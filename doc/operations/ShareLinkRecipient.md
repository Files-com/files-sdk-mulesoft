# Share Link Recipient

A BundleRecipient is a person who has had a bundle shared with them via email invite. A Bundle can be re-shared
with a Bundle Recipient by sending a create request with the inbox_id, recipient email address,
and share_after_create => true.

## List Share Link Recipients

### XML Element

```xml
<filescom:list-share-link-recipients />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| bundleId<br/>*Long*<br/>**Required** | List recipients for the bundle with this ID. |


### Example Operation

```xml
<filescom:list-share-link-recipients config-ref="FilesCom" bundleId="1" />
```


### Example Response Payload

```json
[
  {
    "company": "Acme Inc.",
    "name": "John Doe",
    "note": "Some note.",
    "recipient": "john.doe@example.com",
    "sentAt": "2000-01-01T01:00:00Z"
  }
]
```

## Create Share Link Recipient

### XML Element

```xml
<filescom:create-share-link-recipient />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| bundleId<br/>*Long*<br/>**Required** | Bundle to share. |
| recipient<br/>*String*<br/>**Required** | Email addresses to share this bundle with. |
| name<br/>*String* | Name of recipient. |
| company<br/>*String* | Company of recipient. |
| note<br/>*String* | Note to include in email. |


### Example Operation

```xml
<filescom:create-share-link-recipient config-ref="FilesCom"
 bundleId="1"
 recipient="johndoe@gmail.com"
 name="John Smith"
 company="Acme Ltd"
 note="Just a note."
/>
```


### Example Response Payload

```json
{
  "company": "Acme Inc.",
  "name": "John Doe",
  "note": "Some note.",
  "recipient": "john.doe@example.com",
  "sentAt": "2000-01-01T01:00:00Z"
}
```

