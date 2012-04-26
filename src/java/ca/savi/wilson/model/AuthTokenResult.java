package ca.savi.wilson.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ca.savi.wilson.AuthenticationResult;

/**
 *
 * @author Mohammad Sadegh Faraji <ms.faraji@utoronto.ca>
 * @version 0.2
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuthenticationResult")
@XmlType(propOrder={"successful","error","tenantId"})
public class AuthTokenResult extends AuthenticationResult{
  private int tenantId;
  public int getTenantId()
  {
    return this.tenantId;
  }
  public void setTenantId(int value)
  {
    this.tenantId=value;
  }
}
