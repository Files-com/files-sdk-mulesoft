/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
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
