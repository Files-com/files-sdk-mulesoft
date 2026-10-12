/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Date;

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
    this.company = SdkFields.read(bundleRecipient, "company", String.class);
    this.name = SdkFields.read(bundleRecipient, "name", String.class);
    this.note = SdkFields.read(bundleRecipient, "note", String.class);
    this.recipient = SdkFields.read(bundleRecipient, "recipient", String.class);
    this.sentAt = SdkFields.read(bundleRecipient, "sentAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.workspaceId = SdkFields.read(bundleRecipient, "workspaceId", Long.class);
    this.userId = SdkFields.read(bundleRecipient, "userId", Long.class);
    this.bundleId = SdkFields.read(bundleRecipient, "bundleId", Long.class);
    this.shareAfterCreate = Boolean.TRUE.equals(SdkFields.read(bundleRecipient, "shareAfterCreate", Boolean.class));
  }

  private String company;

  public String getCompany() {
    return company;
  }

  public void setCompany(final String company) {
    this.company = company;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  private String note;

  public String getNote() {
    return note;
  }

  public void setNote(final String note) {
    this.note = note;
  }

  private String recipient;

  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(final String recipient) {
    this.recipient = recipient;
  }

  private ZonedDateTime sentAt;

  public ZonedDateTime getSentAt() {
    return sentAt;
  }

  public void setSentAt(final ZonedDateTime sentAt) {
    this.sentAt = sentAt;
  }

  private Long workspaceId;

  public Long getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(final Long workspaceId) {
    this.workspaceId = workspaceId;
  }

  private Long userId;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  private Long bundleId;

  public Long getBundleId() {
    return bundleId;
  }

  public void setBundleId(final Long bundleId) {
    this.bundleId = bundleId;
  }

  private boolean shareAfterCreate;

  public boolean getShareAfterCreate() {
    return shareAfterCreate;
  }

  public void setShareAfterCreate(final boolean shareAfterCreate) {
    this.shareAfterCreate = shareAfterCreate;
  }

}
