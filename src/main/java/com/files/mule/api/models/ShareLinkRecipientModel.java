package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;

import com.files.models.BundleRecipient;

/**
 * A BundleRecipient is a person who has had a bundle shared with them via email invite. A Bundle can be re-shared
 * with a Bundle Recipient by sending a create request with the inbox_id, recipient email address,
 * and share_after_create =  true.
 */
public class ShareLinkRecipientModel implements Serializable {
  public ShareLinkRecipientModel() {
  }

  public ShareLinkRecipientModel(final BundleRecipient bundleRecipient) {
    initGroup1(bundleRecipient);
  }

  private void initGroup1(final BundleRecipient bundleRecipient) {
    this.company = bundleRecipient.company;
    this.name = bundleRecipient.name;
    this.note = bundleRecipient.note;
    this.recipient = bundleRecipient.recipient;
    this.sentAt = bundleRecipient.sentAt != null ? ZonedDateTime.ofInstant(bundleRecipient.sentAt.toInstant(), ZoneId.systemDefault()) : null;
    this.bundleId = bundleRecipient.bundleId;
    this.shareAfterCreate = Boolean.TRUE.equals(bundleRecipient.shareAfterCreate);
  }

  private String company;

  public String getCompany() {
    return company;
  }

  private String name;

  public String getName() {
    return name;
  }

  private String note;

  public String getNote() {
    return note;
  }

  private String recipient;

  public String getRecipient() {
    return recipient;
  }

  private ZonedDateTime sentAt;

  public ZonedDateTime getSentAt() {
    return sentAt;
  }

  private Long bundleId;

  public Long getBundleId() {
    return bundleId;
  }

  private boolean shareAfterCreate;

  public boolean getShareAfterCreate() {
    return shareAfterCreate;
  }

}
