package com.path.actions.lookups.admin;

import java.util.List;

import com.path.bo.admin.category.CategoryBO;
import com.path.dbmaps.vo.OPT_CATEGORYVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.category.CategorySC;
import com.path.vo.common.SessionCO;

public class CategoryLookupAction extends LookupBaseAction
{
    private final CategorySC criteria = new CategorySC();
    private CategoryBO categoryBO;

    public Object getModel()
    {
	return criteria;
    }

    /**
     * Build a Grid inside the LiveSearch ...
     */
    public String constructCategLookup()
    {
	try
	{
	    String[] name = { "CATEG_ID", "CATEG_DESC_ENG"};
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("ID_key"), getText("category_key")};

	    /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("category_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/path/optCategory/categoryLookupAction_fillCategLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * This method is to get data from BO and load them in a grid inside the
     * liveSearch component.
     * 
     * @return
     */
    public String fillCategLookup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    
	    if(getRecords() == 0)
	    {
		setRecords(categoryBO.returnCategoryCount(criteria));
	    }
	    List<OPT_CATEGORYVO> elementsList = categoryBO.returnCategoryList(criteria);
	    setGridModel(elementsList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * @return the criteria
     */
    public CategorySC getCriteria()
    {
	return criteria;
    }

    /**
     * @param categoryBO the categoryBO to set
     */
    public void setCategoryBO(CategoryBO categoryBO)
    {
	this.categoryBO = categoryBO;
    }

}
