/**
 * 
 */
package com.path.actions.common.customization.button;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.customization.button.ButtonCustomizationBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.ButtonCustomizationSC;
import com.path.vo.common.customization.button.CustomActionParamCO;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * ButtonCustomizationGridAction.java used to
 */
public class ButtonCustomizationGridAction extends GridBaseAction
{
    private ButtonCustomizationBO buttonCustomizationBO;
    private ButtonCustomizationSC criteria = new ButtonCustomizationSC();
    private ButtonCustomizationCO buttonCustomizationCO = new  ButtonCustomizationCO();
    
    @Override
    public Object getModel()
    {
	return criteria;
    }
    
    
    public String loadButtonCustomizationGrid()
    {
	try
	{

	    String[] searchCols = { "BTN_ID", "PROG_REF","DESCRIPTION", "LABEL_KEY", "BTN_ORDER" };
	    criteria.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(criteria);
	    
	    /**
	     *  set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    String progRef =  StringUtil.nullEmptyToValue(criteria.getProgRef(), ConstantsCommon.PROGREF_ROOT);
	    if(progRef != null && progRef.endsWith("_ALERT"))
	    {
		criteria.setProgRef(progRef.substring(0, progRef.indexOf("_ALERT")));
	    }
	    if(checkNbRec(criteria))
	    {
		setRecords(buttonCustomizationBO.returnButtonCustomListCount(criteria));
	    }

	    /**
	     *  return the collection of records
	     */
	    List<ButtonCustomizationCO> buttonCustomizationCOList = buttonCustomizationBO.returnButtonCustomList(criteria);
	    
	    //translate label keys
	    if(buttonCustomizationCOList != null && !buttonCustomizationCOList.isEmpty())
	    {	
		for(ButtonCustomizationCO buttonCustomizationCO : buttonCustomizationCOList)
		{
		    buttonCustomizationCO.setTranslatedLabelKey(getText(buttonCustomizationCO.getSysParamBtnCustVO().getLABEL_KEY()));
		}
	    }
	    
	    /**
	     *  set the collection into gridModel attribute defined at JSP grid tag
	     */
	    setGridModel(buttonCustomizationCOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    public String loadButtonCustomActionsGrid()
    {
	
	try
	{

	    String[] searchCols = { "OP_ID", "API_CODE", "SERVICE_TYPE", "DESCRIPTION"};
	    criteria.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(criteria);
	    
	    List<ButtonCustomizationCO> buttonCustomizationCOList = new ArrayList<ButtonCustomizationCO>();
	    if(!NumberUtil.isEmptyDecimal(criteria.getButtonId()))
	    {	
		
		SessionCO sessionCO = returnSessionObject();
		criteria.setLovTypeId(ButtonCustomizationConstants.LOV_TYPE_API_TYPE);
		criteria.setStatusLovTypeId(ButtonCustomizationConstants.LOV_TYPE_OPERATION_TYPE);
		criteria.setPreferredLanguage(sessionCO.getLanguage());
		
		/**
		 * set number of rows to be displayed in the page of grid, and
		 * the total number of records for first time load only
		 */
		if(checkNbRec(criteria))
		{
		    setRecords(buttonCustomizationBO.returnButtonActionsListCount(criteria));
		}

		/**
		 * return the collection of records
		 */
		buttonCustomizationCOList = buttonCustomizationBO.returnButtonActionsList(criteria);
		
		if(buttonCustomizationCOList != null && !buttonCustomizationCOList.isEmpty())
		{
		    buttonCustomizationCO.setProgRef(get_pageRef());
		    buttonCustomizationCO.setAppName(sessionCO.getCurrentAppName());
		    
		    //prepare parent operation desciption map
		    Map<BigDecimal, Map<BigDecimal, CustomActionParamCO>> customActionParamCOMap = new HashMap<BigDecimal, Map<BigDecimal, CustomActionParamCO>>();
		    Map<BigDecimal, String> parentOpDescMap = new HashMap<BigDecimal, String>();
		    buildParentOpDescMap(customActionParamCOMap, parentOpDescMap,buttonCustomizationCO);
		    
		    //prepare screen elements map
		    Map<BigDecimal, ButtonCustomizationCO> screenEleemntsMap = returnScreenElementsMap(buttonCustomizationCO);
		    
		    //loop on grid element to format the condition expression and to set the parent operation description
		    for(int i = 0; i < buttonCustomizationCOList.size(); i++)
		    {
			ButtonCustomizationCO custCO = buttonCustomizationCOList.get(i);
			//unformat screen element in condition expression
			if(ButtonCustomizationConstants.OP_TYPE.CONDITION.equals(custCO.getSysParamBtnCustActionsVO()
				.getOP_TYPE())
				&& StringUtil.isNotEmpty(custCO.getSysParamBtnCustActionsVO().getCOND_EXPR()))
			{
			    ButtonCustomizationCO returnedCustCO = buttonCustomizationBO.unformatConditionExpr(custCO, customActionParamCOMap);
			    String resultScreen = unformatScreenElement(screenEleemntsMap, returnedCustCO.getSysParamBtnCustActionsVO().getCOND_EXPR());
			    custCO.getSysParamBtnCustActionsVO().setCOND_EXPR(resultScreen);
			}
			
			//adjust parent operation description
			if(ConstantsCommon.ONE.equals(custCO.getReadonlyParentOp()))
			{
			    custCO.getSysParamBtnCustActionsVO().setPARENT_OP_ID(null);
			    if(parentOpDescMap.containsKey(custCO.getSysParamBtnCustActionsVO().getOP_ID()))
			    {
				custCO.setParentOperationDesc(parentOpDescMap.get(custCO.getSysParamBtnCustActionsVO().getOP_ID()));
			    }
			}
			
			if(ButtonCustomizationConstants.API_TYPE.REPORT.equals(custCO.getImImalApiVO()
				    .getSERVICE_TYPE()))
			{
			    custCO.setApiCodeValue(custCO.getSysParamBtnCustActionsVO().getREPORT_PROG_REF());
			}
			else if(custCO.getSysParamBtnCustActionsVO().getAPI_CODE() != null)
			{
			    custCO.setApiCodeValue(String.valueOf(custCO.getSysParamBtnCustActionsVO().getAPI_CODE()));
			}
		    }
		    
		}

	    }
	    /**
	     *  set the collection into gridModel attribute defined at JSP grid tag
	     */
	    setGridModel(buttonCustomizationCOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
	
    }
    
    
    public String loadButtonCustomCondGrid()
    {
	
	try
	{

	    String[] searchCols = { "OP_ID", "OP_TYPE", "DESCRIPTION", "LABEL_KEY", "COND_EXPR", "ACTION_SEQ_ID" };
	    criteria.setSearchCols(searchCols);
	    /**
	     *  copy the details related to search criteria to the SC
	     */
	    
	    copyproperties(criteria);
	    
	    List<ButtonCustomizationCO> buttonCustomizationCOList = new ArrayList<ButtonCustomizationCO>();
	    if(!NumberUtil.isEmptyDecimal(criteria.getButtonId()))
	    {	
		
		SessionCO sessionCO = returnSessionObject();
		criteria.setLovTypeId(ButtonCustomizationConstants.LOV_TYPE_OPERATION_TYPE);
		criteria.setPreferredLanguage(sessionCO.getLanguage());
		
		/**
		 * set number of rows to be displayed in the page of grid, and
		 * the total number of records for first time load only
		 */
		if(checkNbRec(criteria))
		{
		    setRecords(buttonCustomizationBO.returnButtonCondListCount(criteria));
		}

		/**
		 * return the collection of records
		 */
		buttonCustomizationCOList = buttonCustomizationBO.returnButtonCondList(criteria);

	    }
	    /**
	     *  set the collection into gridModel attribute defined at JSP grid tag
	     */
	    setGridModel(buttonCustomizationCOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
	
    }
    
    private void buildParentOpDescMap(Map<BigDecimal, Map<BigDecimal, CustomActionParamCO>> customActionParamCOMap, Map<BigDecimal, String> parentOpDescMap, ButtonCustomizationCO buttonCustomizationCO) throws BaseException
    {
	String theProgRef = returnCommonLibBO().returnOrginProgRef(buttonCustomizationCO.getAppName() ,buttonCustomizationCO.getProgRef());
	 
	ButtonCustomizationSC buttonCustomizationSC = new ButtonCustomizationSC();
	buttonCustomizationSC.setButtonId(criteria.getButtonId());
	buttonCustomizationSC.setProgRef(theProgRef);
	buttonCustomizationSC.setOnBtnLoad(null);
	buttonCustomizationSC.setShowArgDetails(null);
	
	ButtonCustomizationCO returnedButtonCustomizationCO = returnCommonLibBO().returnButtonCustActionData(buttonCustomizationSC);
	List<CustomActionParamCO> actionParamCOList = null;
	if(returnedButtonCustomizationCO != null)
	{
	    actionParamCOList = returnedButtonCustomizationCO.getCustomActionParamCOList();
	}
	if(actionParamCOList != null && !actionParamCOList.isEmpty())
	{
	    for(CustomActionParamCO paramCO : actionParamCOList)
	    {
		if(customActionParamCOMap.containsKey(paramCO.getOperationId()))
		{
		    customActionParamCOMap.get(paramCO.getOperationId()).put(paramCO.getArgId(), paramCO);
		}
		else
		{
		    Map<BigDecimal, CustomActionParamCO> argMap = new HashMap<BigDecimal, CustomActionParamCO>();
		    argMap.put(paramCO.getArgId(), paramCO);
		    customActionParamCOMap.put(paramCO.getOperationId(), argMap);
		}

		if(ButtonCustomizationConstants.OP_TYPE.CONDITION.equals(paramCO.getOperationType())
			&& paramCO.getCondResultOpId() != null)
		{
		    if(parentOpDescMap.containsKey(paramCO.getCondResultOpId()))
		    {
			String previousParent = parentOpDescMap.get(paramCO.getCondResultOpId());
			parentOpDescMap.put(paramCO.getCondResultOpId(), previousParent + " , "
				+ paramCO.getOperationDesc() + "(" + paramCO.getOperationId() + ")");

		    }
		    else
		    {
			parentOpDescMap.put(paramCO.getCondResultOpId(), paramCO.getOperationDesc() + "("
				+ paramCO.getOperationId() + ")");
		    }
		}
	    }
	}

    }
    
    private Map<BigDecimal, ButtonCustomizationCO> returnScreenElementsMap(ButtonCustomizationCO  buttonCustomizationCO) throws BaseException
    {

	List<ButtonCustomizationCO> screenEleemntsList = buttonCustomizationBO
		.returnScreenElements(buttonCustomizationCO);
	Map<BigDecimal, ButtonCustomizationCO> screenEleemntsMap = new HashMap<BigDecimal, ButtonCustomizationCO>();
	if(screenEleemntsList != null && !screenEleemntsList.isEmpty())
	{
	    for(ButtonCustomizationCO screenCO : screenEleemntsList)
	    {
		screenEleemntsMap.put(screenCO.getSysParamScreenElementsVO().getFLD_IDENTIFIER(), screenCO);
	    }
	}
	return screenEleemntsMap;
    }

    public String unformatScreenElement(Map<BigDecimal, ButtonCustomizationCO> screenElementsMap, String expression)
    {
	if(screenElementsMap != null 
		&& StringUtil.isNotEmpty(expression))
	{
	    Pattern patternScreen = Pattern.compile("(.*?)(F.([0-9]*))(.*?)");
	    Matcher matcherScreen = patternScreen.matcher(expression);
	    StringBuffer resultScreen = new StringBuffer();

	    while(matcherScreen.find())
	    {
		if(StringUtil.isNumeric(matcherScreen.group(3), false))
		{
		    BigDecimal fldIdentifier = new BigDecimal(matcherScreen.group(3));
		    ButtonCustomizationCO elementCO = screenElementsMap.get(fldIdentifier);
		    if(elementCO != null)
		    {
			matcherScreen.appendReplacement(resultScreen, matcherScreen.group(1)
				+ "[screen."
				+ getText(
					StringUtil.nullToEmpty(elementCO.getSysParamScreenElementsVO()
						.getFIELD_KEY_LABEL_CODE())).replace(" ", "_") + "{F."
				+ matcherScreen.group(3) + "}]");
		    }
		}
	    }

	    matcherScreen.appendTail(resultScreen);
	    return resultScreen.toString();
	}
	return null;
    }

    public ButtonCustomizationSC getCriteria()
    {
        return criteria;
    }


    public void setCriteria(ButtonCustomizationSC criteria)
    {
        this.criteria = criteria;
    }


    public ButtonCustomizationCO getButtonCustomizationCO()
    {
        return buttonCustomizationCO;
    }


    public void setButtonCustomizationCO(ButtonCustomizationCO buttonCustomizationCO)
    {
        this.buttonCustomizationCO = buttonCustomizationCO;
    }


    public void setButtonCustomizationBO(ButtonCustomizationBO buttonCustomizationBO)
    {
        this.buttonCustomizationBO = buttonCustomizationBO;
    }
    
}
