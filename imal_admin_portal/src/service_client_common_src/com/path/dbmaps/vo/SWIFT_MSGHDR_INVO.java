package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SWIFT_MSGHDR_INVO extends BaseVO {
    /**
     * This field corresponds to the database column SWIFT_MSGHDR_IN.ACK
     */
    private BigDecimal ACK;

    /**
     * This field corresponds to the database column SWIFT_MSGHDR_IN.MSG_CODE
     */
    private String MSG_CODE;

    /**
     * This field corresponds to the database column SWIFT_MSGHDR_IN.SEQ
     */
    private BigDecimal SEQ;

    /**
     * This field corresponds to the database column SWIFT_MSGHDR_IN.BRIEF_DESC_ENG
     */
    private String BRIEF_DESC_ENG;

    /**
     * This field corresponds to the database column SWIFT_MSGHDR_IN.LONG_DESC_ENG
     */
    private String LONG_DESC_ENG;

    /**
     * This field corresponds to the database column SWIFT_MSGHDR_IN.PROC_NAME
     */
    private String PROC_NAME;

    /**
     * This field corresponds to the database column SWIFT_MSGHDR_IN.REPTAG_COND
     */
    private String REPTAG_COND;
    
    
    /**
     * This field corresponds to the database column SWIFT_MSGHDR_IN.GENERATE_ACH_YN
     */
    private BigDecimal GENERATE_ACH_YN;
    
    /**
     * This field corresponds to the database column SWIFT_MSGHDR_IN.LAU_SIGN_YN
     */
    private BigDecimal LAU_SIGN_YN;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSGHDR_IN.ACK
     *
     * @return the value of SWIFT_MSGHDR_IN.ACK
     */
    public BigDecimal getACK() {
        return ACK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSGHDR_IN.ACK
     *
     * @param ACK the value for SWIFT_MSGHDR_IN.ACK
     */
    public void setACK(BigDecimal ACK) {
        this.ACK = ACK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSGHDR_IN.MSG_CODE
     *
     * @return the value of SWIFT_MSGHDR_IN.MSG_CODE
     */
    public String getMSG_CODE() {
        return MSG_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSGHDR_IN.MSG_CODE
     *
     * @param MSG_CODE the value for SWIFT_MSGHDR_IN.MSG_CODE
     */
    public void setMSG_CODE(String MSG_CODE) {
        this.MSG_CODE = MSG_CODE == null ? null : MSG_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSGHDR_IN.SEQ
     *
     * @return the value of SWIFT_MSGHDR_IN.SEQ
     */
    public BigDecimal getSEQ() {
        return SEQ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSGHDR_IN.SEQ
     *
     * @param SEQ the value for SWIFT_MSGHDR_IN.SEQ
     */
    public void setSEQ(BigDecimal SEQ) {
        this.SEQ = SEQ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSGHDR_IN.BRIEF_DESC_ENG
     *
     * @return the value of SWIFT_MSGHDR_IN.BRIEF_DESC_ENG
     */
    public String getBRIEF_DESC_ENG() {
        return BRIEF_DESC_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSGHDR_IN.BRIEF_DESC_ENG
     *
     * @param BRIEF_DESC_ENG the value for SWIFT_MSGHDR_IN.BRIEF_DESC_ENG
     */
    public void setBRIEF_DESC_ENG(String BRIEF_DESC_ENG) {
        this.BRIEF_DESC_ENG = BRIEF_DESC_ENG == null ? null : BRIEF_DESC_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSGHDR_IN.LONG_DESC_ENG
     *
     * @return the value of SWIFT_MSGHDR_IN.LONG_DESC_ENG
     */
    public String getLONG_DESC_ENG() {
        return LONG_DESC_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSGHDR_IN.LONG_DESC_ENG
     *
     * @param LONG_DESC_ENG the value for SWIFT_MSGHDR_IN.LONG_DESC_ENG
     */
    public void setLONG_DESC_ENG(String LONG_DESC_ENG) {
        this.LONG_DESC_ENG = LONG_DESC_ENG == null ? null : LONG_DESC_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSGHDR_IN.PROC_NAME
     *
     * @return the value of SWIFT_MSGHDR_IN.PROC_NAME
     */
    public String getPROC_NAME() {
        return PROC_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSGHDR_IN.PROC_NAME
     *
     * @param PROC_NAME the value for SWIFT_MSGHDR_IN.PROC_NAME
     */
    public void setPROC_NAME(String PROC_NAME) {
        this.PROC_NAME = PROC_NAME == null ? null : PROC_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSGHDR_IN.REPTAG_COND
     *
     * @return the value of SWIFT_MSGHDR_IN.REPTAG_COND
     */
    public String getREPTAG_COND() {
        return REPTAG_COND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSGHDR_IN.REPTAG_COND
     *
     * @param REPTAG_COND the value for SWIFT_MSGHDR_IN.REPTAG_COND
     */
    public void setREPTAG_COND(String REPTAG_COND) {
        this.REPTAG_COND = REPTAG_COND == null ? null : REPTAG_COND.trim();
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSGHDR_IN.GENERATE_ACH_YN
     *
     * @return the value of SWIFT_MSGHDR_IN.GENERATE_ACH_YN
     */
    public BigDecimal getGENERATE_ACH_YN() {
        return GENERATE_ACH_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSGHDR_IN.GENERATE_ACH_YN
     *
     * @param GENERATE_ACH_YN the value for SWIFT_MSGHDR_IN.GENERATE_ACH_YN
     */
    public void setGENERATE_ACH_YN(BigDecimal GENERATE_ACH_YN) {
        this.GENERATE_ACH_YN = GENERATE_ACH_YN;
    }

	public BigDecimal getLAU_SIGN_YN() {
		return LAU_SIGN_YN;
	}

	public void setLAU_SIGN_YN(BigDecimal lAU_SIGN_YN) {
		LAU_SIGN_YN = lAU_SIGN_YN;
	}
}