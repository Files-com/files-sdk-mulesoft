package com.files.mule.api.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class AbstractModel implements Serializable {
  protected InputStream toInputStream(final byte[] bytes) {
    return bytes != null ? new ByteArrayInputStream(bytes) : null;
  }

  protected <T> List<T> toList(final T[] array) {
    return array != null ? Arrays.asList(array) : null;
  }

  protected ZonedDateTime toZonedDateTime(final Date date) {
    return date != null ? ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()) : null;
  }
}
