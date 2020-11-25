/**
 * 
 */
package com.path.actions.common.menu;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.menu.MenuBO;
import com.path.dbmaps.vo.OPTVO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.menu.TreeMenuSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * TreeGridMenuAction.java used to build the menus in a tree Grid
 */
public class TreeGridMenuAction extends GridBaseAction
{
       private TreeMenuSC criteria = new TreeMenuSC();
       private MenuBO menuBO;
       private List<OPTVO> menuList = new ArrayList<OPTVO>();
	/**
	 * Used for getting Links Management List Details Grid for LinksManagementList.jsp
	 * @return
	 * @throws JSONException
	 */
       public String loadTreeMenu() 
       {
	   return SUCCESS;
       }
       @Override
    public Object getModel()
       {
   	return criteria;
       }       
	public String loadMenuTreeGrid()
	{
	      String[] searchCol = {"MENU_TITLE_ENG"};
	      try
		{
			/**
			 *  copy the details related to search criteria to the SC
			 */
		        SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
		        copyproperties(criteria);
		        /**
		         * in case the UserId has been sent in the parameter will use it, otherwise will get it from session
		         */
                        if(StringUtil.nullToEmpty(criteria.getUserId()).isEmpty() && StringUtil.nullToEmpty(criteria.getProfileId()).isEmpty())
                        {                            
                            criteria.setUserId(sessionCO.getUserName());
                        }
                        if(StringUtil.nullToEmpty(criteria.getProfileId()).isEmpty())
                        {
                            criteria.setProfileId(null);
                        }
                        if(StringUtil.nullToEmpty(criteria.getAppName()).isEmpty())
                        {                            
                            criteria.setAppName(null);
                        }
		        criteria.setCompCode(sessionCO.getCompanyCode());
		        criteria.setBranchCode(sessionCO.getBranchCode());
			criteria.setLangCode(sessionCO.getLanguage());
			if(StringUtil.nullToEmpty(criteria.getProgRef()).isEmpty())
                        { 
			    criteria.setParentid(null);
                        }
			else
			{
			    criteria.setParentid(criteria.getProgRef());
			}
			if(StringUtil.nullToEmpty(criteria.getNodeid()).isEmpty())
			{
				criteria.setProgRef(null);
			}
			else
			{
			    String theKey = criteria.getNodeid();
			    int spltrIndex  = theKey.indexOf('_');
			    if(spltrIndex == -1)
			    {
				criteria.setAppName(theKey);
				criteria.setProgRef("ROOT");
			    }
			    else
			    {
				criteria.setAppName(theKey.substring(0, spltrIndex));
				criteria.setProgRef(theKey.substring(spltrIndex+1,theKey.length()));
			    }
			}

			if(ConstantsCommon.ONE.equals(criteria.getSaveAsParent()))
			{
			    String appName = sessionCO.getCurrentAppName();
			    criteria.setAppName(appName);
			    if(StringUtil.isNotEmpty(criteria.getProgRef()) )
			    {
				criteria.setParentid(menuBO.returnParent(criteria));	
			    }
			}
			
			/**
			 *  return the collection of records
			 */
			menuList = menuBO.returnMenuList(criteria);
			
			/**
			 *  set the collection into gridModel attribute defined at JSP grid tag
			 */
			setGridModel(menuList);
			
		}
		catch(Exception e)
		{
			log.error(e, "Error in Tree Menu Grid");
			handleException(e, null, null);
		}
		return SUCCESS;
	}
	/**
	 * @param menuBO the menuBO to set
	 */
	public void setMenuBO(MenuBO menuBO)
	{
	    this.menuBO = menuBO;
	}
	/**
	 * @return the menuList
	 */
	public List<OPTVO> getMenuList()
	{
	    return menuList;
	}
	/**
	 * @param menuList the menuList to set
	 */
	public void setMenuList(List<OPTVO> menuList)
	{
	    this.menuList = menuList;
	}
	/**
	 * @return the criteria
	 */
	public TreeMenuSC getCriteria()
	{
	    return criteria;
	}
	/**
	 * @param criteria the criteria to set
	 */
	public void setCriteria(TreeMenuSC criteria)
	{
	    this.criteria = criteria;
	}
}
