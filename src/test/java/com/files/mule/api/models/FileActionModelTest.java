/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.files.models.FileAction;

public class FileActionModelTest {
  @Test
  public void testFileActionModel() {
    final FileActionModel model = new FileActionModel(new FileAction());
    model.setStatus("pending");
    assertThat(model.getStatus(), equalTo("pending"));
    model.setFileMigrationId(1L);
    assertThat(model.getFileMigrationId(), equalTo(1L));
  }
}
