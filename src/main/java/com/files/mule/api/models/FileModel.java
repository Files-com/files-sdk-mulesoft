package com.files.mule.api.models;

import java.time.ZonedDateTime;
import java.util.Map;

import com.files.models.File;

public class FileModel extends AbstractModel {
  public FileModel() {
  }

  public FileModel(final File file) {
    this.path = file.path;
    this.createdById = file.createdById;
    this.createdByApiKeyId = file.createdByApiKeyId;
    this.createdByAs2IncomingMessageId = file.createdByAs2IncomingMessageId;
    this.createdByAutomationId = file.createdByAutomationId;
    this.createdByBundleRegistrationId = file.createdByBundleRegistrationId;
    this.createdByInboxId = file.createdByInboxId;
    this.createdByRemoteServerId = file.createdByRemoteServerId;
    this.createdByRemoteServerSyncId = file.createdByRemoteServerSyncId;
    this.customMetadata = file.customMetadata;
    this.displayName = file.displayName;
    this.type = file.type;
    this.size = file.size;
    this.createdAt = toZonedDateTime(file.createdAt);
    this.lastModifiedById = file.lastModifiedById;
    this.lastModifiedByApiKeyId = file.lastModifiedByApiKeyId;
    this.lastModifiedByAutomationId = file.lastModifiedByAutomationId;
    this.lastModifiedByBundleRegistrationId = file.lastModifiedByBundleRegistrationId;
    this.lastModifiedByRemoteServerId = file.lastModifiedByRemoteServerId;
    this.lastModifiedByRemoteServerSyncId = file.lastModifiedByRemoteServerSyncId;
    this.mtime = toZonedDateTime(file.mtime);
    this.providedMtime = toZonedDateTime(file.providedMtime);
    this.crc32 = file.crc32;
    this.md5 = file.md5;
    this.sha1 = file.sha1;
    this.sha256 = file.sha256;
    this.mimeType = file.mimeType;
    this.region = file.region;
    this.permissions = file.permissions;
    this.subfoldersLocked = Boolean.TRUE.equals(file.subfoldersLocked);
    this.isLocked = Boolean.TRUE.equals(file.isLocked);
    this.downloadUri = file.downloadUri;
    this.priorityColor = file.priorityColor;
    this.previewId = file.previewId;
    if (file.preview != null) {
      this.preview = new PreviewModel(file.preview);
    }
    this.action = file.action;
    this.length = file.length;
    this.mkdirParents = Boolean.TRUE.equals(file.mkdirParents);
    this.part = file.part;
    this.parts = file.parts;
    this.ref = file.ref;
    this.restart = file.restart;
    this.structure = file.structure;
    this.withRename = Boolean.TRUE.equals(file.withRename);
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

  private String action;

  public String getAction() {
    return action;
  }

  private Long length;

  public Long getLength() {
    return length;
  }

  private boolean mkdirParents;

  public boolean getMkdirParents() {
    return mkdirParents;
  }

  private Long part;

  public Long getPart() {
    return part;
  }

  private Long parts;

  public Long getParts() {
    return parts;
  }

  private String ref;

  public String getRef() {
    return ref;
  }

  private Long restart;

  public Long getRestart() {
    return restart;
  }

  private String structure;

  public String getStructure() {
    return structure;
  }

  private boolean withRename;

  public boolean getWithRename() {
    return withRename;
  }

}
