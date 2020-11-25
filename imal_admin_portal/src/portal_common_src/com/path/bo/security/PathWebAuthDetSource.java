package com.path.bo.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * class to initialize a WebAuthenticationDetails object that holds additional request parameters (other than j_username, j_password)
 * @author PatriciaNasrallah
 *
 */
public class PathWebAuthDetSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails >
{
    @Override
    public WebAuthenticationDetails buildDetails (HttpServletRequest context) {
	    return new PathWebAuthDets(context);
	  }
}
