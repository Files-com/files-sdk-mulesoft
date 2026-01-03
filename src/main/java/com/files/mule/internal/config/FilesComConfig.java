/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilesComConfig {
  private static final Logger LOGGER = LoggerFactory.getLogger(FilesComConfig.class);

  private final Properties properties = new Properties();

  public FilesComConfig() {
    try (final InputStream file = FilesComConfig.class.getResourceAsStream("/filescom-connector.properties")) {
      properties.load(file);
    } catch (IOException e) {
      LOGGER.warn("could not load configurator properties");
    }
  }

  public String getConnectorVersion() {
    return properties.getProperty("connectorVersion", "0.0.1");
  }

  public String getUserAgent() {
    final String defaultUserAgent = String.format("Files.com MuleSoft Integration v%s", this.getConnectorVersion());
    return properties.getProperty("userAgent", defaultUserAgent);
  }

  public void setProperty(final String property, final String value) {
    properties.setProperty(property, value);
  }
}
