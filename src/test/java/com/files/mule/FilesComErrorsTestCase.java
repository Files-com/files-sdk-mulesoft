package com.files.mule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.files.ResponseError;
import com.files.exceptions.ApiErrorException;
import com.files.mule.internal.FilesComConnection;
import com.files.mule.internal.FilesComOperations;
import com.files.mule.internal.exceptions.FilesComApiException;

@RunWith(MockitoJUnitRunner.class)
public class FilesComErrorsTestCase {

  @Mock
  private FilesComConnection connection;

  private final FilesComOperations operations = new FilesComOperations();

  @Test
  public void testApiException() throws Exception {
    final ResponseError error = new ResponseError();
    error.type = "not-found/user-not-found";

    final ApiErrorException exception = ApiErrorException.forType("User not found", error, null);
    when(connection.findUser(any())).thenThrow(exception);

    try {
      operations.showUser(connection, 1L);
    } catch (final FilesComApiException e) {
      assertThat(e.getType().getType(), is("NOT_FOUND"));
    }
  }

  @Test
  public void testUnknownApiException() throws Exception {
    final ResponseError error = new ResponseError();
    error.type = "unexpected/error";

    final ApiErrorException exception = ApiErrorException.forType("User not found", error, null);
    when(connection.findUser(any())).thenThrow(exception);

    try {
      operations.showUser(connection, 1L);
    } catch (final FilesComApiException e) {
      assertThat(e.getType().getType(), is("UNKNOWN"));
    }
  }
}
