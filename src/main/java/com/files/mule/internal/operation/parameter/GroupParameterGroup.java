/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.operation.parameter;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class GroupParameterGroup {
  private GroupParameterGroup() {
  }

  public static class Show {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
    @Placement(tab = Placement.DEFAULT_TAB)
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
