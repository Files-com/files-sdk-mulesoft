/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
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
 *
 * Editing a field definition creates a replacement field with a new ID and preserves the original definition for existing registration answers. Unchanged fields and fields moved within the layout retain their IDs. Use the returned form_layout when submitting new answers or editing the form again.
 *
 * Authenticated form field set responses include historical definitions in form_fields so existing answers can still be interpreted. Only IDs in form_layout are current fields. Forms embedded in Share Link and Inbox responses contain current definitions only.
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
    this.inUse = Boolean.TRUE.equals(formFieldSet.inUse);
    this.userId = formFieldSet.userId;
    this.workspaceId = formFieldSet.workspaceId;
  }

  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  private List<Long> formLayouts;

  public List<Long> getFormLayouts() {
    return formLayouts;
  }

  public void setFormLayouts(final List<Long> formLayouts) {
    this.formLayouts = formLayouts;
  }

  private boolean skipName;

  public boolean getSkipName() {
    return skipName;
  }

  public void setSkipName(final boolean skipName) {
    this.skipName = skipName;
  }

  private boolean skipEmail;

  public boolean getSkipEmail() {
    return skipEmail;
  }

  public void setSkipEmail(final boolean skipEmail) {
    this.skipEmail = skipEmail;
  }

  private boolean skipCompany;

  public boolean getSkipCompany() {
    return skipCompany;
  }

  public void setSkipCompany(final boolean skipCompany) {
    this.skipCompany = skipCompany;
  }

  private boolean inUse;

  public boolean getInUse() {
    return inUse;
  }

  public void setInUse(final boolean inUse) {
    this.inUse = inUse;
  }

  private Long userId;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  private Long workspaceId;

  public Long getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(final Long workspaceId) {
    this.workspaceId = workspaceId;
  }

}
