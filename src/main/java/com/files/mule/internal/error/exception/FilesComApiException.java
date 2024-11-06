package com.files.mule.internal.error.exception;

import java.util.Arrays;

import org.mule.runtime.extension.api.exception.ModuleException;

import com.files.exceptions.ApiErrorException;
import com.files.mule.internal.error.FilesComErrorType;

public class FilesComApiException extends ModuleException {
  public FilesComApiException(final ApiErrorException cause) {
    super(cause.getError(),
        Arrays.stream(FilesComErrorType.values())
            .filter(error -> error.apiErrorGroup != null)
            .filter(error -> cause.getType().startsWith(error.apiErrorGroup))
            .findFirst()
            .orElse(FilesComErrorType.OTHER),
        cause);
  }
}
