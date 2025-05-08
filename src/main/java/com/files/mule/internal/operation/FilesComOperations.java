/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.operation;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.mule.runtime.api.exception.MuleException;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.runtime.streaming.PagingProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.files.ListIterator;
import com.files.models.Bundle;
import com.files.models.BundleDownload;
import com.files.models.BundleNotification;
import com.files.models.BundleRecipient;
import com.files.models.BundleRegistration;
import com.files.models.File;
import com.files.models.Group;
import com.files.models.User;
import com.files.mule.api.models.FileActionModel;
import com.files.mule.api.models.FileModel;
import com.files.mule.api.models.FolderModel;
import com.files.mule.api.models.GroupModel;
import com.files.mule.api.models.ShareLinkDownloadModel;
import com.files.mule.api.models.ShareLinkModel;
import com.files.mule.api.models.ShareLinkNotificationModel;
import com.files.mule.api.models.ShareLinkRecipientModel;
import com.files.mule.api.models.ShareLinkRegistrationModel;
import com.files.mule.api.models.UserModel;
import com.files.mule.internal.connection.FilesComConnection;
import com.files.mule.internal.error.provider.FilesComErrorsProvider;
import com.files.mule.internal.operation.parameter.ShareLinkParameterGroup;
import com.files.mule.internal.operation.parameter.ShareLinkDownloadParameterGroup;
import com.files.mule.internal.operation.parameter.ShareLinkNotificationParameterGroup;
import com.files.mule.internal.operation.parameter.ShareLinkRecipientParameterGroup;
import com.files.mule.internal.operation.parameter.ShareLinkRegistrationParameterGroup;
import com.files.mule.internal.operation.parameter.FileParameterGroup;
import com.files.mule.internal.operation.parameter.FolderParameterGroup;
import com.files.mule.internal.operation.parameter.GroupParameterGroup;
import com.files.mule.internal.operation.parameter.UserParameterGroup;

public class FilesComOperations {

  private static final Logger LOGGER = LoggerFactory.getLogger(FilesComOperations.class);
  private static final String ADMIN_IDS = "admin_ids";
  private static final String AUTHENTICATION_METHOD = "authentication_method";
  private static final String BUNDLE_ID = "bundle_id";
  private static final String COMPANY = "company";
  private static final String DAV_PERMISSION = "dav_permission";
  private static final String DESCRIPTION = "description";
  private static final String DESTINATION = "destination";
  private static final String EMAIL = "email";
  private static final String EXPIRES_AT = "expires_at";
  private static final String FTP_PERMISSION = "ftp_permission";
  private static final String GROUP_IDS = "group_ids";
  private static final String ID = "id";
  private static final String MAX_USES = "max_uses";
  private static final String MKDIR_PARENTS = "mkdir_parents";
  private static final String NAME = "name";
  private static final String NOTE = "note";
  private static final String NOTES = "notes";
  private static final String NOTIFY_ON_REGISTRATION = "notify_on_registration";
  private static final String NOTIFY_ON_UPLOAD = "notify_on_upload";
  private static final String NOTIFY_USER_ID = "notify_user_id";
  private static final String PASSWORD = "password";
  private static final String PATH = "path";
  private static final String PATHS = "paths";
  private static final String PERMISSIONS = "permissions";
  private static final String RECIPIENT = "recipient";
  private static final String REQUIRE_PASSWORD_CHANGE = "require_password_change";
  private static final String REQUIRE_REGISTRATION = "require_registration";
  private static final String RESTAPI_PERMISSION = "restapi_permission";
  private static final String SFTP_PERMISSION = "sftp_permission";
  private static final String SHARE_AFTER_CREATE = "share_after_create";
  private static final String USER_HOME = "user_home";
  private static final String USER_IDS = "user_ids";
  private static final String USER_ROOT = "user_root";
  private static final String USERNAME = "username";

  /**
   * List Share Links
   */
  @DisplayName("Share Link - List")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, ShareLinkModel> listShareLinks() {
    return new PagingProvider<FilesComConnection, ShareLinkModel>() {

      private ListIterator<Bundle> iterator;

      @Override
      public List<ShareLinkModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();

          LOGGER.debug("Loading first page of ShareLinks...");
          iterator = connection.listBundle(requestParameters);
        } else {
          if (iterator.hasNextPage()) {
            LOGGER.debug("Loading next page of ShareLinks...");
            iterator = connection.listBundle(iterator);
          } else {
            LOGGER.debug("No more pages of ShareLinks to load");
            return new ArrayList<>();
          }
        }

        return iterator.data.stream().map(ShareLinkModel::new).collect(Collectors.toList());
      }

      @Override
      public java.util.Optional<Integer> getTotalResults(final FilesComConnection connection) {
        return java.util.Optional.empty(); // not supported
      }

      @Override
      public void close(final FilesComConnection connection) throws MuleException {
        // no-op
      }
    };
  }

  /**
   * Show Share Link
   */
  @DisplayName("Share Link - Show")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public ShareLinkModel showShareLink(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") ShareLinkParameterGroup.Show parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    return new ShareLinkModel(connection.findBundle(requestParameters));
  }

  /**
   * Create Share Link
   */
  @DisplayName("Share Link - Create")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public ShareLinkModel createShareLink(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") ShareLinkParameterGroup.Create parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.paths != null) {
      requestParameters.put(PATHS, parameters.getPaths().toArray(new String[0]));
    }

    if (parameters.password != null) {
      requestParameters.put(PASSWORD, parameters.getPassword());
    }

    if (parameters.expiresAt != null) {
      requestParameters.put(EXPIRES_AT, parameters.getExpiresAt());
    }

    if (parameters.maxUses != null) {
      requestParameters.put(MAX_USES, parameters.getMaxUses());
    }

    if (parameters.description != null) {
      requestParameters.put(DESCRIPTION, parameters.getDescription());
    }

    if (parameters.note != null) {
      requestParameters.put(NOTE, parameters.getNote());
    }

    requestParameters.put(REQUIRE_REGISTRATION, parameters.getRequireRegistration());
    requestParameters.put(PERMISSIONS, "read");
    return new ShareLinkModel(connection.createBundle(requestParameters));
  }

  /**
   * Update Share Link
   */
  @DisplayName("Share Link - Update")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public ShareLinkModel updateShareLink(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") ShareLinkParameterGroup.Update parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    if (parameters.expiresAt != null) {
      requestParameters.put(EXPIRES_AT, parameters.getExpiresAt());
    }

    return new ShareLinkModel(connection.updateBundle(requestParameters));
  }

  /**
   * Delete Share Link
   */
  @DisplayName("Share Link - Delete")
  @Throws(FilesComErrorsProvider.class)
  public void deleteShareLink(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") ShareLinkParameterGroup.Delete parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    connection.deleteBundle(requestParameters);
  }

  /**
   * List Share Link Downloads
   */
  @DisplayName("Share Link - List Downloads")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, ShareLinkDownloadModel> listShareLinkDownloads(final @ParameterGroup(name = "Parameters") ShareLinkDownloadParameterGroup.List parameters) {
    return new PagingProvider<FilesComConnection, ShareLinkDownloadModel>() {

      private ListIterator<BundleDownload> iterator;

      @Override
      public List<ShareLinkDownloadModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();
          if (parameters.bundleId != null) {
            requestParameters.put(BUNDLE_ID, parameters.getBundleId());
          }

          LOGGER.debug("Loading first page of ShareLinkDownloads...");
          iterator = connection.listBundleDownload(requestParameters);
        } else {
          if (iterator.hasNextPage()) {
            LOGGER.debug("Loading next page of ShareLinkDownloads...");
            iterator = connection.listBundleDownload(iterator);
          } else {
            LOGGER.debug("No more pages of ShareLinkDownloads to load");
            return new ArrayList<>();
          }
        }

        return iterator.data.stream().map(ShareLinkDownloadModel::new).collect(Collectors.toList());
      }

      @Override
      public java.util.Optional<Integer> getTotalResults(final FilesComConnection connection) {
        return java.util.Optional.empty(); // not supported
      }

      @Override
      public void close(final FilesComConnection connection) throws MuleException {
        // no-op
      }
    };
  }

  /**
   * List Share Link Notifications
   */
  @DisplayName("Share Link - List Notifications")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, ShareLinkNotificationModel> listShareLinkNotifications() {
    return new PagingProvider<FilesComConnection, ShareLinkNotificationModel>() {

      private ListIterator<BundleNotification> iterator;

      @Override
      public List<ShareLinkNotificationModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();

          LOGGER.debug("Loading first page of ShareLinkNotifications...");
          iterator = connection.listBundleNotification(requestParameters);
        } else {
          if (iterator.hasNextPage()) {
            LOGGER.debug("Loading next page of ShareLinkNotifications...");
            iterator = connection.listBundleNotification(iterator);
          } else {
            LOGGER.debug("No more pages of ShareLinkNotifications to load");
            return new ArrayList<>();
          }
        }

        return iterator.data.stream().map(ShareLinkNotificationModel::new).collect(Collectors.toList());
      }

      @Override
      public java.util.Optional<Integer> getTotalResults(final FilesComConnection connection) {
        return java.util.Optional.empty(); // not supported
      }

      @Override
      public void close(final FilesComConnection connection) throws MuleException {
        // no-op
      }
    };
  }

  /**
   * Show Share Link Notification
   */
  @DisplayName("Share Link - Show Notification")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public ShareLinkNotificationModel showShareLinkNotification(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") ShareLinkNotificationParameterGroup.Show parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    return new ShareLinkNotificationModel(connection.findBundleNotification(requestParameters));
  }

  /**
   * Create Share Link Notification
   */
  @DisplayName("Share Link - Create Notification")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public ShareLinkNotificationModel createShareLinkNotification(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") ShareLinkNotificationParameterGroup.Create parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.bundleId != null) {
      requestParameters.put(BUNDLE_ID, parameters.getBundleId());
    }

    if (parameters.notifyUserId != null) {
      requestParameters.put(NOTIFY_USER_ID, parameters.getNotifyUserId());
    }

    requestParameters.put(NOTIFY_ON_REGISTRATION, true);
    requestParameters.put(NOTIFY_ON_UPLOAD, true);
    return new ShareLinkNotificationModel(connection.createBundleNotification(requestParameters));
  }

  /**
   * Update Share Link Notification
   */
  @DisplayName("Share Link - Update Notification")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public ShareLinkNotificationModel updateShareLinkNotification(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") ShareLinkNotificationParameterGroup.Update parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    requestParameters.put(NOTIFY_ON_REGISTRATION, parameters.getNotifyOnRegistration());
    requestParameters.put(NOTIFY_ON_UPLOAD, parameters.getNotifyOnUpload());
    return new ShareLinkNotificationModel(connection.updateBundleNotification(requestParameters));
  }

  /**
   * Delete Share Link Notification
   */
  @DisplayName("Share Link - Delete Notification")
  @Throws(FilesComErrorsProvider.class)
  public void deleteShareLinkNotification(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") ShareLinkNotificationParameterGroup.Delete parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    connection.deleteBundleNotification(requestParameters);
  }

  /**
   * List Share Link Recipients
   */
  @DisplayName("Share Link - List Recipients")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, ShareLinkRecipientModel> listShareLinkRecipients(final @ParameterGroup(name = "Parameters") ShareLinkRecipientParameterGroup.List parameters) {
    return new PagingProvider<FilesComConnection, ShareLinkRecipientModel>() {

      private ListIterator<BundleRecipient> iterator;

      @Override
      public List<ShareLinkRecipientModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();
          if (parameters.bundleId != null) {
            requestParameters.put(BUNDLE_ID, parameters.getBundleId());
          }

          LOGGER.debug("Loading first page of ShareLinkRecipients...");
          iterator = connection.listBundleRecipient(requestParameters);
        } else {
          if (iterator.hasNextPage()) {
            LOGGER.debug("Loading next page of ShareLinkRecipients...");
            iterator = connection.listBundleRecipient(iterator);
          } else {
            LOGGER.debug("No more pages of ShareLinkRecipients to load");
            return new ArrayList<>();
          }
        }

        return iterator.data.stream().map(ShareLinkRecipientModel::new).collect(Collectors.toList());
      }

      @Override
      public java.util.Optional<Integer> getTotalResults(final FilesComConnection connection) {
        return java.util.Optional.empty(); // not supported
      }

      @Override
      public void close(final FilesComConnection connection) throws MuleException {
        // no-op
      }
    };
  }

  /**
   * Create Share Link Recipient
   */
  @DisplayName("Share Link - Create Recipient")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public ShareLinkRecipientModel createShareLinkRecipient(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") ShareLinkRecipientParameterGroup.Create parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.bundleId != null) {
      requestParameters.put(BUNDLE_ID, parameters.getBundleId());
    }

    if (parameters.recipient != null) {
      requestParameters.put(RECIPIENT, parameters.getRecipient());
    }

    if (parameters.name != null) {
      requestParameters.put(NAME, parameters.getName());
    }

    if (parameters.company != null) {
      requestParameters.put(COMPANY, parameters.getCompany());
    }

    if (parameters.note != null) {
      requestParameters.put(NOTE, parameters.getNote());
    }

    requestParameters.put(SHARE_AFTER_CREATE, true);
    return new ShareLinkRecipientModel(connection.createBundleRecipient(requestParameters));
  }

  /**
   * List Share Link Registrations
   */
  @DisplayName("Share Link - List Registrations")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, ShareLinkRegistrationModel> listShareLinkRegistrations(final @ParameterGroup(name = "Parameters") ShareLinkRegistrationParameterGroup.List parameters) {
    return new PagingProvider<FilesComConnection, ShareLinkRegistrationModel>() {

      private ListIterator<BundleRegistration> iterator;

      @Override
      public List<ShareLinkRegistrationModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();
          if (parameters.bundleId != null) {
            requestParameters.put(BUNDLE_ID, parameters.getBundleId());
          }

          LOGGER.debug("Loading first page of ShareLinkRegistrations...");
          iterator = connection.listBundleRegistration(requestParameters);
        } else {
          if (iterator.hasNextPage()) {
            LOGGER.debug("Loading next page of ShareLinkRegistrations...");
            iterator = connection.listBundleRegistration(iterator);
          } else {
            LOGGER.debug("No more pages of ShareLinkRegistrations to load");
            return new ArrayList<>();
          }
        }

        return iterator.data.stream().map(ShareLinkRegistrationModel::new).collect(Collectors.toList());
      }

      @Override
      public java.util.Optional<Integer> getTotalResults(final FilesComConnection connection) {
        return java.util.Optional.empty(); // not supported
      }

      @Override
      public void close(final FilesComConnection connection) throws MuleException {
        // no-op
      }
    };
  }

  /**
   * Download File
   */
  @DisplayName("File - Download")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public InputStream downloadFile(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") FileParameterGroup.Download parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.path != null) {
      requestParameters.put(PATH, parameters.getPath());
    }

    return connection.downloadFile(requestParameters);
  }

  /**
   * Upload File
   */
  @DisplayName("File - Upload")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileModel uploadFile(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") FileParameterGroup.Upload parameters, final @Content @Summary("Content to be written into the file.") InputStream content) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.path != null) {
      requestParameters.put(PATH, parameters.getPath());
    }

    requestParameters.put(MKDIR_PARENTS, true);
    return new FileModel(connection.createFile(requestParameters, content));
  }

  /**
   * Delete File/Folder
   */
  @DisplayName("File - Delete")
  @Throws(FilesComErrorsProvider.class)
  public void deleteFile(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") FileParameterGroup.Delete parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.path != null) {
      requestParameters.put(PATH, parameters.getPath());
    }

    connection.deleteFile(requestParameters);
  }

  /**
   * Find File/Folder by Path
   */
  @DisplayName("File - Show")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileModel showFile(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") FileParameterGroup.Show parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.path != null) {
      requestParameters.put(PATH, parameters.getPath());
    }

    return new FileModel(connection.findFile(requestParameters));
  }

  /**
   * Copy File/Folder
   */
  @DisplayName("File - Copy")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileActionModel copyFile(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") FileParameterGroup.Copy parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.path != null) {
      requestParameters.put(PATH, parameters.getPath());
    }

    if (parameters.destination != null) {
      requestParameters.put(DESTINATION, parameters.getDestination());
    }

    return new FileActionModel(connection.copyFile(requestParameters));
  }

  /**
   * Move File/Folder
   */
  @DisplayName("File - Move")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileActionModel moveFile(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") FileParameterGroup.Move parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.path != null) {
      requestParameters.put(PATH, parameters.getPath());
    }

    if (parameters.destination != null) {
      requestParameters.put(DESTINATION, parameters.getDestination());
    }

    return new FileActionModel(connection.moveFile(requestParameters));
  }

  /**
   * List Folders by Path
   */
  @DisplayName("Folder - List")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, FileModel> listFolders(final @ParameterGroup(name = "Parameters") FolderParameterGroup.List parameters) {
    return new PagingProvider<FilesComConnection, FileModel>() {

      private ListIterator<File> iterator;

      @Override
      public List<FileModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();
          if (parameters.path != null) {
            requestParameters.put(PATH, parameters.getPath());
          }

          LOGGER.debug("Loading first page of Folders...");
          iterator = connection.listForFolder(requestParameters);
        } else {
          if (iterator.hasNextPage()) {
            LOGGER.debug("Loading next page of Folders...");
            iterator = connection.listForFolder(iterator);
          } else {
            LOGGER.debug("No more pages of Folders to load");
            return new ArrayList<>();
          }
        }

        return iterator.data.stream().map(FileModel::new).collect(Collectors.toList());
      }

      @Override
      public java.util.Optional<Integer> getTotalResults(final FilesComConnection connection) {
        return java.util.Optional.empty(); // not supported
      }

      @Override
      public void close(final FilesComConnection connection) throws MuleException {
        // no-op
      }
    };
  }

  /**
   * Create Folder
   */
  @DisplayName("Folder - Create")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FolderModel createFolder(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") FolderParameterGroup.Create parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.path != null) {
      requestParameters.put(PATH, parameters.getPath());
    }

    requestParameters.put(MKDIR_PARENTS, true);
    return new FolderModel(connection.createFolder(requestParameters));
  }

  /**
   * Delete File/Folder
   */
  @DisplayName("Folder - Delete")
  @Throws(FilesComErrorsProvider.class)
  public void deleteFolder(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") FileParameterGroup.Delete parameters) {
    deleteFile(connection, parameters);
  }

  /**
   * Find File/Folder by Path
   */
  @DisplayName("Folder - Show")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileModel showFolder(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") FileParameterGroup.Show parameters) {
    return showFile(connection, parameters);
  }

  /**
   * Copy File/Folder
   */
  @DisplayName("Folder - Copy")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileActionModel copyFolder(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") FileParameterGroup.Copy parameters) {
    return copyFile(connection, parameters);
  }

  /**
   * Move File/Folder
   */
  @DisplayName("Folder - Move")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileActionModel moveFolder(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") FileParameterGroup.Move parameters) {
    return moveFile(connection, parameters);
  }

  /**
   * List Groups
   */
  @DisplayName("Group - List")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, GroupModel> listGroups() {
    return new PagingProvider<FilesComConnection, GroupModel>() {

      private ListIterator<Group> iterator;

      @Override
      public List<GroupModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();

          LOGGER.debug("Loading first page of Groups...");
          iterator = connection.listGroup(requestParameters);
        } else {
          if (iterator.hasNextPage()) {
            LOGGER.debug("Loading next page of Groups...");
            iterator = connection.listGroup(iterator);
          } else {
            LOGGER.debug("No more pages of Groups to load");
            return new ArrayList<>();
          }
        }

        return iterator.data.stream().map(GroupModel::new).collect(Collectors.toList());
      }

      @Override
      public java.util.Optional<Integer> getTotalResults(final FilesComConnection connection) {
        return java.util.Optional.empty(); // not supported
      }

      @Override
      public void close(final FilesComConnection connection) throws MuleException {
        // no-op
      }
    };
  }

  /**
   * Show Group
   */
  @DisplayName("Group - Show")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public GroupModel showGroup(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") GroupParameterGroup.Show parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    return new GroupModel(connection.findGroup(requestParameters));
  }

  /**
   * Create Group
   */
  @DisplayName("Group - Create")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public GroupModel createGroup(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") GroupParameterGroup.Create parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.name != null) {
      requestParameters.put(NAME, parameters.getName());
    }

    if (parameters.notes != null) {
      requestParameters.put(NOTES, parameters.getNotes());
    }

    if (parameters.userIds != null) {
      requestParameters.put(USER_IDS, parameters.getUserIds());
    }

    if (parameters.adminIds != null) {
      requestParameters.put(ADMIN_IDS, parameters.getAdminIds());
    }

    return new GroupModel(connection.createGroup(requestParameters));
  }

  /**
   * Update Group
   */
  @DisplayName("Group - Update")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public GroupModel updateGroup(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") GroupParameterGroup.Update parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    if (parameters.notes != null) {
      requestParameters.put(NOTES, parameters.getNotes());
    }

    if (parameters.userIds != null) {
      requestParameters.put(USER_IDS, parameters.getUserIds());
    }

    if (parameters.adminIds != null) {
      requestParameters.put(ADMIN_IDS, parameters.getAdminIds());
    }

    if (parameters.name != null) {
      requestParameters.put(NAME, parameters.getName());
    }

    return new GroupModel(connection.updateGroup(requestParameters));
  }

  /**
   * Delete Group
   */
  @DisplayName("Group - Delete")
  @Throws(FilesComErrorsProvider.class)
  public void deleteGroup(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") GroupParameterGroup.Delete parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    connection.deleteGroup(requestParameters);
  }

  /**
   * List Users
   */
  @DisplayName("User - List")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, UserModel> listUsers() {
    return new PagingProvider<FilesComConnection, UserModel>() {

      private ListIterator<User> iterator;

      @Override
      public List<UserModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();

          LOGGER.debug("Loading first page of Users...");
          iterator = connection.listUser(requestParameters);
        } else {
          if (iterator.hasNextPage()) {
            LOGGER.debug("Loading next page of Users...");
            iterator = connection.listUser(iterator);
          } else {
            LOGGER.debug("No more pages of Users to load");
            return new ArrayList<>();
          }
        }

        return iterator.data.stream().map(UserModel::new).collect(Collectors.toList());
      }

      @Override
      public java.util.Optional<Integer> getTotalResults(final FilesComConnection connection) {
        return java.util.Optional.empty(); // not supported
      }

      @Override
      public void close(final FilesComConnection connection) throws MuleException {
        // no-op
      }
    };
  }

  /**
   * Show User
   */
  @DisplayName("User - Show")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public UserModel showUser(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") UserParameterGroup.Show parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    return new UserModel(connection.findUser(requestParameters));
  }

  /**
   * Create User
   */
  @DisplayName("User - Create")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public UserModel createUser(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") UserParameterGroup.Create parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.username != null) {
      requestParameters.put(USERNAME, parameters.getUsername());
    }

    if (parameters.email != null) {
      requestParameters.put(EMAIL, parameters.getEmail());
    }

    if (parameters.groupIds != null) {
      requestParameters.put(GROUP_IDS, parameters.getGroupIds());
    }

    if (parameters.password != null) {
      requestParameters.put(PASSWORD, parameters.getPassword());
    }

    if (parameters.authenticationMethod != null) {
      requestParameters.put(AUTHENTICATION_METHOD, parameters.getAuthenticationMethod());
    }

    if (parameters.name != null) {
      requestParameters.put(NAME, parameters.getName());
    }

    if (parameters.company != null) {
      requestParameters.put(COMPANY, parameters.getCompany());
    }

    if (parameters.notes != null) {
      requestParameters.put(NOTES, parameters.getNotes());
    }

    requestParameters.put(REQUIRE_PASSWORD_CHANGE, parameters.getRequirePasswordChange());
    if (parameters.userRoot != null) {
      requestParameters.put(USER_ROOT, parameters.getUserRoot());
    }

    if (parameters.userHome != null) {
      requestParameters.put(USER_HOME, parameters.getUserHome());
    }

    requestParameters.put(DAV_PERMISSION, true);
    requestParameters.put(FTP_PERMISSION, true);
    requestParameters.put(RESTAPI_PERMISSION, true);
    requestParameters.put(SFTP_PERMISSION, true);
    return new UserModel(connection.createUser(requestParameters));
  }

  /**
   * Update User
   */
  @DisplayName("User - Update")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public UserModel updateUser(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") UserParameterGroup.Update parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    if (parameters.email != null) {
      requestParameters.put(EMAIL, parameters.getEmail());
    }

    if (parameters.groupIds != null) {
      requestParameters.put(GROUP_IDS, parameters.getGroupIds());
    }

    if (parameters.password != null) {
      requestParameters.put(PASSWORD, parameters.getPassword());
    }

    if (parameters.authenticationMethod != null) {
      requestParameters.put(AUTHENTICATION_METHOD, parameters.getAuthenticationMethod());
    }

    if (parameters.name != null) {
      requestParameters.put(NAME, parameters.getName());
    }

    if (parameters.company != null) {
      requestParameters.put(COMPANY, parameters.getCompany());
    }

    if (parameters.notes != null) {
      requestParameters.put(NOTES, parameters.getNotes());
    }

    requestParameters.put(REQUIRE_PASSWORD_CHANGE, parameters.getRequirePasswordChange());
    if (parameters.userRoot != null) {
      requestParameters.put(USER_ROOT, parameters.getUserRoot());
    }

    if (parameters.userHome != null) {
      requestParameters.put(USER_HOME, parameters.getUserHome());
    }

    if (parameters.username != null) {
      requestParameters.put(USERNAME, parameters.getUsername());
    }

    requestParameters.put(DAV_PERMISSION, true);
    requestParameters.put(FTP_PERMISSION, true);
    requestParameters.put(RESTAPI_PERMISSION, true);
    requestParameters.put(SFTP_PERMISSION, true);
    return new UserModel(connection.updateUser(requestParameters));
  }

  /**
   * Delete User
   */
  @DisplayName("User - Delete")
  @Throws(FilesComErrorsProvider.class)
  public void deleteUser(final @Connection FilesComConnection connection, final @ParameterGroup(name = "Parameters") UserParameterGroup.Delete parameters) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (parameters.id != null) {
      requestParameters.put(ID, parameters.getId());
    }

    connection.deleteUser(requestParameters);
  }
}
