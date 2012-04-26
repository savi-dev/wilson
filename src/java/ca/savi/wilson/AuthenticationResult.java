// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson;

import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
@XmlTransient
public abstract class AuthenticationResult {
  protected boolean successful;
  protected String error;
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
}
