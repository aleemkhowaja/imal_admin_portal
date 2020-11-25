/**
 * 
 */
package com.path.vo.common.reportresponse;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseObject;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 *
 *          ReportResponseCO.java used to
 */

public class ReportResponseCO extends BaseObject
{
    private String reportRef;
    private String reportParams;
    private BigDecimal reportId;
    private BigDecimal argumentId;
    private BigDecimal engReportId;
    private String engReportParams;
    private BigDecimal arabReportId;
    private String arabReportParams;
    private Boolean autoPrint;
    private String printerName;
    private String callBackFunc;
    private Boolean selectReportLanguage = false;
    private String reportLanguage;
    private BigDecimal nbrCopies;
    private BigDecimal engNbrCopies;
    private BigDecimal arabNbrCopies;
    // NABIL FEGHALI - BB120129 - YMC FORMS
    private String message;
    private String engMessage;
    private String arabMessage;
    private Boolean selectLangBeforeConf = false;
    private String reportTitle;
    
    // TP 1062269 Loading Report Assigned by Customization into provided Div or iFrame ID - Customization Enhancement
    private String componentId;
    
    public String getComponentId() 
    {
		return componentId;
	}

	public void setComponentId(String componentId) 
	{
		this.componentId = componentId;
	}

	public String getReportRef()
    {
	return reportRef;
    }

    public void setReportRef(String reportRef)
    {
	this.reportRef = reportRef;
    }

    public String getReportParams()
    {
	return reportParams;
    }

    public void setReportParams(String reportParams)
    {
	this.reportParams = reportParams;
    }

    public BigDecimal getEngReportId()
    {
	return engReportId;
    }

    public void setEngReportId(BigDecimal engReportId)
    {
	this.engReportId = engReportId;
    }

    public String getEngReportParams()
    {
	return engReportParams;
    }

    public void setEngReportParams(String engReportParams)
    {
	this.engReportParams = engReportParams;
    }

    public BigDecimal getArabReportId()
    {
	return arabReportId;
    }

    public void setArabReportId(BigDecimal arabReportId)
    {
	this.arabReportId = arabReportId;
    }

    public String getArabReportParams()
    {
	return arabReportParams;
    }

    public void setArabReportParams(String arabReportParams)
    {
	this.arabReportParams = arabReportParams;
    }

    public Boolean getAutoPrint()
    {
	return autoPrint;
    }

    public void setAutoPrint(Boolean autoPrint)
    {
	this.autoPrint = autoPrint;
    }

    public String getCallBackFunc()
    {
	return callBackFunc;
    }

    public void setCallBackFunc(String callBackFunc)
    {
	this.callBackFunc = callBackFunc;
    }

    public Boolean getSelectReportLanguage()
    {
	return selectReportLanguage;
    }

    public void setSelectReportLanguage(Boolean selectReportLanguage)
    {
	this.selectReportLanguage = selectReportLanguage;
    }

    public String getReportLanguage()
    {
	return reportLanguage;
    }

    public void setReportLanguage(String reportLanguage)
    {
	this.reportLanguage = reportLanguage;
    }

    public BigDecimal getReportId()
    {
	return reportId;
    }

    public void setReportId(BigDecimal reportId)
    {
	this.reportId = reportId;
    }

    public BigDecimal getNbrCopies()
    {
	return nbrCopies;
    }

    public void setNbrCopies(BigDecimal nbrCopies)
    {
	this.nbrCopies = nbrCopies;
    }

    public String getEngMessage()
    {
	return engMessage;
    }

    public void setEngMessage(String engMessage)
    {
	this.engMessage = engMessage;
    }

    public String getArabMessage()
    {
	return arabMessage;
    }

    public void setArabMessage(String arabMessage)
    {
	this.arabMessage = arabMessage;
    }

    public String getMessage()
    {
	return message;
    }

    public void setMessage(String message)
    {
	this.message = message;
    }

    public Boolean getSelectLangBeforeConf()
    {
	return selectLangBeforeConf;
    }

    public void setSelectLangBeforeConf(Boolean selectLangBeforeConf)
    {
	this.selectLangBeforeConf = selectLangBeforeConf;
    }

    public String getPrinterName()
    {
	return printerName;
    }

    public void setPrinterName(String printerName)
    {
	this.printerName = printerName;
    }

    public BigDecimal getArgumentId()
    {
	return argumentId;
    }

    public void setArgumentId(BigDecimal argumentId)
    {
	this.argumentId = argumentId;
    }

    public BigDecimal getEngNbrCopies()
    {
	return engNbrCopies;
    }

    public void setEngNbrCopies(BigDecimal engNbrCopies)
    {
	this.engNbrCopies = engNbrCopies;
    }

    public BigDecimal getArabNbrCopies()
    {
	return arabNbrCopies;
    }

    public void setArabNbrCopies(BigDecimal arabNbrCopies)
    {
	this.arabNbrCopies = arabNbrCopies;
    }

    public String getReportTitle()
    {
	return reportTitle;
    }

    public void setReportTitle(String reportTitle)
    {
	this.reportTitle = reportTitle;
    }

}
