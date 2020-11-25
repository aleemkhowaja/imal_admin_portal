package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SWIFT_MSGVO extends BaseVO {
    /**
     * This field corresponds to the database column SWIFT_MSG.MSG_CODE
     */
    private String MSG_CODE;

    /**
     * This field corresponds to the database column SWIFT_MSG.BRIEF_DESC_ENG
     */
    private String BRIEF_DESC_ENG;

    /**
     * This field corresponds to the database column SWIFT_MSG.LONG_DESC_ENG
     */
    private String LONG_DESC_ENG;

    /**
     * This field corresponds to the database column SWIFT_MSG.BRIEF_DESC_ARAB
     */
    private String BRIEF_DESC_ARAB;

    /**
     * This field corresponds to the database column SWIFT_MSG.LONG_DESC_ARAB
     */
    private String LONG_DESC_ARAB;

    /**
     * This field corresponds to the database column SWIFT_MSG.MESSAGE_ORDER
     */
    private BigDecimal MESSAGE_ORDER;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSG.MSG_CODE
     *
     * @return the value of SWIFT_MSG.MSG_CODE
     */
    public String getMSG_CODE() {
        return MSG_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSG.MSG_CODE
     *
     * @param MSG_CODE the value for SWIFT_MSG.MSG_CODE
     */
    public void setMSG_CODE(String MSG_CODE) {
        this.MSG_CODE = MSG_CODE == null ? null : MSG_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSG.BRIEF_DESC_ENG
     *
     * @return the value of SWIFT_MSG.BRIEF_DESC_ENG
     */
    public String getBRIEF_DESC_ENG() {
        return BRIEF_DESC_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSG.BRIEF_DESC_ENG
     *
     * @param BRIEF_DESC_ENG the value for SWIFT_MSG.BRIEF_DESC_ENG
     */
    public void setBRIEF_DESC_ENG(String BRIEF_DESC_ENG) {
        this.BRIEF_DESC_ENG = BRIEF_DESC_ENG == null ? null : BRIEF_DESC_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSG.LONG_DESC_ENG
     *
     * @return the value of SWIFT_MSG.LONG_DESC_ENG
     */
    public String getLONG_DESC_ENG() {
        return LONG_DESC_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSG.LONG_DESC_ENG
     *
     * @param LONG_DESC_ENG the value for SWIFT_MSG.LONG_DESC_ENG
     */
    public void setLONG_DESC_ENG(String LONG_DESC_ENG) {
        this.LONG_DESC_ENG = LONG_DESC_ENG == null ? null : LONG_DESC_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSG.BRIEF_DESC_ARAB
     *
     * @return the value of SWIFT_MSG.BRIEF_DESC_ARAB
     */
    public String getBRIEF_DESC_ARAB() {
        return BRIEF_DESC_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSG.BRIEF_DESC_ARAB
     *
     * @param BRIEF_DESC_ARAB the value for SWIFT_MSG.BRIEF_DESC_ARAB
     */
    public void setBRIEF_DESC_ARAB(String BRIEF_DESC_ARAB) {
        this.BRIEF_DESC_ARAB = BRIEF_DESC_ARAB == null ? null : BRIEF_DESC_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSG.LONG_DESC_ARAB
     *
     * @return the value of SWIFT_MSG.LONG_DESC_ARAB
     */
    public String getLONG_DESC_ARAB() {
        return LONG_DESC_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSG.LONG_DESC_ARAB
     *
     * @param LONG_DESC_ARAB the value for SWIFT_MSG.LONG_DESC_ARAB
     */
    public void setLONG_DESC_ARAB(String LONG_DESC_ARAB) {
        this.LONG_DESC_ARAB = LONG_DESC_ARAB == null ? null : LONG_DESC_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSG.MESSAGE_ORDER
     *
     * @return the value of SWIFT_MSG.MESSAGE_ORDER
     */
    public BigDecimal getMESSAGE_ORDER() {
        return MESSAGE_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSG.MESSAGE_ORDER
     *
     * @param MESSAGE_ORDER the value for SWIFT_MSG.MESSAGE_ORDER
     */
    public void setMESSAGE_ORDER(BigDecimal MESSAGE_ORDER) {
        this.MESSAGE_ORDER = MESSAGE_ORDER;
    }
}