/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.operation.parameter;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class ShareLinkNotificationParameterGroup {
  private ShareLinkNotificationParameterGroup() {
  }

  public static class Show {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
    @Optional
    @Summary("The id of the user to notify.")
    @Example("1")
    public Long notifyUserId;

    public Long getNotifyUserId() {
      return notifyUserId;
    }

    public void setNotifyUserId(final Long notifyUserId) {
      this.notifyUserId = notifyUserId;
    }

  }

  public static class Update {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
