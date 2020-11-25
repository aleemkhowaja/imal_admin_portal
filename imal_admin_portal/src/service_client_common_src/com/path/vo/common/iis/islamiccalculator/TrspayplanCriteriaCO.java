package com.path.vo.common.iis.islamiccalculator;

import java.io.Serializable;
import java.math.BigDecimal;

import com.path.dbmaps.vo.TRSPAYPLAN_CRITERIAVO;

public class TrspayplanCriteriaCO extends TRSPAYPLAN_CRITERIAVO implements Serializable
{
    private String ACC_NAME;
    private String COVERING_ACC_NAME;
    private BigDecimal scheduleAmtFormat;

    public void setCOVERING_ACC_NAME(String cOVERING_ACC_NAME)
    {
	COVERING_ACC_NAME = cOVERING_ACC_NAME;
    }

    public String getCOVERING_ACC_NAME()
    {
	return COVERING_ACC_NAME;
    }

    public String getACC_NAME()
    {
	return ACC_NAME;
    }

    public void setACC_NAME(String aCCNAME)
    {
	ACC_NAME = aCCNAME;
    }

    public BigDecimal getScheduleAmtFormat()
    {
	return scheduleAmtFormat;
    }

    public void setScheduleAmtFormat(BigDecimal scheduleAmtFormat)
    {
	this.scheduleAmtFormat = scheduleAmtFormat;
    }

}
