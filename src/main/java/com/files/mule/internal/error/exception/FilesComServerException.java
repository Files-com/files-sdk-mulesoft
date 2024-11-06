package com.files.mule.internal.error.exception;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.mule.internal.error.FilesComErrorType;

public class FilesComServerException extends ModuleException {
  public FilesComServerException(final Throwable cause) {
    super(FilesComErrorType.SERVICE_UNAVAILABLE, cause);
  }
}
