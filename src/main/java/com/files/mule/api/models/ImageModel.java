package com.files.mule.api.models;

import com.files.models.Image;

public class ImageModel extends AbstractModel {
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
