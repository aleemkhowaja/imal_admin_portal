package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;



public class OPT_SERIESVO extends BaseVO{
	private String APP_NAME;
	private String PROG_REF;
	private String SUFFIX;
	private String PREFIX;
	
	
	public String getAPP_NAME() {
		return APP_NAME;
	}
	
	public void setAPP_NAME(String aPP_NAME) {
		APP_NAME = aPP_NAME;
	}
	
	public String getPROG_REF() {
		return PROG_REF;
	}
	
	public void setPROG_REF(String pROG_REF) {
		PROG_REF = pROG_REF;
	}
	
	public String getSUFFIX() {
		return SUFFIX;
	}
	
	public void setSUFFIX(String sUFFIX) {
		SUFFIX = sUFFIX;
	}
	
	public String getPREFIX() {
		return PREFIX;
	}
	
	public void setPREFIX(String pREFIX) {
		PREFIX = pREFIX;
	}
	
}
