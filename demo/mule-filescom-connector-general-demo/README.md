# Files.com Connector Demo

Anypoint Studio demo for Files.com Connector.

## Prerequisites

* Anypoint Studio 7
* Files.com Connector v1.0.0

## How to Run

1. Import the demo project folder into Anypoint Studio.
1. Enter a valid Files.com API Key into the Files.com Config Component.
1. Click on "Test Connection..." to make sure the connection works correctly.
1. Run the application.

## Endpoints

### GET /download?path={remotePath}

Use this endpoint to download a file from Files.com.

```bash
curl --request GET "localhost:8081/download?path=folder/file.txt" --output file.txt
```

### POST /upload?path={remotePath}

Use this endpoint to upload a file to Files.com and create a Share Link for it.

```bash
curl --request POST "localhost:8081/upload?path=folder/file.txt" --data-binary @file.txt
```
