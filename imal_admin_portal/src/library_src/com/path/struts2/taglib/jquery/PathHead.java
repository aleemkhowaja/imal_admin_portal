package com.path.struts2.taglib.jquery;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgeppert.struts2.jquery.components.Head;
import com.opensymphony.xwork2.util.ValueStack;

public class PathHead extends Head
{
    private String appversion;
    
    public PathHead(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }
    
    
    
    @Override
    public boolean start(Writer arg0)
    {

	// TODO Auto-generated constructor stub
	addParameter("appversion", findValue(appversion, String.class));
		
	//the super.start() should be called at the end of the method
	return super.start(arg0);
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
