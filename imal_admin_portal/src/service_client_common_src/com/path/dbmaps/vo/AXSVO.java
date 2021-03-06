package com.path.dbmaps.vo;

import java.util.Date;

public class AXSVO extends AXSVOKey {
    /**
     * This field corresponds to the database column AXS.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column AXS.AUTHORIZED_BY
     */
    private String AUTHORIZED_BY;

    /**
     * This field corresponds to the database column AXS.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column AXS.FROM_USER
     */
    private String FROM_USER;

    /**
     * This field corresponds to the database column AXS.FROM_ROLE
     */
    private String FROM_ROLE;

    /**
     * This field corresponds to the database column AXS.FROM_GROUP
     */
    private String FROM_GROUP;

    /**
     * This field corresponds to the database column AXS.DIRECT_ACCESS
     */
    private String DIRECT_ACCESS;

    /**
     * This field corresponds to the database column AXS.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column AXS.DATE_AUTHORIZED
     */
    private Date DATE_AUTHORIZED;

    /**
     * This field corresponds to the database column AXS.DATE_DELETED
     */
    private Date DATE_DELETED;

    /**
     * This field corresponds to the database column AXS.DATE_DELETE_REJECTED
     */
    private Date DATE_DELETE_REJECTED;

    /**
     * This field corresponds to the database column AXS.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column AXS.DELETE_REJECTED_BY
     */
    private String DELETE_REJECTED_BY;

    /**
     * This field corresponds to the database column AXS.TO_BE_DELETED
     */
    private String TO_BE_DELETED;
    
    private Date ACCESS_FROM_DATE;
    
    private Date ACCESS_TO_DATE;
    
    private Date DATE_MODIFIED;
    
    private String MODIFIED_BY;
    
    private String APPROVED_BY;
    
    private Date DATE_APPROVED;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.CREATED_BY
     *
     * @return the value of AXS.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.CREATED_BY
     *
     * @param CREATED_BY the value for AXS.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.AUTHORIZED_BY
     *
     * @return the value of AXS.AUTHORIZED_BY
     */
    public String getAUTHORIZED_BY() {
        return AUTHORIZED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.AUTHORIZED_BY
     *
     * @param AUTHORIZED_BY the value for AXS.AUTHORIZED_BY
     */
    public void setAUTHORIZED_BY(String AUTHORIZED_BY) {
        this.AUTHORIZED_BY = AUTHORIZED_BY == null ? null : AUTHORIZED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.STATUS
     *
     * @return the value of AXS.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.STATUS
     *
     * @param STATUS the value for AXS.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.FROM_USER
     *
     * @return the value of AXS.FROM_USER
     */
    public String getFROM_USER() {
        return FROM_USER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.FROM_USER
     *
     * @param FROM_USER the value for AXS.FROM_USER
     */
    public void setFROM_USER(String FROM_USER) {
        this.FROM_USER = FROM_USER == null ? null : FROM_USER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.FROM_ROLE
     *
     * @return the value of AXS.FROM_ROLE
     */
    public String getFROM_ROLE() {
        return FROM_ROLE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.FROM_ROLE
     *
     * @param FROM_ROLE the value for AXS.FROM_ROLE
     */
    public void setFROM_ROLE(String FROM_ROLE) {
        this.FROM_ROLE = FROM_ROLE == null ? null : FROM_ROLE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.FROM_GROUP
     *
     * @return the value of AXS.FROM_GROUP
     */
    public String getFROM_GROUP() {
        return FROM_GROUP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.FROM_GROUP
     *
     * @param FROM_GROUP the value for AXS.FROM_GROUP
     */
    public void setFROM_GROUP(String FROM_GROUP) {
        this.FROM_GROUP = FROM_GROUP == null ? null : FROM_GROUP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.DIRECT_ACCESS
     *
     * @return the value of AXS.DIRECT_ACCESS
     */
    public String getDIRECT_ACCESS() {
        return DIRECT_ACCESS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.DIRECT_ACCESS
     *
     * @param DIRECT_ACCESS the value for AXS.DIRECT_ACCESS
     */
    public void setDIRECT_ACCESS(String DIRECT_ACCESS) {
        this.DIRECT_ACCESS = DIRECT_ACCESS == null ? null : DIRECT_ACCESS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.DATE_CREATED
     *
     * @return the value of AXS.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.DATE_CREATED
     *
     * @param DATE_CREATED the value for AXS.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.DATE_AUTHORIZED
     *
     * @return the value of AXS.DATE_AUTHORIZED
     */
    public Date getDATE_AUTHORIZED() {
        return DATE_AUTHORIZED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.DATE_AUTHORIZED
     *
     * @param DATE_AUTHORIZED the value for AXS.DATE_AUTHORIZED
     */
    public void setDATE_AUTHORIZED(Date DATE_AUTHORIZED) {
        this.DATE_AUTHORIZED = DATE_AUTHORIZED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.DATE_DELETED
     *
     * @return the value of AXS.DATE_DELETED
     */
    public Date getDATE_DELETED() {
        return DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.DATE_DELETED
     *
     * @param DATE_DELETED the value for AXS.DATE_DELETED
     */
    public void setDATE_DELETED(Date DATE_DELETED) {
        this.DATE_DELETED = DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.DATE_DELETE_REJECTED
     *
     * @return the value of AXS.DATE_DELETE_REJECTED
     */
    public Date getDATE_DELETE_REJECTED() {
        return DATE_DELETE_REJECTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.DATE_DELETE_REJECTED
     *
     * @param DATE_DELETE_REJECTED the value for AXS.DATE_DELETE_REJECTED
     */
    public void setDATE_DELETE_REJECTED(Date DATE_DELETE_REJECTED) {
        this.DATE_DELETE_REJECTED = DATE_DELETE_REJECTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.DELETED_BY
     *
     * @return the value of AXS.DELETED_BY
     */
    public String getDELETED_BY() {
        return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.DELETED_BY
     *
     * @param DELETED_BY the value for AXS.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY) {
        this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.DELETE_REJECTED_BY
     *
     * @return the value of AXS.DELETE_REJECTED_BY
     */
    public String getDELETE_REJECTED_BY() {
        return DELETE_REJECTED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.DELETE_REJECTED_BY
     *
     * @param DELETE_REJECTED_BY the value for AXS.DELETE_REJECTED_BY
     */
    public void setDELETE_REJECTED_BY(String DELETE_REJECTED_BY) {
        this.DELETE_REJECTED_BY = DELETE_REJECTED_BY == null ? null : DELETE_REJECTED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column AXS.TO_BE_DELETED
     *
     * @return the value of AXS.TO_BE_DELETED
     */
    public String getTO_BE_DELETED() {
        return TO_BE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AXS.TO_BE_DELETED
     *
     * @param TO_BE_DELETED the value for AXS.TO_BE_DELETED
     */
    public void setTO_BE_DELETED(String TO_BE_DELETED) {
        this.TO_BE_DELETED = TO_BE_DELETED == null ? null : TO_BE_DELETED.trim();
    }

	
	public Date getACCESS_FROM_DATE()
	{
		return ACCESS_FROM_DATE;
	}

	public void setACCESS_FROM_DATE(Date aCCESS_FROM_DATE)
	{
		ACCESS_FROM_DATE = aCCESS_FROM_DATE;
	}

	public Date getACCESS_TO_DATE()
	{
		return ACCESS_TO_DATE;
	}

	public void setACCESS_TO_DATE(Date aCCESS_TO_DATE)
	{
		ACCESS_TO_DATE = aCCESS_TO_DATE;
	}

	public Date getDATE_MODIFIED()
	{
		return DATE_MODIFIED;
	}

	public void setDATE_MODIFIED(Date dATE_MODIFIED)
	{
		DATE_MODIFIED = dATE_MODIFIED;
	}

	public String getMODIFIED_BY()
	{
		return MODIFIED_BY;
	}

	public void setMODIFIED_BY(String mODIFIED_BY)
	{
		MODIFIED_BY = mODIFIED_BY;
	}

	public String getAPPROVED_BY()
	{
		return APPROVED_BY;
	}

	public void setAPPROVED_BY(String aPPROVED_BY)
	{
		APPROVED_BY = aPPROVED_BY;
	}

	public Date getDATE_APPROVED()
	{
		return DATE_APPROVED;
	}

	public void setDATE_APPROVED(Date dATE_APPROVED)
	{
		DATE_APPROVED = dATE_APPROVED;
	}
}