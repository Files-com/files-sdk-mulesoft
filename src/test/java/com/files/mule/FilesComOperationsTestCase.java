package com.files.mule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.mule.runtime.api.message.Error;

public class FilesComOperationsTestCase extends MuleArtifactFunctionalTestCase {

  @Override
  protected String getConfigFile() {
    return "test-mule-config.xml";
  }

  @Test
  public void testShareLinkOperations() throws Exception {
    final Optional<Error> error = flowRunner("ShareLinkFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testFileOperations() throws Exception {
    final Optional<Error> error = flowRunner("FileFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testFolderOperations() throws Exception {
    final Optional<Error> error = flowRunner("FolderFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testGroupOperations() throws Exception {
    final Optional<Error> error = flowRunner("GroupFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testUserOperations() throws Exception {
    final Optional<Error> error = flowRunner("UserFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testListShareLinkOperation() throws Exception {
    final Optional<Error> error = flowRunner("listShareLinksFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testShowShareLinkOperation() throws Exception {
    final Optional<Error> error = flowRunner("showShareLinkFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testCreateShareLinkOperation() throws Exception {
    final Optional<Error> error = flowRunner("createShareLinkFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testUpdateShareLinkOperation() throws Exception {
    final Optional<Error> error = flowRunner("updateShareLinkFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testDeleteShareLinkOperation() throws Exception {
    final Optional<Error> error = flowRunner("deleteShareLinkFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testListShareLinkDownloadOperation() throws Exception {
    final Optional<Error> error = flowRunner("listShareLinkDownloadsFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testListShareLinkNotificationOperation() throws Exception {
    final Optional<Error> error = flowRunner("listShareLinkNotificationsFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testShowShareLinkNotificationOperation() throws Exception {
    final Optional<Error> error = flowRunner("showShareLinkNotificationFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testCreateShareLinkNotificationOperation() throws Exception {
    final Optional<Error> error = flowRunner("createShareLinkNotificationFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testUpdateShareLinkNotificationOperation() throws Exception {
    final Optional<Error> error = flowRunner("updateShareLinkNotificationFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testDeleteShareLinkNotificationOperation() throws Exception {
    final Optional<Error> error = flowRunner("deleteShareLinkNotificationFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testListShareLinkRecipientOperation() throws Exception {
    final Optional<Error> error = flowRunner("listShareLinkRecipientsFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testCreateShareLinkRecipientOperation() throws Exception {
    final Optional<Error> error = flowRunner("createShareLinkRecipientFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testListShareLinkRegistrationOperation() throws Exception {
    final Optional<Error> error = flowRunner("listShareLinkRegistrationsFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testDownloadFileOperation() throws Exception {
    final Optional<Error> error = flowRunner("downloadFileFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  @Ignore // Not currently working with files-mock-server
  public void testUploadFileOperation() throws Exception {
    final Optional<Error> error = flowRunner("uploadFileFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testDeleteFileOperation() throws Exception {
    final Optional<Error> error = flowRunner("deleteFileFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testShowFileOperation() throws Exception {
    final Optional<Error> error = flowRunner("showFileFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testCopyFileOperation() throws Exception {
    final Optional<Error> error = flowRunner("copyFileFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testMoveFileOperation() throws Exception {
    final Optional<Error> error = flowRunner("moveFileFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testListFolderOperation() throws Exception {
    final Optional<Error> error = flowRunner("listFoldersFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testCreateFolderOperation() throws Exception {
    final Optional<Error> error = flowRunner("createFolderFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testDeleteFolderOperation() throws Exception {
    final Optional<Error> error = flowRunner("deleteFolderFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testShowFolderOperation() throws Exception {
    final Optional<Error> error = flowRunner("showFolderFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testCopyFolderOperation() throws Exception {
    final Optional<Error> error = flowRunner("copyFolderFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testMoveFolderOperation() throws Exception {
    final Optional<Error> error = flowRunner("moveFolderFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testListGroupOperation() throws Exception {
    final Optional<Error> error = flowRunner("listGroupsFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testShowGroupOperation() throws Exception {
    final Optional<Error> error = flowRunner("showGroupFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testCreateGroupOperation() throws Exception {
    final Optional<Error> error = flowRunner("createGroupFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testUpdateGroupOperation() throws Exception {
    final Optional<Error> error = flowRunner("updateGroupFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testDeleteGroupOperation() throws Exception {
    final Optional<Error> error = flowRunner("deleteGroupFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testListUserOperation() throws Exception {
    final Optional<Error> error = flowRunner("listUsersFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testShowUserOperation() throws Exception {
    final Optional<Error> error = flowRunner("showUserFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testCreateUserOperation() throws Exception {
    final Optional<Error> error = flowRunner("createUserFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testUpdateUserOperation() throws Exception {
    final Optional<Error> error = flowRunner("updateUserFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

  @Test
  public void testDeleteUserOperation() throws Exception {
    final Optional<Error> error = flowRunner("deleteUserFlow").run().getError();
    assertThat(error.isPresent(), is(false));
  }

}
