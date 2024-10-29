package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

import com.files.models.Folder;

public class FolderModel implements Serializable {
  public FolderModel() {
  }

  public FolderModel(final Folder folder) {
    this.path = folder.path;
    this.createdById = folder.createdById;
    this.createdByApiKeyId = folder.createdByApiKeyId;
    this.createdByAs2IncomingMessageId = folder.createdByAs2IncomingMessageId;
    this.createdByAutomationId = folder.createdByAutomationId;
    this.createdByBundleRegistrationId = folder.createdByBundleRegistrationId;
    this.createdByInboxId = folder.createdByInboxId;
    this.createdByRemoteServerId = folder.createdByRemoteServerId;
    this.createdByRemoteServerSyncId = folder.createdByRemoteServerSyncId;
    this.customMetadata = folder.customMetadata;
    this.displayName = folder.displayName;
    this.type = folder.type;
    this.size = folder.size;
    this.createdAt = folder.createdAt;
    this.lastModifiedById = folder.lastModifiedById;
    this.lastModifiedByApiKeyId = folder.lastModifiedByApiKeyId;
    this.lastModifiedByAutomationId = folder.lastModifiedByAutomationId;
    this.lastModifiedByBundleRegistrationId = folder.lastModifiedByBundleRegistrationId;
    this.lastModifiedByRemoteServerId = folder.lastModifiedByRemoteServerId;
    this.lastModifiedByRemoteServerSyncId = folder.lastModifiedByRemoteServerSyncId;
    this.mtime = folder.mtime;
    this.providedMtime = folder.providedMtime;
    this.crc32 = folder.crc32;
    this.md5 = folder.md5;
    this.sha1 = folder.sha1;
    this.sha256 = folder.sha256;
    this.mimeType = folder.mimeType;
    this.region = folder.region;
    this.permissions = folder.permissions;
    this.subfoldersLocked = folder.subfoldersLocked;
    this.isLocked = folder.isLocked;
    this.downloadUri = folder.downloadUri;
    this.priorityColor = folder.priorityColor;
    this.previewId = folder.previewId;
    if (folder.preview != null) {
      this.preview = new PreviewModel(folder.preview);
    }
    this.mkdirParents = folder.mkdirParents;
  }

  /**
   * File/Folder path. This must be slash-delimited, but it must neither start nor end with a slash. Maximum of 5000 characters.
   */
  @Parameter
  public String path;

  public String getPath() {
    return path;
  }

  /**
   * User ID of the User who created the file/folder
   */
  @Parameter
  public Long createdById;

  public Long getCreatedById() {
    return createdById;
  }

  /**
   * ID of the API key that created the file/folder
   */
  @Parameter
  public Long createdByApiKeyId;

  public Long getCreatedByApiKeyId() {
    return createdByApiKeyId;
  }

  /**
   * ID of the AS2 Incoming Message that created the file/folder
   */
  @Parameter
  public Long createdByAs2IncomingMessageId;

  public Long getCreatedByAs2IncomingMessageId() {
    return createdByAs2IncomingMessageId;
  }

  /**
   * ID of the Automation that created the file/folder
   */
  @Parameter
  public Long createdByAutomationId;

  public Long getCreatedByAutomationId() {
    return createdByAutomationId;
  }

  /**
   * ID of the Bundle Registration that created the file/folder
   */
  @Parameter
  public Long createdByBundleRegistrationId;

  public Long getCreatedByBundleRegistrationId() {
    return createdByBundleRegistrationId;
  }

  /**
   * ID of the Inbox that created the file/folder
   */
  @Parameter
  public Long createdByInboxId;

  public Long getCreatedByInboxId() {
    return createdByInboxId;
  }

  /**
   * ID of the Remote Server that created the file/folder
   */
  @Parameter
  public Long createdByRemoteServerId;

  public Long getCreatedByRemoteServerId() {
    return createdByRemoteServerId;
  }

  /**
   * ID of the Remote Server Sync that created the file/folder
   */
  @Parameter
  public Long createdByRemoteServerSyncId;

  public Long getCreatedByRemoteServerSyncId() {
    return createdByRemoteServerSyncId;
  }

  /**
   * Custom metadata map of keys and values. Limited to 32 keys, 256 characters per key and 1024 characters per value.
   */
  @Parameter
  public Map<String, String> customMetadata;

  public Map<String, String> getCustomMetadata() {
    return customMetadata;
  }

  /**
   * File/Folder display name
   */
  @Parameter
  public String displayName;

  public String getDisplayName() {
    return displayName;
  }

  /**
   * Type: `directory` or `file`.
   */
  @Parameter
  public String type;

  public String getType() {
    return type;
  }

  /**
   * File/Folder size
   */
  @Parameter
  public Long size;

  public Long getSize() {
    return size;
  }

  /**
   * File created date/time
   */
  @Parameter
  public Date createdAt;

  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * User ID of the User who last modified the file/folder
   */
  @Parameter
  public Long lastModifiedById;

  public Long getLastModifiedById() {
    return lastModifiedById;
  }

  /**
   * ID of the API key that last modified the file/folder
   */
  @Parameter
  public Long lastModifiedByApiKeyId;

  public Long getLastModifiedByApiKeyId() {
    return lastModifiedByApiKeyId;
  }

  /**
   * ID of the Automation that last modified the file/folder
   */
  @Parameter
  public Long lastModifiedByAutomationId;

  public Long getLastModifiedByAutomationId() {
    return lastModifiedByAutomationId;
  }

  /**
   * ID of the Bundle Registration that last modified the file/folder
   */
  @Parameter
  public Long lastModifiedByBundleRegistrationId;

  public Long getLastModifiedByBundleRegistrationId() {
    return lastModifiedByBundleRegistrationId;
  }

  /**
   * ID of the Remote Server that last modified the file/folder
   */
  @Parameter
  public Long lastModifiedByRemoteServerId;

  public Long getLastModifiedByRemoteServerId() {
    return lastModifiedByRemoteServerId;
  }

  /**
   * ID of the Remote Server Sync that last modified the file/folder
   */
  @Parameter
  public Long lastModifiedByRemoteServerSyncId;

  public Long getLastModifiedByRemoteServerSyncId() {
    return lastModifiedByRemoteServerSyncId;
  }

  /**
   * File last modified date/time, according to the server.  This is the timestamp of the last Files.com operation of the file, regardless of what modified timestamp was sent.
   */
  @Parameter
  public Date mtime;

  public Date getMtime() {
    return mtime;
  }

  /**
   * File last modified date/time, according to the client who set it.  Files.com allows desktop, FTP, SFTP, and WebDAV clients to set modified at times.  This allows Desktop :Cloud syncing to preserve modified at times.
   */
  @Parameter
  public Date providedMtime;

  public Date getProvidedMtime() {
    return providedMtime;
  }

  /**
   * File CRC32 checksum. This is sometimes delayed, so if you get a blank response, wait and try again.
   */
  @Parameter
  public String crc32;

  public String getCrc32() {
    return crc32;
  }

  /**
   * File MD5 checksum. This is sometimes delayed, so if you get a blank response, wait and try again.
   */
  @Parameter
  public String md5;

  public String getMd5() {
    return md5;
  }

  /**
   * File SHA1 checksum. This is sometimes delayed, so if you get a blank response, wait and try again.
   */
  @Parameter
  public String sha1;

  public String getSha1() {
    return sha1;
  }

  /**
   * File SHA256 checksum. This is sometimes delayed, so if you get a blank response, wait and try again.
   */
  @Parameter
  public String sha256;

  public String getSha256() {
    return sha256;
  }

  /**
   * MIME Type.  This is determined by the filename extension and is not stored separately internally.
   */
  @Parameter
  public String mimeType;

  public String getMimeType() {
    return mimeType;
  }

  /**
   * Region location
   */
  @Parameter
  public String region;

  public String getRegion() {
    return region;
  }

  /**
   * A short string representing the current user's permissions.  Can be `r` (Read),`w` (Write),`d` (Delete), `l` (List) or any combination
   */
  @Parameter
  public String permissions;

  public String getPermissions() {
    return permissions;
  }

  /**
   * Are subfolders locked and unable to be modified?
   */
  @Parameter
  public Boolean subfoldersLocked;

  public Boolean getSubfoldersLocked() {
    return subfoldersLocked;
  }

  /**
   * Is this folder locked and unable to be modified?
   */
  @Parameter
  public Boolean isLocked;

  public Boolean getIsLocked() {
    return isLocked;
  }

  /**
   * Link to download file. Provided only in response to a download request.
   */
  @Parameter
  public String downloadUri;

  public String getDownloadUri() {
    return downloadUri;
  }

  /**
   * Bookmark/priority color of file/folder
   */
  @Parameter
  public String priorityColor;

  public String getPriorityColor() {
    return priorityColor;
  }

  /**
   * File preview ID
   */
  @Parameter
  public Long previewId;

  public Long getPreviewId() {
    return previewId;
  }

  /**
   * File preview
   */
  @Parameter
  public PreviewModel preview;

  public PreviewModel getPreview() {
    return preview;
  }

  /**
   * Create parent directories if they do not exist?
   */
  @Parameter
  public Boolean mkdirParents;

  public Boolean getMkdirParents() {
    return mkdirParents;
  }

}
