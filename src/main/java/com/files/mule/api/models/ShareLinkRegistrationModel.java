/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;

import com.files.models.BundleRegistration;

/**
 * A BundleRegistration is a registration record when a user fills out the form to access the bundle.
 */
public class ShareLinkRegistrationModel implements Serializable {
  public ShareLinkRegistrationModel() {
  }

  public ShareLinkRegistrationModel(final BundleRegistration bundleRegistration) {
    initGroup1(bundleRegistration);
    initGroup2(bundleRegistration);
  }

  private void initGroup1(final BundleRegistration bundleRegistration) {
    this.code = bundleRegistration.code;
    this.name = bundleRegistration.name;
    this.company = bundleRegistration.company;
    this.email = bundleRegistration.email;
    this.ip = bundleRegistration.ip;
    this.inboxCode = bundleRegistration.inboxCode;
    this.clickwrapBody = bundleRegistration.clickwrapBody;
    this.formFieldSetId = bundleRegistration.formFieldSetId;
    this.formFieldData = bundleRegistration.formFieldData;
    this.bundleCode = bundleRegistration.bundleCode;
  }

  private void initGroup2(final BundleRegistration bundleRegistration) {
    this.bundleId = bundleRegistration.bundleId;
    this.bundleRecipientId = bundleRegistration.bundleRecipientId;
    this.createdAt = bundleRegistration.createdAt != null ? ZonedDateTime.ofInstant(bundleRegistration.createdAt.toInstant(), ZoneId.systemDefault()) : null;
  }

  private String code;

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  private String company;

  public String getCompany() {
    return company;
  }

  public void setCompany(final String company) {
    this.company = company;
  }

  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  private String ip;

  public String getIp() {
    return ip;
  }

  public void setIp(final String ip) {
    this.ip = ip;
  }

  private String inboxCode;

  public String getInboxCode() {
    return inboxCode;
  }

  public void setInboxCode(final String inboxCode) {
    this.inboxCode = inboxCode;
  }

  private String clickwrapBody;

  public String getClickwrapBody() {
    return clickwrapBody;
  }

  public void setClickwrapBody(final String clickwrapBody) {
    this.clickwrapBody = clickwrapBody;
  }

  private Long formFieldSetId;

  public Long getFormFieldSetId() {
    return formFieldSetId;
  }

  public void setFormFieldSetId(final Long formFieldSetId) {
    this.formFieldSetId = formFieldSetId;
  }

  private Object formFieldData;

  public Object getFormFieldData() {
    return formFieldData;
  }

  public void setFormFieldData(final Object formFieldData) {
    this.formFieldData = formFieldData;
  }

  private String bundleCode;

  public String getBundleCode() {
    return bundleCode;
  }

  public void setBundleCode(final String bundleCode) {
    this.bundleCode = bundleCode;
  }

  private Long bundleId;

  public Long getBundleId() {
    return bundleId;
  }

  public void setBundleId(final Long bundleId) {
    this.bundleId = bundleId;
  }

  private Long bundleRecipientId;

  public Long getBundleRecipientId() {
    return bundleRecipientId;
  }

  public void setBundleRecipientId(final Long bundleRecipientId) {
    this.bundleRecipientId = bundleRecipientId;
  }

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

}
