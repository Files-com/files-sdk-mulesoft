/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Map;

import com.files.models.File;

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
    this.path = file.path;
    this.createdById = file.createdById;
    this.createdByApiKeyId = file.createdByApiKeyId;
    this.createdByAs2IncomingMessageId = file.createdByAs2IncomingMessageId;
    this.createdByAutomationId = file.createdByAutomationId;
    this.createdByBundleRegistrationId = file.createdByBundleRegistrationId;
    this.createdByInboxId = file.createdByInboxId;
    this.createdByRemoteServerId = file.createdByRemoteServerId;
    this.createdBySyncId = file.createdBySyncId;
    this.customMetadata = file.customMetadata;
  }

  private void initGroup2(final File file) {
    this.displayName = file.displayName;
    this.fileType = file.type;
    this.size = file.size;
    this.createdAt = file.createdAt != null ? ZonedDateTime.ofInstant(file.createdAt.toInstant(), ZoneId.systemDefault()) : null;
    this.lastModifiedById = file.lastModifiedById;
    this.lastModifiedByApiKeyId = file.lastModifiedByApiKeyId;
    this.lastModifiedByAutomationId = file.lastModifiedByAutomationId;
    this.lastModifiedByBundleRegistrationId = file.lastModifiedByBundleRegistrationId;
    this.lastModifiedByRemoteServerId = file.lastModifiedByRemoteServerId;
    this.lastModifiedBySyncId = file.lastModifiedBySyncId;
  }

  private void initGroup3(final File file) {
    this.mtime = file.mtime != null ? ZonedDateTime.ofInstant(file.mtime.toInstant(), ZoneId.systemDefault()) : null;
    this.providedMtime = file.providedMtime != null ? ZonedDateTime.ofInstant(file.providedMtime.toInstant(), ZoneId.systemDefault()) : null;
    this.crc32 = file.crc32;
    this.md5 = file.md5;
    this.sha1 = file.sha1;
    this.sha256 = file.sha256;
    this.mimeType = file.mimeType;
    this.region = file.region;
    this.permissions = file.permissions;
    this.subfoldersLocked = Boolean.TRUE.equals(file.subfoldersLocked);
  }

  private void initGroup4(final File file) {
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
  }

  private void initGroup5(final File file) {
    this.ref = file.ref;
    this.restart = file.restart;
    this.structure = file.structure;
    this.withRename = Boolean.TRUE.equals(file.withRename);
    this.bufferedUpload = Boolean.TRUE.equals(file.bufferedUpload);
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

}
