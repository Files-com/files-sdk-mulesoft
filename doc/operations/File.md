# File



## Download File

### XML Element

```xml
<filescom:download-file />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| path<br/>*String*<br/>**Required** | Path to operate on. |


### Example Operation

```xml
<filescom:download-file config-ref="FilesCom" path="path" />
```


### Response Payload

The payload will be a stream of the file content. See [Streaming in Mule Apps](https://docs.mulesoft.com/mule-runtime/latest/streaming-about) for strategies on handling streaming data.

## Upload File

### XML Element

```xml
<filescom:upload-file />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| path<br/>*String*<br/>**Required** | Path to operate on. |
| content<br/>*Content*<br/>**Required** | Content to be written into the file. |

### Example Operation

```xml
<filescom:upload-file config-ref="FilesCom" path="path" />
```

The above example uses the payload as the content. You can also specify the content explicitly in the operation:

```xml
<filescom:upload-file config-ref="FilesCom" path="path">
  <filescom:content><![CDATA[File content]]></filescom:content>
</filescom:upload-file>
```


### Example Response Payload

```json
{
  "path": "path/file.txt",
  "createdById": 1,
  "createdByApiKeyId": 1,
  "createdByAs2IncomingMessageId": 1,
  "createdByAutomationId": 1,
  "createdByBundleRegistrationId": 1,
  "createdByInboxId": 1,
  "createdByRemoteServerId": 1,
  "createdBySyncId": 1,
  "customMetadata": {
    "key": "value"
  },
  "displayName": "file.txt",
  "type": "file",
  "size": 1024,
  "createdAt": "2000-01-01T01:00:00Z",
  "lastModifiedById": 1,
  "lastModifiedByApiKeyId": 1,
  "lastModifiedByAutomationId": 1,
  "lastModifiedByBundleRegistrationId": 1,
  "lastModifiedByRemoteServerId": 1,
  "lastModifiedBySyncId": 1,
  "mtime": "2000-01-01T01:00:00Z",
  "providedMtime": "2000-01-01T01:00:00Z",
  "crc32": "70976923",
  "md5": "17c54824e9931a4688ca032d03f6663c",
  "sha1": "a94a8fe5ccb19ba61c4c0873d391e987982fbbd3",
  "sha256": "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08",
  "mimeType": "application/octet-stream",
  "region": "us-east-1",
  "permissions": "rwd",
  "subfoldersLocked?": true,
  "isLocked": true,
  "downloadUri": "https://mysite.files.com/...",
  "priorityColor": "red",
  "previewId": 1,
  "preview": {
    "id": 1,
    "status": "complete",
    "downloadUri": "https://mysite.files.com/...",
    "type": "image",
    "size": "large"
  }
}
```

## Delete File/Folder

### XML Element

```xml
<filescom:delete-file />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| path<br/>*String*<br/>**Required** | Path to operate on. |


### Example Operation

```xml
<filescom:delete-file config-ref="FilesCom" path="path" />
```


## Find File/Folder by Path

### XML Element

```xml
<filescom:show-file />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| path<br/>*String*<br/>**Required** | Path to operate on. |


### Example Operation

```xml
<filescom:show-file config-ref="FilesCom" path="path" />
```


### Example Response Payload

```json
{
  "path": "path/file.txt",
  "createdById": 1,
  "createdByApiKeyId": 1,
  "createdByAs2IncomingMessageId": 1,
  "createdByAutomationId": 1,
  "createdByBundleRegistrationId": 1,
  "createdByInboxId": 1,
  "createdByRemoteServerId": 1,
  "createdBySyncId": 1,
  "customMetadata": {
    "key": "value"
  },
  "displayName": "file.txt",
  "type": "file",
  "size": 1024,
  "createdAt": "2000-01-01T01:00:00Z",
  "lastModifiedById": 1,
  "lastModifiedByApiKeyId": 1,
  "lastModifiedByAutomationId": 1,
  "lastModifiedByBundleRegistrationId": 1,
  "lastModifiedByRemoteServerId": 1,
  "lastModifiedBySyncId": 1,
  "mtime": "2000-01-01T01:00:00Z",
  "providedMtime": "2000-01-01T01:00:00Z",
  "crc32": "70976923",
  "md5": "17c54824e9931a4688ca032d03f6663c",
  "sha1": "a94a8fe5ccb19ba61c4c0873d391e987982fbbd3",
  "sha256": "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08",
  "mimeType": "application/octet-stream",
  "region": "us-east-1",
  "permissions": "rwd",
  "subfoldersLocked?": true,
  "isLocked": true,
  "downloadUri": "https://mysite.files.com/...",
  "priorityColor": "red",
  "previewId": 1,
  "preview": {
    "id": 1,
    "status": "complete",
    "downloadUri": "https://mysite.files.com/...",
    "type": "image",
    "size": "large"
  }
}
```

## Copy File/Folder

### XML Element

```xml
<filescom:copy-file />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| path<br/>*String*<br/>**Required** | Path to operate on. |
| destination<br/>*String*<br/>**Required** | Copy destination path. |


### Example Operation

```xml
<filescom:copy-file config-ref="FilesCom"
 path="path"
 destination="destination"
/>
```


### Example Response Payload

```json
{
  "status": "pending",
  "fileMigrationId": 1
}
```

## Move File/Folder

### XML Element

```xml
<filescom:move-file />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| path<br/>*String*<br/>**Required** | Path to operate on. |
| destination<br/>*String*<br/>**Required** | Move destination path. |


### Example Operation

```xml
<filescom:move-file config-ref="FilesCom"
 path="path"
 destination="destination"
/>
```


### Example Response Payload

```json
{
  "status": "pending",
  "fileMigrationId": 1
}
```

