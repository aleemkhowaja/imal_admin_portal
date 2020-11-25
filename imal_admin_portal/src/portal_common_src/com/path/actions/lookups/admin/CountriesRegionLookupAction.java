package com.path.actions.lookups.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.admin.countriesregion.CountriesRegionBO;
import com.path.dbmaps.vo.COUNTRIES_REGIONVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.countriesregion.CountriesRegionSC;
import com.path.vo.common.SessionCO;

public class CountriesRegionLookupAction extends LookupBaseAction
{

    private CountriesRegionSC criteria = new CountriesRegionSC();
    private CountriesRegionBO countriesRegionBO;
    private BigDecimal COUNTRY_CODE;

    public Object getModel()
    {
	return criteria;
    }

    public String constructLookup()
    {
	try
	{ 
	    // Design the Grid by defining the column model and column names
	    String[] name = { "REGION_CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB", };
	    String[] colType = { "number", "text", "text", "text", "text" };
	    String[] titles = { getText("Region_Code_key"), getText("Brief_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Eng_key"), getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "REGION_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG" };
		colType = new String[] { "number", "text", "text" };
		titles = new String[] { getText("Region_Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Region_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CountriesRegion_fillCountriesRegionLookup");

	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CountriesRegionLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup Countries Region data filtered by the defined criteria
     * 
     * @return
     */
    public String fillCountriesRegionLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setCountry_code(COUNTRY_CODE);
	    List<COUNTRIES_REGIONVO> regionVOList = new ArrayList<COUNTRIES_REGIONVO>();
	    if(!NumberUtil.isEmptyDecimal(COUNTRY_CODE))
	    {
		if(getRecords() == 0)
		{
		    setRecords(countriesRegionBO.countriesRegionListCount(criteria));
		}
		regionVOList = countriesRegionBO.countriesRegionList(criteria);
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(regionVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillCountriesRegionLookup of CountriesRegionLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public CountriesRegionSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CountriesRegionSC criteria)
    {
	this.criteria = criteria;
    }

    public void setCountriesRegionBO(CountriesRegionBO countriesRegionBO)
    {
	this.countriesRegionBO = countriesRegionBO;
    }

    public BigDecimal getCOUNTRY_CODE()
    {
	return COUNTRY_CODE;
    }

    public void setCOUNTRY_CODE(BigDecimal cOUNTRYCODE)
    {
	COUNTRY_CODE = cOUNTRYCODE;
    }

}
