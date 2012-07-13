// Copyright (C) 2012, The SAVI Project.
package ca.savi.wilson;

import java.util.ResourceBundle;
import ca.savi.wilson.impl.KeyStoneIDM;
import ca.savi.wilson.impl.LocalIDM;

/**
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
public class AuthenticationFactory {
  private static Authentication authManager;
  /**
   * Creates the default Authentication.
   *
   * @return The Identity manager.
   *@version 0.2
   */
  public static Authentication createAuthentication(String authUri) {
    if(AuthenticationFactory.authManager!=null) {
      return authManager;
    } else {
      KeyStoneIDM ks= new KeyStoneIDM();
      ks.keystone.setCredentialEndpoint(authUri);
      ks.keystone.setTokenEndpoint(authUri);
      ks.keystone.setTokenEndpoint("ADMIN");
      authManager = (Authentication) ks;
    }
    return authManager;
  }
}
