package ca.savinetwork.testbed.authentication;

/**
 * Authentication class
 * 
 * @author eliot
 *
 */

public interface Authentication {

    /**
     * Authenticate resource usage
     * 
     * @param AuthenticateResourceUsageIn
     * @return 
     */
    public ca.savinetwork.testbed.type.authenticationschema.AuthenticateResourceUsageResponse authenticateResourceUsage(ca.savinetwork.testbed.type.authenticationschema.AuthenticateResourceUsageRequest AuthenticateResourceUsageIn);

    /**
     * Authenticate user
     * 
     * @param AuthenticateUserIn
     * @return 
     */
    public ca.savinetwork.testbed.type.authenticationschema.AuthenticateUserResponse authenticateUser(ca.savinetwork.testbed.type.authenticationschema.AuthenticateUserRequest AuthenticateUserIn);
}
