/**
 * 
 */
package com.path.actions.common.screengenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.actions.admin.dynamicparams.DynamicParamsAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.screengenerator.ScreenGeneratorBO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.dynamicparams.DynamicParamsVO;
import com.path.vo.admin.dynamicparams.ListParamVO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.screengenerator.ElementPropertiesDetCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
import com.path.vo.common.select.SelectCO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * PropertiesDetailsDynAction.java used to
 */
public class PropertiesDetailsDynAction extends DynamicParamsAction
{
    private ArrayList<DynamicParamsVO> formLst  = new ArrayList<DynamicParamsVO>();
    private List<SelectCO> textFieldModeLst = new ArrayList<SelectCO>();
    private List<SelectCO> lookupModeLst = new ArrayList<SelectCO>();
    private List<SelectCO> labelModeLst = new ArrayList<SelectCO>();
    private ScreenGeneratorSC criteria = new ScreenGeneratorSC();
    private ScreenGeneratorBO screenGeneratorBO;
    private Map<String,Object> propertiesValMap = new HashMap<String,Object>();
 
    /**
     * Used to load the Properties screen on element selection 
     * @author marwanmaddah
     * @date   Dec 8, 2015
     * @return String
     *
     */
    public String loadPropertiesDetails()
    {
	try
	{
	    fillPropertiesForm();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    log.error("************: Error in load properties details section");
	}
	return SUCCESS_DYNAMIC_PARAM;
    }
    
    /**
     * 
     * @author marwanmaddah
     * @date   Dec 8, 2015
     * 
     * @modifiedBy Sajjad Soomro
     * @modifiedDate 10 Dec, 2019
     * @description set Tab Details button properties and binding method (screenGeneratorProp_openAddTabScreen) with onClick.
     * 
     * @throws BaseException
     */
    private void fillPropertiesForm() throws BaseException
    {
	SessionCO sessionCO     = returnSessionObject();
	DynamicParamsVO paramVO = new DynamicParamsVO();
	criteria.setLangCode(sessionCO.getLanguage());
	criteria.setLovTypeId(ConstantsCommon.ELEMENT_PROPERTY_LOV_TYPE);
	List<ElementPropertiesDetCO> elemPropDetList = screenGeneratorBO.returnElementPropDetails(criteria);
	int counter = 1;
	String propName = "";
	String modeType = ConstantsCommon.ONE;
	String lookupDescVal = "", forLabelVal = "";
	Map<String,ElementPropertiesDetCO> elementsMap = new HashMap<String,ElementPropertiesDetCO>();
	for (ElementPropertiesDetCO epCO : elemPropDetList) 
	{
	    elementsMap.put(epCO.getPropertyCode(),epCO);
	}
	
	for(ElementPropertiesDetCO elementPropertiesDetCO:elemPropDetList)
	{
	    String elementId  = (elementPropertiesDetCO.getElementId()+"_").concat(elementPropertiesDetCO.getPropertyCode());
            paramVO = new DynamicParamsVO();
            paramVO.setLabel(elementPropertiesDetCO.getLabelDesc());
            paramVO.setLabelId("lbl_".concat(elementId));
            paramVO.setElement_dataType(ConstantsCommon.ELEMENT_DATA_TYPE_MAP.get(Integer.valueOf(elementPropertiesDetCO.getDataType())));
            paramVO.setElement_type(ConstantsCommon.ELEMENT_LAYOUT_TYPE_MAP.get(Integer.valueOf(elementPropertiesDetCO.getLayoutType())));
            if(Integer.valueOf(9).equals(Integer.valueOf(elementPropertiesDetCO.getLayoutType())))
            {
        	paramVO.setCssStyle("width:200px;"); 
            }
            paramVO.setId(elementId);
            propName = "elemProp_".concat(elementPropertiesDetCO.getPropertyCode());
            /**
             * 
             */
            if (!NumberUtil.isEmptyDecimal(criteria.getScrTableId()) && "name".equals(elementPropertiesDetCO.getPropertyCode())
        	    && !ConstantsCommon.ELEMENT_TYPE_GRID.equals(criteria.getElementType())) 
            {
        	paramVO.setElement_type(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH);
            }
            /**
             * 
             */
            paramVO.setName("propertiesValMap."+propName);
            paramVO.setRow(counter);
            paramVO.setColumn(2);
	    if(ConstantsCommon.ELEMENT_TYPE_GRID.equals(criteria.getElementType()))
	    {
		String propVal = null;
		if(elementsMap.get(ConstantsCommon.PROPERTY_CODE_EDITABLE)!= null)
		{
		    propVal = elementsMap.get(ConstantsCommon.PROPERTY_CODE_EDITABLE).getPropertyValue();
		}
		
		if(ConstantsCommon.PROPERTY_CODE_TABLE_NAME.equals(elementPropertiesDetCO.getPropertyCode())
			|| ConstantsCommon.PROPERTY_CODE_COLPROPS.equals(elementPropertiesDetCO.getPropertyCode())
			|| ConstantsCommon.PROPERTY_CODE_RETRIEVALCONDITION.equals(elementPropertiesDetCO.getPropertyCode()))
		{
		    if(propVal == null || ConstantsCommon.ZERO.equals(propVal))
		    {
			paramVO.setReadOnly(ConstantsCommon.TRUE);
		    }
		    else
		    {
			paramVO.setReadOnly(ConstantsCommon.FALSE);
		    }
		    if(ConstantsCommon.PROPERTY_CODE_TABLE_NAME.equals(elementPropertiesDetCO.getPropertyCode()))
		    {
			paramVO.setActionName("/path/screenGenerator/generatorLookupAction_drawingScrTablesGrid");
			paramVO.setResultList("TABLE_TECH_NAME:lookuptxt_" + paramVO.getId()+",:"+paramVO.getId().split("_")[0]+"_colProperties");
			paramVO.setDependencySrc("/path/screenGenerator/screenGeneratorDepAction_scrTableGridDep");
			//Add dependency for Retrieve Condition for display of tableName in Dynamic Screen
			paramVO.setParameters("criteria.tableName:lookuptxt_"+paramVO.getId()+",criteria.elementId:~CONST_"+elementPropertiesDetCO.getElementId());
			paramVO.setDependency("lookuptxt_"+paramVO.getId()+":criteria.tableName"+","+paramVO.getId().split("_")[0]+"_condData:criteria.queryData");
			
		    }
		    if(ConstantsCommon.PROPERTY_CODE_COLPROPS.equals(elementPropertiesDetCO.getPropertyCode()))
		    {
			paramVO.setOnClick("screenGeneratorProp_openColProperties('"
				+ elementPropertiesDetCO.getElementId() + "','" + criteria.getElementType() + "')");
			DynamicParamsVO hideColPropertiesData = new DynamicParamsVO();
			hideColPropertiesData.setId(elementPropertiesDetCO.getElementId() + "_colProperties");
			hideColPropertiesData.setName("propertiesValMap.elemProp_colProperties");
			hideColPropertiesData.setElement_type(HIDDEN_ELEMENT);
			hideColPropertiesData.setRow(counter);
			hideColPropertiesData.setColumn(3);
			if(!StringUtil.nullToEmpty(elementPropertiesDetCO.getPropertyValueExpr()).isEmpty())
			{
			    hideColPropertiesData.setValue(elementPropertiesDetCO.getPropertyValueExpr());
			}
			formLst.add(hideColPropertiesData);
		    }
		}
		//Enable search for grid
		if(ConstantsCommon.PROPERTY_CODE_ENABLESEARCH.equals(elementPropertiesDetCO.getPropertyCode()))
		{
		    if(ConstantsCommon.ONE.equals(elementPropertiesDetCO.getPropertyValue()))
		    {
			propertiesValMap.put(propName,BigDecimal.ONE);
		    }
		    else
		    {
			propertiesValMap.put(propName,BigDecimal.ZERO);
		    }
		}
		// add retrieval condition for editable grid
		if(ConstantsCommon.PROPERTY_CODE_RETRIEVALCONDITION.equals(elementPropertiesDetCO.getPropertyCode()))
		{

		    if( StringUtil.isNotEmpty( criteria.getElementType()) )
		    {

			paramVO.setOnClick("screenGeneratorProp_openQueryScreen('"+elementPropertiesDetCO.getElementId()+"', undefined, '" + criteria.getElementType() +"','"+elementPropertiesDetCO.getPropertyCode()+ "')");
		    }
		    else
		    {
			paramVO.setOnClick("screenGeneratorProp_openQueryScreen('"+elementPropertiesDetCO.getElementId()+"')");
		    }
		    // add hidden element to form to save the condition 
		    DynamicParamsVO hideFilterData = new DynamicParamsVO();
		    hideFilterData.setId(elementPropertiesDetCO.getElementId()+"_condData");
		    hideFilterData.setName("propertiesValMap.elemProp_condData");
		    hideFilterData.setElement_type(HIDDEN_ELEMENT);
		    hideFilterData.setRow(counter);
		    hideFilterData.setColumn(3);
		    if(!StringUtil.nullToEmpty(elementPropertiesDetCO.getPropertyValueExpr()).isEmpty())
		    {
			hideFilterData.setValue(elementPropertiesDetCO.getPropertyValueExpr());
		    }
		    formLst.add(hideFilterData);
		}
		if(ConstantsCommon.PROPERTY_CODE_EDITABLE.equals(elementPropertiesDetCO.getPropertyCode()))
		{
		    String tableNameId = (elementsMap.get(ConstantsCommon.PROPERTY_CODE_TABLE_NAME).getElementId()
			    + "_").concat(elementsMap.get(ConstantsCommon.PROPERTY_CODE_TABLE_NAME).getPropertyCode());
		    String queryId = (elementsMap.get(ConstantsCommon.PROPERTY_CODE_QUERY).getElementId()
			    + "_").concat(elementsMap.get(ConstantsCommon.PROPERTY_CODE_QUERY).getPropertyCode());
		    String condId = (elementsMap.get(ConstantsCommon.PROPERTY_CODE_RETRIEVALCONDITION).getElementId()
			    + "_").concat(elementsMap.get(ConstantsCommon.PROPERTY_CODE_RETRIEVALCONDITION).getPropertyCode());
		    paramVO.setOnClick(
			    "screenGenerator_onEditableCheckBoxClick('" + elementId + "','" + tableNameId +"','" + queryId +"','" + condId + "')");
		}
		if(ConstantsCommon.PROPERTY_CODE_QUERY.equals(elementPropertiesDetCO.getPropertyCode())
			|| ConstantsCommon.PROPERTY_CODE_DBL_CLICK.equals(elementPropertiesDetCO.getPropertyCode()))
		{
		    if(propVal == null || ConstantsCommon.ZERO.equals(propVal))
		    {
			paramVO.setReadOnly(ConstantsCommon.FALSE);
		    }
		    else
		    {
			paramVO.setReadOnly(ConstantsCommon.TRUE);
		    }
		}
	    }
            if(((ConstantsCommon.ELEMENT_TYPE_BUTTON.equals(criteria.getElementType())|| ConstantsCommon.ELEMENT_TYPE_LABEL.equals(criteria.getElementType())) && ConstantsCommon.PROPERTY_CODE_VALUE.equals(elementPropertiesDetCO.getPropertyCode()))
               ||
               (ConstantsCommon.ELEMENT_TYPE_PANEL.equals(criteria.getElementType()) && ConstantsCommon.PROPERTY_CODE_TITLE.equals(elementPropertiesDetCO.getPropertyCode()))
               ||
               ConstantsCommon.PROPERTY_CODE_PLACEHOLDER.equals(elementPropertiesDetCO.getPropertyCode())
               ||
               ConstantsCommon.PROPERTY_CODE_LABELLEFT.equals(elementPropertiesDetCO.getPropertyCode())
               ||
               ConstantsCommon.PROPERTY_CODE_LABELRIGHT.equals(elementPropertiesDetCO.getPropertyCode())
              )
            {
        	if(Integer.valueOf(7).equals(Integer.valueOf(elementPropertiesDetCO.getLayoutType())))
        	{
        	    /**
        	     * in case the element is label or button 
        	     * and the layout type is a liveSearch
        	     * then will open the translation key lookup.
        	     */
        	    paramVO.setActionName("/pathdesktop/TranslationLookup_labelKeyLookup");
        	    paramVO.setResultList("sysParamKeyLabelVO.KEY_LABEL_CODE:lookuptxt_"+paramVO.getId());
        	    //set the value of selectedApp to 3.0 instead of '3'
        	    //in order to be parsed as number and not quoted string
        	    //issue # 419136
        	    paramVO.setParamList("translationSC.selectedApp:3.0");
        	    paramVO.setDependencySrc("/path/screenGenerator/screenGeneratorDepAction_dependencyByLabelKey");
        	    paramVO.setDependency("lookuptxt_"+paramVO.getId()+":criteria.labelKey");
        	    paramVO.setParameters("criteria.labelKey:lookuptxt_"+paramVO.getId());
        	    paramVO.setAfterDepEvent("screenGenerator_onValueChange('lookuptxt_"+elementId+"')");
        	}
        	else
        	{        	    
        	    paramVO.setOnchange("screenGenerator_onValueChange('"+elementId+"')");
        	}
            }
            //Rabih Apply the LiveSearch parameter here drawingScrColsGrid
            String elementType = criteria.getElementType();
            if(!NumberUtil.isEmptyDecimal(criteria.getScrTableId())
        	&& (ConstantsCommon.PROPERTY_CODE_NAME.equals(elementPropertiesDetCO.getPropertyCode()) &&
        	   (ConstantsCommon.ELEMENT_TYPE_CHECKBOX.equals(elementType)||
        	    ConstantsCommon.ELEMENT_TYPE_COMBOBOX.equals(elementType)||
        	    ConstantsCommon.ELEMENT_TYPE_DATEPICKER.equals(elementType)||
        	    ConstantsCommon.ELEMENT_TYPE_LIVESEARCH.equals(elementType)||
        	    ConstantsCommon.ELEMENT_TYPE_RADIOBUTTON.equals(elementType)||
        	    ConstantsCommon.ELEMENT_TYPE_TEXTAREA.equals(elementType)||
        	    ConstantsCommon.ELEMENT_TYPE_TEXTFIELD.equals(elementType)||
        	    ConstantsCommon.ELEMENT_TYPE_FILE.equals(elementType)) ||
        	    (ConstantsCommon.PROPERTY_CODE_FILE_NAME.equals(elementPropertiesDetCO.getPropertyCode())
            		    && ConstantsCommon.ELEMENT_TYPE_FILE.equals(elementType)))
        	    )
            {
        	    paramVO.setActionName("/path/screenGenerator/generatorLookupAction_drawingScrColsGrid");
        	    paramVO.setResultList("COL_TECH_NAME:lookuptxt_"+paramVO.getId());
        	    // IF property code is name and element type is file, we need to restrict to COL_TYPE = 6 in database to only show BLOB
        	    if(ConstantsCommon.PROPERTY_CODE_NAME.equals(elementPropertiesDetCO.getPropertyCode()) 
        		    && ConstantsCommon.ELEMENT_TYPE_FILE.equals(elementType))
        	    {
        		paramVO.setParamList("criteria.tableId:screenTableId,criteria.colType:~CONST_6");
        	    }
        	    // IF property code is file name and element type is file, we need to restrict to COL_TYPE = 1 in database to only show String
        	    else if(ConstantsCommon.PROPERTY_CODE_FILE_NAME.equals(elementPropertiesDetCO.getPropertyCode())
            		    && ConstantsCommon.ELEMENT_TYPE_FILE.equals(elementType))
        	    {
        		paramVO.setParamList("criteria.tableId:screenTableId,criteria.colType:~CONST_1");
        	    }
        	    else
        	    {
        		paramVO.setParamList("criteria.tableId:screenTableId");
        	    }
        	    paramVO.setDependencySrc("/path/screenGenerator/screenGeneratorDepAction_scrColsGridDep");
        	    paramVO.setDependency("lookuptxt_"+paramVO.getId()+":criteria.relatedCol");
        	    paramVO.setParameters("criteria.relatedCol:lookuptxt_"+paramVO.getId());
        	    paramVO.setAfterDepEvent("screenGenerator_onValueChange('lookuptxt_"+elementId+"')");
            }
            
            //Rabih Add radio group element description
            if(ConstantsCommon.PROPERTY_CODE_GROUP_LABEL.equals(elementPropertiesDetCO.getPropertyCode()) &&
        	    ConstantsCommon.ELEMENT_TYPE_RADIOBUTTON.equals(elementType))
            {
        	    paramVO.setActionName("/pathdesktop/TranslationLookup_labelKeyLookup");
        	    paramVO.setResultList("sysParamKeyLabelVO.KEY_LABEL_CODE:lookuptxt_"+paramVO.getId());
        	    paramVO.setParamList("translationSC.selectedApp:3.0");
        	    paramVO.setDependencySrc("/path/screenGenerator/screenGeneratorDepAction_dependencyByLabelKey");
        	    paramVO.setDependency("lookuptxt_"+paramVO.getId()+":criteria.groupLabel");
        	    paramVO.setParameters("criteria.groupLabel:lookuptxt_"+paramVO.getId());
        	    paramVO.setAfterDepEvent("screenGenerator_onValueChange('lookuptxt_"+elementId+"')");
            }
            if(!StringUtil.nullToEmpty(elementPropertiesDetCO.getPropertyValue()).isEmpty())
            {        	
        	paramVO.setValue(elementPropertiesDetCO.getPropertyValue());
            }
            if(!StringUtil.nullToEmpty(elementPropertiesDetCO.getPropertyValueExpr()).isEmpty())
            {        	
        	paramVO.setValue(elementPropertiesDetCO.getPropertyValueExpr());
            }
            
            if(ConstantsCommon.PROPERTY_CODE_ID.equals(elementPropertiesDetCO.getPropertyCode()))
            {
        	paramVO.setRequired(ConstantsCommon.TRUE);
        	paramVO.setOnchange("screenGenerator_onIdPropertyChange('"+elementId+"')");
            }
            if(ConstantsCommon.PROPERTY_CODE_FILE_NAME.equals(elementPropertiesDetCO.getPropertyCode()))
            {
        	paramVO.setRequired(ConstantsCommon.TRUE);
            }
            else if(ConstantsCommon.PROPERTY_CODE_OPTIONS.equals(elementPropertiesDetCO.getPropertyCode()))
            {
            /// US 853476 Muhammad.Asif
            paramVO.setOnClick("screenGeneratorProp_openDatasourceScreen('"+elementPropertiesDetCO.getElementId()+"', undefined, '" + criteria.getElementType() + "','"+elementPropertiesDetCO.getPropertyCode()+"')");
            DynamicParamsVO hideOptionsData = new DynamicParamsVO();
        	hideOptionsData.setId(elementPropertiesDetCO.getElementId()+"_optionData");
        	hideOptionsData.setName("propertiesValMap.elemProp_optionData");
        	hideOptionsData.setElement_type(HIDDEN_ELEMENT);
        	hideOptionsData.setRow(counter);
        	hideOptionsData.setColumn(3);
        	if(!StringUtil.nullToEmpty(elementPropertiesDetCO.getPropertyValueExpr()).isEmpty())
        	{
        	    hideOptionsData.setValue(elementPropertiesDetCO.getPropertyValueExpr());
        	}
        	formLst.add(hideOptionsData);
            }
            else if(ConstantsCommon.PROPERTY_CODE_QUERY.equals(elementPropertiesDetCO.getPropertyCode()))
            {
        	if( StringUtil.isNotEmpty( criteria.getElementType()) )
        	{
        		/// US 853476 Muhammad.Asif
        		paramVO.setOnClick("screenGeneratorProp_openDatasourceScreen('"+elementPropertiesDetCO.getElementId()+"', undefined, '" + criteria.getElementType() + "','"+elementPropertiesDetCO.getPropertyCode()+"')");
        	}
        	else
        	{
        	    paramVO.setOnClick("screenGeneratorProp_openQueryScreen('"+elementPropertiesDetCO.getElementId()+"')");
        	}
        	DynamicParamsVO hideQueryData = new DynamicParamsVO();
        	hideQueryData.setId(elementPropertiesDetCO.getElementId()+"_queryData");
        	hideQueryData.setName("propertiesValMap.elemProp_queryData");
        	hideQueryData.setElement_type(HIDDEN_ELEMENT);
        	hideQueryData.setRow(counter);
        	hideQueryData.setColumn(3);
        	if(!StringUtil.nullToEmpty(elementPropertiesDetCO.getPropertyValueExpr()).isEmpty())
        	{
        	    hideQueryData.setValue(elementPropertiesDetCO.getPropertyValueExpr());
        	}
        	formLst.add(hideQueryData);
        	if(ConstantsCommon.ELEMENT_TYPE_TEXTFIELD.equals(criteria.getElementType()))
        	{
                	String tagPropVal;
                	if(criteria.getCurrElemProperties()!=null && criteria.getCurrElemProperties().containsKey("elemProp_"+ConstantsCommon.PROPERTY_CODE_TAG))
                	{
                	    tagPropVal = (String)criteria.getCurrElemProperties().get("elemProp_"+ConstantsCommon.PROPERTY_CODE_TAG);
                	}
                	else
                	{
                	    tagPropVal = elementsMap.get(ConstantsCommon.PROPERTY_CODE_TAG).getPropertyValue();
                	}
                	if(!ConstantsCommon.ONE.equals(tagPropVal))
                	{
        	            SYS_PARAM_SCREEN_DISPLAYVO buttonDisplayVO = new SYS_PARAM_SCREEN_DISPLAYVO();
        	            buttonDisplayVO.setIS_VISIBLE(BigDecimal.ZERO);
        	            getAdditionalScreenParams().put(paramVO.getId(), buttonDisplayVO);
                	}
        	}
            }
            else if(ConstantsCommon.PROPERTY_CODE_MODE.equals(elementPropertiesDetCO.getPropertyCode()))
            {
        	if(criteria.getCurrElemProperties()!=null && criteria.getCurrElemProperties().containsKey(propName))
        	{
        	    modeType = (String)criteria.getCurrElemProperties().get(propName); 
        	}
        	else if(!StringUtil.nullToEmpty(elementPropertiesDetCO.getPropertyValue()).isEmpty())
        	{
        	    modeType = elementPropertiesDetCO.getPropertyValue();
        	}
        	
        	SelectCO varcharCO  = new SelectCO();
        	varcharCO.setCode(String.valueOf(1));
        	varcharCO.setDescValue("Varchar");
        	
        	SelectCO numericCO = new SelectCO();
        	numericCO.setCode(String.valueOf(2));
        	numericCO.setDescValue("Numeric");
        	propertiesValMap.put(propName,modeType);
        	textFieldModeLst.add(varcharCO);
        	textFieldModeLst.add(numericCO);
        	ListParamVO lstParamVO = new ListParamVO();
        	lstParamVO.setValueList("textFieldModeLst");
        	lstParamVO.setKey("code");
        	lstParamVO.setValue("descValue");
        	paramVO.setListParamVO(lstParamVO);
        	
        	/**
        	 * Dependency with Format property
        	 */
        	paramVO.setDependencySrc("/path/screenGenerator/screenGeneratorDepAction_dependencyByModeType?");
	        paramVO.setParameters("criteria.modeType:"+paramVO.getId()+",criteria.elementId:~CONST_"+elementPropertiesDetCO.getElementId());
	        paramVO.setDependency(paramVO.getId()+":criteria.modeType");	        
            }
            else if(ConstantsCommon.PROPERTY_CODE_LOOKUPDESC.equals(elementPropertiesDetCO.getPropertyCode()))
	    {
		if(!StringUtil.nullToEmpty(elementPropertiesDetCO.getPropertyValue()).isEmpty())
		{
		    lookupDescVal = elementPropertiesDetCO.getPropertyValue();
		}
		JSONArray jsonOnLoadModel = (JSONArray) JSONSerializer.toJSON(criteria.getLookupDesc());
		Object[] onLoadScriptArr = jsonOnLoadModel.toArray();
		SelectCO lookupOtion = new SelectCO();
		lookupOtion.setCode("");
		lookupOtion.setDescValue("");
		lookupModeLst.add(lookupOtion);
		for(Object lookupDet : onLoadScriptArr)
		{
		    JSONObject theLookup = (JSONObject) lookupDet;
		    lookupOtion = new SelectCO();
		    lookupOtion.setCode((String) theLookup.get("elemId"));
		    lookupOtion.setDescValue((String) theLookup.get("pId"));
		    lookupModeLst.add(lookupOtion);
		}
		propertiesValMap.put(propName,lookupDescVal);
		ListParamVO lstParamVO = new ListParamVO();
		lstParamVO.setValueList("lookupModeLst");
		lstParamVO.setKey("code");
		lstParamVO.setValue("descValue");
		paramVO.setListParamVO(lstParamVO);
	    }
            else if(ConstantsCommon.PROPERTY_CODE_LABELFOR.equals(elementPropertiesDetCO.getPropertyCode()))
	    {
		if(!StringUtil.nullToEmpty(elementPropertiesDetCO.getPropertyValue()).isEmpty())
		{
		    forLabelVal = elementPropertiesDetCO.getPropertyValue();
		}
		JSONArray jsonOnLoadModel = (JSONArray) JSONSerializer.toJSON(criteria.getLabelFor());
		Object[] onLoadScriptArr = jsonOnLoadModel.toArray();
		SelectCO labelOtion = new SelectCO();
		labelOtion.setCode("");
		labelOtion.setDescValue("");
		labelModeLst.add(labelOtion);
		for(Object labelDet : onLoadScriptArr)
		{
		    JSONObject theLabelFor = (JSONObject) labelDet;
		    labelOtion = new SelectCO();
		    labelOtion.setCode((String) theLabelFor.get("elemId"));
		    labelOtion.setDescValue((String) theLabelFor.get("pId"));
		    labelModeLst.add(labelOtion);
		}
		propertiesValMap.put(propName, forLabelVal);
		ListParamVO lstParamVO = new ListParamVO();
		lstParamVO.setValueList("labelModeLst");
		lstParamVO.setKey("code");
		lstParamVO.setValue("descValue");
		paramVO.setListParamVO(lstParamVO);
	    }
            else if(ConstantsCommon.PROPERTY_CODE_NBFORMAT.equals(elementPropertiesDetCO.getPropertyCode()))
            {
	        if(ConstantsCommon.ONE.equals(modeType))
	        {
//	            SYS_PARAM_SCREEN_DISPLAYVO formatDisplayVO = new SYS_PARAM_SCREEN_DISPLAYVO();
//	            formatDisplayVO.setIS_VISIBLE(BigDecimal.ZERO);
//                    getAdditionalScreenParams().put(paramVO.getName(), formatDisplayVO);
                    propertiesValMap.put(propName,null);
	        }

            }
            else if(ConstantsCommon.PROPERTY_CODE_NBFRMTTER.equals(elementPropertiesDetCO.getPropertyCode())
             || ConstantsCommon.PROPERTY_CODE_NBZRONTALW.equals(elementPropertiesDetCO.getPropertyCode())
             || ConstantsCommon.PROPERTY_CODE_NBNEGNTALW.equals(elementPropertiesDetCO.getPropertyCode())
            )
            {
	        if(ConstantsCommon.ONE.equals(modeType))
	        {
	            SYS_PARAM_SCREEN_DISPLAYVO displayVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	            displayVO.setIS_VISIBLE(BigDecimal.ZERO);
                    getAdditionalScreenParams().put(paramVO.getName(), displayVO);
                    propertiesValMap.put(propName,BigDecimal.ZERO);
	        }        	
            }
            else if(ConstantsCommon.PROPERTY_CODE_SOURCE.equals(elementPropertiesDetCO.getPropertyCode())
        	    || ConstantsCommon.PROPERTY_CODE_ONCHANGE.equals(elementPropertiesDetCO.getPropertyCode())
        	    || ConstantsCommon.PROPERTY_CODE_DBL_CLICK.equals(elementPropertiesDetCO.getPropertyCode())
        	    || ConstantsCommon.PROPERTY_CODE_ADD_TAB.equals(elementPropertiesDetCO.getPropertyCode()))
            {
        	String forChange = ConstantsCommon.ZERO;
        	DynamicParamsVO hideBtnSourceData = new DynamicParamsVO();
        	if(ConstantsCommon.PROPERTY_CODE_ONCHANGE.equals(elementPropertiesDetCO.getPropertyCode()))
        	{
        	    hideBtnSourceData.setId(elementPropertiesDetCO.getElementId()+"_onChangeData");
        	    hideBtnSourceData.setName("propertiesValMap.elemProp_onChangeData");
        	    forChange = ConstantsCommon.ONE;
        	}
        	else if(ConstantsCommon.PROPERTY_CODE_ADD_TAB.equals(elementPropertiesDetCO.getPropertyCode()))
        	{
        	    hideBtnSourceData.setId(elementPropertiesDetCO.getElementId()+"_addTabData");
        	    hideBtnSourceData.setName("propertiesValMap.elemProp_addTabData");
        	    forChange = ConstantsCommon.ONE;
        	}
        	else
        	{        	    
        	    hideBtnSourceData.setId(elementPropertiesDetCO.getElementId()+"_sourceData");
        	    hideBtnSourceData.setName("propertiesValMap.elemProp_sourceData");
        	}
        	hideBtnSourceData.setElement_type(HIDDEN_ELEMENT);
        	hideBtnSourceData.setRow(counter);
        	hideBtnSourceData.setColumn(3);
        	if(!StringUtil.nullToEmpty(elementPropertiesDetCO.getPropertyValueExpr()).isEmpty())
        	{
        	    hideBtnSourceData.setValue(elementPropertiesDetCO.getPropertyValueExpr());
        	}
        	//binding method with "Tab Details" Button of Tabbed Panel
        	if(ConstantsCommon.PROPERTY_CODE_ADD_TAB.equals(elementPropertiesDetCO.getPropertyCode()))
        	{
        	    paramVO.setOnClick("screenGeneratorProp_openAddTabScreen('"+elementPropertiesDetCO.getElementId()+"','"+criteria.getElementType()+"','"+forChange+"')");        	    
        	}
        	else
        	{
        	    paramVO.setOnClick("screenGeneratorProp_openBtnSourceScreen('"+elementPropertiesDetCO.getElementId()+"','"+criteria.getElementType()+"','"+forChange+"')");
        	}
        	formLst.add(hideBtnSourceData);
            }
            else if(ConstantsCommon.PROPERTY_CODE_MINDATE.equals(elementPropertiesDetCO.getPropertyCode()) || ConstantsCommon.PROPERTY_CODE_MAXDATE.equals(elementPropertiesDetCO.getPropertyCode()))
            {
        	paramVO.setDependencySrc("/path/screenGenerator/screenGeneratorDepAction_dependencyBtwnMinMaxDate?");
        	
        	paramVO.setParameters("criteria.fromProp:"+elementPropertiesDetCO.getPropertyCode()+",criteria.minDate:"+elementPropertiesDetCO.getElementId()+"_minDate,criteria.maxDate:"+elementPropertiesDetCO.getElementId()+"_maxDate,criteria.elementId:~CONST_"+elementPropertiesDetCO.getElementId());
        	paramVO.setDependency(paramVO.getId()+":criteria."+elementPropertiesDetCO.getPropertyCode());   
        	
            }
            else if(ConstantsCommon.PROPERTY_CODE_DATEFORMAT.equals(elementPropertiesDetCO.getPropertyCode()))
            {
        	paramVO.setDependencySrc("/path/screenGenerator/screenGeneratorDepAction_dateFormatValidation?");        	
	        paramVO.setParameters("criteria.dateFormat:"+paramVO.getId()+",criteria.elementId:~CONST_"+elementPropertiesDetCO.getElementId());
	        paramVO.setDependency(paramVO.getId()+":criteria.dateFormat");	        
        	
            }
            else if(ConstantsCommon.PROPERTY_CODE_AUTO_SEARCH_ONY.equals(elementPropertiesDetCO.getPropertyCode()) 
        	    || ConstantsCommon.PROPERTY_CODE_SINGLE_INPUT.equals(elementPropertiesDetCO.getPropertyCode()))
            {
        	String tagPropVal;
        	if(criteria.getCurrElemProperties()!=null && criteria.getCurrElemProperties().containsKey("elemProp_"+ConstantsCommon.PROPERTY_CODE_TAG))
        	{
        	    tagPropVal = (String)criteria.getCurrElemProperties().get("elemProp_"+ConstantsCommon.PROPERTY_CODE_TAG);
        	}
        	else
        	{
        	    tagPropVal = elementsMap.get(ConstantsCommon.PROPERTY_CODE_TAG).getPropertyValue();
        	}
        	if(!ConstantsCommon.ONE.equals(tagPropVal))
        	{
	            SYS_PARAM_SCREEN_DISPLAYVO displayVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	            displayVO.setIS_VISIBLE(BigDecimal.ZERO);
	            getAdditionalScreenParams().put(paramVO.getName(), displayVO);
                    propertiesValMap.put(propName,BigDecimal.ZERO);
                    
        	}
            }
            else if(ConstantsCommon.PROPERTY_CODE_TAG.equals(elementPropertiesDetCO.getPropertyCode()))
            {
        	paramVO.setDependencySrc("/path/screenGenerator/screenGeneratorDepAction_dependencyOnTagFlag?");        	
	        paramVO.setParameters("criteria.tagInput:"+paramVO.getId()+",criteria.elementId:~CONST_"+elementPropertiesDetCO.getElementId());
	        paramVO.setDependency(paramVO.getId()+":criteria.tagInput");      	
            }
            if(!NumberUtil.isEmptyDecimal(elementPropertiesDetCO.getDataLength()) && !BigDecimal.valueOf(-1).equals(elementPropertiesDetCO.getDataLength()))
            {        	
        	paramVO.setMaxLength(elementPropertiesDetCO.getDataLength().intValue());
            }
            if(ConstantsCommon.ELEMENT_LAYOUT_TYPE_MAP.get(Integer.valueOf(6)).equals(paramVO.getElement_type()))
            {
        	paramVO.setValOpt("1:0");
            }
            formLst.add(paramVO);
            counter++; 
	}
	fillFormElements(formLst, "", "propertyDetFormId", "");
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
     * @param screenGeneratorBO the screenGeneratorBO to set
     */
    public void setScreenGeneratorBO(ScreenGeneratorBO screenGeneratorBO)
    {
        this.screenGeneratorBO = screenGeneratorBO;
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
     * @return the textFieldModeLst
     */
    public List<SelectCO> getTextFieldModeLst()
    {
        return textFieldModeLst;
    }

    /**
     * @param textFieldModeLst the textFieldModeLst to set
     */
    public void setTextFieldModeLst(List<SelectCO> textFieldModeLst)
    {
        this.textFieldModeLst = textFieldModeLst;
    }

    /**
     * @return the propertiesValMap
     */
    public Map<String, Object> getPropertiesValMap()
    {
        return propertiesValMap;
    }

    /**
     * @param propertiesValMap the propertiesValMap to set
     */
    public void setPropertiesValMap(Map<String, Object> propertiesValMap)
    {
        this.propertiesValMap = propertiesValMap;
    }
    public List<SelectCO> getLookupModeLst()
    {
        return lookupModeLst;
    }

    public void setLookupModeLst(List<SelectCO> lookupModeLst)
    {
        this.lookupModeLst = lookupModeLst;
    }

    public List<SelectCO> getLabelModeLst()
    {
        return labelModeLst;
    }

    public void setLabelModeLst(List<SelectCO> labelModeLst)
    {
        this.labelModeLst = labelModeLst;
    }
}
