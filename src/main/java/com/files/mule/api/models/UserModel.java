/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Arrays;
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
  }

  private void initGroup1(final User user) {
    this.id = user.id;
    this.username = user.username;
    this.adminGroupIds = user.adminGroupIds != null ? Arrays.asList(user.adminGroupIds) : null;
    this.allowedIps = user.allowedIps;
    this.attachmentsPermission = Boolean.TRUE.equals(user.attachmentsPermission);
    this.apiKeysCount = user.apiKeysCount;
    this.authenticateUntil = user.authenticateUntil != null ? ZonedDateTime.ofInstant(user.authenticateUntil.toInstant(), ZoneId.systemDefault()) : null;
    this.authenticationMethod = user.authenticationMethod;
    this.avatarUrl = user.avatarUrl;
    this.billable = Boolean.TRUE.equals(user.billable);
  }

  private void initGroup2(final User user) {
    this.billingPermission = Boolean.TRUE.equals(user.billingPermission);
    this.bypassSiteAllowedIps = Boolean.TRUE.equals(user.bypassSiteAllowedIps);
    this.bypassUserLifecycleRules = Boolean.TRUE.equals(user.bypassUserLifecycleRules);
    this.createdAt = user.createdAt != null ? ZonedDateTime.ofInstant(user.createdAt.toInstant(), ZoneId.systemDefault()) : null;
    this.davPermission = Boolean.TRUE.equals(user.davPermission);
    this.disabled = Boolean.TRUE.equals(user.disabled);
    this.disabledExpiredOrInactive = Boolean.TRUE.equals(user.disabledExpiredOrInactive);
    this.email = user.email;
    this.filesystemLayout = user.filesystemLayout;
    this.firstLoginAt = user.firstLoginAt != null ? ZonedDateTime.ofInstant(user.firstLoginAt.toInstant(), ZoneId.systemDefault()) : null;
  }

  private void initGroup3(final User user) {
    this.ftpPermission = Boolean.TRUE.equals(user.ftpPermission);
    this.groupIds = user.groupIds;
    this.headerText = user.headerText;
    this.language = user.language;
    this.lastLoginAt = user.lastLoginAt != null ? ZonedDateTime.ofInstant(user.lastLoginAt.toInstant(), ZoneId.systemDefault()) : null;
    this.lastWebLoginAt = user.lastWebLoginAt != null ? ZonedDateTime.ofInstant(user.lastWebLoginAt.toInstant(), ZoneId.systemDefault()) : null;
    this.lastFtpLoginAt = user.lastFtpLoginAt != null ? ZonedDateTime.ofInstant(user.lastFtpLoginAt.toInstant(), ZoneId.systemDefault()) : null;
    this.lastSftpLoginAt = user.lastSftpLoginAt != null ? ZonedDateTime.ofInstant(user.lastSftpLoginAt.toInstant(), ZoneId.systemDefault()) : null;
    this.lastDavLoginAt = user.lastDavLoginAt != null ? ZonedDateTime.ofInstant(user.lastDavLoginAt.toInstant(), ZoneId.systemDefault()) : null;
    this.lastDesktopLoginAt = user.lastDesktopLoginAt != null ? ZonedDateTime.ofInstant(user.lastDesktopLoginAt.toInstant(), ZoneId.systemDefault()) : null;
  }

  private void initGroup4(final User user) {
    this.lastRestapiLoginAt = user.lastRestapiLoginAt != null ? ZonedDateTime.ofInstant(user.lastRestapiLoginAt.toInstant(), ZoneId.systemDefault()) : null;
    this.lastApiUseAt = user.lastApiUseAt != null ? ZonedDateTime.ofInstant(user.lastApiUseAt.toInstant(), ZoneId.systemDefault()) : null;
    this.lastActiveAt = user.lastActiveAt != null ? ZonedDateTime.ofInstant(user.lastActiveAt.toInstant(), ZoneId.systemDefault()) : null;
    this.lastProtocolCipher = user.lastProtocolCipher;
    this.lockoutExpires = user.lockoutExpires != null ? ZonedDateTime.ofInstant(user.lockoutExpires.toInstant(), ZoneId.systemDefault()) : null;
    this.name = user.name;
    this.company = user.company;
    this.notes = user.notes;
    this.notificationDailySendTime = user.notificationDailySendTime;
    this.officeIntegrationEnabled = Boolean.TRUE.equals(user.officeIntegrationEnabled);
  }

  private void initGroup5(final User user) {
    this.partnerAdmin = Boolean.TRUE.equals(user.partnerAdmin);
    this.partnerId = user.partnerId;
    this.passwordSetAt = user.passwordSetAt != null ? ZonedDateTime.ofInstant(user.passwordSetAt.toInstant(), ZoneId.systemDefault()) : null;
    this.passwordValidityDays = user.passwordValidityDays;
    this.publicKeysCount = user.publicKeysCount;
    this.receiveAdminAlerts = Boolean.TRUE.equals(user.receiveAdminAlerts);
    this.require2fa = user.require2fa;
    this.requireLoginBy = user.requireLoginBy != null ? ZonedDateTime.ofInstant(user.requireLoginBy.toInstant(), ZoneId.systemDefault()) : null;
    this.active2fa = Boolean.TRUE.equals(user.active2fa);
    this.requirePasswordChange = Boolean.TRUE.equals(user.requirePasswordChange);
  }

  private void initGroup6(final User user) {
    this.passwordExpired = Boolean.TRUE.equals(user.passwordExpired);
    this.readonlySiteAdmin = Boolean.TRUE.equals(user.readonlySiteAdmin);
    this.restapiPermission = Boolean.TRUE.equals(user.restapiPermission);
    this.selfManaged = Boolean.TRUE.equals(user.selfManaged);
    this.sftpPermission = Boolean.TRUE.equals(user.sftpPermission);
    this.siteAdmin = Boolean.TRUE.equals(user.siteAdmin);
    this.siteId = user.siteId;
    this.skipWelcomeScreen = Boolean.TRUE.equals(user.skipWelcomeScreen);
    this.encryptionRequired = user.sslRequired;
    this.ssoStrategyId = user.ssoStrategyId;
  }

  private void initGroup7(final User user) {
    this.subscribeToNewsletter = Boolean.TRUE.equals(user.subscribeToNewsletter);
    this.externallyManaged = Boolean.TRUE.equals(user.externallyManaged);
    this.tags = user.tags;
    this.timeZone = user.timeZone;
    this.typeOf2fa = user.typeOf2fa;
    this.typeOf2faForDisplay = user.typeOf2faForDisplay;
    this.userRoot = user.userRoot;
    this.userHome = user.userHome;
    this.daysRemainingUntilPasswordExpire = user.daysRemainingUntilPasswordExpire;
    this.passwordExpireAt = user.passwordExpireAt != null ? ZonedDateTime.ofInstant(user.passwordExpireAt.toInstant(), ZoneId.systemDefault()) : null;
  }

  private void initGroup8(final User user) {
    this.avatarDelete = Boolean.TRUE.equals(user.avatarDelete);
    this.changePassword = user.changePassword;
    this.changePasswordConfirmation = user.changePasswordConfirmation;
    this.grantPermission = user.grantPermission;
    this.groupId = user.groupId;
    this.importedPasswordHash = user.importedPasswordHash;
    this.password = user.password;
    this.passwordConfirmation = user.passwordConfirmation;
    this.announcementsRead = Boolean.TRUE.equals(user.announcementsRead);
    this.clear2fa = Boolean.TRUE.equals(user.clear2fa);
  }

  private void initGroup9(final User user) {
    this.convertToPartnerUser = Boolean.TRUE.equals(user.convertToPartnerUser);
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

  private Long siteId;

  public Long getSiteId() {
    return siteId;
  }

  public void setSiteId(final Long siteId) {
    this.siteId = siteId;
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
