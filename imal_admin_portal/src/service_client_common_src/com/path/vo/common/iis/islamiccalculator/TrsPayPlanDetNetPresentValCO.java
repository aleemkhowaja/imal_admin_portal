/**
 * 
 */
package com.path.vo.common.iis.islamiccalculator;

import java.math.BigDecimal;

import com.path.dbmaps.vo.TRSPAYPLANDET_NET_PRESENT_VALVO;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2018, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * TrsPayPlanDetNetPresentValCO.java used to
 */
public class TrsPayPlanDetNetPresentValCO extends BaseVO
{
    private TRSPAYPLANDET_NET_PRESENT_VALVO trsPayPlanDetNetPresentValVO = new TRSPAYPLANDET_NET_PRESENT_VALVO();;
    private BigDecimal dealCurrencyDecimal;
    private String npvSelected;

    public TRSPAYPLANDET_NET_PRESENT_VALVO getTrsPayPlanDetNetPresentValVO()
    {
	return trsPayPlanDetNetPresentValVO;
    }

    public void setTrsPayPlanDetNetPresentValVO(TRSPAYPLANDET_NET_PRESENT_VALVO trsPayPlanDetNetPresentValVO)
    {
	this.trsPayPlanDetNetPresentValVO = trsPayPlanDetNetPresentValVO;
    }

    public BigDecimal getDealCurrencyDecimal()
    {
	return dealCurrencyDecimal;
    }

    public void setDealCurrencyDecimal(BigDecimal dealCurrencyDecimal)
    {
	this.dealCurrencyDecimal = dealCurrencyDecimal;
    }

    public String getNpvSelected()
    {
	return npvSelected;
    }

    public void setNpvSelected(String npvSelected)
    {
	this.npvSelected = npvSelected;
    }

}
