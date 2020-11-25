/**
 * 
 */
package com.path.actions.common.dynamicscreen;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.dynamicscreen.DynamicScreenBO;
import com.path.bo.common.dynclientparams.DynClientParamsBO;
import com.path.dbmaps.vo.SYS_DYN_SCREEN_DEFVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.dynamicscreen.DynamicScreenConstant;
import com.path.vo.common.dynclientparams.DynClientParamsSC;
import com.path.vo.common.dynlookup.DynCommonLookupSC;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
import com.path.vo.common.select.SelectCO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DynDependencyAction.java used to
 */
public class DynDependencyAction extends GridBaseAction
{
    private CommonLibSC criteria = new CommonLibSC();
    private DynamicScreenBO dynamicScreenBO;
    private DynClientParamsBO dynClientParamsBO;
    private DynamicScreenCO dynamicScreenCO        = new DynamicScreenCO();
    private SYS_DYN_SCREEN_DEFVO sysDynScreenDefVO = new SYS_DYN_SCREEN_DEFVO();
    private static final String TELEPHONE_FORMAT_COL = "TELEPHONE_FORMAT";
    private BigDecimal dynParamType;
    private String dynScreenMappingId;
    private String dynScreenMappingDesc;
    private BigDecimal columnType;
    private Map<String,Object> hmDepScrOptionsElems = new HashMap<String,Object>();//TP1010864 contains screen element map for dependency
    @Override
    public Object getModel()
    {
        return criteria;
    }
   /**
    * Used to manage dependency for column properties of type livesearch in dynamic screen grid
    */
    public String dynLookupDependency() 
    {
	SessionCO sessionCO = returnSessionObject();
	String elementId=null,colName =null, colDesc = null,colType =null,colTechName= null,elemId = null, colValue=null;
	DynCommonLookupSC dynCommonLookupSC =new DynCommonLookupSC ();

	try
	{
	    List<String> elemIds = new ArrayList<String>();
	    for(Map.Entry<String, Object> entry : criteria.getElemHm().entrySet())
	    {
		String entryKey = (String)entry.getKey();
		elemIds.add(entryKey);
		//get column name
		if("colName".equals(entryKey))
		{
		    String[] val = (String[])entry.getValue();
		    colName= val[0];
		}
		//get column description
		else if("colDesc".equals(entryKey))
		{
		    String[] val = (String[])entry.getValue();
		    colDesc= val[0];
		}
		//get column technical name
		else if("colTechName".equals(entryKey))
		{
		    String[] val = (String[])entry.getValue();
		    colTechName= val[0];
		}
		else if("elementId".equals(entryKey))
		{
		    String[] val = (String[])entry.getValue();
		    elementId = val[0]; 
		    String[] arr = val[0].split("_");
		    elemId= arr[0];

		}
		else if("colValue".equals(entryKey))
		{
		    String[] val = (String[])entry.getValue();
		    colValue= val[0];
		}
		//get Column Type
		else if("colType".equals(entryKey))
		{
		    String[] val = (String[])entry.getValue();
		    colType= val[0];
		}
	    }
	    if(colValue.isEmpty())
	    {
		colValue="NULL";
	    }
	    else {
		//check column type
		if(!colType.isEmpty())
		{

		    switch(colType) {
			case "1"://String

			    //Escape single quotes
			    if(colValue.indexOf("'")!=-1)
			    {
				colValue = colValue.replaceAll("'", "''");  
			    }
			    colValue= "'"+colValue+"'";
			    break;
			case "2"://Date

			    //Escape single quotes
			    if(colValue.indexOf("'")!=-1)
			    {
				colValue = colValue.replaceAll("'", "''");  
			    }
			    if(criteria.getIsOracle() == 1)
			    {
				colValue = "TO_DATE(TO_CHAR('" + colValue + "','dd/mm/yyyy'),'dd/mm/yyyy')";
			    }
			    else
			    {
				colValue = "CONVERT(DATE,CONVERT(VARCHAR,'" + colValue + "',103),103))";
			    }
			    break;
			case "3"://NUMERIC
			    if(!NumberUtil.isNumber(colValue))
			    {
				colValue="NULL";
			    }

			    break;
			case "4"://BOOLEAN
			    //Escape single quotes
			    if(colValue.indexOf("'")!=-1)
			    {
				colValue = colValue.replaceAll("'", "''");  
			    }
			    colValue= "'"+colValue+"'";
			    break;

			default:
			    colValue="NULL";
			    break;
		    }

		}
	    }
	    //get session values
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
	    //get query result
	    ArrayList<LinkedHashMap> result = null;
	    if(elemId!=null && colTechName!=null && colValue!=null )
	    {
		//escape single quote
		if(elemId.indexOf("'")!=-1)
		{
		    elemId = elemId.replaceAll("'", "''"); 
		}
		else if(colTechName.indexOf("'")!=-1)
		{
		    colTechName = colTechName.replaceAll("'", "''");
		}
		else if(StringUtil.isNotEmpty(colDesc)&& colDesc.indexOf("'")!=-1)
		{
		    colDesc = colDesc.replaceAll("'", "''");
		}
		dynCommonLookupSC.setElementId(new BigDecimal(elemId));
		dynCommonLookupSC.setColName(colTechName);
		dynCommonLookupSC.setColumnCode(colName);
		dynCommonLookupSC.setColValue(colValue);
		dynCommonLookupSC.setColDesc(colDesc);
		result = dynamicScreenBO.validateColPropLookupQuery(requiredFieldsSC,dynCommonLookupSC,criteria.getElemHm()) ;
	    }

	  //TP#1053821 Additional lookup description for colProp
	    if(result!=null && result.size()>0)
	    {
		HashMap<String, Object> lookUpRow = (HashMap<String, Object>) result.get(0);
		
		if(StringUtil.isNotEmpty(colDesc) )
		{
			Object descStr = lookUpRow.get(colDesc) == null? "":lookUpRow.get(colDesc) ;
			criteria.getElemHm().put("colDescValue", descStr);
			//set lookupDesc to readonly
			criteria.getElemHm().put("colDescReadOnly", "true");
		}
		if(criteria.getElemHm().get("addLkpDesc")!=null)
		{
		    String[] val = (String[]) criteria.getElemHm().get("addLkpDesc");
		    String addLkpDesc = val[0];
		    addLkpDesc = addLkpDesc.substring(0, addLkpDesc.length());
		    
		    if(StringUtil.isNotEmpty(addLkpDesc))
		    {
			String[] addlkpArr = addLkpDesc.split(";");
			for(int k=0;k<addlkpArr.length;k++) 
			{
			    String[] depElem = addlkpArr[k].split("~VALUE_");
			    colDesc =  depElem[1];
			    String elId =  depElem[0];
			    Object descStr = lookUpRow.get(colDesc) == null? lookUpRow.get(colDesc.toUpperCase()):lookUpRow.get(colDesc) ;
			    criteria.getElemHm().put(elId, descStr);
			}
		    }
		}
	    }
	    else 
	    {
		criteria.getElemHm().put("colDescValue", "");
		criteria.getElemHm().put("colValue", "");
		throw new BOException(MessageCodes.INVALID_ENTRY);
	    }
	    return SUCCESS;
	}

	catch(Exception e)
	{
	    // TODO Auto-generated catch block
	    handleException(e, null, null);
	    return SUCCESS;
	}
    }
   /**
    * @author marwanmaddah
    * @date   Jan 27, 2016
    * @return String
    * Used to manage all the dependencies that will be built dynamically inside the dynamic screen.
    */
   public String dynDependenciesProcess()
   {
       boolean cleanCriteria = false;
       String elemFormat = null;
       try{
	    SessionCO sessionCO  = returnSessionObject();
	    List<String> elemIds = new ArrayList<String>();
	    List<String> dependencyIds = new ArrayList<String>();
	    String queryDep = "", queryCond = "", currDep = "";
	    for(Map.Entry<String, Object> entry : criteria.getElemHm().entrySet())
	    {
		String entryKey = (String)entry.getKey();
		elemIds.add(entryKey);
		//Get the queryDep element ID and the query condition element value
		if("queryDep".equals(entryKey))
		{
		    String[] val = (String[])entry.getValue();
		    queryDep = val[0];
		}
		if("queryCond".equals(entryKey))
		{
		    String[] val = (String[])entry.getValue();
		    queryCond = ((String[]) criteria.getElemHm().get(val[0]))[0];
		    /**
		     * [MarwanMaddah].
		     * in case the main value is sent as empty, will clean the SC and return a SUCCESS 
		     * to clean all the elements that are related to the current dependency
		     */
		    if(StringUtil.nullToEmpty(queryCond).isEmpty())
		    {
			cleanCriteria = true;
		    }
		}
		if("currDep".equals(entryKey))
		{
		    String[] val = (String[])entry.getValue();
		    currDep = currDep.concat(val[0]);
		}
		if (entryKey.contains("dependency_"))
		{
		    String[] val = (String[])entry.getValue();
		    dependencyIds.add(val[0]);
		}
	    }
	    if(StringUtil.isNotEmpty(queryDep) && StringUtil.isNotEmpty(queryCond))
	    {
		//Get the CLOB from SYS_DYN_SCREEN_ELEMENTS_DET
		//Parse the JSON and compose the query with the additional condition of the column value
		//evaluate the composed query and return the result.
		//return Description of the field	    
		elemFormat = queryDependency(new BigDecimal(queryDep), queryCond);
		
		if(!StringUtil.nullToEmpty(elemFormat).isEmpty())
		{
		    criteria.setElemFormat(elemFormat);
		}
	    }
	    criteria.setElemIds(elemIds);
	    /**
	     * fill session variables for execute expressions.
	     */
	    HashMap<String, Object> hmSessionExp = new HashMap<String, Object>();
	    hmSessionExp.put(ConstantsCommon.USER_ID_EXP_VAR, sessionCO.getUserName());
	    hmSessionExp.put(ConstantsCommon.COMP_CODE_EXP_VAR, sessionCO.getCompanyCode());
	    hmSessionExp.put(ConstantsCommon.COMP_NAME_EXP_VAR, sessionCO.getCompanyName());
	    hmSessionExp.put(ConstantsCommon.BRANCH_CODE_EXP_VAR, sessionCO.getBranchCode());
	    hmSessionExp.put(ConstantsCommon.BRANCH_NAME_EXP_VAR, sessionCO.getBranchName());
	    hmSessionExp.put(ConstantsCommon.USER_FIRST_NAME_EXP_VAR, sessionCO.getUserFirstName());
	    hmSessionExp.put(ConstantsCommon.USER_LAST_NAME_EXP_VAR, sessionCO.getUserLastName());
	    hmSessionExp.put(ConstantsCommon.BASE_CURR_NAME_EXP_VAR, sessionCO.getBaseCurrencyName());
	    hmSessionExp.put(ConstantsCommon.RUNNING_DATE_VAR, sessionCO.getRunningDateRET());

	    if(sessionCO.getCtsTellerVO() != null && sessionCO.getCtsTellerVO().getCODE() != null)
	    {
		hmSessionExp.put(ConstantsCommon.IS_USER_TELLER_EXP_VAR, BigDecimal.ONE);
	    }

	    criteria.setHmSessionExpVals(hmSessionExp);
	    String lookupDesc = criteria.getLookupDesc();
	    Map<String,SYS_PARAM_SCREEN_DISPLAYVO> displayMap = dynamicScreenBO.returnDynScreenElemExpressions(criteria);
	    //check if the expression is related to a lookup then trigger change the affected lookup
	    if(StringUtil.isNotEmpty(currDep))
	    {
		for(Map.Entry<String, SYS_PARAM_SCREEN_DISPLAYVO> entry : displayMap.entrySet())
		{
		    String entryKey = entry.getKey();
		    // Get the queryDep element ID and the query condition
		    // element value
		    if(currDep.equals(entryKey))
		    {
			SYS_PARAM_SCREEN_DISPLAYVO val = (SYS_PARAM_SCREEN_DISPLAYVO) entry.getValue();
			val.setTriggerChange(ConstantsCommon.ONE);
		    }
		}
	    }
	    //Set lookup Description as readonly
	    if(StringUtil.isNotEmpty(lookupDesc))
	    {
		SYS_PARAM_SCREEN_DISPLAYVO displayvo=null;
		if(displayMap.containsKey(lookupDesc))
		{
		    displayvo = displayMap.get(lookupDesc);

		}
		else 
		{
		    displayvo = new SYS_PARAM_SCREEN_DISPLAYVO();
		    displayvo.setELEMENT_ID(lookupDesc);
		}
		displayvo.setIS_READONLY(BigDecimal.valueOf(1));
		displayMap.put(lookupDesc, displayvo);
	    }
	    resetByDependency(displayMap,dependencyIds);
	    getAdditionalScreenParams().putAll(displayMap);
	    if(cleanCriteria)
	    {
		criteria = new CommonLibSC();
	    }
       }
       catch(Exception ex)
       {
	   criteria = new CommonLibSC();
	   handleException(ex, null, null);
       }
       return SUCCESS;
   }
   
    /**
     * @author Rabih El Khatib
     * @date Aug 26, 2016
     * @return String Used to evaluate the query dependency based on columnCode
     *         value
     */
    public String queryDependency(BigDecimal queryID, String queryCond)
    {
	String elemFormat =null;
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    DynCommonLookupSC dynSC = new DynCommonLookupSC();
	    dynSC.setElementId(queryID);
	    dynSC.setPropertyCode("query");
	    DynamicScreenCO dynScrCO  = dynamicScreenBO.returnelemPropertyDetails(dynSC);
	    String queryData = dynScrCO.getPropertyExprValue();
	    JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(queryData);
	    Object[] modelArr = jsonModel.toArray();
	    JSONObject obj = (JSONObject) modelArr[0];
	    String columnCode = obj.getString("columnCode").trim();
	    String columnDesc = obj.getString("columnDesc").trim();
	    String querySynthax = obj.getString("querySynthax");
	    dynSC.setScreenId(criteria.getScreenId());
	    Map<String, DynamicScreenCO> hmElemDataType = dynamicScreenBO.returnParamsDataType(dynSC);
	    String findParamPattern = "#\\s*(\\w+)";
	    Pattern p = Pattern.compile(findParamPattern);
	    Matcher matcher = p.matcher(querySynthax);
	    DynamicScreenCO paramKeyDataType = null;
	    String elemType = "";
	    String dataMode = "";
	    while(matcher.find())
	    {
		String currParam = matcher.group();
		String paramKey = currParam.substring(1, currParam.length());

		if(criteria.getElemHm() != null && criteria.getElemHm().containsKey(paramKey)
			&& !StringUtil.nullToEmpty(criteria.getElemHm().get(paramKey)).isEmpty())
		{

		    Object paramVal = "";
		    /**
		     * in case the key exists inside expBoolTestData then get
		     * the paramKey value from session
		     */
		    if(ConstantsCommon.expBoolTestData.get(0).containsKey(paramKey))
		    {
			
			paramVal = (Object) sessionCO.getClass()
				.getMethod("get" + StringUtil.setFirstCharUpper(paramKey)).invoke(sessionCO);
		    }
		    else
		    {
		    	paramVal = ((String[]) criteria.getElemHm().get(paramKey))[0];
		    }
		    String repParamVal = "'" + paramVal + "'";
		    if(!hmElemDataType.isEmpty() && hmElemDataType.containsKey(paramKey))
		    {
			paramKeyDataType = hmElemDataType.get(paramKey);
			elemType = paramKeyDataType.getElementType();
			dataMode = paramKeyDataType.getElement_mode();
			switch (Integer.valueOf(elemType).intValue())
			{
			    case 1:
				if(String.valueOf(2).equals(dataMode))
				{
				    repParamVal = (String) paramVal;
				}
				break;
			    case 4:
				if(criteria.getIsOracle() == 1)
				{
				    repParamVal = "TO_DATE(TO_CHAR('" + paramVal + "','dd/mm/yyyy'),'dd/mm/yyyy')";
				}
				else
				{
				    repParamVal = "CONVERT(DATE,CONVERT(VARCHAR,'" + paramVal + "',103),103))";
				}
				break;
			    default:
				repParamVal = "'" + paramVal + "'";
				break;
			}
		    }

		    querySynthax = querySynthax.replaceAll(currParam, repParamVal);
		}
		else
		{
		    throw new BOException(MessageCodes.INVALID_MISSING, new String[] { "liveSearchParams_key" });
		}
	    }
	    
	    querySynthax = DynamicScreenCommonMethods.replaceLookupQueryParams(sessionCO, criteria.getElemHm(), querySynthax);
	    
	    List<Object> queryResult = null;
	    DynClientParamsSC dynClientParamsSC = new DynClientParamsSC();
	    dynClientParamsSC.setDynamicQuery(querySynthax);
	    dynClientParamsSC.setValueField(columnCode);
	    dynClientParamsSC.setLookupVal(queryCond);

	    queryResult = dynClientParamsBO.evaluateLookupExpression(dynClientParamsSC);

	    HashMap<String, Object> lookUpRow = new HashMap<String, Object>();

	    if(queryResult != null && queryResult.size() > 0)
	    {
		lookUpRow = (HashMap<String, Object>) queryResult.get(0);
		/**
		 * [MarwanMaddah]
		 * in case the query contains telephone format 
		 * will get it with the phone code to define the final phone format 
		 * and return it to be used as txtFormat inside the related elements that are linked to the livesearch
		 */
		if(lookUpRow.containsKey(TELEPHONE_FORMAT_COL))
		{
		    elemFormat = (String)lookUpRow.get(TELEPHONE_FORMAT_COL);
		}
		Object theCode = lookUpRow.get(columnCode) == null? lookUpRow.get(columnCode.toUpperCase()) : lookUpRow.get(columnCode);
		criteria.getElemHm().put(((String[]) criteria.getElemHm().get("queryCond"))[0], theCode.toString());
		if(criteria.getElemHm().get("queryDesc") != null)
		{
			Object descStr = lookUpRow.get(columnDesc) == null? lookUpRow.get(columnDesc.toUpperCase()):lookUpRow.get(columnDesc) ;
			String scrElmId = ((String[]) criteria.getElemHm().get("queryDesc"))[0];
			criteria.getElemHm().put(scrElmId, descStr);
			criteria.setLookupDesc(scrElmId);
		}
		//TP#1053820 Additional lookup description for livesearch
		
		if(criteria.getElemHm().get("addLkpDesc") != null )
		{
		    String[] val = (String[]) criteria.getElemHm().get("addLkpDesc");

		    String addLkpDesc = val[0];
		    if(StringUtil.isNotEmpty(addLkpDesc))
		    {
			SYS_PARAM_SCREEN_DISPLAYVO dispVO = new SYS_PARAM_SCREEN_DISPLAYVO();
			
			addLkpDesc = addLkpDesc.substring(0, addLkpDesc.length());
			String[] addlkpArr = addLkpDesc.split(";");
			for(int k=0;k<addlkpArr.length;k++) 
			{
			    String[] depElem = addlkpArr[k].split("~VALUE_");
			    columnDesc =  depElem[1];
			    String elmId =  depElem[0];
			    Object descStr = lookUpRow.get(columnDesc) == null? lookUpRow.get(columnDesc.toUpperCase()):lookUpRow.get(columnDesc);
			    criteria.getElemHm().put(elmId, descStr);
			}
		    }
		}
	    }
	    else
	    {
		if(criteria.getElemHm().get("queryCond") != null)
		{
		    criteria.getElemHm().put(((String[]) criteria.getElemHm().get("queryCond"))[0], "");
		}
		if(criteria.getElemHm().get("queryDesc") != null)
		{
		    criteria.getElemHm().put(((String[]) criteria.getElemHm().get("queryDesc"))[0], "");
		}
	    }
	}
	catch(Exception ex)
	{
	    criteria = new CommonLibSC();
	    handleException(ex, null, null);
	}
	return elemFormat;
    }
   
   /**
    * used to manage the dependency by screen id
    * @author marwanmaddah
    * @date   Feb 19, 2016
    * @return String
    *
    */
   public String dependencyByScreenId()
   {
       try{
	   SessionCO sessionCO = returnSessionObject();
	   if(!NumberUtil.isEmptyDecimal(criteria.getScreenId()))
	   {	       
	       sysDynScreenDefVO = dynamicScreenBO.returnScreenInfo(criteria);
	   }
       }
       catch(Exception ex)
       {
	   sysDynScreenDefVO = new SYS_DYN_SCREEN_DEFVO();
	   handleException(ex,null,null);
       }
       return SUCCESS;
   }
   
   
   /* SUPT190250 ,Vysakh,13/11/2019,BEGIN */
   public String dependencyForDynScreenElementsOrSessionLookup()
   {
	try
	{
	    // If source mapping is session variable
	    if(getDynParamType().compareTo(ConstantsCommon.SOURCE_MAPPING_SESSION_VARIABLE) == 0)
	    {
		dependencyBySessionElementMap();
	    }
	    else
	    {
		if(StringUtil.isNumeric(getDynScreenMappingId(), false))
		{
		    dynamicScreenCO.setElementIdValue(BigDecimal.valueOf(Integer.parseInt(getDynScreenMappingId())));
		    dependencyByScreenElementId();
		    setDynScreenMappingDesc(dynamicScreenCO.getElementId());
		}
		else
		{
		    setDynScreenMappingId(null);
		}
	    }
	}
	catch(Exception ex)
	{
	    setDynScreenMappingId(null);
	    handleException(ex, null, null);
	}

	return SUCCESS;
   }

   public String dependencyBySessionElementMap()
   {
	try
	{
	    if(StringUtil.isNotEmpty(getDynScreenMappingId()))
	    {
		String sessionFieldValue = getDynScreenMappingId();
		Class<?> sessionFieldType = PathPropertyUtil.returnPropertyType(returnSessionObject(),
			sessionFieldValue);

		if(sessionFieldType == null
			|| !ButtonCustomizationConstants.SESSIONCO_PROPERTIES.containsKey(sessionFieldValue))
		{
		    throw new BOException(MessageCodes.INVALID_VALUE);
		}
		
		Object sessionAttrObj = null;
		
		sessionAttrObj = PathPropertyUtil.returnProperty(returnSessionObject(),sessionFieldValue);
		
		if(sessionAttrObj instanceof String && getColumnType().compareTo(BigDecimal.valueOf(1)) != 0)
		{
		    throw new BOException(MessageCodes.INVALID_VALUE);
		}
		else if(sessionAttrObj instanceof Date && getColumnType().compareTo(BigDecimal.valueOf(2)) != 0)
		{
		    throw new BOException(MessageCodes.INVALID_VALUE);
		}
		else if(sessionAttrObj instanceof BigDecimal && getColumnType().compareTo(BigDecimal.valueOf(3)) != 0)
		{
		    throw new BOException(MessageCodes.INVALID_VALUE);
		}
		
		setDynScreenMappingDesc( ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(getDynScreenMappingId())
			.getDescription());
	    }
	}
	catch(Exception ex)
	{
	    setDynScreenMappingDesc(null);
	    setDynScreenMappingId(null);
	    handleException(ex, null, null);

	}

	return "jsonSuccess";
   }

   /* SUPT190250 ,Vysakh,13/11/2019,END */   
/**
    * this function is used to manage the dependency by screen element id
    * @date   Feb 19, 2016
    * @return String
    *
    */
   public String dependencyByScreenElementId()
   {
       try
       {
	   if(!NumberUtil.isEmptyDecimal(dynamicScreenCO.getScreenIdValue())
		   && !NumberUtil.isEmptyDecimal(dynamicScreenCO.getElementIdValue()))
	   {
	       SessionCO sessionCO = returnSessionObject();
	       DynCommonLookupSC criteria = new DynCommonLookupSC();
	       criteria.setElementId(dynamicScreenCO.getElementIdValue());
	       criteria.setScreenId(dynamicScreenCO.getScreenIdValue());
	       criteria.setLovTypeId(DynamicScreenConstant.LOV_ELEMENT_TYPE);
	       criteria.setPreferredLanguage(sessionCO.getLanguage());
	       dynamicScreenCO = dynamicScreenBO.dependencyByScreenElementId(criteria);
	   }
       }
       catch(Exception ex)
       {
	   dynamicScreenCO.setElementIdValue(null);
	   handleException(ex,null,null);
       }
       NumberUtil.resetEmptyValues(dynamicScreenCO);
       return SUCCESS;
   }
   
   public String textIdDependency()
   {
       try
    {
	if(criteria!=null && !NumberUtil.isEmptyDecimal(criteria.getScreenId()) && !StringUtil.nullToEmpty(criteria.getElementId()).isEmpty())
	{	    
	    dynamicScreenBO.updateLiveSearchDesc(criteria);
	}
    }
    catch(Exception e)
    {
	handleException(e,null,null);
    }
       return SUCCESS;
   }
   
   /**
    * this function is used to manage the dependency by screen element id
    * @param Map<String,SYS_PARAM_SCREEN_DISPLAYVO> displayMap
    * 		  List<String> dependencyIds
    * 
    */
   private void resetByDependency(Map<String,SYS_PARAM_SCREEN_DISPLAYVO> displayMap,List<String> dependencyIds) throws Exception 
   {
   	for (String elementID : dependencyIds) 
   	{
   		SessionCO sessionCO = returnSessionObject();
   		ScreenGeneratorSC screenGeneratorSC = new ScreenGeneratorSC();
   		screenGeneratorSC.setSessionCO(sessionCO);
   		screenGeneratorSC.setScreenId(criteria.getScreenId());	
   		screenGeneratorSC.setElementId(new BigDecimal(elementID));
   		screenGeneratorSC.setDisplayMap(displayMap);
   		for(Map.Entry<String, Object> entry : criteria.getElemHm().entrySet())
   	    {
   		String entryKey = (String)entry.getKey();
   		if(("propertyCode_"+screenGeneratorSC.getElementId()).equals(entryKey))
   		{
   		    String[] val = (String[])entry.getValue();
   		    screenGeneratorSC.setPropertyCode(val[0]);
   		}
   		if(("elemDependencyID_"+screenGeneratorSC.getElementId()).equals(entryKey))
   		{
   			String[] val = (String[])entry.getValue();
   			String[] valSub =val[0].split("~");
   		    screenGeneratorSC.setElementType(valSub[0]);
   		}
   		}
   	    DynCommonLookupSC dynSC = new DynCommonLookupSC();
   	    List<SelectCO> lst = new ArrayList<SelectCO>();
   	    dynSC.setElementId(screenGeneratorSC.getElementId());
   	    dynSC.setPropertyCode(screenGeneratorSC.getPropertyCode());
   	    dynSC.setPropertyCode(screenGeneratorSC.getElementType().equals(ConstantsCommon.ELEMENT_TYPE_COMBOBOX) ? ConstantsCommon.PROPERTY_CODE_OPTIONS : ConstantsCommon.PROPERTY_CODE_QUERY );
           DynamicScreenCO dynScrCO  = dynamicScreenBO.returnelemPropertyDetails(dynSC);
           if ( null != dynScrCO)
           {
   	        String optionsData  = dynScrCO.getPropertyExprValue();	
   		    screenGeneratorSC.setOptionsData(optionsData);	
   		    if ( StringUtil.isNotEmpty(optionsData) && !screenGeneratorSC.getElementType().equals(ConstantsCommon.ELEMENT_TYPE_GRID)) 
   		    {
   		    	lst = dynamicScreenBO.fillOptionsDataList(screenGeneratorSC);
   		    	
   		    }
           }
           getHmDepScrOptionsElems().put(screenGeneratorSC.getElementId() + "_lst", lst);
   	}
   }

   /**
    * this function is used on dependency of screen or session lookup 
    * @param 
    * 
    */
   public String dependencyForScreenElementsOrSessionLookup()
   {
   try
   {
       if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(dynamicScreenCO.getElement_mode()))
       {
	   switch(dynamicScreenCO.getElementType()) {
	       case "Numeric":
		  setColumnType(new BigDecimal(3));
	         break;
	       case "Varchar":
		   setColumnType(new BigDecimal(1));
	         break;
	       case "Date":
		   setColumnType(new BigDecimal(2));
	       break;
	       default:
		   setColumnType(new BigDecimal(0));
	     }
       	dependencyBySessionElementMap();
       }
       else if(ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(dynamicScreenCO.getElement_mode()))
       {
	    dynamicScreenCO.setElementIdValue((new BigDecimal(getDynScreenMappingId())));
       	dependencyByScreenElementId();
       	setDynScreenMappingDesc(dynamicScreenCO.getElementId());
       	dynamicScreenCO.setElement_mode(String.valueOf(dynamicScreenCO.getElementIdValue()));
       }
   }
   catch(Exception ex)
   {
       handleException(ex, null, null);
   }
   return SUCCESS;
   }
public BigDecimal getDynParamType()
{
	return dynParamType;
}

public void setDynParamType(BigDecimal dynParamType)
{
	this.dynParamType = dynParamType;
}

public String getDynScreenMappingId()
{
	return dynScreenMappingId;
}

public void setDynScreenMappingId(String dynScreenMappingId)
{
	this.dynScreenMappingId = dynScreenMappingId;
}

public String getDynScreenMappingDesc()
{
	return dynScreenMappingDesc;
}

public void setDynScreenMappingDesc(String dynScreenMappingDesc)
{
	this.dynScreenMappingDesc = dynScreenMappingDesc;
}

public BigDecimal getColumnType()
{
	return columnType;
}

public void setColumnType(BigDecimal columnType)
{
	this.columnType = columnType;
}
 
/**
 * @return the criteria
 */
public CommonLibSC getCriteria()
{
    return criteria;
}
/**
 * @param criteria the criteria to set
 */
public void setCriteria(CommonLibSC criteria)
{
    this.criteria = criteria;
}
/**
 * @param dynamicScreenBO the dynamicScreenBO to set
 */
public void setDynamicScreenBO(DynamicScreenBO dynamicScreenBO)
{
    this.dynamicScreenBO = dynamicScreenBO;
}
/**
 * @return the dynamicScreenCO
 */
public DynamicScreenCO getDynamicScreenCO()
{
    return dynamicScreenCO;
}
/**
 * @param dynamicScreenCO the dynamicScreenCO to set
 */
public void setDynamicScreenCO(DynamicScreenCO dynamicScreenCO)
{
    this.dynamicScreenCO = dynamicScreenCO;
}
/**
 * @return the sysDynScreenDefVO
 */
public SYS_DYN_SCREEN_DEFVO getSysDynScreenDefVO()
{
    return sysDynScreenDefVO;
}
/**
 * @param sysDynScreenDefVO the sysDynScreenDefVO to set
 */
public void setSysDynScreenDefVO(SYS_DYN_SCREEN_DEFVO sysDynScreenDefVO)
{
    this.sysDynScreenDefVO = sysDynScreenDefVO;
}
public void setDynClientParamsBO(DynClientParamsBO dynClientParamsBO)
{
    this.dynClientParamsBO = dynClientParamsBO;
}
public Map<String, Object> getHmDepScrOptionsElems()
{
    return hmDepScrOptionsElems;
}
public void setHmDepScrOptionsElems(Map<String, Object> hmDepScrOptionsElems)
{
    this.hmDepScrOptionsElems = hmDepScrOptionsElems;
}


}
