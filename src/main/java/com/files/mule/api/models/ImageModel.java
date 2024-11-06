package com.files.mule.api.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
