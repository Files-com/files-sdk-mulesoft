package com.files.mule.api.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    if (bundleDownload.createdAt != null) {
      this.createdAt = ZonedDateTime.ofInstant(bundleDownload.createdAt.toInstant(), ZoneId.systemDefault());
    }
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
