package com.path.vo.common.screengenerator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ScreenGeneratorSC.java used to
 */
public class ScreenGeneratorSC extends GridParamsSC
{
    private BigDecimal screenId;
    private BigDecimal elementId;
    private String     elementType;
    private String     elementProperty;
    private String     newElem;
    private String     progRef;
    private String     langCode;
    private String     optionsData;
    private String     queryData;
    private String     sourceData;
    private String     modeType;
    private String     formatFieldId;
    private String     formatValue;
    private BigDecimal formatterValue;
    
    private String     paramId;
    private String     loadScriptData;
    private String     labelKey;
    
    private String     objectCode;
    private BigDecimal subObjectId;
    private String     objectType;
    //List of text fields on screen to be chosen as description fields for liveSearch element
    private String	lookupDesc;
    //List of elements available on screen to be assigned for label.
    private String	labelFor;
    
    //Boolean to check if CommonMethods.returnBoolConSyntax is needed on the value or not
    private boolean	valueExpression = false;
    private Map<String,Object> hmSessionExpVals = new HashMap<String,Object>();
    
    private BigDecimal  tableId;
    private String      tableName;
    
    private BigDecimal scrTableId;
    
    private BigDecimal    scrGridFlag;

    private String	relatedCol;
    
    //Bug 514831 Handling Radio Group label
    private String	groupLabel;
    private Map<String,DynamicScreenCO> elementsTypeMap = new HashMap<String,DynamicScreenCO>();
    
    private Map<String,DynamicScreenFileCO> dsFileHm;
    
    private Map<String,Object> colValHm;
    private Map<String,Object> pkColValHm;
    private BigDecimal colType;
    private Map<String,String> colTypeHm;
    
    private String colProperties;
    
    private Date minDate;
    private Date maxDate;
    private String fromProp;
    private String dateFormat;
    private BigDecimal tagInput;
    private Map<String,String> currElemProperties = new HashMap<String,String>();
    private Boolean omniFlagScr;
    private String forChange;
    private String loadEmptyGrid;
    private String screenParamMap;
    
    private String tableDatasource;
    private BigDecimal globalActivityId;    
    private boolean loadedInObjDisplay;
    private String propertyCode;
    private BigDecimal lovMapId;
    private BigDecimal lovDynParamType;    
    private BigDecimal restOperationId;
    private BigDecimal operationOutParameter;
    private BigDecimal buttonId;
    private String actionType;  
    private String mapDirection;
    private SessionCO sessionCO;
    private Map<String,SYS_PARAM_SCREEN_DISPLAYVO> displayMap;
    private String tableCreationSyntax;    
    private String dataInsertScript; 
    private Integer pageNumber; 
   
    private String screenFieldId; //SUPT190250 
    private boolean fromServiceCall;//dynamic screen is retrieved from Webservice call
    //TP#1009625 Dynamic Screen Customized Required
    private Map<String,Object> entityTypeInfosMap = new HashMap<String,Object>();
    //TP#1106431 mapping parameters of dynamic screen 
    private String dynScrParamMap;
    
    public String getScreenFieldId()
    {
        return screenFieldId;
    }
    public void setScreenFieldId(String screenFieldId)
    {
        this.screenFieldId = screenFieldId;
    }
    /**
     * @return the screenId
     */
    public BigDecimal getScreenId()
    {
        return screenId;
    }
    /**
     * @param screenId the screenId to set
     */
    public void setScreenId(BigDecimal screenId)
    {
        this.screenId = screenId;
    }
    /**
     * @return the progRef
     */
    public String getProgRef()
    {
        return progRef;
    }
    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
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
     * @return the langCode
     */
    public String getLangCode()
    {
        return langCode;
    }
    /**
     * @param langCode the langCode to set
     */
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
    /**
     * @return the newElem
     */
    public String getNewElem()
    {
        return newElem;
    }
    /**
     * @param newElem the newElem to set
     */
    public void setNewElem(String newElem)
    {
        this.newElem = newElem;
    }
    /**
     * @return the elementType
     */
    public String getElementType()
    {
        return elementType;
    }
    /**
     * @param elementType the elementType to set
     */
    public void setElementType(String elementType)
    {
        this.elementType = elementType;
    }
    /**
     * @return the optionsData
     */
    public String getOptionsData()
    {
        return optionsData;
    }
    /**
     * @param optionsData the optionsData to set
     */
    public void setOptionsData(String optionsData)
    {
        this.optionsData = optionsData;
    }
    /**
     * @return the queryData
     */
    public String getQueryData()
    {
        return queryData;
    }
    /**
     * @param queryData the queryData to set
     */
    public void setQueryData(String queryData)
    {
        this.queryData = queryData;
    }
    /**
     * @return the paramId
     */
    public String getParamId()
    {
        return paramId;
    }
    /**
     * @param paramId the paramId to set
     */
    public void setParamId(String paramId)
    {
        this.paramId = paramId;
    }
    /**
     * @return the sourceData
     */
    public String getSourceData()
    {
        return sourceData;
    }
    /**
     * @param sourceData the sourceData to set
     */
    public void setSourceData(String sourceData)
    {
        this.sourceData = sourceData;
    }
    /**
     * @return the modeType
     */
    public String getModeType()
    {
        return modeType;
    }
    /**
     * @param modeType the modeType to set
     */
    public void setModeType(String modeType)
    {
        this.modeType = modeType;
    }
    /**
     * @return the formatFieldId
     */
    public String getFormatFieldId()
    {
        return formatFieldId;
    }
    /**
     * @param formatFieldId the formatFieldId to set
     */
    public void setFormatFieldId(String formatFieldId)
    {
        this.formatFieldId = formatFieldId;
    }
    /**
     * @return the formatValue
     */
    public String getFormatValue()
    {
        return formatValue;
    }
    /**
     * @param formatValue the formatValue to set
     */
    public void setFormatValue(String formatValue)
    {
        this.formatValue = formatValue;
    }
    /**
     * @return the loadScriptData
     */
    public String getLoadScriptData()
    {
        return loadScriptData;
    }
    /**
     * @param loadScriptData the loadScriptData to set
     */
    public void setLoadScriptData(String loadScriptData)
    {
        this.loadScriptData = loadScriptData;
    }
    public String getLabelKey()
    {
        return labelKey;
    }
    public void setLabelKey(String labelKey)
    {
        this.labelKey = labelKey;
    }
    public String getObjectCode()
    {
        return objectCode;
    }
    public void setObjectCode(String objectCode)
    {
        this.objectCode = objectCode;
    }
    public String getObjectType()
    {
        return objectType;
    }
    public void setObjectType(String objectType)
    {
        this.objectType = objectType;
    }
    public BigDecimal getSubObjectId()
    {
        return subObjectId;
    }
    public void setSubObjectId(BigDecimal subObjectId)
    {
        this.subObjectId = subObjectId;
    }
    public String getLookupDesc()
    {
        return lookupDesc;
    }
    public void setLookupDesc(String lookupDesc)
    {
        this.lookupDesc = lookupDesc;
    }
    public String getLabelFor()
    {
        return labelFor;
    }
    public void setLabelFor(String labelFor)
    {
        this.labelFor = labelFor;
    }
    /**
     * @return the tableId
     */
    public BigDecimal getTableId()
    {
        return tableId;
    }
    /**
     * @param tableId the tableId to set
     */
    public void setTableId(BigDecimal tableId)
    {
        this.tableId = tableId;
    }
    /**
     * @return the tableName
     */
    public String getTableName()
    {
        return tableName;
    }
    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }
    public boolean isValueExpression()
    {
        return valueExpression;
    }
    public void setValueExpression(boolean valueExpression)
    {
        this.valueExpression = valueExpression;
    }
    /**
     * @return the hmSessionExpVals
     */
    public Map<String, Object> getHmSessionExpVals()
    {
        return hmSessionExpVals;
    }
    /**
     * @param hmSessionExpVals the hmSessionExpVals to set
     */
    public void setHmSessionExpVals(Map<String, Object> hmSessionExpVals)
    {
        this.hmSessionExpVals = hmSessionExpVals;
    }
    public String getRelatedCol()
    {
        return relatedCol;
    }
    public void setRelatedCol(String relatedCol)
    {
        this.relatedCol = relatedCol;
    }
    public String getGroupLabel()
    {
        return groupLabel;
    }

    public void setGroupLabel(String groupLabel)
    {
	this.groupLabel = groupLabel;
    }

    public BigDecimal getScrTableId()
    {
	return scrTableId;
    }

    public void setScrTableId(BigDecimal scrTableId)
    {
	this.scrTableId = scrTableId;
    }

    public BigDecimal getScrGridFlag()
    {
	return scrGridFlag;
    }

    public void setScrGridFlag(BigDecimal scrGridFlag)
    {
	this.scrGridFlag = scrGridFlag;
    }
    public Map<String,DynamicScreenFileCO> getDsFileHm()
    {
	return dsFileHm;
    }
    public void setDsFileHm(Map<String,DynamicScreenFileCO> dsFileHm)
    {
	this.dsFileHm = dsFileHm;
    }
    public Map<String,Object> getColValHm()
    {
	return colValHm;
    }
    public void setColValHm(Map<String,Object> colValHm)
    {
	this.colValHm = colValHm;
    }
    public Map<String,Object> getPkColValHm()
    {
	return pkColValHm;
    }
    public void setPkColValHm(Map<String,Object> pkColValHm)
    {
	this.pkColValHm = pkColValHm;
    }
    public BigDecimal getColType()
    {
	return colType;
    }
    public void setColType(BigDecimal colType)
    {
	this.colType = colType;
    }
    /**
     * @return the formatterValue
     */
    public BigDecimal getFormatterValue()
    {
        return formatterValue;
    }
    /**
     * @param formatterValue the formatterValue to set
     */
    public void setFormatterValue(BigDecimal formatterValue)
    {
        this.formatterValue = formatterValue;
    }
    
    public Map<String,String> getColTypeHm()
    {
	return colTypeHm;
    }
    
    public void setColTypeHm(Map<String,String> colTypeHm)
    {
	this.colTypeHm = colTypeHm;
    }
    
    public String getColProperties()
    {
	return colProperties;
    }
    
    public void setColProperties(String colProperties)
    {
	this.colProperties = colProperties;
    }
    public Map<String, DynamicScreenCO> getElementsTypeMap()
    {
        return elementsTypeMap;
    }
    public void setElementsTypeMap(Map<String, DynamicScreenCO> elementsTypeMap)
    {
        this.elementsTypeMap = elementsTypeMap;
    }
    /**
     * @return the minDate
     */
    public Date getMinDate()
    {
        return minDate;
    }
    /**
     * @param minDate the minDate to set
     */
    public void setMinDate(Date minDate)
    {
        this.minDate = minDate;
    }
    /**
     * @return the maxDate
     */
    public Date getMaxDate()
    {
        return maxDate;
    }
    /**
     * @param maxDate the maxDate to set
     */
    public void setMaxDate(Date maxDate)
    {
        this.maxDate = maxDate;
    }
    /**
     * @return the fromProp
     */
    public String getFromProp()
    {
        return fromProp;
    }
    /**
     * @param fromProp the fromProp to set
     */
    public void setFromProp(String fromProp)
    {
        this.fromProp = fromProp;
    }
    /**
     * @return the dateFormat
     */
    public String getDateFormat()
    {
        return dateFormat;
    }
    /**
     * @param dateFormat the dateFormat to set
     */
    public void setDateFormat(String dateFormat)
    {
        this.dateFormat = dateFormat;
    }
    /**
     * @return the tagInput
     */
    public BigDecimal getTagInput()
    {
        return tagInput;
    }
    /**
     * @param tagInput the tagInput to set
     */
    public void setTagInput(BigDecimal tagInput)
    {
        this.tagInput = tagInput;
    }
    /**
     * @return the currElemProperties
     */
    public Map<String, String> getCurrElemProperties()
    {
        return currElemProperties;
    }
    /**
     * @param currElemProperties the currElemProperties to set
     */
    public void setCurrElemProperties(Map<String, String> currElemProperties)
    {
        this.currElemProperties = currElemProperties;
    }
    /**
     * @return the omniFlagScr
     */
    public Boolean getOmniFlagScr()
    {
        return omniFlagScr;
    }
    /**
     * @param omniFlagScr the omniFlagScr to set
     */
    public void setOmniFlagScr(Boolean omniFlagScr)
    {
        this.omniFlagScr = omniFlagScr;
    }
    /**
     * @return the forChange
     */
    public String getForChange()
    {
        return forChange;
    }
    /**
     * @param forChange the forChange to set
     */
    public void setForChange(String forChange)
    {
        this.forChange = forChange;
    }
    /**
     * @return the loadEmptyGrid
     */
    public String getLoadEmptyGrid()
    {
        return loadEmptyGrid;
    }
    /**
     * @param loadEmptyGrid the loadEmptyGrid to set
     */
    public void setLoadEmptyGrid(String loadEmptyGrid)
    {
        this.loadEmptyGrid = loadEmptyGrid;
    }
    /**
     * @return the screenParamMap
     */
    public String getScreenParamMap()
    {
        return screenParamMap;
    }
    /**
     * @param screenParamMap the screenParamMap to set
     */
    public void setScreenParamMap(String screenParamMap)
    {
        this.screenParamMap = screenParamMap;
    }
    /**
     * @return the elementProperty
     */
    public String getElementProperty()
    {
        return elementProperty;
    }
    /**
     * @param elementProperty the elementProperty to set
     */
    public void setElementProperty(String elementProperty)
    {
        this.elementProperty = elementProperty;
    }
	public String getTableDatasource() {
		return tableDatasource;
	}
	public void setTableDatasource(String tableDatasource) {
		this.tableDatasource = tableDatasource;
	}
	public BigDecimal getGlobalActivityId() {
		return globalActivityId;
	}
	public void setGlobalActivityId(BigDecimal globalActivityId) {
		this.globalActivityId = globalActivityId;
	}
	public boolean isLoadedInObjDisplay() {
		return loadedInObjDisplay;
	}
	public void setLoadedInObjDisplay(boolean loadedInObjDisplay) {
		this.loadedInObjDisplay = loadedInObjDisplay;
	}
	public String getPropertyCode() {
		return propertyCode;
	}
	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}
	public BigDecimal getLovMapId() {
		return lovMapId;
	}
	public void setLovMapId(BigDecimal lovMapId) {
		this.lovMapId = lovMapId;
	}
	public BigDecimal getLovDynParamType() {
		return lovDynParamType;
	}
	public void setLovDynParamType(BigDecimal lovDynParamType) {
		this.lovDynParamType = lovDynParamType;
	}
	public BigDecimal getRestOperationId() {
		return restOperationId;
	}
	public void setRestOperationId(BigDecimal restOperationId) {
		this.restOperationId = restOperationId;
	}
	public BigDecimal getOperationOutParameter() {
		return operationOutParameter;
	}
	public void setOperationOutParameter(BigDecimal operationOutParameter) {
		this.operationOutParameter = operationOutParameter;
	}
	public BigDecimal getButtonId() {
		return buttonId;
	}
	public void setButtonId(BigDecimal buttonId) {
		this.buttonId = buttonId;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getMapDirection() {
		return mapDirection;
	}
	public void setMapDirection(String mapDirection) {
		this.mapDirection = mapDirection;
	}
	public SessionCO getSessionCO() {
		return sessionCO;
	}
	public void setSessionCO(SessionCO sessionCO) {
		this.sessionCO = sessionCO;
	}
	public Map<String, SYS_PARAM_SCREEN_DISPLAYVO> getDisplayMap() {
		return displayMap;
	}
	public void setDisplayMap(Map<String, SYS_PARAM_SCREEN_DISPLAYVO> displayMap) {
		this.displayMap = displayMap;
	}
	public String getTableCreationSyntax() {
		return tableCreationSyntax;
	}
	public void setTableCreationSyntax(String tableCreationSyntax) {
		this.tableCreationSyntax = tableCreationSyntax;
	}
	public String getDataInsertScript() {
		return dataInsertScript;
	}
	public void setDataInsertScript(String dataInsertScript) {
		this.dataInsertScript = dataInsertScript;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	/**
	 * @return the entityTypeInfosMap
	 */
	public Map<String,Object> getEntityTypeInfosMap()
	{
	    return entityTypeInfosMap;
	}
	/**
	 * @param entityTypeInfosMap the entityTypeInfosMap to set
	 */
	public void setEntityTypeInfosMap(Map<String,Object> entityTypeInfosMap)
	{
	    this.entityTypeInfosMap = entityTypeInfosMap;
	}
	public boolean isFromServiceCall()
	{
	    return fromServiceCall;
	}
	public void setFromServiceCall(boolean fromServiceCall)
	{
	    this.fromServiceCall = fromServiceCall;
	}
	public String getDynScrParamMap()
	{
	    return dynScrParamMap;
	}
	public void setDynScrParamMap(String dynScrParamMap)
	{
	    this.dynScrParamMap = dynScrParamMap;
	}
	 
}
