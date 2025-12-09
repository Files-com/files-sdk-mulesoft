/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Map;

import com.files.models.Folder;

public class FolderModel implements Serializable {
  public FolderModel() {
  }

  public FolderModel(final Folder folder) {
    initGroup1(folder);
    initGroup2(folder);
    initGroup3(folder);
    initGroup4(folder);
  }

  private void initGroup1(final Folder folder) {
    this.path = folder.path;
    this.createdById = folder.createdById;
    this.createdByApiKeyId = folder.createdByApiKeyId;
    this.createdByAs2IncomingMessageId = folder.createdByAs2IncomingMessageId;
    this.createdByAutomationId = folder.createdByAutomationId;
    this.createdByBundleRegistrationId = folder.createdByBundleRegistrationId;
    this.createdByInboxId = folder.createdByInboxId;
    this.createdByRemoteServerId = folder.createdByRemoteServerId;
    this.createdBySyncId = folder.createdBySyncId;
    this.customMetadata = folder.customMetadata;
  }

  private void initGroup2(final Folder folder) {
    this.displayName = folder.displayName;
    this.fileType = folder.type;
    this.size = folder.size;
    this.createdAt = folder.createdAt != null ? ZonedDateTime.ofInstant(folder.createdAt.toInstant(), ZoneId.systemDefault()) : null;
    this.lastModifiedById = folder.lastModifiedById;
    this.lastModifiedByApiKeyId = folder.lastModifiedByApiKeyId;
    this.lastModifiedByAutomationId = folder.lastModifiedByAutomationId;
    this.lastModifiedByBundleRegistrationId = folder.lastModifiedByBundleRegistrationId;
    this.lastModifiedByRemoteServerId = folder.lastModifiedByRemoteServerId;
    this.lastModifiedBySyncId = folder.lastModifiedBySyncId;
  }

  private void initGroup3(final Folder folder) {
    this.mtime = folder.mtime != null ? ZonedDateTime.ofInstant(folder.mtime.toInstant(), ZoneId.systemDefault()) : null;
    this.providedMtime = folder.providedMtime != null ? ZonedDateTime.ofInstant(folder.providedMtime.toInstant(), ZoneId.systemDefault()) : null;
    this.crc32 = folder.crc32;
    this.md5 = folder.md5;
    this.sha1 = folder.sha1;
    this.sha256 = folder.sha256;
    this.mimeType = folder.mimeType;
    this.region = folder.region;
    this.permissions = folder.permissions;
    this.subfoldersLocked = Boolean.TRUE.equals(folder.subfoldersLocked);
  }

  private void initGroup4(final Folder folder) {
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

  public void setPath(final String path) {
    this.path = path;
  }

  private Long createdById;

  public Long getCreatedById() {
    return createdById;
  }

  public void setCreatedById(final Long createdById) {
    this.createdById = createdById;
  }

  private Long createdByApiKeyId;

  public Long getCreatedByApiKeyId() {
    return createdByApiKeyId;
  }

  public void setCreatedByApiKeyId(final Long createdByApiKeyId) {
    this.createdByApiKeyId = createdByApiKeyId;
  }

  private Long createdByAs2IncomingMessageId;

  public Long getCreatedByAs2IncomingMessageId() {
    return createdByAs2IncomingMessageId;
  }

  public void setCreatedByAs2IncomingMessageId(final Long createdByAs2IncomingMessageId) {
    this.createdByAs2IncomingMessageId = createdByAs2IncomingMessageId;
  }

  private Long createdByAutomationId;

  public Long getCreatedByAutomationId() {
    return createdByAutomationId;
  }

  public void setCreatedByAutomationId(final Long createdByAutomationId) {
    this.createdByAutomationId = createdByAutomationId;
  }

  private Long createdByBundleRegistrationId;

  public Long getCreatedByBundleRegistrationId() {
    return createdByBundleRegistrationId;
  }

  public void setCreatedByBundleRegistrationId(final Long createdByBundleRegistrationId) {
    this.createdByBundleRegistrationId = createdByBundleRegistrationId;
  }

  private Long createdByInboxId;

  public Long getCreatedByInboxId() {
    return createdByInboxId;
  }

  public void setCreatedByInboxId(final Long createdByInboxId) {
    this.createdByInboxId = createdByInboxId;
  }

  private Long createdByRemoteServerId;

  public Long getCreatedByRemoteServerId() {
    return createdByRemoteServerId;
  }

  public void setCreatedByRemoteServerId(final Long createdByRemoteServerId) {
    this.createdByRemoteServerId = createdByRemoteServerId;
  }

  private Long createdBySyncId;

  public Long getCreatedBySyncId() {
    return createdBySyncId;
  }

  public void setCreatedBySyncId(final Long createdBySyncId) {
    this.createdBySyncId = createdBySyncId;
  }

  private Map<String, String> customMetadata;

  public Map<String, String> getCustomMetadata() {
    return customMetadata;
  }

  public void setCustomMetadata(final Map<String, String> customMetadata) {
    this.customMetadata = customMetadata;
  }

  private String displayName;

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(final String displayName) {
    this.displayName = displayName;
  }

  private String fileType;

  public String getFileType() {
    return fileType;
  }

  public void setFileType(final String fileType) {
    this.fileType = fileType;
  }

  private Long size;

  public Long getSize() {
    return size;
  }

  public void setSize(final Long size) {
    this.size = size;
  }

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  private Long lastModifiedById;

  public Long getLastModifiedById() {
    return lastModifiedById;
  }

  public void setLastModifiedById(final Long lastModifiedById) {
    this.lastModifiedById = lastModifiedById;
  }

  private Long lastModifiedByApiKeyId;

  public Long getLastModifiedByApiKeyId() {
    return lastModifiedByApiKeyId;
  }

  public void setLastModifiedByApiKeyId(final Long lastModifiedByApiKeyId) {
    this.lastModifiedByApiKeyId = lastModifiedByApiKeyId;
  }

  private Long lastModifiedByAutomationId;

  public Long getLastModifiedByAutomationId() {
    return lastModifiedByAutomationId;
  }

  public void setLastModifiedByAutomationId(final Long lastModifiedByAutomationId) {
    this.lastModifiedByAutomationId = lastModifiedByAutomationId;
  }

  private Long lastModifiedByBundleRegistrationId;

  public Long getLastModifiedByBundleRegistrationId() {
    return lastModifiedByBundleRegistrationId;
  }

  public void setLastModifiedByBundleRegistrationId(final Long lastModifiedByBundleRegistrationId) {
    this.lastModifiedByBundleRegistrationId = lastModifiedByBundleRegistrationId;
  }

  private Long lastModifiedByRemoteServerId;

  public Long getLastModifiedByRemoteServerId() {
    return lastModifiedByRemoteServerId;
  }

  public void setLastModifiedByRemoteServerId(final Long lastModifiedByRemoteServerId) {
    this.lastModifiedByRemoteServerId = lastModifiedByRemoteServerId;
  }

  private Long lastModifiedBySyncId;

  public Long getLastModifiedBySyncId() {
    return lastModifiedBySyncId;
  }

  public void setLastModifiedBySyncId(final Long lastModifiedBySyncId) {
    this.lastModifiedBySyncId = lastModifiedBySyncId;
  }

  private ZonedDateTime mtime;

  public ZonedDateTime getMtime() {
    return mtime;
  }

  public void setMtime(final ZonedDateTime mtime) {
    this.mtime = mtime;
  }

  private ZonedDateTime providedMtime;

  public ZonedDateTime getProvidedMtime() {
    return providedMtime;
  }

  public void setProvidedMtime(final ZonedDateTime providedMtime) {
    this.providedMtime = providedMtime;
  }

  private String crc32;

  public String getCrc32() {
    return crc32;
  }

  public void setCrc32(final String crc32) {
    this.crc32 = crc32;
  }

  private String md5;

  public String getMd5() {
    return md5;
  }

  public void setMd5(final String md5) {
    this.md5 = md5;
  }

  private String sha1;

  public String getSha1() {
    return sha1;
  }

  public void setSha1(final String sha1) {
    this.sha1 = sha1;
  }

  private String sha256;

  public String getSha256() {
    return sha256;
  }

  public void setSha256(final String sha256) {
    this.sha256 = sha256;
  }

  private String mimeType;

  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(final String mimeType) {
    this.mimeType = mimeType;
  }

  private String region;

  public String getRegion() {
    return region;
  }

  public void setRegion(final String region) {
    this.region = region;
  }

  private String permissions;

  public String getPermissions() {
    return permissions;
  }

  public void setPermissions(final String permissions) {
    this.permissions = permissions;
  }

  private boolean subfoldersLocked;

  public boolean getSubfoldersLocked() {
    return subfoldersLocked;
  }

  public void setSubfoldersLocked(final boolean subfoldersLocked) {
    this.subfoldersLocked = subfoldersLocked;
  }

  private boolean isLocked;

  public boolean getIsLocked() {
    return isLocked;
  }

  public void setIsLocked(final boolean isLocked) {
    this.isLocked = isLocked;
  }

  private String downloadUri;

  public String getDownloadUri() {
    return downloadUri;
  }

  public void setDownloadUri(final String downloadUri) {
    this.downloadUri = downloadUri;
  }

  private String priorityColor;

  public String getPriorityColor() {
    return priorityColor;
  }

  public void setPriorityColor(final String priorityColor) {
    this.priorityColor = priorityColor;
  }

  private Long previewId;

  public Long getPreviewId() {
    return previewId;
  }

  public void setPreviewId(final Long previewId) {
    this.previewId = previewId;
  }

  private PreviewModel preview;

  public PreviewModel getPreview() {
    return preview;
  }

  public void setPreview(final PreviewModel preview) {
    this.preview = preview;
  }

  private boolean mkdirParents;

  public boolean getMkdirParents() {
    return mkdirParents;
  }

  public void setMkdirParents(final boolean mkdirParents) {
    this.mkdirParents = mkdirParents;
  }

}
