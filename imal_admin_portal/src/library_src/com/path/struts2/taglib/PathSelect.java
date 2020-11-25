package com.path.struts2.taglib;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Select;

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

public class PathSelect extends Select
{
    private String dependency, dependencySrc, parameter,afterDepEvent,beforeDepEvent;
    private String overrideLabelText;
    private String overrideLabelKey;
    private String fieldAudit;
    private String considerChoiceValue;
    private String dynValue;
    
    private String required;

    public PathSelect(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    @Override
    public void evaluateExtraParams()
    {
	super.evaluateExtraParams();
	/**
	 * [MarwanMaddah] BUG #439547
	 * The flag considerChoiceValue has been added to avoid any conflict in value process between dynamic screens and regular screens 
	 * because from dynamic screen the real value will be passed from action 
	 * where from regular tag(from JSP), the value will be the name of a property from action in this case this flag will be null
	 */
	if(!StringUtil.nullToEmpty(dynValue).isEmpty() && ConstantsCommon.TRUE.equals(considerChoiceValue))
	{
	    addParameter("nameValue",dynValue);
	}
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
	    if(!StringUtil.nullToEmpty(theVO.getValue()).isEmpty())
	    {
		addParameter("nameValue",theVO.getValue());
	    }
	    
	    // Enable field audit management
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
	// empty could come from DynamicParam form construction
	if(dependencySrc != null && !dependencySrc.trim().isEmpty() && dependency != null && !dependency.trim().isEmpty())
	{
	    String escapedDep = findString(dependency);
	    escapedDep = StringUtil.removeNewLineTabSpace(escapedDep);
	    addParameter("dependency", escapedDep);
	    addParameter("dependencySrc", findString(dependencySrc));
	}
	// empty could come from DynamicParam form construction
	if(parameter != null && !parameter.trim().isEmpty())
	{
	    String escapedDep = findString(parameter);
	    escapedDep = StringUtil.removeNewLineTabSpace(escapedDep);
	    addParameter("parameter", escapedDep);
	}
	if(afterDepEvent != null)
	{
	    addParameter("afterDepEvent",findString(afterDepEvent));
	}
	if(beforeDepEvent != null)
	{
	    addParameter("beforeDepEvent",findString(beforeDepEvent));
	}
	
	// tooltip for the input
	String toolTip = RootUtil.returnFieldToolTipWithCustomization(request,name, id,theVO);
	if(toolTip != null)
	{
	    addParameter("title", toolTip);
	}
	
	HashMap<String,  HashMap<String, String>> hm = RootUtil.returnChangesHighlightsForElt(request);
	if(hm != null && hm.containsKey(name) && !StringUtil.nullToEmpty((hm.get(name)).get("OLD_VALUE")).equals(StringUtil.nullToEmpty(getParameters().get("nameValue"))))
	{
	    if(cssClass == null)
	    {
		cssClass = "";
	    }
	    cssClass = cssClass.concat(" pathHighlights");
	    addParameter("cssClass", findString(cssClass));
        /**
         * [MarwanMaddah]
         * added the below checking 
         * to avoid the null pointer exception issue that has been faced with IIS team
         * in case of select box with old value bigdecimal and null
         */
        if(StringUtil.nullToEmpty((hm.get(name)).get("OLD_VALUE")).isEmpty())
        {
          addParameter("oldValue",null);
        }
        else
        {       
          addParameter("oldValue", findString((hm.get(name)).get("OLD_VALUE")));
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
     * @return the considerChoiceValue
     */
    public String getConsiderChoiceValue()
    {
        return considerChoiceValue;
    }

    /**
     * @param considerChoiceValue the considerChoiceValue to set
     */
    public void setConsiderChoiceValue(String considerChoiceValue)
    {
        this.considerChoiceValue = considerChoiceValue;
    }

    /**
     * @return the dynValue
     */
    public String getDynValue()
    {
        return dynValue;
    }

    /**
     * @param dynValue the dynValue to set
     */
    public void setDynValue(String dynValue)
    {
        this.dynValue = dynValue;
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
