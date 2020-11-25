package com.path.struts2.taglib.toolbar;

import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.dbmaps.vo.SYS_PARAM_BTN_CUSTVO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;

public class ToolBar extends ClosingUIBean// Component
{
	
	public static final String OPEN_TEMPLATE = "path-toolbar";
	public static final String PATH_TEMPLATE = "path-toolbar-close";
	public static final String PATH_THEME = "path-xhtml";

	private String id;
	private String width;
	private String hideInAlert;
	
	public ToolBar(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
		
		
	}
	
	@Override
	public boolean start(Writer arg0)
        {
	    
	     BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	     String pageRef = baseAction.get_pageRef();
	     //Check if custom button exists on the current pageRef
	     if(StringUtil.isNotEmpty(pageRef))
	     {
		 addParameter("pageRef", pageRef);
		 //get the list of custom buttons
		 List<SYS_PARAM_BTN_CUSTVO> customButtonList = RootUtil.returnToolBarButtonCust(request,pageRef, id);
		 if(customButtonList != null && !customButtonList.isEmpty())
		 {
		     addParameter("customButtonList", customButtonList);
		 }
	     }
	     
    	     // the super.start() should be called at the end of the method
    	     return super.start(arg0);
        }

	@Override
	public void setTheme(String theme) {
		super.setTheme(PATH_THEME);
	
	}

	@Override
	protected String getDefaultTemplate() {
		return PATH_TEMPLATE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getDefaultOpenTemplate() {
		return OPEN_TEMPLATE;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getWidth() {
		return width;
	}

	public String getHideInAlert()
	{
	    return hideInAlert;
	}

	public void setHideInAlert(String hideInAlert)
	{
	    this.hideInAlert = hideInAlert;
	}
	
}
