package com.files.mule.api.models;

import java.io.Serializable;

import com.files.models.Image;

public class ImageModel implements Serializable {
  public ImageModel() {
  }

  public ImageModel(final Image image) {
    this.name = image.name;
    this.uri = image.uri;
  }

  private String name;

  public String getName() {
    return name;
  }

  private String uri;

  public String getUri() {
    return uri;
  }

}
