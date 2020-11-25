package com.path.vo.common.iis.islamiccalculator;

import java.math.BigDecimal;

import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.TRSDEAL_MULTIPLE_YIELDVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: mathew
 * 
 *          TrsdealMultipleYieldCO.java used to
 */
@SuppressWarnings("serial")
public class TrsdealMultipleYieldCO extends BaseVO
{
    private TRSDEAL_MULTIPLE_YIELDVO trsdealMultipleYieldVO;
    private BigDecimal lineNo;
    private BigDecimal totalYield;
    private Boolean fixedFloatingRateYN;
    private TRSCLASSVO trsclassVO;

    public void setTrsdealMultipleYieldVO(TRSDEAL_MULTIPLE_YIELDVO trsdealMultipleYieldVO)
    {
	this.trsdealMultipleYieldVO = trsdealMultipleYieldVO;
    }

    public TRSDEAL_MULTIPLE_YIELDVO getTrsdealMultipleYieldVO()
    {
	return trsdealMultipleYieldVO;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public BigDecimal getTotalYield()
    {
	if(trsdealMultipleYieldVO == null)
	{
	    return BigDecimal.ZERO;
	}
	double totalYieldVal = 0;
	if(trsdealMultipleYieldVO.getMARGIN_RATE() != null)
	{
	    totalYieldVal = totalYieldVal + trsdealMultipleYieldVO.getMARGIN_RATE().doubleValue();
	}
	if(trsdealMultipleYieldVO.getFLOATING_RATE() != null)
	{
	    totalYieldVal = totalYieldVal + trsdealMultipleYieldVO.getFLOATING_RATE().doubleValue();
	}
	totalYield = BigDecimal.valueOf(totalYieldVal);
	return totalYield;
    }

    public void setFixedFloatingRateYN(Boolean fixedFloatingRateYN)
    {
	this.fixedFloatingRateYN = fixedFloatingRateYN;
    }

    public Boolean getFixedFloatingRateYN()
    {
	return fixedFloatingRateYN;
    }

    public TRSCLASSVO getTrsclassVO()
    {
	return trsclassVO;
    }

    public void setTrsclassVO(TRSCLASSVO trsclassVO)
    {
	this.trsclassVO = trsclassVO;
    }

    public void setTotalYield(BigDecimal totalYield)
    {
	this.totalYield = totalYield;
    }

}