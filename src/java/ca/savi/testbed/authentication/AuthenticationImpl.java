// Copyright (c) 2012, The SAVI Project.
package ca.savi.testbed.authentication;

import ca.savi.testbed.authentication.datastore.AuthenticationDataStore;
import ca.savi.testbed.authentication.model.AuthenticateResourceUsageRequest;
import ca.savi.testbed.authentication.model.AuthenticateUserRequest;
import ca.savi.testbed.authentication.model.AuthenticationResult;
import ca.savi.testbed.authentication.model.Credential;

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
  AuthenticationDataStore datastore = new AuthenticationDataStore();

  @Override
  public AuthenticationResult authenticateResourceUsage(
      AuthenticateResourceUsageRequest request) {
    // TODO(soheil): Ask eliot about this.
//    DBGetResourceUsageIn.setStopTime(request.getStopTime());
//    DBGetResourceUsageIn.setInUse(request.isInUse());
//    DBGetResourceUsageIn.setUsername(request.getUsername());
//
//    DBGetResourceUsageOut = dataStore.dbGetResourceUsage(DBGetResourceUsageIn);
//
//    if (DBGetResourceUsageOut.getResourceList() != null
//        && DBGetResourceUsageOut.getResourceList().size() > 0) {
//      authenticationResult.setSuccessful(true);
//    } else {
//      authenticationResult.setSuccessful(false);
//      authenticationResult.setError("No such resource");
//    }
    AuthenticationResult result = new AuthenticationResult();
    result.setSuccessful(true);
    return result;
  }

  @Override
  public AuthenticationResult authenticateUser(
      AuthenticateUserRequest request) {
    AuthenticationResult authenticationResult = new AuthenticationResult();
    Credential credential = datastore.findCredential(
        request.getUserCredentials().getUsername());

    if (credential != null &&
        credential.getPassword().equals(
            request.getUserCredentials().getPassword())) {
      authenticationResult.setSuccessful(true);
    } else {
      authenticationResult.setSuccessful(false);
      authenticationResult.setError("Invalid username/password");
    }
    return authenticationResult;
  }
}
