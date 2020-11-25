/**
 * 
 */
package com.path.vo.common;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

/**
 * @author marwanmaddah
 *
 */
public class DefaultCompBranchCO extends BaseVO
{	
  private BigDecimal companyCode;
  private String     companyDesc;
  private BigDecimal branchCode;
  private String     branchDesc;
/**
 * @return the companyCode
 */
public BigDecimal getCompanyCode() {
	return companyCode;
}
/**
 * @param companyCode the companyCode to set
 */
public void setCompanyCode(BigDecimal companyCode) {
	this.companyCode = companyCode;
}
/**
 * @return the companyDesc
 */
public String getCompanyDesc() {
	return companyDesc;
}
/**
 * @param companyDesc the companyDesc to set
 */
public void setCompanyDesc(String companyDesc) {
	this.companyDesc = companyDesc;
}
/**
 * @return the branchCode
 */
public BigDecimal getBranchCode() {
	return branchCode;
}
/**
 * @param branchCode the branchCode to set
 */
public void setBranchCode(BigDecimal branchCode) {
	this.branchCode = branchCode;
}
/**
 * @return the branchDesc
 */
public String getBranchDesc() {
	return branchDesc;
}
/**
 * @param branchDesc the branchDesc to set
 */
public void setBranchDesc(String branchDesc) {
	this.branchDesc = branchDesc;
}
}
