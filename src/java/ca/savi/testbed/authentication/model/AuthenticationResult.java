// Copyright (c) 2012, The SAVI Project.
package ca.savi.testbed.authentication.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Authentication result.
 *
 * @author Soheil Hassas Yeganeh <soheil@cs.toronto.edu>
 * @version 0.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuthenticationResult")
public class AuthenticationResult {

  protected boolean successful;
  protected String error;

  /**
   * @return Whether the user is authenticated.
   */
  public boolean isSuccessful() {
    return successful;
  }

  public void setSuccessful(boolean value) {
    this.successful = value;
  }

  public String getError() {
    return error;
  }

  public void setError(String value) {
    this.error = value;
  }
}
