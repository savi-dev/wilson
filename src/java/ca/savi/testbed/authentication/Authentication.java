// Copyright (c) 2012, The SAVI Project.
package ca.savi.testbed.authentication;

import ca.savi.testbed.authentication.model.AuthenticateResourceUsageRequest;
import ca.savi.testbed.authentication.model.AuthenticateUserRequest;
import ca.savi.testbed.authentication.model.AuthenticationResult;

/**
 * Authentication class.
 *
 * @author Eliot Kang <eliot@savinetwork.ca>
 * @version 0.1
 */
public interface Authentication {

  /**
   * Authenticate resource usage
   *
   * @param authenticateResourceUsageRequest
   * @return
   */
  public AuthenticationResult authenticateResourceUsage(
      AuthenticateResourceUsageRequest authenticateResourceUsageRequest);

  /**
   * Authenticate user
   *
   * @param authenticateUserRequest
   * @return
   */
  public AuthenticationResult authenticateUser(
      AuthenticateUserRequest authenticateUserRequest);
}
