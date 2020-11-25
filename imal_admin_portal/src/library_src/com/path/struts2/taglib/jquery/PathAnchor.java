package com.path.struts2.taglib.jquery;

import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgeppert.struts2.jquery.components.Anchor;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.struts2.lib.common.RootUtil;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: DeniskHaddad
 * 
 *          PathAnchor.java used to Overwrite Anchor Jquery Standard Component
 */
public class PathAnchor extends Anchor
{

    public PathAnchor(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    @Override
    public boolean start(Writer arg0)
    {
    	//the additional code should exists before calling super.start()	
	// reading id and name before evaluateExtraPArams which set default id
	String theId = id, theName = name;
	if(id != null )
	{
	    String regEx = ".*[%!@#$%^&*(){}<>=\\[\\]/\\\\\'\"].*";
	    Pattern p = Pattern.compile(regEx);
	    Matcher m = p.matcher(id);
	    if(m.matches())
	    {
		addParameter("specialChars", "true");
	    }
	}
	
	// manipulating dynamic display for anchor tag only show hide is
	// possible
	SYS_PARAM_SCREEN_DISPLAYVO theVO = null;
	if(theId == null)
	{
	    if(theName != null)
	    {
		theVO = RootUtil.returnParamScreenDisplay(request, name, id, RootUtil.ANCHOR_ELEM_TYPE);
	    }

	}
	else
	{
	    theVO = RootUtil.returnParamScreenDisplay(request, id, id, RootUtil.ANCHOR_ELEM_TYPE);
	}
	if(theVO != null && theVO.getIS_VISIBLE() != null && theVO.getIS_VISIBLE().intValue() == 0)
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
    
	//escape id from special characters that might be used for security intrusion
	id =  RootUtil.escapeJS(id);
	
	//the super.start() should be called at the end of the method
    	return super.start(arg0);
    }
}
