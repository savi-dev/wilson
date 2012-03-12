// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson;

import ca.savi.yorkdale.model.authentication.AuthenticateResourceUsageRequest;
import ca.savi.yorkdale.model.authentication.AuthenticateResourceUsageResponse;
import ca.savi.yorkdale.model.authentication.AuthenticationUserRequest;
import ca.savi.yorkdale.model.authentication.AuthenticationUserResponse;

/**
 * Authentication class.
 *
 * @author Eliot J. Kang <eliot@savinetwork.ca>
 * @version 0.1
 */
public interface Authentication {
  /**
   * Authenticate resource usage
   *
   * @param authenticateResourceUsageRequest
   * @return
   */
  public AuthenticateResourceUsageResponse authenticateResourceUsage(
      AuthenticateResourceUsageRequest authenticateResourceUsageRequest);

  /**
   * Authenticate user
   *
   * @param authenticateUserRequest
   * @return
   */
  public AuthenticationUserResponse authenticateUser(
      AuthenticationUserRequest authenticateUserRequest);
}
