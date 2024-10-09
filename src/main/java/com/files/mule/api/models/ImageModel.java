package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

import com.files.models.Image;

public class ImageModel implements Serializable {
  public ImageModel() {
  }

  public ImageModel(final Image image) {
    this.name = image.name;
    this.uri = image.uri;
  }

  /**
   * Image name
   */
  @Parameter
  public String name;

  public String getName() {
    return name;
  }

  /**
   * Image URI
   */
  @Parameter
  public String uri;

  public String getUri() {
    return uri;
  }

}
