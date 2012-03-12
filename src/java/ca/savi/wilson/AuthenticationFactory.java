// Copyright (C) 2012, The SAVI Project.
package ca.savi.wilson;

import ca.savi.wilson.impl.AuthenticationImpl;

public class AuthenticationFactory {

  /**
   * Creates the default Authentication.
   *
   * @return The datastore.
   */
  public Authentication createAuthentication() {
    return new AuthenticationImpl();
  }
}