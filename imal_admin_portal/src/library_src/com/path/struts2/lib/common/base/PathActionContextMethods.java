package com.path.struts2.lib.common.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.ActionContext;
import com.path.lib.log.Log;

public class PathActionContextMethods
{
    /**
     * Private constructor only to prevent instantiation in the class
     */
    private PathActionContextMethods()
    {
	Log.getInstance().error("PathActionContextMethods This Class Should not be Instantiated");
    }

    public static Map<String, String[]> returnParameters()
    {
	HttpParameters parameters = ActionContext.getContext().getParameters();

	/**
	 * Access to this method will be restricted with the next version
	 * deprecated since 2.5.6, do not use it
	 */
	Map<String, String[]> result = new HashMap<>(parameters.size());
	for(Map.Entry<String, Parameter> entry : parameters.entrySet())
	{
	    result.put(entry.getKey(), entry.getValue().getMultipleValues());
	}
	return result;
    }
    
    public static Map<String, Object> returnParametersObject()
    {
	HttpParameters parameters = ActionContext.getContext().getParameters();
	Map<String, Object> result = new HashMap<>(parameters.size());
	for(Map.Entry<String, Parameter> entry : parameters.entrySet())
	{
	    result.put(entry.getKey(), entry.getValue().getMultipleValues());
	}
	return result;
    }
    /**
     * adding or updating parameter in the ActionContext
     * @param paramName parameter name
     * @param paramValue parameter Value
     */
    public static void putParametersToContext(String paramName, Object paramValue)
    {
	HttpParameters parameters = ActionContext.getContext().getParameters();
	
	if(paramName != null)
	{
	    Parameter.Request newParameter = new Parameter.Request(paramName, paramValue);
	    parameters.put(paramName, newParameter);
	}
	
    }
}
