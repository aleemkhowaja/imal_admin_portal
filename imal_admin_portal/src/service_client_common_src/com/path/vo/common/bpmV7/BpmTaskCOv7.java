/**
 * 
 */
package com.path.vo.common.bpmV7;

import java.math.BigDecimal;
import java.util.Date;

import com.path.vo.common.bpm.BpmTaskCOWrapper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
 
@XStreamAlias("task-summary")
public class BpmTaskCOv7  extends BpmTaskCOWrapper 
{
    @XStreamAlias("task-id")
    private BigDecimal taskId;

    @XStreamAlias("task-name")
    private String taskName;

    @XStreamAlias("task-description")
    private String taskDesc;

    @XStreamAlias("task-status")
    private String taskStatus;

    @XStreamAlias("task-actual-owner")
    private String taskOwner;

    @XStreamAlias("task-created-on")
    private Date taskCreationDate;

    @XStreamAlias("task-activation-time")
    private Date taskActivationDate;

    @XStreamAlias("task-expiration-time")
    private Date taskExpirationDate;

    @XStreamAlias("task-proc-inst-id")
    private BigDecimal processInstanceId;

    @XStreamAlias("task-proc-def-id")
    private String processId;

    @XStreamAlias("task-container-id")
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
