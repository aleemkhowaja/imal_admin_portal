package com.path.vo.admin.user;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.S_REJECTED_PASSWORDSVO;
import com.path.dbmaps.vo.USRVO;

public class UsrCO extends USRVO
{
	private String status_desc;
	private String encType;
	private Date systemDate;
	private String reason;
        private String appName;
	private BigDecimal status;
	
	
	private String AD_USER_ID;
	private String AD_USER_NAME;
	private String AD_USER_DOMAIN;
	private String AD_AUTH_YN;
	private String AD_SERVER;
	
	private BigDecimal REPORT_ID;
	private String     REPORT_NAME;
	private String     REPORT_PROG_REF;

	private S_REJECTED_PASSWORDSVO rejPwdVO;
	private Integer noPwdTrack;
	/**
	 * [MarwanMaddah]:
	 * used inside LoginMapper.returnLoggedInUsers query. 
	 */
	private String PRIVILEGE_LEVEL_DESC;
	private String USR_FULL_NAME;
	private String USER_ID;
	private String LONG_NAME_ENG;
	/**
	 * Used for LDAPS connectivity 
	 */
	private String     USER_LOGIN_CRITERIA;
	private String     CONNECTIVITY_PROTOCOL;
	private BigDecimal AD_PORT;
	/**
	 * End
	 */
	
	//TP #933791 ABSAI190599 - SADS;Password policy is not working on user creation
	private Date usrBirthDate;
	
	public String getStatus_desc()
	{
		return status_desc;
	}

	public void setStatus_desc(String statusDesc)
	{
		status_desc = statusDesc;
	}

	public String getEncType() {
		return encType;
	}

	public void setEncType(String encType) {
		this.encType = encType;
	}

	public Date getSystemDate() {
		return systemDate;
	}

	public void setSystemDate(Date systemDate) {
		this.systemDate = systemDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	/**
	 * @return the aD_USER_ID
	 */
	public String getAD_USER_ID()
	{
	    return AD_USER_ID;
	}

	/**
	 * @param aDUSERID the aD_USER_ID to set
	 */
	public void setAD_USER_ID(String aDUSERID)
	{
	    AD_USER_ID = aDUSERID;
	}

	/**
	 * @return the aD_USER_NAME
	 */
	public String getAD_USER_NAME()
	{
	    return AD_USER_NAME;
	}

	/**
	 * @param aDUSERNAME the aD_USER_NAME to set
	 */
	public void setAD_USER_NAME(String aDUSERNAME)
	{
	    AD_USER_NAME = aDUSERNAME;
	}

	/**
	 * @return the aD_USER_DOMAIN
	 */
	public String getAD_USER_DOMAIN()
	{
	    return AD_USER_DOMAIN;
	}

	/**
	 * @param aDUSERDOMAIN the aD_USER_DOMAIN to set
	 */
	public void setAD_USER_DOMAIN(String aDUSERDOMAIN)
	{
	    AD_USER_DOMAIN = aDUSERDOMAIN;
	}

	/**
	 * @return the rEPORT_ID
	 */
	public BigDecimal getREPORT_ID()
	{
	    return REPORT_ID;
	}

	/**
	 * @param rEPORTID the rEPORT_ID to set
	 */
	public void setREPORT_ID(BigDecimal rEPORTID)
	{
	    REPORT_ID = rEPORTID;
	}

	/**
	 * @return the rEPORT_NAME
	 */
	public String getREPORT_NAME()
	{
	    return REPORT_NAME;
	}

	/**
	 * @param rEPORTNAME the rEPORT_NAME to set
	 */
	public void setREPORT_NAME(String rEPORTNAME)
	{
	    REPORT_NAME = rEPORTNAME;
	}

	/**
	 * @return the rEPORT_PROG_REF
	 */
	public String getREPORT_PROG_REF()
	{
	    return REPORT_PROG_REF;
	}

	/**
	 * @param rEPORTPROGREF the rEPORT_PROG_REF to set
	 */
	public void setREPORT_PROG_REF(String rEPORTPROGREF)
	{
	    REPORT_PROG_REF = rEPORTPROGREF;
	}

	public String getAD_AUTH_YN()
	{
	    return AD_AUTH_YN;
	}

	public void setAD_AUTH_YN(String aDAUTHYN)
	{
	    AD_AUTH_YN = aDAUTHYN;
	}

	public String getAD_SERVER()
	{
	    return AD_SERVER;
	}

	public void setAD_SERVER(String aDSERVER)
	{
	    AD_SERVER = aDSERVER;
	}

	public S_REJECTED_PASSWORDSVO getRejPwdVO()
	{
	    return rejPwdVO;
	}

	public void setRejPwdVO(S_REJECTED_PASSWORDSVO rejPwdVO)
	{
	    this.rejPwdVO = rejPwdVO;
	}

	public Integer getNoPwdTrack()
	{
	    return noPwdTrack;
	}

	public void setNoPwdTrack(Integer noPwdTrack)
	{
	    this.noPwdTrack = noPwdTrack;
	}

	/**
	 * @return the pRIVILEGE_LEVEL_DESC
	 */
	public String getPRIVILEGE_LEVEL_DESC()
	{
	    return PRIVILEGE_LEVEL_DESC;
	}

	/**
	 * @param pRIVILEGE_LEVEL_DESC the pRIVILEGE_LEVEL_DESC to set
	 */
	public void setPRIVILEGE_LEVEL_DESC(String pRIVILEGE_LEVEL_DESC)
	{
	    PRIVILEGE_LEVEL_DESC = pRIVILEGE_LEVEL_DESC;
	}

	/**
	 * @return the uSR_FULL_NAME
	 */
	public String getUSR_FULL_NAME()
	{
	    return USR_FULL_NAME;
	}

	/**
	 * @param uSR_FULL_NAME the uSR_FULL_NAME to set
	 */
	public void setUSR_FULL_NAME(String uSR_FULL_NAME)
	{
	    USR_FULL_NAME = uSR_FULL_NAME;
	}

	/**
	 * @return the uSER_LOGIN_CRITERIA
	 */
	public String getUSER_LOGIN_CRITERIA()
	{
	    return USER_LOGIN_CRITERIA;
	}

	/**
	 * @param uSER_LOGIN_CRITERIA the uSER_LOGIN_CRITERIA to set
	 */
	public void setUSER_LOGIN_CRITERIA(String uSER_LOGIN_CRITERIA)
	{
	    USER_LOGIN_CRITERIA = uSER_LOGIN_CRITERIA;
	}

	/**
	 * @return the cONNECTIVITY_PROTOCOL
	 */
	public String getCONNECTIVITY_PROTOCOL()
	{
	    return CONNECTIVITY_PROTOCOL;
	}

	/**
	 * @param cONNECTIVITY_PROTOCOL the cONNECTIVITY_PROTOCOL to set
	 */
	public void setCONNECTIVITY_PROTOCOL(String cONNECTIVITY_PROTOCOL)
	{
	    CONNECTIVITY_PROTOCOL = cONNECTIVITY_PROTOCOL;
	}

	/**
	 * @return the aD_PORT
	 */
	public BigDecimal getAD_PORT()
	{
	    return AD_PORT;
	}

	/**
	 * @param aD_PORT the aD_PORT to set
	 */
	public void setAD_PORT(BigDecimal aD_PORT)
	{
	    AD_PORT = aD_PORT;
	}

	/**
	 * @return the uSER_ID
	 */
	public String getUSER_ID()
	{
	    return USER_ID;
	}

	/**
	 * @param uSER_ID the uSER_ID to set
	 */
	public void setUSER_ID(String uSER_ID)
	{
	    USER_ID = uSER_ID;
	}

	/**
	 * @return the lONG_NAME_ENG
	 */
	public String getLONG_NAME_ENG()
	{
	    return LONG_NAME_ENG;
	}

	/**
	 * @param lONG_NAME_ENG the lONG_NAME_ENG to set
	 */
	public void setLONG_NAME_ENG(String lONG_NAME_ENG)
	{
	    LONG_NAME_ENG = lONG_NAME_ENG;
	}

	public Date getUsrBirthDate() 
	{
		return usrBirthDate;
	}

	public void setUsrBirthDate(Date usrBirthDate) 
	{
		this.usrBirthDate = usrBirthDate;
	}
	
}
