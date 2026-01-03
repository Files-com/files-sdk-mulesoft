/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.files.models.File;

public class FileModelTest {
  @Test
  public void testFileModel() {
    final FileModel model = new FileModel(new File());
    model.setPath("path/file.txt");
    assertThat(model.getPath(), equalTo("path/file.txt"));
    model.setCreatedById(1L);
    assertThat(model.getCreatedById(), equalTo(1L));
    model.setCreatedByApiKeyId(1L);
    assertThat(model.getCreatedByApiKeyId(), equalTo(1L));
    model.setCreatedByAs2IncomingMessageId(1L);
    assertThat(model.getCreatedByAs2IncomingMessageId(), equalTo(1L));
    model.setCreatedByAutomationId(1L);
    assertThat(model.getCreatedByAutomationId(), equalTo(1L));
    model.setCreatedByBundleRegistrationId(1L);
    assertThat(model.getCreatedByBundleRegistrationId(), equalTo(1L));
    model.setCreatedByInboxId(1L);
    assertThat(model.getCreatedByInboxId(), equalTo(1L));
    model.setCreatedByRemoteServerId(1L);
    assertThat(model.getCreatedByRemoteServerId(), equalTo(1L));
    model.setCreatedBySyncId(1L);
    assertThat(model.getCreatedBySyncId(), equalTo(1L));
    model.setCustomMetadata(null);
    assertThat(model.getCustomMetadata(), equalTo(null));
    model.setDisplayName("file.txt");
    assertThat(model.getDisplayName(), equalTo("file.txt"));
    model.setFileType("file");
    assertThat(model.getFileType(), equalTo("file"));
    model.setSize(1024L);
    assertThat(model.getSize(), equalTo(1024L));
    model.setCreatedAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getCreatedAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setLastModifiedById(1L);
    assertThat(model.getLastModifiedById(), equalTo(1L));
    model.setLastModifiedByApiKeyId(1L);
    assertThat(model.getLastModifiedByApiKeyId(), equalTo(1L));
    model.setLastModifiedByAutomationId(1L);
    assertThat(model.getLastModifiedByAutomationId(), equalTo(1L));
    model.setLastModifiedByBundleRegistrationId(1L);
    assertThat(model.getLastModifiedByBundleRegistrationId(), equalTo(1L));
    model.setLastModifiedByRemoteServerId(1L);
    assertThat(model.getLastModifiedByRemoteServerId(), equalTo(1L));
    model.setLastModifiedBySyncId(1L);
    assertThat(model.getLastModifiedBySyncId(), equalTo(1L));
    model.setMtime(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getMtime(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setProvidedMtime(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getProvidedMtime(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
    model.setCrc32("70976923");
    assertThat(model.getCrc32(), equalTo("70976923"));
    model.setMd5("17c54824e9931a4688ca032d03f6663c");
    assertThat(model.getMd5(), equalTo("17c54824e9931a4688ca032d03f6663c"));
    model.setSha1("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3");
    assertThat(model.getSha1(), equalTo("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3"));
    model.setSha256("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08");
    assertThat(model.getSha256(), equalTo("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08"));
    model.setMimeType("application/octet-stream");
    assertThat(model.getMimeType(), equalTo("application/octet-stream"));
    model.setRegion("us-east-1");
    assertThat(model.getRegion(), equalTo("us-east-1"));
    model.setPermissions("rwd");
    assertThat(model.getPermissions(), equalTo("rwd"));
    model.setSubfoldersLocked(true);
    assertThat(model.getSubfoldersLocked(), equalTo(true));
    model.setIsLocked(true);
    assertThat(model.getIsLocked(), equalTo(true));
    model.setDownloadUri("https://mysite.files.com/...");
    assertThat(model.getDownloadUri(), equalTo("https://mysite.files.com/..."));
    model.setPriorityColor("red");
    assertThat(model.getPriorityColor(), equalTo("red"));
    model.setPreviewId(1L);
    assertThat(model.getPreviewId(), equalTo(1L));
    model.setPreview(null);
    assertThat(model.getPreview(), equalTo(null));
    model.setAction("");
    assertThat(model.getAction(), equalTo(""));
    model.setLength(1L);
    assertThat(model.getLength(), equalTo(1L));
    model.setMkdirParents(false);
    assertThat(model.getMkdirParents(), equalTo(false));
    model.setPart(1L);
    assertThat(model.getPart(), equalTo(1L));
    model.setParts(1L);
    assertThat(model.getParts(), equalTo(1L));
    model.setRef("");
    assertThat(model.getRef(), equalTo(""));
    model.setRestart(1L);
    assertThat(model.getRestart(), equalTo(1L));
    model.setStructure("");
    assertThat(model.getStructure(), equalTo(""));
    model.setWithRename(false);
    assertThat(model.getWithRename(), equalTo(false));
    model.setBufferedUpload(false);
    assertThat(model.getBufferedUpload(), equalTo(false));
  }
}
