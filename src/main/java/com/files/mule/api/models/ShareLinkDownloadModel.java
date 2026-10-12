/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Date;

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
    this.bundleRegistration = SdkFields.read(bundleDownload, "bundleRegistration", com.files.models.BundleRegistration.class, ShareLinkRegistrationModel::new);
    this.downloadMethod = SdkFields.read(bundleDownload, "downloadMethod", String.class);
    this.path = SdkFields.read(bundleDownload, "path", String.class);
    this.workspaceId = SdkFields.read(bundleDownload, "workspaceId", Long.class);
    this.createdAt = SdkFields.read(bundleDownload, "createdAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
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

  private Long workspaceId;

  public Long getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(final Long workspaceId) {
    this.workspaceId = workspaceId;
  }

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

}
