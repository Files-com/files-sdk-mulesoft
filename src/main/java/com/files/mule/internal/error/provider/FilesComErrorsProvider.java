package com.files.mule.internal.error.provider;

import java.util.HashSet;
import java.util.Set;

import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

import com.files.mule.internal.error.FilesComErrorType;

public class FilesComErrorsProvider implements ErrorTypeProvider {
  @Override
  public Set<ErrorTypeDefinition> getErrorTypes() {
    HashSet<ErrorTypeDefinition<?>> errors = new HashSet<>();
    errors.add(FilesComErrorType.BAD_REQUEST);
    errors.add(FilesComErrorType.NOT_AUTHENTICATED);
    errors.add(FilesComErrorType.NOT_AUTHORIZED);
    errors.add(FilesComErrorType.NOT_FOUND);
    errors.add(FilesComErrorType.PROCESSING_FAILURE);
    errors.add(FilesComErrorType.RATE_LIMITED);
    errors.add(FilesComErrorType.SERVICE_UNAVAILABLE);
    errors.add(FilesComErrorType.SITE_CONFIGURATION);
    errors.add(FilesComErrorType.OTHER);
    errors.add(FilesComErrorType.ARGUMENT);
    errors.add(FilesComErrorType.RESPONSE);
    errors.add(FilesComErrorType.CONNECTIVITY);
    return new HashSet<>(errors);
  }
}
