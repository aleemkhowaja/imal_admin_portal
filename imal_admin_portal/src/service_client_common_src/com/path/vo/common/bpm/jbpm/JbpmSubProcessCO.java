/**
 * 
 */
package com.path.vo.common.bpm.jbpm;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * JbpmSubProcessCO.java used to
 */
@XStreamAlias("bpmn2:subProcess")
public class JbpmSubProcessCO extends JbpmProcessCO
{
    @XStreamImplicit(itemFieldName = "bpmn2:userTask")
    private List<JbpmUserTaskCO> userTaskList;
    
    @XStreamImplicit(itemFieldName = "bpmn2:task")
    private List<JbpmCustomTaskCO> customTaskList; 

    public List<JbpmUserTaskCO> getUserTaskList()
    {
        return userTaskList;
    }

    public void setUserTaskList(List<JbpmUserTaskCO> userTaskList)
    {
        this.userTaskList = userTaskList;
    }

    public List<JbpmCustomTaskCO> getCustomTaskList()
    {
        return customTaskList;
    }

    public void setCustomTaskList(List<JbpmCustomTaskCO> customTaskList)
    {
        this.customTaskList = customTaskList;
    }
    
}
