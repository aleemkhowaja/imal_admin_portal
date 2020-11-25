package com.path.vo.common.customization.css;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>ClassCss.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
public class ClassCss implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String cssName;
    private List<AttributeCss> attributeCss;
    private List<AttributeCss> defaultAttrCodes;

    /**
     * @return the attributeCss
     */
    public List<AttributeCss> getAttributeCss()
    {
	return attributeCss;
    }

    /**
     * @param attributeCss the attributeCss to set
     */
    public void setAttributeCss(List<AttributeCss> attributeCss)
    {
	this.attributeCss = attributeCss;
    }

    /**
     * @return the cssName
     */
    public String getCssName()
    {
	return cssName;
    }

    /**
     * @param cssName the cssName to set
     */
    public void setCssName(String cssName)
    {
	this.cssName = cssName;
    }

    /**
     * @return the defaultAttrCodes
     */
    public List<AttributeCss> getDefaultAttrCodes()
    {
        return defaultAttrCodes;
    }

    /**
     * @param defaultAttrCodes the defaultAttrCodes to set
     */
    public void setDefaultAttrCodes(List<AttributeCss> defaultAttrCodes)
    {
        this.defaultAttrCodes = defaultAttrCodes;
    }

}
