package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

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
    this.notifyOnRegistration = bundleNotification.notifyOnRegistration;
    this.notifyOnUpload = bundleNotification.notifyOnUpload;
    this.userId = bundleNotification.userId;
  }

  /**
   * Bundle ID to notify on
   */
  @Parameter
  public Long bundleId;

  public Long getBundleId() {
    return bundleId;
  }

  /**
   * Bundle Notification ID
   */
  @Parameter
  public Long id;

  public Long getId() {
    return id;
  }

  /**
   * Triggers bundle notification when a registration action occurs for it.
   */
  @Parameter
  public Boolean notifyOnRegistration;

  public Boolean getNotifyOnRegistration() {
    return notifyOnRegistration;
  }

  /**
   * Triggers bundle notification when a upload action occurs for it.
   */
  @Parameter
  public Boolean notifyOnUpload;

  public Boolean getNotifyOnUpload() {
    return notifyOnUpload;
  }

  /**
   * The id of the user to notify.
   */
  @Parameter
  public Long userId;

  public Long getUserId() {
    return userId;
  }

}
