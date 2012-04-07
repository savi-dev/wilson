//Copyright (c) 2012, The SAVI Project.

package ca.savi.wilson.model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Token that should be authenticated for user request.
 * 
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Token {

  @XmlElement(required = true)
  protected String id;
  @XmlElement
  protected String expirationDate;

  /**
   * 
   * @return the token value
   */
  public String getId() {
    return this.id;
  }

  /**
   * 
   * @param value
   *          new token
   */
  public void setId(String value) {
    this.id = value;
  }

  /**
   * 
   * @return date until this token is valid
   */
  public String getExpirationDate() {
    return this.expirationDate;
  }

  public void setExpirationDate(String value) {
    this.expirationDate = value;
  }
}
