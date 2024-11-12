package com.files.mule.internal.operation.parameter;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class ShareLinkRecipientParameterGroup {
  private ShareLinkRecipientParameterGroup() {
  }

  public static class List {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Summary("List recipients for the bundle with this ID.")
    @Example("1")
    public Long bundleId;

    public Long getBundleId() {
      return bundleId;
    }

    public void setBundleId(final Long bundleId) {
      this.bundleId = bundleId;
    }

  }

  public static class Create {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Summary("Bundle to share.")
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
    @Summary("Email addresses to share this bundle with.")
    @Example("johndoe@gmail.com")
    public String recipient;

    public String getRecipient() {
      return recipient;
    }

    public void setRecipient(final String recipient) {
      this.recipient = recipient;
    }

    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Optional
    @Summary("Name of recipient.")
    @Example("John Smith")
    public String name;

    public String getName() {
      return name;
    }

    public void setName(final String name) {
      this.name = name;
    }

    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Optional
    @Summary("Company of recipient.")
    @Example("Acme Ltd")
    public String company;

    public String getCompany() {
      return company;
    }

    public void setCompany(final String company) {
      this.company = company;
    }

    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Optional
    @Summary("Note to include in email.")
    @Example("Just a note.")
    public String note;

    public String getNote() {
      return note;
    }

    public void setNote(final String note) {
      this.note = note;
    }

  }

}
