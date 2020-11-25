/**
 * 
 */
package com.path.actions.common.dynamicscreen;

import java.util.List;

import com.path.bo.common.dynamicscreen.DynamicScreenBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * LinkDynamicScreenListAction.java used to
 */
public class LinkDynamicScreenListAction extends GridBaseAction
{
        private ScreenGeneratorSC criteria = new ScreenGeneratorSC();
        private DynamicScreenBO dynamicScreenBO;
        
        @Override
        public Object getModel()
        {
    	return criteria;
        }
        
        /**
         * 
         * marwanmaddah
         */
	public String loadLinkDynScreenGrid()
	{
	      String[] searchCol = {"DYN_SCREEN_ID","SCREEN_DESC","PROG_REF","MENU_TITLE"};
	      try
		{
			/**
			 *  copy the details related to search criteria to the SC
			 */
		        SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
			criteria.setLangCode(sessionCO.getLanguage());
			criteria.setCurrAppName(sessionCO.getCurrentAppName());
		        copyproperties(criteria);
			/**
			 *  set number of rows to be displayed in the page of grid, and the
			 * total number of records for first time load only
			 */
			if(checkNbRec(criteria))
			{
			  setRecords(dynamicScreenBO.linkDynScreenListCount(criteria));
			}

			/**
			 *  return the collection of records
			 */
			List<DynamicScreenCO> linkDynScreenList = dynamicScreenBO.linkDynScreenListRecords(criteria);
			
			/**
			 *  set the collection into gridModel attribute defined at JSP grid tag
			 */
			setGridModel(linkDynScreenList);
			
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

}
