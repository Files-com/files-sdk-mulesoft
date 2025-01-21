/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.files.models.BundleRegistration;

public class ShareLinkRegistrationModelTest {
  @Test
  public void testShareLinkRegistrationModel() {
    final ShareLinkRegistrationModel model = new ShareLinkRegistrationModel(new BundleRegistration());
    model.setCode("abc123");
    assertThat(model.getCode(), equalTo("abc123"));
    model.setName("account");
    assertThat(model.getName(), equalTo("account"));
    model.setCompany("Action Verb");
    assertThat(model.getCompany(), equalTo("Action Verb"));
    model.setEmail("john.doe@files.com");
    assertThat(model.getEmail(), equalTo("john.doe@files.com"));
    model.setIp("10.1.1.1");
    assertThat(model.getIp(), equalTo("10.1.1.1"));
    model.setInboxCode("abc123");
    assertThat(model.getInboxCode(), equalTo("abc123"));
    model.setClickwrapBody("example");
    assertThat(model.getClickwrapBody(), equalTo("example"));
    model.setFormFieldSetId(1L);
    assertThat(model.getFormFieldSetId(), equalTo(1L));
    model.setFormFieldData(null);
    assertThat(model.getFormFieldData(), equalTo(null));
    model.setBundleCode("example");
    assertThat(model.getBundleCode(), equalTo("example"));
    model.setBundleId(1L);
    assertThat(model.getBundleId(), equalTo(1L));
    model.setBundleRecipientId(1L);
    assertThat(model.getBundleRecipientId(), equalTo(1L));
    model.setCreatedAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getCreatedAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
  }
}
