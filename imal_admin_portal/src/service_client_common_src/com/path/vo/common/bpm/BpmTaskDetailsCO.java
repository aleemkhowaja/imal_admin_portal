/**
 *  
 */
package com.path.vo.common.bpm;

import java.math.BigDecimal;

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
@XStreamAlias("task")
public class BpmTaskDetailsCO  extends BaseVO 
{
    @XStreamAlias("id")
    private BigDecimal taskId;
    
    @XStreamAlias("name")
    private String taskName;
    
    @XStreamAlias("description")
    private String taskDesc;
    
    @XStreamAlias("taskData")
    private BpmTaskDataCO bpmTaskDataCO =  new BpmTaskDataCO();

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

    public BpmTaskDataCO getBpmTaskDataCO()
    {
        return bpmTaskDataCO;
    }

    public void setBpmTaskDataCO(BpmTaskDataCO bpmTaskDataCO)
    {
        this.bpmTaskDataCO = bpmTaskDataCO;
    }

}
