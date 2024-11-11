package com.files.mule.api.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
    this.bundlepaths = bundle.bundlepaths != null ? Arrays.asList(bundle.bundlepaths) : null;
    this.password = bundle.password;
    this.formFieldSetId = bundle.formFieldSetId;
    this.createSnapshot = Boolean.TRUE.equals(bundle.createSnapshot);
    this.finalizeSnapshot = Boolean.TRUE.equals(bundle.finalizeSnapshot);
    this.watermarkAttachmentFile = bundle.watermarkAttachmentFile != null ? new ByteArrayInputStream(bundle.watermarkAttachmentFile) : null;
    this.watermarkAttachmentDelete = Boolean.TRUE.equals(bundle.watermarkAttachmentDelete);
  }

  private String code;

  public String getCode() {
    return code;
  }

  private String colorLeft;

  public String getColorLeft() {
    return colorLeft;
  }

  private String colorLink;

  public String getColorLink() {
    return colorLink;
  }

  private String colorText;

  public String getColorText() {
    return colorText;
  }

  private String colorTop;

  public String getColorTop() {
    return colorTop;
  }

  private String colorTopText;

  public String getColorTopText() {
    return colorTopText;
  }

  private String url;

  public String getUrl() {
    return url;
  }

  private String description;

  public String getDescription() {
    return description;
  }

  private ZonedDateTime expiresAt;

  public ZonedDateTime getExpiresAt() {
    return expiresAt;
  }

  private boolean passwordProtected;

  public boolean getPasswordProtected() {
    return passwordProtected;
  }

  private String permissions;

  public String getPermissions() {
    return permissions;
  }

  private boolean previewOnly;

  public boolean getPreviewOnly() {
    return previewOnly;
  }

  private boolean requireRegistration;

  public boolean getRequireRegistration() {
    return requireRegistration;
  }

  private boolean requireShareRecipient;

  public boolean getRequireShareRecipient() {
    return requireShareRecipient;
  }

  private boolean requireLogout;

  public boolean getRequireLogout() {
    return requireLogout;
  }

  private String clickwrapBody;

  public String getClickwrapBody() {
    return clickwrapBody;
  }

  private FormFieldSetModel formFieldSet;

  public FormFieldSetModel getFormFieldSet() {
    return formFieldSet;
  }

  private boolean skipName;

  public boolean getSkipName() {
    return skipName;
  }

  private boolean skipEmail;

  public boolean getSkipEmail() {
    return skipEmail;
  }

  private ZonedDateTime startAccessOnDate;

  public ZonedDateTime getStartAccessOnDate() {
    return startAccessOnDate;
  }

  private boolean skipCompany;

  public boolean getSkipCompany() {
    return skipCompany;
  }

  private Long id;

  public Long getId() {
    return id;
  }

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  private boolean dontSeparateSubmissionsByFolder;

  public boolean getDontSeparateSubmissionsByFolder() {
    return dontSeparateSubmissionsByFolder;
  }

  private Long maxUses;

  public Long getMaxUses() {
    return maxUses;
  }

  private String note;

  public String getNote() {
    return note;
  }

  private String pathTemplate;

  public String getPathTemplate() {
    return pathTemplate;
  }

  private String pathTemplateTimeZone;

  public String getPathTemplateTimeZone() {
    return pathTemplateTimeZone;
  }

  private boolean sendEmailReceiptToUploader;

  public boolean getSendEmailReceiptToUploader() {
    return sendEmailReceiptToUploader;
  }

  private Long snapshotId;

  public Long getSnapshotId() {
    return snapshotId;
  }

  private Long userId;

  public Long getUserId() {
    return userId;
  }

  private String username;

  public String getUsername() {
    return username;
  }

  private Long clickwrapId;

  public Long getClickwrapId() {
    return clickwrapId;
  }

  private Long inboxId;

  public Long getInboxId() {
    return inboxId;
  }

  private ImageModel watermarkAttachment;

  public ImageModel getWatermarkAttachment() {
    return watermarkAttachment;
  }

  private Map<String, String> watermarkValue;

  public Map<String, String> getWatermarkValue() {
    return watermarkValue;
  }

  private boolean hasInbox;

  public boolean getHasInbox() {
    return hasInbox;
  }

  private boolean dontAllowFoldersInUploads;

  public boolean getDontAllowFoldersInUploads() {
    return dontAllowFoldersInUploads;
  }

  private List<String> paths;

  public List<String> getPaths() {
    return paths;
  }

  private List<Object> bundlepaths;

  public List<Object> getBundlepaths() {
    return bundlepaths;
  }

  private String password;

  public String getPassword() {
    return password;
  }

  private Long formFieldSetId;

  public Long getFormFieldSetId() {
    return formFieldSetId;
  }

  private boolean createSnapshot;

  public boolean getCreateSnapshot() {
    return createSnapshot;
  }

  private boolean finalizeSnapshot;

  public boolean getFinalizeSnapshot() {
    return finalizeSnapshot;
  }

  private InputStream watermarkAttachmentFile;

  public InputStream getWatermarkAttachmentFile() {
    return watermarkAttachmentFile;
  }

  private boolean watermarkAttachmentDelete;

  public boolean getWatermarkAttachmentDelete() {
    return watermarkAttachmentDelete;
  }

}
