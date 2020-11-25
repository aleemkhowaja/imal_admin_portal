package com.path.struts2.taglib;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Checkbox;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.CurrElementExpressionsCO;
import com.path.vo.common.SessionCO;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: DeniskHaddad
 *
 * PathCheckbox.java used to overwrite Struts CheckBox Component
 */
public class PathCheckbox extends Checkbox {
   
    // common attributes
    private String dependency, dependencySrc, parameter,afterDepEvent;
    private String overrideLabelText;
    private String overrideLabelKey;
    private String fieldAudit;
    private String allowDefValCust;
    private String valOpt; //value options specify values for true:false
    public PathCheckbox(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    
    @Override
    protected void evaluateExtraParams() 
    {
	super.evaluateExtraParams();
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	// manipulating dynamic display for checkbox tag , visibility, readonly
	SYS_PARAM_SCREEN_DISPLAYVO theVO = null;
	String ref = name;
	if(name == null)
	{
	    ref = id;
	}
	theVO = RootUtil.returnParamScreenDisplay(request, ref,id);
	
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
	    if(theVO.getIS_VISIBLE()!= null && theVO.getIS_VISIBLE().intValue() == 0)
	    {
		if(cssStyle == null )
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
		    addParameter("hideLabel", "true");
		    addParameter("cssStyle", findString(cssStyle));
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
	    //check for default value
	    if(Boolean.valueOf(allowDefValCust)
		    && StringUtil.isNotEmpty(name) && findValue(name) == null
		    && StringUtil.isNotEmpty(theVO.getDEFAULT_VALUE()))
	    {
		
		addParameter("nameValue", theVO.getDEFAULT_VALUE());
	    }
	    
	}
	
	if(dependencySrc != null && !dependencySrc.trim().isEmpty() && dependency != null && !dependency.trim().isEmpty())
	{
		addParameter("dependencySrc", findString(dependencySrc));
		String escapedDep = findString(dependency);
		escapedDep = StringUtil.removeNewLineTabSpace(escapedDep);
		addParameter("dependency", escapedDep);
	}
	// empty could come from DynamicParam form construction
	if(parameter != null && !parameter.trim().isEmpty())
	{
		addParameter("parameter", findString(parameter));
	}
	if(afterDepEvent != null)
	{
	    addParameter("afterDepEvent",findString(afterDepEvent));
	}
	if(!StringUtil.nullToEmpty(valOpt).isEmpty())
	{
	    addParameter("valOpt",findString(valOpt));
	}
	if(!StringUtil.nullToEmpty(allowDefValCust).isEmpty())
	{
	    addParameter("allowDefValCust",findString(allowDefValCust));
	}
	
	if(!StringUtil.nullToEmpty(key).isEmpty())
	{
	    addParameter("labelKey",findString(key));
	}
	
	HashMap<String,  HashMap<String, String>> hm = RootUtil.returnChangesHighlightsForElt(request);
	if(hm != null && hm.containsKey(name) && !StringUtil.nullToEmpty((hm.get(name)).get("OLD_VALUE")).equals(StringUtil.nullToEmpty(getParameters().get("nameValue"))))
	{
	    if(cssClass == null)
	    {
		cssClass = "";
	    }
	    cssClass = cssClass.concat(" checkboxHighlights");
	    addParameter("cssClass", findString(cssClass));
	    String newTitle = StringUtil.nullToEmpty(getParameters().get("title"));
	    if(!newTitle.isEmpty())
	    {
		newTitle = newTitle.concat("\n");
	    }
	    String oldValStr = (hm.get(name)).get("OLD_VALUE");
	    boolean isChecked = false;
	    if(valOpt == null) 
            {
		isChecked = Boolean.valueOf(oldValStr); 
            }
	    else
	    {
		String[] valOptArr = valOpt.split(":");
		if(valOptArr[0].equals(oldValStr))
		{
		    isChecked = true;
		}
	    }
	    
	    newTitle = newTitle.concat(RootUtil.returnTransMsg(request, "oldValKey").concat(": "));
	    if(isChecked)
	    {
		newTitle = newTitle.concat(RootUtil.returnTransMsg(request, "checkedValKey"));
	    }
	    else
	    {
		newTitle = newTitle.concat(RootUtil.returnTransMsg(request, "notCheckedValKey"));
	    }
	    addParameter("title", newTitle);
	}
        /**
         * [MarwanMaddah]
         * dynamic dependency management.
         * in case the flag APPLY_DYN_EXPRESSION is TRUE
         * will check if the current element is exists in any expression on any other element on the screen 
         * in case exists will arrange those elements and add them as dynExpressionArgs 
         * to use them in the Interceptor(PathSessionInterceptor) after calling the dependency which can be defined from the dev 
         * or the default dependency that will be added in case there is no dependency defined from Dev side
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

    }
    
    @Override
    protected Class getValueClassType() {
        return String.class;
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


    public String getValOpt()
    {
        return valOpt;
    }


    public void setValOpt(String valOpt)
    {
        this.valOpt = valOpt;
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
     * @return the allowDefValCust
     */
    public String getAllowDefValCust()
    {
        return allowDefValCust;
    }


    /**
     * @param allowDefValCust the allowDefValCust to set
     */
    public void setAllowDefValCust(String allowDefValCust)
    {
        this.allowDefValCust = allowDefValCust;
    }
}
