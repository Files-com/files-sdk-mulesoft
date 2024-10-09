package com.files.mule.internal.exceptions;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.mule.internal.errors.FilesComError;

public class FilesComServerException extends ModuleException {
  public FilesComServerException(final Throwable cause) {
    super(FilesComError.SERVICE_UNAVAILABLE, cause);
  }
}
