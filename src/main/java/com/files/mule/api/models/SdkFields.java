/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.api.models;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Reads the public fields of the Files.com Java SDK's models by name. The connector's models follow the current
 * API schema, which can have properties the SDK release the connector is built with does not have yet. Such a
 * property reads as no value; once a later SDK release has the field, its value is read like any other.
 */
final class SdkFields {
  private static final ClassValue<Map<String, Field>> PUBLIC_FIELDS = new ClassValue<Map<String, Field>>() {
    @Override
    protected Map<String, Field> computeValue(final Class<?> type) {
      final Map<String, Field> fields = new HashMap<>();
      for (final Field field : type.getFields()) {
        if (!Modifier.isStatic(field.getModifiers())) {
          fields.put(field.getName(), field);
        }
      }
      return fields;
    }
  };

  private SdkFields() {
  }

  /**
   * The value of the public field name of source, or null when source's class has no such field. A value that is
   * not a type raises a ClassCastException.
   */
  static <T> T read(final Object source, final String name, final Class<T> type) {
    final Field field = PUBLIC_FIELDS.get(source.getClass()).get(name);
    if (field == null) {
      return null;
    }
    try {
      return type.cast(field.get(source));
    } catch (final IllegalAccessException e) {
      throw new IllegalStateException("The field " + name + " of " + source.getClass().getName() + " cannot be read",
          e);
    }
  }

  /** The value of the public field name of source passed through convert, or null when it has no value. */
  static <T, R> R read(final Object source, final String name, final Class<T> type,
      final Function<? super T, ? extends R> convert) {
    final T value = read(source, name, type);
    return value != null ? convert.apply(value) : null;
  }
}
