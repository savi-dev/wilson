// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.impl;

import java.util.List;
import ca.savi.moon.datastore.DataStoreFactory;
import ca.savi.wilson.Authentication;
import ca.savi.wilson.AuthenticationResult;
import ca.savi.wilson.ResultDecorator;
import ca.savi.wilson.model.AuthCredentialResult;
import ca.savi.wilson.model.AuthResourceUsageReq;
import ca.savi.wilson.model.AuthTokenReq;
import ca.savi.wilson.model.AuthTokenResult;
import ca.savi.wilson.model.AuthUserReq;
import ca.savi.yorkdale.ControlCenterDataStore;
import ca.savi.yorkdale.entity.ResourceUsageEntity;
import ca.savi.yorkdale.entity.UserEntity;

/**
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
public class LocalIDM implements Authentication, ResultDecorator {
  ControlCenterDataStore dataStore = DataStoreFactory.createDataStore();
  AuthCredentialResult result;

  @Override
  public AuthCredentialResult authenticateResourceUsage(
      AuthResourceUsageReq request) {
    List<ResourceUsageEntity> resourceUsages = dataStore.getResourceUsage(null,
        request.isInUse(), null, request.getUsername(), null,
        request.getStopTime());
    result = new AuthCredentialResult();
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
  public AuthCredentialResult authenticateUser(AuthUserReq request) {
    result = new AuthCredentialResult();
    UserEntity user = dataStore.getUser(request.getUserCredentials()
        .getUsername(), request.getUserCredentials().getPassword());
    if (user != null) {
      result.setSuccessful(true);
    }
    else {
      result.setSuccessful(false);
      result.setError("Invalid username/password");
    }
    return decorateAuthCredResponse();
  }

  @Override
  public AuthCredentialResult decorateAuthCredResponse() {
    return result;
  }

  @Override
  public AuthTokenResult authenticateToken(AuthTokenReq token) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AuthenticationResult decorateTokeAuthReponse() {
    // TODO Auto-generated method stub
    return null;
  }
}
