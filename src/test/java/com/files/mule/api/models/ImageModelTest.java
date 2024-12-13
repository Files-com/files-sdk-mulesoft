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
