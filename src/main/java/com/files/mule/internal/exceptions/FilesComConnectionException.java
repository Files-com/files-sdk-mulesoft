package com.files.mule.internal.exceptions;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.mule.internal.errors.FilesComError;

public class FilesComConnectionException extends ModuleException {
  public FilesComConnectionException(final Throwable cause) {
    super(FilesComError.CONNECTIVITY, cause);
  }
}
