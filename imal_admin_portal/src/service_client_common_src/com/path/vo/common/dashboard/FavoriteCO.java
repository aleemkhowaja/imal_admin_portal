/**
 * 
 */
package com.path.vo.common.dashboard;

import java.util.Date;

import com.path.dbmaps.vo.USER_FAVORITESVO;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * FavoriteCO.java used to
 */
public class FavoriteCO extends BaseVO
{
   private String opt_url;
   private USER_FAVORITESVO userFavorites = new USER_FAVORITESVO();
   private String  appDesc;
   private String  appUrl;
   private Boolean externalLink;
   private String  fullPath;
   private Date    hijriDate;
   private String  targetAppName;
   private String  targetProgRef;
/**
 * @return the opt_url
 */
public String getOpt_url()
{
    return opt_url;
}
/**
 * @param optUrl the opt_url to set
 */
public void setOpt_url(String optUrl)
{
    opt_url = optUrl;
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
/**
 * @return the userFavorites
 */
public USER_FAVORITESVO getUserFavorites()
{
    return userFavorites;
}
/**
 * @param userFavorites the userFavorites to set
 */
public void setUserFavorites(USER_FAVORITESVO userFavorites)
{
    this.userFavorites = userFavorites;
}
/**
 * @return the externalLink
 */
public Boolean getExternalLink()
{
    return externalLink;
}
/**
 * @param externalLink the externalLink to set
 */
public void setExternalLink(Boolean externalLink)
{
    this.externalLink = externalLink;
}
/**
 * @return the fullPath
 */
public String getFullPath()
{
    return fullPath;
}
/**
 * @param fullPath the fullPath to set
 */
public void setFullPath(String fullPath)
{
    this.fullPath = fullPath;
}
/**
 * @return the hijriDate
 */
public Date getHijriDate()
{
    return hijriDate;
}
/**
 * @param hijriDate the hijriDate to set
 */
public void setHijriDate(Date hijriDate)
{
    this.hijriDate = hijriDate;
}
/**
 * @return the targetAppName
 */
public String getTargetAppName()
{
    return targetAppName;
}
/**
 * @param targetAppName the targetAppName to set
 */
public void setTargetAppName(String targetAppName)
{
    this.targetAppName = targetAppName;
}
/**
 * @return the targetProgRef
 */
public String getTargetProgRef()
{
    return targetProgRef;
}
/**
 * @param targetProgRef the targetProgRef to set
 */
public void setTargetProgRef(String targetProgRef)
{
    this.targetProgRef = targetProgRef;
}

}
