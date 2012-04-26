//Copyright (c) 2012, The SAVI Project.

package ca.savi.wilson.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Represents the credential of a user.
 *
 * @author Soheil Hassas Yeganeh <soheil@cs.toronto.edu>
 * @version 0.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Credential {

  @XmlElement(required = true)
  protected String username;
  @XmlElement(required = true)
  protected String password;

  /**
   * @return User's name.
   */
  @Id
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
