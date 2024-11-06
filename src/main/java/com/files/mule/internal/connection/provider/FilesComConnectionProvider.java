package com.files.mule.internal.connection.provider;

import java.util.HashMap;

import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

import com.files.exceptions.ApiErrorException;
import com.files.mule.internal.connection.FilesComConnection;

public class FilesComConnectionProvider implements CachedConnectionProvider<FilesComConnection> {

  @Parameter
  @DisplayName("API Key")
  @Summary("The API key used to authenticate with Files.com.")
  @Placement(tab = Placement.DEFAULT_TAB)
  private String apiKey;

  @Parameter
  @Optional
  @DisplayName("Base URL")
  @Summary("Required if your site is configured to disable global acceleration. This can also be set to use a mock server in development or CI.")
  @Placement(tab = Placement.ADVANCED_TAB)
  private String baseUrl;

  @Override
  public FilesComConnection connect() throws ConnectionException {
    return new FilesComConnection(apiKey, baseUrl);
  }

  @Override
  public void disconnect(final FilesComConnection connection) {
    // no-op
  }

  @Override
  public ConnectionValidationResult validate(final FilesComConnection connection) {
    final HashMap<String, Object> requestParameters = new HashMap<>();
    requestParameters.put("path", "");
    requestParameters.put("per_page", 1L);

    try {
      final String apiRoot = connection.getApiRoot();
      if (apiRoot == null || !apiRoot.equals("http://files-mock-server:4041")) {
        connection.listForFolder(requestParameters);
      }
      return ConnectionValidationResult.success();
    } catch (final Exception e) {
      String message = e.getMessage();
      if (e instanceof ApiErrorException) {
        message = ((ApiErrorException) e).getError();
      }

      return ConnectionValidationResult.failure("Connection failed: " + message, e);
    }
  }
}
