package com.path.vo.common.languages;

import com.path.lib.vo.BaseVO;


/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: rabihelkhatib
 *
 * languagesCO.java used to
 */
@SuppressWarnings("serial")
public class LanguagesCO extends BaseVO
{
    private String langCode;
    private String langISOCode;
    private String langValue;
    private String isRTL;
    
    
    public String getLangCode()
    {
        return langCode;
    }
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }
    public String getLangISOCode()
    {
        return langISOCode;
    }
    public void setLangISOCode(String langISOCode)
    {
        this.langISOCode = langISOCode;
    }
    public String getLangValue()
    {
        return langValue;
    }
    public void setLangValue(String langValue)
    {
        this.langValue = langValue;
    }
    public String getIsRTL()
    {
        return isRTL;
    }
    public void setIsRTL(String isRTL)
    {
        this.isRTL = isRTL;
    }
}
