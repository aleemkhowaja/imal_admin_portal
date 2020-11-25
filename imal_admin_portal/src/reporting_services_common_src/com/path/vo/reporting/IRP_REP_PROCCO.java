package com.path.vo.reporting;

import java.math.BigDecimal;

import com.path.dbmaps.vo.IRP_REP_PROCVO;

public class IRP_REP_PROCCO  extends IRP_REP_PROCVO
{
	private String PROC_NAME;
	private String PROC_DESC;
	private String PROC_PARAMS;
	private BigDecimal SYS_PROC_ID;
	
	public BigDecimal getSYS_PROC_ID() {
		return SYS_PROC_ID;
	}
	public void setSYS_PROC_ID(BigDecimal sYSPROCID) {
		SYS_PROC_ID = sYSPROCID;
	}
	public String getPROC_PARAMS() {
		return PROC_PARAMS;
	}
	public void setPROC_PARAMS(String pROCPARAMS) {
		PROC_PARAMS = pROCPARAMS;
	}
	public String getPROC_NAME() {
		return PROC_NAME;
	}
	public void setPROC_NAME(String pROCNAME) {
		PROC_NAME = pROCNAME;
	}
	public String getPROC_DESC() {
		return PROC_DESC;
	}
	public void setPROC_DESC(String pROCDESC) {
		PROC_DESC = pROCDESC;
	}
	
	
}
