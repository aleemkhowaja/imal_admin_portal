package com.path.vo.common.bpmV7;

import java.math.BigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("task-instance")
public class BpmTaskDetailsCOv7 
{
    @XStreamAlias("task-id")
    private BigDecimal taskId;

    @XStreamAlias("task-name")
    private String taskName;

    @XStreamAlias("task-status")
    private String status;

    @XStreamAlias("task-process-id")
    private String processId;

    @XStreamAlias("task-process-instance-id")
    private BigDecimal processInstanceId;

    @XStreamAlias("task-container-id")
    private String deploymentId;

    @XStreamAlias("task-actual-owner")
    private String actuelOwner;

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

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getProcessId()
    {
	return processId;
    }

    public void setProcessId(String processId)
    {
	this.processId = processId;
    }

    public BigDecimal getProcessInstanceId()
    {
	return processInstanceId;
    }

    public void setProcessInstanceId(BigDecimal processInstanceId)
    {
	this.processInstanceId = processInstanceId;
    }

    public String getDeploymentId()
    {
	return deploymentId;
    }

    public void setDeploymentId(String deploymentId)
    {
	this.deploymentId = deploymentId;
    }

    public String getActuelOwner()
    {
	return actuelOwner;
    }

    public void setActuelOwner(String actuelOwner)
    {
	this.actuelOwner = actuelOwner;
    }

}
