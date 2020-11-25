/**
 * 
 */
package com.path.vo.common.bpmV7;

import java.util.ArrayList;
import java.util.List;

import com.path.vo.common.bpm.BpmCOWrapper;
import com.path.vo.common.bpmV7.BpmProcessCOv7;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class BpmCOv7 extends BpmCOWrapper
{

    @XStreamImplicit(itemFieldName = "processes")
    private List<BpmProcessCOv7> processDefinitionList = new ArrayList<BpmProcessCOv7>();

    @XStreamImplicit(itemFieldName = "task-summary")
    private List<BpmTaskCOv7> taskSummaryList = new ArrayList<BpmTaskCOv7>();

    @XStreamImplicit(itemFieldName = "process-instance")
    private List<BpmProcessInstanceLogCOv7> historyLogList = new ArrayList<BpmProcessInstanceLogCOv7>();

    public List<BpmProcessCOv7> getProcessDefinitionList()
    {
	return processDefinitionList;
    }

    public void setProcessDefinitionList(List<BpmProcessCOv7> processDefinitionList)
    {
	this.processDefinitionList = processDefinitionList;
    }

    public List<BpmTaskCOv7> getTaskSummaryList()
    {
	return taskSummaryList;
    }

    public void setTaskSummaryList(List<BpmTaskCOv7> taskSummaryList)
    {
	this.taskSummaryList = taskSummaryList;
    }

    public List<BpmProcessInstanceLogCOv7> getHistoryLogList()
    {
	return historyLogList;
    }

    public void setHistoryLogList(List<BpmProcessInstanceLogCOv7> historyLogList)
    {
	this.historyLogList = historyLogList;
    }

}
