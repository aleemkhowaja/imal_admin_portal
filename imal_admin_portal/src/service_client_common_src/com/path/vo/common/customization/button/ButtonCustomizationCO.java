/**
 * 
 */
package com.path.vo.common.customization.button;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.IM_API_ARGUMENTVO;
import com.path.dbmaps.vo.IM_IMAL_APIVO;
import com.path.dbmaps.vo.SYS_DYN_SCREEN_DEFVO;
import com.path.dbmaps.vo.SYS_PARAM_ACTION_ARG_LISTVO;
import com.path.dbmaps.vo.SYS_PARAM_ACTION_ARG_MAPVO;
import com.path.dbmaps.vo.SYS_PARAM_ACTION_COND_MAPVO;
import com.path.dbmaps.vo.SYS_PARAM_BTN_CUSTVO;
import com.path.dbmaps.vo.SYS_PARAM_BTN_CUST_ACTIONSVO;
import com.path.dbmaps.vo.SYS_PARAM_BTN_CUST_OUTPUT_MAPVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ELEMENTSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ENTITY_TYPEVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;
import com.path.vo.common.reportresponse.ReportResponseCO;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * WorkFlowCO.java used to
 */
public class ButtonCustomizationCO extends BaseVO
{
    private SYS_PARAM_BTN_CUSTVO sysParamBtnCustVO = new SYS_PARAM_BTN_CUSTVO();
    private SYS_PARAM_BTN_CUST_ACTIONSVO sysParamBtnCustActionsVO = new SYS_PARAM_BTN_CUST_ACTIONSVO();
    private SYS_PARAM_ACTION_ARG_MAPVO sysParamActionArgMapVO = new SYS_PARAM_ACTION_ARG_MAPVO();
    private IM_IMAL_APIVO imImalApiVO = new IM_IMAL_APIVO();
    private IM_API_ARGUMENTVO imApiArgumentVO = new IM_API_ARGUMENTVO();
    private SYS_PARAM_ACTION_COND_MAPVO sysParamActionCondMapVO = new SYS_PARAM_ACTION_COND_MAPVO();
    private SYS_PARAM_SCREEN_ELEMENTSVO sysParamScreenElementsVO = new SYS_PARAM_SCREEN_ELEMENTSVO();
    private SYS_DYN_SCREEN_DEFVO dynScreenDefVO = new SYS_DYN_SCREEN_DEFVO();
    private CustomActionParamCO customActionParamCO = new CustomActionParamCO();
    private SYS_PARAM_BTN_CUST_OUTPUT_MAPVO sysParamBtnCustOutMap = new SYS_PARAM_BTN_CUST_OUTPUT_MAPVO();
    private SYS_PARAM_ACTION_ARG_LISTVO sysParamActionArgList   = new SYS_PARAM_ACTION_ARG_LISTVO();

    private String language;
    private String customBtnData;
    private String fieldDesc;
    private String propertyName;
    private String argDesc;
    private String actionDesc;
    private String operationDesc;
    private String excludeCurrentBtnActions;
    private BigDecimal linkToPreviousAction;
    private String executionResult;
    private String translatedLabelKey;
    private String translatedArgStatus;
    private String translatedArgType;
    private String userName;
    private Date   runningDate;
    private String gridUpdate;
    private String outputMapGridUpdate;
    private String dynScrParamMapGridUpdate;
    private String autoCompleteTags;
    private BigDecimal operationId;
    private BigDecimal buttonId;
    private String readonlyParentOp;
    private String parentOperationDesc;
    private String progRef;
    private String appName;
    private String toolbarId;
    private String currentAccessProgRef;
    private String REPORT_PROG_REF;//keep the name as upper case to stay compatible with the report lookup
    private BigDecimal DYN_SCREEN_ID; //keep the name as upper case to stay compatible with the dynamic screen lookup
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private String preferredLanguage;
    private String apiCodeValue;
    private String serviceTypeDesc;
    private BigDecimal dynScreenId;
    private BigDecimal fromDynScreenId;
    private BigDecimal fromDynElementId;
    private String globalOperationMode;
    private String btnApiDescription;
    private String mapDirection;
    private BigDecimal mapId;
    private Boolean proceedOnFail;
    private String proceedOnExpression;
    private BigDecimal linkOpId;
    private String actionArgListGridUpdate;

    private List<ReportResponseCO> reportResponseCOList = new ArrayList<ReportResponseCO>();
    private List<String> clientScriptList = new ArrayList<String>();
    private List<ButtonCustomizationCO> buttonCustCOList = new ArrayList<ButtonCustomizationCO>();
    //Add entityType list
    List<SYS_PARAM_SCREEN_ENTITY_TYPEVO> buttonCustCOEntityTypesList = new ArrayList<SYS_PARAM_SCREEN_ENTITY_TYPEVO>();
    private List<SysParamBtnCustOutMapSC> sysParamBtnCustOutList = new ArrayList<SysParamBtnCustOutMapSC>();
    private List<SysParamActionArgListSC> sysParamActionArgListArray = new ArrayList<SysParamActionArgListSC>();
    private List<DynamicScreenParamsMapCO>  dynamicScreenParamsMapCOList = new ArrayList<DynamicScreenParamsMapCO>();
    
    private String dynScreenAppName;
    private String dynScreenProgRef;
    private BigDecimal dynScreenCompCode;
    private BigDecimal dynScreenFldIdentifier;
    private BigDecimal mapElementType;    
    
    private List<CustomActionParamCO> customActionParamCOList = new ArrayList<CustomActionParamCO>();
    private List<CustomActionParamCO> globalOutputActionParamCOList = new ArrayList<CustomActionParamCO>();
    private Map<BigDecimal, Map<BigDecimal, CustomActionParamCO>> actionsParamMap;
    
    private String gridColumns;
    
    private SessionCO sessionCO;//TP 896475 Global activity after execution to return the script, screen, report...
    
    public SYS_PARAM_BTN_CUSTVO getSysParamBtnCustVO()
    {
        return sysParamBtnCustVO;
    }

    public void setSysParamBtnCustVO(SYS_PARAM_BTN_CUSTVO sysParamBtnCustVO)
    {
        this.sysParamBtnCustVO = sysParamBtnCustVO;
    }

    public SYS_PARAM_BTN_CUST_ACTIONSVO getSysParamBtnCustActionsVO()
    {
        return sysParamBtnCustActionsVO;
    }

    public void setSysParamBtnCustActionsVO(SYS_PARAM_BTN_CUST_ACTIONSVO sysParamBtnCustActionsVO)
    {
        this.sysParamBtnCustActionsVO = sysParamBtnCustActionsVO;
    }

    public IM_IMAL_APIVO getImImalApiVO()
    {
        return imImalApiVO;
    }

    public void setImImalApiVO(IM_IMAL_APIVO imImalApiVO)
    {
        this.imImalApiVO = imImalApiVO;
    }



    public SYS_PARAM_ACTION_ARG_MAPVO getSysParamActionArgMapVO()
    {
        return sysParamActionArgMapVO;
    }

    public void setSysParamActionArgMapVO(SYS_PARAM_ACTION_ARG_MAPVO sysParamActionArgMapVO)
    {
        this.sysParamActionArgMapVO = sysParamActionArgMapVO;
    }

    public String getCustomBtnData()
    {
        return customBtnData;
    }

    public void setCustomBtnData(String customBtnData)
    {
        this.customBtnData = customBtnData;
    }

    public String getFieldDesc()
    {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc)
    {
        this.fieldDesc = fieldDesc;
    }

    public IM_API_ARGUMENTVO getImApiArgumentVO()
    {
        return imApiArgumentVO;
    }

    public void setImApiArgumentVO(IM_API_ARGUMENTVO imApiArgumentVO)
    {
        this.imApiArgumentVO = imApiArgumentVO;
    }

    public String getExcludeCurrentBtnActions()
    {
        return excludeCurrentBtnActions;
    }

    public void setExcludeCurrentBtnActions(String excludeCurrentBtnActions)
    {
        this.excludeCurrentBtnActions = excludeCurrentBtnActions;
    }

    public BigDecimal getLinkToPreviousAction()
    {
        return linkToPreviousAction;
    }

    public void setLinkToPreviousAction(BigDecimal linkToPreviousAction)
    {
        this.linkToPreviousAction = linkToPreviousAction;
    }


    public List<ButtonCustomizationCO> getButtonCustCOList()
    {
        return buttonCustCOList;
    }

    public void setButtonCustCOList(List<ButtonCustomizationCO> buttonCustCOList)
    {
        this.buttonCustCOList = buttonCustCOList;
    }

    public String getExecutionResult()
    {
        return executionResult;
    }

    public void setExecutionResult(String executionResult)
    {
        this.executionResult = executionResult;
    }

    public String getTranslatedLabelKey()
    {
        return translatedLabelKey;
    }

    public void setTranslatedLabelKey(String translatedLabelKey)
    {
        this.translatedLabelKey = translatedLabelKey;
    }

    public String getTranslatedArgStatus()
    {
        return translatedArgStatus;
    }

    public void setTranslatedArgStatus(String translatedArgStatus)
    {
        this.translatedArgStatus = translatedArgStatus;
    }

    public String getTranslatedArgType()
    {
        return translatedArgType;
    }

    public void setTranslatedArgType(String translatedArgType)
    {
        this.translatedArgType = translatedArgType;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getArgDesc()
    {
        return argDesc;
    }

    public void setArgDesc(String argDesc)
    {
        this.argDesc = argDesc;
    }

    public String getActionDesc()
    {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc)
    {
        this.actionDesc = actionDesc;
    }

    public SYS_PARAM_ACTION_COND_MAPVO getSysParamActionCondMapVO()
    {
        return sysParamActionCondMapVO;
    }

    public void setSysParamActionCondMapVO(SYS_PARAM_ACTION_COND_MAPVO sysParamActionCondMapVO)
    {
        this.sysParamActionCondMapVO = sysParamActionCondMapVO;
    }

    public String getOperationDesc()
    {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc)
    {
        this.operationDesc = operationDesc;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Date getRunningDate()
    {
        return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    public String getGridUpdate()
    {
        return gridUpdate;
    }

    public void setGridUpdate(String gridUpdate)
    {
        this.gridUpdate = gridUpdate;
    }

    public String getAutoCompleteTags()
    {
        return autoCompleteTags;
    }

    public void setAutoCompleteTags(String autoCompleteTags)
    {
        this.autoCompleteTags = autoCompleteTags;
    }

    public BigDecimal getOperationId()
    {
        return operationId;
    }

    public void setOperationId(BigDecimal operationId)
    {
        this.operationId = operationId;
    }

    public BigDecimal getButtonId()
    {
        return buttonId;
    }

    public void setButtonId(BigDecimal buttonId)
    {
        this.buttonId = buttonId;
    }

    public String getReadonlyParentOp()
    {
        return readonlyParentOp;
    }

    public void setReadonlyParentOp(String readonlyParentOp)
    {
        this.readonlyParentOp = readonlyParentOp;
    }

    public String getParentOperationDesc()
    {
        return parentOperationDesc;
    }

    public void setParentOperationDesc(String parentOperationDesc)
    {
        this.parentOperationDesc = parentOperationDesc;
    }

    public SYS_PARAM_SCREEN_ELEMENTSVO getSysParamScreenElementsVO()
    {
        return sysParamScreenElementsVO;
    }

    public void setSysParamScreenElementsVO(SYS_PARAM_SCREEN_ELEMENTSVO sysParamScreenElementsVO)
    {
        this.sysParamScreenElementsVO = sysParamScreenElementsVO;
    }

    public String getProgRef()
    {
        return progRef;
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public String getToolbarId()
    {
        return toolbarId;
    }

    public void setToolbarId(String toolbarId)
    {
        this.toolbarId = toolbarId;
    }

    public String getCurrentAccessProgRef()
    {
        return currentAccessProgRef;
    }

    public void setCurrentAccessProgRef(String currentAccessProgRef)
    {
        this.currentAccessProgRef = currentAccessProgRef;
    }

    public String getREPORT_PROG_REF()
    {
        return REPORT_PROG_REF;
    }

    public void setREPORT_PROG_REF(String rEPORTPROGREF)
    {
        REPORT_PROG_REF = rEPORTPROGREF;
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

    public String getPreferredLanguage()
    {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
        this.preferredLanguage = preferredLanguage;
    }

    public String getApiCodeValue()
    {
        return apiCodeValue;
    }

    public void setApiCodeValue(String apiCodeValue)
    {
        this.apiCodeValue = apiCodeValue;
    }

    public String getServiceTypeDesc()
    {
        return serviceTypeDesc;
    }

    public void setServiceTypeDesc(String serviceTypeDesc)
    {
        this.serviceTypeDesc = serviceTypeDesc;
    }

    public List<ReportResponseCO> getReportResponseCOList()
    {
        return reportResponseCOList;
    }

    public void setReportResponseCOList(List<ReportResponseCO> reportResponseCOList)
    {
        this.reportResponseCOList = reportResponseCOList;
    }

    public List<String> getClientScriptList()
    {
        return clientScriptList;
    }

    public void setClientScriptList(List<String> clientScriptList)
    {
        this.clientScriptList = clientScriptList;
    }

    public SYS_DYN_SCREEN_DEFVO getDynScreenDefVO()
    {
        return dynScreenDefVO;
    }

    public void setDynScreenDefVO(SYS_DYN_SCREEN_DEFVO dynScreenDefVO)
    {
        this.dynScreenDefVO = dynScreenDefVO;
    }

    public BigDecimal getDynScreenId()
    {
        return dynScreenId;
    }

    public void setDynScreenId(BigDecimal dynScreenId)
    {
        this.dynScreenId = dynScreenId;
    }

    public String getGlobalOperationMode()
    {
        return globalOperationMode;
    }

    public void setGlobalOperationMode(String globalOperationMode)
    {
        this.globalOperationMode = globalOperationMode;
    }

    public BigDecimal getDYN_SCREEN_ID()
    {
        return DYN_SCREEN_ID;
    }

    public void setDYN_SCREEN_ID(BigDecimal dYNSCREENID)
    {
        DYN_SCREEN_ID = dYNSCREENID;
    }

    public CustomActionParamCO getCustomActionParamCO()
    {
        return customActionParamCO;
    }

    public void setCustomActionParamCO(CustomActionParamCO customActionParamCO)
    {
        this.customActionParamCO = customActionParamCO;
    }

    public String getDynScrParamMapGridUpdate()
    {
        return dynScrParamMapGridUpdate;
    }

    public void setDynScrParamMapGridUpdate(String dynScrParamMapGridUpdate)
    {
        this.dynScrParamMapGridUpdate = dynScrParamMapGridUpdate;
    }

    public List<DynamicScreenParamsMapCO> getDynamicScreenParamsMapCOList()
    {
        return dynamicScreenParamsMapCOList;
    }

    public void setDynamicScreenParamsMapCOList(List<DynamicScreenParamsMapCO> dynamicScreenParamsMapCOList)
    {
        this.dynamicScreenParamsMapCOList = dynamicScreenParamsMapCOList;
    }

    public String getDynScreenAppName()
    {
        return dynScreenAppName;
    }

    public void setDynScreenAppName(String dynScreenAppName)
    {
        this.dynScreenAppName = dynScreenAppName;
    }

    public String getDynScreenProgRef()
    {
        return dynScreenProgRef;
    }

    public void setDynScreenProgRef(String dynScreenProgRef)
    {
        this.dynScreenProgRef = dynScreenProgRef;
    }

    public BigDecimal getDynScreenCompCode()
    {
        return dynScreenCompCode;
    }

    public void setDynScreenCompCode(BigDecimal dynScreenCompCode)
    {
        this.dynScreenCompCode = dynScreenCompCode;
    }

    public BigDecimal getDynScreenFldIdentifier()
    {
        return dynScreenFldIdentifier;
    }

    public void setDynScreenFldIdentifier(BigDecimal dynScreenFldIdentifier)
    {
        this.dynScreenFldIdentifier = dynScreenFldIdentifier;
    }

    public BigDecimal getMapElementType()
    {
        return mapElementType;
    }

    public void setMapElementType(BigDecimal mapElementType)
    {
        this.mapElementType = mapElementType;
    }
    
    public String getBtnApiDescription()
    {
        return btnApiDescription;
    }

    public void setBtnApiDescription(String btnApiDescription)
    {
        this.btnApiDescription = btnApiDescription;
    }
    public String getMapDirection()
    {
        return mapDirection;
    }

    public void setMapDirection(String mapDirection)
    {
        this.mapDirection = mapDirection;
    }
    
    public BigDecimal getMapId()
    {
        return mapId;
    }

    public void setMapId(BigDecimal mapId)
    {
        this.mapId = mapId;
    }

    public List<CustomActionParamCO> getCustomActionParamCOList()
    {
        return customActionParamCOList;
    }

    public void setCustomActionParamCOList(List<CustomActionParamCO> customActionParamCOList)
    {
        this.customActionParamCOList = customActionParamCOList;
    }

    public List<CustomActionParamCO> getGlobalOutputActionParamCOList()
    {
        return globalOutputActionParamCOList;
    }

    public void setGlobalOutputActionParamCOList(List<CustomActionParamCO> globalOutputActionParamCOList)
    {
        this.globalOutputActionParamCOList = globalOutputActionParamCOList;
    }

    public Map<BigDecimal, Map<BigDecimal, CustomActionParamCO>> getActionsParamMap()
    {
        return actionsParamMap;
    }

    public void setActionsParamMap(Map<BigDecimal, Map<BigDecimal, CustomActionParamCO>> actionsParamMap)
    {
        this.actionsParamMap = actionsParamMap;
    }

    public Boolean getProceedOnFail()
    {
        return proceedOnFail;
    }

    public void setProceedOnFail(Boolean proceedOnFail)
    {
        this.proceedOnFail = proceedOnFail;
    }

    public String getProceedOnExpression()
    {
        return proceedOnExpression;
    }

    public void setProceedOnExpression(String proceedOnExpression)
    {
        this.proceedOnExpression = proceedOnExpression;
    }

    public BigDecimal getLinkOpId()
    {
        return linkOpId;
    }

    public void setLinkOpId(BigDecimal linkOpId)
    {
        this.linkOpId = linkOpId;
    }
    	
    public SYS_PARAM_BTN_CUST_OUTPUT_MAPVO getSysParamBtnCustOutMap()
    {
        return sysParamBtnCustOutMap;
    }

    public void setSysParamBtnCustOutMap(SYS_PARAM_BTN_CUST_OUTPUT_MAPVO sysParamBtnCustOutMap)
    {
        this.sysParamBtnCustOutMap = sysParamBtnCustOutMap;
    }

    public String getOutputMapGridUpdate()
    {
        return outputMapGridUpdate;
    }

    public void setOutputMapGridUpdate(String outputMapGridUpdate)
    {
        this.outputMapGridUpdate = outputMapGridUpdate;
    }

    public List<SysParamBtnCustOutMapSC> getSysParamBtnCustOutList()
    {
        return sysParamBtnCustOutList;
    }

    public void setSysParamBtnCustOutList(List<SysParamBtnCustOutMapSC> sysParamBtnCustOutList)
    {
        this.sysParamBtnCustOutList = sysParamBtnCustOutList;
    }
    
    public SYS_PARAM_ACTION_ARG_LISTVO getSysParamActionArgList()
    {
        return sysParamActionArgList;
    }

    public void setSysParamActionArgList(SYS_PARAM_ACTION_ARG_LISTVO sysParamActionArgList)
    {
        this.sysParamActionArgList = sysParamActionArgList;
    }

    public String getActionArgListGridUpdate()
    {
        return actionArgListGridUpdate;
    }

    public void setActionArgListGridUpdate(String actionArgListGridUpdate)
    {
        this.actionArgListGridUpdate = actionArgListGridUpdate;
    }

    public List<SysParamActionArgListSC> getSysParamActionArgListArray()
    {
        return sysParamActionArgListArray;
    }

    public void setSysParamActionArgListArray(List<SysParamActionArgListSC> sysParamActionArgListArray)
    {
        this.sysParamActionArgListArray = sysParamActionArgListArray;
    }

    public String getGridColumns()
    {
        return gridColumns;
    }

    public void setGridColumns(String gridColumns)
    {
        this.gridColumns = gridColumns;
    }

    /**
     * @return the fromDynScreenId
     */
    public BigDecimal getFromDynScreenId()
    {
        return fromDynScreenId;
    }

    /**
     * @param fromDynScreenId the fromDynScreenId to set
     */
    public void setFromDynScreenId(BigDecimal fromDynScreenId)
    {
        this.fromDynScreenId = fromDynScreenId;
    }

    /**
     * @return the fromDynElementId
     */
    public BigDecimal getFromDynElementId()
    {
        return fromDynElementId;
    }

    /**
     * @param fromDynElementId the fromDynElementId to set
     */
    public void setFromDynElementId(BigDecimal fromDynElementId)
    {
        this.fromDynElementId = fromDynElementId;
    }

    public SessionCO getSessionCO()
    {
        return sessionCO;
    }

    public void setSessionCO(SessionCO sessionCO)
    {
        this.sessionCO = sessionCO;
    }
    public List<SYS_PARAM_SCREEN_ENTITY_TYPEVO> getButtonCustCOEntityTypesList()
    {
        return buttonCustCOEntityTypesList;
    }

    public void setButtonCustCOEntityTypesList(List<SYS_PARAM_SCREEN_ENTITY_TYPEVO> buttonCustCOEntityTypesList)
    {
        this.buttonCustCOEntityTypesList = buttonCustCOEntityTypesList;
    }

    public String getPropertyName()
    {
        return propertyName;
    }

    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
    }
}
