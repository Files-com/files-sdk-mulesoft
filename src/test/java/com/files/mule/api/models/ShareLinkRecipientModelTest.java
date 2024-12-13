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
    model.setBundleId(1L);
    assertThat(model.getBundleId(), equalTo(1L));
    model.setShareAfterCreate(true);
    assertThat(model.getShareAfterCreate(), equalTo(true));
  }
}
