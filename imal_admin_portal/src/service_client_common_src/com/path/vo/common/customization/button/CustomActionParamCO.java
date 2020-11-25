/**
 * 
 */
package com.path.vo.common.customization.button;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.SYS_PARAM_ACTION_ARG_LISTVO;
import com.path.struts2.lib.common.BaseObject;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          CustomActionParamsCO.java used to
 */
public class CustomActionParamCO extends BaseObject implements Comparable<CustomActionParamCO>
{
    private BigDecimal btnId;
    private BigDecimal operationId;
    private String operationType;
    private String appName;
    private String progRef;
    private BigDecimal actionId;
    private String procedureName;
    private String apiType;
    private BigDecimal argId;
    private String argName;
    private String argType;
    private String status;
    private String mapType;
    private String mapValue;
    private Object argValue;
    private BigDecimal linkActionId;
    private BigDecimal linkArgId;
    private String operationDesc;
    private String argDesc;
    private String condExpr;
    private String condResult;
    private BigDecimal condResultOpId;
    private BigDecimal condLineNo;
    private BigDecimal parentOpId;
    private String argDefaultVal;
    private String requiredArg;
    private String nestedArg;
    private String acceptType;
    private String contentType;
    private BigDecimal argOrder;
    private String mapDirection;
    
    private String soapOperation; 
    private String soapOperationLocalPart;
    private String soapMessagePrefix;
    private String soapNamespaces;
    private String soapAction;
    private String screenTitle;
    private BigDecimal screenWidth;
    private BigDecimal screenHeight;
    private String initialLoadParam;
    private List<SYS_PARAM_ACTION_ARG_LISTVO> sysParamActionArgList  =  new ArrayList<SYS_PARAM_ACTION_ARG_LISTVO>();
    private String mapExpression;
    private String dynParamType;
    private String delimiter;
    private String selectionType;
    private String fromSource;
    /*TP#983067 Option to load JS Method to be called from js File located on the server*/
    private String scriptUrl;
    
    // TP 1062269 Loading Report Assigned by Customization into provided Div or iFrame ID - Customization Enhancement
    private String componentId;

	public String getComponentId() 
	{
		return componentId;
	}
	
	public void setComponentId(String componentId) 
	{
		this.componentId = componentId;
	}
	
	public String getScriptUrl()
    {
	return scriptUrl;
    }
    public void setScriptUrl(String scriptUrl)
    {
	this.scriptUrl = scriptUrl;
    }
    public BigDecimal getBtnId()
    {
        return btnId;
    }
    public void setBtnId(BigDecimal btnId)
    {
        this.btnId = btnId;
    }
    public String getAppName()
    {
        return appName;
    }
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
    public BigDecimal getActionId()
    {
        return actionId;
    }
    public void setActionId(BigDecimal actionId)
    {
        this.actionId = actionId;
    }
    public String getProcedureName()
    {
        return procedureName;
    }
    public void setProcedureName(String procedureName)
    {
        this.procedureName = procedureName;
    }
    public String getApiType()
    {
        return apiType;
    }
    public void setApiType(String apiType)
    {
        this.apiType = apiType;
    }
    public BigDecimal getArgId()
    {
        return argId;
    }
    public void setArgId(BigDecimal argId)
    {
        this.argId = argId;
    }
    public String getArgName()
    {
        return argName;
    }
    public void setArgName(String argName)
    {
        this.argName = argName;
    }
    public String getArgType()
    {
        return argType;
    }
    public void setArgType(String argType)
    {
        this.argType = argType;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public String getMapType()
    {
        return mapType;
    }
    public void setMapType(String mapType)
    {
        this.mapType = mapType;
    }
    public String getMapValue()
    {
        return mapValue;
    }
    public void setMapValue(String mapValue)
    {
        this.mapValue = mapValue;
    }
    public Object getArgValue()
    {
        return argValue;
    }
    public void setArgValue(Object argValue)
    {
        this.argValue = argValue;
    }
    public BigDecimal getLinkActionId()
    {
        return linkActionId;
    }
    public void setLinkActionId(BigDecimal linkActionId)
    {
        this.linkActionId = linkActionId;
    }
    public BigDecimal getLinkArgId()
    {
        return linkArgId;
    }
    public void setLinkArgId(BigDecimal linkArgId)
    {
        this.linkArgId = linkArgId;
    }
    public BigDecimal getOperationId()
    {
        return operationId;
    }
    public void setOperationId(BigDecimal operationId)
    {
        this.operationId = operationId;
    }
    
    public String getOperationDesc()
    {
        return operationDesc;
    }
    public void setOperationDesc(String operationDesc)
    {
        this.operationDesc = operationDesc;
    }
    public String getArgDesc()
    {
        return argDesc;
    }
    public void setArgDesc(String argDesc)
    {
        this.argDesc = argDesc;
    }
    public String getCondExpr()
    {
        return condExpr;
    }
    public void setCondExpr(String condExpr)
    {
        this.condExpr = condExpr;
    }
    public String getCondResult()
    {
        return condResult;
    }
    public void setCondResult(String condResult)
    {
        this.condResult = condResult;
    }
    public BigDecimal getCondResultOpId()
    {
        return condResultOpId;
    }
    public void setCondResultOpId(BigDecimal condResultOpId)
    {
        this.condResultOpId = condResultOpId;
    }
    public String getOperationType()
    {
        return operationType;
    }
    public void setOperationType(String operationType)
    {
        this.operationType = operationType;
    }
    public BigDecimal getCondLineNo()
    {
        return condLineNo;
    }
    public void setCondLineNo(BigDecimal condLineNo)
    {
        this.condLineNo = condLineNo;
    }
    public BigDecimal getParentOpId()
    {
        return parentOpId;
    }
    public void setParentOpId(BigDecimal parentOpId)
    {
        this.parentOpId = parentOpId;
    }
    public String getArgDefaultVal()
    {
        return argDefaultVal;
    }
    public void setArgDefaultVal(String argDefaultVal)
    {
        this.argDefaultVal = argDefaultVal;
    }
    public String getRequiredArg()
    {
        return requiredArg;
    }
    public void setRequiredArg(String requiredArg)
    {
        this.requiredArg = requiredArg;
    }
    public String getAcceptType()
    {
        return acceptType;
    }
    public void setAcceptType(String acceptType)
    {
        this.acceptType = acceptType;
    }
    public String getContentType()
    {
        return contentType;
    }
    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }
    public BigDecimal getArgOrder()
    {
        return argOrder;
    }
    public void setArgOrder(BigDecimal argOrder)
    {
        this.argOrder = argOrder;
    }
    public String getSoapOperation()
    {
        return soapOperation;
    }
    public void setSoapOperation(String soapOperation)
    {
        this.soapOperation = soapOperation;
    }
    public String getSoapOperationLocalPart()
    {
        return soapOperationLocalPart;
    }
    public void setSoapOperationLocalPart(String soapOperationLocalPart)
    {
        this.soapOperationLocalPart = soapOperationLocalPart;
    }
    public String getSoapMessagePrefix()
    {
        return soapMessagePrefix;
    }
    public void setSoapMessagePrefix(String soapMessagePrefix)
    {
        this.soapMessagePrefix = soapMessagePrefix;
    }
    public String getSoapNamespaces()
    {
        return soapNamespaces;
    }
    public void setSoapNamespaces(String soapNamespaces)
    {
        this.soapNamespaces = soapNamespaces;
    }
    public String getSoapAction()
    {
        return soapAction;
    }
    public void setSoapAction(String soapAction)
    {
        this.soapAction = soapAction;
    }
    /**
     * @return the screenWidth
     */
    public BigDecimal getScreenWidth()
    {
        return screenWidth;
    }
    /**
     * @param screenWidth the screenWidth to set
     */
    public void setScreenWidth(BigDecimal screenWidth)
    {
        this.screenWidth = screenWidth;
    }
    /**
     * @return the screenHeight
     */
    public BigDecimal getScreenHeight()
    {
        return screenHeight;
    }
    /**
     * @param screenHeight the screenHeight to set
     */
    public void setScreenHeight(BigDecimal screenHeight)
    {
        this.screenHeight = screenHeight;
    }
    /**
     * The below compareTo is added to sort the CustomActionParamCO by argId
     * */
    @Override
    public int compareTo(CustomActionParamCO o)
    {
	if(o != null && o.argOrder != null && this.argOrder != null)
	{
	    return this.getArgOrder().compareTo(o.getArgOrder());
	}
	if(this.getArgId() == null || o == null || o.getArgId() == null)
	{
	    return 0;
	}
	return this.getArgId().compareTo(o.getArgId());
    }

    public String getMapDirection()
    {
        return mapDirection;
    }
    public void setMapDirection(String mapDirection)
    {
        this.mapDirection = mapDirection;
    }
    
    public String getInitialLoadParam()
    {
        return initialLoadParam;
    }
    public void setInitialLoadParam(String initialLoadParam)
    {
        this.initialLoadParam = initialLoadParam;
    }
    public List<SYS_PARAM_ACTION_ARG_LISTVO> getSysParamActionArgList()
    {
        return sysParamActionArgList;
    }
    public void setSysParamActionArgList(List<SYS_PARAM_ACTION_ARG_LISTVO> sysParamActionArgList)
    {
        this.sysParamActionArgList = sysParamActionArgList;
    }
    /**
     * @return the mapExpression
     */
    public String getMapExpression()
    {
        return mapExpression;
    }
    /**
     * @param mapExpression the mapExpression to set
     */
    public void setMapExpression(String mapExpression)
    {
        this.mapExpression = mapExpression;
    }
    public String getNestedArg()
    {
        return nestedArg;
    }
    public void setNestedArg(String nestedArg)
    {
        this.nestedArg = nestedArg;
    }
    public String getDynParamType()
    {
	return dynParamType;
    }
    public void setDynParamType(String dynParamType)
    {
	this.dynParamType = dynParamType;
    }
    public String getScreenTitle()
    {
        return screenTitle;
    }
    public void setScreenTitle(String screenTitle)
    {
        this.screenTitle = screenTitle;
    }
    public String getDelimiter()
    {
        return delimiter;
    }
    public void setDelimiter(String delimiter)
    {
        this.delimiter = delimiter;
    }
    public String getSelectionType()
    {
        return selectionType;
    }
    public void setSelectionType(String selectionType)
    {
        this.selectionType = selectionType;
    }
    public String getFromSource()
    {
        return fromSource;
    }
    public void setFromSource(String fromSource)
    {
        this.fromSource = fromSource;
    }
    
}
