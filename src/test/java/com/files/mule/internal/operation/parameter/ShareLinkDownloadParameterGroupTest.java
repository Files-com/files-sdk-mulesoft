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
