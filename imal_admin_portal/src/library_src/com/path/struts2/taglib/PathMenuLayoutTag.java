package com.path.struts2.taglib;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

public class PathMenuLayoutTag extends AbstractUITag
{
    protected ArrayList list;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
	return new PathMenuLayout(stack, req, res);
    }

    protected void populateParams()
    {
	super.populateParams();

	((PathMenuLayout) component).setList(list);
	((PathMenuLayout) component).setId(id);
    }

    public void setList(ArrayList list)
    {
        this.list = list;
    }
    
}
