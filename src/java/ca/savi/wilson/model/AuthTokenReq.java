// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Token Model Class
 *
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Token")
public class AuthTokenReq {

  @XmlElement(required = true)
  protected String service_endpoint;
  @XmlElement(required = true)
  protected Token service_token;
  @XmlElement(required = true)
  protected Token user_token;

  public String getService_endpoint() {
    return this.service_endpoint;
  }

  public void setService_endpoint(String value) {
    this.service_endpoint = value;
  }

  public Token getService_token() {
    return this.service_token;
  }

  public void setService_token(Token value) {
    this.service_token = value;
  }

  public Token getUser_token() {
    return this.user_token;
  }

  public void setUser_token(Token value) {
    this.user_token = value;
  }
}
