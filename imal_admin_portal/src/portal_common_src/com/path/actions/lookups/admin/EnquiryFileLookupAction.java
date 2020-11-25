package com.path.actions.lookups.admin;

import com.path.bo.common.dynfiles.DynFilesBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynfiles.DynFilesSC;

public class EnquiryFileLookupAction extends LookupBaseAction
{
    private DynFilesSC dynFilesSC;
    private DynFilesBO dynFilesBO;

    public String enqFileLookupDef()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "dfDataFileVO.FILE_CODE", "dfDataFileVO.FILE_DESC" };
	    String[] colType = { "text", "text" };
	    String[] titles = { getText("File_Code_key"), getText("File_Name_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/EnqFileLookup_loadEnqLookupData");
	    lookup(grid, dynFilesSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of Enquiry File Lookup");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup branch data filtered by user.
     * 
     * @return
     */
    public String loadEnqLookupData()
    {
	try
	{
	    String[] searchCol = { "dfDataFileVO.FILE_CODE", "dfDataFileVO.FILE_DESC" };
	    dynFilesSC.setSearchCols(searchCol);
	    SessionCO sessionCO = returnSessionObject();
	    setSearchFilter(dynFilesSC);
	    copyproperties(dynFilesSC);
	    dynFilesSC.setCompCode(sessionCO.getCompanyCode());
	    dynFilesSC.setBranchCode(sessionCO.getBranchCode());
	    dynFilesSC.setUserId(sessionCO.getUserName());
	    dynFilesSC.setAppName(sessionCO.getCurrentAppName());
	    dynFilesSC.setProfType(NumberUtil.nullToZero(returnCommonLibBO().returnPthCtrl().getPOP_PROF_MOD_ACCESS()));
	    // dynFileSC.setStructType("2");

	    if(getRecords() == 0)
	    {
		setRecords(dynFilesBO.returnDynFilesListCount(dynFilesSC));
	    }

	    setGridModel(dynFilesBO.returnDynFilesList(dynFilesSC));
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loading Enquiry File lookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public DynFilesSC getDynFilesSC()
    {
	return dynFilesSC;
    }

    public void setDynFilesSC(DynFilesSC dynFileSC)
    {
	this.dynFilesSC = dynFileSC;
    }

    public Object getModel()
    {
	return dynFilesSC;
    }

    public void setDynFilesBO(DynFilesBO dynFilesBO)
    {
	this.dynFilesBO = dynFilesBO;
    }

}
