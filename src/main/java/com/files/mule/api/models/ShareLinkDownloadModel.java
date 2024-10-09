package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

import com.files.models.BundleDownload;

/**
 * A BundleDownload is a record of the download action that happened in the bundle.
 */
public class ShareLinkDownloadModel implements Serializable {
  public ShareLinkDownloadModel() {
  }

  public ShareLinkDownloadModel(final BundleDownload bundleDownload) {
    if (bundleDownload.bundleRegistration != null) {
      this.bundleRegistration = new ShareLinkRegistrationModel(bundleDownload.bundleRegistration);
    }
    this.downloadMethod = bundleDownload.downloadMethod;
    this.path = bundleDownload.path;
    this.createdAt = bundleDownload.createdAt;
  }

  /**
   */
  @Parameter
  public ShareLinkRegistrationModel bundleRegistration;

  public ShareLinkRegistrationModel getBundleRegistration() {
    return bundleRegistration;
  }

  /**
   * Download method (file or full_zip)
   */
  @Parameter
  public String downloadMethod;

  public String getDownloadMethod() {
    return downloadMethod;
  }

  /**
   * Download path. This must be slash-delimited, but it must neither start nor end with a slash. Maximum of 5000 characters.
   */
  @Parameter
  public String path;

  public String getPath() {
    return path;
  }

  /**
   * Download date/time
   */
  @Parameter
  public Date createdAt;

  public Date getCreatedAt() {
    return createdAt;
  }

}
