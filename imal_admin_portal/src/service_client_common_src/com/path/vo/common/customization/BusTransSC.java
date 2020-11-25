package com.path.vo.common.customization;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: deniskhaddad
 *
 * BusTransSC.java used for Search Criteria of Business translation in Customization Screen
 */
public class BusTransSC extends GridParamsSC
{
    private String pageRef;
    private String appName;
    private BigDecimal fldIdent;
    private String elemntName;
    private String voPropName;
    private String voCoRef;

    public BigDecimal getFldIdent()
    {
	return fldIdent;
    }

    public void setFldIdent(BigDecimal fldIdent)
    {
	this.fldIdent = fldIdent;
    }

    public String getPageRef()
    {
	return pageRef;
    }

    public void setPageRef(String pageRef)
    {
	this.pageRef = pageRef;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }



    public String getVoPropName()
    {
        return voPropName;
    }

    public void setVoPropName(String voPropName)
    {
        this.voPropName = voPropName;
    }

    public String getVoCoRef()
    {
        return voCoRef;
    }

    public void setVoCoRef(String voCoRef)
    {
        this.voCoRef = voCoRef;
    }

    public String getElemntName()
    {
        return elemntName;
    }

    public void setElemntName(String elemntName)
    {
        this.elemntName = elemntName;
    }

}
