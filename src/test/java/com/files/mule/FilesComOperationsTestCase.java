package com.files.mule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Optional;

import org.junit.Test;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.mule.runtime.api.message.Error;

public class FilesComOperationsTestCase extends MuleArtifactFunctionalTestCase {

  @Override
  protected String getConfigFile() {
    return "test-mule-config.xml";
  }

  @Test
  public void testFlows() throws Exception {
    final String[] flowNames = new String[]{"ShareLinkFlow", "FileFlow", "FolderFlow", "GroupFlow", "UserFlow", "listShareLinksFlow", "showShareLinkFlow", "createShareLinkFlow", "updateShareLinkFlow", "deleteShareLinkFlow", "listShareLinkDownloadsFlow", "listShareLinkNotificationsFlow", "showShareLinkNotificationFlow", "createShareLinkNotificationFlow", "updateShareLinkNotificationFlow", "deleteShareLinkNotificationFlow", "listShareLinkRecipientsFlow", "createShareLinkRecipientFlow", "listShareLinkRegistrationsFlow", "downloadFileFlow", "deleteFileFlow", "showFileFlow", "copyFileFlow", "moveFileFlow", "listFoldersFlow", "createFolderFlow", "deleteFolderFlow", "showFolderFlow", "copyFolderFlow", "moveFolderFlow", "listGroupsFlow", "showGroupFlow", "createGroupFlow", "updateGroupFlow", "deleteGroupFlow", "listUsersFlow", "showUserFlow", "createUserFlow", "updateUserFlow", "deleteUserFlow"};
    for (final String flowName : flowNames) {
      try {
        final Optional<Error> error = flowRunner(flowName).run().getError();
        assertThat(error.isPresent(), is(false));
      } catch (final Exception e) {
        throw new Exception("Test failed for flow: " + flowName, e);
      }
    }
  }
}
