# Share Link Notification

A BundleNotification is an E-Mail sent out to users when certain actions are performed on or within a shared set of files and folders.

## List Share Link Notifications

### XML Element

```xml
<filescom:list-share-link-notifications />
```


### Example Operation

```xml
<filescom:list-share-link-notifications config-ref="FilesCom" />
```


### Example Response Payload

```json
[
  {
    "bundleId": 1,
    "id": 1,
    "notifyOnRegistration": true,
    "notifyOnUpload": true,
    "notifyUserId": 1
  }
]
```

## Show Share Link Notification

### XML Element

```xml
<filescom:show-share-link-notification />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | Bundle Notification ID. |


### Example Operation

```xml
<filescom:show-share-link-notification config-ref="FilesCom" id="1" />
```


### Example Response Payload

```json
{
  "bundleId": 1,
  "id": 1,
  "notifyOnRegistration": true,
  "notifyOnUpload": true,
  "notifyUserId": 1
}
```

## Create Share Link Notification

### XML Element

```xml
<filescom:create-share-link-notification />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| bundleId<br/>*Long*<br/>**Required** | Bundle ID to notify on |
| notifyUserId<br/>*Long* | The id of the user to notify. |


### Example Operation

```xml
<filescom:create-share-link-notification config-ref="FilesCom"
 bundleId="1"
 notifyUserId="1"
/>
```


### Example Response Payload

```json
{
  "bundleId": 1,
  "id": 1,
  "notifyOnRegistration": true,
  "notifyOnUpload": true,
  "notifyUserId": 1
}
```

## Update Share Link Notification

### XML Element

```xml
<filescom:update-share-link-notification />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | Bundle Notification ID. |
| notifyOnRegistration<br/>*boolean* | Triggers bundle notification when a registration action occurs for it. |
| notifyOnUpload<br/>*boolean* | Triggers bundle notification when a upload action occurs for it. |


### Example Operation

```xml
<filescom:update-share-link-notification config-ref="FilesCom"
 id="1"
 notifyOnRegistration="true"
 notifyOnUpload="true"
/>
```


### Example Response Payload

```json
{
  "bundleId": 1,
  "id": 1,
  "notifyOnRegistration": true,
  "notifyOnUpload": true,
  "notifyUserId": 1
}
```

## Delete Share Link Notification

### XML Element

```xml
<filescom:delete-share-link-notification />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | Bundle Notification ID. |


### Example Operation

```xml
<filescom:delete-share-link-notification config-ref="FilesCom" id="1" />
```


