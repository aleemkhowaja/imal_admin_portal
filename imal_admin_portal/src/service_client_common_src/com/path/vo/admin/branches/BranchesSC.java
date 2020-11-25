package com.path.vo.admin.branches;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class BranchesSC extends GridParamsSC{
	
	public BranchesSC()
	{
		super.setSearchCols(new String[] { "BRANCH_CODE","BRIEF_DESC_ENG"});
	}
	
	
	private String userId;
	private BigDecimal compCode;
	private BigDecimal branchCode;
	private String language;
	private BigDecimal displayMsg;
        private String allowMultiBr;
        private String screenName;
        private boolean multiHO;
	private BigDecimal loggedInBranch;
	private BigDecimal hoBranch; 
	private boolean physicalBranch;
	
	//DASI170153 
        private String isHoBranch;
        private String operationNature;
        private BigDecimal toVaultCode;
        private BigDecimal fromVaultCode;
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public BigDecimal getCompCode() {
		return compCode;
	}


	public void setCompCode(BigDecimal compCode) {
		this.compCode = compCode;
	}


	public BigDecimal getBranchCode() {
		return branchCode;
	}


	public void setBranchCode(BigDecimal branchCode) {
		this.branchCode = branchCode;
	}


	public String getLanguage()
	{
	    return language;
	}


	public void setLanguage(String language)
	{
	    this.language = language;
	}


	public BigDecimal getDisplayMsg()
	{
	    return displayMsg;
	}


	public void setDisplayMsg(BigDecimal displayMsg)
	{
	    this.displayMsg = displayMsg;
	}


	public String getAllowMultiBr()
	{
	    return allowMultiBr;
	}


	public void setAllowMultiBr(String allowMultiBr)
	{
	    this.allowMultiBr = allowMultiBr;
	}


	public String getScreenName()
	{
	    return screenName;
	}


	public void setScreenName(String screenName)
	{
	    this.screenName = screenName;
	}


	public BigDecimal getLoggedInBranch()
	{
	    return loggedInBranch;
	}


	public void setLoggedInBranch(BigDecimal loggedInBranch)
	{
	    this.loggedInBranch = loggedInBranch;
	}


	public BigDecimal getHoBranch()
	{
	    return hoBranch;
	}


	public void setHoBranch(BigDecimal hoBranch)
	{
	    this.hoBranch = hoBranch;
	}


	public boolean isMultiHO()
	{
	    return multiHO;
	}


	public void setMultiHO(boolean multiHO)
	{
	    this.multiHO = multiHO;
	}


	public boolean isPhysicalBranch() {
		return physicalBranch;
	}


	public void setPhysicalBranch(boolean physicalBranch) {
		this.physicalBranch = physicalBranch;
	}


	public String getIsHoBranch()
	{
	    return isHoBranch;
	}


	public void setIsHoBranch(String isHoBranch)
	{
	    this.isHoBranch = isHoBranch;
	}


	public String getOperationNature()
	{
	    return operationNature;
	}


	public void setOperationNature(String operationNature)
	{
	    this.operationNature = operationNature;
	}


	public BigDecimal getToVaultCode()
	{
	    return toVaultCode;
	}


	public void setToVaultCode(BigDecimal toVaultCode)
	{
	    this.toVaultCode = toVaultCode;
	}


	public BigDecimal getFromVaultCode()
	{
	    return fromVaultCode;
	}


	public void setFromVaultCode(BigDecimal fromVaultCode)
	{
	    this.fromVaultCode = fromVaultCode;
	}
	

}
