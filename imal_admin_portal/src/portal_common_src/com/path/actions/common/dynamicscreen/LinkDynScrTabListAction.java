/**
 * 
 */
package com.path.actions.common.dynamicscreen;

import java.util.List;

import com.path.bo.common.dynamicscreen.DynamicScreenBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamicscreen.LinkDynScrTabCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * LinkDynamicScreenTabListAction.java used to
 */
public class LinkDynScrTabListAction extends GridBaseAction
{
    private ScreenGeneratorSC criteria = new ScreenGeneratorSC();
    private DynamicScreenBO dynamicScreenBO;
    
    /**
     * 
     * 
     * marwanmaddah
     */
    @Override
    public Object getModel()
    {
        // TODO Auto-generated method stub
        return criteria;
    }
	public String loadLinkDynScrTabGrid()
	{
	      String[] searchCol = {"DYN_SCREEN_ID","SCREEN_DESC","OBJECT_CODE","OBJECT_TYPE","SUB_OBJECT_DESC","SUB_OBJECT_ID"};
	      try
		{
			/**0
			 *  copy the details related to search criteria to the SC
			 */
		        SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
			criteria.setLangCode(sessionCO.getLanguage());
			criteria.setCurrAppName(sessionCO.getCurrentAppName());
			criteria.setProgRef(get_pageRef());
		        copyproperties(criteria);
			/**
			 *  set number of rows to be displayed in the page of grid, and the
			 * total number of records for first time load only
			 */
			if(checkNbRec(criteria))
			{
			  setRecords(dynamicScreenBO.linkDynScrTabListCount(criteria));
			}

			/**
			 *  return the collection of records
			 */
			List<LinkDynScrTabCO> linkDynScrTabList = dynamicScreenBO.linkDynScrTabListRecords(criteria);
			
			/**
			 *  set the collection into gridModel attribute defined at JSP grid tag
			 */
			setGridModel(linkDynScrTabList);
			
		}
		catch(Exception e)
		{
			log.error(e, "Error in loadScreenGeneratorGrid");
			handleException(e, null, null);
		}
		return SUCCESS;
	}
	public void setDynamicScreenBO(DynamicScreenBO dynamicScreenBO)
	{
	    this.dynamicScreenBO = dynamicScreenBO;
	}


}
