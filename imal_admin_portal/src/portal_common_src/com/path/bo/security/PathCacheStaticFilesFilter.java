package com.path.bo.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.path.lib.common.util.StringUtil;

/**
 * This Filter is needed when the Encryption Filter is disabled for Stress Testing, So once the web.xml updated to remove Encryption filter , need to be replaced by this filter
 * Copyright 2019, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: DeniskHaddad
 *
 * PathCachStaticFielsFilter.java used to
 */
public class PathCacheStaticFilesFilter implements Filter
{

    @Override
    public void destroy()
    {
	// TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException
    {
	if(request instanceof HttpServletRequest && response instanceof HttpServletResponse)
	{
	    HttpServletRequest httprequest = (HttpServletRequest) request;

	    String requestURI = httprequest.getRequestURI();
	    if(requestURI != null)
	    {
		requestURI = requestURI.toUpperCase();
	    }
	    if(requestURI.contains("?"))
	    {
		requestURI = requestURI.substring(0, requestURI.indexOf("?"));
	    }
	    if((requestURI.endsWith(".JS") && StringUtil.isNotEmpty(httprequest.getParameter("_")))
		    || requestURI.endsWith(".CSS") || requestURI.endsWith(".PNG") || requestURI.endsWith(".SVG")
		    || requestURI.endsWith(".GIF") || requestURI.endsWith(".JPG") || requestURI.endsWith(".JPEG"))
	    {
		response = new PathUrlParamWrapperResponse((HttpServletResponse) response);
	    }

	    chain.doFilter(request, response);
	}
    }
    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
	// nothing to apply just not to make the build fail
    }
}
