package com.files.mule.internal.error.provider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

import com.files.mule.internal.error.FilesComErrorType;

public class FilesComErrorProvider implements ErrorTypeProvider {
  @Override
  @SuppressWarnings("rawtypes")
  public Set<ErrorTypeDefinition> getErrorTypes() {
    return new HashSet<>(Arrays.asList(FilesComErrorType.values()));
  }
}
