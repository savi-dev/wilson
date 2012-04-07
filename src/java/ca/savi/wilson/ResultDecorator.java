// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson;

import ca.savi.wilson.model.AuthenticationResult;

/**
 * Decorator class.
 * 
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */

public interface ResultDecorator {
  AuthenticationResult decoratingAuthResponse();
}
