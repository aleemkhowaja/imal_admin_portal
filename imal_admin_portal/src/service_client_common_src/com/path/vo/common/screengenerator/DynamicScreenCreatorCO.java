/**
 * 
 */
package com.path.vo.common.screengenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.SYS_DYN_SCREEN_DEFVO;
import com.path.dbmaps.vo.SYS_DYN_SCREEN_ELEMENTS_DETVO;
import com.path.dbmaps.vo.SYS_DYN_TABLE_DETVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.admin.dynamicparams.DynamicParamsVO;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DynamicScreenCreatorCO.java used to
 */
public class DynamicScreenCreatorCO  extends BaseVO
{
    private SYS_DYN_SCREEN_DEFVO         sysDynScreenDefVO   = new SYS_DYN_SCREEN_DEFVO();
    private SYS_DYN_TABLE_DETVO			 sysDynTableDetVO 	 = new SYS_DYN_TABLE_DETVO();
    private String REPORT_PROG_REF;
    private List<DynamicScreenDetailsCO> dynScreenDetailsLst = new ArrayList<DynamicScreenDetailsCO>();
    private String     property_code;
    private String     property_value;
    private String     property_big_value;
    private BigDecimal elementId;
    private BigDecimal elementType;
    private String     elementMode;
    private String     appDesc;
    private String     theId;
    private String     propName;
    private BigDecimal operationId;
    private String     onLoadScript;
    private String     screenDesc;
    private Boolean    createFrom;
    private BigDecimal createFromId;
    
    private BigDecimal techId;
    private BigDecimal parentTechId;
    
    
    private String elemId;
    private String elemName;
    private String elemValue;
    private String elemValExp;
    private String requiredExp;
    private String readOnlyExp;
    private String visibilityExp;
    private String elemFormat;
    
    private String langCode;
    private String respMsg;
    /**
     * used to check the mode when filling the nbFormat/txtFormat in construction 
     * in case the mode is numeric will fill nbFormat otherwise will fill txtFormat.
     */
    private String currElemMode;
    
    private BigDecimal scrTableId;
    private String     scrTableTechName;
    private String     scrTableDesc;
    private BigDecimal scrGridFlag;
    private String     elementMapKey;
    private String     lookupDesc;
    
    private String     topPos;
    private String     leftPos;
    private String     widthProp;
    private String     heightProp;
    private String     onChangeProp;
    private String     stepperProp;
    
    /**
     * Used to know the type for each variable that is exists inside the screen
     * to used it later for the expression validation
     */
    private HashMap<String,BigDecimal> variablesMap = new HashMap<String,BigDecimal>();
    /**
     * used to get the existsElements Ids, based on them we can know the deleted elements
     */
    private List<BigDecimal> existElemIds = new ArrayList<BigDecimal>();
    
    private List<SYS_DYN_SCREEN_ELEMENTS_DETVO> elemDets = new ArrayList<SYS_DYN_SCREEN_ELEMENTS_DETVO>();
    private List<LinkedElementsCO> linkedElements = new ArrayList<LinkedElementsCO>();
    private String omniChannelScr;
    
    private BigDecimal globalActivityId;
    private String globalActivityDesc;
    
    private BigDecimal restOperationId;
    private String restOperationDesc;
    
    private BigDecimal operationOutParameter;
    private String operationOutParameterDesc;
    
    private BigDecimal apiCode;
    private String apiDescription;
    
    private String restOperationOutArgName;
    
    private BigDecimal operationMapType;
    private String operationMapValue;
    private DynamicParamsVO dynScrParamVO;
    /**
     * @return the sysDynScreenDefVO
     */
    public SYS_DYN_SCREEN_DEFVO getSysDynScreenDefVO()
    {
        return sysDynScreenDefVO;
    }
    /**
     * @param sysDynScreenDefVO the sysDynScreenDefVO to set
     */
    public void setSysDynScreenDefVO(SYS_DYN_SCREEN_DEFVO sysDynScreenDefVO)
    {
        this.sysDynScreenDefVO = sysDynScreenDefVO;
    }
    public SYS_DYN_TABLE_DETVO getSysDynTableDetVO() {
		return sysDynTableDetVO;
	}
	public void setSysDynTableDetVO(SYS_DYN_TABLE_DETVO sysDynTableDetVO) {
		this.sysDynTableDetVO = sysDynTableDetVO;
	}
	/**
     * @return the property_code
     */
    public String getProperty_code()
    {
        return property_code;
    }
    /**
     * @param propertyCode the property_code to set
     */
    public void setProperty_code(String propertyCode)
    {
        property_code = propertyCode;
    }
    /**
     * @return the property_value
     */
    public String getProperty_value()
    {
        return property_value;
    }
    /**
     * @param propertyValue the property_value to set
     */
    public void setProperty_value(String propertyValue)
    {
        property_value = propertyValue;
    }
    /**
     * @return the elementType
     */
    public BigDecimal getElementType()
    {
        return elementType;
    }
    /**
     * @param elementType the elementType to set
     */
    public void setElementType(BigDecimal elementType)
    {
        this.elementType = elementType;
    }
    /**
     * @return the elementId
     */
    public BigDecimal getElementId()
    {
        return elementId;
    }
    /**
     * @param elementId the elementId to set
     */
    public void setElementId(BigDecimal elementId)
    {
        this.elementId = elementId;
    }
    /**
     * @return the property_big_value
     */
    public String getProperty_big_value()
    {
        return property_big_value;
    }
    /**
     * @param propertyBigValue the property_big_value to set
     */
    public void setProperty_big_value(String propertyBigValue)
    {
        property_big_value = propertyBigValue;
    }
    /**
     * @return the appDesc
     */
    public String getAppDesc()
    {
        return appDesc;
    }
    /**
     * @param appDesc the appDesc to set
     */
    public void setAppDesc(String appDesc)
    {
        this.appDesc = appDesc;
    }
    /**
     * @return the theId
     */
    public String getTheId()
    {
        return theId;
    }
    /**
     * @param theId the theId to set
     */
    public void setTheId(String theId)
    {
        this.theId = theId;
    }
    /**
     * @return the variablesMap
     */
    public HashMap<String, BigDecimal> getVariablesMap()
    {
        return variablesMap;
    }
    /**
     * @param variablesMap the variablesMap to set
     */
    public void setVariablesMap(HashMap<String, BigDecimal> variablesMap)
    {
        this.variablesMap = variablesMap;
    }
    /**
     * @return the existElemIds
     */
    public List<BigDecimal> getExistElemIds()
    {
        return existElemIds;
    }
    /**
     * @param existElemIds the existElemIds to set
     */
    public void setExistElemIds(List<BigDecimal> existElemIds)
    {
        this.existElemIds = existElemIds;
    }
    /**
     * @return the onLoadScript
     */
    public String getOnLoadScript()
    {
        return onLoadScript;
    }
    /**
     * @param onLoadScript the onLoadScript to set
     */
    public void setOnLoadScript(String onLoadScript)
    {
        this.onLoadScript = onLoadScript;
    }
    public BigDecimal getOperationId()
    {
        return operationId;
    }
    public void setOperationId(BigDecimal operationId)
    {
        this.operationId = operationId;
    }
    public Boolean getCreateFrom()
    {
        return createFrom;
    }
    public void setCreateFrom(Boolean createFrom)
    {
        this.createFrom = createFrom;
    }
    public BigDecimal getCreateFromId()
    {
        return createFromId;
    }
    public void setCreateFromId(BigDecimal createFromId)
    {
        this.createFromId = createFromId;
    }
    public BigDecimal getTechId()
    {
        return techId;
    }
    public void setTechId(BigDecimal techId)
    {
        this.techId = techId;
    }
    public BigDecimal getParentTechId()
    {
        return parentTechId;
    }
    public void setParentTechId(BigDecimal parentTechId)
    {
        this.parentTechId = parentTechId;
    }
    public String getElemId()
    {
        return elemId;
    }
    public void setElemId(String elemId)
    {
        this.elemId = elemId;
    }
    public String getElemName()
    {
        return elemName;
    }
    public void setElemName(String elemName)
    {
        this.elemName = elemName;
    }
    public String getElemValue()
    {
        return elemValue;
    }
    public void setElemValue(String elemValue)
    {
        this.elemValue = elemValue;
    }
    public String getRequiredExp()
    {
        return requiredExp;
    }
    public void setRequiredExp(String requiredExp)
    {
        this.requiredExp = requiredExp;
    }
    public String getReadOnlyExp()
    {
        return readOnlyExp;
    }
    public void setReadOnlyExp(String readOnlyExp)
    {
        this.readOnlyExp = readOnlyExp;
    }
    public String getVisibilityExp()
    {
        return visibilityExp;
    }
    public void setVisibilityExp(String visibilityExp)
    {
        this.visibilityExp = visibilityExp;
    }
    public String getElementMode()
    {
        return elementMode;
    }
    public void setElementMode(String elementMode)
    {
        this.elementMode = elementMode;
    }
    public String getElemValExp()
    {
        return elemValExp;
    }
    public void setElemValExp(String elemValExp)
    {
        this.elemValExp = elemValExp;
    }
    public String getLangCode()
    {
        return langCode;
    }
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
    public String getRespMsg()
    {
        return respMsg;
    }
    public void setRespMsg(String respMsg)
    {
        this.respMsg = respMsg;
    }
    /**
     * @return the dynScreenDetailsLst
     */
    public List<DynamicScreenDetailsCO> getDynScreenDetailsLst()
    {
        return dynScreenDetailsLst;
    }
    /**
     * @param dynScreenDetailsLst the dynScreenDetailsLst to set
     */
    public void setDynScreenDetailsLst(List<DynamicScreenDetailsCO> dynScreenDetailsLst)
    {
        this.dynScreenDetailsLst = dynScreenDetailsLst;
    }
    /**
     * @return the screenDesc
     */
    public String getScreenDesc()
    {
        return screenDesc;
    }
    /**
     * @param screenDesc the screenDesc to set
     */
    public void setScreenDesc(String screenDesc)
    {
        this.screenDesc = screenDesc;
    }
    /**
     * @return the scrTableTechName
     */
    public String getScrTableTechName()
    {
        return scrTableTechName;
    }
    /**
     * @param scrTableTechName the scrTableTechName to set
     */
    public void setScrTableTechName(String scrTableTechName)
    {
        this.scrTableTechName = scrTableTechName;
    }
    /**
     * @return the scrTableDesc
     */
    public String getScrTableDesc()
    {
        return scrTableDesc;
    }
    /**
     * @param scrTableDesc the scrTableDesc to set
     */
    public void setScrTableDesc(String scrTableDesc)
    {
        this.scrTableDesc = scrTableDesc;
    }
    /**
     * @return the scrTableId
     */
    public BigDecimal getScrTableId()
    {
        return scrTableId;
    }
    /**
     * @param scrTableId the scrTableId to set
     */
    public void setScrTableId(BigDecimal scrTableId)
    {
        this.scrTableId = scrTableId;
    }
    /**
     * @return the currElemMode
     */
    public String getCurrElemMode()
    {
        return currElemMode;
    }
    /**
     * @param currElemMode the currElemMode to set
     */
    public void setCurrElemMode(String currElemMode)
    {
        this.currElemMode = currElemMode;
    }
	public BigDecimal getScrGridFlag() {
		return scrGridFlag;
	}
	public void setScrGridFlag(BigDecimal scrGridFlag) {
		this.scrGridFlag = scrGridFlag;
	}
	public String getElementMapKey()
	{
	    return elementMapKey;
	}
	public void setElementMapKey(String elementMapKey)
	{
	    this.elementMapKey = elementMapKey;
	}
	
	/**
	 * @return the lookupDesc
	 */
	public String getLookupDesc()
	{
	    return lookupDesc;
	}
	/**
	 * @param lookupDesc the lookupDesc to set
	 */
	public void setLookupDesc(String lookupDesc)
	{
	    this.lookupDesc = lookupDesc;
	}
	/**
	 * @return the elemDets
	 */
	public List<SYS_DYN_SCREEN_ELEMENTS_DETVO> getElemDets()
	{
	    return elemDets;
	}
	/**
	 * @param elemDets the elemDets to set
	 */
	public void setElemDets(List<SYS_DYN_SCREEN_ELEMENTS_DETVO> elemDets)
	{
	    this.elemDets = elemDets;
	}
	/**
	 * @return the elemFormat
	 */
	public String getElemFormat()
	{
	    return elemFormat;
	}
	/**
	 * @param elemFormat the elemFormat to set
	 */
	public void setElemFormat(String elemFormat)
	{
	    this.elemFormat = elemFormat;
	}
	/**
	 * @return the topPos
	 */
	public String getTopPos()
	{
	    return topPos;
	}
	/**
	 * @param topPos the topPos to set
	 */
	public void setTopPos(String topPos)
	{
	    this.topPos = topPos;
	}
	/**
	 * @return the leftPos
	 */
	public String getLeftPos()
	{
	    return leftPos;
	}
	/**
	 * @param leftPos the leftPos to set
	 */
	public void setLeftPos(String leftPos)
	{
	    this.leftPos = leftPos;
	}
	/**
	 * @return the propName
	 */
	public String getPropName()
	{
	    return propName;
	}
	/**
	 * @param propName the propName to set
	 */
	public void setPropName(String propName)
	{
	    this.propName = propName;
	}
	/**
	 * @return the widthProp
	 */
	public String getWidthProp()
	{
	    return widthProp;
	}
	/**
	 * @param widthProp the widthProp to set
	 */
	public void setWidthProp(String widthProp)
	{
	    this.widthProp = widthProp;
	}
	/**
	 * @return the heightProp
	 */
	public String getHeightProp()
	{
	    return heightProp;
	}
	/**
	 * @param heightProp the heightProp to set
	 */
	public void setHeightProp(String heightProp)
	{
	    this.heightProp = heightProp;
	}
	/**
	 * @return the linkedElements
	 */
	public List<LinkedElementsCO> getLinkedElements()
	{
	    return linkedElements;
	}
	/**
	 * @param linkedElements the linkedElements to set
	 */
	public void setLinkedElements(List<LinkedElementsCO> linkedElements)
	{
	    this.linkedElements = linkedElements;
	}
	/**
	 * @return the onChangeProp
	 */
	public String getOnChangeProp()
	{
	    return onChangeProp;
	}
	/**
	 * @param onChangeProp the onChangeProp to set
	 */
	public void setOnChangeProp(String onChangeProp)
	{
	    this.onChangeProp = onChangeProp;
	}
	/**
	 * @return the omniChannelScr
	 */
	public String getOmniChannelScr()
	{
	    return omniChannelScr;
	}
	/**
	 * @param omniChannelScr the omniChannelScr to set
	 */
	public void setOmniChannelScr(String omniChannelScr)
	{
	    this.omniChannelScr = omniChannelScr;
	}
	/**
	 * @return the stepperProp
	 */
	public String getStepperProp()
	{
	    return stepperProp;
	}
	/**
	 * @param stepperProp the stepperProp to set
	 */
	public void setStepperProp(String stepperProp)
	{
	    this.stepperProp = stepperProp;
	}
	public BigDecimal getGlobalActivityId() {
		return globalActivityId;
	}
	public void setGlobalActivityId(BigDecimal globalActivityId) {
		this.globalActivityId = globalActivityId;
	}
	public String getGlobalActivityDesc() {
		return globalActivityDesc;
	}
	public void setGlobalActivityDesc(String globalActivityDesc) {
		this.globalActivityDesc = globalActivityDesc;
	}
	public BigDecimal getRestOperationId() {
		return restOperationId;
	}
	public void setRestOperationId(BigDecimal restOperationId) {
		this.restOperationId = restOperationId;
	}
	public String getRestOperationDesc() {
		return restOperationDesc;
	}
	public void setRestOperationDesc(String restOperationDesc) {
		this.restOperationDesc = restOperationDesc;
	}
	public BigDecimal getOperationOutParameter() {
		return operationOutParameter;
	}
	public void setOperationOutParameter(BigDecimal operationOutParameter) {
		this.operationOutParameter = operationOutParameter;
	}
	public String getOperationOutParameterDesc() {
		return operationOutParameterDesc;
	}
	public void setOperationOutParameterDesc(String operationOutParameterDesc) {
		this.operationOutParameterDesc = operationOutParameterDesc;
	}
	public BigDecimal getApiCode() {
		return apiCode;
	}
	public void setApiCode(BigDecimal apiCode) {
		this.apiCode = apiCode;
	}
	public String getApiDescription() {
		return apiDescription;
	}
	public void setApiDescription(String apiDescription) {
		this.apiDescription = apiDescription;
	}
	public String getRestOperationOutArgName() {
		return restOperationOutArgName;
	}
	public void setRestOperationOutArgName(String restOperationOutArgName) {
		this.restOperationOutArgName = restOperationOutArgName;
	}
	public BigDecimal getOperationMapType() {
		return operationMapType;
	}
	public void setOperationMapType(BigDecimal operationMapType) {
		this.operationMapType = operationMapType;
	}
	public String getOperationMapValue() {
		return operationMapValue;
	}
	public void setOperationMapValue(String operationMapValue) {
		this.operationMapValue = operationMapValue;
	}
	public String getREPORT_PROG_REF()
	{
	    return REPORT_PROG_REF;
	}
	public void setREPORT_PROG_REF(String rEPORT_PROG_REF)
	{
	    REPORT_PROG_REF = rEPORT_PROG_REF;
	}
	public DynamicParamsVO getDynScrParamVO()
	{
	    return dynScrParamVO;
	}
	public void setDynScrParamVO(DynamicParamsVO dynScrParamVO)
	{
	    this.dynScrParamVO = dynScrParamVO;
	}

}
