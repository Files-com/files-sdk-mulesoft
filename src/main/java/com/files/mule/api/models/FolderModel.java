package com.files.mule.api.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    if (folder.createdAt != null) {
      this.createdAt = ZonedDateTime.ofInstant(folder.createdAt.toInstant(), ZoneId.systemDefault());
    }
    this.lastModifiedById = folder.lastModifiedById;
    this.lastModifiedByApiKeyId = folder.lastModifiedByApiKeyId;
    this.lastModifiedByAutomationId = folder.lastModifiedByAutomationId;
    this.lastModifiedByBundleRegistrationId = folder.lastModifiedByBundleRegistrationId;
    this.lastModifiedByRemoteServerId = folder.lastModifiedByRemoteServerId;
    this.lastModifiedByRemoteServerSyncId = folder.lastModifiedByRemoteServerSyncId;
    if (folder.mtime != null) {
      this.mtime = ZonedDateTime.ofInstant(folder.mtime.toInstant(), ZoneId.systemDefault());
    }
    if (folder.providedMtime != null) {
      this.providedMtime = ZonedDateTime.ofInstant(folder.providedMtime.toInstant(), ZoneId.systemDefault());
    }
    this.crc32 = folder.crc32;
    this.md5 = folder.md5;
    this.sha1 = folder.sha1;
    this.sha256 = folder.sha256;
    this.mimeType = folder.mimeType;
    this.region = folder.region;
    this.permissions = folder.permissions;
    this.subfoldersLocked = Boolean.TRUE.equals(folder.subfoldersLocked);
    this.isLocked = Boolean.TRUE.equals(folder.isLocked);
    this.downloadUri = folder.downloadUri;
    this.priorityColor = folder.priorityColor;
    this.previewId = folder.previewId;
    if (folder.preview != null) {
      this.preview = new PreviewModel(folder.preview);
    }
    this.mkdirParents = Boolean.TRUE.equals(folder.mkdirParents);
  }

  private String path;

  public String getPath() {
    return path;
  }

  private Long createdById;

  public Long getCreatedById() {
    return createdById;
  }

  private Long createdByApiKeyId;

  public Long getCreatedByApiKeyId() {
    return createdByApiKeyId;
  }

  private Long createdByAs2IncomingMessageId;

  public Long getCreatedByAs2IncomingMessageId() {
    return createdByAs2IncomingMessageId;
  }

  private Long createdByAutomationId;

  public Long getCreatedByAutomationId() {
    return createdByAutomationId;
  }

  private Long createdByBundleRegistrationId;

  public Long getCreatedByBundleRegistrationId() {
    return createdByBundleRegistrationId;
  }

  private Long createdByInboxId;

  public Long getCreatedByInboxId() {
    return createdByInboxId;
  }

  private Long createdByRemoteServerId;

  public Long getCreatedByRemoteServerId() {
    return createdByRemoteServerId;
  }

  private Long createdByRemoteServerSyncId;

  public Long getCreatedByRemoteServerSyncId() {
    return createdByRemoteServerSyncId;
  }

  private Map<String, String> customMetadata;

  public Map<String, String> getCustomMetadata() {
    return customMetadata;
  }

  private String displayName;

  public String getDisplayName() {
    return displayName;
  }

  private String type;

  public String getType() {
    return type;
  }

  private Long size;

  public Long getSize() {
    return size;
  }

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  private Long lastModifiedById;

  public Long getLastModifiedById() {
    return lastModifiedById;
  }

  private Long lastModifiedByApiKeyId;

  public Long getLastModifiedByApiKeyId() {
    return lastModifiedByApiKeyId;
  }

  private Long lastModifiedByAutomationId;

  public Long getLastModifiedByAutomationId() {
    return lastModifiedByAutomationId;
  }

  private Long lastModifiedByBundleRegistrationId;

  public Long getLastModifiedByBundleRegistrationId() {
    return lastModifiedByBundleRegistrationId;
  }

  private Long lastModifiedByRemoteServerId;

  public Long getLastModifiedByRemoteServerId() {
    return lastModifiedByRemoteServerId;
  }

  private Long lastModifiedByRemoteServerSyncId;

  public Long getLastModifiedByRemoteServerSyncId() {
    return lastModifiedByRemoteServerSyncId;
  }

  private ZonedDateTime mtime;

  public ZonedDateTime getMtime() {
    return mtime;
  }

  private ZonedDateTime providedMtime;

  public ZonedDateTime getProvidedMtime() {
    return providedMtime;
  }

  private String crc32;

  public String getCrc32() {
    return crc32;
  }

  private String md5;

  public String getMd5() {
    return md5;
  }

  private String sha1;

  public String getSha1() {
    return sha1;
  }

  private String sha256;

  public String getSha256() {
    return sha256;
  }

  private String mimeType;

  public String getMimeType() {
    return mimeType;
  }

  private String region;

  public String getRegion() {
    return region;
  }

  private String permissions;

  public String getPermissions() {
    return permissions;
  }

  private boolean subfoldersLocked;

  public boolean getSubfoldersLocked() {
    return subfoldersLocked;
  }

  private boolean isLocked;

  public boolean getIsLocked() {
    return isLocked;
  }

  private String downloadUri;

  public String getDownloadUri() {
    return downloadUri;
  }

  private String priorityColor;

  public String getPriorityColor() {
    return priorityColor;
  }

  private Long previewId;

  public Long getPreviewId() {
    return previewId;
  }

  private PreviewModel preview;

  public PreviewModel getPreview() {
    return preview;
  }

  private boolean mkdirParents;

  public boolean getMkdirParents() {
    return mkdirParents;
  }

}
