/*
 * $Id: Password.java 651946 2008-04-27 13:41:38Z apetrelli $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.path.struts2.taglib;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Password;

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
 * Copyright 2018, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: DeniskHaddad
 *
 * PathPassword.java used to Overwrite the struts 2 password, in order to be able to include required attribute, 
 * so that not to change the tags for struts upgrade 2.3.34
 */
public class PathPassword extends Password {

    protected String required;;

    public PathPassword(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }


    public void evaluateExtraParams() {
	
	//Struts 2.5 upgrade - in new Struts 2.5 the showPassword is defaulted to NULL, we need to default it to TRUE to behave similary as old Struts 2.3 and then to call the evaluateExtraParams() to take effect. 
	if(showPassword == null)
	{
	    showPassword = ConstantsCommon.TRUE;
	}
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
	    
	    // control on Max Length Field if Exists
	    if(theVO.getMAX_LENGTH() != null && theVO.getMAX_LENGTH().intValue() > 0)
	    {
		maxlength = theVO.getMAX_LENGTH().toString();
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
	if(maxlength != null && !maxlength.trim().isEmpty())
	{
	    addParameter("maxlength", findString(maxlength));
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
		}
	    }
	    catch(BaseException e)
	    {
		// TODO Auto-generated catch block
		Log.getInstance().error(e, "Error in Dynamic Expresssion process");
	    } 
	}

        if (!StringUtil.nullToEmpty(required).isEmpty()) {
            addParameter("required", findValue(required, Boolean.class));
        }
    }


    public String getRequired()
    {
        return required;
    }

    public void setRequired(String required)
    {
        this.required = required;
    }
}
