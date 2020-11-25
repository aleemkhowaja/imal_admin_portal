package com.path.vo.common.customization;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.SYS_PARAM_ATTRIBUTEVO;
import com.path.dbmaps.vo.SYS_PARAM_STYLEVO;
import com.path.dbmaps.vo.SYS_PARAM_STYLE_ATTRIBUTEVOKey;
import com.path.dbmaps.vo.SYS_THEMEVO;
import com.path.dbmaps.vo.SYS_THEME_STYLE_ATTRIBUTE_VALVO;
import com.path.struts2.lib.common.BaseObject;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>ThemeCustomizationCO.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
@SuppressWarnings("serial")
public class ThemeCustomizationCO extends BaseObject
{
    private SYS_PARAM_STYLEVO styleVO;
    private SYS_PARAM_ATTRIBUTEVO attrVO;
    private SYS_PARAM_STYLE_ATTRIBUTEVOKey styleAttrVO;
    private List<ThemeCustomizationCO> styleAttrVOs;
    private SYS_THEMEVO themeVO;
    private SYS_THEME_STYLE_ATTRIBUTE_VALVO themeStyleAttrVO;

    private BigDecimal colorChange;
    private BigDecimal bcolorChange;
    private BigDecimal borderChange;
    private BigDecimal imageChange;
    private BigDecimal fontChange;
    private BigDecimal sizeChange;
    private BigDecimal gradientChange;
    private BigDecimal colorDefaulted;
    private BigDecimal borderDefaulted;
    private BigDecimal imageDefaulted;
    private BigDecimal fontDefaulted;
    private BigDecimal sizeDefaulted;
    private BigDecimal gradientDefaulted;
    private BigDecimal isGlobal;
    private String overrideCustImport;

    private String fontName;
    private BigDecimal size;

    private String appDesc;
    private List<SYS_THEME_STYLE_ATTRIBUTE_VALVO> themeDetailsData = new ArrayList<SYS_THEME_STYLE_ATTRIBUTE_VALVO>();

    /**
     * @return the styleVO
     */
    public SYS_PARAM_STYLEVO getStyleVO()
    {
	return styleVO;
    }

    /**
     * @param styleVO the styleVO to set
     */
    public void setStyleVO(SYS_PARAM_STYLEVO styleVO)
    {
	this.styleVO = styleVO;
    }

    /**
     * @return the themeVO
     */
    public SYS_THEMEVO getThemeVO()
    {
	return themeVO;
    }

    /**
     * @param themeVO the themeVO to set
     */
    public void setThemeVO(SYS_THEMEVO themeVO)
    {
	this.themeVO = themeVO;
    }

    /**
     * @return the themeStyleAttrVO
     */
    public SYS_THEME_STYLE_ATTRIBUTE_VALVO getThemeStyleAttrVO()
    {
	return themeStyleAttrVO;
    }

    /**
     * @param themeStyleAttrVO the themeStyleAttrVO to set
     */
    public void setThemeStyleAttrVO(SYS_THEME_STYLE_ATTRIBUTE_VALVO themeStyleAttrVO)
    {
	this.themeStyleAttrVO = themeStyleAttrVO;
    }

    /**
     * @return the colorChange
     */
    public BigDecimal getColorChange()
    {
	return colorChange;
    }

    /**
     * @param colorChange the colorChange to set
     */
    public void setColorChange(BigDecimal colorChange)
    {
	this.colorChange = colorChange;
    }

    /**
     * @return the imageChange
     */
    public BigDecimal getImageChange()
    {
	return imageChange;
    }

    /**
     * @param imageChange the imageChange to set
     */
    public void setImageChange(BigDecimal imageChange)
    {
	this.imageChange = imageChange;
    }

    /**
     * @return the styleAttrVO
     */
    public SYS_PARAM_STYLE_ATTRIBUTEVOKey getStyleAttrVO()
    {
	return styleAttrVO;
    }

    /**
     * @param styleAttrVO the styleAttrVO to set
     */
    public void setStyleAttrVO(SYS_PARAM_STYLE_ATTRIBUTEVOKey styleAttrVO)
    {
	this.styleAttrVO = styleAttrVO;
    }

    /**
     * @return the styleAttrVOs
     */
    public List<ThemeCustomizationCO> getStyleAttrVOs()
    {
	return styleAttrVOs;
    }

    /**
     * @param styleAttrVOs the styleAttrVOs to set
     */
    public void setStyleAttrVOs(List<ThemeCustomizationCO> styleAttrVOs)
    {
	this.styleAttrVOs = styleAttrVOs;
    }

    /**
     * @return the attrVO
     */
    public SYS_PARAM_ATTRIBUTEVO getAttrVO()
    {
	return attrVO;
    }

    /**
     * @param attrVO the attrVO to set
     */
    public void setAttrVO(SYS_PARAM_ATTRIBUTEVO attrVO)
    {
	this.attrVO = attrVO;
    }

    /**
     * @return the fontChange
     */
    public BigDecimal getFontChange()
    {
	return fontChange;
    }

    /**
     * @param fontChange the fontChange to set
     */
    public void setFontChange(BigDecimal fontChange)
    {
	this.fontChange = fontChange;
    }

    /**
     * @return the fontName
     */
    public String getFontName()
    {
	return fontName;
    }

    /**
     * @param fontName the fontName to set
     */
    public void setFontName(String fontName)
    {
	this.fontName = fontName;
    }

    /**
     * @return the sizeChange
     */
    public BigDecimal getSizeChange()
    {
	return sizeChange;
    }

    /**
     * @param sizeChange the sizeChange to set
     */
    public void setSizeChange(BigDecimal sizeChange)
    {
	this.sizeChange = sizeChange;
    }

    /**
     * @return the size
     */
    public BigDecimal getSize()
    {
	return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(BigDecimal size)
    {
	this.size = size;
    }

    /**
     * @return the gradientChange
     */
    public BigDecimal getGradientChange()
    {
        return gradientChange;
    }

    /**
     * @param gradientChange the gradientChange to set
     */
    public void setGradientChange(BigDecimal gradientChange)
    {
        this.gradientChange = gradientChange;
    }

    /**
     * @return the colorDefaulted
     */
    public BigDecimal getColorDefaulted()
    {
        return colorDefaulted;
    }

    /**
     * @param colorDefaulted the colorDefaulted to set
     */
    public void setColorDefaulted(BigDecimal colorDefaulted)
    {
        this.colorDefaulted = colorDefaulted;
    }

    /**
     * @return the imageDefaulted
     */
    public BigDecimal getImageDefaulted()
    {
        return imageDefaulted;
    }

    /**
     * @param imageDefaulted the imageDefaulted to set
     */
    public void setImageDefaulted(BigDecimal imageDefaulted)
    {
        this.imageDefaulted = imageDefaulted;
    }

    /**
     * @return the fontDefaulted
     */
    public BigDecimal getFontDefaulted()
    {
        return fontDefaulted;
    }

    /**
     * @param fontDefaulted the fontDefaulted to set
     */
    public void setFontDefaulted(BigDecimal fontDefaulted)
    {
        this.fontDefaulted = fontDefaulted;
    }

    /**
     * @return the sizeDefaulted
     */
    public BigDecimal getSizeDefaulted()
    {
        return sizeDefaulted;
    }

    /**
     * @param sizeDefaulted the sizeDefaulted to set
     */
    public void setSizeDefaulted(BigDecimal sizeDefaulted)
    {
        this.sizeDefaulted = sizeDefaulted;
    }

    /**
     * @return the gradientDefaulted
     */
    public BigDecimal getGradientDefaulted()
    {
        return gradientDefaulted;
    }

    /**
     * @param gradientDefaulted the gradientDefaulted to set
     */
    public void setGradientDefaulted(BigDecimal gradientDefaulted)
    {
        this.gradientDefaulted = gradientDefaulted;
    }

    /**
     * @return the appDesc
     */
    public String getAppDesc()
    {
        return appDesc;
    }

    /**
     * @param appDesc the appDesc to set
     */
    public void setAppDesc(String appDesc)
    {
        this.appDesc = appDesc;
    }

    public BigDecimal getIsGlobal()
    {
        return isGlobal;
    }

    public void setIsGlobal(BigDecimal isGlobal)
    {
        this.isGlobal = isGlobal;
    }
    
    public List<SYS_THEME_STYLE_ATTRIBUTE_VALVO> getThemeDetailsData()
    {
        return themeDetailsData;
    }

    public void setThemeDetailsData(List<SYS_THEME_STYLE_ATTRIBUTE_VALVO> themeDetailsData)
    {
        this.themeDetailsData = themeDetailsData;
    }

    public String getOverrideCustImport()
    {
        return overrideCustImport;
    }

    public void setOverrideCustImport(String overrideCustImport)
    {
        this.overrideCustImport = overrideCustImport;
    }

    public BigDecimal getBorderChange()
    {
        return borderChange;
    }

    public void setBorderChange(BigDecimal borderChange)
    {
        this.borderChange = borderChange;
    }

    public BigDecimal getBorderDefaulted()
    {
        return borderDefaulted;
    }

    public void setBorderDefaulted(BigDecimal borderDefaulted)
    {
        this.borderDefaulted = borderDefaulted;
    }

    public BigDecimal getBcolorChange()
    {
        return bcolorChange;
    }

    public void setBcolorChange(BigDecimal bcolorChange)
    {
        this.bcolorChange = bcolorChange;
    }
    
    
}
