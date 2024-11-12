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
    try {
      return executeWithRegionRetry(() -> Bundle.list(parameters, getRequestOptions()).loadNextPage());
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

  public ListIterator<Bundle> listBundle(final ListIterator<Bundle> iterator) {
    try {
      return executeWithRegionRetry(() -> iterator.loadNextPage());
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

  public Bundle findBundle(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> Bundle.find(parameters, getRequestOptions()));
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

  public Bundle createBundle(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> Bundle.create(parameters, getRequestOptions()));
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

  public Bundle updateBundle(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> Bundle.update(parameters, getRequestOptions()));
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

  public void deleteBundle(final HashMap<String, Object> parameters) {
    try {
      executeWithRegionRetry(_null -> Bundle.delete(parameters, getRequestOptions()));
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

  public ListIterator<BundleDownload> listBundleDownload(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> BundleDownload.list(parameters, getRequestOptions()).loadNextPage());
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

  public ListIterator<BundleDownload> listBundleDownload(final ListIterator<BundleDownload> iterator) {
    try {
      return executeWithRegionRetry(() -> iterator.loadNextPage());
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

  public ListIterator<BundleNotification> listBundleNotification(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> BundleNotification.list(parameters, getRequestOptions()).loadNextPage());
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

  public ListIterator<BundleNotification> listBundleNotification(final ListIterator<BundleNotification> iterator) {
    try {
      return executeWithRegionRetry(() -> iterator.loadNextPage());
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

  public BundleNotification findBundleNotification(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> BundleNotification.find(parameters, getRequestOptions()));
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

  public BundleNotification createBundleNotification(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> BundleNotification.create(parameters, getRequestOptions()));
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

  public BundleNotification updateBundleNotification(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> BundleNotification.update(parameters, getRequestOptions()));
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

  public void deleteBundleNotification(final HashMap<String, Object> parameters) {
    try {
      executeWithRegionRetry(_null -> BundleNotification.delete(parameters, getRequestOptions()));
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

  public ListIterator<BundleRecipient> listBundleRecipient(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> BundleRecipient.list(parameters, getRequestOptions()).loadNextPage());
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

  public ListIterator<BundleRecipient> listBundleRecipient(final ListIterator<BundleRecipient> iterator) {
    try {
      return executeWithRegionRetry(() -> iterator.loadNextPage());
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

  public BundleRecipient createBundleRecipient(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> BundleRecipient.create(parameters, getRequestOptions()));
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

  public ListIterator<BundleRegistration> listBundleRegistration(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> BundleRegistration.list(parameters, getRequestOptions()).loadNextPage());
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

  public ListIterator<BundleRegistration> listBundleRegistration(final ListIterator<BundleRegistration> iterator) {
    try {
      return executeWithRegionRetry(() -> iterator.loadNextPage());
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

  public InputStream downloadFile(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> File.download(parameters, getRequestOptions())).getInputStream();
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
    } catch (final IllegalArgumentException | NullPointerException | IOException e) {
      throw new ModuleException(FilesComErrorType.ARGUMENT, e);
    }
  }

  public File createFile(final HashMap<String, Object> parameters, final InputStream content) {
    try {
      return executeWithRegionRetry(() -> File.create(parameters, getRequestOptions())).putInputStream(content, null, 1);
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
    } catch (final IllegalArgumentException | NullPointerException | IOException e) {
      throw new ModuleException(FilesComErrorType.ARGUMENT, e);
    } catch (final InterruptedException e) { // Handle interruption, but it should never get thrown in this context
      Thread.currentThread().interrupt();
      throw new ModuleException("Upload was interrupted", FilesComErrorType.ARGUMENT, e);
    }
  }

  public void deleteFile(final HashMap<String, Object> parameters) {
    try {
      executeWithRegionRetry(_null -> File.delete(parameters, getRequestOptions()));
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

  public File findFile(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> File.find(parameters, getRequestOptions()));
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

  public FileAction copyFile(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> File.copy(parameters, getRequestOptions()));
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

  public FileAction moveFile(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> File.move(parameters, getRequestOptions()));
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

  public ListIterator<File> listForFolder(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> Folder.listFor(parameters, getRequestOptions()).loadNextPage());
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

  public ListIterator<File> listForFolder(final ListIterator<File> iterator) {
    try {
      return executeWithRegionRetry(() -> iterator.loadNextPage());
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

  public Folder createFolder(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> Folder.create(parameters, getRequestOptions()));
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

  public ListIterator<Group> listGroup(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> Group.list(parameters, getRequestOptions()).loadNextPage());
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

  public ListIterator<Group> listGroup(final ListIterator<Group> iterator) {
    try {
      return executeWithRegionRetry(() -> iterator.loadNextPage());
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

  public Group findGroup(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> Group.find(parameters, getRequestOptions()));
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

  public Group createGroup(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> Group.create(parameters, getRequestOptions()));
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

  public Group updateGroup(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> Group.update(parameters, getRequestOptions()));
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

  public void deleteGroup(final HashMap<String, Object> parameters) {
    try {
      executeWithRegionRetry(_null -> Group.delete(parameters, getRequestOptions()));
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

  public ListIterator<User> listUser(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> User.list(parameters, getRequestOptions()).loadNextPage());
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

  public ListIterator<User> listUser(final ListIterator<User> iterator) {
    try {
      return executeWithRegionRetry(() -> iterator.loadNextPage());
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

  public User findUser(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> User.find(parameters, getRequestOptions()));
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

  public User createUser(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> User.create(parameters, getRequestOptions()));
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

  public User updateUser(final HashMap<String, Object> parameters) {
    try {
      return executeWithRegionRetry(() -> User.update(parameters, getRequestOptions()));
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

  public void deleteUser(final HashMap<String, Object> parameters) {
    try {
      executeWithRegionRetry(_null -> User.delete(parameters, getRequestOptions()));
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
