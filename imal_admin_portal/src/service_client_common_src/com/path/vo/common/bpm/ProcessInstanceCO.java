package com.path.vo.common.bpm;
 
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("process-instance-response")
public class ProcessInstanceCO
{
    @XStreamAlias("id")
    private String processId;
    
    @XStreamAlias("process-id")
    private String processDefId;

    public String getProcessId()
    {
        return processId;
    }

    public void setProcessId(String processId)
    {
        this.processId = processId;
    }

    public String getProcessDefId()
    {
        return processDefId;
    }

    public void setProcessDefId(String processDefId)
    {
        this.processDefId = processDefId;
    }
    
}
