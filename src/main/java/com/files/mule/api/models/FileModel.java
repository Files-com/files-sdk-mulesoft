/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.files.models.File;

/**
 * A File object represents a file or folder on your Files.com site. The `type` field is `file` for files and `directory` for folders.
 */
public class FileModel implements Serializable {
  public FileModel() {
  }

  public FileModel(final File file) {
    initGroup1(file);
    initGroup2(file);
    initGroup3(file);
    initGroup4(file);
    initGroup5(file);
  }

  private void initGroup1(final File file) {
    this.path = SdkFields.read(file, "path", String.class);
    this.createdById = SdkFields.read(file, "createdById", Long.class);
    this.createdByApiKeyId = SdkFields.read(file, "createdByApiKeyId", Long.class);
    this.createdByAs2IncomingMessageId = SdkFields.read(file, "createdByAs2IncomingMessageId", Long.class);
    this.createdByAutomationId = SdkFields.read(file, "createdByAutomationId", Long.class);
    this.createdByBundleRegistrationId = SdkFields.read(file, "createdByBundleRegistrationId", Long.class);
    this.createdByInboxId = SdkFields.read(file, "createdByInboxId", Long.class);
    this.createdByRemoteServerId = SdkFields.read(file, "createdByRemoteServerId", Long.class);
    this.createdBySyncId = SdkFields.read(file, "createdBySyncId", Long.class);
    this.customMetadata = SdkFields.read(file, "customMetadata", Object.class);
  }

  private void initGroup2(final File file) {
    this.displayName = SdkFields.read(file, "displayName", String.class);
    this.fileType = SdkFields.read(file, "type", String.class);
    this.size = SdkFields.read(file, "size", Long.class);
    this.createdAt = SdkFields.read(file, "createdAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.lastModifiedById = SdkFields.read(file, "lastModifiedById", Long.class);
    this.lastModifiedByApiKeyId = SdkFields.read(file, "lastModifiedByApiKeyId", Long.class);
    this.lastModifiedByAutomationId = SdkFields.read(file, "lastModifiedByAutomationId", Long.class);
    this.lastModifiedByBundleRegistrationId = SdkFields.read(file, "lastModifiedByBundleRegistrationId", Long.class);
    this.lastModifiedByRemoteServerId = SdkFields.read(file, "lastModifiedByRemoteServerId", Long.class);
    this.lastModifiedBySyncId = SdkFields.read(file, "lastModifiedBySyncId", Long.class);
  }

  private void initGroup3(final File file) {
    this.mtime = SdkFields.read(file, "mtime", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.providedMtime = SdkFields.read(file, "providedMtime", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.crc32 = SdkFields.read(file, "crc32", String.class);
    this.md5 = SdkFields.read(file, "md5", String.class);
    this.sha1 = SdkFields.read(file, "sha1", String.class);
    this.sha256 = SdkFields.read(file, "sha256", String.class);
    this.mimeType = SdkFields.read(file, "mimeType", String.class);
    this.region = SdkFields.read(file, "region", String.class);
    this.permissions = SdkFields.read(file, "permissions", String.class);
    this.subfoldersLocked = Boolean.TRUE.equals(SdkFields.read(file, "subfoldersLocked", Boolean.class));
  }

  private void initGroup4(final File file) {
    this.isLocked = Boolean.TRUE.equals(SdkFields.read(file, "isLocked", Boolean.class));
    this.downloadUri = SdkFields.read(file, "downloadUri", String.class);
    this.directConnectionInfo = SdkFields.read(file, "directConnectionInfo", com.files.models.DirectConnectionInfo.class, DirectConnectionInfoModel::new);
    this.priorityColor = SdkFields.read(file, "priorityColor", String.class);
    this.previewId = SdkFields.read(file, "previewId", Long.class);
    this.preview = SdkFields.read(file, "preview", com.files.models.Preview.class, PreviewModel::new);
    this.action = SdkFields.read(file, "action", String.class);
    this.length = SdkFields.read(file, "length", Long.class);
    this.mkdirParents = Boolean.TRUE.equals(SdkFields.read(file, "mkdirParents", Boolean.class));
    this.part = SdkFields.read(file, "part", Long.class);
  }

  private void initGroup5(final File file) {
    this.parts = SdkFields.read(file, "parts", Long.class);
    this.ref = SdkFields.read(file, "ref", String.class);
    this.restart = SdkFields.read(file, "restart", Long.class);
    this.copyBehaviors = Boolean.TRUE.equals(SdkFields.read(file, "copyBehaviors", Boolean.class));
    this.structure = SdkFields.read(file, "structure", String.class);
    this.withRename = Boolean.TRUE.equals(SdkFields.read(file, "withRename", Boolean.class));
    this.bufferedUpload = Boolean.TRUE.equals(SdkFields.read(file, "bufferedUpload", Boolean.class));
    this.withDirectConnectionInfo = Boolean.TRUE.equals(SdkFields.read(file, "withDirectConnectionInfo", Boolean.class));
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

  private String action;

  public String getAction() {
    return action;
  }

  public void setAction(final String action) {
    this.action = action;
  }

  private Long length;

  public Long getLength() {
    return length;
  }

  public void setLength(final Long length) {
    this.length = length;
  }

  private boolean mkdirParents;

  public boolean getMkdirParents() {
    return mkdirParents;
  }

  public void setMkdirParents(final boolean mkdirParents) {
    this.mkdirParents = mkdirParents;
  }

  private Long part;

  public Long getPart() {
    return part;
  }

  public void setPart(final Long part) {
    this.part = part;
  }

  private Long parts;

  public Long getParts() {
    return parts;
  }

  public void setParts(final Long parts) {
    this.parts = parts;
  }

  private String ref;

  public String getRef() {
    return ref;
  }

  public void setRef(final String ref) {
    this.ref = ref;
  }

  private Long restart;

  public Long getRestart() {
    return restart;
  }

  public void setRestart(final Long restart) {
    this.restart = restart;
  }

  private boolean copyBehaviors;

  public boolean getCopyBehaviors() {
    return copyBehaviors;
  }

  public void setCopyBehaviors(final boolean copyBehaviors) {
    this.copyBehaviors = copyBehaviors;
  }

  private String structure;

  public String getStructure() {
    return structure;
  }

  public void setStructure(final String structure) {
    this.structure = structure;
  }

  private boolean withRename;

  public boolean getWithRename() {
    return withRename;
  }

  public void setWithRename(final boolean withRename) {
    this.withRename = withRename;
  }

  private boolean bufferedUpload;

  public boolean getBufferedUpload() {
    return bufferedUpload;
  }

  public void setBufferedUpload(final boolean bufferedUpload) {
    this.bufferedUpload = bufferedUpload;
  }

  private boolean withDirectConnectionInfo;

  public boolean getWithDirectConnectionInfo() {
    return withDirectConnectionInfo;
  }

  public void setWithDirectConnectionInfo(final boolean withDirectConnectionInfo) {
    this.withDirectConnectionInfo = withDirectConnectionInfo;
  }

}
