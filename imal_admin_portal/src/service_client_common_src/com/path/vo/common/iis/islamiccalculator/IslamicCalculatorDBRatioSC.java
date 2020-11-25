package com.path.vo.common.iis.islamiccalculator;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;

public class IslamicCalculatorDBRatioSC extends BaseSC {

	private String dbrDetails;
	private BigDecimal dbrAmount;
	private BigDecimal dbrAmountFormat;
	public String getDbrDetails() {
		return dbrDetails;
	}
	public void setDbrDetails(String dbrDetails) {
		this.dbrDetails = dbrDetails;
	}
	public BigDecimal getDbrAmount(){
		return dbrAmount;
	}
	public void setDbrAmount(BigDecimal dbrAmount)
	{
		this.dbrAmount = dbrAmount;
	}
	public BigDecimal getDbrAmountFormat() {
		return dbrAmountFormat;
	}
	public void setDbrAmountFormat(BigDecimal dbrAmountFormat) {
		this.dbrAmountFormat = dbrAmountFormat;
	}
}
