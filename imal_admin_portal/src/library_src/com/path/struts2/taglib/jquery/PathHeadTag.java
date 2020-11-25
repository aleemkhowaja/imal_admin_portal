package com.path.struts2.taglib.jquery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.views.jsp.ui.HeadTag;
import com.opensymphony.xwork2.util.ValueStack;

public class PathHeadTag extends HeadTag
{
    private String appversion;
    
    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
	return new PathHead(stack, req, res);
    }
    
    @Override
    protected void populateParams()
    {
	// TODO Auto-generated method stub
	super.populateParams();
	PathHead pathHead = (PathHead)component;
	pathHead.setAppversion(appversion);
    }

    /**
     * @return the appversion
     */
    public String getAppversion()
    {
        return appversion;
    }

    /**
     * @param appversion the appversion to set
     */
    public void setAppversion(String appversion)
    {
        this.appversion = appversion;
    }
    
    
}
