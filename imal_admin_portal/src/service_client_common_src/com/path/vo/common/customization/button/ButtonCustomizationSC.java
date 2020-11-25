package com.path.vo.common.customization.button;

import java.math.BigDecimal;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

public class ButtonCustomizationSC extends GridParamsSC
{
    private String progRef;
    private String toolBarId;
    private BigDecimal buttonId;
    private BigDecimal actionId;
    private BigDecimal dynScreenId;
    private BigDecimal dynElementId;
    private BigDecimal operationId;
    private BigDecimal argId;
    private String onBtnLoad;
    private String showArgDetails;
    private BigDecimal fldIdentifier;
    private String argType;
    private BigDecimal linkToPreviousAction;
    private BigDecimal dependentOpId;
    private BigDecimal statusLovTypeId;
    private String buttonsByParentRef;
    private String actionType;
    private String reportRef;
    private String mapType;
    private String globalParamMap;
    private String mapDirection;
    private boolean isGlobalActivity;
    private String btnProgRef;
    private BigDecimal apiCode;
    private BigDecimal elemSequenceId;
    
    //dynamic procedure call parameters
    private List<CustomActionParamCO> customActionParamCOList;
    private String procedureName;
    private String procedureParams;
    private String updateToNull;
    private List<BigDecimal> idList;
    private String apiType;
    private String gridColumns;
    
    public String getProgRef()
    {
        return progRef;
    }
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    public String getToolBarId()
    {
        return toolBarId;
    }
    public void setToolBarId(String toolBarId)
    {
        this.toolBarId = toolBarId;
    }
    public BigDecimal getButtonId()
    {
        return buttonId;
    }
    public void setButtonId(BigDecimal buttonId)
    {
        this.buttonId = buttonId;
    }
    public BigDecimal getActionId()
    {
        return actionId;
    }
    public void setActionId(BigDecimal actionId)
    {
        this.actionId = actionId;
    }
    public String getOnBtnLoad()
    {
        return onBtnLoad;
    }
    public void setOnBtnLoad(String onBtnLoad)
    {
        this.onBtnLoad = onBtnLoad;
    }
    public String getShowArgDetails()
    {
        return showArgDetails;
    }
    public void setShowArgDetails(String showArgDetails)
    {
        this.showArgDetails = showArgDetails;
    }
    public List<CustomActionParamCO> getCustomActionParamCOList()
    {
        return customActionParamCOList;
    }
    public void setCustomActionParamCOList(List<CustomActionParamCO> customActionParamCOList)
    {
        this.customActionParamCOList = customActionParamCOList;
    }
    public String getProcedureName()
    {
        return procedureName;
    }
    public void setProcedureName(String procedureName)
    {
        this.procedureName = procedureName;
    }
    public String getProcedureParams()
    {
        return procedureParams;
    }
    public void setProcedureParams(String procedureParams)
    {
        this.procedureParams = procedureParams;
    }
    public BigDecimal getFldIdentifier()
    {
        return fldIdentifier;
    }
    public void setFldIdentifier(BigDecimal fldIdentifier)
    {
        this.fldIdentifier = fldIdentifier;
    }
    public BigDecimal getLinkToPreviousAction()
    {
        return linkToPreviousAction;
    }
    public void setLinkToPreviousAction(BigDecimal linkToPreviousAction)
    {
        this.linkToPreviousAction = linkToPreviousAction;
    }
    public String getArgType()
    {
        return argType;
    }
    public void setArgType(String argType)
    {
        this.argType = argType;
    }
    public BigDecimal getArgId()
    {
        return argId;
    }
    public void setArgId(BigDecimal argId)
    {
        this.argId = argId;
    }
    public BigDecimal getOperationId()
    {
        return operationId;
    }
    public void setOperationId(BigDecimal operationId)
    {
        this.operationId = operationId;
    }
    public BigDecimal getDependentOpId()
    {
        return dependentOpId;
    }
    public void setDependentOpId(BigDecimal dependentOpId)
    {
        this.dependentOpId = dependentOpId;
    }
    public BigDecimal getStatusLovTypeId()
    {
        return statusLovTypeId;
    }
    public void setStatusLovTypeId(BigDecimal statusLovTypeId)
    {
        this.statusLovTypeId = statusLovTypeId;
    }
    public String getUpdateToNull()
    {
        return updateToNull;
    }
    public void setUpdateToNull(String updateToNull)
    {
        this.updateToNull = updateToNull;
    }
    public List<BigDecimal> getIdList()
    {
        return idList;
    }
    public void setIdList(List<BigDecimal> idList)
    {
        this.idList = idList;
    }
    public String getButtonsByParentRef()
    {
        return buttonsByParentRef;
    }
    public void setButtonsByParentRef(String buttonsByParentRef)
    {
        this.buttonsByParentRef = buttonsByParentRef;
    }
    public String getActionType()
    {
        return actionType;
    }
    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }
    public String getReportRef()
    {
        return reportRef;
    }
    public void setReportRef(String reportRef)
    {
        this.reportRef = reportRef;
    }
    public BigDecimal getDynScreenId()
    {
        return dynScreenId; 
    }
    public void setDynScreenId(BigDecimal dynScreenId)
    {
        this.dynScreenId = dynScreenId;
    }
    public String getMapType()
    {
        return mapType;
    }
    public void setMapType(String mapType)
    {
        this.mapType = mapType;
    }
    
    public String getMapDirection()
    {
        return mapDirection;
    }
    public void setMapDirection(String mapDirection)
    {
        this.mapDirection = mapDirection;
    }
    public String getGlobalParamMap()
    {
        return globalParamMap;
    }
    public void setGlobalParamMap(String globalParamMap)
    {
        this.globalParamMap = globalParamMap;
    }
    public boolean isGlobalActivity()
    {
        return isGlobalActivity;
    }
    public void setGlobalActivity(boolean isGlobalActivity)
    {
        this.isGlobalActivity = isGlobalActivity;
    }
    public String getBtnProgRef()
    {
        return btnProgRef;
    }
    public void setBtnProgRef(String btnProgRef)
    {
        this.btnProgRef = btnProgRef;
    }
    public String getApiType()
    {
        return apiType;
    }
    public void setApiType(String apiType)
    {
        this.apiType = apiType;
    }
    public BigDecimal getApiCode()
    {
        return apiCode;
    }
    public void setApiCode(BigDecimal apiCode)
    {
        this.apiCode = apiCode;
    }
    public BigDecimal getElemSequenceId()
    {
        return elemSequenceId;
    }
    public void setElemSequenceId(BigDecimal elemSequenceId)
    {
        this.elemSequenceId = elemSequenceId;
    }
    public String getGridColumns()
    {
        return gridColumns;
    }
    public void setGridColumns(String gridColumns)
    {
        this.gridColumns = gridColumns;
    }
    public BigDecimal getDynElementId()
    {
        return dynElementId;
    }
    public void setDynElementId(BigDecimal dynElementId)
    {
        this.dynElementId = dynElementId;
    }
    
}
