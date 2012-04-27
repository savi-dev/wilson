// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson;

import ca.savi.wilson.model.AuthNResult;
import ca.savi.wilson.model.AuthResourceUsageReq;
import ca.savi.wilson.model.AuthNUserReq;

/**
 * Authentication class.
 *
 * @author Eliot J. Kang <eliot@savinetwork.ca>
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
public interface Authentication {
  /**
   * Authenticate resource usage
   *
   * @param authenticateResourceUsageRequest
   * @return
   */
  public AuthNResult authenticateResourceUsage(
      AuthResourceUsageReq authenticateResourceUsageRequest);

  /**
   * Authenticate user
   *
   * @param authenticateUserRequest
   * @return
   */
  public AuthNResult authenticateUser(AuthNUserReq request);
}