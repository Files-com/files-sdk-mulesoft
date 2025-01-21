# Share Link Download

A BundleDownload is a record of the download action that happened in the bundle.

## List Share Link Downloads

### XML Element

```xml
<filescom:list-share-link-downloads />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| bundleId<br/>*Long* | Bundle ID |


### Example Operation

```xml
<filescom:list-share-link-downloads config-ref="FilesCom" bundleId="1" />
```


### Example Response Payload

```json
[
  {
    "bundleRegistration": {
      "code": "abc123",
      "name": "account",
      "company": "Action Verb",
      "email": "john.doe@files.com",
      "ip": "10.1.1.1",
      "inboxCode": "abc123",
      "clickwrapBody": "example",
      "formFieldSetId": 1,
      "formFieldData": {
        "key": "example value"
      },
      "bundleCode": "example",
      "bundleId": 1,
      "bundleRecipientId": 1,
      "createdAt": "2000-01-01T01:00:00Z"
    },
    "downloadMethod": "file",
    "path": "a/b/test.txt",
    "createdAt": "2000-01-01T01:00:00Z"
  }
]
```

