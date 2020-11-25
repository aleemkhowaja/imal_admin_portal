/**
 * Added by Rania Al-Bitar on 09/02/2017
 */

package com.path.dbmaps.vo;
import com.path.lib.vo.BaseVO; 

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class INTER_BRANCH_ACC_DETAILSVO extends BaseVO {
	
	
	/**
     * This field corresponds to the database column INTER_BRANCH_ACC_DETAILS.COMP_CODE
     */
	private BigDecimal COMP_CODE;
	/**
     * This field corresponds to the database column INTER_BRANCH_ACC_DETAILS.ACC_CODE
     */
	private BigDecimal ACC_CODE;
	/**
     * This field corresponds to the database column INTER_BRANCH_ACC_DETAILS.BRANCH_CODE
     */
	private BigDecimal BRANCH_CODE;
	/**
     * This field corresponds to the database column INTER_BRANCH_ACC_DETAILS.GL_CODE
     */
	private BigDecimal GL_CODE;
	/**
     * This field corresponds to the database column INTER_BRANCH_ACC_DETAILS.CIF_SUB_NO
     */
	private BigDecimal CIF_SUB_NO;
	/**
     * This field corresponds to the database column INTER_BRANCH_ACC_DETAILS.SL_NO
     */
	private BigDecimal SL_NO;
	
	public BigDecimal getCOMP_CODE() {
		return COMP_CODE;
	}
	public void setCOMP_CODE(BigDecimal cOMP_CODE) {
		COMP_CODE = cOMP_CODE;
	}
	public BigDecimal getACC_CODE() {
		return ACC_CODE;
	}
	public void setACC_CODE(BigDecimal aCC_CODE) {
		ACC_CODE = aCC_CODE;
	}
	public BigDecimal getBRANCH_CODE() {
		return BRANCH_CODE;
	}
	public void setBRANCH_CODE(BigDecimal bRANCH_CODE) {
		BRANCH_CODE = bRANCH_CODE;
	}
	public BigDecimal getGL_CODE() {
		return GL_CODE;
	}
	public void setGL_CODE(BigDecimal gL_CODE) {
		GL_CODE = gL_CODE;
	}
	public BigDecimal getCIF_SUB_NO() {
		return CIF_SUB_NO;
	}
	public void setCIF_SUB_NO(BigDecimal cIF_SUB_NO) {
		CIF_SUB_NO = cIF_SUB_NO;
	}
	public BigDecimal getSL_NO() {
		return SL_NO;
	}
	public void setSL_NO(BigDecimal sL_NO) {
		SL_NO = sL_NO;
	}
	
	
	
    
}
