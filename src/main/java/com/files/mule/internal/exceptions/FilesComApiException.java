package com.files.mule.internal.exceptions;

import java.util.Arrays;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.exceptions.ApiErrorException;
import com.files.mule.internal.errors.FilesComError;

public class FilesComApiException extends ModuleException {
  public FilesComApiException(final ApiErrorException cause) {
    super(cause.getError(), getErrorGroup(cause), cause);
  }

  private static FilesComError getErrorGroup(final ApiErrorException cause) {
    final String errorType = cause.getType();
    return Arrays.stream(FilesComError.values())
        .filter(error -> error.apiErrorGroup != null)
        .filter(error -> errorType.startsWith(error.apiErrorGroup))
        .findFirst()
        .orElse(FilesComError.UNKNOWN);
  }
}
