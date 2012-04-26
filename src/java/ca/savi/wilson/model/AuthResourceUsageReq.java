// Copyright (c) 2012, The SAVI Project.
package ca.savi.wilson.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Authentication request for resource usage.
 *
 * @author Soheil Hassas Yeganeh <soheil@cs.toronto.edu>
 */
// TODO(mohammad): Need to be refactored to a general interface.
// TODO(soheil): There is no need for this value objects.
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuthenticateResourceUsageRequest")
public class AuthResourceUsageReq {
  @XmlElement(required = true)
  protected String username;
  @XmlElement(required = true)
  protected String planName;
  @XmlElement(required = true)
  protected String aorName;
  protected String resourceType;
  protected String uuid;
  protected String startTime;
  protected String stopTime;
  protected Boolean inUse;

  /**
   * @return User's name.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set's username.
   *
   * @param username
   *          User's name.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return The plan's name.
   */
  public String getPlanName() {
    return planName;
  }

  /**
   * @param planName
   *          The desired plan name.
   */
  public void setPlanName(String planName) {
    this.planName = planName;
  }

  public String getAorName() {
    return aorName;
  }

  public void setAorName(String value) {
    this.aorName = value;
  }

  /**
   * @return Resource's type.
   */
  public String getResourceType() {
    return resourceType;
  }

  /**
   * @param resourceType
   *          Resource's type.
   */
  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  /**
   * @return UUID.
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * @param uuid
   */
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  /**
   * @return The start time of the reservation.
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * Set's the start time of the reservation.
   *
   * @param startTime
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  /**
   * @return The stop time of the reservation.
   */
  public String getStopTime() {
    return stopTime;
  }

  /**
   * The stop time of the reservation.
   *
   * @param stopTime
   */
  public void setStopTime(String stopTime) {
    this.stopTime = stopTime;
  }

  /**
   * @return Whether the resource is in use.
   */
  public Boolean isInUse() {
    return inUse;
  }

  /**
   * Sets whether the user can be in user.
   *
   * @param inUse
   */
  public void setInUse(Boolean inUse) {
    this.inUse = inUse;
  }
}
