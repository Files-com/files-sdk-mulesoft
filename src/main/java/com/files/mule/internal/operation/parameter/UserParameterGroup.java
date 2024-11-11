package com.files.mule.internal.operation.parameter;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.annotation.values.OfValues;

import com.files.mule.internal.values.UserValueProviders;
import com.files.mule.internal.values.UserValueProviders.AuthenticationMethod;

public class UserParameterGroup {
  private UserParameterGroup() {
  }

  public static class Show {
    @Parameter
    @Summary("User ID.")
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
    @Summary("User's username")
    @Example("user")
    public String username;

    public String getUsername() {
      return username;
    }

    public void setUsername(final String username) {
      this.username = username;
    }

    @Parameter
    @Optional
    @Summary("User's email.")
    @Example("example")
    public String email;

    public String getEmail() {
      return email;
    }

    public void setEmail(final String email) {
      this.email = email;
    }

    @Parameter
    @Optional
    @Summary("A list of group ids to associate this user with.  Comma delimited.")
    @Example("example")
    public String groupIds;

    public String getGroupIds() {
      return groupIds;
    }

    public void setGroupIds(final String groupIds) {
      this.groupIds = groupIds;
    }

    @Parameter
    @Optional
    @Summary("User password.")
    public String password;

    public String getPassword() {
      return password;
    }

    public void setPassword(final String password) {
      this.password = password;
    }

    @Parameter
    @Optional
    @Summary("How is this user authenticated?")
    @OfValues(UserValueProviders.AuthenticationMethod.class)
    @Example("password")
    public String authenticationMethod;

    public String getAuthenticationMethod() {
      return authenticationMethod;
    }

    public void setAuthenticationMethod(final String authenticationMethod) {
      this.authenticationMethod = authenticationMethod;
    }

    @Parameter
    @Optional
    @Summary("User's full name")
    @Example("John Doe")
    public String name;

    public String getName() {
      return name;
    }

    public void setName(final String name) {
      this.name = name;
    }

    @Parameter
    @Optional
    @Summary("User's company")
    @Example("ACME Corp.")
    public String company;

    public String getCompany() {
      return company;
    }

    public void setCompany(final String company) {
      this.company = company;
    }

    @Parameter
    @Optional
    @Summary("Any internal notes on the user")
    @Example("Internal notes on this user.")
    public String notes;

    public String getNotes() {
      return notes;
    }

    public void setNotes(final String notes) {
      this.notes = notes;
    }

    @Parameter
    @Optional
    @Summary("Is a password change required upon next user login?")
    @Example("true")
    public boolean requirePasswordChange;

    public boolean getRequirePasswordChange() {
      return requirePasswordChange;
    }

    public void setRequirePasswordChange(final boolean requirePasswordChange) {
      this.requirePasswordChange = requirePasswordChange;
    }

    @Parameter
    @Optional
    @Summary("Root folder for FTP (and optionally SFTP if the appropriate site-wide setting is set).  Note that this is not used for API, Desktop, or Web interface.")
    @Example("example")
    public String userRoot;

    public String getUserRoot() {
      return userRoot;
    }

    public void setUserRoot(final String userRoot) {
      this.userRoot = userRoot;
    }

    @Parameter
    @Optional
    @Summary("Home folder for FTP/SFTP.  Note that this is not used for API, Desktop, or Web interface.")
    @Example("example")
    public String userHome;

    public String getUserHome() {
      return userHome;
    }

    public void setUserHome(final String userHome) {
      this.userHome = userHome;
    }

  }

  public static class Update {
    @Parameter
    @Summary("User ID.")
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
    @Summary("User's email.")
    @Example("example")
    public String email;

    public String getEmail() {
      return email;
    }

    public void setEmail(final String email) {
      this.email = email;
    }

    @Parameter
    @Optional
    @Summary("A list of group ids to associate this user with.  Comma delimited.")
    @Example("example")
    public String groupIds;

    public String getGroupIds() {
      return groupIds;
    }

    public void setGroupIds(final String groupIds) {
      this.groupIds = groupIds;
    }

    @Parameter
    @Optional
    @Summary("User password.")
    public String password;

    public String getPassword() {
      return password;
    }

    public void setPassword(final String password) {
      this.password = password;
    }

    @Parameter
    @Optional
    @Summary("How is this user authenticated?")
    @OfValues(UserValueProviders.AuthenticationMethod.class)
    @Example("password")
    public String authenticationMethod;

    public String getAuthenticationMethod() {
      return authenticationMethod;
    }

    public void setAuthenticationMethod(final String authenticationMethod) {
      this.authenticationMethod = authenticationMethod;
    }

    @Parameter
    @Optional
    @Summary("User's full name")
    @Example("John Doe")
    public String name;

    public String getName() {
      return name;
    }

    public void setName(final String name) {
      this.name = name;
    }

    @Parameter
    @Optional
    @Summary("User's company")
    @Example("ACME Corp.")
    public String company;

    public String getCompany() {
      return company;
    }

    public void setCompany(final String company) {
      this.company = company;
    }

    @Parameter
    @Optional
    @Summary("Any internal notes on the user")
    @Example("Internal notes on this user.")
    public String notes;

    public String getNotes() {
      return notes;
    }

    public void setNotes(final String notes) {
      this.notes = notes;
    }

    @Parameter
    @Optional
    @Summary("Is a password change required upon next user login?")
    @Example("true")
    public boolean requirePasswordChange;

    public boolean getRequirePasswordChange() {
      return requirePasswordChange;
    }

    public void setRequirePasswordChange(final boolean requirePasswordChange) {
      this.requirePasswordChange = requirePasswordChange;
    }

    @Parameter
    @Optional
    @Summary("Root folder for FTP (and optionally SFTP if the appropriate site-wide setting is set).  Note that this is not used for API, Desktop, or Web interface.")
    @Example("example")
    public String userRoot;

    public String getUserRoot() {
      return userRoot;
    }

    public void setUserRoot(final String userRoot) {
      this.userRoot = userRoot;
    }

    @Parameter
    @Optional
    @Summary("Home folder for FTP/SFTP.  Note that this is not used for API, Desktop, or Web interface.")
    @Example("example")
    public String userHome;

    public String getUserHome() {
      return userHome;
    }

    public void setUserHome(final String userHome) {
      this.userHome = userHome;
    }

    @Parameter
    @Optional
    @Summary("User's username")
    @Example("user")
    public String username;

    public String getUsername() {
      return username;
    }

    public void setUsername(final String username) {
      this.username = username;
    }

  }

  public static class Delete {
    @Parameter
    @Summary("User ID.")
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
