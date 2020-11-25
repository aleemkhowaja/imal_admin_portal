package com.path.actions.lookups.admin;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.dynfiles.DynFilesBO;
import com.path.dbmaps.vo.DF_FILE_TAG_INP_PARAMVO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynfiles.DynFilesSC;

public class TagValueLookupAction extends LookupBaseAction
{
    private DynFilesBO dynFilesBO;
    private DynFilesSC dynFilesSC;
    private DF_FILE_TAG_INP_PARAMVO dfFileTagParamVO;

    public String tagLookupDef()
    {
	try
	{
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    String[] name = { "INP_PARAM_DISP_VALUE", "INP_PARAM_DATA_VALUE" };
	    String[] colType = { "text", "text" };
	    String[] titles = { "Tag Value", "Tag Data value" };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");

	    grid.setUrl("/pathdesktop/TagValueLookup_loadTagLookupData");
	    int cols = name.length;

	    for(int i = 0; i < cols; i++)
	    {
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		gridColumn.setWidth("300");
		if(name[i].equals("INP_PARAM_DATA_VALUE"))
		{
		    gridColumn.setHidden(true);
		}

		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, dynFilesSC);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of Tag value lookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup branch data filtered by user.
     * 
     * @return
     */
    public String loadTagLookupData()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    setSearchFilter(dynFilesSC);
	    copyproperties(dynFilesSC);
	    dynFilesSC.setCompCode(sessionCO.getCompanyCode());
	    dynFilesSC.setBranchCode(sessionCO.getBranchCode());
	    dynFilesSC.setUserId(sessionCO.getUserName());
	    dynFilesSC.setAppName(sessionCO.getCurrentAppName());

	    setGridModel(dynFilesBO.returnDynFilesTagDisplayValues(dynFilesSC));
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loading Tag Value lookup, loadTagLookupData");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String dependencyByInputTagValue()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    dynFilesSC.setCompCode(sessionCO.getCompanyCode());
	    dynFilesSC.setBranchCode(sessionCO.getBranchCode());
	    dynFilesSC.setUserId(sessionCO.getUserName());
	    dynFilesSC.setAppName(sessionCO.getCurrentAppName());
	    dfFileTagParamVO = dynFilesBO.getInputTagValues(dynFilesSC);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByInputTagValue");
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

    public void setDfFileTagParamVO(DF_FILE_TAG_INP_PARAMVO dfFileTagParamVO)
    {
	this.dfFileTagParamVO = dfFileTagParamVO;
    }

    public DF_FILE_TAG_INP_PARAMVO getDfFileTagParamVO()
    {
	return dfFileTagParamVO;
    }
}
