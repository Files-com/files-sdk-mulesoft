# Share Link

A Bundle is the API/SDK term for the feature called Share Links in the web interface.
The API provides the full set of actions related to Share Links, including sending them via E-Mail.

Please note that we very closely monitor the E-Mailing feature and any abuse will result in disabling of your site.

## List Share Links

### XML Element

```xml
<filescom:list-share-links />
```


### Example Operation

```xml
<filescom:list-share-links config-ref="FilesCom" />
```


### Example Response Payload

```json
[
  {
    "code": "abc123",
    "colorLeft": "#0066a7",
    "colorLink": "#d34f5d",
    "colorText": "#0066a7",
    "colorTop": "#000000",
    "colorTopText": "#ffffff",
    "url": "https://subdomain.files.com/f/12345678",
    "description": "The public description of the bundle.",
    "expiresAt": "2000-01-01T01:00:00Z",
    "passwordProtected": true,
    "permissions": "read",
    "previewOnly": true,
    "requireRegistration": true,
    "requireShareRecipient": true,
    "requireLogout": true,
    "clickwrapBody": "[Legal text]",
    "formFieldSet": {
      "id": 1,
      "title": "Sample Form Title",
      "formLayout": [
        1,
        2,
        3,
        4
      ],
      "formFields": [
        {
          "id": 1,
          "label": "Sample Label",
          "required": true,
          "helpText": "Help Text",
          "fieldType": "text",
          "optionsForSelect": [
            "red",
            "green",
            "blue"
          ],
          "defaultOption": "red",
          "formFieldSetId": 1
        }
      ],
      "skipName": true,
      "skipEmail": true,
      "skipCompany": true,
      "inUse": true
    },
    "skipName": true,
    "skipEmail": true,
    "startAccessOnDate": "2000-01-01T01:00:00Z",
    "skipCompany": true,
    "id": 1,
    "createdAt": "2000-01-01T01:00:00Z",
    "dontSeparateSubmissionsByFolder": true,
    "maxUses": 1,
    "note": "The internal note on the bundle.",
    "pathTemplate": "{{name}}_{{ip}}",
    "pathTemplateTimeZone": "Eastern Time (US & Canada)",
    "sendEmailReceiptToUploader": true,
    "snapshotId": 1,
    "userId": 1,
    "username": "user",
    "clickwrapId": 1,
    "inboxId": 1,
    "watermarkAttachment": {
      "name": "My logo",
      "uri": "https://mysite.files.com/.../my_image.png"
    },
    "watermarkValue": {
      "key": "example value"
    },
    "sendOneTimePasswordToRecipientAtRegistration": true,
    "hasInbox": true,
    "dontAllowFoldersInUploads": true,
    "paths": [
      "file.txt"
    ],
    "bundlepaths": [
      {
        "recursive": true,
        "path": "example"
      }
    ]
  }
]
```

## Show Share Link

### XML Element

```xml
<filescom:show-share-link />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | Bundle ID. |


### Example Operation

```xml
<filescom:show-share-link config-ref="FilesCom" id="1" />
```


### Example Response Payload

```json
{
  "code": "abc123",
  "colorLeft": "#0066a7",
  "colorLink": "#d34f5d",
  "colorText": "#0066a7",
  "colorTop": "#000000",
  "colorTopText": "#ffffff",
  "url": "https://subdomain.files.com/f/12345678",
  "description": "The public description of the bundle.",
  "expiresAt": "2000-01-01T01:00:00Z",
  "passwordProtected": true,
  "permissions": "read",
  "previewOnly": true,
  "requireRegistration": true,
  "requireShareRecipient": true,
  "requireLogout": true,
  "clickwrapBody": "[Legal text]",
  "formFieldSet": {
    "id": 1,
    "title": "Sample Form Title",
    "formLayout": [
      1,
      2,
      3,
      4
    ],
    "formFields": [
      {
        "id": 1,
        "label": "Sample Label",
        "required": true,
        "helpText": "Help Text",
        "fieldType": "text",
        "optionsForSelect": [
          "red",
          "green",
          "blue"
        ],
        "defaultOption": "red",
        "formFieldSetId": 1
      }
    ],
    "skipName": true,
    "skipEmail": true,
    "skipCompany": true,
    "inUse": true
  },
  "skipName": true,
  "skipEmail": true,
  "startAccessOnDate": "2000-01-01T01:00:00Z",
  "skipCompany": true,
  "id": 1,
  "createdAt": "2000-01-01T01:00:00Z",
  "dontSeparateSubmissionsByFolder": true,
  "maxUses": 1,
  "note": "The internal note on the bundle.",
  "pathTemplate": "{{name}}_{{ip}}",
  "pathTemplateTimeZone": "Eastern Time (US & Canada)",
  "sendEmailReceiptToUploader": true,
  "snapshotId": 1,
  "userId": 1,
  "username": "user",
  "clickwrapId": 1,
  "inboxId": 1,
  "watermarkAttachment": {
    "name": "My logo",
    "uri": "https://mysite.files.com/.../my_image.png"
  },
  "watermarkValue": {
    "key": "example value"
  },
  "sendOneTimePasswordToRecipientAtRegistration": true,
  "hasInbox": true,
  "dontAllowFoldersInUploads": true,
  "paths": [
    "file.txt"
  ],
  "bundlepaths": [
    {
      "recursive": true,
      "path": "example"
    }
  ]
}
```

## Create Share Link

### XML Element

```xml
<filescom:create-share-link />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| paths<br/>*List&lt;String&gt;*<br/>**Required** | A list of paths to include in this bundle. |
| password<br/>*String* | Password for this bundle. |
| expiresAt<br/>*String* | Bundle expiration date/time |
| maxUses<br/>*Long* | Maximum number of times bundle can be accessed |
| description<br/>*String* | Public description |
| note<br/>*String* | Bundle internal note |
| requireRegistration<br/>*boolean* | Show a registration page that captures the downloader's name and email address? |


### Example Operation

```xml
<filescom:create-share-link config-ref="FilesCom"
 paths='#[["file.txt"]]'
 password="Password"
 expiresAt="2000-01-01T01:00:00Z"
 maxUses="1"
 description="The public description of the bundle."
 note="The internal note on the bundle."
 requireRegistration="false"
/>
```


### Example Response Payload

```json
{
  "code": "abc123",
  "colorLeft": "#0066a7",
  "colorLink": "#d34f5d",
  "colorText": "#0066a7",
  "colorTop": "#000000",
  "colorTopText": "#ffffff",
  "url": "https://subdomain.files.com/f/12345678",
  "description": "The public description of the bundle.",
  "expiresAt": "2000-01-01T01:00:00Z",
  "passwordProtected": true,
  "permissions": "read",
  "previewOnly": true,
  "requireRegistration": true,
  "requireShareRecipient": true,
  "requireLogout": true,
  "clickwrapBody": "[Legal text]",
  "formFieldSet": {
    "id": 1,
    "title": "Sample Form Title",
    "formLayout": [
      1,
      2,
      3,
      4
    ],
    "formFields": [
      {
        "id": 1,
        "label": "Sample Label",
        "required": true,
        "helpText": "Help Text",
        "fieldType": "text",
        "optionsForSelect": [
          "red",
          "green",
          "blue"
        ],
        "defaultOption": "red",
        "formFieldSetId": 1
      }
    ],
    "skipName": true,
    "skipEmail": true,
    "skipCompany": true,
    "inUse": true
  },
  "skipName": true,
  "skipEmail": true,
  "startAccessOnDate": "2000-01-01T01:00:00Z",
  "skipCompany": true,
  "id": 1,
  "createdAt": "2000-01-01T01:00:00Z",
  "dontSeparateSubmissionsByFolder": true,
  "maxUses": 1,
  "note": "The internal note on the bundle.",
  "pathTemplate": "{{name}}_{{ip}}",
  "pathTemplateTimeZone": "Eastern Time (US & Canada)",
  "sendEmailReceiptToUploader": true,
  "snapshotId": 1,
  "userId": 1,
  "username": "user",
  "clickwrapId": 1,
  "inboxId": 1,
  "watermarkAttachment": {
    "name": "My logo",
    "uri": "https://mysite.files.com/.../my_image.png"
  },
  "watermarkValue": {
    "key": "example value"
  },
  "sendOneTimePasswordToRecipientAtRegistration": true,
  "hasInbox": true,
  "dontAllowFoldersInUploads": true,
  "paths": [
    "file.txt"
  ],
  "bundlepaths": [
    {
      "recursive": true,
      "path": "example"
    }
  ]
}
```

## Update Share Link

### XML Element

```xml
<filescom:update-share-link />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | Bundle ID. |
| expiresAt<br/>*String* | Bundle expiration date/time |


### Example Operation

```xml
<filescom:update-share-link config-ref="FilesCom"
 id="1"
 expiresAt="2000-01-01T01:00:00Z"
/>
```


### Example Response Payload

```json
{
  "code": "abc123",
  "colorLeft": "#0066a7",
  "colorLink": "#d34f5d",
  "colorText": "#0066a7",
  "colorTop": "#000000",
  "colorTopText": "#ffffff",
  "url": "https://subdomain.files.com/f/12345678",
  "description": "The public description of the bundle.",
  "expiresAt": "2000-01-01T01:00:00Z",
  "passwordProtected": true,
  "permissions": "read",
  "previewOnly": true,
  "requireRegistration": true,
  "requireShareRecipient": true,
  "requireLogout": true,
  "clickwrapBody": "[Legal text]",
  "formFieldSet": {
    "id": 1,
    "title": "Sample Form Title",
    "formLayout": [
      1,
      2,
      3,
      4
    ],
    "formFields": [
      {
        "id": 1,
        "label": "Sample Label",
        "required": true,
        "helpText": "Help Text",
        "fieldType": "text",
        "optionsForSelect": [
          "red",
          "green",
          "blue"
        ],
        "defaultOption": "red",
        "formFieldSetId": 1
      }
    ],
    "skipName": true,
    "skipEmail": true,
    "skipCompany": true,
    "inUse": true
  },
  "skipName": true,
  "skipEmail": true,
  "startAccessOnDate": "2000-01-01T01:00:00Z",
  "skipCompany": true,
  "id": 1,
  "createdAt": "2000-01-01T01:00:00Z",
  "dontSeparateSubmissionsByFolder": true,
  "maxUses": 1,
  "note": "The internal note on the bundle.",
  "pathTemplate": "{{name}}_{{ip}}",
  "pathTemplateTimeZone": "Eastern Time (US & Canada)",
  "sendEmailReceiptToUploader": true,
  "snapshotId": 1,
  "userId": 1,
  "username": "user",
  "clickwrapId": 1,
  "inboxId": 1,
  "watermarkAttachment": {
    "name": "My logo",
    "uri": "https://mysite.files.com/.../my_image.png"
  },
  "watermarkValue": {
    "key": "example value"
  },
  "sendOneTimePasswordToRecipientAtRegistration": true,
  "hasInbox": true,
  "dontAllowFoldersInUploads": true,
  "paths": [
    "file.txt"
  ],
  "bundlepaths": [
    {
      "recursive": true,
      "path": "example"
    }
  ]
}
```

## Delete Share Link

### XML Element

```xml
<filescom:delete-share-link />
```

### Parameters

| Parameter | Description |
| --------- | ----------- |
| id<br/>*Long*<br/>**Required** | Bundle ID. |


### Example Operation

```xml
<filescom:delete-share-link config-ref="FilesCom" id="1" />
```


