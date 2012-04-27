// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.model;


public class AuthNUserReq {
  protected Credential userCredentials;
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
