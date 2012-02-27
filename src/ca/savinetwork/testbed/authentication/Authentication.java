// Copyright (c) 2012, The SAVI Project.
// All right researved. http://www.savinetwork.ca
package ca.savinetwork.testbed.authentication;

/**
 * Authentication class
 *
 * @author Eliot Kang <eliot@savinetwork.ca>
 *
 */


public interface Authentication {

    /**
     * Authenticate resource usage
     *
     * @param AuthenticateResourceUsageIn
     * @return
     */
    public ca.savinetwork.testbed.type.authenticationschema.AuthenticateResourceUsageResponse
        authenticateResourceUsage(ca.savinetwork.testbed.type.authenticationschema.AuthenticateResourceUsageRequest AuthenticateResourceUsageIn);

    /**
     * Authenticate user
     *
     * @param AuthenticateUserIn
     * @return
     */
    public ca.savinetwork.testbed.type.authenticationschema.AuthenticateUserResponse
        authenticateUser(ca.savinetwork.testbed.type.authenticationschema.AuthenticateUserRequest AuthenticateUserIn);
}
