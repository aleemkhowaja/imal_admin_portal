package com.path.actions.common.dynamicscreen;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.path.bo.common.CommonMethods;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;

public class DynamicScreenCommonMethods
{

    public static String replaceLookupQueryParams(SessionCO sessionCO,Map elemHm,String querySynthax) throws Exception
    {
	   
	   RequiredFieldsSC requiredFieldsSC = new RequiredFieldsSC(); 
	   requiredFieldsSC.setLoginUserId(sessionCO.getUserName());
	   requiredFieldsSC.setCompCode(sessionCO.getCompanyCode());
	   requiredFieldsSC.setCompanyName(sessionCO.getCompanyName());
	   requiredFieldsSC.setBranchCode(sessionCO.getBranchCode());
	   requiredFieldsSC.setBranchName(sessionCO.getBranchName());
	   requiredFieldsSC.setUserFirstName(sessionCO.getUserFirstName());
	   requiredFieldsSC.setUserLastName(sessionCO.getUserLastName());
	   requiredFieldsSC.setBaseCurrencyName(sessionCO.getBaseCurrencyName());
	   requiredFieldsSC.setIsTeller((sessionCO.getCtsTellerVO() != null ? BigDecimal.ONE : BigDecimal.ZERO));
	   requiredFieldsSC.setRunningDate(sessionCO.getRunningDateRET());    
	   List<Map<String, Object>> recordList = CommonMethods.returnBoolExpressionDataList(requiredFieldsSC);
	
	   Map<String, HashMap> screenParamMapValues = new HashMap<String, HashMap>();
	   Object screenParamMapObj =  elemHm.get("screenParamMap");
	   if(screenParamMapObj instanceof String && StringUtil.isNotEmpty(screenParamMapObj.toString()))
	   {
	       ObjectMapper mapper = new ObjectMapper();
	       screenParamMapValues = mapper.readValue(screenParamMapObj.toString(),new TypeReference<HashMap<String, HashMap>>(){});
	   }
	   else if(screenParamMapObj instanceof String[] && StringUtil.isNotEmpty(((String[])screenParamMapObj)[0]))
	   {
	       ObjectMapper mapper = new ObjectMapper();
	       screenParamMapValues = mapper.readValue(((String[])screenParamMapObj)[0],new TypeReference<HashMap<String, HashMap>>(){});
	   }
		   
	   Pattern paramPattern = Pattern.compile("(.*?)(\\[screen.(\\S*)\\]|\\[session.(\\S*)\\])(.*?)");
	   Matcher paramMatcher = paramPattern.matcher(querySynthax);
	   StringBuffer queryBuffer = new StringBuffer();
	   while(paramMatcher.find())
	   {
	       if(paramMatcher.group(2) != null)
	       {
		   //in case of screen parameter
		   if(StringUtil.isNotEmpty(paramMatcher.group(3)))
		   {
		       String screenParamName = paramMatcher.group(3);
		       HashMap<String, String> screenParamHashMap = screenParamMapValues.get(screenParamName);
		       Object screenParamObj = elemHm.get("screen_".concat(screenParamName));
		       String screenParamValue = "";
		       if(screenParamObj instanceof String)
		       {
			   screenParamValue = screenParamObj.toString();
		       }
		       else if(screenParamObj instanceof String[])
		       {
			   screenParamValue = ((String[])screenParamObj)[0].toString();
		       }
		       String screenParamMode = screenParamHashMap.get("inputMode");
		       if("number".equals(screenParamMode))
		       {
			   paramMatcher.appendReplacement(queryBuffer, paramMatcher.group(1) + screenParamValue );
		       }
		       else if("text".equals(screenParamMode))
		       {
			   paramMatcher.appendReplacement(queryBuffer, paramMatcher.group(1) + "'" + screenParamValue + "'");
		       }
		   }
		   //in case of session parameter
		   if(StringUtil.isNotEmpty(paramMatcher.group(4)) && recordList != null && recordList.size() >= 1)
		   {
		       String sessionParamName = paramMatcher.group(4);
		       Object sessionParamObj = recordList.get(0).get(sessionParamName);
			    
		       if(sessionParamObj instanceof String)
		       {
			   paramMatcher.appendReplacement(queryBuffer, paramMatcher.group(1)  + "'" + sessionParamObj.toString() + "'" );
		       }
		       else if(sessionParamObj instanceof Number)
		       {
			   paramMatcher.appendReplacement(queryBuffer, paramMatcher.group(1) + sessionParamObj.toString() );
		       }
			    
		   }
	       }
	   }
	   
	   paramMatcher.appendTail(queryBuffer);
	   querySynthax = queryBuffer.toString();
	   return querySynthax;   
    }

}
