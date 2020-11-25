/**
 * 
 */
package com.path.struts2.taglib.tabs;

import java.io.Writer;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgeppert.struts2.jquery.components.TabbedPanel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.dynamicscreen.LinkDynScrTabCO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * PathTabbedPanel.java used to
 */
public class PathTabbedPanel extends TabbedPanel
{
    public static final String PATH_TEMPLATE  = "tabbedpanel";
    public static final String PATH_THEME     = "path-xhtml";
    public static final String TEMPLATE_CLOSE = "tabbedpanel-close";
    final private static String COMPONENT_NAME = PathTabbedPanel.class.getName();
    
    private String tabsOrder;
    private String userPrefLabel;
    private String additionalTabsStr;
    
    private String onAddTopics;
    private String onRemoveTopics;
    private String animate;
    private String spinner;
    public PathTabbedPanel(ValueStack stack, HttpServletRequest request, HttpServletResponse response) 
    {
	    super(stack, request, response); 
    }
    @Override
    public boolean start(Writer arg0)
    {
	//the additional code should exists before calling super.start()	
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	if("true".equals(sortable))
	{
	    tabsOrder = baseAction.returnObjectColumnsOrder(id,ConstantsCommon.PREF_OBJECT_TYPE_TAB);
	    addParameter("tabsOrder",tabsOrder);
	}
	/**
	 * [MarwanMaddah]: get the additional tabs list, 
	 * transfer the list to a JSON String format and parse it to JavaScript TabbedPanel object. 
	 */
	List<LinkDynScrTabCO> additionalTabsLst = baseAction.returnAdditionalObjElements(id, ConstantsCommon.PREF_OBJECT_TYPE_TAB);
	if(!additionalTabsLst.isEmpty())
	{
	    /*tp 985986 Customization Reflection on Custom Added Tabs to Tabbed Pannel*/
	    additionalTabsStr = additionalTabsLst.stream().map(ldSTabCo -> {
		JSONObject ldSTabCoJSON = new JSONObject();
		String tabNameInDB = "newTabId_" + ldSTabCo.getSUB_OBJECT_ID() + "_" + ldSTabCo.getDYN_SCREEN_ID();
		
		ldSTabCoJSON.put("id", tabNameInDB+"_"+baseAction.get_pageRef());
		ldSTabCoJSON.put("SUB_OBJECT_DESC", ldSTabCo.getSUB_OBJECT_DESC());
		ldSTabCoJSON.put("SUB_OBJECT_ID", ldSTabCo.getSUB_OBJECT_ID());
		
		SYS_PARAM_SCREEN_DISPLAYVO sysPSDVO = RootUtil.returnParamScreenDisplay(request, tabNameInDB, null,
			RootUtil.TAB_ELEM_TYPE);
		if(sysPSDVO != null)
		{
		    BigDecimal isReadOnly = sysPSDVO.getIS_READONLY();
		    if(isReadOnly != null)
		    {
			boolean disabled = (BigDecimal.ONE.equals(isReadOnly)) ? true : false;
			ldSTabCoJSON.put("disabled", disabled);
		    }

		    BigDecimal isVisible = sysPSDVO.getIS_VISIBLE();
		    if(BigDecimal.ZERO.equals(isVisible))
		    {
			ldSTabCoJSON.put("isVisible", ConstantsCommon.ZERO);
			ldSTabCoJSON.put("cssStyle","display:none");
		    }
		}
		return ldSTabCoJSON;
	    }).collect(JSONArray::new, (jsonArr, jsonOb) -> jsonArr.add(jsonOb), (jsonArr1, jsonArr2) ->{}).toString();
	    
	    addParameter("additionalTabsStr",additionalTabsStr);
	}
	userPrefLabel = baseAction.getText("reset_user_pref_key");

	//escape id from special characters that might be used for security intrusion
	id =  RootUtil.escapeJS(id);
    
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
     * @return the componentName
     */
    @Override
    public String getComponentName()
    {
        return COMPONENT_NAME;
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
    public String getOnAddTopics()
    {
        return onAddTopics;
    }
    public void setOnAddTopics(String onAddTopics)
    {
        this.onAddTopics = onAddTopics;
    }
    public String getOnRemoveTopics()
    {
        return onRemoveTopics;
    }
    public void setOnRemoveTopics(String onRemoveTopics)
    {
        this.onRemoveTopics = onRemoveTopics;
    }
    public String getAnimate()
    {
        return animate;
    }
    public void setAnimate(String animate)
    {
        this.animate = animate;
    }
    public String getSpinner()
    {
        return spinner;
    }
    public void setSpinner(String spinner)
    {
        this.spinner = spinner;
    }

}
