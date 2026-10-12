/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.files.models.FormFieldSet;

public class SdkFieldsTest {
  @Test
  public void readsTheValuesOfTheSdkFields() {
    final FormFieldSet formFieldSet = new FormFieldSet();
    formFieldSet.id = 7L;
    formFieldSet.title = "Intake";
    formFieldSet.skipName = true;
    formFieldSet.formLayout = new Long[]{1L, 2L};

    assertThat(SdkFields.read(formFieldSet, "id", Long.class), equalTo(7L));
    assertThat(SdkFields.read(formFieldSet, "title", String.class), equalTo("Intake"));
    assertThat(SdkFields.read(formFieldSet, "skipName", Boolean.class), equalTo(true));
    final List<Long> formLayouts = SdkFields.read(formFieldSet, "formLayout", Long[].class, Arrays::asList);
    assertThat(formLayouts, equalTo(Arrays.asList(1L, 2L)));
  }

  @Test
  public void readsNoValueForAFieldTheSdkDoesNotHave() {
    final FormFieldSet formFieldSet = new FormFieldSet();

    assertThat(SdkFields.read(formFieldSet, "notAFormFieldSetField", Boolean.class), nullValue());
    assertThat(SdkFields.read(formFieldSet, "notAFormFieldSetField", Long[].class, SdkFieldsTest::unexpected),
        nullValue());
  }

  @Test
  public void readsNoValueForAnSdkFieldWithoutOne() {
    final FormFieldSet formFieldSet = new FormFieldSet();

    assertThat(SdkFields.read(formFieldSet, "title", String.class), nullValue());
    assertThat(SdkFields.read(formFieldSet, "formLayout", Long[].class, SdkFieldsTest::unexpected), nullValue());
  }

  @Test(expected = ClassCastException.class)
  public void refusesAValueOfAnotherType() {
    final FormFieldSet formFieldSet = new FormFieldSet();
    formFieldSet.title = "Intake";

    SdkFields.read(formFieldSet, "title", Long.class);
  }

  private static List<Long> unexpected(final Long[] value) {
    throw new AssertionError("There is no value to convert");
  }
}
