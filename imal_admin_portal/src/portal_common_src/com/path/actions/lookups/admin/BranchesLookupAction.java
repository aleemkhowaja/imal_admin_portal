package com.path.actions.lookups.admin;

import java.math.BigDecimal;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.admin.branches.BranchesBO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.branches.BranchesSC;
import com.path.vo.common.SessionCO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author GhenoieSaab
 * 
 *         BranchesLookupAction.java used to load Branch Lookup
 */
public class BranchesLookupAction extends LookupBaseAction
{
    private final BranchesSC branchesSC = new BranchesSC();
    private List<BRANCHESVO> branchesVOList;
    private BigDecimal fromVaultCode;
    BRANCHESVO temp;
    private BranchesBO branchesBO;

    @Override
    public Object getModel()
    {
	return branchesSC;
    }

    /**
     * Construct Branch Lookup
     * 
     * @return
     */
    public String constructLookup()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "BRANCH_CODE", "BRIEF_DESC_ENG" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("branchCode"), getText("briefDesc") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("branches.branchList"));
	    grid.setRowNum("5");
	    grid.setShrinkToFit("true");
	    grid.setUrl("/pathdesktop/BranchesByUsrLookup_fillLookupBranchByUsr");
	    lookup(grid, branchesSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of BranchesLookupAction");
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
    public String fillLookupBranchByUsr()
    {
	try
	{
	    setSearchFilter(branchesSC);
	    // Get the data from BO
	    copyproperties(branchesSC);

	    SessionCO sessionCO = returnSessionObject();
	    branchesSC.setUserId(sessionCO.getUserName());
	    if ("ACCOUNT".equals(branchesSC.getScreenName()))
	    {
                branchesSC.setAllowMultiBr(sessionCO.getCtsTellerVO().getENABLE_MULTI_BR_ACC_CREAT_YN());    
	    }
	    
	    if(branchesSC.getCompCode() == null)
	    {
		 branchesSC.setCompCode(sessionCO.getCompanyCode());
	    }
	    
	    if(getRecords() == 0)
	    {
		setRecords(branchesBO.getBranchesByUsrCount(branchesSC));
	    }
	    branchesVOList = branchesBO.getBranchesByUsrList(branchesSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(branchesVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of BranchesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Construct Branch Lookup
     * 
     * @return
     */
    public String constructLookupByCompCode()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "BRANCH_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB",
		    "REMARK", "BASE_CURRENCY" };
	    String[] colType = { "number", "text", "text", "text", "text", "text", "number" };
	    String[] titles = { getText("branchCode"), getText("briefDesc"), getText("Long_Description_key"),
		    getText("Brief_Name_Arab_key"), getText("Long_Desc_Arab_key"), getText("remarks_key"),
		    getText("Currency_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("branches.branchList"));
	    grid.setRowNum("5");
//	    grid.setShrinkToFit("true");
	    grid.setUrl("/pathdesktop/BranchesByUsrLookup_fillLookupBranchByCompCode");
	    List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
	    columnSpecs.get(0).setLeadZeros("4");
	    lookup(grid, columnSpecs, null, branchesSC);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookupByCompCode of BranchesLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup branch data filtered by CompCode.
     * 
     * @return
     * @throws JSONException
     */
    public String fillLookupBranchByCompCode()
    {
	try
	{
	    setSearchFilter(branchesSC);
	    // Get the data from BO
	    copyproperties(branchesSC);
	    // DASI170153
	    SessionCO sessionCO = returnSessionObject();
	    branchesSC.setBranchCode(sessionCO.getBranchCode());
	    /**
	     * the if condition was added by HanaaElJazzar for TrxTemplate
	     * Screen. If the company code was not sent to this method, then
	     * take it from the session. .
	     */
	    if(NumberUtil.isEmptyDecimal(branchesSC.getCompCode()))
	    {
		branchesSC.setCompCode(returnSessionObject().getCompanyCode());
	    }

	    if(getRecords() == 0)
	    {
		setRecords(branchesBO.getBranchesListCountByCompCode(branchesSC));
	    }
	    branchesVOList = branchesBO.getBranchesListByCompCode(branchesSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(branchesVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData by CompCode of BranchesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * PB : w_lookup_branch_comp
     */
    public String constructVaultBranchLookup()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "BRANCH_CODE", "BRIEF_DESC_ENG", "BASE_CURRENCY", "REMARK" };
	    String[] colType = { "number", "text", "number", "text" };
	    String[] titles = { getText("branchCode"), getText("briefDesc"), getText("Base_Currency_key"),
		    getText("Remark_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("branches.branchList"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/BranchesByUsrLookup_fillLookupBranchByCompCode");
	    lookup(grid, branchesSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of BranchesDestinationLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Construct Branch Lookup
     * 
     * @return
     */
    public String constructBranchLookupByCompCodeUnionAllBranches()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "BRANCH_CODE", "BRIEF_DESC_ENG" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("branchCode"), getText("Description_key") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("branches.branchList"));
	    grid.setRowNum("5");
	    grid.setShrinkToFit("true");
	    grid.setUrl("/pathdesktop/BranchesByUsrLookup_fillBranchLookupByCompCodeUnionAllBranches");
	    lookup(grid, branchesSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookupByCompCodeUnionAllBranches of BranchesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillBranchLookupByCompCodeUnionAllBranches()
    {
	try
	{
	    setSearchFilter(branchesSC);
	    copyproperties(branchesSC);
	    branchesSC.setCompCode(returnSessionObject().getCompanyCode());
	    if(getRecords() == 0)
	    {
		setRecords(branchesBO.getBranchesByCompCodeUnionAllBranchesCount(branchesSC));
	    }
	    branchesVOList = branchesBO.getBranchesByCompCodeUnionAllBranches(branchesSC);
	    if(branchesVOList != null && !branchesVOList.isEmpty())
	    {
		for(BRANCHESVO eachBranch : branchesVOList)
		{
		    if(eachBranch.getBRANCH_CODE().compareTo(BigDecimal.ZERO) == 0)
		    {
			eachBranch.setBRIEF_DESC_ENG(getText("all_branch_key"));
		    }
		}

	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(branchesVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData by CompCode of BranchesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setBranchesBO(BranchesBO branchesBO)
    {
	this.branchesBO = branchesBO;
    }
    
    public BigDecimal getFromVaultCode()
    {
        return fromVaultCode;
    }

    public void setFromVaultCode(BigDecimal fromVaultCode)
    {
        this.fromVaultCode = fromVaultCode;
    }

}