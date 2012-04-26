// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.impl;

import ca.savi.aaa.keystone.API.KSServiceAPI;
import ca.savi.aaa.keystone.model.KSUserAuthResp;
import ca.savi.wilson.Authentication;
import ca.savi.wilson.AuthenticationResult;
import ca.savi.wilson.ResultDecorator;
import ca.savi.wilson.model.AuthCredentialResult;
import ca.savi.wilson.model.AuthResourceUsageReq;
import ca.savi.wilson.model.AuthTokenReq;
import ca.savi.wilson.model.AuthTokenResult;
import ca.savi.wilson.model.AuthUserReq;

/**
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
public class KeyStoneIDM implements Authentication, ResultDecorator {

  private KSServiceAPI ksConnect;
  public KSUserAuthResp response;
  private AuthCredentialResult authenticationResult = null;

  public KeyStoneIDM(String address, String port) {
    ksConnect = new KSServiceAPI(address, port);
    this.authenticationResult = new AuthCredentialResult();
  }

  @Override
  public AuthCredentialResult authenticateResourceUsage(
      AuthResourceUsageReq authenticateResourceUsageRequest) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AuthCredentialResult authenticateUser(
      AuthUserReq req) {
    response = ksConnect.authenticateCred(req.getUserCredentials().getUsername(),
        req.getUserCredentials().getPassword());

    return decorateAuthCredResponse();
  }

  @Override
  public AuthCredentialResult decorateAuthCredResponse() {
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
