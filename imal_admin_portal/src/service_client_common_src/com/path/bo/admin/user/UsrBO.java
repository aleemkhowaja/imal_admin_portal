package com.path.bo.admin.user;

import java.util.List;

import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.admin.user.UsrSC;

public interface UsrBO
{
	public List getUserList(UsrSC usrSC) throws BaseException;

	public int getUserCount(UsrSC usrSC) throws BaseException;
	
	public USRVO getUserDetails(UsrSC usrSC) throws BaseException;
	
	public Boolean validateUser(UsrSC usrSC) throws BaseException;//PathSolutions [Navas] added a method for validating the search result
	
	public List getUserListFor_w_lookup_user(UsrSC usrSC) throws BaseException;
	
	public int getUserCountFor_w_lookup_user(UsrSC usrSC) throws BaseException;
	
	public USRVO getUserDetailsFor_w_lookup_user(UsrSC usrSC) throws BaseException;
	
	/**
	 * 
	 * @param criteria
	 * @return users list based on a portlet (portletCode)
	 * @throws BaseException
	 */
        public List returnPortletUsersList(UsrSC criteria) throws BaseException;
    
        /**
         * 
         * @param criteria
         * @return Count of users list based on a portlet (portletCode)
         * @throws BaseException
         */
        public int returnPortletUsersListCount(UsrSC criteria) throws BaseException;
        /**
         * used to return the user reports list and open it in a lookup
         * @author marwanmaddah
         * @date   Feb 25, 2015
         * @param usrSC
         * @return
         * @throws BaseException List
         *
         */
        public List getUsrReportsList(UsrSC usrSC) throws BaseException;
        /**
         * used to check the user's reports count
         * @author marwanmaddah
         * @date   Feb 25, 2015
         * @param usrSC
         * @return
         * @throws BaseException int
         *
         */
        public int getUsrReportsCount(UsrSC usrSC) throws BaseException;
        /**
         * Used to return the user report CO on dependency
         * @author marwanmaddah
         * @date   Feb 25, 2015
         * @param usrSC
         * @return
         * @throws BaseException UsrCO
         *
         */
        public UsrCO getUsrReports(UsrSC usrSC) throws BaseException;
        //added by Marie-Joe for tp#339545
        public USRVO getUserEmailDetails(UsrSC usrSC) throws BaseException;
        
        //Mark Ayoub - Paty
        /**
         * Method for creating User
         * @param usrVO
         * @throws BaseException
         */
        public void createUser (USRVO usrVO) throws BaseException;
        /**
         * Method for deleting USer
         * @param usrSC
         * @throws BaseException
         */
        public void deleteUser (UsrSC usrSC) throws BaseException;
}
