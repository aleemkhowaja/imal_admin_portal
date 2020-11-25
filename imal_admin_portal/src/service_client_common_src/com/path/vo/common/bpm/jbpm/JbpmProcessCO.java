/**
 * 
 */
package com.path.vo.common.bpm.jbpm;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * JbpmProcessCO.java used to
 */
@XStreamAlias("bpmn2:process")
public class JbpmProcessCO implements Serializable
{
    @XStreamAsAttribute 
    @XStreamAlias("id") 
    private String id;
    
    @XStreamAsAttribute 
    @XStreamAlias("name") 
    private String name;
    
    @XStreamAsAttribute 
    @XStreamAlias("drools:version") 
    private String version;
    
    @XStreamImplicit(itemFieldName = "bpmn2:property")
    private List<JbpmProcessVarCO> processVarList;
    
    @XStreamImplicit(itemFieldName = "bpmn2:userTask")
    private List<JbpmUserTaskCO> userTaskList; 
    
    @XStreamImplicit(itemFieldName = "bpmn2:task")
    private List<JbpmCustomTaskCO> customTaskList; 
    
    @XStreamImplicit(itemFieldName = "bpmn2:subProcess")
    private List<JbpmSubProcessCO> subProcessList; 
    
    @XStreamAlias("bpmn2:documentation")
    private String documentation;
    
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getVersion()
    {
        return version;
    }
    public void setVersion(String version)
    {
        this.version = version;
    }
    public List<JbpmProcessVarCO> getProcessVarList()
    {
        return processVarList;
    }
    public void setProcessVarList(List<JbpmProcessVarCO> processVarList)
    {
        this.processVarList = processVarList;
    }
    public List<JbpmUserTaskCO> getUserTaskList()
    {
        return userTaskList;
    }
    public void setUserTaskList(List<JbpmUserTaskCO> userTaskList)
    {
        this.userTaskList = userTaskList;
    }
    public List<JbpmSubProcessCO> getSubProcessList()
    {
        return subProcessList;
    }
    public void setSubProcessList(List<JbpmSubProcessCO> subProcessList)
    {
        this.subProcessList = subProcessList;
    }
    public List<JbpmCustomTaskCO> getCustomTaskList()
    {
        return customTaskList;
    }
    public void setCustomTaskList(List<JbpmCustomTaskCO> customTaskList)
    {
        this.customTaskList = customTaskList;
    }
    public String getDocumentation()
    {
        return documentation;
    }
    public void setDocumentation(String documentation)
    {
        this.documentation = documentation;
    }
    
}
