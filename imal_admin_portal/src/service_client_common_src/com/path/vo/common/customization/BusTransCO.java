package com.path.vo.common.customization;

import com.path.struts2.lib.common.BaseObject;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: deniskhaddad
 *
 * BusTransCO.java used to load the Business Translation List in Customization Screen
 */
public class BusTransCO extends BaseObject
{
    private String langCode;
    private String globalToolTip;
    private String langDesc;
    private String toolTip;
    public String getLangCode()
    {
        return langCode;
    }
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
    public String getLangDesc()
    {
        return langDesc;
    }
    public void setLangDesc(String langDesc)
    {
        this.langDesc = langDesc;
    }
    public String getToolTip()
    {
        return toolTip;
    }
    public void setToolTip(String toolTip)
    {
        this.toolTip = toolTip;
    }
    public String getGlobalToolTip()
    {
        return globalToolTip;
    }
    public void setGlobalToolTip(String globalToolTip)
    {
        this.globalToolTip = globalToolTip;
    }
}
