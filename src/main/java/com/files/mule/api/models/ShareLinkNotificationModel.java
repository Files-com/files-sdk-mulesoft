/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;

import com.files.models.BundleNotification;

/**
 * A BundleNotification is an E-Mail sent out to users when certain actions are performed on or within a shared set of files and folders.
 */
public class ShareLinkNotificationModel implements Serializable {
  public ShareLinkNotificationModel() {
  }

  public ShareLinkNotificationModel(final BundleNotification bundleNotification) {
    initGroup1(bundleNotification);
  }

  private void initGroup1(final BundleNotification bundleNotification) {
    this.bundleId = bundleNotification.bundleId;
    this.id = bundleNotification.id;
    this.notifyOnRegistration = Boolean.TRUE.equals(bundleNotification.notifyOnRegistration);
    this.notifyOnUpload = Boolean.TRUE.equals(bundleNotification.notifyOnUpload);
    this.userId = bundleNotification.userId;
  }

  private Long bundleId;

  public Long getBundleId() {
    return bundleId;
  }

  public void setBundleId(final Long bundleId) {
    this.bundleId = bundleId;
  }

  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  private boolean notifyOnRegistration;

  public boolean getNotifyOnRegistration() {
    return notifyOnRegistration;
  }

  public void setNotifyOnRegistration(final boolean notifyOnRegistration) {
    this.notifyOnRegistration = notifyOnRegistration;
  }

  private boolean notifyOnUpload;

  public boolean getNotifyOnUpload() {
    return notifyOnUpload;
  }

  public void setNotifyOnUpload(final boolean notifyOnUpload) {
    this.notifyOnUpload = notifyOnUpload;
  }

  private Long userId;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

}
