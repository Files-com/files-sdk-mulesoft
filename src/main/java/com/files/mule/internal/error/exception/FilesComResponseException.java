package com.files.mule.internal.error.exception;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.mule.internal.error.FilesComErrorType;

public class FilesComResponseException extends ModuleException {
  public FilesComResponseException(final Throwable cause) {
    super(FilesComErrorType.RESPONSE, cause);
  }
}
