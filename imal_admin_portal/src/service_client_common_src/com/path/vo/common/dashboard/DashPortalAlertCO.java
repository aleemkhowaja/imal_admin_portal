/**
 * 
 */
package com.path.vo.common.dashboard;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashPortalAlertCO.java used to
 */
public class DashPortalAlertCO extends BaseVO
{
  private String     appName;
  private String     appDesc;
  private BigDecimal alertsCount;
/**
 * @return the appName
 */
public String getAppName()
{
    return appName;
}
/**
 * @param appName the appName to set
 */
public void setAppName(String appName)
{
    this.appName = appName;
}
/**
 * @return the appDesc
 */
public String getAppDesc()
{
    return appDesc;
}
/**
 * @param appDesc the appDesc to set
 */
public void setAppDesc(String appDesc)
{
    this.appDesc = appDesc;
}
/**
 * @return the alertsCount
 */
public BigDecimal getAlertsCount()
{
    return alertsCount;
}
/**
 * @param alertsCount the alertsCount to set
 */
public void setAlertsCount(BigDecimal alertsCount)
{
    this.alertsCount = alertsCount;
} 
}
