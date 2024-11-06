package com.files.mule.internal.connection;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.files.FilesClient;
import com.files.ListIterator;
import com.files.exceptions.ApiErrorException.LockoutRegionMismatchException;
import com.files.models.*;
import com.files.mule.internal.config.FilesComConfig;

public class FilesComConnection {

  private static final Logger LOGGER = LoggerFactory.getLogger(FilesComConnection.class);

  private final String apiKey;
  private String apiRoot;

  public FilesComConnection(final String apiKey, final String apiRoot) {
    this.apiKey = apiKey;
    setApiRoot(apiRoot);

    FilesClient.setProperty("userAgent", FilesComConfig.getInstance().getUserAgent());
  }

  private HashMap<String, Object> getRequestOptions() {
    final HashMap<String, Object> requestOptions = new HashMap<>();
    requestOptions.put("api_key", apiKey);
    return requestOptions;
  }

  public String getApiRoot() {
    return apiRoot;
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
      return Bundle.list(parameters, getRequestOptions()).loadNextPage();
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return Bundle.list(parameters, getRequestOptions()).loadNextPage();
    }
  }

  public Bundle findBundle(final HashMap<String, Object> parameters) {
    try {
      return Bundle.find(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return Bundle.find(parameters, getRequestOptions());
    }
  }

  public Bundle createBundle(final HashMap<String, Object> parameters) {
    try {
      return Bundle.create(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return Bundle.create(parameters, getRequestOptions());
    }
  }

  public Bundle updateBundle(final HashMap<String, Object> parameters) {
    try {
      return Bundle.update(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return Bundle.update(parameters, getRequestOptions());
    }
  }

  public void deleteBundle(final HashMap<String, Object> parameters) {
    try {
      Bundle.delete(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      Bundle.delete(parameters, getRequestOptions());
    }
  }

  public ListIterator<BundleDownload> listBundleDownload(final HashMap<String, Object> parameters) {
    try {
      return BundleDownload.list(parameters, getRequestOptions()).loadNextPage();
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return BundleDownload.list(parameters, getRequestOptions()).loadNextPage();
    }
  }

  public ListIterator<BundleNotification> listBundleNotification(final HashMap<String, Object> parameters) {
    try {
      return BundleNotification.list(parameters, getRequestOptions()).loadNextPage();
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return BundleNotification.list(parameters, getRequestOptions()).loadNextPage();
    }
  }

  public BundleNotification findBundleNotification(final HashMap<String, Object> parameters) {
    try {
      return BundleNotification.find(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return BundleNotification.find(parameters, getRequestOptions());
    }
  }

  public BundleNotification createBundleNotification(final HashMap<String, Object> parameters) {
    try {
      return BundleNotification.create(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return BundleNotification.create(parameters, getRequestOptions());
    }
  }

  public BundleNotification updateBundleNotification(final HashMap<String, Object> parameters) {
    try {
      return BundleNotification.update(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return BundleNotification.update(parameters, getRequestOptions());
    }
  }

  public void deleteBundleNotification(final HashMap<String, Object> parameters) {
    try {
      BundleNotification.delete(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      BundleNotification.delete(parameters, getRequestOptions());
    }
  }

  public ListIterator<BundleRecipient> listBundleRecipient(final HashMap<String, Object> parameters) {
    try {
      return BundleRecipient.list(parameters, getRequestOptions()).loadNextPage();
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return BundleRecipient.list(parameters, getRequestOptions()).loadNextPage();
    }
  }

  public BundleRecipient createBundleRecipient(final HashMap<String, Object> parameters) {
    try {
      return BundleRecipient.create(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return BundleRecipient.create(parameters, getRequestOptions());
    }
  }

  public ListIterator<BundleRegistration> listBundleRegistration(final HashMap<String, Object> parameters) {
    try {
      return BundleRegistration.list(parameters, getRequestOptions()).loadNextPage();
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return BundleRegistration.list(parameters, getRequestOptions()).loadNextPage();
    }
  }

  public File downloadFile(final HashMap<String, Object> parameters) {
    try {
      return File.download(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return File.download(parameters, getRequestOptions());
    }
  }

  public FileUploadPart createFile(final HashMap<String, Object> parameters) {
    try {
      return File.create(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return File.create(parameters, getRequestOptions());
    }
  }

  public void deleteFile(final HashMap<String, Object> parameters) {
    try {
      File.delete(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      File.delete(parameters, getRequestOptions());
    }
  }

  public File findFile(final HashMap<String, Object> parameters) {
    try {
      return File.find(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return File.find(parameters, getRequestOptions());
    }
  }

  public FileAction copyFile(final HashMap<String, Object> parameters) {
    try {
      return File.copy(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return File.copy(parameters, getRequestOptions());
    }
  }

  public FileAction moveFile(final HashMap<String, Object> parameters) {
    try {
      return File.move(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return File.move(parameters, getRequestOptions());
    }
  }

  public ListIterator<File> listForFolder(final HashMap<String, Object> parameters) {
    try {
      return Folder.listFor(parameters, getRequestOptions()).loadNextPage();
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return Folder.listFor(parameters, getRequestOptions()).loadNextPage();
    }
  }

  public Folder createFolder(final HashMap<String, Object> parameters) {
    try {
      return Folder.create(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return Folder.create(parameters, getRequestOptions());
    }
  }

  public ListIterator<Group> listGroup(final HashMap<String, Object> parameters) {
    try {
      return Group.list(parameters, getRequestOptions()).loadNextPage();
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return Group.list(parameters, getRequestOptions()).loadNextPage();
    }
  }

  public Group findGroup(final HashMap<String, Object> parameters) {
    try {
      return Group.find(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return Group.find(parameters, getRequestOptions());
    }
  }

  public Group createGroup(final HashMap<String, Object> parameters) {
    try {
      return Group.create(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return Group.create(parameters, getRequestOptions());
    }
  }

  public Group updateGroup(final HashMap<String, Object> parameters) {
    try {
      return Group.update(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return Group.update(parameters, getRequestOptions());
    }
  }

  public void deleteGroup(final HashMap<String, Object> parameters) {
    try {
      Group.delete(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      Group.delete(parameters, getRequestOptions());
    }
  }

  public ListIterator<User> listUser(final HashMap<String, Object> parameters) {
    try {
      return User.list(parameters, getRequestOptions()).loadNextPage();
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return User.list(parameters, getRequestOptions()).loadNextPage();
    }
  }

  public User findUser(final HashMap<String, Object> parameters) {
    try {
      return User.find(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return User.find(parameters, getRequestOptions());
    }
  }

  public User createUser(final HashMap<String, Object> parameters) {
    try {
      return User.create(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return User.create(parameters, getRequestOptions());
    }
  }

  public User updateUser(final HashMap<String, Object> parameters) {
    try {
      return User.update(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      return User.update(parameters, getRequestOptions());
    }
  }

  public void deleteUser(final HashMap<String, Object> parameters) {
    try {
      User.delete(parameters, getRequestOptions());
    } catch (final LockoutRegionMismatchException e) {
      setApiRoot(e.getData().get("host").toString());
      User.delete(parameters, getRequestOptions());
    }
  }
}
