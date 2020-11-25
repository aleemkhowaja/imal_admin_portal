/**
 * 
 */
package com.path.vo.common;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.path.dbmaps.vo.SYS_PARAM_OBJ_DETAILS_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.struts2.lib.common.BaseSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: MarwanMaddah
 * 
 *          RequiredFieldsSC.java used to
 */
public class RequiredFieldsSC extends BaseSC
{
    private String langCode;
    private String appName;
    private String progRef;
    private String elementName;
    private String elementId;
    private BigDecimal trxType;
    private BigDecimal cifType;
    private BigDecimal countryId;
    private BigDecimal trsNo;
    private BigDecimal cifNo;
    private String loginUserId;
    private String cbInd;
    private String trsType;
    //branch Name and Company Name needed for Expression evaluation
    private String branchName;
    private String companyName;
    private String baseCurrencyName;
    private String userFirstName;
    private String userLastName;
    private BigDecimal isTeller;
    private String originalProgRef;
    private String     entityType;
    private BigDecimal entityCode;
    
    private String expressionCode;
    private String columnName;
    private BigDecimal topN;
    private boolean fromStartup;
    private String defaultAppName;
    private SYS_PARAM_SCREEN_DISPLAYVO sysParamsVO = new SYS_PARAM_SCREEN_DISPLAYVO();
    private SYS_PARAM_OBJ_DISPLAYVO sysParamsObjDispVO = new SYS_PARAM_OBJ_DISPLAYVO(); 
    private SYS_PARAM_OBJ_DETAILS_DISPLAYVO sysParamsObjDetailsDispVO = new SYS_PARAM_OBJ_DETAILS_DISPLAYVO(); 
    private String fromText;
    private String fromTextArea;
    private String fromDatePicker;
    private Object inputFieldValue;
    private String allowDefValCust;
    private Boolean requiredDataByCifNoOnly;
    //created to get trx screen fields that can modified from FOM screen
    private String allowModifyInFom;
    private Map<String,Object> entityTypeInfosMap = new HashMap<String,Object>();
    
    private Map<String,Object> dynParamsMap = new HashMap<String,Object>();
    
    private String[] neededEntities;
    /**
     * used to pass the current screen object in the required fields criteria 
     * to get the values of the properties that are exists in the expressions  
     */
    private Object screenObject;
    private Boolean custValidation;
    private String custActionType;
    private String readFromMir;
    private String fromSmart;
    //TP#1002338 Value Validation Expression for Element LiveSearch and Select Boxes Customization Enhancements
    private String fromSelectBox;
    private String fromLiveSearch;
    private Boolean checkFomTrxDetails;
    private String fromDynamicScreen;//TP#1085788
    
    
    /**
     * 
     * @return
     */
    public String getLangCode()
    {
	return langCode;
    }

    /**
     * 
     * @param langCode
     */
    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    /**
     * 
     * @return
     */
    public String getAppName()
    {
	return appName;
    }

    /**
     * 
     * @param appName
     */
    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public String getElementName()
    {
	return elementName;
    }

    public void setElementName(String elementName)
    {
	this.elementName = elementName;
    }

    public BigDecimal getTrxType()
    {
	return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    /**
     * @return the trsNo
     */
    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    /**
     * @param trsNo the trsNo to set
     */
    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }

    /**
     * @return the loginUserId
     */
    public String getLoginUserId()
    {
	return loginUserId;
    }

    /**
     * @param loginUserId the loginUserId to set
     */
    public void setLoginUserId(String loginUserId)
    {
	this.loginUserId = loginUserId;
    }

    /**
     * @return the cbInd
     */
    public String getCbInd()
    {
	return cbInd;
    }

    /**
     * @param cbInd the cbInd to set
     */
    public void setCbInd(String cbInd)
    {
	this.cbInd = cbInd;
    }

    /**
     * @return the trsType
     */
    public String getTrsType()
    {
	return trsType;
    }

    /**
     * @param trsType the trsType to set
     */
    public void setTrsType(String trsType)
    {
	this.trsType = trsType;
    }

    public String getElementId()
    {
	return elementId;
    }

    public void setElementId(String elementId)
    {
	this.elementId = elementId;
    }

    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public String getBranchName()
    {
        return branchName;
    }

    public void setBranchName(String branchName)
    {
        this.branchName = branchName;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getBaseCurrencyName()
    {
        return baseCurrencyName;
    }

    public void setBaseCurrencyName(String baseCurrencyName)
    {
        this.baseCurrencyName = baseCurrencyName;
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

    public BigDecimal getIsTeller()
    {
        return isTeller;
    }

    public void setIsTeller(BigDecimal isTeller)
    {
        this.isTeller = isTeller;
    }

    /**
     * @return the originalProgRef
     */
    public String getOriginalProgRef()
    {
        return originalProgRef;
    }

    /**
     * @param originalProgRef the originalProgRef to set
     */
    public void setOriginalProgRef(String originalProgRef)
    {
        this.originalProgRef = originalProgRef;
    }

    /**
     * @return the entityType
     */
    public String getEntityType()
    {
        return entityType;
    }

    /**
     * @param entityType the entityType to set
     */
    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }

    /**
     * @return the entityCode
     */
    public BigDecimal getEntityCode()
    {
        return entityCode;
    }

    /**
     * @param entityCode the entityCode to set
     */
    public void setEntityCode(BigDecimal entityCode)
    {
        this.entityCode = entityCode;
    }

	public void setExpressionCode(String expressionCode) {
		this.expressionCode = expressionCode;
	}

	public String getExpressionCode() {
		return expressionCode;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setTopN(BigDecimal topN) {
		this.topN = topN;
	}

	public BigDecimal getTopN() {
		return topN;
	}

	public boolean isFromStartup()
	{
	    return fromStartup;
	}

	public void setFromStartup(boolean fromStartup)
	{
	    this.fromStartup = fromStartup;
	}

	/**
	 * @return the sysParamsVO
	 */
	public SYS_PARAM_SCREEN_DISPLAYVO getSysParamsVO()
	{
	    return sysParamsVO;
	}

	/**
	 * @param sysParamsVO the sysParamsVO to set
	 */
	public void setSysParamsVO(SYS_PARAM_SCREEN_DISPLAYVO sysParamsVO)
	{
	    this.sysParamsVO = sysParamsVO;
	}

	/**
	 * @return the defaultAppName
	 */
	public String getDefaultAppName()
	{
	    return defaultAppName;
	}

	/**
	 * @param defaultAppName the defaultAppName to set
	 */
	public void setDefaultAppName(String defaultAppName)
	{
	    this.defaultAppName = defaultAppName;
	}

	public String getFromText()
	{
	    return fromText;
	}

	public void setFromText(String fromText)
	{
	    this.fromText = fromText;
	}

	public String getFromTextArea()
	{
	    return fromTextArea;
	}

	public void setFromTextArea(String fromTextArea)
	{
	    this.fromTextArea = fromTextArea;
	}

	public Object getInputFieldValue()
	{
	    return inputFieldValue;
	}

	public void setInputFieldValue(Object inputFieldValue)
	{
	    this.inputFieldValue = inputFieldValue;
	}

	public String getAllowDefValCust()
	{
	    return allowDefValCust;
	}

	public void setAllowDefValCust(String allowDefValCust)
	{
	    this.allowDefValCust = allowDefValCust;
	}

	public Boolean getRequiredDataByCifNoOnly()
	{
	    return requiredDataByCifNoOnly;
	}

	public void setRequiredDataByCifNoOnly(Boolean requiredDataByCifNoOnly)
	{
	    this.requiredDataByCifNoOnly = requiredDataByCifNoOnly;
	}
	
	public String getAllowModifyInFom()
	{
	    return allowModifyInFom;
	}

	public void setAllowModifyInFom(String allowModifyInFom)
	{
	    this.allowModifyInFom = allowModifyInFom;
	}

	/**
	 * @return the dynParamsMap
	 */
	public Map<String, Object> getDynParamsMap()
	{
	    return dynParamsMap;
	}

	/**
	 * @param dynParamsMap the dynParamsMap to set
	 */
	public void setDynParamsMap(Map<String, Object> dynParamsMap)
	{
	    this.dynParamsMap = dynParamsMap;
	}

	public Map<String, Object> getEntityTypeInfosMap()
	{
	    return entityTypeInfosMap;
	}

	public void setEntityTypeInfosMap(Map<String, Object> entityTypeInfosMap)
	{
	    this.entityTypeInfosMap = entityTypeInfosMap;
	}
	
	/**
	 * @return the neededEntities
	 */
	public String[] getNeededEntities()
	{
	    return neededEntities;
	}

	/**
	 * @param neededEntities the neededEntities to set
	 */
	public void setNeededEntities(String[] neededEntities)
	{
	    this.neededEntities = neededEntities;
	}

	public BigDecimal getCountryId()
	{
	    return countryId;
	}

	public void setCountryId(BigDecimal countryId)
	{
	    this.countryId = countryId;
	}

	public Object getScreenObject()
	{
	    return screenObject;
	}

	public void setScreenObject(Object screenObject)
	{
	    this.screenObject = screenObject;
	}

	public Boolean getCustValidation()
	{
	    return custValidation;
	}

	public void setCustValidation(Boolean custValidation)
	{
	    this.custValidation = custValidation;
	}
	
        public String getFromDatePicker()
        {
    	return fromDatePicker;
        }
    
        public void setFromDatePicker(String fromDatePicker)
        {
    	this.fromDatePicker = fromDatePicker;
        }

	public SYS_PARAM_OBJ_DISPLAYVO getSysParamsObjDispVO()
	{
	    return sysParamsObjDispVO;
	}

	public void setSysParamsObjDispVO(SYS_PARAM_OBJ_DISPLAYVO sysParamsObjDispVO)
	{
	    this.sysParamsObjDispVO = sysParamsObjDispVO;
	}

	public SYS_PARAM_OBJ_DETAILS_DISPLAYVO getSysParamsObjDetailsDispVO()
	{
	    return sysParamsObjDetailsDispVO;
	}

	public void setSysParamsObjDetailsDispVO(SYS_PARAM_OBJ_DETAILS_DISPLAYVO sysParamsObjDetailsDispVO)
	{
	    this.sysParamsObjDetailsDispVO = sysParamsObjDetailsDispVO;
	}

	/**
	 * @return the custActionType
	 */
	public String getCustActionType()
	{
	    return custActionType;
	}

	/**
	 * @param custActionType the custActionType to set
	 */
	public void setCustActionType(String custActionType)
	{
	    this.custActionType = custActionType;
	}

	/**
	 * @return the readFromMir
	 */
	public String getReadFromMir()
	{
	    return readFromMir;
	}

	/**
	 * @param readFromMir the readFromMir to set
	 */
	public void setReadFromMir(String readFromMir)
	{
	    this.readFromMir = readFromMir;
	}

	public String getFromSmart() {
		return fromSmart;
	}

	public void setFromSmart(String fromSmart) {
		this.fromSmart = fromSmart;
	}

	/**
	 * @return the fromSelectBox
	 */
	public String getFromSelectBox()
	{
	    return fromSelectBox;
	}

	/**
	 * @param fromSelectBox the fromSelectBox to set
	 */
	public void setFromSelectBox(String fromSelectBox)
	{
	    this.fromSelectBox = fromSelectBox;
	}

	/**
	 * @return the fromLiveSearch
	 */
	public String getFromLiveSearch()
	{
	    return fromLiveSearch;
	}

	/**
	 * @param fromLiveSearch the fromLiveSearch to set
	 */
	public void setFromLiveSearch(String fromLiveSearch)
	{
	    this.fromLiveSearch = fromLiveSearch;
	}

	public Boolean getCheckFomTrxDetails()
	{
	    return checkFomTrxDetails;
	}

	public void setCheckFomTrxDetails(Boolean checkFomTrxDetails)
	{
	    this.checkFomTrxDetails = checkFomTrxDetails;
	}

	public String getFromDynamicScreen()
	{
	    return fromDynamicScreen;
	}

	public void setFromDynamicScreen(String fromDynamicScreen)
	{
	    this.fromDynamicScreen = fromDynamicScreen;
	}
}