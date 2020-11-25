package com.path.struts2.taglib;

import java.io.Writer;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgeppert.struts2.jquery.components.DatePicker;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.CurrElementExpressionsCO;
import com.path.vo.common.SessionCO;

public class PathDatePicker extends DatePicker
{

    private String dependency, dependencySrc, parameter, afterDepEvent, beforeDepEvent;
    private String overrideLabelText;
    private String showHijri;
    private String showOnlyHijri;
    private String dateLabelsKeys;
    private String overrideLabelKey;
    private String fieldAudit;
    
    private String required;
    
    // ISO date formats
    private static final String CLIENT_DATE_FORMAT = "yyyy-MM-dd";
    private static final String CLIENT_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    public PathDatePicker(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    @Override
    public boolean start(Writer arg0)
    {
	//the additional code should exists before calling super.start()	
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
		    disabled= "true";
		}
		else
		{
		    readonly = "false";
		    disabled= "false";
		}
		addParameter("readonly", findValue(readonly, Boolean.class));
		addParameter("disabled", findValue(disabled, Boolean.class));
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
		overrideLabelText = baseAction.getText(theVO.getLABEL_KEY());
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
	/**
	     * 
	     */
	// empty could come from DynamicParam form construction
	if(parameter != null && !parameter.trim().isEmpty())
	{
	    String escapedPar = findString(parameter);
	    escapedPar = StringUtil.removeNewLineTabSpace(escapedPar);
	    addParameter("parameter", escapedPar);
	}
	// empty could come from DynamicParam form construction
	if(dependencySrc != null && !dependencySrc.trim().isEmpty() && dependency != null && !dependency.trim().isEmpty())
	{
	    addParameter("dependencySrc", findString(dependencySrc));
	    addParameter("dependency", findString(dependency));
	}

	if(afterDepEvent != null)
	{
	    addParameter("afterDepEvent", findString(afterDepEvent));
	}
	if(beforeDepEvent != null)
	{
	    addParameter("beforeDepEvent", findString(beforeDepEvent));
	}

	if(name != null)
	{
	    Object dateVal = findValue(name);

	    if(dateVal instanceof Date)
	    {
		String clientFormat = CLIENT_DATE_FORMAT; // format accepted by
							  // JS new Date (value)
		if(timepicker != null && timepicker.equals("true"))
		{
		    clientFormat = CLIENT_DATETIME_FORMAT;
		}
		addParameter("prevValue", DateUtil.format((Date) dateVal, clientFormat));
	    }
	}

	/**
	 * Hijri Date Management
	 */
	if(StringUtil.isNotEmpty(showHijri) && "true".equals(showHijri))
	{
	    addParameter("showHijri", findString(showHijri));
	    addParameter("langCode", ActionContext.getContext().getLocale().getLanguage());
	}
	else
	{
	    addParameter("showHijri", "false");
	}
	if(showOnlyHijri == null)
	{
	    addParameter("showOnlyHijri", "false");
	}
	else
	{
	    addParameter("showOnlyHijri", findString(showOnlyHijri));
	}
	if(StringUtil.isNotEmpty(showOnlyHijri) && "true".equals(showOnlyHijri))
	{
	    String cssGregorianStyle = "";
	    if(cssStyle == null || cssStyle.isEmpty())
	    {
		addParameter("cssStyle", "");
		cssGregorianStyle = "display:none";
	    }
	    else
	    {
		addParameter("cssStyle", cssStyle);
		cssGregorianStyle = cssStyle + ";display:none";
	    }
	    addParameter("cssGregorianStyle", findString(cssGregorianStyle));
	}
	
	if(dateLabelsKeys != null && !"".equals(dateLabelsKeys))
	{
	    addParameter("dateLabelsKeys", dateLabelsKeys);
	}
	
	if(theVO == null || StringUtil.nullToEmpty(theVO.getBACKGROUND_COLOR()).isEmpty())
	{
	    HashMap<String,  HashMap<String, String>> hm = RootUtil.returnChangesHighlightsForElt(request);
	    if(hm != null && hm.containsKey(name) && !StringUtil.nullToEmpty((hm.get(name)).get("OLD_VALUE")).equals(StringUtil.nullToEmpty(getParameters().get("prevValue"))))
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
	/**
	 * end
	 */
	
	if(StringUtil.isNotEmpty(required))
	{
	    addParameter("required", findValue(required, Boolean.class));
	}
	
	//the super.start() should be called at the end of the method
	return super.start(arg0);
    }
    
    /**
     * method needed to set the time when date is used with timepicker and value is specified instead of name property
     * since start method is overriding the hour/minute/second parameters to 0 (no time) 
     */
    @Override
    public void evaluateParams()
    {
      super.evaluateParams();
   // in case of dynamic params they are setting the value as a string in
	// the ISO format
	if(value != null && "true".equals(timepicker))
	{
	    Object nameValue = null;
	    Calendar cal = null;
	    nameValue = findValue(value);
	    if(nameValue == null)
	    {
		nameValue = findString(value);
		if(!nameValue.toString().isEmpty())
		{
		    cal = new GregorianCalendar();
		    try
		    {
			cal.setTime(DateUtil.parseDate(nameValue.toString(), CLIENT_DATETIME_FORMAT));
		    }
		    catch(Exception e)
		    {
			Log.getInstance().warning("Not parsable date "+nameValue.toString() +" to Format "+CLIENT_DATETIME_FORMAT+" >> "+e.getMessage());
		    }
		}
	    }
	    else
	    {
		cal = new GregorianCalendar();
		cal.setTime((Date) nameValue);
	    }
	    if(cal != null)
	    {
		// adding all the date parameters in order for value to be set
		// correctly in datepicker
		addParameter("dayValue", Integer.toString(cal.get(Calendar.DAY_OF_MONTH)));
		addParameter("monthValue", Integer.toString(cal.get(Calendar.MONTH)));
		addParameter("yearValue", Integer.toString(cal.get(Calendar.YEAR)));
		addParameter("hourValue", Integer.toString(cal.get(Calendar.HOUR)));
		addParameter("minuteValue", Integer.toString(cal.get(Calendar.MINUTE)));
		addParameter("secondValue", Integer.toString(cal.get(Calendar.SECOND)));
	    }
	}
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

    public String getOverrideLabelText()
    {
	return overrideLabelText;
    }

    public void setOverrideLabelText(String overrideLabelText)
    {
	this.overrideLabelText = overrideLabelText;
    }

    public String getAfterDepEvent()
    {
	return afterDepEvent;
    }

    public void setAfterDepEvent(String afterDepEvent)
    {
	this.afterDepEvent = afterDepEvent;
    }

    public String getBeforeDepEvent()
    {
	return beforeDepEvent;
    }

    public void setBeforeDepEvent(String beforeDepEvent)
    {
	this.beforeDepEvent = beforeDepEvent;
    }

    /**
     * @return the showHijri
     */
    public String getShowHijri()
    {
	return showHijri;
    }

    /**
     * @param showHijri the showHijri to set
     */
    public void setShowHijri(String showHijri)
    {
	this.showHijri = showHijri;
    }

    /**
     * @return the showOnlyHijri
     */
    public String getShowOnlyHijri()
    {
	return showOnlyHijri;
    }

    /**
     * @param showOnlyHijri the showOnlyHijri to set
     */
    public void setShowOnlyHijri(String showOnlyHijri)
    {
	this.showOnlyHijri = showOnlyHijri;
    }

    /**
     * @return the dateLabelsKeys
     */
    public String getDateLabelsKeys()
    {
	return dateLabelsKeys;
    }

    /**
     * @param dateLabelsKeys the dateLabelsKeys to set
     */
    public void setDateLabelsKeys(String dateLabelsKeys)
    {
	this.dateLabelsKeys = dateLabelsKeys;
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
