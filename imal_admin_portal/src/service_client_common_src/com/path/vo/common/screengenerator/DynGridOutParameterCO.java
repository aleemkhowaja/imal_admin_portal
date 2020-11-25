/**
 * 
 */
package com.path.vo.common.screengenerator;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Muhammad.Asif 
 *
 * DynGridOutParameterCO.java used to handle out parameter grid 
 */
public class DynGridOutParameterCO extends BaseVO
{	
  private String colDataType;
  private String colDescription;
  private String colFormat;
  private String colTechName;
  private String restListProperties;
  
public String getColDataType() {
	return colDataType;
}
public void setColDataType(String colDataType) {
	this.colDataType = colDataType;
}
public String getColDescription() {
	return colDescription;
}
public void setColDescription(String colDescription) {
	this.colDescription = colDescription;
}
public String getColFormat() {
	return colFormat;
}
public void setColFormat(String colFormat) {
	this.colFormat = colFormat;
}
public String getColTechName() {
	return colTechName;
}
public void setColTechName(String colTechName) {
	this.colTechName = colTechName;
}
public String getRestListProperties() {
	return restListProperties;
}
public void setRestListProperties(String restListProperties) {
	this.restListProperties = restListProperties;
}
  
  
      
}
