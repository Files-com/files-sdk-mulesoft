/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.files.models.Image;

public class ImageModelTest {
  @Test
  public void testImageModel() {
    final ImageModel model = new ImageModel(new Image());
    model.setName("My logo");
    assertThat(model.getName(), equalTo("My logo"));
    model.setUri("https://mysite.files.com/.../my_image.png");
    assertThat(model.getUri(), equalTo("https://mysite.files.com/.../my_image.png"));
  }
}
