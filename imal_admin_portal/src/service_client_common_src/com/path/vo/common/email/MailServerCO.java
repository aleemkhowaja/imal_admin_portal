/**
 * 
 */
package com.path.vo.common.email;

import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * MailServerCO.java used to
 */
public class MailServerCO extends RetailBaseVO
{
  private String url;
  private String host;
  private int    port;
  private String userName;
  private String password;
  private String protocol = "smtp";
  // true/false parameter to specify whether to enable the SSL secure layer in email server.
  private String sslEnabled;
  private String authEnabled; // Specify whether authentication enabled for this mail server
  private String startTlsEnabled; // Specify whether TLS enabled for this mail server
  // port used for SSL secure connection, if null then port will be used
  private int    sslSocketPort;
/**
 * @return the url
 */
public String getUrl()
{
    return url;
}
/**
 * @param url the url to set
 */
public void setUrl(String url)
{
    this.url = url;
}

/**
 * @return the host
 */
public String getHost()
{
    return host;
}
/**
 * @param host the host to set
 */
public void setHost(String host)
{
    this.host = host;
}
/**
 * @return the port
 */
public int getPort()
{
    return port;
}
/**
 * @param port the port to set
 */
public void setPort(int port)
{
    this.port = port;
}
/**
 * @return the userName
 */
public String getUserName()
{
    return userName;
}
/**
 * @param userName the userName to set
 */
public void setUserName(String userName)
{
    this.userName = userName;
}
/**
 * @return the password
 */
public String getPassword()
{
    return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password)
{
    this.password = password;
}
/**
 * @return the protocol
 */
public String getProtocol()
{
    return protocol;
}
/**
 * @param protocol the protocol to set
 */
public void setProtocol(String protocol)
{
    this.protocol = protocol;
}
public String getSslEnabled()
{
    return sslEnabled;
}
public void setSslEnabled(String sslEnabled)
{
    this.sslEnabled = sslEnabled;
}
public int getSslSocketPort()
{
    return sslSocketPort;
}
public void setSslSocketPort(int sslSocketPort)
{
    this.sslSocketPort = sslSocketPort;
}
public String getAuthEnabled()
{
    return authEnabled;
}
public void setAuthEnabled(String authEnabled)
{
    this.authEnabled = authEnabled;
}
public String getStartTlsEnabled()
{
    return startTlsEnabled;
}
public void setStartTlsEnabled(String startTlsEnabled)
{
    this.startTlsEnabled = startTlsEnabled;
}
  
}
