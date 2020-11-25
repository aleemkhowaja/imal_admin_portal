package com.path.struts2.taglib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.TextArea;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_ELEM_ACTIVITIESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
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

public class PathTextArea extends TextArea {

    private String dir;
    private String maxlength;
    private String size;
    private String overrideLabelText;
    private String overrideLabelKey;
    private String fieldAudit;
    private String customBtnData;
    private String customKeyEventBtnData;
    private String onlyArabic;
    
    private String required;
    
    
    public PathTextArea(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }


    @Override
    public void evaluateExtraParams() {
        super.evaluateExtraParams();        
        SYS_PARAM_SCREEN_DISPLAYVO theVO = RootUtil.returnParamScreenDisplay(request, name, id);
        BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	if(theVO != null)
	{
	    if(theVO.getIS_MANDATORY() != null)
	    {
        	    if(theVO.getIS_MANDATORY().intValue() == 1)
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
        		readonly = "true";
        	    }
        	    else
        	    {
        		readonly = "false";
        	    }
        	    addParameter("readonly", findValue(readonly, Boolean.class));
	    }
	    if(theVO.getIS_VISIBLE() != null && theVO.getIS_VISIBLE().intValue() == 0)
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
		if(cssStyle == null || cssStyle.isEmpty())
		{
		    cssStyle = "";
		}
		else
		{
		    cssStyle += ";";
		}
		cssStyle += "background:" + theVO.getBACKGROUND_COLOR() + " !important";
		addParameter("cssStyle", findString(cssStyle));
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
		addParameter("title", newTitle.concat(RootUtil.returnTransMsg(request, "oldValKey").concat(": ") +(hm.get(name)).get("OLD_VALUE")));
	    }
	}
	
	/**
	 * only arabic management
	 */
	if(onlyArabic==null)
	{
	    addParameter("onlyArabic","false");
	}
	else
	{
	    addParameter("onlyArabic",findString(onlyArabic));
	}
	
	if(dir != null)
	{
	    addParameter("dir", findString(dir));
	}
	if(maxlength != null && !maxlength.trim().isEmpty())
	{
	    addParameter("maxlength", findString(maxlength));
	}
	if(size != null)
	{
	    addParameter("size", findString(size));
	}
	
	String toolTip = RootUtil.returnFieldToolTipWithCustomization(request,name, id, theVO);
	if(toolTip != null)
	{
	    addParameter("title", toolTip);
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
		    boolean defaultDependency = true;//(dependencySrc==null?true:false); 
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
        			customBtnDataMap.put("elemSequenceId", sysParamElemActivity.getSEQUENCE_ID());
        			customBtnDataMap.put("proceedExpression", sysParamElemActivity.getPROCEED_ON_EXPRESSION());
        			RootUtil.addScreenElements(customBtnDataMap, activitiesVOList,request);
        			customBtnData = PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true);
        			addParameter("customBtnData", findString(customBtnData));
            			String initialOnChange = onchange;
            			String onchangeValue = "var stopPropagation = customBtnActionCall('" + id + "', '0',"
            				+ ("1".equals(sysParamElemActivity.getPROCEED_ON_FAIL()))+"); if(!stopPropagation){"
            				+ initialOnChange + "}";
            			addParameter("onchange", onchangeValue);
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
    }


    public String getDir()
    {
        return dir;
    }


    public void setDir(String dir)
    {
        this.dir = dir;
    }


    public String getMaxlength()
    {
        return maxlength;
    }


    public void setMaxlength(String maxlength)
    {
        this.maxlength = maxlength;
    }


    public String getSize()
    {
        return size;
    }


    public void setSize(String size)
    {
        this.size = size;
    }


    public String getOverrideLabelText()
    {
        return overrideLabelText;
    }


    public void setOverrideLabelText(String overrideLabelText)
    {
        this.overrideLabelText = overrideLabelText;
    }


    public String getOverrideLabelKey()
    {
        return overrideLabelKey;
    }


    public void setOverrideLabelKey(String overrideLabelKey)
    {
        this.overrideLabelKey = overrideLabelKey;
    }

    public String getFieldAudit()
    {
	return fieldAudit;
    }

    public void setFieldAudit(String fieldAudit)
    {
	this.fieldAudit = fieldAudit;
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


    public String getOnlyArabic()
    {
        return onlyArabic;
    }


    public void setOnlyArabic(String onlyArabic)
    {
        this.onlyArabic = onlyArabic;
    }
    
    
}
