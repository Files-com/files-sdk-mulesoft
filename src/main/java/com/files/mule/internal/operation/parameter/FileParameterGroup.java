/**
 * (c) 2003-2025 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.operation.parameter;

import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class FileParameterGroup {
  private FileParameterGroup() {
  }

  public static class Download {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Summary("Path to operate on.")
    @Example("path")
    public String path;

    public String getPath() {
      return path;
    }

    public void setPath(final String path) {
      this.path = path;
    }

  }

  public static class Upload {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Summary("Path to operate on.")
    @Example("path")
    public String path;

    public String getPath() {
      return path;
    }

    public void setPath(final String path) {
      this.path = path;
    }

  }

  public static class Delete {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Summary("Path to operate on.")
    @Example("path")
    public String path;

    public String getPath() {
      return path;
    }

    public void setPath(final String path) {
      this.path = path;
    }

  }

  public static class Show {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Summary("Path to operate on.")
    @Example("path")
    public String path;

    public String getPath() {
      return path;
    }

    public void setPath(final String path) {
      this.path = path;
    }

  }

  public static class Copy {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Summary("Path to operate on.")
    @Example("path")
    public String path;

    public String getPath() {
      return path;
    }

    public void setPath(final String path) {
      this.path = path;
    }

    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Summary("Copy destination path.")
    @Example("destination")
    public String destination;

    public String getDestination() {
      return destination;
    }

    public void setDestination(final String destination) {
      this.destination = destination;
    }

  }

  public static class Move {
    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Summary("Path to operate on.")
    @Example("path")
    public String path;

    public String getPath() {
      return path;
    }

    public void setPath(final String path) {
      this.path = path;
    }

    @Parameter
    @Placement(tab = Placement.DEFAULT_TAB)
    @Summary("Move destination path.")
    @Example("destination")
    public String destination;

    public String getDestination() {
      return destination;
    }

    public void setDestination(final String destination) {
      this.destination = destination;
    }

  }

}
