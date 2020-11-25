/**
 * 
 */
package com.path.vo.common.menu;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * TreeMenuSC.java used to
 */
public class TreeMenuSC extends GridParamsSC
{
    private String langCode;
    private String appName;
    private String progRef;
    private String nodeid;
    private String parentid;
    private BigDecimal n_level;
    private String saveAsParent;
    private String profileId;
    /**
     * @return the langCode
     */
    public String getLangCode()
    {
        return langCode;
    }
    /**
     * @param langCode the langCode to set
     */
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
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
     * @return the progRef
     */
    public String getProgRef()
    {
        return progRef;
    }
    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    /**
     * @return the nodeid
     */
    public String getNodeid()
    {
        return nodeid;
    }
    /**
     * @param nodeid the nodeid to set
     */
    public void setNodeid(String nodeid)
    {
        this.nodeid = nodeid;
    }
    /**
     * @return the parentid
     */
    public String getParentid()
    {
        return parentid;
    }
    /**
     * @param parentid the parentid to set
     */
    public void setParentid(String parentid)
    {
        this.parentid = parentid;
    }
    /**
     * @return the n_level
     */
    public BigDecimal getN_level()
    {
        return n_level;
    }
    /**
     * @param nLevel the n_level to set
     */
    public void setN_level(BigDecimal nLevel)
    {
        n_level = nLevel;
    }
    public String getSaveAsParent()
    {
        return saveAsParent;
    }
    public void setSaveAsParent(String saveAsParent)
    {
        this.saveAsParent = saveAsParent;
    }
    /**
     * @return the profileId
     */
    public String getProfileId()
    {
        return profileId;
    }
    /**
     * @param profileId the profileId to set
     */
    public void setProfileId(String profileId)
    {
        this.profileId = profileId;
    }
}
