package com.path.vo.admin.countriesregion;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CountriesRegionSC extends GridParamsSC {

	private BigDecimal countryCode;
	private BigDecimal regionCode;
	private String issuePlace;

	public BigDecimal getCountry_code()
	{
		return countryCode;
	}

	public void setCountry_code(BigDecimal countryCode)
	{
		this.countryCode = countryCode;
	}

	public BigDecimal getRegionCode()
	{
		return regionCode;
	}

	public void setRegionCode(BigDecimal regionCode)
	{
		this.regionCode = regionCode;
	}

	public String getIssuePlace()
	{
	    return issuePlace;
	}

	public void setIssuePlace(String issuePlace)
	{
	    this.issuePlace = issuePlace;
	}

}
