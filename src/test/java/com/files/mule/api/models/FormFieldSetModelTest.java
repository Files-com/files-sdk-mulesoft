package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.junit.Test;

import com.files.models.FormFieldSet;

public class FormFieldSetModelTest {
  @Test
  public void testFormFieldSetModel() {
    final FormFieldSetModel model = new FormFieldSetModel(new FormFieldSet());
    model.setId(1L);
    assertThat(model.getId(), equalTo(1L));
    model.setTitle("Sample Form Title");
    assertThat(model.getTitle(), equalTo("Sample Form Title"));
    model.setFormLayouts(Arrays.asList(1L, 2L, 3L, 4L));
    assertThat(model.getFormLayouts(), equalTo(Arrays.asList(1L, 2L, 3L, 4L)));
    model.setSkipName(true);
    assertThat(model.getSkipName(), equalTo(true));
    model.setSkipEmail(true);
    assertThat(model.getSkipEmail(), equalTo(true));
    model.setSkipCompany(true);
    assertThat(model.getSkipCompany(), equalTo(true));
    model.setUserId(1L);
    assertThat(model.getUserId(), equalTo(1L));
  }
}
