// Copyright (C) 2012, The SAVI Project.
package ca.savi.wilson.impl;

import ca.savi.wilson.Authentication;
import ca.savi.yorkdale.DataStore;
import ca.savi.yorkdale.DataStoreFactory;
import ca.savi.yorkdale.model.authentication.AuthenticateResourceUsageRequest;
import ca.savi.yorkdale.model.authentication.AuthenticateResourceUsageResponse;
import ca.savi.yorkdale.model.authentication.AuthenticationUserRequest;
import ca.savi.yorkdale.model.authentication.AuthenticationUserResponse;
import ca.savi.yorkdale.model.datastore.DBGetResourceUsageRequest;
import ca.savi.yorkdale.model.datastore.DBGetResourceUsageResponse;
import ca.savi.yorkdale.model.datastore.DBGetUserRequest;
import ca.savi.yorkdale.model.datastore.DBGetUserResponse;

public class AuthenticationImpl implements Authentication {
  @Override
  public AuthenticateResourceUsageResponse authenticateResourceUsage(
      AuthenticateResourceUsageRequest AuthenticateResourceUsageIn) {
    DataStore dataStore = new DataStoreFactory().createDataStore();
    AuthenticateResourceUsageResponse AuthenticateResourceUsageOut =
        new AuthenticateResourceUsageResponse();
    AuthenticateResourceUsageResponse AuthenticateResourceUsageOut_Fail =
        new AuthenticateResourceUsageResponse();
    DBGetResourceUsageResponse DBGetResourceUsageOut =
        new DBGetResourceUsageResponse();
    DBGetResourceUsageRequest DBGetResourceUsageIn =
        new DBGetResourceUsageRequest();

    DBGetResourceUsageIn.setPlanName(AuthenticateResourceUsageIn.getPlanName());
    DBGetResourceUsageIn.setAorName(AuthenticateResourceUsageIn.getAorName());
    DBGetResourceUsageIn.setResourceType(AuthenticateResourceUsageIn
        .getResourceType());
    DBGetResourceUsageIn.setUuid(AuthenticateResourceUsageIn.getUuid());
    DBGetResourceUsageIn.setStartTime(AuthenticateResourceUsageIn
        .getStartTime());
    DBGetResourceUsageIn.setStopTime(AuthenticateResourceUsageIn.getStopTime());
    DBGetResourceUsageIn.setInUse(AuthenticateResourceUsageIn.isInUse());
    DBGetResourceUsageIn.setUsername(AuthenticateResourceUsageIn.getUsername());

    DBGetResourceUsageOut = dataStore.dbGetResourceUsage(DBGetResourceUsageIn);

    if (DBGetResourceUsageOut.getResourceList() != null
        && DBGetResourceUsageOut.getResourceList().size() > 0) {
      AuthenticateResourceUsageOut.setSuccessful(true);
      return AuthenticateResourceUsageOut;
    } else {
      AuthenticateResourceUsageOut_Fail.setSuccessful(false);
      AuthenticateResourceUsageOut_Fail.setError("No such resource");
      return AuthenticateResourceUsageOut_Fail;
    }
  }

  @Override
  public AuthenticationUserResponse authenticateUser(
      AuthenticationUserRequest AuthenticateUserIn) {
    DataStore dataStore = new DataStoreFactory().createDataStore();
    DBGetUserResponse DBGetUserOut = new DBGetUserResponse();
    DBGetUserRequest DBGetUserIn = new DBGetUserRequest();
    AuthenticationUserResponse AuthenticateUserOut =
        new AuthenticationUserResponse();
    AuthenticationUserResponse AuthenticateUserOut_AuthFail =
        new AuthenticationUserResponse();

    System.out.println("Auth: " + AuthenticateUserIn.getUserCredentials());
    DBGetUserIn.setUserCredentials(AuthenticateUserIn.getUserCredentials());

    // <invoke>
    DBGetUserOut = dataStore.dbGetUser(DBGetUserIn);

    if (DBGetUserOut.getUsers() != null && DBGetUserOut.getUsers().size() > 0) {
      AuthenticateUserOut.setSuccessful(true);
      return AuthenticateUserOut;
    } else {
      AuthenticateUserOut_AuthFail.setSuccessful(false);
      AuthenticateUserOut_AuthFail.setError("Invalid username/password");
      return AuthenticateUserOut_AuthFail;
    }
  }
}
