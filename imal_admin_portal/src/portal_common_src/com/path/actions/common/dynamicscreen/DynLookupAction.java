/**
 * 
 */
package com.path.actions.common.dynamicscreen;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jackson.map.ObjectMapper;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.dynamicscreen.DynamicScreenBO;
import com.path.bo.common.screengenerator.GeneratorBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.dynlookup.DynCommonLookupSC;
import com.path.vo.common.screengenerator.DynScreenQueryCO;
import org.codehaus.jackson.type.TypeReference;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DynLookupAction.java used to
 */
public class DynLookupAction  extends LookupBaseAction
{
   private DynamicScreenBO   dynamicScreenBO;  
   private GeneratorBO       generatorBO;

   private DynCommonLookupSC criteria = new DynCommonLookupSC();
   
   @Override
   public Object getModel()
   {
	return criteria;
   }
   
   /**
    * 
    * @author marwanmaddah
    * @date   Feb 10, 2016
    * @return String
    *
    */
   public String constructQryLookup()
   {
        try{
            criteria.setPropertyCode("query");
            DynamicScreenCO dynScrCO  = dynamicScreenBO.returnelemPropertyDetails(criteria);
	    String queryData = dynScrCO.getPropertyExprValue();
            JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(queryData);
            Object[]  modelArr  = jsonModel.toArray();
            JSONObject obj      = (JSONObject) modelArr[0];
	    
	    String columnCode   = obj.getString("columnCode");
	    String columnDesc   = obj.getString("columnDesc");
	    
	    DynScreenQueryCO dynScreenQueryCO = new DynScreenQueryCO();
	    dynScreenQueryCO.setColumnCode(columnCode);
	    dynScreenQueryCO.setColumnDesc(columnDesc);
	    dynScreenQueryCO.setQuerySynthax(obj.getString("querySynthax"));
	    DynScreenQueryCO resultCO = generatorBO.checkQueryValidation(dynScreenQueryCO);
	    Map<String,String> hmDataStruct = resultCO.getQueryDataStruct();
	    Iterator it  = hmDataStruct.entrySet().iterator();
	    StringBuffer namesStr   = new StringBuffer();
	    StringBuffer colTypeStr = new StringBuffer(); 
	    StringBuffer titlesStr  = new StringBuffer(); 
	    int i=0;
	    while(it.hasNext())
	    {
		Entry  entry  = (Entry)it.next();
		String theKey = (String)entry.getKey();
		if(i==0)
		{
		    namesStr.append(theKey);
		    titlesStr.append(getText(theKey));
		    colTypeStr.append((String)entry.getValue());
		}
		else
		{
		    namesStr.append(",").append(theKey);
		    titlesStr.append(",").append(getText(theKey));
		    colTypeStr.append(",").append((String)entry.getValue());		    
		}
		i++;
	    }
	    String[]  name    = namesStr.toString().split(",");
	    String[]  colType = colTypeStr.toString().split(",");
	    String[]  titles  = titlesStr.toString().split(",");

	    /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/path/dynamicScreen/dynLookupAction_fillQryLookup");
	    lookup(grid, criteria, name, colType, titles); 

        }
	catch(Exception e)
	{
	    log.error("Error in the construction of the Dynamic lookup");
	    handleException(e,null,null);
	}
	return SUCCESS;
   }
   
   public String fillQryLookup()
   {
       try{
	   SessionCO sessionCO = returnSessionObject();
	   setSearchFilter(criteria);
	   copyproperties(criteria);
           Map<String,DynamicScreenCO> hmElemDataType = dynamicScreenBO.returnParamsDataType(criteria);
           criteria.setPropertyCode("query");
           DynamicScreenCO dynScrCO  = dynamicScreenBO.returnelemPropertyDetails(criteria);
	   String queryData = dynScrCO.getPropertyExprValue();
           JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(queryData);
           Object[]  modelArr  = jsonModel.toArray();
           JSONObject obj      = (JSONObject) modelArr[0];
           String querySynthax = obj.getString("querySynthax");
           String findParamPattern = "#\\s*(\\w+)";
	   Pattern p = Pattern.compile(findParamPattern);
	   Matcher matcher = p.matcher(querySynthax);
	   String elemTypeMode     = "";
	   DynamicScreenCO paramKeyDataType = null;
	   String elemType         = "";
	   String dataMode         = "";
	   JSONObject jsonObj      = null;
	   while (matcher.find())
	   {
	     String currParam  = matcher.group();
	     String paramKey = currParam.substring(1, currParam.length());

	     if(criteria.getElemHm()!=null && criteria.getElemHm().containsKey(paramKey) && !StringUtil.nullToEmpty(criteria.getElemHm().get(paramKey)).isEmpty())
	     {

               Object paramVal = ""; 
               /**
                * in case the key exists inside expBoolTestData then get the paramKey value from session
                */
	       if(ConstantsCommon.expBoolTestData.get(0).containsKey(paramKey))
	       {
		   paramVal = (Object)sessionCO.getClass().getMethod("get"+StringUtil.setFirstCharUpper(paramKey)).invoke(sessionCO);
	       }
	       else
	       {		   
		   paramVal = criteria.getElemHm().get(paramKey);
	       }
	       String repParamVal = "'"+paramVal+"'";
	       if(!hmElemDataType.isEmpty() && hmElemDataType.containsKey(paramKey))
	       {		   
		   paramKeyDataType = hmElemDataType.get(paramKey);
		   elemType = paramKeyDataType.getElementType();
		   dataMode = paramKeyDataType.getElement_mode();
		   switch(Integer.valueOf(elemType).intValue())
		   {
		       case 1:
			   if(String.valueOf(2).equals(dataMode))
			   {
			       repParamVal =  (String)paramVal;
			   }
			   break;
		       case 4:
			   if(criteria.getIsOracle() == 1)
			   {			       
			       repParamVal = "TO_DATE(TO_CHAR('"+paramVal+"','dd/mm/yyyy'),'dd/mm/yyyy')";
			   }
			   else
			   {
			       repParamVal = "CONVERT(DATE,CONVERT(VARCHAR,'"+paramVal+"',103),103))";
			   }
			   break;
			default:
			   repParamVal = "'"+paramVal+"'"; 
			   break;
		   }
	       }
	       
	       querySynthax = querySynthax.replaceAll(currParam,repParamVal);
	     }
	     else
	     {
		throw new BOException(MessageCodes.INVALID_MISSING, new String[]{"liveSearchParams_key"}); 
	     }
	   }

	   querySynthax = DynamicScreenCommonMethods.replaceLookupQueryParams(sessionCO, criteria.getElemHm(), querySynthax);
           criteria.setQuerySynthax(querySynthax);
           
 	   if(getRecords() == 0)
	   {
 	      int cnt = dynamicScreenBO.returnLookupQryCount(criteria);
 	      setRecords(Integer.valueOf(cnt));
	   }
	   ArrayList<LinkedHashMap> list = dynamicScreenBO.returnLookupQryResult(criteria);
	   setGridModel(list);
       }
       catch(Exception e)
       {
	   log.error("Error in the filling of the Dynamic lookup");
	   handleException(e,null,null);
       }
       return SUCCESS;
   }

    public String constructGridWidgetLookup()
    {
	try
	{
	    String colProps = dynamicScreenBO.returnGridWidgetLookup(criteria);

	    JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(colProps);
	    JSONArray jsonModel = jsonFilter.getJSONArray("root");
	    Object[] modelArr = jsonModel.toArray();
	    String queryData = null;

	    for(int i = 0; i < modelArr.length; i++)
	    {
		JSONObject obj = (JSONObject) modelArr[i];
		if(obj.get("COL_TECH_NAME").equals(criteria.getColName()))
		{
		    queryData = obj.get("QUERY_DATA").toString();
		    break;
		}
	    }

	    jsonModel = (JSONArray) JSONSerializer.toJSON(queryData);
	    modelArr = jsonModel.toArray();
	    JSONObject obj = (JSONObject) modelArr[0];

	    String columnCode = obj.getString("columnCode");
	    String columnDesc = obj.getString("columnDesc");

	    DynScreenQueryCO dynScreenQueryCO = new DynScreenQueryCO();
	    dynScreenQueryCO.setColumnCode(columnCode);
	    dynScreenQueryCO.setColumnDesc(columnDesc);
	    dynScreenQueryCO.setQuerySynthax(obj.getString("querySynthax"));
	    DynScreenQueryCO resultCO = generatorBO.checkQueryValidation(dynScreenQueryCO);
	    Map<String, String> hmDataStruct = resultCO.getQueryDataStruct();
	    Iterator it = hmDataStruct.entrySet().iterator();
	    StringBuffer namesStr = new StringBuffer();
	    StringBuffer colTypeStr = new StringBuffer();
	    StringBuffer titlesStr = new StringBuffer();
	    int i = 0;
	    while(it.hasNext())
	    {
		Entry entry = (Entry) it.next();
		String theKey = (String) entry.getKey();
		if(i == 0)
		{
		    namesStr.append(theKey);
		    titlesStr.append(getText(theKey));
		    colTypeStr.append((String) entry.getValue());
		}
		else
		{
		    namesStr.append(",").append(theKey);
		    titlesStr.append(",").append(getText(theKey));
		    colTypeStr.append(",").append((String) entry.getValue());
		}
		i++;
	    }
	    String[] name = namesStr.toString().split(",");
	    String[] colType = colTypeStr.toString().split(",");
	    String[] titles = titlesStr.toString().split(",");

	    /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/path/dynamicScreen/dynLookupAction_fillGridWidgetLookup");
	    lookup(grid, criteria, name, colType, titles);

	}
	catch(Exception e)
	{
	    log.error("Error in the construction of the Dynamic lookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
   
    public String fillGridWidgetLookup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    String colProps = dynamicScreenBO.returnGridWidgetLookup(criteria);
	    JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(colProps);
	    JSONArray jsonModel = jsonFilter.getJSONArray("root");
	    Object[] modelArr = jsonModel.toArray();
	    String queryData = null;

	    for(int i = 0; i < modelArr.length; i++)
	    {
		JSONObject obj = (JSONObject) modelArr[i];
		if(obj.get("COL_TECH_NAME").equals(criteria.getColName()))
		{
		    queryData = obj.get("QUERY_DATA").toString();
		    break;
		}
	    }

	    jsonModel = (JSONArray) JSONSerializer.toJSON(queryData);
	    modelArr = jsonModel.toArray();
	    JSONObject obj = (JSONObject) modelArr[0];
	    String querySynthax = obj.getString("querySynthax");
	    querySynthax = DynamicScreenCommonMethods.replaceLookupQueryParams(sessionCO, criteria.getElemHm(), querySynthax);
	    criteria.setQuerySynthax(querySynthax);

	    if(getRecords() == 0)
	    {
		int cnt = dynamicScreenBO.returnLookupQryCount(criteria);
		setRecords(Integer.valueOf(cnt));
	    }
	    ArrayList<LinkedHashMap> list = dynamicScreenBO.returnLookupQryResult(criteria);
	    setGridModel(list);
	}
	catch(Exception e)
	{
	    log.error("Error in the filling of the Dynamic lookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
   
    /**
     * @return the criteria
     */
    public DynCommonLookupSC getCriteria()
    {
        return criteria;
    }
    
    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(DynCommonLookupSC criteria)
    {
        this.criteria = criteria;
    }

    /**
     * @param dynLookupBO the dynLookupBO to set
     */
    public void setDynamicScreenBO(DynamicScreenBO dynamicScreenBO)
    {
        this.dynamicScreenBO = dynamicScreenBO;
    }

    /**
     * @param generatorBO the generatorBO to set
     */
    public void setGeneratorBO(GeneratorBO generatorBO)
    {
        this.generatorBO = generatorBO;
    }

}
