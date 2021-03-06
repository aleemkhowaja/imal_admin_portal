package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CTS_CRITERIAVO extends CTS_CRITERIAVOKey
{
    /**
     * This field corresponds to the database column CTS_CRITERIA.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTS_CRITERIA.CRITERIA_USAGE
     */
    private String CRITERIA_USAGE;

    /**
     * This field corresponds to the database column CTS_CRITERIA.QUERY_ID
     */
    private BigDecimal QUERY_ID;

    /**
     * This field corresponds to the database column CTS_CRITERIA.PROCEDURE_ID
     */
    private BigDecimal PROCEDURE_ID;

    /**
     * This field corresponds to the database column CTS_CRITERIA.CRITERIA_DESC
     */
    private String CRITERIA_DESC;

    /**
     * This field corresponds to the database column CTS_CRITERIA.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column CTS_CRITERIA.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column CTS_CRITERIA.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column CTS_CRITERIA.DATE_MODIFIED
     */
    private Date DATE_MODIFIED;

    /**
     * This field corresponds to the database column CTS_CRITERIA.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    /**
     * This field corresponds to the database column CTS_CRITERIA.SCORE
     */
    private BigDecimal SCORE;

    /**
     * This field corresponds to the database column CTS_CRITERIA.CRITERIA_REFERENCE
     */
    private String CRITERIA_REFERENCE;
    
    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTS_CRITERIA.BRANCH_CODE
     *
     * @return the value of CTS_CRITERIA.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE()
    {
	return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTS_CRITERIA.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for CTS_CRITERIA.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE)
    {
	this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTS_CRITERIA.CRITERIA_USAGE
     *
     * @return the value of CTS_CRITERIA.CRITERIA_USAGE
     */
    public String getCRITERIA_USAGE()
    {
	return CRITERIA_USAGE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTS_CRITERIA.CRITERIA_USAGE
     *
     * @param CRITERIA_USAGE the value for CTS_CRITERIA.CRITERIA_USAGE
     */
    public void setCRITERIA_USAGE(String CRITERIA_USAGE)
    {
	this.CRITERIA_USAGE = CRITERIA_USAGE == null ? null : CRITERIA_USAGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTS_CRITERIA.QUERY_ID
     *
     * @return the value of CTS_CRITERIA.QUERY_ID
     */
    public BigDecimal getQUERY_ID()
    {
	return QUERY_ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTS_CRITERIA.QUERY_ID
     *
     * @param QUERY_ID the value for CTS_CRITERIA.QUERY_ID
     */
    public void setQUERY_ID(BigDecimal QUERY_ID)
    {
	this.QUERY_ID = QUERY_ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTS_CRITERIA.PROCEDURE_ID
     *
     * @return the value of CTS_CRITERIA.PROCEDURE_ID
     */
    public BigDecimal getPROCEDURE_ID()
    {
	return PROCEDURE_ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTS_CRITERIA.PROCEDURE_ID
     *
     * @param PROCEDURE_ID the value for CTS_CRITERIA.PROCEDURE_ID
     */
    public void setPROCEDURE_ID(BigDecimal PROCEDURE_ID)
    {
	this.PROCEDURE_ID = PROCEDURE_ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTS_CRITERIA.CRITERIA_DESC
     *
     * @return the value of CTS_CRITERIA.CRITERIA_DESC
     */
    public String getCRITERIA_DESC()
    {
	return CRITERIA_DESC;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTS_CRITERIA.CRITERIA_DESC
     *
     * @param CRITERIA_DESC the value for CTS_CRITERIA.CRITERIA_DESC
     */
    public void setCRITERIA_DESC(String CRITERIA_DESC)
    {
	this.CRITERIA_DESC = CRITERIA_DESC == null ? null : CRITERIA_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTS_CRITERIA.CREATED_BY
     *
     * @return the value of CTS_CRITERIA.CREATED_BY
     */
    public String getCREATED_BY()
    {
	return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTS_CRITERIA.CREATED_BY
     *
     * @param CREATED_BY the value for CTS_CRITERIA.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY)
    {
	this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTS_CRITERIA.DATE_CREATED
     *
     * @return the value of CTS_CRITERIA.DATE_CREATED
     */
    public Date getDATE_CREATED()
    {
	return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTS_CRITERIA.DATE_CREATED
     *
     * @param DATE_CREATED the value for CTS_CRITERIA.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED)
    {
	this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTS_CRITERIA.MODIFIED_BY
     *
     * @return the value of CTS_CRITERIA.MODIFIED_BY
     */
    public String getMODIFIED_BY()
    {
	return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTS_CRITERIA.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for CTS_CRITERIA.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY)
    {
	this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTS_CRITERIA.DATE_MODIFIED
     *
     * @return the value of CTS_CRITERIA.DATE_MODIFIED
     */
    public Date getDATE_MODIFIED()
    {
	return DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTS_CRITERIA.DATE_MODIFIED
     *
     * @param DATE_MODIFIED the value for CTS_CRITERIA.DATE_MODIFIED
     */
    public void setDATE_MODIFIED(Date DATE_MODIFIED)
    {
	this.DATE_MODIFIED = DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTS_CRITERIA.DATE_UPDATED
     *
     * @return the value of CTS_CRITERIA.DATE_UPDATED
     */
    public Date getDATE_UPDATED()
    {
	return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTS_CRITERIA.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for CTS_CRITERIA.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED)
    {
	this.DATE_UPDATED = DATE_UPDATED;
    }

    public BigDecimal getSCORE()
    {
	return SCORE;
    }

    public void setSCORE(BigDecimal sCORE)
    {
	SCORE = sCORE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column CTS_CRITERIA.CRITERIA_REFERENCE
     *
     * @return the value of CTS_CRITERIA.CRITERIA_REFERENCE
     */
	public String getCRITERIA_REFERENCE()
	{
		return CRITERIA_REFERENCE;
	}

	/**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column CTS_CRITERIA.CRITERIA_REFERENCE
     *
     * @param CRITERIA_REFERENCE the value for CTS_CRITERIA.CRITERIA_REFERENCE
     */
	public void setCRITERIA_REFERENCE(String cRITERIA_REFERENCE)
	{
		CRITERIA_REFERENCE = cRITERIA_REFERENCE;
	}
}