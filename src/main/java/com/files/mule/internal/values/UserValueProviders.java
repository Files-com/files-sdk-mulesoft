/**
 * (c) 2003-2026 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package com.files.mule.internal.values;

import java.util.Set;

import org.mule.runtime.api.value.Value;
import org.mule.runtime.extension.api.values.ValueBuilder;
import org.mule.runtime.extension.api.values.ValueProvider;

public class UserValueProviders {
  private UserValueProviders() {
  }

  public static class AuthenticationMethod implements ValueProvider {

    @Override
    public Set<Value> resolve() {
      return ValueBuilder.getValuesFor("password", "email_signup");
    }
  }
}
