package com.path.actions.common.screengenerator;

import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.screengenerator.ScreenGeneratorBO;
import com.path.dbmaps.vo.SYS_DYN_SCREEN_DEFVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ScreenGeneratorListAction.java used to
 */
public class ScreenGeneratorListAction extends GridBaseAction
{
	private ScreenGeneratorBO screenGeneratorBO;
	private ScreenGeneratorSC criteria =new ScreenGeneratorSC();
	
	@Override
	public Object getModel()
	{
		return criteria;
	}

	/**
	 * 
	 * @author marwanmaddah
	 * @date   Dec 2, 2015
	 * @return
	 * @throws JSONException String
	 *
	 */
	public String loadScreenGeneratorGrid()
	{
	      String[] searchCol = {"DYN_SCREEN_ID","DYN_SCREEN_DESC"};
	      try
		{
			/**
			 *  copy the details related to search criteria to the SC
			 */
		        SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
		        copyproperties(criteria);
			/**
			 *  set number of rows to be displayed in the page of grid, and the
			 * total number of records for first time load only
			 */
		        criteria.setCurrAppName(sessionCO.getCurrentAppName());
			if(checkNbRec(criteria))
			{
			  setRecords(screenGeneratorBO.dynScreensListCount(criteria));
			}

			/**
			 *  return the collection of records
			 */
			List<SYS_DYN_SCREEN_DEFVO> generatedList = screenGeneratorBO.dynScreensList(criteria);
			
			/**
			 *  set the collection into gridModel attribute defined at JSP grid tag
			 */
			setGridModel(generatedList);
			
		}
		catch(Exception e)
		{
			log.error(e, "Error in loadScreenGeneratorGrid");
			handleException(e, null, null);
		}
		return SUCCESS;
	}
	/**
	 * 
	 * @author marwanmaddah
	 * @date   Dec 2, 2015
	 * @param screenGeneratorBO void
	 *
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

}
