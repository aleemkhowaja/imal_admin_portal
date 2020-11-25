package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class DEPT_BRVO extends BaseVO{
   private BigDecimal COMP_CODE;
   private BigDecimal DIV_CODE;
   private BigDecimal DEPT_CODE;
   private BigDecimal BRANCH_CODE;
	   
	public BigDecimal getCOMP_CODE() {
		return COMP_CODE;
	}
	public void setCOMP_CODE(BigDecimal cOMP_CODE) {
		COMP_CODE = cOMP_CODE;
	}
	public BigDecimal getDIV_CODE() {
		return DIV_CODE;
	}
	public void setDIV_CODE(BigDecimal dIV_CODE) {
		DIV_CODE = dIV_CODE;
	}
	public BigDecimal getDEPT_CODE() {
		return DEPT_CODE;
	}
	public void setDEPT_CODE(BigDecimal dEPT_CODE) {
		DEPT_CODE = dEPT_CODE;
	}
	public BigDecimal getBRANCH_CODE() {
		return BRANCH_CODE;
	}
	public void setBRANCH_CODE(BigDecimal bRANCH_CODE) {
		BRANCH_CODE = bRANCH_CODE;
	}
	   
	   
}
