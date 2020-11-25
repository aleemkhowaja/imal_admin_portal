package com.path.vo.reporting;

import java.io.Serializable;
import java.util.HashMap;

public class CommonReportingSessionCO implements Serializable
{
	private IRP_AD_HOC_REPORTCO reportCO;
	private SQL_OBJECT sqlObj;
	private HashMap<String,HashMap<String,Object>> fileExpImpParamsMap = new HashMap<String, HashMap<String,Object>>();
	
	/**
	 * @return the fileExpImpParamsMap
	 */
	public HashMap<String, HashMap<String, Object>> getFileExpImpParamsMap()
	{
	    return fileExpImpParamsMap;
	}

	/**
	 * @param fileExpImpParamsMap the fileExpImpParamsMap to set
	 */
	public void setFileExpImpParamsMap(HashMap<String, HashMap<String, Object>> fileExpImpParamsMap)
	{
	    this.fileExpImpParamsMap = fileExpImpParamsMap;
	}
	public IRP_AD_HOC_REPORTCO getReportCO() {
		return reportCO;
	}
	public void setReportCO(IRP_AD_HOC_REPORTCO reportCO) {
		this.reportCO = reportCO;
	}
	public SQL_OBJECT getSqlObj() {
		return sqlObj;
	}
	public void setSqlObj(SQL_OBJECT sqlObj) {
		this.sqlObj = sqlObj;
	}

}
