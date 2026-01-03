/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.operation.parameter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class FolderParameterGroupTest {
  @Test
  public void testList() {
    final FolderParameterGroup.List group = new FolderParameterGroup.List();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testCreate() {
    final FolderParameterGroup.Create group = new FolderParameterGroup.Create();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testDelete() {
    final FolderParameterGroup.Delete group = new FolderParameterGroup.Delete();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testShow() {
    final FolderParameterGroup.Show group = new FolderParameterGroup.Show();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testCopy() {
    final FolderParameterGroup.Copy group = new FolderParameterGroup.Copy();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
    group.setDestination("destination");
    assertThat(group.getDestination(), equalTo("destination"));
  }

  @Test
  public void testMove() {
    final FolderParameterGroup.Move group = new FolderParameterGroup.Move();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
    group.setDestination("destination");
    assertThat(group.getDestination(), equalTo("destination"));
  }

}
