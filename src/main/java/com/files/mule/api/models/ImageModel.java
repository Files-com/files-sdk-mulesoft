/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
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
