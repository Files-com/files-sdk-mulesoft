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
