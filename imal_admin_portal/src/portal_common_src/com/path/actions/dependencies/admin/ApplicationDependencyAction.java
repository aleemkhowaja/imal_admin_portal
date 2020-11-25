package com.path.actions.dependencies.admin;

import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;

/**
 * 
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: deniskhaddad
 * 
 *          ApplicationDependencyAction.java used to manage Dependencies of
 *          Application
 */
public class ApplicationDependencyAction extends BaseAction
{
    private S_APPVO appVO = new S_APPVO();
    private OPTVO optVO = new OPTVO();
    private String webAppsOnly;

    /**
     * dependency by Application Name
     * 
     * @return
     */
    public String applicationDepend()
    {
	try
	{
	    String appName = appVO.getAPP_NAME();
	    if(StringUtil.nullToEmpty(appName).isEmpty())
	    {
		appVO = new S_APPVO();
	    }
	    else
	    {
		S_APPVO applic = returnCommonLibBO().returnApplication(appVO);
		// check if application available and if it is relates to WEb if webAppsOnly falg recieved
		if(applic == null || (webAppsOnly != null
					&& !ConstantsCommon.APP_IS_WEB_AND_PB.equals(applic.getIS_WEB_YN())
					    && !ConstantsCommon.APP_IS_WEB_ONLY.equals(applic.getIS_WEB_YN() )
				    ))
		{
		    appVO = new S_APPVO();
		}
		else
		{
		    String language = returnSessionObject().getLanguage();
		    appVO.setAPP_DESC(applic.getAPP_DESC());
		    if(ConstantsCommon.LANGUAGE_ARABIC.equals(language))
		    {
			appVO.setAPP_DESC(applic.getAPP_DESC_AR());
		    }
		    else if(ConstantsCommon.LANGUAGE_FRENCH.equals(language))
		    {
			appVO.setAPP_DESC(applic.getAPP_DESC_FR());
		    }
		    optVO = new OPTVO();
		}
	    }
	}
	catch(Exception e)
	{
	    appVO = new S_APPVO();
	    optVO = new OPTVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public S_APPVO getAppVO()
    {
	return appVO;
    }

    public void setAppVO(S_APPVO appVO)
    {
	this.appVO = appVO;
    }

    public OPTVO getOptVO()
    {
        return optVO;
    }

    public void setWebAppsOnly(String webAppsOnly)
    {
        this.webAppsOnly = webAppsOnly;
    }
}
