# Files.com MuleSoft Connector

The content included here should be enough to get started, but please visit our
[Developer Documentation Website](https://developers.files.com/mulesoft/) for the complete documentation.

## Introduction

MuleSoft provides a platform for building application networks that connect enterprise
applications, data, and devices across any cloud and on-premises.

The Files.com MuleSoft Connector allows you to interact with the Files.com API using MuleSoft. The
connector provides access to a wide range resources, including users, groups, folders, files, and
more.

### Requirements

Mule Runtime 4.3.0 or later is required to use the Files.com MuleSoft Connector.

### Installation

It's recommended to use Anypoint Studio to install the Files.com MuleSoft Connector. This can be
done by searching for "filescom" in the Anypoint Exchange and installing the connector from there.

Alternatively, you can modify the `pom.xml` file to include the connector as a dependency:

```xml
<dependency>
    <groupId>com.files</groupId>
    <artifactId>mule-filescom-connector</artifactId>
    <version>x.x.x</version>
    <classifier>mule-plugin</classifier>
</dependency>
```

Replace `x.x.x` with the version of the connector you wish to use.

### Usage

If you're using Anypoint Studio, you can drag and drop any of the connector's operations into your
flow to begin using them.

If you're manually coding your MuleSoft application, you'll need to include the following code
inside the `<mule>` tag of the header of your project configuration XML file:

```xml
http://www.mulesoft.org/schema/mule/filescom
http://www.mulesoft.org/schema/mule/filescom/current/mule-filescom.xsd
```

This example shows how the namespace statements are placed in the mule XML block:

```xml
<mule xmlns="http://www.mulesoft.org/schema/mule/core"
      xmlns:filescom="http://www.mulesoft.org/schema/mule/filescom"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.mulesoft.org/schema/mule/core
      http://www.mulesoft.org/schema/mule/core/current/mule.xsd
      http://www.mulesoft.org/schema/mule/filescom
      http://www.mulesoft.org/schema/mule/filescom/current/mule-filescom.xsd">
```

## Authentication

### Authenticate with an API Key

Authenticating with an API key is the recommended authentication method for most scenarios, and is
the method used in the examples on this site.

To use the Files.com connector with an API Key, first generate an API key from the [web
interface](https://www.files.com/docs/sdk-and-apis/api-keys) or [via the API or an
SDK](/rest/resources/developers/api-keys).

Note that when using a user-specific API key, if the user is an administrator, you will have full
access to the entire API. If the user is not an administrator, you will only be able to access files
that user can access, and no access will be granted to site administration functions in the API.

#### Configuring in AnyPoint Studio

The connector configuration can be added when setting up the first Files.com operation in your
flow. Simply drag and drop an operation into your flow, and you will be required to configure
the connector. Provide the API key in the configuration dialog, and the connector will use it by
default for all operations.

#### Manually Configuring the Connector

You can also manually configure the connector by adding the following element to your project
configuration XML file:

```xml title="Example Configuration"
<filescom:config name="FilesCom">
    <filescom:connection apiKey="YOUR_API_KEY" />
</filescom:config>
```

Don't forget to replace the placeholder, `YOUR_API_KEY`, with your actual API key.

## Configuration

### Configuration Options

#### Base URL

Setting the base URL for the API is required if your site is configured to disable global acceleration.
This can also be set to use a mock server in development or CI.

If you're using Anypoint Studio, you can set the base URL in the Advanced tab of the connector configuration.

If you're manually configuring your MuleSoft application, you can set the base URL in the connector configuration XML:

```xml title="Example Configuration"
<filescom:config name="FilesCom">
    <filescom:connection apiKey="YOUR_API_KEY" baseUrl="https://SUBDOMAIN.files.com" />
</filescom:config>
```

## Sort and Filter

Several of the Files.com API resources have list operations that return multiple instances of the
resource. The List operations can be sorted and filtered.

### Sorting

To sort the returned data, pass in the ```sort_by``` method argument.

Each resource supports a unique set of valid sort fields and can only be sorted by one field at a
time.

### Filtering

Filters apply selection criteria to the underlying query that returns the results. They can be
applied individually or combined with other filters, and the resulting data can be sorted by a
single field.

Each resource supports a unique set of valid filter fields, filter combinations, and combinations of
filters and sort fields.

#### Filter Types

| Filter | Type | Description |
| --------- | --------- | --------- |
| `filter` | Exact | Find resources that have an exact field value match to a passed in value. (i.e., FIELD_VALUE = PASS_IN_VALUE). |
| `filter_prefix` | Pattern | Find resources where the specified field is prefixed by the supplied value. This is applicable to values that are strings. |
| `filter_gt` | Range | Find resources that have a field value that is greater than the passed in value.  (i.e., FIELD_VALUE > PASS_IN_VALUE). |
| `filter_gteq` | Range | Find resources that have a field value that is greater than or equal to the passed in value.  (i.e., FIELD_VALUE >=  PASS_IN_VALUE). |
| `filter_lt` | Range | Find resources that have a field value that is less than the passed in value.  (i.e., FIELD_VALUE < PASS_IN_VALUE). |
| `filter_lteq` | Range | Find resources that have a field value that is less than or equal to the passed in value.  (i.e., FIELD_VALUE \<= PASS_IN_VALUE). |

## Errors

The Files.com MuleSoft Connector will return errors that fall into two categories:

1. Connector Errors - errors that originate within the connector itself
2. API Errors - errors that occur due to the response from the Files.com API

### Error Types

#### Connector Errors

Connector errors are related to processing input data, parsing API responses, and API connectivity
issues.

| Error | Description |
| ----- | ----------- |
| `FILESCOM:ARGUMENT` | Illegal Argument |
| `FILESCOM:RESPONSE` | Invalid API Response |
| `FILESCOM:CONNECTIVITY` | API Connection Error |

#### API Errors

API errors are errors returned by the Files.com API. For simpler error handling, the MuleSoft
Connector groups all API errors into the following types:

| Error | Description |
| ----- | ----------- |
| `FILESCOM:BAD_REQUEST` | Bad Request |
| `FILESCOM:NOT_AUTHENTICATED` | Not Authenticated |
| `FILESCOM:NOT_AUTHORIZED` | Not Authorized |
| `FILESCOM:NOT_FOUND` | Not Found |
| `FILESCOM:PROCESSING_FAILURE` | Processing Failure |
| `FILESCOM:RATE_LIMITED` | Rate Limited |
| `FILESCOM:SERVICE_UNAVAILABLE` | Service Unavailable |
| `FILESCOM:SITE_CONFIGURATION` | Site Configuration |
| `FILESCOM:OTHER` | Unknown API Error |

## Case Sensitivity

The Files.com API compares files and paths in a case-insensitive manner. For related documentation see [Case Sensitivity Documentation](https://www.files.com/docs/files-and-folders/file-system-semantics/case-sensitivity).

## Mock Server

Files.com publishes a Files.com API server, which is useful for testing your use of the Files.com
SDKs and other direct integrations against the Files.com API in an integration test environment.

It is a Ruby app that operates as a minimal server for the purpose of testing basic network
operations and JSON encoding for your SDK or API client. It does not maintain state and it does not
deeply inspect your submissions for correctness.

Eventually we will add more features intended for integration testing, such as the ability to
intentionally provoke errors.

Download the server as a Docker image via [Docker Hub](https://hub.docker.com/r/filescom/files-mock-server).

The Source Code is also available on [GitHub](https://github.com/Files-com/files-mock-server).

A README is available on the GitHub link.

