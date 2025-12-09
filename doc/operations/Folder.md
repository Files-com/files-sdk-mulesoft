# Folder



## List Folders by Path

### XML Element

```xml
<filescom:list-folders />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| path<br/>*String*<br/>**Required** | Path to operate on. |


### Example Operation

```xml
<filescom:list-folders config-ref="FilesCom" path="path" />
```


### Example Response Payload

```json
[
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
]
```

## Create Folder

### XML Element

```xml
<filescom:create-folder />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| path<br/>*String*<br/>**Required** | Path to operate on. |


### Example Operation

```xml
<filescom:create-folder config-ref="FilesCom" path="path" />
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

