package com.path.vo.common.customization.css;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>AttributeCss.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
public class AttributeCss implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String attrName;
    private List<String> valueCss;

    /**
     * @return the valueCss
     */
    public List<String> getValueCss()
    {
	return valueCss;
    }

    /**
     * @param valueCss the valueCss to set
     */
    public void setValueCss(List<String> valueCss)
    {
	this.valueCss = valueCss;
    }

    /**
     * @return the attrName
     */
    public String getAttrName()
    {
	return attrName;
    }

    /**
     * @param attrName the attrName to set
     */
    public void setAttrName(String attrName)
    {
	this.attrName = attrName;
    }

}
