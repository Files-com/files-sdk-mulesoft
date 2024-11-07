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
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.annotation.values.OfValues;
import org.mule.runtime.extension.api.runtime.streaming.PagingProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.files.ListIterator;
import com.files.models.*;
import com.files.mule.api.models.*;
import com.files.mule.internal.connection.FilesComConnection;
import com.files.mule.internal.error.provider.FilesComErrorsProvider;
import com.files.mule.internal.values.*;

public class FilesComOperations {

  private static final Logger LOGGER = LoggerFactory.getLogger(FilesComOperations.class);

  /**
   * List Share Links
   */
  @DisplayName("Share Link - List")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, ShareLinkModel> listShareLinks(
  ) {
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
  public ShareLinkModel showShareLink(
      final @Connection FilesComConnection connection,
      final @Summary("Bundle ID.") @Example("1") Long id) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    return new ShareLinkModel(connection.findBundle(requestParameters));
  }

  /**
   * Create Share Link
   */
  @DisplayName("Share Link - Create")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public ShareLinkModel createShareLink(
      final @Connection FilesComConnection connection,
      final @Summary("A list of paths to include in this bundle.") @Example("[\"file.txt\"]") List<String> paths,
      final @Optional @Summary("Password for this bundle.") @Example("Password") String password,
      final @Optional @Summary("Bundle expiration date/time") @Example("2000-01-01T01:00:00Z") String expiresAt,
      final @Optional @Summary("Maximum number of times bundle can be accessed") @Example("1") Long maxUses,
      final @Optional @Summary("Public description") @Example("The public description of the bundle.") String description,
      final @Optional @Summary("Bundle internal note") @Example("The internal note on the bundle.") String note,
      final @Optional @Summary("Show a registration page that captures the downloader's name and email address?") @Example("true") boolean requireRegistration) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (paths != null) {
      requestParameters.put("paths", paths.toArray(new String[0]));
    }

    if (password != null) {
      requestParameters.put("password", password);
    }

    if (expiresAt != null) {
      requestParameters.put("expires_at", expiresAt);
    }

    if (maxUses != null) {
      requestParameters.put("max_uses", maxUses);
    }

    if (description != null) {
      requestParameters.put("description", description);
    }

    if (note != null) {
      requestParameters.put("note", note);
    }

    requestParameters.put("require_registration", requireRegistration);
    requestParameters.put("permissions", "read");
    return new ShareLinkModel(connection.createBundle(requestParameters));
  }

  /**
   * Update Share Link
   */
  @DisplayName("Share Link - Update")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public ShareLinkModel updateShareLink(
      final @Connection FilesComConnection connection,
      final @Summary("Bundle ID.") @Example("1") Long id,
      final @Optional @Summary("Bundle expiration date/time") @Example("2000-01-01T01:00:00Z") String expiresAt) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    if (expiresAt != null) {
      requestParameters.put("expires_at", expiresAt);
    }

    return new ShareLinkModel(connection.updateBundle(requestParameters));
  }

  /**
   * Delete Share Link
   */
  @DisplayName("Share Link - Delete")
  @Throws(FilesComErrorsProvider.class)
  public void deleteShareLink(
      final @Connection FilesComConnection connection,
      final @Summary("Bundle ID.") @Example("1") Long id) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    connection.deleteBundle(requestParameters);
  }

  /**
   * List Share Link Downloads
   */
  @DisplayName("Share Link - List Downloads")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, ShareLinkDownloadModel> listShareLinkDownloads(
      final @Optional @Summary("Bundle ID") @Example("1") Long bundleId) {
    return new PagingProvider<FilesComConnection, ShareLinkDownloadModel>() {

      private ListIterator<BundleDownload> iterator;

      @Override
      public List<ShareLinkDownloadModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();
          if (bundleId != null) {
            requestParameters.put("bundle_id", bundleId);
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
  public PagingProvider<FilesComConnection, ShareLinkNotificationModel> listShareLinkNotifications(
  ) {
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
  public ShareLinkNotificationModel showShareLinkNotification(
      final @Connection FilesComConnection connection,
      final @Summary("Bundle Notification ID.") @Example("1") Long id) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    return new ShareLinkNotificationModel(connection.findBundleNotification(requestParameters));
  }

  /**
   * Create Share Link Notification
   */
  @DisplayName("Share Link - Create Notification")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public ShareLinkNotificationModel createShareLinkNotification(
      final @Connection FilesComConnection connection,
      final @Summary("Bundle ID to notify on") @Example("1") Long bundleId,
      final @Optional @Summary("The id of the user to notify.") @Example("1") Long userId) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (bundleId != null) {
      requestParameters.put("bundle_id", bundleId);
    }

    if (userId != null) {
      requestParameters.put("user_id", userId);
    }

    requestParameters.put("notify_on_registration", true);
    requestParameters.put("notify_on_upload", true);
    return new ShareLinkNotificationModel(connection.createBundleNotification(requestParameters));
  }

  /**
   * Update Share Link Notification
   */
  @DisplayName("Share Link - Update Notification")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public ShareLinkNotificationModel updateShareLinkNotification(
      final @Connection FilesComConnection connection,
      final @Summary("Bundle Notification ID.") @Example("1") Long id,
      final @Optional @Summary("Triggers bundle notification when a registration action occurs for it.") @Example("true") boolean notifyOnRegistration,
      final @Optional @Summary("Triggers bundle notification when a upload action occurs for it.") @Example("true") boolean notifyOnUpload) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    requestParameters.put("notify_on_registration", notifyOnRegistration);
    requestParameters.put("notify_on_upload", notifyOnUpload);
    return new ShareLinkNotificationModel(connection.updateBundleNotification(requestParameters));
  }

  /**
   * Delete Share Link Notification
   */
  @DisplayName("Share Link - Delete Notification")
  @Throws(FilesComErrorsProvider.class)
  public void deleteShareLinkNotification(
      final @Connection FilesComConnection connection,
      final @Summary("Bundle Notification ID.") @Example("1") Long id) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    connection.deleteBundleNotification(requestParameters);
  }

  /**
   * List Share Link Recipients
   */
  @DisplayName("Share Link - List Recipients")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, ShareLinkRecipientModel> listShareLinkRecipients(
      final @Summary("List recipients for the bundle with this ID.") @Example("1") Long bundleId) {
    return new PagingProvider<FilesComConnection, ShareLinkRecipientModel>() {

      private ListIterator<BundleRecipient> iterator;

      @Override
      public List<ShareLinkRecipientModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();
          if (bundleId != null) {
            requestParameters.put("bundle_id", bundleId);
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
  public ShareLinkRecipientModel createShareLinkRecipient(
      final @Connection FilesComConnection connection,
      final @Summary("Bundle to share.") @Example("1") Long bundleId,
      final @Summary("Email addresses to share this bundle with.") @Example("johndoe@gmail.com") String recipient,
      final @Optional @Summary("Name of recipient.") @Example("John Smith") String name,
      final @Optional @Summary("Company of recipient.") @Example("Acme Ltd") String company,
      final @Optional @Summary("Note to include in email.") @Example("Just a note.") String note) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (bundleId != null) {
      requestParameters.put("bundle_id", bundleId);
    }

    if (recipient != null) {
      requestParameters.put("recipient", recipient);
    }

    if (name != null) {
      requestParameters.put("name", name);
    }

    if (company != null) {
      requestParameters.put("company", company);
    }

    if (note != null) {
      requestParameters.put("note", note);
    }

    requestParameters.put("share_after_create", true);
    return new ShareLinkRecipientModel(connection.createBundleRecipient(requestParameters));
  }

  /**
   * List Share Link Registrations
   */
  @DisplayName("Share Link - List Registrations")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, ShareLinkRegistrationModel> listShareLinkRegistrations(
      final @Optional @Summary("ID of the associated Bundle") @Example("1") Long bundleId) {
    return new PagingProvider<FilesComConnection, ShareLinkRegistrationModel>() {

      private ListIterator<BundleRegistration> iterator;

      @Override
      public List<ShareLinkRegistrationModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();
          if (bundleId != null) {
            requestParameters.put("bundle_id", bundleId);
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
   * Download file
   */
  @DisplayName("File - Download")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public InputStream downloadFile(
      final @Connection FilesComConnection connection,
      final @Summary("Path to operate on.") @Example("path") String path) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (path != null) {
      requestParameters.put("path", path);
    }

    return connection.downloadFile(requestParameters);
  }

  /**
   * Upload file
   */
  @DisplayName("File - Upload")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileModel uploadFile(
      final @Connection FilesComConnection connection,
      final @Summary("Path to operate on.") @Example("path") String path,
      final @Content @Summary("Content to be written into the file.") InputStream content) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (path != null) {
      requestParameters.put("path", path);
    }

    requestParameters.put("mkdir_parents", true);
    return new FileModel(connection.createFile(requestParameters, content));
  }

  /**
   * Delete file/folder
   */
  @DisplayName("File - Delete")
  @Throws(FilesComErrorsProvider.class)
  public void deleteFile(
      final @Connection FilesComConnection connection,
      final @Summary("Path to operate on.") @Example("path") String path) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (path != null) {
      requestParameters.put("path", path);
    }

    connection.deleteFile(requestParameters);
  }

  /**
   * Find file/folder by path
   */
  @DisplayName("File - Show")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileModel showFile(
      final @Connection FilesComConnection connection,
      final @Summary("Path to operate on.") @Example("path") String path) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (path != null) {
      requestParameters.put("path", path);
    }

    return new FileModel(connection.findFile(requestParameters));
  }

  /**
   * Copy file/folder
   */
  @DisplayName("File - Copy")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileActionModel copyFile(
      final @Connection FilesComConnection connection,
      final @Summary("Path to operate on.") @Example("path") String path,
      final @Summary("Copy destination path.") @Example("destination") String destination) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (path != null) {
      requestParameters.put("path", path);
    }

    if (destination != null) {
      requestParameters.put("destination", destination);
    }

    return new FileActionModel(connection.copyFile(requestParameters));
  }

  /**
   * Move file/folder
   */
  @DisplayName("File - Move")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileActionModel moveFile(
      final @Connection FilesComConnection connection,
      final @Summary("Path to operate on.") @Example("path") String path,
      final @Summary("Move destination path.") @Example("destination") String destination) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (path != null) {
      requestParameters.put("path", path);
    }

    if (destination != null) {
      requestParameters.put("destination", destination);
    }

    return new FileActionModel(connection.moveFile(requestParameters));
  }

  /**
   * List Folders by path
   */
  @DisplayName("Folder - List")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, FileModel> listFolders(
      final @Summary("Path to operate on.") @Example("path") String path) {
    return new PagingProvider<FilesComConnection, FileModel>() {

      private ListIterator<File> iterator;

      @Override
      public List<FileModel> getPage(final FilesComConnection connection) {
        if (iterator == null) {
          final HashMap<String, Object> requestParameters = new HashMap<>();
          if (path != null) {
            requestParameters.put("path", path);
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
   * Create folder
   */
  @DisplayName("Folder - Create")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FolderModel createFolder(
      final @Connection FilesComConnection connection,
      final @Summary("Path to operate on.") @Example("path") String path) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (path != null) {
      requestParameters.put("path", path);
    }

    requestParameters.put("mkdir_parents", true);
    return new FolderModel(connection.createFolder(requestParameters));
  }

  /**
   * Delete file/folder
   */
  @DisplayName("Folder - Delete")
  @Throws(FilesComErrorsProvider.class)
  public void deleteFolder(
      final @Connection FilesComConnection connection,
      final @Summary("Path to operate on.") @Example("path") String path) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (path != null) {
      requestParameters.put("path", path);
    }

    connection.deleteFile(requestParameters);
  }

  /**
   * Find file/folder by path
   */
  @DisplayName("Folder - Show")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileModel showFolder(
      final @Connection FilesComConnection connection,
      final @Summary("Path to operate on.") @Example("path") String path) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (path != null) {
      requestParameters.put("path", path);
    }

    return new FileModel(connection.findFile(requestParameters));
  }

  /**
   * Copy file/folder
   */
  @DisplayName("Folder - Copy")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileActionModel copyFolder(
      final @Connection FilesComConnection connection,
      final @Summary("Path to operate on.") @Example("path") String path,
      final @Summary("Copy destination path.") @Example("destination") String destination) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (path != null) {
      requestParameters.put("path", path);
    }

    if (destination != null) {
      requestParameters.put("destination", destination);
    }

    return new FileActionModel(connection.copyFile(requestParameters));
  }

  /**
   * Move file/folder
   */
  @DisplayName("Folder - Move")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public FileActionModel moveFolder(
      final @Connection FilesComConnection connection,
      final @Summary("Path to operate on.") @Example("path") String path,
      final @Summary("Move destination path.") @Example("destination") String destination) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (path != null) {
      requestParameters.put("path", path);
    }

    if (destination != null) {
      requestParameters.put("destination", destination);
    }

    return new FileActionModel(connection.moveFile(requestParameters));
  }

  /**
   * List Groups
   */
  @DisplayName("Group - List")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, GroupModel> listGroups(
  ) {
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
  public GroupModel showGroup(
      final @Connection FilesComConnection connection,
      final @Summary("Group ID.") @Example("1") Long id) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    return new GroupModel(connection.findGroup(requestParameters));
  }

  /**
   * Create Group
   */
  @DisplayName("Group - Create")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public GroupModel createGroup(
      final @Connection FilesComConnection connection,
      final @Summary("Group name.") @Example("name") String name,
      final @Optional @Summary("Group notes.") @Example("example") String notes,
      final @Optional @Summary("A list of user ids. If sent as a string, should be comma-delimited.") @Example("1") String userIds,
      final @Optional @Summary("A list of group admin user ids. If sent as a string, should be comma-delimited.") @Example("1") String adminIds) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (name != null) {
      requestParameters.put("name", name);
    }

    if (notes != null) {
      requestParameters.put("notes", notes);
    }

    if (userIds != null) {
      requestParameters.put("user_ids", userIds);
    }

    if (adminIds != null) {
      requestParameters.put("admin_ids", adminIds);
    }

    return new GroupModel(connection.createGroup(requestParameters));
  }

  /**
   * Update Group
   */
  @DisplayName("Group - Update")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public GroupModel updateGroup(
      final @Connection FilesComConnection connection,
      final @Summary("Group ID.") @Example("1") Long id,
      final @Optional @Summary("Group notes.") @Example("example") String notes,
      final @Optional @Summary("A list of user ids. If sent as a string, should be comma-delimited.") @Example("1") String userIds,
      final @Optional @Summary("A list of group admin user ids. If sent as a string, should be comma-delimited.") @Example("1") String adminIds,
      final @Optional @Summary("Group name.") @Example("owners") String name) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    if (notes != null) {
      requestParameters.put("notes", notes);
    }

    if (userIds != null) {
      requestParameters.put("user_ids", userIds);
    }

    if (adminIds != null) {
      requestParameters.put("admin_ids", adminIds);
    }

    if (name != null) {
      requestParameters.put("name", name);
    }

    return new GroupModel(connection.updateGroup(requestParameters));
  }

  /**
   * Delete Group
   */
  @DisplayName("Group - Delete")
  @Throws(FilesComErrorsProvider.class)
  public void deleteGroup(
      final @Connection FilesComConnection connection,
      final @Summary("Group ID.") @Example("1") Long id) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    connection.deleteGroup(requestParameters);
  }

  /**
   * List Users
   */
  @DisplayName("User - List")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public PagingProvider<FilesComConnection, UserModel> listUsers(
  ) {
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
  public UserModel showUser(
      final @Connection FilesComConnection connection,
      final @Summary("User ID.") @Example("1") Long id) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    return new UserModel(connection.findUser(requestParameters));
  }

  /**
   * Create User
   */
  @DisplayName("User - Create")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public UserModel createUser(
      final @Connection FilesComConnection connection,
      final @Summary("User's username") @Example("user") String username,
      final @Optional @Summary("User's email.") @Example("example") String email,
      final @Optional @Summary("A list of group ids to associate this user with.  Comma delimited.") @Example("example") String groupIds,
      final @Optional @Summary("User password.") String password,
      final @Optional @Summary("How is this user authenticated?") @OfValues(UserValueProviders.AuthenticationMethod.class) @Example("password") String authenticationMethod,
      final @Optional @Summary("User's full name") @Example("John Doe") String name,
      final @Optional @Summary("User's company") @Example("ACME Corp.") String company,
      final @Optional @Summary("Any internal notes on the user") @Example("Internal notes on this user.") String notes,
      final @Optional @Summary("Is a password change required upon next user login?") @Example("true") boolean requirePasswordChange,
      final @Optional @Summary("Root folder for FTP (and optionally SFTP if the appropriate site-wide setting is set).  Note that this is not used for API, Desktop, or Web interface.") @Example("example") String userRoot,
      final @Optional @Summary("Home folder for FTP/SFTP.  Note that this is not used for API, Desktop, or Web interface.") @Example("example") String userHome) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (username != null) {
      requestParameters.put("username", username);
    }

    if (email != null) {
      requestParameters.put("email", email);
    }

    if (groupIds != null) {
      requestParameters.put("group_ids", groupIds);
    }

    if (password != null) {
      requestParameters.put("password", password);
    }

    if (authenticationMethod != null) {
      requestParameters.put("authentication_method", authenticationMethod);
    }

    if (name != null) {
      requestParameters.put("name", name);
    }

    if (company != null) {
      requestParameters.put("company", company);
    }

    if (notes != null) {
      requestParameters.put("notes", notes);
    }

    requestParameters.put("require_password_change", requirePasswordChange);
    if (userRoot != null) {
      requestParameters.put("user_root", userRoot);
    }

    if (userHome != null) {
      requestParameters.put("user_home", userHome);
    }

    requestParameters.put("dav_permission", true);
    requestParameters.put("ftp_permission", true);
    requestParameters.put("restapi_permission", true);
    requestParameters.put("sftp_permission", true);
    return new UserModel(connection.createUser(requestParameters));
  }

  /**
   * Update User
   */
  @DisplayName("User - Update")
  @MediaType(value = ANY, strict = false)
  @Throws(FilesComErrorsProvider.class)
  public UserModel updateUser(
      final @Connection FilesComConnection connection,
      final @Summary("User ID.") @Example("1") Long id,
      final @Optional @Summary("User's email.") @Example("example") String email,
      final @Optional @Summary("A list of group ids to associate this user with.  Comma delimited.") @Example("example") String groupIds,
      final @Optional @Summary("User password.") String password,
      final @Optional @Summary("How is this user authenticated?") @OfValues(UserValueProviders.AuthenticationMethod.class) @Example("password") String authenticationMethod,
      final @Optional @Summary("User's full name") @Example("John Doe") String name,
      final @Optional @Summary("User's company") @Example("ACME Corp.") String company,
      final @Optional @Summary("Any internal notes on the user") @Example("Internal notes on this user.") String notes,
      final @Optional @Summary("Is a password change required upon next user login?") @Example("true") boolean requirePasswordChange,
      final @Optional @Summary("Root folder for FTP (and optionally SFTP if the appropriate site-wide setting is set).  Note that this is not used for API, Desktop, or Web interface.") @Example("example") String userRoot,
      final @Optional @Summary("Home folder for FTP/SFTP.  Note that this is not used for API, Desktop, or Web interface.") @Example("example") String userHome,
      final @Optional @Summary("User's username") @Example("user") String username) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    if (email != null) {
      requestParameters.put("email", email);
    }

    if (groupIds != null) {
      requestParameters.put("group_ids", groupIds);
    }

    if (password != null) {
      requestParameters.put("password", password);
    }

    if (authenticationMethod != null) {
      requestParameters.put("authentication_method", authenticationMethod);
    }

    if (name != null) {
      requestParameters.put("name", name);
    }

    if (company != null) {
      requestParameters.put("company", company);
    }

    if (notes != null) {
      requestParameters.put("notes", notes);
    }

    requestParameters.put("require_password_change", requirePasswordChange);
    if (userRoot != null) {
      requestParameters.put("user_root", userRoot);
    }

    if (userHome != null) {
      requestParameters.put("user_home", userHome);
    }

    if (username != null) {
      requestParameters.put("username", username);
    }

    requestParameters.put("dav_permission", true);
    requestParameters.put("ftp_permission", true);
    requestParameters.put("restapi_permission", true);
    requestParameters.put("sftp_permission", true);
    return new UserModel(connection.updateUser(requestParameters));
  }

  /**
   * Delete User
   */
  @DisplayName("User - Delete")
  @Throws(FilesComErrorsProvider.class)
  public void deleteUser(
      final @Connection FilesComConnection connection,
      final @Summary("User ID.") @Example("1") Long id) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    if (id != null) {
      requestParameters.put("id", id);
    }

    connection.deleteUser(requestParameters);
  }
}
