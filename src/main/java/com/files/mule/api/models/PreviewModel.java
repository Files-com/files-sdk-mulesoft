/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;

import com.files.models.Preview;

/**
 * A Preview is an image or PDF preview that is meant to be viewed within the web interface.
 */
public class PreviewModel implements Serializable {
  public PreviewModel() {
  }

  public PreviewModel(final Preview preview) {
    initGroup1(preview);
  }

  private void initGroup1(final Preview preview) {
    this.id = preview.id;
    this.status = preview.status;
    this.downloadUri = preview.downloadUri;
    this.previewType = preview.type;
    this.size = preview.size;
  }

  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(final String status) {
    this.status = status;
  }

  private String downloadUri;

  public String getDownloadUri() {
    return downloadUri;
  }

  public void setDownloadUri(final String downloadUri) {
    this.downloadUri = downloadUri;
  }

  private String previewType;

  public String getPreviewType() {
    return previewType;
  }

  public void setPreviewType(final String previewType) {
    this.previewType = previewType;
  }

  private String size;

  public String getSize() {
    return size;
  }

  public void setSize(final String size) {
    this.size = size;
  }

}
