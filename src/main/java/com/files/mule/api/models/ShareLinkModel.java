/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
  }

  private void initGroup1(final Bundle bundle) {
    this.code = bundle.code;
    this.colorLeft = bundle.colorLeft;
    this.colorLink = bundle.colorLink;
    this.colorText = bundle.colorText;
    this.colorTop = bundle.colorTop;
    this.colorTopText = bundle.colorTopText;
    this.url = bundle.url;
    this.description = bundle.description;
    this.expiresAt = bundle.expiresAt != null ? ZonedDateTime.ofInstant(bundle.expiresAt.toInstant(), ZoneId.systemDefault()) : null;
    this.passwordProtected = Boolean.TRUE.equals(bundle.passwordProtected);
  }

  private void initGroup2(final Bundle bundle) {
    this.permissions = bundle.permissions;
    this.previewOnly = Boolean.TRUE.equals(bundle.previewOnly);
    this.requireRegistration = Boolean.TRUE.equals(bundle.requireRegistration);
    this.requireShareRecipient = Boolean.TRUE.equals(bundle.requireShareRecipient);
    this.requireLogout = Boolean.TRUE.equals(bundle.requireLogout);
    this.clickwrapBody = bundle.clickwrapBody;
    if (bundle.formFieldSet != null) {
      this.formFieldSet = new FormFieldSetModel(bundle.formFieldSet);
    }
    this.skipName = Boolean.TRUE.equals(bundle.skipName);
    this.skipEmail = Boolean.TRUE.equals(bundle.skipEmail);
    this.startAccessOnDate = bundle.startAccessOnDate != null ? ZonedDateTime.ofInstant(bundle.startAccessOnDate.toInstant(), ZoneId.systemDefault()) : null;
  }

  private void initGroup3(final Bundle bundle) {
    this.skipCompany = Boolean.TRUE.equals(bundle.skipCompany);
    this.id = bundle.id;
    this.createdAt = bundle.createdAt != null ? ZonedDateTime.ofInstant(bundle.createdAt.toInstant(), ZoneId.systemDefault()) : null;
    this.dontSeparateSubmissionsByFolder = Boolean.TRUE.equals(bundle.dontSeparateSubmissionsByFolder);
    this.maxUses = bundle.maxUses;
    this.note = bundle.note;
    this.pathTemplate = bundle.pathTemplate;
    this.pathTemplateTimeZone = bundle.pathTemplateTimeZone;
    this.sendEmailReceiptToUploader = Boolean.TRUE.equals(bundle.sendEmailReceiptToUploader);
    this.snapshotId = bundle.snapshotId;
  }

  private void initGroup4(final Bundle bundle) {
    this.userId = bundle.userId;
    this.username = bundle.username;
    this.clickwrapId = bundle.clickwrapId;
    this.inboxId = bundle.inboxId;
    if (bundle.watermarkAttachment != null) {
      this.watermarkAttachment = new ImageModel(bundle.watermarkAttachment);
    }
    this.watermarkValue = bundle.watermarkValue;
    this.hasInbox = Boolean.TRUE.equals(bundle.hasInbox);
    this.dontAllowFoldersInUploads = Boolean.TRUE.equals(bundle.dontAllowFoldersInUploads);
    this.paths = bundle.paths != null ? Arrays.asList(bundle.paths) : null;
    this.password = bundle.password;
  }

  private void initGroup5(final Bundle bundle) {
    this.formFieldSetId = bundle.formFieldSetId;
    this.createSnapshot = Boolean.TRUE.equals(bundle.createSnapshot);
    this.finalizeSnapshot = Boolean.TRUE.equals(bundle.finalizeSnapshot);
    this.watermarkAttachmentDelete = Boolean.TRUE.equals(bundle.watermarkAttachmentDelete);
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

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  private boolean dontSeparateSubmissionsByFolder;

  public boolean getDontSeparateSubmissionsByFolder() {
    return dontSeparateSubmissionsByFolder;
  }

  public void setDontSeparateSubmissionsByFolder(final boolean dontSeparateSubmissionsByFolder) {
    this.dontSeparateSubmissionsByFolder = dontSeparateSubmissionsByFolder;
  }

  private Long maxUses;

  public Long getMaxUses() {
    return maxUses;
  }

  public void setMaxUses(final Long maxUses) {
    this.maxUses = maxUses;
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

  private Map<String, String> watermarkValue;

  public Map<String, String> getWatermarkValue() {
    return watermarkValue;
  }

  public void setWatermarkValue(final Map<String, String> watermarkValue) {
    this.watermarkValue = watermarkValue;
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
