/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.operation.parameter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class GroupParameterGroupTest {
  @Test
  public void testShow() {
    final GroupParameterGroup.Show group = new GroupParameterGroup.Show();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
  }

  @Test
  public void testCreate() {
    final GroupParameterGroup.Create group = new GroupParameterGroup.Create();
    group.setName("name");
    assertThat(group.getName(), equalTo("name"));
    group.setNotes("example");
    assertThat(group.getNotes(), equalTo("example"));
    group.setUserIds("1");
    assertThat(group.getUserIds(), equalTo("1"));
    group.setAdminIds("1");
    assertThat(group.getAdminIds(), equalTo("1"));
  }

  @Test
  public void testUpdate() {
    final GroupParameterGroup.Update group = new GroupParameterGroup.Update();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
    group.setNotes("example");
    assertThat(group.getNotes(), equalTo("example"));
    group.setUserIds("1");
    assertThat(group.getUserIds(), equalTo("1"));
    group.setAdminIds("1");
    assertThat(group.getAdminIds(), equalTo("1"));
    group.setName("owners");
    assertThat(group.getName(), equalTo("owners"));
  }

  @Test
  public void testDelete() {
    final GroupParameterGroup.Delete group = new GroupParameterGroup.Delete();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
  }

}
