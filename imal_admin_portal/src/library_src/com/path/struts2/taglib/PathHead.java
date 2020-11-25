package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Head;

import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;

public class PathHead extends Head
{
	public static final String PATH_TEMPLATE = "path-head";
	public static final String PATH_THEME = "path-xhtml";

	private String decoratorName;
	public PathHead(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
	{
		super(stack, request, response);
	}
	
	@Override
	public void setTheme(String theme)
	{
	  super.setTheme(PATH_THEME);
	}
	@Override
	protected String getDefaultTemplate()
	{
	  return PATH_TEMPLATE;
	}

	public String getDecoratorName()
	{
	    return decoratorName;
	}

	public void setDecoratorName(String decoratorName)
	{
	    this.decoratorName = decoratorName;
	}

	@Override
	public void evaluateParams()
	{
	    // TODO Auto-generated method stub
	    super.evaluateParams();
	    if(decoratorName != null)
	    {
		addParameter("decoratorName", findString(decoratorName));
	    }
	    addParameter("SECURITY_ENCRYPTPARAMS_ENABLED", findString(Boolean.valueOf(ConstantsCommon.SECURITY_ENCRYPTPARAMS_ENABLED).toString()));
	    addParameter("UNIQUE_SESSION_TOKEN", findString(CommonMethods.returnUniqueSessionToken(request.getSession())));
	    addParameter("ENCRYPTION_PWD", findString(CommonMethods.returnEncryptionPassword(request.getSession())));
	    addParameter("BLOCK_F12", findString(CommonMethods.returnF12BlockingEnabled()));
	    addParameter("appversion", findString(ConstantsCommon.returnAppNumericVersion()));
	}
	

}
