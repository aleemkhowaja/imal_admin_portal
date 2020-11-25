/**
 * 
 */
package com.path.vo.common.dashboard;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * ApplicationCO.java used to
 */
public class ApplicationCO extends BaseVO
{
  private S_APPVO    appVO;
  private BigDecimal groupCode;
  private String     groupDesc;
  private String     lastLogin;
  private String     lastLogout;
  private String     latestVersion;
  private Date       loginDate;
  private Date       logoutDate;
  private String     appUrl;
/**
 * @return the appVO
 */
public S_APPVO getAppVO()
{
    return appVO;
}

/**
 * @param appVO the appVO to set
 */
public void setAppVO(S_APPVO appVO)
{
    this.appVO = appVO;
}

/**
 * @return the groupCode
 */
public BigDecimal getGroupCode()
{
    return groupCode;
}

/**
 * @param groupCode the groupCode to set
 */
public void setGroupCode(BigDecimal groupCode)
{
    this.groupCode = groupCode;
}

/**
 * @return the groupDesc
 */
public String getGroupDesc()
{
    return groupDesc;
}

/**
 * @param groupDesc the groupDesc to set
 */
public void setGroupDesc(String groupDesc)
{
    this.groupDesc = groupDesc;
}

/**
 * @return the latestVersion
 */
public String getLatestVersion()
{
    return latestVersion;
}

/**
 * @param latestVersion the latestVersion to set
 */
public void setLatestVersion(String latestVersion)
{
    this.latestVersion = latestVersion;
}

/**
 * @return the lastLogin
 */
public String getLastLogin()
{
    return lastLogin;
}

/**
 * @param lastLogin the lastLogin to set
 */
public void setLastLogin(String lastLogin)
{
    this.lastLogin = lastLogin;
}

/**
 * @return the lastLogout
 */
public String getLastLogout()
{
    return lastLogout;
}

/**
 * @param lastLogout the lastLogout to set
 */
public void setLastLogout(String lastLogout)
{
    this.lastLogout = lastLogout;
}

/**
 * @return the loginDate
 */
public Date getLoginDate()
{
    return loginDate;
}

/**
 * @param loginDate the loginDate to set
 */
public void setLoginDate(Date loginDate)
{
    this.loginDate = loginDate;
}

/**
 * @return the logoutDate
 */
public Date getLogoutDate()
{
    return logoutDate;
}

/**
 * @param logoutDate the logoutDate to set
 */
public void setLogoutDate(Date logoutDate)
{
    this.logoutDate = logoutDate;
}

/**
 * @return the appUrl
 */
public String getAppUrl()
{
    return appUrl;
}

/**
 * @param appUrl the appUrl to set
 */
public void setAppUrl(String appUrl)
{
    this.appUrl = appUrl;
}
}
