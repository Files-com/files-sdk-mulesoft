package com.files.mule.internal.operation.parameter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ShareLinkRecipientParameterGroupTest {
  @Test
  public void testList() {
    final ShareLinkRecipientParameterGroup.List group = new ShareLinkRecipientParameterGroup.List();
    group.setBundleId(1L);
    assertThat(group.getBundleId(), equalTo(1L));
  }

  @Test
  public void testCreate() {
    final ShareLinkRecipientParameterGroup.Create group = new ShareLinkRecipientParameterGroup.Create();
    group.setBundleId(1L);
    assertThat(group.getBundleId(), equalTo(1L));
    group.setRecipient("johndoe@gmail.com");
    assertThat(group.getRecipient(), equalTo("johndoe@gmail.com"));
    group.setName("John Smith");
    assertThat(group.getName(), equalTo("John Smith"));
    group.setCompany("Acme Ltd");
    assertThat(group.getCompany(), equalTo("Acme Ltd"));
    group.setNote("Just a note.");
    assertThat(group.getNote(), equalTo("Just a note."));
  }

}
