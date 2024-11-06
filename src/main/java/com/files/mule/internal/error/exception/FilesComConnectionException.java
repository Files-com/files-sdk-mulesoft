package com.files.mule.internal.error.exception;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.mule.internal.error.FilesComErrorType;

public class FilesComConnectionException extends ModuleException {
  public FilesComConnectionException(final Throwable cause) {
    super(FilesComErrorType.CONNECTIVITY, cause);
  }
}
