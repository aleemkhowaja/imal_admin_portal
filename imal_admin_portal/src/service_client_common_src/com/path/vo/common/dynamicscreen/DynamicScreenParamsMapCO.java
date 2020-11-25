/**
 * 
 */
package com.path.vo.common.dynamicscreen;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.SYS_DYN_SCREEN_DEFVO;
import com.path.dbmaps.vo.SYS_PARAM_ELM_DYN_SCRN_MAPVO;
import com.path.dbmaps.vo.SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * DynamicScreenParamMapCO.java used to
 */
public class DynamicScreenParamsMapCO extends BaseVO
{
    private SYS_PARAM_ELM_DYN_SCRN_MAPVO sysParamElmDynScrnMap = new SYS_PARAM_ELM_DYN_SCRN_MAPVO();
    private SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO sysParamElmDynScrnMapDet = new SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO();
    private SYS_DYN_SCREEN_DEFVO sysDynScreenDef = new SYS_DYN_SCREEN_DEFVO();
    
    private String mapTypeDesc;
    private String mapValueDesc;
    private String mapValueConstant;
    private String elementHtmlId;
    //TP#934567 Button Customization Dynamic Screen Action Assignment - Parameter from Grid on Source Screen
    private String fromSource;
    private Date runningDate;
    private String userName;
    
    private String dynamicScreenParamsMapData;
    private BigDecimal dynamicScreenOpId;
    
    private String dynParamTypeDesc;
    
    public SYS_PARAM_ELM_DYN_SCRN_MAPVO getSysParamElmDynScrnMap()
    {
        return sysParamElmDynScrnMap;
    }
    public void setSysParamElmDynScrnMap(SYS_PARAM_ELM_DYN_SCRN_MAPVO sysParamElmDynScrnMap)
    {
        this.sysParamElmDynScrnMap = sysParamElmDynScrnMap;
    }
    public SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO getSysParamElmDynScrnMapDet()
    {
        return sysParamElmDynScrnMapDet;
    }
    public void setSysParamElmDynScrnMapDet(SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO sysParamElmDynScrnMapDet)
    {
        this.sysParamElmDynScrnMapDet = sysParamElmDynScrnMapDet;
    }
    public SYS_DYN_SCREEN_DEFVO getSysDynScreenDef()
    {
        return sysDynScreenDef;
    }
    public void setSysDynScreenDef(SYS_DYN_SCREEN_DEFVO sysDynScreenDef)
    {
        this.sysDynScreenDef = sysDynScreenDef;
    }
    public String getMapTypeDesc()
    {
        return mapTypeDesc;
    }
    public void setMapTypeDesc(String mapTypeDesc)
    {
        this.mapTypeDesc = mapTypeDesc;
    }
    public String getMapValueConstant()
    {
        return mapValueConstant;
    }
    public void setMapValueConstant(String mapValueConstant)
    {
        this.mapValueConstant = mapValueConstant;
    }
    public String getElementHtmlId()
    {
        return elementHtmlId;
    }
    public void setElementHtmlId(String elementHtmlId)
    {
        this.elementHtmlId = elementHtmlId;
    }
    public String getMapValueDesc()
    {
        return mapValueDesc;
    }
    public void setMapValueDesc(String mapValueDesc)
    {
        this.mapValueDesc = mapValueDesc;
    }
    public Date getRunningDate()
    {
        return runningDate;
    }
    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getDynamicScreenParamsMapData()
    {
        return dynamicScreenParamsMapData;
    }
    public void setDynamicScreenParamsMapData(String dynamicScreenParamsMapData)
    {
        this.dynamicScreenParamsMapData = dynamicScreenParamsMapData;
    }
    public BigDecimal getDynamicScreenOpId()
    {
        return dynamicScreenOpId;
    }
    public void setDynamicScreenOpId(BigDecimal dynamicScreenOpId)
    {
        this.dynamicScreenOpId = dynamicScreenOpId;
    }
    public String getDynParamTypeDesc()
    {
	return dynParamTypeDesc;
    }
    public void setDynParamTypeDesc(String dynParamTypeDesc)
    {
	this.dynParamTypeDesc = dynParamTypeDesc;
    }
    public String getFromSource()
    {
        return fromSource;
    }
    public void setFromSource(String fromSource)
    {
        this.fromSource = fromSource;
    }
    
}
