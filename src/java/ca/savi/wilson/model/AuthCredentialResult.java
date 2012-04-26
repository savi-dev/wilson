// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ca.savi.wilson.AuthenticationResult;

/**
 * Authentication result.
 *
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuthenticationResult")
@XmlType(propOrder={"successful","error","token","expirationDate","accessCode"})
public class AuthCredentialResult extends AuthenticationResult {

  protected String token;
  protected String expirationDate;
  protected int accessCode;

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
public int getAccessCode()
{
  return this.accessCode;
}

public void setAccessCode(int value)
{
  this.accessCode=value;
}
}
