package com.path.bo.security;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class PathUrlParamWrapperResponse extends HttpServletResponseWrapper
{
    private static final List<String> ExclusionHeaderList = Arrays.asList("PRAGMA", "CACHE-CONTROL", "EXPIRES");

    public PathUrlParamWrapperResponse(HttpServletResponse response)
    {
	super(response);
	// TODO Auto-generated constructor stub
    }

    public void addDateHeader(String name, long date)
    {
	if(name != null && !ExclusionHeaderList.contains(name.toUpperCase()))
	{
	    super.addDateHeader(name, date);
	}
    }

    public void addHeader(String name, String value)
    {
	if(name != null && !ExclusionHeaderList.contains(name.toUpperCase()))
	{
	    super.addHeader(name, value);
	}
    }

    public void addIntHeader(String name, int value)
    {
	if(name != null && !ExclusionHeaderList.contains(name.toUpperCase()))
	{
	    super.addIntHeader(name, value);
	}
    }

    public void setDateHeader(String name, long date)
    {
	if(name != null && !ExclusionHeaderList.contains(name.toUpperCase()))
	{
	    super.setDateHeader(name, date);
	}
    }

    public void setHeader(String name, String value)
    {
	if(name != null && !ExclusionHeaderList.contains(name.toUpperCase()))
	{
	    super.setHeader(name, value);
	}
    }

    public void setIntHeader(String name, int value)
    {
	if(name != null && !ExclusionHeaderList.contains(name.toUpperCase()))
	{
	    super.setIntHeader(name, value);
	}
    }
}