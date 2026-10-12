/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
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
    this.id = SdkFields.read(group, "id", Long.class);
    this.name = SdkFields.read(group, "name", String.class);
    this.allowedIps = SdkFields.read(group, "allowedIps", String.class);
    this.adminIds = SdkFields.read(group, "adminIds", String.class);
    this.notes = SdkFields.read(group, "notes", String.class);
    this.userIds = SdkFields.read(group, "userIds", String.class);
    this.usernames = SdkFields.read(group, "usernames", String.class);
    this.aiAssistantPersonalityId = SdkFields.read(group, "aiAssistantPersonalityId", Long.class);
    this.ftpPermission = Boolean.TRUE.equals(SdkFields.read(group, "ftpPermission", Boolean.class));
    this.sftpPermission = Boolean.TRUE.equals(SdkFields.read(group, "sftpPermission", Boolean.class));
  }

  private void initGroup2(final Group group) {
    this.davPermission = Boolean.TRUE.equals(SdkFields.read(group, "davPermission", Boolean.class));
    this.restapiPermission = Boolean.TRUE.equals(SdkFields.read(group, "restapiPermission", Boolean.class));
    this.s3CompatibleEndpointPermission = Boolean.TRUE.equals(SdkFields.read(group, "s3CompatibleEndpointPermission", Boolean.class));
    this.desktopConfigurationProfileId = SdkFields.read(group, "desktopConfigurationProfileId", Long.class);
    this.integrationCentricProfileId = SdkFields.read(group, "integrationCentricProfileId", Long.class);
    this.siteId = SdkFields.read(group, "siteId", Long.class);
    this.workspaceId = SdkFields.read(group, "workspaceId", Long.class);
  }

  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  private String allowedIps;

  public String getAllowedIps() {
    return allowedIps;
  }

  public void setAllowedIps(final String allowedIps) {
    this.allowedIps = allowedIps;
  }

  private String adminIds;

  public String getAdminIds() {
    return adminIds;
  }

  public void setAdminIds(final String adminIds) {
    this.adminIds = adminIds;
  }

  private String notes;

  public String getNotes() {
    return notes;
  }

  public void setNotes(final String notes) {
    this.notes = notes;
  }

  private String userIds;

  public String getUserIds() {
    return userIds;
  }

  public void setUserIds(final String userIds) {
    this.userIds = userIds;
  }

  private String usernames;

  public String getUsernames() {
    return usernames;
  }

  public void setUsernames(final String usernames) {
    this.usernames = usernames;
  }

  private Long aiAssistantPersonalityId;

  public Long getAiAssistantPersonalityId() {
    return aiAssistantPersonalityId;
  }

  public void setAiAssistantPersonalityId(final Long aiAssistantPersonalityId) {
    this.aiAssistantPersonalityId = aiAssistantPersonalityId;
  }

  private boolean ftpPermission;

  public boolean getFtpPermission() {
    return ftpPermission;
  }

  public void setFtpPermission(final boolean ftpPermission) {
    this.ftpPermission = ftpPermission;
  }

  private boolean sftpPermission;

  public boolean getSftpPermission() {
    return sftpPermission;
  }

  public void setSftpPermission(final boolean sftpPermission) {
    this.sftpPermission = sftpPermission;
  }

  private boolean davPermission;

  public boolean getDavPermission() {
    return davPermission;
  }

  public void setDavPermission(final boolean davPermission) {
    this.davPermission = davPermission;
  }

  private boolean restapiPermission;

  public boolean getRestapiPermission() {
    return restapiPermission;
  }

  public void setRestapiPermission(final boolean restapiPermission) {
    this.restapiPermission = restapiPermission;
  }

  private boolean s3CompatibleEndpointPermission;

  public boolean getS3CompatibleEndpointPermission() {
    return s3CompatibleEndpointPermission;
  }

  public void setS3CompatibleEndpointPermission(final boolean s3CompatibleEndpointPermission) {
    this.s3CompatibleEndpointPermission = s3CompatibleEndpointPermission;
  }

  private Long desktopConfigurationProfileId;

  public Long getDesktopConfigurationProfileId() {
    return desktopConfigurationProfileId;
  }

  public void setDesktopConfigurationProfileId(final Long desktopConfigurationProfileId) {
    this.desktopConfigurationProfileId = desktopConfigurationProfileId;
  }

  private Long integrationCentricProfileId;

  public Long getIntegrationCentricProfileId() {
    return integrationCentricProfileId;
  }

  public void setIntegrationCentricProfileId(final Long integrationCentricProfileId) {
    this.integrationCentricProfileId = integrationCentricProfileId;
  }

  private Long siteId;

  public Long getSiteId() {
    return siteId;
  }

  public void setSiteId(final Long siteId) {
    this.siteId = siteId;
  }

  private Long workspaceId;

  public Long getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(final Long workspaceId) {
    this.workspaceId = workspaceId;
  }

}
