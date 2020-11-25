package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

public class PathPageTag extends AbstractUITag
{

    private String ref;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	return new PathPage(stack, request, response);
    }

    public void setRef(String ref)
    {
	this.ref = ref;
    }

    public String getRef()
    {
	return ref;
    }

    @Override
    protected void populateParams()
    {
	super.populateParams();
	((PathPage) component).setRef(ref);
    }

}
