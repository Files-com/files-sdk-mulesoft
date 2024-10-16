package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

import com.files.models.User;

/**
 * A User is a single user that belongs to your site.
 *
 * Users functionality provides the tools and features needed to manage user accounts within your site.
 */
public class UserModel implements Serializable {
  public UserModel() {
  }

  public UserModel(final User user) {
    this.id = user.id;
    this.username = user.username;
    this.adminGroupIds = user.adminGroupIds;
    this.allowedIps = user.allowedIps;
    this.attachmentsPermission = user.attachmentsPermission;
    this.apiKeysCount = user.apiKeysCount;
    this.authenticateUntil = user.authenticateUntil;
    this.authenticationMethod = user.authenticationMethod;
    this.avatarUrl = user.avatarUrl;
    this.billable = user.billable;
    this.billingPermission = user.billingPermission;
    this.bypassSiteAllowedIps = user.bypassSiteAllowedIps;
    this.bypassInactiveDisable = user.bypassInactiveDisable;
    this.createdAt = user.createdAt;
    this.davPermission = user.davPermission;
    this.disabled = user.disabled;
    this.disabledExpiredOrInactive = user.disabledExpiredOrInactive;
    this.email = user.email;
    this.firstLoginAt = user.firstLoginAt;
    this.ftpPermission = user.ftpPermission;
    this.groupIds = user.groupIds;
    this.headerText = user.headerText;
    this.language = user.language;
    this.lastLoginAt = user.lastLoginAt;
    this.lastWebLoginAt = user.lastWebLoginAt;
    this.lastFtpLoginAt = user.lastFtpLoginAt;
    this.lastSftpLoginAt = user.lastSftpLoginAt;
    this.lastDavLoginAt = user.lastDavLoginAt;
    this.lastDesktopLoginAt = user.lastDesktopLoginAt;
    this.lastRestapiLoginAt = user.lastRestapiLoginAt;
    this.lastApiUseAt = user.lastApiUseAt;
    this.lastActiveAt = user.lastActiveAt;
    this.lastProtocolCipher = user.lastProtocolCipher;
    this.lockoutExpires = user.lockoutExpires;
    this.name = user.name;
    this.company = user.company;
    this.notes = user.notes;
    this.notificationDailySendTime = user.notificationDailySendTime;
    this.officeIntegrationEnabled = user.officeIntegrationEnabled;
    this.passwordSetAt = user.passwordSetAt;
    this.passwordValidityDays = user.passwordValidityDays;
    this.publicKeysCount = user.publicKeysCount;
    this.receiveAdminAlerts = user.receiveAdminAlerts;
    this.require2fa = user.require2fa;
    this.requireLoginBy = user.requireLoginBy;
    this.active2fa = user.active2fa;
    this.requirePasswordChange = user.requirePasswordChange;
    this.passwordExpired = user.passwordExpired;
    this.readonlySiteAdmin = user.readonlySiteAdmin;
    this.restapiPermission = user.restapiPermission;
    this.selfManaged = user.selfManaged;
    this.sftpPermission = user.sftpPermission;
    this.siteAdmin = user.siteAdmin;
    this.skipWelcomeScreen = user.skipWelcomeScreen;
    this.sslRequired = user.sslRequired;
    this.ssoStrategyId = user.ssoStrategyId;
    this.subscribeToNewsletter = user.subscribeToNewsletter;
    this.externallyManaged = user.externallyManaged;
    this.timeZone = user.timeZone;
    this.typeOf2fa = user.typeOf2fa;
    this.typeOf2faForDisplay = user.typeOf2faForDisplay;
    this.userRoot = user.userRoot;
    this.userHome = user.userHome;
    this.daysRemainingUntilPasswordExpire = user.daysRemainingUntilPasswordExpire;
    this.passwordExpireAt = user.passwordExpireAt;
    this.avatarFile = user.avatarFile;
    this.avatarDelete = user.avatarDelete;
    this.changePassword = user.changePassword;
    this.changePasswordConfirmation = user.changePasswordConfirmation;
    this.grantPermission = user.grantPermission;
    this.groupId = user.groupId;
    this.importedPasswordHash = user.importedPasswordHash;
    this.password = user.password;
    this.passwordConfirmation = user.passwordConfirmation;
    this.announcementsRead = user.announcementsRead;
  }

  /**
   * User ID
   */
  @Parameter
  public Long id;

  public Long getId() {
    return id;
  }

  /**
   * User's username
   */
  @Parameter
  public String username;

  public String getUsername() {
    return username;
  }

  /**
   * List of group IDs of which this user is an administrator
   */
  @Parameter
  public Long[] adminGroupIds;

  public Long[] getAdminGroupIds() {
    return adminGroupIds;
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
   * If `true`, the user can user create Bundles (aka Share Links). Use the bundle permission instead.
   */
  @Parameter
  public Boolean attachmentsPermission;

  public Boolean getAttachmentsPermission() {
    return attachmentsPermission;
  }

  /**
   * Number of API keys associated with this user
   */
  @Parameter
  public Long apiKeysCount;

  public Long getApiKeysCount() {
    return apiKeysCount;
  }

  /**
   * Scheduled Date/Time at which user will be deactivated
   */
  @Parameter
  public Date authenticateUntil;

  public Date getAuthenticateUntil() {
    return authenticateUntil;
  }

  /**
   * How is this user authenticated?
   */
  @Parameter
  public String authenticationMethod;

  public String getAuthenticationMethod() {
    return authenticationMethod;
  }

  /**
   * URL holding the user's avatar
   */
  @Parameter
  public String avatarUrl;

  public String getAvatarUrl() {
    return avatarUrl;
  }

  /**
   * Is this a billable user record?
   */
  @Parameter
  public Boolean billable;

  public Boolean getBillable() {
    return billable;
  }

  /**
   * Allow this user to perform operations on the account, payments, and invoices?
   */
  @Parameter
  public Boolean billingPermission;

  public Boolean getBillingPermission() {
    return billingPermission;
  }

  /**
   * Allow this user to skip site-wide IP blacklists?
   */
  @Parameter
  public Boolean bypassSiteAllowedIps;

  public Boolean getBypassSiteAllowedIps() {
    return bypassSiteAllowedIps;
  }

  /**
   * Exempt this user from being disabled based on inactivity?
   */
  @Parameter
  public Boolean bypassInactiveDisable;

  public Boolean getBypassInactiveDisable() {
    return bypassInactiveDisable;
  }

  /**
   * When this user was created
   */
  @Parameter
  public Date createdAt;

  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Can the user connect with WebDAV?
   */
  @Parameter
  public Boolean davPermission;

  public Boolean getDavPermission() {
    return davPermission;
  }

  /**
   * Is user disabled? Disabled users cannot log in, and do not count for billing purposes. Users can be automatically disabled after an inactivity period via a Site setting or schedule to be deactivated after specific date.
   */
  @Parameter
  public Boolean disabled;

  public Boolean getDisabled() {
    return disabled;
  }

  /**
   * Computed property that returns true if user disabled or expired or inactive.
   */
  @Parameter
  public Boolean disabledExpiredOrInactive;

  public Boolean getDisabledExpiredOrInactive() {
    return disabledExpiredOrInactive;
  }

  /**
   * User email address
   */
  @Parameter
  public String email;

  public String getEmail() {
    return email;
  }

  /**
   * User's first login time
   */
  @Parameter
  public Date firstLoginAt;

  public Date getFirstLoginAt() {
    return firstLoginAt;
  }

  /**
   * Can the user access with FTP/FTPS?
   */
  @Parameter
  public Boolean ftpPermission;

  public Boolean getFtpPermission() {
    return ftpPermission;
  }

  /**
   * Comma-separated list of group IDs of which this user is a member
   */
  @Parameter
  public String groupIds;

  public String getGroupIds() {
    return groupIds;
  }

  /**
   * Text to display to the user in the header of the UI
   */
  @Parameter
  public String headerText;

  public String getHeaderText() {
    return headerText;
  }

  /**
   * Preferred language
   */
  @Parameter
  public String language;

  public String getLanguage() {
    return language;
  }

  /**
   * User's most recent login time via any protocol
   */
  @Parameter
  public Date lastLoginAt;

  public Date getLastLoginAt() {
    return lastLoginAt;
  }

  /**
   * User's most recent login time via web
   */
  @Parameter
  public Date lastWebLoginAt;

  public Date getLastWebLoginAt() {
    return lastWebLoginAt;
  }

  /**
   * User's most recent login time via FTP
   */
  @Parameter
  public Date lastFtpLoginAt;

  public Date getLastFtpLoginAt() {
    return lastFtpLoginAt;
  }

  /**
   * User's most recent login time via SFTP
   */
  @Parameter
  public Date lastSftpLoginAt;

  public Date getLastSftpLoginAt() {
    return lastSftpLoginAt;
  }

  /**
   * User's most recent login time via WebDAV
   */
  @Parameter
  public Date lastDavLoginAt;

  public Date getLastDavLoginAt() {
    return lastDavLoginAt;
  }

  /**
   * User's most recent login time via Desktop app
   */
  @Parameter
  public Date lastDesktopLoginAt;

  public Date getLastDesktopLoginAt() {
    return lastDesktopLoginAt;
  }

  /**
   * User's most recent login time via Rest API
   */
  @Parameter
  public Date lastRestapiLoginAt;

  public Date getLastRestapiLoginAt() {
    return lastRestapiLoginAt;
  }

  /**
   * User's most recent API use time
   */
  @Parameter
  public Date lastApiUseAt;

  public Date getLastApiUseAt() {
    return lastApiUseAt;
  }

  /**
   * User's most recent activity time, which is the latest of most recent login, most recent API use, enablement, or creation
   */
  @Parameter
  public Date lastActiveAt;

  public Date getLastActiveAt() {
    return lastActiveAt;
  }

  /**
   * The most recent protocol and cipher used
   */
  @Parameter
  public String lastProtocolCipher;

  public String getLastProtocolCipher() {
    return lastProtocolCipher;
  }

  /**
   * Time in the future that the user will no longer be locked out if applicable
   */
  @Parameter
  public Date lockoutExpires;

  public Date getLockoutExpires() {
    return lockoutExpires;
  }

  /**
   * User's full name
   */
  @Parameter
  public String name;

  public String getName() {
    return name;
  }

  /**
   * User's company
   */
  @Parameter
  public String company;

  public String getCompany() {
    return company;
  }

  /**
   * Any internal notes on the user
   */
  @Parameter
  public String notes;

  public String getNotes() {
    return notes;
  }

  /**
   * Hour of the day at which daily notifications should be sent. Can be in range 0 to 23
   */
  @Parameter
  public Long notificationDailySendTime;

  public Long getNotificationDailySendTime() {
    return notificationDailySendTime;
  }

  /**
   * Enable integration with Office for the web?
   */
  @Parameter
  public Boolean officeIntegrationEnabled;

  public Boolean getOfficeIntegrationEnabled() {
    return officeIntegrationEnabled;
  }

  /**
   * Last time the user's password was set
   */
  @Parameter
  public Date passwordSetAt;

  public Date getPasswordSetAt() {
    return passwordSetAt;
  }

  /**
   * Number of days to allow user to use the same password
   */
  @Parameter
  public Long passwordValidityDays;

  public Long getPasswordValidityDays() {
    return passwordValidityDays;
  }

  /**
   * Number of public keys associated with this user
   */
  @Parameter
  public Long publicKeysCount;

  public Long getPublicKeysCount() {
    return publicKeysCount;
  }

  /**
   * Should the user receive admin alerts such a certificate expiration notifications and overages?
   */
  @Parameter
  public Boolean receiveAdminAlerts;

  public Boolean getReceiveAdminAlerts() {
    return receiveAdminAlerts;
  }

  /**
   * 2FA required setting
   */
  @Parameter
  public String require2fa;

  public String getRequire2fa() {
    return require2fa;
  }

  /**
   * Require user to login by specified date otherwise it will be disabled.
   */
  @Parameter
  public Date requireLoginBy;

  public Date getRequireLoginBy() {
    return requireLoginBy;
  }

  /**
   * Is 2fa active for the user?
   */
  @Parameter
  public Boolean active2fa;

  public Boolean getActive2fa() {
    return active2fa;
  }

  /**
   * Is a password change required upon next user login?
   */
  @Parameter
  public Boolean requirePasswordChange;

  public Boolean getRequirePasswordChange() {
    return requirePasswordChange;
  }

  /**
   * Is user's password expired?
   */
  @Parameter
  public Boolean passwordExpired;

  public Boolean getPasswordExpired() {
    return passwordExpired;
  }

  /**
   * Is the user an allowed to view all (non-billing) site configuration for this site?
   */
  @Parameter
  public Boolean readonlySiteAdmin;

  public Boolean getReadonlySiteAdmin() {
    return readonlySiteAdmin;
  }

  /**
   * Can this user access the Web app, Desktop app, SDKs, or REST API?  (All of these tools use the API internally, so this is one unified permission set.)
   */
  @Parameter
  public Boolean restapiPermission;

  public Boolean getRestapiPermission() {
    return restapiPermission;
  }

  /**
   * Does this user manage it's own credentials or is it a shared/bot user?
   */
  @Parameter
  public Boolean selfManaged;

  public Boolean getSelfManaged() {
    return selfManaged;
  }

  /**
   * Can the user access with SFTP?
   */
  @Parameter
  public Boolean sftpPermission;

  public Boolean getSftpPermission() {
    return sftpPermission;
  }

  /**
   * Is the user an administrator for this site?
   */
  @Parameter
  public Boolean siteAdmin;

  public Boolean getSiteAdmin() {
    return siteAdmin;
  }

  /**
   * Skip Welcome page in the UI?
   */
  @Parameter
  public Boolean skipWelcomeScreen;

  public Boolean getSkipWelcomeScreen() {
    return skipWelcomeScreen;
  }

  /**
   * SSL required setting
   */
  @Parameter
  public String sslRequired;

  public String getSslRequired() {
    return sslRequired;
  }

  /**
   * SSO (Single Sign On) strategy ID for the user, if applicable.
   */
  @Parameter
  public Long ssoStrategyId;

  public Long getSsoStrategyId() {
    return ssoStrategyId;
  }

  /**
   * Is the user subscribed to the newsletter?
   */
  @Parameter
  public Boolean subscribeToNewsletter;

  public Boolean getSubscribeToNewsletter() {
    return subscribeToNewsletter;
  }

  /**
   * Is this user managed by a SsoStrategy?
   */
  @Parameter
  public Boolean externallyManaged;

  public Boolean getExternallyManaged() {
    return externallyManaged;
  }

  /**
   * User time zone
   */
  @Parameter
  public String timeZone;

  public String getTimeZone() {
    return timeZone;
  }

  /**
   * Type(s) of 2FA methods in use, for programmatic use.  Will be either `sms`, `totp`, `webauthn`, `yubi`, `email`, or multiple values sorted alphabetically and joined by an underscore.  Does not specify whether user has more than one of a given method.
   */
  @Parameter
  public String typeOf2fa;

  public String getTypeOf2fa() {
    return typeOf2fa;
  }

  /**
   * Type(s) of 2FA methods in use, formatted for displaying in the UI.  Unlike `type_of_2fa`, this value will make clear when a user has more than 1 of the same type of method.
   */
  @Parameter
  public String typeOf2faForDisplay;

  public String getTypeOf2faForDisplay() {
    return typeOf2faForDisplay;
  }

  /**
   * Root folder for FTP (and optionally SFTP if the appropriate site-wide setting is set).  Note that this is not used for API, Desktop, or Web interface.
   */
  @Parameter
  public String userRoot;

  public String getUserRoot() {
    return userRoot;
  }

  /**
   * Home folder for FTP/SFTP.  Note that this is not used for API, Desktop, or Web interface.
   */
  @Parameter
  public String userHome;

  public String getUserHome() {
    return userHome;
  }

  /**
   * Number of days remaining until password expires
   */
  @Parameter
  public Long daysRemainingUntilPasswordExpire;

  public Long getDaysRemainingUntilPasswordExpire() {
    return daysRemainingUntilPasswordExpire;
  }

  /**
   * Password expiration datetime
   */
  @Parameter
  public Date passwordExpireAt;

  public Date getPasswordExpireAt() {
    return passwordExpireAt;
  }

  /**
   * An image file for your user avatar.
   */
  @Parameter
  public byte[] avatarFile;

  public byte[] getAvatarFile() {
    return avatarFile;
  }

  /**
   * If true, the avatar will be deleted.
   */
  @Parameter
  public Boolean avatarDelete;

  public Boolean getAvatarDelete() {
    return avatarDelete;
  }

  /**
   * Used for changing a password on an existing user.
   */
  @Parameter
  public String changePassword;

  public String getChangePassword() {
    return changePassword;
  }

  /**
   * Optional, but if provided, we will ensure that it matches the value sent in `change_password`.
   */
  @Parameter
  public String changePasswordConfirmation;

  public String getChangePasswordConfirmation() {
    return changePasswordConfirmation;
  }

  /**
   * Permission to grant on the user root.  Can be blank or `full`, `read`, `write`, `list`, `read+write`, or `list+write`
   */
  @Parameter
  public String grantPermission;

  public String getGrantPermission() {
    return grantPermission;
  }

  /**
   * Group ID to associate this user with.
   */
  @Parameter
  public Long groupId;

  public Long getGroupId() {
    return groupId;
  }

  /**
   * Pre-calculated hash of the user's password. If supplied, this will be used to authenticate the user on first login. Supported hash methods are MD5, SHA1, and SHA256.
   */
  @Parameter
  public String importedPasswordHash;

  public String getImportedPasswordHash() {
    return importedPasswordHash;
  }

  /**
   * User password.
   */
  @Parameter
  public String password;

  public String getPassword() {
    return password;
  }

  /**
   * Optional, but if provided, we will ensure that it matches the value sent in `password`.
   */
  @Parameter
  public String passwordConfirmation;

  public String getPasswordConfirmation() {
    return passwordConfirmation;
  }

  /**
   * Signifies that the user has read all the announcements in the UI.
   */
  @Parameter
  public Boolean announcementsRead;

  public Boolean getAnnouncementsRead() {
    return announcementsRead;
  }

}
