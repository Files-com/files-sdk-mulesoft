package com.files.mule.internal.error;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

public enum FilesComErrorType implements ErrorTypeDefinition<FilesComErrorType> {
  BAD_REQUEST("bad-request"),
  NOT_AUTHENTICATED("not-authenticated"),
  NOT_AUTHORIZED("not-authorized"),
  NOT_FOUND("not-found"),
  PROCESSING_FAILURE("processing-failure"),
  RATE_LIMITED("rate-limited"),
  SERVICE_UNAVAILABLE("service-unavailable"),
  SITE_CONFIGURATION("site-configuration"),
  OTHER,
  ARGUMENT,
  RESPONSE,
  CONNECTIVITY;

  public final String apiErrorGroup;

  FilesComErrorType(final String apiErrorGroup) {
    this.apiErrorGroup = apiErrorGroup;
  }

  FilesComErrorType() {
    this.apiErrorGroup = null;
  }
}
