/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.operation.parameter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ShareLinkDownloadParameterGroupTest {
  @Test
  public void testList() {
    final ShareLinkDownloadParameterGroup.List group = new ShareLinkDownloadParameterGroup.List();
    group.setBundleId(1L);
    assertThat(group.getBundleId(), equalTo(1L));
  }

}
