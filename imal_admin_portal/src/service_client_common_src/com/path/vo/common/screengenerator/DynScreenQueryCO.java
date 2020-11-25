/**
 * 
 */
package com.path.vo.common.screengenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.path.lib.vo.BaseVO;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DynScreenQueryCO.java used to
 */
public class DynScreenQueryCO extends BaseVO
{
  private String columnCode;
  private String columnDesc;
  private String querySynthax;
  private Boolean colCodeFound;
  private Boolean colDescFound;
  private Map<String,String> queryDataStruct;
  private String elementType;
  private String screenQueryParams;
  private boolean retCond;
  private String tableName;
  private BigDecimal screenId;
  private List<Map<String, Object>> sessionList;
  private Map<String, DynamicScreenCO > screenParamMapValues;
  private String tableDatasource;
  private String screenName;
  //TP#1053820 Additional lookup Description
  private String addLkpDesc;
  private BigDecimal addLkpDescFound;
  private List<String> dynScrElmLst;
  private List<String> dynScreenDetailsLst;
  private String lookupDescription;
public Map<String, String> getQueryDataStruct()
{
    return queryDataStruct;
}
public void setQueryDataStruct(Map<String, String> queryDataStruct)
{
    this.queryDataStruct = queryDataStruct;
}
/**
 * @return the columnCode
 */
public String getColumnCode()
{
    return columnCode;
}
/**
 * @param columnCode the columnCode to set
 */
public void setColumnCode(String columnCode)
{
    this.columnCode = columnCode;
}
/**
 * @return the columnDesc
 */
public String getColumnDesc()
{
    return columnDesc;
}
/**
 * @param columnDesc the columnDesc to set
 */
public void setColumnDesc(String columnDesc)
{
    this.columnDesc = columnDesc;
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
public Boolean getColCodeFound()
{
    return colCodeFound;
}
public void setColCodeFound(Boolean colCodeFound)
{
    this.colCodeFound = colCodeFound;
}
public Boolean getColDescFound()
{
    return colDescFound;
}
public void setColDescFound(Boolean colDescFound)
{
    this.colDescFound = colDescFound;
}
public String getElementType()
{
    return elementType;
}
public void setElementType(String elementType)
{
    this.elementType = elementType;
}
public String getScreenQueryParams()
{
    return screenQueryParams;
}
public void setScreenQueryParams(String screenQueryParams)
{
    this.screenQueryParams = screenQueryParams;
}
public boolean isRetCond()
{
    return retCond;
}
public void setRetCond(boolean retCond)
{
    this.retCond = retCond;
}
public String getTableName()
{
    return tableName;
}
public void setTableName(String tableName)
{
    this.tableName = tableName;
}
public List<Map<String, Object>> getSessionList()
{
    return sessionList;
}
public void setSessionList(List<Map<String, Object>> sessionList)
{
    this.sessionList = sessionList;
}
public Map<String, DynamicScreenCO> getScreenParamMapValues()
{
  return screenParamMapValues;
}
public void setScreenParamMapValues(Map<String, DynamicScreenCO> screenParamMapValues)
{
  this.screenParamMapValues = screenParamMapValues;
}
public BigDecimal getScreenId()
{
  return screenId;
}
public void setScreenId(BigDecimal screenId)
{
  this.screenId = screenId;
}
public String getTableDatasource() {
	return tableDatasource;
}
public void setTableDatasource(String tableDatasource) {
	this.tableDatasource = tableDatasource;
}
public String getScreenName() {
	return screenName;
}
public void setScreenName(String screenName) {
	this.screenName = screenName;
}
public String getAddLkpDesc()
{
    return addLkpDesc;
}
public void setAddLkpDesc(String addLkpDesc)
{
    this.addLkpDesc = addLkpDesc;
}

public List<String> getDynScrElmLst()
{
    return dynScrElmLst;
}
public void setDynScrElmLst(List<String> dynScrElmLst)
{
    this.dynScrElmLst = dynScrElmLst;
}
public List<String> getDynScreenDetailsLst()
{
    return dynScreenDetailsLst;
}
public void setDynScreenDetailsLst(List<String> dynScreenDetailsLst)
{
    this.dynScreenDetailsLst = dynScreenDetailsLst;
}
public BigDecimal getAddLkpDescFound()
{
    return addLkpDescFound;
}
public void setAddLkpDescFound(BigDecimal addLkpDescFound)
{
    this.addLkpDescFound = addLkpDescFound;
}
public String getLookupDescription()
{
    return lookupDescription;
}
public void setLookupDescription(String lookupDescription)
{
    this.lookupDescription = lookupDescription;
}

}
