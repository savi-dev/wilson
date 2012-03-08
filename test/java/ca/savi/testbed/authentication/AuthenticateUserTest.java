// Copyright (c) 2012, The SAVI Project.
package ca.savi.testbed.authentication;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.savi.testbed.authentication.model.AuthenticateUserRequest;
import ca.savi.testbed.authentication.model.AuthenticationResult;
import ca.savi.testbed.authentication.model.Credential;
import ca.savi.testbed.datastore.model.User;

/**
 * Test user authentication.
 *
 * @author Soheil Hassas Yeganeh <soheil@cs.toronto.edu>
 * @version 0.1
 */
public class AuthenticateUserTest {

  private static final String TEST_USER = "summer10";
  private static final String TEST_PASSWD = "summer10";
  static AuthenticationImpl auth;
  /**
   * Creates an authentication instance.
   */
  @BeforeClass
  public static void setup() {
    auth = new AuthenticationImpl();
  }

  @Test
  public void testAuthenticateUserValidUser() {
    AuthenticateUserRequest request = new AuthenticateUserRequest();
    Credential cred = new Credential();
    cred.setUsername(TEST_USER);
    cred.setPassword(TEST_PASSWD);
    request.setUserCredentials(cred);
    AuthenticationResult result = auth.authenticateUser(request);
    assertNotNull(result);
    assertTrue(result.isSuccessful());
  }

  @Test
  public void testAuthenticateUserInvalidUser() {
    AuthenticateUserRequest request = new AuthenticateUserRequest();
    Credential cred = new Credential();
    cred.setUsername(TEST_USER + "s");
    cred.setPassword(TEST_PASSWD);
    request.setUserCredentials(cred);
    AuthenticationResult result = auth.authenticateUser(request);
    assertNotNull(result);
    assertFalse(result.isSuccessful());
  }

  @Test
  public void testAuthenticateUserInvalidPassword() {
    AuthenticateUserRequest request = new AuthenticateUserRequest();
    Credential cred = new Credential();
    cred.setUsername(TEST_USER);
    cred.setPassword(TEST_PASSWD + "s");
    request.setUserCredentials(cred);
    AuthenticationResult result = auth.authenticateUser(request);
    assertNotNull(result);
    assertFalse(result.isSuccessful());
  }

  @AfterClass
  public static void tearDown() {
    auth.datastore.getDataStore().shutdown();
  }
}
