package com.files.mule.internal.operation.parameter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ShareLinkNotificationParameterGroupTest {
  @Test
  public void testShow() {
    final ShareLinkNotificationParameterGroup.Show group = new ShareLinkNotificationParameterGroup.Show();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
  }

  @Test
  public void testCreate() {
    final ShareLinkNotificationParameterGroup.Create group = new ShareLinkNotificationParameterGroup.Create();
    group.setBundleId(1L);
    assertThat(group.getBundleId(), equalTo(1L));
    group.setUserId(1L);
    assertThat(group.getUserId(), equalTo(1L));
  }

  @Test
  public void testUpdate() {
    final ShareLinkNotificationParameterGroup.Update group = new ShareLinkNotificationParameterGroup.Update();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
    group.setNotifyOnRegistration(true);
    assertThat(group.getNotifyOnRegistration(), equalTo(true));
    group.setNotifyOnUpload(true);
    assertThat(group.getNotifyOnUpload(), equalTo(true));
  }

  @Test
  public void testDelete() {
    final ShareLinkNotificationParameterGroup.Delete group = new ShareLinkNotificationParameterGroup.Delete();
    group.setId(1L);
    assertThat(group.getId(), equalTo(1L));
  }

}
