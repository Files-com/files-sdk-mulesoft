package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

import com.files.models.BundleRegistration;

/**
 * A BundleRegistration is a registration record when a user fills out the form to access the bundle.
 */
public class ShareLinkRegistrationModel implements Serializable {
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
    this.createdAt = bundleRegistration.createdAt;
  }

  /**
   * Registration cookie code
   */
  @Parameter
  public String code;

  public String getCode() {
    return code;
  }

  /**
   * Registrant name
   */
  @Parameter
  public String name;

  public String getName() {
    return name;
  }

  /**
   * Registrant company name
   */
  @Parameter
  public String company;

  public String getCompany() {
    return company;
  }

  /**
   * Registrant email address
   */
  @Parameter
  public String email;

  public String getEmail() {
    return email;
  }

  /**
   * Registrant IP Address
   */
  @Parameter
  public String ip;

  public String getIp() {
    return ip;
  }

  /**
   * InboxRegistration cookie code, if there is an associated InboxRegistration
   */
  @Parameter
  public String inboxCode;

  public String getInboxCode() {
    return inboxCode;
  }

  /**
   * Clickwrap text that was shown to the registrant
   */
  @Parameter
  public String clickwrapBody;

  public String getClickwrapBody() {
    return clickwrapBody;
  }

  /**
   * Id of associated form field set
   */
  @Parameter
  public Long formFieldSetId;

  public Long getFormFieldSetId() {
    return formFieldSetId;
  }

  /**
   * Data for form field set with form field ids as keys and user data as values
   */
  @Parameter
  public Map<String, String> formFieldData;

  public Map<String, String> getFormFieldData() {
    return formFieldData;
  }

  /**
   * Bundle URL code
   */
  @Parameter
  public String bundleCode;

  public String getBundleCode() {
    return bundleCode;
  }

  /**
   * Id of associated bundle
   */
  @Parameter
  public Long bundleId;

  public Long getBundleId() {
    return bundleId;
  }

  /**
   * Id of associated bundle recipient
   */
  @Parameter
  public Long bundleRecipientId;

  public Long getBundleRecipientId() {
    return bundleRecipientId;
  }

  /**
   * Registration creation date/time
   */
  @Parameter
  public Date createdAt;

  public Date getCreatedAt() {
    return createdAt;
  }

}
