/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.operation.parameter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class FolderParameterGroupTest {
  @Test
  public void testList() throws Exception {
    final FolderParameterGroup.List group = new FolderParameterGroup.List();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testCreate() throws Exception {
    final FolderParameterGroup.Create group = new FolderParameterGroup.Create();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testDelete() throws Exception {
    final FolderParameterGroup.Delete group = new FolderParameterGroup.Delete();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testShow() throws Exception {
    final FolderParameterGroup.Show group = new FolderParameterGroup.Show();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testCopy() throws Exception {
    final FolderParameterGroup.Copy group = new FolderParameterGroup.Copy();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
    group.setDestination("destination");
    assertThat(group.getDestination(), equalTo("destination"));
  }

  @Test
  public void testMove() throws Exception {
    final FolderParameterGroup.Move group = new FolderParameterGroup.Move();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
    group.setDestination("destination");
    assertThat(group.getDestination(), equalTo("destination"));
  }

}
