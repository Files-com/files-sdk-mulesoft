/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.ZonedDateTime;
import java.util.Arrays;

import org.junit.Test;

import com.files.models.Bundle;

public class ShareLinkModelTest {
  @Test
  public void testShareLinkModel() {
    final ShareLinkModel model = new ShareLinkModel(new Bundle());
    model.setCode("abc123");
    assertThat(model.getCode(), equalTo("abc123"));
    model.setColorLeft("#0066a7");
    assertThat(model.getColorLeft(), equalTo("#0066a7"));
    model.setColorLink("#d34f5d");
    assertThat(model.getColorLink(), equalTo("#d34f5d"));
    model.setColorText("#0066a7");
    assertThat(model.getColorText(), equalTo("#0066a7"));
    model.setColorTop("#000000");
    assertThat(model.getColorTop(), equalTo("#000000"));
    model.setColorTopText("#ffffff");
    assertThat(model.getColorTopText(), equalTo("#ffffff"));
    model.setUrl("https://subdomain.files.com/f/12345678");
    assertThat(model.getUrl(), equalTo("https://subdomain.files.com/f/12345678"));
    model.setDescription("The public description of the bundle.");
    assertThat(model.getDescription(), equalTo("The public description of the bundle."));
    model.setExpiresAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getExpiresAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setPasswordProtected(true);
    assertThat(model.getPasswordProtected(), equalTo(true));
    model.setPermissions("read");
    assertThat(model.getPermissions(), equalTo("read"));
    model.setPreviewOnly(true);
    assertThat(model.getPreviewOnly(), equalTo(true));
    model.setRequireRegistration(true);
    assertThat(model.getRequireRegistration(), equalTo(true));
    model.setRequireShareRecipient(true);
    assertThat(model.getRequireShareRecipient(), equalTo(true));
    model.setRequireLogout(true);
    assertThat(model.getRequireLogout(), equalTo(true));
    model.setClickwrapBody("[Legal text]");
    assertThat(model.getClickwrapBody(), equalTo("[Legal text]"));
    model.setFormFieldSet(null);
    assertThat(model.getFormFieldSet(), equalTo(null));
    model.setSkipName(true);
    assertThat(model.getSkipName(), equalTo(true));
    model.setSkipEmail(true);
    assertThat(model.getSkipEmail(), equalTo(true));
    model.setStartAccessOnDate(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getStartAccessOnDate(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setSkipCompany(true);
    assertThat(model.getSkipCompany(), equalTo(true));
    model.setId(1L);
    assertThat(model.getId(), equalTo(1L));
    model.setCreatedAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getCreatedAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setDontSeparateSubmissionsByFolder(true);
    assertThat(model.getDontSeparateSubmissionsByFolder(), equalTo(true));
    model.setMaxUses(1L);
    assertThat(model.getMaxUses(), equalTo(1L));
    model.setNote("The internal note on the bundle.");
    assertThat(model.getNote(), equalTo("The internal note on the bundle."));
    model.setPathTemplate("{{name}}_{{ip}}");
    assertThat(model.getPathTemplate(), equalTo("{{name}}_{{ip}}"));
    model.setPathTemplateTimeZone("Eastern Time (US & Canada)");
    assertThat(model.getPathTemplateTimeZone(), equalTo("Eastern Time (US & Canada)"));
    model.setSendEmailReceiptToUploader(true);
    assertThat(model.getSendEmailReceiptToUploader(), equalTo(true));
    model.setSnapshotId(1L);
    assertThat(model.getSnapshotId(), equalTo(1L));
    model.setUserId(1L);
    assertThat(model.getUserId(), equalTo(1L));
    model.setUsername("user");
    assertThat(model.getUsername(), equalTo("user"));
    model.setClickwrapId(1L);
    assertThat(model.getClickwrapId(), equalTo(1L));
    model.setInboxId(1L);
    assertThat(model.getInboxId(), equalTo(1L));
    model.setWatermarkAttachment(null);
    assertThat(model.getWatermarkAttachment(), equalTo(null));
    model.setWatermarkValue(null);
    assertThat(model.getWatermarkValue(), equalTo(null));
    model.setHasInbox(true);
    assertThat(model.getHasInbox(), equalTo(true));
    model.setDontAllowFoldersInUploads(true);
    assertThat(model.getDontAllowFoldersInUploads(), equalTo(true));
    model.setPaths(Arrays.asList("file.txt"));
    assertThat(model.getPaths(), equalTo(Arrays.asList("file.txt")));
    model.setPassword("Password");
    assertThat(model.getPassword(), equalTo("Password"));
    model.setFormFieldSetId(1L);
    assertThat(model.getFormFieldSetId(), equalTo(1L));
    model.setCreateSnapshot(false);
    assertThat(model.getCreateSnapshot(), equalTo(false));
    model.setFinalizeSnapshot(false);
    assertThat(model.getFinalizeSnapshot(), equalTo(false));
    model.setWatermarkAttachmentDelete(false);
    assertThat(model.getWatermarkAttachmentDelete(), equalTo(false));
  }
}
