package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class DYN_CHRG_TEMPLATE_NODESVOKey extends BaseVO {
    /**
     * This field corresponds to the database column DYN_CHRG_TEMPLATE_NODES.DYN_TEMP_ID
     */
    private BigDecimal DYN_TEMP_ID;

    /**
     * This field corresponds to the database column DYN_CHRG_TEMPLATE_NODES.NODE_ID
     */
    private String NODE_ID;

    /**
     * This field corresponds to the database column DYN_CHRG_TEMPLATE_NODES.PARENT_NODE_ID
     */
    private String PARENT_NODE_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DYN_CHRG_TEMPLATE_NODES.DYN_TEMP_ID
     *
     * @return the value of DYN_CHRG_TEMPLATE_NODES.DYN_TEMP_ID
     */
    public BigDecimal getDYN_TEMP_ID() {
        return DYN_TEMP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DYN_CHRG_TEMPLATE_NODES.DYN_TEMP_ID
     *
     * @param DYN_TEMP_ID the value for DYN_CHRG_TEMPLATE_NODES.DYN_TEMP_ID
     */
    public void setDYN_TEMP_ID(BigDecimal DYN_TEMP_ID) {
        this.DYN_TEMP_ID = DYN_TEMP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DYN_CHRG_TEMPLATE_NODES.NODE_ID
     *
     * @return the value of DYN_CHRG_TEMPLATE_NODES.NODE_ID
     */
    public String getNODE_ID() {
        return NODE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DYN_CHRG_TEMPLATE_NODES.NODE_ID
     *
     * @param NODE_ID the value for DYN_CHRG_TEMPLATE_NODES.NODE_ID
     */
    public void setNODE_ID(String NODE_ID) {
        this.NODE_ID = NODE_ID == null ? null : NODE_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DYN_CHRG_TEMPLATE_NODES.PARENT_NODE_ID
     *
     * @return the value of DYN_CHRG_TEMPLATE_NODES.PARENT_NODE_ID
     */
    public String getPARENT_NODE_ID() {
        return PARENT_NODE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DYN_CHRG_TEMPLATE_NODES.PARENT_NODE_ID
     *
     * @param PARENT_NODE_ID the value for DYN_CHRG_TEMPLATE_NODES.PARENT_NODE_ID
     */
    public void setPARENT_NODE_ID(String PARENT_NODE_ID) {
        this.PARENT_NODE_ID = PARENT_NODE_ID == null ? null : PARENT_NODE_ID.trim();
    }
}