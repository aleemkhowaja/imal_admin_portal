package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

/**
 * Date Created: 25/02/2017
 * @author raniaalbitar
 *	
 */
public class REGIONSVO extends BaseVO{
			
	
	private BigDecimal REGION_CODE;
	private String BRIEF_DESC_ENG;
	private String LONG_DESC_ENG;
	private String BRIEF_DESC_AR;
	private String LONG_DESC_AR;
	private BigDecimal TIME_ZONE;
	private String ADDITIONAL_REF;
	private String HOL1;
	private String HOL2;
	private String HOL3;
	private String HOL4;
	private Date DATE_UPDATED;
	
	public BigDecimal getREGION_CODE() {
		return REGION_CODE;
	}
	public void setREGION_CODE(BigDecimal rEGION_CODE) {
		REGION_CODE = rEGION_CODE;
	}
	public String getBRIEF_DESC_ENG() {
		return BRIEF_DESC_ENG;
	}
	public void setBRIEF_DESC_ENG(String bRIEF_DESC_ENG) {
		BRIEF_DESC_ENG = bRIEF_DESC_ENG;
	}
	public String getLONG_DESC_ENG() {
		return LONG_DESC_ENG;
	}
	public void setLONG_DESC_ENG(String lONG_DESC_ENG) {
		LONG_DESC_ENG = lONG_DESC_ENG;
	}
	public String getLONG_DESC_AR() {
		return LONG_DESC_AR;
	}
	public void setLONG_DESC_AR(String lONG_DESC_AR) {
		LONG_DESC_AR = lONG_DESC_AR;
	}
	public BigDecimal getTIME_ZONE() {
		return TIME_ZONE;
	}
	public void setTIME_ZONE(BigDecimal tIME_ZONE) {
		TIME_ZONE = tIME_ZONE;
	}
	public String getADDITIONAL_REF() {
		return ADDITIONAL_REF;
	}
	public void setADDITIONAL_REF(String aDDITIONAL_REF) {
		ADDITIONAL_REF = aDDITIONAL_REF;
	}
	public String getHOL1() {
		return HOL1;
	}
	public void setHOL1(String hOL1) {
		HOL1 = hOL1;
	}
	public String getHOL2() {
		return HOL2;
	}
	public void setHOL2(String hOL2) {
		HOL2 = hOL2;
	}
	public String getHOL3() {
		return HOL3;
	}
	public void setHOL3(String hOL3) {
		HOL3 = hOL3;
	}
	public String getHOL4() {
		return HOL4;
	}
	public void setHOL4(String hOL4) {
		HOL4 = hOL4;
	}
	public String getBRIEF_DESC_AR() {
		return BRIEF_DESC_AR;
	}
	public void setBRIEF_DESC_AR(String bRIEF_DESC_AR) {
		BRIEF_DESC_AR = bRIEF_DESC_AR;
	}
	
	public Date getDATE_UPDATED()
	{
		return DATE_UPDATED;
	}
	
	public void setDATE_UPDATED(Date dATE_UPDATED)
	{
		DATE_UPDATED = dATE_UPDATED;
	}
	
	
				
}
