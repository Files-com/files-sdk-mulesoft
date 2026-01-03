/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.operation.parameter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.junit.Test;

public class ShareLinkParameterGroupTest {
  @Test
  public void testShow() {
    final ShareLinkParameterGroup.Show group = new ShareLinkParameterGroup.Show();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
  }

  @Test
  public void testCreate() {
    final ShareLinkParameterGroup.Create group = new ShareLinkParameterGroup.Create();
    group.setPaths(Arrays.asList("file.txt"));
    assertThat(group.getPaths(), equalTo(Arrays.asList("file.txt")));
    group.setPassword("Password");
    assertThat(group.getPassword(), equalTo("Password"));
    group.setExpiresAt("2000-01-01T01:00:00Z");
    assertThat(group.getExpiresAt(), equalTo("2000-01-01T01:00:00Z"));
    group.setMaxUses(1L);
    assertThat(group.getMaxUses(), equalTo(1L));
    group.setDescription("The public description of the bundle.");
    assertThat(group.getDescription(), equalTo("The public description of the bundle."));
    group.setNote("The internal note on the bundle.");
    assertThat(group.getNote(), equalTo("The internal note on the bundle."));
    group.setRequireRegistration(false);
    assertThat(group.getRequireRegistration(), equalTo(false));
  }

  @Test
  public void testUpdate() {
    final ShareLinkParameterGroup.Update group = new ShareLinkParameterGroup.Update();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
    group.setExpiresAt("2000-01-01T01:00:00Z");
    assertThat(group.getExpiresAt(), equalTo("2000-01-01T01:00:00Z"));
  }

  @Test
  public void testDelete() {
    final ShareLinkParameterGroup.Delete group = new ShareLinkParameterGroup.Delete();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
  }

}
