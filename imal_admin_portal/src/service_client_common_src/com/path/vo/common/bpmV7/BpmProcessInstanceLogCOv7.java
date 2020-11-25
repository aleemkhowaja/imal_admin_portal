package com.path.vo.common.bpmV7;

import java.math.BigDecimal;
import java.util.Date;

import com.path.vo.common.bpm.BpmProcessInstanceLogCOWrapper;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("process-instance")
public class BpmProcessInstanceLogCOv7 extends BpmProcessInstanceLogCOWrapper
{
    @XStreamAlias("process-instance-id")
    private BigDecimal processInstanceId;
    
    @XStreamAlias("process-id")
    private String processId;
    
    @XStreamAlias("process-name")
    private String processName;
    
    @XStreamAlias("container-id")
    private String externalId;
    
    @XStreamAlias("process-instance-desc")
    private String processInstanceDescription;
    
    @XStreamAlias("initiator")
    private String identity;
    
    @XStreamAlias("process-version")
    private String processVersion;
    
    @XStreamAlias("process-instance-state")
    private String status;
    
    @XStreamAlias("start-date")
    private Date startDate;
    
    @XStreamAlias("end-date")
    private Date endDate;
    
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

    public String getProcessName()
    {
        return processName;
    }

    public void setProcessName(String processName)
    {
        this.processName = processName;
    }

    public String getExternalId()
    {
        return externalId;
    }

    public void setExternalId(String externalId)
    {
        this.externalId = externalId;
    }

    public String getProcessInstanceDescription()
    {
        return processInstanceDescription;
    }

    public void setProcessInstanceDescription(String processInstanceDescription)
    {
        this.processInstanceDescription = processInstanceDescription;
    }

    public String getIdentity()
    {
        return identity;
    }

    public void setIdentity(String identity)
    {
        this.identity = identity;
    }

    public String getProcessVersion()
    {
        return processVersion;
    }

    public void setProcessVersion(String processVersion)
    {
        this.processVersion = processVersion;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

}
