/**
 * 
 */
package com.path.vo.common.dynlookup;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DynLookupSC.java used to
 */
public class DynCommonLookupSC extends GridParamsSC
{
    private BigDecimal         screenId;
    private BigDecimal         elementId;
    private String             querySynthax;
    private Map<String,String> elemHm = new HashMap<String,String>();
    private BigDecimal globalActivityId;
    private BigDecimal dynParamType;
    private String             colName;
    private String             propertyCode;
    private String 	       mapType;
    //TP#982174 Add dependency for live search in column properties
    private String             columnCode;
    private String             colValue;
    private String             colDesc;
    /**
     * @return the screenId
     */
    public BigDecimal getScreenId()
    {
        return screenId;
    }
    /**
     * @param screenId the screenId to set
     */
    public void setScreenId(BigDecimal screenId)
    {
        this.screenId = screenId;
    }
    /**
     * @return the elemHm
     */
    public Map<String, String> getElemHm()
    {
        return elemHm;
    }
    /**
     * @param elemHm the elemHm to set
     */
    public void setElemHm(Map<String, String> elemHm)
    {
        this.elemHm = elemHm;
    }
    /**
     * @return the elementId
     */
    public BigDecimal getElementId()
    {
        return elementId;
    }
    /**
     * @param elementId the elementId to set
     */
    public void setElementId(BigDecimal elementId)
    {
        this.elementId = elementId;
    }
    /**
     * @return the querySynthax
     */
    public String getQuerySynthax()
    {
        return querySynthax;
    }
    /**
     * @param querySynthax the querySynthax to set
     */
    public void setQuerySynthax(String querySynthax)
    {
        this.querySynthax = querySynthax;
    }
    /**
     * @return the globalActivityId
     */
    public BigDecimal getGlobalActivityId()
    {
        return globalActivityId;
    }
    /**
     * @param globalActivityId the globalActivityId to set
     */
    public void setGlobalActivityId(BigDecimal globalActivityId)
    {
        this.globalActivityId = globalActivityId;
    }
    public BigDecimal getDynParamType()
    {
	return dynParamType;
    }
    public void setDynParamType(BigDecimal dynParamType)
    {
	this.dynParamType = dynParamType;
    }
    public String getColName()
    {
	return colName;
    }
    public void setColName(String colName)
    {
	this.colName = colName;
    }
    public String getPropertyCode()
    {
        return propertyCode;
    }
    public void setPropertyCode(String propertyCode)
    {
        this.propertyCode = propertyCode;
    }
   
    public String getMapType() {
	return mapType;
    }
    public void setMapType(String mapType) {
	this.mapType = mapType;
    }
    public String getColValue()
    {
        return colValue;
    }
    public void setColValue(String colValue)
    {
        this.colValue = colValue;
    }
    public String getColDesc()
    {
        return colDesc;
    }
    public void setColDesc(String colDesc)
    {
        this.colDesc = colDesc;
    }
    public String getColumnCode()
    {
        return columnCode;
    }
    public void setColumnCode(String columnCode)
    {
        this.columnCode = columnCode;
    }
}
