package com.path.actions;

import java.util.Date;

import com.path.actions.ReportAction;
import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.ActiveTransCO;
import com.path.vo.common.SessionCO;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * CheckDataReportAction.java used to
 */
public class CommonCustomReportAction extends ReportAction
{
    private ActiveTransCO activeTransCO = new ActiveTransCO();
    private String reportRef;
    /**
     * Used as transparent layer between landing page 
     * and the real reporting process to do our specific cases 
     * @author marwanmaddah
     * @date   Feb 24, 2015
     * @return String
     *
     */
    public String generateCustomReport()
    {
	try
	{	    
	    if(StringUtil.isNotEmpty(reportRef))
	    {
		setR_r(reportRef);
	    }
	    setFlushResponse(false);
	    generateReport();
	    if(getReportOutputCO()==null || getReportOutputCO().getReportBytes()==null)
	    {
		activeTransCO.setHasData(Boolean.FALSE);
	    }
	    else
	    {
		byte[] reportBytes = getReportOutputCO().getReportBytes();
		Boolean hasData = Boolean.valueOf(getReportOutputCO().isHasData());
		if(reportBytes != null && reportBytes.length > 0)
		{
		    activeTransCO.setHasData(hasData);
		    activeTransCO.setRepStr(new String(reportBytes));
		}
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
    /**
     * @return the activeTransCO
     */
    public ActiveTransCO getActiveTransCO()
    {
        return activeTransCO;
    }
    /**
     * @param activeTransCO the activeTransCO to set
     */
    public void setActiveTransCO(ActiveTransCO activeTransCO)
    {
        this.activeTransCO = activeTransCO;
    }
    /**
     * @return the reportRef
     */
    public String getReportRef()
    {
        return reportRef;
    }
    /**
     * @param reportRef the reportRef to set
     */
    public void setReportRef(String reportRef)
    {
        this.reportRef = reportRef;
    }
}

