/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.files.models.Folder;

/**
 * A File object represents a file or folder on your Files.com site. The `type` field is `file` for files and `directory` for folders.
 */
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
    this.path = SdkFields.read(folder, "path", String.class);
    this.createdById = SdkFields.read(folder, "createdById", Long.class);
    this.createdByApiKeyId = SdkFields.read(folder, "createdByApiKeyId", Long.class);
    this.createdByAs2IncomingMessageId = SdkFields.read(folder, "createdByAs2IncomingMessageId", Long.class);
    this.createdByAutomationId = SdkFields.read(folder, "createdByAutomationId", Long.class);
    this.createdByBundleRegistrationId = SdkFields.read(folder, "createdByBundleRegistrationId", Long.class);
    this.createdByInboxId = SdkFields.read(folder, "createdByInboxId", Long.class);
    this.createdByRemoteServerId = SdkFields.read(folder, "createdByRemoteServerId", Long.class);
    this.createdBySyncId = SdkFields.read(folder, "createdBySyncId", Long.class);
    this.customMetadata = SdkFields.read(folder, "customMetadata", Object.class);
  }

  private void initGroup2(final Folder folder) {
    this.displayName = SdkFields.read(folder, "displayName", String.class);
    this.fileType = SdkFields.read(folder, "type", String.class);
    this.size = SdkFields.read(folder, "size", Long.class);
    this.createdAt = SdkFields.read(folder, "createdAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.lastModifiedById = SdkFields.read(folder, "lastModifiedById", Long.class);
    this.lastModifiedByApiKeyId = SdkFields.read(folder, "lastModifiedByApiKeyId", Long.class);
    this.lastModifiedByAutomationId = SdkFields.read(folder, "lastModifiedByAutomationId", Long.class);
    this.lastModifiedByBundleRegistrationId = SdkFields.read(folder, "lastModifiedByBundleRegistrationId", Long.class);
    this.lastModifiedByRemoteServerId = SdkFields.read(folder, "lastModifiedByRemoteServerId", Long.class);
    this.lastModifiedBySyncId = SdkFields.read(folder, "lastModifiedBySyncId", Long.class);
  }

  private void initGroup3(final Folder folder) {
    this.mtime = SdkFields.read(folder, "mtime", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.providedMtime = SdkFields.read(folder, "providedMtime", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.crc32 = SdkFields.read(folder, "crc32", String.class);
    this.md5 = SdkFields.read(folder, "md5", String.class);
    this.sha1 = SdkFields.read(folder, "sha1", String.class);
    this.sha256 = SdkFields.read(folder, "sha256", String.class);
    this.mimeType = SdkFields.read(folder, "mimeType", String.class);
    this.region = SdkFields.read(folder, "region", String.class);
    this.permissions = SdkFields.read(folder, "permissions", String.class);
    this.subfoldersLocked = Boolean.TRUE.equals(SdkFields.read(folder, "subfoldersLocked", Boolean.class));
  }

  private void initGroup4(final Folder folder) {
    this.isLocked = Boolean.TRUE.equals(SdkFields.read(folder, "isLocked", Boolean.class));
    this.downloadUri = SdkFields.read(folder, "downloadUri", String.class);
    this.directConnectionInfo = SdkFields.read(folder, "directConnectionInfo", com.files.models.DirectConnectionInfo.class, DirectConnectionInfoModel::new);
    this.priorityColor = SdkFields.read(folder, "priorityColor", String.class);
    this.previewId = SdkFields.read(folder, "previewId", Long.class);
    this.preview = SdkFields.read(folder, "preview", com.files.models.Preview.class, PreviewModel::new);
    this.mkdirParents = Boolean.TRUE.equals(SdkFields.read(folder, "mkdirParents", Boolean.class));
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

  private Object customMetadata;

  public Object getCustomMetadata() {
    return customMetadata;
  }

  public void setCustomMetadata(final Object customMetadata) {
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

  private DirectConnectionInfoModel directConnectionInfo;

  public DirectConnectionInfoModel getDirectConnectionInfo() {
    return directConnectionInfo;
  }

  public void setDirectConnectionInfo(final DirectConnectionInfoModel directConnectionInfo) {
    this.directConnectionInfo = directConnectionInfo;
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
