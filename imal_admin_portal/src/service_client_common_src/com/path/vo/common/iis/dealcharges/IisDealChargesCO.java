package com.path.vo.common.iis.dealcharges;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.lib.vo.BaseVO;

public class IisDealChargesCO extends BaseVO implements Serializable
{
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal productClass;
    private BigDecimal cifNo;
    private Date maturityDate;
    private BigDecimal dealNo;
    private Date valueDate;
    private BigDecimal currency;
    private BigDecimal DownPaymentAmount;
    private List<TrsDealChargesCO> iisTrsdealchargesCO;
    private TrsDealChargesCO trsDealChargesCO;
    private String callType;// To find out the call from product class selection
    // or other column selection P - PRODUCTCLASS O -
    // OTHERS
    private BigDecimal allowEditVat;
    private BigDecimal dealAmount;
    private BigDecimal companyContributionAmount;
    private String allowEdit;
    private BigDecimal dealCurrency;
	// 976965 - SBI200143
	private String COLLECT_CHARGES_ACCOUNT_TYPE;

	public String getCOLLECT_CHARGES_ACCOUNT_TYPE()
    {
                return COLLECT_CHARGES_ACCOUNT_TYPE;
    }

    public void setCOLLECT_CHARGES_ACCOUNT_TYPE(String cOLLECT_CHARGES_ACCOUNT_TYPE)
    {
                COLLECT_CHARGES_ACCOUNT_TYPE = cOLLECT_CHARGES_ACCOUNT_TYPE;
    }

    public BigDecimal getDealNo()
    {
	return dealNo;
    }

    public void setDealNo(BigDecimal dealNo)
    {
	this.dealNo = dealNo;
    }

    public BigDecimal getDownPaymentAmount()
    {
	return DownPaymentAmount;
    }

    public void setDownPaymentAmount(BigDecimal downPaymentAmount)
    {
	DownPaymentAmount = downPaymentAmount;
    }

    public BigDecimal getCompanyContributionAmount()
    {
	return companyContributionAmount;
    }

    public void setCompanyContributionAmount(BigDecimal companyContributionAmount)
    {
	this.companyContributionAmount = companyContributionAmount;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getAllowEditVat()
    {
	return allowEditVat;
    }

    public void setAllowEditVat(BigDecimal allowEditVat)
    {
	this.allowEditVat = allowEditVat;
    }

    public String getCallType()
    {
	return callType;
    }

    public void setCallType(String callType)
    {
	this.callType = callType;
    }

    public BigDecimal getDealAmount()
    {
	return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount)
    {
	this.dealAmount = dealAmount;
    }

    public Date getMaturityDate()
    {
	return maturityDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
	this.maturityDate = maturityDate;
    }

    public Date getValueDate()
    {
	return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public BigDecimal getCurrency()
    {
	return currency;
    }

    public void setCurrency(BigDecimal currency)
    {
	this.currency = currency;
    }

    public List<TrsDealChargesCO> getIisTrsdealchargesCO()
    {
	return iisTrsdealchargesCO;
    }

    public void setIisTrsdealchargesCO(List<TrsDealChargesCO> iisTrsdealchargesCO)
    {
	this.iisTrsdealchargesCO = iisTrsdealchargesCO;
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

    public BigDecimal getProductClass()
    {
	return productClass;
    }

    public void setProductClass(BigDecimal productClass)
    {
	this.productClass = productClass;
    }

    public TrsDealChargesCO getTrsDealChargesCO()
    {
	return trsDealChargesCO;
    }

    public void setTrsDealChargesCO(TrsDealChargesCO trsDealChargesCO)
    {
	this.trsDealChargesCO = trsDealChargesCO;
    }

    public String getAllowEdit()
    {
	return allowEdit;
    }

    public void setAllowEdit(String allowEdit)
    {
	this.allowEdit = allowEdit;
    }

    public BigDecimal getDealCurrency()
    {
	return dealCurrency;
    }

    public void setDealCurrency(BigDecimal dealCurrency)
    {
	this.dealCurrency = dealCurrency;
    }
}
