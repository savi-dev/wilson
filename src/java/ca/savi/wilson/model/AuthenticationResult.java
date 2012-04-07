// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Authentication result.
 * 
 * @author Soheil Hassas Yeganeh <soheil@cs.toronto.edu>
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuthenticationResult")
public class AuthenticationResult {

  protected boolean successful;
  protected String error;
  protected String token;
  protected String expirationDate;
  protected int accessCode;

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

  public String getToken() {
    return token;
  }

  public void setToken(String value) {
    this.token = value;
  }

  public void setExpirationDate(String value) {
    this.expirationDate = value;
  }

  public String getExpirationDate() {
    return this.expirationDate;
  }
}
