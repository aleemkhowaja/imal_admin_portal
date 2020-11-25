package com.path.struts2.taglib;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Radio;

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
public class PathRadio extends Radio {

    private String overrideLabelText;
    private String overrideLabelKey;
    private String fieldAudit;
    private String considerChoiceValue;
    private String dynValue;
    //Bug 514831 Handling Radio Group label    
    private String groupElemKeyLabel;
    private String hasHiddenOpt;
    
    public PathRadio(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }
    @Override
    public void evaluateExtraParams()
    {
        super.evaluateExtraParams();
     // manipulating dynamic display for checkbox tag , visibility, readonly
	SYS_PARAM_SCREEN_DISPLAYVO theVO = null;
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	String ref = name;
	if(name == null)
	{
	    ref = id;
	}
	/**
	 * [MarwanMaddah] BUG #439443
	 * the flag considerChoiceValue has been added to avoid any conflict in value process between dynamic screens and regular screens 
	 * because from dynamci screen the real value will be passed from action 
	 * where from regular tag (from jsp), the value will be the name of a property from action in this case this flag will be null
	 */
	if(!StringUtil.nullToEmpty(dynValue).isEmpty() && ConstantsCommon.TRUE.equals(considerChoiceValue))
	{
	   addParameter("nameValue",dynValue);
	}
	
	//Set groupElemKeyLabel
	if(StringUtil.isNotEmpty(groupElemKeyLabel))
	{
	    addParameter("groupElemKeyLabel", findString(groupElemKeyLabel));
	}
	/**
	 *  [MarwanMaddah]:BBRUP180313
	 *  added to manage the default radio option, by adding a hidden option and select it as default 
	 *  in case the radio button is coming from a dynamic screen without a defined default value 
	 */
	if(!StringUtil.nullToEmpty(hasHiddenOpt).isEmpty() && ConstantsCommon.ONE.equals(hasHiddenOpt))
	{
	    addParameter("hasHiddenOpt", findString(hasHiddenOpt));
	}
	/**
	 * 
	 */
	theVO = RootUtil.returnParamScreenDisplay(request, ref, id);
	
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
		    addParameter("cssStyle", findString(cssStyle));
		}
	    }
	    if(theVO.getValue()!=null)
	    {		
	       	addParameter("nameValue",theVO.getValue());
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
	/**
	 * end
	 */
	
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
    public String getGroupElemKeyLabel()
    {
	return groupElemKeyLabel;
    }
    public void setGroupElemKeyLabel(String groupElemKeyLabel)
    {
	this.groupElemKeyLabel = groupElemKeyLabel;
    }
    /**
     * @return the hasHiddenOpt
     */
    public String getHasHiddenOpt()
    {
        return hasHiddenOpt;
    }
    /**
     * @param hasHiddenOpt the hasHiddenOpt to set
     */
    public void setHasHiddenOpt(String hasHiddenOpt)
    {
        this.hasHiddenOpt = hasHiddenOpt;
    }
}
