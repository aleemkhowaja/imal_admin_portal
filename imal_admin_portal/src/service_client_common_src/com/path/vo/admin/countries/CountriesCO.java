package com.path.vo.admin.countries;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.COUNTRIES_REGIONVO;
import com.path.dbmaps.vo.COUNTRIES_TEL_FORMATVO;
import com.path.vo.core.common.RetailBaseVO;

public class CountriesCO extends RetailBaseVO
{
    private COUNTRIESVO countriesVO = new COUNTRIESVO();
    private COUNTRIES_REGIONVO countriesRegionVO = new COUNTRIES_REGIONVO();
    private COUNTRIES_TEL_FORMATVO countriesTelFormat = new COUNTRIES_TEL_FORMATVO();
    private CIF_ADDRESSVO cifAddressVO = new CIF_ADDRESSVO();
    
    private BigDecimal amountUtilized;// used to get the amount utilized
    private BigDecimal amountAvailable;// used to get the amount avialable
    private BigDecimal amountBankCifFc;// used to get the amount of trx in
				       // country CY
    private String code;// used to get Code in COUNTRIES_LIMIT_CIF_TRS
    private String countryLimitAction;// used to set 'APPROVE' 'REVERSE'
				      // 'DELETE' 'CANCEL' 'CLOSE'
    private String countryLimitInd;// used to set 'U' 'I' 'D'
    // 'CLOSE-REVERSE'
    private String warningMsg;
    private BigDecimal regionCode;
    
    private Integer countProhibCountry; //JIHANE TP178768

    public COUNTRIESVO getCountriesVO()
    {
	return countriesVO;
    }

    public void setCountriesVO(COUNTRIESVO countriesVO)
    {
	this.countriesVO = countriesVO;
    }

    public String getWarningMsg()
    {
	return warningMsg;
    }

    public void setWarningMsg(String warningMsg)
    {
	this.warningMsg = warningMsg;
    }

    public BigDecimal getAmountUtilized()
    {
	return amountUtilized;
    }

    public void setAmountUtilized(BigDecimal amountUtilized)
    {
	this.amountUtilized = amountUtilized;
    }

    public BigDecimal getAmountAvailable()
    {
	return amountAvailable;
    }

    public void setAmountAvailable(BigDecimal amountAvailable)
    {
	this.amountAvailable = amountAvailable;
    }

    public BigDecimal getAmountBankCifFc()
    {
	return amountBankCifFc;
    }

    public void setAmountBankCifFc(BigDecimal amountBankCifFc)
    {
	this.amountBankCifFc = amountBankCifFc;
    }

    public String getCode()
    {
	return code;
    }

    public void setCode(String code)
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

    public String getCountryLimitInd()
    {
	return countryLimitInd;
    }

    public void setCountryLimitInd(String countryLimitInd)
    {
	this.countryLimitInd = countryLimitInd;
    }

    public BigDecimal getRegionCode()
    {
	return regionCode;
    }

    public void setRegionCode(BigDecimal regionCode)
    {
	this.regionCode = regionCode;
    }

    public Integer getCountProhibCountry()
    {
        return countProhibCountry;
    }

    public void setCountProhibCountry(Integer countProhibCountry)
    {
        this.countProhibCountry = countProhibCountry;
    }

    public COUNTRIES_REGIONVO getCountriesRegionVO()
    {
        return countriesRegionVO;
    }

    public void setCountriesRegionVO(COUNTRIES_REGIONVO countriesRegionVO)
    {
        this.countriesRegionVO = countriesRegionVO;
    }

    public COUNTRIES_TEL_FORMATVO getCountriesTelFormat()
    {
        return countriesTelFormat;
    }

    public void setCountriesTelFormat(COUNTRIES_TEL_FORMATVO countriesTelFormat)
    {
        this.countriesTelFormat = countriesTelFormat;
    }

    public CIF_ADDRESSVO getCifAddressVO()
    {
        return cifAddressVO;
    }

    public void setCifAddressVO(CIF_ADDRESSVO cifAddressVO)
    {
        this.cifAddressVO = cifAddressVO;
    }


}
