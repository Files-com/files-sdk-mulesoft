package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

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
    initGroup1(formFieldSet);
  }

  private void initGroup1(final FormFieldSet formFieldSet) {
    this.id = formFieldSet.id;
    this.title = formFieldSet.title;
    this.formLayouts = formFieldSet.formLayout != null ? Arrays.asList(formFieldSet.formLayout) : null;
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

  private List<Long> formLayouts;

  public List<Long> getFormLayouts() {
    return formLayouts;
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
