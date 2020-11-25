/**
 * 
 */
package com.path.actions.common.dashboard.favorites;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.dashboardportal.DashboardPortalBO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.USER_FAVORITESVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dashboard.FavoriteCO;
import com.path.vo.common.dashboardportal.DashboardPortalSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * FavoriteMainAction.java used to
 */
public class FavoriteMainAction extends BaseAction
{
   private DashboardPortalBO dashboardPortalBO;
   public FavoriteCO favoriteCO = new FavoriteCO();
   public List<FavoriteCO>             favoritesLst = new ArrayList<FavoriteCO>();
   public Map<String,List<FavoriteCO>> favoritesMap = new HashMap<String,List<FavoriteCO>>();
   public String actionMode = "saveNew";
   
   /**
    * Prepare the needed data for Favorite widget and forward them to favorites.ftl
    * @author marwanmaddah
    * @date   Dec 23, 2013
    * @return String
    *
    */
   @Override
public Object getModel()
   {
	return favoriteCO;
   }

   public String loadFavoritewidget()
   {
       try
       {
	     SessionCO  session = returnSessionObject();
	     prepareFavoriteData(session.getUserName());
       }
       catch(Exception ex)
       {
	   handleException(ex, null, null);
	   return ERROR_ACTION;
       }
       return SUCCESS;
   }
   /**
    * 
    * @author marwanmaddah
    * @date   Dec 26, 2013
    * @throws BaseException void
    *
    */
    private void prepareFavoriteData(String userId) throws Exception
    {
	String appName = "";
	DashboardPortalSC criteria = new DashboardPortalSC();
	criteria.setUSER_ID(userId);
	Properties prop       = null;
	boolean propNotLoaded = false;
	try
	{
	    
	    favoritesLst = dashboardPortalBO.returnFavoriteList(criteria);
	    List<FavoriteCO> screenList = new ArrayList<FavoriteCO>();
	    int lstSize = favoritesLst.size();
	    for(int i = 0; i < lstSize; i++)
	    {
		FavoriteCO favCO = favoritesLst.get(i);
		favCO.getUserFavorites().setDESCRIPTION(StringEscapeUtils.escapeHtml(favCO.getUserFavorites().getDESCRIPTION()));
		if(i == 0)
		{
		    appName = favCO.getUserFavorites().getAPP_NAME();
		}
		else
		{
		    if(!appName.equals(favCO.getUserFavorites().getAPP_NAME()))
		    {
			favoritesMap.put(appName, screenList);
			appName = favCO.getUserFavorites().getAPP_NAME();
			screenList = new ArrayList<FavoriteCO>();
		    }
		}
		if(favCO.getExternalLink())
		{
		    favCO.setAppUrl(favCO.getUserFavorites().getURL());
		}
		else
		{
		    if(!propNotLoaded)
		    {
			prop = PropertiesLoaderUtils.loadAllProperties("PathRemoting.properties");
			propNotLoaded = true;
		    }
		    favCO.setAppUrl(prop.getProperty("app."+appName+".url"));
		    
		    //FIX #444260 -  Admin portal>>Favorites>> My Reports Screen are not displaying in new dialog box - in case target App URL is report, to apply same as in TreeMEnuAction
		    if (StringUtil.nullToEmpty(favCO.getOpt_url()).trim().equals(ConstantsCommon.REPORTS_OPT_URL))
		    {
			if(ConstantsCommon.REP_APP_NAME.equals(appName))
			{
			    favCO.setOpt_url("/path/reportsRet/dynRepParamsAction_loadReportFromMenu?menu="+favCO.getUserFavorites().getPROG_REF());
			}
			else
			{
			    //retrieve url from opt_extended for the target app name (set as current) and target prog ref
			    String originOPTRef = favCO.getUserFavorites().getPROG_REF();
			    String [] optDetailsArray = returnCommonLibBO().returnOptDetailsList(appName, originOPTRef);
			    // OPT Reference is not empty
        		    if(!StringUtil.nullToEmpty(optDetailsArray[4]).isEmpty())
        		    {
        			originOPTRef = optDetailsArray[4];
        		    }
        		    
			    favCO.setOpt_url("/path/reporting/ReportsAction_callReports.action?r_r="+originOPTRef);
			}
		    }	
		    
		    //FIX #805026 - in case of TRAGET_APP screen we should get the orginial opt url
		    if(StringUtil.nullToEmpty(favCO.getOpt_url()).trim().equals(ConstantsCommon.TARGET_APP_URL)
			    && StringUtil.isNotEmpty(favCO.getTargetAppName())
			    && StringUtil.isNotEmpty(favCO.getTargetProgRef()))
		    {
			String [] optDetailsArray = returnCommonLibBO().returnOptDetailsList(favCO.getTargetAppName(), favCO.getTargetProgRef());
			// OPT URL is not empty
			if(!StringUtil.nullToEmpty(optDetailsArray[0]).isEmpty())
			{
			    favCO.setOpt_url(optDetailsArray[0]);
			    favCO.setAppUrl(prop.getProperty("app."+ favCO.getTargetAppName() +".url"));
			}
		    }

		}
		screenList.add(favCO);
		if(i == lstSize - 1)
		{
		    favoritesMap.put(appName, screenList);
		}
	    }
	}
	catch(Exception ex)
	{
	    throw new Exception(ex);
	}

    }
   /**
    * Used to initialize the favorite maintenance section  
    * @author marwanmaddah
    * @date   Dec 26, 2013
    * @return String
    *
    */
   public String initialize()
   {
       try
       {
	   SessionCO session = returnSessionObject();
	   USER_FAVORITESVO userFavoritesOpt =  new USER_FAVORITESVO();
	   userFavoritesOpt.setAPP_NAME(session.getCurrentAppName());
	   userFavoritesOpt.setUSER_ID(session.getUserName());
	   favoriteCO.setUserFavorites(userFavoritesOpt);
	   favoriteCO.setExternalLink(false);
	   actionMode = "saveNew";
	   favMaintDisplayMgnt();
       }
       catch(Exception ex)
       {
	   handleException(ex, null, null);
	   return ERROR_ACTION;
       }
       return SUCCESS;
   }
   
   /**
    * Used to open the favorite maintenance section in update mode  
    * @author marwanmaddah
    * @date   Dec 26, 2013
    * @return String
    *
    */
   public String edit()
   {
       try
       {
	   SessionCO session = returnSessionObject();
	   USER_FAVORITESVO userFavorites = favoriteCO.getUserFavorites();
	   userFavorites.setUSER_ID(session.getUserName());
	   favoriteCO = dashboardPortalBO.returnFavoriteMaint(favoriteCO);
	   actionMode = "update";
	   favMaintDisplayMgnt();
       }
       catch(Exception ex)
       {
	   handleException(ex, null, null);
	   return ERROR_ACTION;  
       }
       return SUCCESS;
   }
   
  /**
   * used to do the delete management ...  
   * @author marwanmaddah
   * @date   Dec 24, 2013
   * @return String
   *
   */
  public String deleteFavorite()
  {
     try
     {
	 SessionCO session = returnSessionObject();
	 USER_FAVORITESVO userFavoritesOpt = favoriteCO.getUserFavorites();
	 userFavoritesOpt.setUSER_ID(session.getUserName());
	 dashboardPortalBO.deleteFavorite(favoriteCO);
	 prepareFavoriteData(session.getUserName());
     }
     catch(Exception ex)
     {
	   handleException(ex, null, null);
	   return ERROR_ACTION;
     }
     return SUCCESS;
  }
  
  /**
   * to do the update management
   * @author marwanmaddah
   * @date   Dec 26, 2013
   * @return String
   *
   */
  public String update()
  {
     try
     {
	 SessionCO session = returnSessionObject();
	 USER_FAVORITESVO userFavoritesOpt = favoriteCO.getUserFavorites();
	 userFavoritesOpt.setUSER_ID(session.getUserName());
	 dashboardPortalBO.updateFavorite(favoriteCO);
	 prepareFavoriteData(session.getUserName());
     }
     catch(Exception ex)
     {
	   handleException(ex, null, null);
	   return ERROR_ACTION;
     }
     return SUCCESS;
  }
  
  /**
   * to do the Save New Management.... 
   * @author marwanmaddah
   * @date   Dec 26, 2013
   * @return String
   *
   */
  public String saveNew()
  {
     try
     {
	 SessionCO session = returnSessionObject();
	 USER_FAVORITESVO userFavoritesOpt = favoriteCO.getUserFavorites();
	 userFavoritesOpt.setUSER_ID(session.getUserName());
	 dashboardPortalBO.saveNewFavorite(favoriteCO);
	 prepareFavoriteData(session.getUserName());
     }
     catch(Exception ex)
     {
	   handleException(ex, null, null);
	   return ERROR_ACTION;
     }
     return SUCCESS;
  }
  
  /**
   * Dependency on external link management 
   * @author marwanmaddah
   * @date   Jan 14, 2014
   * @return String
   *
   */
  public String externalDependencyMgnt()
  {
      try
      {
	  if(favoriteCO.getExternalLink())
	  {
	     favoriteCO.getUserFavorites().setPROG_REF(null);
	     favoriteCO.getUserFavorites().setAPP_NAME(ConstantsCommon.IBIS_APP_NAME);
	     favoriteCO.getUserFavorites().setDESCRIPTION(null);
	     favoriteCO.setFullPath(null);
	  }
	  else
	  {
	      favoriteCO.getUserFavorites().setURL(null); 
	  }
	  favMaintDisplayMgnt();
      }
      catch(Exception ex)
      {
	   handleException(ex, null, null);
      }
      return SUCCESS;
  }
  
  /**
   * to do the dislpay management in a common method and call it from where it is needed
   * @author marwanmaddah
   * @date   Jan 15, 2014
   * @throws BaseException void
   *
   */
  private void favMaintDisplayMgnt() throws BaseException
  {
         String theKey = "";
	 if(favoriteCO.getExternalLink())
	 {
	     SYS_PARAM_SCREEN_DISPLAYVO treeMenuVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	     treeMenuVO.setIS_VISIBLE(BigDecimal.ZERO);
	     treeMenuVO.setELEMENT_ID("favTreeMenuBtnId");
	     theKey = "favTreeMenuBtnId";
	     getAdditionalScreenParams().put(theKey, treeMenuVO);
	     
	     SYS_PARAM_SCREEN_DISPLAYVO inDialogVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	     inDialogVO.setIS_VISIBLE(BigDecimal.ZERO);
	     inDialogVO.setELEMENT_ID("chkOpenInDialog");
	     theKey = "chkOpenInDialog";
	     getAdditionalScreenParams().put(theKey, inDialogVO);
	     
	     SYS_PARAM_SCREEN_DISPLAYVO fullPathVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	     fullPathVO.setIS_VISIBLE(BigDecimal.ZERO);
	     fullPathVO.setIS_MANDATORY(BigDecimal.ZERO);
	     fullPathVO.setELEMENT_ID("favoriteFullPath");
	     fullPathVO.setELEMENT_NAME("favoriteCO.fullPath");
	     theKey = "favoriteFullPath";
	     getAdditionalScreenParams().put(theKey, fullPathVO);
	     
	     SYS_PARAM_SCREEN_DISPLAYVO externalVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	     externalVO.setIS_VISIBLE(BigDecimal.ONE);
	     externalVO.setIS_MANDATORY(BigDecimal.ONE);
	     externalVO.setELEMENT_ID("favoriteExternal");
	     theKey = "favoriteExternal";
	     getAdditionalScreenParams().put(theKey, externalVO);
	 }
	 else
	 {
	     SYS_PARAM_SCREEN_DISPLAYVO treeMenuVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	     treeMenuVO.setIS_VISIBLE(BigDecimal.ONE);
	     treeMenuVO.setELEMENT_ID("favTreeMenuBtnId");
	     theKey = "favTreeMenuBtnId";
	     getAdditionalScreenParams().put(theKey, treeMenuVO);
	     
	     SYS_PARAM_SCREEN_DISPLAYVO inDialogVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	     inDialogVO.setIS_VISIBLE(BigDecimal.ONE);
	     inDialogVO.setELEMENT_ID("chkOpenInDialog");
	     theKey = "chkOpenInDialog";
	     getAdditionalScreenParams().put(theKey, inDialogVO);

	     
	     SYS_PARAM_SCREEN_DISPLAYVO fullPathVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	     fullPathVO.setIS_VISIBLE(BigDecimal.ONE);
	     fullPathVO.setIS_MANDATORY(BigDecimal.ONE);
	     fullPathVO.setELEMENT_ID("favoriteFullPath");
	     theKey = "favoriteFullPath";
	     getAdditionalScreenParams().put(theKey, fullPathVO);
	     
	     
	     SYS_PARAM_SCREEN_DISPLAYVO externalVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	     externalVO.setIS_VISIBLE(BigDecimal.ZERO);
	     externalVO.setIS_MANDATORY(BigDecimal.ZERO);
	     externalVO.setELEMENT_ID("favoriteExternal");
	     theKey = "favoriteExternal";
	     getAdditionalScreenParams().put(theKey, externalVO);
	 }
	 if("update".equals(actionMode))
	 {
	     SYS_PARAM_SCREEN_DISPLAYVO externalVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	     externalVO.setIS_READONLY(BigDecimal.ONE);
	     externalVO.setELEMENT_ID("chkfavoriteExt");
	     theKey = "chkfavoriteExt";
	     getAdditionalScreenParams().put(theKey, externalVO);	     
	 }
  }
/**
 * @return the favoritesLst
 */
public List<FavoriteCO> getFavoritesLst()
{
    return favoritesLst;
}

/**
 * @param favoritesLst the favoritesLst to set
 */
public void setFavoritesLst(List<FavoriteCO> favoritesLst)
{
    this.favoritesLst = favoritesLst;
}

/**
 * @return the favoritesMap
 */
public Map<String, List<FavoriteCO>> getFavoritesMap()
{
    return favoritesMap;
}

/**
 * @param favoritesMap the favoritesMap to set
 */
public void setFavoritesMap(Map<String, List<FavoriteCO>> favoritesMap)
{
    this.favoritesMap = favoritesMap;
}

/**
 * @param dashboardPortalBO the dashboardPortalBO to set
 */
public void setDashboardPortalBO(DashboardPortalBO dashboardPortalBO)
{
    this.dashboardPortalBO = dashboardPortalBO;
}

/**
 * @return the favoriteCO
 */
public FavoriteCO getFavoriteCO()
{
    return favoriteCO;
}

/**
 * @param favoriteCO the favoriteCO to set
 */
public void setFavoriteCO(FavoriteCO favoriteCO)
{
    this.favoriteCO = favoriteCO;
}

/**
 * @return the actionMode
 */
public String getActionMode()
{
    return actionMode;
}

/**
 * @param actionMode the actionMode to set
 */
public void setActionMode(String actionMode)
{
    this.actionMode = actionMode;
}
}
