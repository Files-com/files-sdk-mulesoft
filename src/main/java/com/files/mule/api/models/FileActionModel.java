package com.files.mule.api.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Parameter;

import com.files.models.FileAction;

/**
 * A FileAction is an operation status for copy/move file. Copy and Move operations have File Migration associated with them.
 */
public class FileActionModel implements Serializable {
  public FileActionModel() {
  }

  public FileActionModel(final FileAction fileAction) {
    this.status = fileAction.status;
    this.fileMigrationId = fileAction.fileMigrationId;
  }

  /**
   * Status of file operation.
   */
  @Parameter
  public String status;

  public String getStatus() {
    return status;
  }

  /**
   * If status is pending, this is the id of the File Migration to check for status updates.
   */
  @Parameter
  public Long fileMigrationId;

  public Long getFileMigrationId() {
    return fileMigrationId;
  }

}
