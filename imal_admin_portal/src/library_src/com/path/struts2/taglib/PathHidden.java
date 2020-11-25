package com.path.struts2.taglib;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Hidden;

import com.opensymphony.xwork2.util.ValueStack;
import com.path.lib.common.util.DateUtil;
import com.path.struts2.lib.common.RootUtil;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: DeniskHaddad
 *
 * PathHidden.java used to overwrite Hidden input object.
 */
public class PathHidden extends Hidden {

    public PathHidden(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }
    protected void evaluateExtraParams()
    {
	super.evaluateExtraParams();
	if(name != null)
	{
        	Object valueObj = stack.findValue(name);
        	// if the hidden is of Date Type
        	if(valueObj != null && (valueObj instanceof Date))
        	{
        	   String dateFormat = DateUtil.returnDateFormat(RootUtil.returnNumberFormat(request.getSession())) ; 
        	   // taking date part from user format and adding Time to it
        	   dateFormat = dateFormat.split(" ")[0] + " HH:mm:ss:SSS";
        	   
        	   String formatedUsrDate = DateUtil.format((Date)valueObj, dateFormat);
        	   parameters.put("nameValue", formatedUsrDate);
        	}
	}
    }
    
}
