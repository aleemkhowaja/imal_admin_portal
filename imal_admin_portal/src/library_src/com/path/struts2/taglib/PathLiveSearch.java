package com.path.struts2.taglib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_ELEM_ACTIVITIESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.CurrElementExpressionsCO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;

public class PathLiveSearch extends UIBean
{// Dialog

    public static final String PATH_TEMPLATE = "livesearch";
    public static final String PATH_THEME = "path-xhtml";

    /**
     *Unique Id of the lookup component.
     */
    private String id;
    /**
     * Specify the action name of Action Class(Implementer should define the
     * class) which needs to get invoked while clicking the lookup button of the
     * dialog.
     * 
     */

    private String actionName;
    /**
     * Using for where clause parameters (ColumnName:ComponentId) Column Name =
     * DbColumnName and ComponentId = Id of the component(ie, textfield,textarea
     * etc...)
     */

    private String paramList;
    /**
     * Using for setting the data (Once the record is selected in the grid and
     * clicks OK button of the lookup component) into corresponding components
     * like textfield,textarea,etc...(ColumnName:Component Id) Column Name = The
     * column name (column header) Component Id = The id of the component in
     * which the value get set.
     */
    private String resultList;
    /**
     * Name of the function which needs to call while clicking OK button of the
     * dialog (The implementer should write the function). If no functions
     * specified then the component will take the value of outputparam and fill
     * the content automatically
     */
    private String onOk;

    /**
     * Name of the function which needs to call while clicking CANCEL button of
     * the dialog (The implementer should write the function). If no functions
     * specified then the component will take the value of outputparam and fill
     * the content automatically
     */
    private String onCancel;

    private String searchElement;
    private String multiSelect = "false";
    private String selectColumn;
    private String afterDepEvent;
    private String beforeDepEvent;
    private String mode;
    protected String size;
    protected String maxlength;
    protected String minValue;
    protected String maxValue;
    private String zeroNotAllowed;
    private String leadZeros;
    private String overrideLabelText;
    private String relatedDescElt;//id of the related description text field
    private String tabindex;
    private String overrideLabelKey;
    private String allowDefValCust;
    private String customBtnData;
    private String customKeyEventBtnData;
    /**
     * The auto search element by default it is off.If it is true then it will
     * open the search window directly once clicks on the text field
     */
    private String dependency, dependencySrc, parameter, readOnlyMode, autoSearch = "false";
    
    private String reConstruct;
    private String multiResultInput; //input Id of the hidden element that will store the multiselect values as JSON string

    private String fieldAudit;
    /**
     * CSS Style to be applied on input field of the livesearch
     */
    private String inputCssStyle;
    
    private String required;
    protected String dontLoadData;//TP 887297 dont Load Data for livesearch feature

    public PathLiveSearch(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);

	// TODO Auto-generated constructor stub
    }

    @Override
    protected void evaluateExtraParams()
    {
	super.evaluateExtraParams();
	

	/**
	 * Enable Grid column default order setting
	 */
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	String gridColSortRight = baseAction.returnAccessRightByProgRef(ConstantsCommon.GRID_COL_SORT_OPT);
	if(ConstantsCommon.GRID_COL_SORT_OPT.equals(StringUtil.nullToEmpty(gridColSortRight)))
	{
	    addParameter("gridColSortRight",true);
	}

	//adding default nbFormat for livesearch number to # since nbFormat is not available in livsearch mode number
	if("number".equals(mode))
	{
	    addParameter("nbFormat", "#");
	}
	
	SYS_PARAM_SCREEN_DISPLAYVO theVO = RootUtil.returnParamScreenDisplay(request, name, "lookuptxt_"+id);
	if(theVO != null)
	{
	    int visible = (theVO.getIS_VISIBLE() == null || theVO.getIS_VISIBLE().intValue() == 1) ? 1 : 0; 
	    if(visible == 0)
	    {
		if(cssStyle == null || cssStyle.isEmpty())
		{
		    cssStyle = "";
		}
		else
		{
		    cssStyle += ";";
		}
		cssStyle += "display:none";
		addParameter("cssStyle", findString(cssStyle));
	    }
	    // control on BACKGROUND_COLOR if Exists
	    if(StringUtil.isNotEmpty(theVO.getBACKGROUND_COLOR()))
	    {
		if(inputCssStyle == null || inputCssStyle.isEmpty())
		{
		    inputCssStyle = "";
		}
		else
		{
		    inputCssStyle += ";";
		}
		inputCssStyle += "background:" + theVO.getBACKGROUND_COLOR() + " !important";
		addParameter("inputCssStyle", findString(inputCssStyle));
	    }
	    if(theVO.getIS_MANDATORY() != null)
	    {
        	    if(theVO.getIS_MANDATORY().intValue() == 1 && visible == 1)
        	    {
        		required = "true";
        	    }
        	    else
        	    {
        		required = "false";
        	    }
           }
	    if(theVO.getIS_READONLY() != null)
	    {
        	    if(theVO.getIS_READONLY().intValue() == 1)
        	    {
        		readOnlyMode = "true";
        	    }
        	    else
        	    {
        		readOnlyMode = "false";
        	    }
	    }
	    
	    if(!StringUtil.nullToEmpty(theVO.getLABEL_KEY()).isEmpty())
	    {
		overrideLabelText =  baseAction.getText(theVO.getLABEL_KEY());
		addParameter("overrideLabelText", findString(overrideLabelText));
		// LABEL_KEY is coming already translated in case of additionalScreensParams upon load of screen
		overrideLabelKey = theVO.getLabelKeyVal() != null ? theVO.getLabelKeyVal() : theVO.getLABEL_KEY();
		addParameter("overrideLabelKey", findString(overrideLabelKey));
	    }
	 // control on Max Length Field if Exists
	    if(theVO.getMAX_LENGTH() != null && theVO.getMAX_LENGTH().intValue() > 0)
	    {
		maxlength = String.valueOf(theVO.getMAX_LENGTH().intValue());
	    }
	    
	 // control on Number Format for numeric inputs
	    if(theVO.getDecFormat() != null && "number".equals(mode))
	    {
		addParameter("nbFormat", theVO.getDecFormat());
	    }
	    
	    if(NumberUtil.nullToZero(theVO.getZERO_NOT_ALLOWED()).intValue() > 0)
	    {
		zeroNotAllowed = "true";
	    }
	    
	    //check for default value
	    if(Boolean.valueOf(allowDefValCust)
		    && StringUtil.isNotEmpty(name) && findValue(name) == null
		    && StringUtil.isNotEmpty(theVO.getDEFAULT_VALUE()))
	    {
		addParameter("nameValue", theVO.getDEFAULT_VALUE());
	    }
	    
	    // control on Min Length Field if Exists
	    if(theVO.getMIN_LENGTH() != null && theVO.getMIN_LENGTH().intValue() > 0)
	    {
		addParameter("minlength", theVO.getMIN_LENGTH().intValue());
	    }
	    //Enable field audit management		    	
	    if(theVO.getENABLE_FIELD_AUDIT_YN() != null)
	    {										
		 if(theVO.getENABLE_FIELD_AUDIT_YN().intValue() == 1)
		 {
		     fieldAudit = "true";
		 }
		 else
		 {
		     fieldAudit = "false";
		 }
		addParameter("fieldAudit", findValue(fieldAudit, Boolean.class));
	    }
	}
	if(id != null)
	{
	    addParameter("id", findString(id));
	}
	if(actionName != null)
	{
	    addParameter("actionName", findString(actionName));
	}
	if(paramList != null)
	{
	    addParameter("paramList", findString(paramList));
	}
	if(resultList != null)
	{
	    addParameter("resultList", findString(resultList));
	}
	if(onOk != null)
	{
	    addParameter("onOk", findString(onOk));
	}
	if(onCancel != null)
	{
	    addParameter("onCancel", findString(onCancel));
	}
	if(name != null)
	{
	    addParameter("name", findString(name));
	}
	if(searchElement != null)
	{
	    addParameter("searchElement", findString(searchElement));
	}
	if(multiSelect != null)
	{
	    addParameter("multiSelect", findString(multiSelect));
	}
	if(selectColumn != null)
	{
	    addParameter("selectColumn", findString(selectColumn));
	}
	if(dependency != null)
	{
	    String escapedDep = findString(dependency);
	    escapedDep = StringUtil.removeNewLineTabSpace(escapedDep);
	    addParameter("dependency", escapedDep);
	}
	if(dependencySrc != null)
	{
	    addParameter("dependencySrc", findString(dependencySrc));
	}
	if(parameter != null)
	{
	    String escapedDep = findString(parameter);
	    escapedDep = StringUtil.removeNewLineTabSpace(escapedDep);
	    addParameter("parameter", escapedDep);
	}
	if(readOnlyMode != null)
	{
	    addParameter("readOnlyMode", findString(readOnlyMode));
	}
	if(StringUtil.isNotEmpty(afterDepEvent))
	{
	    addParameter("afterDepEvent", findString(afterDepEvent));
	}
	if(beforeDepEvent != null)
	{
	    addParameter("beforeDepEvent", findString(beforeDepEvent));
	}
	if(mode != null)
	{
	    addParameter("mode", findString(mode));
	}
	if(size != null)
	{
	    addParameter("size", findString(size));
	}
	// empty could come from DynamicParam form construction
	if(maxlength != null && !maxlength.trim().isEmpty())
	{
	    addParameter("maxlength", findString(maxlength));
	}
	// empty could come from DynamicParam form construction
	if(minValue != null && !minValue.trim().isEmpty())
	{
		addParameter("minValue", findString(minValue));
	}
	// empty could come from DynamicParam form construction
	if(maxValue != null && !maxValue.trim().isEmpty())
	{
		addParameter("maxValue", findString(maxValue));
	}
	if(leadZeros != null)
	{
	    addParameter("leadZeros",findString(leadZeros));
	}
	if(zeroNotAllowed != null)
	{
	    addParameter("zeroNotAllowed", findString(zeroNotAllowed));
	}
	// tooltip for the input
	String toolTip = RootUtil.returnFieldToolTipWithCustomization(request,name, id, theVO);
	if(toolTip != null)
	{
	    addParameter("title", toolTip);
	}
	if(relatedDescElt != null)
	{
	    addParameter("relatedDescElt", findString(relatedDescElt));
	}
	if(tabindex != null)
	{
	    addParameter("tabindex", findString(tabindex));
	}
	if(reConstruct != null)
	{
	    addParameter("reConstruct", findString(reConstruct));
	}
	if(allowDefValCust != null)
	{
	    addParameter("allowDefValCust", findString(allowDefValCust));
	}
	if(multiResultInput != null)
	{
	    addParameter("multiResultInput", findString(multiResultInput));
	}
	
	if(theVO == null || StringUtil.nullToEmpty(theVO.getBACKGROUND_COLOR()).isEmpty())
	{
	    HashMap<String,  HashMap<String, String>> hm = RootUtil.returnChangesHighlightsForElt(request);
	    if(hm != null && hm.containsKey(name) && !StringUtil.nullToEmpty((hm.get(name)).get("OLD_VALUE")).equals(StringUtil.nullToEmpty(getParameters().get("nameValue"))))
	    {
		if(cssClass == null)
		{
		    cssClass = "";
		}
		cssClass = cssClass.concat(" pathHighlights");
		addParameter("cssClass", findString(cssClass));
		String newTitle = StringUtil.nullToEmpty(getParameters().get("title"));
		if(!newTitle.isEmpty())
		{
		    newTitle = newTitle.concat("\n");
		}
		addParameter("title", newTitle.concat(RootUtil.returnTransMsg(request, "oldValKey").concat(": ") +StringUtil.nullToEmpty((hm.get(name)).get("OLD_VALUE"))));
	    }
	}
        /**
         * dynamic dependency management.
         */
	SessionCO sessionCO = baseAction.returnSessionObject();
	if(sessionCO!=null && sessionCO.getCompanyCode()!=null && ConstantsCommon.APPLY_DYN_EXPRESSION)
	{		    
	    CommonLibSC commonLibSC = new CommonLibSC();
	    commonLibSC.setAppName(sessionCO.getCurrentAppName());
	    commonLibSC.setProgRef(baseAction.get_pageRef());
	    commonLibSC.setCompCode(sessionCO.getCompanyCode());
	    commonLibSC.setCurrElementName(name);
	    try
	    {
		List<CurrElementExpressionsCO> currElemExprList = baseAction.returnCommonLibBO().returnCurrElementExpression(commonLibSC);
		if(currElemExprList!=null && !currElemExprList.isEmpty())
		{
		    String dynExpressionsArgs = "";
		    String defaultDependencies = "";
		    boolean defaultDependency = (dependencySrc==null?true:false); 
		    for(int i=0;i<currElemExprList.size();i++)
		    {
			CurrElementExpressionsCO currElemExprCO =  currElemExprList.get(i);
			if(i==0)
			{
			    dynExpressionsArgs  += "hmDynElems._progRef:~CONST_"+baseAction.get_pageRef()+",hmDynElems.currElemName:~CONST_"+currElemExprCO.getCurrElementName()+",hmDynElems."+currElemExprCO.getCurrElemDisplayName()+":"+currElemExprCO.getCurrElementId()+"_"+baseAction.get_pageRef()+",hmDynElems."+currElemExprCO.getDISPLAY_FIELD_NAME()+":"+currElemExprCO.getELEMENT_ID()+"_"+baseAction.get_pageRef();
			    defaultDependencies += currElemExprCO.getELEMENT_ID()+"_"+baseAction.get_pageRef() + ":"+ "hmDynElems."+currElemExprCO.getDISPLAY_FIELD_NAME();
			}
			else
			{
			    dynExpressionsArgs  += ","+"hmDynElems."+currElemExprCO.getDISPLAY_FIELD_NAME()+":"+currElemExprCO.getELEMENT_ID()+"_"+baseAction.get_pageRef();
			    defaultDependencies += ","+currElemExprCO.getELEMENT_ID()+"_"+baseAction.get_pageRef()+":"+"hmDynElems."+currElemExprCO.getDISPLAY_FIELD_NAME();
			}
		    }
		    addParameter("dynExpressionsArgs", dynExpressionsArgs);
		    if(defaultDependency)
		    {
			addParameter("dependencySrc",request.getContextPath()+"/path/customization/DefaultDependency");
			addParameter("dependency",StringUtil.removeNewLineTabSpace(defaultDependencies));
			addParameter("parameter",StringUtil.removeNewLineTabSpace(dynExpressionsArgs));

		    }
		}
	    }
	    catch(BaseException e)
	    {
		// TODO Auto-generated catch block
		Log.getInstance().error(e, "Error in Dynamic Expresssion process");
	    } 
	}
	
	// get list of activities since we can now add before and after execution on the same button.
	if(theVO!=null)
	{
        	  theVO.setAPP_NAME(sessionCO.getCurrentAppName());
        	  List<CustomElementActivitiesSC> activitiesVOList = RootUtil.returnParamElemActivities(theVO);
        	
        	  if(activitiesVOList != null && activitiesVOList.size()>0)
        	  {
        	    for(CustomElementActivitiesSC activityVO : activitiesVOList)
        	    {
        		SYS_PARAM_ELEM_ACTIVITIESVO sysParamElemActivity = activityVO.getSysParamElemActivitiesVO();
        		theVO.setElemSequenceId(sysParamElemActivity.getSEQUENCE_ID());
        		try
        		{
        		    if(ButtonCustomizationConstants.ACTIVITY_TYPE.ONCHANGE
        			    .equals(sysParamElemActivity.getACTIVITY_TYPE()) || ButtonCustomizationConstants.ACTIVITY_TYPE.BOTH
        			    .equals(sysParamElemActivity.getACTIVITY_TYPE()))
        		    {
        			Map<String, Object> customBtnDataMap = RootUtil.returnButtonCustActionData(request,
        				sysParamElemActivity.getACTIVITY_ID(), true, theVO);
        			customBtnDataMap.put("dynScreenAppName", sessionCO.getCurrentAppName());
        			customBtnDataMap.put("dynScreenProgRef", theVO.getPROG_REF());
        			customBtnDataMap.put("dynScreenCompCode", theVO.getCOMP_CODE());
        			customBtnDataMap.put("dynScreenFldIdentifier", sysParamElemActivity.getFLD_IDENTIFIER());
        			customBtnDataMap.put("isGlobalActivity", true);
        			customBtnDataMap.put("proceedExpression", sysParamElemActivity.getPROCEED_ON_EXPRESSION());
            			customBtnDataMap.put("elemSequenceId", sysParamElemActivity.getSEQUENCE_ID());
        			customBtnDataMap.put("proceedOnFail", ConstantsCommon.ONE.equals(sysParamElemActivity.getPROCEED_ON_FAIL()));
        			customBtnDataMap.put("id", id);
        			RootUtil.addScreenElements(customBtnDataMap, activitiesVOList,request);
        			customBtnData = PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true);
        			addParameter("customBtnData", findString(customBtnData));
        		    }
        		   
            		    if(ButtonCustomizationConstants.ACTIVITY_TYPE.KEYEVENT
            			    .equals(sysParamElemActivity.getACTIVITY_TYPE()) || ButtonCustomizationConstants.ACTIVITY_TYPE.BOTH
        			    .equals(sysParamElemActivity.getACTIVITY_TYPE()))
            		    {
            			Map<String, Object> customBtnDataMap = RootUtil.returnButtonCustActionData(request,
            				sysParamElemActivity.getACTIVITY_ID(), true, theVO);
            			customBtnDataMap.put("dynScreenAppName", sessionCO.getCurrentAppName());
            			customBtnDataMap.put("dynScreenProgRef", theVO.getPROG_REF());
            			customBtnDataMap.put("dynScreenCompCode", theVO.getCOMP_CODE());
            			customBtnDataMap.put("dynScreenFldIdentifier", sysParamElemActivity.getFLD_IDENTIFIER());
            			customBtnDataMap.put("isGlobalActivity", true);
            			customBtnDataMap.put("elemSequenceId", sysParamElemActivity.getSEQUENCE_ID());
            			customBtnDataMap.put("proceedExpression", sysParamElemActivity.getPROCEED_ON_EXPRESSION());
            			RootUtil.addScreenElements(customBtnDataMap, activitiesVOList,request);
            			customKeyEventBtnData = PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true);
            			addParameter("customKeyEventBtnData", findString(customKeyEventBtnData));
            		    }
        
        		}
        		catch(Exception e)
        		{
        		    customBtnData = null;
        		    customKeyEventBtnData = null;
        		}
        	    }
        	  }
	}
	/**
	 * end
	 */
	if(StringUtil.isNotEmpty(required))
	{
	    addParameter("required", findValue(required, Boolean.class));
	}
	
	// TP 887297  
	if(!StringUtil.nullToEmpty(dontLoadData).isEmpty())
	{
	    addParameter("dontLoadData",findString(dontLoadData));
	}
	else
	{
	    addParameter("dontLoadData","false");
	}
    }

    /**
     * Sets the path theme
     */
    @Override
    public String getTheme()
    {
	return PATH_THEME;
    }

    /**
     * Get the path template
     */
    @Override
    protected String getDefaultTemplate()
    {
	return PATH_TEMPLATE;
    }

    /**
     * Get the id
     */
    @Override
    public String getId()
    {
	return id;
    }

    /**
     *Sets the id
     */
    @Override
    public void setId(String id)
    {
	this.id = id;
    }

    /**
     * Get the action name.
     * 
     * @return
     */
    public String getActionName()
    {
	return actionName;
    }

    /**
     * Set the action name
     * 
     * @param actionName
     */
    public void setActionName(String actionName)
    {
	this.actionName = actionName;
    }

    /**
     * Get the result list
     * 
     * @return
     */
    public String getResultList()
    {
	return resultList;
    }

    /**
     * Set the result list
     * 
     * @param resultlist
     */
    public void setResultList(String resultList)
    {
	this.resultList = resultList;
    }

    /**
     * Get the ok button value
     * 
     * @return
     */
    public String getOnOk()
    {
	return onOk;
    }

    /**
     * Set the ok button value
     * 
     * @param onok
     */
    public void setOnOk(String onOk)
    {
	this.onOk = onOk;
    }

    /**
     * get the cancel button value
     * 
     * @return
     */
    public String getOnCancel()
    {
	return onCancel;
    }

    /**
     * Set the cancel button value
     * 
     * @param oncancel
     */
    public void setOnCancel(String onCancel)
    {
	this.onCancel = onCancel;
    }

    /*
     * public static String getPathTemplate() { return PATH_TEMPLATE; } public
     * static String getPathTheme() { return PATH_THEME; }
     */
    /**
     * Get the param list
     * 
     * @return
     */
    public String getParamList()
    {
	return paramList;
    }

    /**
     * Set the param list
     * 
     * @param keylist
     */
    public void setParamList(String keyList)
    {
	this.paramList = keyList;
    }

    /**
     * Gets the search column
     * 
     * @return
     */
    public String getSearchElement()
    {
	return searchElement;
    }

    /**
     * Set the search column
     * 
     * @param searchElement
     */
    public void setSearchElement(String searchElement)
    {
	this.searchElement = searchElement;
    }

    /**
     * Get the auto search element
     * 
     * @return autoSearch
     */
    public String getAutoSearch()
    {
	return autoSearch;
    }

    /**
     * Sets the auto Search element
     * 
     * @param autoSearch
     */
    public void setAutoSearch(String autoSearch)
    {
	this.autoSearch = autoSearch;
    }

    public String getMultiSelect()
    {
	return multiSelect;
    }

    public void setMultiSelect(String multiSelect)
    {
	this.multiSelect = multiSelect;
    }

    public String getSelectColumn()
    {
	return selectColumn;
    }

    public void setSelectColumn(String selectColumn)
    {
	this.selectColumn = selectColumn;
    }

    public String getDependency()
    {
	return dependency;
    }

    public void setDependency(String dependency)
    {
	this.dependency = dependency;
    }

    public String getDependencySrc()
    {
	return dependencySrc;
    }

    public void setDependencySrc(String dependencySrc)
    {
	this.dependencySrc = dependencySrc;
    }

    public String getParameter()
    {
	return parameter;
    }

    public void setParameter(String parameter)
    {
	this.parameter = parameter;
    }

    public String getReadOnlyMode()
    {
	return readOnlyMode;
    }

    public void setReadOnlyMode(String readOnlyMode)
    {
	this.readOnlyMode = readOnlyMode;
    }

    public String getAfterDepEvent()
    {
	return afterDepEvent;
    }

    public void setAfterDepEvent(String afterDepEvent)
    {
	this.afterDepEvent = afterDepEvent;
    }

    public String getMode()
    {
	return mode;
    }

    public void setMode(String mode)
    {
	this.mode = mode;
    }

    public void setSize(String size)
    {
	this.size = size;
    }

    public void setMaxlength(String maxlength)
    {
	this.maxlength = maxlength;
    }

    public String getSize()
    {
        return size;
    }

    public String getMaxlength()
    {
        return maxlength;
    }

    public String getMinValue()
    {
        return minValue;
    }

    public void setMinValue(String minValue)
    {
        this.minValue = minValue;
    }

    public String getMaxValue()
    {
        return maxValue;
    }

    public void setMaxValue(String maxValue)
    {
        this.maxValue = maxValue;
    }

    public String getLeadZeros()
    {
        return leadZeros;
    }

    public void setLeadZeros(String leadZeros)
    {
        this.leadZeros = leadZeros;
    }

    public String getOverrideLabelText()
    {
        return overrideLabelText;
    }

    public void setOverrideLabelText(String overrideLabelText)
    {
        this.overrideLabelText = overrideLabelText;
    }

    public String getBeforeDepEvent()
    {
        return beforeDepEvent;
    }

    public void setBeforeDepEvent(String beforeDepEvent)
    {
        this.beforeDepEvent = beforeDepEvent;
    }

    public String getZeroNotAllowed()
    {
        return zeroNotAllowed;
    }

    public void setZeroNotAllowed(String zeroNotAllowed)
    {
        this.zeroNotAllowed = zeroNotAllowed;
    }

    public String getRelatedDescElt()
    {
        return relatedDescElt;
    }

    public void setRelatedDescElt(String relatedDescElt)
    {
        this.relatedDescElt = relatedDescElt;
    }

    public String getTabindex()
    {
        return tabindex;
    }

    @Override
    public void setTabindex(String tabindex)
    {
        this.tabindex = tabindex;
    }
    
    public String getOverrideLabelKey()
    {
        return overrideLabelKey;
    }

    public void setOverrideLabelKey(String overrideLabelKey)
    {
        this.overrideLabelKey = overrideLabelKey;
    }

    /**
     * @return the reConstruct
     */
    public String getReConstruct()
    {
        return reConstruct;
    }

    /**
     * @param reConstruct the reConstruct to set
     */
    public void setReConstruct(String reConstruct)
    {
        this.reConstruct = reConstruct;
    }

    public String getAllowDefValCust()
    {
        return allowDefValCust;
    }

    public void setAllowDefValCust(String allowDefValCust)
    {
        this.allowDefValCust = allowDefValCust;
    }
    
    public String getMultiResultInput()
    {
        return multiResultInput;
    }

    public void setMultiResultInput(String multiResultInput)
    {
        this.multiResultInput = multiResultInput;
    }

    public String getFieldAudit()
    {
        return fieldAudit;
    }

    public void setFieldAudit(String fieldAudit)
    {
        this.fieldAudit = fieldAudit;
    }

    /**
     * @return the inputCssStyle
     */
    public String getInputCssStyle()
    {
        return inputCssStyle;
    }

    /**
     * @param inputCssStyle the inputCssStyle to set
     */
    public void setInputCssStyle(String inputCssStyle)
    {
        this.inputCssStyle = inputCssStyle;
    }

    public String getCustomBtnData()
    {
        return customBtnData;
    }

    public void setCustomBtnData(String customBtnData)
    {
        this.customBtnData = customBtnData;
    }

    public String getCustomKeyEventBtnData()
    {
        return customKeyEventBtnData;
    }

    public void setCustomKeyEventBtnData(String customKeyEventBtnData)
    {
        this.customKeyEventBtnData = customKeyEventBtnData;
    }

    /**
     * @return the required
     */
    public String getRequired()
    {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(String required)
    {
        this.required = required;
    }
    /**
     * @return the dontLoadData
     */
    public String getDontLoadData()
    {
        return dontLoadData;
    }

    /**
     * @param dontLoadData the dontLoadData to set
     */
    public void setDontLoadData(String dontLoadData)
    {
        this.dontLoadData = dontLoadData;
    }
    
}
