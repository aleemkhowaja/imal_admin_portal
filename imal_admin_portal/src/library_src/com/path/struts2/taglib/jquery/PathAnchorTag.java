package com.path.struts2.taglib.jquery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.views.jsp.ui.AnchorTag;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: DeniskHaddad
 *
 * PathAnchorTag.java used to Overwrite Jquery Standard Anchor Tag
 */
public class PathAnchorTag extends AnchorTag 
{

    public Component getBean(ValueStack stack, HttpServletRequest req,
	    HttpServletResponse res) {
	return new PathAnchor(stack, req, res);
    }
   
}
