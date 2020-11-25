package com.path.actions.common.statuscustomization;

import java.util.List;

import com.path.bo.common.statuscustomization.StatusCustomizationBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.statuscustomization.StatusCustomizationCO;
import com.path.vo.common.statuscustomization.StatusCustomizationSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * StatusCustomizationListAction.java used to
 */
public class StatusCustomizationListAction extends GridBaseAction
{
	private StatusCustomizationBO statusCustomizationBO;
	private StatusCustomizationSC criteria = new StatusCustomizationSC();
	
	@Override
	public Object getModel()
	{
	    return criteria;
	}

	/**
	 * 
	 * @author marwanmaddah
	 * @date   Aug 27, 2015
	 * @return String
	 *
	 */
	public String loadStatusCustomizationGrid()
	{
	   String[] searchCol = {"APP_DESC","SECTION_DESC","STATUS_DESC"}; 
	   try{
		/**
		 *  copy the details related to search criteria to the SC
		 */
	        SessionCO sessionCO = returnSessionObject();
		criteria.setSearchCols(searchCol);
	        copyproperties(criteria);

	        criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setLangCode(sessionCO.getLanguage());
		criteria.setCurrAppName(sessionCO.getCurrentAppName());
		criteria.setIvCrud(getIv_crud());
		criteria.setProgRef(get_pageRef());
		criteria.setSelectedKey(getText("selected_key"));
		/**
		 *  set number of rows to be displayed in the page of grid, and the
		 * total number of records for first time load only
		 */
		if(checkNbRec(criteria))
		{
		  setRecords(statusCustomizationBO.statusCustCount(criteria));
		}

		/**
		 *  return the collection of records
		 */
		List<StatusCustomizationCO> statusCustList = statusCustomizationBO.statusCustList(criteria);
		
		/**
		 *  set the collection into gridModel attribute defined at JSP grid tag
		 */
		setGridModel(statusCustList);

	   }
	   catch(Exception ex)
	   {
	       handleException(ex, null, null);
	   }
	   return SUCCESS;
	}
	/**
	 * 
	 * @author marwanmaddah
	 * @date   Aug 27, 2015
	 * @param statusCustomizationBO void
	 *
	 */
	public void setStatusCustomizationBO(StatusCustomizationBO statusCustomizationBO)
	{
		this.statusCustomizationBO = statusCustomizationBO;
	}
	/**
	 * @return the criteria
	 */
	public StatusCustomizationSC getCriteria()
	{
	    return criteria;
	}
	/**
	 * @param criteria the criteria to set
	 */
	public void setCriteria(StatusCustomizationSC criteria)
	{
	    this.criteria = criteria;
	}
}
