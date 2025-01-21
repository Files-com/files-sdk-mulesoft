# Share Link Registration

A BundleRegistration is a registration record when a user fills out the form to access the bundle.

## List Share Link Registrations

### XML Element

```xml
<filescom:list-share-link-registrations />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| bundleId<br/>*Long* | ID of the associated Bundle |


### Example Operation

```xml
<filescom:list-share-link-registrations config-ref="FilesCom" bundleId="1" />
```


### Example Response Payload

```json
[
  {
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
  }
]
```

