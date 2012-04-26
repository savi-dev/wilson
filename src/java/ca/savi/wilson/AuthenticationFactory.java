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
  Authentication authManager;
  /**
   * Creates the default Authentication.
   *
   * @return The Identity manager.
   *@version 0.2
   */
  public Authentication createAuthentication() {
    if(this.authManager!=null)
    {
      return authManager;
    }
    else
    {
      try {
        ResourceBundle resources = ResourceBundle.getBundle("ca.savi.aaa");
        String idm = resources.getString("IDM");
        if (idm.intern() == "Local") {
          return createLocalAuthentication();
        }
        else if (idm.intern() == "KeyStone") {
          return createKeyStoneAuthentication(resources.getString("Address"),
              resources.getString("Port"));
        }
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  private Authentication createLocalAuthentication() {
    return (Authentication) new LocalIDM();
  }

  private Authentication createKeyStoneAuthentication(String address,
      String port) {
    return (Authentication) new KeyStoneIDM(address, port);
  }
}