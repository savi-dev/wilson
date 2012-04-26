// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson;

import ca.savi.wilson.model.AuthTokenReq;
import ca.savi.wilson.model.AuthTokenResult;
import ca.savi.wilson.model.AuthResourceUsageReq;
import ca.savi.wilson.model.AuthUserReq;
import ca.savi.wilson.model.AuthCredentialResult;

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
  public AuthCredentialResult authenticateResourceUsage(
      AuthResourceUsageReq authenticateResourceUsageRequest);

  /**
   * Authenticate user
   *
   * @param authenticateUserRequest
   * @return
   */
  public AuthCredentialResult authenticateUser(AuthUserReq request);
  public AuthTokenResult authenticateToken(AuthTokenReq token);
}