/**
 * 
 */
package com.path.bo.common.bpm;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmCommonMethods.java used to
 */
public class BpmCommonMethods
{
    private static final Log log = Log.getInstance();
    
    public static void initializeBpmEngineProperties()
    {
	try
	{
	    if(Boolean.valueOf(PathPropertyUtil.getPathRemotingProp("PathRemoting", "bpm.enabled")))
	    {
		for(BpmEngineConstant.BPM_PROPERTIES property : BpmEngineConstant.BPM_PROPERTIES.values())
		{
		    property.setValue(PathPropertyUtil.returnPathPropertyFromFile(BpmEngineConstant.BPM_PROPERTY_FILE,property.toString()));
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "[BpmCommonMethods] initializeBpmEngineProperties " + e.getMessage());
	}
    }
    
    public static void initializeBpmBOMappingProperties()
    {
	try
	{
	    if(Boolean.valueOf(PathPropertyUtil.getPathRemotingProp("PathRemoting", "bpm.enabled")))
	    {
		if(BpmEngineConstant.BPM_BO_MAPPING == null)
		{
		    BpmEngineConstant.BPM_BO_MAPPING = new HashMap<String, Map<String, Map<String, String>>>();

		    Properties prop = new Properties();
		    prop.load(PathPropertyUtil.class.getClassLoader().getResourceAsStream(
			    BpmEngineConstant.BPM_BO_MAPPING_PROPERTY_FILE));
		    Set<Object> keys = prop.keySet();
		    if(keys != null && !keys.isEmpty())
		    {
			for(Object key : keys)
			{
			    String processName = key.toString();
			    String processMapping = prop.getProperty(processName);
			    if(StringUtil.isNotEmpty(processMapping))
			    {
				String[] taskMapping = processMapping.trim().split(",");
				if(taskMapping != null && taskMapping.length > 0)
				{
				    for(String boMapping : taskMapping)
				    {
					String[] taskBoMapping = boMapping.trim().split(":");
					if(taskBoMapping != null && taskBoMapping.length == 2)
					{
					    String bpmTaskName = StringUtil.nullToEmpty(taskBoMapping[0]).trim();
					    String bpmBoMethod = StringUtil.nullToEmpty(taskBoMapping[1]).trim();
					    if(StringUtil.isNotEmpty(bpmTaskName) && StringUtil.isNotEmpty(bpmBoMethod))
					    {
						if(!(BpmEngineConstant.BPM_BO_MAPPING.containsKey(processName)))
						{
						    BpmEngineConstant.BPM_BO_MAPPING.put(processName,
							    new HashMap<String, Map<String, String>>());
						}

						if(!BpmEngineConstant.BPM_BO_MAPPING.get(processName).containsKey(
							bpmTaskName))
						{
						    BpmEngineConstant.BPM_BO_MAPPING.get(processName).put(bpmTaskName,
							    new HashMap<String, String>());
						}

						String bpmBoArg = "";

						String patternString = "(.*)\\((.*)\\)";
						// Create a Pattern object
						Pattern pattern = Pattern.compile(patternString);
						// Now create matcher object.
						Matcher matcher = pattern.matcher(bpmBoMethod);
						if(matcher.find())
						{
						    bpmBoMethod = matcher.group(1);
						    bpmBoArg = matcher.group(2);
						}

						BpmEngineConstant.BPM_BO_MAPPING.get(processName).get(bpmTaskName)
							.put(bpmBoMethod, bpmBoArg);
					    }
					}
				    }
				}
			    }
			}
		    }
		}
	    }
	}
	catch (Exception e) 
	{
	    BpmEngineConstant.BPM_BO_MAPPING = null;
	    log.error(e, "[BpmCommonMethods] initializeBpmBOMappingProperties " + e.getMessage());
	}
    }
    
    public static void reloadBpmEngineProperties()
    {
	try
	{
	    if(Boolean.valueOf(PathPropertyUtil.getPathRemotingProp("PathRemoting", "bpm.enabled")))
	    {
		synchronized(BpmEngineConstant.BPM_PROPERTIES.values())
		{
		    PathPropertyUtil.removeCachedPropFile(BpmEngineConstant.BPM_PROPERTY_FILE);
		    initializeBpmEngineProperties();
		}
		synchronized(BpmEngineConstant.BPM_BO_MAPPING)
		{
		    BpmEngineConstant.BPM_BO_MAPPING = null;
		    PathPropertyUtil.removeCachedPropFile(BpmEngineConstant.BPM_BO_MAPPING_PROPERTY_FILE);
		    initializeBpmBOMappingProperties();
		}

	    }
	}
	catch(Exception e)
	{
	    log.error(e, "[BpmCommonMethods] reloadBpmEngineProperties " + e.getMessage());
	}
    }

}
