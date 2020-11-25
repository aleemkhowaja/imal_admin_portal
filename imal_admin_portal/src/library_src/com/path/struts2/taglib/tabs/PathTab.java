
package com.path.struts2.taglib.tabs;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.jgeppert.struts2.jquery.components.Tab;
import com.jgeppert.struts2.jquery.components.TabbedPanel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;

/**
 * 
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * PathTab.java used to
 */
public class PathTab extends Tab {

  public static final String TEMPLATE       = "tab";
  public static final String PATH_THEME     = "path-xhtml";
  public static final String TEMPLATE_CLOSE = "tab-close";
  public static final String COMPONENT_NAME = PathTab.class.getName();

  private String labelKey;
  
  public PathTab(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  @Override
public String getDefaultOpenTemplate()
  {
    return TEMPLATE;
  }

  @Override
protected String getDefaultTemplate()
  {
    return TEMPLATE_CLOSE;
  }

  @Override
  public boolean start(Writer arg0)
  {
      //the additional code should exists before calling super.start()
      TabbedPanel parentTabbedPanel = (TabbedPanel) findAncestor(TabbedPanel.class);
      if (parentTabbedPanel != null)
      {
        addParameter("parentTabbedPanel", findString(parentTabbedPanel.getId()));
      }

      if(target != null){
  	addParameter("target", findString(target));
      }
      if(closable != null){
  	addParameter("closable", findValue(closable, Boolean.class));
      }
      if(disabled!=null){
  	addParameter("disabled", findString(disabled));
      }
      if(key!=null){
  	addParameter("labelKey",findString(key));
      }
	SYS_PARAM_SCREEN_DISPLAYVO theVO = RootUtil.returnParamScreenDisplay(request, id, id,RootUtil.TAB_ELEM_TYPE);
	if(theVO != null)
	{
	    if(theVO.getIS_READONLY() != null)
	    {
		    if(theVO.getIS_READONLY().intValue() == 1)
		    {
			disabled = "true";
		    }
		    else
		    {
			disabled = "false";
		    }
		    addParameter("disabled", findValue(disabled, Boolean.class));
	    }
	    if(theVO.getIS_VISIBLE() != null && theVO.getIS_VISIBLE().intValue() == 0)
	    {
		if(cssStyle == null || cssStyle.isEmpty())
		{
		    cssStyle = "";
		}
		else
		{
		    cssStyle += ";";
		}
		cssStyle += "display:none";
		addParameter("isVisible", ConstantsCommon.ZERO);
		addParameter("cssStyle", findString(cssStyle));
	    }
	    if(!StringUtil.nullToEmpty(theVO.getLABEL_KEY()).isEmpty())
	    {
		BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
		label =  baseAction.getText(theVO.getLABEL_KEY());
		addParameter("label", findString(label));
		addParameter("labelKey", findString(theVO.getLABEL_KEY()));
	    }	    	    
	}

      //the super.start() should be called at the end of the method
      return super.start(arg0);
  }


  @Override
  @StrutsTagSkipInheritance
  public void setTheme(String theme)
  {
    super.setTheme(theme);
  }

  @Override
  public String getTheme()
  {
    return PATH_THEME;
  }
/**
 * @return the labelKey
 */
public String getLabelKey()
{
    return labelKey;
}

/**
 * @param labelKey the labelKey to set
 */
public void setLabelKey(String labelKey)
{
    this.labelKey = labelKey;
}

}
