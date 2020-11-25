package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

public class SADS_RESTRICTION_DEFINITIONVO extends BaseVO {
	
	private BigDecimal RESTRICTION_CODE;
	
	private String RESTRICTION_NAME;
	
	private String STATUS;	
	
	private String CREATED_BY;
	
	private Date CREATED_DATE;
	
	private String MODIFIED_BY;
	
	private Date MODIFIED_DATE;
	
	private String APPROVED_BY;
	
	private Date APPROVED_DATE;
	



	public BigDecimal getRESTRICTION_CODE() {
		return RESTRICTION_CODE;
	}

	public void setRESTRICTION_CODE(BigDecimal rESTRICTION_CODE) {
		RESTRICTION_CODE = rESTRICTION_CODE;
	}

	public String getRESTRICTION_NAME() {
		return RESTRICTION_NAME;
	}

	public void setRESTRICTION_NAME(String rESTRICTION_NAME) {
		RESTRICTION_NAME = rESTRICTION_NAME;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getCREATED_BY() {
		return CREATED_BY;
	}

	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	public Date getCREATED_DATE() {
		return CREATED_DATE;
	}

	public void setCREATED_DATE(Date cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}

	public String getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	public void setMODIFIED_BY(String mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	public Date getMODIFIED_DATE() {
		return MODIFIED_DATE;
	}

	public void setMODIFIED_DATE(Date mODIFIED_DATE) {
		MODIFIED_DATE = mODIFIED_DATE;
	}

	public String getAPPROVED_BY() {
		return APPROVED_BY;
	}

	public void setAPPROVED_BY(String aPPROVED_BY) {
		APPROVED_BY = aPPROVED_BY;
	}

	public Date getAPPROVED_DATE() {
		return APPROVED_DATE;
	}

	public void setAPPROVED_DATE(Date aPPROVED_DATE) {
		APPROVED_DATE = aPPROVED_DATE;
	}

	


}
