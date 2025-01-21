/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.files.models.BundleNotification;

public class ShareLinkNotificationModelTest {
  @Test
  public void testShareLinkNotificationModel() {
    final ShareLinkNotificationModel model = new ShareLinkNotificationModel(new BundleNotification());
    model.setBundleId(1L);
    assertThat(model.getBundleId(), equalTo(1L));
    model.setId(1L);
    assertThat(model.getId(), equalTo(1L));
    model.setNotifyOnRegistration(true);
    assertThat(model.getNotifyOnRegistration(), equalTo(true));
    model.setNotifyOnUpload(true);
    assertThat(model.getNotifyOnUpload(), equalTo(true));
    model.setUserId(1L);
    assertThat(model.getUserId(), equalTo(1L));
  }
}
