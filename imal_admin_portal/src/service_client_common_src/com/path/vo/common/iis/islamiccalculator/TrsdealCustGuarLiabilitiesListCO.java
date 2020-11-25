/**
 * 
 */
package com.path.vo.common.iis.islamiccalculator;

import java.math.BigDecimal;

import com.path.dbmaps.vo.TRSDEAL_CUST_GUAR_LIABLITIESVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: mathew
 * 
 *          TrsdealCustGuarLiabilitiesListCO.java used to
 */
@SuppressWarnings("serial")
public class TrsdealCustGuarLiabilitiesListCO extends BaseVO
{
    TRSDEAL_CUST_GUAR_LIABLITIESVO trsdealCustGuarLiabilitiesVO = new TRSDEAL_CUST_GUAR_LIABLITIESVO();

    private BigDecimal REF_NBR;

    private BigDecimal LINE_NBR;

    private BigDecimal COMP_CODE;

    private BigDecimal BRANCH;

    public TRSDEAL_CUST_GUAR_LIABLITIESVO getTrsdealCustGuarLiabilitiesVO()
    {
	return trsdealCustGuarLiabilitiesVO;
    }

    public void setTrsdealCustGuarLiabilitiesVO(TRSDEAL_CUST_GUAR_LIABLITIESVO trsdealCustGuarLiabilitiesVO)
    {
	this.trsdealCustGuarLiabilitiesVO = trsdealCustGuarLiabilitiesVO;
    }

    public BigDecimal getLINE_NBR()
    {
	return LINE_NBR;
    }

    public void setLINE_NBR(BigDecimal lINENBR)
    {
	LINE_NBR = lINENBR;
    }

    public BigDecimal getREF_NBR()
    {
	return REF_NBR;
    }

    public void setREF_NBR(BigDecimal rEFNBR)
    {
	REF_NBR = rEFNBR;
    }

    public BigDecimal getCOMP_CODE()
    {
	return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMPCODE)
    {
	COMP_CODE = cOMPCODE;
    }

    public BigDecimal getBRANCH()
    {
	return BRANCH;
    }

    public void setBRANCH(BigDecimal bRANCH)
    {
	BRANCH = bRANCH;
    }

}
