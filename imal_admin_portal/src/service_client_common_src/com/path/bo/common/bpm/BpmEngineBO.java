/**
 * 
 */
package com.path.bo.common.bpm;

import java.util.Map;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.bpm.BpmCO;
import com.path.vo.common.bpm.BpmTaskCO;
import com.path.vo.common.bpm.BpmTaskDetailsCO;
 
/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmEngineBO.java used to
 */
public interface BpmEngineBO
{
    /**
     * function that should return all tasks assigned or available to a user
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnUserAssignedAndAvailableTasks(BpmCO bpmCO) throws BaseException;
    
    
    /**
     * function that should return the definttion of all deployed process
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnProcessDefinitionList(BpmCO bpmCO) throws BaseException;
    
    
    /**
     * complete a task using it's task id
     * @param bpmCO
     * @throws BaseException
     */
    public void completeTask(BpmCO bpmCO) throws BaseException;    
    
    /**
     * complete a task using it's task id and set task out put parameters. 
     * the parameters will be passed in url like /rest/task/{taskId}/complete?map_LINK_CODE_out=1&map_COMP_CODE_out=1
     * in order to set the LINK_CODE_out and the COMP_CODE_out
     * @param bpmCO
     * @param taskParametersMap
     * @throws BaseException
     */
    public void competeTaskWithParam(BpmCO bpmCO, Map<String, String> taskParametersMap) throws BaseException;
    
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
     * start a task
     * @param bpmCO
     * @throws BaseException
     */
    public void startTask(BpmCO bpmCO)throws BaseException;
    
    /**
     * nominate a task
     * @param bpmCO
     * @throws BaseException
     */
    public void nominateTask(BpmCO bpmCO, String assignmentValues)throws BaseException;
    
    /**
     * start a process instance
     * @param bpmCO
     * @throws BaseException
     */
    public BpmCO startProcessInstance(BpmCO bpmCO)throws BaseException;
    
    /**
     * return the process defintion image
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnProcessDefinitionImage(BpmCO bpmCO)throws BaseException;
    
    /**
     * return task details
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmTaskDetailsCO returnTaskDetails(BpmCO bpmCO)throws BaseException;
    
    /**
     * return process variables
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public Map<String, Object> returnProcessVariables(BpmCO bpmCO)throws BaseException;
    
    /**
     * return tasks related to a process instance id
     * @param bpmCO
     * @throws BaseException
     */
    public BpmCO returnTasksByProcessInstance(BpmCO bpmCO)throws BaseException;
    
    /**
     * forward a task
     * @param bpmCO
     * @throws BaseException
     */
    public void forwardTask(BpmCO bpmCO)throws BaseException;
    
    /**
     * function used to return the Authorization that is passed in the header of a rest service call
     * @param userName
     * @param userPassWord
     * @return
     * @throws BaseException
     */
    public String returnAuthorization(String userName, String userPassWord)throws BaseException;
    
    /**
     * function that should return the list of process instance : all active , completed , aborted. it can be filterd by active only when passing the flag activeProcesses=true
     * @param bpmCO
     * @return
     * @throws BaseException
     */
    public BpmCO returnInstanceHistList(BpmCO bpmCO) throws BaseException;
    
    /**
     * abort a process instance
     * @param bpmCO
     * @throws BaseException
     */
    public BpmCO abortProcessInstance(BpmCO bpmCO)throws BaseException;
    
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

}
