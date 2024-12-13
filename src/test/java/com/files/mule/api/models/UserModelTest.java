package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.ZonedDateTime;
import java.util.Arrays;

import org.junit.Test;

import com.files.models.User;

public class UserModelTest {
  @Test
  public void testUserModel() {
    final UserModel model = new UserModel(new User());
    model.setId(1L);
    assertThat(model.getId(), equalTo(1L));
    model.setUsername("user");
    assertThat(model.getUsername(), equalTo("user"));
    model.setAdminGroupIds(Arrays.asList(1L));
    assertThat(model.getAdminGroupIds(), equalTo(Arrays.asList(1L)));
    model.setAllowedIps("10.0.0.0/8\n127.0.0.1");
    assertThat(model.getAllowedIps(), equalTo("10.0.0.0/8\n127.0.0.1"));
    model.setAttachmentsPermission(true);
    assertThat(model.getAttachmentsPermission(), equalTo(true));
    model.setApiKeysCount(1L);
    assertThat(model.getApiKeysCount(), equalTo(1L));
    model.setAuthenticateUntil(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getAuthenticateUntil(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setAuthenticationMethod("password");
    assertThat(model.getAuthenticationMethod(), equalTo("password"));
    model.setAvatarUrl("example");
    assertThat(model.getAvatarUrl(), equalTo("example"));
    model.setBillable(true);
    assertThat(model.getBillable(), equalTo(true));
    model.setBillingPermission(true);
    assertThat(model.getBillingPermission(), equalTo(true));
    model.setBypassSiteAllowedIps(true);
    assertThat(model.getBypassSiteAllowedIps(), equalTo(true));
    model.setBypassInactiveDisable(true);
    assertThat(model.getBypassInactiveDisable(), equalTo(true));
    model.setCreatedAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getCreatedAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setDavPermission(true);
    assertThat(model.getDavPermission(), equalTo(true));
    model.setDisabled(true);
    assertThat(model.getDisabled(), equalTo(true));
    model.setDisabledExpiredOrInactive(true);
    assertThat(model.getDisabledExpiredOrInactive(), equalTo(true));
    model.setEmail("example");
    assertThat(model.getEmail(), equalTo("example"));
    model.setFirstLoginAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getFirstLoginAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setFtpPermission(true);
    assertThat(model.getFtpPermission(), equalTo(true));
    model.setGroupIds("example");
    assertThat(model.getGroupIds(), equalTo("example"));
    model.setHeaderText("User-specific message.");
    assertThat(model.getHeaderText(), equalTo("User-specific message."));
    model.setLanguage("en");
    assertThat(model.getLanguage(), equalTo("en"));
    model.setLastLoginAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getLastLoginAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setLastWebLoginAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getLastWebLoginAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setLastFtpLoginAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getLastFtpLoginAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setLastSftpLoginAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getLastSftpLoginAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setLastDavLoginAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getLastDavLoginAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setLastDesktopLoginAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getLastDesktopLoginAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setLastRestapiLoginAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getLastRestapiLoginAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setLastApiUseAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getLastApiUseAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setLastActiveAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getLastActiveAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setLastProtocolCipher("example");
    assertThat(model.getLastProtocolCipher(), equalTo("example"));
    model.setLockoutExpires(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getLockoutExpires(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setName("John Doe");
    assertThat(model.getName(), equalTo("John Doe"));
    model.setCompany("ACME Corp.");
    assertThat(model.getCompany(), equalTo("ACME Corp."));
    model.setNotes("Internal notes on this user.");
    assertThat(model.getNotes(), equalTo("Internal notes on this user."));
    model.setNotificationDailySendTime(18L);
    assertThat(model.getNotificationDailySendTime(), equalTo(18L));
    model.setOfficeIntegrationEnabled(true);
    assertThat(model.getOfficeIntegrationEnabled(), equalTo(true));
    model.setPasswordSetAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getPasswordSetAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setPasswordValidityDays(1L);
    assertThat(model.getPasswordValidityDays(), equalTo(1L));
    model.setPublicKeysCount(1L);
    assertThat(model.getPublicKeysCount(), equalTo(1L));
    model.setReceiveAdminAlerts(true);
    assertThat(model.getReceiveAdminAlerts(), equalTo(true));
    model.setRequire2fa("always_require");
    assertThat(model.getRequire2fa(), equalTo("always_require"));
    model.setRequireLoginBy(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getRequireLoginBy(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setActive2fa(true);
    assertThat(model.getActive2fa(), equalTo(true));
    model.setRequirePasswordChange(true);
    assertThat(model.getRequirePasswordChange(), equalTo(true));
    model.setPasswordExpired(true);
    assertThat(model.getPasswordExpired(), equalTo(true));
    model.setReadonlySiteAdmin(true);
    assertThat(model.getReadonlySiteAdmin(), equalTo(true));
    model.setRestapiPermission(true);
    assertThat(model.getRestapiPermission(), equalTo(true));
    model.setSelfManaged(true);
    assertThat(model.getSelfManaged(), equalTo(true));
    model.setSftpPermission(true);
    assertThat(model.getSftpPermission(), equalTo(true));
    model.setSiteAdmin(true);
    assertThat(model.getSiteAdmin(), equalTo(true));
    model.setSiteId(1L);
    assertThat(model.getSiteId(), equalTo(1L));
    model.setSkipWelcomeScreen(true);
    assertThat(model.getSkipWelcomeScreen(), equalTo(true));
    model.setEncryptionRequired("always_require");
    assertThat(model.getEncryptionRequired(), equalTo("always_require"));
    model.setSsoStrategyId(1L);
    assertThat(model.getSsoStrategyId(), equalTo(1L));
    model.setSubscribeToNewsletter(true);
    assertThat(model.getSubscribeToNewsletter(), equalTo(true));
    model.setExternallyManaged(true);
    assertThat(model.getExternallyManaged(), equalTo(true));
    model.setTimeZone("Pacific Time (US & Canada)");
    assertThat(model.getTimeZone(), equalTo("Pacific Time (US & Canada)"));
    model.setTypeOf2fa("yubi");
    assertThat(model.getTypeOf2fa(), equalTo("yubi"));
    model.setTypeOf2faForDisplay("yubi");
    assertThat(model.getTypeOf2faForDisplay(), equalTo("yubi"));
    model.setUserRoot("example");
    assertThat(model.getUserRoot(), equalTo("example"));
    model.setUserHome("example");
    assertThat(model.getUserHome(), equalTo("example"));
    model.setDaysRemainingUntilPasswordExpire(1L);
    assertThat(model.getDaysRemainingUntilPasswordExpire(), equalTo(1L));
    model.setPasswordExpireAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getPasswordExpireAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setAvatarDelete(true);
    assertThat(model.getAvatarDelete(), equalTo(true));
    model.setChangePassword("");
    assertThat(model.getChangePassword(), equalTo(""));
    model.setChangePasswordConfirmation("");
    assertThat(model.getChangePasswordConfirmation(), equalTo(""));
    model.setGrantPermission("");
    assertThat(model.getGrantPermission(), equalTo(""));
    model.setGroupId(1L);
    assertThat(model.getGroupId(), equalTo(1L));
    model.setImportedPasswordHash("");
    assertThat(model.getImportedPasswordHash(), equalTo(""));
    model.setPassword("");
    assertThat(model.getPassword(), equalTo(""));
    model.setPasswordConfirmation("");
    assertThat(model.getPasswordConfirmation(), equalTo(""));
    model.setAnnouncementsRead(true);
    assertThat(model.getAnnouncementsRead(), equalTo(true));
  }
}
