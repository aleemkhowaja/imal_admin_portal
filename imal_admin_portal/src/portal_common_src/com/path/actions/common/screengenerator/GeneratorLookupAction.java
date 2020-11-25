/**
 * 
 */
package com.path.actions.common.screengenerator;

import java.math.BigDecimal;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.screengenerator.ScreenGeneratorBO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.screengenerator.DynScrTableColsCO;
import com.path.vo.common.screengenerator.DynScrTablesCO;
import com.path.vo.common.screengenerator.DynamicScreenCreatorCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;

/**
 * @author MarwanMaddah
 * 
 */
public class GeneratorLookupAction extends LookupBaseAction
{
    private ScreenGeneratorSC criteria = new ScreenGeneratorSC();
    private ScreenGeneratorBO screenGeneratorBO;
    private List<DynScrTablesCO> scrTablesList;
    private List<DynScrTableColsCO> scrTablesColsList;
    private List<DynamicScreenCreatorCO> globalActivityList;
    private List<DynamicScreenCreatorCO> restOperationList;
    private List<DynamicScreenCreatorCO> operationOutParameterList;

    /**
	 * 
	 */
    @Override
    public Object getModel()
    {
	return criteria;
    }
       
    public String drawingScrTablesGrid()
    {
 	try
 	{
 	    String[]  name    = {"TABLE_ID", "TABLE_TECH_NAME", "TABLE_DESC"};
 	    String[]  colType = {"number", "text", "text"};
 	    Boolean[] hidden  = {true,false,false};
 	    String[]  titles  = {getText("id_key"),getText("table_tech_name_key"), getText("table_desc_key")};
 	    
 	    /**
 	     * Defining The Grid ...
 	     */
 	    LookupGrid grid = new LookupGrid();
 	    grid.setCaption(getText("table_list_key"));
 	    grid.setRowNum("5");
 	    grid.setUrl("/path/screenGenerator/generatorLookupAction_scrTablesGridLkp");
 	    int cols = name.length;
 	    
 	    lookup(grid,criteria,name, colType, titles);
 	}
 	catch(Exception ex)
 	{
 	    ex.printStackTrace();
 	}
 	return SUCCESS;
    }
    
    /**
     * prepare data of the template lookup in the generator management ...
     * 
     * @return
     */
    public String scrTablesGridLkp() throws Exception
    {
 	try
 	{
 	    setSearchFilter(criteria);
 	    // Get the data from BO
 	    copyproperties(criteria);
 	    setRecords(screenGeneratorBO.dynScrGeneratedTblListCount(criteria));
 	    scrTablesList = screenGeneratorBO.dynScrGeneratedTblList(criteria);
 	    setGridModel(scrTablesList);
 	}
 	catch(Exception ex)
 	{
 	    throw new JSONException("Error Loading Screen Tables Grid"+ex.getMessage());
 	}
 	return SUCCESS;
    }
    //Rabih
    public String drawingScrColsGrid()
    {
 	try
 	{
 	    String[]  name    = {"COL_ID", "COL_TECH_NAME", "COL_DESC"};
 	    String[]  colType = {"number", "text", "text"};
 	    //Boolean[] hidden  = {true,false,false};
 	    String[]  titles  = {getText("id_key"),getText("table_tech_name_key"), getText("table_desc_key")};
 	    
 	    /**
 	     * Defining The Grid ...
 	     */
 	    LookupGrid grid = new LookupGrid();
 	    grid.setCaption(getText("table_list_key"));
 	    grid.setRowNum("5");
 	    grid.setUrl("/path/screenGenerator/generatorLookupAction_scrColsGridLkp");
 	    //int cols = name.length;
 	    
 	    lookup(grid,criteria,name, colType, titles);
 	}
 	catch(Exception ex)
 	{
 	    ex.printStackTrace();
 	}
 	return SUCCESS;
    }
    
    /**
     * prepare data of the template lookup in the generator management ...
     * 
     * @return
     */
    public String scrColsGridLkp() throws Exception
    {
 	try
 	{
 	    setSearchFilter(criteria);
 	    // Get the data from BO
 	    copyproperties(criteria);
 	    setRecords(screenGeneratorBO.dynScrTablesListCount(criteria));
 	   scrTablesColsList = screenGeneratorBO.dynScrTablesList(criteria);
 	    setGridModel(scrTablesColsList);
 	}
 	catch(Exception ex)
 	{
 	    throw new JSONException("Error Loading Screen Tables Grid"+ex.getMessage());
 	}
 	return SUCCESS;
    }

    //Rabih
    /**
     * 
     * @return
     */
    public String depScreenDesc()
    {
	try{
	    SYS_PARAM_SCREEN_DISPLAYVO lookupDisplay = new SYS_PARAM_SCREEN_DISPLAYVO();
	    lookupDisplay.setELEMENT_ID("lookuptxt_dynScreenTableNameId");
	    lookupDisplay.setIS_READONLY(BigDecimal.ONE);
	    getAdditionalScreenParams().put("lookuptxt_dynScreenTableNameId", lookupDisplay);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    /**
     * @param screenGeneratorBO the screenGeneratorBO to set
     */
    public void setScreenGeneratorBO(ScreenGeneratorBO screenGeneratorBO)
    {
        this.screenGeneratorBO = screenGeneratorBO;
    }

    /**
     * @return the criteria
     */
    public ScreenGeneratorSC getCriteria()
    {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(ScreenGeneratorSC criteria)
    {
        this.criteria = criteria;
    }
    /**
     * @author Muhammad.Asif
     * This method is used to construct Global Activity LIVESEARCH 
     * @param 
     * @return String 
     */
    public String loadGlobalActivityGrid() throws Exception
    {
 	try
 	{
 		String[]  name    = {"globalActivityId", "globalActivityDesc"};
 	    String[]  colType = {"number", "text"};
 	    //Boolean[] hidden  = {true,false,false};
 	    String[]  titles  = {getText("id_key"),getText("description_key")};
 	    
 	    /**
 	     * Defining The Grid ...
 	     */
 	    LookupGrid grid = new LookupGrid();
 	    grid.setCaption(getText("globalActivityList_key"));
 	    grid.setRowNum("5");
 	    grid.setUrl("/path/screenGenerator/generatorLookupAction_srcColsGlobalActivityLkp");
 	    
 	    lookup(grid,criteria,name, colType, titles); 	    
 	}
 	catch(Exception ex)
 	{
 	    throw new JSONException("Error Loading Global Activity Grid"+ex.getMessage());
 	}
 	return SUCCESS;
    }
    
    /**
     * @author Muhammad.Asif
     * This method is used to fill Global Activity LIVESEARCH data. 
     * @param 
     * @return String 
     */
    public String srcColsGlobalActivityLkp() throws Exception
    {
 	try
 	{
 		setSearchFilter(criteria);
	    // Get the data from BO
	    copyproperties(criteria);
	    setRecords(screenGeneratorBO.loadGlobalActivityGridCount(criteria));
	    globalActivityList = screenGeneratorBO.loadGlobalActivityGrid(criteria);
	    
	    setGridModel(globalActivityList);
 	}
 	catch(Exception ex)
 	{
 	    throw new JSONException("Error Loading Global Activity Grid"+ex.getMessage());
 	}
 	return SUCCESS;
    }
    
    /**
     * @author Muhammad.Asif
     * This method is used to construct Rest Operation LIVESEARCH 
     * @param 
     * @return String 
     */
    public String loadRestOperation() throws Exception
    {
 	try
 	{
 		String[]  name    = {"restOperationId", "restOperationDesc"};
 	    String[]  colType = {"number", "text"};
 	    //Boolean[] hidden  = {true,false,false};
 	    String[]  titles  = {getText("id_key"),getText("description_key")};
 	    
 	    /**
 	     * Defining The Grid ...
 	     */
 	    LookupGrid grid = new LookupGrid();
 	    grid.setCaption(getText("restOperationList_key"));
 	    grid.setRowNum("5");
 	    grid.setUrl("/path/screenGenerator/generatorLookupAction_srcColsRestOperationLkp");
 	    
 	    lookup(grid,criteria,name, colType, titles); 	    
 	}
 	catch(Exception ex)
 	{
 	    throw new JSONException("Error Loading Rest Operation Grid"+ex.getMessage());
 	}
 	return SUCCESS;
    }
    /**
     * @author Muhammad.Asif
     * This method is used to fill Rest Operation LIVESEARCH data  
     * @param 
     * @return String 
     */
    public String srcColsRestOperationLkp() throws Exception
    {
 	try
 	{
 		setSearchFilter(criteria);
	    // Get the data from BO
	    copyproperties(criteria);
	    setRecords(screenGeneratorBO.loadRestOperationCount(criteria));
	    restOperationList = screenGeneratorBO.loadRestOperation(criteria);
	    
	    setGridModel(restOperationList);
 	}
 	catch(Exception ex)
 	{
 	    throw new JSONException("Error Loading Rest Operations "+ex.getMessage());
 	}
 	return SUCCESS;
    }
    /**
     * @author Muhammad.Asif
     * This method is used to construct LIVESEARCH for Operation out parameter  
     * @param 
     * @return String 
     */
    public String loadOperationOutParameter() throws Exception
    {
 	try
 	{
 		String[]  name    = {"operationOutParameter", "operationOutParameterDesc"};
 	    String[]  colType = {"number", "text"};
 	    String[]  titles  = {getText("id_key"),getText("description_key")};
 	    /**
 	     * Defining The Grid ...
 	     */
 	    LookupGrid grid = new LookupGrid();
 	    grid.setCaption(getText("restOperationList_key"));
 	    grid.setRowNum("5");
 	    grid.setUrl("/path/screenGenerator/generatorLookupAction_srcColsOperationOutParameterLkp");
 	    
 	    lookup(grid,criteria,name, colType, titles); 	    
 	}
 	catch(Exception ex)
 	{
 	    throw new JSONException("Error Loading Operation Out Parameter"+ex.getMessage());
 	}
 	return SUCCESS;
    }
    /**
     * @author Muhammad.Asif
     * This method is used to fill data of LIVESEARCH for Operation out parameter  
     * @param 
     * @return String 
     */
    public String srcColsOperationOutParameterLkp() throws Exception
    {
 	try
 	{
 		setSearchFilter(criteria);
	    copyproperties(criteria);
	    criteria.setNbRec(-1);
	    setRecords(screenGeneratorBO.loadOperationOutParameterCount(criteria));
	    operationOutParameterList= screenGeneratorBO.loadOperationOutParameter(criteria);
	    
	    setGridModel(operationOutParameterList);
 	}
 	catch(Exception ex)
 	{
 	    throw new JSONException("Error Loading Operation Out Parameter Grid"+ex.getMessage());
 	}
 	return SUCCESS;
    }
}
