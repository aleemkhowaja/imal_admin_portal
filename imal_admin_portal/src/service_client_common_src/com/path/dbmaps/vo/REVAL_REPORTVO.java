package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class REVAL_REPORTVO extends BaseVO {
    /**
     * This field corresponds to the database column REVAL_REPORT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column REVAL_REPORT.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column REVAL_REPORT.USER_ID
     */
    private String USER_ID;

    /**
     * This field corresponds to the database column REVAL_REPORT.ERR_CODE
     */
    private BigDecimal ERR_CODE;

    /**
     * This field corresponds to the database column REVAL_REPORT.ERR_MESSAGE
     */
    private String ERR_MESSAGE;

    /**
     * This field corresponds to the database column REVAL_REPORT.TEST_DTE
     */
    private Date TEST_DTE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REVAL_REPORT.COMP_CODE
     *
     * @return the value of REVAL_REPORT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REVAL_REPORT.COMP_CODE
     *
     * @param COMP_CODE the value for REVAL_REPORT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REVAL_REPORT.BRANCH_CODE
     *
     * @return the value of REVAL_REPORT.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REVAL_REPORT.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for REVAL_REPORT.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REVAL_REPORT.USER_ID
     *
     * @return the value of REVAL_REPORT.USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REVAL_REPORT.USER_ID
     *
     * @param USER_ID the value for REVAL_REPORT.USER_ID
     */
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID == null ? null : USER_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REVAL_REPORT.ERR_CODE
     *
     * @return the value of REVAL_REPORT.ERR_CODE
     */
    public BigDecimal getERR_CODE() {
        return ERR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REVAL_REPORT.ERR_CODE
     *
     * @param ERR_CODE the value for REVAL_REPORT.ERR_CODE
     */
    public void setERR_CODE(BigDecimal ERR_CODE) {
        this.ERR_CODE = ERR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REVAL_REPORT.ERR_MESSAGE
     *
     * @return the value of REVAL_REPORT.ERR_MESSAGE
     */
    public String getERR_MESSAGE() {
        return ERR_MESSAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REVAL_REPORT.ERR_MESSAGE
     *
     * @param ERR_MESSAGE the value for REVAL_REPORT.ERR_MESSAGE
     */
    public void setERR_MESSAGE(String ERR_MESSAGE) {
        this.ERR_MESSAGE = ERR_MESSAGE == null ? null : ERR_MESSAGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REVAL_REPORT.TEST_DTE
     *
     * @return the value of REVAL_REPORT.TEST_DTE
     */
    public Date getTEST_DTE() {
        return TEST_DTE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REVAL_REPORT.TEST_DTE
     *
     * @param TEST_DTE the value for REVAL_REPORT.TEST_DTE
     */
    public void setTEST_DTE(Date TEST_DTE) {
        this.TEST_DTE = TEST_DTE;
    }
}