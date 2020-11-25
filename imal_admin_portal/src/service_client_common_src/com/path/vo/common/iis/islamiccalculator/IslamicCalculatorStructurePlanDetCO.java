package com.path.vo.common.iis.islamiccalculator;

import java.io.Serializable;

public class IslamicCalculatorStructurePlanDetCO implements Serializable
{
    private Double installmentAmount;
    private Double principleAmount;
    private Double profitAmount;
    private Double pushDownProfitAmount;
    private Long noOfInstallmentForEqualize;
    private Double totalOutstandingAmount;
    private Double lineAllocatedCharges;
    private Double cumActualCharges;
    private Double cumAllocatedCharges;
    private Long lineAllocatedCount;
    private Double totalAllocatedProfit;
    private Double totalChargesExcludeProfitCalc;
    private Double totalInsuranceExcludeProfitCalc;
    private Double vatAmount;
    private Double allocatedVatAmount;
    private Double allocatedCapitalAmount;

    public Double getVatAmount()
    {
	return vatAmount;
    }

    public void setVatAmount(Double vatAmount)
    {
	this.vatAmount = vatAmount;
    }

    public Double getInstallmentAmount()
    {
	return installmentAmount;
    }

    public void setInstallmentAmount(Double installmentAmount)
    {
	this.installmentAmount = installmentAmount;
    }

    public Double getPrincipleAmount()
    {
	return principleAmount;
    }

    public void setPrincipleAmount(Double principleAmount)
    {
	this.principleAmount = principleAmount;
    }

    public Double getProfitAmount()
    {
	return profitAmount;
    }

    public void setProfitAmount(Double profitAmount)
    {
	this.profitAmount = profitAmount;
    }

    public Double getPushDownProfitAmount()
    {
	return pushDownProfitAmount;
    }

    public void setPushDownProfitAmount(Double pushDownProfitAmount)
    {
	this.pushDownProfitAmount = pushDownProfitAmount;
    }

    public Long getNoOfInstallmentForEqualize()
    {
	return noOfInstallmentForEqualize;
    }

    public void setNoOfInstallmentForEqualize(Long noOfInstallmentForEqualize)
    {
	this.noOfInstallmentForEqualize = noOfInstallmentForEqualize;
    }

    public Double getTotalOutstandingAmount()
    {
	return totalOutstandingAmount;
    }

    public void setTotalOutstandingAmount(Double totalOutstandingAmount)
    {
	this.totalOutstandingAmount = totalOutstandingAmount;
    }

    public Double getLineAllocatedCharges()
    {
	return lineAllocatedCharges;
    }

    public void setLineAllocatedCharges(Double lineAllocatedCharges)
    {
	this.lineAllocatedCharges = lineAllocatedCharges;
    }

    public Double getCumActualCharges()
    {
	return cumActualCharges;
    }

    public void setCumActualCharges(Double cumActualCharges)
    {
	this.cumActualCharges = cumActualCharges;
    }

    public Double getCumAllocatedCharges()
    {
	return cumAllocatedCharges;
    }

    public void setCumAllocatedCharges(Double cumAllocatedCharges)
    {
	this.cumAllocatedCharges = cumAllocatedCharges;
    }

    public Long getLineAllocatedCount()
    {
	return lineAllocatedCount;
    }

    public void setLineAllocatedCount(Long lineAllocatedCount)
    {
	this.lineAllocatedCount = lineAllocatedCount;
    }

    public Double getTotalAllocatedProfit()
    {
	return totalAllocatedProfit;
    }

    public void setTotalAllocatedProfit(Double totalAllocatedProfit)
    {
	this.totalAllocatedProfit = totalAllocatedProfit;
    }

    public Double getTotalChargesExcludeProfitCalc()
    {
	return totalChargesExcludeProfitCalc;
    }

    public void setTotalChargesExcludeProfitCalc(Double totalChargesExcludeProfitCalc)
    {
	this.totalChargesExcludeProfitCalc = totalChargesExcludeProfitCalc;
    }

    public Double getTotalInsuranceExcludeProfitCalc()
    {
	return totalInsuranceExcludeProfitCalc;
    }

    public void setTotalInsuranceExcludeProfitCalc(Double totalInsuranceExcludeProfitCalc)
    {
	this.totalInsuranceExcludeProfitCalc = totalInsuranceExcludeProfitCalc;
    }

    public Double getAllocatedVatAmount()
    {
	return allocatedVatAmount;
    }

    public void setAllocatedVatAmount(Double allocatedVatAmount)
    {
	this.allocatedVatAmount = allocatedVatAmount;
    }

    public Double getAllocatedCapitalAmount()
    {
	return allocatedCapitalAmount;
    }

    public void setAllocatedCapitalAmount(Double allocatedCapitalAmount)
    {
	this.allocatedCapitalAmount = allocatedCapitalAmount;
    }

}
