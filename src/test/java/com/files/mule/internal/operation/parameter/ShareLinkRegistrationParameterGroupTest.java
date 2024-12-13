package com.files.mule.internal.operation.parameter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ShareLinkRegistrationParameterGroupTest {
  @Test
  public void testList() {
    final ShareLinkRegistrationParameterGroup.List group = new ShareLinkRegistrationParameterGroup.List();
    group.setBundleId(1L);
    assertThat(group.getBundleId(), equalTo(1L));
  }

}
