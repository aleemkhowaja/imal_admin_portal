package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class BRANCH_SESSIONVOKey extends BaseVO {
    /**
     * This field corresponds to the database column BRANCH_SESSION.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column BRANCH_SESSION.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column BRANCH_SESSION.DATE_OPENED
     */
    private Date DATE_OPENED;

    /**
     * This field corresponds to the database column BRANCH_SESSION.STATUS
     */
    private String STATUS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BRANCH_SESSION.BRANCH_CODE
     *
     * @return the value of BRANCH_SESSION.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BRANCH_SESSION.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for BRANCH_SESSION.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BRANCH_SESSION.COMP_CODE
     *
     * @return the value of BRANCH_SESSION.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BRANCH_SESSION.COMP_CODE
     *
     * @param COMP_CODE the value for BRANCH_SESSION.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BRANCH_SESSION.DATE_OPENED
     *
     * @return the value of BRANCH_SESSION.DATE_OPENED
     */
    public Date getDATE_OPENED() {
        return DATE_OPENED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BRANCH_SESSION.DATE_OPENED
     *
     * @param DATE_OPENED the value for BRANCH_SESSION.DATE_OPENED
     */
    public void setDATE_OPENED(Date DATE_OPENED) {
        this.DATE_OPENED = DATE_OPENED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BRANCH_SESSION.STATUS
     *
     * @return the value of BRANCH_SESSION.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BRANCH_SESSION.STATUS
     *
     * @param STATUS the value for BRANCH_SESSION.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }
}