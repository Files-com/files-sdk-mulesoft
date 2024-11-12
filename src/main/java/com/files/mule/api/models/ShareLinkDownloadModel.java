package com.files.mule.api.models;

import java.time.ZonedDateTime;

import com.files.models.BundleDownload;

/**
 * A BundleDownload is a record of the download action that happened in the bundle.
 */
public class ShareLinkDownloadModel extends AbstractModel {
  public ShareLinkDownloadModel() {
  }

  public ShareLinkDownloadModel(final BundleDownload bundleDownload) {
    if (bundleDownload.bundleRegistration != null) {
      this.bundleRegistration = new ShareLinkRegistrationModel(bundleDownload.bundleRegistration);
    }
    this.downloadMethod = bundleDownload.downloadMethod;
    this.path = bundleDownload.path;
    this.createdAt = toZonedDateTime(bundleDownload.createdAt);
  }

  private ShareLinkRegistrationModel bundleRegistration;

  public ShareLinkRegistrationModel getBundleRegistration() {
    return bundleRegistration;
  }

  private String downloadMethod;

  public String getDownloadMethod() {
    return downloadMethod;
  }

  private String path;

  public String getPath() {
    return path;
  }

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

}
