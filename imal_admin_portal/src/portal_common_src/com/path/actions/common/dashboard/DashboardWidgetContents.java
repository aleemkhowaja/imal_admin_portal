package com.path.actions.common.dashboard;

import com.path.struts2.lib.common.base.BaseAction;

public class DashboardWidgetContents extends BaseAction
{

    private String widget;
    private String language;
    public String execute()
    {
      language =  getLocale().getLanguage();
	  return widget;
    }

    public String getWidget()
    {
        return widget;
    }

    public void setWidget(String widget)
    {
        this.widget = widget;
    }

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}
}
