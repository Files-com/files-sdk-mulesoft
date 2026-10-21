/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.mule.runtime.api.message.Error;

public class FilesComOperationsTestCase extends MuleArtifactFunctionalTestCase {

  // The logical path FileDownloadFlow downloads from the fixture.
  private static final String DOWNLOAD_PATH = "file-path";

  private static final String UPSTREAM_INSECURE_ALLOWED = "upstreamInsecureAllowed";

  // The existing static configuration, in test-mule-config.xml, of the connector under test: its value's classloader is
  // the one through which the connector loads the Java SDK.
  private static final String CONNECTOR_CONFIG = "FilesCom";

  // The Java SDK's process-wide configuration class, named only as a string: the test's own classloader cannot see it.
  private static final String SDK_CONFIG_CLASS = "com.files.FilesConfig";

  // The most seconds FileDownloadFlow may take, as Boomi's download test allows its download.
  private static final long DOWNLOAD_TIMEOUT_SECONDS = 60;

  // The most seconds the flow's worker may take to finish once it has been stopped and the fixture closed.
  private static final long WORKER_SETTLE_SECONDS = 10;

  @Override
  protected String getConfigFile() {
    return "test-mule-config.xml";
  }

  @Test
  public void testFlows() throws Exception {
    final String[] flowNames = new String[]{"ShareLinkFlow", "FileFlow", "FolderFlow", "GroupFlow", "UserFlow"};
    for (final String flowName : flowNames) {
      try {
        final Optional<Error> error = flowRunner(flowName).run().getError();
        assertThat(error.isPresent(), is(false));
      } catch (final Exception e) {
        throw new Exception("Test failed for flow: " + flowName, e);
      }
    }
  }

  // FileDownloadFlow's real download-file step, against a test-owned fixture on 127.0.0.1 (DownloadFixture), not the
  // Mock: the flow reads the downloaded stream into a String before it ends, and that must be the fixture's whole
  // content, served by its storage after a request for the file's FileEntity. The fixture's storage URI is http, which
  // the SDK's public upstreamInsecureAllowed allows. It is set, on the SDK configuration the connector itself loads
  // (ConnectorSdkConfiguration), only around this download, and set back to the effective value it had before, however
  // the test ends.
  //
  // The flow runs on a worker of the test's own, which the test waits for up to DOWNLOAD_TIMEOUT_SECONDS: a flow that
  // has not finished by then is cancelled and fails the test. The test itself, not the worker, then cleans up, in its
  // own finally, whatever happened (see the comment there).
  @Test
  public void testFileDownloadFlow() throws Exception {
    final ConnectorSdkConfiguration sdkConfiguration = ConnectorSdkConfiguration.of(
        muleContext.getExtensionManager().getConfiguration(CONNECTOR_CONFIG, testEvent()).getValue());
    final boolean priorUpstreamInsecureAllowed = sdkConfiguration.upstreamInsecureAllowed();
    final ExecutorService worker = Executors.newSingleThreadExecutor(runnable -> {
      final Thread thread = new Thread(runnable, "file-download-flow");
      thread.setDaemon(true);
      return thread;
    });
    final DownloadFixture fixture = DownloadFixture.start(DOWNLOAD_PATH, DownloadFixture.CONTENT);
    Throwable failure = null;

    try {
      sdkConfiguration.setUpstreamInsecureAllowed(true);

      final Callable<Object> runFlow = () -> flowRunner("FileDownloadFlow")
          .withVariable("downloadBaseUrl", fixture.baseUrl())
          .withVariable("downloadPath", DOWNLOAD_PATH)
          .run()
          .getMessage()
          .getPayload()
          .getValue();
      final Future<Object> download = worker.submit(runFlow);
      final Object downloaded;

      try {
        downloaded = download.get(DOWNLOAD_TIMEOUT_SECONDS, TimeUnit.SECONDS);
      } catch (TimeoutException timedOut) {
        download.cancel(true);
        throw new AssertionError("FileDownloadFlow did not finish within " + DOWNLOAD_TIMEOUT_SECONDS
            + " s; the fixture received " + fixture.requests(), timedOut);
      } catch (InterruptedException interrupted) {
        download.cancel(true);
        Thread.currentThread().interrupt();
        throw interrupted;
      } catch (ExecutionException failed) {
        // The flow's own failure, as it was thrown.
        final Throwable cause = failed.getCause();

        if (cause instanceof Exception) {
          throw (Exception) cause;
        }

        if (cause instanceof java.lang.Error) {
          throw (java.lang.Error) cause;
        }

        throw failed;
      }

      assertThat(downloaded, is((Object) new String(DownloadFixture.CONTENT, StandardCharsets.UTF_8)));

      // Only once the whole payload has been checked: closing the fixture joins its handlers, which may still be
      // recording the storage response the flow has already read, so that what it served is complete.
      fixture.close();
      fixture.assertDownloadServed();
    } catch (Throwable error) {
      failure = error;
      throw error;
    } finally {
      // Every cleanup is attempted, whatever the others do: the worker is stopped, cancelling a flow still running;
      // the fixture is closed, if it is not already, which ends any request the download still has open; the worker is given up to
      // WORKER_SETTLE_SECONDS to finish; and the setting is restored. None makes the test pass: a failure among them
      // follows the test's own failure, if any, as a suppressed one, and is otherwise thrown, with any later ones
      // suppressed.
      final List<RuntimeException> cleanup = new ArrayList<RuntimeException>();
      worker.shutdownNow();

      try {
        fixture.close();
      } catch (RuntimeException closeFailure) {
        cleanup.add(closeFailure);
      }

      try {
        if (!worker.awaitTermination(WORKER_SETTLE_SECONDS, TimeUnit.SECONDS)) {
          cleanup.add(new IllegalStateException("FileDownloadFlow's worker was still running " + WORKER_SETTLE_SECONDS
              + " s after it was stopped and the fixture closed"));
        }
      } catch (InterruptedException interrupted) {
        Thread.currentThread().interrupt();
        cleanup.add(new IllegalStateException("interrupted while FileDownloadFlow's worker settled", interrupted));
      }

      try {
        sdkConfiguration.setUpstreamInsecureAllowed(priorUpstreamInsecureAllowed);
      } catch (RuntimeException restoreFailure) {
        cleanup.add(restoreFailure);
      }

      reportCleanup(failure, cleanup);
    }
  }

  // Adds the cleanup failures to the test's own failure, first, as suppressed ones; or, when the test did not fail,
  // throws the first of them, with the rest suppressed.
  private static void reportCleanup(Throwable first, List<RuntimeException> cleanup) {
    if (cleanup.isEmpty()) {
      return;
    }

    if (first != null) {
      for (final RuntimeException failure : cleanup) {
        first.addSuppressed(failure);
      }

      return;
    }

    final RuntimeException thrown = cleanup.get(0);

    for (final RuntimeException failure : cleanup.subList(1, cleanup.size())) {
      thrown.addSuppressed(failure);
    }

    throw thrown;
  }

  // The Java SDK's process-wide configuration as the connector itself loads it: com.files.FilesConfig, resolved by the
  // classloader that defined the value of the connector's own static FilesCom configuration, and used through its
  // public getInstance(), getUpstreamInsecureAllowed() and setProperty(String, String) only. The test's classloader
  // cannot see the SDK, which the connector's plugin brings, so nothing here names an SDK class, and nothing else is
  // searched: a missing part of that public contract fails at once, saying what is missing.
  private static final class ConnectorSdkConfiguration {
    private final Object instance;
    private final Method getUpstreamInsecureAllowed;
    private final Method setProperty;

    private ConnectorSdkConfiguration(Object instance, Method getUpstreamInsecureAllowed, Method setProperty) {
      this.instance = instance;
      this.getUpstreamInsecureAllowed = getUpstreamInsecureAllowed;
      this.setProperty = setProperty;
    }

    // The SDK configuration of the connector whose configuration value is connectorConfiguration.
    static ConnectorSdkConfiguration of(Object connectorConfiguration) {
      if (connectorConfiguration == null) {
        throw new IllegalStateException("the " + CONNECTOR_CONFIG + " configuration has no value to find the connector's SDK by");
      }

      final Class<?> connectorClass = connectorConfiguration.getClass();
      final ClassLoader loader = connectorClass.getClassLoader();

      if (loader == null) {
        throw new IllegalStateException("the " + CONNECTOR_CONFIG + " configuration's value, a " + connectorClass.getName()
            + ", has no classloader of its own to find the connector's SDK by");
      }

      final Class<?> sdkConfigClass;

      try {
        sdkConfigClass = loader.loadClass(SDK_CONFIG_CLASS);
      } catch (ClassNotFoundException missing) {
        throw new IllegalStateException("the classloader of the " + CONNECTOR_CONFIG + " configuration's value, a "
            + connectorClass.getName() + ", cannot load " + SDK_CONFIG_CLASS, missing);
      }

      final Method getInstance = publicMethod(sdkConfigClass, "getInstance");
      final Method getter = publicMethod(sdkConfigClass, "getUpstreamInsecureAllowed");
      final Method setter = publicMethod(sdkConfigClass, "setProperty", String.class, String.class);

      if (!Modifier.isStatic(getInstance.getModifiers()) || getInstance.getReturnType() != sdkConfigClass
          || Modifier.isStatic(getter.getModifiers()) || getter.getReturnType() != boolean.class
          || Modifier.isStatic(setter.getModifiers()) || setter.getReturnType() != void.class) {
        throw new IllegalStateException(SDK_CONFIG_CLASS + "'s public getInstance(), getUpstreamInsecureAllowed() and "
            + "setProperty(String, String) are not the static FilesConfig getInstance(), boolean getter and void setter "
            + "this test uses");
      }

      final Object instance = invoke(getInstance, null);

      if (!sdkConfigClass.isInstance(instance)) {
        throw new IllegalStateException(SDK_CONFIG_CLASS + ".getInstance() gave no " + SDK_CONFIG_CLASS);
      }

      return new ConnectorSdkConfiguration(instance, getter, setter);
    }

    // The effective upstreamInsecureAllowed, as the SDK's getter gives it.
    boolean upstreamInsecureAllowed() {
      return (Boolean) invoke(getUpstreamInsecureAllowed, instance);
    }

    // Sets upstreamInsecureAllowed to allowed, through the SDK's public setProperty.
    void setUpstreamInsecureAllowed(boolean allowed) {
      invoke(setProperty, instance, UPSTREAM_INSECURE_ALLOWED, Boolean.toString(allowed));
    }

    private static Method publicMethod(Class<?> owner, String name, Class<?>... parameters) {
      try {
        return owner.getMethod(name, parameters);
      } catch (NoSuchMethodException missing) {
        final StringBuilder signature = new StringBuilder(name).append('(');

        for (int index = 0; index < parameters.length; index += 1) {
          signature.append(index == 0 ? "" : ", ").append(parameters[index].getSimpleName());
        }

        throw new IllegalStateException(owner.getName() + " has no public " + signature.append(')')
            + ", which this test needs", missing);
      }
    }

    private static Object invoke(Method method, Object target, Object... arguments) {
      final String name = method.getDeclaringClass().getName() + "." + method.getName();

      try {
        return method.invoke(target, arguments);
      } catch (InvocationTargetException failed) {
        throw new IllegalStateException(name + " failed", failed.getCause());
      } catch (IllegalAccessException refused) {
        throw new IllegalStateException(name + " could not be called as a public method", refused);
      }
    }
  }
}
