package com.path.bo.common.dashboardportal;

import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.EMP_PHOTOSVO;
import com.path.dbmaps.vo.SYS_PARAM_PORTLET_TYPEVO;
import com.path.dbmaps.vo.SYS_PARAM_USR_ALLOWED_PORTLETSVO;
import com.path.dbmaps.vo.USER_PORTLETSVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.common.dashboard.ApplicationCO;
import com.path.vo.common.dashboard.DashPortalAlertCO;
import com.path.vo.common.dashboard.FavoriteCO;
import com.path.vo.common.dashboard.WorkspaceWidgetCO;
import com.path.vo.common.dashboardportal.DashboardPortalSC;
import com.path.vo.common.dashboardportal.DashboardWkspceWidgetSC;

public interface DashboardPortalBO 
{

    /**
     * returns the list of system widgets to be shown in the left bar 
     * @return
     * @throws BaseException
     */
    List returnWidgetTypeList(DashboardPortalSC dpsc) throws BaseException;
    
    /**
     * returns the user dashboard widgets and layout details
     * @param sc search criteria by user Id 
     * @return
     * @throws BaseException
     */
    List returnUserPortal(DashboardPortalSC sc)throws BaseException;
    
    /**
     * saves the current layout of the dashboard portal for the current user
     * @param lst list of widgets to be saved
     * @throws BaseException
     */
    void saveLayout(List<USER_PORTLETSVO> lst,String userId)throws BaseException;
    
    /**
     * adds a new custom widget for user dashboard and updates current layout
     * @param theVO new custom widget detail object
     * @param lst list of all widgets in the layout to be updated
     * @throws BaseException
     */
    void insertUserPortlet(SYS_PARAM_PORTLET_TYPEVO theVO, List<USER_PORTLETSVO> lst)throws BaseException;
    
    /**
     * Favorites Management 
     * @author marwanmaddah
     * @date   Dec 24, 2013
     * @param criteria
     * @return
     * @throws BaseException List<FavoriteCO>
     *
     */
    List<FavoriteCO> returnFavoriteList(DashboardPortalSC criteria)throws BaseException;
    
    /**
     * used to delete a screen from the favorites screens list Based on USER_ID 
     * @author marwanmaddah
     * @date   Dec 24, 2013
     * @param favoriteCO
     * @throws BaseException void
     *
     */
    public void deleteFavorite(FavoriteCO favoriteCO) throws BaseException;
    /**
     * Used to add the selected screen to the favorites screen of the selected User
     * @author marwanmaddah
     * @date   Jan 14, 2014
     * @param favoriteCO
     * @throws BaseException void
     *
     */
    public void saveNewFavorite(FavoriteCO favoriteCO) throws BaseException;
    /**
     * Used to update the selected screen to the favorites screen of the selected User
     * @author marwanmaddah
     * @date   Jan 14, 2014
     * @param favoriteCO
     * @throws BaseException void
     *
     */
    public void updateFavorite(FavoriteCO favoriteCO) throws BaseException;
    /**
     * Used to return needed information to be loaded on Favorites Maintenance section in case of edit mode
     * @author marwanmaddah
     * @date   Jan 14, 2014
     * @param  userFavorites
     * @return USER_FAVORITESVO
     * @throws BaseException 
     *
     */
    public FavoriteCO returnFavoriteMaint(FavoriteCO favoriteCO) throws BaseException;
    
    /**
     * Used to return the List of application, based on the user Access right.
     * @author marwanmaddah
     * @date   Jan 8, 2014
     * @param  criteria
     * @return List<ApplicationCO>
     * @throws BaseException 
     *
     */
    public List<ApplicationCO> returnAppList(DashboardPortalSC criteria)throws BaseException;
    
    /**
     * Used to return the main information related to the selected application
     * @author marwanmaddah
     * @date   Jan 8, 2014
     * @param  criteria
     * @return ApplicationCO
     * @throws BaseException 
     *
     */
    public ApplicationCO returnAppInfos(DashboardPortalSC criteria)throws BaseException;
    
    /**
     * Used to return the needed data for the alert widget
     * @author marwanmaddah
     * @date   Jan 9, 2014
     * @param criteria
     * @return
     * @throws BaseException List<DashPortalAlertCO>
     *
     */
    public List<DashPortalAlertCO> returnAlertsList(DashboardPortalSC criteria)throws BaseException;
    /**
     * returns list of workspace details per user (user_workspace)
     * @param criteria
     * @return
     * @throws BaseException
     */
    List<WorkspaceWidgetCO> returnWorkspaceList(DashboardWkspceWidgetSC criteria)throws BaseException;
    /**
     * returns workspace content by user/role
     * @param criteria
     * @return
     * @throws BaseException
     */
    List<WorkspaceWidgetCO> returnWorkspaceForUser(DashboardWkspceWidgetSC criteria)throws BaseException;
    
    /**
     * updates workspace details for user/profile
     * @param userId
     * @param groupId
     * @param updatesLst
     * @throws BaseException
     */
    void updateUserWorkspace(String userId, String groupId, List<WorkspaceWidgetCO> updatesLst)throws BaseException;

    /**
     * return the portlet record by portlet code
     * @param portletInfo
     * @return
     * @throws BaseException
     */
    public SYS_PARAM_PORTLET_TYPEVO returnPortletInfo(SYS_PARAM_PORTLET_TYPEVO portletInfo) throws BaseException;

    /**
     * 
     * @param DashboardPortalSC
     * @throws BaseException
     */
    public void updUserAssignedPortlet(DashboardPortalSC criteria) throws BaseException;
        
    /**
     * updates the user DEFAULT_DISPLAY_PAGE
     * @param usrVO
     * @throws BaseException
     */
    void updateUserDefaultDisplayPage(USRVO usrVO)throws BaseException;
    
    /**
     * used for the business checking that are related to final Sign off management
     * @author marwanmaddah
     * @date   Mar 2, 2015
     * @param dashboardPortalSC
     * @throws BaseException void
     *
     */
    public void finalSignOffChecking(DashboardPortalSC dashboardPortalSC) throws BaseException;
    /**
     * used to update the teller status.
     * @author marwanmaddah
     * @date   Mar 12, 2015
     * @param criteria
     * @throws BaseException void
     *
     */
    public void finalSignOff(DashboardPortalSC criteria) throws BaseException;

    /**
     * Returns the List of the user allowed portlets count
     * @author Rabih El Khatib
     * @param DashboardPortalSC
     * @throws BaseException
     *
     */
    public int returnUsrAllwdPrtltsListCount(DashboardPortalSC dashBoardSC) throws BaseException;
    
    /**
     * Returns the List of the user allowed portlets
     * @author Rabih El Khatib
     * @param DashboardPortalSC
     * @throws BaseException
     *
     */
    
    public List<DashboardPortalSC> returnUsrAllwdPrtltsList(DashboardPortalSC criteria) throws BaseException;
    
    /**
     * Returns the List of the available portlets Count
     * @author Rabih El Khatib
     * @param DashboardPortalSC
     * @throws BaseException
     *
     */
    public int returnPortletsListCount(DashboardPortalSC criteria) throws BaseException;

    /**
     * Returns the List of the available portlets
     * @author Rabih El Khatib
     * @param DashboardPortalSC
     * @throws BaseException
     *
     */
    public List<SYS_PARAM_PORTLET_TYPEVO> returnPortletsList(DashboardPortalSC criteria) throws BaseException;

    /**
     * Saves the List of selected users and portlets
     * @author Rabih El Khatib
     * @param DashboardPortalSC
     * @throws BaseException
     *
     */
    public void updUserAllowedPortlet(DashboardPortalSC criteria) throws BaseException;
    
    /**
     * Used to return boolean on the existence of user allowed portlets
     * @author rabih el khatib
     * @param SYS_PARAM_USR_ALLOWED_PORTLETSVO
     * @return
     * @throws BaseException
     */
    public boolean checkUsrAllwdPrtlts(SYS_PARAM_USR_ALLOWED_PORTLETSVO usrAllwdPrtlts) throws BaseException;
    
    /**
     * Returns the List of the assigned widgets for a specific user
     * @author rabih el khatib
     * @param DashboardPortalSC
     * @return integer
     * @throws BaseException
     */
    public int returnUserDashWidgetsListCount(DashboardPortalSC dashBoardSC) throws BaseException;
    
    /**
     * Returns the List of the assigned widgets for a specific user
     * @author rabih el khatib
     * @param DashboardPortalSC
     * @return List<DashboardPortalSC>
     * @throws BaseException
     */
    public List<DashboardPortalSC> returnUserDashWidgetsList(DashboardPortalSC criteria) throws BaseException;
    
    /**
     * Used to return boolean on the existence of user assigned portlets
     * @param usrSC
     * @return
     * @throws BaseException
     */
    public boolean checkUsrAssignedPrtlts(USER_PORTLETSVO assgndPortletsVO) throws BaseException;
    
    /**
     * Returns the messages list for scrolling marquee
     * @param criteria
     * @return List<String>
     * @throws BaseException
     */
    public List<String> returnMarqueeMessages(DashboardPortalSC criteria) throws BaseException;
    
    /**
     * Loads the employee photo
     * @param criteria
     * @return
     * @throws BaseException
     */
    public EMP_PHOTOSVO loadEmployeePhoto(DashboardPortalSC criteria) throws BaseException;
    
    /**
     * function used to return the todo_refresh_time from USR and from PTH_CTRL
     * @param userId
     * @param defaultPthRefreshTime
     * @return map that contains 2 keys todoRefreshTimeNumber and pthRefreshTimeNumber 
     * @throws BaseException
     */
    public Map<String, Integer> returnUserRefreshTime(String userId, String defaultPthRefreshTime) throws BaseException;
    
    public int unstldNotTransCashBalCount(DashboardPortalSC dashBoardSC) throws BaseException;
    public List<UsrCO> unstldNotTransCashBalList(DashboardPortalSC criteria) throws BaseException;

}
