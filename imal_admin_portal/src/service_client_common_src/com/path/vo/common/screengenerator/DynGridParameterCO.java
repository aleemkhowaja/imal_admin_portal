/**
 * 
 */
package com.path.vo.common.screengenerator;

import java.math.BigDecimal;

import com.path.dbmaps.vo.SYS_PARAM_GLOBAL_ACT_ARG_MAPVO;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Muhammad.Asif
 *
 * DynGridParameterCO.java used to load parameter on parameter grid.
 */
public class DynGridParameterCO extends BaseVO
{
 private SYS_PARAM_GLOBAL_ACT_ARG_MAPVO sysParamGlobalActArgMapVO = new SYS_PARAM_GLOBAL_ACT_ARG_MAPVO();
 private String mapDirection; 
 private String opIdDescription;
 private String argDescription; 
 private String apiType; 
 private BigDecimal apiCode;
 private String mapTypeDesc;
 private String screenFldIdDesc ; 
 private String mapDescription ;
 private String dynElemDescription ;
 private String mODIFIED_BYString;
 private String fromSource ; 
 private String dynParamTypeDesc ;
 private String argName;
 
public SYS_PARAM_GLOBAL_ACT_ARG_MAPVO getSysParamGlobalActArgMapVO() {
	return sysParamGlobalActArgMapVO;
}
public void setSysParamGlobalActArgMapVO(SYS_PARAM_GLOBAL_ACT_ARG_MAPVO sysParamGlobalActArgMapVO) {
	this.sysParamGlobalActArgMapVO = sysParamGlobalActArgMapVO;
}
public String getMapDirection() {
	return mapDirection;
}
public void setMapDirection(String mapDirection) {
	this.mapDirection = mapDirection;
}
public String getOpIdDescription() {
	return opIdDescription;
}
public void setOpIdDescription(String opIdDescription) {
	this.opIdDescription = opIdDescription;
}
public String getArgDescription() {
	return argDescription;
}
public void setArgDescription(String argDescription) {
	this.argDescription = argDescription;
}
public String getApiType() {
	return apiType;
}
public void setApiType(String apiType) {
	this.apiType = apiType;
}
public BigDecimal getApiCode() {
	return apiCode;
}
public void setApiCode(BigDecimal apiCode) {
	this.apiCode = apiCode;
}
public String getMapTypeDesc() {
	return mapTypeDesc;
}
public void setMapTypeDesc(String mapTypeDesc) {
	this.mapTypeDesc = mapTypeDesc;
}
public String getScreenFldIdDesc() {
	return screenFldIdDesc;
}
public void setScreenFldIdDesc(String screenFldIdDesc) {
	this.screenFldIdDesc = screenFldIdDesc;
}
public String getMapDescription() {
	return mapDescription;
}
public void setMapDescription(String mapDescription) {
	this.mapDescription = mapDescription;
}
public String getDynElemDescription() {
	return dynElemDescription;
}
public void setDynElemDescription(String dynElemDescription) {
	this.dynElemDescription = dynElemDescription;
}
public String getmODIFIED_BYString() {
	return mODIFIED_BYString;
}
public void setmODIFIED_BYString(String mODIFIED_BYString) {
	this.mODIFIED_BYString = mODIFIED_BYString;
}
public String getFromSource() {
	return fromSource;
}
public void setFromSource(String fromSource) {
	this.fromSource = fromSource;
}
public String getDynParamTypeDesc() {
	return dynParamTypeDesc;
}
public void setDynParamTypeDesc(String dynParamTypeDesc) {
	this.dynParamTypeDesc = dynParamTypeDesc;
}
public String getArgName() {
	return argName;
}
public void setArgName(String argName) {
	this.argName = argName;
}    
}
