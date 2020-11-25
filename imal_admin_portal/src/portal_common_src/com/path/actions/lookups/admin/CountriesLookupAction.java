package com.path.actions.lookups.admin; 

import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.admin.countries.CountriesBO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.countries.CountriesSC;
import com.path.vo.common.SessionCO;

public class CountriesLookupAction extends LookupBaseAction
{

    private CountriesBO countriesBO;
    private CountriesSC countriesSC = new CountriesSC();

    /**
     * 
     */
    public Object getModel()
    {
	return countriesSC;
    }

    /**
     * Construct Countries Lookup based on the VO returned in the resultMap.
     * 
     * @return
     */
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "COUNTRY_CODE","BRIEF_DESC_ENG", "BRIEF_DESC_ARAB", "LONG_DESC_ENG", "LONG_DESC_ARAB" ,"TELEPHONE_FORMAT", "ISO_COUNTRY"};
	    String[] colType = { "number", "text", "text", "text", "text","text" ,"text"};
	    String[] titles = { getText("Code_key"),getText("Brief_Desc_Eng_key"),getText("Brief_Desc_Arab_key") 
		    , getText("Long_Desc_Eng_key"),getText("Long_Desc_Arab_key"),getText("telephone_format_key"), getText("isocurrencycode_key") };
	    
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "COUNTRY_CODE","BRIEF_DESC_ENG", "LONG_DESC_ENG", "TELEPHONE_FORMAT", "ISO_COUNTRY"};
		colType = new String[] { "number", "text", "text", "text", "text"};
		titles = new String[] { getText("Code_key"),getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key") ,getText("telephone_format_key"), getText("isocurrencycode_key")};
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("establishment_place_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CountriesLookup_fillCountriesLookup");
	    lookup(grid, countriesSC, name,  colType,  titles );
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of CountriesLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup for CountriesLookup data filtered by the defined criteria
     * 
     * @return
     * @throws JSONException
     */
    public String fillCountriesLookup() 
    {
	try
	{
	    setSearchFilter(countriesSC);
	    copyproperties(countriesSC);
	    SessionCO sessionCO = returnSessionObject();
	    countriesSC.setCompCode(sessionCO.getCompanyCode());

	    if(checkNbRec(countriesSC))
	    {
		setRecords(countriesBO.countriesListCount(countriesSC));
	    }
	    List<COUNTRIESVO> countriesVOList = countriesBO.countriesList(countriesSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(countriesVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of CountriesLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public CountriesSC getcountriesSC()
    {
	return countriesSC;
    }

    public void setcountriesSC(CountriesSC countriesSC)
    {
	this.countriesSC = countriesSC;
    }

    public void setCountriesBO(CountriesBO countriesBO)
    {
	this.countriesBO = countriesBO;
    }

}
