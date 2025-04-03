/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.operation.parameter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class UserParameterGroupTest {
  @Test
  public void testShow() {
    final UserParameterGroup.Show group = new UserParameterGroup.Show();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
  }

  @Test
  public void testCreate() {
    final UserParameterGroup.Create group = new UserParameterGroup.Create();
    group.setUsername("user");
    assertThat(group.getUsername(), equalTo("user"));
    group.setEmail("john.doe@files.com");
    assertThat(group.getEmail(), equalTo("john.doe@files.com"));
    group.setGroupIds("example");
    assertThat(group.getGroupIds(), equalTo("example"));
    group.setPassword("");
    assertThat(group.getPassword(), equalTo(""));
    group.setAuthenticationMethod("password");
    assertThat(group.getAuthenticationMethod(), equalTo("password"));
    group.setName("John Doe");
    assertThat(group.getName(), equalTo("John Doe"));
    group.setCompany("ACME Corp.");
    assertThat(group.getCompany(), equalTo("ACME Corp."));
    group.setNotes("Internal notes on this user.");
    assertThat(group.getNotes(), equalTo("Internal notes on this user."));
    group.setRequirePasswordChange(true);
    assertThat(group.getRequirePasswordChange(), equalTo(true));
    group.setUserRoot("example");
    assertThat(group.getUserRoot(), equalTo("example"));
    group.setUserHome("example");
    assertThat(group.getUserHome(), equalTo("example"));
  }

  @Test
  public void testUpdate() {
    final UserParameterGroup.Update group = new UserParameterGroup.Update();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
    group.setEmail("john.doe@files.com");
    assertThat(group.getEmail(), equalTo("john.doe@files.com"));
    group.setGroupIds("example");
    assertThat(group.getGroupIds(), equalTo("example"));
    group.setPassword("");
    assertThat(group.getPassword(), equalTo(""));
    group.setAuthenticationMethod("password");
    assertThat(group.getAuthenticationMethod(), equalTo("password"));
    group.setName("John Doe");
    assertThat(group.getName(), equalTo("John Doe"));
    group.setCompany("ACME Corp.");
    assertThat(group.getCompany(), equalTo("ACME Corp."));
    group.setNotes("Internal notes on this user.");
    assertThat(group.getNotes(), equalTo("Internal notes on this user."));
    group.setRequirePasswordChange(true);
    assertThat(group.getRequirePasswordChange(), equalTo(true));
    group.setUserRoot("example");
    assertThat(group.getUserRoot(), equalTo("example"));
    group.setUserHome("example");
    assertThat(group.getUserHome(), equalTo("example"));
    group.setUsername("user");
    assertThat(group.getUsername(), equalTo("user"));
  }

  @Test
  public void testDelete() {
    final UserParameterGroup.Delete group = new UserParameterGroup.Delete();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
  }

}
