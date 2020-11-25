package com.path.vo.reporting;

import com.path.dbmaps.vo.IRP_REP_PROC_PARAMSVO;

public class IRP_REP_PROC_PARAMSCO extends IRP_REP_PROC_PARAMSVO
{
	private String PARAM_TYPE;
	private String PROC_NAME;
	private String QRY_PARAM_NAME;
	private String PARAM_VALUE;
	private String PARAM_IN_OUT;

	public String getPARAM_VALUE() {
		return PARAM_VALUE;
	}
	public void setPARAM_VALUE(String pARAMVALUE) {
		PARAM_VALUE = pARAMVALUE;
	}
	public String getPARAM_TYPE() {
		return PARAM_TYPE;
	}
	public void setPARAM_TYPE(String pARAMTYPE) {
		PARAM_TYPE = pARAMTYPE;
	}
	public String getPROC_NAME() {
		return PROC_NAME;
	}
	public void setPROC_NAME(String pROCNAME) {
		PROC_NAME = pROCNAME;
	}
	public String getQRY_PARAM_NAME() {
		return QRY_PARAM_NAME;
	}
	public void setQRY_PARAM_NAME(String qRYPARAMNAME) {
		QRY_PARAM_NAME = qRYPARAMNAME;
	}
	
	public String getPARAM_IN_OUT() {
		return PARAM_IN_OUT;
	}
	public void setPARAM_IN_OUT(String pARAMINOUT) {
		PARAM_IN_OUT = pARAMINOUT;
	}
	
	
	
}
