/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.files.models.User;

/**
 * A User represents a human or system/service user with the ability to connect to Files.com via any of the available connectivity methods (unless restricted to specific protocols).
 *
 * Users are associated with API Keys, SSH (SFTP) Keys, Notifications, Permissions, and Group memberships.
 *
 *
 * ## Authentication
 *
 * The `authentication_method` property on a User determines exactly how that user can login and authenticate to their Files.com account. Files.com offers a variety of authentication methods to ensure flexibility, security, migration, and compliance.
 *
 * These authentication methods can be configured during user creation and can be modified at any time by site administrators. The meanings of the available values are as follows:
 *
 * * `password` - Allows authentication via a password.  If API Keys or SSH (SFTP) Keys are also configured, those can be used *instead* of the password.  If Two Factor Authentication (2FA) methods are also configured, a valid 2nd factor is required in addition to the password.
 * * `email_signup` - When set upon user creation, an email will be sent to the new user with a link for them to create their password. Once the user has created their password, their authentication type will change to `password`.
 * * `sso` - Allows authentication via a linked Single Sign On provider.  If API Keys or SSH (SFTP) Keys are also configured, those can be used *instead* of Single Sign On.  If Two Factor Authentication (2FA) methods are also configured, a valid 2nd factor is required in addition to Single Sign On.  When using this method, you must also provide a valid `sso_strategy_id` to associate the User to the appropriate SSO provider.
 * * `password_with_imported_hash` - Works like the `password` method but allows importing a hashed password in MD5, SHA-1, or SHA-256 format.  Provide the imported hash in the field `imported_password_hash`.  Upon first use, the password will be converted to Files.com's internal storage format and the authentication type will change to `password`. Typically only used when migrating to Files.com from another MFT solution.
 * * `none` - Does not allow authentication via username and password, but does allow authentication via API Key or SSH (SFTP) Key.  Typically only used for service users.
 * * `password_and_ssh_key` - Allows authentication only by providing a password and also a valid SSH (SFTP) Key in a single attempt.  If API Keys are also configured, those can be used *instead* of the password and key combination.  This method only works with (typically enterprise) SSH/SFTP clients capable of sending both authentication methods at once.  Typically only used for service users.
 */
public class UserModel implements Serializable {
  public UserModel() {
  }

  public UserModel(final User user) {
    initGroup1(user);
    initGroup2(user);
    initGroup3(user);
    initGroup4(user);
    initGroup5(user);
    initGroup6(user);
    initGroup7(user);
    initGroup8(user);
    initGroup9(user);
    initGroup10(user);
  }

  private void initGroup1(final User user) {
    this.id = SdkFields.read(user, "id", Long.class);
    this.username = SdkFields.read(user, "username", String.class);
    this.adminGroupIds = SdkFields.read(user, "adminGroupIds", Long[].class, Arrays::asList);
    this.allowedIps = SdkFields.read(user, "allowedIps", String.class);
    this.attachmentsPermission = Boolean.TRUE.equals(SdkFields.read(user, "attachmentsPermission", Boolean.class));
    this.apiKeysCount = SdkFields.read(user, "apiKeysCount", Long.class);
    this.authenticateUntil = SdkFields.read(user, "authenticateUntil", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.authenticationMethod = SdkFields.read(user, "authenticationMethod", String.class);
    this.avatarUrl = SdkFields.read(user, "avatarUrl", String.class);
    this.billable = Boolean.TRUE.equals(SdkFields.read(user, "billable", Boolean.class));
  }

  private void initGroup2(final User user) {
    this.billingPermission = Boolean.TRUE.equals(SdkFields.read(user, "billingPermission", Boolean.class));
    this.bypassSiteAllowedIps = Boolean.TRUE.equals(SdkFields.read(user, "bypassSiteAllowedIps", Boolean.class));
    this.bypassUserLifecycleRules = Boolean.TRUE.equals(SdkFields.read(user, "bypassUserLifecycleRules", Boolean.class));
    this.createdAt = SdkFields.read(user, "createdAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.davPermission = Boolean.TRUE.equals(SdkFields.read(user, "davPermission", Boolean.class));
    this.disabled = Boolean.TRUE.equals(SdkFields.read(user, "disabled", Boolean.class));
    this.disabledExpiredOrInactive = Boolean.TRUE.equals(SdkFields.read(user, "disabledExpiredOrInactive", Boolean.class));
    this.aiAssistantPersonalityId = SdkFields.read(user, "aiAssistantPersonalityId", Long.class);
    this.desktopConfigurationProfileId = SdkFields.read(user, "desktopConfigurationProfileId", Long.class);
    this.integrationCentricProfileId = SdkFields.read(user, "integrationCentricProfileId", Long.class);
  }

  private void initGroup3(final User user) {
    this.email = SdkFields.read(user, "email", String.class);
    this.filesystemLayout = SdkFields.read(user, "filesystemLayout", String.class);
    this.firstLoginAt = SdkFields.read(user, "firstLoginAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.ftpPermission = Boolean.TRUE.equals(SdkFields.read(user, "ftpPermission", Boolean.class));
    this.groupIds = SdkFields.read(user, "groupIds", String.class);
    this.headerText = SdkFields.read(user, "headerText", String.class);
    this.language = SdkFields.read(user, "language", String.class);
    this.lastLoginAt = SdkFields.read(user, "lastLoginAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.lastWebLoginAt = SdkFields.read(user, "lastWebLoginAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.lastFtpLoginAt = SdkFields.read(user, "lastFtpLoginAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
  }

  private void initGroup4(final User user) {
    this.lastSftpLoginAt = SdkFields.read(user, "lastSftpLoginAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.lastDavLoginAt = SdkFields.read(user, "lastDavLoginAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.lastDesktopLoginAt = SdkFields.read(user, "lastDesktopLoginAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.lastRestapiLoginAt = SdkFields.read(user, "lastRestapiLoginAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.lastApiUseAt = SdkFields.read(user, "lastApiUseAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.lastActiveAt = SdkFields.read(user, "lastActiveAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.lastProtocolCipher = SdkFields.read(user, "lastProtocolCipher", String.class);
    this.lockoutExpires = SdkFields.read(user, "lockoutExpires", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.name = SdkFields.read(user, "name", String.class);
    this.company = SdkFields.read(user, "company", String.class);
  }

  private void initGroup5(final User user) {
    this.notes = SdkFields.read(user, "notes", String.class);
    this.notificationDailySendTime = SdkFields.read(user, "notificationDailySendTime", Long.class);
    this.officeIntegrationEnabled = Boolean.TRUE.equals(SdkFields.read(user, "officeIntegrationEnabled", Boolean.class));
    this.partnerAdmin = Boolean.TRUE.equals(SdkFields.read(user, "partnerAdmin", Boolean.class));
    this.partnerId = SdkFields.read(user, "partnerId", Long.class);
    this.partnerName = SdkFields.read(user, "partnerName", String.class);
    this.passwordSetAt = SdkFields.read(user, "passwordSetAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.passwordValidityDays = SdkFields.read(user, "passwordValidityDays", Long.class);
    this.primaryGroupId = SdkFields.read(user, "primaryGroupId", Long.class);
    this.publicKeysCount = SdkFields.read(user, "publicKeysCount", Long.class);
  }

  private void initGroup6(final User user) {
    this.receiveAdminAlerts = Boolean.TRUE.equals(SdkFields.read(user, "receiveAdminAlerts", Boolean.class));
    this.notifyOnAllSiteWarnings = Boolean.TRUE.equals(SdkFields.read(user, "notifyOnAllSiteWarnings", Boolean.class));
    this.notifyOnAllSsoFailures = Boolean.TRUE.equals(SdkFields.read(user, "notifyOnAllSsoFailures", Boolean.class));
    this.notifyOnAllUserSecurityEvents = Boolean.TRUE.equals(SdkFields.read(user, "notifyOnAllUserSecurityEvents", Boolean.class));
    this.notifyOnAllPendingWorkFailures = Boolean.TRUE.equals(SdkFields.read(user, "notifyOnAllPendingWorkFailures", Boolean.class));
    this.notifyOnAllSiemHttpDestinationFailures = Boolean.TRUE.equals(SdkFields.read(user, "notifyOnAllSiemHttpDestinationFailures", Boolean.class));
    this.notifyOnAllSyncFailures = Boolean.TRUE.equals(SdkFields.read(user, "notifyOnAllSyncFailures", Boolean.class));
    this.notifyOnAllAutomationFailures = Boolean.TRUE.equals(SdkFields.read(user, "notifyOnAllAutomationFailures", Boolean.class));
    this.notifyOnAllExpectationFailures = Boolean.TRUE.equals(SdkFields.read(user, "notifyOnAllExpectationFailures", Boolean.class));
    this.require2fa = SdkFields.read(user, "require2fa", String.class);
  }

  private void initGroup7(final User user) {
    this.requireLoginBy = SdkFields.read(user, "requireLoginBy", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.active2fa = Boolean.TRUE.equals(SdkFields.read(user, "active2fa", Boolean.class));
    this.requirePasswordChange = Boolean.TRUE.equals(SdkFields.read(user, "requirePasswordChange", Boolean.class));
    this.passwordExpired = Boolean.TRUE.equals(SdkFields.read(user, "passwordExpired", Boolean.class));
    this.responsibleGroupId = SdkFields.read(user, "responsibleGroupId", Long.class);
    this.responsibleUserId = SdkFields.read(user, "responsibleUserId", Long.class);
    this.readonlySiteAdmin = Boolean.TRUE.equals(SdkFields.read(user, "readonlySiteAdmin", Boolean.class));
    this.restapiPermission = Boolean.TRUE.equals(SdkFields.read(user, "restapiPermission", Boolean.class));
    this.s3CompatibleEndpointPermission = Boolean.TRUE.equals(SdkFields.read(user, "s3CompatibleEndpointPermission", Boolean.class));
    this.selfManaged = Boolean.TRUE.equals(SdkFields.read(user, "selfManaged", Boolean.class));
  }

  private void initGroup8(final User user) {
    this.sftpPermission = Boolean.TRUE.equals(SdkFields.read(user, "sftpPermission", Boolean.class));
    this.siteAdmin = Boolean.TRUE.equals(SdkFields.read(user, "siteAdmin", Boolean.class));
    this.workspaceAdmin = Boolean.TRUE.equals(SdkFields.read(user, "workspaceAdmin", Boolean.class));
    this.siteId = SdkFields.read(user, "siteId", Long.class);
    this.workspaceId = SdkFields.read(user, "workspaceId", Long.class);
    this.defaultWorkspaceId = SdkFields.read(user, "defaultWorkspaceId", Long.class);
    this.skipWelcomeScreen = Boolean.TRUE.equals(SdkFields.read(user, "skipWelcomeScreen", Boolean.class));
    this.encryptionRequired = SdkFields.read(user, "sslRequired", String.class);
    this.ssoStrategyId = SdkFields.read(user, "ssoStrategyId", Long.class);
    this.subscribeToNewsletter = Boolean.TRUE.equals(SdkFields.read(user, "subscribeToNewsletter", Boolean.class));
  }

  private void initGroup9(final User user) {
    this.externallyManaged = Boolean.TRUE.equals(SdkFields.read(user, "externallyManaged", Boolean.class));
    this.tags = SdkFields.read(user, "tags", String.class);
    this.timeZone = SdkFields.read(user, "timeZone", String.class);
    this.typeOf2fa = SdkFields.read(user, "typeOf2fa", String.class);
    this.typeOf2faForDisplay = SdkFields.read(user, "typeOf2faForDisplay", String.class);
    this.userRoot = SdkFields.read(user, "userRoot", String.class);
    this.userHome = SdkFields.read(user, "userHome", String.class);
    this.daysRemainingUntilPasswordExpire = SdkFields.read(user, "daysRemainingUntilPasswordExpire", Long.class);
    this.passwordExpireAt = SdkFields.read(user, "passwordExpireAt", Date.class,
        value -> ZonedDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault()));
    this.avatarDelete = Boolean.TRUE.equals(SdkFields.read(user, "avatarDelete", Boolean.class));
  }

  private void initGroup10(final User user) {
    this.changePassword = SdkFields.read(user, "changePassword", String.class);
    this.changePasswordConfirmation = SdkFields.read(user, "changePasswordConfirmation", String.class);
    this.grantPermission = SdkFields.read(user, "grantPermission", String.class);
    this.groupId = SdkFields.read(user, "groupId", Long.class);
    this.importedPasswordHash = SdkFields.read(user, "importedPasswordHash", String.class);
    this.password = SdkFields.read(user, "password", String.class);
    this.passwordConfirmation = SdkFields.read(user, "passwordConfirmation", String.class);
    this.announcementsRead = Boolean.TRUE.equals(SdkFields.read(user, "announcementsRead", Boolean.class));
    this.clear2fa = Boolean.TRUE.equals(SdkFields.read(user, "clear2fa", Boolean.class));
    this.convertToPartnerUser = Boolean.TRUE.equals(SdkFields.read(user, "convertToPartnerUser", Boolean.class));
  }

  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  private List<Long> adminGroupIds;

  public List<Long> getAdminGroupIds() {
    return adminGroupIds;
  }

  public void setAdminGroupIds(final List<Long> adminGroupIds) {
    this.adminGroupIds = adminGroupIds;
  }

  private String allowedIps;

  public String getAllowedIps() {
    return allowedIps;
  }

  public void setAllowedIps(final String allowedIps) {
    this.allowedIps = allowedIps;
  }

  private boolean attachmentsPermission;

  public boolean getAttachmentsPermission() {
    return attachmentsPermission;
  }

  public void setAttachmentsPermission(final boolean attachmentsPermission) {
    this.attachmentsPermission = attachmentsPermission;
  }

  private Long apiKeysCount;

  public Long getApiKeysCount() {
    return apiKeysCount;
  }

  public void setApiKeysCount(final Long apiKeysCount) {
    this.apiKeysCount = apiKeysCount;
  }

  private ZonedDateTime authenticateUntil;

  public ZonedDateTime getAuthenticateUntil() {
    return authenticateUntil;
  }

  public void setAuthenticateUntil(final ZonedDateTime authenticateUntil) {
    this.authenticateUntil = authenticateUntil;
  }

  private String authenticationMethod;

  public String getAuthenticationMethod() {
    return authenticationMethod;
  }

  public void setAuthenticationMethod(final String authenticationMethod) {
    this.authenticationMethod = authenticationMethod;
  }

  private String avatarUrl;

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(final String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  private boolean billable;

  public boolean getBillable() {
    return billable;
  }

  public void setBillable(final boolean billable) {
    this.billable = billable;
  }

  private boolean billingPermission;

  public boolean getBillingPermission() {
    return billingPermission;
  }

  public void setBillingPermission(final boolean billingPermission) {
    this.billingPermission = billingPermission;
  }

  private boolean bypassSiteAllowedIps;

  public boolean getBypassSiteAllowedIps() {
    return bypassSiteAllowedIps;
  }

  public void setBypassSiteAllowedIps(final boolean bypassSiteAllowedIps) {
    this.bypassSiteAllowedIps = bypassSiteAllowedIps;
  }

  private boolean bypassUserLifecycleRules;

  public boolean getBypassUserLifecycleRules() {
    return bypassUserLifecycleRules;
  }

  public void setBypassUserLifecycleRules(final boolean bypassUserLifecycleRules) {
    this.bypassUserLifecycleRules = bypassUserLifecycleRules;
  }

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(final ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  private boolean davPermission;

  public boolean getDavPermission() {
    return davPermission;
  }

  public void setDavPermission(final boolean davPermission) {
    this.davPermission = davPermission;
  }

  private boolean disabled;

  public boolean getDisabled() {
    return disabled;
  }

  public void setDisabled(final boolean disabled) {
    this.disabled = disabled;
  }

  private boolean disabledExpiredOrInactive;

  public boolean getDisabledExpiredOrInactive() {
    return disabledExpiredOrInactive;
  }

  public void setDisabledExpiredOrInactive(final boolean disabledExpiredOrInactive) {
    this.disabledExpiredOrInactive = disabledExpiredOrInactive;
  }

  private Long aiAssistantPersonalityId;

  public Long getAiAssistantPersonalityId() {
    return aiAssistantPersonalityId;
  }

  public void setAiAssistantPersonalityId(final Long aiAssistantPersonalityId) {
    this.aiAssistantPersonalityId = aiAssistantPersonalityId;
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

  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  private String filesystemLayout;

  public String getFilesystemLayout() {
    return filesystemLayout;
  }

  public void setFilesystemLayout(final String filesystemLayout) {
    this.filesystemLayout = filesystemLayout;
  }

  private ZonedDateTime firstLoginAt;

  public ZonedDateTime getFirstLoginAt() {
    return firstLoginAt;
  }

  public void setFirstLoginAt(final ZonedDateTime firstLoginAt) {
    this.firstLoginAt = firstLoginAt;
  }

  private boolean ftpPermission;

  public boolean getFtpPermission() {
    return ftpPermission;
  }

  public void setFtpPermission(final boolean ftpPermission) {
    this.ftpPermission = ftpPermission;
  }

  private String groupIds;

  public String getGroupIds() {
    return groupIds;
  }

  public void setGroupIds(final String groupIds) {
    this.groupIds = groupIds;
  }

  private String headerText;

  public String getHeaderText() {
    return headerText;
  }

  public void setHeaderText(final String headerText) {
    this.headerText = headerText;
  }

  private String language;

  public String getLanguage() {
    return language;
  }

  public void setLanguage(final String language) {
    this.language = language;
  }

  private ZonedDateTime lastLoginAt;

  public ZonedDateTime getLastLoginAt() {
    return lastLoginAt;
  }

  public void setLastLoginAt(final ZonedDateTime lastLoginAt) {
    this.lastLoginAt = lastLoginAt;
  }

  private ZonedDateTime lastWebLoginAt;

  public ZonedDateTime getLastWebLoginAt() {
    return lastWebLoginAt;
  }

  public void setLastWebLoginAt(final ZonedDateTime lastWebLoginAt) {
    this.lastWebLoginAt = lastWebLoginAt;
  }

  private ZonedDateTime lastFtpLoginAt;

  public ZonedDateTime getLastFtpLoginAt() {
    return lastFtpLoginAt;
  }

  public void setLastFtpLoginAt(final ZonedDateTime lastFtpLoginAt) {
    this.lastFtpLoginAt = lastFtpLoginAt;
  }

  private ZonedDateTime lastSftpLoginAt;

  public ZonedDateTime getLastSftpLoginAt() {
    return lastSftpLoginAt;
  }

  public void setLastSftpLoginAt(final ZonedDateTime lastSftpLoginAt) {
    this.lastSftpLoginAt = lastSftpLoginAt;
  }

  private ZonedDateTime lastDavLoginAt;

  public ZonedDateTime getLastDavLoginAt() {
    return lastDavLoginAt;
  }

  public void setLastDavLoginAt(final ZonedDateTime lastDavLoginAt) {
    this.lastDavLoginAt = lastDavLoginAt;
  }

  private ZonedDateTime lastDesktopLoginAt;

  public ZonedDateTime getLastDesktopLoginAt() {
    return lastDesktopLoginAt;
  }

  public void setLastDesktopLoginAt(final ZonedDateTime lastDesktopLoginAt) {
    this.lastDesktopLoginAt = lastDesktopLoginAt;
  }

  private ZonedDateTime lastRestapiLoginAt;

  public ZonedDateTime getLastRestapiLoginAt() {
    return lastRestapiLoginAt;
  }

  public void setLastRestapiLoginAt(final ZonedDateTime lastRestapiLoginAt) {
    this.lastRestapiLoginAt = lastRestapiLoginAt;
  }

  private ZonedDateTime lastApiUseAt;

  public ZonedDateTime getLastApiUseAt() {
    return lastApiUseAt;
  }

  public void setLastApiUseAt(final ZonedDateTime lastApiUseAt) {
    this.lastApiUseAt = lastApiUseAt;
  }

  private ZonedDateTime lastActiveAt;

  public ZonedDateTime getLastActiveAt() {
    return lastActiveAt;
  }

  public void setLastActiveAt(final ZonedDateTime lastActiveAt) {
    this.lastActiveAt = lastActiveAt;
  }

  private String lastProtocolCipher;

  public String getLastProtocolCipher() {
    return lastProtocolCipher;
  }

  public void setLastProtocolCipher(final String lastProtocolCipher) {
    this.lastProtocolCipher = lastProtocolCipher;
  }

  private ZonedDateTime lockoutExpires;

  public ZonedDateTime getLockoutExpires() {
    return lockoutExpires;
  }

  public void setLockoutExpires(final ZonedDateTime lockoutExpires) {
    this.lockoutExpires = lockoutExpires;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  private String company;

  public String getCompany() {
    return company;
  }

  public void setCompany(final String company) {
    this.company = company;
  }

  private String notes;

  public String getNotes() {
    return notes;
  }

  public void setNotes(final String notes) {
    this.notes = notes;
  }

  private Long notificationDailySendTime;

  public Long getNotificationDailySendTime() {
    return notificationDailySendTime;
  }

  public void setNotificationDailySendTime(final Long notificationDailySendTime) {
    this.notificationDailySendTime = notificationDailySendTime;
  }

  private boolean officeIntegrationEnabled;

  public boolean getOfficeIntegrationEnabled() {
    return officeIntegrationEnabled;
  }

  public void setOfficeIntegrationEnabled(final boolean officeIntegrationEnabled) {
    this.officeIntegrationEnabled = officeIntegrationEnabled;
  }

  private boolean partnerAdmin;

  public boolean getPartnerAdmin() {
    return partnerAdmin;
  }

  public void setPartnerAdmin(final boolean partnerAdmin) {
    this.partnerAdmin = partnerAdmin;
  }

  private Long partnerId;

  public Long getPartnerId() {
    return partnerId;
  }

  public void setPartnerId(final Long partnerId) {
    this.partnerId = partnerId;
  }

  private String partnerName;

  public String getPartnerName() {
    return partnerName;
  }

  public void setPartnerName(final String partnerName) {
    this.partnerName = partnerName;
  }

  private ZonedDateTime passwordSetAt;

  public ZonedDateTime getPasswordSetAt() {
    return passwordSetAt;
  }

  public void setPasswordSetAt(final ZonedDateTime passwordSetAt) {
    this.passwordSetAt = passwordSetAt;
  }

  private Long passwordValidityDays;

  public Long getPasswordValidityDays() {
    return passwordValidityDays;
  }

  public void setPasswordValidityDays(final Long passwordValidityDays) {
    this.passwordValidityDays = passwordValidityDays;
  }

  private Long primaryGroupId;

  public Long getPrimaryGroupId() {
    return primaryGroupId;
  }

  public void setPrimaryGroupId(final Long primaryGroupId) {
    this.primaryGroupId = primaryGroupId;
  }

  private Long publicKeysCount;

  public Long getPublicKeysCount() {
    return publicKeysCount;
  }

  public void setPublicKeysCount(final Long publicKeysCount) {
    this.publicKeysCount = publicKeysCount;
  }

  private boolean receiveAdminAlerts;

  public boolean getReceiveAdminAlerts() {
    return receiveAdminAlerts;
  }

  public void setReceiveAdminAlerts(final boolean receiveAdminAlerts) {
    this.receiveAdminAlerts = receiveAdminAlerts;
  }

  private boolean notifyOnAllSiteWarnings;

  public boolean getNotifyOnAllSiteWarnings() {
    return notifyOnAllSiteWarnings;
  }

  public void setNotifyOnAllSiteWarnings(final boolean notifyOnAllSiteWarnings) {
    this.notifyOnAllSiteWarnings = notifyOnAllSiteWarnings;
  }

  private boolean notifyOnAllSsoFailures;

  public boolean getNotifyOnAllSsoFailures() {
    return notifyOnAllSsoFailures;
  }

  public void setNotifyOnAllSsoFailures(final boolean notifyOnAllSsoFailures) {
    this.notifyOnAllSsoFailures = notifyOnAllSsoFailures;
  }

  private boolean notifyOnAllUserSecurityEvents;

  public boolean getNotifyOnAllUserSecurityEvents() {
    return notifyOnAllUserSecurityEvents;
  }

  public void setNotifyOnAllUserSecurityEvents(final boolean notifyOnAllUserSecurityEvents) {
    this.notifyOnAllUserSecurityEvents = notifyOnAllUserSecurityEvents;
  }

  private boolean notifyOnAllPendingWorkFailures;

  public boolean getNotifyOnAllPendingWorkFailures() {
    return notifyOnAllPendingWorkFailures;
  }

  public void setNotifyOnAllPendingWorkFailures(final boolean notifyOnAllPendingWorkFailures) {
    this.notifyOnAllPendingWorkFailures = notifyOnAllPendingWorkFailures;
  }

  private boolean notifyOnAllSiemHttpDestinationFailures;

  public boolean getNotifyOnAllSiemHttpDestinationFailures() {
    return notifyOnAllSiemHttpDestinationFailures;
  }

  public void setNotifyOnAllSiemHttpDestinationFailures(final boolean notifyOnAllSiemHttpDestinationFailures) {
    this.notifyOnAllSiemHttpDestinationFailures = notifyOnAllSiemHttpDestinationFailures;
  }

  private boolean notifyOnAllSyncFailures;

  public boolean getNotifyOnAllSyncFailures() {
    return notifyOnAllSyncFailures;
  }

  public void setNotifyOnAllSyncFailures(final boolean notifyOnAllSyncFailures) {
    this.notifyOnAllSyncFailures = notifyOnAllSyncFailures;
  }

  private boolean notifyOnAllAutomationFailures;

  public boolean getNotifyOnAllAutomationFailures() {
    return notifyOnAllAutomationFailures;
  }

  public void setNotifyOnAllAutomationFailures(final boolean notifyOnAllAutomationFailures) {
    this.notifyOnAllAutomationFailures = notifyOnAllAutomationFailures;
  }

  private boolean notifyOnAllExpectationFailures;

  public boolean getNotifyOnAllExpectationFailures() {
    return notifyOnAllExpectationFailures;
  }

  public void setNotifyOnAllExpectationFailures(final boolean notifyOnAllExpectationFailures) {
    this.notifyOnAllExpectationFailures = notifyOnAllExpectationFailures;
  }

  private String require2fa;

  public String getRequire2fa() {
    return require2fa;
  }

  public void setRequire2fa(final String require2fa) {
    this.require2fa = require2fa;
  }

  private ZonedDateTime requireLoginBy;

  public ZonedDateTime getRequireLoginBy() {
    return requireLoginBy;
  }

  public void setRequireLoginBy(final ZonedDateTime requireLoginBy) {
    this.requireLoginBy = requireLoginBy;
  }

  private boolean active2fa;

  public boolean getActive2fa() {
    return active2fa;
  }

  public void setActive2fa(final boolean active2fa) {
    this.active2fa = active2fa;
  }

  private boolean requirePasswordChange;

  public boolean getRequirePasswordChange() {
    return requirePasswordChange;
  }

  public void setRequirePasswordChange(final boolean requirePasswordChange) {
    this.requirePasswordChange = requirePasswordChange;
  }

  private boolean passwordExpired;

  public boolean getPasswordExpired() {
    return passwordExpired;
  }

  public void setPasswordExpired(final boolean passwordExpired) {
    this.passwordExpired = passwordExpired;
  }

  private Long responsibleGroupId;

  public Long getResponsibleGroupId() {
    return responsibleGroupId;
  }

  public void setResponsibleGroupId(final Long responsibleGroupId) {
    this.responsibleGroupId = responsibleGroupId;
  }

  private Long responsibleUserId;

  public Long getResponsibleUserId() {
    return responsibleUserId;
  }

  public void setResponsibleUserId(final Long responsibleUserId) {
    this.responsibleUserId = responsibleUserId;
  }

  private boolean readonlySiteAdmin;

  public boolean getReadonlySiteAdmin() {
    return readonlySiteAdmin;
  }

  public void setReadonlySiteAdmin(final boolean readonlySiteAdmin) {
    this.readonlySiteAdmin = readonlySiteAdmin;
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

  private boolean selfManaged;

  public boolean getSelfManaged() {
    return selfManaged;
  }

  public void setSelfManaged(final boolean selfManaged) {
    this.selfManaged = selfManaged;
  }

  private boolean sftpPermission;

  public boolean getSftpPermission() {
    return sftpPermission;
  }

  public void setSftpPermission(final boolean sftpPermission) {
    this.sftpPermission = sftpPermission;
  }

  private boolean siteAdmin;

  public boolean getSiteAdmin() {
    return siteAdmin;
  }

  public void setSiteAdmin(final boolean siteAdmin) {
    this.siteAdmin = siteAdmin;
  }

  private boolean workspaceAdmin;

  public boolean getWorkspaceAdmin() {
    return workspaceAdmin;
  }

  public void setWorkspaceAdmin(final boolean workspaceAdmin) {
    this.workspaceAdmin = workspaceAdmin;
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

  private Long defaultWorkspaceId;

  public Long getDefaultWorkspaceId() {
    return defaultWorkspaceId;
  }

  public void setDefaultWorkspaceId(final Long defaultWorkspaceId) {
    this.defaultWorkspaceId = defaultWorkspaceId;
  }

  private boolean skipWelcomeScreen;

  public boolean getSkipWelcomeScreen() {
    return skipWelcomeScreen;
  }

  public void setSkipWelcomeScreen(final boolean skipWelcomeScreen) {
    this.skipWelcomeScreen = skipWelcomeScreen;
  }

  private String encryptionRequired;

  public String getEncryptionRequired() {
    return encryptionRequired;
  }

  public void setEncryptionRequired(final String encryptionRequired) {
    this.encryptionRequired = encryptionRequired;
  }

  private Long ssoStrategyId;

  public Long getSsoStrategyId() {
    return ssoStrategyId;
  }

  public void setSsoStrategyId(final Long ssoStrategyId) {
    this.ssoStrategyId = ssoStrategyId;
  }

  private boolean subscribeToNewsletter;

  public boolean getSubscribeToNewsletter() {
    return subscribeToNewsletter;
  }

  public void setSubscribeToNewsletter(final boolean subscribeToNewsletter) {
    this.subscribeToNewsletter = subscribeToNewsletter;
  }

  private boolean externallyManaged;

  public boolean getExternallyManaged() {
    return externallyManaged;
  }

  public void setExternallyManaged(final boolean externallyManaged) {
    this.externallyManaged = externallyManaged;
  }

  private String tags;

  public String getTags() {
    return tags;
  }

  public void setTags(final String tags) {
    this.tags = tags;
  }

  private String timeZone;

  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(final String timeZone) {
    this.timeZone = timeZone;
  }

  private String typeOf2fa;

  public String getTypeOf2fa() {
    return typeOf2fa;
  }

  public void setTypeOf2fa(final String typeOf2fa) {
    this.typeOf2fa = typeOf2fa;
  }

  private String typeOf2faForDisplay;

  public String getTypeOf2faForDisplay() {
    return typeOf2faForDisplay;
  }

  public void setTypeOf2faForDisplay(final String typeOf2faForDisplay) {
    this.typeOf2faForDisplay = typeOf2faForDisplay;
  }

  private String userRoot;

  public String getUserRoot() {
    return userRoot;
  }

  public void setUserRoot(final String userRoot) {
    this.userRoot = userRoot;
  }

  private String userHome;

  public String getUserHome() {
    return userHome;
  }

  public void setUserHome(final String userHome) {
    this.userHome = userHome;
  }

  private Long daysRemainingUntilPasswordExpire;

  public Long getDaysRemainingUntilPasswordExpire() {
    return daysRemainingUntilPasswordExpire;
  }

  public void setDaysRemainingUntilPasswordExpire(final Long daysRemainingUntilPasswordExpire) {
    this.daysRemainingUntilPasswordExpire = daysRemainingUntilPasswordExpire;
  }

  private ZonedDateTime passwordExpireAt;

  public ZonedDateTime getPasswordExpireAt() {
    return passwordExpireAt;
  }

  public void setPasswordExpireAt(final ZonedDateTime passwordExpireAt) {
    this.passwordExpireAt = passwordExpireAt;
  }

  private boolean avatarDelete;

  public boolean getAvatarDelete() {
    return avatarDelete;
  }

  public void setAvatarDelete(final boolean avatarDelete) {
    this.avatarDelete = avatarDelete;
  }

  private String changePassword;

  public String getChangePassword() {
    return changePassword;
  }

  public void setChangePassword(final String changePassword) {
    this.changePassword = changePassword;
  }

  private String changePasswordConfirmation;

  public String getChangePasswordConfirmation() {
    return changePasswordConfirmation;
  }

  public void setChangePasswordConfirmation(final String changePasswordConfirmation) {
    this.changePasswordConfirmation = changePasswordConfirmation;
  }

  private String grantPermission;

  public String getGrantPermission() {
    return grantPermission;
  }

  public void setGrantPermission(final String grantPermission) {
    this.grantPermission = grantPermission;
  }

  private Long groupId;

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(final Long groupId) {
    this.groupId = groupId;
  }

  private String importedPasswordHash;

  public String getImportedPasswordHash() {
    return importedPasswordHash;
  }

  public void setImportedPasswordHash(final String importedPasswordHash) {
    this.importedPasswordHash = importedPasswordHash;
  }

  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  private String passwordConfirmation;

  public String getPasswordConfirmation() {
    return passwordConfirmation;
  }

  public void setPasswordConfirmation(final String passwordConfirmation) {
    this.passwordConfirmation = passwordConfirmation;
  }

  private boolean announcementsRead;

  public boolean getAnnouncementsRead() {
    return announcementsRead;
  }

  public void setAnnouncementsRead(final boolean announcementsRead) {
    this.announcementsRead = announcementsRead;
  }

  private boolean clear2fa;

  public boolean getClear2fa() {
    return clear2fa;
  }

  public void setClear2fa(final boolean clear2fa) {
    this.clear2fa = clear2fa;
  }

  private boolean convertToPartnerUser;

  public boolean getConvertToPartnerUser() {
    return convertToPartnerUser;
  }

  public void setConvertToPartnerUser(final boolean convertToPartnerUser) {
    this.convertToPartnerUser = convertToPartnerUser;
  }

}
