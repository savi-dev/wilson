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
  public static Authentication createAuthentication() {
    if(AuthenticationFactory.authManager!=null)
    {
      return authManager;
    }
    else
    {
      try {
        ResourceBundle resources = ResourceBundle.getBundle("ca.savi.aaa");
        String idm = resources.getString("IDM");
        if (idm.intern() == "Local") {
          authManager = createLocalAuthentication();
        }
        else if (idm.intern() == "KeyStone") {
          authManager = createKeyStoneAuthentication(resources.getString("Address"),
              resources.getString("Port"));
        }
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
    return authManager;
  }

  private static Authentication createLocalAuthentication() {
    return (Authentication) new LocalIDM();
  }

  private static Authentication createKeyStoneAuthentication(String address,
      String port) {
    return (Authentication) new KeyStoneIDM(address, port);
  }
}