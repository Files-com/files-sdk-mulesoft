package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

import com.files.models.Preview;

/**
 * A Preview is an image or PDF preview that is meant to be viewed within the web interface.
 */
public class PreviewModel implements Serializable {
  public PreviewModel() {
  }

  public PreviewModel(final Preview preview) {
    this.id = preview.id;
    this.status = preview.status;
    this.downloadUri = preview.downloadUri;
    this.type = preview.type;
    this.size = preview.size;
  }

  /**
   * Preview ID
   */
  @Parameter
  public Long id;

  public Long getId() {
    return id;
  }

  /**
   * Preview status.  Can be invalid, not_generated, generating, complete, or file_too_large
   */
  @Parameter
  public String status;

  public String getStatus() {
    return status;
  }

  /**
   * Link to download preview
   */
  @Parameter
  public String downloadUri;

  public String getDownloadUri() {
    return downloadUri;
  }

  /**
   * Preview type. Can be image, pdf, pdf_native, video, or audio
   */
  @Parameter
  public String type;

  public String getType() {
    return type;
  }

  /**
   * Preview size
   */
  @Parameter
  public String size;

  public String getSize() {
    return size;
  }

}
