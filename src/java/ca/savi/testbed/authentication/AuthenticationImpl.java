// Copyright (c) 2012, The SAVI Project.
package ca.savi.testbed.authentication;

import java.sql.Timestamp;
import java.util.List;

import ca.savi.testbed.authentication.model.AuthenticateResourceUsageRequest;
import ca.savi.testbed.authentication.model.AuthenticateUserRequest;
import ca.savi.testbed.authentication.model.AuthenticationResult;
import ca.savi.testbed.datastore.ControlCenterDataStore;
import ca.savi.testbed.datastore.model.ResourceUsage;
import ca.savi.testbed.datastore.model.User;

/**
 * Authentication class.
 *
 * @author Eliot Kang <eliot@savinetwork.ca>
 * @author Soheil Hassas Yeganeh <soheil@cs.toronto.edu>
 * @version 0.1
 */
// TODO(soheil): Move it to impl, and create a factory class.
public class AuthenticationImpl implements Authentication {
  // TODO(soheil): Inject it.
  ControlCenterDataStore datastore = ControlCenterDataStore.createDataStore();

  @Override
  public AuthenticationResult authenticateResourceUsage(
      AuthenticateResourceUsageRequest request) {
    List<ResourceUsage> resourceUsages = datastore.getResourceUsage(
        request.isInUse(), null, request.getUsername(),
        null, Timestamp.valueOf(request.getStopTime()));
    AuthenticationResult result = new AuthenticationResult();
    if (resourceUsages == null || resourceUsages.size() == 0) {
      result.setSuccessful(false);
      result.setError("No such resource");
    } else {
      result.setSuccessful(true);
    }
    return result;
  }

  @Override
  public AuthenticationResult authenticateUser(
      AuthenticateUserRequest request) {
    AuthenticationResult authenticationResult = new AuthenticationResult();
    User user = datastore.getUser(request.getUserCredentials().getUsername(),
        request.getUserCredentials().getPassword());

    if (user != null) {
      authenticationResult.setSuccessful(true);
    } else {
      authenticationResult.setSuccessful(false);
      authenticationResult.setError("Invalid username/password");
    }
    return authenticationResult;
  }
}
