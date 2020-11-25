/**
 * 
 */
package com.path.actions.lookups.admin;

import java.util.List;

import com.path.bo.admin.smartaddoption.SmartAddOptionsBO;
import com.path.dbmaps.vo.S_ADDITIONS_OPTIONSVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.smartaddoption.SmartAddOptionsSC;
import com.path.vo.common.SessionCO;

/**
 * @author raees
 * 
 */
public class SmartAddOptionsLookupAction extends LookupBaseAction
{
    private SmartAddOptionsSC smartAddOptionsSC = new SmartAddOptionsSC();
    private SmartAddOptionsBO smartAddOptionsBO;

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "OPTION_SERIAL", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB", "LONG_NAME_ARAB",
		    "OPTION_CODE" };
	    String[] colType = { "number", "text", "text", "text", "text", "number" };
	    String[] titles = { getText("Option_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key"), getText("Option_key") };
	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "OPTION_SERIAL", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "OPTION_CODE" };
		colType = new String[] { "number", "text", "text", "number" };
		titles = new String[] { getText("Option_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key"), getText("Option_key") };
	    }
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Select_Option_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/SmartAddOptions_fillSmartAddOptionsLookup");

	    lookup(grid, smartAddOptionsSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of SmartAddOptionsLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Smart Fields filtered by the defined criteria
     * 
     * @return String
     */
    public String fillSmartAddOptionsLookup()
    {
	try
	{
	    setSearchFilter(smartAddOptionsSC);
	    copyproperties(smartAddOptionsSC);
	    SessionCO sessionCO = returnSessionObject();
	    smartAddOptionsSC.setCompCode(sessionCO.getCompanyCode());

	    if(getRecords() == 0)
	    {
		setRecords(smartAddOptionsBO.returnSmartAddOptionsListCount(smartAddOptionsSC));
	    }
	    List<S_ADDITIONS_OPTIONSVO> smartAddOptionsVOList = smartAddOptionsBO
		    .returnSmartAddOptionsList(smartAddOptionsSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(smartAddOptionsVOList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillSmartAddOptionsLookup of SmartAddOptionsLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @return the smartAddOptionsSC
     */
    public Object getModel()
    {
	return smartAddOptionsSC;
    }

    /**
     * @return the smartAddOptionsSC
     */
    public SmartAddOptionsSC getSmartAddOptionsSC()
    {
	return smartAddOptionsSC;
    }

    /**
     * @param smartAddOptionsSC the smartAddOptionsSC to set
     */
    public void setSmartAddOptionsSC(SmartAddOptionsSC smartAddOptionsSC)
    {
	this.smartAddOptionsSC = smartAddOptionsSC;
    }

    /**
     * @param smartAddOptionsBO the smartAddOptionsBO to set
     */
    public void setSmartAddOptionsBO(SmartAddOptionsBO smartAddOptionsBO)
    {
	this.smartAddOptionsBO = smartAddOptionsBO;
    }
}
