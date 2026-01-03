/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.operation.parameter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class FileParameterGroupTest {
  @Test
  public void testDownload() {
    final FileParameterGroup.Download group = new FileParameterGroup.Download();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testUpload() {
    final FileParameterGroup.Upload group = new FileParameterGroup.Upload();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testDelete() {
    final FileParameterGroup.Delete group = new FileParameterGroup.Delete();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testShow() {
    final FileParameterGroup.Show group = new FileParameterGroup.Show();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
  }

  @Test
  public void testCopy() {
    final FileParameterGroup.Copy group = new FileParameterGroup.Copy();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
    group.setDestination("destination");
    assertThat(group.getDestination(), equalTo("destination"));
  }

  @Test
  public void testMove() {
    final FileParameterGroup.Move group = new FileParameterGroup.Move();
    group.setPath("path");
    assertThat(group.getPath(), equalTo("path"));
    group.setDestination("destination");
    assertThat(group.getDestination(), equalTo("destination"));
  }

}
