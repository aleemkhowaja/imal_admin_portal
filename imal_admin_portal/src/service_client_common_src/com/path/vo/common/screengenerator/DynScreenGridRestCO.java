package com.path.vo.common.screengenerator;

import java.math.BigDecimal;
import java.util.List;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Muhammad.Asif 
 *
 * DynScreenGridRestCO.java used to load rest out parameter 
 */
public class DynScreenGridRestCO extends BaseVO
{
  private BigDecimal elementId; 
  private BigDecimal elementType;
  private String tableDatasource;
  private BigDecimal globalActivityId;
  private BigDecimal restOperationId;
  private BigDecimal operationOutParameter; 
  private String globalActivityDesc;
  private String restOperationDesc;
  private String operationOutParameterDesc;
  private String restOperationOutArgName;
  private List<DynGridOutParameterCO> parameterOutGridData;  
  private List<DynGridParameterCO>  parameterGridData;
  
  private String columnCode;
  private String columnDesc;
  
	public BigDecimal getElementId() {
		return elementId;
	}
	public void setElementId(BigDecimal elementId) {
		this.elementId = elementId;
	}
	public BigDecimal getElementType() {
		return elementType;
	}
	public void setElementType(BigDecimal elementType) {
		this.elementType = elementType;
	}
	public String getTableDatasource() {
		return tableDatasource;
	}
	public void setTableDatasource(String tableDatasource) {
		this.tableDatasource = tableDatasource;
	}
	public BigDecimal getGlobalActivityId() {
		return globalActivityId;
	}
	public void setGlobalActivityId(BigDecimal globalActivityId) {
		this.globalActivityId = globalActivityId;
	}
	public BigDecimal getRestOperationId() {
		return restOperationId;
	}
	public void setRestOperationId(BigDecimal restOperationId) {
		this.restOperationId = restOperationId;
	}
	public BigDecimal getOperationOutParameter() {
		return operationOutParameter;
	}
	public void setOperationOutParameter(BigDecimal operationOutParameter) {
		this.operationOutParameter = operationOutParameter;
	}
	public List<DynGridOutParameterCO> getParameterOutGridData() {
		return parameterOutGridData;
	}
	public void setParameterOutGridData(List<DynGridOutParameterCO> parameterOutGridData) {
		this.parameterOutGridData = parameterOutGridData;
	}
	public List<DynGridParameterCO> getParameterGridData() {
		return parameterGridData;
	}
	public void setParameterGridData(List<DynGridParameterCO> parameterGridData) {
		this.parameterGridData = parameterGridData;
	}
	public String getGlobalActivityDesc() {
		return globalActivityDesc;
	}
	public void setGlobalActivityDesc(String globalActivityDesc) {
		this.globalActivityDesc = globalActivityDesc;
	}
	public String getRestOperationDesc() {
		return restOperationDesc;
	}
	public void setRestOperationDesc(String restOperationDesc) {
		this.restOperationDesc = restOperationDesc;
	}
	public String getOperationOutParameterDesc() {
		return operationOutParameterDesc;
	}
	public void setOperationOutParameterDesc(String operationOutParameterDesc) {
		this.operationOutParameterDesc = operationOutParameterDesc;
	}
	public String getColumnCode() {
		return columnCode;
	}
	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}
	public String getColumnDesc() {
		return columnDesc;
	}
	public void setColumnDesc(String columnDesc) {
		this.columnDesc = columnDesc;
	}
	public String getRestOperationOutArgName() {
		return restOperationOutArgName;
	}
	public void setRestOperationOutArgName(String restOperationOutArgName) {
		this.restOperationOutArgName = restOperationOutArgName;
	}
	
}
