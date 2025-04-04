/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.files.models.BundleDownload;

public class ShareLinkDownloadModelTest {
  @Test
  public void testShareLinkDownloadModel() {
    final ShareLinkDownloadModel model = new ShareLinkDownloadModel(new BundleDownload());
    model.setBundleRegistration(null);
    assertThat(model.getBundleRegistration(), equalTo(null));
    model.setDownloadMethod("file");
    assertThat(model.getDownloadMethod(), equalTo("file"));
    model.setPath("a/b/test.txt");
    assertThat(model.getPath(), equalTo("a/b/test.txt"));
    model.setCreatedAt(ZonedDateTime.parse("2000-01-01T01:00:00Z"));
    assertThat(model.getCreatedAt(), equalTo(ZonedDateTime.parse("2000-01-01T01:00:00Z")));
  }
}
