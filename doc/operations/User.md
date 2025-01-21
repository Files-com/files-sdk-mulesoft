# User

A User represents a human or system/service user with the ability to connect to Files.com via any of the available connectivity methods (unless restricted to specific protocols).

Users are associated with API Keys, SSH (SFTP) Keys, Notifications, Permissions, and Group memberships.


## Authentication

The `authentication_method` property on a User determines exactly how that user can login and authenticate to their Files.com account. Files.com offers a variety of authentication methods to ensure flexibility, security, migration, and compliance.

These authentication methods can be configured during user creation and can be modified at any time by site administrators. The meanings of the available values are as follows:

* `password` - Allows authentication via a password.  If API Keys or SSH (SFTP) Keys are also configured, those can be used *instead* of the password.  If Two Factor Authentication (2FA) methods are also configured, a valid 2nd factor is required in addition to the password.
* `email_signup` - When set upon user creation, an email will be sent to the new user with a link for them to create their password. Once the user has created their password, their authentication type will change to `password`.
* `sso` - Allows authentication via a linked Single Sign On provider.  If API Keys or SSH (SFTP) Keys are also configured, those can be used *instead* of Single Sign On.  If Two Factor Authentication (2FA) methods are also configured, a valid 2nd factor is required in addition to Single Sign On.  When using this method, you must also provide a valid `sso_strategy_id` to associate the User to the appropriate SSO provider.
* `password_with_imported_hash` - Works like the `password` method but allows importing a hashed password in MD5, SHA-1, or SHA-256 format.  Provide the imported hash in the field `imported_password_hash`.  Upon first use, the password will be converted to Files.com's internal storage format and the authentication type will change to `password`. Typically only used when migrating to Files.com from another MFT solution.
* `none` - Does not allow authentication via username and password, but does allow authentication via API Key or SSH (SFTP) Key.  Typically only used for service users.
* `password_and_ssh_key` - Allows authentication only by providing a password and also a valid SSH (SFTP) Key in a single attempt.  If API Keys are also configured, those can be used *instead* of the password and key combination.  This method only works with (typically enterprise) SSH/SFTP clients capable of sending both authentication methods at once.  Typically only used for service users.

## List Users

### XML Element

```xml
<filescom:list-users />
```


### Example Operation

```xml
<filescom:list-users config-ref="FilesCom" />
```


### Example Response Payload

```json
[
  {
    "id": 1,
    "username": "user",
    "adminGroupIds": [
      1
    ],
    "allowedIps": "10.0.0.0/8\n127.0.0.1",
    "attachmentsPermission": true,
    "apiKeysCount": 1,
    "authenticateUntil": "2000-01-01T01:00:00Z",
    "authenticationMethod": "password",
    "avatarUrl": "example",
    "billable": true,
    "billingPermission": true,
    "bypassSiteAllowedIps": true,
    "bypassInactiveDisable": true,
    "createdAt": "2000-01-01T01:00:00Z",
    "davPermission": true,
    "disabled": true,
    "disabledExpiredOrInactive": true,
    "email": "example",
    "firstLoginAt": "2000-01-01T01:00:00Z",
    "ftpPermission": true,
    "groupIds": "example",
    "headerText": "User-specific message.",
    "language": "en",
    "lastLoginAt": "2000-01-01T01:00:00Z",
    "lastWebLoginAt": "2000-01-01T01:00:00Z",
    "lastFtpLoginAt": "2000-01-01T01:00:00Z",
    "lastSftpLoginAt": "2000-01-01T01:00:00Z",
    "lastDavLoginAt": "2000-01-01T01:00:00Z",
    "lastDesktopLoginAt": "2000-01-01T01:00:00Z",
    "lastRestapiLoginAt": "2000-01-01T01:00:00Z",
    "lastApiUseAt": "2000-01-01T01:00:00Z",
    "lastActiveAt": "2000-01-01T01:00:00Z",
    "lastProtocolCipher": "example",
    "lockoutExpires": "2000-01-01T01:00:00Z",
    "name": "John Doe",
    "company": "ACME Corp.",
    "notes": "Internal notes on this user.",
    "notificationDailySendTime": 18,
    "officeIntegrationEnabled": true,
    "passwordSetAt": "2000-01-01T01:00:00Z",
    "passwordValidityDays": 1,
    "publicKeysCount": 1,
    "receiveAdminAlerts": true,
    "require2fa": "always_require",
    "requireLoginBy": "2000-01-01T01:00:00Z",
    "active2fa": true,
    "requirePasswordChange": true,
    "passwordExpired": true,
    "readonlySiteAdmin": true,
    "restapiPermission": true,
    "selfManaged": true,
    "sftpPermission": true,
    "siteAdmin": true,
    "siteId": 1,
    "skipWelcomeScreen": true,
    "sslRequired": "always_require",
    "ssoStrategyId": 1,
    "subscribeToNewsletter": true,
    "externallyManaged": true,
    "timeZone": "Pacific Time (US & Canada)",
    "typeOf2fa": "yubi",
    "typeOf2faForDisplay": "yubi",
    "userRoot": "example",
    "userHome": "example",
    "daysRemainingUntilPasswordExpire": 1,
    "passwordExpireAt": "2000-01-01T01:00:00Z"
  }
]
```

## Show User

### XML Element

```xml
<filescom:show-user />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | User ID. |


### Example Operation

```xml
<filescom:show-user config-ref="FilesCom" id="1" />
```


### Example Response Payload

```json
{
  "id": 1,
  "username": "user",
  "adminGroupIds": [
    1
  ],
  "allowedIps": "10.0.0.0/8\n127.0.0.1",
  "attachmentsPermission": true,
  "apiKeysCount": 1,
  "authenticateUntil": "2000-01-01T01:00:00Z",
  "authenticationMethod": "password",
  "avatarUrl": "example",
  "billable": true,
  "billingPermission": true,
  "bypassSiteAllowedIps": true,
  "bypassInactiveDisable": true,
  "createdAt": "2000-01-01T01:00:00Z",
  "davPermission": true,
  "disabled": true,
  "disabledExpiredOrInactive": true,
  "email": "example",
  "firstLoginAt": "2000-01-01T01:00:00Z",
  "ftpPermission": true,
  "groupIds": "example",
  "headerText": "User-specific message.",
  "language": "en",
  "lastLoginAt": "2000-01-01T01:00:00Z",
  "lastWebLoginAt": "2000-01-01T01:00:00Z",
  "lastFtpLoginAt": "2000-01-01T01:00:00Z",
  "lastSftpLoginAt": "2000-01-01T01:00:00Z",
  "lastDavLoginAt": "2000-01-01T01:00:00Z",
  "lastDesktopLoginAt": "2000-01-01T01:00:00Z",
  "lastRestapiLoginAt": "2000-01-01T01:00:00Z",
  "lastApiUseAt": "2000-01-01T01:00:00Z",
  "lastActiveAt": "2000-01-01T01:00:00Z",
  "lastProtocolCipher": "example",
  "lockoutExpires": "2000-01-01T01:00:00Z",
  "name": "John Doe",
  "company": "ACME Corp.",
  "notes": "Internal notes on this user.",
  "notificationDailySendTime": 18,
  "officeIntegrationEnabled": true,
  "passwordSetAt": "2000-01-01T01:00:00Z",
  "passwordValidityDays": 1,
  "publicKeysCount": 1,
  "receiveAdminAlerts": true,
  "require2fa": "always_require",
  "requireLoginBy": "2000-01-01T01:00:00Z",
  "active2fa": true,
  "requirePasswordChange": true,
  "passwordExpired": true,
  "readonlySiteAdmin": true,
  "restapiPermission": true,
  "selfManaged": true,
  "sftpPermission": true,
  "siteAdmin": true,
  "siteId": 1,
  "skipWelcomeScreen": true,
  "sslRequired": "always_require",
  "ssoStrategyId": 1,
  "subscribeToNewsletter": true,
  "externallyManaged": true,
  "timeZone": "Pacific Time (US & Canada)",
  "typeOf2fa": "yubi",
  "typeOf2faForDisplay": "yubi",
  "userRoot": "example",
  "userHome": "example",
  "daysRemainingUntilPasswordExpire": 1,
  "passwordExpireAt": "2000-01-01T01:00:00Z"
}
```

## Create User

### XML Element

```xml
<filescom:create-user />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| username<br/>*String*<br/>**Required** | User's username |
| email<br/>*String* | User's email. |
| groupIds<br/>*String* | A list of group ids to associate this user with.  Comma delimited. |
| password<br/>*String* | User password. |
| authenticationMethod<br/>*String* | How is this user authenticated?<br/>Possible values: `password`, `email_signup` |
| name<br/>*String* | User's full name |
| company<br/>*String* | User's company |
| notes<br/>*String* | Any internal notes on the user |
| requirePasswordChange<br/>*boolean* | Is a password change required upon next user login? |
| userRoot<br/>*String* | Root folder for FTP (and optionally SFTP if the appropriate site-wide setting is set).  Note that this is not used for API, Desktop, or Web interface. |
| userHome<br/>*String* | Home folder for FTP/SFTP.  Note that this is not used for API, Desktop, or Web interface. |


### Example Operation

```xml
<filescom:create-user config-ref="FilesCom"
 username="user"
 email="example"
 groupIds="example"
 authenticationMethod="password"
 name="John Doe"
 company="ACME Corp."
 notes="Internal notes on this user."
 requirePasswordChange="true"
 userRoot="example"
 userHome="example"
/>
```


### Example Response Payload

```json
{
  "id": 1,
  "username": "user",
  "adminGroupIds": [
    1
  ],
  "allowedIps": "10.0.0.0/8\n127.0.0.1",
  "attachmentsPermission": true,
  "apiKeysCount": 1,
  "authenticateUntil": "2000-01-01T01:00:00Z",
  "authenticationMethod": "password",
  "avatarUrl": "example",
  "billable": true,
  "billingPermission": true,
  "bypassSiteAllowedIps": true,
  "bypassInactiveDisable": true,
  "createdAt": "2000-01-01T01:00:00Z",
  "davPermission": true,
  "disabled": true,
  "disabledExpiredOrInactive": true,
  "email": "example",
  "firstLoginAt": "2000-01-01T01:00:00Z",
  "ftpPermission": true,
  "groupIds": "example",
  "headerText": "User-specific message.",
  "language": "en",
  "lastLoginAt": "2000-01-01T01:00:00Z",
  "lastWebLoginAt": "2000-01-01T01:00:00Z",
  "lastFtpLoginAt": "2000-01-01T01:00:00Z",
  "lastSftpLoginAt": "2000-01-01T01:00:00Z",
  "lastDavLoginAt": "2000-01-01T01:00:00Z",
  "lastDesktopLoginAt": "2000-01-01T01:00:00Z",
  "lastRestapiLoginAt": "2000-01-01T01:00:00Z",
  "lastApiUseAt": "2000-01-01T01:00:00Z",
  "lastActiveAt": "2000-01-01T01:00:00Z",
  "lastProtocolCipher": "example",
  "lockoutExpires": "2000-01-01T01:00:00Z",
  "name": "John Doe",
  "company": "ACME Corp.",
  "notes": "Internal notes on this user.",
  "notificationDailySendTime": 18,
  "officeIntegrationEnabled": true,
  "passwordSetAt": "2000-01-01T01:00:00Z",
  "passwordValidityDays": 1,
  "publicKeysCount": 1,
  "receiveAdminAlerts": true,
  "require2fa": "always_require",
  "requireLoginBy": "2000-01-01T01:00:00Z",
  "active2fa": true,
  "requirePasswordChange": true,
  "passwordExpired": true,
  "readonlySiteAdmin": true,
  "restapiPermission": true,
  "selfManaged": true,
  "sftpPermission": true,
  "siteAdmin": true,
  "siteId": 1,
  "skipWelcomeScreen": true,
  "sslRequired": "always_require",
  "ssoStrategyId": 1,
  "subscribeToNewsletter": true,
  "externallyManaged": true,
  "timeZone": "Pacific Time (US & Canada)",
  "typeOf2fa": "yubi",
  "typeOf2faForDisplay": "yubi",
  "userRoot": "example",
  "userHome": "example",
  "daysRemainingUntilPasswordExpire": 1,
  "passwordExpireAt": "2000-01-01T01:00:00Z"
}
```

## Update User

### XML Element

```xml
<filescom:update-user />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | User ID. |
| email<br/>*String* | User's email. |
| groupIds<br/>*String* | A list of group ids to associate this user with.  Comma delimited. |
| password<br/>*String* | User password. |
| authenticationMethod<br/>*String* | How is this user authenticated?<br/>Possible values: `password`, `email_signup` |
| name<br/>*String* | User's full name |
| company<br/>*String* | User's company |
| notes<br/>*String* | Any internal notes on the user |
| requirePasswordChange<br/>*boolean* | Is a password change required upon next user login? |
| userRoot<br/>*String* | Root folder for FTP (and optionally SFTP if the appropriate site-wide setting is set).  Note that this is not used for API, Desktop, or Web interface. |
| userHome<br/>*String* | Home folder for FTP/SFTP.  Note that this is not used for API, Desktop, or Web interface. |
| username<br/>*String* | User's username |


### Example Operation

```xml
<filescom:update-user config-ref="FilesCom"
 id="1"
 email="example"
 groupIds="example"
 authenticationMethod="password"
 name="John Doe"
 company="ACME Corp."
 notes="Internal notes on this user."
 requirePasswordChange="true"
 userRoot="example"
 userHome="example"
 username="user"
/>
```


### Example Response Payload

```json
{
  "id": 1,
  "username": "user",
  "adminGroupIds": [
    1
  ],
  "allowedIps": "10.0.0.0/8\n127.0.0.1",
  "attachmentsPermission": true,
  "apiKeysCount": 1,
  "authenticateUntil": "2000-01-01T01:00:00Z",
  "authenticationMethod": "password",
  "avatarUrl": "example",
  "billable": true,
  "billingPermission": true,
  "bypassSiteAllowedIps": true,
  "bypassInactiveDisable": true,
  "createdAt": "2000-01-01T01:00:00Z",
  "davPermission": true,
  "disabled": true,
  "disabledExpiredOrInactive": true,
  "email": "example",
  "firstLoginAt": "2000-01-01T01:00:00Z",
  "ftpPermission": true,
  "groupIds": "example",
  "headerText": "User-specific message.",
  "language": "en",
  "lastLoginAt": "2000-01-01T01:00:00Z",
  "lastWebLoginAt": "2000-01-01T01:00:00Z",
  "lastFtpLoginAt": "2000-01-01T01:00:00Z",
  "lastSftpLoginAt": "2000-01-01T01:00:00Z",
  "lastDavLoginAt": "2000-01-01T01:00:00Z",
  "lastDesktopLoginAt": "2000-01-01T01:00:00Z",
  "lastRestapiLoginAt": "2000-01-01T01:00:00Z",
  "lastApiUseAt": "2000-01-01T01:00:00Z",
  "lastActiveAt": "2000-01-01T01:00:00Z",
  "lastProtocolCipher": "example",
  "lockoutExpires": "2000-01-01T01:00:00Z",
  "name": "John Doe",
  "company": "ACME Corp.",
  "notes": "Internal notes on this user.",
  "notificationDailySendTime": 18,
  "officeIntegrationEnabled": true,
  "passwordSetAt": "2000-01-01T01:00:00Z",
  "passwordValidityDays": 1,
  "publicKeysCount": 1,
  "receiveAdminAlerts": true,
  "require2fa": "always_require",
  "requireLoginBy": "2000-01-01T01:00:00Z",
  "active2fa": true,
  "requirePasswordChange": true,
  "passwordExpired": true,
  "readonlySiteAdmin": true,
  "restapiPermission": true,
  "selfManaged": true,
  "sftpPermission": true,
  "siteAdmin": true,
  "siteId": 1,
  "skipWelcomeScreen": true,
  "sslRequired": "always_require",
  "ssoStrategyId": 1,
  "subscribeToNewsletter": true,
  "externallyManaged": true,
  "timeZone": "Pacific Time (US & Canada)",
  "typeOf2fa": "yubi",
  "typeOf2faForDisplay": "yubi",
  "userRoot": "example",
  "userHome": "example",
  "daysRemainingUntilPasswordExpire": 1,
  "passwordExpireAt": "2000-01-01T01:00:00Z"
}
```

## Delete User

### XML Element

```xml
<filescom:delete-user />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | User ID. |


### Example Operation

```xml
<filescom:delete-user config-ref="FilesCom" id="1" />
```


