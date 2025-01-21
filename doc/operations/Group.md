# Group

A Group is a powerful tool for permissions and user management on Files.com.  Users can belong to multiple groups.

All permissions can be managed via Groups, and Groups can also be synced to your identity platform via LDAP or SCIM.

Files.com's Group Admin feature allows you to define Group Admins, who then have access to add and remove users within their groups.

## List Groups

### XML Element

```xml
<filescom:list-groups />
```


### Example Operation

```xml
<filescom:list-groups config-ref="FilesCom" />
```


### Example Response Payload

```json
[
  {
    "id": 1,
    "name": "owners",
    "allowedIps": "10.0.0.0/8\n127.0.0.1",
    "adminIds": "1",
    "notes": "example",
    "userIds": "1",
    "usernames": "example",
    "ftpPermission": true,
    "sftpPermission": true,
    "davPermission": true,
    "restapiPermission": true,
    "siteId": 1
  }
]
```

## Show Group

### XML Element

```xml
<filescom:show-group />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | Group ID. |


### Example Operation

```xml
<filescom:show-group config-ref="FilesCom" id="1" />
```


### Example Response Payload

```json
{
  "id": 1,
  "name": "owners",
  "allowedIps": "10.0.0.0/8\n127.0.0.1",
  "adminIds": "1",
  "notes": "example",
  "userIds": "1",
  "usernames": "example",
  "ftpPermission": true,
  "sftpPermission": true,
  "davPermission": true,
  "restapiPermission": true,
  "siteId": 1
}
```

## Create Group

### XML Element

```xml
<filescom:create-group />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| name<br/>*String*<br/>**Required** | Group name. |
| notes<br/>*String* | Group notes. |
| userIds<br/>*String* | A list of user ids. If sent as a string, should be comma-delimited. |
| adminIds<br/>*String* | A list of group admin user ids. If sent as a string, should be comma-delimited. |


### Example Operation

```xml
<filescom:create-group config-ref="FilesCom"
 name="name"
 notes="example"
 userIds="1"
 adminIds="1"
/>
```


### Example Response Payload

```json
{
  "id": 1,
  "name": "owners",
  "allowedIps": "10.0.0.0/8\n127.0.0.1",
  "adminIds": "1",
  "notes": "example",
  "userIds": "1",
  "usernames": "example",
  "ftpPermission": true,
  "sftpPermission": true,
  "davPermission": true,
  "restapiPermission": true,
  "siteId": 1
}
```

## Update Group

### XML Element

```xml
<filescom:update-group />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | Group ID. |
| notes<br/>*String* | Group notes. |
| userIds<br/>*String* | A list of user ids. If sent as a string, should be comma-delimited. |
| adminIds<br/>*String* | A list of group admin user ids. If sent as a string, should be comma-delimited. |
| name<br/>*String* | Group name. |


### Example Operation

```xml
<filescom:update-group config-ref="FilesCom"
 id="1"
 notes="example"
 userIds="1"
 adminIds="1"
 name="owners"
/>
```


### Example Response Payload

```json
{
  "id": 1,
  "name": "owners",
  "allowedIps": "10.0.0.0/8\n127.0.0.1",
  "adminIds": "1",
  "notes": "example",
  "userIds": "1",
  "usernames": "example",
  "ftpPermission": true,
  "sftpPermission": true,
  "davPermission": true,
  "restapiPermission": true,
  "siteId": 1
}
```

## Delete Group

### XML Element

```xml
<filescom:delete-group />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | Group ID. |


### Example Operation

```xml
<filescom:delete-group config-ref="FilesCom" id="1" />
```


