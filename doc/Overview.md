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

The Files.com MuleSoft Connector is published to Maven Central. To install it, add the connector as
a dependency in your Mule application's `pom.xml` file:

```xml
<dependency>
    <groupId>com.files</groupId>
    <artifactId>mule-filescom-connector</artifactId>
    <version>x.x.x</version>
    <classifier>mule-plugin</classifier>
</dependency>
```

Replace `x.x.x` with the version of the connector you wish to use. The latest version is listed on
[Maven Central](https://central.sonatype.com/artifact/com.files/mule-filescom-connector).

The connector is also listed on Anypoint Exchange, but new versions reach Maven Central first.

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

#### Special note about the List Folder Endpoint

For historical reasons, and to maintain compatibility
with a variety of other cloud-based MFT and EFSS services, Folders will always be listed before Files
when listing a Folder.  This applies regardless of the sorting parameters you provide.  These *will* be
used, after the initial sort application of Folders before Files.

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

## Paths

Files.com preserves the spelling of file and folder paths while comparing them using shared case and Unicode rules. Use the SDK comparison helpers when matching paths locally.
<div></div>

### Capitalization

Files.com uses case-insensitive path matching based on its fixed Unicode comparison map.

For example, the following paths have the same comparison key:

| Path Variant                          | Comparison Key              |
|---------------------------------------|------------------------------|
| `Documents/Reports/Q1.pdf`            | `documents/reports/q1.pdf`  |
| `documents/reports/q1.PDF`            | `documents/reports/q1.pdf`  |
| `DOCUMENTS/REPORTS/Q1.PDF`            | `documents/reports/q1.pdf`  |

This behavior applies across:
- API requests
- Folder and file lookup operations
- Automations and workflows

See also: [Case Sensitivity Documentation](https://www.files.com/docs/files-and-folders/case-sensitivity/)

### Slashes

Use `/` between folder and file names, without leading or trailing slashes. SDK normalization helpers convert backslashes to `/`, remove duplicate separators, and discard exact `.` and `..` components. Discarding `..` leaves the preceding folder name intact.

| Input | Normalized path |
|-------|-----------------|
| `folder/subfolder/file.txt` | `folder/subfolder/file.txt` |
| `/folder/subfolder/file.txt` | `folder/subfolder/file.txt` |
| `folder/subfolder/file.txt/` | `folder/subfolder/file.txt` |
| `//folder//file.txt` | `folder/file.txt` |
| `folder/../file.txt` | `folder/file.txt` |

<div></div>

### Unicode and Path Comparison

Files.com compares paths using a fixed mapping shared by the server and SDKs. It treats case and many accent differences as equivalent: `Résumé.txt` and `resume.txt` identify the same file, as do `q` followed by a combining acute accent and `q`. The mapping also handles other equivalences, such as Hiragana and Katakana. Lowercasing or applying a standard Unicode normalization form alone does not reproduce these rules.

SDK comparison helpers normalize path separators and dot segments, then apply the bundled [versioned comparison map](https://github.com/Files-com/files-sdk-javascript/blob/master/shared/path_comparison.json). The [shared examples](https://github.com/Files-com/files-sdk-javascript/blob/master/shared/comparison_examples.json) give exact comparison results for integrations that implement their own matching. The map uses hexadecimal Unicode scalar values as keys: a missing entry preserves the character, an empty replacement removes it, and other replacements may contain several characters. Apply each replacement once without normalizing or lowercasing the result again.

Use comparison results only for matching. Send the original path spelling in API requests and preserve it for display and local filenames; comparison results can have a different spelling or length.

Trailing whitespace is significant for comparison. `report.txt` and `report.txt ` are different file paths, and SDK helpers preserve spaces, tabs, and newlines. Folder names cannot end in whitespace. See [Unicode Normalization](https://www.files.com/docs/files-and-folders/file-system-semantics/unicode-normalization) for the complete path rules.

<div></div>

## Workspaces

A Workspace groups files, users, groups, Partners, integrations, and workflows within a Files.com Site. An integration can provision a Workspace for a department or project and delegate its operation to a team without making that team Site Administrators. Every Site has a Default Workspace, with ID `0`; additional Workspaces have their own IDs and root folders.

Account membership, request context, and permission grants serve different purposes. Creating an account in a Workspace determines where it belongs. Selecting a Workspace determines which resources a request operates on. A permission grant determines what the caller can do there. Selecting a Workspace never grants access to it.

### Accounts and Administrative Access

A user's or group's `workspace_id` identifies the Workspace the account belongs to. Accounts belonging to a Custom Workspace stay within it. Default Workspace users and groups can receive permissions in one or more Custom Workspaces while keeping their existing accounts in Workspace `0`.

| Account | Workspace Administrator assignment | Scope |
| --- | --- | --- |
| User belonging to a Custom Workspace | Set the user's `workspace_admin` to `true`. | That user's own Custom Workspace. |
| Default Workspace user | Create an `admin` Permission for the user on a Custom Workspace's root folder. | Each Custom Workspace with a root grant. |
| Default Workspace group | Create an `admin` Permission for the group on a Custom Workspace's root folder. | Every member inherits administration of each Workspace with a root grant. |

`workspace_admin` is not a summary of a user's effective administrative access. A Default Workspace user can administer a Custom Workspace through a direct or group root grant while their `workspace_admin` remains `false`. Groups have no `workspace_admin` field. See [Users](/mulesoft/resources/user-accounts/users) and [Groups](/mulesoft/resources/user-accounts/groups) for account fields.

An `admin` grant on the **Custom Workspace root** provides full Workspace Administrator authority over its files, users, groups, Partners, workflows, and integrations. An `admin` grant on a subfolder provides Folder Admin authority over that folder and its descendants; it does not provide Workspace administration. Other permission levels provide their corresponding folder access without Workspace administration. [Permissions](/mulesoft/resources/user-accounts/permissions) defines the levels.

Site Administrators manage cross-Workspace assignments to Default Workspace accounts. Workspace Administrators manage accounts and permissions within their own scope. Site Administrators retain access to every Workspace; adding a Workspace grant does not narrow Site Administrator authority. The [product documentation](https://www.files.com/docs/workspaces/workspace-administrators) explains the administrator's operational scope and site-wide controls.

### Request Context and API Keys

You can include the `X-Files-Workspace-Id` REST header to select a Workspace for a request. SDK request options and CLI configuration send that same selection. When a Workspace is selected, Workspace-scoped resources are listed, created, and changed within that context, and ordinary paths are relative to its root.

A resource's `workspace_id` request field describes the resource's Workspace membership. It is separate from the SDK's Workspace request option or REST header. Creating a Workspace-scoped resource in a Custom Workspace defaults its `workspace_id` to the selected Workspace; a mismatching membership value is rejected with `not-authorized/insufficient-permission-for-params`.

Selecting another Workspace with an API key requires a **Full Access key created in the Default Workspace**. A user key follows that user's current access, including group permissions. A site-wide Full Access key created in the Default Workspace has Site Administrator authority in every Workspace. A Files Only key stays in its creation Workspace, even if its user has cross-Workspace access. Any key created in a Custom Workspace stays within that Workspace. Selecting another context with these confined keys is rejected with `bad-request/invalid-workspace-id-header`.

An account belonging to a Custom Workspace is scoped there when it authenticates normally. For a Default Workspace user, explicitly select the intended Workspace for an integration rather than relying on an interactive login preference. [API Keys](/mulesoft/resources/developers/api-keys) and [Authentication](/mulesoft/overview/authentication) cover credentials.

The adjacent request uses the member's own Default Workspace Full Access user key to list the root of Workspace `123`, after access has been assigned.

```shell title="Request as the group member"
curl 'https://YOUR_SUBDOMAIN.files.com/api/rest/v1/folders/' \
  -H 'X-FilesAPI-Key: YOUR_MEMBER_API_KEY' \
  -H 'X-Files-Workspace-Id: 123'
```

### Delegating a Workspace to an Existing Group

An operations team already represented by a Default Workspace group can administer a Custom Workspace through one root Permission. The group and its members stay in the Default Workspace, so the same team can receive different access in other Workspaces.

First retrieve the target [Workspace](/mulesoft/resources/settings/workspaces) and [Group](/mulesoft/resources/user-accounts/groups) IDs as a Site Administrator in Workspace `0`. The examples use Workspace `123`, group `456`, and member user `789`; replace them with your own IDs. Confirm that the group belongs to Workspace `0` and that the intended user is a member.

Create the Permission using a Default Workspace Full Access site-wide key or a Full Access user key belonging to a Site Administrator. Keep the request context at `0` and use the qualified root path `_/Workspaces/123`. Set `group_id` to the group's ID, `permission` to `admin`, and `recursive` to `true`. Save the returned Permission `id` for later removal. For an individual Default Workspace user, use `user_id` instead of `group_id`.

For a Default Workspace group, a Site Administrator can also select Workspace `123` and use an empty `path` to grant access to its root. The qualified path in Workspace `0` works for both Default Workspace users and groups and keeps the account scope and target Workspace explicit. Appending a subfolder to the path would grant Folder Admin access instead of Workspace Administrator authority.

After the grant, run the request-context example above with the member's own credential and Workspace `123` selected. That member can work with the Workspace's files and perform Workspace Administrator operations, such as managing its users, Partners, and integrations. A Site Administrator's successful request does not establish that the member has the intended access.

```shell title="Find account and Workspace IDs"
curl 'https://YOUR_SUBDOMAIN.files.com/api/rest/v1/workspaces' \
  -H 'X-FilesAPI-Key: YOUR_SITE_ADMIN_API_KEY' \
  -H 'X-Files-Workspace-Id: 0'
curl 'https://YOUR_SUBDOMAIN.files.com/api/rest/v1/groups' \
  -H 'X-FilesAPI-Key: YOUR_SITE_ADMIN_API_KEY' \
  -H 'X-Files-Workspace-Id: 0'
```

```shell title="Grant group administration"
curl 'https://YOUR_SUBDOMAIN.files.com/api/rest/v1/permissions' \
  -X POST \
  -H 'X-FilesAPI-Key: YOUR_SITE_ADMIN_API_KEY' \
  -H 'X-Files-Workspace-Id: 0' \
  -H 'Content-Type: application/json' \
  -d '{"path":"_/Workspaces/123","group_id":456,"permission":"admin","recursive":true}'
```

### Permission Inspection and Removal

List the member's Permissions with `user_id` and `include_groups=true` to include grants inherited through group membership. Listing only direct user grants can miss the Permission that provides Workspace administration. In Workspace `0`, the Custom Workspace root appears as `_/Workspaces/123`; in Workspace `123`, paths are relative to that root. Inspect the root path and `permission=admin`, rather than treating the user's `workspace_admin` field as their effective administrative access.

Permission lists show individual grants, rather than a single flag for effective administrative access. Membership in several groups combines their access. A Permission using `group_ids` instead of `group_id` requires membership in all the specified groups; it is not a shorthand for assigning the same grant to several independent groups.

Removing a member ends access received through that group. Deleting the root Permission ends the group's Workspace Administrator grant for every member. These changes leave independent direct and other group grants in place, so review all applicable grants when withdrawing access. Default Workspace user API keys follow those permission changes without being recreated.

Group membership maintained through SCIM follows the same rule. A Group Admin allowed to add members can give those users the group's existing Workspace Administrator access. Choose who manages the group with that authority in mind.

Delete the Permission by its returned `id` as the Site Administrator in Workspace `0`. The removal examples use Permission ID `9001`; replace it with the ID returned by your create request. Permissions are created and deleted, rather than updated in place. If narrower folder access is still needed, assign it explicitly; deleting a broad grant does not restore narrower grants it previously replaced.

```shell title="Inspect member grants and remove the group grant"
curl 'https://YOUR_SUBDOMAIN.files.com/api/rest/v1/permissions?user_id=789&include_groups=true' \
  -H 'X-FilesAPI-Key: YOUR_SITE_ADMIN_API_KEY' \
  -H 'X-Files-Workspace-Id: 0'
curl 'https://YOUR_SUBDOMAIN.files.com/api/rest/v1/permissions/9001' \
  -X DELETE \
  -H 'X-FilesAPI-Key: YOUR_SITE_ADMIN_API_KEY' \
  -H 'X-Files-Workspace-Id: 0'
```

## Foreign Language Support

The Files.com MuleSoft Connector will soon be updated to support localized responses by using a configuration
method. When available, it can be used to guide the API in selecting a preferred language for applicable response content.

Language support currently applies to select human-facing fields only, such as notification messages
and error descriptions.

If the specified language is not supported or the value is omitted, the API defaults to English.

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
