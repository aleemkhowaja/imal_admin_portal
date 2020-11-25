/**
 * 
 */
package com.path.vo.common.bpmV7;

import com.path.vo.common.bpm.BpmProcessCOWrapper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
 
@XStreamAlias("processes")
public class BpmProcessCOv7 extends BpmProcessCOWrapper
{

    @XStreamAlias("process-id")
    protected String processId;
    
    @XStreamAlias("process-name")
    protected String processName;
    
    @XStreamAlias("container-id")
    protected String deploymentId;
    
    @XStreamAlias("process-version")
    protected String version;
    
    @XStreamAlias("package")
    protected String packageName;

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

    public String getDeploymentId()
    {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId)
    {
        this.deploymentId = deploymentId;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
    }
    
}
