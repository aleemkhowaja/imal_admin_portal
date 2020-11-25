package com.path.bo.common.login;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.S_APPLOGVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.admin.user.UsrSC;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.CommonLibCO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.DefaultCompBranchCO;
import com.path.vo.common.LoginCO;
import com.path.vo.common.PasswordChangeCO;
import com.path.vo.common.PathCounterLcSC;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ctsteller.CTSTELLERSC;

/**
 * 
 * Copyright 2010, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Denisk Haddad
 * 
 *          LoginBO.java interface for user Login operations
 */
public interface LoginBO
{
    /**
     * 
     * Used for returning used information corresponding to given userName
     * 
     * @param userName
     * @return
     * @throws BaseException
     */
    public UsrCO userLoginDet(String userName) throws BaseException;
    /**
     * return User DEtails with ACtive Directory User Checking
     * @param username user name entered during login
     * @return UsrCO Object containing details
     * @throws BaseException
     */
    public UsrCO returnAdDetails(String username) throws BaseException;

	/**
	 * insert in S_USR_LOGIN_LOG details of the user logged in
	 * @param userSC
	 * @return
	 * @throws DAOException
	 */
	//public void updateUserLogin(String username, String remoteHost, String logReason, long status) throws BaseException;

    // public void loadLoginDetToVO(UsrLogInInfoVO loginInfVo, boolean
    // updateLogin)throws PathException;
    // public void updateUserInfo(UserInfoVO usrInfVo) throws PathException;
    // public void assignUserAuthentRole(String string)throws PathException;
    // public void changePwd(UserInfoVO userInfoVO, String newPwd, String
    // oldPwd)throws PathException;
    /**
     * 
     * @param userName
     * @param password
     * @return
     * @throws BadCredentialsException
     */
    public int authenticateUserAndPass(String userName, String password)throws BadCredentialsException;
    /**
     * Method requested to check for username availability and check password
     * 
     * @param username
     * @param password
     * @param hostName
     * @param appName
     * @param language
     * @param captchaText
     * @param captchaUserText
     * @param appVersion Version of application need to sent from portal side
     *            since some application have the same services but different
     *            portals like icor, iret, prov, ... all of them use
     *            iis_services
     * @return
     * @throws BadCredentialsException
     */
    public int authenticateUser(String username, String password,String hostName,String appName, String language,String appVersion,String webHttpSessionId,Boolean autoLogin,String captchaText,String CaptchaUserText) throws BadCredentialsException;
    
    /**
     * 
     * @param username
     * @param password
     * @param hostName
     * @param appName
     * @param language
     * @param appVersion
     * @param webHttpSessionId
     * @param autoLogin
     * @return
     * @throws BadCredentialsException
     */
    public int authenticateUser(String username, String password, String hostName, String appName, String language,String appVersion,String webHttpSessionId,Boolean autoLogin) throws BadCredentialsException;
    /**
     * Method requested to encrypt password and check for username/password validity 
     *  @param username user name
     *  @param password plain password
     *  @param request
     *  @return array containing encrypted password and flag meaning if user is allowed to access
     *  @throws BaseException
     */
    public String[] encryptAuthenticateUser(String username, String password,String hostName,String appName, String language,String webHttpSessionId) throws BadCredentialsException;
    /**
     * 
     * @param username
     * @param password
     * @param hostName
     * @param appName
     * @param language
     * @param appVersion
     * @param webHttpSessionId
     * @return
     * @throws BadCredentialsException
     */
    public String[] encryptAuthenticateUser(String username, String password, String hostName, String appName,
	    String language, String appVersion,String webHttpSessionId) throws BadCredentialsException;
    /**
     * Method requested to encrypt password and check for username/password validity
     * @param username
     * @param password
     * @param hostName
     * @param appName
     * @param language
     * @param captchaText
     * @param captchaUserText
     * @param appVersion version of the application for compatibility checking, check authenticateUser method
     * @return
     * @throws BadCredentialsException
     */
    public String[] encryptAuthenticateUser(String username, String password, String hostName, String appName,
	    String language, String appVersion,String webHttpSessionId,String captchaText,String captchaUserText) throws BadCredentialsException;
    /**
     * Fill CTSTELLER user details and check its status
     * @param ctstellersc
     * @param hostName 
     * @return
     * @throws BadCredentialsException
     */
    public CTSTELLERVO loadTellerDetails(CTSTELLERSC ctstellersc, String hostName,String webHttpSessionId) throws BaseException;
    
    /**
     * 
     * Used for return running date of the application without Time
     * 
     * @param companyCode
     * @param branchCode
     * @param appName
     * @return
     * @throws BaseException
     */
    public Date returnRunningDate(BigDecimal companyCode, BigDecimal branchCode, String appName) throws BaseException;
    
    /**
     * 
     * @param compCode
     * @param branchCode
     * @param appName
     * @param runningDate
     * @param fiscalYear
     * @param userName
     * below method used to update the running date
     * @throws BaseException 
     */
    public void updateRunningDate(BigDecimal compCode, BigDecimal branchCode, String appName, Date runningDate, BigDecimal fiscalYear, String userName) throws BaseException;

    /**
     * 
     * Used for return running date of the application with Time
     * 
     * @param companyCode Comapny Code
     * @param branchCode Branch Code
     * @param appName Application Name
     * @return
     * @throws BaseException
     */
    public Date returnRunningDateWithTime(BigDecimal companyCode, BigDecimal branchCode, String appName)
	    throws BaseException;
    /**
     * 
     * Used for checking User Password
     * 
     * @param encType Encryption Type
     * @param passFwd Forward Password
     * @param passRev Reverse Password
     * @param passFin Final Password
     * @param currPwd Current Password
     * @param userName user Name
     * @param usrUnsuccLogins user unsuccessful current logins
     * @param hostName machine Name
     * @param captchaText
     * @param captchaUserText
     * @param appName application Name
     * @throws BadCredentialsException
     * @throws BaseException
     */
    public void checkPwdEnc(String encType,double passFwd,double passRev, String passFin,String currPwd , String userName,BigDecimal usrUnsuccLogins, String usrStatus, String hostName, String appName, String language,String webHttpSessionId,String captchaText,String captchaUserText) 
	throws BadCredentialsException, BaseException;
    /**
     * 
     * @param encType
     * @param passFwd
     * @param passRev
     * @param passFin
     * @param currPwd
     * @param userName
     * @param usrUnsuccLogins
     * @param usrStatus
     * @param hostName
     * @param appName
     * @param language
     * @param webHttpSessionId
     * @throws BadCredentialsException
     * @throws BaseException
     */
    public void checkPwdEnc(String encType, double passFwd, double passRev, String passFin, String currPwd,String userName, BigDecimal usrUnsuccLogins, String usrStatus, String hostName, String appName,String language,String webHttpSessionId) throws BadCredentialsException, BaseException;
/**
 * 
 * Used for checking if correct Company and Branch is entered 
 * 
 * @param compCode
 * @param branchCode
 * @param appName
 * @param userName
 * @param hostName
 * @throws BaseException
 */
    public void checkCompanyBranchAccess(CommonLibSC criteria) throws BaseException;
    /**
     * method that checks if the user has access to at least one Menu and what is the default Page to be loaded Menu or Landing page
     * @param compCode
     * @param branchCode
     * @param appName
     * @param userName
     * @param language 
     * @param branchIsClosedUserLogged Flag specifying if user logged in after branch closure occurred, for Non Financial Transaction operation #137163
     * @return
     * @throws BaseException
     */
    String returnDefaultPageLogin(BigDecimal compCode, BigDecimal branchCode, String appName, String userName, String language, String branchIsClosedUserLogged)throws BaseException;
/**
 * 
 * Used for set user Status as logged to the given Module
 * 
 * @param compCode company Code
 * @param branchCode Branch Code
 * @param userName User NAme
 * @param appName logged in application
 * @param ip machine IP
 * @param httpSessionId: it is the user session id
 */
    public void loginUserToModule(BigDecimal compCode, BigDecimal branchCode, String userName, String appName, String ip, String httpSessionId)
    throws BaseException;
    
    /**
     * TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
     * 
     * @param compCode
     * @param branchCode
     * @param userName
     * @param appName
     * @param ip
     * @param httpSessionId
     * @param isFinalSignOff
     * @throws BaseException
     */
    public void loginUserToModule(BigDecimal compCode, BigDecimal branchCode, String userName, String appName, String ip, String httpSessionId, boolean isFinalSignOff)
    throws BaseException;

/**
 * 
 * Used for logged out user from the application
 * 
 * @param userName
 * @param appName
 * @param ip 
 * @param compCode
 * @param braCode
 * @param fromSwitchBranch whether called from Switch branch option
 */
    public void logoutUserFromModule(String userName, String appName, String ip, BigDecimal compCode, BigDecimal braCode,String idleStatus,String webHttpSessionId, boolean fromSwitchBranch)throws BaseException;
/**
 * 
 * Used for Returning Welcome Message to be displyed on Welcome Page
 * 
 * @param userName
 * @param userLastName 
 * @param userFirstName 
 * @param userLanguage 
 * @return
 * @throws BaseException
 */
    public String returnWelcomeMsg(String userName, String userFirstName, String userLastName, String userLanguage)throws BaseException;

    /**
     * 
     * Used for returning fiscal month and year and null if not defined
     * 
     * @param compCode company code
     * @param branchCode branch code
     * @param runningDate running Date
     * @return [0] is the fiscal year, [1] is the fiscal month
     */
    public BigDecimal[] returnFiscalYearMonth(BigDecimal compCode, BigDecimal branchCode, Date runningDate)
	    throws BaseException;

    /**
     * returns the pwd encrypted according to encType and user name pwd
     * @param encType encrption type
     * @param username user name
     * @param pwd password
     * @return
     * @throws BaseException
     */
    String returnEncryptedPassword(String encType,String username,String pwd)throws BaseException;
    /**
     * returns encrypted password
     * @param username user name
     * @param pwd password
     * @return encrypted value of password
     * @throws BaseException
     */
    String returnEncryptedPassword(String username,String pwd)throws BaseException;
    /**
     * changes the password of the user and saves it to db
     * @param pwdChangeCO password object containing new password and other info
     * @param userName user name
     * @throws BaseException
     */
    public boolean changePwd(PasswordChangeCO pwdChangeCO, String userName) throws BaseException;
    /**
     * checks if the old password entered on password change screen is correct 
     * @param pwdChangeCO password object containing old password entered from screen
     * @throws BaseException
     */
    public boolean checkOldPassword(PasswordChangeCO pwdChangeCO)throws BaseException;
    
    /**
     * 
     * Used for returning Exposure Currency Details,m Throws Exception if Exposure Currency Not correct
     * 
     * @param compCode
     * @param branchCode
     * @param appName
     * @param userName
     * @param hostName
     * @return
     * @throws BaseException
     */
    public CURRENCIESVO returnExposureCurrency(BigDecimal compCode, BigDecimal branchCode, String appName,
	    String userName, String hostName,String webHttpSessionId) throws BaseException;

    /**
     * Used for returning Exposure Currency Details, Throws Exception if
     * Exposure Currency Not correct in case asService=false
     * 
     * @param compCode company code
     * @param appName name of application to trace in case of error, needed only if asService=false
     * @param userName user to trace in case of error, needed only if asService=false
     * @param hostName name of machine to trace in case of error, needed only if asService=false
     * @param asService specifies whether the call is as service to return the
     *            Currency without throwing and login errors
     * @return CurrencyVO of Exposure currency, null if not found
     * @throws BaseException
     */
    public CURRENCIESVO returnExposureCurrency(BigDecimal compCode, String appName,
	    String userName, String hostName,boolean asService,String webHttpSessionId) throws BaseException;
    /**
     * 
     * Used for checking whether the branch and session are opened in order to
     * access the branch
     * 
     * @param compCode
     * @param branchCode
     * @param userId
     * @throws BaseException
     */
    public String checkBranchSession(BigDecimal compCode, BigDecimal branchCode, String userId) throws BaseException;

    /**
     * This function returns the CTSTELLERVO by compCode, branchCode and
     * user_id
     * @author nabilfeghali
     * @param ctsTellerSC
     * @return
     * @throws BaseException
     */
    public CTSTELLERVO ctsTellerDetails(CTSTELLERSC ctsTellerSC) throws BaseException;
    /**
     * method return whether other users are logged in to given company (application and branch are option)
     * @param loginCO
     * @return long > 0 means there are users that still logged.
     * @throws BaseException
     */
    public long checkAppLogUsrsAlreadyLoggedIn(LoginCO loginCO) throws BaseException;
    /**
     * this function checks if there any users logged in other than the current
     * logged in user
     * 
     * @param username
     * @param appName
     * @param compCode
     * @param branchCode
     * @throws BaseException
     */
    public void checkOtherUsersAlreadyLoggedIn(String username, String appName, BigDecimal compCode,
	    BigDecimal branchCode) throws BaseException;
    /**
     * method to apply lock on database table S_APPLOG
     * @param loginCO
     */
    public void applyLockOnAppLog(LoginCO loginCO) throws BaseException;
    /**
     * MEthod for activating/Deactivating Single User Mode,updating all users to be logged in/logged out
     * @param loginCO parameter containing details of which application, company, branch users to be updated
     * @return int > 0 number of records updated.
     * @throws BaseException
     */
    public int activateDeactivateSingleUserMode(LoginCO loginCO) throws BaseException;
    
    
    /**
     * Return List of currently Logged in users
     * @param compCode
     * @param branchCode
     * @param appName
     * @return List<CTSTELLERVO>
     * @throws BaseException
     */
    public List<UsrCO> returnLoggedInUsersList(CTSTELLERSC ctsTellerSC) throws BaseException;
    
    /**
     * Method that returns the count of logged in users
     * @param compCode
     * @param branchCode
     * @param appName
     * @return int
     * @throws BaseException
     */
    public int returnLoggedInUsersListCount(CTSTELLERSC ctsTellerSC) throws BaseException;
    
    /**
     * Method that returns the count of logged in users that does not have the privilege to overpass branch /session closure
     * @param compCode
     * @param branchCode
     * @param appName
     * @return int
     * @throws BaseException
     */
    public int returnLoggedInOverPassCount(CommonLibSC criteria)throws BaseException;
    
    /**
     * returns the default display page of the user (0=menu screen, 1=landing page) 
     * @param usrSC
     * @return
     * @throws BaseException
     */
    String returnUsrDefaultDisplayPage(UsrSC usrSC) throws BaseException;
    
    /**
     * Used for path licenses auditing management 
     * @author marwanmaddah
     * @date   Sep 11, 2014
     * @param pathCounterLcSC
     * @return
     * @throws BaseException String
     *
     */
    public String pathLicensesLog(PathCounterLcSC pathCounterLcSC)throws BaseException;
    
    /**
     * returns value of WEB_HTTP_SESSION_ID from S_APPLOG for given user/comp/branch/app
     * @param vo
     * @return
     * @throws BaseException
     */
    String returnWebHttpSessionId(S_APPLOGVO vo)throws BaseException;
    
    /**
     * Login Alert Implementation TP#297149
     * This function will do 2 different checking based on the userSC parameter:
     * 1- it can check if the current user is a subordinate in login alert subordinate table.
     * 2- it can check if the current user is a manager (has subordinates) in login alert subordinate table.
     * @param usrSC
     * @return
     * @throws BaseException
     */
    public UsrSC returnLoginAlertSubUserCount(UsrSC usrSC) throws BaseException;
    
    /**
     * Login Alert Implementation TP#297149
     * This function will prepare the alert parameters to be used when opening the send alert grid.
     * it should be passed from desktopAction to AppMain to be used in showSendAlert()
     * @param userSC
     * @return
     * @throws BaseException
     */
    public AlertsParamCO returnLoginAlertsParam(UsrSC userSC) throws BaseException;
    
    /**
     * Login Alert Implementation TP#297149
     * This function will update the user login approval date in case of alert login 
     * @param date
     * @param usrVO
     * @throws BaseException
     */
    public void updateUsrAlertLoginApproval(USRVO usrVO) throws BaseException;
    
    /**
     * Login Alert Implementation TP#297149
     * This function will check if the login alert should be enabled
     * Edited - TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
     * @param CommonLibSC commonLibSC
     * @param isFinalSignOff
     * @return
     * @throws BaseException
     */
    public boolean checkLoginAlertEnabled(CommonLibSC commonLibSC, boolean isFinalSignOff) throws BaseException;
    /**
     * Login Alert Implementation TP#297149
     * This function will update the log of the user login in S_USR_LOGIN_LOG
     * @param username
     * @param remoteHost
     * @param logReason
     * @param status
     * @param appName
     */
    public void updateUserLogin(String username, String remoteHost, String logReason, long status, String appName, String httpWebSession, String loginAlertApproverRejecter)throws BaseException;
    
    /**
     * returns the pwd expiry date for user when exists 
     * @param usrCO
     * @return
     * @throws BaseException
     */
    Date returnPwdExpDate(UsrCO usrCO)throws BaseException;

    /**
     * method to check whether the security token upon login is valid 
     * @param criteria
     * @return returns error code in case of exception and null otherwise
     * @throws BaseException
     */
    Integer validateSecurityToken(CommonLibSC criteria )throws BaseException;

    /**
     * Used for insert and set user Status as logged to the given application
     * @param compCode
     * @param branchCode
     * @param userName
     * @param appName
     * @param ip
     * @param httpSessionId
     * @throws BaseException
     */
    public void loginUserToApp(BigDecimal compCode, BigDecimal branchCode, String userName, String appName, String ip, String httpSessionId)
    throws BaseException;
    /**
     * This method perform authentication of provided User and password against LDAP
     * usrCO Object should contain the LDAP server, LDAP Port, USER Name, User LDAP Domain if needed,and if LDAPS (secure is used)
     * @param password
     * @param usrCO
     * @returns String[] with 2 entries, true / false in String[0], and Exception Description is available in String[1] (empty if no errors)
     */
    public String[] authenticateUsingLdap(String password,UsrCO usrCO) throws BaseException;
    
    /**
     * This method used to generate captcha image
     * @return String captchaText,byte[] captchaImg 
     * @throws BaseException
     */
    public Object[] generateCaptcha() throws BaseException;
    
    /**
     * return list of ldap users with their information like phoneNumber,email...
     * @return json format of list of users
     * @throws Exception
     */
    public String returnLdapUsersList()throws BaseException;
    
    /**
     * update logout logs 
     * @param userName
     * @param appName
     * @param ip
     * @param compCode
     * @param branchCode
     * @param idleStatus
     * @param webHttpSessionId
     * @throws BaseException
     */
    public void updateLogoutLogs(String userName, String appName, String ip, BigDecimal compCode,BigDecimal branchCode, String idleStatus,String webHttpSessionId) throws BaseException;
    public int returnExpiryNtfNbDays(CommonLibSC criteria) throws BaseException;
    
    /**
     * return the list of ROLE_NAME from S_APPROLUSR by USER_ID
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<String> returnRoleNameByUserId(CommonLibSC criteria) throws BaseException;    
    /**
     * Method to Check the Version Compatibility between the provided version and specified application and that updated At DB level
     * @param appName application Name to Check
     * @param appVersion Application VErsion to Check
     * @throws BaseException Exception if the compatibility not satisfied
     */
    //TP 849633 making method public to be used in Integration service for service call verification
    public void checkVersionCompatibility(String appName, String appVersion) throws BaseException;
    
    //TP #917463 wrong message generated for all operations(Method to cover the SOA calls from SADS application)
    public int authenticateUserAndPass(String userName, String password, String soaCallFromAppName) throws BadCredentialsException;
    
    //TP #933791 ABSAI190599 - SADS;Password policy is not working on user creation
    public void check_password(String newPwd, String userName, UsrCO usrCO) throws BaseException;
    
    // TP #933826 :ABSAI190603 - Cannot change iMAL password from Java applications
    public String[] authenticateUserReturningAuthBy(String username, String password, String hostName, String appName, String language,
    	    String appVersion,String webHttpSessionId,Boolean autoLogin,String captchText,String captchaUserText, String soaFromAppName) throws BadCredentialsException;
    //RKFHK190067--No warning message if running date not same as Phoenix running date
    public CommonLibCO returnPhoenixRunningDate(BigDecimal companyCode) throws BaseException;
    public DefaultCompBranchCO returnDefaultCompBr(UsrSC userSC) throws BaseException;
}
