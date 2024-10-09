package com.files.mule.internal.values;

import java.util.Set;

import org.mule.runtime.api.value.Value;
import org.mule.runtime.extension.api.values.ValueBuilder;
import org.mule.runtime.extension.api.values.ValueProvider;

public class UserValueProviders {
  public static class AuthenticationMethod implements ValueProvider {

    @Override
    public Set<Value> resolve() {
      return ValueBuilder.getValuesFor("password", "email_signup");
    }
  }
}
