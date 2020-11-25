/**
 * 
 */
package com.path.vo.common.customization.button;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.opensymphony.xwork2.ActionContext;
import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * ButtonCustomizationCommonMethods.java used to
 */
public class ButtonCustomizationCommonMethods
{
    protected final static Log log = Log.getInstance();
    /**
     * Function used for constant mapping conversion to the related action parameter type
     * @param customActionParamCO
     */
    public static void constantParamMapConversion(CustomActionParamCO customActionParamCO)
    {
	if(customActionParamCO != null)
	{
	    try
	    {
		// IM_API_ARGUMENT.ARG_TYPE = 'N' --> NUMERIC
		// IM_API_ARGUMENT.ARG_TYPE = 'E' --> DECIMAL
		if(ButtonCustomizationConstants.ARG_TYPE.NUMBER.equals(customActionParamCO.getArgType())
			|| ButtonCustomizationConstants.ARG_TYPE.DECIMAL.equals(customActionParamCO.getArgType()))
		{
		    BigDecimal conversionValue = null;
		    if("".equals(StringUtil.nullToEmpty(customActionParamCO.getMapValue()).trim()))
		    {
			conversionValue = ConstantsCommon.EMPTY_BIGDECIMAL_VALUE;
		    }
		    else
		    {
			conversionValue = new BigDecimal(customActionParamCO.getMapValue());
		    }
		    customActionParamCO.setArgValue(conversionValue);

		}
		// IM_API_ARGUMENT.ARG_TYPE = 'T' --> DATE
		else if(ButtonCustomizationConstants.ARG_TYPE.DATE_DATETIME.equals(customActionParamCO.getArgType()))
		{
		    String dateString = customActionParamCO.getMapValue();
		    // sometimes like in toolbar search one might not key in a
		    // valid date string which will generate exception,
		    // 160 means space but comes as special character in grid case
		    if(!StringUtil.nullToEmpty(dateString).isEmpty()
			    && (dateString.length() != 1 || dateString.codePointAt(0) != 160))
		    {
			Map<String, Object> session = ActionContext.getContext().getContextMap();
			customActionParamCO.setArgValue(DateUtil.returnDateObj(dateString, session));
		    }

		}
		// IM_API_ARGUMENT.ARG_TYPE = 'V' --> VARCHAR
		else if(ButtonCustomizationConstants.ARG_TYPE.VARCHAR.equals(customActionParamCO.getArgType()))
		{
		    customActionParamCO.setArgValue(customActionParamCO.getMapValue());
		}
		// IM_API_ARGUMENT.ARG_TYPE = 'C' --> CHAR
		else if(ButtonCustomizationConstants.ARG_TYPE.CHAR.equals(customActionParamCO.getArgType()))
		{
		    String value = StringUtil.nullToEmpty(customActionParamCO.getMapValue());
		    customActionParamCO.setArgValue(value.length() > 0 ? value.substring(0,1) : "");
		}
		// IM_API_ARGUMENT.ARG_TYPE = 'I' --> INTEGER
		else if(ButtonCustomizationConstants.ARG_TYPE.INTEGER.equals(customActionParamCO.getArgType()))
		{
		    customActionParamCO.setArgValue(Integer.getInteger(customActionParamCO.getMapValue()));
		}
		// IM_API_ARGUMENT.ARG_TYPE = 'L' --> LONG
		else if(ButtonCustomizationConstants.ARG_TYPE.LONG.equals(customActionParamCO.getArgType()))
		{
		    customActionParamCO.setArgValue(Long.getLong(customActionParamCO.getMapValue()));
		}
		// IM_API_ARGUMENT.ARG_TYPE = 'D' --> DOUBLE
		else if(ButtonCustomizationConstants.ARG_TYPE.LONG.equals(customActionParamCO.getArgType())
			&& NumberUtil.isNumber(customActionParamCO.getMapValue()))
		{
		    customActionParamCO.setArgValue(Double.valueOf(customActionParamCO.getMapValue()));
		}
	    }
	    catch(Exception e)
	    {
		log.error(e," Conversion error in ButtonCustomizationMaintAction.constantParamMapConversion " + e.getMessage());
	    }
	}
    }
    
    public static CustomActionParamCO commonParamConversion(CustomActionParamCO customActionParamCO,
	    HashMap<String, String> screenMappingParamList, Object sessionCOObj, Map<String, Object> inputParamMap) throws BaseException
    {
	String mapType = customActionParamCO.getMapType();

	// Screen map type
	if(ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(mapType) || ButtonCustomizationConstants.MAP_TYPE.GRIDCOLUMN.equals(mapType)  )
	{
	    if(screenMappingParamList != null
		    && screenMappingParamList.containsKey(customActionParamCO.getOperationId() + "-"
			    + customActionParamCO.getArgId()))
	    {
		customActionParamCO.setMapValue(screenMappingParamList.get(customActionParamCO.getOperationId() + "-"
			+ customActionParamCO.getArgId()));
		ButtonCustomizationCommonMethods.constantParamMapConversion(customActionParamCO);
	    }
	}
	// Session map type
	else if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(mapType))
	{
	    PathPropertyUtil.copyProperties(sessionCOObj, customActionParamCO, customActionParamCO.getMapValue() + " argValue");
	}
	// Constant map type
	else if(ButtonCustomizationConstants.MAP_TYPE.CONSTANT.equals(mapType))
	{
	    ButtonCustomizationCommonMethods.constantParamMapConversion(customActionParamCO);
	}
	else if(ButtonCustomizationConstants.MAP_TYPE.MAP.equals(mapType))
	{
	    if(inputParamMap != null)
	    {
		if(ButtonCustomizationConstants.ARG_TYPE.LIST.equals(customActionParamCO.getArgType()))
		{
		  String xmlString =  null;
		  if(StringUtil.isNotEmpty(customActionParamCO.getMapValue())) 
		  {
		      if(ConstantsCommon.ONE.equals(customActionParamCO.getNestedArg())) 
		      {
			  xmlString		= getValueFromMap(inputParamMap, customActionParamCO.getMapValue().toString());
		      }
		      else 
		      {
			  xmlString		= jaxbObjectToXML(inputParamMap.get(customActionParamCO.getMapValue()));
			  
		      }
		  }
		  else 
		  {
			if(ConstantsCommon.ONE.equals(customActionParamCO.getNestedArg()))
			{
			    xmlString = getValueFromMap(inputParamMap, customActionParamCO.getArgName());
			}
			else
			{
			    xmlString = inputParamMap.get(customActionParamCO.getArgName()).toString();
			}
		  }
		  int beginIndex 	= nthIndexOf(xmlString, '<', 3);
		  int endIndex 		= xmlString.length();
		    for (int i = 0; i < 2; i++) {
			endIndex = xmlString.lastIndexOf('<', endIndex);
		    }
		  customActionParamCO.setArgValue(xmlString.subSequence(beginIndex, endIndex));
		}
		else
		{
		    if(StringUtil.isNotEmpty(customActionParamCO.getMapValue())) 
		    {
			if(ConstantsCommon.ONE.equals(customActionParamCO.getNestedArg()))
			{
			    customActionParamCO.setMapValue(getValueFromMap(inputParamMap,customActionParamCO.getMapValue().toString()));
			}
			else
			{
				if(inputParamMap.get(customActionParamCO.getMapValue()) != null)
				{
					customActionParamCO.setMapValue(inputParamMap.get(customActionParamCO.getMapValue()).toString());
				}
			}
		    }else 
		    {
			if(ConstantsCommon.ONE.equals(customActionParamCO.getNestedArg()))
			{
			    customActionParamCO.setMapValue(getValueFromMap(inputParamMap,customActionParamCO.getArgName()));
			}else 
			{
				if(inputParamMap.get(customActionParamCO.getArgName()) != null)
				{
				    customActionParamCO.setMapValue(inputParamMap.get(customActionParamCO.getArgName()).toString());
				}
			}
		    }
		    ButtonCustomizationCommonMethods.constantParamMapConversion(customActionParamCO);
		}
	    }
	}
	return customActionParamCO;
    }
    
    public static String getValueFromMap(Map<String, Object> inputParamMap, String argName)
    {
	String[] keyArray = argName.split(Pattern.quote("."));
	String value = null;
	 if(inputParamMap.get(keyArray[0])!=null) 
	 {
        	if(keyArray.length>1) 
        	{
        	    value =   getValueFromMap((Map<String, Object>) inputParamMap.get(keyArray[0]),argName.substring(keyArray[0].length() +1 ,argName.length()));
        	}
        	else 
        	{
        	    value =    inputParamMap.get(keyArray[0]).toString();
        	}
	 }
	return value;
    }

    public static int nthIndexOf(String text, char needle, int n)
    {
        for (int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) == needle)
            {
                n--;
                if (n == 0)
                {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static String jaxbObjectToXML(Object co) {
	    String xmlString = "";
	    try {
	        JAXBContext context = JAXBContext.newInstance(co.getClass());
	        Marshaller m = context.createMarshaller();

	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

	        StringWriter sw = new StringWriter();
	        m.marshal(co, sw);
	        xmlString = sw.toString();

	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }

	    return xmlString;
	}
    
    public static void buildNextActionMap(Map<BigDecimal, BigDecimal> nextActionsMap,  CustomActionParamCO customActionParamCO)
    {
	BigDecimal parentOpId = customActionParamCO.getParentOpId();
	//when the parent op id is -1 that means the parent operation is a condition, so no need to add this operation in the next action map
	BigDecimal conditionParentOpId = new BigDecimal(-1);
	
	if(parentOpId != null && !conditionParentOpId.equals(parentOpId))
	{
	    nextActionsMap.put(parentOpId,customActionParamCO.getOperationId());
	}
    }

    
    public static void buildActionsParamMap(Map<BigDecimal, Map<BigDecimal, CustomActionParamCO>> actionsParamMap, CustomActionParamCO customActionParamCO)
    {
	Map<BigDecimal, CustomActionParamCO> btnMap = null;
	if(actionsParamMap.containsKey(customActionParamCO.getOperationId()))
	{
	    btnMap = actionsParamMap.get(customActionParamCO.getOperationId());
	}
	else
	{
	    btnMap = new HashMap<BigDecimal, CustomActionParamCO>();
	    actionsParamMap.put(customActionParamCO.getOperationId(), btnMap);
	}
	if(ButtonCustomizationConstants.OP_TYPE.ACTION.equals(customActionParamCO.getOperationType()))
	{
	    if(customActionParamCO.getArgId() != null)
	    {
		btnMap.put(customActionParamCO.getArgId(), customActionParamCO);
	    }
	    else
	    {
		btnMap.put(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE, customActionParamCO);
	    }
	}
	// TP 1034362 - add null checking for key to avoid null pointer exception related to the TP
	else if(ButtonCustomizationConstants.OP_TYPE.CONDITION.equals(customActionParamCO.getOperationType()) && null != customActionParamCO.getCondLineNo())
	{
	    btnMap.put(customActionParamCO.getCondLineNo(), customActionParamCO);
	}
    }

    public static Map<String, Object> fillNestedMap(Map<String, Object> outputParamMap, String map_KEY, Object argValue)
    {
	String[] keyArray = map_KEY.split(Pattern.quote("."));
	if(keyArray.length>1) 
	{
	    if(outputParamMap.get(keyArray[0])==null) 
	    {
		outputParamMap.put(keyArray[0],new HashMap<String,Object>());
	    }
	    fillNestedMap((Map<String, Object>) outputParamMap.get(keyArray[0]),map_KEY.substring(keyArray[0].length() +1 ,map_KEY.length()),argValue);
	}
	else 
	{
	    outputParamMap.put(keyArray[0], argValue);
	}
	return outputParamMap;
    }
}
