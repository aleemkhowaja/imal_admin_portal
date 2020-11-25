/**
 * 
 */
package com.path.actions.common.dynamicscreen;

import java.math.BigDecimal;
import java.net.URLDecoder;
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
import org.codehaus.jackson.type.TypeReference;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.dynamicscreen.DynamicScreenBO;
import com.path.bo.common.screengenerator.GeneratorBO;
import com.path.dbmaps.vo.SYS_DYN_TABLE_DETVO;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.dynlookup.DynCommonLookupSC;
import com.path.vo.common.screengenerator.DynScreenQueryCO;
import com.path.vo.common.screengenerator.DynamicScreenCreatorCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AdelNasrallah
 *
 * LinkDynamicScreenTabListAction.java used to
 */
public class DynScrGridListAction extends GridBaseAction
{
    private ScreenGeneratorSC criteria = new ScreenGeneratorSC();

    private DynamicScreenBO dynamicScreenBO;
    private GeneratorBO       generatorBO;

    @Override
    public Object getModel()
    {
        // TODO Auto-generated method stub
        return criteria;
    }
	public String loadDynScrGrid()
	{
		try
		{
	  	    SessionCO sessionCO = returnSessionObject();
			criteria.setLovTypeId(ConstantsCommon.DATA_TYPE_LOV_TYPE);
			criteria.setLangCode(sessionCO.getLanguage());

			// retrieve the columns to construct the query
			List<DynamicScreenCreatorCO> dynScrCreatorList = dynamicScreenBO.retrieveDynamicTableInfo(criteria);
			
			List<String> searchColList = new ArrayList<String>();
			List<String> colList = new ArrayList<String>();
			HashMap<String,String> dateSearchCol = new HashMap<String,String>();
			String primaryCol = "";
			StringBuilder primaryColTemp = new StringBuilder();
			String prefix = "";
			SYS_DYN_TABLE_DETVO sysDynTableDetVO = new SYS_DYN_TABLE_DETVO();
			
			// loop over columns to construct the query
			for(int i = 0; i< dynScrCreatorList.size(); i++)
			{
				sysDynTableDetVO = dynScrCreatorList.get(i).getSysDynTableDetVO();
				if(sysDynTableDetVO.getPRIMARY_KEY().intValue()==1)
				{
					primaryColTemp.append(prefix);
					prefix = ",";
					primaryColTemp.append(sysDynTableDetVO.getCOL_TECH_NAME());
				}
				if(sysDynTableDetVO.getCOL_TYPE().intValue()!=6){
				    colList.add(sysDynTableDetVO.getCOL_TECH_NAME());					
				}
				if(sysDynTableDetVO.getCOL_TYPE().intValue()==2 || sysDynTableDetVO.getCOL_TYPE().intValue()==5)
				{
					dateSearchCol.put(sysDynTableDetVO.getCOL_TECH_NAME(), sysDynTableDetVO.getCOL_TECH_NAME());
				}
					searchColList.add(sysDynTableDetVO.getCOL_TECH_NAME());			
			}
			
			// add additional columns for primary keys in grid in order to retrieve the record based on these columns
			primaryCol = primaryColTemp.toString();
			
			    
			colList.add("'"+primaryCol+"'"+"PRIMARY_COL");

			String[] searchCol = searchColList.toArray(new String[0]);
			
			//** copy the details related to search criteria to the SC
			criteria.setSearchCols(searchCol);
			criteria.setDateSearchCols(dateSearchCol);

			criteria.setCurrAppName(sessionCO.getCurrentAppName());
			copyproperties(criteria);

			String queryData = "SELECT " + StringUtil.returnStringFromArray(colList, ",") + " FROM " +dynScrCreatorList.get(0).getScrTableTechName(); 
			criteria.setQueryData(queryData);

			//** set number of rows to be displayed in the page of grid, and the total number of records for first time load only
			if(checkNbRec(criteria))
			{
			  setRecords(dynamicScreenBO.returnDynGridListCount(criteria));
			}
			//** return the collection of records
			List<LinkedHashMap> dynGridList = dynamicScreenBO.returnDynGridListRecords(criteria);

			//** set the collection into gridModel attribute defined at JSP grid tag
			setGridModel(dynGridList);
			
		}
		catch(Exception e)
		{
			log.error(e, "Error in loadDynScrGrid");
			handleException(e, null, null);
		}
		return SUCCESS;
	}
	
    public String loadDynScrGridWidget()
    {
	try
	{
	    List<LinkedHashMap> dynGridList = null;
	    if(criteria.getObjectType().equals("Table"))
	    {
		
		loadByTableName(dynGridList);
	    }
	    else if(criteria.getObjectType().equals("Query"))
	    {
		loadByQuery(dynGridList);
	    }
	    else if(criteria.getObjectType().equals("RestService"))
	    {
	    	loadByRestService(dynGridList);
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadDynScrGrid");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    private void loadByTableName(List<LinkedHashMap> dynGridList)
    {
	try
	{
	SessionCO sessionCO = returnSessionObject();
	criteria.setLovTypeId(ConstantsCommon.DATA_TYPE_LOV_TYPE);
	criteria.setLangCode(sessionCO.getLanguage());

	// retrieve the columns to construct the query
	List<DynamicScreenCreatorCO> dynScrCreatorList = dynamicScreenBO.retrieveTableInfoById(criteria);
       // retrieve condition
	DynCommonLookupSC dynCommonLookupSC = new DynCommonLookupSC();
	dynCommonLookupSC.setElementId(criteria.getElementId());
	dynCommonLookupSC.setPropertyCode("retCond");
	DynamicScreenCO dynScrCO  = dynamicScreenBO.returnelemPropertyDetails(dynCommonLookupSC);
	String condition = null;
	if(dynScrCO!=null)
	{
	    condition= dynScrCO.getPropertyExprValue();
	}
	if(StringUtil.isNotEmpty(condition)) {
	JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(condition);
	Object[] modelArr = jsonModel.toArray();
	JSONObject obj = (JSONObject) modelArr[0];
	condition = obj.getString("querySynthax");
	}
	List<String> searchColList = new ArrayList<String>();
	List<String> colList = new ArrayList<String>();
	HashMap<String, String> dateSearchCol = new HashMap<String, String>();
	String primaryCol = "";
	StringBuilder primaryColTemp = new StringBuilder();
	String prefix = "";
	SYS_DYN_TABLE_DETVO sysDynTableDetVO = new SYS_DYN_TABLE_DETVO();

	// loop over columns to construct the query
	for(int i = 0; i < dynScrCreatorList.size(); i++)
	{  
	    sysDynTableDetVO = dynScrCreatorList.get(i).getSysDynTableDetVO();
	    if(sysDynTableDetVO.getPRIMARY_KEY().intValue() == 1)
	    {
		primaryColTemp.append(prefix);
		prefix = ",";
		primaryColTemp.append(sysDynTableDetVO.getCOL_TECH_NAME());
	    }
	    if(sysDynTableDetVO.getCOL_TYPE().intValue() != 6)
	    {
		colList.add(sysDynTableDetVO.getCOL_TECH_NAME());
	    }
	    if(sysDynTableDetVO.getCOL_TYPE().intValue() == 2 || sysDynTableDetVO.getCOL_TYPE().intValue() == 5)
	    {
		dateSearchCol.put(sysDynTableDetVO.getCOL_TECH_NAME(), sysDynTableDetVO.getCOL_TECH_NAME());
	    }
	    searchColList.add(sysDynTableDetVO.getCOL_TECH_NAME());
	}
	// add additional columns for primary keys in grid in order to retrieve
	// the record based on these columns
	primaryCol = primaryColTemp.toString();
	colList.add("'" + primaryCol + "'" + " PRIMARY_COL");

	String[] searchCol = searchColList.toArray(new String[0]);

	// ** copy the details related to search criteria to the SC
	criteria.setSearchCols(searchCol);
	criteria.setDateSearchCols(dateSearchCol);

	criteria.setCurrAppName(sessionCO.getCurrentAppName());
	copyproperties(criteria);
	//construct query from tableName
	String queryData = "SELECT " + StringUtil.returnStringFromArray(colList, ",") + ",DATE_UPDATED FROM "
		+ dynScrCreatorList.get(0).getScrTableTechName();
	//if condition is not empty add condition to query
	if(StringUtil.isNotBlank(condition))
	{
	    queryData+=" WHERE ".concat(condition);

	    //Validate query
	    DynScreenQueryCO dynScreenQueryCO = new DynScreenQueryCO();
	    dynScreenQueryCO.setQuerySynthax(queryData);
	    dynScreenQueryCO.setElementType(ConstantsCommon.ELEMENT_TYPE_GRID);
	    generatorBO.checkQueryValidation(dynScreenQueryCO);
	    //get query parameters
	    if(StringUtil.isNotEmpty(criteria.getScreenParamMap()))
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
		//session parameters
		List<Map<String, Object>> recordList = CommonMethods.returnBoolExpressionDataList(requiredFieldsSC);

		Map<String, HashMap> screenParamMapValues = new HashMap<String, HashMap>();
		ObjectMapper mapper = new ObjectMapper();
		//screen parameters
		screenParamMapValues = mapper.readValue(criteria.getScreenParamMap(),new TypeReference<HashMap<String, HashMap>>(){});

		Pattern paramPattern = Pattern.compile("(.*?)(\\[screen.(\\S*)\\]|\\[session.(\\S*)\\])(.*?)");
		Matcher paramMatcher = paramPattern.matcher(queryData);
		StringBuffer queryBuffer = new StringBuffer();
		while(paramMatcher.find())
		{
		    if(paramMatcher.group(2) != null)
		    {
			//in case of screen parameter
			if(StringUtil.isNotEmpty(paramMatcher.group(3)))
			{
			    String screenParamName = paramMatcher.group(3);
			    //if parameter from radio button the id is concatenated with the value selected
			    HashMap<String, String> screenParamHashMap;
			    if(screenParamMapValues.containsKey(screenParamName+screenParamMapValues.get("inputValue"))) {
				screenParamHashMap=screenParamMapValues.get(screenParamName+screenParamMapValues.get("inputValue"));
			    }
			    else
			    {
				//if of type lookup then key starts with lookuptxt
				screenParamHashMap = screenParamMapValues.containsKey("lookuptxt_"+screenParamName)?screenParamMapValues.get("lookuptxt_"+screenParamName):screenParamMapValues.get(screenParamName);
			    }
			    String screenParamValue = screenParamHashMap.get("inputValue");
			    String screenParamMode = screenParamHashMap.get("inputMode");
			    if(ConstantsCommon.COLUMN_NUMBER_TYPE.equalsIgnoreCase(screenParamMode))
			    {
				if(screenParamValue.isEmpty())
				{
				    screenParamValue="NULL";
				}
				//Escape single quotes
				else if(screenParamValue.indexOf("'")!=-1)
				{
				    screenParamValue = screenParamValue.replaceAll("'", "''");  
				}
				paramMatcher.appendReplacement(queryBuffer, paramMatcher.group(1) + screenParamValue );
			    }
			    else if(ConstantsCommon.COLUMN_TEXT_TYPE.equalsIgnoreCase(screenParamMode))
			    {
				if(screenParamValue.isEmpty())
				{
				    screenParamValue="NULL";
				}
				//Escape single quotes
				else if(screenParamValue.indexOf("'")!=-1)
				{
				    screenParamValue = screenParamValue.replaceAll("'", "''");  
				}
				paramMatcher.appendReplacement(queryBuffer, paramMatcher.group(1) + "'" + screenParamValue + "'");
			    }
			}
			//in case of session parameter
			else if(StringUtil.isNotEmpty(paramMatcher.group(4)) && recordList != null && recordList.size() > 0)
			{
			    String sessionParamName = paramMatcher.group(4);
			    Object sessionParamObj = recordList.get(0).get(sessionParamName);

			    if(sessionParamObj instanceof String)
			    {
				String screenParamValue = sessionParamObj.toString();
				//Escape single quotes
				if(screenParamValue.indexOf("'")!=-1)
				{
				    screenParamValue = screenParamValue.replaceAll("'", "''");  
				}
				paramMatcher.appendReplacement(queryBuffer, paramMatcher.group(1)  + "'" + screenParamValue + "'" );
			    }
			    else if(sessionParamObj instanceof Number)
			    {
				String screenParamValue = sessionParamObj.toString();
				//Escape single quotes
				if(screenParamValue.indexOf("'")!=-1)
				{
				    screenParamValue = screenParamValue.replaceAll("'", "''");  
				}
				paramMatcher.appendReplacement(queryBuffer, paramMatcher.group(1) + sessionParamObj.toString() );
			    }

			}
			else 
			{
			    paramMatcher.appendReplacement(queryBuffer, paramMatcher.group(1) + "NULL");
			}
		    }
		}

		paramMatcher.appendTail(queryBuffer);
		queryData = queryBuffer.toString();
	    }


	    criteria.setQueryData(queryData);

	    if(ConstantsCommon.TRUE.equalsIgnoreCase(criteria.getLoadEmptyGrid()))
	    {
		if(checkNbRec(criteria))
		{
		    setRecords(0);
		}
		dynGridList = new ArrayList<LinkedHashMap>();
	    }
	    else
	    {
		// ** set number of rows to be displayed in the page of grid, and the total number of records for first time load only
		if(checkNbRec(criteria))
		{
		    setRecords(dynamicScreenBO.returnDynGridListCount(criteria));
		}
		// ** return the collection of records
		dynGridList = dynamicScreenBO.returnDynGridListRecords(criteria);
	    }	
	}
	else 
	{ 
	    criteria.setQueryData(queryData);
	    // ** set number of rows to be displayed in the page of grid, and the
	    // total number of records for first time load only
	    if(checkNbRec(criteria))
	    {
		setRecords(dynamicScreenBO.returnDynGridListCount(criteria));
	    }
	    // ** return the collection of records
	    dynGridList = dynamicScreenBO.returnDynGridListRecords(criteria);
	}
	// ** set the collection into gridModel attribute defined at JSP grid
	// tag
	setGridModel(dynGridList);
	
	// TP#897711 SUPT190250 - Nazim Jassar ; 29/11/2019 [START]
	updateDynamicRowFooter(dynGridList, searchCol);
	// TP#897711 SUPT190250 - Nazim Jassar ; 29/11/2019 [END]

	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadDynScrGrid");
	    handleException(e, null, null);
	}
    }
	
    private void loadByQuery(List<LinkedHashMap> dynGridList)
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    List<String> searchColList = new ArrayList<String>();

	    HashMap<String, String> dateSearchCol = new HashMap<String, String>();

	    DynCommonLookupSC dynCommonLookupSC = new DynCommonLookupSC();
	    dynCommonLookupSC.setElementId(criteria.getElementId());
	    dynCommonLookupSC.setPropertyCode("query");
	    DynamicScreenCO dynScrCO  = dynamicScreenBO.returnelemPropertyDetails(dynCommonLookupSC);
	    String queryData = dynScrCO.getPropertyExprValue();
	    JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(queryData);
	    Object[] modelArr = jsonModel.toArray();
	    JSONObject obj = (JSONObject) modelArr[0];

	    String querySyntax = obj.getString("querySynthax");
	    DynScreenQueryCO dynScreenQueryCO = new DynScreenQueryCO();
	    dynScreenQueryCO.setQuerySynthax(querySyntax);
	    dynScreenQueryCO.setElementType(ConstantsCommon.ELEMENT_TYPE_GRID);
	    //TP#1081060 Issue with query grid
	    dynScreenQueryCO = generatorBO.returnQueryParams(dynScreenQueryCO);
	   Map<String, Map<String,String>> hmDataStruct = generatorBO.returnGridColNames(dynScreenQueryCO.getQuerySynthax());
	   Iterator it = hmDataStruct.entrySet().iterator();

	    while(it.hasNext())
	    {
		Entry entry = (Entry) it.next();
		String theKey = (String) entry.getKey();
		Map<String,String> colType = (Map<String,String>) entry.getValue();
		//replace spaces by '_' in column alias name 
		theKey = StringUtil.nullToEmpty(theKey).replaceAll(" " , "_");
		if(colType.containsKey("date"))
		{
		    dateSearchCol.put(theKey, theKey);
		}
		searchColList.add(theKey);
	    }
	    String[] searchCol = searchColList.toArray(new String[0]);

	    // ** copy the details related to search criteria to the SC
	    criteria.setSearchCols(searchCol);
	    criteria.setDateSearchCols(dateSearchCol);

	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    if(StringUtil.isNotEmpty(criteria.getFilters()))
	    {
		criteria.setFilters(URLDecoder.decode(criteria.getFilters(),FileUtil.DEFAULT_FILE_ENCODING));
	    }
	    copyproperties(criteria);
	    if(StringUtil.isNotEmpty(criteria.getScreenParamMap()))
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
		ObjectMapper mapper = new ObjectMapper();
		screenParamMapValues = mapper.readValue(criteria.getScreenParamMap(),new TypeReference<HashMap<String, HashMap>>(){});

		Pattern paramPattern = Pattern.compile("(.*?)(\\[screen.(\\S*)\\]|\\[session.(\\S*)\\])(.*?)");
		Matcher paramMatcher = paramPattern.matcher(querySyntax);
		StringBuffer queryBuffer = new StringBuffer();
		while(paramMatcher.find())
		{
		    if(paramMatcher.group(2) != null)
		    {
			//in case of screen parameter
			if(StringUtil.isNotEmpty(paramMatcher.group(3)))
			{
			    String screenParamName = paramMatcher.group(3);
			    //if parameter from radio button
			    HashMap<String, String> screenParamHashMap;
			    if(screenParamMapValues.containsKey(screenParamName+screenParamMapValues.get("inputValue"))) {
				screenParamHashMap=screenParamMapValues.get(screenParamName+screenParamMapValues.get("inputValue"));
			    }
			    //Check if parameter is of type lookup to add lookup_txt to id otherwise take the elementId as it is
			    else
			    {
				screenParamHashMap = screenParamMapValues.containsKey("lookuptxt_"+screenParamName)?screenParamMapValues.get("lookuptxt_"+screenParamName):screenParamMapValues.get(screenParamName);
			    }
			    String screenParamValue = screenParamHashMap.get("inputValue");
			    String screenParamMode = screenParamHashMap.get("inputMode");
			    if(ConstantsCommon.COLUMN_NUMBER_TYPE.equals(screenParamMode))
			    {
				if(screenParamValue.isEmpty())
				{
				    screenParamValue="NULL";
				}
				paramMatcher.appendReplacement(queryBuffer, paramMatcher.group(1) + screenParamValue );
			    }
			    else if(ConstantsCommon.COLUMN_TEXT_TYPE.equals(screenParamMode))
			    {
				if(screenParamValue.isEmpty())
				{
				    screenParamValue="NULL";
				}
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
		querySyntax = queryBuffer.toString();
	    }
	    
	    criteria.setQueryData(querySyntax);

	    if(ConstantsCommon.TRUE.equalsIgnoreCase(criteria.getLoadEmptyGrid()))
	    {
		    if(checkNbRec(criteria))
		    {
			setRecords(0);
		    }
		    dynGridList = new ArrayList<LinkedHashMap>();
	    }
	    else
	    {
		// ** set number of rows to be displayed in the page of grid, and the total number of records for first time load only
		if(checkNbRec(criteria))
		{
		    setRecords(dynamicScreenBO.returnDynGridListCount(criteria));
		}
		// ** return the collection of records
		dynGridList = dynamicScreenBO.returnDynGridListRecords(criteria);
	    }
	    List<LinkedHashMap> dynGridListNew  = new ArrayList<LinkedHashMap> ();
	    
	    //TP#1081060 replace spaces in column name by '_'
	    dynGridList.forEach(item->{
		LinkedHashMap dynGridMap = new LinkedHashMap();
		item.forEach((k,v)->{
			k = ((String) k).trim().replace(' ','_');
			dynGridMap.put(k, v);
		});
		dynGridListNew.add(dynGridMap);
	});
	    // ** set the collection into gridModel attribute defined at JSP grid tag
	    setGridModel(dynGridListNew);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadDynScrGrid");
	    handleException(e, null, null);
	}
    }
    
    // TP#897711 SUPT190250 - Nazim Jassar ; 29/11/2019 [START]
    private String updateDynamicRowFooter(List<LinkedHashMap> dynGridList, String[] colList)
    {
	try
	{

	    ScreenGeneratorSC screenGeneratorSC = new ScreenGeneratorSC();
	    screenGeneratorSC.setFormatFieldId(criteria.getScreenFieldId());
	    screenGeneratorSC.setScreenId(criteria.getScreenId());
	    String colProps = dynamicScreenBO.returnColProps(screenGeneratorSC);

	    if ( StringUtil.isNotEmpty(colProps))
	    {
        	    JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(colProps);
        	    JSONArray jsonModel = jsonFilter.getJSONArray("root");
        	    Object[] modelArr = jsonModel.toArray();
        
        	    String colTechName = "", footterDesc = "";
        	    ColumnWiseProcessor avgCoulmn = new ColumnWiseProcessor();
        	    ColumnWiseProcessor sumColumn = new ColumnWiseProcessor();
        	    HashMap<String, Object> gridFooterMap = new HashMap<String, Object>();
        	    for(int i = 0; i < modelArr.length; i++)
        	    {
        		JSONObject obj = (JSONObject) modelArr[i];
        		HashMap<String, Object> gridColsElemHm = (HashMap<String, Object>) new ObjectMapper()
        			.readValue(obj.toString(), HashMap.class);
        
        		if(gridColsElemHm != null && gridColsElemHm.get("FOOTER_DESC") != null && 
        			!gridColsElemHm.get("FOOTER_DESC").equals(""))
        		{
        		    if(gridColsElemHm.get("COL_TECH_NAME") != null)
        		    {
                		    colTechName = gridColsElemHm.get("COL_TECH_NAME").toString();
                		    footterDesc = gridColsElemHm.get("FOOTER_DESC").toString();
                		    gridFooterMap.put(colTechName, footterDesc);
        		    }
        		}
        		if(gridColsElemHm.get("AGGREGATE_CODE") != null && 
        			!gridColsElemHm.get("AGGREGATE_CODE").equals(""))
        		{    
        		    addToColumnProcessor(gridColsElemHm.get("COL_TECH_NAME").toString(),
        			gridColsElemHm.get("AGGREGATE_CODE").toString(), avgCoulmn, sumColumn);
        		}
        	    }
        	    processGridData(gridFooterMap, dynGridList, colList, avgCoulmn, sumColumn);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    private void processGridData(HashMap<String, Object> gridFooterMap, List<LinkedHashMap> dynGridList,
	    String[] colList, ColumnWiseProcessor avgColumn, ColumnWiseProcessor sumColumn)
    {
	try
	{
	    String colValue = "";
		for(String colName : colList)
		{
		    for(int i = 0; i < dynGridList.size(); i++)
		    {
			if(dynGridList.get(i).get(colName) != null)
			{
			    colValue = dynGridList.get(i).get(colName).toString();
			    avgColumn.inputAndProcess(colName, colValue);
			    sumColumn.inputAndProcess(colName, colValue);
			}
		    }
		}
		for(String colName : colList)
		{
		    if(avgColumn.getColumnProcessor(colName) != null)
			gridFooterMap.put(colName, avgColumn.getColumnProcessor(colName).result());
		    if(sumColumn.getColumnProcessor(colName) != null)
			gridFooterMap.put(colName, sumColumn.getColumnProcessor(colName).result());

		}
		setUserdata(gridFooterMap);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
    }

    private void addToColumnProcessor(String columnName, String aggregate, ColumnWiseProcessor avgManipulator,
	    ColumnWiseProcessor totalManipulator)
    {
	if(ConstantsCommon.AVERAGE.equals(aggregate))
	{
	    avgManipulator.addToColumnProcessor(columnName, new ColumnAvgOperation());
	}

	else if(ConstantsCommon.SUM.equals(aggregate))
	{
	    totalManipulator.addToColumnProcessor(columnName, new ColumnAggregateOperation());
	}
    }

    // TP#897711 SUPT190250 - Nazim Jassar ; 29/11/2019 [END]
    
    public void setDynamicScreenBO(DynamicScreenBO dynamicScreenBO)
    {
	this.dynamicScreenBO = dynamicScreenBO;
    }

    public ScreenGeneratorSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(ScreenGeneratorSC criteria)
    {
	this.criteria = criteria;
    }

    public void setGeneratorBO(GeneratorBO generatorBO)
    {
        this.generatorBO = generatorBO;
    }
    /**
     * @author Muhammad.Asif
     * this function is used when data source is Global activity of rest operation. 
     * @param  (List<LinkedHashMap> dynGridList
     * @throws Exception
     */
	private void loadByRestService(List<LinkedHashMap> dynGridList) throws Exception 
	{
		criteria.setSessionCO(returnSessionObject());
		List<String> searchColList = new ArrayList<String>();
		HashMap<String, String> dateSearchCol = new HashMap<String, String>();
		DynCommonLookupSC dynCommonLookupSC = new DynCommonLookupSC();
		PathPropertyUtil.copyProperties(criteria, dynCommonLookupSC);
		dynCommonLookupSC.setPropertyCode("query");
        DynamicScreenCO dynScrCO  = dynamicScreenBO.returnelemPropertyDetails(dynCommonLookupSC);
        String queryData = dynScrCO.getPropertyExprValue();	
		criteria.setQueryData(queryData);
		JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(queryData);
		Object[] modelArr = jsonModel.toArray();
		JSONObject obj = (JSONObject) modelArr[0];
		criteria.setButtonId(new BigDecimal(obj.getString("globalActivityId")));
		criteria.setRestOperationId(new BigDecimal(obj.getString("restOperationId")));
		if (obj.has("tableDatasource")
				&& obj.getString("tableDatasource").equals(ConstantsCommon.DATASOURCE_BY_GLOBAL_ACTIVITY)) 
		{
			JSONArray jsonColumnArr = obj.getJSONArray("parameterOutGridData");
			if (jsonColumnArr != null) 
			{
				for (Object object : jsonColumnArr) 
				{
					JSONObject jsonObject = (JSONObject) object;
					String paramType = jsonObject.getString("COL_DATA_TYPE");
					String paramName = StringUtil.nullToEmpty(jsonObject.getString("COL_TECH_NAME"));
					if ("date".equalsIgnoreCase(paramType) || "T".equalsIgnoreCase(paramType)) 
					{
						dateSearchCol.put(paramName, paramName.toUpperCase());
					}
					searchColList.add(paramName.toUpperCase());
				}
			}
			String[] searchCol = searchColList.toArray(new String[0]);
			// ** copy the details related to search criteria to the SC
			criteria.setSearchCols(searchCol);
			criteria.setDateSearchCols(dateSearchCol);
			criteria.setCurrAppName(criteria.getSessionCO().getCurrentAppName());
		}
		//criteria.set_search("true");
		copyproperties(criteria);
		String tableName = ConstantsCommon.DS_REST_TMP_TABLE_PREFIX + ( obj.has("elementIdName") ? obj.getString("elementIdName").toUpperCase() + "_" + obj.getString("screenId") : " DUAL " );
		criteria.setTableName(tableName);
		criteria.setPageNumber(this.getPage());
		dynGridList = dynamicScreenBO.loadByRestService(criteria);
					// ** set number of rows to be displayed in the page of grid, and the total
		// number of records for first time load only
		if (checkNbRec(criteria)) 
		{
			setRecords(dynGridList.size());
		}
		// ** set the collection into gridModel attribute defined at JSP grid tag
		setGridModel(dynGridList);
	}
}
