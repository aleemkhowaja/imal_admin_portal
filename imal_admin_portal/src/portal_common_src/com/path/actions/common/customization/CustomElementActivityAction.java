package com.path.actions.common.customization;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.actions.common.customization.button.ButtonCustomizationGridAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.customization.CustomizationBO;
import com.path.bo.common.customization.button.ButtonCustomizationBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.button.ButtonCustomizationCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: peterabounader
 *
 *          CustomElementActivityAction.java used to
 */
public class CustomElementActivityAction extends GridBaseAction
{
    private CustomElementActivitiesSC criteria = new CustomElementActivitiesSC();
    private CustomizationBO customizationBO;
    private ButtonCustomizationBO buttonCustomizationBO;

    List<SelectCO> activityTypeCmbList;

    @Override
    public Object getModel()
    {
	return criteria;
    }

    /**
     * this function is used to load mapping type list
     * 
     * @return
     */
    public String loadActivityTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ConstantsCommon.BUTTON_ACTIVITY_LOV_TYPE);
	    // EXCLUDE NONE, ON CHANGE AND KEY EVENT AND BOTH WHERE THEY WILL BE USED LATER
	    if(ConstantsCommon.TRUE.equals(criteria.getEnableAfterExecution()))
	    {
		selSC.setLovCodesExclude("'0','6','7','8','9'");
	    }else
	    {
		selSC.setLovCodesExclude("'0','5','6','7','8','9'");
	    }
	    // IF THERE IS AN ACTIVITY TYPE CHOSEN THEN WE MUST EXECLUDE ALL THE OTHER ACTIVITY TYPES SINCE WE CAN ADD ONLY BEFORE AND AFTER EXECUTION AT THE SAME TIME
	    if(StringUtil.isNotEmpty(criteria.getFirstActivityType()) && ConstantsCommon.TRUE.equals(criteria.getEnableAfterExecution()))
	    {
		selSC.setLovCodesExclude("'0','1','2','3','" + criteria.getFirstActivityType() + "','6','7','8','9'");
	    }
	    // if from textfiled,livesearch or textArea exclude all activity types except onchange and keyEvent and both
	    if(ConstantsCommon.ONE.equals(criteria.getFromText()))
	    {
		if(StringUtil.isNotEmpty(criteria.getFirstActivityType()))
		{
		    selSC.setLovCodesExclude("'0','1','2','3','4','5','" + criteria.getFirstActivityType() + "','8','9'");
		}else
		{
		    selSC.setLovCodesExclude("'0','1','2','3','4','5','8'");
		}
	    }
	    // if from object display (grid customization) include only the double click
	    if(ConstantsCommon.ONE.equals(criteria.getFromObjDisplay()))
	    {
		selSC.setLovCodesExclude(null);
		selSC.setLovCodesInlude("'8'");
	    }
	    /**
	     * [TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
	     * if from object display (grid customization) for column activity include only the onChange event
	     */
	    if(ConstantsCommon.ONE.equals(criteria.getFromObjDisplay()) && criteria.getObjColumnActivity())
	    {
		selSC.setLovCodesExclude(null);
		selSC.setLovCodesInlude("'"+ButtonCustomizationConstants.ACTIVITY_TYPE.ONCHANGE.getCode()+"'");
	    }
	    activityTypeCmbList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return "jsonSuccess";
    }

    /**
     * Used for loading the Grid of Business Translation
     * 
     * @return
     */
    public String loadElementActivityList()
    {
	try
	{
	    String[] searchCol = { "activityDescription", "ACTIVITY_ID", "DESCRIPTION", "PROCEED_ON_FAIL","ACTIVITY_ENABLE_YN", "SCREEN_WIDTH", "SCREEN_HEIGHT", "SCREEN_TITLE" };
	    /**
	     * copy the details related to search criteria to the SC
	     */
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setLovTypeId(ConstantsCommon.BUTTON_ACTIVITY_LOV_TYPE);
	    criteria.setSearchCols(searchCol);
	    /**
	     * [TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
	     */
	    if("true".equals(criteria.getFromObjDisplay()))
	    {
		List<String> activityTypes = new ArrayList<String>();
		/**
		 * check if object custom element activity true then set on change event
		 * otherwise set double click event 
		 */
		if(criteria.getObjColumnActivity())
		{
		    activityTypes.add(ButtonCustomizationConstants.ACTIVITY_TYPE.ONCHANGE.getCode());
		}
		else
		{
		    activityTypes.add(ButtonCustomizationConstants.ACTIVITY_TYPE.DOUBLECLICK.getCode());
		}
		criteria.setActivityTypes(activityTypes);
	    }
	    copyproperties(criteria);
	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(criteria))
	    {
		setRecords(customizationBO.returnElementActivitiesCount(criteria));
	    }

	    /**
	     * return the collection of records
	     */
	    List<CustomElementActivitiesSC> generatedList = new ArrayList<CustomElementActivitiesSC>();
	    //TP#1040160 Fix issue with retreiving all records when customized element of type grid
	    if(!NumberUtil.isEmptyDecimal(criteria.getSysParamElemActivitiesVO().getOBJ_DISPLAY_ID()) ||(!"true".equals(StringUtil.nullToEmpty(criteria.getFromObjDisplay()))))
	    {
		generatedList = customizationBO.returnElementActivitiesList(criteria);
	    }
	    List<CustomElementActivitiesSC> newGeneratedList = new ArrayList<CustomElementActivitiesSC>();
	    for(CustomElementActivitiesSC crite : generatedList)
	    {
		//generatedList.remove(crite);
		// FILL PAGE REF TO BE USED IN fillAutoCompleteTags function
		crite.setPageRef(get_pageRef());
		crite = customizationBO.fillAutoCompleteTags(crite);
		// in case of screen elements to add them to the auto complete data 
		if(crite != null && crite.getButtonCustCOList() != null)
		{
		    StringBuffer autoCompleteValues = new StringBuffer(StringUtil.nullToEmpty(crite.getAutoCompleteTags()));
		    Map<BigDecimal, ButtonCustomizationCO> screenElementsMap = new HashMap<BigDecimal, ButtonCustomizationCO>();
		    for(ButtonCustomizationCO screenCO : crite.getButtonCustCOList())
		    {
			autoCompleteValues.append(",");
			autoCompleteValues.append("\"[screen."+ (StringUtil.nullToEmpty(screenCO.getSysParamScreenElementsVO().getFIELD_KEY_LABEL_CODE())).replace(" ", "_")
				+ "{F." + screenCO.getSysParamScreenElementsVO().getFLD_IDENTIFIER() + "}]\"");
			screenElementsMap.put(screenCO.getSysParamScreenElementsVO().getFLD_IDENTIFIER(), screenCO);
		    }
		    crite.setAutoCompleteTags(autoCompleteValues.toString());
		    if(StringUtil.isNotEmpty(crite.getSysParamElemActivitiesVO().getPROCEED_ON_EXPRESSION()))
		    {
			ButtonCustomizationGridAction gridAction = new ButtonCustomizationGridAction();
			String returnedResultExpr = gridAction.unformatScreenElement(screenElementsMap,
				crite.getSysParamElemActivitiesVO().getPROCEED_ON_EXPRESSION());
			crite.getSysParamElemActivitiesVO().setPROCEED_ON_EXPRESSION(returnedResultExpr);
		    }
		}
		crite.setAutoCompleteTags(crite.getAutoCompleteTags().replaceAll("\"", ""));
		newGeneratedList.add(crite);
		//generatedList.add(0, crite);
	    }
	    NumberUtil.resetEmptyValues(newGeneratedList);
	    setGridModel(newGeneratedList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    public String deleteElementActivity()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(criteria.getSysParamElemActivitiesVO().getSEQUENCE_ID()))
	    {
		customizationBO.deleteElementActivity(criteria);

		set_warning(getText("Record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /**
     * in case of new row added or changing procedure to return the autocompletedata for proceed expression
     * @return
     */
    public String returnAutoCompleteData()
    {
	try
	{
	    criteria = customizationBO.fillAutoCompleteTags(criteria);
	    // in case of screen elements to add them to the auto complete data 
	    if(criteria != null && criteria.getButtonCustCOList() != null)
	    {
		StringBuffer autoCompleteValues = new StringBuffer(StringUtil.nullToEmpty(criteria.getAutoCompleteTags()));
		 Map<BigDecimal, ButtonCustomizationCO> screenElementsMap = new HashMap<BigDecimal, ButtonCustomizationCO>();
		for(ButtonCustomizationCO screenCO : criteria.getButtonCustCOList())
		{
		    autoCompleteValues.append(",");
		    autoCompleteValues.append("\"[screen." + getText(StringUtil.nullToEmpty(screenCO.getSysParamScreenElementsVO().getFIELD_KEY_LABEL_CODE())).replace(" ", "_")
			    + "{F." + screenCO.getSysParamScreenElementsVO().getFLD_IDENTIFIER() + "}]\"");
		    screenElementsMap.put(screenCO.getSysParamScreenElementsVO().getFLD_IDENTIFIER(), screenCO);
		}
		criteria.setAutoCompleteTags(autoCompleteValues.toString());
		if(StringUtil.isNotEmpty(criteria.getSysParamElemActivitiesVO().getPROCEED_ON_EXPRESSION()))
		{
		    ButtonCustomizationGridAction gridAction = new ButtonCustomizationGridAction();
		    String returnedResultExpr = gridAction.unformatScreenElement(screenElementsMap,criteria.getSysParamElemActivitiesVO().getPROCEED_ON_EXPRESSION());
		    criteria.getSysParamElemActivitiesVO().setPROCEED_ON_EXPRESSION(returnedResultExpr);
		}
	    }
	    criteria.setAutoCompleteTags(criteria.getAutoCompleteTags().replaceAll("\"", ""));
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    public CustomElementActivitiesSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CustomElementActivitiesSC criteria)
    {
	this.criteria = criteria;
    }

    public List<SelectCO> getActivityTypeCmbList()
    {
	return activityTypeCmbList;
    }

    public void setActivityTypeCmbList(List<SelectCO> activityTypeCmbList)
    {
	this.activityTypeCmbList = activityTypeCmbList;
    }

    public void setCustomizationBO(CustomizationBO customizationBO)
    {
	this.customizationBO = customizationBO;
    }

    public void setButtonCustomizationBO(ButtonCustomizationBO buttonCustomizationBO)
    {
	this.buttonCustomizationBO = buttonCustomizationBO;
    }

}
