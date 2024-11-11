package com.files.mule.internal.operation.parameter;

import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class FolderParameterGroup {
  private FolderParameterGroup() {
  }

  public static class List {
    @Parameter
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

  public static class Create {
    @Parameter
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
