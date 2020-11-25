/**
 * 
 */
package com.path.bo.security;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.session.SessionManagementFilter;

import com.path.bo.common.CommonMethods;
import com.path.lib.log.Log;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * PathSessionManagementFilter.java used to
 */
public class PathSessionManagementFilter extends SessionManagementFilter
{
    private static final String FILTER_APPLIED = "__spring_security_session_mgmt_filter_applied";
    private final SecurityContextRepository securityContextRepository;
    public PathSessionManagementFilter(SecurityContextRepository securityContextRepository)
    {
	super(securityContextRepository);
	this.securityContextRepository = securityContextRepository;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
	    ServletException
    {
	HttpServletRequest request = (HttpServletRequest) req;
	
	Log.getInstance().debug("IN PathSessionManagementFilter j_userName "+request.getParameter("j_username")+" URI "+request.getRequestURI());
	/*check if the request is coming from CommonScreenFrameLoader.jsp or from ExternalAppFrameLoader.jsp*/
	if( (request.getParameter("j_username") != null && request.getParameter("j_password") != null &&
		(
		   (request.getParameter("externalScreen") != null && request.getParameter("extAppName") != null) 
		|| (request.getParameter("destinationScreenUrl") != null && request.getParameter("destinationProgRef") != null)
		// only for websphere appId to be checked Coming from DashboardPortal.js (Workspace item, favorite, or application opening)
		// TP 500032 Websphere automatic login Issue
		// Same occurred  later on Weblogic server when opening reporting server on same server different Port (for Weblogic not need to include checking in DashboardPortal.js)
		|| (
		     (request.getParameter("appId") != null || request.getParameter("favoriteId") != null  || request.getParameter("menuVar") != null )
		     && Arrays.asList(new String[]{"WAS","WLS"}).contains(CommonMethods.returnServerType().toUpperCase()))
		)
	
	    /*check if the filter has not been applied on this request*/
	    && (request.getAttribute(FILTER_APPLIED) == null)
	    
		&& (!securityContextRepository.containsContext(request))
		
		    /*check if the session is invalid : isRequestedSessionIdValid = false*/
		    && (!request.isRequestedSessionIdValid()) 
		)    
		 // Issue at BMO in reporting BMOUPI170247 not able to load the image in report on Websphere for first time due to session filter redirecting to timeout page
		// applied to all servers since the image url should not be secure
		|| request.getRequestURI().equals(request.getContextPath()+"/servlets/image"))
	{
	    Log.getInstance().debug("IN PathSessionManagementFilter j_userName exists and called from external screen or /servlets/image is called"); 
	    //set the attribute FILTER_APPLIED to true to mark that the request has passed this filter
	    request.setAttribute(FILTER_APPLIED, Boolean.TRUE);
	    //no need to clear the JSESSIONID cookies because a new JSESSIONID will be created in the response header
	    //continue with next filters
	    HttpServletResponse response = (HttpServletResponse) res;
	    chain.doFilter(request, response);
	    return;
	}

	// Call the parent filter
	super.doFilter(req, res, chain);
    }
    
}
