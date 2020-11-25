package com.path.actions.common.recordlogs;

import java.util.ArrayList;

import com.path.bo.common.recordlogs.RecordLogsBO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.recordlogs.RecordLogsSC;
import com.path.vo.common.recordlogs.RecordUserMailListCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * RecordLogsListAction.java used to
 */
public class RecordLogsListAction extends GridBaseAction
{
    private RecordLogsBO recordLogsBO;
    private final  RecordLogsSC recordSC = new RecordLogsSC();
    private String allSelectedRow;

    @Override
    public Object getModel()
    {
	// TODO Auto-generated method stub
	return recordSC;
    }

    /***
     * Method for populating the Group Dependent labels grid
     * 
     * @return String
     */
    public String loadRecordUserMailGrid()
    {
	return "loadRecordUserMail";
    }

    private void fillRecordSC()
    {
	    SessionCO sessionObject = returnSessionObject();
	    recordSC.setAppName(StringUtil.nullEmptyToValue(recordSC.getAppName(), sessionObject.getCurrentAppName()));
	    recordSC.setRunningDate(sessionObject.getRunningDateRET());
	    recordSC.setUserId(sessionObject.getUserName());
	    recordSC.setPreferredLanguage(sessionObject.getLanguage());
    }
    
    /***
     * Method for populating the Groups details grid for Labels dependent
     * 
     * @return String
     */
    public String loadRecordUserMailGridData()
    {
	try
	{
	    String[] searchCols = { "USER_ID", "USER_NAME", "EMAIL_ID", "EMAIL_SERVER", "MAIL_TO",
		    "MAIL_RESULT", "REPLY"};
	    
	    fillRecordSC();
	    recordSC.setSearchCols(searchCols);
	    copyproperties(recordSC);
	    if(checkNbRec(recordSC))
	    {
		setRecords(recordLogsBO.returnUserMailListCount(recordSC));
	    }
	    ArrayList<RecordUserMailListCO> recordUserMailListCO = recordLogsBO.returnUserMailList(recordSC);
	    setGridModel(recordUserMailListCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }

    public String returnAllSelectedRow()
    {
	try
	{
	    fillRecordSC();
	    recordSC.setNbRec(-1);
	    ArrayList<RecordUserMailListCO> recordUserMailListCO = recordLogsBO.returnUserMailList(recordSC);
	    int listSize = recordUserMailListCO.size();
	    RecordUserMailListCO recordUserMailCO;
	    StringBuffer sb = new StringBuffer();

	    for(int i = 0; i < listSize; i++)
	    { 
		recordUserMailCO = recordUserMailListCO.get(i);
		sb.append("\""+recordUserMailCO.getUSER_ID()+"\" : \"").append(recordUserMailCO.getREPLY()).append("\",");
	    }
	    if(sb.length() > 0)
	    {
		setAllSelectedRow("{" + sb.substring(0, sb.length() - 1).toString() + "}");
	    }
	    else
	    {
		setAllSelectedRow("");
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    public void setRecordLogsBO(RecordLogsBO recordLogsBO)
    {
	this.recordLogsBO = recordLogsBO;
    }

    public String getAllSelectedRow()
    {
        return allSelectedRow;
    }

    public void setAllSelectedRow(String allSelectedRow)
    {
        this.allSelectedRow = allSelectedRow;
    }
}
