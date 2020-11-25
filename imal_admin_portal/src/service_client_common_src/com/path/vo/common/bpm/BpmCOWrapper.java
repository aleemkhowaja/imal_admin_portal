package com.path.vo.common.bpm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.bo.common.ConstantsCommon;
import com.path.lib.vo.BaseVO;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;

public abstract class BpmCOWrapper extends BaseVO
{
    private byte[] bpmFileContent;
    private String gridUpdate;
    private BigDecimal taskId;
    private BigDecimal taskMapId;
    private String taskName;
    private String deploymentId;
    private String processDefId;
    private String language;
    private String warningMsg;
    private BigDecimal processInstanceId;
    private BigDecimal processId;
    private String progRef;
    private String mapType;
    private String appName;
    private Date runningDate;
    private String methodSignature;
    private String restUrl;
    private String restAuthorization;
    private String exportType;
    private String processName;
    private String type;
    private String startWithProcessVariables;
    private String comment;
    private String commentRequired;
    private Boolean loadPasswordFromUsrDet;
    private int count;
    private String actionTypes;
    private String hideActionTypeInLogsGrid = ConstantsCommon.TRUE;
    private String enableAddDeleteInLogsGrid = ConstantsCommon.TRUE;
    private String excludeLoggedInUser;
    private String fileName;
    private String fileExtension;
    private BigDecimal documentId;
    private String taskGridRefreshTime;
    private String enableAddComment;
    private String enableDeleteComment;
    private String enableUpdateComment;

    // TP #957629 - System is not displaying any User ID in the forward option for the Request
    private BigDecimal compCode;
    private BigDecimal branchCode;

    // Added for JBPM v7 - to know when to return SVG image
    private boolean typeSVG;

    private Map<String, Object> bpmTaskArgMap = new HashMap<String, Object>();

    private BpmTaskMappingCO bpmTaskMappingCO = new BpmTaskMappingCO();

    private List<BpmTaskMappingCO> bpmTaskMappingCOList = new ArrayList<BpmTaskMappingCO>();

    private List<DynamicScreenParamsMapCO> dynamicScreenParamsMapCOList = new ArrayList<DynamicScreenParamsMapCO>();

    private BpmProcessCO bpmProcessCO = new BpmProcessCO();

    public List<DynamicScreenParamsMapCO> getDynamicScreenParamsMapCOList()
    {
	return dynamicScreenParamsMapCOList;
    }

    public void setDynamicScreenParamsMapCOList(List<DynamicScreenParamsMapCO> dynamicScreenParamsMapCOList)
    {
	this.dynamicScreenParamsMapCOList = dynamicScreenParamsMapCOList;
    }

    public String getDeploymentId()
    {
	return deploymentId;
    }

    public void setDeploymentId(String deploymentId)
    {
	this.deploymentId = deploymentId;
    }

    public String getProcessDefId()
    {
	return processDefId;
    }

    public void setProcessDefId(String processDefId)
    {
	this.processDefId = processDefId;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public String getWarningMsg()
    {
	return warningMsg;
    }

    public void setWarningMsg(String warningMsg)
    {
	this.warningMsg = warningMsg;
    }

    public String getTaskName()
    {
	return taskName;
    }

    public void setTaskName(String taskName)
    {
	this.taskName = taskName;
    }

    public BigDecimal getProcessInstanceId()
    {
	return processInstanceId;
    }

    public void setProcessInstanceId(BigDecimal processInstanceId)
    {
	this.processInstanceId = processInstanceId;
    }

    public Map<String, Object> getBpmTaskArgMap()
    {
	return bpmTaskArgMap;
    }

    public void setBpmTaskArgMap(Map<String, Object> bpmTaskArgMap)
    {
	this.bpmTaskArgMap = bpmTaskArgMap;
    }

    public BigDecimal getTaskId()
    {
	return taskId;
    }

    public void setTaskId(BigDecimal taskId)
    {
	this.taskId = taskId;
    }

    public BpmTaskMappingCO getBpmTaskMappingCO()
    {
	return bpmTaskMappingCO;
    }

    public void setBpmTaskMappingCO(BpmTaskMappingCO bpmTaskMappingCO)
    {
	this.bpmTaskMappingCO = bpmTaskMappingCO;
    }

    public String getGridUpdate()
    {
	return gridUpdate;
    }

    public void setGridUpdate(String gridUpdate)
    {
	this.gridUpdate = gridUpdate;
    }

    public List<BpmTaskMappingCO> getBpmTaskMappingCOList()
    {
	return bpmTaskMappingCOList;
    }

    public void setBpmTaskMappingCOList(List<BpmTaskMappingCO> bpmTaskMappingCOList)
    {
	this.bpmTaskMappingCOList = bpmTaskMappingCOList;
    }

    public byte[] getBpmFileContent()
    {
	return bpmFileContent;
    }

    public void setBpmFileContent(byte[] bpmFileContent)
    {
	this.bpmFileContent = bpmFileContent;
    }

    public BigDecimal getProcessId()
    {
	return processId;
    }

    public void setProcessId(BigDecimal processId)
    {
	this.processId = processId;
    }

    public BigDecimal getTaskMapId()
    {
	return taskMapId;
    }

    public void setTaskMapId(BigDecimal taskMapId)
    {
	this.taskMapId = taskMapId;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public String getMapType()
    {
	return mapType;
    }

    public void setMapType(String mapType)
    {
	this.mapType = mapType;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public Date getRunningDate()
    {
	return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public String getMethodSignature()
    {
	return methodSignature;
    }

    public void setMethodSignature(String methodSignature)
    {
	this.methodSignature = methodSignature;
    }

    public String getRestUrl()
    {
	return restUrl;
    }

    public void setRestUrl(String restUrl)
    {
	this.restUrl = restUrl;
    }

    public String getRestAuthorization()
    {
	return restAuthorization;
    }

    public void setRestAuthorization(String restAuthorization)
    {
	this.restAuthorization = restAuthorization;
    }

    public String getExportType()
    {
	return exportType;
    }

    public void setExportType(String exportType)
    {
	this.exportType = exportType;
    }

    public String getProcessName()
    {
	return processName;
    }

    public void setProcessName(String processName)
    {
	this.processName = processName;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public String getStartWithProcessVariables()
    {
	return startWithProcessVariables;
    }

    public void setStartWithProcessVariables(String startWithProcessVariables)
    {
	this.startWithProcessVariables = startWithProcessVariables;
    }

    public String getComment()
    {
	return comment;
    }

    public void setComment(String comment)
    {
	this.comment = comment;
    }

    public String getCommentRequired()
    {
	return commentRequired;
    }

    public void setCommentRequired(String commentRequired)
    {
	this.commentRequired = commentRequired;
    }

    public Boolean getLoadPasswordFromUsrDet()
    {
	return loadPasswordFromUsrDet;
    }

    public void setLoadPasswordFromUsrDet(Boolean loadPasswordFromUsrDet)
    {
	this.loadPasswordFromUsrDet = loadPasswordFromUsrDet;
    }

    public int getCount()
    {
	return count;
    }

    public void setCount(int count)
    {
	this.count = count;
    }

    public String getActionTypes()
    {
	return actionTypes;
    }

    public void setActionTypes(String actionTypes)
    {
	this.actionTypes = actionTypes;
    }

    public String getHideActionTypeInLogsGrid()
    {
	return hideActionTypeInLogsGrid;
    }

    public void setHideActionTypeInLogsGrid(String hideActionTypeInLogsGrid)
    {
	this.hideActionTypeInLogsGrid = hideActionTypeInLogsGrid;
    }

    public String getEnableAddDeleteInLogsGrid()
    {
	return enableAddDeleteInLogsGrid;
    }

    public void setEnableAddDeleteInLogsGrid(String enableAddDeleteInLogsGrid)
    {
	this.enableAddDeleteInLogsGrid = enableAddDeleteInLogsGrid;
    }

    /**
     * @return the excludeLoggedInUser
     */
    public String getExcludeLoggedInUser()
    {
	return excludeLoggedInUser;
    }

    /**
     * @param excludeLoggedInUser the excludeLoggedInUser to set
     */
    public void setExcludeLoggedInUser(String excludeLoggedInUser)
    {
	this.excludeLoggedInUser = excludeLoggedInUser;
    }

    /**
     * @return the fileName
     */
    public String getFileName()
    {
	return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName)
    {
	this.fileName = fileName;
    }

    /**
     * @return the fileExtension
     */
    public String getFileExtension()
    {
	return fileExtension;
    }

    /**
     * @param fileExtension the fileExtension to set
     */
    public void setFileExtension(String fileExtension)
    {
	this.fileExtension = fileExtension;
    }

    /**
     * @return the documentId
     */
    public BigDecimal getDocumentId()
    {
	return documentId;
    }

    /**
     * @param documentId the documentId to set
     */
    public void setDocumentId(BigDecimal documentId)
    {
	this.documentId = documentId;
    }

    /**
     * @return the bpmProcessCO
     */
    public BpmProcessCO getBpmProcessCO()
    {
	return bpmProcessCO;
    }

    /**
     * @param bpmProcessCO the bpmProcessCO to set
     */
    public void setBpmProcessCO(BpmProcessCO bpmProcessCO)
    {
	this.bpmProcessCO = bpmProcessCO;
    }

    /**
     * @return the taskGridRefreshTime
     */
    public String getTaskGridRefreshTime()
    {
	return taskGridRefreshTime;
    }

    /**
     * @param taskGridRefreshTime the taskGridRefreshTime to set
     */
    public void setTaskGridRefreshTime(String taskGridRefreshTime)
    {
	this.taskGridRefreshTime = taskGridRefreshTime;
    }

    public String getEnableAddComment()
    {
	return enableAddComment;
    }

    public void setEnableAddComment(String enableAddComment)
    {
	this.enableAddComment = enableAddComment;
    }

    public String getEnableDeleteComment()
    {
	return enableDeleteComment;
    }

    public void setEnableDeleteComment(String enableDeleteComment)
    {
	this.enableDeleteComment = enableDeleteComment;
    }

    public String getEnableUpdateComment()
    {
	return enableUpdateComment;
    }

    public void setEnableUpdateComment(String enableUpdateComment)
    {
	this.enableUpdateComment = enableUpdateComment;
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

    public boolean isTypeSVG()
    {
	return typeSVG;
    }

    public void setTypeSVG(boolean typeSVG)
    {
	this.typeSVG = typeSVG;
    }

}
