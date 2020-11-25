package com.path.vo.common.iis.dealcharges;

import java.io.Serializable;
import java.math.BigDecimal;

import com.path.dbmaps.vo.TRSCHARGESVO;

public class TrsChargesCO extends TRSCHARGESVO implements Serializable {
private BigDecimal ldecChargePercentage;
private String lsChargeType;
private String lsCollectChargeDealYn;
private String lsCollectChargeAccountType;
private String lsChargeAmountPerinst;
private String excludeCharges;
private String serialNo;
public String getSerialNo() {
	return serialNo;
}
public void setSerialNo(String serialNo) {
	this.serialNo = serialNo;
}
public String getExcludeCharges() {
	return excludeCharges;
}
public void setExcludeCharges(String excludeCharges) {
	this.excludeCharges = excludeCharges;
}
public BigDecimal getLdecChargePercentage() {
	return ldecChargePercentage;
}
public void setLdecChargePercentage(BigDecimal ldecChargePercentage) {
	this.ldecChargePercentage = ldecChargePercentage;
}
public String getLsChargeType() {
	return lsChargeType;
}
public void setLsChargeType(String lsChargeType) {
	this.lsChargeType = lsChargeType;
}
public String getLsCollectChargeDealYn() {
	return lsCollectChargeDealYn;
}
public void setLsCollectChargeDealYn(String lsCollectChargeDealYn) {
	this.lsCollectChargeDealYn = lsCollectChargeDealYn;
}
public String getLsCollectChargeAccountType() {
	return lsCollectChargeAccountType;
}
public void setLsCollectChargeAccountType(String lsCollectChargeAccountType) {
	this.lsCollectChargeAccountType = lsCollectChargeAccountType;
}
public String getLsChargeAmountPerinst() {
	return lsChargeAmountPerinst;
}
public void setLsChargeAmountPerinst(String lsChargeAmountPerinst) {
	this.lsChargeAmountPerinst = lsChargeAmountPerinst;
}
}