package ca.savinetwork.testbed.authentication;

import ca.savinetwork.testbed.type.authenticationschema.*;
import ca.savinetwork.testbed.type.datastoreschema.*;

import ca.savinetwork.testbed.datastore.DataStore;

/**
 * Authentication class
 * 
 * @author eliot
 *
 */
public class AuthenticationImpl implements Authentication {
    /**
     * DataStore instance
     */
    private DataStore dataStore = null;

    public AuthenticationImpl() {
        dataStore = new DataStore();
    }
    @Override
    public AuthenticateResourceUsageResponse authenticateResourceUsage(AuthenticateResourceUsageRequest AuthenticateResourceUsageIn) {
    	AuthenticateResourceUsageResponse AuthenticateResourceUsageOut = new AuthenticateResourceUsageResponse();
    	AuthenticateResourceUsageResponse AuthenticateResourceUsageOut_Fail = new AuthenticateResourceUsageResponse();
    	DBGetResourceUsageResponse DBGetResourceUsageOut = new DBGetResourceUsageResponse();
    	DBGetResourceUsageRequest DBGetResourceUsageIn = new DBGetResourceUsageRequest();
    	
    	DBGetResourceUsageIn.setPlanName(AuthenticateResourceUsageIn.getPlanName());
    	DBGetResourceUsageIn.setAorName(AuthenticateResourceUsageIn.getAorName());
    	DBGetResourceUsageIn.setResourceType(AuthenticateResourceUsageIn.getResourceType());
    	DBGetResourceUsageIn.setUuid(AuthenticateResourceUsageIn.getUuid());
    	DBGetResourceUsageIn.setStartTime(AuthenticateResourceUsageIn.getStartTime());
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
    public AuthenticateUserResponse authenticateUser(AuthenticateUserRequest AuthenticateUserIn) {
    	DBGetUserResponse DBGetUserOut = new DBGetUserResponse();
    	DBGetUserRequest DBGetUserIn = new DBGetUserRequest();
    	AuthenticateUserResponse AuthenticateUserOut = new AuthenticateUserResponse();
    	AuthenticateUserResponse AuthenticateUserOut_AuthFail = new AuthenticateUserResponse();
    
    	DBGetUserIn.setUserCredentials(AuthenticateUserIn.getUserCredentials());
    	
    	//	<invoke>
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
