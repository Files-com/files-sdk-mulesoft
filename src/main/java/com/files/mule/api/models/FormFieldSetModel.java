package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

import com.files.models.FormFieldSet;

/**
 * A Form Field Set is a custom form to be used for bundle and inbox registrations.
 *
 * Each Form Field Set contains one or more Form Fields. A form and all of its form fields are submitted in a single create request. The order of form fields in the array is the order they will be displayed.
 *
 * Once created, a form field set can then be associated with one or more bundle(s) and/or inbox(s). Once associated, you will be required to submit well-formatted form-data when creating a bundle-registration or inbox registration.
 */
public class FormFieldSetModel implements Serializable {
  public FormFieldSetModel() {
  }

  public FormFieldSetModel(final FormFieldSet formFieldSet) {
    this.id = formFieldSet.id;
    this.title = formFieldSet.title;
    this.formLayout = formFieldSet.formLayout;
    this.formFields = formFieldSet.formFields;
    this.skipName = formFieldSet.skipName;
    this.skipEmail = formFieldSet.skipEmail;
    this.skipCompany = formFieldSet.skipCompany;
    this.userId = formFieldSet.userId;
  }

  /**
   * Form field set id
   */
  @Parameter
  public Long id;

  public Long getId() {
    return id;
  }

  /**
   * Title to be displayed
   */
  @Parameter
  public String title;

  public String getTitle() {
    return title;
  }

  /**
   * Layout of the form
   */
  @Parameter
  public Long[] formLayout;

  public Long[] getFormLayout() {
    return formLayout;
  }

  /**
   * Associated form fields
   */
  @Parameter
  public Object[] formFields;

  public Object[] getFormFields() {
    return formFields;
  }

  /**
   * Any associated InboxRegistrations or BundleRegistrations can be saved without providing name
   */
  @Parameter
  public Boolean skipName;

  public Boolean getSkipName() {
    return skipName;
  }

  /**
   * Any associated InboxRegistrations or BundleRegistrations can be saved without providing email
   */
  @Parameter
  public Boolean skipEmail;

  public Boolean getSkipEmail() {
    return skipEmail;
  }

  /**
   * Any associated InboxRegistrations or BundleRegistrations can be saved without providing company
   */
  @Parameter
  public Boolean skipCompany;

  public Boolean getSkipCompany() {
    return skipCompany;
  }

  /**
   * User ID.  Provide a value of `0` to operate the current session's user.
   */
  @Parameter
  public Long userId;

  public Long getUserId() {
    return userId;
  }

}
