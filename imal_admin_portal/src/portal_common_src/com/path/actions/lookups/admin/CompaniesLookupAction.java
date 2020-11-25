package com.path.actions.lookups.admin;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.admin.companies.CompaniesBO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.companies.CompaniesSC;
import com.path.vo.common.SessionCO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author GhenoieSaab
 * 
 *         CompaniesLookupAction.java used to load Company Lookup
 */
public class CompaniesLookupAction extends LookupBaseAction
{
    
    private final CompaniesSC companiesSC = new CompaniesSC();
    private List<COMPANIESVO> companiesVOList;
    private CompaniesBO companiesBO;

    public Object getModel()
    {
	return companiesSC;
    }

    /**
     * Construct Company Lookup
     * 
     * @return
     */
    public String constructLookup()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "COMP_CODE", "BRIEF_DESC_ENG" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("compCode"), getText("briefDesc") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("companies.compList"));
	    grid.setRowNum("5");
	    grid.setShrinkToFit("true");
	    // coming from Statement of Account Section
	    if(StringUtil.nullToEmpty(get_pageRef()).equals("QUER001T"))
	    {
		grid.setUrl("/pathdesktop/CompaniesByUsrLookup_fillLookupCompany");
	    }
	    else
	    {
		grid.setUrl("/pathdesktop/CompaniesByUsrLookup_fillLookupCompanyByUsr");
	    }
	    
	    lookup(grid, companiesSC, name,  colType,  titles );
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CompaniesLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Company data filtered by user.
     * 
     * @return
     */
    public String fillLookupCompanyByUsr()
    {
	try
	{
	    setSearchFilter(companiesSC);
	    // Get the data from BO
	    copyproperties(companiesSC);

	    SessionCO sessionCO = returnSessionObject();
	    companiesSC.setUserId(sessionCO.getUserName());

	    if(getRecords() == 0)
	    {
		setRecords(companiesBO.getCompaniesByUsrCount(companiesSC));
	    }
	    companiesVOList = companiesBO.getCompaniesByUsrList(companiesSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(companiesVOList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupCompanyByUsr of CompaniesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillLookupCompany()
    {
	try
	{
	    setSearchFilter(companiesSC);
	    // Get the data from BO
	    copyproperties(companiesSC);

	    SessionCO sessionCO = returnSessionObject();
	    companiesSC.setUserId(sessionCO.getUserName());

	    if(getRecords() == 0)
	    {
		setRecords(companiesBO.getCompaniesCount(companiesSC));
	    }
	    companiesVOList = companiesBO.getCompaniesList(companiesSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(companiesVOList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupCompanyByUsr of CompaniesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setCompaniesBO(CompaniesBO companiesBO)
    {
	this.companiesBO = companiesBO;
    }

    /**
     * Construct Company Lookup Without need for userId..
     * 
     * @author HanaaElJazzar
     * @return String
     */
    public String constructLookupWithoutUserId()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "COMP_CODE", "BRIEF_DESC_ENG" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("compCode"), getText("briefDesc") };

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("companies.compList"));
	    grid.setRowNum("5");
	    grid.setShrinkToFit("true");
	    grid.setUrl("/pathdesktop/CompaniesByUsrLookup_fillLookupCompany");

	    lookup(grid, companiesSC, name,  colType,  titles );
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookupWithoutUserId of CompaniesLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    /**
     * w_lookup_company
     * @return
     */
    public String companyCurrLookup()
    {
	
	String[] columnArr[] = { { "companiesVO.COMP_CODE", "number", getText("Code__key") },
		{ "companiesVO.BRIEF_DESC_ENG", "text", getText("Brief_Name_key") },
		{ "companiesVO.LONG_DESC_ENG", "text", getText("Long_Name__key") },
		{ "currenciesVO.BRIEF_DESC_ENG", "text", getText("Base_Currency_key") },
		{ "companiesVO.REMARK", "text", getText("Remark_key") },
		{ "companiesVO.BRIEF_DESC_ARAB", "text", getText("Brief_Desc_Arab_key") },
		{ "companiesVO.LONG_DESC_ARAB", "text", getText("Long_Desc_Arab_key") } };
	try
	{
	    
	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		columnArr = new String[][] { { "companiesVO.COMP_CODE", "number", getText("Code__key") },
			{ "companiesVO.BRIEF_DESC_ENG", "text", getText("Brief_Name_key") },
			{ "companiesVO.LONG_DESC_ENG", "text", getText("Long_Name__key") },
			{ "currenciesVO.BRIEF_DESC_ENG", "text", getText("Base_Currency_key") },
			{ "companiesVO.REMARK", "text", getText("Remark_key") } };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Code__key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CompaniesByUsrLookup_fillCompanyCurrLookup");

	    LookupGridColumn gridColumn;
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    for(String[] col : columnArr)
	    {
		gridColumn = new LookupGridColumn();
		gridColumn.setName(col[0]);
		gridColumn.setIndex(col[0]);
		gridColumn.setColType(col[1]);
		gridColumn.setTitle(col[2]);
		gridColumn.setSearch(true);

		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, companiesSC);
	}
	catch(Exception e)
	{
		handleException(e, null, null);
	}

	return SUCCESS;
    }



    /**
     * Fill the lookup reason data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCompanyCurrLookup()
    {
	try
	{
	    setSearchFilter(companiesSC);
	    copyproperties(companiesSC);

	    if(getRecords() == 0)
	    {
		setRecords(companiesBO.getCompanyCurrLkpCount(companiesSC));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(companiesBO.getCompanyCurrLkpList(companiesSC));
	}
	catch(Exception e)
	{
		handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Construct Company Lookup from PPS Group Company
     * 
     * @author LValappil
     * @return String
     */
    public String constructPPSGroupCompaniesLookup()
    {
    	try
    	{
    		// Design the Grid by defining the column model and column names
    		String[] name = { "COMP_CODE", "BRIEF_DESC_ENG" };
    		String[] colType = { "number", "text" };
    		String[] titles = { getText("compCode"), getText("briefDesc") };
    		
    		// Defining the Grid
    		LookupGrid grid = new LookupGrid();
    		grid.setCaption(getText("companies.compList"));
    		grid.setRowNum("5");
    		grid.setShrinkToFit("true");
    		
    		// coming from Statement of Account Section
    		grid.setUrl("/pathdesktop/CompaniesByUsrLookup_fillPPSGroupCompaniesLookup");
    		
    		lookup(grid, companiesSC, name,  colType,  titles );
    	}
    	catch(Exception e)
    	{
    		log.error(e, "Error in constructPPSGroupCompaniesLookup of CompaniesLookupAction");
    		handleException(e, null, null);
    	}
    	return SUCCESS;
    }
    
    public String fillPPSGroupCompaniesLookup()
    {
    	try
    	{
    		setSearchFilter(companiesSC);
    		copyproperties(companiesSC);
    		
    		SessionCO sessionCO = returnSessionObject();
    		companiesSC.setCompCode(sessionCO.getCompanyCode());
    		companiesSC.setBranchCode(sessionCO.getBranchCode());
    		if(getRecords() == 0)
    		{
    			setRecords(companiesBO.getPPSGroupCompaniesCount(companiesSC));
    		}
    		companiesVOList = companiesBO.getPPSGroupCompaniesList(companiesSC);
    		// set the collection into gridModel attribute defined at JSP grid
    		setGridModel(companiesVOList);
    	}
    	catch(Exception e)
    	{
    		log.error(e, "Error in fillPPSGroupCompaniesLookup of CompaniesLookupAction");
    		handleException(e, null, null);
    	}
    	return SUCCESS;
    }
}
