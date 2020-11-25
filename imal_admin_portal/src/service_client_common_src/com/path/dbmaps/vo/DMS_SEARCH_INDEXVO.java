package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class DMS_SEARCH_INDEXVO extends DMS_SEARCH_INDEXVOKey
{

	/**
	 * This field corresponds to the database column DMS_SEARCH_INDEX.ELEMENT_TYPE
	 */
	private BigDecimal ELEMENT_TYPE;

	/**
	 * This field corresponds to the database column DMS_SEARCH_INDEX.ELEMENT_TYPE
	 */
	private BigDecimal DMS_INDEX_NUM;

	/**
	 * This field corresponds to the database column DMS_SEARCH_INDEX.DMS_INDEX_NAME
	 */
	private String DMS_INDEX_NAME;

	/**
	 * This field corresponds to the database column DMS_SEARCH_INDEX.IMAL_INDEX_NAME
	 */
	private String IMAL_INDEX_NAME;

	/**
	 * This field corresponds to the database column DMS_SEARCH_INDEX.SECTION
	 */
	private String SECTION;

	/**
	 * This field corresponds to the database column DMS_SEARCH_INDEX.SCREEN_ID
	 */
	private BigDecimal SCREEN_ID;

	/**
	 * This field corresponds to the database column DMS_SEARCH_INDEX.ORDER_VALUE
	 */
	private BigDecimal ORDER_VALUE;

	/**
	 * This field corresponds to the database column DMS_SEARCH_INDEX.EXPRESSION_COLUMNS
	 */
	private String EXPRESSION_COLUMNS;

	private Date DATE_UPDATED;

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column DMS_SEARCH_INDEX.ELEMENT_TYPE
	 *
	 * @return the value of DMS_SEARCH_INDEX.ELEMENT_TYPE
	 */
	public BigDecimal getELEMENT_TYPE()
	{
		return ELEMENT_TYPE;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column DMS_SEARCH_INDEX.ELEMENT_TYPE
	 *
	 * @param ELEMENT_TYPE the value for DMS_SEARCH_INDEX.ELEMENT_TYPE
	 */
	public void setELEMENT_TYPE(BigDecimal ELEMENT_TYPE)
	{
		this.ELEMENT_TYPE = ELEMENT_TYPE;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column DMS_SEARCH_INDEX.DMS_INDEX_NUM
	 *
	 * @return the value of DMS_SEARCH_INDEX.DMS_INDEX_NUM
	 */
	public BigDecimal getDMS_INDEX_NUM()
	{
		return DMS_INDEX_NUM;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets theDMS_INDEX_NUMe database column DMS_SEARCH_INDEX.DMS_INDEX_NUM
	 *
	 * @param DMS_INDEX_NUM the value for DMS_SEARCH_INDEX.DMS_INDEX_NUM
	 */
	public void setDMS_INDEX_NUM(BigDecimal DMS_INDEX_NUM)
	{
		this.DMS_INDEX_NUM = DMS_INDEX_NUM;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column DMS_SEARCH_INDEX.DMS_INDEX_NAME
	 *
	 * @return the value of DMS_SEARCH_INDEX.DMS_INDEX_NAME
	 */
	public String getDMS_INDEX_NAME()
	{
		return DMS_INDEX_NAME;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column DMS_SEARCH_INDEX.DMS_INDEX_NAME
	 *
	 * @param DMS_INDEX_NAME the value for DMS_SEARCH_INDEX.DMS_INDEX_NAME
	 */
	public void setDMS_INDEX_NAME(String DMS_INDEX_NAME)
	{
		this.DMS_INDEX_NAME = DMS_INDEX_NAME == null ? null : DMS_INDEX_NAME.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column DMS_SEARCH_INDEX.IMAL_INDEX_NAME
	 *
	 * @return the value of DMS_SEARCH_INDEX.IMAL_INDEX_NAME
	 */
	public String getIMAL_INDEX_NAME()
	{
		return IMAL_INDEX_NAME;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column DMS_SEARCH_INDEX.IMAL_INDEX_NAME
	 *
	 * @param IMAL_INDEX_NAME the value for DMS_SEARCH_INDEX.IMAL_INDEX_NAME
	 */
	public void setIMAL_INDEX_NAME(String IMAL_INDEX_NAME)
	{
		this.IMAL_INDEX_NAME = IMAL_INDEX_NAME == null ? null : IMAL_INDEX_NAME.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column DMS_SEARCH_INDEX.SECTION
	 *
	 * @return the value of DMS_SEARCH_INDEX.SECTION
	 */
	public String getSECTION()
	{
		return SECTION;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column DMS_SEARCH_INDEX.SECTION
	 *
	 * @param SECTION the value for DMS_SEARCH_INDEX.SECTION
	 */
	public void setSECTION(String SECTION)
	{
		this.SECTION = SECTION == null ? null : SECTION.trim();
	}

	public Date getDATE_UPDATED()
	{
		return DATE_UPDATED;
	}

	public void setDATE_UPDATED(Date dATE_UPDATED)
	{
		DATE_UPDATED = dATE_UPDATED;
	}

	public BigDecimal getSCREEN_ID()
	{
		return SCREEN_ID;
	}

	public void setSCREEN_ID(BigDecimal sCREEN_ID)
	{
		SCREEN_ID = sCREEN_ID;
	}

	public BigDecimal getORDER_VALUE()
	{
		return ORDER_VALUE;
	}

	
	public void setORDER_VALUE(BigDecimal oRDER_VALUE)
	{
		ORDER_VALUE = oRDER_VALUE;
	}

	
	public String getEXPRESSION_COLUMNS()
	{
		return EXPRESSION_COLUMNS;
	}

	public void setEXPRESSION_COLUMNS(String eXPRESSION_COLUMNS)
	{
		EXPRESSION_COLUMNS = eXPRESSION_COLUMNS == null ? null : eXPRESSION_COLUMNS.trim();
	}
}
