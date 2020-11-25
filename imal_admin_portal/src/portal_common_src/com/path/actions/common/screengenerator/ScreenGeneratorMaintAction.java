package com.path.actions.common.screengenerator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.screengenerator.GeneratorBO;
import com.path.bo.common.screengenerator.ScreenGeneratorBO;
import com.path.dbmaps.vo.SYS_DYN_SCREEN_ELEMENTS_DETVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.screengenerator.DynButtonSourceCO;
import com.path.vo.common.screengenerator.DynScrTableColsCO;
import com.path.vo.common.screengenerator.DynScrTablesCO;
import com.path.vo.common.screengenerator.DynamicScreenCreatorCO;
import com.path.vo.common.screengenerator.DynamicScreenDetailsCO;
import com.path.vo.common.screengenerator.LoadScriptCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
import com.path.vo.common.select.SelectCO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * ScreenGeneratorMaintAction.java used to
 */
public class ScreenGeneratorMaintAction extends BaseAction
{
    private ScreenGeneratorSC criteria = new ScreenGeneratorSC();
    private String screenData;
    private String optionalData;
    private String additionalData;
    private String TEMPLATE_NAME;
    private String TEMPLATE_ID;
    private String actionType;
    public  String autoCompleteTags;
    public  String autoCompleteGridTags;
    private DynamicScreenCreatorCO dynScreenCreatorCO  = new DynamicScreenCreatorCO();
    
    private DynButtonSourceCO dynButtonSourceCO   = new DynButtonSourceCO();
    private List<SelectCO>    btnSourceList       = new ArrayList<SelectCO>();

    private LoadScriptCO      loadScriptCO        = new LoadScriptCO();
    
    private GeneratorBO       generatorBO;
    private ScreenGeneratorBO screenGeneratorBO;
    private String      fileName;
    private InputStream exportStream;
    private InputStream errorStream;
    private static final String EXPORT_FILE_ENC_PASS = "path_exp_dynFile";
    
    private boolean showConfirmation;
    private String  confirmationResponse;
    private File    uploadFile;
    private DynScrTablesCO dynScrTablesCO; 
    private String dynScrTableGridUpdates;
    private Boolean _scrGridFlagEnabled = true;
    private Boolean _omniChannelFlag = Boolean.FALSE;

    @Override
    public Object getModel()
    {
	return dynScreenCreatorCO;
    }
    /**
     * Used to open the Dynamic Screen Generator.
     * @author marwanmaddah
     * @date   Dec 3, 2015
     * @return String
     *
     */
    public String loadScreenGeneratorPage()
    {
	try
	{
	    String screenGenAccessRight = returnAccessRightByProgRef(ConstantsCommon.DYN_SCR_GEN_OPT);
	    if(screenGenAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }

	    set_searchGridId("screenGeneratorListGridTbl_Id");
	    SessionCO sessionCO = returnSessionObject();
	    String appName = sessionCO.getCurrentAppName();
	    if("OADM".equals(appName))
	    {
		set_omniChannelFlag(Boolean.TRUE);
	    }
	    Map<String, Object> tags = CommonMethods.returnBoolExpressionDataList(null).get(0);
	    Iterator<String> it = tags.keySet().iterator();
	    StringBuffer theTags = new StringBuffer();
	    while(it.hasNext())
	    {
		String value = it.next();
		if(!theTags.toString().isEmpty())
		{
		   theTags.append(",");
		}
		theTags.append("\""+value+"\"");	    
	    }
	    // operators adding
	    theTags.append(",\"AND\",\"OR\"");
	    setAutoCompleteTags(theTags.toString());
	    
	    
	    /* define autocomplete grid tags */
	    StringBuffer theGridTags = new StringBuffer();
	    Iterator<String> gridIt = tags.keySet().iterator();
	    while(gridIt.hasNext())
	    {
		String value = gridIt.next();
		if(!theGridTags.toString().isEmpty())
		{
		    theGridTags.append(",");
		}
		theGridTags.append("\"[session."+value+"]\"");	    
	    }
	    // operators adding
	    theGridTags.append(",\"AND\",\"OR\"");
	    setAutoCompleteGridTags(theGridTags.toString());
	    
	    
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    return ERROR_ACTION;
	}
	return "screenGeneratorList";
    }

    /**
     * 
     * @return
     * @throws BaseException
     */
    public String initialize()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    String appName = sessionCO.getCurrentAppName();
	    if("OADM".equals(appName))
	    {
		set_omniChannelFlag(Boolean.TRUE);
	    }
	    
	    setActionType("saveNew");
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    return ERROR_ACTION;
	}
	return SUCCESS;
    }

    /**
     * prepare data, and fill the form on dbClick on a record from the grid.
     * 
     * @return
     */
    public String edit()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    
	    if("OADM".equals(sessionCO.getCurrentAppName()))
	    {
		set_omniChannelFlag(Boolean.TRUE);
	    }
	    
	    Boolean createFrom = dynScreenCreatorCO.getCreateFrom(); 
	    dynScreenCreatorCO = generatorBO.returnScreenMainInfo(criteria);
	    if(createFrom!=null && createFrom)
	    {
		dynScreenCreatorCO.getSysDynScreenDefVO().setDYN_SCREEN_DESC(null);
		dynScreenCreatorCO.setCreateFrom(createFrom);
		setActionType("saveNew");
	    }
	    else
	    {
        	if(dynScreenCreatorCO.getScrTableId()!=null)
        	{
        		_scrGridFlagEnabled = false;
        	}    	
		setActionType("update");
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    /**
     * 
     * @author marwanmaddah
     * @date   Feb 18, 2016
     * @return String
     *
     */
    public String loadBtnSourceScreen()
    {
	try{
	    if(!StringUtil.nullToEmpty(criteria.getSourceData()).isEmpty())
	    {
	       JSONArray  jsonQueryModel = (JSONArray) JSONSerializer.toJSON(criteria.getSourceData());
	       Object[]   modelArr = jsonQueryModel.toArray();
	       JSONObject obj      = (JSONObject) modelArr[0];
	       obj.remove("scrParamMapGridUpdate");
	       dynButtonSourceCO   = (DynButtonSourceCO) JSONObject.toBean(obj, DynButtonSourceCO.class);
	    }
	    
	    if(StringUtil.nullToEmpty(dynButtonSourceCO.getSourceType()).isEmpty())
	    {
		if(ConstantsCommon.ONE.equals(criteria.getForChange()))
		{
		    dynButtonSourceCO.setSourceType(ConstantsCommon.SCRIPT_BTN_SOURCE);
		}
		else
		{		    
		    dynButtonSourceCO.setSourceType(ConstantsCommon.INTERNAL_SCREEN_BTN_SOURCE); 
		}
	    }
	    
	    dynButtonSourceCO = screenGeneratorBO.changeLayoutBasedOnSourceType(dynButtonSourceCO);
	    getAdditionalScreenParams().putAll(dynButtonSourceCO.getDisplayHm());
	    
	    SelectCO selectScriptCO    = new SelectCO();
	    selectScriptCO.setCode(ConstantsCommon.SCRIPT_BTN_SOURCE);
	    selectScriptCO.setDescValue(getText("script_key"));
	    
	    if(!ConstantsCommon.ONE.equals(criteria.getForChange()))
	    {
        	SelectCO selectScreenCO    = new SelectCO();
        	selectScreenCO.setCode(ConstantsCommon.INTERNAL_SCREEN_BTN_SOURCE);
        	selectScreenCO.setDescValue(getText("dynamic_screen_key"));
        	    
        	SelectCO selectExtScreenCO = new SelectCO();
        	selectExtScreenCO.setCode(ConstantsCommon.EXTERNEL_BTN_SOURCE);
        	selectExtScreenCO.setDescValue(getText("global_activities_key"));
        	    
        	SelectCO selectSubmitCO = new SelectCO();
        	selectSubmitCO.setCode(ConstantsCommon.SUBMIT_BTN_SOURCE);
        	selectSubmitCO.setDescValue(getText("submit_key"));
        	    
        	SelectCO selectDeleteCO = new SelectCO();
        	selectDeleteCO.setCode(ConstantsCommon.DELETE_BTN_SOURCE);
        	selectDeleteCO.setDescValue(getText("delete_key"));
        	
        	//TP#989676 Add Button Submit with Parent
        	SelectCO selectSubmitWithParentCO = new SelectCO();
        	selectSubmitWithParentCO.setCode(ConstantsCommon.SUBMIT_WITH_PARENT_BTN_SOURCE);
        	selectSubmitWithParentCO.setDescValue(getText("submit_with_parent_key"));
        	    
        	//Adel - If type grid, only show dynamic screen and script options
        	if(!criteria.getElementType().equals(ConstantsCommon.ELEMENT_TYPE_GRID))
        	{
        	    btnSourceList.add(selectSubmitCO);
        	    btnSourceList.add(selectExtScreenCO);
        	    btnSourceList.add(selectDeleteCO);
        	    //TP#989676 Add Button Submit with Parent
        	    btnSourceList.add(selectSubmitWithParentCO);
        	}
        	btnSourceList.add(selectScreenCO);
	    }
	    btnSourceList.add(selectScriptCO);

	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return "btnSourceScreen";
    }
    /**
     * used to open the on load script data screen
     * @author marwanmaddah
     * @date   Mar 7, 2016
     * @return String
     *
     */
    public String loadOnLoadScriptScreen()
    {
	try{
	    if(!StringUtil.nullToEmpty(criteria.getLoadScriptData()).isEmpty())
	    {
		JSONArray  jsonQueryModel = (JSONArray) JSONSerializer.toJSON(criteria.getLoadScriptData());
		Object[]   modelArr = jsonQueryModel.toArray();
		JSONObject obj = (JSONObject) modelArr[0];
		loadScriptCO   = (LoadScriptCO) JSONObject.toBean(obj, LoadScriptCO.class);
	    }	    
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return "onLoadScriptScreen";
    }
    /**
     * @author MarwanMaddah
     * @return
     */
    public String exportScreen()
    {
	try{
	    ScreenGeneratorSC criteria  = new ScreenGeneratorSC();
	    List<DynScrTableColsCO> colsLst = new ArrayList(); 
	    criteria.setScreenId(dynScreenCreatorCO.getSysDynScreenDefVO().getDYN_SCREEN_ID());
	    List<DynamicScreenCreatorCO> dataLst = generatorBO.returnScreenElementsData(criteria);
	    if(dataLst != null && !NumberUtil.isEmptyDecimal(dataLst.get(0).getScrTableId()) )
	    {
		criteria.setTableId(dataLst.get(0).getScrTableId());
	    	colsLst = generatorBO.returnExportedDynTablesCols(criteria);

	    }
	    String jsonScreenData = PathJSONUtil.strutsJsonSerialize(dataLst, null, null, false, true);
	    String jsonColsData = PathJSONUtil.strutsJsonSerialize(colsLst, null, null, false, true);

	    JSONObject jObj = new JSONObject();
	    jObj.put("SCREEN", jsonScreenData);
	    jObj.put("COLS", jsonColsData);

	    String screenDataStr = jObj.toString();
	    screenDataStr = SecurityUtils.encryptAES(EXPORT_FILE_ENC_PASS,screenDataStr);
	    byte[] resultBytes = screenDataStr.getBytes(FileUtil.DEFAULT_FILE_ENCODING);
	    exportStream = new ByteArrayInputStream(resultBytes);
	    setFileName("Export_DynScreen_"+dynScreenCreatorCO.getSysDynScreenDefVO().getDYN_SCREEN_ID()+".dynscr");
	    ServletActionContext.getResponse().setHeader("Set-Cookie", "fileDownload=true; path=/");
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    try
	    {
	    	setErrorStream(new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING)));
	    }
	    catch(UnsupportedEncodingException e1)
	    {
		   log.error(e1, "Error in reading the error message");
	    }
	    return "fileError";

	}
	return "exported";
    }
    /**
     * @author marwanmaddah
     * @return
     */
    public String openImportDialog()
    {
	return "openImportDialog";
    }
    /**
     * @author MarwanMaddah
     * @return
     */
    public String importScreen()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    if(uploadFile != null && uploadFile.isFile() && uploadFile.length() > 0)
	    {
		//limit the size of the file to be below of 200 MB = 200000000 bytes
		byte[] content = PathFileSecure.readFileToByteArray(uploadFile,200000000);
		String result = new String(content);
		String screenDataStr = SecurityUtils.decryptAES(EXPORT_FILE_ENC_PASS, result);
		
		Object jsonObj = JSONSerializer.toJSON(screenDataStr);
		Object[] modelArr = null;
		List<DynScrTableColsCO> colsList = new ArrayList<DynScrTableColsCO>();
		if (jsonObj instanceof JSONObject)
		{
		    JSONObject jsonRoot = (JSONObject) JSONSerializer.toJSON(screenDataStr);
		    JSONArray jsonScreenArray = (JSONArray) jsonRoot.getJSONArray("SCREEN");
		    JSONArray colsJSONArray = (JSONArray) jsonRoot.getJSONArray("COLS");
		  
    		    for (int i=0;i<colsJSONArray.size();i++)
    		    { 
    			DynScrTableColsCO dynScrTableColsCO = new DynScrTableColsCO();
    			dynScrTableColsCO.setCOL_DESC((String)colsJSONArray.getJSONObject(i).get("COL_DESC"));
    			dynScrTableColsCO.setCOL_ID(new BigDecimal(colsJSONArray.getJSONObject(i).get("COL_ID").toString()));
    			dynScrTableColsCO.setCOL_TECH_NAME((String)colsJSONArray.getJSONObject(i).get("COL_TECH_NAME"));
    			dynScrTableColsCO.setCOL_TYPE((String)colsJSONArray.getJSONObject(i).get("COL_TYPE"));
    			dynScrTableColsCO.setPRIMARY_KEY(new BigDecimal(colsJSONArray.getJSONObject(i).get("PRIMARY_KEY").toString()));
    			dynScrTableColsCO.setTABLE_DESC((String)colsJSONArray.getJSONObject(i).get("TABLE_DESC"));
    			dynScrTableColsCO.setTABLE_ID(new BigDecimal(colsJSONArray.getJSONObject(i).get("TABLE_ID").toString()));
    			dynScrTableColsCO.setTABLE_TECH_NAME((String)colsJSONArray.getJSONObject(i).get("TABLE_TECH_NAME"));
    			dynScrTableColsCO.setVISIBLE_YN(new BigDecimal(colsJSONArray.getJSONObject(i).get("VISIBLE_YN").toString()));
    			if (colsJSONArray.getJSONObject(i).get("COL_LENGTH") != null)
    			{
    			dynScrTableColsCO.setCOL_LENGTH(new BigDecimal(colsJSONArray.getJSONObject(i).get("COL_LENGTH").toString()));
    			}
    			if (colsJSONArray.getJSONObject(i).get("DECIMAL_VALUE") != null)
    			{
    			dynScrTableColsCO.setDECIMAL_VALUE(new BigDecimal(colsJSONArray.getJSONObject(i).get("DECIMAL_VALUE").toString()));
    			}
    			colsList.add(dynScrTableColsCO);
    	            } 
		    modelArr = jsonScreenArray.toArray();
		}
		else if(jsonObj instanceof JSONArray)
		{
			JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(screenDataStr);
			modelArr     = jsonModel.toArray();
		}
		
		JSONObject obj;
		List<DynamicScreenCreatorCO> dataLst = new ArrayList<DynamicScreenCreatorCO>();
		HashMap<String,Object> hm;
		String propName = null;
		Class<?> propType;		
		List<DynamicScreenDetailsCO> dynScreenDetailsLst    = new ArrayList<DynamicScreenDetailsCO>();
		HashMap<String, BigDecimal>  variablesMap           = new HashMap<String, BigDecimal>();
		DynamicScreenDetailsCO screenDetailsCO = null;
		boolean newElement   = true;
		BigDecimal elementId = null; 
		List<SYS_DYN_SCREEN_ELEMENTS_DETVO> elementDetLst = new ArrayList<SYS_DYN_SCREEN_ELEMENTS_DETVO>();
		SYS_DYN_SCREEN_ELEMENTS_DETVO newElementDet;
		List<String> propertiesLst   = new ArrayList<String>();
		List<BigDecimal> btnInternalSrc  = new ArrayList<BigDecimal>();
		List<BigDecimal> btnGlobalActSrc = new ArrayList<BigDecimal>(); 
		/**
		 * will read the JSON list which is built from the imported file
		 * and will fill the needed data inside dynScreenCreatorCO
		 * where will be dynScreenDetailsLst<screenDetailsCO>, every CO it is an element
		 * and for every element will fill List<SYS_DYN_SCREEN_ELEMENTS_DETVO> elementDetLst based on the properties.
		 */
		for(int i=0;i<modelArr.length;i++)
		{
		    obj = (JSONObject) modelArr[i];
		    if(i==0)
		    {
			dynScreenCreatorCO.getSysDynScreenDefVO().setCREATED_BY(sessionCO.getUserName());
			dynScreenCreatorCO.getSysDynScreenDefVO().setDYN_SCREEN_DESC(obj.getString("screenDesc"));
			if(obj.containsKey("onLoadScript") && obj.get("onLoadScript")!=null && !(StringUtil.nullToEmpty(obj.getString("onLoadScript")).trim()).isEmpty())
			{
			    JSONArray onLoadScriptData = (JSONArray)obj.get("onLoadScript");
			    dynScreenCreatorCO.getSysDynScreenDefVO().setON_LOAD_SCRIPT(onLoadScriptData.toString());
			}
			if(obj.containsKey("scrGridFlag") && obj.get("scrGridFlag")!=null)
			{			    
		    	dynScreenCreatorCO.setScrGridFlag(BigDecimal.valueOf(obj.getLong("scrGridFlag")));
		    	dynScreenCreatorCO.setScrTableId(BigDecimal.valueOf(obj.getLong("scrTableId")));
			}
		    }
		    BigDecimal currElemId = BigDecimal.valueOf((Integer)obj.get("elementId"));
		    if(elementId == null ||(currElemId!=null && !(currElemId).equals(elementId)))
		    {
			if(elementId!=null)
			{
			  screenDetailsCO.setElementDetLst(elementDetLst);  
			  dynScreenDetailsLst.add(screenDetailsCO);
			}
			variablesMap.put(obj.getString("theId"),new BigDecimal(obj.getString("elementType")));
			elementId = new BigDecimal((Integer)obj.get("elementId"));
			screenDetailsCO = new DynamicScreenDetailsCO();
			screenDetailsCO.setUserName(sessionCO.getUserName());
			screenDetailsCO.getSysDynScreenElemVO().setELEMENT_TYPE_CODE(obj.getString("elementType"));
			if(obj.containsKey("techId") && obj.get("techId")!=null)
			{			    
			    screenDetailsCO.getSysDynScreenElemVO().setTECH_ID(BigDecimal.valueOf(obj.getLong("techId")));
			}
			if(obj.containsKey("parentTechId") && obj.get("parentTechId")!=null)
			{			    
			    screenDetailsCO.getSysDynScreenElemVO().setPARENT_TECH_ID(BigDecimal.valueOf(obj.getLong("parentTechId")));
			}
			elementDetLst = new ArrayList<SYS_DYN_SCREEN_ELEMENTS_DETVO>(); 
		    }
		    newElementDet = new SYS_DYN_SCREEN_ELEMENTS_DETVO();
		    newElementDet.setPROPERTY_CODE(obj.getString("property_code"));		    
		    String currPropCode = obj.getString("property_code");
		    String currElemType = obj.getString("elementType");
		    String propData = currPropCode+"_"+currElemType;
		    if(!propertiesLst.contains(propData) 
		       && !ConstantsCommon.PROPERTY_CODE_LEFT.equals(currPropCode)
		       && !ConstantsCommon.PROPERTY_CODE_TOP.equals(currPropCode)
		       && !ConstantsCommon.PROPERTY_CODE_HEIGHT.equals(currPropCode)
		       && !ConstantsCommon.PROPERTY_CODE_WIDTH.equals(currPropCode))
		    {
			propertiesLst.add(propData);
		    }
		    /**
		     * In case the property is a query 
		     * will check the validation of the button source.
		     */
		    if(ConstantsCommon.PROPERTY_CODE_SOURCE.equals(currPropCode) && ConstantsCommon.ELEMENT_TYPE_BUTTON.equals(currElemType) && obj.containsKey("property_big_value") && !StringUtil.nullToEmpty(obj.getString("property_big_value")).isEmpty())
		    {
			JSONArray  bigValArr    = (JSONArray)obj.get("property_big_value");
			Object[]   bigValObjArr = bigValArr.toArray();
			JSONObject btnSource    = (JSONObject)bigValObjArr[0];
			String     sourceType   = btnSource.getString("sourceType");
			if(ConstantsCommon.INTERNAL_SCREEN_BTN_SOURCE.equals(sourceType))
			{
				String _sourceScreenId = btnSource.getString("sourceScreenId");
				if(!StringUtil.nullToEmpty(_sourceScreenId).isEmpty())
				{					
					btnInternalSrc.add(new BigDecimal(_sourceScreenId));
				}
			}
			else if(ConstantsCommon.EXTERNEL_BTN_SOURCE.equals(sourceType))
			{
				String _sourceGlobalActivityId = btnSource.getString("sourceGlobalActivityId");
				if(!StringUtil.nullToEmpty(_sourceGlobalActivityId).isEmpty())
				{					
					btnGlobalActSrc.add(new BigDecimal(_sourceGlobalActivityId));
				}
			}
		    }
		    /**
		     * 
		     */
		    if(obj.containsKey("property_big_value") && obj.getString("property_big_value")!=null && obj.getString("property_big_value").trim().length() > 0)
		    {
			newElementDet.setPROPERTY_EXPRESSION_VALUE(obj.getString("property_big_value"));
		    }
		    if(obj.containsKey("property_value") && obj.getString("property_value")!=null && obj.getString("property_value").trim().length() > 0)
		    {
			newElementDet.setPROPERTY_VALUE(obj.getString("property_value"));
		    }
		    elementDetLst.add(newElementDet);
		    if(i==(modelArr.length-1))
		    {
		       screenDetailsCO.setElementDetLst(elementDetLst);  
		       dynScreenDetailsLst.add(screenDetailsCO);
		    }
		}
		if(!dynScreenDetailsLst.isEmpty())
		{
		    dynScreenCreatorCO.setDynScreenDetailsLst(dynScreenDetailsLst);
		}
		if(!variablesMap.isEmpty())
		{		    
		    dynScreenCreatorCO.setVariablesMap(variablesMap);
		}
		CommonLibSC criteria = new CommonLibSC();
		criteria.setUserId(sessionCO.getUserName());
		criteria.setCompanyCode(sessionCO.getCompanyCode());
		criteria.setBranchCode(sessionCO.getBranchCode()); 
		criteria.setAppName(sessionCO.getCurrentAppName());
		criteria.setLanguage(sessionCO.getLanguage());
		criteria.setProgRef(ConstantsCommon.PROGREF_ROOT);
		generatorBO.checkImportedFileProperties(propertiesLst,btnInternalSrc,btnGlobalActSrc,criteria);
		List<DynScrTableColsCO> tempColsList = new ArrayList<DynScrTableColsCO>();
		if(!colsList.isEmpty())
    		{
        		ArrayList<DynScrTablesCO> dynScrTablesCOList = new ArrayList<DynScrTablesCO>();
        		String tableTechName = "";
        		
        		int colsSize = colsList.size();
        		for(int i = 0; i<colsSize; i++)
        		{
        		    if(!tableTechName.isEmpty() && !tableTechName.equals(colsList.get(i).getTABLE_TECH_NAME()))
        		    {
        			DynScrTablesCO dynScrTablesCO = new DynScrTablesCO();
        	        	dynScrTablesCO.setTABLE_TECH_NAME(colsList.get(i-1).getTABLE_TECH_NAME());
        	        	dynScrTablesCO.setTABLE_DESC(colsList.get(i-1).getTABLE_DESC());
        	        	dynScrTablesCO.setCreatedBy(dynScreenCreatorCO.getSysDynScreenDefVO().getCREATED_BY());
        	        	dynScrTablesCO.setTABLE_ID(colsList.get(i-1).getTABLE_ID());
        	        	dynScrTablesCO.setColsLst(tempColsList);
        		    	dynScrTablesCOList.add(dynScrTablesCO);
        		    	tempColsList =  new ArrayList<DynScrTableColsCO>();
        		    }
        		    tableTechName = colsList.get(i).getTABLE_TECH_NAME();
        		    tempColsList.add(colsList.get(i));
        		}
        		DynScrTablesCO dynScrTablesCO = new DynScrTablesCO();
                	dynScrTablesCO.setTABLE_TECH_NAME(tableTechName);
                	dynScrTablesCO.setTABLE_DESC(colsList.get(colsSize-1).getTABLE_DESC());
                	dynScrTablesCO.setTABLE_ID(colsList.get(colsSize-1).getTABLE_ID());
                	dynScrTablesCO.setCreatedBy(dynScreenCreatorCO.getSysDynScreenDefVO().getCREATED_BY());
                	dynScrTablesCO.setColsLst(tempColsList);
        	    	dynScrTablesCOList.add(dynScrTablesCO);
        	    	
        	    	dynScreenCreatorCO.setRespMsg(confirmationResponse);
        	    	generatorBO.importDynScrTable(dynScrTablesCOList,dynScreenCreatorCO);
    		}
		else
		{
			generatorBO.saveNew(dynScreenCreatorCO);			
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return  "fileSuccess";
    }
    /**
     * @author marwanmaddah
     * @return String
     * @UsedTo open defineDynamic screen tables to use them on submit process 
     * and to link the screen content to the tables columns 
     */
    public String loadDefineScrTablesScreen()
    {
	try{
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "loadTableGenerator";
    }
    public String loadGeneratedTblData()
    {
	try{
	    if(criteria!=null && !NumberUtil.isEmptyDecimal(criteria.getTableId()) )
	    {
		dynScrTablesCO = generatorBO.returnSelectedTableData(criteria);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "loadGeneTblMaint";
    }
    /**
     * 
     * @return
     */
    public String checkTableName()
    {
	try{	    
	    generatorBO.checkTableName(criteria);
	}
	catch(Exception e)
	{
	    criteria = new ScreenGeneratorSC();
	    handleException(e, null, null);
	}
	return "successJson";
    }
    /**
     * 
     * @return
     */
    public String generateDynScrTable()
    {
	SessionCO sessionCO = returnSessionObject();
	try
	{
	    if(!StringUtil.nullToEmpty(dynScrTableGridUpdates).isEmpty())
	    {		
		GridUpdates gu = getGridUpdates(dynScrTableGridUpdates, DynScrTableColsCO.class);
		/**
		 * [TP#1074196] - Dynamic Screen Dynamic Table Ability to update Column Characteristics Visibility, Description
		 * validate if tableId exists then add/update dynamic screen table columns record
		 */
		if(dynScrTablesCO != null && !NumberUtil.isEmptyDecimal(dynScrTablesCO.getTABLE_ID()))
		{
		    List<DynScrTableColsCO> addLst = gu.getLstAdd();
		    List<DynScrTableColsCO> modifyLst = gu.getLstModify();
		    if((addLst != null && !addLst.isEmpty()) || (modifyLst != null && !modifyLst.isEmpty()))
		    {
			ScreenGeneratorSC screenGeneratorSC = new ScreenGeneratorSC();
			screenGeneratorSC.setScrGridFlag(BigDecimal.ONE);
			screenGeneratorSC.setLovTypeId(ConstantsCommon.DATA_TYPE_LOV_TYPE);
			screenGeneratorSC.setLangCode(sessionCO.getLanguage());
			screenGeneratorSC.setTableId(dynScrTablesCO.getTABLE_ID());
			screenGeneratorSC.setTableName(dynScrTablesCO.getTABLE_TECH_NAME());
			if(addLst != null && !addLst.isEmpty())
			    dynScrTablesCO.setCreatedBy(sessionCO.getUserName());
			if(modifyLst != null && !modifyLst.isEmpty())
			    dynScrTablesCO.setModifiedBy(sessionCO.getUserName());

			generatorBO.updateDynScrTable(addLst, modifyLst, dynScrTablesCO, screenGeneratorSC);
		    }
		}
		else
		{
		    List<DynScrTableColsCO> addLst = gu.getLstAdd();
		    dynScrTablesCO.setColsLst(addLst);
		    dynScrTablesCO.setCreatedBy(sessionCO.getUserName());
		    generatorBO.generateDynScrTable(dynScrTablesCO);
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return "successJson";
	}
	return SUCCESS;
    }
    
    /**
     * 
     * @author Adel Nasrallah
     * @date   Apr 16, 2018
     * @return String
     *
     */
    public String loadColPropertiesScreen()
    {
	return "dynGridColPropMaint";
    }
    
    /**
     * @return the screenData
     */
    public String getScreenData()
    {
	return screenData;
    }

    /**
     * @param screenData the screenData to set
     */
    public void setScreenData(String screenData)
    {
	this.screenData = screenData;
    }

    /**
     * @return the optionalData
     */
    public String getOptionalData()
    {
	return optionalData;
    }

    /**
     * @param optionalData the optionalData to set
     */
    public void setOptionalData(String optionalData)
    {
	this.optionalData = optionalData;
    }

    /**
     * @return the additionalData
     */
    public String getAdditionalData()
    {
	return additionalData;
    }

    /**
     * @param additionalData the additionalData to set
     */
    public void setAdditionalData(String additionalData)
    {
	this.additionalData = additionalData;
    }

    /**
     * @return the tEMPLATE_NAME
     */
    public String getTEMPLATE_NAME()
    {
	return TEMPLATE_NAME;
    }

    /**
     * @param tEMPLATENAME the tEMPLATE_NAME to set
     */
    public void setTEMPLATE_NAME(String tEMPLATENAME)
    {
	TEMPLATE_NAME = tEMPLATENAME;
    }

    /**
     * @return the tEMPLATE_ID
     */
    public String getTEMPLATE_ID()
    {
	return TEMPLATE_ID;
    }

    /**
     * @param tEMPLATEID the tEMPLATE_ID to set
     */
    public void setTEMPLATE_ID(String tEMPLATEID)
    {
	TEMPLATE_ID = tEMPLATEID;
    }

    /**
     * @return the dynScreenCreatorCO
     */
    public DynamicScreenCreatorCO getDynScreenCreatorCO()
    {
	return dynScreenCreatorCO;
    }

    /**
     * @param dynScreenCreatorCO the dynScreenCreatorCO to set
     */
    public void setDynScreenCreatorCO(DynamicScreenCreatorCO dynScreenCreatorCO)
    {
	this.dynScreenCreatorCO = dynScreenCreatorCO;
    }

    /**
     * @return the actionType
     */
    public String getActionType()
    {
	return actionType;
    }

    /**
     * @param actionType the actionType to set
     */
    public void setActionType(String actionType)
    {
	this.actionType = actionType;
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
     * @param generatorBO the generatorBO to set
     */
    public void setGeneratorBO(GeneratorBO generatorBO)
    {
        this.generatorBO = generatorBO;
    }
    /**
     * @return the autoCompleteTags
     */
    public String getAutoCompleteTags()
    {
        return autoCompleteTags;
    }
    /**
     * @param autoCompleteTags the autoCompleteTags to set
     */
    public void setAutoCompleteTags(String autoCompleteTags)
    {
        this.autoCompleteTags = autoCompleteTags;
    }
    /**
     * @param screenGeneratorBO the screenGeneratorBO to set
     */
    public void setScreenGeneratorBO(ScreenGeneratorBO screenGeneratorBO)
    {
        this.screenGeneratorBO = screenGeneratorBO;
    }
    /**
     * @return the dynButtonSourceCO
     */
    public DynButtonSourceCO getDynButtonSourceCO()
    {
        return dynButtonSourceCO;
    }
    /**
     * @param dynButtonSourceCO the dynButtonSourceCO to set
     */
    public void setDynButtonSourceCO(DynButtonSourceCO dynButtonSourceCO)
    {
        this.dynButtonSourceCO = dynButtonSourceCO;
    }
    /**
     * @return the btnSourceList
     */
    public List<SelectCO> getBtnSourceList()
    {
        return btnSourceList;
    }
    /**
     * @param btnSourceList the btnSourceList to set
     */
    public void setBtnSourceList(List<SelectCO> btnSourceList)
    {
        this.btnSourceList = btnSourceList;
    }
    /**
     * @return the loadScriptCO
     */
    public LoadScriptCO getLoadScriptCO()
    {
        return loadScriptCO;
    }
    /**
     * @param loadScriptCO the loadScriptCO to set
     */
    public void setLoadScriptCO(LoadScriptCO loadScriptCO)
    {
        this.loadScriptCO = loadScriptCO;
    }
    /**
     * @return the fileName
     */
    public String getFileName()
    {
        return fileName;
    }
    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    /**
     * @return the exportStream
     */
    public InputStream getExportStream()
    {
        return exportStream;
    }
    /**
     * @param exportStream the exportStream to set
     */
    public void setExportStream(InputStream exportStream)
    {
        this.exportStream = exportStream;
    }
    /**
     * @return the errorStream
     */
    public InputStream getErrorStream()
    {
        return errorStream;
    }
    /**
     * @param errorStream the errorStream to set
     */
    public void setErrorStream(InputStream errorStream)
    {
        this.errorStream = errorStream;
    }
    /**
     * @return the showConfirmation
     */
    public boolean isShowConfirmation()
    {
        return showConfirmation;
    }
    /**
     * @param showConfirmation the showConfirmation to set
     */
    public void setShowConfirmation(boolean showConfirmation)
    {
        this.showConfirmation = showConfirmation;
    }
    /**
     * @return the confirmationResponse
     */
    public String getConfirmationResponse()
    {
        return confirmationResponse;
    }
    /**
     * @param confirmationResponse the confirmationResponse to set
     */
    public void setConfirmationResponse(String confirmationResponse)
    {
        this.confirmationResponse = confirmationResponse;
    }
    /**
     * @return the uploadFile
     */
    public File getUploadFile()
    {
        return uploadFile;
    }
    /**
     * @param uploadFile the uploadFile to set
     */
    public void setUploadFile(File uploadFile)
    {
        this.uploadFile = uploadFile;
    }
    /**
     * @return the dynScrTablesCO
     */
    public DynScrTablesCO getDynScrTablesCO()
    {
        return dynScrTablesCO;
    }
    /**
     * @param dynScrTablesCO the dynScrTablesCO to set
     */
    public void setDynScrTablesCO(DynScrTablesCO dynScrTablesCO)
    {
        this.dynScrTablesCO = dynScrTablesCO;
    }
    /**
     * @return the dynScrTableGridUpdates
     */
    public String getDynScrTableGridUpdates()
    {
        return dynScrTableGridUpdates;
    }
    /**
     * @param dynScrTableGridUpdates the dynScrTableGridUpdates to set
     */
    public void setDynScrTableGridUpdates(String dynScrTableGridUpdates)
    {
        this.dynScrTableGridUpdates = dynScrTableGridUpdates;
    }
	public Boolean get_scrGridFlagEnabled() {
		return _scrGridFlagEnabled;
	}
	public void set_scrGridFlagEnabled(Boolean _scrGridFlagEnabled) {
		this._scrGridFlagEnabled = _scrGridFlagEnabled;
	}
	/**
	 * @return the _omniChannelFlag
	 */
	public Boolean get_omniChannelFlag()
	{
	    return _omniChannelFlag;
	}
	/**
	 * @param _omniChannelFlag the _omniChannelFlag to set
	 */
	public void set_omniChannelFlag(Boolean _omniChannelFlag)
	{
	    this._omniChannelFlag = _omniChannelFlag;
	}
	/**
	 * @return the autoCompleteGridTags
	 */
	public String getAutoCompleteGridTags()
	{
	    return autoCompleteGridTags;
	}
	/**
	 * @param autoCompleteGridTags the autoCompleteGridTags to set
	 */
	public void setAutoCompleteGridTags(String autoCompleteGridTags)
	{
	    this.autoCompleteGridTags = autoCompleteGridTags;
	}
	
	
}
