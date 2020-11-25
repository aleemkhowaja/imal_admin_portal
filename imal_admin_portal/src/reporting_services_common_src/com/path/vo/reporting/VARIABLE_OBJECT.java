package com.path.vo.reporting;

import java.io.Serializable;

public class VARIABLE_OBJECT implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1666454684149289117L;
	
	private String varName;
	private String varClass;
	private String calculation;
	private String resetType;
	private String expression;
	private int qryIndex;
	private String feName;
	
	public String getVarName() {
		return varName;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public String getVarClass() {
		return varClass;
	}
	public void setVarClass(String varClass) {
		this.varClass = varClass;
	}
	public String getCalculation() {
		return calculation;
	}
	public void setCalculation(String calculation) {
		this.calculation = calculation;
	}
	public String getResetType() {
		return resetType;
	}
	public void setResetType(String resetType) {
		this.resetType = resetType;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public int getQryIndex() {
		return qryIndex;
	}
	public void setQryIndex(int qryIndex) {
		this.qryIndex = qryIndex;
	}
	public String getFeName() {
		return feName;
	}
	public void setFeName(String feName) {
		this.feName = feName;
	}
}
