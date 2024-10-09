package com.files.mule.internal.exceptions;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.mule.internal.errors.FilesComError;

public class FilesComAuthenticationException extends ModuleException {
  public FilesComAuthenticationException(final Throwable cause) {
    super(FilesComError.NOT_AUTHENTICATED, cause);
  }
}
