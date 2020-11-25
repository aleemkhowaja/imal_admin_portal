package com.path.struts2.taglib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.TextField;

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

public class PathTextField extends TextField
{
	protected String mode;
	private static String NUMBER_MODE = "number";

	// common attributes
	private String dependency, dependencySrc, parameter;

	// number attribute
	protected String minValue;
	protected String maxValue;
	protected String nbFormat;
	private String roundNumber;
	private String zeroNotAllowed;
	private String noFormat;
	private String groupSepa;
	private String decimalSepa;
	private String showCurrency;
	private String currencySymbol;
	private String emptyValue;
	private String leadZeros;
	private String afterDepEvent;
	private String beforeDepEvent;
	private String overrideLabelText;
	private String txtFormat; //any text format could be telephone,email etc... 
        private String descriptionKey;
        private String onlyArabic;
        private String overrideLabelKey;
        private String maxLenBeforeDec;
        private String allowDefValCust;
        private String fieldAudit;
        private String customBtnData;
        private String customKeyEventBtnData;
        
        private String required;
        
	/**
	 * In case the textfield is on mode number, 
	 * This attribute used to defined the javaScript function where the formatting will be manage
	 */
	private String formatter;
	
	public PathTextField(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
	{
		super(stack, request, response);
	}

	@Override
	protected void evaluateExtraParams()
	{
		super.evaluateExtraParams();
		BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
		SYS_PARAM_SCREEN_DISPLAYVO theVO = RootUtil.returnParamScreenDisplay(request, name, id);
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
			maxlength = theVO.getMAX_LENGTH().toString();
		    }
		    
		    // control on Number Format for numeric inputs
		    if(theVO.getDecFormat() != null && NUMBER_MODE.equals(mode))
		    {
			nbFormat = theVO.getDecFormat();
		    }
		    else if(theVO.getTxtFormat() != null )
		    {
			txtFormat = theVO.getTxtFormat();
		    }
		    
		    if(NumberUtil.nullToZero(theVO.getZERO_NOT_ALLOWED()).intValue() > 0)
		    {
			zeroNotAllowed = "true";
		    }
		    
		    if(theVO.getLEAD_ZEROS() != null)
		    {
			leadZeros = theVO.getLEAD_ZEROS().toString();
		    }
		    
		    //check for default value
		    if(Boolean.valueOf(allowDefValCust)
			    && StringUtil.isNotEmpty(name) && findValue(name) == null
			    && StringUtil.isNotEmpty(theVO.getDEFAULT_VALUE()))
		    {
			addParameter("nameValue", theVO.getDEFAULT_VALUE());
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
		    
		    // control on Min Length Field if Exists
		    if(theVO.getMIN_LENGTH() != null && theVO.getMIN_LENGTH().intValue() > 0)
		    {
			addParameter("minlength", theVO.getMIN_LENGTH().intValue());
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
		}
		
		if(descriptionKey == null)
		{
		    String toolTip = RootUtil.returnFieldToolTipWithCustomization(request, name, id, theVO);
		    if(toolTip != null)
		    {
			addParameter("title", toolTip);
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
		// empty could come from DynamicParam form construction
		if(parameter != null && !parameter.trim().isEmpty())
		{
		    String escapedPara = findString(parameter);
		    escapedPara = StringUtil.removeNewLineTabSpace(escapedPara);
		    addParameter("parameter", escapedPara);
		}
		if(maxlength != null && !maxlength.trim().isEmpty())
		{
		    addParameter("maxlength", findString(maxlength));
		}
		// empty could come from DynamicParam form construction
		if(dependencySrc != null && !dependencySrc.trim().isEmpty() && dependency != null && !dependency.trim().isEmpty())
		{
			addParameter("dependencySrc", findString(dependencySrc));
			
			String escapedDep = findString(dependency);
			escapedDep = StringUtil.removeNewLineTabSpace(escapedDep);
			addParameter("dependency", escapedDep);
		}
		if(mode != null)
		{
			addParameter("mode", findString(mode));
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
		// empty could come from DynamicParam form construction
		if(maxLenBeforeDec != null && !maxLenBeforeDec.trim().isEmpty())
		{
		    addParameter("maxLenBeforeDec", findString(maxLenBeforeDec));
		}
		
		if(nbFormat != null)
		{
			addParameter("nbFormat", findString(nbFormat));
		}
		if(roundNumber != null)
		{
			addParameter("roundNumber", findString(roundNumber));
		}
		if(zeroNotAllowed != null)
		{
			addParameter("zeroNotAllowed", findString(zeroNotAllowed));
		}
		if(noFormat != null)
		{
			addParameter("noFormat", findString(noFormat));
		}
		if(showCurrency != null)
		{
			addParameter("showCurrency", findString(showCurrency));
		}
		if(currencySymbol != null)
		{
			addParameter("currencySymbol", findString(currencySymbol));
		}
		if(emptyValue != null)
		{
		    addParameter("emptyValue", findString(emptyValue));
		}
		if(decimalSepa != null)
		{
		    addParameter("decimalSepa",findString(decimalSepa));
		}
		if(groupSepa != null)
		{
		    addParameter("groupSepa",findString(groupSepa));
		}
		if(leadZeros != null)
		{
		    addParameter("leadZeros",findString(leadZeros));
		}
		if(afterDepEvent != null)
		{
		    addParameter("afterDepEvent",findString(afterDepEvent));
		}
		if(beforeDepEvent != null)
		{
		    addParameter("beforeDepEvent",findString(beforeDepEvent));
		}
		if(txtFormat != null)
		{
		    addParameter("txtFormat",findString(txtFormat));
		}
		if(formatter != null)
		{
		    addParameter("formatter",findString(formatter));
		}
		if(allowDefValCust != null)
		{
		    addParameter("allowDefValCust",findString(allowDefValCust));
		}
		if(descriptionKey != null)
		{
		    
		    descriptionKey =  baseAction.getText(descriptionKey);
		    addParameter("descriptionKey",findString(descriptionKey));
		    String mouseOver = "toggleEltDescriptionDiv('"+id+"')";
		    onmouseover = StringUtil.nullToEmpty(onmouseover);
		    onmouseover += ";" + mouseOver; 
		    addParameter("onmouseover", findString(onmouseover));
		}
		/**
		 * only arabic management
		 */
		if(onlyArabic==null || NUMBER_MODE.equals(mode))
		{
		    addParameter("onlyArabic","false");
		}
		else
		{
		    addParameter("onlyArabic",findString(onlyArabic));
		}
	        /**
	         * [MarwanMaddah]
	         * dynamic dependency management.
	         * this part is used to prepare the dependency based on the expressions
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

	public String getMode()
	{
		return mode;
	}

	public void setMode(String mode)
	{
		this.mode = mode;
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

	public String getNbFormat()
	{
		return nbFormat;
	}

	public void setNbFormat(String nbFormat)
	{
		this.nbFormat = nbFormat;
	}

	public String getGroupSepa()
	{
		return groupSepa;
	}

	public void setGroupSepa(String groupSepa)
	{
		this.groupSepa = groupSepa;
	}

	public String getDecimalSepa()
	{
		return decimalSepa;
	}

	public void setDecimalSepa(String decimalSepa)
	{
		this.decimalSepa = decimalSepa;
	}

	public String getRoundNumber()
	{
		return roundNumber;
	}

	public void setRoundNumber(String roundNumber)
	{
		this.roundNumber = roundNumber;
	}


	public String getNoFormat()
	{
		return noFormat;
	}

	public void setNoFormat(String noFormat)
	{
		this.noFormat = noFormat;
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

	public String getShowCurrency()
	{
		return showCurrency;
	}

	public void setShowCurrency(String showCurrency)
	{
		this.showCurrency = showCurrency;
	}

	public String getCurrencySymbol()
	{
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol)
	{
		this.currencySymbol = currencySymbol;
	}

	public String getEmptyValue()
	{
		return emptyValue;
	}

	public void setEmptyValue(String emptyValue)
	{
		this.emptyValue = emptyValue;
	}

	/**
	 * @return the leadZeros
	 */
	public String getLeadZeros()
	{
	    return leadZeros;
	}

	/**
	 * @param leadZeros the leadZeros to set
	 */
	public void setLeadZeros(String leadZeros)
	{
	    this.leadZeros = leadZeros;
	}

	public String getAfterDepEvent()
	{
	    return afterDepEvent;
	}

	public void setAfterDepEvent(String afterDepEvent)
	{
	    this.afterDepEvent = afterDepEvent;
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

	public String getTxtFormat()
	{
	    return txtFormat;
	}

	public void setTxtFormat(String txtFormat)
	{
	    this.txtFormat = txtFormat;
	}

	/**
	 * @return the formatter
	 */
	public String getFormatter()
	{
	    return formatter;
	}

	/**
	 * @param formatter the formatter to set
	 */
	public void setFormatter(String formatter)
	{
	    this.formatter = formatter;
	}

	public String getDescriptionKey()
	{
	    return descriptionKey;
	}

	public void setDescriptionKey(String descriptionKey)
	{
	    this.descriptionKey = descriptionKey;
	}

	/**
	 * @return the onlyArabic
	 */
	public String getOnlyArabic()
	{
	    return onlyArabic;
	}

	/**
	 * @param onlyArabic the onlyArabic to set
	 */
	public void setOnlyArabic(String onlyArabic)
	{
	    this.onlyArabic = onlyArabic;
	}

	public String getOverrideLabelKey()
	{
	    return overrideLabelKey;
	}

	public void setOverrideLabelKey(String overrideLabelKey)
	{
	    this.overrideLabelKey = overrideLabelKey;
	}

	public String getMaxLenBeforeDec()
	{
	    return maxLenBeforeDec;
	}

	public void setMaxLenBeforeDec(String maxLenBeforeDec)
	{
	    this.maxLenBeforeDec = maxLenBeforeDec;
	}

	public String getAllowDefValCust()
	{
	    return allowDefValCust;
	}

	public void setAllowDefValCust(String allowDefValCust)
	{
	    this.allowDefValCust = allowDefValCust;
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
	
	
}
