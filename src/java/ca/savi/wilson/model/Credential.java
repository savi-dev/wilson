//Copyright (c) 2012, The SAVI Project.

package ca.savi.wilson.model;


/**
 * Represents the credential of a user.
 *
 * @author Mohammad Faraji <ms.faraji@utoronto.ca>
 * @version 0.1
 */
public class Credential {
  protected String username;
  protected String password;
  protected String token;
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  /**
   * @return User's name.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the user name.
   *
   * @param username
   *          User's name.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return User's password.
   */
  // TODO(soheil): Do we need to have hashed or something?
  public String getPassword() {
    return password;
  }

  /**
   * Sets user's password.
   *
   * @param value
   *          User's password.
   */
  public void setPassword(String password) {
    this.password = password;
  }

}
