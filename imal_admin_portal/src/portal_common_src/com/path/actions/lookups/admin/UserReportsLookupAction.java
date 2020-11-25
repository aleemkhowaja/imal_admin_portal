/**
 * 
 */
package com.path.actions.lookups.admin;

import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.admin.user.UsrBO;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.admin.user.UsrSC;
import com.path.vo.common.SessionCO;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * UserReportsLookupAction.java used to
 */
public class UserReportsLookupAction extends LookupBaseAction
{
    private final UsrSC criteria = new UsrSC();
    private UsrBO usrBO;
    private List<UsrCO> UsrReportsList;
    @Override
    public Object getModel()
    {
	return criteria;
    }
    
    public String constructLookup()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "REPORT_ID","REPORT_PROG_REF", "REPORT_NAME"};
	    String[] colType = { "number", "text","text"};
	    String[] titles = { getText("rep_id_key"),getText("prog_ref_key"), getText("REP_NAME_KEY")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("User Reports List"));
	    grid.setRowNum("5");
	    grid.setShrinkToFit("true");
	    grid.setUrl("/pathdesktop/UsrReportsLookup_fillLookupUsrReports");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of UsersReportsLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup branch data filtered by user.
     * 
     * @return
     * @throws JSONException
     */
    public String fillLookupUsrReports()
    {
	try
	{
	    criteria.setSearchCols(new String[]{"REPORT_ID", "REPORT_PROG_REF", "REPORT_NAME"});
	    setSearchFilter(criteria);
	    // Get the data from BO
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    
	    criteria.setUserId(sessionCO.getUserName());
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());
            criteria.setAppName(StringUtil.nullToEmpty(criteria.getCurrAppName()).isEmpty() || ConstantsCommon.IMAL_APP_NAME.equals(criteria.getCurrAppName())?sessionCO.getCurrentAppName():criteria.getCurrAppName());
	    PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
	    criteria.setProfType(NumberUtil.nullToZero(pthCtrl.getPOP_PROF_MOD_ACCESS()));

	    	if(StringUtil.nullToEmpty(criteria.getCurrAppName()).isEmpty())
            {
               criteria.setCurrAppName(null);	
            }
	    if(getRecords() == 0)
	    {
		setRecords(usrBO.getUsrReportsCount(criteria));
	    }
	    UsrReportsList = usrBO.getUsrReportsList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(UsrReportsList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of BranchesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @param usrBO the usrBO to set
     */
    public void setUsrBO(UsrBO usrBO)
    {
        this.usrBO = usrBO;
    }

    /**
     * @return the usrReportsList
     */
    public List<UsrCO> getUsrReportsList()
    {
        return UsrReportsList;
    }

    /**
     * @param usrReportsList the usrReportsList to set
     */
    public void setUsrReportsList(List<UsrCO> usrReportsList)
    {
        UsrReportsList = usrReportsList;
    }


}
