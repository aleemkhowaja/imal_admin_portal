/**
 * 
 */
package com.path.vo.common.bpm;

import com.path.struts2.lib.common.BaseObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;
 
/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmProcessCO.java used to
 */ 
@XStreamAlias("process-definition")
public class BpmProcessCO extends BpmProcessCOWrapper
{

    @XStreamAlias("id")
    private String processId;
    
    @XStreamAlias("name")
    private String processName;
    
    @XStreamAlias("deployment-id")
    private String deploymentId;
    
    @XStreamAlias("version")
    private String version;
    
    @XStreamAlias("package-name")
    private String packageName;
    
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
