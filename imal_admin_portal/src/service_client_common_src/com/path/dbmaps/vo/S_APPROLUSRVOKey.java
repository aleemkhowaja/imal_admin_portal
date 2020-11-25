package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class S_APPROLUSRVOKey extends BaseVO {

	private String USER_ID;
	private String APP_NAME;
	private String ROLE_NAME;
	private BigDecimal COMP_CODE;
	private BigDecimal BRANCH_CODE;
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		this.USER_ID = uSER_ID == null ? null : uSER_ID.trim();
	}
	
	public String getAPP_NAME() {
		return APP_NAME;
	}
	public void setAPP_NAME(String aPP_NAME) {
		this.APP_NAME = aPP_NAME == null ? null : aPP_NAME.trim();
	}
	
	public String getROLE_NAME() {
		return ROLE_NAME;
	}
	public void setROLE_NAME(String rOLE_NAME) {
		this.ROLE_NAME = rOLE_NAME == null ? null : rOLE_NAME.trim();
	}
	
	public BigDecimal getCOMP_CODE() {
		return COMP_CODE;
	}
	public void setCOMP_CODE(BigDecimal cOMP_CODE) {
		COMP_CODE = cOMP_CODE;
	}
	public BigDecimal getBRANCH_CODE() {
		return BRANCH_CODE;
	}
	public void setBRANCH_CODE(BigDecimal bRANCH_CODE) {
		BRANCH_CODE = bRANCH_CODE;
	}
	
	
}
