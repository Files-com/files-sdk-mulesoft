package com.files.mule.api.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    if (formFieldSet.formLayout != null) {
      this.formLayout = Arrays.asList(formFieldSet.formLayout);
    }
    if (formFieldSet.formFields != null) {
      this.formFields = Arrays.asList(formFieldSet.formFields);
    }
    this.skipName = Boolean.TRUE.equals(formFieldSet.skipName);
    this.skipEmail = Boolean.TRUE.equals(formFieldSet.skipEmail);
    this.skipCompany = Boolean.TRUE.equals(formFieldSet.skipCompany);
    this.userId = formFieldSet.userId;
  }

  private Long id;

  public Long getId() {
    return id;
  }

  private String title;

  public String getTitle() {
    return title;
  }

  private List<Long> formLayout;

  public List<Long> getFormLayout() {
    return formLayout;
  }

  private List<Object> formFields;

  public List<Object> getFormFields() {
    return formFields;
  }

  private boolean skipName;

  public boolean getSkipName() {
    return skipName;
  }

  private boolean skipEmail;

  public boolean getSkipEmail() {
    return skipEmail;
  }

  private boolean skipCompany;

  public boolean getSkipCompany() {
    return skipCompany;
  }

  private Long userId;

  public Long getUserId() {
    return userId;
  }

}
