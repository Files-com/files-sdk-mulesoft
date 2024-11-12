package com.files.mule.api.models;

import java.time.ZonedDateTime;
import java.util.Map;

import com.files.models.BundleRegistration;

/**
 * A BundleRegistration is a registration record when a user fills out the form to access the bundle.
 */
public class ShareLinkRegistrationModel extends AbstractModel {
  public ShareLinkRegistrationModel() {
  }

  public ShareLinkRegistrationModel(final BundleRegistration bundleRegistration) {
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
    this.bundleId = bundleRegistration.bundleId;
    this.bundleRecipientId = bundleRegistration.bundleRecipientId;
    this.createdAt = toZonedDateTime(bundleRegistration.createdAt);
  }

  private String code;

  public String getCode() {
    return code;
  }

  private String name;

  public String getName() {
    return name;
  }

  private String company;

  public String getCompany() {
    return company;
  }

  private String email;

  public String getEmail() {
    return email;
  }

  private String ip;

  public String getIp() {
    return ip;
  }

  private String inboxCode;

  public String getInboxCode() {
    return inboxCode;
  }

  private String clickwrapBody;

  public String getClickwrapBody() {
    return clickwrapBody;
  }

  private Long formFieldSetId;

  public Long getFormFieldSetId() {
    return formFieldSetId;
  }

  private Map<String, String> formFieldData;

  public Map<String, String> getFormFieldData() {
    return formFieldData;
  }

  private String bundleCode;

  public String getBundleCode() {
    return bundleCode;
  }

  private Long bundleId;

  public Long getBundleId() {
    return bundleId;
  }

  private Long bundleRecipientId;

  public Long getBundleRecipientId() {
    return bundleRecipientId;
  }

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

}
