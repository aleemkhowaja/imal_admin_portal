package com.path.vo.common.select;

import com.path.lib.vo.BaseVO;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: DeniskHaddad
 *
 * SelectCO.java used to return select boxes from List of Values Tables
 */
public class SelectCO extends BaseVO
{
    private String code;
    private String descValue;
    private String hiddenOpt;
    private String defaultValue;
    private String iconName; // property used in Omni project to add icon image url to list of values
    
    public SelectCO()
    {
	super();
    }
    
    public SelectCO(String code, String descValue)
    {
	this.code = code;
	this.descValue = descValue;
    }
    
    public String getCode()
    {
        return code;
    }
    public void setCode(String code)
    {
        this.code = code;
    }
    public String getDescValue()
    {
        return descValue;
    }
    public void setDescValue(String descValue)
    {
        this.descValue = descValue;
    }

    /**
     * @return the defaultValue
     */
    public String getDefaultValue()
    {
        return defaultValue;
    }

    /**
     * @param defaultValue the defaultValue to set
     */
    public void setDefaultValue(String defaultValue)
    {
        this.defaultValue = defaultValue;
    }

    /**
     * @return the hiddenOpt
     */
    public String getHiddenOpt()
    {
        return hiddenOpt;
    }

    /**
     * @param hiddenOpt the hiddenOpt to set
     */
    public void setHiddenOpt(String hiddenOpt)
    {
        this.hiddenOpt = hiddenOpt;
    }

    public String getIconName()
    {
        return iconName;
    }

    public void setIconName(String iconName)
    {
        this.iconName = iconName;
    }
    
}
