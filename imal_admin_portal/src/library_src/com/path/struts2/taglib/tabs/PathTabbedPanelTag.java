/**
 * 
 */
package com.path.struts2.taglib.tabs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * PathTabbedPanelTag.java used to
 */
public class PathTabbedPanelTag extends AbstractUITag
{
    protected String selectedTab;
    protected String useSelectedTabCookie;
    protected String openOnMouseover;
    protected String collapsible;
    protected String animate;
    protected String spinner;
    protected String cache;
    protected String disabledTabs;
    protected String sortable;

    protected String onAddTopics;
    protected String onRemoveTopics;
    
    private String tabsOrder;
    private String userPrefLabel;
    private String additionalTabsStr;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
      return new PathTabbedPanel(stack, req, res);
    }

    @Override
    protected void populateParams()
    {
      super.populateParams();
      PathTabbedPanel tabbedPanel = (PathTabbedPanel) component;
      tabbedPanel.setSelectedTab(selectedTab);
      tabbedPanel.setUseSelectedTabCookie(useSelectedTabCookie);
      tabbedPanel.setAnimate(animate);
      tabbedPanel.setCollapsible(collapsible);
      tabbedPanel.setOpenOnMouseover(openOnMouseover);
      tabbedPanel.setSpinner(spinner);
      tabbedPanel.setCache(cache);
      tabbedPanel.setDisabledTabs(disabledTabs);
      tabbedPanel.setSortable(sortable);
      tabbedPanel.setTabsOrder(tabsOrder);
      tabbedPanel.setOnAddTopics(onAddTopics);
      tabbedPanel.setOnRemoveTopics(onRemoveTopics);
      tabbedPanel.setUserPrefLabel(userPrefLabel);
      tabbedPanel.setAdditionalTabsStr(additionalTabsStr);
    }

    public void setSelectedTab(String selectedTab)
    {
      this.selectedTab = selectedTab;
    }

    public void setUseSelectedTabCookie(String useSelectedTabCookie)
    {
      this.useSelectedTabCookie = useSelectedTabCookie;
    }

    public void setOpenOnMouseover(String openOnMouseover)
    {
      this.openOnMouseover = openOnMouseover;
    }

    public void setCollapsible(String collapsible)
    {
      this.collapsible = collapsible;
    }

    public void setAnimate(String animate)
    {
      this.animate = animate;
    }

    public void setSpinner(String spinner)
    {
      this.spinner = spinner;
    }

    public void setCache(String cache)
    {
      this.cache = cache;
    }

    public void setDisabledTabs(String disabledTabs)
    {
      this.disabledTabs = disabledTabs;
    }

    public void setOnAddTopics(String onAddTopics)
    {
      this.onAddTopics = onAddTopics;
    }

    public void setOnRemoveTopics(String onRemoveTopics)
    {
      this.onRemoveTopics = onRemoveTopics;
    }

    public void setSortable(String sortable)
    {
      this.sortable = sortable;
    }

    /**
     * @return the tabsOrder
     */
    public String getTabsOrder()
    {
        return tabsOrder;
    }

    /**
     * @param tabsOrder the tabsOrder to set
     */
    public void setTabsOrder(String tabsOrder)
    {
        this.tabsOrder = tabsOrder;
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

    public String getAdditionalTabsStr()
    {
        return additionalTabsStr;
    }

    public void setAdditionalTabsStr(String additionalTabsStr)
    {
        this.additionalTabsStr = additionalTabsStr;
    }

}
