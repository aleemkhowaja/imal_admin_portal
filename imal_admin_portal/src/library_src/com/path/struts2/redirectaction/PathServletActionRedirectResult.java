package com.path.struts2.redirectaction;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.result.ServletActionRedirectResult;

import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;

/**
 * 
 * Copyright 2017, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * PathServletActionRedirectResult.java used to
 */
public class PathServletActionRedirectResult extends ServletActionRedirectResult
{
    private static Log log = Log.getInstance();
    
    @Override
    protected void sendRedirect(HttpServletResponse response, String finalLocation) throws IOException
    {
	if(ConstantsCommon.SECURITY_ENCRYPTPARAMS_ENABLED && StringUtil.isNotEmpty(finalLocation) && finalLocation.indexOf("PATHPARAM") == -1)
	{
	    try
	    {
		HttpSession session = ServletActionContext.getRequest().getSession();
		log.debug("[PathServletActionRedirectResult] finalLocation before encryption is : " + finalLocation);
		finalLocation = SecurityUtils.returnEncryptedNoPaddingUrl(finalLocation, true, session);
		log.debug("[PathServletActionRedirectResult] finalLocation after encryption is : " + finalLocation);
	    }
	    catch(Exception e)
	    {
		e.printStackTrace();
		log.error(e,"[PathServletActionRedirectResult] error in the encryption of the finalLocation");
	    }
	}
	super.sendRedirect(response, finalLocation);
    }
}
