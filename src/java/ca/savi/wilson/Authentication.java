// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson;

import ca.savi.wilson.model.AuthenticateResourceUsageRequest;
import ca.savi.wilson.model.AuthenticateUserRequest;
import ca.savi.wilson.model.AuthenticationResult;

/**
 * Authentication class.
 * 
 * @author Eliot J. Kang <eliot@savinetwork.ca>
 * @author Mohammad Sadegh Faraji <ms.faraji>
 * @version 0.2
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
  public AuthenticationResult authenticateUser(AuthenticateUserRequest request);
}