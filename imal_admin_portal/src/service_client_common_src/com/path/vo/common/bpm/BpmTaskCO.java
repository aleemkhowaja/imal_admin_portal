/**
 * 
 */
package com.path.vo.common.bpm;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;
import com.thoughtworks.xstream.annotations.XStreamAlias;
 
/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmTaskCO.java used to
 */
@XStreamAlias("task-summary")
public class BpmTaskCO  extends BpmTaskCOWrapper 
{
    @XStreamAlias("id")
    private BigDecimal taskId;
    
    @XStreamAlias("name")
    private String taskName;
    
    @XStreamAlias("description")
    private String taskDesc;
     
    @XStreamAlias("status")
    private String taskStatus;
    
    @XStreamAlias("actual-owner")
    private String taskOwner;
    
    @XStreamAlias("created-on")
    private Date taskCreationDate;
    
    @XStreamAlias("activation-time")
    private Date taskActivationDate;
    
    @XStreamAlias("expiration-time")
    private Date taskExpirationDate;
    
    @XStreamAlias("process-instance-id")
    private BigDecimal processInstanceId;
    
    @XStreamAlias("process-id")
    private String processId;
    
    @XStreamAlias("deployment-id")
    private String deploymentId;
    
    public BigDecimal getTaskId()
    {
        return taskId;
    }
    public void setTaskId(BigDecimal taskId)
    {
        this.taskId = taskId;
    }
    public String getTaskName()
    {
        return taskName;
    }
    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }
    public String getTaskDesc()
    {
        return taskDesc;
    }
    public void setTaskDesc(String taskDesc)
    {
        this.taskDesc = taskDesc;
    }
    public String getTaskStatus()
    {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus)
    {
        this.taskStatus = taskStatus;
    }
    public String getTaskOwner()
    {
        return taskOwner;
    }
    public void setTaskOwner(String taskOwner)
    {
        this.taskOwner = taskOwner;
    }
    public BigDecimal getProcessInstanceId()
    {
        return processInstanceId;
    }
    public void setProcessInstanceId(BigDecimal processInstanceId)
    {
        this.processInstanceId = processInstanceId;
    }
    public String getProcessId()
    {
        return processId;
    }
    public void setProcessId(String processId)
    {
        this.processId = processId;
    }
    
    public String getDeploymentId()
    {
        return deploymentId;
    }
    public void setDeploymentId(String deploymentId)
    {
        this.deploymentId = deploymentId;  
    }
    
    public Date getTaskCreationDate()
    {
        return taskCreationDate;
    }
    public void setTaskCreationDate(Date taskCreationDate)
    {
        this.taskCreationDate = taskCreationDate;
    }
    public Date getTaskExpirationDate()
    {
        return taskExpirationDate;
    }
    public void setTaskExpirationDate(Date taskExpirationDate)
    {
        this.taskExpirationDate = taskExpirationDate;
    }
    
    public Date getTaskActivationDate()
    {
        return taskActivationDate;
    }
    public void setTaskActivationDate(Date taskActivationDate)
    {
        this.taskActivationDate = taskActivationDate;
    }
    
}
