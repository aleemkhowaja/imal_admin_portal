/**
 * 
 */
package com.path.actions.common.bpm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.bpm.BpmBO;
import com.path.bo.common.bpm.BpmEngineConstant;
import com.path.dbmaps.vo.SYS_PARAM_BPM_PROCESS_DEFVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.bpm.BpmCO;
import com.path.vo.common.bpm.BpmProcessCO;
import com.path.vo.common.bpm.BpmProcessInstanceLogCO;
import com.path.vo.common.bpm.BpmSC;
import com.path.vo.common.bpm.BpmTaskCO;
import com.path.vo.common.bpm.BpmTaskMappingCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmGridAction.java used to
 */
public class BpmGridAction extends GridBaseAction
{
    private BpmBO bpmBO;
    private BpmCO bpmCO = new BpmCO();
    private BpmSC bpmSC = new BpmSC(); 
    
    @Override
    public Object getModel()
    {
	return bpmSC;
    }
    
    private void prepareCommonParams()
    {
	if(SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null)
	{
	    SessionCO sessionCO = returnSessionObject();
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    bpmCO.setBpmUserName(sessionCO.getUserName());
	    bpmCO.setBpmUserPass((String) authentication.getCredentials());
	} 
    }
    
    /**
     * function used to give the BPMADMIN all access to all actions
     */
    private void enableBpmAdminActions(BpmCO bpmCO, BpmProcessCO process, BpmTaskCO task, BpmProcessInstanceLogCO instanceLogCO)
    {
	if(BpmEngineConstant.BPM_PROPERTIES.BPM_ADMIN_USERNAME.getValue().equals(bpmCO.getBpmUserName()))
	{
	    if(process != null)
	    {	
		process.setShowProcessImageBtn(true);
		process.setShowStartBtn(true);
		process.setShowExportDocBtn(true);
	    }
	    if(task != null)
	    {
		task.setShowInstanceImageBtn(true);
		task.setShowAdminLogsBtn(true);
		task.setShowSuspendBtn(true);
		task.setShowResumeBtn(true);
		task.setShowForwardBtn(true);
		task.setShowOpenBtn(true);
		task.setShowReleaseBtn(true);
		task.setShowCompleteBtn(true);
		if(BpmEngineConstant.TASK_STATUS.READY.equals(task.getTaskStatus()))
		{
		    task.setShowClaimBtn(true);
		}
	    }
	    if(instanceLogCO != null)
	    {
		instanceLogCO.setShowAbortBtn(true);
	    }
	}
    }
    
    public String loadProcessInstanceTasksGrid()
    {
	try
	{
	    prepareCommonParams();
	    SessionCO sessionCO = returnSessionObject();
	    
	    String[] searchCols = {"TASK_ID","PROCESS_INSTANCE_ID","PROCESS_ID","DEPLOYMENT_ID","TASK_NAME","TASK_DESC","TASK_STATUS",
		    		   "TASK_OWNER","TASK_CREATION_DATE","TASK_EXPIRATION_DATE","TASK_PRIORITY_DESC"};
	    bpmSC.setSearchCols(searchCols);
	    bpmSC.setPreferredLanguage(sessionCO.getLanguage());
	    bpmSC.setTaskPriorityLovTypeId(BpmEngineConstant.LOV_TYPE_TASK_PRIORITY);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(bpmSC);
	    
	    bpmCO.setProcessInstanceId(bpmSC.getProcessId());
	    BpmCO bpmTaskSummaryCO = bpmBO.returnTasksByProcessInstance(bpmCO,bpmSC);
	    
	    if(bpmTaskSummaryCO != null)
	    {	
		List<BpmTaskCO> tasksList = bpmTaskSummaryCO.getTaskSummaryList();
		if(tasksList != null && !tasksList.isEmpty())
		{
		    BpmSC criteria = new BpmSC();
		    criteria.setUserId(bpmCO.getBpmUserName());
		    Map<String, BpmTaskMappingCO> accessRightMap = bpmBO.returnProcesAccessRightByUser(criteria);
		    
		    List<String> processDefList = new ArrayList<String>();
		    List<String> taskNameList = new ArrayList<String>();
		    
		    
		    for(BpmTaskCO task : tasksList)
		    {
			if(!processDefList.contains(task.getProcessId()))
			{
			    processDefList.add(task.getProcessId());
			}
			if(!taskNameList.contains(task.getTaskName()))
			{
			    taskNameList.add(task.getTaskName());
			}
		    }

		    defineTaskVisibleButton(processDefList,taskNameList,tasksList,accessRightMap);
		    
		    /**
		     *  set number of rows to be displayed in the page of grid, and the
		     * total number of records for first time load only
		     */
		    if(checkNbRec(bpmSC))
		    {
			setRecords(bpmTaskSummaryCO.getCount());
		    }

		    /**
		     *  set the collection into gridModel attribute defined at JSP grid tag
		     */
		    setGridModel(tasksList);
		}
	    }
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String loadUserTasksGrid()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    prepareCommonParams();
	    
	    String[] searchCols = {"TASK_ID","PROCESS_INSTANCE_ID","PROCESS_ID","DEPLOYMENT_ID","TASK_NAME","TASK_DESC","TASK_STATUS",
		    		   "TASK_OWNER","TASK_CREATION_DATE","TASK_EXPIRATION_DATE","TASK_PRIORITY_DESC"};
	    bpmSC.setSearchCols(searchCols);
	    bpmSC.setPreferredLanguage(sessionCO.getLanguage());
	    bpmSC.setTaskPriorityLovTypeId(BpmEngineConstant.LOV_TYPE_TASK_PRIORITY);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(bpmSC);
	    
	    BpmCO bpmTaskSummaryCO = bpmBO.returnUserAssignedAndAvailableTasks(bpmCO, bpmSC);
	    if(bpmTaskSummaryCO != null)
	    {	
		List<BpmTaskCO> tasksList = bpmTaskSummaryCO.getTaskSummaryList();
		if(tasksList != null && !tasksList.isEmpty())
		{
		    BpmSC criteria = new BpmSC();
		    criteria.setUserId(bpmCO.getBpmUserName());
		    Map<String, BpmTaskMappingCO> accessRightMap = bpmBO.returnProcesAccessRightByUser(criteria);
		    
		    List<String> processDefList = new ArrayList<String>();
		    List<String> taskNameList = new ArrayList<String>();
		    
		    
		    for(BpmTaskCO task : tasksList)
		    {
			if(!processDefList.contains(task.getProcessId()))
			{
			    processDefList.add(task.getProcessId());
			}
			if(!taskNameList.contains(task.getTaskName()))
			{
			    taskNameList.add(task.getTaskName());
			}
		    }

		    defineTaskVisibleButton(processDefList,taskNameList,tasksList,accessRightMap);
		    
		    /**
		     *  set number of rows to be displayed in the page of grid, and the
		     * total number of records for first time load only
		     */
		    if(checkNbRec(bpmSC))
		    {
			setRecords(bpmTaskSummaryCO.getCount());
		    }

		    /**
		     *  set the collection into gridModel attribute defined at JSP grid tag
		     */
		    setGridModel(tasksList);
		}
	    }
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String loadProcInstGrid()
    {
	try
	{
	    prepareCommonParams();
	    
	    String[] searchCols = { "PROCESS_NAME", "VERSION" };
	    bpmSC.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(bpmSC);
	    
	    BpmCO bpmProcessDefCO = bpmBO.returnProcessDefinitionList(bpmCO,bpmSC);
	    if(bpmProcessDefCO != null)
	    {	
		List<BpmProcessCO> processDefList = bpmProcessDefCO.getProcessDefinitionList();
		if(processDefList != null && !processDefList.isEmpty())
		{
		    BpmSC criteria = new BpmSC();
		    criteria.setUserId(bpmCO.getBpmUserName());
		    Map<String, BpmTaskMappingCO> accessRightMap = bpmBO.returnProcesAccessRightByUser(criteria);
		    
		    for(BpmProcessCO process : processDefList)
		    {
			if(accessRightMap != null && accessRightMap.containsKey(process.getProcessId()))
			{
			    process.setShowProcessImageBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
				    process.getProcessId()).getAccessRightVO().getSHOW_PROCESS_IMAGE_YN()));
			    
			    process.setShowStartBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
				    process.getProcessId()).getAccessRightVO().getSTART_INSTANCE_YN()));
			    
			    process.setShowExportDocBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
				    process.getProcessId()).getAccessRightVO().getSHOW_EXPORT_DOC_YN()));
			}
			enableBpmAdminActions(bpmCO, process, null, null);
		    }
		    
		    /**
		     *  set number of rows to be displayed in the page of grid, and the
		     * total number of records for first time load only
		     */
		    if(checkNbRec(bpmSC))
		    {
			setRecords(bpmProcessDefCO.getCount());
		    }

		    /**
		     *  set the collection into gridModel attribute defined at JSP grid tag
		     */
		    setGridModel(processDefList);
		}
	    }
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String loadUploadedProcessDefGrid()
    {
	try
	{   
	    String[] searchCols = { "PROCESS_ID", "PROCESS_NAME", "VERSION" , "ACTIVE" };
	    bpmSC.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(bpmSC);
	    
	    /**
	     *  set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(bpmSC))
	    {
		setRecords(bpmBO.returnUploadedProcessDefListCount(bpmSC));
	    }

	    /**
	     *  return the collection of records
	     */
	    List<SYS_PARAM_BPM_PROCESS_DEFVO> processDefList = bpmBO.returnUploadedProcessDefList(bpmSC);
	    
	    /**
	     *  set the collection into gridModel attribute defined at JSP grid tag
	     */
	    setGridModel(processDefList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String loadUserTaskMappingGrid()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    bpmSC.setPreferredLanguage(sessionCO.getLanguage());
	    bpmSC.setLovTypeId(BpmEngineConstant.LOV_TYPE_ID_SCREEN_DESC);
	    bpmSC.setCompletionLovTypeId(BpmEngineConstant.LOV_TYPE_TASK_COMPLETION_DESC);
	    bpmSC.setActionLovTypeId(BpmEngineConstant.LOV_TYPE_ACTION_TYPE);
	    bpmSC.setTaskPriorityLovTypeId(BpmEngineConstant.LOV_TYPE_TASK_PRIORITY);
	    
	    String[] searchCols = { "TASK_NAME", "SCREEN_CODE", "completionTypeDesc", "taskPriorityDesc" };
	    bpmSC.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(bpmSC);
	    
	    /**
	     *  set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(bpmSC))
	    {
		setRecords(bpmBO.returnUserTaskMapListCount(bpmSC));
	    }

	    /**
	     *  return the collection of records
	     */
	    List<BpmTaskMappingCO> processDefList = bpmBO.returnUserTaskMapList(bpmSC);
	    
	    /**
	     *  set the collection into gridModel attribute defined at JSP grid tag
	     */
	    setGridModel(processDefList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    private void highlightExpiredTasks(BpmTaskCO task)
    {
	if(task.getTaskExpirationDate() != null && task.getTaskExpirationDate().getTime() > 0
		&& task.getTaskExpirationDate().getTime() < System.currentTimeMillis())
	{
	    task.setHighlightColor(BpmEngineConstant.BPM_PROPERTIES.EXPIRED_TASK_HIGHLIGHT_COLOR.getValue());
	}
    }
    
    private void defineTaskVisibleButton(List<String> processDefList, List<String> taskNameList, List<BpmTaskCO> tasksList, 
	    Map<String, BpmTaskMappingCO> accessRightMap) throws BaseException
    {
	if(processDefList != null && !processDefList.isEmpty()
		&& tasksList != null && !tasksList.isEmpty())
	{
	    BpmSC criteria = new BpmSC();
	    criteria.setProcessDefList(processDefList);
	    criteria.setTaskNameList(taskNameList);
	    Map<String, BpmTaskMappingCO> taskResultMap = bpmBO.returnTaskMapByProcessDef(criteria);
	   
	    for(BpmTaskCO task : tasksList)
	    {
		highlightExpiredTasks(task);
		
		if(accessRightMap != null && accessRightMap.containsKey(task.getProcessId()))
		{
		    task.setShowInstanceImageBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
			    task.getProcessId()).getAccessRightVO().getSHOW_INSTANCE_IMAGE_YN()));
		    
		    task.setShowAdminLogsBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
			    task.getProcessId()).getAccessRightVO().getSHOW_TASK_ADMIN_LOGS_YN()));
		    
		    task.setShowDocumentsBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
			    task.getProcessId()).getAccessRightVO().getSHOW_PROC_INST_DOC_YN()));
		    
		    task.setAddComment(ConstantsCommon.ONE.equals(accessRightMap.get(
			    task.getProcessId()).getAccessRightVO().getSHOW_COMMENT_ADD_YN()));
		    
		    task.setDeleteComment(ConstantsCommon.ONE.equals(accessRightMap.get(
			    task.getProcessId()).getAccessRightVO().getSHOW_COMMENT_DELETE_YN()));
		    
		    task.setUpdateComment(ConstantsCommon.ONE.equals(accessRightMap.get(
			    task.getProcessId()).getAccessRightVO().getSHOW_COMMENT_UPDATE_YN()));
		    
		    if(BpmEngineConstant.TASK_STATUS.RESERVED.equals(task.getTaskStatus()))
		    {
			task.setShowSuspendBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
				    task.getProcessId()).getAccessRightVO().getSHOW_SUSPEND_RESUME_YN()));
		    }
		    if(BpmEngineConstant.TASK_STATUS.SUSPENDED.equals(task.getTaskStatus()))
		    {
			task.setShowResumeBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
				    task.getProcessId()).getAccessRightVO().getSHOW_SUSPEND_RESUME_YN()));
		    }
		
		}
		
		if(BpmEngineConstant.TASK_STATUS.READY.equals(task.getTaskStatus()))
		{
		    task.setShowClaimBtn(true);
		}
		else if(BpmEngineConstant.TASK_STATUS.RESERVED.equals(task.getTaskStatus())
			|| BpmEngineConstant.TASK_STATUS.IN_PROGRESS.equals(task.getTaskStatus()))
		{
		    task.setShowForwardBtn(accessRightMap.get(
			    task.getProcessId()) != null && 
			    accessRightMap.get(task.getProcessId()).getAccessRightVO() != null &&
			    ConstantsCommon.ONE.equals(accessRightMap.get(task.getProcessId()).getAccessRightVO().getSHOW_FORWARD_TASK_YN()));
		    task.setShowOpenBtn(true);
		    task.setShowReleaseBtn(true);
		    defineCompeleteButtonVisibility(task, taskResultMap, task.getProcessId() + "_" + task.getTaskName());
		}
		
		enableBpmAdminActions(bpmCO, null, task, null);
	    }
	
	}
    }
    
    private void defineCompeleteButtonVisibility(BpmTaskCO task,Map<String, BpmTaskMappingCO> taskResultMap, String key)
    {
	//in case the mapping of the task exists, we will check the completion type  
	if(taskResultMap != null && taskResultMap.containsKey(key))
	{
	    BpmTaskMappingCO taskMappingCO = taskResultMap.get(key);
	    if(BpmEngineConstant.COMPLETION_TYPE.MANUEL.equals(taskMappingCO.getTaskMapVO().getCOMPLETION_TYPE())
		    || BpmEngineConstant.COMPLETION_TYPE.BOTH.equals(taskMappingCO.getTaskMapVO().getCOMPLETION_TYPE()))
	    {
		task.setShowCompleteBtn(true);
	    }
	}
	//in case the process is not uploaded, so there is no mapping for the task, by default we will show the complete on the task
	else
	{
	    task.setShowCompleteBtn(true);
	}
    }
    
    public String loadUserTaskAssignGrid()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    bpmSC.setLovTypeId(BpmEngineConstant.LOV_TYPE_TASK_ASSIGNMENT_DESC);
	    bpmSC.setPreferredLanguage(sessionCO.getLanguage());
	    
	    String[] searchCols = { "ASSIGNMENT_TYPE_DESC", "ENTITY_NAME" };
	    bpmSC.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(bpmSC);
	    
	    /**
	     *  set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(bpmSC))
	    {
		setRecords(bpmBO.returnUserTaskAssignListCount(bpmSC));
	    }

	    /**
	     *  return the collection of records
	     */
	    List<BpmTaskMappingCO> userTaskAssignList = bpmBO.returnUserTaskAssignList(bpmSC);
	    
	    /**
	     *  set the collection into gridModel attribute defined at JSP grid tag
	     */
	    setGridModel(userTaskAssignList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String loadProcessAccessRightGrid()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    bpmSC.setLovTypeId(BpmEngineConstant.LOV_TYPE_TASK_ASSIGNMENT_DESC);
	    bpmSC.setPreferredLanguage(sessionCO.getLanguage());
	    
	    String[] searchCols = { "ASSIGNMENT_TYPE_DESC", "ENTITY_NAME","START_INSTANCE_YN","SHOW_PROCESS_IMAGE_YN","SHOW_INSTANCE_IMAGE_YN",
		    		   "SHOW_EXPORT_DOC_YN", "SHOW_ABORT_INSTANCE_YN", "START_WITH_PROC_VAR_YN", "SHOW_SUSPEND_RESUME_YN", "SHOW_TASK_ADMIN_LOGS_YN"};
	    bpmSC.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(bpmSC);
	    
	    /**
	     *  set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(bpmSC))
	    {
		setRecords(bpmBO.returnProcessAccessRightListCount(bpmSC));
	    }

	    /**
	     *  return the collection of records
	     */
	    List<BpmTaskMappingCO> userTaskAssignList = bpmBO.returnProcessAccessRightList(bpmSC);
	    
	    /**
	     *  set the collection into gridModel attribute defined at JSP grid tag
	     */
	    setGridModel(userTaskAssignList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String loadProcessVariablesGrid()
    {
	try
	{
	    String[] searchCols = { "VARIABLE_ID", "VARIABLE_NAME","VARIABLE_TYPE","BUSINESS_NAME","DESCRIPTION","IS_MANDATORY_YN", "SHOW_ON_STARTUP_YN" };
	    bpmSC.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(bpmSC);
	    
	    /**
	     *  set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(bpmSC))
	    {
		setRecords(bpmBO.returnProcessVariablesListCount(bpmSC));
	    }

	    /**
	     *  return the collection of records
	     */
	    List<BpmTaskMappingCO> processVariablesList = bpmBO.returnProcessVariablesList(bpmSC);
	    
	    
	    if(processVariablesList != null && !processVariablesList.isEmpty())
	    {
		for(BpmTaskMappingCO bpmTaskMappingCO : processVariablesList)
		{    
		    if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(bpmTaskMappingCO
			    .getProcessVariablesVO().getDEFAULT_TYPE()) && StringUtil.isNotEmpty(bpmTaskMappingCO
				    .getProcessVariablesVO().getDEFAULT_VALUE()))
		    {
			bpmTaskMappingCO.setFieldDesc(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(bpmTaskMappingCO
				    .getProcessVariablesVO().getDEFAULT_VALUE()).getDescription());
			bpmTaskMappingCO.setVariableValue(null);
		    }
		    else if(ButtonCustomizationConstants.MAP_TYPE.CONSTANT.equals(bpmTaskMappingCO
			    .getProcessVariablesVO().getDEFAULT_TYPE()))
		    {
			bpmTaskMappingCO.getProcessVariablesVO().setDEFAULT_VALUE(null);
			bpmTaskMappingCO.setFieldDesc(null);
		    }
			
		}
	    }
	    /**
	     *  set the collection into gridModel attribute defined at JSP grid tag
	     */
	    setGridModel(processVariablesList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String loadInstanceHistGrid()
    {
	try
	{
	    prepareCommonParams();
	    
	    String[] searchCols = { "PROCESS_INSTANCE_ID", "PROCESS_ID","PROCESS_NAME","EXTERNAL_ID","PROCESS_INSTANCE_DESCRIPTION","IDENTITY", "PROCESS_VERSION",
		    "STATUS", "START_DATE", "END_DATE", "ACTION_COMMENT"};
	    bpmSC.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(bpmSC);
	    
	    BpmCO bpmProcessHistCO = bpmBO.returnInstanceHistList(bpmCO,bpmSC);
	    if(bpmProcessHistCO != null)
	    {	
		List<BpmProcessInstanceLogCO> historyLogList = bpmProcessHistCO.getHistoryLogList();
		if(historyLogList != null && !historyLogList.isEmpty())
		{
		    BpmSC criteria = new BpmSC();
		    criteria.setUserId(bpmCO.getBpmUserName());
		    Map<String, BpmTaskMappingCO> accessRightMap = bpmBO.returnProcesAccessRightByUser(criteria);
		    for(BpmProcessInstanceLogCO instanceLogCO : historyLogList)
		    {
			    if(instanceLogCO != null)
			    {
				if(accessRightMap != null && accessRightMap.containsKey(instanceLogCO.getProcessId())
					&& BpmEngineConstant.INSTANCE_STATUS.ACTIVE.getValue().equals(bpmCO.getType()))
				{
				    instanceLogCO.setShowAbortBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
					    instanceLogCO.getProcessId()).getAccessRightVO().getSHOW_ABORT_INSTANCE_YN()));
				}
			    }
			    enableBpmAdminActions(bpmCO, null, null, instanceLogCO);
		    }
		    
		    /**
		     *  set number of rows to be displayed in the page of grid, and the
		     * total number of records for first time load only
		     */
		    if(checkNbRec(bpmSC))
		    {
			setRecords(bpmProcessHistCO.getCount());
		    }

		    /**
		     *  set the collection into gridModel attribute defined at JSP grid tag
		     */
		    setGridModel(historyLogList);
		}
	    }
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String loadBpmLogsGrid()
    {
	try
	{
	    
	    String[] searchCols = { "ACTION_TYPE_DESC", "CREATED_DATE", "CREATED_BY", "ACTION_COMMENT" };
	    bpmSC.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(bpmSC);
	    
	    SessionCO sessionCO = returnSessionObject();
	    bpmSC.setPreferredLanguage(sessionCO.getLanguage());
	    bpmSC.setLovTypeId(BpmEngineConstant.LOV_TYPE_TASK_ACTIONS_DESC);
	    if(StringUtil.isNotEmpty(bpmSC.getActionTypes()))
	    {
		bpmSC.setActionTypesList(Arrays.asList(bpmSC.getActionTypes().split(",")));
	    }
	    
	    /**
	     *  set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(bpmSC))
	    {
		setRecords(bpmBO.returnBpmLogsListCount(bpmSC));
	    }

	    /**
	     *  return the collection of records
	     */
	    List<BpmTaskMappingCO> logsList = bpmBO.returnBpmLogsList(bpmSC);
	    
	    /**
	     *  set the collection into gridModel attribute defined at JSP grid tag
	     */
	    setGridModel(logsList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String loadbpmDocsGrid()
    {
	try
	{
	    
	    String[] searchCols = { "DOC_ID", "DOC_NAME", "DOC_TYPE" };
	    bpmSC.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(bpmSC);
	    
	    /**
	     *  set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(bpmSC))
	    {
		setRecords(bpmBO.returnBpmDocsListCount(bpmSC));
	    }

	    /**
	     *  return the collection of records
	     */
	    List<BpmTaskMappingCO> logsList = bpmBO.returnBpmDocsList(bpmSC);
	    
	    /**
	     *  set the collection into gridModel attribute defined at JSP grid tag
	     */
	    setGridModel(logsList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public void setBpmBO(BpmBO bpmBO)
    {
        this.bpmBO = bpmBO;
    }

    public BpmCO getBpmCO()
    {
        return bpmCO;
    }

    public void setBpmCO(BpmCO bpmCO)
    {
        this.bpmCO = bpmCO;
    }

    public BpmSC getBpmSC()
    {
        return bpmSC;
    }

    public void setBpmSC(BpmSC bpmSC)
    {
        this.bpmSC = bpmSC;
    }
    
}
