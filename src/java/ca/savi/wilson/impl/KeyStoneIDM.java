// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.impl;

import ca.savi.authentication.keystone.API.KSServiceAPI;
import ca.savi.authentication.keystone.model.KSUserAuthResp;
import ca.savi.wilson.Authentication;
import ca.savi.wilson.ResultDecorator;
import ca.savi.wilson.model.AuthenticateResourceUsageRequest;
import ca.savi.wilson.model.AuthenticateUserRequest;
import ca.savi.wilson.model.AuthenticationResult;

/**
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
public class KeyStoneIDM implements Authentication, ResultDecorator {

  private KSServiceAPI ksConnect;
  public KSUserAuthResp response;
  private AuthenticationResult authenticationResult = null;

  public KeyStoneIDM(String address, String port) {
    ksConnect = new KSServiceAPI(address, port);
    this.authenticationResult = new AuthenticationResult();
  }

  @Override
  public AuthenticationResult authenticateResourceUsage(
      AuthenticateResourceUsageRequest authenticateResourceUsageRequest) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AuthenticationResult authenticateUser(
      AuthenticateUserRequest authenticateUserRequest) {
    response = ksConnect.authenticate(authenticateUserRequest
        .getUserCredentials().getUsername(), authenticateUserRequest
        .getUserCredentials().getPassword());

    return decoratingAuthResponse();
  }

  @Override
  public AuthenticationResult decoratingAuthResponse() {
    if (this.response == null) {
      authenticationResult.setSuccessful(false);
      authenticationResult.setError("Invalid username/password");
    }
    else {
      authenticationResult.setSuccessful(true);
      authenticationResult.setToken(response.getAccess().getToken().getId());
      authenticationResult.setExpirationDate(response.getAccess().getToken()
          .getExpires());
    }
    return authenticationResult;

  }

}
