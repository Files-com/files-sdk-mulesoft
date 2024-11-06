package com.files.mule.internal.error.exception;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.mule.internal.error.FilesComErrorType;

public class FilesComAuthenticationException extends ModuleException {
  public FilesComAuthenticationException(final Throwable cause) {
    super(FilesComErrorType.NOT_AUTHENTICATED, cause);
  }
}
