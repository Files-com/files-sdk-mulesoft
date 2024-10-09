package com.files.mule.internal.errors;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

public enum FilesComError implements ErrorTypeDefinition<FilesComError> {
  BAD_REQUEST("bad-request"),
  NOT_AUTHENTICATED("not-authenticated"),
  NOT_AUTHORIZED("not-authorized"),
  NOT_FOUND("not-found"),
  PROCESSING_FAILURE("processing-failure"),
  RATE_LIMITED("rate-limited"),
  SERVICE_UNAVAILABLE("service-unavailable"),
  SITE_CONFIGURATION("site-configuration"),
  UNKNOWN,
  ARGUMENT,
  RESPONSE,
  CONNECTIVITY;

  public final String apiErrorGroup;

  FilesComError(final String apiErrorGroup) {
    this.apiErrorGroup = apiErrorGroup;
  }

  FilesComError() {
    this.apiErrorGroup = null;
  }
}
