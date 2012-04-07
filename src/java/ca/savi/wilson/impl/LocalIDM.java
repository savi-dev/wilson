// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.impl;

import java.sql.Timestamp;
import java.util.List;
import ca.savi.testbed.datastore.ControlCenterDataStore;
import ca.savi.testbed.datastore.model.ResourceUsage;
import ca.savi.testbed.datastore.model.User;
import ca.savi.wilson.Authentication;
import ca.savi.wilson.ResultDecorator;
import ca.savi.wilson.model.AuthenticateResourceUsageRequest;
import ca.savi.wilson.model.AuthenticateUserRequest;
import ca.savi.wilson.model.AuthenticationResult;

/**
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
public class LocalIDM implements Authentication, ResultDecorator {
  ControlCenterDataStore datastore = ControlCenterDataStore.createDataStore();
  AuthenticationResult authenticationResult;

  @Override
  public AuthenticationResult authenticateResourceUsage(
      AuthenticateResourceUsageRequest request) {
    List<ResourceUsage> resourceUsages = datastore.getResourceUsage(
        request.isInUse(), null, request.getUsername(), null,
        Timestamp.valueOf(request.getStopTime()));
    AuthenticationResult result = new AuthenticationResult();
    if (resourceUsages == null || resourceUsages.size() == 0) {
      result.setSuccessful(false);
      result.setError("No such resource");
    }
    else {
      result.setSuccessful(true);
    }
    return result;
  }

  @Override
  public AuthenticationResult authenticateUser(AuthenticateUserRequest request) {
    authenticationResult = new AuthenticationResult();
    User user = datastore.getUser(request.getUserCredentials().getUsername(),
        request.getUserCredentials().getPassword());

    if (user != null) {
      authenticationResult.setSuccessful(true);
    }
    else {
      authenticationResult.setSuccessful(false);
      authenticationResult.setError("Invalid username/password");
    }
    return decoratingAuthResponse();
  }

  @Override
  public AuthenticationResult decoratingAuthResponse() {
    return authenticationResult;
  }

}
