/**
 * 
 */
package com.path.actions.common.statuscustomization;

import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.statuscustomization.StatusCustomizationBO;
import com.path.dbmaps.vo.SYS_PARAM_LOV_TYPEVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.statuscustomization.StatusCustomizationCO;
import com.path.vo.common.statuscustomization.StatusCustomizationSC;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * UserReportsLookupAction.java used to
 */
public class StatusCustLookupAction extends LookupBaseAction
{
    private final StatusCustomizationSC criteria = new StatusCustomizationSC();
    private StatusCustomizationBO       statusCustomizationBO;
    private List<StatusCustomizationCO> statusList;
    private List<SYS_PARAM_LOV_TYPEVO>  lovList;
    private String                      actionType;
    @Override
    public Object getModel()
    {
	return criteria;
    }
    
    public String constructLookup()
    {
	try
	{
	    if(NumberUtil.isEmptyDecimal(criteria.getLovTypeId()))
	    {
		throw new BOException(getText("define_lov_type_key"));
	    }
	    if(StringUtil.nullToEmpty(criteria.getProgRef()).isEmpty())
	    {
		throw new BOException(getText("select_screen_key"));
	    }
	    // Design the Grid by defining the column model and column names
	    String[] name = {"STATUS_CODE","STATUS_DESC"};
	    String[] colType = {"text","text"};
	    String[] titles = {getText("Code_key"),getText("status.status_desc")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("status_list_key"));
	    grid.setRowNum("5");
	    grid.setShrinkToFit("true");
	    grid.setUrl("/path/statusCustomization/StatusCustLookup_fillLookupStatusCust");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the status lookup.
     * 
     * @return
     * @throws JSONException
     */
    public String fillLookupStatusCust()
    {
	try
	{
	    criteria.setSearchCols(new String[]{"STATUS_CODE","STATUS_DESC"});
	    setSearchFilter(criteria);
	    // Get the data from BO
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    
	    criteria.setUserId(sessionCO.getUserName());
            criteria.setCurrAppName(sessionCO.getCurrentAppName());
            if(StringUtil.nullToEmpty(actionType).equals(ConstantsCommon.ACTION_TYPE_SAVE_NEW))
            {
               criteria.setCheckExistence("1");
            }
            else
            {
        	criteria.setCheckExistence("0");
            }
	    if(getRecords() == 0)
	    {
		setRecords(statusCustomizationBO.statusLookupLkpCount(criteria));
	    }
	    statusList = statusCustomizationBO.statusLookupLkpRecords(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(statusList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public String constructLovLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = {"LOV_TYPE_ID","LOV_TYPE_DESCRIPTION"};
	    String[] colType = {"text","text"};
	    String[] titles = {getText("Code_key"),getText("desc_eng_key")};
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("lov_list_key"));
	    grid.setRowNum("5");
	    grid.setShrinkToFit("true");
	    grid.setUrl("/path/statusCustomization/StatusCustLookup_fillLookupLovStatusCust");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    
    /**
     * Fill the lov lookup.
     * 
     * @return
     * @throws JSONException
     */
    public String fillLookupLovStatusCust()
    {
	try
	{
	    criteria.setSearchCols(new String[]{"LOV_TYPE_ID","LOV_TYPE_DESCRIPTION"});
	    setSearchFilter(criteria);
	    // Get the data from BO
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    
	    if(getRecords() == 0)
	    {
		setRecords(statusCustomizationBO.statusLovLookupCount(criteria));
	    }
	    lovList = statusCustomizationBO.statusLovLookupRecords(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(lovList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @return the statusList
     */
    public List<StatusCustomizationCO> getStatusList()
    {
        return statusList;
    }

    /**
     * @param statusList the statusList to set
     */
    public void setStatusList(List<StatusCustomizationCO> statusList)
    {
        this.statusList = statusList;
    }

    /**
     * @return the criteria
     */
    public StatusCustomizationSC getCriteria()
    {
        return criteria;
    }

    /**
     * @param statusCustomizationBO the statusCustomizationBO to set
     */
    public void setStatusCustomizationBO(StatusCustomizationBO statusCustomizationBO)
    {
        this.statusCustomizationBO = statusCustomizationBO;
    }

    /**
     * @return the lovList
     */
    public List<SYS_PARAM_LOV_TYPEVO> getLovList()
    {
        return lovList;
    }

    /**
     * @param lovList the lovList to set
     */
    public void setLovList(List<SYS_PARAM_LOV_TYPEVO> lovList)
    {
        this.lovList = lovList;
    }

    /**
     * @return the actionType
     */
    public String getActionType()
    {
        return actionType;
    }

    /**
     * @param actionType the actionType to set
     */
    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }


}
