package com.path.bo.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.path.lib.log.Log;

/**
 * 
 * Copyright 2010, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Denisk Haddad
 * 
 *PathLogoutFilterHandler.java used to extend spring security
 *implementation of Logout process
 */
public class PathLogoutFilterHandler extends SecurityContextLogoutHandler
{
    protected final static Log log = Log.getInstance();
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication auth)
    {
//	log.error("[PATH-INFO] PathLogoutFilterHandler logout method");
	// flag to speciy whether manula logout performed
	/*if(auth != null)
	{
	    log.error("[PATH-INFO] PathLogoutFilterHandler before setting attribute  manual_log_out principal :  "+auth.getPrincipal());
	}*/
	request.getSession().setAttribute("manual_log_out", "1");
	super.logout(request, response, auth);
    }
}
