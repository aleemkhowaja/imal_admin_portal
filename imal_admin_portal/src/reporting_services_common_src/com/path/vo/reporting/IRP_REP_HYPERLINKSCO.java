package com.path.vo.reporting;

import com.path.dbmaps.vo.IRP_REP_HYPERLINKSVO;
import com.path.lib.vo.BaseVO;

public class IRP_REP_HYPERLINKSCO  extends BaseVO 
{
	private String REPORT_NAME;
	private String LINKED_REP_NAME;
	private IRP_REP_HYPERLINKSVO hyperlinkVO=new IRP_REP_HYPERLINKSVO();
	private String HYPERLINK_PARAMS;
	//private Long FIELD_INDEX;
	private String ARGUMENT_NAME;
	private String PARAM_TYPE;
	private String SAVE_FLAG;
	private String LINKED_PROG_REF;
	private String DATE_UPDATED_STR;
	private String PARAM_DELETE;
	
	public String getPARAM_DELETE() {
		return PARAM_DELETE;
	}
	public void setPARAM_DELETE(String pARAMDELETE) {
		PARAM_DELETE = pARAMDELETE;
	}
	public String getDATE_UPDATED_STR() {
		return DATE_UPDATED_STR;
	}
	public void setDATE_UPDATED_STR(String dATEUPDATEDSTR) {
		DATE_UPDATED_STR = dATEUPDATEDSTR;
	}
	public String getLINKED_PROG_REF() {
		return LINKED_PROG_REF;
	}
	public void setLINKED_PROG_REF(String lINKEDPROGREF) {
		LINKED_PROG_REF = lINKEDPROGREF;
	}
	public String getSAVE_FLAG() {
		return SAVE_FLAG;
	}
	public void setSAVE_FLAG(String sAVEFLAG) {
		SAVE_FLAG = sAVEFLAG;
	}
	public String getPARAM_TYPE() {
		return PARAM_TYPE;
	}
	public void setPARAM_TYPE(String pARAMTYPE) {
		PARAM_TYPE = pARAMTYPE;
	}
	public String getARGUMENT_NAME() {
		return ARGUMENT_NAME;
	}
	public void setARGUMENT_NAME(String aRGUMENTNAME) {
		ARGUMENT_NAME = aRGUMENTNAME;
	}
//	public Long getFIELD_INDEX() {
//		return FIELD_INDEX;
//	}
//	public void setFIELD_INDEX(Long fIELDINDEX) {
//		FIELD_INDEX = fIELDINDEX;
//	}
	public String getHYPERLINK_PARAMS() {
		return HYPERLINK_PARAMS;
	}
	public void setHYPERLINK_PARAMS(String hYPERLINKPARAMS) {
		HYPERLINK_PARAMS = hYPERLINKPARAMS;
	}
	public String getREPORT_NAME() {
		return REPORT_NAME;
	}
	public void setREPORT_NAME(String rEPORTNAME) {
		REPORT_NAME = rEPORTNAME;
	}
	public String getLINKED_REP_NAME() {
		return LINKED_REP_NAME;
	}
	public void setLINKED_REP_NAME(String lINKEDREPNAME) {
		LINKED_REP_NAME = lINKEDREPNAME;
	}
	public IRP_REP_HYPERLINKSVO getHyperlinkVO() {
		return hyperlinkVO;
	}
	public void setHyperlinkVO(IRP_REP_HYPERLINKSVO hyperlinkVO) {
		this.hyperlinkVO = hyperlinkVO;
	}
	
}
