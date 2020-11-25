/**
 * 
 */
/**
 * 
 */
package com.path.actions.common.dynamicscreen;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionContext;
import com.path.actions.admin.dynamicparams.DynamicParamsAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.dynamicscreen.DynamicScreenBO;
import com.path.bo.common.screengenerator.GeneratorBO;
import com.path.dbmaps.vo.SYS_DYN_SCREEN_ELEMENTS_DETVO;
import com.path.dbmaps.vo.SYS_DYN_TABLE_DETVO;
import com.path.dbmaps.vo.SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ENTITY_TYPEVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.vo.admin.dynamicparams.DynamicParamsVO;
import com.path.vo.admin.dynamicparams.ListParamVO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.dynamicscreen.DynamicScreenConstant;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapSC;
import com.path.vo.common.dynlookup.DynCommonLookupSC;
import com.path.vo.common.screengenerator.DynGridOutParameterCO;
import com.path.vo.common.screengenerator.DynScrTableColsCO;
import com.path.vo.common.screengenerator.DynScreenQueryCO;
import com.path.vo.common.screengenerator.DynamicScreenCreatorCO;
import com.path.vo.common.screengenerator.DynamicScreenFileCO;
import com.path.vo.common.screengenerator.LinkedElementsCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * PreviewScreenDynAction.java used to
 */
public class DynamicScreenMainAction extends DynamicParamsAction
{
    private ArrayList<DynamicParamsVO> formLst  = new ArrayList<DynamicParamsVO>();
    private ScreenGeneratorSC          criteria = new ScreenGeneratorSC();
    private DynamicScreenParamsMapCO dynamicScreenParamsMapCO = new DynamicScreenParamsMapCO();
    private GeneratorBO generatorBO;
    private Map<String,List<SelectCO>> optionsDataMap = new HashMap<String,List<SelectCO>>();
    List<SelectCO> mapTypeList  = new ArrayList<SelectCO>();
    private DynamicScreenBO dynamicScreenBO;
    private Map<String,String> scrElemHm = new HashMap<String,String>();
    private Map<String,DynamicScreenFileCO> dynFileElemHm = new HashMap<String,DynamicScreenFileCO>();
    private Map<String,String> gridElemHm = new HashMap<String,String>();
    private Map<String,String> tempPropertiesHm = new HashMap<String,String>();
    //List of gridIds that will be reloaded when screen Parameter defined in query is modified
    private Map<String,ArrayList<String>> gridParamHm = new HashMap<String,ArrayList<String>>();
    //TP#1079614 map of displayParamVO as defined after expression execution
    private Map <String,SYS_PARAM_SCREEN_DISPLAYVO> displayhm = new HashMap<String,SYS_PARAM_SCREEN_DISPLAYVO>();
    private List<DynScrTableColsCO> colsLst = new ArrayList<DynScrTableColsCO>();
    List<SelectCO> dynParamMapList  = new ArrayList<SelectCO>();
  //TP#934567 Button Customization Dynamic Screen Action Assignment - Parameter from Grid on Source Screen
    List<SelectCO> selectionTypeList  = new ArrayList<SelectCO>();
    private String changeTrack;
    
    private String      fileName;
    private InputStream exportStream;
    private BigDecimal scrGridFlag;
    
    private List<DynamicScreenCreatorCO> dataLst = new ArrayList<DynamicScreenCreatorCO>();
    private String hasHiddenOpt;
    JSONObject rowData;
    String colNames;
    String screenFieldID;
    private String gridDetailsData;
    private BigDecimal screenId;
    
    //TP#1009625 Dynamic Screen Customized Required
    private List<String> screenEntityTypeInfosList = new ArrayList<String>();
    //TP#989676 Dynamic Screen Button to Save Child Screen opened from Parent with Parent Submit - Enhancement
    private String parentScreenParams;

    /**
     * [TP#1009625] Dynamic Screen Customized Required
     * @description return screen related entity type paramerters 
     * @createdBy Sajjad Soomro 
     * 
     * @return String
     * @throws BaseException
     */
    public String returnEntityTypeInfos() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	SYS_PARAM_SCREEN_ENTITY_TYPEVO sysParamScreenEntityType = new SYS_PARAM_SCREEN_ENTITY_TYPEVO();
	sysParamScreenEntityType.setAPP_NAME(sessionCO.getCurrentAppName());
	sysParamScreenEntityType.setPROG_REF(StringUtil.nullToEmpty(get_pageRef()).isEmpty()?ConstantsCommon.PROGREF_ROOT:get_pageRef());
	List<SYS_PARAM_SCREEN_ENTITY_TYPEVO> entityTypeInfosList = returnCommonLibBO().returnEntityTypeInfos(sysParamScreenEntityType);
	screenEntityTypeInfosList = new ArrayList<String>();
	for(int i=0;i<entityTypeInfosList.size();i++)
	{
	    screenEntityTypeInfosList.add(entityTypeInfosList.get(i).getENTITY_TYPE());
	}
	return SUCCESS;
    }
    
    /**
     * 
     * @author marwanmaddah
     * @date   Jan 6, 2016
     * @return String
     *
     */
	public String loadDynamicScreen() throws Exception
	{
		try 
		{
			// check if the grid is enabled - if enabled return grid 
			// else return form
			String returnGrid = fillDynamicGrid();
			if(returnGrid != null)
			{
			    //TP#1106431
			    criteria.setDynScrParamMap(dynamicScreenParamsMapCO.getDynamicScreenParamsMapData());
				return SUCCESS_DYNAMIC_GRID;				
			}
			
//			fillDynamicScreenForm();
			fillDynamicScreenForm_new();
			fillAdditionalScreenParams();
		} catch (Exception ex) 
		{
			handleException(ex, null, null);
			log.error(ex, "************: Error in load preview screen process");
			return "jsonError";
		}

		return SUCCESS_DYNAMIC_PARAM;
	}

	 /**
     * 
     * @author adelnasrallah
     * @date   Aug 2017
     * @return String 
     * This method is called after the grid jsp is loaded in order to load its corresponding form
     */
	 public String fillDynamicFormAfterGridLoad()
	 {
		try 
		{
//	 		fillDynamicScreenForm();
		        //TP#1106431
		        dynamicScreenParamsMapCO.setDynamicScreenParamsMapData(criteria.getDynScrParamMap());
		        fillDynamicScreenForm_new();
			fillAdditionalScreenParams(); 
		} 
		catch (Exception ex) 
		{
			handleException(ex, null, null);
			log.error(ex, "************: Error in fillDynamicFormAfterGrid");
		}

		return SUCCESS_DYNAMIC_PARAM;
	 }

	 /**
	     * 
	     * @author adelnasrallah
	     * @date   Aug 2017
	     * @return JSON 
	     * This method is used to load the grid jsp
	     */
    private String fillDynamicGrid()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    Map<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> dynScrParamMap = returnDynamicScrParamsMap();
	    if(!dynScrParamMap.isEmpty())
	    {
		for(Entry<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> entry : dynScrParamMap.entrySet())
		{
		    SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO sysParamVo = entry.getValue();
		    if(sysParamVo.getDYN_PARAM_TYPE().equals("2"))
		    {
			return null;
		    }
		}
	    }

	    List<DynamicScreenCreatorCO> dataLst = generatorBO.returnScreenElementsData(criteria);
	    
	    if(dataLst != null && NumberUtil.nullToZero(dataLst.get(0).getScrGridFlag()).intValue() == 1)
	    {
		criteria.setScrGridFlag(BigDecimal.ONE);
		criteria.setLovTypeId(ConstantsCommon.DATA_TYPE_LOV_TYPE);
		criteria.setLangCode(sessionCO.getLanguage());
		criteria.setTableId(dataLst.get(0).getScrTableId());
		criteria.setIsOracle(ConstantsCommon.CURR_DBMS_ORACLE);
		setColsLst(generatorBO.returnDynTableCols(criteria));

		for(int i = 0; i < colsLst.size(); i++)
		{
		    if(colsLst.get(i).getCOL_TYPE().equals("1"))
		    {
			colsLst.get(i).setCOL_TYPE_DESC("text");
		    }
		    else if(colsLst.get(i).getCOL_TYPE().equals("3"))
		    {
			colsLst.get(i).setCOL_TYPE_DESC("number");
		    }
		    else if(colsLst.get(i).getCOL_TYPE().equals("2") || colsLst.get(i).getCOL_TYPE().equals("5"))
		    {
			colsLst.get(i).setCOL_TYPE_DESC("date");
		    }
		    else if(colsLst.get(i).getCOL_TYPE().equals("4"))
		    {
			colsLst.get(i).setCOL_TYPE_DESC("checkbox");
		    }

		    if(colsLst.get(i).getVISIBLE_YN().intValue() == 1)
		    {
			colsLst.get(i).setHIDDEN("false");
		    }
		    else
		    {
			colsLst.get(i).setHIDDEN("true");
		    }

		    CommonLibSC sc = new CommonLibSC();
		    sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
		    sc.setProgRef(ConstantsCommon.PROGREF_ROOT);
		    sc.setKeyLabelCode(colsLst.get(i).getCOL_DESC());
		    sc.setLanguage(returnSessionObject().getLanguage());
		    String transMessage = returnCommonLibBO().returnKeyLabelTrans(sc);
		    colsLst.get(i).setCOL_DESC(transMessage);
		}
		DynScrTableColsCO tableColsCO = new DynScrTableColsCO();
		tableColsCO.setCOL_TECH_NAME("PRIMARY_COL");
		tableColsCO.setCOL_DESC("PRIMARY_COL");
		tableColsCO.setCOL_TYPE_DESC("text");
		tableColsCO.setCOL_TYPE(ConstantsCommon.ONE);
		tableColsCO.setHIDDEN(ConstantsCommon.TRUE);
		colsLst.add(tableColsCO);

		set_searchGridId("dynamicScreen_" + criteria.getScreenId() + "_Grid");
		set_showSmartInfoBtn("false");
		return SUCCESS_DYNAMIC_GRID;
	    }

	}
	catch(Exception ex)
	{
	    ex.printStackTrace();
	    handleException(ex, null, null);
	}
	return null;
    }
    /**
     * 
     * @throws Exception
     */
    private void fillDynamicScreenForm_new() throws Exception 
    {
	try 
	{
	    SessionCO sessionCO = returnSessionObject();
	    DynamicParamsVO paramVO = null;
	    String onLoadScript = null;
	    boolean dateProp = false, timeProp = false, hijriProp = false, dateDefaultVal = false, submitWithParent = false;
	    criteria.setLangCode(sessionCO.getLanguage());
	    criteria.setLovTypeId(ConstantsCommon.ELEMENT_PROPERTY_LOV_TYPE);
	    /**
	     * global Variables per screen
	     */
	    String formId = StringUtil.isNotEmpty(get_pageRef()) ? "dynScreen_"+ criteria.getScreenId() + "_FormId" + "_" + get_pageRef(): "dynScreen_" + criteria.getScreenId() + "_FormId";
	    String _addPageRef = StringUtil.nullToEmpty(get_pageRef()).isEmpty() ? "" : "_" + get_pageRef();
	    String findParamPattern = "#\\s*(\\w+)";
	    JSONArray jsonModel;
	    Object[] modelArr;
	    JSONObject obj;
	    BigDecimal elemExprResult = BigDecimal.ZERO;
	    StringBuffer paramList = null;
	    StringBuffer resultList = null;
	    StringBuffer dependencyList = null;
	    StringBuffer dependencyParamList = null;
	    StringBuffer cssStyle = null;

	    BigDecimal elementId = null;
	    String currId = "";
	    String currName = "";
	    String _theElemId = "";
	    String elementType = "";
	    String currElemMode = "";
	    String columnCode;
	    String columnDesc;
	    String sourceType;
	    String querySynthax;

	    String pxStr = "px";
	    String topPos = null;
	    String leftPos = null;
	    String widthProp = null;
	    String heightProp = null;
            int maxBottomValue = 0;
            int heightValue = 0;
	    List<SYS_DYN_SCREEN_ELEMENTS_DETVO> elemProperties = null;
	    //TP#1070377 add map for dependency management
	    Map<String, List<LinkedElementsCO>> dependencyHm = new HashMap<String, List<LinkedElementsCO>>();
	    //TP#1070377 add dependency for comboBox
	    Map<String, List<LinkedElementsCO>> optionDependencyHm = new HashMap<String, List<LinkedElementsCO>>();
	    List<String> prodIds = new ArrayList<String>();
	    Map<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> dynScrParamMap = returnDynamicScrParamsMap();
		  /// US 853476 Muhammad.Asif for dependency 
	    List<SYS_DYN_SCREEN_ELEMENTS_DETVO> linkedElementsForDependecy = new ArrayList<SYS_DYN_SCREEN_ELEMENTS_DETVO>();	    
	    LinkedHashMap<String, Object> tableRowMap = new LinkedHashMap<String, Object>();
	    Map<String, Object> screenElementsMap = new HashMap<String, Object>();//Tp1010834 contains screen elements values on load based on pk
	    HashMap<BigDecimal, String> pkElements = new HashMap<BigDecimal, String>();
	    StringBuffer gridUpdateIds = new StringBuffer();
	    // TP 1021997
	    List<DynamicParamsVO> hiddenElemList = new ArrayList<DynamicParamsVO>();
	    
	    // only used when on dbl click event from grid or if opening screen through PK
	    //  retrieve row information after double click from dynamic grid or by PK from button or screen
	    if(!dynScrParamMap.isEmpty())
	    {
		for(Entry<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> entry : dynScrParamMap.entrySet())
		{
		    SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO sysParamVo = entry.getValue();
		    if(sysParamVo.getDYN_PARAM_TYPE().equals("2"))
		    {
			pkElements.put(sysParamVo.getTO_ELEMENT_ID(),sysParamVo.getMAP_VALUE());
			criteria.setModeType(ConstantsCommon.ON_LOAD_MODE);
		    }
		}
	    }

	    if(ConstantsCommon.ON_LOAD_MODE.equals(criteria.getModeType()))
	    {
		criteria.setLovTypeId(ConstantsCommon.DATA_TYPE_LOV_TYPE);
		criteria.setLangCode(sessionCO.getLanguage());
		List<DynamicScreenCreatorCO> dynScrCreatorList = dynamicScreenBO.retrieveDynTableScreenColsInfo(criteria);
		List<String> queryColList = new ArrayList<String>();
		SYS_DYN_TABLE_DETVO sysDynTableDetVO = new SYS_DYN_TABLE_DETVO();
		String colTechName;
		String ColTechValue;
		boolean isCompletePk = true;
		// if there are parameters sent from another screen or from button customization, 
		//check if the parameters are linked to primary key in order to retrieve its record from db
		//set isCompletePk to false if not matching 
		// to do: only retreive primary keys for performance (retrieveDynTableScreenColsInfo)
		if(!dynScrParamMap.isEmpty())
		{
		    for(int i = 0; i < dynScrCreatorList.size(); i++)
		    {
			DynamicScreenCreatorCO dynCO = dynScrCreatorList.get(i);
			sysDynTableDetVO = dynCO.getSysDynTableDetVO();
			colTechName = sysDynTableDetVO.getCOL_TECH_NAME();
			if(sysDynTableDetVO.getPRIMARY_KEY().equals(BigDecimal.ONE) && pkElements.containsKey(dynCO.getElementId()))
			{
			    if(pkElements.get(dynCO.getElementId()).isEmpty()){
				isCompletePk = false;
			    }
			    scrElemHm.put(dynCO.getProperty_value(), pkElements.get(dynCO.getElementId()));
			}
			else if(sysDynTableDetVO.getPRIMARY_KEY().equals(BigDecimal.ONE) && !pkElements.containsKey(dynCO.getElementId()))
			{
			    isCompletePk = false;
			    break;
			}
		    }
		}

		// retrieve record from db
		if(!isCompletePk == false)
		{
		    String inputString;
		    BigDecimal columnType;
		    String columnName;

		    Map<String, Object> pkColValHm = new HashMap<String, Object>();
		    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date dateFormatted = null;
		    SimpleDateFormat desiredFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		    for(int i = 0; i < dynScrCreatorList.size(); i++)
		    {
			sysDynTableDetVO = dynScrCreatorList.get(i).getSysDynTableDetVO();
			colTechName = sysDynTableDetVO.getCOL_TECH_NAME();
			// do not retrieve the type 6 which is blob
			if(sysDynTableDetVO.getCOL_TYPE().intValue() != 6)
			{
			    queryColList.add(colTechName);
			}
			if(scrElemHm.containsKey(colTechName) && sysDynTableDetVO.getPRIMARY_KEY().intValue() == 1)
			{
			    inputString = (String) scrElemHm.get(sysDynTableDetVO.getCOL_TECH_NAME());

			    columnType = sysDynTableDetVO.getCOL_TYPE();
			    columnName = sysDynTableDetVO.getCOL_TECH_NAME();
			    // format input string based on column type
			    if(columnType.intValue() == 2 || columnType.intValue() == 5)
			    {
				if(inputString.matches("^[a-zA-Z_;'\"]+$"))
				{
				    throw new BaseException("Value: " + inputString + "' is not a Date");
				}

				boolean correctFormat = true;
				try
				{
				    simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
				    dateFormatted = simpleDateFormat.parse(inputString);
				}
				catch(ParseException e)
				{
				    correctFormat = false;
				}

				if(!correctFormat)
				{
				    try
				    {
					desiredFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
					dateFormatted = desiredFormat.parse(inputString);
					correctFormat = true;
				    }
				    catch(ParseException e)
				    {
					correctFormat = false;
				    }
				}

				if(!correctFormat)
				{
				    try
				    {
					desiredFormat = new SimpleDateFormat("dd/MM/yyyy");
					dateFormatted = desiredFormat.parse(inputString);
					correctFormat = true;
				    }
				    catch(ParseException e)
				    {
					correctFormat = false;
				    }
				}
				pkColValHm.put(columnName, dateFormatted);
			    }
			    else if(columnType.intValue() == 3 || columnType.intValue() == 4)
			    {
				if(inputString!=null && !NumberUtil.isNumber(inputString))
				{
        			   inputString = returnDynamicParamValue(dynScrParamMap,inputString);
        			   if(inputString!=null && !NumberUtil.isNumber(inputString))
        			   {
        			      throw new BaseException("Value " + inputString + "' is not Number");
        			   }
				}
				inputString = StringUtil.nullToEmpty(inputString).isEmpty() ? null : inputString;
				BigDecimal inputBigdecimal = new BigDecimal(inputString);
				pkColValHm.put(columnName, inputBigdecimal);
			    }
			    else
			    {
				pkColValHm.put(columnName, inputString);
			    }
			}

		    }

		    queryColList.add("DATE_UPDATED");

		    List<LinkedHashMap> dynGridList = null;
		    if(!dynScrCreatorList.isEmpty()){
			String queryData = "SELECT " + StringUtil.returnStringFromArray(queryColList, ",") + " FROM "
				+ dynScrCreatorList.get(0).getScrTableTechName() + " WHERE ";
			criteria.setQueryData(queryData);
			criteria.setRecToskip(0);
			criteria.setNbRec(1);
			criteria.setPkColValHm(pkColValHm);
			// ** return the collection of records
			dynGridList = dynamicScreenBO.returnDynGridListRecords(criteria);
		    }

		    if(dynGridList != null && !dynGridList.isEmpty())
		    {
			tableRowMap = dynGridList.get(0);
		    }
		    else if((dynGridList == null || dynGridList.isEmpty()) && !dynScrParamMap.isEmpty())
		    {
			criteria.setModeType(""); // set mode type to different than load in order to set the scrElemHm.hidden_cu to create
		    }
		}
		else
		{
		    criteria.setModeType("");
		}
	    }


	    /**
	     * retrieve screen elements data from DB
	     */
            if(dataLst==null || dataLst.size() == 0)
            {            	
            	dataLst = generatorBO.returnScreenElemDataRun(criteria);
            }
            
            //sort List in order of parent-child hierarchy
            List<DynamicScreenCreatorCO> parentChildList = new ArrayList<DynamicScreenCreatorCO>();
            dataLst.forEach(parentCO -> { 
        	if(parentCO.getParentTechId() == null)
            	{
        	    parentChildList.add(parentCO);
            	}
        	/**
        	 * add child elements next to its parent element in the list.
        	 * indexOf is used if the child element further has its child elements 
        	 * then add child elements next to its parent element index location
        	 */
        	parentChildList.addAll(parentChildList.indexOf(parentCO)+1, dataLst.stream()
        		.filter(childCO -> childCO.getParentTechId() != null && childCO.getParentTechId().equals(parentCO.getTechId()))
        		.collect(Collectors.toList()));
            });
            dataLst = parentChildList;

            Map<String,BigDecimal> elementsTypeMap = new HashMap<String,BigDecimal>();
            Map<String,DynamicScreenCO> elmExprModeMap  = new HashMap<String,DynamicScreenCO>();
            for (int i=0;i<dataLst.size();i++)
            {
        	if(i==0)
        	{
        	    scrGridFlag = NumberUtil.nullToZero(dataLst.get(0).getScrTableId());
        	}
            	DynamicScreenCreatorCO dynScreenCreatorCO = dataLst.get(i);
            	//TP#1070377 loop over element Properties
            	elemProperties = dynScreenCreatorCO.getElemDets();
            	for (int j = 0; j < elemProperties.size(); j++) 
            	{
            	    SYS_DYN_SCREEN_ELEMENTS_DETVO elementDet = elemProperties.get(j);
            	    
            	    //Fill linksElement for Dependency
            	    LinkedElementsCO linkedElem = new LinkedElementsCO();

            	    String expression = StringUtil.nullToEmpty(elementDet.getPROPERTY_EXPRESSION_VALUE());
            	    String propertyCode =  StringUtil.nullToEmpty(elementDet.getPROPERTY_CODE());
            	    if(StringUtil.isNotEmpty(expression))
            	    {
            		//Property Expressions
            		if( ConstantsCommon.PROPERTY_CODE_READONLY.equals(propertyCode)
            			|| ConstantsCommon.PROPERTY_CODE_REQUIRED.equals(propertyCode)
            			|| ConstantsCommon.PROPERTY_CODE_VISIBLE.equals(propertyCode) 
            			|| ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode))
            		{
            		    for(DynamicScreenCreatorCO dynScrCO: dataLst)
            		    {

            			if(expression.contains(dynScrCO.getTheId()))
            			{
            			    linkedElem.setId(dynScreenCreatorCO.getTheId());
            			    linkedElem.setName(dynScreenCreatorCO.getPropName());
            			    linkedElem.setExpression(elementDet.getPROPERTY_EXPRESSION_VALUE());
            			    if(!dependencyHm.containsKey(dynScrCO.getTheId()))
            			    {
            			    	dependencyHm.put(dynScrCO.getTheId(), new ArrayList< LinkedElementsCO>());
            			    }
            			    dependencyHm.get(dynScrCO.getTheId()).add(linkedElem);
            			}
            		    }
            		}
            		//Option Property
            		else if (ConstantsCommon.PROPERTY_CODE_OPTIONS.equals(propertyCode))
            		{ 
            		    // fill optionDependencyHm 
        		JSONArray jsonElemModel = (JSONArray) JSONSerializer.toJSON(expression);
        		Object[] onElemArr = jsonElemModel.toArray();
        		JSONObject elemObj = (JSONObject) onElemArr[0];
        		String querySyntax = elemObj.has("querySynthax") ? (String) elemObj.get("querySynthax") : ""  ;
        		if ( StringUtil.isEmptyString(querySyntax) && elemObj.has("parameterGridData")) //case of Global Activity
        		{
        		    JSONArray  jsonParamArr = elemObj.getJSONArray("parameterGridData");
        		    if (jsonParamArr != null) 
        		    {
        			for (Object jObject : jsonParamArr)
        			{            	
        			    JSONObject jsonObject = (JSONObject) jObject;
        			    String paramType = jsonObject.getString("sysParamGlobalActArgMapVO.MAP_TYPE");
        			    String screenParamName = StringUtil.nullToEmpty(jsonObject.getString("mapDescription"));
        			    
        			    if (ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(paramType) && !screenParamName.isEmpty() )
        			    {
        				linkedElem.setId(dynScreenCreatorCO.getTheId());
        				linkedElem.setElemId(dynScreenCreatorCO.getElementId());
                			linkedElem.setName(dynScreenCreatorCO.getPropName());
                			linkedElem.setExpression(elementDet.getPROPERTY_EXPRESSION_VALUE());
                			linkedElem.setPropertyCode(elementDet.getPROPERTY_CODE());
                			linkedElem.setElementType(dynScreenCreatorCO.getElementType());
        				if(!optionDependencyHm.containsKey(screenParamName))
        				{
        				    optionDependencyHm.put(screenParamName,new ArrayList<LinkedElementsCO>());
        				}
        				
        				    optionDependencyHm.get(screenParamName).add(linkedElem);
        			    }
        				
        			}
        		    }
        		}
        		else //case of query
        		{
        		    Pattern paramPattern = Pattern.compile("(.*?)(\\[screen.(\\S*)\\])(.*?)");
        		    Matcher paramMatcher = paramPattern.matcher(querySyntax);   
        		    while(paramMatcher.find())
        		    {
        			if( (paramMatcher.group(2) != null) && StringUtil.isNotEmpty(paramMatcher.group(3)))
        			{
        			    String screenParamName = paramMatcher.group(3);
        			    linkedElem.setId(dynScreenCreatorCO.getTheId());
        			    linkedElem.setElemId(dynScreenCreatorCO.getElementId());
            			    linkedElem.setName(dynScreenCreatorCO.getPropName());
            			    linkedElem.setExpression(elementDet.getPROPERTY_EXPRESSION_VALUE());
            			    linkedElem.setPropertyCode(elementDet.getPROPERTY_CODE());
            			    linkedElem.setElementType(dynScreenCreatorCO.getElementType());
        			    if(!optionDependencyHm.containsKey(screenParamName))
    				{
    				    optionDependencyHm.put(screenParamName,new ArrayList<LinkedElementsCO>());
    				}
    				
    				    optionDependencyHm.get(screenParamName).add(linkedElem);
        			}
        		    }
        		}
            	    }

            	}
            	}         	
            	
        	
            	
            	DynamicScreenCO dynScreenCO = new DynamicScreenCO();
            	dynScreenCO.setElementIdValue(dynScreenCreatorCO.getElementId());
            	dynScreenCO.setTheId(dynScreenCreatorCO.getTheId());
            	
            	elementsTypeMap.put(dynScreenCreatorCO.getTheId(),dataLst.get(i).getElementType());

            	if(StringUtil.nullToEmpty(dynScreenCreatorCO.getElementMode()).isEmpty())
            	{
            		/**
            		 * in case the element is a date picker will set the mode as 3 inside the map 
            		 * to use it on expression execution 
            		 */
            		if(BigDecimal.valueOf(4).equals(dynScreenCreatorCO.getElementType()))
            		{
            			dynScreenCO.setElement_mode(String.valueOf(3));
            			elmExprModeMap.put(dynScreenCreatorCO.getTheId(),dynScreenCO);
            		}
            		else
            		{
            			dynScreenCO.setElement_mode(String.valueOf(1));
            			elmExprModeMap.put(dynScreenCreatorCO.getTheId(),dynScreenCO);
            		}
            	}
            	else
            	{
            		dynScreenCO.setElement_mode(dynScreenCreatorCO.getElementMode());
            		elmExprModeMap.put(dynScreenCreatorCO.getTheId(),dynScreenCO);
            	}
            	/**
        	 * In case of primary key mapping get mapped values before expression execution
        	 */
            	
        	if(tableRowMap != null && !tableRowMap.isEmpty()) 
        	{
        	   if(tableRowMap.containsKey(dynScreenCreatorCO.getPropName()))
        	   {
        	       SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO elm = new  SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO();
        	       String theValue ;
        	       Object thePropValue = tableRowMap.get(dynScreenCreatorCO.getPropName());
        	       if(thePropValue!= null && thePropValue instanceof Date)
		       {
			   theValue = DateUtil.format((Date)thePropValue,"dd/MM/yyyy HH:mm:ss");
		       }
		       else
		       if(thePropValue!= null && thePropValue instanceof BigDecimal)
		       {
			   theValue = ((BigDecimal)thePropValue).toPlainString();
		       }
		       else
		       {
			   theValue = StringUtil.nullToEmpty(thePropValue);
		       }
		       elm.setMAP_VALUE(StringUtil.nullToEmpty(theValue));
        	       if(dynScreenCreatorCO.getElementType()!=null) {
        	       elm.setMAP_TYPE(dynScreenCreatorCO.getElementType().toString());}
        	       dynScrParamMap.put(dynScreenCreatorCO.getElementId(),elm );//contains all screen elements that are mapped to dynamicTable by TechId 123
        	       screenElementsMap.put(dynScreenCreatorCO.getTheId(), elm);//contains all screen elements that are mapped to dynamicTable by propertyId Key
        	   }
        	}
            }
            //TP1010864 set screenElemtmap
            criteria.setColValHm(screenElementsMap);
            /**
             * TP#989676 Dynamic Screen Button to Save Child Screen opened from Parent with Parent Submit - Enhancement
             * if screen is child screen and opened form parent screen then fill map with form old values 
             */
            Map<String, String> childScreenElemHm = new HashMap<String, String>();
            if(criteria.getSourceData() != null)
            {
        	JSONObject screenJsonObj = (JSONObject) JSONSerializer.toJSON(criteria.getSourceData());
        	if(screenJsonObj.containsKey("scrElemHm"))
        	{
        	    childScreenElemHm = (HashMap<String, String>) JSONObject.toBean(screenJsonObj.getJSONObject("scrElemHm"), HashMap.class);
        	}
            }
            
            for (int i=0;i<dataLst.size();i++) 
            {
        	/**
        	 * reset variables on each loop
        	 */
        	paramVO = new DynamicParamsVO();
        	paramList = new StringBuffer();
        	resultList = new StringBuffer();
        	dependencyList = new StringBuffer();
        	dependencyParamList = new StringBuffer();
        	cssStyle = new StringBuffer();

        	dateProp = false;
        	timeProp = false;
        	hijriProp = false;
        	dateDefaultVal = false;
        	_theElemId = "";
        	elemProperties = new ArrayList<SYS_DYN_SCREEN_ELEMENTS_DETVO>();
        	elemExprResult = BigDecimal.ZERO;
        	/**
        	 * 
        	 */
        	DynamicScreenCreatorCO dynScreenCreatorCO = (DynamicScreenCreatorCO)dataLst.get(i);

        	elementId    = dynScreenCreatorCO.getElementId();
        	currId       = dynScreenCreatorCO.getTheId();
        	currName     = dynScreenCreatorCO.getPropName();
        	currElemMode = dynScreenCreatorCO.getCurrElemMode();
        	int elementTypeId = dynScreenCreatorCO.getElementType().intValue();
        	elementType = ConstantsCommon.ELEMENT_LAYOUT_TYPE_MAP.get(Integer.valueOf(elementTypeId));
        	topPos      = dynScreenCreatorCO.getTopPos();
        	leftPos     = dynScreenCreatorCO.getLeftPos();
        	widthProp   = dynScreenCreatorCO.getWidthProp();
        	heightProp  = dynScreenCreatorCO.getHeightProp();
        	//used to define display of element after expression execution
        	SYS_PARAM_SCREEN_DISPLAYVO displayVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        	elemProperties = dynScreenCreatorCO.getElemDets();
        	defineDynamicParamValue(dynScrParamMap, paramVO, elementId);

        	paramVO.setElement_type(elementType);

        	paramVO.setId((StringUtil.nullToEmpty(currId).isEmpty() ? ""
        		+ elementId : currId).concat(_addPageRef));
        	paramVO.setRow(0);
        	paramVO.setColumn(0);
        	paramVO.setPositionAbsolute(true);
        	if (!StringUtil.nullToEmpty(currId).isEmpty()) 
        	{
        	    prodIds.add(currId);
        	}
        	if (dynScreenCreatorCO.getTechId() != null) 
        	{
        	    paramVO.setTechId(dynScreenCreatorCO.getTechId());
        	}
        	int topValue = (new BigDecimal(topPos)).intValue();
        	if (dynScreenCreatorCO.getParentTechId() != null) 
        	{
        	    paramVO.setParentTechId(dynScreenCreatorCO.getParentTechId());
        	    topValue = topValue + 20;
        	}
        	if(StringUtil.nullToEmpty(heightProp).isEmpty())
        	{
        	    if(ConstantsCommon.LAYOUT_TYPE_GRID.equals(StringUtil.nullToEmpty(paramVO.getElement_type())))
        	    {
        		heightValue=160;//grid default height in case not resized
        	    }
        	    else
        	    {
        		heightValue=20;
        	    }
        	}
        	else //retrieve height
        	{
        	    heightValue = (new BigDecimal(heightProp)).intValue();
        	}
        	int newMaxBottomValue = topValue + heightValue;
        	if(maxBottomValue<newMaxBottomValue)//used to add space between last element and end of the screen as hidden div
        	{
        	    maxBottomValue = newMaxBottomValue;   
        	}
        	if (!StringUtil.nullToEmpty(currElemMode).isEmpty() && 2 == Integer.valueOf(currElemMode).intValue()) 
        	{
        	    paramVO.setMode(MODE_NUMBER);
        	}
        	/**
        	 * name management
        	 */
        	if(ConstantsCommon.LAYOUT_TYPE_GRID.equals(elementType) && StringUtil.nullToEmpty(currName).isEmpty())
        	{
        	    paramVO.setName("");
        	}
        	else if(ConstantsCommon.LAYOUT_TYPE_TEXTFIELD.equals(elementType) && StringUtil.nullToEmpty(currName).isEmpty())
        	{
        	    paramVO.setName("scrElemHm.".concat("dynElem_").concat((StringUtil.nullToEmpty(currId).isEmpty()?""+elementId:currId)));
        	}
        	else if (StringUtil.nullToEmpty(currName).isEmpty()) 
        	{
//        	    paramVO.setName("dynElem_".concat(paramVO.getId()));
        	    paramVO.setName("dynElem_".concat((StringUtil.nullToEmpty(currId).isEmpty()?""+elementId:currId)));
        	    /**
        	     * TP#989676 Dynamic Screen Button to Save Child Screen opened from Parent with Parent Submit - Enhancement
        	     * In case of child screen and File element not linked to Dynamic Table
        	     */
        	    if(ConstantsCommon.LAYOUT_TYPE_FILE.equals(paramVO.getElement_type()) && getParentScreenParams() != null)
        	    {
        		paramVO.setName("dynFileElemHm.".concat(paramVO.getName())+".uploadFile");
        	    }
        	}
        	else if(ConstantsCommon.LAYOUT_TYPE_FILE.equals(paramVO.getElement_type()))
        	{
			    //name is dynamicFileCO + uploadFile < variable inside dynamicFileCO
			    paramVO.setName("dynFileElemHm.".concat(currName)+".uploadFile");
			    
			    // TP #864592 : Hide download Button in case screen not linked to DB
			    // TP 1085880 - Hide download button in case the record is new
			    if(NumberUtil.isEmptyDecimal(dynScreenCreatorCO.getScrTableId()) || !ConstantsCommon.ON_LOAD_MODE.equals(criteria.getModeType()))
			    {
			    	paramVO.setRenderFileDownloadBtn("false");
			    }
			    else
			    {
			    	paramVO.setRenderFileDownloadBtn("true");
			    }
			}
        	else if(scrGridFlag.compareTo(BigDecimal.ZERO)>0)
        	{
        	    paramVO.setName("scrElemHm.".concat(currName));
        	}
        	else
        	{
        	    paramVO.setName(currName); 
        	}
	
        	_theElemId = currId + _addPageRef;
        	/**
        	 * [MarwanMaddah] css style management
        	 */
        	cssStyle.append("width:").append(widthProp).append(pxStr).append(";");
        	cssStyle.append(" ").append("height:").append(heightProp).append(pxStr).append(";");
        	cssStyle.append(" ").append("top:").append(String.valueOf(topValue)).append(pxStr).append(";");
        	String algnAtt = "left";
        	/**
        	 * alignment management, based on the session Direction value
        	 */
        	if (sessionCO.getIsRTLDir() == 1) 
        	{
        	    algnAtt = "right";
        	    
        	    if (ConstantsCommon.LAYOUT_TYPE_LABEL.equals(elementType)) 
            	{
        	    	cssStyle.append(" ").append("text-align").append(":").append(algnAtt).append(";");
            	}
        	}
        	/**
        	 * 
        	 */
        	cssStyle.append(" ").append(algnAtt).append(":").append(leftPos).append(pxStr).append(";");

        	if (!ConstantsCommon.LAYOUT_TYPE_DATEPICKER.equals(elementType)&& !ConstantsCommon.LAYOUT_TYPE_FILE.equals(elementType)) 
        	{
        	    cssStyle.append("position:absolute;");
        	}
        	
        	
        	paramVO.setHeight(heightProp);
        	/**
i         	 * will enter one time to fill the onLoad Script per screen 
        	 */
        	if (!StringUtil.nullToEmpty(dynScreenCreatorCO.getOnLoadScript()).isEmpty() && StringUtil.nullToEmpty(onLoadScript).isEmpty()) 
        	{
        	    JSONArray jsonOnLoadModel = (JSONArray) JSONSerializer.toJSON(dynScreenCreatorCO.getOnLoadScript());
        	    Object[] onLoadScriptArr = jsonOnLoadModel.toArray();
        	    JSONObject onLoadObj = (JSONObject) onLoadScriptArr[0];
        	    onLoadScript = (String) onLoadObj.get("loadScriptData");
    		    onLoadScript = onLoadScript.replaceAll("\\[formId\\]", "'" +formId+"'").replaceAll("\\[screenId\\]", criteria.getScreenId().toString());
        	    //					paramVO.setOnLoadScript(onLoadScript);
        	}

        	/**
        	 * LAYOUT_TYPE_CHECKBOX
        	 */
        	if (elementTypeId == 6) 
        	{
        	    paramVO.setValOpt("1:0");
        	}
        	/**
        	 * LAYOUT_TYPE_LIVESEARCH
        	 */
        	else if (elementTypeId == 7) 
        	{
        	    _theElemId = "lookuptxt_".concat(_theElemId);
        	    if (dependencyParamList.length() == 0) 
        	    {
        		dependencyParamList.append("screenId:").append("~CONST_").append(criteria.getScreenId());
        		dependencyParamList.append(",").append("elementId:").append("~CONST_").append(currId);
        		dependencyParamList.append(",").append("criteria.elemHm.").append(currId).append(":").append(_theElemId);
        		dependencyList.append(_theElemId).append(":").append("criteria.elemHm." + currId);
        	    }
        	    dependencyParamList.append(",").append("criteria.elemHm.queryDep").append(":").append("~CONST_").append(elementId);
        	    dependencyParamList.append(",").append("criteria.elemHm.queryCond").append(":").append(currId);

        	    String lookupDesc = dynScreenCreatorCO.getLookupDesc();
        	    if (!StringUtil.nullToEmpty(lookupDesc).isEmpty()) 
        	    {
        		dependencyParamList.append(",").append("criteria.elemHm.queryDesc").append(":").append("~CONST_").append(lookupDesc);
        		dependencyList.append(",").append(lookupDesc).append(_addPageRef).append(":").append("criteria.elemHm." + lookupDesc);
        	    }

        	}

        	/**
        	 * properties management
        	 */
        	for (int j = 0; j < elemProperties.size(); j++) 
        	{
        	    SYS_DYN_SCREEN_ELEMENTS_DETVO elementDet = elemProperties.get(j);
        	    String propertyCode     = elementDet.getPROPERTY_CODE();
        	    String propertyValue    = elementDet.getPROPERTY_VALUE();
        	    String propertyBigValue = elementDet.getPROPERTY_EXPRESSION_VALUE();

		    // Adel - Separate grid behavior from other widgets
		    // Each property that needs to have Separate behavior is added here
		    if(ConstantsCommon.LAYOUT_TYPE_GRID.equals(elementType)
			    && (ConstantsCommon.PROPERTY_CODE_TABLE_NAME.equals(propertyCode)
				    || ConstantsCommon.PROPERTY_CODE_QUERY.equals(propertyCode)
				    || ConstantsCommon.PROPERTY_CODE_EDITABLE.equals(propertyCode)
				    || ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode)
				    || ConstantsCommon.PROPERTY_CODE_DBL_CLICK.equals(propertyCode)
				    || ConstantsCommon.PROPERTY_CODE_COLPROPS.equals(propertyCode))
			            || ConstantsCommon.PROPERTY_CODE_ENABLESEARCH.equals(propertyCode)
			            || ConstantsCommon.PROPERTY_CODE_RETRIEVALCONDITION.equals(propertyCode))
		    {
//			dynScreenCreatorCO.setProperty_code(propertyCode);
//			dynScreenCreatorCO.setProperty_value(propertyValue);
//			dynScreenCreatorCO.setProperty_big_value(propertyBigValue);
			fillGridWidgetProperties(dynScreenCreatorCO, paramVO, gridUpdateIds,elementDet, hiddenElemList);
		    }
		    else if (ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(elementType) && ConstantsCommon.PROPERTY_CODE_QUERY.equals(propertyCode)) 
        	    {
        		jsonModel = (JSONArray) JSONSerializer.toJSON(propertyBigValue);
        		modelArr = jsonModel.toArray();
        		obj = (JSONObject) modelArr[0];
        		paramList = new StringBuffer();
        		resultList = new StringBuffer();

        		//Tp#975602 Trim ColumnCode and Column Description
        		columnCode = StringUtil.nullToEmpty(obj.getString("columnCode")).trim();
        		columnDesc = StringUtil.nullToEmpty(obj.getString("columnDesc")).trim();
        		querySynthax = obj.getString("querySynthax");
        		//TP# 1053821 add dependency for addLkpDesc in colProp
        		if(obj.has("addLkpDesc"))
        		{
        		   dependencyForAdditionalLookupDesc(obj, dependencyList, dependencyParamList,false);
        		}
        		Pattern p = Pattern.compile(findParamPattern);
        		Matcher matcher = p.matcher(querySynthax);

        		paramList.append("screenId:").append("~CONST_").append(criteria.getScreenId());
        		paramList.append(",").append("elementId:").append("~CONST_").append(elementId);

        		StringBuffer queryArgsList = new StringBuffer();
        		while (matcher.find()) 
        		{
        		    String currParam = matcher.group();
        		    currParam = currParam.substring(1, currParam.length());
        		    criteria.setParamId(currParam);
        		    BigDecimal paramType = elementsTypeMap.get(currParam);
        		    /**
        		     * in case the parameter that is exists in the query
        		     * is a LiveSearch we have to add 'lookuptxt_' to
        		     * the id when we add it to the paramList
        		     */
        		    String currElemId = currParam;
        		    if (ConstantsCommon.LIVESEARCH_ELEMENT_TYPE.equals(paramType)) 
        		    {
        			currElemId = "lookuptxt_".concat(currParam);
        		    }
        		    queryArgsList.append(",").append("elemHm.").append(currParam).append(":").append(currElemId + _addPageRef);
        		    paramList.append(",").append("elemHm.").append(currParam).append(":").append(currElemId + _addPageRef);
        		    dependencyParamList.append(",").append("elemHm.").append(currParam).append(":").append(currElemId + _addPageRef);
        		}
        		
        		if(StringUtil.isNotEmpty(querySynthax))
        		{
        		    Pattern patternQueryParam = Pattern.compile("(.*?)(\\[screen.(\\S*)\\]|\\[session.(\\S*)\\])(.*?)");
        		    Matcher matcherQueryParam = patternQueryParam.matcher(querySynthax);
        		    StringBuffer queryBuffer = new StringBuffer();
        		    StringBuffer screenParamBuffer = new StringBuffer();
        		    while(matcherQueryParam.find())
        		    {
        			if(matcherQueryParam.group(2) != null)
        			{
        			    matcherQueryParam.appendReplacement(queryBuffer, matcherQueryParam.group(1) + "NULL");
        			    if(StringUtil.isNotEmpty(matcherQueryParam.group(3)))
        			    {
        				String newparam = ",criteria.elemHm.screen_".concat(matcherQueryParam.group(3)).concat(":").concat(matcherQueryParam.group(3) + _addPageRef);
        				paramList.append(newparam);
        				paramList.append(",criteria.elemHm.screenParamMap:returnLookupScreenParamMap('" + currId + _addPageRef + "')");
        				dependencyParamList.append(newparam);
        				dependencyParamList.append(",criteria.elemHm.screenParamMap:returnLookupScreenParamMap('"+ currId + _addPageRef  + "')");
        			    }
        			}
        		    }
        		}
        		
        		
        		paramVO.setParamList(paramList.toString());
        		paramVO.setActionName("/path/dynamicScreen/dynLookupAction_constructQryLookup?");
        		resultList.append(StringUtil.isNotEmpty(resultList.toString()) ? "," : "").append(columnCode).append(":").append(_theElemId);
        		paramVO.setResultList(resultList.toString());
        		paramVO.setSearchElement(columnCode);
        	    }
        	    /**
        	     * 
        	     */
        	    else if (ConstantsCommon.LAYOUT_TYPE_BUTTON.equals(elementType) && ConstantsCommon.PROPERTY_CODE_SOURCE.equals(propertyCode)) 
        	    {
        		jsonModel = (JSONArray) JSONSerializer.toJSON(propertyBigValue);
        		modelArr = jsonModel.toArray();
        		obj = (JSONObject) modelArr[0];
        		paramList = new StringBuffer();
        		// in case of _recReadOnly to set the button disabled
        		if ("true".equals(get_recReadOnly())) 
        		{
        		    paramVO.setReadOnly("true");
        		}
        		sourceType = obj.getString("sourceType");
        		if (ConstantsCommon.INTERNAL_SCREEN_BTN_SOURCE.equals(sourceType)) 
        		{
        		    String sourceScreenId = obj.getString("sourceScreenId");
        		    int sourceScreenWidth = (obj.containsKey("sourceScreenWidth") && !StringUtil.nullToEmpty(obj.getString("sourceScreenWidth")).isEmpty()) ? obj.getInt("sourceScreenWidth") : 400;
        		    int sourceScreenHeight = (obj.containsKey("sourceScreenHeight") && !StringUtil.nullToEmpty(obj.getString("sourceScreenHeight")).isEmpty()) ? obj.getInt("sourceScreenHeight") : 600;
        		    String sourceScreenTitle = (obj.containsKey("sourceScreenTitle") && !StringUtil.nullToEmpty(obj.getString("sourceScreenTitle")).isEmpty()) ? obj.getString("sourceScreenTitle") : ""; 
        		    paramVO.setOnClick("dynamicScreen_openDynamicScreen('"
        			    + sourceScreenId
        			    + "', null, '"
        			    + paramVO.getId()
        			    + "',"
        			    + sourceScreenWidth
        			    + ","
        			    + sourceScreenHeight
        			    + ", null"
        			    + ", null"
        			    + ", '" + StringEscapeUtils.escapeJavaScript(sourceScreenTitle) + "')");
        		    DynamicScreenParamsMapSC criteria = new DynamicScreenParamsMapSC();
        		    criteria.setMapElementType(DynamicScreenConstant.MAP_ELEMENT_TYPE.DYN_BTN_LINK_TO_DYN_SCREEN.getValue());
        		    criteria.setElementIdentifier(dynScreenCreatorCO.getElementId());
        		    criteria.setElementOpId(new BigDecimal(sourceScreenId));
        		    List<DynamicScreenParamsMapCO> paramMapList = returnCommonLibBO().returnDynScreenMappedParameters(criteria);
        		    if (paramMapList != null && !paramMapList.isEmpty()) 
        		    {
        			DynamicParamsVO hideDynScreenMappedData = new DynamicParamsVO();
        			hideDynScreenMappedData.setId(paramVO.getId()+ "_dynScreenMappedParameters");
        			hideDynScreenMappedData.setElement_type(HIDDEN_ELEMENT);
        			hideDynScreenMappedData.setRow(0);
        			hideDynScreenMappedData.setColumn(0);
        			hideDynScreenMappedData.setValue(PathJSONUtil.strutsJsonSerialize(paramMapList, null, null,false, true));
        			hiddenElemList.add(hideDynScreenMappedData);
        		    }
        		} 
        		else if (ConstantsCommon.SCRIPT_BTN_SOURCE.equals(sourceType)) 
        		{
        		    String sourceScriptData = obj.getString("sourceScriptData");
        		    if (!StringUtil.nullToEmpty(sourceScriptData).isEmpty()) 
        		    {
        			// 471675 added buttonFunction to handle button
        			// scripts.
        			String buttonFunction = "dynamicScreen_excute_"+ paramVO.getId() + "()";
        			paramVO.setOnClick(buttonFunction);
        			if (StringUtil.isNotEmpty(_addPageRef)) 
        			{
        			    /**
        			     * in case there is a progref, catch all the
        			     * parameters that are used inside the
        			     * script and add _progRef to the used Ids
        			     */
        			    sourceScriptData = replaceFormIdWithPageRef(sourceScriptData, _addPageRef, formId);
        			}
        			sourceScriptData = sourceScriptData.replaceAll("\\[formId\\]", formId).replaceAll("\\[screenId\\]",criteria.getScreenId().toString());
        			paramVO.setButtonScript("function "+ buttonFunction + "{"+ sourceScriptData + "}");
        		    }

        		} 
        		else if (ConstantsCommon.EXTERNEL_BTN_SOURCE.equals(sourceType)) 
        		{
        		    // to manage the external screen process
        		    String sourceGlobalActivityId = obj.getString("sourceGlobalActivityId");
        		    paramVO.setOnClick("customBtnActionCall('"+ paramVO.getId() + "', null);");
        		    
        		    Map<String, Object> customBtnDataMap = new HashMap<String, Object>();
        		    
        		    HttpServletRequest request = ServletActionContext.getRequest();
        		    BigDecimal buttonElementId = dynScreenCreatorCO.getElementId();
        		    BigDecimal screenId = dynScreenCreatorCO.getSysDynScreenDefVO().getDYN_SCREEN_ID();
        		    request.setAttribute("DYNAMIC_SCREEN_ID", screenId);
        		    request.setAttribute("DYNAMIC_ELEMENT_ID", buttonElementId);
        		    customBtnDataMap = RootUtil.returnButtonCustActionData(request,
				    new BigDecimal(sourceGlobalActivityId), true, null);
        		   
        		    customBtnDataMap.put("isGlobalActivity", true); 
        		    customBtnDataMap.put("fromDynScreenId", screenId);
        		    customBtnDataMap.put("fromDynElementId", buttonElementId);
        		    
        		    DynamicParamsVO hideDynScreenMappedData = new DynamicParamsVO();
        		    hideDynScreenMappedData.setId(paramVO.getId()+ "_customBtnData");
        		    hideDynScreenMappedData.setElement_type(HIDDEN_ELEMENT);
        		    hideDynScreenMappedData.setRow(0);
        		    hideDynScreenMappedData.setColumn(0);
        		    hideDynScreenMappedData.setValue(PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null,false, true));
        		    hiddenElemList.add(hideDynScreenMappedData);
        		}
        		// Added by Adel to cover submit button
        		else if (ConstantsCommon.SUBMIT_BTN_SOURCE.equals(sourceType)) 
        		{
        		    paramVO.setOnClick("dynScreenProcessAfterValidate('"+ formId+ "','"+ criteria.getScreenId() + "')");
        		}
        		// Added to cover 'Submit with Parent' Button reference to TP#989676
        		else if (ConstantsCommon.SUBMIT_WITH_PARENT_BTN_SOURCE.equals(sourceType)) 
        		{
        		    paramVO.setOnClick("dynScreenProcessWithParent('"+ formId+ "','"+ criteria.getScreenId() + "')");
        		    submitWithParent = true;
        		}
        		// Added by Adel to cover delete button
        		else if (ConstantsCommon.DELETE_BTN_SOURCE.equals(sourceType)) 
        		{
        		    if (ConstantsCommon.ON_LOAD_MODE.equals(criteria.getModeType())) 
        		    {
        			paramVO.setVisible(ConstantsCommon.TRUE);
        		    } 
        		    else 
        		    {
        			paramVO.setVisible(ConstantsCommon.FALSE);
        		    }
        		    paramVO.setOnClick("dynamicScreenOnBtnDelete('"+ formId + "','" + criteria.getScreenId()+ "')");
        		}
        	    } 
        	    else if (ConstantsCommon.LAYOUT_TYPE_BUTTON.equals(elementType) && ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode)&& !StringUtil.nullToEmpty(propertyValue).isEmpty()) 
        	    {
        		paramVO.setLabel(getText(propertyValue));
        	    } 
        	    else if ((ConstantsCommon.LAYOUT_TYPE_RADIOBUTTON.equals(elementType) || ConstantsCommon.LAYOUT_TYPE_COMBOBOX.equals(elementType))
        		    && ConstantsCommon.PROPERTY_CODE_OPTIONS.equals(propertyCode)) 
        	    {
        		setHasHiddenOpt(ConstantsCommon.ZERO);
        		//TP 1010834
        		SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO scrMapEm = null;
        		if(dynScrParamMap!=null)
        		{
        		    scrMapEm = dynScrParamMap.get(elementDet.getELEMENT_ID());
        		}
        		criteria.setOptionsData(propertyBigValue);
        		String defaultValue =null;
        		//Fill Options
        		List<SelectCO> list = fillOptionsDataList(paramVO.getId(),propertyBigValue,elementType);
			//For data loaded from Grid
        		if(scrMapEm!=null && ConstantsCommon.ON_LOAD_MODE.equals(StringUtil.nullToEmpty(criteria.getModeType()))) 
        		{
        		    for (SelectCO selectCO : list) 
        		    {
        			if(StringUtil.nullToEmpty(scrMapEm.getMAP_VALUE()).equals(selectCO.getCode()))
        			{
        			    defaultValue = selectCO.getCode();
        			}
        		    } 
        		}
        		else
        		{
        		    for (SelectCO selectCO : list)
        		    {
        			if(ConstantsCommon.ONE.equals(selectCO.getDefaultValue()))
        			{
        			    defaultValue = selectCO.getCode();
        			}
        		    }
        		}
        		ListParamVO lstParamVO = new ListParamVO();
        		lstParamVO.setValueList("optionsDataMap."+paramVO.getId()+"_lst");
        		lstParamVO.setKey("code");
        		lstParamVO.setValue("descValue");
        		if(!StringUtil.nullToEmpty(hasHiddenOpt).isEmpty() && ConstantsCommon.ONE.equals(hasHiddenOpt))
        		{			
        		    lstParamVO.setHasHiddenOpt(hasHiddenOpt);
        		}
        		else
        		{
        		    lstParamVO.setHasHiddenOpt(ConstantsCommon.ZERO);
        		}
        		paramVO.setListParamVO(lstParamVO);
        		if(StringUtil.nullToEmpty(defaultValue).isEmpty())
        		{
        		    paramVO.setEmptyOption(ConstantsCommon.TRUE);
        		}
        		else 
        		{
        		    paramVO.setValue(defaultValue);
        		    paramVO.setConsiderChoiceValue(ConstantsCommon.TRUE);
        		}
        	    } 
        	    else if (ConstantsCommon.LAYOUT_TYPE_RADIOBUTTON.equals(elementType)
        		    && ConstantsCommon.PROPERTY_CODE_GROUP_LABEL.equals(propertyCode)
        		    && !StringUtil.nullToEmpty(propertyValue).isEmpty()) 
        	    {
        		paramVO.setGroupLabel(propertyValue);
        	    } 
        	    else if (ConstantsCommon.LAYOUT_TYPE_DATEPICKER.equals(elementType)
        		    && (ConstantsCommon.PROPERTY_CODE_TIME.equals(propertyCode)
        			    || ConstantsCommon.PROPERTY_CODE_DATE.equals(propertyCode) 
        			    || ConstantsCommon.PROPERTY_CODE_HIJRI.equals(propertyCode)
        			    || ConstantsCommon.PROPERTY_CODE_DATE_DEFLT_VAL.equals(propertyCode))) 
        	    {
        		if (ConstantsCommon.ONE.equals(propertyValue)) 
        		{
        		    if (ConstantsCommon.PROPERTY_CODE_TIME.equals(propertyCode)) 
        		    {
        			timeProp = true;
        		    } 
        		    else if (ConstantsCommon.PROPERTY_CODE_DATE.equals(propertyCode)) 
        		    {
        			String initFormat = DateUtil.getDatePattern(paramVO.getValue());
        			if (initFormat != null) 
        			{
        			    Date initDate = new SimpleDateFormat(initFormat).parse(paramVO.getValue());
        			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        			    paramVO.setValue(formatter.format(initDate));
        			}
        			dateProp = true;
        		    }
        		    else if(ConstantsCommon.PROPERTY_CODE_DATE_DEFLT_VAL.equals(propertyCode))
        		    {
        			dateDefaultVal = true;
        		    }
        		    else 
        		    {
        			hijriProp = true;
        		    }
        		}
        	    } 
        	    else if (ConstantsCommon.PROPERTY_CODE_MAXLENGTH.equals(propertyCode)
        		    && propertyValue != null
        		    && propertyValue.trim().length() > 0) 
        	    {
        		paramVO.setMaxLength(Integer.valueOf(propertyValue));
        	    } 
        	    else if (ConstantsCommon.LAYOUT_TYPE_LABEL.equals(elementType)) 
        	    {
        		if (ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode)) 
        		{
        		    paramVO.setLabel(propertyValue);
        		}
        		if (ConstantsCommon.PROPERTY_CODE_LABELFOR.equals(propertyCode)
        			&& !StringUtil.nullToEmpty(propertyValue).isEmpty()) 
        		{
        		    String propVal = propertyValue + _addPageRef;
        		    if(elementsTypeMap!=null && elementsTypeMap.containsKey(propertyValue))
        		    {
				BigDecimal theParamType = elementsTypeMap.get(propertyValue);
				String theCurElemTyp = ConstantsCommon.ELEMENT_LAYOUT_TYPE_MAP.get(Integer.valueOf(theParamType.intValue()));
				if (ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(theCurElemTyp)) 
				{				    
				    propVal = "lookuptxt_"+propVal;
				}
        		    }
        		    paramVO.setLabelForElemId(propVal);
        		}
        	    } 
        	    else if (ConstantsCommon.PROPERTY_CODE_TITLE.equals(propertyCode) && StringUtil.isNotEmpty(propertyValue)) 
        	    {
        		paramVO.setTitle(getText(propertyValue));
        	    } 
        	    else if (ConstantsCommon.PROPERTY_CODE_NBFORMAT.equals(propertyCode) && StringUtil.isNotEmpty(propertyValue)) 
        	    {
        		String formatPattern = "[a-zA-Z1-9]+";
        		Pattern formatPtrn = Pattern.compile(formatPattern);
        		Matcher formatmatcher = formatPtrn.matcher(propertyValue);
        		if (!formatmatcher.find()) 
        		{
        		    if (ConstantsCommon.DYN_ELEM_MODE_NUMERIC.equals(currElemMode)) 
        		    {
        			paramVO.setNbFormat(propertyValue);
        		    } 
        		    else 
        		    {
        			paramVO.setTxtFormat(propertyValue);
        		    }
        		}
        	    }
		    else if(ConstantsCommon.PROPERTY_CODE_NBFRMTTER.equals(propertyCode))
		    {
			if(ConstantsCommon.DYN_ELEM_MODE_NUMERIC.equals(currElemMode)
				&& ConstantsCommon.ONE.equals(propertyValue))
			{
			    paramVO.setFormatter("numberFmatterBrackets");
			}
		    }
		    else if(ConstantsCommon.PROPERTY_CODE_NBZRONTALW.equals(propertyCode))
		    {
			if(ConstantsCommon.DYN_ELEM_MODE_NUMERIC.equals(currElemMode)
				&& ConstantsCommon.ONE.equals(propertyValue))
			{
			    paramVO.setZeroNotAllowed(ConstantsCommon.TRUE);
			}
		    }
		    else if(ConstantsCommon.PROPERTY_CODE_NBNEGNTALW.equals(propertyCode))
		    {
			if(ConstantsCommon.DYN_ELEM_MODE_NUMERIC.equals(currElemMode)
				&& ConstantsCommon.ONE.equals(propertyValue))
			{
			    paramVO.setMinValue(BigDecimal.ZERO);
			}
		    }
		    else if(ConstantsCommon.PROPERTY_CODE_FILE_NAME.equals(propertyCode)
			    && StringUtil.isNotEmpty(propertyValue))
		    {
			paramVO.setOnClick("dynamicScreen_downloadDynFile('" + formId + "','" + criteria.getScreenId()
				+ "','" + paramVO.getId() + "','" + propertyValue + "');event.stopImmediatePropagation();");
		    }

        	    /**
        	     * Expressions
        	     */
        	    if ((ConstantsCommon.PROPERTY_CODE_READONLY.equals(propertyCode)
        		    || ConstantsCommon.PROPERTY_CODE_REQUIRED.equals(propertyCode)
        		    || ConstantsCommon.PROPERTY_CODE_VISIBLE.equals(propertyCode) 
        		    || ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode))
        		    && !StringUtil.nullToEmpty(propertyBigValue).isEmpty()) 
        	    {
        		if ((dependencyList == null || dependencyList.length() == 0) && ConstantsCommon.PROPERTY_CODE_VALIDATE.equals(propertyCode)) 
        		{
        		    dependencyList.append(_theElemId+ ":criteria.elemHm." + currId);
        		    dependencyParamList.append("screenId:~CONST_"+ criteria.getScreenId() + ",elementId:'"+ currId + "',elemHm." + currId + ":"+ _theElemId);
        		}
        		/**
        		 * [MarwanMaddah]: in case The expression is on the
        		 * value expression the execute expression result, will
        		 * not be forced as boolean
        		 */
        		if (ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode)) 
        		{
        		    criteria.setValueExpression(true);
        		} 
        		else 
        		{
        		    criteria.setValueExpression(false);
        		}
        		criteria.setElementsTypeMap(elmExprModeMap);
        		
        		// Hussein Zaraket - Fill sessionCO variables in requiredFieldsSC in order to use when executing expression.
        		RequiredFieldsSC requiredFieldsSC   = new RequiredFieldsSC();
        		requiredFieldsSC.setUserId(sessionCO.getUserName());
        		requiredFieldsSC.setLoginUserId(sessionCO.getUserName());
        		requiredFieldsSC.setCompCode(sessionCO.getCompanyCode());
        		requiredFieldsSC.setCompanyName(sessionCO.getCompanyName());
        		requiredFieldsSC.setBranchCode(sessionCO.getBranchCode());
        		requiredFieldsSC.setBranchName(sessionCO.getBranchName());
        		requiredFieldsSC.setUserFirstName(sessionCO.getUserFirstName());
        		requiredFieldsSC.setUserLastName(sessionCO.getUserLastName());
        		requiredFieldsSC.setBaseCurrencyName(sessionCO.getBaseCurrencyName());
        		if(null != sessionCO.getCtsTellerVO()) 
        		{
        			requiredFieldsSC.setIsTeller(BigDecimal.ONE);
        		}else 
        		{
        			requiredFieldsSC.setIsTeller(BigDecimal.ZERO);
        		}
        		requiredFieldsSC.setRunningDate(sessionCO.getRunningDateRET());
        		
        		Object expressionResult = dynamicScreenBO.executeCurrentExpression(criteria,dynScrParamMap, paramVO,propertyBigValue,requiredFieldsSC);
        		if (ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode)&& expressionResult != null) 
        		{
        		    if (MODE_NUMBER.equals(dynScreenCreatorCO.getCurrElemMode())
        			    || (!StringUtil.nullToEmpty(dynScreenCreatorCO.getCurrElemMode()).isEmpty() && expressionResult instanceof BigDecimal)) 
        		    {
        			BigDecimal resultObj = (BigDecimal) expressionResult;
        			if (NumberUtil.emptyDecimalToNull(resultObj) != null) 
        			{
        			    paramVO.setValue(new String(""+ resultObj.intValue()));
        			}
        		    } 
        		    else if (!StringUtil.nullToEmpty(dynScreenCreatorCO.getCurrElemMode()).isEmpty()) 
        		    {
        			paramVO.setValue(String.valueOf(expressionResult));
        		    }
        		} 
        		else 
        		{
        		    elemExprResult = (BigDecimal) expressionResult;
        		}
        		if (BigDecimal.ONE.equals(elemExprResult)) 
        		{
        		    if (ConstantsCommon.PROPERTY_CODE_READONLY.equals(propertyCode)) 
        		    {
        			paramVO.setReadOnly(ConstantsCommon.TRUE);
        			displayVO.setIS_READONLY(new BigDecimal(1));
        			displayVO.setREADONLY_EXPR(propertyBigValue);
        		    }
        		    if (ConstantsCommon.PROPERTY_CODE_REQUIRED.equals(propertyCode)) 
        		    {
        			// TP 1085880 - File upload field mandatory issue
        			if(ConstantsCommon.LAYOUT_TYPE_FILE.equals(paramVO.getElement_type())) 
        			{
        			    paramVO.setRequired("path_required");
        			}
        			else 
        			{
        			    paramVO.setRequired(ConstantsCommon.TRUE);
        			}
        			displayVO.setIS_MANDATORY(new BigDecimal(1));
        			displayVO.setMANDATORY_EXPR(propertyBigValue);
        		    }
        		    if (ConstantsCommon.PROPERTY_CODE_VISIBLE.equals(propertyCode)) 
        		    {
        			
        			displayVO.setIS_VISIBLE(new BigDecimal(1));
        			displayVO.setVISIBILITY_EXPR(propertyBigValue);
        		    }
        		} 
        		else 
        		{
        		    if (ConstantsCommon.PROPERTY_CODE_VISIBLE.equals(propertyCode)) 
        		    {
        			if (cssStyle.length() == 0) 
        			{
        			    cssStyle.append("display:none;");
        			} 
        			else 
        			{
        			    cssStyle.append(" ").append("display:none;");
        			}
        			displayVO.setIS_VISIBLE(new BigDecimal(0));
        			displayVO.setVISIBILITY_EXPR(propertyBigValue);
        		    }
        		    else if (ConstantsCommon.PROPERTY_CODE_READONLY.equals(propertyCode)) 
        		    {
        		    //TP#1083826
        			paramVO.setReadOnly(ConstantsCommon.FALSE);
        			displayVO.setIS_READONLY(new BigDecimal(0));
        			displayVO.setREADONLY_EXPR(propertyBigValue);

        		    }
        		    else if (ConstantsCommon.PROPERTY_CODE_REQUIRED.equals(propertyCode)) 
        		    {
        			paramVO.setRequired(ConstantsCommon.FALSE);
        			displayVO.setIS_MANDATORY(new BigDecimal(0));
        			displayVO.setMANDATORY_EXPR(propertyBigValue);
        		    }
        		}

        	    }
        	}
        	 displayhm.put(paramVO.getId(), displayVO);
        	/**
        	 * end of properties loop
        	 */
        	if(ConstantsCommon.LAYOUT_TYPE_GRID.equals(elementType))
        	{
        	    if(tempPropertiesHm.get(ConstantsCommon.PROPERTY_CODE_TABLE_NAME)!=null)
        	    {
        		fillGridWidgetFromDynTableProperty(dynScreenCreatorCO, paramVO);
        	    }
        	    tempPropertiesHm = new HashMap<String,String>();
        	    //Fill list of grid ids whose query contains screen parameters to automatically reload the grid when screen parameter is modified
        	    if(StringUtil.isNotEmpty(paramVO.getParamList())) 
        	    {
        		String params=paramVO.getParamList();//params is a string representation of grid Ids as follows "['gridId1','gridId2'...]"
        		params= params.substring(1, (params.length())-1);// remove [] from params

        	    
        	    String[] currArray;
        	    ArrayList<String> paramArrayList= new ArrayList<String>() ;
        	    if(StringUtil.isNotEmpty(params)) {
        		 currArray= params.split(",");
        		 
        		 for(int index=0;index<currArray.length;index++)
        		 {
        		 //add PROG_REF within single quotes
        		 currArray[index]= currArray[index].substring(0, currArray[index].length()-1)+_addPageRef+currArray[index].substring(currArray[index].length()-1);
        		 }

        		 paramArrayList = new ArrayList<String>(Arrays.asList(currArray));
        	    }
        	    //Add ProgRef to if of the element which will trigger the reload of the grid
        	    gridParamHm.put(dynScreenCreatorCO.getTheId()+_addPageRef,paramArrayList);

        	    }
        	}
        	
        	if (ConstantsCommon.LAYOUT_TYPE_DATEPICKER.equals(elementType)) 
        	{
        	    String dateFormat = "yyyy-MM-dd";
        	    if (dateProp) 
        	    {
        		if (timeProp) 
        		{
        		    paramVO.setDateWithTime(ConstantsCommon.TRUE);
        		    paramVO.setDateTimeAmPm("true");
        		    dateFormat ="yyyy-MM-dd'T'HH:mm:ss";
        		}
        		if (hijriProp) 
        		{
        		    paramVO.setShowHijri(ConstantsCommon.TRUE);
		    //							if(dependencyParamList == null || dependencyParamList.length() == 0)
		    //							{
		    //								paramVO.setOnchange("onChangeDateWithHijri('"+paramVO.getId()+"')");
		    //							}

        		}
        	    } 
        	    else 
        	    {
        		if (timeProp) 
        		{
        		    // timePicker
        		    // paramVO.setDateWithTime(ConstantsCommon.TRUE);
        		}
        		if (hijriProp) 
        		{
        		    paramVO.setShowHijri(ConstantsCommon.TRUE);
        		    paramVO.setShowOnlyHijri(ConstantsCommon.TRUE);
        		    //							if(dependencyParamList == null || dependencyParamList.length() == 0)
        		    //							{
        		    //								paramVO.setOnchange("onChangeDateWithHijri('"+paramVO.getId()+"')");
        		    //							}
        		}
        	    }

        	    if(dateDefaultVal && StringUtil.nullToEmpty(paramVO.getValue()).isEmpty())
        	    {						
        		DateFormat df  = new SimpleDateFormat(dateFormat);
        		String dateString = df.format(sessionCO.getRunningDateRET());					
        		paramVO.setValue(dateString);
        	    }
        	}

        	//		    defineDynamicParamValue(dynScrParamMap,paramVO, elementId);
        	if(!tableRowMap.isEmpty() && tableRowMap.containsKey(paramVO.getName().replace("scrElemHm.", "").toUpperCase()))
        	{
//commented on behalf of Marwan Maddah to adjust the saving of radio values inside dynamic tables
//        	    if(paramVO.getValue().isEmpty()){
        		String theKey = paramVO.getName().replace("scrElemHm.", "").toUpperCase();
        		tableRowMap.get(theKey);
        		Object theValue = tableRowMap.get(theKey);
        		String value = "";
        		if(theValue!=null)
        		{
        		    value = ""+theValue;
        		    if(!value.isEmpty())
        		    {
        			// format date from db in order to be compatible with datepicker
        			if(ConstantsCommon.LAYOUT_TYPE_DATEPICKER.equals(elementType))
        			{
        			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        			    Date tempDate = sdf.parse(value);
        			    sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        			    value = sdf.format(tempDate);
        			}
        			//Fix COMBOBOX Display for mapping
        			else if(ConstantsCommon.LAYOUT_TYPE_COMBOBOX.equals(elementType))
        			{
        			    paramVO.setConsiderChoiceValue(ConstantsCommon.TRUE);
        			}
        			paramVO.setValue(value);
        		    }
        		}
//        	    }
        	    if(scrElemHm.containsKey(paramVO.getName().replace("scrElemHm.", "").toUpperCase())  )
        	    {
        		paramVO.setReadOnly(ConstantsCommon.TRUE);
        	    }
        	}
       
        	  /**
        	   * TP#989676 Dynamic Screen Button to Save Child Screen opened from Parent with Parent Submit - Enhancement
        	   * if screen is child screen and opened form parent screen then fill form with the old values 
        	   */
        	  if(criteria.getSourceData() != null)
        	  {
        	      if(ConstantsCommon.LAYOUT_TYPE_FILE.equals(paramVO.getElement_type()))
        	      {
        		  //set method onClick to download file
        		  paramVO.setOnClick("dynamicScreen_downloadDynJsonEncFile('" + formId + "','" + criteria.getScreenId()	+ "','" + paramVO.getId() + "');event.stopImmediatePropagation();");
        	      }
        	      else if(childScreenElemHm != null && !childScreenElemHm.isEmpty())
        	      {
        		  String theKey = paramVO.getName().replace("scrElemHm.", "");
        		  if(childScreenElemHm.containsKey(theKey) && !StringUtil.nullToEmpty(childScreenElemHm.get(theKey)).isEmpty())
        		  {
        		      //set form element value
        		      paramVO.setValue(childScreenElemHm.get(theKey));
        		      if(ConstantsCommon.LAYOUT_TYPE_RADIOBUTTON.equals(paramVO.getElement_type()))
        		      {
        			paramVO.setConsiderChoiceValue(ConstantsCommon.TRUE);  
        		      }
        		  }
        	      }
        	  }
        	/**
        	 * 
        	 */
        	  //TP#1070377 call dependency method
        	  paramVO.setCssStyle(cssStyle.toString());//set cssStyle
        	  if (dependencyParamList != null && dependencyParamList.length() > 0) 
                    {
        		    paramVO.setDependency(dependencyList.toString());
        		    paramVO.setParameters(dependencyParamList.toString());
                    }
        	  dynScreenCreatorCO.setDynScrParamVO(paramVO);
            }
           
            for(DynamicScreenCreatorCO  currParamCO : dataLst) {

        	DynamicParamsVO currParamVO = currParamCO.getDynScrParamVO();
        	String dependencyParamListStr = StringUtil.nullToEmpty(currParamCO.getDynScrParamVO().getParameters());
        	String dependencyListStr = StringUtil.nullToEmpty(currParamCO.getDynScrParamVO().getDependency());
        	dependencyList = new StringBuffer();
        	dependencyParamList = new StringBuffer();
        	//set LinkedElements
        	if(!dependencyHm.isEmpty())
        	{
        	    dependencyHm.forEach((key,value)->{

        		if(key.equals(currParamCO.getTheId())){
        		    currParamCO.setLinkedElements(value);
        		}
        	    });
        	    
        	}
        	
        	//set dependency for comboBox optionDependencyHm
        	if(!optionDependencyHm.isEmpty())
        	{
        	    for (Entry<String, List<LinkedElementsCO>> entry : optionDependencyHm.entrySet())
        	    {
        		if(entry.getKey().equals(currParamCO.getTheId()))
        		{
        		    String theId =currParamCO.getTheId();
        		    String elemType = currParamCO.getElementType().toString();
        		    String elmId =theId+_addPageRef;
        		    if(ConstantsCommon.ELEMENT_TYPE_LIVESEARCH.equals(elemType))
			    {
        			elmId = "lookuptxt_"+elmId;
			    }
        		    BigDecimal elemenId = currParamCO.getElementId();
        		   
        		    for(LinkedElementsCO lnkElemCO : entry.getValue())
        		    {
        			 
             		    String propertyCode = lnkElemCO.getPropertyCode();
             		    BigDecimal elemenType = lnkElemCO.getElementType();
             		    BigDecimal elId  = lnkElemCO.getElemId();
             		    String elTheId = lnkElemCO.getId();
             		    if(dependencyParamListStr.length()==0)
             		    {
             		    	dependencyParamList.append("screenId:").append("~CONST_").append(criteria.getScreenId());
             		    	dependencyParamList.append(",").append("elementId:").append("~CONST_").append( theId );
             		    	dependencyParamList.append(",").append("criteria.elemHm.").append(theId).append(":").append(elmId);
         		       
             		    }
             		    if(dependencyListStr.length()>0)
         		    	{
             				dependencyList.append(",");
         		    	}
             		   
     			    dependencyParamList.append(",").append("criteria.elemHm.").append("propertyCode").append(":").append(propertyCode);
     			    dependencyParamList.append(",").append("criteria.elemHm.").append("elementId").append(":").append("~CONST_").append( elemenId);
     			    dependencyParamList.append(",").append("criteria.elemHm.").append("dependency_"+elId).append(":").append("~CONST_").append(elId);
     			    dependencyParamList.append(",").append("criteria.elemHm.").append("propertyCode_"+elId).append(":").append(propertyCode);
     			    dependencyParamList.append(",").append("criteria.elemHm.").append("elemDependencyID_"+elId).append(":").append(elemenType).append("~").append(elTheId);
     			    
     			    dependencyList.append(elTheId+_addPageRef).append(":").append("hmDepScrOptionsElems." + elId+"_lst");
        		    }
        		   
        		}
        	    }    
        	}
        	if (dependencyParamList != null && dependencyParamList.length() > 0) 
                {
        		  currParamVO.setDependency(dependencyListStr + dependencyList.toString());
        	      currParamVO.setParameters(dependencyParamListStr + dependencyParamList.toString());
                }
        	returnElementDependencies(  currParamCO, currParamVO.getParameters(), currParamVO.getDependency(), elementsTypeMap);
        	//add list of related grids to paramList for automatic grid reload on screen parameter change
        	if(ConstantsCommon.LAYOUT_TYPE_TEXTFIELD.equals(currParamVO.getElement_type())
        		||ConstantsCommon.LAYOUT_TYPE_COMBOBOX.equals(currParamVO.getElement_type())
        		||ConstantsCommon.LAYOUT_TYPE_DATEPICKER.equals(currParamVO.getElement_type())
        		||ConstantsCommon.LAYOUT_TYPE_RADIOBUTTON.equals(currParamVO.getElement_type())
        		||ConstantsCommon.LAYOUT_TYPE_CHECKBOX.equals(currParamVO.getElement_type())
        		||ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(currParamVO.getElement_type())
        		||ConstantsCommon.LAYOUT_TYPE_TEXTAREA.equals(currParamVO.getElement_type())
        		)
        	{
        	    if(!gridParamHm.isEmpty())
        	    {
        		gridParamHm.forEach((key,value)->{

        		    if(value.contains("'"+currParamVO.getId()+"'"))
        		    {
        			if(StringUtil.isNotEmpty(currParamVO.getGridIdList()))
        			{
        			    currParamVO.setGridIdList(currParamVO.getGridIdList()+","+key);
        			}
        			else//if list is empty
        			{
        			    currParamVO.setGridIdList(key);
        			}
        		    }
        		});
        		if(currParamVO.getGridIdList() == null)
        		{
        		    currParamVO.setGridIdList("");
        		}
        	    }
        	}
        	formLst.add(currParamVO);
            }

            //Screen Id as hidden
            paramVO = new DynamicParamsVO();
            paramVO.setId(formId + "_dynamic_screenId");
            paramVO.setName("scrElemHm.dynamic_screenId");
            paramVO.setValue(criteria.getScreenId().toString());
            paramVO.setElement_type(ConstantsCommon.LAYOUT_TYPE_HIDDEN);
            paramVO.setRow(0);
            paramVO.setColumn(0);
            paramVO.setVisible(ConstantsCommon.FALSE);
            hiddenElemList.add(paramVO);
            
            //TP#989676 Hide parent screen parameters json
            if(submitWithParent)
            {
        	paramVO = new DynamicParamsVO();
        	paramVO.setId(formId + "_dynamic_parent_screen_params");
        	paramVO.setName("dynamic_parent_screen_params");
        	paramVO.setValue(getParentScreenParams() == null ? "": getParentScreenParams());	// if direct preview from dynamic screen then empty
        	paramVO.setElement_type(ConstantsCommon.LAYOUT_TYPE_HIDDEN);
        	paramVO.setRow(0);
        	paramVO.setColumn(0);
        	paramVO.setVisible(ConstantsCommon.FALSE);
        	hiddenElemList.add(paramVO);
        	
        	paramVO = new DynamicParamsVO();
        	paramVO.setId("not_open_from_parent_screen_err_key");
        	paramVO.setValue(getText("not_open_from_parent_screen_err_key"));	// error message if child screen not open from parent screen
        	paramVO.setElement_type(ConstantsCommon.LAYOUT_TYPE_HIDDEN);
        	paramVO.setRow(0);
        	paramVO.setColumn(0);
        	paramVO.setVisible(ConstantsCommon.FALSE);
        	hiddenElemList.add(paramVO);
            }

            // add hidden input to identify a new record from updated record
            paramVO = new DynamicParamsVO();
            paramVO.setId(formId + "_hidden_cuId");// create update
            paramVO.setName("scrElemHm.hidden_cu");
            if(ConstantsCommon.ON_LOAD_MODE.equals(criteria.getModeType())) 
            {
        	paramVO.setValue("U");// update record
            } 
            else 
            {
        	paramVO.setValue("C");// create new record
            }
            paramVO.setElement_type(ConstantsCommon.LAYOUT_TYPE_HIDDEN);
            paramVO.setRow(0);
            paramVO.setColumn(0);
            paramVO.setVisible(ConstantsCommon.FALSE);

            hiddenElemList.add(paramVO);

            paramVO = new DynamicParamsVO();
            paramVO.setId(formId + "_date_updated");// create update
            paramVO.setName("scrElemHm.DATE_UPDATED");
            paramVO.setElement_type(ConstantsCommon.LAYOUT_TYPE_HIDDEN);
            paramVO.setRow(0);
            paramVO.setColumn(0);
            paramVO.setVisible(ConstantsCommon.FALSE);
	    if(!tableRowMap.isEmpty() && tableRowMap.containsKey(paramVO.getName().replace("scrElemHm.", "").toUpperCase()))
	    {
		if(paramVO.getValue().isEmpty())
		{
		    //Bug#946481 Dynamic files error on all modules 
		    String value = StringUtil.nullToEmpty(tableRowMap.get(paramVO.getName().replace("scrElemHm.", "").toUpperCase())).toString();
		    paramVO.setValue(value);
		}
	    }
            hiddenElemList.add(paramVO);

            paramVO         = new DynamicParamsVO();
	    paramVO.setId(formId+"_gridUpdateIds");// create update
	    paramVO.setName("gridUpdateIds");
	    paramVO.setElement_type(ConstantsCommon.LAYOUT_TYPE_HIDDEN);
	    paramVO.setValue(gridUpdateIds.toString());
	    paramVO.setRow(0);
	    paramVO.setColumn(0);
	    paramVO.setVisible(ConstantsCommon.FALSE);
	    //TP 1021997
	    hiddenElemList.add(paramVO);
	    formLst.addAll(hiddenElemList);
	    //TP#1045591 Add div at the end of the dynamic screen
	    paramVO = new DynamicParamsVO();
	    paramVO.setElement_type(DIV_ELEMENT);
	    paramVO.setId( formId +"additional_space_div");
	    StringBuffer divCssStyle =new StringBuffer();
	    divCssStyle.append("width:").append("1").append(pxStr).append(";");
	    divCssStyle.append(" ").append("height:").append("20").append(pxStr).append(";");
	    divCssStyle.append(" ").append("position:").append("absolute").append(";");
	    divCssStyle.append(" ").append("top:").append(String.valueOf(maxBottomValue)).append(pxStr).append(";");
	    paramVO.setCssStyle(divCssStyle.toString());
	    paramVO.setRow(0);
	    paramVO.setColumn(0);
	    paramVO.setVisible(ConstantsCommon.TRUE);
	    formLst.add(paramVO);
	    if (StringUtil.nullToEmpty(onLoadScript).isEmpty()) 
	    {
		fillFormElements(formLst,"",formId,"","true","",Boolean.TRUE);
	    } 
            else 
            {
        	for (int i = 0; i < prodIds.size(); i++) 
        	{
        	    onLoadScript = onLoadScript.replaceAll("\\b"+ prodIds.get(i) + "\\b", prodIds.get(i)+ _addPageRef);
        	}
        	// Removed assignment of onLoadScript to Hidden element and
        	// place it directly in DynamicParams.ftl
        	fillFormElements(formLst, "", formId, "", "true", onLoadScript,Boolean.TRUE);
            }
            getFormVO().setChangeTrack(StringUtil.nullToEmpty(changeTrack).isEmpty() ? ConstantsCommon.FALSE: changeTrack);

	} 
	catch (Exception ex) 
	{
	    log.error(ex, "Error during dynamic screen construction process");
	    throw new BaseException(ex);
	}
    }

    //TP#1070377 adding dependency for dynamic screen
    private void returnElementDependencies(DynamicScreenCreatorCO dynamicScreenCreatorCO,String dependencyParamListStr,String  dependencyListStr, Map<String,BigDecimal> elementsTypeMap )
    {
	 DynamicParamsVO paramVO = dynamicScreenCreatorCO.getDynScrParamVO();
	 List<LinkedElementsCO> linkedElements = dynamicScreenCreatorCO.getLinkedElements();
	 String   _addPageRef = StringUtil.nullToEmpty(get_pageRef()).isEmpty()?"":"_"+get_pageRef();
	 String currId = dynamicScreenCreatorCO.getTheId();
	 String formId = StringUtil.isNotEmpty(get_pageRef()) ? "dynScreen_"+ criteria.getScreenId() + "_FormId" + "_" + get_pageRef(): "dynScreen_" + criteria.getScreenId() + "_FormId";    
	 StringBuffer dependencyParamList = new StringBuffer();
	 if(!StringUtil.nullToEmpty(dependencyParamListStr).isEmpty())
	 {
	     dependencyParamList.append(dependencyParamListStr);
	 }
	 
	 StringBuffer dependencyList = new StringBuffer();
	 if(!StringUtil.nullToEmpty(dependencyListStr).isEmpty())
	 {
	     dependencyList.append(dependencyListStr);
	 }
	 
	 /**
	 * dependency management
	 */
	if (linkedElements != null && linkedElements.size() > 0) 
	{
	   
	    String _theElemId = currId+_addPageRef;
	    if(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(paramVO.getElement_type()))
	    {
		_theElemId = "lookuptxt_"+_theElemId;
	    }
	    paramVO.setDependencySrc("path/dynamicScreen/dynDependencyAction_dynDependenciesProcess?");
	    if(dependencyParamList.length()==0)
            {
		 dependencyParamList.append("screenId:").append("~CONST_").append(criteria.getScreenId());
		 dependencyParamList.append(",").append("elementId:").append("~CONST_").append(currId);
		 dependencyParamList.append(",").append("criteria.elemHm.").append(currId).append(":").append(_theElemId);
		
            }
            if(dependencyList.length()==0)
            {
        	 dependencyList.append(_theElemId).append(":").append("criteria.elemHm." + currId);
            }
           
	    for (LinkedElementsCO linkedElement : linkedElements) 
	    {
		String linkedId = linkedElement.getId();
		String currExpression = linkedElement.getExpression();
		/**
		 * to catch all the variables that are exists inside the
		 * current expression not the element that is under
		 * construction and the current element.
		 */
		String currExpPtrn = "(?!AND)(?!OR)(?!and)(?!or)\\w+(\\w)\\w+";
		Pattern p = Pattern.compile(currExpPtrn);
		Matcher matcher = p.matcher(currExpression);
		while (matcher.find()) 
		{
		    String currExpArg = matcher.group();
		    String currArgId = "";
		    if (dependencyParamList != null) 
		    {
			String depParamListStr = dependencyParamList.toString();
			if (depParamListStr.length() > 0 && !depParamListStr.contains(currExpArg)) 
			{
			    if (elementsTypeMap.containsKey(currExpArg)) 
			    {
				BigDecimal paramType = elementsTypeMap.get(currExpArg);
				String curElemTyp = ConstantsCommon.ELEMENT_LAYOUT_TYPE_MAP.get(Integer.valueOf(paramType.intValue()));
				if (ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(curElemTyp)) 
				{
				    currArgId = "lookuptxt_"+currExpArg;
				} 
				else 
				{
				    currArgId = currExpArg;
				}
				dependencyParamList.append(",").append("criteria.elemHm.").append(currExpArg);
				dependencyParamList.append(":").append(currArgId).append(_addPageRef);
			    }

			}
		    }
		}
		/**
		 * END
		 */

	    }
	}
	
	/**
	 * after fetching all the properties, in case the
	 * dependencyParamList is not null and not empty will set the
	 * dependency args inside the ParamVO
	 */
	if (dependencyParamList != null && dependencyParamList.length() > 0) 
	{
	    paramVO.setDependency(dependencyList.toString());
	    paramVO.setParameters(dependencyParamList.toString());
	    paramVO.setDependencySrc("path/dynamicScreen/dynDependencyAction_dynDependenciesProcess?");
	}
	
	
	/**
	 * [MarwanMaddah]: onChange Management 
	 * In case there is dependency the onChange will be handled within the afterDependency
	 * otherwise it will be handled through the onChange event.
	 */
	  String onChangeProp = dynamicScreenCreatorCO.getOnChangeProp();
	  if(!StringUtil.nullToEmpty(onChangeProp).isEmpty())
	  {
  		JSONArray onChangeJson = (JSONArray) JSONSerializer.toJSON(onChangeProp);
  		Object[]  onChangeArr  = onChangeJson.toArray();
  		JSONObject onChangeobj = (JSONObject) onChangeArr[0];

		        String onChangeData = onChangeobj.getString("sourceScriptData");
		        if (!StringUtil.nullToEmpty(onChangeData).isEmpty()) 
		        {
		            
			String onChangeFunc = "dynamicScreen_onChange_"+ paramVO.getId() + "()";
			if(dependencyParamList != null && dependencyParamList.length() > 0)
			{
			    paramVO.setAfterDepEvent(onChangeFunc);
			}
			else
			{        			    
			    paramVO.setOnchange(onChangeFunc);
			}
			if (StringUtil.isNotEmpty(_addPageRef)) 
			{
			    /**
			     * in case there is a progref, catch all the
			     * parameters that are used inside the
			     * script and add _progRef to the used Ids
			     */
			    String scriptParamPattern = "(#\\w+)";
			    Pattern scriptDataPattern = Pattern.compile(scriptParamPattern);
			    Matcher matcher = scriptDataPattern.matcher(onChangeData);
			    List<String> passedElemsMap = new ArrayList<String>();
			    while (matcher.find()) 
			    {
				String currGroup = matcher.group();
				if (!passedElemsMap.contains(currGroup)) 
				{
				    onChangeData = onChangeData.replace(currGroup,currGroup+ _addPageRef);
				    passedElemsMap.add(currGroup);
				}
			    }
			}
			onChangeData = onChangeData.replaceAll("\\[formId\\]", formId).replaceAll("\\[screenId\\]",criteria.getScreenId().toString());
			paramVO.setOnChangeScript("function "+ onChangeFunc + "{"+ onChangeData + "}");
		        }
	  }
    }
    
    /**
     * 
     * @author marwanmaddah
     * @date   Jan 6, 2016
     * @throws BaseException void
     *
     */
//    private void fillDynamicScreenForm() throws Exception
//    {
//	try{	    
//	SessionCO sessionCO     = returnSessionObject();
//	DynamicParamsVO paramVO = new DynamicParamsVO();
//	criteria.setLangCode(sessionCO.getLanguage());
//	criteria.setLovTypeId(ConstantsCommon.ELEMENT_PROPERTY_LOV_TYPE);
//	
//	List<DynamicScreenCreatorCO> dataLst = generatorBO.returnScreenElementsData(criteria);
//	BigDecimal elementId =null;
//	String currId = "";
//	String _theElemId = "";
//	String pxStr = "",currAttr="",attrValue="";
//	String elementType = "";
//    StringBuffer cssStyle = new StringBuffer();
//    Statement stmt;
//    StringBuffer dependencyList      = new StringBuffer();
//    StringBuffer dependencyParamList = new StringBuffer();
//    StringBuffer descDependency	 = new StringBuffer();
//    StringBuffer descDepParam	 = new StringBuffer();
//    HashMap<String, StringBuffer> descDeps = new HashMap<String, StringBuffer>();
//    HashMap<String, StringBuffer> descDepPars = new HashMap<String, StringBuffer>();
//    String   _addPageRef = StringUtil.nullToEmpty(get_pageRef()).isEmpty()?"":"_"+get_pageRef();
//    SelectCO selectCO    = new SelectCO();
//    JSONArray  jsonModel;
//    Object[]   modelArr;
//    JSONObject obj;
//    StringBuffer paramList  = new StringBuffer();
//    StringBuffer resultList = new StringBuffer(); 
//    String columnCode;
//    String columnDesc;
//    String sourceType;
//    String querySynthax;
//    String formId = StringUtil.isNotEmpty(get_pageRef())?"dynScreen_"+criteria.getScreenId()+"_FormId"+"_"+get_pageRef():"dynScreen_"+criteria.getScreenId()+"_FormId";
//    String findParamPattern = "#\\s*(\\w+)";
//    String onLoadScript = null;
//    boolean dateProp = false, timeProp = false, hijriProp = false;
//    List<String> prodIds = new ArrayList<String>();
//    Map<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> dynScrParamMap  = returnDynamicScrParamsMap();
//    boolean newElement = true;
//    CommonLibSC commonLibSC = new CommonLibSC();
//    boolean displayMgntDone = false;
//    BigDecimal elemExprResult = BigDecimal.ZERO;
//    Map<String, String> queryDepPassed = new HashMap<String, String>();
//    boolean expressionExist = false;
//    LinkedHashMap<String,Object> tableRowMap = new LinkedHashMap<String,Object>();
//    HashMap<BigDecimal,String> pkElements = new HashMap<BigDecimal,String>();
//    StringBuffer gridUpdateIds = new StringBuffer();
//    // only used when on dbl click event from grid or if opening screen through PK
//    //  retrieve row information after double click from dynamic grid or by PK from button or screen
//    if(!dynScrParamMap.isEmpty())
//    {
//        for(Entry<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> entry : dynScrParamMap.entrySet())
//        {
//    		SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO sysParamVo = entry.getValue();
//    		if(sysParamVo.getDYN_PARAM_TYPE().equals("2"))
//    		{
//    		    pkElements.put(sysParamVo.getTO_ELEMENT_ID(),sysParamVo.getMAP_VALUE());
//    		    criteria.setModeType(ConstantsCommon.ON_LOAD_MODE);
//    		}
//        }
//    }
//
//    scrGridFlag = NumberUtil.nullToZero(dataLst.get(0).getScrTableId());
//
//    if(ConstantsCommon.ON_LOAD_MODE.equals(criteria.getModeType()))
//    {
//	criteria.setLovTypeId(ConstantsCommon.DATA_TYPE_LOV_TYPE);
//	criteria.setLangCode(sessionCO.getLanguage());
//	List<DynamicScreenCreatorCO> dynScrCreatorList = dynamicScreenBO.retrieveDynTableScreenColsInfo(criteria);
//	List<String> queryColList = new ArrayList<String>();
//	SYS_DYN_TABLE_DETVO sysDynTableDetVO = new SYS_DYN_TABLE_DETVO();
//	String colTechName;
//	String ColTechValue;
//	boolean isCompletePk = true;
//	// if there are parameters sent from another screen or from button customization, 
//	//check if the parameters are linked to primary key in order to retrieve its record from db
//	//set isCompletePk to false if not matching 
//	if(!dynScrParamMap.isEmpty())
//	{
//	    for(int i = 0; i < dynScrCreatorList.size(); i++)
//	    {
//		DynamicScreenCreatorCO dynCO = dynScrCreatorList.get(i);
//		sysDynTableDetVO = dynCO.getSysDynTableDetVO();
//		colTechName = sysDynTableDetVO.getCOL_TECH_NAME();
//		if(sysDynTableDetVO.getPRIMARY_KEY().equals(BigDecimal.ONE) && pkElements.containsKey(dynCO.getElementId()))
//		{
//		    if(pkElements.get(dynCO.getElementId()).isEmpty()){
//			isCompletePk = false;
//		    }
//		    scrElemHm.put(dynCO.getProperty_value(), pkElements.get(dynCO.getElementId()));
//		}
//		else if(sysDynTableDetVO.getPRIMARY_KEY().equals(BigDecimal.ONE) && !pkElements.containsKey(dynCO.getElementId()))
//		{
//		isCompletePk = false;
//		break;
//		}
//	    }
//	}
//	
//	// retrieve record from db
//	if(!isCompletePk == false)
//	{
//	    String inputString;
//	    BigDecimal columnType;
//	    String columnName;
//	    
//	    Map<String, Object> pkColValHm = new HashMap<String, Object>();
//	    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    Date dateFormatted = null;
//	    SimpleDateFormat desiredFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//	    
//	    for(int i = 0; i < dynScrCreatorList.size(); i++)
//	    {
//		sysDynTableDetVO = dynScrCreatorList.get(i).getSysDynTableDetVO();
//		colTechName = sysDynTableDetVO.getCOL_TECH_NAME();
//		// do not retrieve the type 6 which is blob
//		if(sysDynTableDetVO.getCOL_TYPE().intValue() != 6)
//		{
//		    queryColList.add(colTechName);
//		}
//		if(scrElemHm.containsKey(colTechName) && sysDynTableDetVO.getPRIMARY_KEY().intValue() == 1)
//		{
//		    inputString = (String) scrElemHm.get(sysDynTableDetVO.getCOL_TECH_NAME());
//		    
//		    columnType = sysDynTableDetVO.getCOL_TYPE();
//		    columnName = sysDynTableDetVO.getCOL_TECH_NAME();
//		    // format input string based on column type
//		    if(columnType.intValue() == 2 || columnType.intValue() == 5)
//		    {
//			if(inputString.matches("^[a-zA-Z_;'\"]+$"))
//			{
//			    throw new BaseException("Value: " + inputString + "' is not a Date");
//			}
//
//			boolean correctFormat = true;
//			try
//			{
//			    simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
//			    dateFormatted = simpleDateFormat.parse(inputString);
//			}
//			catch(ParseException e)
//			{
//			    correctFormat = false;
//			}
//			
//			if(!correctFormat)
//			{
//			    try
//			    {
//				desiredFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
//				dateFormatted = desiredFormat.parse(inputString);
//				correctFormat = true;
//			    }
//			    catch(ParseException e)
//			    {
//				correctFormat = false;
//			    }
//			}
//			
//			if(!correctFormat)
//			{
//			    try
//			    {
//				desiredFormat = new SimpleDateFormat("dd/MM/yyyy");
//				dateFormatted = desiredFormat.parse(inputString);
//				correctFormat = true;
//			    }
//			    catch(ParseException e)
//			    {
//				correctFormat = false;
//			    }
//			}
//			pkColValHm.put(columnName, dateFormatted);
//		    }
//		    else if(columnType.intValue() == 3 || columnType.intValue() == 4)
//		    {
//			if(!NumberUtil.isNumber(inputString))
//			{
//			    throw new BaseException("Value " + inputString + "' is not Number");
//			}
//			inputString = inputString.isEmpty() ? null : inputString;
//			BigDecimal inputBigdecimal = new BigDecimal(inputString);
//			pkColValHm.put(columnName, inputBigdecimal);
//		    }
//		    else
//		    {
//			pkColValHm.put(columnName, inputString);
//		    }
//		}
//		
//	    }
//	    
//	    queryColList.add("DATE_UPDATED");
//	    
//	    List<LinkedHashMap> dynGridList = null;
//	    if(!dynScrCreatorList.isEmpty()){
//		    String queryData = "SELECT " + StringUtil.returnStringFromArray(queryColList, ",") + " FROM "
//			    + dynScrCreatorList.get(0).getScrTableTechName() + " WHERE ";
//		    criteria.setQueryData(queryData);
//		    criteria.setRecToskip(0);
//		    criteria.setNbRec(1);
//		    criteria.setPkColValHm(pkColValHm);
//		    // ** return the collection of records
//		    dynGridList = dynamicScreenBO.returnDynGridListRecords(criteria);
//	    }
//
//	    if(dynGridList != null && !dynGridList.isEmpty())
//	    {
//		tableRowMap = dynGridList.get(0);
//	    }
//	    else if((dynGridList == null || dynGridList.isEmpty()) && !dynScrParamMap.isEmpty())
//	    {
//		criteria.setModeType(""); // set mode type to different than load in order to set the scrElemHm.hidden_cu to create
//	    }
//	}
//	else
//	{
//	    criteria.setModeType("");
//	}
//    }
//    
//    for(int i = 0 ; i < dataLst.size();i++)
//	{
//                DynamicScreenCreatorCO dynScreenCreatorCO = dataLst.get(i);
//                if(i == 0)
//                {
//        	    if(!StringUtil.nullToEmpty(dynScreenCreatorCO.getOnLoadScript()).isEmpty())
//        	    {
//        		JSONArray  jsonOnLoadModel = (JSONArray) JSONSerializer.toJSON(dynScreenCreatorCO.getOnLoadScript());
//        		Object[]   onLoadScriptArr = jsonOnLoadModel.toArray();
//        		JSONObject onLoadObj = (JSONObject) onLoadScriptArr[0];
//        		onLoadScript = (String)onLoadObj.get("loadScriptData");
//        		onLoadScript = onLoadScript.replaceAll("\\[formId\\]", "'" +formId+"'").replaceAll("\\[screenId\\]", criteria.getScreenId().toString());
//        	    }
//                }
//		if(i > 0 && !elementId.equals(dynScreenCreatorCO.getElementId()))
//		{
//		    //close the opened css
//		    //fill it into the opened paramVO 
//		    //add paramVO in the list 
//		    // open new paramVO.
//		    paramVO.setCssStyle(cssStyle.toString());
//		    if(StringUtil.nullToEmpty(paramVO.getName()).isEmpty() && !ConstantsCommon.LAYOUT_TYPE_GRID.equals(elementType))
//		    {
//			paramVO.setName("dynElem_".concat(paramVO.getId()));
//		    }
//		    if(ConstantsCommon.LAYOUT_TYPE_DATEPICKER.equals(elementType))
//		    {
//			if(dateProp)
//			{
//			    if(timeProp)
//			    {
//				paramVO.setDateWithTime(ConstantsCommon.TRUE);
//        		    	paramVO.setDateTimeAmPm("true");
//			    }
//			    if(hijriProp)
//			    {
//				paramVO.setShowHijri(ConstantsCommon.TRUE);
//			    }
//			}
//			else
//			{
//			    if(timeProp)
//			    {
//				//timePicker
//				//paramVO.setDateWithTime(ConstantsCommon.TRUE);
//			    }
//			    if(hijriProp)
//			    {
//				paramVO.setShowHijri(ConstantsCommon.TRUE);
//				paramVO.setShowOnlyHijri(ConstantsCommon.TRUE);
//			    }
//			    
//			}
//		    }
//		    else if(ConstantsCommon.LAYOUT_TYPE_GRID.equals(elementType))
//		    {
//			if(tempPropertiesHm.get(ConstantsCommon.PROPERTY_CODE_TABLE_NAME)!=null)
//			{
//			    DynamicScreenCreatorCO prevDynScreenCreatorCO = dataLst.get(i-1);
//			    fillGridWidgetFromDynTableProperty(prevDynScreenCreatorCO, paramVO);
//			}
//			tempPropertiesHm = new HashMap<String,String>();
//		    }
////		    defineDynamicParamValue(dynScrParamMap,paramVO, elementId);
//		    if(!tableRowMap.isEmpty() && tableRowMap.containsKey(paramVO.getName().replace("scrElemHm.", "").toUpperCase()))
//		    {
//			if(paramVO.getValue().isEmpty()){
//		    	String theKey = paramVO.getName().replace("scrElemHm.", "").toUpperCase();
//		    	tableRowMap.get(theKey);
//		    	Object theValue = tableRowMap.get(theKey);
//		    	String value = "";
//		    	if(theValue!=null)
//		    	{
//		    	    value = ""+theValue;
//		    	}
//		    	// format date from db in order to be compatible with datepicker
//		    	if(ConstantsCommon.LAYOUT_TYPE_DATEPICKER.equals(elementType) && !value.isEmpty())
//		    	{
//        		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        		    	Date tempDate = sdf.parse(value);
//        		    	sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        		    	value = sdf.format(tempDate);
//		    	}
//		    	paramVO.setValue(value);
//			}
//		    	if(scrElemHm.containsKey(paramVO.getName().replace("scrElemHm.", "").toUpperCase())  )
//		    	{
//		    		paramVO.setReadOnly(ConstantsCommon.TRUE);
//		    	}
//		    }
//		    formLst.add(paramVO);
//		    cssStyle            = new StringBuffer();
//		    dependencyList      = new StringBuffer();
//		    dependencyParamList = new StringBuffer();
//		    descDependency	= new StringBuffer();
//                    descDepParam	= new StringBuffer();
//		    dateProp        = false;
//		    timeProp        = false;
//		    hijriProp       = false;
//		    paramVO         = new DynamicParamsVO();
//		    newElement      = true;
//		    displayMgntDone = false;
//		    expressionExist = false;
//		}
//		if(newElement)
//		{
//                    elementId = dynScreenCreatorCO.getElementId();
//                    defineDynamicParamValue(dynScrParamMap,paramVO, elementId);
//                    elementType = ConstantsCommon.ELEMENT_LAYOUT_TYPE_MAP.get(Integer.valueOf(dynScreenCreatorCO.getElementType().intValue()));
//                    paramVO.setElement_type(elementType);
//                    if(dynScreenCreatorCO.getTechId()!=null)
//                    {
//                	paramVO.setTechId(dynScreenCreatorCO.getTechId());
//                    }
//                    if(dynScreenCreatorCO.getParentTechId()!=null)
//                    {
//                	paramVO.setParentTechId(dynScreenCreatorCO.getParentTechId());
//                    }
//                    
//                    currId = dynScreenCreatorCO.getTheId();
//                    if(!StringUtil.nullToEmpty(currId).isEmpty())
//                    {
//                      prodIds.add(currId);
//                    }
//                    if(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(elementType))
//                    {
//                            _theElemId = "lookuptxt_"+currId+_addPageRef;
//                    }
//            	    else
//            	   {
//            	    _theElemId = currId+_addPageRef;
//            	   }
//            	
//                   if(ConstantsCommon.ELEMENT_LAYOUT_TYPE_MAP.get(Integer.valueOf(6)).equals(paramVO.getElement_type()))
//                   {
//                	   paramVO.setValOpt("1:0");
//                   }
//    
//                   paramVO.setId((StringUtil.nullToEmpty(currId).isEmpty()?""+elementId:currId).concat(_addPageRef));
//                    
//                   paramVO.setRow(0);
//                   paramVO.setColumn(0);
//                   newElement = false;
//		}
//		
//		String propertyCode     = dynScreenCreatorCO.getProperty_code();
//		String propertyValue    = dynScreenCreatorCO.getProperty_value();
//		String propertyBigValue = dynScreenCreatorCO.getProperty_big_value();
//		
//		// Adel - added checking if grid widget, do not enter this condition as it is not needed 
//		if(!StringUtil.nullToEmpty(currId).isEmpty() && !ConstantsCommon.LAYOUT_TYPE_GRID.equals(elementType))
//		{
//		    dependencyList = new StringBuffer();
//		    dependencyParamList = new StringBuffer();
//		    descDependency = new StringBuffer();
//		    descDepParam = new StringBuffer();
//
//		    if(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(elementType))
//		    {
//    		    	String lookupDesc = dynScreenCreatorCO.getLookupDesc();
//    		    	if(!StringUtil.nullToEmpty(lookupDesc).isEmpty())
//    		    	{
//        		  StringBuffer addToLiveSrchParam = new StringBuffer();
//            		  StringBuffer addToLiveSrchDep  = new StringBuffer(); 
//    		    	    
//    		    	  addToLiveSrchParam.append(",").append("criteria.elemHm.queryDesc").append(":").append("~CONST_").append(lookupDesc);
//    		    	  addToLiveSrchDep.append(",").append(lookupDesc).append(_addPageRef).append(":").append("criteria.elemHm." + lookupDesc);
//			  descDeps.put(currId,addToLiveSrchDep);
//			  descDepPars.put(currId,addToLiveSrchParam);    		    	  
//    		    	}
//			
//		    }
//		    
//		    String lookupDescriptor = "";
//		    if(ConstantsCommon.PROPERTY_CODE_LOOKUPDESC.equals(dataLst.get(i).getProperty_code())
//			    && StringUtil.isNotEmpty(dataLst.get(i).getProperty_value()))
//		    {
//			lookupDescriptor = dataLst.get(i).getProperty_value();
//		    }
//		    for(int j = 0; j < dataLst.size(); j++)
//		    {
//			String currElemType = ConstantsCommon.ELEMENT_LAYOUT_TYPE_MAP
//				.get(Integer.valueOf(dataLst.get(j).getElementType().intValue()));
//			if(ConstantsCommon.LAYOUT_TYPE_TEXTFIELD.equals(elementType)
//				&& ConstantsCommon.PROPERTY_CODE_LOOKUPDESC.equals(dataLst.get(j).getProperty_code())
//				&& dynScreenCreatorCO.getTheId().equals(dataLst.get(j).getProperty_value()))
//			{
//			    if(ConstantsCommon.PROPERTY_CODE_READONLY.equals(propertyCode))
//			    {
//				paramVO.setReadOnly(ConstantsCommon.TRUE);
//			    }
//			}
//			if(!elementId.equals(dataLst.get(j).getElementId())
//				&& !StringUtil.nullToEmpty(dataLst.get(j).getProperty_big_value()).isEmpty()
//				&& dataLst.get(j).getProperty_big_value().contains(currId)
//				&& !ConstantsCommon.PROPERTY_CODE_QUERY.equals(dataLst.get(j).getProperty_code())
//				&& !ConstantsCommon.PROPERTY_CODE_OPTIONS.equals(dataLst.get(j).getProperty_code())
//				&& !ConstantsCommon.PROPERTY_CODE_SOURCE.equals(dataLst.get(j).getProperty_code()))
//			{
//			    String currElemId = dataLst.get(j).getTheId();
//			    if(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(currElemType))
//			    {
//				currElemId = "lookuptxt_" + dataLst.get(j).getTheId();
//			    }
//			    if(dependencyList.length() == 0 && !"Query".equals(queryDepPassed.get(currId)))
//			    {
//				dependencyList.append(currElemId).append(_addPageRef).append(":")
//					.append("criteria.elemHm." + dataLst.get(j).getTheId());
//				if(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(elementType))
//				{
//				    dependencyList.append(StringUtil.nullToEmpty(descDeps.get(currId)));
//				}
//			    }
//
//			    if(dependencyParamList.length() == 0 && !"Query".equals(queryDepPassed.get(currId)))
//			    {
//				dependencyParamList.append("screenId:").append("~CONST_").append(criteria.getScreenId())
//					.append(",").append("elementId:").append("'" + currId + "'");
//				dependencyParamList.append(",elemHm.").append(currId).append(":").append(_theElemId);
//				dependencyParamList.append(",").append("elemHm." + dataLst.get(j).getTheId())
//					.append(":").append(currElemId).append(_addPageRef);
//				if(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(elementType))
//				{
//				    dependencyParamList.append(",").append("criteria.elemHm.queryDep").append(":")
//					    .append("~CONST_").append(dynScreenCreatorCO.getElementId());
//				    dependencyParamList.append(",").append("criteria.elemHm.queryCond").append(":")
//					    .append(currId);
//				    if(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(currElemType))
//				    {
//					dependencyParamList.append(",").append("criteria.elemHm.currDep").append(":")
//						.append("'" + "lookuptxt_" + dataLst.get(j).getTheId() + "'");
//				    }
//				    dependencyParamList.append(StringUtil.nullToEmpty(descDepPars.get(currId)));
//				    expressionExist = true;
//				}
//			    }
//			    /**
//			     * to catch all the variables that are exists inside
//			     * the current expression not the element that is
//			     * under construction and the current element.
//			     */
//			    String currExpression = dataLst.get(j).getProperty_big_value();
//			    String currExpPtrn = "(?!AND)(?!OR)(?!and)(?!or)\\w+(\\w)\\w+";
//			    Pattern p = Pattern.compile(currExpPtrn);
//			    Matcher matcher = p.matcher(currExpression);
//			    while(matcher.find())
//			    {
//				String currExpArg = matcher.group();
//				String currArgId = "";
//				if(dependencyParamList != null)
//				{
//				    String depParamListStr = dependencyParamList.toString();
//				    if(depParamListStr.length() > 0 && !depParamListStr.contains(currExpArg))
//				    {
//					/**
//					 * will try to remove this loop by
//					 * changing the query or use collection
//					 * inside the Mapper
//					 */
//					for(int k = 0; k < dataLst.size(); k++)
//					{
//					    if(currExpArg.equals(dataLst.get(k).getTheId()))
//					    {
//						String curElemTyp = ConstantsCommon.ELEMENT_LAYOUT_TYPE_MAP.get(
//							Integer.valueOf(dataLst.get(k).getElementType().intValue()));
//						if(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(curElemTyp))
//						{
//						    currArgId = "lookuptxt_" + currExpArg;
//						}
//						else
//						{
//						    currArgId = currExpArg;
//						}
//						dependencyParamList.append(",").append("elemHm.").append(currExpArg)
//							.append(":").append(currArgId).append(_addPageRef);
//						break;
//					    }
//					}
//				    }
//				}
//			    }
//			    /**
//			     * END
//			     */
//
//	            	}
//
//			// If the element defined in labelFor is LiveSearch then
//			// prepend "lookuptxt_" to the property value.
//			if(ConstantsCommon.LAYOUT_TYPE_LABEL.equals(elementType)
//				&& ConstantsCommon.PROPERTY_CODE_LABELFOR.equals(dataLst.get(i).getProperty_code())
//				&& dataLst.get(j).getTheId().equals(dataLst.get(i).getProperty_value()))
//			{
//			    if(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(currElemType))
//			    {
//				propertyValue = "lookuptxt_" + dataLst.get(j).getTheId();
//			    }
//			}
//		    }
//		    if(dependencyList.length() > 0 && dependencyParamList.length() > 0
//			    && !"Query".equals(queryDepPassed.get(currId)))
//
//		    {
//			paramVO.setDependency(dependencyList.toString());
//			paramVO.setParameters(dependencyParamList.toString());
//			paramVO.setDependencySrc("/path/dynamicScreen/dynDependencyAction_dynDependenciesProcess?");
//		    }
//		}
//		
//		//Adel - Separate grid behavior from other widgets
//		//Each property that needs to have Separate behavior is added here
//		if(ConstantsCommon.LAYOUT_TYPE_GRID.equals(elementType)
//			&& (ConstantsCommon.PROPERTY_CODE_TABLE_NAME.equals(propertyCode)
//				|| ConstantsCommon.PROPERTY_CODE_QUERY.equals(propertyCode)
//				|| ConstantsCommon.PROPERTY_CODE_EDITABLE.equals(propertyCode)
//				|| ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode)
//				|| ConstantsCommon.PROPERTY_CODE_DBL_CLICK.equals(propertyCode)
//				|| ConstantsCommon.PROPERTY_CODE_COLPROPS.equals(propertyCode)))
//		{
//                    fillGridWidgetProperties(dynScreenCreatorCO,paramVO,gridUpdateIds,null);
//                }
//		else if(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH.equals(elementType) && ConstantsCommon.PROPERTY_CODE_QUERY.equals(propertyCode))
//		{
//		    jsonModel = (JSONArray) JSONSerializer.toJSON(dynScreenCreatorCO.getProperty_big_value());
//		    modelArr  = jsonModel.toArray();
//		    obj       = (JSONObject) modelArr[0];
//		    paramList = new StringBuffer();
//		    StringBuffer depParamNoExpr = new StringBuffer();
//		    resultList = new StringBuffer();
//		    
//		    columnCode   = obj.getString("columnCode");
//		    columnDesc   = obj.getString("columnDesc");
//		    querySynthax = obj.getString("querySynthax");
//		    
//		    
//		    Pattern p = Pattern.compile(findParamPattern);
//		    Matcher matcher = p.matcher(querySynthax);
//		    
//		    paramList.append("screenId:").append("~CONST_").append(criteria.getScreenId());
//		    paramList.append(",").append("elementId:").append("~CONST_").append(elementId);
//		    
//		    depParamNoExpr.append("screenId:").append("~CONST_").append(criteria.getScreenId());
//		    depParamNoExpr.append(",").append("elementId:").append("'" + currId + "'");
//
//		    StringBuffer queryArgsList = new StringBuffer();
//		    while (matcher.find())
//		    {
//			String currParam = matcher.group();
//			currParam = currParam.substring(1, currParam.length());
//			criteria.setParamId(currParam);
//			BigDecimal paramType = returnParamType(currParam,dataLst);
//			/**
//			 * in case the parameter that is exists in the query is a LiveSearch
//			 * we have to add 'lookuptxt_' to the id when we add it to the paramList
//			 */
//			String currElemId = currParam;
//			if(ConstantsCommon.LIVESEARCH_ELEMENT_TYPE.equals(paramType))
//			{
//			    currElemId = "lookuptxt_".concat(currParam); 
//			}
//			queryArgsList.append(",").append("elemHm.").append(currParam).append(":").append(currElemId+_addPageRef);
//			paramList.append(",").append("elemHm.").append(currParam).append(":").append(currElemId+_addPageRef);
//			depParamNoExpr.append(",").append("elemHm.").append(currParam).append(":").append(currElemId+_addPageRef);
//		    }
//		    if(expressionExist)
//    		    {
//    			dependencyParamList.append(queryArgsList);
//    			dependencyList.append(",").append(_theElemId).append(":").append("criteria.elemHm."+currId);
//    		    }
//    		    else
//    		    {
//    			StringBuffer addToLiveSrchParam = new StringBuffer();
//    		    	StringBuffer addToLiveSrchDep  = new StringBuffer(); 
//    		    	String lookupDesc = dynScreenCreatorCO.getLookupDesc();
//    		    	if(!StringUtil.nullToEmpty(lookupDesc).isEmpty())
//    		    	{            				
//    		    		addToLiveSrchParam.append(",").append("criteria.elemHm.queryDesc").append(":").append("~CONST_").append(lookupDesc);
//    		    		addToLiveSrchDep.append(",").append(lookupDesc).append(_addPageRef).append(":").append("criteria.elemHm." + lookupDesc);    		    		
//    		    	}
//    			dependencyParamList.append(depParamNoExpr);
//    			dependencyList.append(_theElemId).append(":").append("criteria.elemHm."+currId);
//    			
//    			if(StringUtil.nullToEmpty(descDeps.get(currId)).isEmpty())
//    			{
//    			    if(addToLiveSrchDep != null && addToLiveSrchDep.length() > 0)
//    			    {
//    				dependencyList.append(addToLiveSrchDep);
//    			    }
//    			}
//    			else
//    			{
//    			    dependencyList.append(StringUtil.nullToEmpty(descDeps.get(currId)));
//    			}
//
//            		dependencyParamList.append(",criteria.elemHm.").append(currId).append(":").append(_theElemId);
//            		dependencyParamList.append(",").append("criteria.elemHm.queryDep").append(":").append("~CONST_").append(dynScreenCreatorCO.getElementId());
//            		dependencyParamList.append(",").append("criteria.elemHm.queryCond").append(":").append(currId);
//            		
//            		if(StringUtil.nullToEmpty(descDepPars.get(currId)).isEmpty())
//			{
//			    if(addToLiveSrchParam != null && addToLiveSrchParam.length() > 0)
//			    {
//				dependencyParamList.append(addToLiveSrchParam);
//			    }
//			}
//			else
//			{
//			    dependencyParamList.append(StringUtil.nullToEmpty(descDepPars.get(currId)));
//			}
//            		
//    		    }
//		    paramVO.setDependency(dependencyList.toString());
//		    paramVO.setParameters(dependencyParamList.toString());
//		    paramVO.setDependencySrc("/path/dynamicScreen/dynDependencyAction_dynDependenciesProcess?");
//
//		    paramVO.setParamList(paramList.toString());
//		    paramVO.setActionName("/path/dynamicScreen/dynLookupAction_constructQryLookup?");
//		    resultList.append(StringUtil.isNotEmpty(resultList.toString())?",":"").append(columnCode).append(":").append(_theElemId);
//		    paramVO.setResultList(resultList.toString());
//		    paramVO.setSearchElement(columnCode);
//		    queryDepPassed.put(currId, "Query");
//		}
//		else if(ConstantsCommon.LAYOUT_TYPE_BUTTON.equals(elementType) && ConstantsCommon.PROPERTY_CODE_SOURCE.equals(propertyCode))
//		{
//		    jsonModel = (JSONArray) JSONSerializer.toJSON(dynScreenCreatorCO.getProperty_big_value());
//		    modelArr  = jsonModel.toArray();
//		    obj       = (JSONObject) modelArr[0];
//		    paramList = new StringBuffer();
//		    //in case of _recReadOnly to set the button disabled
//		    if("true".equals(get_recReadOnly()))
//		    {
//			paramVO.setReadOnly("true");
//		    }
//		    sourceType = obj.getString("sourceType");
//		    if(ConstantsCommon.INTERNAL_SCREEN_BTN_SOURCE.equals(sourceType))
//		    {
//			String sourceScreenId = obj.getString("sourceScreenId");
//			
//			int sourceScreenWidth  = (obj.containsKey("sourceScreenWidth") && !StringUtil.nullToEmpty(obj.getString("sourceScreenWidth")).isEmpty())?obj.getInt("sourceScreenWidth"):400;
//			int sourceScreenHeight = (obj.containsKey("sourceScreenHeight") && !StringUtil.nullToEmpty(obj.getString("sourceScreenHeight")).isEmpty())?obj.getInt("sourceScreenHeight"):600;
//			paramVO.setOnClick("dynamicScreen_openDynamicScreen('"+sourceScreenId+"', null, '" + paramVO.getId() + "'," + sourceScreenWidth + "," + sourceScreenHeight + ",null,null)");
//			DynamicScreenParamsMapSC criteria = new DynamicScreenParamsMapSC();
//			criteria.setMapElementType(DynamicScreenConstant.MAP_ELEMENT_TYPE.DYN_BTN_LINK_TO_DYN_SCREEN.getValue());
//			criteria.setElementIdentifier(dynScreenCreatorCO.getElementId());
//			criteria.setElementOpId(new BigDecimal(sourceScreenId));
//			List<DynamicScreenParamsMapCO> paramMapList = returnCommonLibBO().returnDynScreenMappedParameters(criteria);
//			if(paramMapList != null && !paramMapList.isEmpty())
//			{
//			    DynamicParamsVO hideDynScreenMappedData = new DynamicParamsVO();
//			    hideDynScreenMappedData.setId(paramVO.getId()+"_dynScreenMappedParameters");
//			    hideDynScreenMappedData.setElement_type(HIDDEN_ELEMENT);
//			    hideDynScreenMappedData.setRow(0);
//			    hideDynScreenMappedData.setColumn(0);
//			    hideDynScreenMappedData.setValue(PathJSONUtil.strutsJsonSerialize(paramMapList, null, null, false, true));
//	        	    formLst.add(hideDynScreenMappedData);
//			}
//		    }
//		    else if(ConstantsCommon.SCRIPT_BTN_SOURCE.equals(sourceType))
//		    {
//			String sourceScriptData = obj.getString("sourceScriptData");
//	        	if(!StringUtil.nullToEmpty(sourceScriptData).isEmpty())
//	        	{
//	        	    //471675 added buttonFunction to handle button scripts.
//	        	    String buttonFunction = "dynamicScreen_excute_"+paramVO.getId()+"()";
//	        	    paramVO.setOnClick(buttonFunction);
//	        	    if(StringUtil.isNotEmpty(_addPageRef))
//	        	    {
//	        		/**
//	        		 * in case there is a progref, catch all the parameters that are used inside the script 
//	        		 * and add _progRef to the used Ids
//	        		 */
//        	        	String scriptParamPattern = "(#\\w+)";
//        			Pattern scriptDataPattern = Pattern.compile(scriptParamPattern);
//        			Matcher matcher = scriptDataPattern.matcher(sourceScriptData);
//                	        List<String> passedElemsMap = new ArrayList<String>();
//                	        while (matcher.find())
//                	        {
//                	          String currGroup = matcher.group();
//                	          if(!passedElemsMap.contains(currGroup))
//                	          {
//                	            sourceScriptData = sourceScriptData.replace(currGroup,currGroup+_addPageRef);
//                	            passedElemsMap.add(currGroup);
//                	          }
//                	        }
//	        	    }
//	        	    sourceScriptData = sourceScriptData.replaceAll("\\[formId\\]", "'" +formId+"'").replaceAll("\\[screenId\\]", criteria.getScreenId().toString());
//
//	        	    paramVO.setButtonScript("function "+buttonFunction+"{"+sourceScriptData+"}");
//	        	}
//
//		    }
//		    else if(ConstantsCommon.EXTERNEL_BTN_SOURCE.equals(sourceType))
//		    {
//			//to manage the external screen process
//			String sourceGlobalActivityId = obj.getString("sourceGlobalActivityId");
//			paramVO.setOnClick("customBtnActionCall('"+paramVO.getId()+"', null)");
//			
//			Map<String, Object> customBtnDataMap = new HashMap<String, Object>();
//			customBtnDataMap.put("customBtnId", new BigDecimal(sourceGlobalActivityId));
//			customBtnDataMap.put("dynScreenFldIdentifier", dynScreenCreatorCO.getElementId());
//			
//			DynamicParamsVO hideDynScreenMappedData = new DynamicParamsVO();
//			hideDynScreenMappedData.setId(paramVO.getId()+"_customBtnData");
//			hideDynScreenMappedData.setElement_type(HIDDEN_ELEMENT);
//			hideDynScreenMappedData.setRow(0);
//			hideDynScreenMappedData.setColumn(0);
//			hideDynScreenMappedData.setValue(PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true));
//	        	formLst.add(hideDynScreenMappedData);
//			
//		    }
//		    // Added by Adel to cover submit button
//		    else if(ConstantsCommon.SUBMIT_BTN_SOURCE.equals(sourceType))
//		    {
//				paramVO.setOnClick("dynScreenProcessAfterValidate('"+formId+"','" +criteria.getScreenId()+ "')");
//		    }
//		    // Added by Adel to cover delete button
//		    else if(ConstantsCommon.DELETE_BTN_SOURCE.equals(sourceType))
//		    {
//			    if(ConstantsCommon.ON_LOAD_MODE.equals(criteria.getModeType()))
//			    {
//			    	paramVO.setVisible(ConstantsCommon.TRUE);
//			    }
//			    else
//			    {
//			    	paramVO.setVisible(ConstantsCommon.FALSE);
//			    }
//				paramVO.setOnClick("dynamicScreenOnBtnDelete('"+formId+"','" +criteria.getScreenId()+ "')");
//		    }
//		}
//		else if(ConstantsCommon.LAYOUT_TYPE_BUTTON.equals(elementType) && ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode) && !StringUtil.nullToEmpty(propertyValue).isEmpty())
//		{		    
//		    paramVO.setLabel(getText(propertyValue));
//		}
//		else if((ConstantsCommon.LAYOUT_TYPE_RADIOBUTTON.equals(elementType) || ConstantsCommon.LAYOUT_TYPE_COMBOBOX.equals(elementType)) && ConstantsCommon.PROPERTY_CODE_OPTIONS.equals(propertyCode))
//		{
//		    setHasHiddenOpt(ConstantsCommon.ZERO);
//		    String defaultValue = fillOptionsDataList(paramVO.getId(),dynScreenCreatorCO.getProperty_big_value(),elementType);
//		    ListParamVO lstParamVO = new ListParamVO();
//		    lstParamVO.setValueList("optionsDataMap."+paramVO.getId()+"_lst");
//		    lstParamVO.setKey("code");
//		    lstParamVO.setValue("descValue");
//		    if(!StringUtil.nullToEmpty(hasHiddenOpt).isEmpty() && ConstantsCommon.ONE.equals(hasHiddenOpt))
//		    {			
//			lstParamVO.setHasHiddenOpt(hasHiddenOpt);
//		    }
//		    else
//		    {
//			lstParamVO.setHasHiddenOpt(ConstantsCommon.ZERO);
//		    }
//		    paramVO.setListParamVO(lstParamVO);
//		    if(StringUtil.nullToEmpty(defaultValue).isEmpty())
//		    {
//			paramVO.setEmptyOption(ConstantsCommon.TRUE);
//		    }
//		    else
//		    {			
//			paramVO.setValue(defaultValue);
//			paramVO.setConsiderChoiceValue(ConstantsCommon.TRUE);
//		    }
//		    
//		}
//		else if(ConstantsCommon.LAYOUT_TYPE_RADIOBUTTON.equals(elementType) && ConstantsCommon.PROPERTY_CODE_GROUP_LABEL.equals(propertyCode)
//			&&!StringUtil.nullToEmpty(propertyValue).isEmpty())
// 	        {
// 		   paramVO.setGroupLabel(propertyValue);
//		}
//		else if(ConstantsCommon.LAYOUT_TYPE_DATEPICKER.equals(elementType) && (ConstantsCommon.PROPERTY_CODE_TIME.equals(propertyCode) || ConstantsCommon.PROPERTY_CODE_DATE.equals(propertyCode) || ConstantsCommon.PROPERTY_CODE_HIJRI.equals(propertyCode)))
//		{
//		    if(ConstantsCommon.ONE.equals(propertyValue))
//		    {			
//			if(ConstantsCommon.PROPERTY_CODE_TIME.equals(propertyCode))
//			{
//			    timeProp = true;
//			}
//			else if (ConstantsCommon.PROPERTY_CODE_DATE.equals(propertyCode))
//			{
//			    String initFormat = DateUtil.getDatePattern(paramVO.getValue());
//			    if(initFormat!=null){
//				    Date initDate = new SimpleDateFormat(initFormat).parse(paramVO.getValue());
//				    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//				    paramVO.setValue(formatter.format(initDate));
//			    }
//			    dateProp = true;
//			}
//			else
//			{
//			    hijriProp = true;
//			}
//		    }
//			
//		}
//		else if(ConstantsCommon.PROPERTY_CODE_TOP.equals(propertyCode)
//			|| ConstantsCommon.PROPERTY_CODE_LEFT.equals(propertyCode)
//			|| ConstantsCommon.PROPERTY_CODE_WIDTH.equals(propertyCode)
//			|| ConstantsCommon.PROPERTY_CODE_HEIGHT.equals(propertyCode))
//		{
//		    pxStr = "px";
//    		    /**
//    		     * [MarwanMaddah]
//    		     * Alignment Management
//    		     */
//    		    currAttr = (ConstantsCommon.PROPERTY_CODE_LEFT.equals(propertyCode) && sessionCO.getIsRTLDir()==1)?"right":propertyCode;
//
//		    attrValue = (ConstantsCommon.PROPERTY_CODE_TOP.equals(propertyCode)
//			    && dynScreenCreatorCO.getParentTechId() != null)
//				    ? String.valueOf((new BigDecimal(propertyValue)).intValue() + 20) : propertyValue;
//		    if(!StringUtil.nullToEmpty(currAttr).isEmpty())
//		    {
//			if(ConstantsCommon.PROPERTY_CODE_HEIGHT.equals(propertyCode))
//			{
//			    paramVO.setHeight(attrValue);
//			}
//			if(cssStyle.length() == 0)
//			{
//			    paramVO.setPositionAbsolute(true);
//			    if(!ConstantsCommon.LAYOUT_TYPE_DATEPICKER.equals(elementType) && !ConstantsCommon.LAYOUT_TYPE_FILE.equals(elementType))
//			    {
//				cssStyle.append("position:absolute;");
//			    }
//			    cssStyle.append(" ").append(currAttr + ":" + attrValue + pxStr + ";");
//			}
//			else
//			{
//			    cssStyle.append(" ").append(currAttr + ":" + attrValue + pxStr + ";");
//			}
//		    }
//		}
//    		else
//    		{
//    		   /**
//    		    *  Set the value of the related property
//    		    */
//    		   if((ConstantsCommon.PROPERTY_CODE_READONLY.equals(propertyCode) || ConstantsCommon.PROPERTY_CODE_REQUIRED.equals(propertyCode) || ConstantsCommon.PROPERTY_CODE_VISIBLE.equals(propertyCode) || ConstantsCommon.PROPERTY_CODE_VALIDATE.equals(propertyCode) || ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode)) && !StringUtil.nullToEmpty(propertyBigValue).isEmpty())
//    		   {
//    		        if(StringUtil.nullToEmpty(paramVO.getDependencySrc()).isEmpty() && ConstantsCommon.PROPERTY_CODE_VALIDATE.equals(propertyCode))
//    		        {
//    		            paramVO.setDependencySrc("/path/dynamicScreen/dynDependencyAction_dynDependenciesProcess?");
//    		            paramVO.setParameters("screenId:~CONST_"+criteria.getScreenId()+",elementId:'"+currId+"',elemHm."+currId+":"+_theElemId);
//    		            paramVO.setDependency(_theElemId+":criteria.elemHm."+currId);
//    		        }
//			try
//			{
//			    /**
//			     * [MarwanMaddah]:
//			     * in case The expression is on the value expression 
//			     * the execute expression result, will not be forced as boolean
//			     */
//			    if(ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode))
//			    {
//				criteria.setValueExpression(true);
//			    }
//			    else
//			    {
//				criteria.setValueExpression(false);
//			    }
//			    Object expressionResult  = dynamicScreenBO.executeCurrentExpression(criteria,dynScrParamMap,paramVO,propertyBigValue);
//			    if(ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode) && expressionResult!=null)
//			    {
//				if(MODE_NUMBER.equals(dynScreenCreatorCO.getCurrElemMode()) || (!StringUtil.nullToEmpty(dynScreenCreatorCO.getCurrElemMode()).isEmpty() && expressionResult instanceof BigDecimal))
//				{
//				    BigDecimal resultObj = (BigDecimal)expressionResult;
//				    if(NumberUtil.emptyDecimalToNull(resultObj)!=null)
//				    {					
//					paramVO.setValue(new String(""+resultObj.intValue()));
//				    }
//				}
//				else if(!StringUtil.nullToEmpty(dynScreenCreatorCO.getCurrElemMode()).isEmpty())
//				{
//				    paramVO.setValue((String)expressionResult);
//				}
//			    }
//			    else
//			    {
//				elemExprResult = (BigDecimal)expressionResult;
//			    }
//			}
//			catch(Exception ex)
//			{
//			    handleException(ex, null, null);
//			    log.error(ex, "************: Error in load preview screen process executeCurrentExpression");
//			    //Commented since freemarker template is generating an error.
//			    //throw new BOException(MessageCodes.INVALID_MISSING,new String[] {_theElemId, propertyCode});
//			}
//    		            if(BigDecimal.ONE.equals(elemExprResult))
//    		            {    		        	
//    		        	if(ConstantsCommon.PROPERTY_CODE_READONLY.equals(propertyCode))
//    		        	{
//    		        	    paramVO.setReadOnly(ConstantsCommon.TRUE);
//    		        	}
//    		        	if(ConstantsCommon.PROPERTY_CODE_REQUIRED.equals(propertyCode))
//    		        	{
//    		        	    paramVO.setRequired(ConstantsCommon.TRUE);
//    		        	}
//    		            }
//    	                    else if(ConstantsCommon.PROPERTY_CODE_VISIBLE.equals(propertyCode))
//    	                    {
//    	                        if(cssStyle.length() == 0)
//    	                        {
//    	                              cssStyle.append("display:none;");
//    	                        }
//    	                        else
//    	                        {
//    	                            cssStyle.append(" ").append("display:none;");
//    	                        }
//    	                    }
//
//    		   }
//    		   else if(ConstantsCommon.PROPERTY_CODE_MODE.equals(propertyCode) && Integer.valueOf(propertyValue).intValue()==2)
//        	   {
//		       paramVO.setMode(MODE_NUMBER);
//        	   }
//    		   else if(ConstantsCommon.PROPERTY_CODE_MAXLENGTH.equals(propertyCode) && propertyValue!=null  && propertyValue.trim().length()>0)
//    		   {
//    		       paramVO.setMaxLength(Integer.valueOf(propertyValue));
//    		   }
//        	   else if(ConstantsCommon.LAYOUT_TYPE_LABEL.equals(elementType))
//    		   {
//        	       if(ConstantsCommon.PROPERTY_CODE_VALUE.equals(propertyCode))
//        	       {
//        		   paramVO.setLabel(propertyValue);
//        	       }
//        	       if(ConstantsCommon.PROPERTY_CODE_LABELFOR.equals(propertyCode) && !StringUtil.nullToEmpty(propertyValue).isEmpty())
//        	       {
//        		   String propVal = propertyValue+_addPageRef;
//        		   paramVO.setLabelForElemId(propVal);
//        	       }
//    		   }
//        	   else if(ConstantsCommon.PROPERTY_CODE_TITLE.equals(propertyCode) && StringUtil.isNotEmpty(propertyValue))
//        	   {
//        	       paramVO.setTitle(getText(propertyValue));
//        	   }
//        	   else if(ConstantsCommon.PROPERTY_CODE_NBFORMAT.equals(propertyCode) && StringUtil.isNotEmpty(propertyValue))
//        	   {
//        	       String currElemMode = dynScreenCreatorCO.getCurrElemMode();
//        	       
//        	       String formatPattern  = "[a-zA-Z1-9]+";
//        	       Pattern formatPtrn = Pattern.compile(formatPattern);
//        	       Matcher formatmatcher = formatPtrn.matcher(propertyValue);
//        	       if(!formatmatcher.find())
//        	       {        		   
//        		   if(ConstantsCommon.DYN_ELEM_MODE_NUMERIC.equals(currElemMode))
//        		   {
//        		       paramVO.setNbFormat(propertyValue); 
//        		   }
//        		   else
//        		   {
//        		       paramVO.setTxtFormat(propertyValue);
//        		   }
//        	       }
//        	       
//        	   }
//        	   else if(ConstantsCommon.PROPERTY_CODE_NBFRMTTER.equals(propertyCode))
//        	   {
//        	       String currElemMode = dynScreenCreatorCO.getCurrElemMode();
//        	       if(ConstantsCommon.DYN_ELEM_MODE_NUMERIC.equals(currElemMode) && ConstantsCommon.ONE.equals(propertyValue))
//        	       {
//        		   paramVO.setFormatter("numberFmatterBrackets");
//        	       }
//        	   }
//        	   else if(ConstantsCommon.PROPERTY_CODE_NBZRONTALW.equals(propertyCode))
//        	   {
//        	       String currElemMode = dynScreenCreatorCO.getCurrElemMode();
//        	       if(ConstantsCommon.DYN_ELEM_MODE_NUMERIC.equals(currElemMode) && ConstantsCommon.ONE.equals(propertyValue))
//        	       {
//        		   paramVO.setZeroNotAllowed(ConstantsCommon.TRUE);
//        	       }
//        	   }
//        	   else if(ConstantsCommon.PROPERTY_CODE_NBNEGNTALW.equals(propertyCode))
//        	   {
//        	       String currElemMode = dynScreenCreatorCO.getCurrElemMode();
//        	       if(ConstantsCommon.DYN_ELEM_MODE_NUMERIC.equals(currElemMode) && ConstantsCommon.ONE.equals(propertyValue))
//        	       {
//        		   paramVO.setMinValue(BigDecimal.ZERO);
//        	       }
//        	   }
//        	   else if(ConstantsCommon.PROPERTY_CODE_NAME.equals(propertyCode)&& StringUtil.isNotEmpty(propertyValue))
//        	   {
//			if(ConstantsCommon.LAYOUT_TYPE_FILE.equals(paramVO.getElement_type()))
//			{
//			    //name is dynamicFileCO + uploadFile < variable inside dynamicFileCO
//			    paramVO.setName("dynFileElemHm.".concat(propertyValue)+".uploadFile");
//			}
//			else
//			{
//			    if(scrGridFlag.compareTo(BigDecimal.ZERO)>0)
//			    {
//			        paramVO.setName("scrElemHm.".concat(propertyValue));
//			    }
//			    else
//			    {
//				paramVO.setName(propertyValue);
//			    }
//			
//			}
//        	   }
//        	   else if(ConstantsCommon.PROPERTY_CODE_FILE_NAME.equals(propertyCode)&& StringUtil.isNotEmpty(propertyValue))
//        	   {
//			    paramVO.setOnClick("dynamicScreen_downloadDynFile('"+formId+"','" 
//				    		+criteria.getScreenId()+"','"+ paramVO.getId()+"','"+ propertyValue +"')");
//        	   }
//    		   else
//    		   {
//    		       if(StringUtil.isNotEmpty(propertyValue) && !ConstantsCommon.PROPERTY_CODE_ID.equals(propertyCode) && !ConstantsCommon.PROPERTY_CODE_READONLY.equals(propertyCode) && !ConstantsCommon.PROPERTY_CODE_REQUIRED.equals(propertyCode) && !ConstantsCommon.PROPERTY_CODE_VISIBLE.equals(propertyCode) && !ConstantsCommon.PROPERTY_CODE_VALIDATE.equals(propertyCode) && !ConstantsCommon.PROPERTY_CODE_COLNAME.equals(propertyCode))
//    		       {
//    			   stmt = new Statement(paramVO, "set"+StringUtil.setFirstCharUpper(propertyCode), new Object[]{StringUtil.nullToEmpty(propertyValue).isEmpty()?"":propertyValue});
//    		       	   stmt.execute();
//    		       }
//    		   }
//    		}
//		if(i == dataLst.size()-1)
//		{
//		    //close the opened css
//		    //fill it into the opened paramVO 
//		    //add paramVO in the list 
//		    paramVO.setCssStyle(cssStyle.toString());
//		    if(StringUtil.nullToEmpty(paramVO.getName()).isEmpty() && !ConstantsCommon.LAYOUT_TYPE_GRID.equals(elementType))
//		    {
//			paramVO.setName("dynElem_".concat(paramVO.getId()));
//		    }
//		    if(ConstantsCommon.LAYOUT_TYPE_DATEPICKER.equals(elementType))
//		    {
//			if(dateProp)
//			{
//			    if(timeProp)
//			    {
//				paramVO.setDateWithTime(ConstantsCommon.TRUE);
//			    }
//			    if(hijriProp)
//			    {
//				paramVO.setShowHijri(ConstantsCommon.TRUE);
//			    }
//			}
//			else
//			{
//			    if(timeProp)
//			    {
//				//timePicker
//				paramVO.setTimepicker(ConstantsCommon.TRUE);
//				paramVO.setTimepickerOnly(ConstantsCommon.TRUE);
//			    }
//			    if(hijriProp)
//			    {
//				paramVO.setShowHijri(ConstantsCommon.TRUE);
//				paramVO.setShowOnlyHijri(ConstantsCommon.TRUE);
//			    }
//			    
//			}
//		    }
//		    else if(ConstantsCommon.LAYOUT_TYPE_GRID.equals(elementType))
//			{
//			    if(tempPropertiesHm.get(ConstantsCommon.PROPERTY_CODE_TABLE_NAME) != null)
//			    {
//				DynamicScreenCreatorCO prevDynScreenCreatorCO = dataLst.get(i - 1);
//				fillGridWidgetFromDynTableProperty(prevDynScreenCreatorCO, paramVO);
//			    }
//			    tempPropertiesHm = new HashMap<String, String>();
//		    }
////		    defineDynamicParamValue(dynScrParamMap,paramVO, elementId);
//		    if(!tableRowMap.isEmpty() && tableRowMap.containsKey(paramVO.getName().replace("scrElemHm.", "").toUpperCase()))
//		    {
//			if(paramVO.getValue().isEmpty()){
//		    	String value = StringUtil.nullToEmpty(tableRowMap.get(paramVO.getName().replace("scrElemHm.", "").toUpperCase())).toString();
//		    	paramVO.setValue(value);
//			}
//		    	if(scrElemHm.containsKey(paramVO.getName().replace("scrElemHm.", "").toUpperCase())  )
//		    	{
//		    		paramVO.setReadOnly(ConstantsCommon.TRUE);
//		    	}
//		    }
//		    formLst.add(paramVO);
//		}
//	}
//    
//        // add hidden input to identify a new record from updated record
//        paramVO         = new DynamicParamsVO();
//	    paramVO.setId(formId+"_hidden_cuId");// create update
//	    paramVO.setName("scrElemHm.hidden_cu");
//	    if(ConstantsCommon.ON_LOAD_MODE.equals(criteria.getModeType()))
//	    {
//	    	paramVO.setValue("U");//update record
//	    }
//	    else
//	    {
//	    	paramVO.setValue("C");//create new record	    	
//	    }
//	    paramVO.setElement_type(ConstantsCommon.LAYOUT_TYPE_TEXTFIELD);
//	    paramVO.setRow(0);
//	    paramVO.setColumn(0);
//	    paramVO.setVisible(ConstantsCommon.FALSE);
//	    
//	    formLst.add(paramVO);
//	    
//        paramVO         = new DynamicParamsVO();
//	    paramVO.setId(formId+"_date_updated");// create update
//	    paramVO.setName("scrElemHm.DATE_UPDATED");
//	    paramVO.setElement_type(ConstantsCommon.LAYOUT_TYPE_TEXTFIELD);
//	    paramVO.setRow(0);
//	    paramVO.setColumn(0);
//	    paramVO.setVisible(ConstantsCommon.FALSE);
//	    if(!tableRowMap.isEmpty() && tableRowMap.containsKey(paramVO.getName().replace("scrElemHm.", "").toUpperCase()))
//	    {
//		if(paramVO.getValue().isEmpty()){
//	    	String value = (String) tableRowMap.get(paramVO.getName().replace("scrElemHm.", "").toUpperCase()).toString();
//	    	paramVO.setValue(value);
//		}
//	    }
//	    formLst.add(paramVO);
//	    
//	    paramVO         = new DynamicParamsVO();
//	    paramVO.setId(formId+"_gridUpdateIds");// create update
//	    paramVO.setName("gridUpdateIds");
//	    paramVO.setElement_type(ConstantsCommon.LAYOUT_TYPE_TEXTFIELD);
//	    paramVO.setValue(gridUpdateIds.toString());
//	    paramVO.setRow(0);
//	    paramVO.setColumn(0);
//	    paramVO.setVisible(ConstantsCommon.FALSE);
//	    formLst.add(paramVO);
//
//        if(StringUtil.nullToEmpty(onLoadScript).isEmpty())
//        {
//        	fillFormElements(formLst, "",formId, "","true","",Boolean.TRUE);
//        }
//        else
//        {
//            for(int i=0;i<prodIds.size();i++)
//            {
//        	onLoadScript = onLoadScript.replaceAll("\\b"+prodIds.get(i)+"\\b",prodIds.get(i)+_addPageRef);
//            }
//            //Removed assignment of onLoadScript to Hidden element and place it directly in DynamicParams.ftl
//            fillFormElements(formLst, "",formId, "","true",onLoadScript,Boolean.TRUE);
//        }
//        getFormVO().setChangeTrack(StringUtil.nullToEmpty(changeTrack).isEmpty() ? ConstantsCommon.FALSE : changeTrack);
//	}
//	catch(Exception ex)
//	{
//	    ex.printStackTrace();
//	    throw new BaseException(ex);
//	}
//    }
    /**
     * Used to fill the additional screen display map based on the expressions execution.
     * marwanmaddah
     */
    private void fillAdditionalScreenParams()throws Exception
    {
	SessionCO sessionCO  = returnSessionObject();
	/**
	 * fill session variables for execute expressions.
	 */
	HashMap<String,Object> hmSessionExp = new HashMap<String,Object>();
	hmSessionExp.put(ConstantsCommon.USER_ID_EXP_VAR,sessionCO.getUserName());
	hmSessionExp.put(ConstantsCommon.COMP_CODE_EXP_VAR,sessionCO.getCompanyCode());
	hmSessionExp.put(ConstantsCommon.COMP_NAME_EXP_VAR,sessionCO.getCompanyName());
	hmSessionExp.put(ConstantsCommon.BRANCH_CODE_EXP_VAR,sessionCO.getBranchCode());
	hmSessionExp.put(ConstantsCommon.BRANCH_NAME_EXP_VAR,sessionCO.getBranchName());
	hmSessionExp.put(ConstantsCommon.USER_FIRST_NAME_EXP_VAR,sessionCO.getUserFirstName());
	hmSessionExp.put(ConstantsCommon.USER_LAST_NAME_EXP_VAR,sessionCO.getUserLastName());
	hmSessionExp.put(ConstantsCommon.BASE_CURR_NAME_EXP_VAR,sessionCO.getBaseCurrencyName());
	hmSessionExp.put(ConstantsCommon.RUNNING_DATE_VAR,sessionCO.getRunningDateRET());
	
	if(sessionCO.getCtsTellerVO() != null && sessionCO.getCtsTellerVO().getCODE() !=null)
	{
	    hmSessionExp.put(ConstantsCommon.IS_USER_TELLER_EXP_VAR,BigDecimal.ONE);
	}
	
	criteria.setHmSessionExpVals(hmSessionExp);
	criteria.setCurrAppName(sessionCO.getCurrentAppName());
	criteria.setProgRef(StringUtil.nullToEmpty(get_pageRef()).isEmpty()?ConstantsCommon.PROGREF_ROOT:get_pageRef());
	criteria.setCompCode(sessionCO.getCompanyCode());
	criteria.setBranchCode(sessionCO.getBranchCode());
	criteria.setLangCode(sessionCO.getLanguage());
	
	/**
	 * [TP#1009625] Dynamic Screen Customized Required
	 * iterate entityTypeInfosList to filling entityTypeInfosMap by converting values into their object type
	 */
	SYS_PARAM_SCREEN_ENTITY_TYPEVO sysParamScreenEntityType = new SYS_PARAM_SCREEN_ENTITY_TYPEVO();
	sysParamScreenEntityType.setAPP_NAME(sessionCO.getCurrentAppName());
	sysParamScreenEntityType.setPROG_REF(StringUtil.nullToEmpty(get_pageRef()).isEmpty()?ConstantsCommon.PROGREF_ROOT:get_pageRef());
	List<SYS_PARAM_SCREEN_ENTITY_TYPEVO> entityTypeInfosList = returnCommonLibBO().returnEntityTypeInfos(sysParamScreenEntityType);
	Map<String,Object> entityTypeInfosMap = new HashMap<String,Object>();
	if(entityTypeInfosList != null && entityTypeInfosList.size() > 0)
	{
	    for(SYS_PARAM_SCREEN_ENTITY_TYPEVO currEntityTypeCO : entityTypeInfosList)
	    {
		String entityCode = ServletActionContext.getRequest().getParameter(currEntityTypeCO.getPROPERTY_NAME());
		if(!StringUtil.nullToEmpty(entityCode).isEmpty())
		{
		    String propDataType = StringUtil.nullToEmpty(currEntityTypeCO.getPROPERTY_DATA_TYPE());
		    if(StringUtil.isNotEmpty(entityCode) && StringUtil.isNotEmpty(propDataType) )
		    {
			if(ConstantsCommon.DATA_TYPE_ENTITY_VARCHAR.equalsIgnoreCase(propDataType))
			{
			    entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(), entityCode);
			}
			else if(ConstantsCommon.DATA_TYPE_ENTITY_DATE.equalsIgnoreCase(propDataType) || ConstantsCommon.DATA_TYPE_ENTITY_DATETIME.equalsIgnoreCase(propDataType))
			{
			    try
			    {
				entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(), DateUtil.returnDateObj(entityCode, ActionContext.getContext().getContextMap()));
			    }
			    catch(Exception e)
			    {
				Log.getInstance().warning("ERROR Not able to parse the date value entityCode = "+entityCode+" to any format setting currEntityTypeCO.getENTITY_TYPE() to null");	
				entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(),null);
			    }
			}
			else
			{
			    entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(), new BigDecimal(entityCode));
			}
		    }
		}
		else
		{
		    entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(),null);
		}
	    }
	}
	if(entityTypeInfosMap != null && !entityTypeInfosMap.isEmpty())
	{
	    criteria.getEntityTypeInfosMap().putAll(entityTypeInfosMap);
	}
	
	Map<String,SYS_PARAM_SCREEN_DISPLAYVO> displayMap = dynamicScreenBO.retrnElemsValAndExp(criteria,displayhm);
	if(!displayMap.isEmpty())
	{
	    getAdditionalScreenParams().putAll(displayMap);
	}
    }
    /**
     * used to fetch the dataList and get the type of the currParam to know how to manage it
     * @author marwanmaddah
     * @date   Feb 15, 2016
     * @param currParam
     * @param dataLst
     * @return
     * @throws Exception BigDecimal
     *
     */
    private BigDecimal returnParamType(String currParam, List<DynamicScreenCreatorCO> dataLst)throws Exception
    {
	BigDecimal elementType = null;
	String     currElementId;
	for(int i = 0 ; i < dataLst.size();i++)
	{
	    DynamicScreenCreatorCO dynScreenCreatorCO = dataLst.get(i); 
	    elementType   = dynScreenCreatorCO.getElementType();
	    if(ConstantsCommon.PROPERTY_CODE_ID.equals(dynScreenCreatorCO.getProperty_code()))
	    {		
		currElementId = dynScreenCreatorCO.getProperty_value();
		if(currParam.equals(currElementId))
		{
		    elementType = dynScreenCreatorCO.getElementType();
		    break;
		}
	    }
	}
	return elementType;
    }

    private List<SelectCO> fillOptionsDataList(String paramId,String optionsData,String elementType) throws Exception
    {
	List<SelectCO> lst = new ArrayList<SelectCO>();
	SessionCO sessionCO = returnSessionObject();
	criteria.setSessionCO(sessionCO);
	/* 
	 * create fillOptionsDataList under BO. 
	 */
	lst = dynamicScreenBO.fillOptionsDataList(criteria);
	optionsDataMap.put(paramId+"_lst", lst);
	return lst;
    }
    /**
     * this function is used to load mapping type list
     * @return
     */
    public String loadMapTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_MAP_TYPE);
	    selSC.setLovCodesInlude("'1','2','3'");
	    mapTypeList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    /**
     * This function will delete a record from the dynamic filed mapping grid
     * @return
     */
    public String deleteDynScreenFieldMapping()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(dynamicScreenParamsMapCO.getSysParamElmDynScrnMapDet().getELEMENT_MAP_ID())
		    && !NumberUtil.isEmptyDecimal(dynamicScreenParamsMapCO.getSysParamElmDynScrnMapDet().getFLD_MAP_ID()))
	    {
		dynamicScreenParamsMapCO = dynamicScreenBO.deleteDynScreenFieldMapping(dynamicScreenParamsMapCO);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * function used to set the value of parameters mapping to the new created field
     * @param dynScrParamMap
     * @param paramVO
     * @param elementId
     */
    private void defineDynamicParamValue(Map<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> dynScrParamMap, DynamicParamsVO paramVO, BigDecimal elementId) throws BaseException 
    {
	if(dynScrParamMap != null && !NumberUtil.isEmptyDecimal(elementId) && dynScrParamMap.containsKey(elementId))
	{
	    SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO paramMapVO = dynScrParamMap.get(elementId);
	    String mapType = paramMapVO.getMAP_TYPE();
	    if(ButtonCustomizationConstants.MAP_TYPE.CONSTANT.equals(mapType)
		    || ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(mapType))
	    {
		paramVO.setValue(StringUtil.nullToEmpty(paramMapVO.getMAP_VALUE()));
		paramVO.setConsiderChoiceValue(ConstantsCommon.TRUE);
	    }
	    else if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(mapType))
	    {
		SessionCO sessionCO = returnSessionObject();
//		PathPropertyUtil.copyProperties(sessionCO, paramVO, paramMapVO.getMAP_VALUE() + " value");
		Object valueObj = PathPropertyUtil.returnProperty(sessionCO, paramMapVO.getMAP_VALUE());
		if(valueObj!=null)
		{
		    paramVO.setValue(String.valueOf(valueObj));
//		    valueStr = String.valueOf(valueObj);
		}
		
	    }
	    
	    //Adel check if paramMapVo is different than primary key as if its primary key we dont want to changeTrack to true
	    // param type 2 = primary key
	    /// mode type = load (it is set when we are retrieving the record by primary key from db)
	    // if param type = 2 without mode type on load, we consider the parameter sent as a regular field and not a primary key
	    if(!paramMapVO.getMAP_VALUE().isEmpty()
		    && !(ConstantsCommon.ON_LOAD_MODE.equals(criteria.getModeType()) && ConstantsCommon.TWO.equals(paramMapVO.getDYN_PARAM_TYPE()))
		    && !ConstantsCommon.TRUE.equals(changeTrack))
	    {
		setChangeTrack(ConstantsCommon.TRUE);
	    }
	}
    }
    private String returnDynamicParamValue(Map<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> dynScrParamMap, String paramName) throws BaseException 
    {
	
	String valueStr = null;
	try {
		if(dynScrParamMap != null && !StringUtil.nullToEmpty(paramName).isEmpty())
		{
		    SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO paramMapVO = null;
		    Iterator mapIt = dynScrParamMap.entrySet().iterator();
		    while(mapIt.hasNext())
		    {
			Entry thisEntry = (Entry) mapIt.next();
			SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO entryMapValue = (SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO)thisEntry.getValue();
			if(paramName.equals(entryMapValue.getMAP_VALUE()))
			{
			    paramMapVO = (SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO)thisEntry.getValue();
			    break;
			}
		    }
		    if(paramMapVO==null)
		    {
			return valueStr;
		    }
		    
		    String mapType = paramMapVO.getMAP_TYPE();
		    if(ButtonCustomizationConstants.MAP_TYPE.CONSTANT.equals(mapType)
			    || ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(mapType))
		    {
			valueStr = StringUtil.nullToEmpty(paramMapVO.getMAP_VALUE());
		    }
		    else if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(mapType))
		    {
			SessionCO sessionCO = returnSessionObject();
			Object valueObj = PathPropertyUtil.returnProperty(sessionCO, paramMapVO.getMAP_VALUE());
			if(valueObj!=null)
			{			    
			    valueStr = String.valueOf(valueObj);
			}
//			PathPropertyUtil.copyProperties(sessionCO, paramVO,  + " value");
		    }
		    
		    //Adel check if paramMapVo is different than primary key as if its primary key we dont want to changeTrack to true
		    // param type 2 = primary key
		    /// mode type = load (it is set when we are retrieving the record by primary key from db)
		    // if param type = 2 without mode type on load, we consider the parameter sent as a regular field and not a primary key
		    if(!paramMapVO.getMAP_VALUE().isEmpty()
			    && !(ConstantsCommon.ON_LOAD_MODE.equals(criteria.getModeType()) && ConstantsCommon.TWO.equals(paramMapVO.getDYN_PARAM_TYPE()))
			    && !ConstantsCommon.TRUE.equals(changeTrack))
		    {
			setChangeTrack(ConstantsCommon.TRUE);
		    }
		}	    
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return valueStr;
    }
    
    /**
     * function that will return the map of the parameters mapping, key=elementId , value = instance of SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO
     * @return
     */
    private Map<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> returnDynamicScrParamsMap()
    {
	Map<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> dynScrParamMap  = new HashMap<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO>();
	if(StringUtil.isNotEmpty(dynamicScreenParamsMapCO.getDynamicScreenParamsMapData()) )
	{    
	    GridUpdates gu = getGridUpdates(dynamicScreenParamsMapCO.getDynamicScreenParamsMapData(), SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO.class,true);
	    List<SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> paramMapDetList = gu.getLstAllRec();
	    if(paramMapDetList != null && !paramMapDetList.isEmpty())
	    {
		for(SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO detVO  : paramMapDetList)
		{
		    dynScrParamMap.put(detVO.getTO_ELEMENT_ID(), detVO);
		}
	    }
	}
	return dynScrParamMap;
    }
    
    /**
     * Submit the form and save it to DB
     */
    public String submitDynamicScreenForm()
    {
	SessionCO sessionCO = returnSessionObject();

	ScreenGeneratorSC screenGeneratorSC = new ScreenGeneratorSC();
	screenGeneratorSC.setScreenId(criteria.getScreenId());
	screenGeneratorSC.setUserId(sessionCO.getUserName());
	screenGeneratorSC.setRunningDate(sessionCO.returnRunningDate());
	//TP#1009625 Dynamic Screen Customization Required
	screenGeneratorSC.setCompCode(sessionCO.getCompanyCode());
	screenGeneratorSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
	screenGeneratorSC.setCurrAppName(sessionCO.getCurrentAppName());
	screenGeneratorSC.setProgRef(StringUtil.nullToEmpty(get_pageRef()).isEmpty()?ConstantsCommon.PROGREF_ROOT:get_pageRef());
	//End TP#1009625
	try
	{
	    /**
	     * [TP#989676] - Need to add option Submit with Parent in Button Source
	     * validate if screen has child screens (source data)
	     * then first check child screens dependency on parent screen 
	     * then submit/save child & parent screens data
	     */
	    String sourceData = criteria.getSourceData();
	    if(!StringUtil.nullToEmpty(sourceData).isEmpty())
	    {	    
		checkParamsDependency(sourceData);
		submitChildScreenData(sourceData);
	    }
	    dynamicScreenBO.submitDynamicScreenForm(scrElemHm, dynFileElemHm, gridElemHm, screenGeneratorSC);
	    dynFileElemHm = null;
	}
	catch(Exception e)
	{
	    dynFileElemHm = null;
	    handleException(e, null, null);
	}
	return "dSstatus";
    }
    
    /**
     * delete the form based on PK
     */
    public String deleteDynamicScreenForm()
    {
    	SessionCO sessionCO     = returnSessionObject();
    	ScreenGeneratorSC screenGeneratorSC = new ScreenGeneratorSC();
    	screenGeneratorSC.setScreenId(criteria.getScreenId());
    	screenGeneratorSC.setUserId(sessionCO.getUserName());
    	screenGeneratorSC.setRunningDate(sessionCO.returnRunningDate());
    	try{
    		dynamicScreenBO.deleteDynamicScreenForm(scrElemHm,screenGeneratorSC);    		
    	}
    	catch(Exception e)
    	{
    	    handleException(e, null, null);
    	}
    	return SUCCESS;
    }
    /**
     * @description validate if form has file element then read the file content into bytes Array and convert to Base64 encoded string 
     * @createdBy Sajjad Soomro [TP#989676]
     * 
     * @return String
     */
    public String submitWithParentDynamicScreenForm()
    {	
	try
	{
	    // if screen has child screens then validate screen dependency value changes
	    if(!StringUtil.nullToEmpty(criteria.getSourceData()).isEmpty())
	    {
		checkParamsDependency(criteria.getSourceData());
	    }
	    if(dynFileElemHm != null && !dynFileElemHm.isEmpty())
	    {
		Iterator<String> iterator  = dynFileElemHm.keySet().iterator();
		while(iterator.hasNext())
		{
		    String key = iterator.next();
		    DynamicScreenFileCO dynFileCO = dynFileElemHm.get(key);
		    byte[] fileBytes = null;
		    try
		    {
			//limit the size of the file to be below of 200 MB = 200000000 bytes
			fileBytes = PathFileSecure.readFileToByteArray(dynFileCO.getUploadFile(),200000000);
		    }
		    catch(Exception e)
		    {
			throw new BaseException("The size of the file to be below of 200 MB");
		    }
		    //set null due to not necessary to return back to client
		    dynFileCO.setUploadFile(null);
		    //set file content into Base64 encoded string
		    dynFileCO.setUploadFileContent(SecurityUtils.encodeB64(fileBytes));
		}
	    }
	}catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "dSstatus";
    }
    
    /**
     * @description used to check parameters dependency between parent and its child screens
     * @createdBy Sajjad Soomro [TP#989676]
     * 
     * @param sourceData
     * @throws Exception
     */
    private void checkParamsDependency(String sourceData) throws Exception
    {
	JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(sourceData);
	Object[] modelArr = jsonModel.toArray();
	JSONObject obj;
	
	for(int i = 0; i < modelArr.length; i++)
	{
	    obj = (JSONObject) modelArr[i];
	    Iterator<String> iterator = obj.keySet().iterator();
	    while(iterator.hasNext())
	    {
		String key = iterator.next();
		JSONObject jsonObj = obj.getJSONObject(key);		
		if(jsonObj.containsKey("dynamicScreenParamsMapCO"))
		{
		    // check if screen has dynamicScreenParamsMapData inside dynamicScreenParamsMapCO then check dependency
		    if(jsonObj.getJSONObject("dynamicScreenParamsMapCO").containsKey("dynamicScreenParamsMapData"))
		    {
			JSONObject paramsDataJsonObj = jsonObj.getJSONObject("dynamicScreenParamsMapCO").getJSONObject("dynamicScreenParamsMapData");
			JSONArray rootModel = paramsDataJsonObj.getJSONArray("root");
			Object[] rootArr = rootModel.toArray();
			JSONObject rootObj;

			for(int j=0; j < rootArr.length; j++)
			{
			    rootObj = (JSONObject) rootArr[j];
			    /**
			     * MAP_TYPE = 1	dependent on screen element
			     * validate if child screen has dependency on parent screen element
			     */
			    if(rootObj.containsKey("FROM_FLD_IDENTIFIER") && rootObj.getInt("MAP_TYPE") == 1)
			    {
				BigDecimal fromFieldId = BigDecimal.valueOf(rootObj.getInt("FROM_FLD_IDENTIFIER"));
				DynCommonLookupSC dynCommonLookupSC = new DynCommonLookupSC();
				dynCommonLookupSC.setElementId(fromFieldId);
				dynCommonLookupSC.setPropertyCode("name");
				//fetch element properties by element id
				DynamicScreenCO dynScrCO = dynamicScreenBO.returnelemPropertyDetails(dynCommonLookupSC);
				if(dynScrCO != null)
				{
				    String mapValue = rootObj.getString("MAP_VALUE");
				    String fromFldElemName = dynScrCO.getPropertyValue();
				    String fromFldElemValue = null;
				    if(scrElemHm.containsKey(fromFldElemName))
				    {
					fromFldElemValue = scrElemHm.get(fromFldElemName);
					// compare parent & child screen dependent element value
					if(!mapValue.equals(fromFldElemValue))
					{
					    throw new BOException(fromFldElemName + " " + getText("scr_submit_with_parent_dep_err_key"));
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
    
    /**
     * @description used to save child screens data into database
     * @createdBy Sajjad Soomro [TP#989676]
     * 
     * @param sourceData
     * @throws BaseException
     */
    private void submitChildScreenData(String sourceData) throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();

	ScreenGeneratorSC screenGeneratorSC = new ScreenGeneratorSC();
	screenGeneratorSC.setUserId(sessionCO.getUserName());
	screenGeneratorSC.setRunningDate(sessionCO.returnRunningDate());
	screenGeneratorSC.setCompCode(sessionCO.getCompanyCode());
	screenGeneratorSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
	screenGeneratorSC.setCurrAppName(sessionCO.getCurrentAppName());
	screenGeneratorSC.setProgRef(StringUtil.nullToEmpty(get_pageRef()).isEmpty()?ConstantsCommon.PROGREF_ROOT:get_pageRef());

	JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(sourceData);
	Object[] modelArr = jsonModel.toArray();
	JSONObject obj;

	for(int i = 0; i < modelArr.length; i++)
	{
	    obj = (JSONObject) modelArr[i];
	    Iterator<String> iterator = obj.keySet().iterator();
	    while(iterator.hasNext())
	    {
		String screenKey = iterator.next();
		JSONObject screenJsonObj = obj.getJSONObject(screenKey);
		JSONObject screenCriteriaObj = screenJsonObj.getJSONObject("criteria");
		String screenId = screenCriteriaObj.getString("screenId");

		/**
		 * validate if screen has further child screens (source data)
		 * then submit/save its child screens data
		 */
		if(screenCriteriaObj.containsKey("sourceData"))
		{
		    String screenSourceData = screenCriteriaObj.getString("sourceData");
		    submitChildScreenData(screenSourceData);
		}

		Map<String, String> scrElemHashMap = new HashMap<String, String>();
		Map<String, String> gridElemHashMap = new HashMap<String, String>();
		Map<String, DynamicScreenFileCO> dynFileElemHashMap = new HashMap<String, DynamicScreenFileCO>();

		if(screenJsonObj.containsKey("scrElemHm"))
		    scrElemHashMap = (HashMap<String, String>) JSONObject.toBean(screenJsonObj.getJSONObject("scrElemHm"), HashMap.class);
		
		// check if screen has grid elements, then iterate and fill object gridElemHashMap
		if(screenJsonObj.containsKey("gridElemHm"))
		{
		    JSONObject gridElemJsonObj = screenJsonObj.getJSONObject("gridElemHm");
		    Iterator<String> gridElemIterator = gridElemJsonObj.keySet().iterator();
		    while(gridElemIterator.hasNext())
		    {
			String jsonKey = gridElemIterator.next();
			if(gridElemJsonObj.getString(jsonKey) != null && !StringUtil.isEmptyString(gridElemJsonObj.getString(jsonKey)))
			{
			    JSONObject gridElemObj = gridElemJsonObj.getJSONObject(jsonKey);
			    gridElemHashMap.put(jsonKey, gridElemObj.toString());
			}
		    }
		}
		// check if screen has file elements, then iterate and read upload file content and fill object dynFileElemHashMap
		if(screenJsonObj.containsKey("dynFileElemHm"))
		{
		    JSONObject dynFileElemJsonObj = screenJsonObj.getJSONObject("dynFileElemHm");
		    Iterator<String> dynFileIterator = dynFileElemJsonObj.keySet().iterator();
		    while(dynFileIterator.hasNext())
		    {
			String jsonKey = dynFileIterator.next();
			JSONObject dynFileElemObj = dynFileElemJsonObj.getJSONObject(jsonKey);
			String fileName = dynFileElemObj.getString("uploadFileFileName");
			String fileType = dynFileElemObj.getString("uploadFileContentType");
			String fileContent = dynFileElemObj.getString("uploadFileContent");

			DynamicScreenFileCO fileCO = new DynamicScreenFileCO();
			fileCO.setByteArrUpload(SecurityUtils.decodeB64NoCharEncoding(fileContent.getBytes()));
			fileCO.setUploadFileFileName(fileName);
			fileCO.setUploadFileContentType(fileType);
			dynFileElemHashMap.put(jsonKey, fileCO);
		    }
		}
		screenGeneratorSC.setScreenId(BigDecimal.valueOf(Double.valueOf(screenId)));
		//submit screen data to save into database
		dynamicScreenBO.submitDynamicScreenForm(scrElemHashMap, dynFileElemHashMap, gridElemHashMap, screenGeneratorSC);
	    }
	}
    }
    /**
     * this function is used to load mapping type list
     * @return
     */
    public String loadDynParamTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_DYN_PARAM_TYPE);
	    dynParamMapList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    /**
     * this function is used to load selection type list
     * @return
     */
    public String loadSelectionTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_SELECTION_TYPE);
	    selSC.setLovCodesInlude("'U','A','S'");
	    selectionTypeList = returnLOV(selSC);
	    //Add empty option
	    SelectCO emptyOption = new SelectCO();
	    emptyOption.setCode("");
	    emptyOption.setDescValue("");
	    selectionTypeList.add(0,emptyOption);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    public String downloadDynFile()
    {
	byte[] resultBytes;
	try
	{
	    DynamicScreenFileCO dynFileCO = null;
	    if(criteria.getSourceData() != null)
	    {
		/**
		 * [TP#989676] Need to add option Submit with Parent in Button Source
		 * used to download file from encrypted content
		 */
		JSONObject dynFileElemObj = (JSONObject) JSONSerializer.toJSON(criteria.getSourceData());		
		String fileName = dynFileElemObj.getString("uploadFileFileName");
		String fileType = dynFileElemObj.getString("uploadFileContentType");
		String fileContent = dynFileElemObj.getString("uploadFileContent");

		dynFileCO = new DynamicScreenFileCO();
		dynFileCO.setByteArrUpload(SecurityUtils.decodeB64NoCharEncoding(fileContent.getBytes()));
		dynFileCO.setUploadFileFileName(fileName);
		dynFileCO.setUploadFileContentType(fileType);
	    }
	    else
	    {
		dynFileCO = dynamicScreenBO.downloadDynFile(scrElemHm,dynFileElemHm,criteria);
	    }
	    if(dynFileCO==null){
		throw new BaseException("There is no file to download"); 
	    }
	    resultBytes = dynFileCO.getByteArrUpload();
	    exportStream = new ByteArrayInputStream(resultBytes);
	    setFileName(dynFileCO.getUploadFileFileName());
	    ServletActionContext.getResponse().setHeader("Set-Cookie", "fileDownload=true; path=/");
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		exportStream = new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    }
	    catch(UnsupportedEncodingException e1)
	    {
		log.error(e1, "Error in reading the error message");
	    }
	    return "fileError";
	}

	return "exported";
    }
    
    private void fillGridWidgetProperties(DynamicScreenCreatorCO dynScreenCreatorCO, DynamicParamsVO paramVO,
	    StringBuffer gridUpdateIds, SYS_DYN_SCREEN_ELEMENTS_DETVO elementDet, List<DynamicParamsVO> hiddenElemList)
    {
	String propertyCode = elementDet.getPROPERTY_CODE();
	String propertyValue = elementDet.getPROPERTY_VALUE();
	String propertyBigValue = elementDet.getPROPERTY_EXPRESSION_VALUE();
	String _addPageRef = StringUtil.nullToEmpty(get_pageRef()).isEmpty()?"":"_"+get_pageRef();
        BigDecimal elementId = dynScreenCreatorCO.getElementId();
        String currId = dynScreenCreatorCO.getTheId();
        
        // case for each customized property of the grid 
	switch (propertyCode)
	{
	    case ConstantsCommon.PROPERTY_CODE_ENABLESEARCH:
		paramVO.setEnblSearch(propertyValue);
		break;
	    case ConstantsCommon.PROPERTY_CODE_TABLE_NAME:
		// if table name is not empty, then the table is dynamic
		if(!StringUtil.nullToEmpty(propertyValue).isEmpty())
		{
		    //handle columns of the grid
		    tempPropertiesHm.put(ConstantsCommon.PROPERTY_CODE_TABLE_NAME, propertyValue);
		    //add an additional field to save the grid updates, it is needed on submit
		    String gridId = (StringUtil.nullToEmpty(currId).isEmpty() ? "" + elementId : currId)
			    .concat(_addPageRef);
		    DynamicParamsVO gridUpdatesParamVO = new DynamicParamsVO();
		    gridUpdatesParamVO.setId(gridId.concat("_gridUpdates"));
		    //TP#1031674 Issue when updating multiple grids mapped to same dynamic table
		    gridUpdatesParamVO.setName("gridElemHm."+gridId);
		    gridUpdatesParamVO.setElement_type(ConstantsCommon.LAYOUT_TYPE_TEXTFIELD);
		    gridUpdatesParamVO.setRow(0);
		    gridUpdatesParamVO.setColumn(0);
		    gridUpdatesParamVO.setVisible(ConstantsCommon.FALSE);
		    hiddenElemList.add(gridUpdatesParamVO);
		    gridUpdateIds.append(gridId).append(";");
		}
		break;
	    case ConstantsCommon.PROPERTY_CODE_QUERY:
		// if property code query exists, then the table is from a defined query
	    {
			if (!StringUtil.isEmptyString(propertyBigValue)) 
			{
				JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(propertyBigValue);
				Object[] modelArr = jsonModel.toArray();
				JSONObject obj   = (JSONObject) modelArr[0];
				/// TP 853476. Dynamic Screen Grid Loading From Rest Serivce [Muhammad.Asif]
				if ( obj.has("tableDatasource") && obj.getString("tableDatasource").equals(ConstantsCommon.DATASOURCE_BY_GLOBAL_ACTIVITY) )
				{
					fillGridWidgetFromRestService(dynScreenCreatorCO, paramVO, obj);
				}
				
				else //case where grid is filled from query 
				{
		    	           fillGridWidgetFromQueryProperty(dynScreenCreatorCO, paramVO, elementDet);
				}
			}
		}
		break;
	    case ConstantsCommon.PROPERTY_CODE_RETRIEVALCONDITION:
		//if Property for retrieval condition
		if(StringUtil.isNotEmpty(propertyBigValue)) 
		{
		String queryData = propertyBigValue;
		JSONArray jsModel = (JSONArray) JSONSerializer.toJSON(propertyBigValue);
		Object[] modArr = jsModel.toArray();
		JSONObject object = (JSONObject) modArr[0];
		queryData = object.getString("querySynthax");
		if(StringUtil.isNotEmpty(queryData))
		{
		    fillGridWidgetFromCondProperty(dynScreenCreatorCO, paramVO, elementDet);
		}
		}
		break;
	    case ConstantsCommon.PROPERTY_CODE_VALUE:
		// set the value as the title of the grid, and translate it if it was a key
		paramVO.setTitle(propertyValue != null
			? getText(propertyValue) : " ");
		break;
	    case ConstantsCommon.PROPERTY_CODE_DBL_CLICK:
		if(StringUtil.isNotEmpty(propertyBigValue))
		{
		    JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(propertyBigValue);
		    Object[] modelArr = jsonModel.toArray();
		    JSONObject obj = (JSONObject) modelArr[0];
		    String sourceType = obj.getString("sourceType");

		    if(ConstantsCommon.SCRIPT_BTN_SOURCE.equals(sourceType))
		    {
			String sourceScriptData = obj.getString("sourceScriptData");
			if(!StringUtil.nullToEmpty(sourceScriptData).isEmpty())
			{
			    // 471675 added buttonFunction to handle button
			    // scripts.
			    String buttonFunction = "dynamicScreen_excute_" + paramVO.getId() + "()";
			    paramVO.setOnClick(buttonFunction);
			    String formId = StringUtil.isNotEmpty(get_pageRef())
				    ? "dynScreen_" + criteria.getScreenId() + "_FormId" + "_" + get_pageRef()
				    : "dynScreen_" + criteria.getScreenId() + "_FormId";
			    if(StringUtil.isNotEmpty(_addPageRef))
			    {
				/**
				 * in case there is a progref, catch all the
				 * parameters that are used inside the script
				 * and add _progRef to the used Ids
				 */
				sourceScriptData = replaceFormIdWithPageRef(sourceScriptData, _addPageRef, formId);
			    }
			    sourceScriptData = sourceScriptData.replaceAll("\\[formId\\]", formId)
				    .replaceAll("\\[screenId\\]", criteria.getScreenId().toString());
			    paramVO.setButtonScript("function " + buttonFunction + "{" + sourceScriptData + "}");
			}
		    }
		    else if(ConstantsCommon.INTERNAL_SCREEN_BTN_SOURCE.equals(sourceType))
		    {
			String sourceScreenId = obj.getString("sourceScreenId");

			int sourceScreenWidth = (obj.containsKey("sourceScreenWidth")
				&& !StringUtil.nullToEmpty(obj.getString("sourceScreenWidth")).isEmpty())
					? obj.getInt("sourceScreenWidth") : 400;
			int sourceScreenHeight = (obj.containsKey("sourceScreenHeight")
				&& !StringUtil.nullToEmpty(obj.getString("sourceScreenHeight")).isEmpty())
					? obj.getInt("sourceScreenHeight") : 600;
			paramVO.setOnClick("dynamicScreen_openDynamicScreen('" + sourceScreenId + "', null, '"
				+ paramVO.getId() + "'," + sourceScreenWidth + "," + sourceScreenHeight + ")");
		    }
		}
		break;
	    case ConstantsCommon.PROPERTY_CODE_COLPROPS:
		    tempPropertiesHm.put(ConstantsCommon.PROPERTY_CODE_COLPROPS, propertyBigValue);
		break;
	    default:
		break;
	}
	
    }
    /**
     * @description catch all the parameters that are used inside the script and add _progRef to the used Ids if not exists
     * @createdBy Sajjad Soomro
     * 
     * @param sourceScriptData
     * @param _addPageRef
     * @return String sourceScriptData
     */
    private String replaceFormIdWithPageRef(String sourceScriptData, String _addPageRef, String formId)
    {
	/**
	 * regex below used to match the content that, start with hash (#) till the the closing parenthesis
	 * regex: #\w+(.+?(?=\)))
	 * # matches the character # literally (case sensitive)
	 * \w+ matches any word character (equal to [a-zA-Z0-9_]
	 * .+? matches any character (except for line terminators)
	 * \) matches the character ) literally (case sensitive)
	 */
	String scriptParamPattern = "#\\w+(.+?(?=\\)))";
	Pattern scriptDataPattern = Pattern.compile(scriptParamPattern);
	Matcher matcher = scriptDataPattern.matcher(sourceScriptData);
	List<String> passedElemsMap = new ArrayList<String>();
	while(matcher.find())
	{
	    String currGroup = matcher.group();
	    if(!passedElemsMap.contains(currGroup))
	    {
		if(!currGroup.contains("_pageRef"))
		{
		    currGroup = currGroup.trim();
		    String[] words = currGroup.split("\\+");
		    if(words.length==1)
		    {
			//ignore last character from word that could be double quote or single quote
			currGroup = currGroup.substring(0, currGroup.length()-1);			
			if(currGroup.matches("#dynScreen_\\d+_FormId") || currGroup.equals("#dynScreen_[screenId]_FormId"))
			{
			    String lastWord = words[words.length-1];
			    lastWord = lastWord.substring(0, lastWord.length()-1);
			    sourceScriptData = sourceScriptData.replace(currGroup, currGroup.replace(lastWord, (lastWord + _addPageRef)));
			}
		    }
		    else
		    {
			String lastWord = words[words.length-1];
			//ignore last character from word that could be double quote or single quote
			lastWord = lastWord.substring(0, lastWord.length()-1);
			sourceScriptData = sourceScriptData.replace(currGroup, currGroup.replace(lastWord, (lastWord + _addPageRef)));
		    }
		}
		passedElemsMap.add(currGroup);
	    }
	}
	return sourceScriptData;
    }
    private void fillGridWidgetFromQueryProperty(DynamicScreenCreatorCO dynScreenCreatorCO, DynamicParamsVO paramVO,
	    SYS_DYN_SCREEN_ELEMENTS_DETVO elementDet)
    {
	try
	{
	    List<DynScrTableColsCO> gridColList = new ArrayList<DynScrTableColsCO>();
	    DynScrTableColsCO tableColsCO = new DynScrTableColsCO();
	    
	    // same behavior as dynamic lookup in order to reuse code
	    String propertyBigValue = elementDet.getPROPERTY_EXPRESSION_VALUE();
	    String queryData = propertyBigValue;
	    JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(queryData);
	    Object[] modelArr = jsonModel.toArray();
	    JSONObject obj = (JSONObject) modelArr[0];
	    
	    DynScreenQueryCO dynScreenQueryCO = new DynScreenQueryCO();

	    //Tp#1081060 Issue with query execution
	    String queryStr = (obj.getString("querySynthax"));
	    dynScreenQueryCO.setQuerySynthax(queryStr);
	    //get screen query parameters
	    dynScreenQueryCO = generatorBO.returnQueryParams(dynScreenQueryCO);
	    paramVO.setParamList(dynScreenQueryCO.getScreenQueryParams());
	    Map<String, Map<String,String>> hmDataStruct = generatorBO.returnGridColNames(dynScreenQueryCO.getQuerySynthax());
	    Iterator it = hmDataStruct.entrySet().iterator();
	    // iterate through grid columns and set needed properties
	    while(it.hasNext())
	    {
	
		Entry entry = (Entry) it.next();
		String theKey = (String) entry.getKey();
		Map<String,String> mapType = (Map<String,String>)entry.getValue();
		String type ="";
		//replace spaces by '_' in column alias name 
                theKey = StringUtil.nullToEmpty(theKey).replaceAll(" ", "_");
		tableColsCO.setCOL_TECH_NAME(theKey);
		tableColsCO.setCOL_DESC(getText(theKey));
		tableColsCO.setHIDDEN("false");
		
		if(mapType.containsKey("number"))
		{
		    
		    tableColsCO.setCOL_TYPE("3");
		    tableColsCO.setNbFormat(mapType.get("number"));
		    type= "number";
		}
		else if(mapType.containsKey("text"))
		{
		    tableColsCO.setCOL_TYPE("1");
		    type= "text";
		}
		else if(mapType.containsKey("date"))
		{
		    tableColsCO.setCOL_TYPE("2");
		    type= "date";
		}
		tableColsCO.setCOL_TYPE_DESC(type);
		gridColList.add(tableColsCO);
		tableColsCO = new DynScrTableColsCO();
	    }
	    
	    paramVO.setColsLst(gridColList);
	    returnSerializedStrFromObj(gridColList);
	    paramVO.setValue(dynScreenCreatorCO.getElementId().toString());
	    paramVO.setElement_dataType("Query");
	    paramVO.setEditable("false");
	    paramVO.setSortable("true");
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
    }
    private void fillGridWidgetFromCondProperty(DynamicScreenCreatorCO dynScreenCreatorCO, DynamicParamsVO paramVO,
	    SYS_DYN_SCREEN_ELEMENTS_DETVO elementDet) 
    {
	try
	{
	    List<DynScrTableColsCO> gridColList = new ArrayList<DynScrTableColsCO>();
	    DynScrTableColsCO tableColsCO = new DynScrTableColsCO();
	    
	    // same behavior as fillGridWidgetFromQueryProperty
	    String propertyBigValue = elementDet.getPROPERTY_EXPRESSION_VALUE();
	    String queryData = propertyBigValue;
	    JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(queryData);
	    Object[] modelArr = jsonModel.toArray();
	    JSONObject obj = (JSONObject) modelArr[0];
	    //select TableName
	    List<SYS_DYN_SCREEN_ELEMENTS_DETVO>elmVO = dynScreenCreatorCO.getElemDets();
	    String tableName="";
	    for(SYS_DYN_SCREEN_ELEMENTS_DETVO currElm :elmVO ) 
	    {
		if( ConstantsCommon.PROPERTY_CODE_TABLE_NAME.equals(currElm.getPROPERTY_CODE()))
		{
		    tableName = currElm.getPROPERTY_VALUE();
		}
	    }
	    DynScreenQueryCO dynScreenQueryCO = new DynScreenQueryCO();
	    
	    dynScreenQueryCO.setElementType(dynScreenCreatorCO.getElementType().toString());

	    String querySyntax = (obj.getString("querySynthax"));
	    querySyntax = "SELECT * FROM "+tableName+" WHERE "+querySyntax;
	    //Construct query from tableName and condition
	    dynScreenQueryCO.setQuerySynthax(querySyntax);
	
	    //TP#1081060 get ScreenParamList
	    dynScreenQueryCO = generatorBO.returnQueryParams(dynScreenQueryCO);
	    paramVO.setParamList(dynScreenQueryCO.getScreenQueryParams());
	    Map<String, Map<String,String>> hmDataStruct = generatorBO.returnGridColNames(dynScreenQueryCO.getQuerySynthax());
	    Iterator it = hmDataStruct.entrySet().iterator();
	   
	    // iterate through grid columns and set needed properties
	    while(it.hasNext())
	    {
		Entry entry = (Entry) it.next();
		String theKey = (String) entry.getKey();
		Map<String,String> mapType = (Map<String,String>)entry.getValue();
		String type="";
		//replace spaces by '_' in column alias name 
		theKey = StringUtil.nullToEmpty(theKey).replaceAll(" ", "_");
		tableColsCO.setCOL_TECH_NAME(theKey);
		tableColsCO.setCOL_DESC(getText(theKey));
		tableColsCO.setHIDDEN("false");
		
		if(mapType.containsKey("number"))
		{
		   
		    tableColsCO.setCOL_TYPE("3");
		    tableColsCO.setNbFormat(mapType.get("number"));
		    type= "number";
		}
		else if(mapType.containsKey("text"))
		{
		    tableColsCO.setCOL_TYPE("1");
		    type= "text";
		}
		else if(mapType.containsKey("date"))
		{
		    tableColsCO.setCOL_TYPE("2");
		    type= "date";
		}
		tableColsCO.setCOL_TYPE_DESC(type);
		gridColList.add(tableColsCO);
		tableColsCO = new DynScrTableColsCO();
	    }
	    
	    paramVO.setColsLst(gridColList);
	    returnSerializedStrFromObj(gridColList);
	    paramVO.setValue(dynScreenCreatorCO.getElementId().toString());
	    paramVO.setElement_dataType("Query");
	    paramVO.setEditable("true");
	    paramVO.setSortable("false");
	}
	    
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
    }

    private void fillGridWidgetFromDynTableProperty(DynamicScreenCreatorCO dynScreenCreatorCO, DynamicParamsVO paramVO)
    {
	// same behavior as main grid
	ScreenGeneratorSC ScreenGeneratorSC = new ScreenGeneratorSC();
	String tableName = tempPropertiesHm.get(ConstantsCommon.PROPERTY_CODE_TABLE_NAME);
	ScreenGeneratorSC.setTableName(tableName);

	HashMap<String,HashMap<String,Object>> gridColsHm = new HashMap<String,HashMap<String,Object>>();
	HashMap<String, Object> gridColsPropsHm = new HashMap<String,Object>();
	String   _addPageRef = StringUtil.nullToEmpty(get_pageRef()).isEmpty()?"":"_"+get_pageRef();
	

	try
	{
	    String colProps = tempPropertiesHm.get(ConstantsCommon.PROPERTY_CODE_COLPROPS);
	    JSONArray jsonModel;
	    Object[] modelArr;
	    if(StringUtil.isNotEmpty(colProps)) {
		JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(colProps);
		    jsonModel = jsonFilter.getJSONArray("root");
		    modelArr = jsonModel.toArray();
			
		    for(int i = 0; i < modelArr.length; i++)
		    {
			JSONObject obj = (JSONObject) modelArr[i];
			gridColsPropsHm = (HashMap<String, Object>) new ObjectMapper().readValue(obj.toString(), HashMap.class);
			
			if(gridColsPropsHm.get("QUERY_DATA").getClass() == ArrayList.class)
			{
			    String queryData = obj.get("QUERY_DATA").toString();
			    gridColsPropsHm.put("QUERY_DATA", queryData);
			    gridColsPropsHm.remove("QUERY_BTN");
			}
			
			gridColsHm.put(gridColsPropsHm.get("COL_TECH_NAME").toString(),gridColsPropsHm);
		    }
	    }
	    
	    List<DynScrTableColsCO> gridColList = generatorBO.returnDynTableCols(ScreenGeneratorSC);
	    //get both elementId and tableId for any element, tableId will be null if grid is not editable
	    paramVO.setValue(dynScreenCreatorCO.getElementId().toString());
	    paramVO.setTableId(gridColList.get(0).getTABLE_ID().toString());
	    paramVO.setElement_dataType("Table");
	    
	    // the grid from table name is always editable, if it is not needed as editable to use query instead of table name
	    paramVO.setEditable("true");
	    paramVO.setSortable("false");
	    for(int i = 0; i < gridColList.size(); i++)
	    {
		DynScrTableColsCO dynScrTableColsCO = gridColList.get(i);
		gridColsPropsHm = gridColsHm.get(dynScrTableColsCO.getCOL_TECH_NAME());
		String queryData = "";
		String visibility = "";
		if(gridColsPropsHm != null && gridColsPropsHm.get("QUERY_DATA") != null)
		{
			queryData = gridColsPropsHm.get("QUERY_DATA").toString();
			String colTechName = gridColsPropsHm.get("COL_TECH_NAME").toString();
			String colType = gridColsPropsHm.get("COL_TYPE").toString();
			String colDesc = gridColsPropsHm.get("LOOKUP_DESC").toString();
			if(!queryData.isEmpty())
			{
			    jsonModel = (JSONArray) JSONSerializer.toJSON(queryData);
			    modelArr = jsonModel.toArray();
			    JSONObject obj = (JSONObject) modelArr[0];
			    StringBuffer paramList  = new StringBuffer();
			    StringBuffer resultList = new StringBuffer();
			    //TP#982174 Add dependency for live search in Column Properties
			    StringBuffer dependencySrc = new StringBuffer();
			    StringBuffer dependencyList = new StringBuffer();
			    StringBuffer dependencyParamList = new StringBuffer();
			    String columnCode = obj.getString("columnCode");
			    String columnDesc = obj.getString("columnDesc");
			    BigDecimal elementId = dynScreenCreatorCO.getElementId();
			    paramList = new StringBuffer();
			    resultList = new StringBuffer();
			    String newparam = null;
			    paramList.append("screenId:").append("~CONST_").append(criteria.getScreenId());
			    paramList.append(",").append("colName:").append("~CONST_").append(dynScrTableColsCO.getCOL_TECH_NAME());
			    paramList.append(",").append("elementId:").append("~CONST_").append(dynScreenCreatorCO.getElementId());
			    //add screen paramlist for passing parameters to query lookup
			    String lookupId = colTechName+"_"+dynScreenCreatorCO.getTheId()+_addPageRef;
			    paramList.append(",criteria.elemHm.screenParamMap:returnLookupScreenParamMap(\\\""+lookupId+ "\\\")");
			    
			    Pattern patternQueryParam = Pattern.compile("(.*?)(\\[screen.(\\S*)\\]|\\[session.(\\S*)\\])(.*?)");
        		    Matcher matcherQueryParam = patternQueryParam.matcher(queryData);
        		    StringBuffer queryBuffer = new StringBuffer();
        		    while(matcherQueryParam.find())
        		    {
        			if(matcherQueryParam.group(2) != null)
        			{
        			    matcherQueryParam.appendReplacement(queryBuffer, matcherQueryParam.group(1) + "NULL");
        			    if(StringUtil.isNotEmpty(matcherQueryParam.group(3)))
        			    {
        				newparam = ",criteria.elemHm.screen_".concat(matcherQueryParam.group(3)).concat(":").concat(matcherQueryParam.group(3) + _addPageRef);
        				paramList.append(newparam);
        				
        				
        			    }
        			}
        		    }
			    dynScrTableColsCO.setParamList(paramList.toString());
			    dynScrTableColsCO.setActionName("/path/dynamicScreen/dynLookupAction_constructGridWidgetLookup?");
			    //TP#1042327 Fix missing validation on lookup when lookupDesc is empty
			    //Adding dependency for LiveSearch ColProp
			    dependencySrc.append("path/dynamicScreen/dynDependencyAction_dynLookupDependency");
                    dependencyList.append("criteria.elemHm.colValue").append(":").append(colTechName);
	        	    dependencyParamList.append("criteria.elemHm.elementId:").append("~CONST_").append(elementId+_addPageRef);
	        	    dependencyParamList.append(",").append("criteria.elemHm.colName:").append("~CONST_").append(columnCode);
	        	    dependencyParamList.append(",").append("criteria.elemHm.colTechName:").append("~CONST_").append(colTechName);
	        	    dependencyParamList.append(",").append("criteria.elemHm.colValue:").append(colTechName);
	        	    dependencyParamList.append(",").append("criteria.elemHm.colType:").append("~CONST_").append(colType);
	        	    dependencyParamList.append(",criteria.elemHm.screenParamMap:returnLookupScreenParamMap('"+colTechName+"_"+dynScreenCreatorCO.getTheId()+_addPageRef+"')");
	        	    if(newparam!=null)
	        	    {
	        		dependencyParamList.append(newparam);
	        	    }
	        	    //TP#1053820 dependency for lookupdesc
	        	    if(StringUtil.isNotEmpty(colDesc))
	        	    {
	        			dependencyList.append(",").append("criteria.elemHm.colDescValue").append(":").append(colDesc).append(":").append("criteria.elemHm.colDescReadOnly");
	        			dependencyParamList.append(",").append("criteria.elemHm.colDesc:").append("~CONST_").append(columnDesc);
	        	    }
	        	    //TP#1053820 add dependency for addLkpDesc in colProp
	        	    if(obj!=null && obj.has("addLkpDesc"))
	        	    {
	        			dependencyForAdditionalLookupDesc( obj,dependencyList, dependencyParamList,true);
	        	    }
			    dynScrTableColsCO.setResultList(resultList.toString());
			    dynScrTableColsCO.setDependencySrc(dependencySrc.toString());
			    dynScrTableColsCO.setDependency(dependencyList.toString());
			    dynScrTableColsCO.setParameter(dependencyParamList.toString());
			    //dynScrTableColsCO.setResultList(resultList.toString());
			    dynScrTableColsCO.setSearchElement(columnCode);
			}
		}
		
		//we will use col type 0 if its live search
		if(gridColsPropsHm !=null && !queryData.isEmpty())
		{
		    dynScrTableColsCO.setCOL_TYPE("0");
		    dynScrTableColsCO.setCOL_TYPE_DESC("liveSearch");
		}
		else if(dynScrTableColsCO.getCOL_TYPE().equals("1"))
		{
		    dynScrTableColsCO.setCOL_TYPE_DESC("text");
		}
		else if(dynScrTableColsCO.getCOL_TYPE().equals("3"))
		{
		    dynScrTableColsCO.setCOL_TYPE_DESC("number");
		}
		else if(dynScrTableColsCO.getCOL_TYPE().equals("2") || gridColList.get(i).getCOL_TYPE().equals("5"))
		{
		    dynScrTableColsCO.setCOL_TYPE_DESC("date");
		}
		else if(dynScrTableColsCO.getCOL_TYPE().equals("4"))
		{
		    dynScrTableColsCO.setCOL_TYPE_DESC("checkbox");
		}

		if(dynScrTableColsCO.getVISIBLE_YN().intValue() == 1)
		{
		    dynScrTableColsCO.setHIDDEN("false");
		}
		else
		{
		    dynScrTableColsCO.setHIDDEN("true");
		}
		
		/* SUPT190250 ,Vysakh,13/11/2019,BEGIN */
		if(gridColsPropsHm != null && gridColsPropsHm.get("VISIBILITY_YN") != null)
		{
		    visibility = gridColsPropsHm.get("VISIBILITY_YN").toString();

		    if(visibility.equals("1"))
		    {
			dynScrTableColsCO.setHIDDEN("false");
		    }
		    else
		    {
			dynScrTableColsCO.setHIDDEN("true");
		    }

		}
		if(gridColsPropsHm != null
			&& (gridColsPropsHm.get("FOOTER_DESC") != null || gridColsPropsHm.get("AGGREGATE") != null))
		{
		    if(StringUtil.isNotEmpty(gridColsPropsHm.get("FOOTER_DESC").toString())
			    || ( StringUtil.isNotEmpty(gridColsPropsHm.get("AGGREGATE").toString()) 
				    && !gridColsPropsHm.get("AGGREGATE").toString().equals("0")))
		    {
			paramVO.setFooterRow("true");
		    }
		}

		if(gridColsPropsHm != null
			&& (gridColsPropsHm.get("SOURCE_MAPPING_CODE") != null || gridColsPropsHm.get("SOURCE_MAPPING_CODE") != null))
		{
		    if (gridColsPropsHm.get("SOURCE_MAPPING_CODE".toString()).equals("2") || 
			gridColsPropsHm.get("SOURCE_MAPPING_CODE".toString()).equals("3") ||
			gridColsPropsHm.get("SOURCE_MAPPING_CODE".toString()).equals("4") )
		    {
			paramVO.setDefaultValueAvailable("true");
		    }
		    
		    if (gridColsPropsHm.get("SOURCE_MAPPING_CODE".toString()).equals("2"))
		    {
			dynScrTableColsCO.setENABLE_FIELD("false");
//			dynScrTableColsCO.setNUMBER_FORMAT("###,##0");
		    }
		    else
		    {
			dynScrTableColsCO.setENABLE_FIELD("true");
		    }
		    
		}
		
		if(gridColsPropsHm != null
			&& (gridColsPropsHm.get("COL_FORMAT") != null || gridColsPropsHm.get("COL_FORMAT") != null))
		{
			dynScrTableColsCO.setNbFormat(gridColsPropsHm.get("COL_FORMAT").toString());
		}
		/* SUPT190250 ,Vysakh,13/11/2019,END */
		
		CommonLibSC sc = new CommonLibSC();
		sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
		sc.setProgRef(ConstantsCommon.PROGREF_ROOT);
		sc.setKeyLabelCode(gridColList.get(i).getCOL_DESC());
		sc.setLanguage(returnSessionObject().getLanguage());
		String transMessage = returnCommonLibBO().returnKeyLabelTrans(sc);
		gridColList.get(i).setCOL_DESC(transMessage);
	    }
	    DynScrTableColsCO tableColsCO = new DynScrTableColsCO();
	    
	    tableColsCO = new DynScrTableColsCO();
	    tableColsCO.setCOL_TECH_NAME("DATE_UPDATED");
	    tableColsCO.setCOL_DESC("DATE_UPDATED");
	    tableColsCO.setCOL_TYPE_DESC("text");
	    tableColsCO.setCOL_TYPE(ConstantsCommon.ONE);
	    tableColsCO.setHIDDEN(ConstantsCommon.TRUE);
	    gridColList.add(tableColsCO);
	    
	    tableColsCO = new DynScrTableColsCO();
	    tableColsCO.setCOL_TECH_NAME("PRIMARY_COL");
	    tableColsCO.setCOL_DESC("PRIMARY_COL");
	    tableColsCO.setCOL_TYPE_DESC("text");
	    tableColsCO.setCOL_TYPE(ConstantsCommon.ONE);
	    tableColsCO.setHIDDEN(ConstantsCommon.TRUE);
	    gridColList.add(tableColsCO);
	    
	    paramVO.setColsLst(gridColList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

    }

    /**
     * Vysakh,SUPT190250
     * 
     * @return
     */
    public String returnGridColumnDefaultValue()
    {
	try
	{
	    if(StringUtil.isNotEmpty(getColNames()))
	    {

		String[] colList = StringUtil.toStringArray(getColNames(), ",");

		ScreenGeneratorSC screenGeneratorSC = new ScreenGeneratorSC();
		screenGeneratorSC.setFormatFieldId(getScreenFieldID());
		screenGeneratorSC.setScreenId(getScreenId());
		String colProps = dynamicScreenBO.returnColProps(screenGeneratorSC);

		if (StringUtil.isNotEmpty(colProps))
		{
		    	rowData = new JSONObject();
        		JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(colProps);
        		JSONArray jsonModel = jsonFilter.getJSONArray("root");
        		Object[] modelArr = jsonModel.toArray();
        
        		Object[] gridArr;
        
        		JSONObject jsonFilter2 = (JSONObject) JSONSerializer.toJSON(gridDetailsData);
        		JSONArray jsonModel2 = jsonFilter2.getJSONArray("root");
        		gridArr = jsonModel2.toArray();
        
        		String sourceMappingCode = "", mappedValue = "", columnTechnicalName = "";
        		BigDecimal gridColumnMaxValue = BigDecimal.ZERO, gridColumnValue = BigDecimal.ZERO;
        		SessionCO sessionCO = returnSessionObject();
        
        		for(String colName : colList)
        		{
        		    for(int i = 0; i < modelArr.length; i++)
        		    {
        			JSONObject obj = (JSONObject) modelArr[i];
        			HashMap<String, Object> gridColsElemHm = (HashMap<String, Object>) new ObjectMapper()
        				.readValue(obj.toString(), HashMap.class);
        
        			columnTechnicalName = (String) gridColsElemHm.get("COL_TECH_NAME");
        			if(columnTechnicalName.equals(colName) && gridColsElemHm != null )
        			{
        			    if (gridColsElemHm.get("SOURCE_MAPPING_CODE") != null && gridColsElemHm.get("MAPPING_ELMNT_ID") != null)
        			    {	
                			    sourceMappingCode = gridColsElemHm.get("SOURCE_MAPPING_CODE").toString();
                			    mappedValue = gridColsElemHm.get("MAPPING_ELMNT_ID").toString();
                
                			    switch (sourceMappingCode)
                			    {
                				case "2": // Auto generated
                				    for(int j = 0; j < gridArr.length; j++)
                				    {
                					JSONObject obj2 = (JSONObject) gridArr[j];
                					HashMap<String, Object> gridDataElemHm = (HashMap<String, Object>) new ObjectMapper()
                						.readValue(obj2.toString(), HashMap.class);
                
                					if (StringUtil.isNotEmpty(gridDataElemHm.get(columnTechnicalName).toString()))
                					{
                        					gridColumnValue = new BigDecimal(
                        						gridDataElemHm.get(columnTechnicalName).toString());
                        
                        					if(gridColumnValue.compareTo(gridColumnMaxValue) > 0)
                        					{
                        					    gridColumnMaxValue = gridColumnValue;
                        					}
                					}
                				    }
                
                				    gridColumnMaxValue = gridColumnMaxValue.add(BigDecimal.ONE);
                				    rowData.element(colName, StringUtil.nullToEmpty(gridColumnMaxValue.toString()));
                				    break;
                				case "3": // Session Variable
                				    // TP#897711 SUPT190250 - Nazim Jassar ; 11/12/2019
        					    Object sessionAttrObj = null;
        					    if(StringUtil.isNotEmpty(mappedValue))
        						sessionAttrObj = PathPropertyUtil.returnProperty(sessionCO,mappedValue);
                
                				    if(sessionAttrObj != null)
                				    {
                					if(sessionAttrObj instanceof String)
                					{
                					    rowData.element(colName, (String) sessionAttrObj);
                					}
                					else if(sessionAttrObj instanceof Date)
                					{
                					    rowData.element(colName, (DateUtil.format((Date) sessionAttrObj)));
                					}
                					else if(sessionAttrObj instanceof BigDecimal)
                					{
                					    rowData.element(colName, ((BigDecimal) sessionAttrObj).toString());
                					}
                				    }
                
                				    break;
                				case "4": // Screen Element
                
        					    // TP#897711 SUPT190250 - Nazim Jassar ; 11/12/2019
        					    SYS_DYN_SCREEN_ELEMENTS_DETVO aSYS_DYN_SCREEN_ELEMENTS_DETVO = null;
        					    if(StringUtil.isNotEmpty(mappedValue))
        						aSYS_DYN_SCREEN_ELEMENTS_DETVO = dynamicScreenBO
        							.returnColumnPropertyValue(new BigDecimal(mappedValue), "name");

                
                				    if (aSYS_DYN_SCREEN_ELEMENTS_DETVO != null)
                				    {
                					if(StringUtil.isEmptyString(aSYS_DYN_SCREEN_ELEMENTS_DETVO.getPROPERTY_VALUE()))
                					{
                					    aSYS_DYN_SCREEN_ELEMENTS_DETVO = dynamicScreenBO
            							.returnColumnPropertyValue(new BigDecimal(mappedValue), "id");
                					    aSYS_DYN_SCREEN_ELEMENTS_DETVO.setPROPERTY_VALUE("dynElem_".concat(aSYS_DYN_SCREEN_ELEMENTS_DETVO.getPROPERTY_VALUE()));
                					}
                					
                        				rowData.element(colName, StringUtil.nullToEmpty(
                        					    scrElemHm.get(aSYS_DYN_SCREEN_ELEMENTS_DETVO.getPROPERTY_VALUE())));
                				    }
                				    else
                				    {
                					rowData.element(colName, "");
                				    }
                				    break;
                				case "5":
                				    rowData.element(colName, "");
                				    break;
                
                			    }
        			 }
        			}
        		    }
        		}
        	    }
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    // TP#897711 SUPT190250 - Nazim Jassar ; 29/11/2019 [START]
    public String updateDynamicRowFooter()
    {
	try
	{
	    if(StringUtil.isNotEmpty(getColNames()))
	    {
		ScreenGeneratorSC screenGeneratorSC = new ScreenGeneratorSC();
		screenGeneratorSC.setFormatFieldId(getScreenFieldID());
		screenGeneratorSC.setScreenId(getScreenId());
		String colProps = dynamicScreenBO.returnColProps(screenGeneratorSC);
		if (StringUtil.isNotEmpty(colProps))
		{
        		JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(colProps);
        		JSONArray jsonModel = jsonFilter.getJSONArray("root");
        		Object[] modelArr = jsonModel.toArray();
        		ColumnWiseProcessor avgOperation = new ColumnWiseProcessor();
        		ColumnWiseProcessor aggregateOperation = new ColumnWiseProcessor();
        		for(int i = 0; i < modelArr.length; i++)
        		{
        		    JSONObject obj = (JSONObject) modelArr[i];
        		    HashMap<String, Object> gridColsElemHm = (HashMap<String, Object>) new ObjectMapper()
        			    .readValue(obj.toString(), HashMap.class);
        		    // TP#897711 SUPT190250 - Nazim Jassar ; 11/12/2019
        		    if(gridColsElemHm.get("AGGREGATE_CODE") != null && 
            			!gridColsElemHm.get("AGGREGATE_CODE").equals(""))
    				    addToColumnProcessor(gridColsElemHm.get("COL_TECH_NAME").toString(),
        			    gridColsElemHm.get("AGGREGATE_CODE").toString(), avgOperation, aggregateOperation);
        		    
        		}
        		processGridData(avgOperation, aggregateOperation);
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    private void processGridData(ColumnWiseProcessor avgColumn, ColumnWiseProcessor sumColumn)

    {
	try
	{

	    String[] colList = StringUtil.toStringArray(getColNames(), ",");
	    JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(gridDetailsData);
	    JSONArray jsonModel = jsonFilter.getJSONArray("root");
	    Object[] modelArr = jsonModel.toArray();
	    String colValue = "";
	    rowData = new JSONObject();
	    
	    for(String colName : colList)
	    {
		for(int i = 0; i < modelArr.length; i++)
		{
		    JSONObject obj = (JSONObject) modelArr[i];
		    HashMap<String, Object> gridColsElemHm = (HashMap<String, Object>) new ObjectMapper()
			    .readValue(obj.toString(), HashMap.class);
		    // TP#897711 SUPT190250 - Nazim Jassar ; 11/12/2019
		    if(gridColsElemHm.get(colName) != null)
		    {
        		    colValue = gridColsElemHm.get(colName).toString();
        		    avgColumn.inputAndProcess(colName, colValue);
        		    sumColumn.inputAndProcess(colName, colValue);
		    }
		}
	    }
	    for(String colName : colList)
	    {
		if(avgColumn.getColumnProcessor(colName) != null)
		{
		    rowData.element(colName,NumberUtil.nullToZero(avgColumn.getColumnProcessor(colName).result()));
		}
		
		if(sumColumn.getColumnProcessor(colName) != null)
		{
		    rowData.element(colName,NumberUtil.nullToZero(sumColumn.getColumnProcessor(colName).result()));
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
    }

    private void addToColumnProcessor(String columnName, String aggregate, ColumnWiseProcessor avgColumn,
	    ColumnWiseProcessor sumColumn)
    {
	if(ConstantsCommon.AVERAGE.equals(aggregate))
	{
	    avgColumn.addToColumnProcessor(columnName, new ColumnAvgOperation());
	}

	else if(ConstantsCommon.SUM.equals(aggregate))
	{
	    sumColumn.addToColumnProcessor(columnName, new ColumnAggregateOperation());
	}

    }

    // TP#897711 SUPT190250 - Nazim Jassar ; 29/11/2019 [END]
    
    /*
     * TP 853476. Dynamic Screen Grid Loading From Rest Serivce [Muhammad.Asif]
     * @param 	DynamicScreenCreatorCO dynScreenCreatorCO
     * 			DynamicParamsVO paramVO
     * 			JSONObject obj
     */
      private void fillGridWidgetFromRestService(DynamicScreenCreatorCO dynScreenCreatorCO, DynamicParamsVO paramVO,JSONObject obj)
      {
  	try
  	{
       
  	    JSONArray  jsonParamArr = obj.getJSONArray("parameterGridData");
  	    if (jsonParamArr != null) 
  	    {
  	    //TP#1070377
  		String paramList  = "[";
  		for (Object jObject : jsonParamArr)
  		{            	
  		    JSONObject jsonObject = (JSONObject) jObject;
  		    String paramType = jsonObject.getString("sysParamGlobalActArgMapVO.MAP_TYPE");
  		    String screenParamName = StringUtil.nullToEmpty(jsonObject.getString("mapDescription")) ;

  		    if (ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(paramType) )
  		    {
  			paramList += "'"+screenParamName+"'";
  		    }
  		}
  		paramList+= "]";
  		paramVO.setParamList(paramList);
  	    }
  	    JSONArray  jsonArray = obj.getJSONArray("parameterOutGridData");
  	    List<DynGridOutParameterCO> listCO = new ArrayList<DynGridOutParameterCO>();         
  	    if (jsonArray != null)
  	    {
  	    	 for (Object object : jsonArray)
             {
             	JSONObject jsonObject = (JSONObject) object; 
             	DynGridOutParameterCO co = new DynGridOutParameterCO();
                if (jsonObject.has("COL_DATA_TYPE") )
                {
             	   co.setColDataType(jsonObject.getString("COL_DATA_TYPE"));
             	   co.setColDescription(jsonObject.getString("COL_DESCRIPTION"));
             	   co.setColTechName(jsonObject.getString("COL_TECH_NAME").toUpperCase());
             	   co.setRestListProperties(jsonObject.getString("REST_LIST_PROPERTIES"));
             	   co.setColFormat(jsonObject.getString("COL_FORMAT"));
             	   listCO.add(co);
                }
             }
  	    }
  	    List<DynScrTableColsCO> gridColList = new ArrayList<DynScrTableColsCO>();
  	    DynScrTableColsCO tableColsCO = new DynScrTableColsCO();
  	    
  	    DynScreenQueryCO dynScreenQueryCO = new DynScreenQueryCO();
  	    
  	    if(dynScreenCreatorCO.getElementType() != null && ConstantsCommon.ELEMENT_TYPE_GRID.equals(dynScreenCreatorCO.getElementType().toString()))
  	    {
  	    	dynScreenQueryCO.setElementType(dynScreenCreatorCO.getElementType().toString());
  	    }	
  	    else
  	    {	
  			String columnCode = obj.getString("columnCode");
  			String columnDesc = obj.getString("columnDesc");
  			dynScreenQueryCO.setColumnCode(columnCode);
  			dynScreenQueryCO.setColumnDesc(columnDesc);
  	    }
  	    // loop through grid columns and set needed properties	    
  	    for (DynGridOutParameterCO dynGridOutParameterCO : listCO ) 
  	    {
  			String theKey = dynGridOutParameterCO.getColDescription();
  			String type = dynGridOutParameterCO.getColDataType();
  			
  			tableColsCO.setCOL_TECH_NAME(dynGridOutParameterCO.getColTechName());
  			tableColsCO.setCOL_DESC(getText(theKey));
  			tableColsCO.setHIDDEN("false");		
  			if("N".equals(type) || "Numeric".equalsIgnoreCase(type) )
  			{
  			    tableColsCO.setCOL_TYPE("3");
  			    tableColsCO.setCOL_TYPE_DESC("number");
  			    tableColsCO.setNbFormat(dynGridOutParameterCO.getColFormat());
  			}
  			else if("V".equals(type) || "Varchar".equalsIgnoreCase(type))
  			{
  			    tableColsCO.setCOL_TYPE("1");
  			    tableColsCO.setCOL_TYPE_DESC("text");
  			}
  			else if("T".equals(type) || "Date".equalsIgnoreCase(type))
  			{
  			    tableColsCO.setCOL_TYPE("2");
  			    tableColsCO.setCOL_TYPE_DESC("date");
  			}
  			gridColList.add(tableColsCO);
  			tableColsCO = new DynScrTableColsCO();
  	    }
  	    
  	    paramVO.setColsLst(gridColList);
  	    returnSerializedStrFromObj(gridColList);
  	    paramVO.setValue(dynScreenCreatorCO.getElementId().toString());
  	    paramVO.setElement_dataType("RestService");
  	    paramVO.setEditable("false");
  	}
  	catch(Exception e)
  	{
  	    handleException(e, null, null);
  	}
      }
      /**
       * TP#1053821
       * Handle dependency for additional lookup Description
       */
      private void dependencyForAdditionalLookupDesc(JSONObject obj ,StringBuffer dependencyList,StringBuffer dependencyParamList,boolean fromColumnProp )
      {
	  String _addPageRef = StringUtil.nullToEmpty(get_pageRef()).isEmpty() ? "" : "_" + get_pageRef();
	  String addLkpDesc = obj.getString("addLkpDesc").replace("\\" ,"");
	  //dependency for addLkpDesc
	  JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(addLkpDesc);
	  JSONArray  jsonPropArr    = jsonFilter.getJSONArray("root");
	  Object[] addLkpDescArr  = jsonPropArr.toArray();
	  JSONObject lkpDescElem;
	  String lkpIds="";
	  for(int index=0;index<addLkpDescArr.length;index++)
	  {

	      lkpDescElem = (JSONObject)addLkpDescArr[index];
	      if(!lkpDescElem.isEmpty())
	      {
		  String lkpId =  lkpDescElem.get("DESC_COLUMN").toString();
		  String screenElementId =  lkpDescElem.getString("ELEMENT_ID").toString(); 
		  lkpIds += (lkpIds.length()>0) ?  ";"+screenElementId+"~VALUE_"+lkpId : screenElementId+"~VALUE_"+lkpId;
		  if(fromColumnProp)
		  {
		      dependencyList.append(",").append("criteria.elemHm." + screenElementId).append(":").append(screenElementId).append(_addPageRef);
		  }
		  else
		  {
		      dependencyList.append(",").append(screenElementId).append(_addPageRef).append(":").append("criteria.elemHm." + screenElementId);
		  }

	      }
	  }
	  dependencyParamList.append(",").append("criteria.elemHm.addLkpDesc").append(":").append("~CONST_").append(lkpIds);
      }
    /**
     * @return the criteria
     */
    public ScreenGeneratorSC getCriteria()
    {
        return criteria;
    }
    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(ScreenGeneratorSC criteria)
    {
        this.criteria = criteria;
    }
    /**
     * @return the formLst
     */
    public ArrayList<DynamicParamsVO> getFormLst()
    {
        return formLst;
    }
    /**
     * @param formLst the formLst to set
     */
    public void setFormLst(ArrayList<DynamicParamsVO> formLst)
    {
        this.formLst = formLst;
    }

    /**
     * @param generatorBO the generatorBO to set
     */
    public void setGeneratorBO(GeneratorBO generatorBO)
    {
        this.generatorBO = generatorBO;
    }

    /**
     * @return the optionsDataMap
     */
    public Map<String, List<SelectCO>> getOptionsDataMap()
    {
        return optionsDataMap;
    }

    /**
     * @param optionsDataMap the optionsDataMap to set
     */
    public void setOptionsDataMap(Map<String, List<SelectCO>> optionsDataMap)
    {
        this.optionsDataMap = optionsDataMap;
    }

    public List<SelectCO> getMapTypeList()
    {
        return mapTypeList;
    }

    public void setMapTypeList(List<SelectCO> mapTypeList)
    {
        this.mapTypeList = mapTypeList;
    }

    /**
     * @param dynamicScreenBO the dynamicScreenBO to set
     */
    public void setDynamicScreenBO(DynamicScreenBO dynamicScreenBO)
    {
        this.dynamicScreenBO = dynamicScreenBO;
    }

    /**
     * @return the dynamicScreenParamsMapCO
     */
    public DynamicScreenParamsMapCO getDynamicScreenParamsMapCO()
    {
        return dynamicScreenParamsMapCO;
    }

    /**
     * @param dynamicScreenParamsMapCO the dynamicScreenParamsMapCO to set
     */
    public void setDynamicScreenParamsMapCO(DynamicScreenParamsMapCO dynamicScreenParamsMapCO)
    {
        this.dynamicScreenParamsMapCO = dynamicScreenParamsMapCO;
    }

    /**
     * @return the scrElemHm
     */
    public Map<String, String> getScrElemHm()
    {
        return scrElemHm;
    }

    /**
     * @param scrElemHm the scrElemHm to set
     */
    public void setScrElemHm(Map<String, String> scrElemHm)
    {
	this.scrElemHm = scrElemHm;
    }

    public List<DynScrTableColsCO> getColsLst()
    {
	return colsLst;
    }

    public void setColsLst(List<DynScrTableColsCO> colsLst)
    {
	this.colsLst = colsLst;
    }

    public List<SelectCO> getDynParamMapList()
    {
	return dynParamMapList;
    }

    public void setDynParamMapList(List<SelectCO> dynParamMapList)
    {
	this.dynParamMapList = dynParamMapList;
    }

    /**
     * @return the changeTrack
     */
    public String getChangeTrack()
    {
	return changeTrack;
    }

    /**
     * @param changeTrack the changeTrack to set
     */
    public void setChangeTrack(String changeTrack)
    {
	this.changeTrack = changeTrack;
    }

    public Map<String,DynamicScreenFileCO> getDynFileElemHm()
    {
	return dynFileElemHm;
    }

    public void setDynFileElemHm(Map<String,DynamicScreenFileCO> dynFileElemHm)
    {
	this.dynFileElemHm = dynFileElemHm;
    }

    public String getFileName()
    {
	return fileName;
    }

    public void setFileName(String fileName)
    {
	this.fileName = fileName;
    }

    public InputStream getExportStream()
    {
	return exportStream;
    }

    public void setExportStream(InputStream exportStream)
    {
	this.exportStream = exportStream;
    }

    public BigDecimal getScrGridFlag()
    {
	return scrGridFlag;
    }

    public void setScrGridFlag(BigDecimal scrGridFlag)
    {
	this.scrGridFlag = scrGridFlag;
    }

    public Map<String, String> getGridElemHm()
    {
        return gridElemHm;
    }

    public void setGridElemHm(Map<String, String> gridElemHm)
    {
        this.gridElemHm = gridElemHm;
    }

    /**
     * @return the hasHiddenOpt
     */
    public String getHasHiddenOpt()
    {
        return hasHiddenOpt;
    }

    /**
     * @param hasHiddenOpt the hasHiddenOpt to set
     */
    public void setHasHiddenOpt(String hasHiddenOpt)
    {
        this.hasHiddenOpt = hasHiddenOpt;
    }

    public List<DynamicScreenCreatorCO> getDataLst()
    {
        return dataLst;
    }

    public void setDataLst(List<DynamicScreenCreatorCO> dataLst)
    {
        this.dataLst = dataLst;
    }

    public List<SelectCO> getSelectionTypeList()
    {
        return selectionTypeList;
    }

    public void setSelectionTypeList(List<SelectCO> selectionTypeList)
    {
        this.selectionTypeList = selectionTypeList;
    }
   
    public String getScreenFieldID()
    {
	return screenFieldID;
    }

    public void setScreenFieldID(String screenFieldID)
    {
	this.screenFieldID = screenFieldID;
    }

    public String getColNames()
    {
	return colNames;
    }

    public void setColNames(String colNames)
    {
	this.colNames = colNames;
    }

    public JSONObject getRowData()
    {
	return rowData;
    }

    public void setRowData(JSONObject rowData)
    {
	this.rowData = rowData;
    }
    public String getGridDetailsData()
    {
	return gridDetailsData;
    }

    public void setGridDetailsData(String gridDetailsData)
    {
	this.gridDetailsData = gridDetailsData;
    }

    public BigDecimal getScreenId()
    {
	return screenId;
    }

    public void setScreenId(BigDecimal screenId)
    {
	this.screenId = screenId;
    }    

    /**
     * @return the screenEntityTypeInfosList
     */
    public List<String> getScreenEntityTypeInfosList()
    {
	return screenEntityTypeInfosList;
    }

    /**
     * @param screenEntityTypeInfosList the screenEntityTypeInfosList to set
     */
    public void setScreenEntityTypeInfosList(List<String> screenEntityTypeInfosList)
    {
	this.screenEntityTypeInfosList = screenEntityTypeInfosList;
    }

    /**
     * @return the parentScreenParams
     */
    public String getParentScreenParams()
    {
	return parentScreenParams;
    }

    /**
     * @param parentScreenParams the parentScreenParams to set
     */
    public void setParentScreenParams(String parentScreenParams)
    {
	this.parentScreenParams = parentScreenParams;
    }

}
