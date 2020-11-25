/**
 * 
 */
package com.path.actions.common.customization;

import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.customization.CustomizationBO;
import com.path.dbmaps.vo.OPTVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.CustomizationSC;
import com.path.vo.common.customization.SavedAsScreensCO;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * saveAsSeriesListAction.java used to
 */
public class SaveAsSeriesListAction extends GridBaseAction
{
    private CustomizationBO customizationBO;
    private CustomizationSC criteria = new CustomizationSC();
    private SavedAsScreensCO savedAsScreensCO = new SavedAsScreensCO();


    public SavedAsScreensCO getSavedAsScreensCO() {
	return savedAsScreensCO;
    }


    public void setSavedAsScreensCO(SavedAsScreensCO savedAsScreensCO) {
	this.savedAsScreensCO = savedAsScreensCO;
    }


    /**
     * forward to OptSeriesList.jsp
     * @author marwanmaddah
     * @date   Sep 3, 2014
     * @return
     * @throws JSONException String
     *
     */
    public String loadSeriesPage() 
    {
	String result = "";
	try
	{
	    result = SUCCESS;
	}
	catch(Exception ex)
	{
	    ex.printStackTrace();
	}
	return result;
    }
    /**
     * Used to load the Grid inside OptSeriesList.jsp
     * @author marwanmaddah
     * @date   Sep 3, 2014
     * @return
     * @throws JSONException String
     *
     */
    public String loadSeriesOptsListGrid() throws JSONException
	{
	      String[] searchCol = {"PROG_REF","MENU_TITLE_ENG"};
	      try
		{
			/**
			 *  copy the details related to search criteria to the SC
			 */
		        SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
		        copyproperties(criteria);

		        criteria.setCompCode(sessionCO.getCompanyCode());
		        String appName = sessionCO.getCurrentAppName();
		        criteria.getScreenDispVO().setAPP_NAME(appName);
			criteria.setCutomizationPROG_REF(get_pageRef());
			
			
			criteria.setIvCrud(getIv_crud());
			/**
			 *  set number of rows to be displayed in the page of grid, and the
			 * total number of records for first time load only
			 */
			if(checkNbRec(criteria))
			{
			  setRecords(customizationBO.returnSeriesOptsListCount(criteria));
			}

			/**
			 *  return the collection of records
			 */
			List<OPTVO> seriesOptList = customizationBO.returnSeriesOptsListRecords(criteria);
			
			/**
			 *  set the collection into gridModel attribute defined at JSP grid tag
			 */
			setGridModel(seriesOptList);
			
		}
		catch(Exception e)
		{
			log.error(e, "Error in Opt Series List Grid");
			handleException(e, null, null);
		}
		return "jsonSuccess";
	}
    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(CustomizationSC criteria)
    {
        this.criteria = criteria;
    }
    
    /**
     * @return the criteria
     */
    public CustomizationSC getCriteria()
    {
        return criteria;
    }
    
    @Override
    public Object getModel()
    {
    	return criteria;
    }
    /**
     * @param customizationBO the customizationBO to set
     */
    public void setCustomizationBO(CustomizationBO customizationBO)
    {
        this.customizationBO = customizationBO;
    }


    /**
     * populate the saved screens grid
     * @author SimonRizkallah
     * @return String - if grid population was successful; otherwise it throws an Exception
     */
    public String populateDeleteSvdScrnsGrid()
    {
	try
	{
	    String[] searchCols = { "PROG_REF", "PROG_DESC", "PARENT_REF", "APP_NAME"};	     
	    criteria.setSearchCols(searchCols); 
 	    copyproperties(criteria);
	    SessionCO sessionObject = returnSessionObject();						
	    criteria.setAppName(sessionObject.getCurrentAppName());		
	    criteria.setOptUrl(ConstantsCommon.SAVED_AS_OPT_URL);			
	    criteria.setDynamicOpt(ConstantsCommon.DYNAMIC_OPT_SAVED_SCREEN);			
	    setRecords(customizationBO.returnSavedScreensCount(criteria));	
	    setGridModel(customizationBO.returnSavedScreensList(criteria));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
}
