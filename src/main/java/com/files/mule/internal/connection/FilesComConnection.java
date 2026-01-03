/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.connection;

import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.mule.runtime.extension.api.exception.ModuleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.files.FilesClient;
import com.files.ListIterator;
import com.files.exceptions.ApiErrorException;
import com.files.exceptions.ApiErrorException.ApiConnectionException;
import com.files.exceptions.ApiErrorException.AuthenticationException;
import com.files.exceptions.ApiErrorException.InvalidResponseException;
import com.files.exceptions.ApiErrorException.LockoutRegionMismatchException;
import com.files.exceptions.ApiErrorException.ServerErrorException;
import com.files.models.Bundle;
import com.files.models.BundleDownload;
import com.files.models.BundleNotification;
import com.files.models.BundleRecipient;
import com.files.models.BundleRegistration;
import com.files.models.File;
import com.files.models.FileAction;
import com.files.models.Folder;
import com.files.models.Group;
import com.files.models.User;
import com.files.mule.internal.config.FilesComConfig;
import com.files.mule.internal.error.FilesComErrorType;

public class FilesComConnection {
  private static final Logger LOGGER = LoggerFactory.getLogger(FilesComConnection.class);

  private final FilesComConfig config = new FilesComConfig();
  private final String apiKey;
  private String apiRoot;

  public FilesComConnection(final String apiKey, final String apiRoot) {
    this.apiKey = apiKey;
    setApiRoot(apiRoot);

    FilesClient.setProperty("userAgent", config.getUserAgent());
  }

  private HashMap<String, Object> getRequestOptions() {
    final HashMap<String, Object> requestOptions = new HashMap<>();
    requestOptions.put("api_key", apiKey);
    return requestOptions;
  }

  public void setApiRoot(final String apiRoot) {
    if (apiRoot != null && !apiRoot.isEmpty()) {
      this.apiRoot = (apiRoot.startsWith("https://") || apiRoot.startsWith("http://") ? "" : "https://") + apiRoot;
      LOGGER.debug("Setting apiRoot to {}", this.apiRoot);
      FilesClient.setProperty("apiRoot", this.apiRoot);
    }
  }

  public ListIterator<Bundle> listBundle(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> Bundle.list(parameters, getRequestOptions()).loadNextPage());
  }

  public ListIterator<Bundle> listBundle(final ListIterator<Bundle> iterator) {
    return executeWithRegionRetry(() -> iterator.loadNextPage());
  }

  public Bundle findBundle(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> Bundle.find(parameters, getRequestOptions()));
  }

  public Bundle createBundle(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> Bundle.create(parameters, getRequestOptions()));
  }

  public Bundle updateBundle(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> Bundle.update(parameters, getRequestOptions()));
  }

  public void deleteBundle(final HashMap<String, Object> parameters) {
    executeWithRegionRetry(_null -> Bundle.delete(parameters, getRequestOptions()));
  }

  public ListIterator<BundleDownload> listBundleDownload(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> BundleDownload.list(parameters, getRequestOptions()).loadNextPage());
  }

  public ListIterator<BundleDownload> listBundleDownload(final ListIterator<BundleDownload> iterator) {
    return executeWithRegionRetry(() -> iterator.loadNextPage());
  }

  public ListIterator<BundleNotification> listBundleNotification(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> BundleNotification.list(parameters, getRequestOptions()).loadNextPage());
  }

  public ListIterator<BundleNotification> listBundleNotification(final ListIterator<BundleNotification> iterator) {
    return executeWithRegionRetry(() -> iterator.loadNextPage());
  }

  public BundleNotification findBundleNotification(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> BundleNotification.find(parameters, getRequestOptions()));
  }

  public BundleNotification createBundleNotification(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> BundleNotification.create(parameters, getRequestOptions()));
  }

  public BundleNotification updateBundleNotification(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> BundleNotification.update(parameters, getRequestOptions()));
  }

  public void deleteBundleNotification(final HashMap<String, Object> parameters) {
    executeWithRegionRetry(_null -> BundleNotification.delete(parameters, getRequestOptions()));
  }

  public ListIterator<BundleRecipient> listBundleRecipient(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> BundleRecipient.list(parameters, getRequestOptions()).loadNextPage());
  }

  public ListIterator<BundleRecipient> listBundleRecipient(final ListIterator<BundleRecipient> iterator) {
    return executeWithRegionRetry(() -> iterator.loadNextPage());
  }

  public BundleRecipient createBundleRecipient(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> BundleRecipient.create(parameters, getRequestOptions()));
  }

  public ListIterator<BundleRegistration> listBundleRegistration(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> BundleRegistration.list(parameters, getRequestOptions()).loadNextPage());
  }

  public ListIterator<BundleRegistration> listBundleRegistration(final ListIterator<BundleRegistration> iterator) {
    return executeWithRegionRetry(() -> iterator.loadNextPage());
  }

  public InputStream downloadFile(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> File.download(parameters, getRequestOptions())).getInputStream();
    } catch (final IOException e) {
      throw new ModuleException(FilesComErrorType.ARGUMENT, e);
    }
  }

  public File createFile(final HashMap<String, Object> parameters, final InputStream content) {
    try {
      return executeWithRegionRetry(() -> File.create(parameters, getRequestOptions())).putInputStream(content, null, 1);
    } catch (final IOException e) {
      throw new ModuleException(FilesComErrorType.ARGUMENT, e);
    } catch (final InterruptedException e) { // Handle interruption, but it should never get thrown in this context
      Thread.currentThread().interrupt();
      throw new ModuleException("Upload was interrupted", FilesComErrorType.ARGUMENT, e);
    }

  }

  public void deleteFile(final HashMap<String, Object> parameters) {
    executeWithRegionRetry(_null -> File.delete(parameters, getRequestOptions()));
  }

  public File findFile(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> File.find(parameters, getRequestOptions()));
  }

  public FileAction copyFile(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> File.copy(parameters, getRequestOptions()));
  }

  public FileAction moveFile(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> File.move(parameters, getRequestOptions()));
  }

  public ListIterator<File> listForFolder(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> Folder.listFor(parameters, getRequestOptions()).loadNextPage());
  }

  public ListIterator<File> listForFolder(final ListIterator<File> iterator) {
    return executeWithRegionRetry(() -> iterator.loadNextPage());
  }

  public Folder createFolder(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> Folder.create(parameters, getRequestOptions()));
  }

  public ListIterator<Group> listGroup(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> Group.list(parameters, getRequestOptions()).loadNextPage());
  }

  public ListIterator<Group> listGroup(final ListIterator<Group> iterator) {
    return executeWithRegionRetry(() -> iterator.loadNextPage());
  }

  public Group findGroup(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> Group.find(parameters, getRequestOptions()));
  }

  public Group createGroup(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> Group.create(parameters, getRequestOptions()));
  }

  public Group updateGroup(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> Group.update(parameters, getRequestOptions()));
  }

  public void deleteGroup(final HashMap<String, Object> parameters) {
    executeWithRegionRetry(_null -> Group.delete(parameters, getRequestOptions()));
  }

  public ListIterator<User> listUser(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> User.list(parameters, getRequestOptions()).loadNextPage());
  }

  public ListIterator<User> listUser(final ListIterator<User> iterator) {
    return executeWithRegionRetry(() -> iterator.loadNextPage());
  }

  public User findUser(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> User.find(parameters, getRequestOptions()));
  }

  public User createUser(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> User.create(parameters, getRequestOptions()));
  }

  public User updateUser(final HashMap<String, Object> parameters) {
    return executeWithRegionRetry(() -> User.update(parameters, getRequestOptions()));
  }

  public void deleteUser(final HashMap<String, Object> parameters) {
    executeWithRegionRetry(_null -> User.delete(parameters, getRequestOptions()));
  }


  private void executeWithRegionRetry(final Consumer<Void> task) {
    executeWithRegionRetry(() -> {
      task.accept(null);
      return null;
    });
  }

  private <T> T executeWithRegionRetry(final Supplier<T> task) {
    try {
      return task.get();
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return task.get();
    } catch (final ApiErrorException e) {
      throw new ModuleException(getErrorType(e), e);
    } catch (final AuthenticationException e) {
      throw new ModuleException(FilesComErrorType.NOT_AUTHENTICATED, e);
    } catch (final ApiConnectionException e) {
      throw new ModuleException(FilesComErrorType.CONNECTIVITY, e);
    } catch (final InvalidResponseException e) {
      throw new ModuleException(FilesComErrorType.RESPONSE, e);
    } catch (final ServerErrorException e) {
      throw new ModuleException(FilesComErrorType.SERVICE_UNAVAILABLE, e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new ModuleException(FilesComErrorType.ARGUMENT, e);
    }
  }

  private FilesComErrorType getErrorType(final ApiErrorException e) {
    return Arrays.stream(FilesComErrorType.values())
        .filter(error -> error.apiErrorGroup != null)
        .filter(error -> e.getType().startsWith(error.apiErrorGroup))
        .findFirst()
        .orElse(FilesComErrorType.OTHER);
  }
}
