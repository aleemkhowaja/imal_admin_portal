/**
 * 
 */
package com.path.vo.common.bpm;

import java.math.BigDecimal;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmSC.java used to
 */
public class BpmSC extends GridParamsSC
{
    private String screenCode;
    private String fromDependency;
    private BigDecimal taskMapId;
    private BigDecimal processId;
    private String taskName;
    private String profType;
    private String taskAssignmentType;
    private String entityName;
    private BigDecimal completionLovTypeId;
    private BigDecimal actionLovTypeId;
    private BigDecimal taskPriorityLovTypeId;
    private List<String> processDefList;
    private List<String> taskNameList;
    private String type;
    private String entityType;
    private BigDecimal entityId;
    private String actionType;
    private String actionTypes;
    private List<String> actionTypesList;
    private BigDecimal dynScreenElemTypeLovTypeId;
    private String excludeLoggedInUser;
    
    public String getScreenCode()
    {
        return screenCode;
    }
    public void setScreenCode(String screenCode)
    {
        this.screenCode = screenCode;
    }
    public String getFromDependency()
    {
        return fromDependency;
    }
    public void setFromDependency(String fromDependency)
    {
        this.fromDependency = fromDependency;
    }
    public BigDecimal getTaskMapId()
    {
        return taskMapId;
    }
    public void setTaskMapId(BigDecimal taskMapId)
    {
        this.taskMapId = taskMapId;
    }
    public BigDecimal getProcessId()
    {
        return processId;
    }
    public void setProcessId(BigDecimal processId)
    {
        this.processId = processId;
    }
    public String getTaskName()
    {
        return taskName;
    }
    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }
    public String getProfType()
    {
        return profType;
    }
    public void setProfType(String profType)
    {
        this.profType = profType;
    }
    public String getTaskAssignmentType()
    {
        return taskAssignmentType;
    }
    public void setTaskAssignmentType(String taskAssignmentType)
    {
        this.taskAssignmentType = taskAssignmentType;
    }
    public String getEntityName()
    {
        return entityName;
    }
    public void setEntityName(String entityName)
    {
        this.entityName = entityName;
    }
    public BigDecimal getCompletionLovTypeId()
    {
        return completionLovTypeId;
    }
    public void setCompletionLovTypeId(BigDecimal completionLovTypeId)
    {
        this.completionLovTypeId = completionLovTypeId;
    }
    public BigDecimal getActionLovTypeId()
    {
	return actionLovTypeId;
    }
    public void setActionLovTypeId(BigDecimal actionLovTypeId)
    {
	this.actionLovTypeId = actionLovTypeId;
    }
    public List<String> getProcessDefList()
    {
        return processDefList;
    }
    public void setProcessDefList(List<String> processDefList)
    {
        this.processDefList = processDefList;
    }
    public List<String> getTaskNameList()
    {
        return taskNameList;
    }
    public void setTaskNameList(List<String> taskNameList)
    {
        this.taskNameList = taskNameList;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getEntityType()
    {
        return entityType;
    }
    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }
    public BigDecimal getEntityId()
    {
        return entityId;
    }
    public void setEntityId(BigDecimal entityId)
    {
        this.entityId = entityId;
    }
    public String getActionType()
    {
        return actionType;
    }
    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }
    public String getActionTypes()
    {
        return actionTypes;
    }
    public void setActionTypes(String actionTypes)
    {
        this.actionTypes = actionTypes;
    }
    public List<String> getActionTypesList()
    {
        return actionTypesList;
    }
    public void setActionTypesList(List<String> actionTypesList)
    {
        this.actionTypesList = actionTypesList;
    }
    public BigDecimal getDynScreenElemTypeLovTypeId()
    {
        return dynScreenElemTypeLovTypeId;
    }
    public void setDynScreenElemTypeLovTypeId(BigDecimal dynScreenElemTypeLovTypeId)
    {
        this.dynScreenElemTypeLovTypeId = dynScreenElemTypeLovTypeId;
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
     * @return the taskPriorityLovTypeId
     */
    public BigDecimal getTaskPriorityLovTypeId()
    {
        return taskPriorityLovTypeId;
    }
    /**
     * @param taskPriorityLovTypeId the taskPriorityLovTypeId to set
     */
    public void setTaskPriorityLovTypeId(BigDecimal taskPriorityLovTypeId)
    {
        this.taskPriorityLovTypeId = taskPriorityLovTypeId;
    }

}
