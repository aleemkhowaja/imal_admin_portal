package com.path.vo.common.audit;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author raees
 *
 */
@SuppressWarnings("serial")
public class AuditReportCO implements Serializable
{
	private Date ACTION_DATE;
	private String ACTION_TYPE;
	private String USER_ID;
	private String USER_NAME;
	private String MACHINE_ID;
	private String APP_NAME;
	private String PROG_REF;
	private String TRX_NBR;
	private Long ACTION_DATE_MS;
	private String ACTION_TYPE_HIDDEN;
	//439073 ADD support for additional fields labels
	private String additionalFieldByTypeDesc;
	private BigDecimal LINE_NUMBER;
	private String TRX_NUMBER;
        private String FIELD_NAME;
        private String OLD_VALUE;
        private String NEW_VALUE;
        private Date RUNNING_DATE;
        private BigDecimal ADD_FIELD_BY_TYPE_COLUMN_NBR;
	/**
	 * @return the aCTION_DATE
	 */
	public Date getACTION_DATE()
	{
		return ACTION_DATE;
	}
	/**
	 * @param aCTIONDATE the aCTION_DATE to set
	 */
	public void setACTION_DATE(Date aCTIONDATE)
	{
		ACTION_DATE = aCTIONDATE;
	}
	/**
	 * @return the aCTION_TYPE
	 */
	public String getACTION_TYPE()
	{
		return ACTION_TYPE;
	}
	/**
	 * @param aCTIONTYPE the aCTION_TYPE to set
	 */
	public void setACTION_TYPE(String aCTIONTYPE)
	{
		ACTION_TYPE = aCTIONTYPE;
	}
	/**
	 * @return the uSER_ID
	 */
	public String getUSER_ID()
	{
		return USER_ID;
	}
	/**
	 * @param uSERID the uSER_ID to set
	 */
	public void setUSER_ID(String uSERID)
	{
		USER_ID = uSERID;
	}
	/**
	 * @return the mACHINE_ID
	 */
	public String getMACHINE_ID()
	{
		return MACHINE_ID;
	}
	/**
	 * @param mACHINEID the mACHINE_ID to set
	 */
	public void setMACHINE_ID(String mACHINEID)
	{
		MACHINE_ID = mACHINEID;
	}
	/**
	 * @return the aPP_NAME
	 */
	public String getAPP_NAME()
	{
		return APP_NAME;
	}
	/**
	 * @param aPPNAME the aPP_NAME to set
	 */
	public void setAPP_NAME(String aPPNAME)
	{
		APP_NAME = aPPNAME;
	}
	/**
	 * @return the pROG_REF
	 */
	public String getPROG_REF()
	{
		return PROG_REF;
	}
	/**
	 * @param pROGREF the pROG_REF to set
	 */
	public void setPROG_REF(String pROGREF)
	{
		PROG_REF = pROGREF;
	}
	/**
	 * @return the tRX_NBR
	 */
	public String getTRX_NBR()
	{
		return TRX_NBR;
	}
	/**
	 * @param tRXNBR the tRX_NBR to set
	 */
	public void setTRX_NBR(String tRXNBR)
	{
		TRX_NBR = tRXNBR;
	}
	/**
	 * @return the aCTION_DATE_MS
	 */
	public Long getACTION_DATE_MS()
	{
		return ACTION_DATE_MS;
	}
	/**
	 * @param aCTIONDATEMS the aCTION_DATE_MS to set
	 */
	public void setACTION_DATE_MS(Long aCTIONDATEMS)
	{
		ACTION_DATE_MS = aCTIONDATEMS;
	}
	/**
	 * @return the aCTION_TYPE_HIDDEN
	 */
	public String getACTION_TYPE_HIDDEN()
	{
		return ACTION_TYPE_HIDDEN;
	}
	/**
	 * @param aCTIONTYPEHIDDEN the aCTION_TYPE_HIDDEN to set
	 */
	public void setACTION_TYPE_HIDDEN(String aCTIONTYPEHIDDEN)
	{
		ACTION_TYPE_HIDDEN = aCTIONTYPEHIDDEN;
	}
	/**
	 * @return the uSER_NAME
	 */
	public String getUSER_NAME()
	{
	    return USER_NAME;
	}
	/**
	 * @param uSERNAME the uSER_NAME to set
	 */
	public void setUSER_NAME(String uSERNAME)
	{
	    USER_NAME = uSERNAME;
	}
	public String getAdditionalFieldByTypeDesc() {
		return additionalFieldByTypeDesc;
	}
	public void setAdditionalFieldByTypeDesc(String additionalFieldByTypeDesc) {
		this.additionalFieldByTypeDesc = additionalFieldByTypeDesc;
	}
	public BigDecimal getLINE_NUMBER() {
		return LINE_NUMBER;
	}
	public void setLINE_NUMBER(BigDecimal lINE_NUMBER) {
		LINE_NUMBER = lINE_NUMBER;
	}
	public String getTRX_NUMBER() {
		return TRX_NUMBER;
	}
	public void setTRX_NUMBER(String tRX_NUMBER) {
		TRX_NUMBER = tRX_NUMBER;
	}
	public String getFIELD_NAME() {
		return FIELD_NAME;
	}
	public void setFIELD_NAME(String fIELD_NAME) {
		FIELD_NAME = fIELD_NAME;
	}
	public String getOLD_VALUE() {
		return OLD_VALUE;
	}
	public void setOLD_VALUE(String oLD_VALUE) {
		OLD_VALUE = oLD_VALUE;
	}
	public String getNEW_VALUE() {
		return NEW_VALUE;
	}
	public void setNEW_VALUE(String nEW_VALUE) {
		NEW_VALUE = nEW_VALUE;
	}
	public Date getRUNNING_DATE() {
		return RUNNING_DATE;
	}
	public void setRUNNING_DATE(Date rUNNING_DATE) {
		RUNNING_DATE = rUNNING_DATE;
	}
	public BigDecimal getADD_FIELD_BY_TYPE_COLUMN_NBR() {
		return ADD_FIELD_BY_TYPE_COLUMN_NBR;
	}
	public void setADD_FIELD_BY_TYPE_COLUMN_NBR(BigDecimal aDD_FIELD_BY_TYPE_COLUMN_NBR) {
		ADD_FIELD_BY_TYPE_COLUMN_NBR = aDD_FIELD_BY_TYPE_COLUMN_NBR;
	}
}
