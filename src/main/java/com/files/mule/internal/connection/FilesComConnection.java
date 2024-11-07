package com.files.mule.internal.connection;

import java.io.InputStream;
import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.files.FilesClient;
import com.files.ListIterator;
import com.files.exceptions.ApiErrorException;
import com.files.exceptions.ApiErrorException.*;
import com.files.models.*;
import com.files.mule.internal.config.FilesComConfig;
import com.files.mule.internal.error.exception.*;

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
      try {
        return Bundle.list(parameters, getRequestOptions()).loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return Bundle.list(parameters, getRequestOptions()).loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<Bundle> listBundle(final ListIterator<Bundle> iterator) {
    try {
      try {
        return iterator.loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return iterator.loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public Bundle findBundle(final HashMap<String, Object> parameters) {
    try {
      try {
        return Bundle.find(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return Bundle.find(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public Bundle createBundle(final HashMap<String, Object> parameters) {
    try {
      try {
        return Bundle.create(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return Bundle.create(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public Bundle updateBundle(final HashMap<String, Object> parameters) {
    try {
      try {
        return Bundle.update(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return Bundle.update(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public void deleteBundle(final HashMap<String, Object> parameters) {
    try {
      try {
        Bundle.delete(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        Bundle.delete(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<BundleDownload> listBundleDownload(final HashMap<String, Object> parameters) {
    try {
      try {
        return BundleDownload.list(parameters, getRequestOptions()).loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return BundleDownload.list(parameters, getRequestOptions()).loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<BundleDownload> listBundleDownload(final ListIterator<BundleDownload> iterator) {
    try {
      try {
        return iterator.loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return iterator.loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<BundleNotification> listBundleNotification(final HashMap<String, Object> parameters) {
    try {
      try {
        return BundleNotification.list(parameters, getRequestOptions()).loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return BundleNotification.list(parameters, getRequestOptions()).loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<BundleNotification> listBundleNotification(final ListIterator<BundleNotification> iterator) {
    try {
      try {
        return iterator.loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return iterator.loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public BundleNotification findBundleNotification(final HashMap<String, Object> parameters) {
    try {
      try {
        return BundleNotification.find(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return BundleNotification.find(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public BundleNotification createBundleNotification(final HashMap<String, Object> parameters) {
    try {
      try {
        return BundleNotification.create(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return BundleNotification.create(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public BundleNotification updateBundleNotification(final HashMap<String, Object> parameters) {
    try {
      try {
        return BundleNotification.update(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return BundleNotification.update(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public void deleteBundleNotification(final HashMap<String, Object> parameters) {
    try {
      try {
        BundleNotification.delete(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        BundleNotification.delete(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<BundleRecipient> listBundleRecipient(final HashMap<String, Object> parameters) {
    try {
      try {
        return BundleRecipient.list(parameters, getRequestOptions()).loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return BundleRecipient.list(parameters, getRequestOptions()).loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<BundleRecipient> listBundleRecipient(final ListIterator<BundleRecipient> iterator) {
    try {
      try {
        return iterator.loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return iterator.loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public BundleRecipient createBundleRecipient(final HashMap<String, Object> parameters) {
    try {
      try {
        return BundleRecipient.create(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return BundleRecipient.create(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<BundleRegistration> listBundleRegistration(final HashMap<String, Object> parameters) {
    try {
      try {
        return BundleRegistration.list(parameters, getRequestOptions()).loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return BundleRegistration.list(parameters, getRequestOptions()).loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<BundleRegistration> listBundleRegistration(final ListIterator<BundleRegistration> iterator) {
    try {
      try {
        return iterator.loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return iterator.loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public InputStream downloadFile(final HashMap<String, Object> parameters) {
    try {
      try {
        return File.download(parameters, getRequestOptions()).getInputStream();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return File.download(parameters, getRequestOptions()).getInputStream();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException | IOException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public File createFile(final HashMap<String, Object> parameters, final InputStream content) {
    try {
      try {
        return File.create(parameters, getRequestOptions()).putInputStream(content, null, 1);
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return File.create(parameters, getRequestOptions()).putInputStream(content, null, 1);
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException | IOException | InterruptedException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public void deleteFile(final HashMap<String, Object> parameters) {
    try {
      try {
        File.delete(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        File.delete(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public File findFile(final HashMap<String, Object> parameters) {
    try {
      try {
        return File.find(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return File.find(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public FileAction copyFile(final HashMap<String, Object> parameters) {
    try {
      try {
        return File.copy(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return File.copy(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public FileAction moveFile(final HashMap<String, Object> parameters) {
    try {
      try {
        return File.move(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return File.move(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<File> listForFolder(final HashMap<String, Object> parameters) {
    try {
      try {
        return Folder.listFor(parameters, getRequestOptions()).loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return Folder.listFor(parameters, getRequestOptions()).loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<File> listForFolder(final ListIterator<File> iterator) {
    try {
      try {
        return iterator.loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return iterator.loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public Folder createFolder(final HashMap<String, Object> parameters) {
    try {
      try {
        return Folder.create(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return Folder.create(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<Group> listGroup(final HashMap<String, Object> parameters) {
    try {
      try {
        return Group.list(parameters, getRequestOptions()).loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return Group.list(parameters, getRequestOptions()).loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<Group> listGroup(final ListIterator<Group> iterator) {
    try {
      try {
        return iterator.loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return iterator.loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public Group findGroup(final HashMap<String, Object> parameters) {
    try {
      try {
        return Group.find(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return Group.find(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public Group createGroup(final HashMap<String, Object> parameters) {
    try {
      try {
        return Group.create(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return Group.create(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public Group updateGroup(final HashMap<String, Object> parameters) {
    try {
      try {
        return Group.update(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return Group.update(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public void deleteGroup(final HashMap<String, Object> parameters) {
    try {
      try {
        Group.delete(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        Group.delete(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<User> listUser(final HashMap<String, Object> parameters) {
    try {
      try {
        return User.list(parameters, getRequestOptions()).loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return User.list(parameters, getRequestOptions()).loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public ListIterator<User> listUser(final ListIterator<User> iterator) {
    try {
      try {
        return iterator.loadNextPage();
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return iterator.loadNextPage();
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public User findUser(final HashMap<String, Object> parameters) {
    try {
      try {
        return User.find(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return User.find(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public User createUser(final HashMap<String, Object> parameters) {
    try {
      try {
        return User.create(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return User.create(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public User updateUser(final HashMap<String, Object> parameters) {
    try {
      try {
        return User.update(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        return User.update(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

  public void deleteUser(final HashMap<String, Object> parameters) {
    try {
      try {
        User.delete(parameters, getRequestOptions());
      } catch (final LockoutRegionMismatchException e) {
        setApiRoot(e.getData().get("host").toString());
        User.delete(parameters, getRequestOptions());
      }
    } catch (final ApiErrorException e) {
      throw new FilesComApiException(e);
    } catch (final AuthenticationException e) {
      throw new FilesComAuthenticationException(e);
    } catch (final ApiConnectionException e) {
      throw new FilesComConnectionException(e);
    } catch (final InvalidResponseException e) {
      throw new FilesComResponseException(e);
    } catch (final ServerErrorException e) {
      throw new FilesComServerException(e);
    } catch (final IllegalArgumentException | NullPointerException e) {
      throw new FilesComArgumentException(e);
    }
  }

}
