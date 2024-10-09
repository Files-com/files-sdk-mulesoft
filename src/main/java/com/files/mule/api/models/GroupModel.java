package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

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
    this.id = group.id;
    this.name = group.name;
    this.allowedIps = group.allowedIps;
    this.adminIds = group.adminIds;
    this.notes = group.notes;
    this.userIds = group.userIds;
    this.usernames = group.usernames;
    this.ftpPermission = group.ftpPermission;
    this.sftpPermission = group.sftpPermission;
    this.davPermission = group.davPermission;
    this.restapiPermission = group.restapiPermission;
  }

  /**
   * Group ID
   */
  @Parameter
  public Long id;

  public Long getId() {
    return id;
  }

  /**
   * Group name
   */
  @Parameter
  public String name;

  public String getName() {
    return name;
  }

  /**
   * A list of allowed IPs if applicable.  Newline delimited
   */
  @Parameter
  public String allowedIps;

  public String getAllowedIps() {
    return allowedIps;
  }

  /**
   * Comma-delimited list of user IDs who are group administrators (separated by commas)
   */
  @Parameter
  public String adminIds;

  public String getAdminIds() {
    return adminIds;
  }

  /**
   * Notes about this group
   */
  @Parameter
  public String notes;

  public String getNotes() {
    return notes;
  }

  /**
   * Comma-delimited list of user IDs who belong to this group (separated by commas)
   */
  @Parameter
  public String userIds;

  public String getUserIds() {
    return userIds;
  }

  /**
   * Comma-delimited list of usernames who belong to this group (separated by commas)
   */
  @Parameter
  public String usernames;

  public String getUsernames() {
    return usernames;
  }

  /**
   * If true, users in this group can use FTP to login.  This will override a false value of `ftp_permission` on the user level.
   */
  @Parameter
  public Boolean ftpPermission;

  public Boolean getFtpPermission() {
    return ftpPermission;
  }

  /**
   * If true, users in this group can use SFTP to login.  This will override a false value of `sftp_permission` on the user level.
   */
  @Parameter
  public Boolean sftpPermission;

  public Boolean getSftpPermission() {
    return sftpPermission;
  }

  /**
   * If true, users in this group can use WebDAV to login.  This will override a false value of `dav_permission` on the user level.
   */
  @Parameter
  public Boolean davPermission;

  public Boolean getDavPermission() {
    return davPermission;
  }

  /**
   * If true, users in this group can use the REST API to login.  This will override a false value of `restapi_permission` on the user level.
   */
  @Parameter
  public Boolean restapiPermission;

  public Boolean getRestapiPermission() {
    return restapiPermission;
  }

}
