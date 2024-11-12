package com.files.mule.api.models;

import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.List;

import com.files.models.User;

/**
 * A User is a single user that belongs to your site.
 *
 * Users functionality provides the tools and features needed to manage user accounts within your site.
 */
public class UserModel extends AbstractModel {
  public UserModel() {
  }

  public UserModel(final User user) {
    this.id = user.id;
    this.username = user.username;
    this.adminGroupIds = toList(user.adminGroupIds);
    this.allowedIps = user.allowedIps;
    this.attachmentsPermission = Boolean.TRUE.equals(user.attachmentsPermission);
    this.apiKeysCount = user.apiKeysCount;
    this.authenticateUntil = toZonedDateTime(user.authenticateUntil);
    this.authenticationMethod = user.authenticationMethod;
    this.avatarUrl = user.avatarUrl;
    this.billable = Boolean.TRUE.equals(user.billable);
    this.billingPermission = Boolean.TRUE.equals(user.billingPermission);
    this.bypassSiteAllowedIps = Boolean.TRUE.equals(user.bypassSiteAllowedIps);
    this.bypassInactiveDisable = Boolean.TRUE.equals(user.bypassInactiveDisable);
    this.createdAt = toZonedDateTime(user.createdAt);
    this.davPermission = Boolean.TRUE.equals(user.davPermission);
    this.disabled = Boolean.TRUE.equals(user.disabled);
    this.disabledExpiredOrInactive = Boolean.TRUE.equals(user.disabledExpiredOrInactive);
    this.email = user.email;
    this.firstLoginAt = toZonedDateTime(user.firstLoginAt);
    this.ftpPermission = Boolean.TRUE.equals(user.ftpPermission);
    this.groupIds = user.groupIds;
    this.headerText = user.headerText;
    this.language = user.language;
    this.lastLoginAt = toZonedDateTime(user.lastLoginAt);
    this.lastWebLoginAt = toZonedDateTime(user.lastWebLoginAt);
    this.lastFtpLoginAt = toZonedDateTime(user.lastFtpLoginAt);
    this.lastSftpLoginAt = toZonedDateTime(user.lastSftpLoginAt);
    this.lastDavLoginAt = toZonedDateTime(user.lastDavLoginAt);
    this.lastDesktopLoginAt = toZonedDateTime(user.lastDesktopLoginAt);
    this.lastRestapiLoginAt = toZonedDateTime(user.lastRestapiLoginAt);
    this.lastApiUseAt = toZonedDateTime(user.lastApiUseAt);
    this.lastActiveAt = toZonedDateTime(user.lastActiveAt);
    this.lastProtocolCipher = user.lastProtocolCipher;
    this.lockoutExpires = toZonedDateTime(user.lockoutExpires);
    this.name = user.name;
    this.company = user.company;
    this.notes = user.notes;
    this.notificationDailySendTime = user.notificationDailySendTime;
    this.officeIntegrationEnabled = Boolean.TRUE.equals(user.officeIntegrationEnabled);
    this.passwordSetAt = toZonedDateTime(user.passwordSetAt);
    this.passwordValidityDays = user.passwordValidityDays;
    this.publicKeysCount = user.publicKeysCount;
    this.receiveAdminAlerts = Boolean.TRUE.equals(user.receiveAdminAlerts);
    this.require2fa = user.require2fa;
    this.requireLoginBy = toZonedDateTime(user.requireLoginBy);
    this.active2fa = Boolean.TRUE.equals(user.active2fa);
    this.requirePasswordChange = Boolean.TRUE.equals(user.requirePasswordChange);
    this.passwordExpired = Boolean.TRUE.equals(user.passwordExpired);
    this.readonlySiteAdmin = Boolean.TRUE.equals(user.readonlySiteAdmin);
    this.restapiPermission = Boolean.TRUE.equals(user.restapiPermission);
    this.selfManaged = Boolean.TRUE.equals(user.selfManaged);
    this.sftpPermission = Boolean.TRUE.equals(user.sftpPermission);
    this.siteAdmin = Boolean.TRUE.equals(user.siteAdmin);
    this.skipWelcomeScreen = Boolean.TRUE.equals(user.skipWelcomeScreen);
    this.encryptionRequired = user.sslRequired;
    this.ssoStrategyId = user.ssoStrategyId;
    this.subscribeToNewsletter = Boolean.TRUE.equals(user.subscribeToNewsletter);
    this.externallyManaged = Boolean.TRUE.equals(user.externallyManaged);
    this.timeZone = user.timeZone;
    this.typeOf2fa = user.typeOf2fa;
    this.typeOf2faForDisplay = user.typeOf2faForDisplay;
    this.userRoot = user.userRoot;
    this.userHome = user.userHome;
    this.daysRemainingUntilPasswordExpire = user.daysRemainingUntilPasswordExpire;
    this.passwordExpireAt = toZonedDateTime(user.passwordExpireAt);
    this.avatarFile = toInputStream(user.avatarFile);
    this.avatarDelete = Boolean.TRUE.equals(user.avatarDelete);
    this.changePassword = user.changePassword;
    this.changePasswordConfirmation = user.changePasswordConfirmation;
    this.grantPermission = user.grantPermission;
    this.groupId = user.groupId;
    this.importedPasswordHash = user.importedPasswordHash;
    this.password = user.password;
    this.passwordConfirmation = user.passwordConfirmation;
    this.announcementsRead = Boolean.TRUE.equals(user.announcementsRead);
  }

  private Long id;

  public Long getId() {
    return id;
  }

  private String username;

  public String getUsername() {
    return username;
  }

  private List<Long> adminGroupIds;

  public List<Long> getAdminGroupIds() {
    return adminGroupIds;
  }

  private String allowedIps;

  public String getAllowedIps() {
    return allowedIps;
  }

  private boolean attachmentsPermission;

  public boolean getAttachmentsPermission() {
    return attachmentsPermission;
  }

  private Long apiKeysCount;

  public Long getApiKeysCount() {
    return apiKeysCount;
  }

  private ZonedDateTime authenticateUntil;

  public ZonedDateTime getAuthenticateUntil() {
    return authenticateUntil;
  }

  private String authenticationMethod;

  public String getAuthenticationMethod() {
    return authenticationMethod;
  }

  private String avatarUrl;

  public String getAvatarUrl() {
    return avatarUrl;
  }

  private boolean billable;

  public boolean getBillable() {
    return billable;
  }

  private boolean billingPermission;

  public boolean getBillingPermission() {
    return billingPermission;
  }

  private boolean bypassSiteAllowedIps;

  public boolean getBypassSiteAllowedIps() {
    return bypassSiteAllowedIps;
  }

  private boolean bypassInactiveDisable;

  public boolean getBypassInactiveDisable() {
    return bypassInactiveDisable;
  }

  private ZonedDateTime createdAt;

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  private boolean davPermission;

  public boolean getDavPermission() {
    return davPermission;
  }

  private boolean disabled;

  public boolean getDisabled() {
    return disabled;
  }

  private boolean disabledExpiredOrInactive;

  public boolean getDisabledExpiredOrInactive() {
    return disabledExpiredOrInactive;
  }

  private String email;

  public String getEmail() {
    return email;
  }

  private ZonedDateTime firstLoginAt;

  public ZonedDateTime getFirstLoginAt() {
    return firstLoginAt;
  }

  private boolean ftpPermission;

  public boolean getFtpPermission() {
    return ftpPermission;
  }

  private String groupIds;

  public String getGroupIds() {
    return groupIds;
  }

  private String headerText;

  public String getHeaderText() {
    return headerText;
  }

  private String language;

  public String getLanguage() {
    return language;
  }

  private ZonedDateTime lastLoginAt;

  public ZonedDateTime getLastLoginAt() {
    return lastLoginAt;
  }

  private ZonedDateTime lastWebLoginAt;

  public ZonedDateTime getLastWebLoginAt() {
    return lastWebLoginAt;
  }

  private ZonedDateTime lastFtpLoginAt;

  public ZonedDateTime getLastFtpLoginAt() {
    return lastFtpLoginAt;
  }

  private ZonedDateTime lastSftpLoginAt;

  public ZonedDateTime getLastSftpLoginAt() {
    return lastSftpLoginAt;
  }

  private ZonedDateTime lastDavLoginAt;

  public ZonedDateTime getLastDavLoginAt() {
    return lastDavLoginAt;
  }

  private ZonedDateTime lastDesktopLoginAt;

  public ZonedDateTime getLastDesktopLoginAt() {
    return lastDesktopLoginAt;
  }

  private ZonedDateTime lastRestapiLoginAt;

  public ZonedDateTime getLastRestapiLoginAt() {
    return lastRestapiLoginAt;
  }

  private ZonedDateTime lastApiUseAt;

  public ZonedDateTime getLastApiUseAt() {
    return lastApiUseAt;
  }

  private ZonedDateTime lastActiveAt;

  public ZonedDateTime getLastActiveAt() {
    return lastActiveAt;
  }

  private String lastProtocolCipher;

  public String getLastProtocolCipher() {
    return lastProtocolCipher;
  }

  private ZonedDateTime lockoutExpires;

  public ZonedDateTime getLockoutExpires() {
    return lockoutExpires;
  }

  private String name;

  public String getName() {
    return name;
  }

  private String company;

  public String getCompany() {
    return company;
  }

  private String notes;

  public String getNotes() {
    return notes;
  }

  private Long notificationDailySendTime;

  public Long getNotificationDailySendTime() {
    return notificationDailySendTime;
  }

  private boolean officeIntegrationEnabled;

  public boolean getOfficeIntegrationEnabled() {
    return officeIntegrationEnabled;
  }

  private ZonedDateTime passwordSetAt;

  public ZonedDateTime getPasswordSetAt() {
    return passwordSetAt;
  }

  private Long passwordValidityDays;

  public Long getPasswordValidityDays() {
    return passwordValidityDays;
  }

  private Long publicKeysCount;

  public Long getPublicKeysCount() {
    return publicKeysCount;
  }

  private boolean receiveAdminAlerts;

  public boolean getReceiveAdminAlerts() {
    return receiveAdminAlerts;
  }

  private String require2fa;

  public String getRequire2fa() {
    return require2fa;
  }

  private ZonedDateTime requireLoginBy;

  public ZonedDateTime getRequireLoginBy() {
    return requireLoginBy;
  }

  private boolean active2fa;

  public boolean getActive2fa() {
    return active2fa;
  }

  private boolean requirePasswordChange;

  public boolean getRequirePasswordChange() {
    return requirePasswordChange;
  }

  private boolean passwordExpired;

  public boolean getPasswordExpired() {
    return passwordExpired;
  }

  private boolean readonlySiteAdmin;

  public boolean getReadonlySiteAdmin() {
    return readonlySiteAdmin;
  }

  private boolean restapiPermission;

  public boolean getRestapiPermission() {
    return restapiPermission;
  }

  private boolean selfManaged;

  public boolean getSelfManaged() {
    return selfManaged;
  }

  private boolean sftpPermission;

  public boolean getSftpPermission() {
    return sftpPermission;
  }

  private boolean siteAdmin;

  public boolean getSiteAdmin() {
    return siteAdmin;
  }

  private boolean skipWelcomeScreen;

  public boolean getSkipWelcomeScreen() {
    return skipWelcomeScreen;
  }

  private String encryptionRequired;

  public String getEncryptionRequired() {
    return encryptionRequired;
  }

  private Long ssoStrategyId;

  public Long getSsoStrategyId() {
    return ssoStrategyId;
  }

  private boolean subscribeToNewsletter;

  public boolean getSubscribeToNewsletter() {
    return subscribeToNewsletter;
  }

  private boolean externallyManaged;

  public boolean getExternallyManaged() {
    return externallyManaged;
  }

  private String timeZone;

  public String getTimeZone() {
    return timeZone;
  }

  private String typeOf2fa;

  public String getTypeOf2fa() {
    return typeOf2fa;
  }

  private String typeOf2faForDisplay;

  public String getTypeOf2faForDisplay() {
    return typeOf2faForDisplay;
  }

  private String userRoot;

  public String getUserRoot() {
    return userRoot;
  }

  private String userHome;

  public String getUserHome() {
    return userHome;
  }

  private Long daysRemainingUntilPasswordExpire;

  public Long getDaysRemainingUntilPasswordExpire() {
    return daysRemainingUntilPasswordExpire;
  }

  private ZonedDateTime passwordExpireAt;

  public ZonedDateTime getPasswordExpireAt() {
    return passwordExpireAt;
  }

  private InputStream avatarFile;

  public InputStream getAvatarFile() {
    return avatarFile;
  }

  private boolean avatarDelete;

  public boolean getAvatarDelete() {
    return avatarDelete;
  }

  private String changePassword;

  public String getChangePassword() {
    return changePassword;
  }

  private String changePasswordConfirmation;

  public String getChangePasswordConfirmation() {
    return changePasswordConfirmation;
  }

  private String grantPermission;

  public String getGrantPermission() {
    return grantPermission;
  }

  private Long groupId;

  public Long getGroupId() {
    return groupId;
  }

  private String importedPasswordHash;

  public String getImportedPasswordHash() {
    return importedPasswordHash;
  }

  private String password;

  public String getPassword() {
    return password;
  }

  private String passwordConfirmation;

  public String getPasswordConfirmation() {
    return passwordConfirmation;
  }

  private boolean announcementsRead;

  public boolean getAnnouncementsRead() {
    return announcementsRead;
  }

}
