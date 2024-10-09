package com.files.mule.internal.exceptions;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.mule.internal.errors.FilesComError;

public class FilesComResponseException extends ModuleException {
  public FilesComResponseException(final Throwable cause) {
    super(FilesComError.RESPONSE, cause);
  }
}
