package com.path.vo.common.iis.islamiccalculator;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


import com.path.lib.common.base.BaseBO;

public class IslamicCalculatorScheduleCO extends BaseBO implements Serializable{
	
	private String lnNo;
	private Boolean  baloon;
	private Date dueDate;
	private BigDecimal installmentAmount;
	private BigDecimal principalAmount;
	private BigDecimal principalCharges;
	private BigDecimal chargeAmount;
	private BigDecimal insuranceAmount;
	private BigDecimal profitAmount;
	private BigDecimal vatAmount;
	private BigDecimal totalEarnedProfit;
	private BigDecimal xnpv;
	private BigDecimal netInvestmentOutstanding;
	private BigDecimal totalDeferredProfit;
	private BigDecimal totalPrincipalOutstanding;
	private BigDecimal noOfDays;
	private BigDecimal constantROR;
	
	public String getLnNo() {
		return lnNo;
	}
	public void setLnNo(String lnNo) {
		this.lnNo = lnNo;
	}
	public Boolean getBaloon() {
		return baloon;
	}
	public void setBaloon(Boolean baloon) {
		this.baloon = baloon;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public BigDecimal getInstallmentAmount() {
		return installmentAmount;
	}
	public void setInstallmentAmount(BigDecimal installmentAmount) {
		this.installmentAmount = installmentAmount;
	}
	public BigDecimal getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(BigDecimal principalAmount) {
		this.principalAmount = principalAmount;
	}
	public BigDecimal getPrincipalCharges() {
		return principalCharges;
	}
	public void setPrincipalCharges(BigDecimal principalCharges) {
		this.principalCharges = principalCharges;
	}
	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}
	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}
	public BigDecimal getInsuranceAmount() {
		return insuranceAmount;
	}
	public void setInsuranceAmount(BigDecimal insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
	public BigDecimal getProfitAmount() {
		return profitAmount;
	}
	public void setProfitAmount(BigDecimal profitAmount) {
		this.profitAmount = profitAmount;
	}
	public BigDecimal getVatAmount() {
		return vatAmount;
	}
	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}
	public BigDecimal getTotalEarnedProfit() {
		return totalEarnedProfit;
	}
	public void setTotalEarnedProfit(BigDecimal totalEarnedProfit) {
		this.totalEarnedProfit = totalEarnedProfit;
	}
	public BigDecimal getXnpv() {
		return xnpv;
	}
	public void setXnpv(BigDecimal xnpv) {
		this.xnpv = xnpv;
	}
	public BigDecimal getNetInvestmentOutstanding() {
		return netInvestmentOutstanding;
	}
	public void setNetInvestmentOutstanding(BigDecimal netInvestmentOutstanding) {
		this.netInvestmentOutstanding = netInvestmentOutstanding;
	}
	public BigDecimal getTotalDeferredProfit() {
		return totalDeferredProfit;
	}
	public void setTotalDeferredProfit(BigDecimal totalDeferredProfit) {
		this.totalDeferredProfit = totalDeferredProfit;
	}
	public BigDecimal getTotalPrincipalOutstanding() {
		return totalPrincipalOutstanding;
	}
	public void setTotalPrincipalOutstanding(BigDecimal totalPrincipalOutstanding) {
		this.totalPrincipalOutstanding = totalPrincipalOutstanding;
	}
	public BigDecimal getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(BigDecimal noOfDays) {
		this.noOfDays = noOfDays;
	}
	public BigDecimal getConstantROR() {
		return constantROR;
	}
	public void setConstantROR(BigDecimal constantROR) {
		this.constantROR = constantROR;
	}

}
