package com.path.bo.common.customization;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.SYS_THEMEVO;
import com.path.dbmaps.vo.SYS_THEME_STYLE_ATTRIBUTE_VALVO;
import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.common.customization.ThemeCustomizationCO;
import com.path.vo.common.customization.css.ThemeCss;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>ThemeCustomizationBO.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
public interface ThemeCustomizationBO
{
    /**
     * Return the count of user themes
     * 
     * @param gridParamsSC
     * @return
     * @throws BaseException
     */
    public int returnUserThemesCount(GridParamsSC gridParamsSC) throws BaseException;

    /**
     * Load the user themes
     * 
     * @param gridParamSC
     * 
     * @return
     * @throws BaseException
     */
    public List<ThemeCustomizationCO> loadUserThemes(GridParamsSC gridParamSC) throws BaseException;

    /**
     * Save the created theme into the database
     * 
     * @param themeCO
     * @param themeCss
     * @param images
     * @throws BaseException
     */
    public void saveUserTheme(ThemeCustomizationCO themeCO, ThemeCss themeCss, Map<String, byte[]> images)
	    throws BaseException;

    /**
     * Activate the given theme id per application
     * 
     * @throws BaseException
     */
    public void activateUserTheme(SYS_THEMEVO themeVO) throws BaseException;

    /**
     * Deactivates the user theme per application
     * 
     * @param themeID
     * @throws BaseException
     */
    public void deactivateUserTheme(BigDecimal themeID) throws BaseException;

    /**
     * Returns the list of style attributes for the specific style technical
     * name
     * 
     * @param styleTechName
     * @return
     */
    public List<ThemeCustomizationCO> getStyleAttrs(String styleTechName) throws BaseException;

    /**
     * Construct the theme Css
     * 
     * @param themeID
     * @param dialogDiv
     * @param hasPrefix
     * @return
     * @throws BaseException
     */
    public String constructThemeCss(BigDecimal themeID, String dialogDiv, String styleRef, boolean hasPrefix,
	    ThemeCss themeCss, String appName) throws BaseException;

    /**
     * Construct the css file if not found in the repositery or IS_UPDATED_YN =
     * 1
     * 
     * @return
     * @throws BaseException
     */
    public String constructCssInRepository(String styleRef, String appName) throws BaseException;

    /**
     * Get the image from repository
     * 
     * @param imageName
     * @param themeId
     * @return
     * @throws BaseException
     */
    public byte[] readThemeStyleImage(String imageName, BigDecimal themeId) throws BaseException;

    /**
     * Deletes the user theme
     * 
     * @param themeID
     */
    public void deleteUserTheme(BigDecimal themeId) throws BaseException;
    /**
     * Deletes the user theme
     * 
     * @param themeID
     */
    public SYS_THEMEVO returnUserTheme(BigDecimal themeId) throws BaseException;
    /**
     * return THEME_ID if exist theme with specific name
     * 
     * @param themeName
     */
    public int returnUserThemeExit(String themeName) throws BaseException;
    /**
     * return sys_param_theme_attribute_val for specific theme_id.
     * @param themeco
     * @return
     * @throws BaseException
     */
    public List<SYS_THEME_STYLE_ATTRIBUTE_VALVO> returnThemeDetails(ThemeCustomizationCO themeco)throws BaseException;

}
