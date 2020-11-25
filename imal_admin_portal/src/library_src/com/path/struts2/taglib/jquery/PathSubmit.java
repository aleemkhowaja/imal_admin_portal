package com.path.struts2.taglib.jquery;

import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgeppert.struts2.jquery.components.Submit;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.BaseServices;
import com.path.bo.common.CommonLibBO;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_ELEM_ACTIVITIESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ELEMENTSVO;
import com.path.lib.common.base.BaseServicesImpl;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.dynamicscreen.DynamicScreenConstant;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapSC;

public class PathSubmit extends Submit
{

    private String freezeOnSubmit;
    private String allowView;
    private String progRef;
    private String allowCust;
    private String enableAfterExecution;
    private String overrideLabelText;
    private String overrideLabelKey;
    private String shortcutKey;
    private String customBtnId;
    private String customBtnData;
    private String customBtnAfterExecData;
    private String fieldAudit;
    private String buttonIconUrl;
    private String sourceAppName;
    
    public PathSubmit(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    public String getFreezeOnSubmit()
    {
	return freezeOnSubmit;
    }

    public void setFreezeOnSubmit(String freezeOnSubmit)
    {
	this.freezeOnSubmit = freezeOnSubmit;
    }

    @Override
    public boolean start(Writer arg0)
    {
	//the additional code should exists before calling super.start()	
	// reading id and name before evaluateExtraPArams which set default id
	String theId = id, theName = name;
	
	SYS_PARAM_SCREEN_DISPLAYVO theVO = null;
	if(StringUtil.nullToEmpty(theId).isEmpty())
	{
	    if(!StringUtil.nullToEmpty(theName).isEmpty())
	    {

		BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
		String custName = name;
		int progRefIndx = name.lastIndexOf("_"+baseAction.get_pageRef());
		if(progRefIndx!=-1)
		{
		    custName = name.substring(0,progRefIndx); 
		}
		theVO = RootUtil.returnParamScreenDisplay(request, custName, id,RootUtil.SUBMIT_ELEM_TYPE);
	    }
	}
	else
	{
		BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
		String custId = id;
		int progRefIndx = id.lastIndexOf("_"+baseAction.get_pageRef());
		if(progRefIndx!=-1)
		{		    
		    custId = id.substring(0,progRefIndx);
		}
		theVO = RootUtil.returnParamScreenDisplay(request, custId, custId,RootUtil.SUBMIT_ELEM_TYPE);
	}
	if(theVO != null)
	{
	    if(theVO.getIS_READONLY() != null)
	    {
		if(theVO.getIS_READONLY().intValue() == 1)
		{
		    disabled = "true";
		}
		else
		{
		    disabled = "false";
		}
		addParameter("disabled", findValue(disabled, Boolean.class));
	    }

	    if(theVO.getIS_VISIBLE() != null && theVO.getIS_VISIBLE().intValue() == 0)
	    {
		if(cssStyle == null)
		{
		    cssStyle = "";
		}

		if(!cssStyle.contains("display:none"))
		{
		    if(!cssStyle.isEmpty())
		    {
			cssStyle += ";";
		    }

		    cssStyle += "display:none";
		    addParameter("cssStyle", findString(cssStyle));
		}
	    }
	    
	    if(!StringUtil.nullToEmpty(theVO.getLABEL_KEY()).isEmpty())
	    {
		BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
		overrideLabelText =  baseAction.getText(theVO.getLABEL_KEY());
		addParameter("overrideLabelText", findString(overrideLabelText));
		// LABEL_KEY is coming already translated in case of additionalScreensParams upon load of screen
		overrideLabelKey = theVO.getLabelKeyVal() != null ? theVO.getLabelKeyVal() : theVO.getLABEL_KEY();
		addParameter("overrideLabelKey", findString(overrideLabelKey));
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
	addParameter("freezeOnSubmit", findString(freezeOnSubmit));
	if(StringUtil.nullToEmpty(allowView).equals("false")) 
	{
	    allowView = "false";
	}
	else if(progRef!=null)
	{
	    BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	    if(StringUtil.isNotEmpty(sourceAppName))
	    {
		allowView = StringUtil.nullEmptyToValue(baseAction.returnAccessRightByProgRef(progRef,sourceAppName), "false");
	    }
	    else
	    {
		allowView = StringUtil.nullEmptyToValue(baseAction.returnAccessRightByProgRef(progRef), "false");
	    }
	}
	
	/**Adding tooltip from Business translation specification*/
	String toolTip = RootUtil.returnFieldToolTipWithCustomization(request, name, id, theVO);
	if(toolTip != null)
	{
	    title = toolTip;
	    addParameter("title", toolTip);
	}

	if(allowView == null || !"false".equals(allowView))
	{
	    addParameter("allowView", findString("true"));
	}	
	if("true".equals(enableAfterExecution))
	{
	    addParameter("enableAfterExecution", findString("true"));
	}	
	// Support shortkeys for the buttons
	if(StringUtil.nullToEmpty(shortcutKey).isEmpty() && theVO != null && StringUtil.isNotEmpty(theVO.getKEYBOARD_SHORTCUT_KEY()))
	{
	    shortcutKey = theVO.getKEYBOARD_SHORTCUT_KEY();
	}
	
	if(StringUtil.isNotEmpty(shortcutKey))
	{
	    addParameter("shortcutKey", findString(shortcutKey));
	}
	SessionCO sesCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
	List<CustomElementActivitiesSC> activitiesVOList = null;
	// get list of activities since we can now add before and after execution on the same button.
	if(theVO!=null)
	{
	    theVO.setAPP_NAME(sesCO.getCurrentAppName());
	    activitiesVOList = RootUtil.returnParamElemActivities(theVO);
	}
	 BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	 String _recReadOnly = baseAction.get_recReadOnly();
	 //TP#953422 set _recReadOnly to false by default
	 if(_recReadOnly == null)
	 {
	     _recReadOnly = "false";
	 }
	if(StringUtil.isNotEmpty(customBtnId))
	{
	    try
	    {
		Map<String, Object> customBtnDataMap = RootUtil.returnButtonCustActionData(request , new BigDecimal(customBtnId),false,null);
		customBtnDataMap.put("_recReadOnly", _recReadOnly);
		customBtnData = PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true);
		addParameter("customBtnData", findString(customBtnData));
		addParameter("customBtnId", findString(customBtnId));
	    }
	    catch(Exception e)
	    {
		customBtnData = null;
	    }
	}
	else 
	{
	    if(activitiesVOList!=null)
		{
		    for(CustomElementActivitiesSC activityVO : activitiesVOList)
		    {
			SYS_PARAM_ELEM_ACTIVITIESVO sysParamElemActivity = activityVO.getSysParamElemActivitiesVO();
			theVO.setElemSequenceId(sysParamElemActivity.getSEQUENCE_ID());
			 try
			    {
				// if dynamic screen id is set on the button
				if(ButtonCustomizationConstants.ACTIVITY_TYPE.DYNAMIC.equals(sysParamElemActivity.getACTIVITY_TYPE()))
				{
				    onclick = "dynamicScreen_openDynamicScreen(" + sysParamElemActivity.getACTIVITY_ID() + ",null,'" + id + "', " + String.valueOf(NumberUtil.nullEmptyToValue(sysParamElemActivity.getSCREEN_WIDTH(), BigDecimal.ZERO)) + "," + String.valueOf(NumberUtil.nullEmptyToValue(sysParamElemActivity.getSCREEN_HEIGHT(), BigDecimal.ZERO))  + ",null,"+_recReadOnly+",'"+StringUtil.nullToEmpty(baseAction.getText(sysParamElemActivity.getSCREEN_TITLE())).replaceAll("'", "\\\\'")+"' );event.stopImmediatePropagation();";
				    DynamicScreenParamsMapSC criteria = new DynamicScreenParamsMapSC();
				    criteria.setMapElementType(DynamicScreenConstant.MAP_ELEMENT_TYPE.NORMAL_BTN_LINK_TO_DYN_SCREEN.getValue());
				    criteria.setElementIdentifier(sysParamElemActivity.getFLD_IDENTIFIER());
				    criteria.setElementOpId(sysParamElemActivity.getACTIVITY_ID());
				    criteria.setCompCode(theVO.getCOMP_CODE());
				    criteria.setProgRef(theVO.getPROG_REF());
				    
				    //criteria.setCurrAppName(theVO.getAPP_NAME());
				    List<DynamicScreenParamsMapCO> paramList = RootUtil.returnDynScreenMappedParameters(request, criteria);
				    if(paramList != null && !paramList.isEmpty())
				    {	
					customBtnData = "{'dynScreenMappedParameters':".concat( PathJSONUtil.strutsJsonSerialize(paramList, null, null, false, true) ).concat("}");
					addParameter("customBtnData", findString(customBtnData));
				    }
				}
				// if global activity is set on the button, or a custom button is set on an internal screen button
				else if(ButtonCustomizationConstants.ACTIVITY_TYPE.GLOBAL.equals(sysParamElemActivity.getACTIVITY_TYPE()) || ButtonCustomizationConstants.ACTIVITY_TYPE.CUSTOM.equals(sysParamElemActivity.getACTIVITY_TYPE()))
				{
				    Map<String, Object> customBtnDataMap = RootUtil.returnButtonCustActionData(request, sysParamElemActivity.getACTIVITY_ID(),true,theVO);
				    customBtnDataMap.put("dynScreenAppName", sesCO.getCurrentAppName());
				    customBtnDataMap.put("dynScreenProgRef", theVO.getPROG_REF());
				    customBtnDataMap.put("dynScreenCompCode", theVO.getCOMP_CODE());
				    customBtnDataMap.put("dynScreenFldIdentifier", sysParamElemActivity.getFLD_IDENTIFIER());
				    customBtnDataMap.put("isGlobalActivity",true);
				    customBtnDataMap.put("elemSequenceId", sysParamElemActivity.getSEQUENCE_ID());
				    customBtnDataMap.put("_recReadOnly", _recReadOnly);
				    
				    
				    customBtnData = PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true);
				    addParameter("customBtnData", findString(customBtnData));
				    onclick = "customBtnActionCall('" + id + "','0',false);event.stopImmediatePropagation();";
				}
				
				else if(ButtonCustomizationConstants.ACTIVITY_TYPE.BEFOREEXECUTION.equals(sysParamElemActivity.getACTIVITY_TYPE()))
				{
				    Map<String, Object> customBtnDataMap = RootUtil.returnButtonCustActionData(request, sysParamElemActivity.getACTIVITY_ID(),true,theVO);
				    customBtnDataMap.put("dynScreenAppName", sesCO.getCurrentAppName());
				    customBtnDataMap.put("dynScreenProgRef", theVO.getPROG_REF());
				    customBtnDataMap.put("dynScreenCompCode", theVO.getCOMP_CODE());
				    customBtnDataMap.put("dynScreenFldIdentifier", sysParamElemActivity.getFLD_IDENTIFIER());
				    customBtnDataMap.put("isGlobalActivity",true);
				    customBtnDataMap.put("initialOnClick", onclick);
				    customBtnDataMap.put("proceedExpression", sysParamElemActivity.getPROCEED_ON_EXPRESSION());
				    customBtnDataMap.put("elemSequenceId", sysParamElemActivity.getSEQUENCE_ID());
				    customBtnDataMap.put("_recReadOnly", _recReadOnly);
				    addScreenElements(customBtnDataMap,activitiesVOList);
				    customBtnData = PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true);
				    addParameter("customBtnData", findString(customBtnData));
				    String initialOnClick = onclick;
				    onclick = "var stopPropagation = customBtnActionCall('" + id + "', '0',"+("1".equals(sysParamElemActivity.getPROCEED_ON_FAIL()))+"); if(!stopPropagation){" + initialOnClick + "}";
				}
				
				else if(ButtonCustomizationConstants.ACTIVITY_TYPE.AFTEREXECUTION.equals(sysParamElemActivity.getACTIVITY_TYPE()))
				{
				    Map<String, Object> customBtnDataMap = RootUtil.returnButtonCustActionData(request, sysParamElemActivity.getACTIVITY_ID(),true,theVO);
				    customBtnDataMap.put("dynScreenAppName", sesCO.getCurrentAppName());
				    customBtnDataMap.put("dynScreenProgRef", theVO.getPROG_REF());
				    customBtnDataMap.put("dynScreenCompCode", theVO.getCOMP_CODE());
				    customBtnDataMap.put("dynScreenFldIdentifier", sysParamElemActivity.getFLD_IDENTIFIER());
				    customBtnDataMap.put("isGlobalActivity",true);
				    customBtnDataMap.put("elemSequenceId", sysParamElemActivity.getSEQUENCE_ID());
				    customBtnDataMap.put("_recReadOnly", _recReadOnly);
				    addScreenElements(customBtnDataMap,activitiesVOList);
				    customBtnAfterExecData = PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true);
				    addParameter("customBtnAfterExecData", findString(customBtnAfterExecData));
				
				}
				
			    }
			    catch(Exception e)
			    {
				customBtnData = null;
			    }
		    }
		}
	}
	if(StringUtil.isNotEmpty(buttonIconUrl))
	{
	    addParameter("buttonIconUrl", findString(buttonIconUrl));
	}
	
	//escape id from special characters that might be used for security intrusion
	id =  RootUtil.escapeJS(id);
	
	//the super.start() should be called at the end of the method
	return super.start(arg0);
    }

    /**
     * This function is used to return the HTML ELEMENT_IDs defined as mapping data of the custom buttons.
     * That means all the html elements id are returned to be evaluated when clicking the custom button.
     * @param customBtnDataMap
     * @param activitiesVOList
     * @return
     */
    private void addScreenElements(Map<String, Object> customBtnDataMap,List<CustomElementActivitiesSC> activitiesVOList) throws BaseException
    {
	// incase the screenElementsList already filled from rootUtil where there is condition on the custom button then no need to fill the screen elements again.
	if(!customBtnDataMap.containsKey("screenElementsList"))
	{
	    SessionCO sessionCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
		String pageRef = request.getParameter("_pageRef");

		BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext()
			.getBean("baseServices");
		CommonLibBO commonLibBO = baseServices.returnCommonLibBO();

		// need to send original prog ref in case of Save AS since the original
		// screen elements are defined in SYS_PARAM_SCREEN_ELEMENTS only
		String theProgRef = commonLibBO.returnOrginProgRef(sessionCO.getCurrentAppName(), pageRef);
		List<BigDecimal> fieldIdentifierList = new ArrayList<BigDecimal>();
		for(CustomElementActivitiesSC activityVO : activitiesVOList)
		{
		    if(StringUtil.isNotEmpty(activityVO.getSysParamElemActivitiesVO().getPROCEED_ON_EXPRESSION()))
		    {
			Pattern pattern = Pattern.compile("(.*?)(F.([0-9]*))(.*?)");
			Matcher matcher = pattern.matcher(activityVO.getSysParamElemActivitiesVO().getPROCEED_ON_EXPRESSION());
			while(matcher.find())
			{
			    if(StringUtil.isNumeric(matcher.group(3), false))
			    {
				BigDecimal fldIdentifier = new BigDecimal(matcher.group(3));
				fieldIdentifierList.add(fldIdentifier);
			    }
			}
		    }
		}
		if(!fieldIdentifierList.isEmpty())
		{
		    List<SYS_PARAM_SCREEN_ELEMENTSVO> screenElementsList = commonLibBO.returnButtonCustScreenElement(sessionCO.getCurrentAppName(), theProgRef, fieldIdentifierList);

		    if(screenElementsList != null && !screenElementsList.isEmpty())
		    {
			 customBtnDataMap.put("screenElementsList", screenElementsList);
		    }
		}
	}
    }

    public String getAllowView()
    {
	return allowView;
    }

    public void setAllowView(String allowView)
    {
	this.allowView = allowView;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    /**
     * @return the allowCust
     */
    public String getAllowCust()
    {
        return allowCust;
    }

    /**
     * @param allowCust the allowCust to set
     */
    public void setAllowCust(String allowCust)
    {
        this.allowCust = allowCust;
    }

    
    public String getEnableAfterExecution()
    {
        return enableAfterExecution;
    }

    public void setEnableAfterExecution(String enableAfterExecution)
    {
        this.enableAfterExecution = enableAfterExecution;
    }

    /**
     * @return the overrideLabelText
     */
    public String getOverrideLabelText()
    {
        return overrideLabelText;
    }

    /**
     * @param overrideLabelText the overrideLabelText to set
     */
    public void setOverrideLabelText(String overrideLabelText)
    {
        this.overrideLabelText = overrideLabelText;
    }

    /**
     * @return the overrideLabelKey
     */
    public String getOverrideLabelKey()
    {
        return overrideLabelKey;
    }

    /**
     * @param overrideLabelKey the overrideLabelKey to set
     */
    public void setOverrideLabelKey(String overrideLabelKey)
    {
        this.overrideLabelKey = overrideLabelKey;
    }

    /**
     * @return the shortcutKey
     */
    public String getShortcutKey()
    {
        return shortcutKey;
    }

    /**
     * @param shortcutKey the shortcutKey to set
     */
    public void setShortcutKey(String shortcutKey)
    {
        this.shortcutKey = shortcutKey;
    }

    public String getCustomBtnId()
    {
        return customBtnId;
    }

    public void setCustomBtnId(String customBtnId)
    {
        this.customBtnId = customBtnId;
    }

    public String getCustomBtnData()
    {
        return customBtnData;
    }

    public void setCustomBtnData(String customBtnData)
    {
        this.customBtnData = customBtnData;
    }

    public String getCustomBtnAfterExecData()
    {
        return customBtnAfterExecData;
    }

    public void setCustomBtnAfterExecData(String customBtnAfterExecData)
    {
        this.customBtnAfterExecData = customBtnAfterExecData;
    }

    public String getFieldAudit()
    {
	return fieldAudit;
    }

    public void setFieldAudit(String fieldAudit)
    {
	this.fieldAudit = fieldAudit;
    }

    public String getButtonIconUrl()
    {
        return buttonIconUrl;
    }

    public void setButtonIconUrl(String buttonIconUrl)
    {
        this.buttonIconUrl = buttonIconUrl;
    }

    /**
     * @return the sourceAppName
     */
    public String getSourceAppName()
    {
        return sourceAppName;
    }

    /**
     * @param sourceAppName the sourceAppName to set
     */
    public void setSourceAppName(String sourceAppName)
    {
        this.sourceAppName = sourceAppName;
    }
    
}
