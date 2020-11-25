package com.path.vo.common.customization;

import java.math.BigDecimal;

import com.path.lib.log.Log;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>ThemeCustomizationConstant.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
@SuppressWarnings("serial")
public final class ThemeCustomizationConstant
{
    private ThemeCustomizationConstant() 
    {
	Log.getInstance().error("This Class Should not be Instantiated");
    }
    
    public final static BigDecimal FF_LOV_TYPE_ID = BigDecimal.valueOf(598);
    public final static String LOGIN_STYLE_REF = "L";
    public final static String DESKTOP_STYLE_REF = "D";
    public final static String THEMES_MAIN_DIV_ID = ".path-theme-customization-dummy";
    public final static String IMAGE_ATTRIBUTE_CODE = "bi";
    public final static String IMAGE_ATTRIBUTE_NAME = "background-image";
    public final static String BACKGROUND_ATTRIBUTE_CODE = "bg";
    public final static String BORDER_ATTRIBUTE_CODE = "boc";
    
    // Struts results
    public final static String RESULT_INIT = "init";
    public static final String RESULT_THEME_DETAILS = "themedetails";
    public static final String RESULT_FILE_SUCCESS = "fileSuccess";
    public static final String RESULT_RETURN_IMAGE = "returnImage";
    public static final String RESULT_RETURN_IMAGE_ERROR = "returnImage_error";
    public static final String RESULT_CSS = "css";
    public static final String RESULT_CUSTOMIZATION_DIALOG = "buildCustomizationDialog";
}
