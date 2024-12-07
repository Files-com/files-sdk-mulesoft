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
    this.type = preview.type;
    this.size = preview.size;
  }

  private Long id;

  public Long getId() {
    return id;
  }

  private String status;

  public String getStatus() {
    return status;
  }

  private String downloadUri;

  public String getDownloadUri() {
    return downloadUri;
  }

  private String type;

  public String getType() {
    return type;
  }

  private String size;

  public String getSize() {
    return size;
  }

}
