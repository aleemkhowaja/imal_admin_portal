package com.path.vo.common.iis.islamiccalculator;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.TRSDEAL_SETTLEMENT_CHARGESVO;

public class TrsDealSettlementChargesCO extends TRSDEAL_SETTLEMENT_CHARGESVO
{
    private String lsBriefNameeng;
    private BigDecimal dealChargesFormat;
    private String dealChargesFormat_baseCy;
    private String dealChargesFormat_chargeCy;
    private String ALLOW_EDIT;
    private Date valueDate;

    // BAJI200023 Fawas.kuruvakkottil 20/10/2020
    private String ALLOW_EDIT_TEMPLATE_CODE;
    private BigDecimal flatAmount;

    public BigDecimal getDealChargesFormat()
    {
	return dealChargesFormat;
    }

    public void setDealChargesFormat(BigDecimal dealChargesFormat)
    {
	this.dealChargesFormat = dealChargesFormat;
    }

    public String getLsBriefNameeng()
    {
	return lsBriefNameeng;
    }

    public void setLsBriefNameeng(String lsBriefNameeng)
    {
	this.lsBriefNameeng = lsBriefNameeng;
    }

    public String getDealChargesFormat_baseCy()
    {
	return dealChargesFormat_baseCy;
    }

    public void setDealChargesFormat_baseCy(String dealChargesFormatBaseCy)
    {
	dealChargesFormat_baseCy = dealChargesFormatBaseCy;
    }

    public String getDealChargesFormat_chargeCy()
    {
	return dealChargesFormat_chargeCy;
    }

    public void setDealChargesFormat_chargeCy(String dealChargesFormatChargeCy)
    {
	dealChargesFormat_chargeCy = dealChargesFormatChargeCy;
    }

    public String getALLOW_EDIT()
    {
	return ALLOW_EDIT;
    }

    public void setALLOW_EDIT(String aLLOWEDIT)
    {
	ALLOW_EDIT = aLLOWEDIT;
    }

    public Date getValueDate()
    {
	return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public String getALLOW_EDIT_TEMPLATE_CODE()
    {
	return ALLOW_EDIT_TEMPLATE_CODE;
    }

    public void setALLOW_EDIT_TEMPLATE_CODE(String aLLOW_EDIT_TEMPLATE_CODE)
    {
	ALLOW_EDIT_TEMPLATE_CODE = aLLOW_EDIT_TEMPLATE_CODE;
    }

    public BigDecimal getFlatAmount()
    {
	return flatAmount;
    }

    public void setFlatAmount(BigDecimal flatAmount)
    {
	this.flatAmount = flatAmount;
    }

}
