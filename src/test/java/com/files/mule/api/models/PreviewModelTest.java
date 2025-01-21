/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.files.models.Preview;

public class PreviewModelTest {
  @Test
  public void testPreviewModel() {
    final PreviewModel model = new PreviewModel(new Preview());
    model.setId(1L);
    assertThat(model.getId(), equalTo(1L));
    model.setStatus("complete");
    assertThat(model.getStatus(), equalTo("complete"));
    model.setDownloadUri("https://mysite.files.com/...");
    assertThat(model.getDownloadUri(), equalTo("https://mysite.files.com/..."));
    model.setPreviewType("image");
    assertThat(model.getPreviewType(), equalTo("image"));
    model.setSize("large");
    assertThat(model.getSize(), equalTo("large"));
  }
}
