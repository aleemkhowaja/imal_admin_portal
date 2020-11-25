package com.path.actions.common.dashboard;

import java.util.ArrayList;
import java.util.Date;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.dashboardportal.DashboardPortalBO;
import com.path.bo.common.login.LoginBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dashboardportal.DashboardPortalSC;
import com.path.vo.core.ctsteller.CTSTELLERSC;

public class PortalDashboardListAction extends GridBaseAction
{
    private LoginBO loginBO;
    private DashboardPortalBO dashboardPortalBO;
    private final CTSTELLERSC ctsTellerSC = new CTSTELLERSC();
    
    public Object getModel()
    {
	return ctsTellerSC;
    }
    
    public String loadUnstldNotTransCashBal()
    {
	set_searchGridId("unstldTransCashBalTbl_Id");
	return "loadUnstldTransCashBal";
    }
    /***
     * Method for populating the Logged in users list
     * 
     * @return String
     */
    public String unstldTransCashBalGridData()
    {
    	try
    	{
    	    //returnLoggedInUsers
    	    String[] searchCols = {"USER_ID","USR_FULL_NAME","PRIVILEGE_LEVEL_DESC"};
    	    SessionCO sessionCO = returnSessionObject();
    	    DashboardPortalSC criteria = new DashboardPortalSC(); 
    	    copyproperties(criteria);
    	    criteria.setSearchCols(searchCols);
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setBranchCode(sessionCO.getBranchCode());
            criteria.setLanguage(sessionCO.getLanguage()); 
            criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
            criteria.setAppName(sessionCO.getCurrentAppName());
            /**
             * return CSM running date in case the application is IBIS 
             */
            Date RunDate  = ConstantsCommon.IBIS_APP_NAME.equals(sessionCO.getCurrentAppName())?loginBO.returnRunningDate(criteria.getCompCode(), criteria.getBranchCode(), ConstantsCommon.RET_APP_NAME):sessionCO.getRunningDateRET();
            criteria.setRunningDate(RunDate); 
            
    	    if(checkNbRec(ctsTellerSC))
    	    {
    		setRecords(dashboardPortalBO.unstldNotTransCashBalCount(criteria));
    	    }
    	    ArrayList<UsrCO> usersList = (ArrayList<UsrCO>)dashboardPortalBO.unstldNotTransCashBalList(criteria);
    	    setGridModel(usersList);
    	}
    	catch(Exception e)
    	{
    	    handleException(e, null, null);
    	}
    	return SUCCESS;
    }
    
    /***
     * Method for populating the Logged in users list grid
     * 
     * @return String
     */
    public String loadLoggedInUsersGrid()
    {
	return "loadLoggedInUsrs";
    }
    
    /***
     * Method for populating the Logged in users list
     * 
     * @return String
     */
    public String loadLoggedInUsersGridData()
    {
    	try
    	{
    	    //returnLoggedInUsers
    	    String[] searchCols = {"USER_ID","LONG_NAME_ENG","PRIVILEGE_LEVEL_DESC"};
    	    SessionCO sessionObject = returnSessionObject();
    	    ctsTellerSC.setCompCode(sessionObject.getCompanyCode());
    	    ctsTellerSC.setBranchCode(sessionObject.getBranchCode());
    	    ctsTellerSC.setSearchCols(searchCols);
    	    ctsTellerSC.setLanguage(sessionObject.getLanguage());
    	    ctsTellerSC.setPreferredLanguage(sessionObject.getLanguage());
    	    ctsTellerSC.setAppName(ConstantsCommon.RET_APP_NAME);
    	    copyproperties(ctsTellerSC);
    	    ctsTellerSC.setOverPassFlag(ConstantsCommon.ONE);
    	    if(checkNbRec(ctsTellerSC))
    	    {
    		setRecords(loginBO.returnLoggedInUsersListCount(ctsTellerSC));
    	    }
    	    ArrayList<UsrCO> loggedInUsers = (ArrayList<UsrCO>) loginBO
    		    .returnLoggedInUsersList(ctsTellerSC);
    	    setGridModel(loggedInUsers);
    	}
    	catch(Exception e)
    	{
    	    handleException(e, null, null);
    	}
    	return SUCCESS;
    }

    public void setLoginBO(LoginBO loginBO)
    {
        this.loginBO = loginBO;
    }
    /**
     * @param dashboardPortalBO the dashboardPortalBO to set
     */
    public void setDashboardPortalBO(DashboardPortalBO dashboardPortalBO)
    {
        this.dashboardPortalBO = dashboardPortalBO;
    }    
}
