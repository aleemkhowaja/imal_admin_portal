/**
 * 
 */
package com.path.struts2.taglib.collapsible;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.struts2.taglib.PathDiv;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Rabih El Khatib
 *
 * PathCollapsGroup.java used to
 */
public class PathCollapsGroup extends PathDiv
{
    public static final String TEMPLATE  = "collapsgroup";
    public static final String PATH_THEME     = "path-xhtml";
    public static final String TEMPLATE_CLOSE = "collapsgroup-close";
    
    private String userPrefLabel;
    public PathCollapsGroup(ValueStack stack, HttpServletRequest request, HttpServletResponse response) 
    {
	    super(stack, request, response);
    }
    @Override
    public boolean start(Writer arg0)
    {
	//the additional code should exists before calling super.start()	
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
//	if("true".equals(sortable))
//	{
//	    tabsOrder = baseAction.returnObjectColumnsOrder(id,ConstantsCommon.PREF_OBJECT_TYPE_TAB);
//	    addParameter("tabsOrder",tabsOrder);
//	}
	userPrefLabel = baseAction.getText("reset_user_pref_key");

    
	//the super.start() should be called at the end of the method
	return super.start(arg0);
    }
    @Override
    public String getTheme()
    {
	return PATH_THEME;
    }
    
    @Override
    public String getDefaultOpenTemplate()
    {
      return TEMPLATE;
    }
    /**
     * Get the path template
     */
    @Override
    protected String getDefaultTemplate()
    {
	return TEMPLATE_CLOSE;
    }

    /**
     * @return the userPrefLabel
     */
    public String getUserPrefLabel()
    {
        return userPrefLabel;
    }
    /**
     * @param userPrefLabel the userPrefLabel to set
     */
    public void setUserPrefLabel(String userPrefLabel)
    {
        this.userPrefLabel = userPrefLabel;
    }

}
