package com.path.vo.common.select;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: DeniskHaddad
 *
 * SelectSC.java used to pass search Criteria for Select boxes result returning
 */
public class SelectSC extends BaseSC
{
    private String language;
    private BigDecimal lovTypeId;
    private String lovCodesExclude;
    private String lovCodesInlude;
    /**
     * the order by which the data is returned, 
     * default (null) is CODE,
     *  "NONE" means no Order ConstatntsCommon.LOV_ORDER_NONE, 
     *  "VALUE" means Description ConstatntsCommon.LOV_ORDER_VALUE
     */
    private String orderCriteria;
    
    /**
     * Empty constructor to initialise the Object 
     */
    public SelectSC()
    {
	language = null;// just not to leave constructor empty
    }
    public SelectSC(BigDecimal lovTypeId)
    {
	this.lovTypeId = lovTypeId;
    }
    public SelectSC(BigDecimal lovTypeId, String language)
    {
	this.language = language;
	this.lovTypeId = lovTypeId;
    }
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }
    public BigDecimal getLovTypeId()
    {
        return lovTypeId;
    }
    public void setLovTypeId(BigDecimal lovTypeId)
    {
        this.lovTypeId = lovTypeId;
    }
    public String getLovCodesExclude()
    {
        return lovCodesExclude;
    }
    public void setLovCodesExclude(String lovCodesExclude)
    {
        this.lovCodesExclude = lovCodesExclude;
    }
    public String getLovCodesInlude()
    {
        return lovCodesInlude;
    }
    public void setLovCodesInlude(String lovCodesInlude)
    {
        this.lovCodesInlude = lovCodesInlude;
    }
    public String getOrderCriteria()
    {
        return orderCriteria;
    }
    public void setOrderCriteria(String orderCriteria)
    {
        this.orderCriteria = orderCriteria;
    }
    
}
