package com.files.mule.internal.operation.parameter;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class GroupParameterGroup {
  private GroupParameterGroup() {
  }

  public static class Show {
    @Parameter
    @Summary("Group ID.")
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
    @Summary("Group name.")
    @Example("name")
    public String name;

    public String getName() {
      return name;
    }

    public void setName(final String name) {
      this.name = name;
    }

    @Parameter
    @Optional
    @Summary("Group notes.")
    @Example("example")
    public String notes;

    public String getNotes() {
      return notes;
    }

    public void setNotes(final String notes) {
      this.notes = notes;
    }

    @Parameter
    @Optional
    @Summary("A list of user ids. If sent as a string, should be comma-delimited.")
    @Example("1")
    public String userIds;

    public String getUserIds() {
      return userIds;
    }

    public void setUserIds(final String userIds) {
      this.userIds = userIds;
    }

    @Parameter
    @Optional
    @Summary("A list of group admin user ids. If sent as a string, should be comma-delimited.")
    @Example("1")
    public String adminIds;

    public String getAdminIds() {
      return adminIds;
    }

    public void setAdminIds(final String adminIds) {
      this.adminIds = adminIds;
    }

  }

  public static class Update {
    @Parameter
    @Summary("Group ID.")
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
    @Summary("Group notes.")
    @Example("example")
    public String notes;

    public String getNotes() {
      return notes;
    }

    public void setNotes(final String notes) {
      this.notes = notes;
    }

    @Parameter
    @Optional
    @Summary("A list of user ids. If sent as a string, should be comma-delimited.")
    @Example("1")
    public String userIds;

    public String getUserIds() {
      return userIds;
    }

    public void setUserIds(final String userIds) {
      this.userIds = userIds;
    }

    @Parameter
    @Optional
    @Summary("A list of group admin user ids. If sent as a string, should be comma-delimited.")
    @Example("1")
    public String adminIds;

    public String getAdminIds() {
      return adminIds;
    }

    public void setAdminIds(final String adminIds) {
      this.adminIds = adminIds;
    }

    @Parameter
    @Optional
    @Summary("Group name.")
    @Example("owners")
    public String name;

    public String getName() {
      return name;
    }

    public void setName(final String name) {
      this.name = name;
    }

  }

  public static class Delete {
    @Parameter
    @Summary("Group ID.")
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
