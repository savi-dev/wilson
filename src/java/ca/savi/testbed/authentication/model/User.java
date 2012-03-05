// Copyright (c) 2012, The SAVI Project.
package ca.savi.testbed.authentication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Represents a user in SAVI.
 *
 * @author Soheil Hassas Yeganeh <soheil@cs.toronto.edu>
 * @version 0.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class User {

    @XmlElement(required = true)
    protected String username;
    @XmlElement(name = "service-level", required = true)
    protected String serviceLevel;

    /**
     * @return The username.
     */
    @Id
    public String getUsername() {
        return username;
    }

    /**
     * Sets user's name.
     *
     * @param username The username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return User's service level.
     */
    public String getServiceLevel() {
        return serviceLevel;
    }

    /**
     * Sets service level.
     *
     * @param serviceLevel The service level.
     */
    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }
}
