package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

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
    this.expiresAt = bundle.expiresAt;
    this.passwordProtected = bundle.passwordProtected;
    this.permissions = bundle.permissions;
    this.previewOnly = bundle.previewOnly;
    this.requireRegistration = bundle.requireRegistration;
    this.requireShareRecipient = bundle.requireShareRecipient;
    this.requireLogout = bundle.requireLogout;
    this.clickwrapBody = bundle.clickwrapBody;
    if (bundle.formFieldSet != null) {
      this.formFieldSet = new FormFieldSetModel(bundle.formFieldSet);
    }
    this.skipName = bundle.skipName;
    this.skipEmail = bundle.skipEmail;
    this.startAccessOnDate = bundle.startAccessOnDate;
    this.skipCompany = bundle.skipCompany;
    this.id = bundle.id;
    this.createdAt = bundle.createdAt;
    this.dontSeparateSubmissionsByFolder = bundle.dontSeparateSubmissionsByFolder;
    this.maxUses = bundle.maxUses;
    this.note = bundle.note;
    this.pathTemplate = bundle.pathTemplate;
    this.pathTemplateTimeZone = bundle.pathTemplateTimeZone;
    this.sendEmailReceiptToUploader = bundle.sendEmailReceiptToUploader;
    this.snapshotId = bundle.snapshotId;
    this.userId = bundle.userId;
    this.username = bundle.username;
    this.clickwrapId = bundle.clickwrapId;
    this.inboxId = bundle.inboxId;
    if (bundle.watermarkAttachment != null) {
      this.watermarkAttachment = new ImageModel(bundle.watermarkAttachment);
    }
    this.watermarkValue = bundle.watermarkValue;
    this.hasInbox = bundle.hasInbox;
    this.paths = bundle.paths;
    this.bundlepaths = bundle.bundlepaths;
    this.password = bundle.password;
    this.formFieldSetId = bundle.formFieldSetId;
    this.createSnapshot = bundle.createSnapshot;
    this.finalizeSnapshot = bundle.finalizeSnapshot;
    this.watermarkAttachmentFile = bundle.watermarkAttachmentFile;
    this.watermarkAttachmentDelete = bundle.watermarkAttachmentDelete;
  }

  /**
   * Bundle code.  This code forms the end part of the Public URL.
   */
  @Parameter
  public String code;

  public String getCode() {
    return code;
  }

  /**
   * Page link and button color
   */
  @Parameter
  public String colorLeft;

  public String getColorLeft() {
    return colorLeft;
  }

  /**
   * Top bar link color
   */
  @Parameter
  public String colorLink;

  public String getColorLink() {
    return colorLink;
  }

  /**
   * Page link and button color
   */
  @Parameter
  public String colorText;

  public String getColorText() {
    return colorText;
  }

  /**
   * Top bar background color
   */
  @Parameter
  public String colorTop;

  public String getColorTop() {
    return colorTop;
  }

  /**
   * Top bar text color
   */
  @Parameter
  public String colorTopText;

  public String getColorTopText() {
    return colorTopText;
  }

  /**
   * Public URL of Share Link
   */
  @Parameter
  public String url;

  public String getUrl() {
    return url;
  }

  /**
   * Public description
   */
  @Parameter
  public String description;

  public String getDescription() {
    return description;
  }

  /**
   * Bundle expiration date/time
   */
  @Parameter
  public Date expiresAt;

  public Date getExpiresAt() {
    return expiresAt;
  }

  /**
   * Is this bundle password protected?
   */
  @Parameter
  public Boolean passwordProtected;

  public Boolean getPasswordProtected() {
    return passwordProtected;
  }

  /**
   * Permissions that apply to Folders in this Share Link.
   */
  @Parameter
  public String permissions;

  public String getPermissions() {
    return permissions;
  }

  /**
   */
  @Parameter
  public Boolean previewOnly;

  public Boolean getPreviewOnly() {
    return previewOnly;
  }

  /**
   * Show a registration page that captures the downloader's name and email address?
   */
  @Parameter
  public Boolean requireRegistration;

  public Boolean getRequireRegistration() {
    return requireRegistration;
  }

  /**
   * Only allow access to recipients who have explicitly received the share via an email sent through the Files.com UI?
   */
  @Parameter
  public Boolean requireShareRecipient;

  public Boolean getRequireShareRecipient() {
    return requireShareRecipient;
  }

  /**
   * If true, we will hide the 'Remember Me' box on the Bundle registration page, requiring that the user logout and log back in every time they visit the page.
   */
  @Parameter
  public Boolean requireLogout;

  public Boolean getRequireLogout() {
    return requireLogout;
  }

  /**
   * Legal text that must be agreed to prior to accessing Bundle.
   */
  @Parameter
  public String clickwrapBody;

  public String getClickwrapBody() {
    return clickwrapBody;
  }

  /**
   * Custom Form to use
   */
  @Parameter
  public FormFieldSetModel formFieldSet;

  public FormFieldSetModel getFormFieldSet() {
    return formFieldSet;
  }

  /**
   * BundleRegistrations can be saved without providing name?
   */
  @Parameter
  public Boolean skipName;

  public Boolean getSkipName() {
    return skipName;
  }

  /**
   * BundleRegistrations can be saved without providing email?
   */
  @Parameter
  public Boolean skipEmail;

  public Boolean getSkipEmail() {
    return skipEmail;
  }

  /**
   * Date when share will start to be accessible. If `nil` access granted right after create.
   */
  @Parameter
  public Date startAccessOnDate;

  public Date getStartAccessOnDate() {
    return startAccessOnDate;
  }

  /**
   * BundleRegistrations can be saved without providing company?
   */
  @Parameter
  public Boolean skipCompany;

  public Boolean getSkipCompany() {
    return skipCompany;
  }

  /**
   * Bundle ID
   */
  @Parameter
  public Long id;

  public Long getId() {
    return id;
  }

  /**
   * Bundle created at date/time
   */
  @Parameter
  public Date createdAt;

  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Do not create subfolders for files uploaded to this share. Note: there are subtle security pitfalls with allowing anonymous uploads from multiple users to live in the same folder. We strongly discourage use of this option unless absolutely required.
   */
  @Parameter
  public Boolean dontSeparateSubmissionsByFolder;

  public Boolean getDontSeparateSubmissionsByFolder() {
    return dontSeparateSubmissionsByFolder;
  }

  /**
   * Maximum number of times bundle can be accessed
   */
  @Parameter
  public Long maxUses;

  public Long getMaxUses() {
    return maxUses;
  }

  /**
   * Bundle internal note
   */
  @Parameter
  public String note;

  public String getNote() {
    return note;
  }

  /**
   * Template for creating submission subfolders. Can use the uploader's name, email address, ip, company, `strftime` directives, and any custom form data.
   */
  @Parameter
  public String pathTemplate;

  public String getPathTemplate() {
    return pathTemplate;
  }

  /**
   * Timezone to use when rendering timestamps in path templates.
   */
  @Parameter
  public String pathTemplateTimeZone;

  public String getPathTemplateTimeZone() {
    return pathTemplateTimeZone;
  }

  /**
   * Send delivery receipt to the uploader. Note: For writable share only
   */
  @Parameter
  public Boolean sendEmailReceiptToUploader;

  public Boolean getSendEmailReceiptToUploader() {
    return sendEmailReceiptToUploader;
  }

  /**
   * ID of the snapshot containing this bundle's contents.
   */
  @Parameter
  public Long snapshotId;

  public Long getSnapshotId() {
    return snapshotId;
  }

  /**
   * Bundle creator user ID
   */
  @Parameter
  public Long userId;

  public Long getUserId() {
    return userId;
  }

  /**
   * Bundle creator username
   */
  @Parameter
  public String username;

  public String getUsername() {
    return username;
  }

  /**
   * ID of the clickwrap to use with this bundle.
   */
  @Parameter
  public Long clickwrapId;

  public Long getClickwrapId() {
    return clickwrapId;
  }

  /**
   * ID of the associated inbox, if available.
   */
  @Parameter
  public Long inboxId;

  public Long getInboxId() {
    return inboxId;
  }

  /**
   * Preview watermark image applied to all bundle items.
   */
  @Parameter
  public ImageModel watermarkAttachment;

  public ImageModel getWatermarkAttachment() {
    return watermarkAttachment;
  }

  /**
   * Preview watermark settings applied to all bundle items. Uses the same keys as Behavior.value
   */
  @Parameter
  public Map<String, String> watermarkValue;

  public Map<String, String> getWatermarkValue() {
    return watermarkValue;
  }

  /**
   * Does this bundle have an associated inbox?
   */
  @Parameter
  public Boolean hasInbox;

  public Boolean getHasInbox() {
    return hasInbox;
  }

  /**
   * A list of paths in this bundle.  For performance reasons, this is not provided when listing bundles.
   */
  @Parameter
  public String[] paths;

  public String[] getPaths() {
    return paths;
  }

  /**
   * A list of bundlepaths in this bundle.  For performance reasons, this is not provided when listing bundles.
   */
  @Parameter
  public Object[] bundlepaths;

  public Object[] getBundlepaths() {
    return bundlepaths;
  }

  /**
   * Password for this bundle.
   */
  @Parameter
  public String password;

  public String getPassword() {
    return password;
  }

  /**
   * Id of Form Field Set to use with this bundle
   */
  @Parameter
  public Long formFieldSetId;

  public Long getFormFieldSetId() {
    return formFieldSetId;
  }

  /**
   * If true, create a snapshot of this bundle's contents.
   */
  @Parameter
  public Boolean createSnapshot;

  public Boolean getCreateSnapshot() {
    return createSnapshot;
  }

  /**
   * If true, finalize the snapshot of this bundle's contents. Note that `create_snapshot` must also be true.
   */
  @Parameter
  public Boolean finalizeSnapshot;

  public Boolean getFinalizeSnapshot() {
    return finalizeSnapshot;
  }

  /**
   * Preview watermark image applied to all bundle items.
   */
  @Parameter
  public byte[] watermarkAttachmentFile;

  public byte[] getWatermarkAttachmentFile() {
    return watermarkAttachmentFile;
  }

  /**
   * If true, will delete the file stored in watermark_attachment
   */
  @Parameter
  public Boolean watermarkAttachmentDelete;

  public Boolean getWatermarkAttachmentDelete() {
    return watermarkAttachmentDelete;
  }

}
