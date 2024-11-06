package com.files.mule.api.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

  private String status;

  public String getStatus() {
    return status;
  }

  private Long fileMigrationId;

  public Long getFileMigrationId() {
    return fileMigrationId;
  }

}
