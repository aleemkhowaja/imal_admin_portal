/**
 * 
 */
package com.path.actions.common.dynamicscreen;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.dynamicscreen.DynamicScreenBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamicscreen.LinkDynScrTabCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * LinkDynScrTabMaintAction.java used to
 */
public class LinkDynScrTabMaintAction extends BaseAction
{
    private ScreenGeneratorSC criteria        = new ScreenGeneratorSC();
    private LinkDynScrTabCO   linkDynScrTabCO = new LinkDynScrTabCO();
    private DynamicScreenBO   dynamicScreenBO;
    private String actionType = "saveNew";
    private static final String LINK_DYN_SCREEN_TAB = "link_dyn_screen_tab";
    private static final String MAIN_INFORMATION    = "mainInformation";
    
    /**
     * 
     * marwanmaddah
     */
    public String openLinkDynScrTabMgnt()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    criteria.setProgRef(get_pageRef());
	    linkDynScrTabCO.setOBJECT_CODE(criteria.getObjectCode());
	    linkDynScrTabCO.setOBJECT_TYPE(criteria.getObjectType());
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	return LINK_DYN_SCREEN_TAB;
    }
    /**
     * 
     * marwanmaddah
     */
    public String initialize()
    {
	try
	{	    
	    linkDynScrTabCO = new LinkDynScrTabCO();
	    linkDynScrTabCO.setOBJECT_CODE(criteria.getObjectCode());
	    linkDynScrTabCO.setOBJECT_TYPE(criteria.getObjectType());	    
	    setActionType(ConstantsCommon.ACTION_TYPE_SAVE_NEW);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return MAIN_INFORMATION;
    }
    /**
     * 
     * marwanmaddah
     */
    public String edit()
    {
	try{
	    if(!NumberUtil.isEmptyDecimal(criteria.getScreenId()))
	    {
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    criteria.setLangCode(sessionCO.getLanguage());
	    criteria.setProgRef((get_pageRef()==null || get_pageRef().isEmpty())?ConstantsCommon.PROGREF_ROOT:get_pageRef());
	    linkDynScrTabCO = dynamicScreenBO.returnLinkDynScrTabData(criteria);
	    linkDynScrTabCO.setTabDesc(getText(linkDynScrTabCO.getSUB_OBJECT_DESC()));
	    set_recReadOnly(ConstantsCommon.TRUE);
	    setActionType("delete");
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return MAIN_INFORMATION;
    }
    /**
     * link dynamic screen to Tab submit management
     * marwanmaddah
     */
    public String saveNew()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    linkDynScrTabCO.setAPP_NAME(sessionObject.getCurrentAppName());
	    linkDynScrTabCO.setPROG_REF((get_pageRef()==null || get_pageRef().isEmpty())?ConstantsCommon.PROGREF_ROOT:get_pageRef());
	    linkDynScrTabCO.setUSER_ID(sessionObject.getUserName());
	    if(StringUtil.nullToEmpty(linkDynScrTabCO.getSUB_OBJECT_DESC()).isEmpty())
	    {
		linkDynScrTabCO.setSUB_OBJECT_DESC(linkDynScrTabCO.getTabDesc());
	    }
	    dynamicScreenBO.linkDynScrTabSubmitMgnt(linkDynScrTabCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    /**
     * 
     * marwanmaddah
     */
    public String delete()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    linkDynScrTabCO.setAPP_NAME(sessionObject.getCurrentAppName());
	    dynamicScreenBO.linkDynScrTabDeleteMgnt(linkDynScrTabCO);
	    linkDynScrTabCO = new LinkDynScrTabCO();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);  
	}
	return SUCCESS;
    }
    
    public ScreenGeneratorSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(ScreenGeneratorSC criteria)
    {
        this.criteria = criteria;
    }

    public void setDynamicScreenBO(DynamicScreenBO dynamicScreenBO)
    {
        this.dynamicScreenBO = dynamicScreenBO;
    }

    public String getActionType()
    {
        return actionType;
    }
    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }
    public LinkDynScrTabCO getLinkDynScrTabCO()
    {
        return linkDynScrTabCO;
    }
    public void setLinkDynScrTabCO(LinkDynScrTabCO linkDynScrTabCO)
    {
        this.linkDynScrTabCO = linkDynScrTabCO;
    }

}
