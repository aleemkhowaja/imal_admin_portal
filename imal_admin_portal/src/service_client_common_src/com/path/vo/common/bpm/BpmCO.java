/**
 * 
 */
package com.path.vo.common.bpm;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
 
/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmCO.java used to
 */
public class BpmCO extends BpmCOWrapper
{
    
    @XStreamImplicit(itemFieldName = "task-summary")
    private List<BpmTaskCO> taskSummaryList = new ArrayList<BpmTaskCO>();

    @XStreamImplicit(itemFieldName = "process-definition")
    private List<BpmProcessCO> processDefinitionList = new ArrayList<BpmProcessCO>();

    @XStreamImplicit(itemFieldName = "process-instance-log")
    private List<BpmProcessInstanceLogCO> historyLogList = new ArrayList<BpmProcessInstanceLogCO>();

    public List<BpmProcessCO> getProcessDefinitionList()
    {
	return processDefinitionList;
    }

    public void setProcessDefinitionList(List<BpmProcessCO> processDefinitionList)
    {
	this.processDefinitionList = processDefinitionList;
    }

    public List<BpmTaskCO> getTaskSummaryList()
    {
	return taskSummaryList;
    }

    public void setTaskSummaryList(List<BpmTaskCO> taskSummaryList)
    {
	this.taskSummaryList = taskSummaryList;
    }

    public List<BpmProcessInstanceLogCO> getHistoryLogList()
    {
	return historyLogList;
    }

    public void setHistoryLogList(List<BpmProcessInstanceLogCO> historyLogList)
    {
	this.historyLogList = historyLogList;
    }
}
