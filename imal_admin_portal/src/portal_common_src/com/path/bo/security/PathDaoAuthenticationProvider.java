package com.path.bo.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * 
 * Copyright 2010, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Denisk Haddad
 *
 * PathDaoAuthenticationProvider.java used to extend spring security implementation
 */
public class PathDaoAuthenticationProvider implements AuthenticationProvider
{

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException
	{
		return auth;
	}

	@Override
	public boolean supports(Class arg0)
	{
		return true;
	}
   
}
