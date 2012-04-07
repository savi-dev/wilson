package ca.savi.wilson.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuthenticateUserRequest")
public class AuthenticateUserRequest {

  @XmlElement(required = true)
  protected Credential userCredentials;
  @XmlElement(required = true)
  protected String operation;

  public Credential getUserCredentials() {
    return userCredentials;
  }

  public void setUserCredentials(Credential value) {
    this.userCredentials = value;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String value) {
    this.operation = value;
  }

}
