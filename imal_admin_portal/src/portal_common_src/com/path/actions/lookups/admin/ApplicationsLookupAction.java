package com.path.actions.lookups.admin;

import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.admin.applications.ApplicationsBO;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.applications.ApplicationsSC;
import com.path.vo.common.SessionCO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: deniskhaddad
 *
 * ApplicationsLookupAction.java used to for Application Lookup
 */
public class ApplicationsLookupAction extends LookupBaseAction
{
    private final ApplicationsSC applicationsSC = new ApplicationsSC();
    private ApplicationsBO applicationsBO;
    private String lang_spec;// used to receive from URL to specify whether LAnguage Specific display needed
    public Object getModel()
    {
	return applicationsSC;
    }

    /**
     * Construct Applications Lookup
     * 
     * @return
     */
    public String constructLookup()
    {
	try
	{
	 // Design the Grid by defining the column model and column names
	    String[] name = { "APP_NAME", "LONG_DESC", "LONG_DESC_AR", "LONG_DESC_FR", "APP_DESC", "APP_DESC_AR",
	    "APP_DESC_FR" };
	    String[] colType = { "text", "text", "text", "text", "text", "text", "text" };
    
	    String[] titles = { getText("application"), getText("Long_Desc_Eng_key"), getText("Long_Desc_Arab_key"),
        	    getText("Long_Desc_FR_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_Arab_key"),
        	    getText("Brief_Desc_FR_key") };
	    
	    SessionCO sessCo = returnSessionObject();
	    /* PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	       1=Arabic Hidden and English Mandatory, 2= Arabic Visible and Mandatory And English Mandatory
		, 3= Arabic Visible and Mandatory English Not Mandatory). */
	    if(sessCo.getHideArabicColumns())
	    {
		name = new String[]{ "APP_NAME", "LONG_DESC", "LONG_DESC_FR", "APP_DESC",  "APP_DESC_FR" };
		colType = new String[] { "text", "text", "text", "text", "text" };
		titles = new String[] { getText("application"), getText("Long_Desc_Eng_key"),
	        	    getText("Long_Desc_FR_key"), getText("Brief_Desc_Eng_key"), getText("Brief_Desc_FR_key") };
	    }
	    
	    String currLang = sessCo.getLanguage();
	    if(lang_spec != null && lang_spec.equals("1"))
	    {
		 colType = new String[] { "text", "text", "text" };
		if(ConstantsCommon.LANGUAGE_ARABIC.equals(currLang))
		{
		    name = new String[] { "APP_NAME", "LONG_DESC_AR", "APP_DESC_AR"};
		    titles = new String[] { getText("application"),getText("Long_Desc_Arab_key"),getText("Brief_Desc_Arab_key")};
		}
		else
		   if(ConstantsCommon.LANGUAGE_FRENCH.equals(currLang))  
		   {
		       name = new String[] { "APP_NAME", "LONG_DESC_FR", "APP_DESC_FR"};
		       titles = new String[] { getText("application"),getText("Long_Desc_FR_key"),getText("Brief_Desc_FR_key")};
		   }
		   else
		   {
		       name = new String[] { "APP_NAME", "LONG_DESC", "APP_DESC"};
		       titles = new String[] { getText("application"),getText("Long_Description_key"),getText("Brief_Description_key")};
		   }
	    }
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("application"));
	    grid.setRowNum("5");
	    grid.setShrinkToFit("true");
	    grid.setUrl("/pathdesktop/ApplicationsLookup_fillApplications");
	    lookup(grid, applicationsSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of ApplicationsLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup Application data.
     * 
     * @return
     * @throws JSONException
     */
    public String fillApplications() throws JSONException
    {
	try
	{
	    setSearchFilter(applicationsSC);
	    // Get the data from BO
	    copyproperties(applicationsSC);
	    
	    if(getRecords() == 0)
	    {
		setRecords(applicationsBO.returnApplicationCount(applicationsSC));
	    }
	    List<S_APPVO> applicationsVOList = applicationsBO.returnAplicationList(applicationsSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(applicationsVOList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillApplications of ApplicationsLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setApplicationsBO(ApplicationsBO applicationsBO)
    {
        this.applicationsBO = applicationsBO;
    }

    public void setLang_spec(String langSpec)
    {
        lang_spec = langSpec;
    }

}
