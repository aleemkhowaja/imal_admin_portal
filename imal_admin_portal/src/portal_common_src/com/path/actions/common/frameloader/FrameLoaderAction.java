/**
 * 
 */
package com.path.actions.common.frameloader;

import com.path.actions.common.login.DesktopAction;
import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.exception.BaseException;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * FrameLoaderAction.java used to
 */
@SuppressWarnings("serial")
public class FrameLoaderAction extends DesktopAction
{
    private String screenUrl;
    private String screenParams;
    
    public String loadFrame()
    {
	return SUCCESS;
    }
    
    public String loadFrameContent() throws BaseException
    {
	if(appName == null)
	{
	    appName = returnSessionObject().getCurrentAppName();
	}
	if(ConstantsCommon.TFA_APP_NAME.equals(appName))
	{
	    themeName = TFA_THEME;
	}
	else if(ConstantsCommon.REP_APP_NAME.equals(appName))
	{
	    themeName = REPORTING_THEME;
	}
	else
	{
	    themeName = CORE_THEME;
	}
	applyDirection();
	return SUCCESS;
    }

    public String getScreenUrl()
    {
        return screenUrl;
    }

    public void setScreenUrl(String screenUrl)
    {
        this.screenUrl = screenUrl;
    }

    public String getScreenParams()
    {
        return screenParams;
    }

    public void setScreenParams(String screenParams)
    {
        this.screenParams = screenParams;
    }
    
    
}
