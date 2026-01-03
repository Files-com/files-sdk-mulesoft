/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;

import com.files.models.BundleDownload;

/**
 * A BundleDownload is a record of the download action that happened in the bundle.
 */
public class ShareLinkDownloadModel implements Serializable {
  public ShareLinkDownloadModel() {
  }

  public ShareLinkDownloadModel(final BundleDownload bundleDownload) {
    initGroup1(bundleDownload);
  }

  private void initGroup1(final BundleDownload bundleDownload) {
    if (bundleDownload.bundleRegistration != null) {
      this.bundleRegistration = new ShareLinkRegistrationModel(bundleDownload.bundleRegistration);
    }
    this.downloadMethod = bundleDownload.downloadMethod;
    this.path = bundleDownload.path;
    this.createdAt = bundleDownload.createdAt != null ? ZonedDateTime.ofInstant(bundleDownload.createdAt.toInstant(), ZoneId.systemDefault()) : null;
  }

  private ShareLinkRegistrationModel bundleRegistration;

  public ShareLinkRegistrationModel getBundleRegistration() {
    return bundleRegistration;
  }

  public void setBundleRegistration(final ShareLinkRegistrationModel bundleRegistration) {
    this.bundleRegistration = bundleRegistration;
  }

  private String downloadMethod;

  public String getDownloadMethod() {
    return downloadMethod;
  }

  public void setDownloadMethod(final String downloadMethod) {
    this.downloadMethod = downloadMethod;
  }

  private String path;

  public String getPath() {
    return path;
  }

  public void setPath(final String path) {
    this.path = path;
  }

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

}
