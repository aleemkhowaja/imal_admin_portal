package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.PasswordTag;

import com.opensymphony.xwork2.util.ValueStack;


/**
 * 
 * Copyright 2018, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: DeniskHaddad
 *
 * PathPasswordTag.java used to overwrite the default Password Tag basically to include the required attribute 
 * that is omitted in struts upgrade 2.3.34 
 */
public class PathPasswordTag extends PasswordTag {

    protected String required;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new PathPassword(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();
        PathPassword password = ((PathPassword) component);
        password.setRequired(required);
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
