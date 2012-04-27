// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.model;
/**
 * Authentication result.
 *
 * @author Mohammad Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
public class AuthNResult {
  protected String token;
  protected String expirationDate;
  protected boolean successful;
  protected String error;

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }
  /**
   * @return Whether the user is authenticated.
   */
  public boolean isSuccessful()
  {
    return this.successful;
  }

  public void setSuccessful(boolean value)
  {
    this.successful=value;
  }
  public String getError()
  {
    return this.error;
  }
  public void setError(String value)
  {
    this.error=value;
  }
  public String getToken() {
    return token;
  }

  public void setToken(String value) {
    this.token = value;
  }
}
