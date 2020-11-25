package com.path.actions.common.recordlogs;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.recordlogs.RecordLogsBO;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.recordlogs.RecordLogsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * RecordLogsMaintAction.java used to
 */
public class RecordLogsMaintAction extends BaseAction
{
    private RecordLogsBO recordLogsBO;
    private RecordLogsSC recordSC = new RecordLogsSC();

    @Override
    public Object getModel()
    {
	// TODO Auto-generated method stub
	return recordSC;
    }

    /**
     * Load the record log page
     * 
     * @return String
     */
    public String loadRecordLogsPage()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    recordSC.setAppName(sessionObject.getCurrentAppName());
	    recordSC.setTheRecord(recordLogsBO.loadRecordLogs(recordSC));
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "loadRecPage";
    }

    /**
     * Save the record Log
     * 
     * @return String
     */
    public String saveRecordLogs()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    recordSC.setAppName(sessionObject.getCurrentAppName());
	    recordSC.setUserId(sessionObject.getUserName());
	    recordSC.setRunningDate(sessionObject.getRunningDateRET());
	    
	    if(ConstantsCommon.OPEN_ENTITY_LOG.equals(recordSC.getRecordsType())
		    || ConstantsCommon.OPEN_ENTITY.equals(recordSC.getRecordsType()))
	    {
		recordSC.setTrxNbr("0");
	    }
	    if(ConstantsCommon.OPEN_ENTITY_LOG.equals(recordSC.getRecordsType())
		    || ConstantsCommon.OPEN_RECORD_LOG.equals(recordSC.getRecordsType()))
	    {
		StringBuffer theRec = new StringBuffer(recordSC.getTheRecord());
		theRec.append("<br>");
		theRec.append("<br>");
		theRec.append("==============================================================");
		theRec.append("<br>");
		theRec.append(getText("User_Id_key") + " : " + recordSC.getUserId() + "   ");
		theRec.append(getText("reporting.sysDate") + " : "
			+ DateUtil.format(sessionObject.getRunningDateRET(), "dd/MM/yyyy") + "   ");
		theRec.append(getText("Current_Date_key") + " : "
			+ DateUtil.format(returnCommonLibBO().returnSystemDateNoTime(), "dd/MM/yyyy"));
		theRec.append("<br>");
		theRec.append("==============================================================");
		theRec.append("<br>");
		theRec.append("<br>");

		theRec.append(StringUtil.nullToEmpty(recordLogsBO.loadRecordLogs(recordSC)));
		recordSC.setTheRecord(theRec.toString());
	    }
	    recordLogsBO.saveRecordLogs(recordSC);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "success";
    }

    /**
     * Send e-mail to specified users
     * 
     * @return String
     */
    public String sendMailTo()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    recordSC.setAppName(StringUtil.nullEmptyToValue(recordSC.getAppName(), sessionObject.getCurrentAppName()));
	    recordSC.setRunningDate(sessionObject.getRunningDateRET());
	    recordSC.setUserId(sessionObject.getUserName());
	    recordSC.setPreferredLanguage(sessionObject.getLanguage());
	    StringBuffer head = new StringBuffer();
	    head.append(getText("companyKey") + " : " + sessionObject.getCompanyName());
	    head.append("<br/>");
	    head.append(getText("Branch_Name_key") + " : " + sessionObject.getBranchName());
	    head.append("<br/>");
	    head.append(getText("User_Id_key") + " : " + sessionObject.getUserName());
	    head.append("<br/>");
	    head.append(getText("Reference_key") + " : " + recordSC.getPageRef());
	    head.append("<br/>");
	    head.append(getText("Date_key") + " : " + DateUtil.format(recordSC.getRunningDate()));
	    head.append("<br/>");
	    recordSC.setMsgHead(head);
	    recordSC.setNbRec(-1);
	    recordLogsBO.sendMailTo(recordSC);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "success";
    }

    public void setRecordLogsBO(RecordLogsBO recordLogsBO)
    {
	this.recordLogsBO = recordLogsBO;
    }

    public RecordLogsSC getRecordSC()
    {
	return recordSC;
    }

    public void setRecordSC(RecordLogsSC recordSC)
    {
	this.recordSC = recordSC;
    }
}
