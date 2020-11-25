/**
 * 
 */
package com.path.actions.dependencies.admin;

import java.math.BigDecimal;

import com.path.bo.common.additionalfields.AdditionalFieldsBO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.admin.additionalfields.AdditionalFieldsByTypeSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.additionalfield.AdditionalFieldsByTypeCO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AdditionalFieldsByTypeDependencyAction.java used to
 */
public class AdditionalFieldsByTypeDependencyAction extends BaseAction
{
    private AdditionalFieldsBO additionalFieldsBO;
    private AdditionalFieldsByTypeSC additionalFieldsByTypeSC = new AdditionalFieldsByTypeSC();
    private BigDecimal dependencyCode;
    private String description;
    
    public String dependencyByCode() 
    {
	try 
	{
	  //Setting session values
	    SessionCO sessionCO = returnSessionObject();
	    additionalFieldsByTypeSC.setCompCode(sessionCO.getCompanyCode());
	    additionalFieldsByTypeSC.setBranchCode(sessionCO.getBranchCode());
	    additionalFieldsByTypeSC.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    additionalFieldsByTypeSC.setFiscalYear(sessionCO.getFiscalYear());
	    additionalFieldsByTypeSC.setBaseCurrDecPoint(sessionCO.getBaseCurrDecPoint());
	    additionalFieldsByTypeSC.setExposCurCode(sessionCO.getExposCurCode());
	    additionalFieldsByTypeSC.setCompanyName(sessionCO.getCompanyName());
	    additionalFieldsByTypeSC.setCompanyArabName(sessionCO.getCompanyArabName());
	    additionalFieldsByTypeSC.setUserName(sessionCO.getUserName());
	    additionalFieldsByTypeSC.setClientType(sessionCO.getClientType());
	    additionalFieldsByTypeSC.setBaseCurrencyName(sessionCO.getBaseCurrencyName());
	    additionalFieldsByTypeSC.setExposCurName(sessionCO.getExposCurName());
	    additionalFieldsByTypeSC.setCurrentAppName(sessionCO.getCurrentAppName());
	    additionalFieldsByTypeSC.setRunningDateRET(sessionCO.getRunningDateRET());
	    additionalFieldsByTypeSC = additionalFieldsBO.returnAdditionalFieldsByCode(additionalFieldsByTypeSC);
	    if(additionalFieldsByTypeSC.getMandatoryElemsList() != null
		    && !additionalFieldsByTypeSC.getMandatoryElemsList().isEmpty())
	    {
		SYS_PARAM_SCREEN_DISPLAYVO vo;
		AdditionalFieldsByTypeCO co;
		for(int i = 0; i < additionalFieldsByTypeSC.getMandatoryElemsList().size(); i++)
		{
		    co = additionalFieldsByTypeSC.getMandatoryElemsList().get(i);
		    if("1".equals(co.getMANDATORY()))
		    {
			vo = new SYS_PARAM_SCREEN_DISPLAYVO();
			vo.setIS_MANDATORY(BigDecimal.ONE);
			getAdditionalScreenParams().put("addFieldsByType_" + co.getFIELD_SEQ() + "_" + get_pageRef(),
				vo);
		    }
		    else
		    {
			vo = new SYS_PARAM_SCREEN_DISPLAYVO();
			vo.setIS_MANDATORY(BigDecimal.ZERO);
			getAdditionalScreenParams().put("addFieldsByType_" + co.getFIELD_SEQ() + "_" + get_pageRef(),
				vo);
		    }
		}
	    }
	} 
	catch (Exception e) 
	{
	    handleException(e, null, null);
	    additionalFieldsByTypeSC.setDependencyCode(null);additionalFieldsByTypeSC.setDescription("asdfs");
	}
	return SUCCESS;
    }
    
    public Object getModel()
    {
        return additionalFieldsByTypeSC;
    }
    
    /**
     * @return the additionalFieldsByTypeSC
     */
    public AdditionalFieldsByTypeSC getAdditionalFieldsByTypeSC()
    {
        return additionalFieldsByTypeSC;
    }
    /**
     * @param additionalFieldsByTypeSC the additionalFieldsByTypeSC to set
     */
    public void setAdditionalFieldsByTypeSC(AdditionalFieldsByTypeSC additionalFieldsByTypeSC)
    {
        this.additionalFieldsByTypeSC = additionalFieldsByTypeSC;
    }
    /**
     * @param additionalFieldsBO the additionalFieldsBO to set
     */
    public void setAdditionalFieldsBO(AdditionalFieldsBO additionalFieldsBO)
    {
        this.additionalFieldsBO = additionalFieldsBO;
    }

    /**
     * @return the dependencyCode
     */
    public BigDecimal getDependencyCode()
    {
        return dependencyCode;
    }

    /**
     * @param dependencyCode the dependencyCode to set
     */
    public void setDependencyCode(BigDecimal dependencyCode)
    {
        this.dependencyCode = dependencyCode;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
}
