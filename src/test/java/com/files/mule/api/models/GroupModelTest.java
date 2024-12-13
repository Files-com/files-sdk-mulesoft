package com.files.mule.api.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.files.models.Group;

public class GroupModelTest {
  @Test
  public void testGroupModel() {
    final GroupModel model = new GroupModel(new Group());
    model.setId(1L);
    assertThat(model.getId(), equalTo(1L));
    model.setName("owners");
    assertThat(model.getName(), equalTo("owners"));
    model.setAllowedIps("10.0.0.0/8\n127.0.0.1");
    assertThat(model.getAllowedIps(), equalTo("10.0.0.0/8\n127.0.0.1"));
    model.setAdminIds("1");
    assertThat(model.getAdminIds(), equalTo("1"));
    model.setNotes("example");
    assertThat(model.getNotes(), equalTo("example"));
    model.setUserIds("1");
    assertThat(model.getUserIds(), equalTo("1"));
    model.setUsernames("example");
    assertThat(model.getUsernames(), equalTo("example"));
    model.setFtpPermission(true);
    assertThat(model.getFtpPermission(), equalTo(true));
    model.setSftpPermission(true);
    assertThat(model.getSftpPermission(), equalTo(true));
    model.setDavPermission(true);
    assertThat(model.getDavPermission(), equalTo(true));
    model.setRestapiPermission(true);
    assertThat(model.getRestapiPermission(), equalTo(true));
    model.setSiteId(1L);
    assertThat(model.getSiteId(), equalTo(1L));
  }
}
