/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.files.models.BundleRecipient;

public class ShareLinkRecipientModelTest {
  @Test
  public void testShareLinkRecipientModel() {
    final ShareLinkRecipientModel model = new ShareLinkRecipientModel(new BundleRecipient());
    model.setCompany("Acme Inc.");
    assertThat(model.getCompany(), equalTo("Acme Inc."));
    model.setName("John Doe");
    assertThat(model.getName(), equalTo("John Doe"));
    model.setNote("Some note.");
    assertThat(model.getNote(), equalTo("Some note."));
    model.setRecipient("john.doe@example.com");
    assertThat(model.getRecipient(), equalTo("john.doe@example.com"));
    model.setSentAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getSentAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setUserId(1L);
    assertThat(model.getUserId(), equalTo(1L));
    model.setBundleId(1L);
    assertThat(model.getBundleId(), equalTo(1L));
    model.setShareAfterCreate(false);
    assertThat(model.getShareAfterCreate(), equalTo(false));
  }
}
