// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.AllTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import ca.savi.wilson.impl.LocalIDM;
import ca.savi.wilson.model.AuthUserReq;
import ca.savi.wilson.model.AuthCredentialResult;
import ca.savi.wilson.model.Credential;

/**
 * Test user authentication.
 *
 * @author Soheil Hassas Yeganeh <soheil@cs.toronto.edu>
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
public class AuthenticateUserTest {

  private static final String TEST_USER = "summer10";
  private static final String TEST_PASSWD = "summer10";
  static LocalIDM auth;
  /**
   * Creates an authentication instance.
   */
  @BeforeClass
  public static void setup() {
    auth = new LocalIDM();
  }

  @Test
  public void testAuthenticateUserValidUser() {
    AuthUserReq request = new AuthUserReq();
    Credential cred = new Credential();
    cred.setUsername(TEST_USER);
    cred.setPassword(TEST_PASSWD);
    request.setUserCredentials(cred);
    AuthCredentialResult result = auth.authenticateUser(request);
    assertNotNull(result);
    assertTrue(result.isSuccessful());
  }

  @Test
  public void testAuthenticateUserInvalidUser() {
    AuthUserReq request = new AuthUserReq();
    Credential cred = new Credential();
    cred.setUsername(TEST_USER + "s");
    cred.setPassword(TEST_PASSWD);
    request.setUserCredentials(cred);
    AuthCredentialResult result = auth.authenticateUser(request);
    assertNotNull(result);
    assertFalse(result.isSuccessful());
  }

  @Test
  public void testAuthenticateUserInvalidPassword() {
    AuthUserReq request = new AuthUserReq();
    Credential cred = new Credential();
    cred.setUsername(TEST_USER);
    cred.setPassword(TEST_PASSWD + "s");
    request.setUserCredentials(cred);
    AuthCredentialResult result = auth.authenticateUser(request);
    assertNotNull(result);
    assertFalse(result.isSuccessful());
  }

}
