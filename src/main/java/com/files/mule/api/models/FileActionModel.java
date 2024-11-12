package com.files.mule.api.models;

import com.files.models.FileAction;

/**
 * A FileAction is an operation status for copy/move file. Copy and Move operations have File Migration associated with them.
 */
public class FileActionModel extends AbstractModel {
  public FileActionModel() {
  }

  public FileActionModel(final FileAction fileAction) {
    this.status = fileAction.status;
    this.fileMigrationId = fileAction.fileMigrationId;
  }

  private String status;

  public String getStatus() {
    return status;
  }

  private Long fileMigrationId;

  public Long getFileMigrationId() {
    return fileMigrationId;
  }

}
