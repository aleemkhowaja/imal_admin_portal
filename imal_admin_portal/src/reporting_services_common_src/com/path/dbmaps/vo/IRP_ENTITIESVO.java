package com.path.dbmaps.vo;

import com.path.vo.reporting.RepBaseVO;

import java.util.Date;

public class IRP_ENTITIESVO extends RepBaseVO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2221660094790242796L;

	/**
     * This field corresponds to the database column IRP_ENTITIES.ENTITY_DB_NAME
     */
    private String ENTITY_DB_NAME;

    /**
     * This field corresponds to the database column IRP_ENTITIES.ENTITY_ALIAS
     */
    private String ENTITY_ALIAS;

    /**
     * This field corresponds to the database column IRP_ENTITIES.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_ENTITIES.ENTITY_DB_NAME
     *
     * @return the value of IRP_ENTITIES.ENTITY_DB_NAME
     */
    public String getENTITY_DB_NAME() {
        return ENTITY_DB_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_ENTITIES.ENTITY_DB_NAME
     *
     * @param ENTITY_DB_NAME the value for IRP_ENTITIES.ENTITY_DB_NAME
     */
    public void setENTITY_DB_NAME(String ENTITY_DB_NAME) {
        this.ENTITY_DB_NAME = ENTITY_DB_NAME == null ? null : ENTITY_DB_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_ENTITIES.ENTITY_ALIAS
     *
     * @return the value of IRP_ENTITIES.ENTITY_ALIAS
     */
    public String getENTITY_ALIAS() {
        return ENTITY_ALIAS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_ENTITIES.ENTITY_ALIAS
     *
     * @param ENTITY_ALIAS the value for IRP_ENTITIES.ENTITY_ALIAS
     */
    public void setENTITY_ALIAS(String ENTITY_ALIAS) {
        this.ENTITY_ALIAS = ENTITY_ALIAS == null ? null : ENTITY_ALIAS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_ENTITIES.DATE_UPDATED
     *
     * @return the value of IRP_ENTITIES.DATE_UPDATED
     */
    public Date getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_ENTITIES.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for IRP_ENTITIES.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED) {
        this.DATE_UPDATED = DATE_UPDATED;
    }
}