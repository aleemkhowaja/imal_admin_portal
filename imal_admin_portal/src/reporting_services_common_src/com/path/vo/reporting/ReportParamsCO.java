package com.path.vo.reporting;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import com.path.struts2.lib.common.BaseObject;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: annasuccar
 *
 * ReportParamsCO.java used to be sent as parameter to JasperReport api to generate a report
 */
public class ReportParamsCO extends BaseObject
{

        /**
         * 
         */
        private static final long serialVersionUID = 8401432373121532513L;
        
        private String userName; // user name in SADS (gv_userid in Pbd)
	private String userFirstName; // user first name 
	private String userLastName; // user last name 
	private String currentAppName;//current application logged in
	private String clientType;//client Type corresponds to Type Column in S_APP table
	private BigDecimal companyCode; //Login Company Code
	private String companyName; // Login Company Description
	private String companyArabName; // Login Company Description
	private BigDecimal branchCode; // Login Branch Code
	private String branchName; // Login Branch Description
	private Date runningDateRET ; // running Date of RET
	private BigDecimal baseCurrencyCode; //Base Currency of Login Company
	private String baseCurrencyName; //Base Currency of Login Company Name
	private BigDecimal baseCurrDecPoint; //Base Currency Decimal Point of base Currency
	private BigDecimal exposCurCode; //Exposure Currency Code
	private String exposCurName; //Exposure Currency Name
	private BigDecimal fiscalYear; //Fiscal Year
	private String language;//language in which we are logged in
	private String progRef;//report reference
	private Boolean noData; //to check if we should load the global function if noData or not
	private String repAppName; //to store the report application name that will used in the jrGobal
	private String repLanguage; //to store the languages choosen by the user on report execution
	private int isRTLDir;
	private BigDecimal employeeId; //to store the value of session attribute employeeId
	private HashMap<String, Object> userNbFormats;//query date format for a user from database
	
	public HashMap<String, Object> getUserNbFormats()
	{
		return userNbFormats;
	}
	
	public void setUserNbFormats(HashMap<String, Object> userNbFormats)
	{
		this.userNbFormats = userNbFormats;
	}

	
	public BigDecimal getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(BigDecimal employeeId) {
		this.employeeId = employeeId;
	}
	public int getIsRTLDir()
	{
	    return isRTLDir;
	}
	public void setIsRTLDir(int isRTLDir)
	{
	    this.isRTLDir = isRTLDir;
	}
	public String getRepLanguage() {
		return repLanguage;
	}
	public void setRepLanguage(String repLanguage) {
		this.repLanguage = repLanguage;
	}
	public String getRepAppName() {
		return repAppName;
	}
	public void setRepAppName(String repAppName) {
		this.repAppName = repAppName;
	}
	public Boolean getNoData() {
		return noData;
	}
	public void setNoData(Boolean noData) {
		this.noData = noData;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCurrentAppName() {
		return currentAppName;
	}
	public void setCurrentAppName(String currentAppName) {
		this.currentAppName = currentAppName;
	}
	public BigDecimal getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(BigDecimal companyCode) {
		this.companyCode = companyCode;
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
	public String getCompanyName()
	{
	    return companyName;
	}
	public void setCompanyName(String companyName)
	{
	    this.companyName = companyName;
	}
	public String getBranchName()
	{
	    return branchName;
	}
	public void setBranchName(String branchName)
	{
	    this.branchName = branchName;
	}
	public Date getRunningDateRET() {
		return runningDateRET;
	}
	public void setRunningDateRET(Date runningDateRET) {
		this.runningDateRET = runningDateRET;
	}
	public BigDecimal getBaseCurrencyCode()
	{
	    return baseCurrencyCode;
	}
	public void setBaseCurrencyCode(BigDecimal baseCurrencyCode)
	{
	    this.baseCurrencyCode = baseCurrencyCode;
	}
	public String getUserFirstName()
	{
	    return userFirstName;
	}
	public void setUserFirstName(String userFirstName)
	{
	    this.userFirstName = userFirstName;
	}
	public String getUserLastName()
	{
	    return userLastName;
	}
	public void setUserLastName(String userLastName)
	{
	    this.userLastName = userLastName;
	}
	public BigDecimal getBaseCurrDecPoint()
	{
	    return baseCurrDecPoint;
	}
	public void setBaseCurrDecPoint(BigDecimal baseCurrDecPoint)
	{
	    this.baseCurrDecPoint = baseCurrDecPoint;
	}
	public BigDecimal getFiscalYear()
	{
	    return fiscalYear;
	}
	public void setFiscalYear(BigDecimal fiscalYear)
	{
	    this.fiscalYear = fiscalYear;
	}
	public String getCompanyArabName()
	{
	    return companyArabName;
	}
	public void setCompanyArabName(String companyArabName)
	{
	    this.companyArabName = companyArabName;
	}
	public String getClientType()
	{
	    return clientType;
	}
	public void setClientType(String clientType)
	{
	    this.clientType = clientType;
	}
	public String getBaseCurrencyName()
	{
	    return baseCurrencyName;
	}
	public void setBaseCurrencyName(String baseCurrencyName)
	{
	    this.baseCurrencyName = baseCurrencyName;
	}
	public BigDecimal getExposCurCode()
	{
	    return exposCurCode;
	}
	public void setExposCurCode(BigDecimal exposCurCode)
	{
	    this.exposCurCode = exposCurCode;
	}
	public String getExposCurName()
	{
	    return exposCurName;
	}
	public void setExposCurName(String exposCurName)
	{
	    this.exposCurName = exposCurName;
	}
        public String getProgRef()
        {
            return progRef;
        }
        public void setProgRef(String progRef)
        {
            this.progRef = progRef;
        }
}
