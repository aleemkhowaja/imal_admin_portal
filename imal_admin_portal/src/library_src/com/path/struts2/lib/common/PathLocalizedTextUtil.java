package com.path.struts2.lib.common;

import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;

import com.path.lib.log.Log;

public class PathLocalizedTextUtil
{
    /**
     * Private constructor only to prevent instantiation in the class
     */
    private PathLocalizedTextUtil()
    {
	Log.getInstance().error("PathLocalizedTextUtil This Class Should not be Instantiated");
    }

    public static Locale localeFromString(String langVal, Object object)
    {
	String theLang = langVal;
	if(langVal != null)
	{
	    theLang = theLang.toLowerCase();
	}
	try
	{
	    return LocaleUtils.toLocale(langVal);
	}
	catch (Exception e) 
	{
	    Log.getInstance().warning("Erro in Locale construction from String "+theLang+" msg "+e.getMessage()+" returning en Locale");
	    return LocaleUtils.toLocale("en");
	}
	
    }
}
