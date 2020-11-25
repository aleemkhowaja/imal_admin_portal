/**
 * 
 */
package com.path.bo.common.bpm;

import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.SYS_PARAM_BPM_LOGSVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_PROCESS_DEFVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DEFINITIONVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.bpm.BpmCO;
import com.path.vo.common.bpm.BpmExporterCO;
import com.path.vo.common.bpm.BpmProcessCO;
import com.path.vo.common.bpm.BpmSC;
import com.path.vo.common.bpm.BpmTaskCO;
import com.path.vo.common.bpm.BpmTaskDetailsCO;
import com.path.vo.common.bpm.BpmTaskMappingCO;
import com.path.vo.common.bpm.jbpm.JbpmProcessVarCO;
 
/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmBO.java used to
 */
public interface BpmBO
{
    
    /**
     * This function will return all assigned and available user task. the userId should be passed in bpmCO
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnUserAssignedAndAvailableTasks(BpmCO bpmCO, BpmSC bpmSC) throws BaseException;

    /**
     * This function will return the definition of all deployed process
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnProcessDefinitionList(BpmCO bpmCO, BpmSC bpmSC) throws BaseException;
    
    /**
     * complete a task using it's task id
     * @param bpmCO
     * @throws BaseException
     */
    public void completeTask(BpmCO bpmCO) throws BaseException;
    
    /**
     * complete a task using it's task id and set human task parmeters
     * @param bpmCO
     * @throws BaseException
     */
    public void completeTaskWithParam(BpmCO bpmCO, Map<String, String> taskParametersMap) throws BaseException;
    
    
    /**
     * claim a task
     * @param bpmCO
     * @throws BaseException
     */
    public void claimTask(BpmCO bpmCO)throws BaseException;
    
    /**
     * release a task
     * @param bpmCO
     * @throws BaseException
     */
    public void releaseTask(BpmCO bpmCO)throws BaseException;
    
    /**
     * start a process instance, 
     * The required parameters are : 
     * - bpmCO.processDefId and bpmCO.deploymentId needed to identify the process to be started. 
     * - bpmCO.bpmUserName to indicate the BPM user.
     * - bpmCO.loadPasswordFromUsrDet should be true in case we don't have the user'.s password ( password is empty ),so the password will be retrieved from database. No need to be true if we have the password.
     * - bpmCO.comment : optional parameter used to insert a descriptive log when starting a new process instance.  
     * @param bpmCO
     * @throws BaseException
     */
    public BpmCO startProcessInstance(BpmCO bpmCO)throws BaseException;
    
    /**
     * return the process definition image
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnProcessDefinitionImage(BpmCO bpmCO)throws BaseException;
    
    
    /**
     * return the human task mapping including the screen url
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnHumanTaskMapping(BpmCO bpmCO)throws BaseException;
    
    /**
     * function that return the output mapping of the human task. these are the task variables mapping that need to be set into jbpm
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnOutputHumanTaskMapping(BpmCO bpmCO) throws BaseException;
    
    /**
     * this function is used to return the count of the all screen defitions
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnScreenDefListCount(BpmSC criteria) throws BaseException;
    /**
     * this function is used to return the list of screen definitions defined in SYS_PARAM_SCREEN_DEFINITION
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<SYS_PARAM_SCREEN_DEFINITIONVO> returnScreenDefList(BpmSC criteria) throws BaseException;
    
    /**
     * dependency by screen code
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO dependencyByScreenCode(BpmCO bpmCO) throws BaseException;
    
    /**
     * save the screen mapping. in case replaceMapping is checked then it will delete all previous data before inserting new one
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO saveScreenMapping(BpmCO bpmCO) throws BaseException;
    
    /**
     * delete all user task mapping including input and output arguments
     * @param criteria
     * @throws BaseException
     */
    public void deleteUserTaskMapping(BpmSC criteria) throws BaseException;
    
    /**
     * insert uploaded file into SYS_PARAM_BPM_PROCESS_DEF
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO uploadBpmnFile(BpmCO bpmCO) throws BaseException;
    
    /**
     * this function is used to return the list of the all uploaded process definitions ( uploaded bpmn2 files ) 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<SYS_PARAM_BPM_PROCESS_DEFVO> returnUploadedProcessDefList(BpmSC criteria) throws BaseException;
    
    
    /**
     * this function is used to return the count of the all uploaded process definitions ( uploaded bpmn2 files ) 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnUploadedProcessDefListCount(BpmSC criteria) throws BaseException;
    
    /**
     * this function is used to return the list of all user tasks and the related mapping to imal screens
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<BpmTaskMappingCO> returnUserTaskMapList(BpmSC criteria) throws BaseException;
    
    /**
     * this function is used to return the count of the all user tasks and the related mapping to imal screens
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnUserTaskMapListCount(BpmSC criteria) throws BaseException;
    
    /**
     * return the list of input argument of a task
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<BpmTaskMappingCO> returnTaskInputArg(BpmSC criteria) throws BaseException;
    
    /**
     * This function will return the list of process variables defined in a bpmn2 file
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public List<JbpmProcessVarCO> returnProcessVarList(BpmCO bpmCO) throws BaseException;
    
    /**
     * return task output mapping
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<BpmTaskMappingCO> returnTaskOutputArg(BpmSC criteria) throws BaseException;
    
    /**
     * common method used to save input/output mapping 
     * @param bpmCO
     * @return
     */
    public BpmCO saveArgMapping(BpmCO bpmCO) throws BaseException;
    
    /**
     * delete an uploaded process and all related task mapping with their arguments
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO deleteUploadedProcessDef(BpmCO bpmCO) throws BaseException;
    
    /**
     * function that return process variables
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public Map<String, Object> returnProcessVariables(BpmCO bpmCO) throws BaseException;
    
    /**
     * this function is used to return the list assignments for a specific task
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<BpmTaskMappingCO> returnUserTaskAssignList(BpmSC criteria) throws BaseException;
    
    /**
     * this function is used to return the count of assignments of a specific task
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnUserTaskAssignListCount(BpmSC criteria) throws BaseException;
    
    /**
     * This function will return the task details
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmTaskDetailsCO returnTaskDetails(BpmCO bpmCO)throws BaseException;
    
    /**
     * this function is used to return the list of roles from S_ROLE
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<Map<String, Object>> returnRolesList(BpmSC criteria) throws BaseException;
        
    /**
     * this function is used to return the count of the list of roles in S_ROLE
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnRolesListCount(BpmSC criteria) throws BaseException;
    
    /**
     * this function will delete a task assignment record in SYS_PARAM_BPM_TASK_ASSIGNMENT
     * @param bpmCO
     * @throws BaseException
     */
    public BpmCO deleteTaskAssignment(BpmCO bpmCO) throws BaseException;
    
    /**
     * this function will save the task assignment records in SYS_PARAM_BPM_TASK_ASSIGNMENT
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO saveTaskAssignement(BpmCO bpmCO) throws BaseException;
    
    /**
     * this function is used to return the list of users from USR
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<USRVO> returnUsersList(BpmSC criteria) throws BaseException;
    
    /**
     * this function is used to return the count of the list of users in USR
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnUsersListCount(BpmSC criteria) throws BaseException;
    
    /**
     * dependency by user/roles in task assignment grid
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO dependencyByTaskAssignment(BpmCO bpmCO) throws BaseException;
    
    /**
     * return map of BpmTaskMappingCO initialized with taskMapVO
     * @param criteria
     * @return
     * @throws BaseException
     */
    public Map<String, BpmTaskMappingCO> returnTaskMapByProcessDef(BpmSC criteria) throws BaseException;
    
    /**
     * forward a task
     * @param bpmCO
     * @throws BaseException
     */
    public void forwardTask(BpmCO bpmCO)throws BaseException;
    
    /**
     * this function is used to return the list of access rights defined for a specific process
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<BpmTaskMappingCO> returnProcessAccessRightList(BpmSC criteria) throws BaseException;
    
    /**
     *  this function is used to return the count of the list of access rights defined for a specific process
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnProcessAccessRightListCount(BpmSC criteria) throws BaseException;
    
    /**
     * this function will delete a access right record in SYS_PARAM_BPM_ACCESS_RIGHT
     * @param bpmCO
     * @throws BaseException
     */
    public BpmCO deleteProcessAccessRight(BpmCO bpmCO) throws BaseException;
    
    /**
     * this function will save the access right records in SYS_PARAM_BPM_ACCESS_RIGHT
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO saveProcessAccessRight(BpmCO bpmCO) throws BaseException;
    
    /**
     * return map of access rights given to a user on all process
     * @param criteria
     * @throws DAOException
     */
    public Map<String, BpmTaskMappingCO> returnProcesAccessRightByUser(BpmSC criteria) throws BaseException;
    
    /**
     * this function will extract the uploaded process CLOB , parse it and prepare an xls file;
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO downloadXlsProcessDoc(BpmCO bpmCO,Map<String, String> transMap)throws BaseException;
    
    /**
     * this function will extract the uploaded process CLOB , parse it and prepare an docx file;
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO downloadDocProcessDoc(BpmCO bpmCO,Map<String, String> transMap)throws BaseException;
    
    /**
     * function that should return the list of process instance : all active , completed , aborted. it can be filterd by active only when passing the flag activeProcesses=true
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnInstanceHistList(BpmCO bpmCO, BpmSC bpmSC) throws BaseException;
    
    /**
     * abort a process instance
     * @param bpmCO
     * @throws BaseException
     */
    public BpmCO abortProcessInstance(BpmCO bpmCO)throws BaseException;
    
    /**
     * this function is used to return the list of process variables defined for a specific process
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<BpmTaskMappingCO> returnProcessVariablesList(BpmSC criteria) throws BaseException;
    
    /**
     *  this function is used to return the count of the list of process variables defined for a specific process
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnProcessVariablesListCount(BpmSC criteria) throws BaseException;
    
    /**
     * this function will save the process variables records in SYS_PARAM_BPM_PROCESS_VAR
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO saveProcessVariables(BpmCO bpmCO) throws BaseException;
    
    /**
     * check if the process instance should be started with variables then open the variable setting dialog 
     * or if we need to start the process instance directly without variable setting.  
     * @param bpmCO
     * @throws BaseException
     */
    public BpmCO startProcessInstanceWithVariables(BpmCO bpmCO)throws BaseException;
    
    /**
     * this function will return the list of process variable to be set on startup of the new process instance
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public List<BpmTaskMappingCO> returnProcessVariablesListOnStartUp(BpmCO bpmCO) throws BaseException;
    
    /**
     * suspend a task
     * @param bpmCO
     * @throws BaseException
     */
    public void suspendTask(BpmCO bpmCO)throws BaseException;
    
    /**
     * resume a task
     * @param bpmCO
     * @throws BaseException
     */
    public void resumeTask(BpmCO bpmCO)throws BaseException;
    
    /**
     * method to return the list of BPM process definitions filtered by start access right.
     * Only the BPM user name is required, the BPM user password will be retrieved dynamically.
     * Parameters :
     * bpmCO.bpmUserName : the BPM user name
     * @param bpmCO
     * @return List<BpmProcessCO>
     * @throws BaseException
     */
    public List<BpmProcessCO> returnProcessDefListByStartAccess(BpmCO bpmCO) throws BaseException;
    
    /**
     * this function is used to returnthe list of BPM Logs
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<BpmTaskMappingCO> returnBpmLogsList(BpmSC criteria) throws BaseException;
    
    /**
     * this function is used to return the count of the list of BPM Logs
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnBpmLogsListCount(BpmSC criteria) throws BaseException;
    
    /**
     * function used to save new logs from logs grid
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO saveNewLogs(BpmCO bpmCO) throws BaseException;
    
    /**
     * function used to export all the related query related to BPM Process
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmExporterCO returnBpmExporter(BpmCO bpmCO) throws BaseException;
    
    /**
     * function used to export all the related query related to BPM Process
     * @param bpmCO
     * @return true if we should open a confirmation popup
     * @throws BaseException
     */
    public boolean insertBpmExporter(BpmExporterCO bpmImporterCO,String confirmationResponse) throws BaseException;
    
    /**
     * save process definition list
     * @param bpmProcessDefLis
     * @throws BaseException
     */
    public void saveProcessDef(List<SYS_PARAM_BPM_PROCESS_DEFVO> bpmProcessDefLis) throws BaseException;
    
    /**
     * this function is used to return the list of BPM Docs
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<BpmTaskMappingCO> returnBpmDocsList(BpmSC criteria) throws BaseException;
    
    /**
     * this function is used to return the count of the list of BPM Docs
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnBpmDocsListCount(BpmSC criteria) throws BaseException;
    
    /**
     * insert uploaded document into SYS_PARAM_BPM_DOC
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO uploadDocument(BpmCO bpmCO) throws BaseException;
    
    /**
     * delete uploaded document from SYS_PARAM_BPM_DOC
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO deleteDocument(BpmCO bpmCO) throws BaseException;
 
    /**
     * download document from SYS_PARAM_BPM_DOC
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnDownloadedDocument(BpmCO bpmCO) throws BaseException;
    
    /**
     * this function is used to delete a log record from table SYS_PARAM_BPM_LOGS
     * @param bpmLogVO
     * @throws BaseException
     */
    public void deleteBpmLog(SYS_PARAM_BPM_LOGSVO bpmLogVO)throws BaseException;
    
    /**
     * this function will return all tasks related to a process instance. 
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnTasksByProcessInstance(BpmCO bpmCO, BpmSC bpmSC) throws BaseException;
    
    /**
     * this method returns the screen definition VO related to the human task
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public SYS_PARAM_SCREEN_DEFINITIONVO returnBpmScreenProgRef(BpmCO bpmCO) throws BaseException;
    
}
