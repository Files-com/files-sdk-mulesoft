package com.files.mule.internal.exceptions;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.mule.internal.errors.FilesComError;

public class FilesComArgumentException extends ModuleException {
  public FilesComArgumentException(final Throwable cause) {
    super(FilesComError.ARGUMENT, cause);
  }
}
