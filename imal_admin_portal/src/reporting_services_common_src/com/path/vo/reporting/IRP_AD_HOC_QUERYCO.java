package com.path.vo.reporting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.IRP_AD_HOC_QUERYVO;
import com.path.dbmaps.vo.IRP_REPORT_QUERYVOKey;

public class IRP_AD_HOC_QUERYCO extends IRP_AD_HOC_QUERYVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2927957696661565712L;
	private SQL_OBJECT sqlObject = new SQL_OBJECT();
	private StringBuffer sqlSyntax;
	private IRP_REPORT_QUERYVOKey reportQueryVO;
	private List<VARIABLE_OBJECT> variablesList = new ArrayList<VARIABLE_OBJECT>();
	private int index;
	private boolean update;
	//private String isQryArg;
	private BigDecimal isQryArg;
	
	private String grpByQryName;
	
	public String getGrpByQryName() {
		return grpByQryName;
	}

	public void setGrpByQryName(String grpByQryName) {
		this.grpByQryName = grpByQryName;
	}

	
	
//	public String getIsQryArg()
//	{
//	    return isQryArg;
//	}
//
//	public void setIsQryArg(String isQryArg)
//	{
//	    this.isQryArg = isQryArg;
//	}

	public BigDecimal getIsQryArg()
	{
	    return isQryArg;
	}

	public void setIsQryArg(BigDecimal isQryArg)
	{
	    this.isQryArg = isQryArg;
	}

	public SQL_OBJECT getSqlObject() {
		return sqlObject;
	}

	public void setSqlObject(SQL_OBJECT sqlObject) {
		this.sqlObject = sqlObject;
	}
	
	public StringBuffer getSqlSyntax() {
		return sqlSyntax;
	}

	public void setSqlSyntax(StringBuffer sqlSyntax) {
		this.sqlSyntax = sqlSyntax;
	}

	public IRP_REPORT_QUERYVOKey getReportQueryVO() {
		return reportQueryVO;
	}

	public void setReportQueryVO(IRP_REPORT_QUERYVOKey reportQueryVO) {
		this.reportQueryVO = reportQueryVO;
	}

	public List<VARIABLE_OBJECT> getVariablesList() {
		return variablesList;
	}

	public void setVariablesList(List<VARIABLE_OBJECT> variablesList) {
		this.variablesList = variablesList;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean getUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}
}
