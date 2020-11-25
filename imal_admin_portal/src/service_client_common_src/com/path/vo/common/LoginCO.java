/**
 * 
 */
package com.path.vo.common;

import java.math.BigDecimal;

import com.path.dbmaps.vo.S_APPLOGVO;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * LoginCO.java used to
 */
public class LoginCO extends BaseVO
{
  private S_APPLOGVO sAppLogVO = new S_APPLOGVO();
  private BigDecimal isWebVers;
  private String excludeEngineApps;
  // used to check for opened Session
  private BigDecimal isBranch;
  private BigDecimal notIsBranch;
  private BigDecimal branchClosedAllowUser;
  
  private String sameUsrToOthApp;
  private String donotCheckLoc;// variable to specify not to check LOC table upon checking of logged in users
  private String currAppName;
  private String httpSessionId;
  private String machineId;
  
/**
 * @return the sAppLogVO
 */
public S_APPLOGVO getsAppLogVO()
{
    return sAppLogVO;
}
/**
 * @param sAppLogVO the sAppLogVO to set
 */
public void setsAppLogVO(S_APPLOGVO sAppLogVO)
{
    this.sAppLogVO = sAppLogVO;
}
/**
 * @return the isWebVers
 */
public BigDecimal getIsWebVers()
{
    return isWebVers;
}
/**
 * @param isWebVers the isWebVers to set
 */
public void setIsWebVers(BigDecimal isWebVers)
{
    this.isWebVers = isWebVers;
}
public String getExcludeEngineApps()
{
    return excludeEngineApps;
}
public void setExcludeEngineApps(String excludeEngineApps)
{
    this.excludeEngineApps = excludeEngineApps;
}
public BigDecimal getIsBranch()
{
    return isBranch;
}
public void setIsBranch(BigDecimal isBranch)
{
    this.isBranch = isBranch;
}
public BigDecimal getNotIsBranch()
{
    return notIsBranch;
}
public void setNotIsBranch(BigDecimal notIsBranch)
{
    this.notIsBranch = notIsBranch;
}
/**
 * @return the sameUsrToOthApp
 */
public String getSameUsrToOthApp()
{
    return sameUsrToOthApp;
}
/**
 * @param sameUsrToOthApp the sameUsrToOthApp to set
 */
public void setSameUsrToOthApp(String sameUsrToOthApp)
{
    this.sameUsrToOthApp = sameUsrToOthApp;
}
/**
 * @return the currAppName
 */
public String getCurrAppName()
{
    return currAppName;
}
/**
 * @param currAppName the currAppName to set
 */
public void setCurrAppName(String currAppName)
{
    this.currAppName = currAppName;
}
public BigDecimal getBranchClosedAllowUser()
{
    return branchClosedAllowUser;
}
public void setBranchClosedAllowUser(BigDecimal branchClosedAllowUser)
{
    this.branchClosedAllowUser = branchClosedAllowUser;
}
/**
 * @return the httpSessionId
 */
public String getHttpSessionId()
{
    return httpSessionId;
}
/**
 * @param httpSessionId the httpSessionId to set
 */
public void setHttpSessionId(String httpSessionId)
{
    this.httpSessionId = httpSessionId;
}
/**
 * @return the machineId
 */
public String getMachineId()
{
    return machineId;
}
/**
 * @param machineId the machineId to set
 */
public void setMachineId(String machineId)
{
    this.machineId = machineId;
}
public String getDonotCheckLoc()
{
    return donotCheckLoc;
}
public void setDonotCheckLoc(String donotCheckLoc)
{
    this.donotCheckLoc = donotCheckLoc;
}
}
