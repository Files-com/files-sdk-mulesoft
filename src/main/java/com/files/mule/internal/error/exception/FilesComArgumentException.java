package com.files.mule.internal.error.exception;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.mule.internal.error.FilesComErrorType;

public class FilesComArgumentException extends ModuleException {
  public FilesComArgumentException(final Throwable cause) {
    super(FilesComErrorType.ARGUMENT, cause);
  }
}
