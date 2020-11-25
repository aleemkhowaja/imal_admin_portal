package com.path.lib.common.interceptor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.path.bo.common.bpm.BpmBO;
import com.path.bo.common.bpm.BpmEngineConstant;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.struts2.lib.common.BaseObject;
import com.path.vo.common.bpm.BpmCO;
import com.path.vo.common.bpm.BpmSC;
import com.path.vo.common.bpm.BpmTaskDetailsCO;
import com.path.vo.common.bpm.BpmTaskMappingCO;
 
public class PathBpmInterceptor implements MethodInterceptor {
    
    private BpmBO bpmBO;
    protected final static Log pathlog = Log.getInstance();
    @Override
    public Object invoke(MethodInvocation method) throws Throwable {
          
	BigDecimal bpmTaskId = null;
	String deploymentId = null;
	String bpmUserName = null;
        String bpmUserPass = null;
        
        pathlog.debug("[PathBpmInterceptor]  method = " + method.getMethod().toGenericString());
        
	Object[] argumentsArray = method.getArguments();
	if(argumentsArray != null && argumentsArray.length > 0)
	{
	    for(Object argument : argumentsArray)
	    {
		if(argument instanceof BaseObject)
		{
		    BaseObject obj = (BaseObject) argument;
		    if(!NumberUtil.isEmptyDecimal(obj.getBpmTaskId()))
		    {
			bpmTaskId = obj.getBpmTaskId();
			deploymentId = obj.getBpmDeploymentId();
			bpmUserName = obj.getBpmUserName();
			bpmUserPass = obj.getBpmUserPass();
			break;
		    }
		}
	    }
	}
	
	pathlog.debug("[PathBpmInterceptor]  bpmTaskId = " + bpmTaskId + ", deploymentId = " + deploymentId);
	
        //note : to get the method name use method.getMethod().getName()
	//execute the current method
        Object result = method.proceed();
           
	    if(!NumberUtil.isEmptyDecimal(bpmTaskId) 
		    && Boolean.valueOf(PathPropertyUtil.getPathRemotingProp("PathRemoting", "bpm.enabled")))
	    {
		BpmCO bpmCO = new BpmCO();
		bpmCO.setMethodSignature(method.getMethod().getName());
		bpmCO.setBpmUserName(bpmUserName);
		bpmCO.setBpmUserPass(bpmUserPass);
		bpmCO.setBpmTaskId(bpmTaskId);
		bpmCO.setDeploymentId(deploymentId);
		
		pathlog.debug("[PathBpmInterceptor] bpmTaskId not null ");
		
		pathlog.debug("[PathBpmInterceptor] bpmUserName = " + bpmUserName);
		pathlog.debug("[PathBpmInterceptor] bpmUserPass = " + bpmUserPass);
		pathlog.debug("[PathBpmInterceptor] bpmTaskId = " + bpmTaskId);
		pathlog.debug("[PathBpmInterceptor] deploymentId = " + deploymentId);
		pathlog.debug("[PathBpmInterceptor] method.getMethod().getName() = " + method.getMethod().getName());
		
		pathlog.debug("[PathBpmInterceptor] bpmBO is null : " + (bpmBO == null));
		BpmTaskDetailsCO returnedBpmTaskCO = bpmBO.returnTaskDetails(bpmCO);
		
		if(returnedBpmTaskCO != null && returnedBpmTaskCO.getBpmTaskDataCO() != null)
		{    
		    String taskName = returnedBpmTaskCO.getTaskName();
		    String processName = returnedBpmTaskCO.getBpmTaskDataCO().getProcessId();
		    String methodSignature = bpmCO.getMethodSignature();
		    
		    pathlog.debug("[PathBpmInterceptor]  taskName = " + taskName );
		    pathlog.debug("[PathBpmInterceptor]  processName = " + processName );
		    pathlog.debug("[PathBpmInterceptor]  methodSignature = " + methodSignature );
		    
		    bpmCO.setTaskName(taskName);
		    bpmCO.setProcessDefId(processName);
		    
		    
		    if(BpmEngineConstant.BPM_BO_MAPPING.containsKey(processName)
			    && BpmEngineConstant.BPM_BO_MAPPING.get(processName).containsKey(taskName)
			    	&& BpmEngineConstant.BPM_BO_MAPPING.get(processName).get(taskName).containsKey(methodSignature))
		    {    
			   
			
			BpmSC criteria = new BpmSC();
			criteria.setTaskNameList(Arrays.asList(taskName));
			criteria.setProcessDefList(Arrays.asList(processName));
			Map<String, BpmTaskMappingCO> taskMap = bpmBO.returnTaskMapByProcessDef(criteria);
			String taskMapKey = processName.concat("_").concat(taskName); 
			if(taskMap != null 
				&& taskMap.containsKey(taskMapKey) 
				&& BpmEngineConstant.COMPLETION_TYPE.MANUEL.equals(taskMap.get(taskMapKey).getTaskMapVO().getCOMPLETION_TYPE()))
			{
			    pathlog.debug("[PathBpmInterceptor] return - task completion type is manuel");
			    return result;
			}
			
			pathlog.debug("[PathBpmInterceptor] method signature exists " );
			
			String methodArg = BpmEngineConstant.BPM_BO_MAPPING.get(processName).get(taskName).get(methodSignature);
			if(StringUtil.isNotEmpty(methodArg) && methodArg.contains("="))
			{
			    String[] argumentChecking = methodArg.trim().split("=");
			    if(argumentChecking != null && argumentChecking.length == 2 
				    && StringUtil.isNotEmpty(argumentChecking[0]) && StringUtil.isNotEmpty(argumentChecking[1]))
			    {
				Object paramObject = PathPropertyUtil.returnProperty(result, argumentChecking[0]);	
				if(paramObject == null || !String.valueOf(paramObject).equals(argumentChecking[1]))
				{
				    pathlog.debug("[PathBpmInterceptor] return - invalid argument checking " + argumentChecking[1] + " paramObject = " + String.valueOf(paramObject));
				    return result;
				}
				
			    }
			}
			
			bpmCO = bpmBO.returnOutputHumanTaskMapping(bpmCO);
        		if(bpmCO != null)
        		{    
        		    Map<String , String> taskParametersMap = null;
        		    if(bpmCO.getBpmTaskMappingCOList() != null && !bpmCO.getBpmTaskMappingCOList().isEmpty())
        		    {
        			taskParametersMap = prepareTaskOutputParam(bpmCO.getBpmTaskMappingCOList(), result);
        		    }
        		    bpmBO.completeTaskWithParam(bpmCO, taskParametersMap);
        		    pathlog.debug("[PathBpmInterceptor] completeTaskWithParam  taskParametersMap = " + String.valueOf(taskParametersMap) );
        		}
		    }
		}
        }
        return result;
    }

    private Map<String, String> prepareTaskOutputParam(List<BpmTaskMappingCO> bpmTaskMappingCOList, Object result)
	    throws BaseException
    {
	if(bpmTaskMappingCOList != null && !bpmTaskMappingCOList.isEmpty())
	{
	    //Map<String, Object> session = ActionContext.getContext().getSession();
	    //SessionCO sessionCO = (SessionCO) session.get(ConstantsCommon.SESSION_VO_ATTR);
	    
	    Map<String, String> outputMap = new HashMap<String, String>();
	    for(BpmTaskMappingCO mappingCO : bpmTaskMappingCOList)
	    {
		if(StringUtil.isNotEmpty(mappingCO.getTaskMapArgOutVO().getARG_NAME()))
		{
		    String mapType = mappingCO.getTaskMapArgOutVO().getMAP_TYPE();
		    String argName = "map_" + mappingCO.getTaskMapArgOutVO().getARG_NAME();
		    if(BpmEngineConstant.MAP_TYPE.SCREEN.equals(mapType))
		    {
			String voCOReference = mappingCO.getFieldTechDetVO().getVO_CO_REFERENCE();
			String voPropertyName = mappingCO.getFieldTechDetVO().getVO_PROPERTY_NAME();
			if(StringUtil.isNotEmpty(voCOReference) && StringUtil.isNotEmpty(voPropertyName))
			{
			    String propName = null;
			    if("default".equals(voCOReference))
			    {
				propName = voPropertyName;
			    }
			    else
			    {
				propName = voCOReference.concat(".").concat(voPropertyName);
			    }
			    try
			    {
				Object paramObject = PathPropertyUtil.returnProperty(result, propName);
				pathlog.debug("[PathBpmInterceptor] prepareTaskOutputParam - paramObject = " + String.valueOf(paramObject));
				//to avoid getting NumberFormatException when the paramObject is null and the process variable is numeric
				if(paramObject != null)
				{
				    //the map_COMP_CODE_out of type FLOAT can be set as 1 in JBPM but when coming to a condition the evaluation throw error
				    //that's why we need to set a scale in order to make values like 1 to be 1.00
				    if(paramObject instanceof BigDecimal)
				    {
					paramObject = ((BigDecimal) paramObject).setScale(2);
				    }
				    //set the date in BPM as a String with dd/MM/yyyy format 
				    if(paramObject instanceof Date)
				    {
					paramObject = DateUtil.format((Date)paramObject);
				    }
				    String paramValue = paramObject == null ? "" : paramObject.toString();
				    outputMap.put(argName, paramValue);
				}
			    }
			    catch (BaseException e) 
			    {
				pathlog.debug("[PathBpmInterceptor] prepareTaskOutputParam - property not fount in method result. propName = " + propName );
				continue;
			    }
			}
		    }
		    else if(BpmEngineConstant.MAP_TYPE.CONSTANT.equals(mapType))
		    {
			outputMap.put(argName, mappingCO.getTaskMapArgOutVO().getMAP_VALUE());
		    }

		}

	    }
	    return outputMap;
	    
	}
	return null;
    }
    
    public void setBpmBO(BpmBO bpmBO)
    {
        this.bpmBO = bpmBO;
    }
    
}