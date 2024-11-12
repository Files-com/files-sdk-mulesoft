package com.files.mule.internal.operation.parameter;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class ShareLinkRegistrationParameterGroup {
  private ShareLinkRegistrationParameterGroup() {
  }

  public static class List {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Optional
    @Summary("ID of the associated Bundle")
    @Example("1")
    public Long bundleId;

    public Long getBundleId() {
      return bundleId;
    }

    public void setBundleId(final Long bundleId) {
      this.bundleId = bundleId;
    }

  }

}
