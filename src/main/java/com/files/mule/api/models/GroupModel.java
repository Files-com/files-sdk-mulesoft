package com.files.mule.api.models;

import java.io.Serializable;

import com.files.models.Group;

/**
 * A Group is a powerful tool for permissions and user management on Files.com.  Users can belong to multiple groups.
 *
 * All permissions can be managed via Groups, and Groups can also be synced to your identity platform via LDAP or SCIM.
 *
 * Files.com's Group Admin feature allows you to define Group Admins, who then have access to add and remove users within their groups.
 */
public class GroupModel implements Serializable {
  public GroupModel() {
  }

  public GroupModel(final Group group) {
    initGroup1(group);
    initGroup2(group);
  }

  private void initGroup1(final Group group) {
    this.id = group.id;
    this.name = group.name;
    this.allowedIps = group.allowedIps;
    this.adminIds = group.adminIds;
    this.notes = group.notes;
    this.userIds = group.userIds;
    this.usernames = group.usernames;
    this.ftpPermission = Boolean.TRUE.equals(group.ftpPermission);
    this.sftpPermission = Boolean.TRUE.equals(group.sftpPermission);
    this.davPermission = Boolean.TRUE.equals(group.davPermission);
  }

  private void initGroup2(final Group group) {
    this.restapiPermission = Boolean.TRUE.equals(group.restapiPermission);
    this.siteId = group.siteId;
  }

  private Long id;

  public Long getId() {
    return id;
  }

  private String name;

  public String getName() {
    return name;
  }

  private String allowedIps;

  public String getAllowedIps() {
    return allowedIps;
  }

  private String adminIds;

  public String getAdminIds() {
    return adminIds;
  }

  private String notes;

  public String getNotes() {
    return notes;
  }

  private String userIds;

  public String getUserIds() {
    return userIds;
  }

  private String usernames;

  public String getUsernames() {
    return usernames;
  }

  private boolean ftpPermission;

  public boolean getFtpPermission() {
    return ftpPermission;
  }

  private boolean sftpPermission;

  public boolean getSftpPermission() {
    return sftpPermission;
  }

  private boolean davPermission;

  public boolean getDavPermission() {
    return davPermission;
  }

  private boolean restapiPermission;

  public boolean getRestapiPermission() {
    return restapiPermission;
  }

  private Long siteId;

  public Long getSiteId() {
    return siteId;
  }

}
