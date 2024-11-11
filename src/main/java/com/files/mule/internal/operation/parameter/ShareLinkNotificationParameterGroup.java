package com.files.mule.internal.operation.parameter;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class ShareLinkNotificationParameterGroup {
  private ShareLinkNotificationParameterGroup() {
  }

  public static class Show {
    @Parameter
    @Summary("Bundle Notification ID.")
    @Example("1")
    public Long id;

    public Long getId() {
      return id;
    }

    public void setId(final Long id) {
      this.id = id;
    }

  }

  public static class Create {
    @Parameter
    @Summary("Bundle ID to notify on")
    @Example("1")
    public Long bundleId;

    public Long getBundleId() {
      return bundleId;
    }

    public void setBundleId(final Long bundleId) {
      this.bundleId = bundleId;
    }

    @Parameter
    @Optional
    @Summary("The id of the user to notify.")
    @Example("1")
    public Long userId;

    public Long getUserId() {
      return userId;
    }

    public void setUserId(final Long userId) {
      this.userId = userId;
    }

  }

  public static class Update {
    @Parameter
    @Summary("Bundle Notification ID.")
    @Example("1")
    public Long id;

    public Long getId() {
      return id;
    }

    public void setId(final Long id) {
      this.id = id;
    }

    @Parameter
    @Optional
    @Summary("Triggers bundle notification when a registration action occurs for it.")
    @Example("true")
    public boolean notifyOnRegistration;

    public boolean getNotifyOnRegistration() {
      return notifyOnRegistration;
    }

    public void setNotifyOnRegistration(final boolean notifyOnRegistration) {
      this.notifyOnRegistration = notifyOnRegistration;
    }

    @Parameter
    @Optional
    @Summary("Triggers bundle notification when a upload action occurs for it.")
    @Example("true")
    public boolean notifyOnUpload;

    public boolean getNotifyOnUpload() {
      return notifyOnUpload;
    }

    public void setNotifyOnUpload(final boolean notifyOnUpload) {
      this.notifyOnUpload = notifyOnUpload;
    }

  }

  public static class Delete {
    @Parameter
    @Summary("Bundle Notification ID.")
    @Example("1")
    public Long id;

    public Long getId() {
      return id;
    }

    public void setId(final Long id) {
      this.id = id;
    }

  }

}
