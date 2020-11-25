package com.path.vo.common.bpm;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.FIELD_TECH_DETAILSVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_ACCESS_RIGHTVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_DOCVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_LOGSVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_PROCESS_DEFVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_PROCESS_VARVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_TASK_ASSIGNMENTVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_TASK_MAPVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_TASK_MAP_ARG_INVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ARGVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DEFINITIONVO;
import com.path.lib.vo.BaseVO;

public class BpmTaskMappingCO extends BaseVO
{
    private BigDecimal replaceMapping;
    private SYS_PARAM_BPM_TASK_MAPVO taskMapVO = new SYS_PARAM_BPM_TASK_MAPVO();
    private SYS_PARAM_BPM_PROCESS_DEFVO  procDefVO = new SYS_PARAM_BPM_PROCESS_DEFVO();
    private SYS_PARAM_SCREEN_DEFINITIONVO screenDefVO = new SYS_PARAM_SCREEN_DEFINITIONVO(); 
    private SYS_PARAM_SCREEN_ARGVO screenArgVO = new SYS_PARAM_SCREEN_ARGVO();
    private SYS_PARAM_BPM_TASK_MAP_ARG_INVO taskMapArgInVO = new SYS_PARAM_BPM_TASK_MAP_ARG_INVO();
    private SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO taskMapArgOutVO = new SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO();
    private FIELD_TECH_DETAILSVO fieldTechDetVO = new FIELD_TECH_DETAILSVO();
    private SYS_PARAM_BPM_TASK_ASSIGNMENTVO taskAssignVO = new SYS_PARAM_BPM_TASK_ASSIGNMENTVO();
    private SYS_PARAM_BPM_ACCESS_RIGHTVO accessRightVO = new SYS_PARAM_BPM_ACCESS_RIGHTVO();
    private SYS_PARAM_BPM_PROCESS_VARVO  processVariablesVO = new SYS_PARAM_BPM_PROCESS_VARVO();
    private SYS_PARAM_BPM_LOGSVO logsVO = new SYS_PARAM_BPM_LOGSVO();
    private SYS_PARAM_BPM_DOCVO docVO = new SYS_PARAM_BPM_DOCVO();
    
    private String fieldDesc;
    private Date runningDate;
    private String assignmentTypeDesc;
    private String completionTypeDesc;
    private String taskPriorityDesc;
    private String variableValue;
    private String actionTypeDesc;
    private String fieldType;
    private String typeCode;
    
    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String typeCode)
    {
        this.typeCode = typeCode;
    }

    public String getValueType()
    {
        return valueType;
    }

    public void setValueType(String valueType)
    {
        this.valueType = valueType;
    }

    private String valueType;
    
    public String getFieldType()
    {
        return fieldType;
    }

    public void setFieldType(String fieldType)
    {
        this.fieldType = fieldType;
    }

    public SYS_PARAM_BPM_TASK_MAPVO getTaskMapVO()
    {
        return taskMapVO;
    }

    public void setTaskMapVO(SYS_PARAM_BPM_TASK_MAPVO taskMapVO)
    {
        this.taskMapVO = taskMapVO;
    }

    public SYS_PARAM_SCREEN_DEFINITIONVO getScreenDefVO()
    {
        return screenDefVO;
    }

    public void setScreenDefVO(SYS_PARAM_SCREEN_DEFINITIONVO screenDefVO)
    {
        this.screenDefVO = screenDefVO;
    }

    public BigDecimal getReplaceMapping()
    {
        return replaceMapping;
    }

    public void setReplaceMapping(BigDecimal replaceMapping)
    {
        this.replaceMapping = replaceMapping;
    }

    public SYS_PARAM_BPM_PROCESS_DEFVO getProcDefVO()
    {
        return procDefVO;
    }

    public void setProcDefVO(SYS_PARAM_BPM_PROCESS_DEFVO procDefVO)
    {
        this.procDefVO = procDefVO;
    }

    public SYS_PARAM_SCREEN_ARGVO getScreenArgVO()
    {
        return screenArgVO;
    }

    public void setScreenArgVO(SYS_PARAM_SCREEN_ARGVO screenArgVO)
    {
        this.screenArgVO = screenArgVO;
    }

    public SYS_PARAM_BPM_TASK_MAP_ARG_INVO getTaskMapArgInVO()
    {
        return taskMapArgInVO;
    }

    public void setTaskMapArgInVO(SYS_PARAM_BPM_TASK_MAP_ARG_INVO taskMapArgInVO)
    {
        this.taskMapArgInVO = taskMapArgInVO;
    }

    public SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO getTaskMapArgOutVO()
    {
        return taskMapArgOutVO;
    }

    public void setTaskMapArgOutVO(SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO taskMapArgOutVO)
    {
        this.taskMapArgOutVO = taskMapArgOutVO;
    }

    public String getFieldDesc()
    {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc)
    {
        this.fieldDesc = fieldDesc;
    }

    public FIELD_TECH_DETAILSVO getFieldTechDetVO()
    {
        return fieldTechDetVO;
    }

    public void setFieldTechDetVO(FIELD_TECH_DETAILSVO fieldTechDetVO)
    {
        this.fieldTechDetVO = fieldTechDetVO;
    }

    public SYS_PARAM_BPM_TASK_ASSIGNMENTVO getTaskAssignVO()
    {
        return taskAssignVO;
    }

    public void setTaskAssignVO(SYS_PARAM_BPM_TASK_ASSIGNMENTVO taskAssignVO)
    {
        this.taskAssignVO = taskAssignVO;
    }

    public Date getRunningDate()
    {
        return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    public String getAssignmentTypeDesc()
    {
        return assignmentTypeDesc;
    }

    public void setAssignmentTypeDesc(String assignmentTypeDesc)
    {
        this.assignmentTypeDesc = assignmentTypeDesc;
    }

    public String getCompletionTypeDesc()
    {
        return completionTypeDesc;
    }

    public void setCompletionTypeDesc(String completionTypeDesc)
    {
        this.completionTypeDesc = completionTypeDesc;
    }

    public SYS_PARAM_BPM_ACCESS_RIGHTVO getAccessRightVO()
    {
        return accessRightVO;
    }

    public void setAccessRightVO(SYS_PARAM_BPM_ACCESS_RIGHTVO accessRightVO)
    {
        this.accessRightVO = accessRightVO;
    }

    public SYS_PARAM_BPM_PROCESS_VARVO getProcessVariablesVO()
    {
        return processVariablesVO;
    }

    public void setProcessVariablesVO(SYS_PARAM_BPM_PROCESS_VARVO processVariablesVO)
    {
        this.processVariablesVO = processVariablesVO;
    }

    public String getVariableValue()
    {
        return variableValue;
    }

    public void setVariableValue(String variableValue)
    {
        this.variableValue = variableValue;
    }

    public SYS_PARAM_BPM_LOGSVO getLogsVO()
    {
        return logsVO;
    }

    public void setLogsVO(SYS_PARAM_BPM_LOGSVO logsVO)
    {
        this.logsVO = logsVO;
    }

    public String getActionTypeDesc()
    {
        return actionTypeDesc;
    }

    public void setActionTypeDesc(String actionTypeDesc)
    {
        this.actionTypeDesc = actionTypeDesc;
    }

    /**
     * @return the docVO
     */
    public SYS_PARAM_BPM_DOCVO getDocVO()
    {
        return docVO;
    }

    /**
     * @param docVO the docVO to set
     */
    public void setDocVO(SYS_PARAM_BPM_DOCVO docVO)
    {
        this.docVO = docVO;
    }

    /**
     * @return the taskPriorityDesc
     */
    public String getTaskPriorityDesc()
    {
        return taskPriorityDesc;
    }

    /**
     * @param taskPriorityDesc the taskPriorityDesc to set
     */
    public void setTaskPriorityDesc(String taskPriorityDesc)
    {
        this.taskPriorityDesc = taskPriorityDesc;
    }
    
}
