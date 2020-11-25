package com.path.bo.common.translation;

import com.path.bo.common.CachedConstantsCommon;
import com.path.lib.log.Log;
import com.path.vo.common.translation.TranslationSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: rabihelkhatib
 *
 * TranslationConstants.java used to
 */
public final class TranslationConstants
{
    /**
     * Private constructor to prevent class from instantiation
     */
    private TranslationConstants()
    {
	Log.getInstance().warning("This class is utility and cannot be instantiated");
    }
    public static void clearTransCash(TranslationSC transSC)
    {
	// Clear Cashed translation map for the current update
	String key = transSC.getPreferredLanguage() + "_" + transSC.getAppName() + "_"
		+ transSC.getPageRef();
	CachedConstantsCommon.keyLabelTransMap.remove(key);
    }
    public static final String ALL_APPS_SELECTION = "4";
}
