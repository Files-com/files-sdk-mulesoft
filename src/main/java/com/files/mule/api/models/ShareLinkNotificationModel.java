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

  private Long id;

  public Long getId() {
    return id;
  }

  private boolean notifyOnRegistration;

  public boolean getNotifyOnRegistration() {
    return notifyOnRegistration;
  }

  private boolean notifyOnUpload;

  public boolean getNotifyOnUpload() {
    return notifyOnUpload;
  }

  private Long userId;

  public Long getUserId() {
    return userId;
  }

}
