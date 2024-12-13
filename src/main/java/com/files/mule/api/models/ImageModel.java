package com.files.mule.api.models;

import java.io.Serializable;

import com.files.models.Image;

public class ImageModel implements Serializable {
  public ImageModel() {
  }

  public ImageModel(final Image image) {
    initGroup1(image);
  }

  private void initGroup1(final Image image) {
    this.name = image.name;
    this.uri = image.uri;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  private String uri;

  public String getUri() {
    return uri;
  }

  public void setUri(final String uri) {
    this.uri = uri;
  }

}
