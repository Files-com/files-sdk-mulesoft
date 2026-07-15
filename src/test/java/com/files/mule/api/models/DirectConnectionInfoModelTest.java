/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.junit.Test;

import com.files.models.DirectConnectionInfo;

public class DirectConnectionInfoModelTest {
  @Test
  public void testDirectConnectionInfoModel() {
    final DirectConnectionInfoModel model = new DirectConnectionInfoModel(new DirectConnectionInfo());
    model.setVersion(1L);
    assertThat(model.getVersion(), equalTo(1L));
    model.setServerName("example");
    assertThat(model.getServerName(), equalTo("example"));
    model.setAddresses(Arrays.asList("example"));
    assertThat(model.getAddresses(), equalTo(Arrays.asList("example")));
    model.setDirectUri("example");
    assertThat(model.getDirectUri(), equalTo("example"));
    model.setCaPem("example");
    assertThat(model.getCaPem(), equalTo("example"));
  }
}
