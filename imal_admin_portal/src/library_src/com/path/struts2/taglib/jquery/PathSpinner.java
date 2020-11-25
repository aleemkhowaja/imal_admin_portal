/*
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

package com.path.struts2.taglib.jquery;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgeppert.struts2.jquery.components.Spinner;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;

public class PathSpinner extends Spinner {

    private String overrideLabelText;
    private String overrideLabelKey;
    
    private String required;
    
  public PathSpinner(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

    @Override
    public boolean start(Writer arg0)
    {
	    //the additional code should exists before calling super.start()
	    
	    if(readonly != null) //setting disabled parameter as readonly since JS manipulation is based on disabled attribute
	    {
		disabled = readonly;
		addParameter("disabled", findValue(disabled, Boolean.class));
	    }
	    
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
			BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
			overrideLabelText =  baseAction.getText(theVO.getLABEL_KEY());
			addParameter("overrideLabelText", findString(overrideLabelText));
			// LABEL_KEY is coming already translated in case of additionalScreensParams upon load of screen
			overrideLabelKey = theVO.getLabelKeyVal() != null ? theVO.getLabelKeyVal() : theVO.getLABEL_KEY();
			addParameter("overrideLabelKey", findString(overrideLabelKey));
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