/**
 * 
 */
package com.path.vo.common.bpm;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;
 
/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmTaskDataCO.java used to
 */
@XStreamAlias("taskData")
public class BpmTaskDataCO extends BaseObject
{ 
    @XStreamAlias("status")
    private String status;
    @XStreamAlias("process-id")
    private String processId;
    @XStreamAlias("process-instance-id")
    private BigDecimal processInstanceId;
    @XStreamAlias("deployment-id")
    private String deploymentId;
    @XStreamAlias("actual-owner")
    private String actuelOwner;
    
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
