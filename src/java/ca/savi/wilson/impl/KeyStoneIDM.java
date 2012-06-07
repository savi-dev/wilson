// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.impl;

import ca.savi.aaa.keystone.API.KSDriver;
import ca.savi.aaa.keystone.model.KSUserAuthResp;
import ca.savi.wilson.Authentication;
import ca.savi.wilson.model.AuthNResult;
import ca.savi.wilson.model.AuthNUserReq;
import ca.savi.wilson.model.AuthResourceUsageReq;

/**
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
public class KeyStoneIDM implements Authentication {

  public KSDriver keystone;
  public KSUserAuthResp response;
  private AuthNResult authenticationResult = null;

  public KeyStoneIDM() {
    keystone = KSDriver.getInstance();
    this.authenticationResult = new AuthNResult();
  }

  @Override
  public AuthNResult authenticateResourceUsage(
      AuthResourceUsageReq authenticateResourceUsageRequest) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AuthNResult authenticateUser(
      AuthNUserReq req) {
    if(req.getUserCredentials().getToken() != null &&
        !req.getUserCredentials().getToken().isEmpty() && !req.getUserCredentials().getToken().trim().isEmpty())
    {
      return authenticateToken(req);
    }
    response = keystone.authenticateUser(req.getUserCredentials().getUsername(),
        req.getUserCredentials().getPassword());

    return decorateAuthCredResponse();
  }

  public AuthNResult decorateAuthCredResponse() {
    if (this.response == null) {
      authenticationResult.setSuccessful(false);
      authenticationResult.setError("Invalid username/password");
    }
    else {
      authenticationResult.setSuccessful(true);
      authenticationResult.setToken(response.getAccess().getToken().getId());
    }
    return authenticationResult;

  }

  public AuthNResult authenticateToken(AuthNUserReq req) {
    response = keystone.validateToken(req.getUserCredentials().getToken());

    return decorateTokeAuthReponse();
  }

  public AuthNResult decorateTokeAuthReponse() {
    if (this.response == null) {
      authenticationResult.setSuccessful(false);
      authenticationResult.setError("Token");
    }
    else {
      authenticationResult.setSuccessful(true);
    }
    return authenticationResult;
  }

}
