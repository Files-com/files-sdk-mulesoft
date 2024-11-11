package com.files.mule.internal.operation.parameter;

import java.util.List;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class ShareLinkParameterGroup {
  private ShareLinkParameterGroup() {
  }

  public static class Show {
    @Parameter
    @Summary("Bundle ID.")
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
    @Summary("A list of paths to include in this bundle.")
    @Example("[\"file.txt\"]")
    public List<String> paths;

    public List<String> getPaths() {
      return paths;
    }

    public void setPaths(final List<String> paths) {
      this.paths = paths;
    }

    @Parameter
    @Optional
    @Summary("Password for this bundle.")
    @Example("Password")
    public String password;

    public String getPassword() {
      return password;
    }

    public void setPassword(final String password) {
      this.password = password;
    }

    @Parameter
    @Optional
    @Summary("Bundle expiration date/time")
    @Example("2000-01-01T01:00:00Z")
    public String expiresAt;

    public String getExpiresAt() {
      return expiresAt;
    }

    public void setExpiresAt(final String expiresAt) {
      this.expiresAt = expiresAt;
    }

    @Parameter
    @Optional
    @Summary("Maximum number of times bundle can be accessed")
    @Example("1")
    public Long maxUses;

    public Long getMaxUses() {
      return maxUses;
    }

    public void setMaxUses(final Long maxUses) {
      this.maxUses = maxUses;
    }

    @Parameter
    @Optional
    @Summary("Public description")
    @Example("The public description of the bundle.")
    public String description;

    public String getDescription() {
      return description;
    }

    public void setDescription(final String description) {
      this.description = description;
    }

    @Parameter
    @Optional
    @Summary("Bundle internal note")
    @Example("The internal note on the bundle.")
    public String note;

    public String getNote() {
      return note;
    }

    public void setNote(final String note) {
      this.note = note;
    }

    @Parameter
    @Optional
    @Summary("Show a registration page that captures the downloader's name and email address?")
    @Example("true")
    public boolean requireRegistration;

    public boolean getRequireRegistration() {
      return requireRegistration;
    }

    public void setRequireRegistration(final boolean requireRegistration) {
      this.requireRegistration = requireRegistration;
    }

  }

  public static class Update {
    @Parameter
    @Summary("Bundle ID.")
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
    @Summary("Bundle expiration date/time")
    @Example("2000-01-01T01:00:00Z")
    public String expiresAt;

    public String getExpiresAt() {
      return expiresAt;
    }

    public void setExpiresAt(final String expiresAt) {
      this.expiresAt = expiresAt;
    }

  }

  public static class Delete {
    @Parameter
    @Summary("Bundle ID.")
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
