package com.path.vo.common.statuscustomization;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * StatusCustomizationSC.java used to
 */
public class StatusCustomizationSC extends GridParamsSC
{
    private String langCode;
    private String progRef;
    private String ivCrud;
    private String statusCode;
    private String selectedKey;
    private String checkExistence;

    /**
     * @return the langCode
     */
    public String getLangCode()
    {
        return langCode;
    }

    /**
     * @param langCode the langCode to set
     */
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
    }

    /**
     * @return the progRef
     */
    public String getProgRef()
    {
        return progRef;
    }

    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    /**
     * @return the ivCrud
     */
    public String getIvCrud()
    {
        return ivCrud;
    }

    /**
     * @param ivCrud the ivCrud to set
     */
    public void setIvCrud(String ivCrud)
    {
        this.ivCrud = ivCrud;
    }

    /**
     * @return the statusCode
     */
    public String getStatusCode()
    {
        return statusCode;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(String statusCode)
    {
        this.statusCode = statusCode;
    }

    /**
     * @return the selectedKey
     */
    public String getSelectedKey()
    {
        return selectedKey;
    }

    /**
     * @param selectedKey the selectedKey to set
     */
    public void setSelectedKey(String selectedKey)
    {
        this.selectedKey = selectedKey;
    }

    /**
     * @return the checkExistence
     */
    public String getCheckExistence()
    {
        return checkExistence;
    }

    /**
     * @param checkExistence the checkExistence to set
     */
    public void setCheckExistence(String checkExistence)
    {
        this.checkExistence = checkExistence;
    }
}
