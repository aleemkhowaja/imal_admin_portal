package com.path.vo.admin.countries;

import java.math.BigDecimal;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

public class CountriesSC extends GridParamsSC
{
    private BigDecimal countryCode;
    private String language;
    private List<BigDecimal> countryList;
    private BigDecimal trsCy;
    private BigDecimal trsAmountFc;
    private String checkEnabled;// used to set the check enabled in COUNTRIES_LIMIT_CIF
    private String countryLimitStatus;// used to set the stattus in COUNTRIES_LIMIT_CIF.Status
    private String countryLimitTrsStatus;// used to set the stattus in
    // COUNTRIES_LIMIT_CIF_TRS.Status
    private BigDecimal cifNo; // used to set the cif no
    private BigDecimal crossRate; // used to set the cross rate to calculate the fc amount of
    // utilzed country cif
    private String groupByCntry; // used to group the sum by country since by default it's by CIF
    private String whereStatus;// used to set where status while updating COUNTRIES_LIMIT_CIF_TRS
    private String status;// used to set where status while updating COUNTRIES_LIMIT_CIF_TRS
    private BigDecimal code;// used to set Code in COUNTRIES_LIMIT_CIF_TRS
    private String countryLimitAction;// /used to set 'APPROVE' 'REVERSE' 'DELETE' 'CANCEL' 'CLOSE'
                                      // 'CLOSE-REVERSE'

    private String amndInd;
    private String codeISO;//COUNTRIES.ISO_COUNTRY
    
    private String isoCountryNoNull; // used to get the list of countries with ISO_COUNTRY not null
    private BigDecimal trxType;

    public BigDecimal getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(BigDecimal countryCode)
    {
        this.countryCode = countryCode;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public List<BigDecimal> getCountryList()
    {
        return countryList;
    }

    public void setCountryList(List<BigDecimal> countryList)
    {
        this.countryList = countryList;
    }

    public BigDecimal getTrsCy()
    {
        return trsCy;
    }

    public void setTrsCy(BigDecimal trsCy)
    {
        this.trsCy = trsCy;
    }

    public String getCheckEnabled()
    {
        return checkEnabled;
    }

    public void setCheckEnabled(String checkEnabled)
    {
        this.checkEnabled = checkEnabled;
    }

    public String getCountryLimitStatus()
    {
        return countryLimitStatus;
    }

    public void setCountryLimitStatus(String countryLimitStatus)
    {
        this.countryLimitStatus = countryLimitStatus;
    }

    public String getCountryLimitTrsStatus()
    {
        return countryLimitTrsStatus;
    }

    public void setCountryLimitTrsStatus(String countryLimitTrsStatus)
    {
        this.countryLimitTrsStatus = countryLimitTrsStatus;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public BigDecimal getCrossRate()
    {
        return crossRate;
    }

    public void setCrossRate(BigDecimal crossRate)
    {
        this.crossRate = crossRate;
    }

    public String getGroupByCntry()
    {
        return groupByCntry;
    }

    public void setGroupByCntry(String groupByCntry)
    {
        this.groupByCntry = groupByCntry;
    }

    public String getWhereStatus()
    {
        return whereStatus;
    }

    public void setWhereStatus(String whereStatus)
    {
        this.whereStatus = whereStatus;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public BigDecimal getCode()
    {
        return code;
    }

    public void setCode(BigDecimal code)
    {
        this.code = code;
    }

    public String getCountryLimitAction()
    {
        return countryLimitAction;
    }

    public void setCountryLimitAction(String countryLimitAction)
    {
        this.countryLimitAction = countryLimitAction;
    }

    public BigDecimal getTrsAmountFc()
    {
        return trsAmountFc;
    }

    public void setTrsAmountFc(BigDecimal trsAmountFc)
    {
        this.trsAmountFc = trsAmountFc;
    }

    public String getAmndInd()
    {
        return amndInd;
    }

    public void setAmndInd(String amndInd)
    {
        this.amndInd = amndInd;
    }

    /**
     * @return the codeISO
     */
    public String getCodeISO()
    {
        return codeISO;
    }

    /**
     * @param codeISO the codeISO to set
     */
    public void setCodeISO(String codeISO)
    {
        this.codeISO = codeISO;
    }

    public String getIsoCountryNoNull()
    {
	return isoCountryNoNull;
    }

    public void setIsoCountryNoNull(String isoCountryNoNull)
    {
	this.isoCountryNoNull = isoCountryNoNull;
    }

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

}
