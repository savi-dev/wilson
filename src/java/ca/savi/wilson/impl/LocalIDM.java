// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.impl;

import java.util.List;
import ca.savi.wilson.Authentication;
import ca.savi.wilson.model.AuthNResult;
import ca.savi.wilson.model.AuthResourceUsageReq;
import ca.savi.wilson.model.AuthNUserReq;
import ca.savi.yorkdale.ControlCenterDataStore;
import ca.savi.yorkdale.DataStoreFactory;
import ca.savi.yorkdale.entity.ResourceUsageEntity;
import ca.savi.yorkdale.entity.UserEntity;

/**
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
public class LocalIDM implements Authentication {
  ControlCenterDataStore dataStore;
  AuthNResult result;

  public LocalIDM() {
    dataStore = DataStoreFactory.createDataStore();
  }
  @Override
  public AuthNResult authenticateResourceUsage(
      AuthResourceUsageReq request) {
    List<ResourceUsageEntity> resourceUsages = dataStore.getResourceUsage(null,
        request.isInUse(), null, request.getUsername(), null,
        request.getStopTime());
    result = new AuthNResult();
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
  public AuthNResult authenticateUser(AuthNUserReq request) {
    result = new AuthNResult();
    UserEntity user = dataStore.getUser(request.getUserCredentials()
        .getUsername(), request.getUserCredentials().getPassword());
    if (user != null) {
      result.setSuccessful(true);
    }
    else {
      result.setSuccessful(false);
      result.setError("Invalid username/password");
    }
    return result;
  }

}
