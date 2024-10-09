package com.files.mule.internal.errors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

public class FilesComErrorProvider implements ErrorTypeProvider {
  @Override
  @SuppressWarnings("rawtypes")
  public Set<ErrorTypeDefinition> getErrorTypes() {
    return new HashSet<>(Arrays.asList(FilesComError.values()));
  }
}
