/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.files.models.Bundle;

/**
 * A Bundle is the API/SDK term for the feature called Share Links in the web interface.
 * The API provides the full set of actions related to Share Links, including sending them via E-Mail.
 *
 * Please note that we very closely monitor the E-Mailing feature and any abuse will result in disabling of your site.
 */
public class ShareLinkModel implements Serializable {
  public ShareLinkModel() {
  }

  public ShareLinkModel(final Bundle bundle) {
    initGroup1(bundle);
    initGroup2(bundle);
    initGroup3(bundle);
    initGroup4(bundle);
    initGroup5(bundle);
    initGroup6(bundle);
  }

  private void initGroup1(final Bundle bundle) {
    this.code = SdkFields.read(bundle, "code", String.class);
    this.colorLeft = SdkFields.read(bundle, "colorLeft", String.class);
    this.colorLink = SdkFields.read(bundle, "colorLink", String.class);
    this.colorText = SdkFields.read(bundle, "colorText", String.class);
    this.colorTop = SdkFields.read(bundle, "colorTop", String.class);
    this.colorTopText = SdkFields.read(bundle, "colorTopText", String.class);
    this.url = SdkFields.read(bundle, "url", String.class);
    this.description = SdkFields.read(bundle, "description", String.class);
    this.expiresAt = SdkFields.read(bundle, "expiresAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.passwordProtected = Boolean.TRUE.equals(SdkFields.read(bundle, "passwordProtected", Boolean.class));
  }

  private void initGroup2(final Bundle bundle) {
    this.permissions = SdkFields.read(bundle, "permissions", String.class);
    this.previewOnly = Boolean.TRUE.equals(SdkFields.read(bundle, "previewOnly", Boolean.class));
    this.requireRegistration = Boolean.TRUE.equals(SdkFields.read(bundle, "requireRegistration", Boolean.class));
    this.requireShareRecipient = Boolean.TRUE.equals(SdkFields.read(bundle, "requireShareRecipient", Boolean.class));
    this.requireLogout = Boolean.TRUE.equals(SdkFields.read(bundle, "requireLogout", Boolean.class));
    this.clickwrapBody = SdkFields.read(bundle, "clickwrapBody", String.class);
    this.formFieldSet = SdkFields.read(bundle, "formFieldSet", com.files.models.FormFieldSet.class, FormFieldSetModel::new);
    this.skipName = Boolean.TRUE.equals(SdkFields.read(bundle, "skipName", Boolean.class));
    this.skipEmail = Boolean.TRUE.equals(SdkFields.read(bundle, "skipEmail", Boolean.class));
    this.startAccessOnDate = SdkFields.read(bundle, "startAccessOnDate", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
  }

  private void initGroup3(final Bundle bundle) {
    this.skipCompany = Boolean.TRUE.equals(SdkFields.read(bundle, "skipCompany", Boolean.class));
    this.id = SdkFields.read(bundle, "id", Long.class);
    this.bypassesSiteExpirationRules = Boolean.TRUE.equals(SdkFields.read(bundle, "bypassesSiteExpirationRules", Boolean.class));
    this.createdAt = SdkFields.read(bundle, "createdAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.deleted = Boolean.TRUE.equals(SdkFields.read(bundle, "deleted", Boolean.class));
    this.deletedAt = SdkFields.read(bundle, "deletedAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.dontSeparateSubmissionsByFolder = Boolean.TRUE.equals(SdkFields.read(bundle, "dontSeparateSubmissionsByFolder", Boolean.class));
    this.effectiveExpiresAt = SdkFields.read(bundle, "effectiveExpiresAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.maxUses = SdkFields.read(bundle, "maxUses", Long.class);
    this.internalName = SdkFields.read(bundle, "internalName", String.class);
  }

  private void initGroup4(final Bundle bundle) {
    this.note = SdkFields.read(bundle, "note", String.class);
    this.pathTemplate = SdkFields.read(bundle, "pathTemplate", String.class);
    this.pathTemplateTimeZone = SdkFields.read(bundle, "pathTemplateTimeZone", String.class);
    this.sendEmailReceiptToUploader = Boolean.TRUE.equals(SdkFields.read(bundle, "sendEmailReceiptToUploader", Boolean.class));
    this.snapshotId = SdkFields.read(bundle, "snapshotId", Long.class);
    this.userId = SdkFields.read(bundle, "userId", Long.class);
    this.username = SdkFields.read(bundle, "username", String.class);
    this.groupId = SdkFields.read(bundle, "groupId", Long.class);
    this.clickwrapId = SdkFields.read(bundle, "clickwrapId", Long.class);
    this.inboxId = SdkFields.read(bundle, "inboxId", Long.class);
  }

  private void initGroup5(final Bundle bundle) {
    this.watermarkAttachment = SdkFields.read(bundle, "watermarkAttachment", com.files.models.Image.class, ImageModel::new);
    this.watermarkValue = SdkFields.read(bundle, "watermarkValue", Object.class);
    this.sendOneTimePasswordToRecipientAtRegistration = Boolean.TRUE.equals(SdkFields.read(bundle, "sendOneTimePasswordToRecipientAtRegistration", Boolean.class));
    this.workspaceId = SdkFields.read(bundle, "workspaceId", Long.class);
    this.hasInbox = Boolean.TRUE.equals(SdkFields.read(bundle, "hasInbox", Boolean.class));
    this.dontAllowFoldersInUploads = Boolean.TRUE.equals(SdkFields.read(bundle, "dontAllowFoldersInUploads", Boolean.class));
    this.paths = SdkFields.read(bundle, "paths", String[].class, Arrays::asList);
    this.password = SdkFields.read(bundle, "password", String.class);
    this.formFieldSetId = SdkFields.read(bundle, "formFieldSetId", Long.class);
    this.createSnapshot = Boolean.TRUE.equals(SdkFields.read(bundle, "createSnapshot", Boolean.class));
  }

  private void initGroup6(final Bundle bundle) {
    this.finalizeSnapshot = Boolean.TRUE.equals(SdkFields.read(bundle, "finalizeSnapshot", Boolean.class));
    this.watermarkAttachmentDelete = Boolean.TRUE.equals(SdkFields.read(bundle, "watermarkAttachmentDelete", Boolean.class));
  }

  private String code;

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  private String colorLeft;

  public String getColorLeft() {
    return colorLeft;
  }

  public void setColorLeft(final String colorLeft) {
    this.colorLeft = colorLeft;
  }

  private String colorLink;

  public String getColorLink() {
    return colorLink;
  }

  public void setColorLink(final String colorLink) {
    this.colorLink = colorLink;
  }

  private String colorText;

  public String getColorText() {
    return colorText;
  }

  public void setColorText(final String colorText) {
    this.colorText = colorText;
  }

  private String colorTop;

  public String getColorTop() {
    return colorTop;
  }

  public void setColorTop(final String colorTop) {
    this.colorTop = colorTop;
  }

  private String colorTopText;

  public String getColorTopText() {
    return colorTopText;
  }

  public void setColorTopText(final String colorTopText) {
    this.colorTopText = colorTopText;
  }

  private String url;

  public String getUrl() {
    return url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  private ZonedDateTime expiresAt;

  public ZonedDateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(final ZonedDateTime expiresAt) {
    this.expiresAt = expiresAt;
  }

  private boolean passwordProtected;

  public boolean getPasswordProtected() {
    return passwordProtected;
  }

  public void setPasswordProtected(final boolean passwordProtected) {
    this.passwordProtected = passwordProtected;
  }

  private String permissions;

  public String getPermissions() {
    return permissions;
  }

  public void setPermissions(final String permissions) {
    this.permissions = permissions;
  }

  private boolean previewOnly;

  public boolean getPreviewOnly() {
    return previewOnly;
  }

  public void setPreviewOnly(final boolean previewOnly) {
    this.previewOnly = previewOnly;
  }

  private boolean requireRegistration;

  public boolean getRequireRegistration() {
    return requireRegistration;
  }

  public void setRequireRegistration(final boolean requireRegistration) {
    this.requireRegistration = requireRegistration;
  }

  private boolean requireShareRecipient;

  public boolean getRequireShareRecipient() {
    return requireShareRecipient;
  }

  public void setRequireShareRecipient(final boolean requireShareRecipient) {
    this.requireShareRecipient = requireShareRecipient;
  }

  private boolean requireLogout;

  public boolean getRequireLogout() {
    return requireLogout;
  }

  public void setRequireLogout(final boolean requireLogout) {
    this.requireLogout = requireLogout;
  }

  private String clickwrapBody;

  public String getClickwrapBody() {
    return clickwrapBody;
  }

  public void setClickwrapBody(final String clickwrapBody) {
    this.clickwrapBody = clickwrapBody;
  }

  private FormFieldSetModel formFieldSet;

  public FormFieldSetModel getFormFieldSet() {
    return formFieldSet;
  }

  public void setFormFieldSet(final FormFieldSetModel formFieldSet) {
    this.formFieldSet = formFieldSet;
  }

  private boolean skipName;

  public boolean getSkipName() {
    return skipName;
  }

  public void setSkipName(final boolean skipName) {
    this.skipName = skipName;
  }

  private boolean skipEmail;

  public boolean getSkipEmail() {
    return skipEmail;
  }

  public void setSkipEmail(final boolean skipEmail) {
    this.skipEmail = skipEmail;
  }

  private ZonedDateTime startAccessOnDate;

  public ZonedDateTime getStartAccessOnDate() {
    return startAccessOnDate;
  }

  public void setStartAccessOnDate(final ZonedDateTime startAccessOnDate) {
    this.startAccessOnDate = startAccessOnDate;
  }

  private boolean skipCompany;

  public boolean getSkipCompany() {
    return skipCompany;
  }

  public void setSkipCompany(final boolean skipCompany) {
    this.skipCompany = skipCompany;
  }

  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  private boolean bypassesSiteExpirationRules;

  public boolean getBypassesSiteExpirationRules() {
    return bypassesSiteExpirationRules;
  }

  public void setBypassesSiteExpirationRules(final boolean bypassesSiteExpirationRules) {
    this.bypassesSiteExpirationRules = bypassesSiteExpirationRules;
  }

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  private boolean deleted;

  public boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(final boolean deleted) {
    this.deleted = deleted;
  }

  private ZonedDateTime deletedAt;

  public ZonedDateTime getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(final ZonedDateTime deletedAt) {
    this.deletedAt = deletedAt;
  }

  private boolean dontSeparateSubmissionsByFolder;

  public boolean getDontSeparateSubmissionsByFolder() {
    return dontSeparateSubmissionsByFolder;
  }

  public void setDontSeparateSubmissionsByFolder(final boolean dontSeparateSubmissionsByFolder) {
    this.dontSeparateSubmissionsByFolder = dontSeparateSubmissionsByFolder;
  }

  private ZonedDateTime effectiveExpiresAt;

  public ZonedDateTime getEffectiveExpiresAt() {
    return effectiveExpiresAt;
  }

  public void setEffectiveExpiresAt(final ZonedDateTime effectiveExpiresAt) {
    this.effectiveExpiresAt = effectiveExpiresAt;
  }

  private Long maxUses;

  public Long getMaxUses() {
    return maxUses;
  }

  public void setMaxUses(final Long maxUses) {
    this.maxUses = maxUses;
  }

  private String internalName;

  public String getInternalName() {
    return internalName;
  }

  public void setInternalName(final String internalName) {
    this.internalName = internalName;
  }

  private String note;

  public String getNote() {
    return note;
  }

  public void setNote(final String note) {
    this.note = note;
  }

  private String pathTemplate;

  public String getPathTemplate() {
    return pathTemplate;
  }

  public void setPathTemplate(final String pathTemplate) {
    this.pathTemplate = pathTemplate;
  }

  private String pathTemplateTimeZone;

  public String getPathTemplateTimeZone() {
    return pathTemplateTimeZone;
  }

  public void setPathTemplateTimeZone(final String pathTemplateTimeZone) {
    this.pathTemplateTimeZone = pathTemplateTimeZone;
  }

  private boolean sendEmailReceiptToUploader;

  public boolean getSendEmailReceiptToUploader() {
    return sendEmailReceiptToUploader;
  }

  public void setSendEmailReceiptToUploader(final boolean sendEmailReceiptToUploader) {
    this.sendEmailReceiptToUploader = sendEmailReceiptToUploader;
  }

  private Long snapshotId;

  public Long getSnapshotId() {
    return snapshotId;
  }

  public void setSnapshotId(final Long snapshotId) {
    this.snapshotId = snapshotId;
  }

  private Long userId;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  private Long groupId;

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(final Long groupId) {
    this.groupId = groupId;
  }

  private Long clickwrapId;

  public Long getClickwrapId() {
    return clickwrapId;
  }

  public void setClickwrapId(final Long clickwrapId) {
    this.clickwrapId = clickwrapId;
  }

  private Long inboxId;

  public Long getInboxId() {
    return inboxId;
  }

  public void setInboxId(final Long inboxId) {
    this.inboxId = inboxId;
  }

  private ImageModel watermarkAttachment;

  public ImageModel getWatermarkAttachment() {
    return watermarkAttachment;
  }

  public void setWatermarkAttachment(final ImageModel watermarkAttachment) {
    this.watermarkAttachment = watermarkAttachment;
  }

  private Object watermarkValue;

  public Object getWatermarkValue() {
    return watermarkValue;
  }

  public void setWatermarkValue(final Object watermarkValue) {
    this.watermarkValue = watermarkValue;
  }

  private boolean sendOneTimePasswordToRecipientAtRegistration;

  public boolean getSendOneTimePasswordToRecipientAtRegistration() {
    return sendOneTimePasswordToRecipientAtRegistration;
  }

  public void setSendOneTimePasswordToRecipientAtRegistration(final boolean sendOneTimePasswordToRecipientAtRegistration) {
    this.sendOneTimePasswordToRecipientAtRegistration = sendOneTimePasswordToRecipientAtRegistration;
  }

  private Long workspaceId;

  public Long getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(final Long workspaceId) {
    this.workspaceId = workspaceId;
  }

  private boolean hasInbox;

  public boolean getHasInbox() {
    return hasInbox;
  }

  public void setHasInbox(final boolean hasInbox) {
    this.hasInbox = hasInbox;
  }

  private boolean dontAllowFoldersInUploads;

  public boolean getDontAllowFoldersInUploads() {
    return dontAllowFoldersInUploads;
  }

  public void setDontAllowFoldersInUploads(final boolean dontAllowFoldersInUploads) {
    this.dontAllowFoldersInUploads = dontAllowFoldersInUploads;
  }

  private List<String> paths;

  public List<String> getPaths() {
    return paths;
  }

  public void setPaths(final List<String> paths) {
    this.paths = paths;
  }

  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  private Long formFieldSetId;

  public Long getFormFieldSetId() {
    return formFieldSetId;
  }

  public void setFormFieldSetId(final Long formFieldSetId) {
    this.formFieldSetId = formFieldSetId;
  }

  private boolean createSnapshot;

  public boolean getCreateSnapshot() {
    return createSnapshot;
  }

  public void setCreateSnapshot(final boolean createSnapshot) {
    this.createSnapshot = createSnapshot;
  }

  private boolean finalizeSnapshot;

  public boolean getFinalizeSnapshot() {
    return finalizeSnapshot;
  }

  public void setFinalizeSnapshot(final boolean finalizeSnapshot) {
    this.finalizeSnapshot = finalizeSnapshot;
  }

  private boolean watermarkAttachmentDelete;

  public boolean getWatermarkAttachmentDelete() {
    return watermarkAttachmentDelete;
  }

  public void setWatermarkAttachmentDelete(final boolean watermarkAttachmentDelete) {
    this.watermarkAttachmentDelete = watermarkAttachmentDelete;
  }

}
