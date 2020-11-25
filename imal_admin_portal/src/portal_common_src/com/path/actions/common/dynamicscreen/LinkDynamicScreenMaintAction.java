/**
 * 
 */
package com.path.actions.common.dynamicscreen;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.dynamicscreen.DynamicScreenBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamicscreen.LinkDynamicScreenCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * LinkDynamicScreenMaintAction.java used to
 */
public class LinkDynamicScreenMaintAction extends BaseAction
{
    private ScreenGeneratorSC   criteria = new ScreenGeneratorSC();
    private LinkDynamicScreenCO linkDynamicScreenCO = new LinkDynamicScreenCO();
    private DynamicScreenBO     dynamicScreenBO;
    private String actionType = "saveNew";
    private static final String LINK_DYN_SCREEN = "link_dyn_screen";
    private static final String MAIN_INFORMATION = "mainInformation";
    
    /**
     * 
     * marwanmaddah
     */
    public String openLinkDynScreenMgnt()
    {
	CommonLibSC criteria = new CommonLibSC();
	try
	{
	    String openLinkDynAccessRight = returnAccessRightByProgRef(ConstantsCommon.SAVE_AS_OPT);
	    if(openLinkDynAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }

	    SessionCO sessionObject = returnSessionObject();
	    String appName = sessionObject.getCurrentAppName();
	    String theProgRef = get_pageRef();
	    
	    criteria.setAppName(appName);
	    criteria.setProgRef(theProgRef);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	return LINK_DYN_SCREEN;
    }
    /**
     * 
     * marwanmaddah
     */
    public String initialize()
    {
	try
	{	    
	    linkDynamicScreenCO = new LinkDynamicScreenCO();
	    setActionType(ConstantsCommon.ACTION_TYPE_SAVE_NEW);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return MAIN_INFORMATION;
    }
    public String edit()
    {
	try{
	    if(!NumberUtil.isEmptyDecimal(criteria.getScreenId()))
	    {
		SessionCO sessionCO = returnSessionObject();
		criteria.setCurrAppName(sessionCO.getCurrentAppName());
		criteria.setLangCode(sessionCO.getLanguage());
		linkDynamicScreenCO = dynamicScreenBO.returnLinkDynScreenData(criteria);
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
     * link dynamic screen submit management
     * marwanmaddah
     */
    public String saveNew()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    linkDynamicScreenCO.setAPP_NAME(sessionObject.getCurrentAppName());
	    linkDynamicScreenCO.setUserId(sessionObject.getUserName());
	    linkDynamicScreenCO.setCompanyCode(sessionObject.getCompanyCode());
	    linkDynamicScreenCO.setBranchCode(sessionObject.getBranchCode());
	    if(StringUtil.nullToEmpty(linkDynamicScreenCO.getParentRef()).isEmpty())
	    {
		linkDynamicScreenCO.setParentRef(ConstantsCommon.PROGREF_ROOT);
	    }
	    dynamicScreenBO.linkDynScreenSubmitMgnt(linkDynamicScreenCO);
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
	    linkDynamicScreenCO.setAPP_NAME(sessionObject.getCurrentAppName());
	    linkDynamicScreenCO.setUserId(sessionObject.getUserName());
	    linkDynamicScreenCO.setCompanyCode(sessionObject.getCompanyCode());
	    linkDynamicScreenCO.setBranchCode(sessionObject.getBranchCode());
	    dynamicScreenBO.linkDynScreenDeleteMgnt(linkDynamicScreenCO);
	    
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

    public LinkDynamicScreenCO getLinkDynamicScreenCO()
    {
        return linkDynamicScreenCO;
    }

    public void setLinkDynamicScreenCO(LinkDynamicScreenCO linkDynamicScreenCO)
    {
        this.linkDynamicScreenCO = linkDynamicScreenCO;
    }
    public String getActionType()
    {
        return actionType;
    }
    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }
    
}
