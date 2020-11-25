package com.path.vo.common.iis.islamiccalculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.TRSDEAL_COUNTRY_HOLIDAYVO;
import com.path.lib.vo.BaseVO;

public class IISHolidayCheckCO extends BaseVO implements Serializable
{
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private Date date;
    private BigDecimal currencyCode;
    private BigDecimal actionCode;
    private String dateType;
    private String maturityDateBeforeHolidayMonthEnd;
    private String ApplyYearHoliday;
    private String holidayMessageAction;
    private BigDecimal productClassCode;
    private Date newDate;
    private String holidayYn;
    private String holidayActionDealValueDate = "N";
    private Date dealValueDate;
    private Date systemDate;

    private String checkCountryHoliday = "Y";
    private String CheckCurrencyHoliday = "Y";
    private String globalConfirmationFrom;
    private String isBusinessDays;
    private String dateFormater;

    private Date NEW_VALUE_DATE;
    private Date NEW_MATURITY_DATE;
    private Date NEW_SALES_DATE;
    private Date NEW_DELIVERY_DATE;

    public Date getSystemDate()
    {
	return systemDate;
    }

    public void setSystemDate(Date systemDate)
    {
	this.systemDate = systemDate;
    }

    public Date getDealValueDate()
    {
	return dealValueDate;
    }

    public void setDealValueDate(Date dealValueDate)
    {
	this.dealValueDate = dealValueDate;
    }

    public String getHolidayActionDealValueDate()
    {
	return holidayActionDealValueDate;
    }

    public void setHolidayActionDealValueDate(String holidayActionDealValueDate)
    {
	this.holidayActionDealValueDate = holidayActionDealValueDate;
    }

    public Date getNewDate()
    {
	return newDate;
    }

    public void setNewDate(Date newDate)
    {
	this.newDate = newDate;
    }

    public String getHolidayYn()
    {
	return holidayYn;
    }

    public void setHolidayYn(String holidayYn)
    {
	this.holidayYn = holidayYn;
    }

    public BigDecimal getProductClassCode()
    {
	return productClassCode;
    }

    public void setProductClassCode(BigDecimal productClassCode)
    {
	this.productClassCode = productClassCode;
    }

    public String getHolidayMessageAction()
    {
	return holidayMessageAction;
    }

    public void setHolidayMessageAction(String holidayMessageAction)
    {
	this.holidayMessageAction = holidayMessageAction;
    }

    List<TRSDEAL_COUNTRY_HOLIDAYVO> TrsdealCountryHolidayList = new ArrayList<TRSDEAL_COUNTRY_HOLIDAYVO>();

    public String getApplyYearHoliday()
    {
	return ApplyYearHoliday;
    }

    public void setApplyYearHoliday(String applyYearHoliday)
    {
	ApplyYearHoliday = applyYearHoliday;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public Date getDate()
    {
	return date;
    }

    public void setDate(Date date)
    {
	this.date = date;
    }

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    public BigDecimal getActionCode()
    {
	return actionCode;
    }

    public void setActionCode(BigDecimal actionCode)
    {
	this.actionCode = actionCode;
    }

    public String getDateType()
    {
	return dateType;
    }

    public void setDateType(String dateType)
    {
	this.dateType = dateType;
    }

    public String getMaturityDateBeforeHolidayMonthEnd()
    {
	return maturityDateBeforeHolidayMonthEnd;
    }

    public void setMaturityDateBeforeHolidayMonthEnd(String maturityDateBeforeHolidayMonthEnd)
    {
	this.maturityDateBeforeHolidayMonthEnd = maturityDateBeforeHolidayMonthEnd;
    }

    public List<TRSDEAL_COUNTRY_HOLIDAYVO> getTrsdealCountryHolidayList()
    {
	return TrsdealCountryHolidayList;
    }

    public void setTrsdealCountryHolidayList(List<TRSDEAL_COUNTRY_HOLIDAYVO> trsdealCountryHolidayList)
    {
	TrsdealCountryHolidayList = trsdealCountryHolidayList;
    }

    public String getCheckCountryHoliday()
    {
	return checkCountryHoliday;
    }

    public void setCheckCountryHoliday(String checkCountryHoliday)
    {
	this.checkCountryHoliday = checkCountryHoliday;
    }

    public String getCheckCurrencyHoliday()
    {
	return CheckCurrencyHoliday;
    }

    public void setCheckCurrencyHoliday(String checkCurrencyHoliday)
    {
	CheckCurrencyHoliday = checkCurrencyHoliday;
    }

    public String getGlobalConfirmationFrom()
    {
	return globalConfirmationFrom;
    }

    public void setGlobalConfirmationFrom(String globalConfirmationFrom)
    {
	this.globalConfirmationFrom = globalConfirmationFrom;
    }

    public String getIsBusinessDays()
    {
	return isBusinessDays;
    }

    public void setIsBusinessDays(String isBusinessDays)
    {
	this.isBusinessDays = isBusinessDays;
    }

    public String getDateFormater()
    {
	return dateFormater;
    }

    public void setDateFormater(String dateFormater)
    {
	this.dateFormater = dateFormater;
    }

    public Date getNEW_VALUE_DATE()
    {
	return NEW_VALUE_DATE;
    }

    public void setNEW_VALUE_DATE(Date nEWVALUEDATE)
    {
	NEW_VALUE_DATE = nEWVALUEDATE;
    }

    public Date getNEW_MATURITY_DATE()
    {
	return NEW_MATURITY_DATE;
    }

    public void setNEW_MATURITY_DATE(Date nEWMATURITYDATE)
    {
	NEW_MATURITY_DATE = nEWMATURITYDATE;
    }

    public Date getNEW_SALES_DATE()
    {
	return NEW_SALES_DATE;
    }

    public void setNEW_SALES_DATE(Date nEWSALESDATE)
    {
	NEW_SALES_DATE = nEWSALESDATE;
    }

    public Date getNEW_DELIVERY_DATE()
    {
	return NEW_DELIVERY_DATE;
    }

    public void setNEW_DELIVERY_DATE(Date nEWDELIVERYDATE)
    {
	NEW_DELIVERY_DATE = nEWDELIVERYDATE;
    }

}
