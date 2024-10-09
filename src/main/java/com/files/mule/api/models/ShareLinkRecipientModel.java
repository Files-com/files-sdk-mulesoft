package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

import com.files.models.BundleRecipient;

/**
 * A BundleRecipient is a person who have had a bundle shared with them via email invite. A Bundle can be re-shared
 * with a Bundle Recipient by sending a create request with the inbox_id, recipient email address,
 * and share_after_create =  true.
 */
public class ShareLinkRecipientModel implements Serializable {
  public ShareLinkRecipientModel() {
  }

  public ShareLinkRecipientModel(final BundleRecipient bundleRecipient) {
    this.company = bundleRecipient.company;
    this.name = bundleRecipient.name;
    this.note = bundleRecipient.note;
    this.recipient = bundleRecipient.recipient;
    this.sentAt = bundleRecipient.sentAt;
    this.bundleId = bundleRecipient.bundleId;
    this.shareAfterCreate = bundleRecipient.shareAfterCreate;
  }

  /**
   * The recipient's company.
   */
  @Parameter
  public String company;

  public String getCompany() {
    return company;
  }

  /**
   * The recipient's name.
   */
  @Parameter
  public String name;

  public String getName() {
    return name;
  }

  /**
   * A note sent to the recipient with the bundle.
   */
  @Parameter
  public String note;

  public String getNote() {
    return note;
  }

  /**
   * The recipient's email address.
   */
  @Parameter
  public String recipient;

  public String getRecipient() {
    return recipient;
  }

  /**
   * When the Bundle was shared with this recipient.
   */
  @Parameter
  public Date sentAt;

  public Date getSentAt() {
    return sentAt;
  }

  /**
   * Bundle to share.
   */
  @Parameter
  public Long bundleId;

  public Long getBundleId() {
    return bundleId;
  }

  /**
   * Set to true to share the link with the recipient upon creation.
   */
  @Parameter
  public Boolean shareAfterCreate;

  public Boolean getShareAfterCreate() {
    return shareAfterCreate;
  }

}
