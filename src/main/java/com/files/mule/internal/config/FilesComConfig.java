package com.files.mule.internal.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilesComConfig {
  private static final Logger LOGGER = LoggerFactory.getLogger(FilesComConfig.class);
  private static volatile FilesComConfig instance;

  private final Properties properties;

  protected FilesComConfig() {
    properties = new Properties();
    try (final InputStream file = FilesComConfig.class.getResourceAsStream("/filescom-connector.properties")) {
      properties.load(file);
    } catch (IOException e) {
      LOGGER.warn("could not load configurator properties");
    }
  }

  public static FilesComConfig getInstance() {
    if (instance == null) {
      synchronized (FilesComConfig.class) {
        if (instance == null) {
          instance = new FilesComConfig();
        }
      }
    }
    return instance;
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
