package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class TRS_REQUEST_CONTRIBUTOR_DETVO extends BaseVO {
    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.REQ_NO
     */
    private BigDecimal REQ_NO;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.SPECIFIC_CIF
     */
    private BigDecimal SPECIFIC_CIF;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.SPECIFIC_COUNTRY
     */
    private BigDecimal SPECIFIC_COUNTRY;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.INVESTMENT_CY
     */
    private BigDecimal INVESTMENT_CY;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.INVESTMENT_AMOUNT
     */
    private BigDecimal INVESTMENT_AMOUNT;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.VALUE_DATE
     */
    private Date VALUE_DATE;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.MATURITY_DATE
     */
    private Date MATURITY_DATE;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.VALUE_DATE_INSTRUCTION
     */
    private String VALUE_DATE_INSTRUCTION;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.MATURITY_DATE_INSTRUCTION
     */
    private String MATURITY_DATE_INSTRUCTION;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.YIELD_FROM
     */
    private BigDecimal YIELD_FROM;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.YIELD_TO
     */
    private BigDecimal YIELD_TO;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.REMARKS
     */
    private String REMARKS;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_BR
     */
    private BigDecimal ACC_BR;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_CY
     */
    private BigDecimal ACC_CY;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_GL
     */
    private BigDecimal ACC_GL;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_CIF
     */
    private BigDecimal ACC_CIF;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_SL
     */
    private BigDecimal ACC_SL;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_IND
     */
    private String ROLLOVER_IND;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMT_TYPE
     */
    private String ROLLOVER_AMT_TYPE;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMOUNT
     */
    private BigDecimal ROLLOVER_AMOUNT;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_METHOD
     */
    private String ROLLOVER_METHOD;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMT_TYPE_2
     */
    private String ROLLOVER_AMT_TYPE_2;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMOUNT_2
     */
    private BigDecimal ROLLOVER_AMOUNT_2;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.BLOCK_CONTRIB_AMT_YN
     */
    private String BLOCK_CONTRIB_AMT_YN;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIB_BLOCKED_AMOUNT
     */
    private BigDecimal CONTRIB_BLOCKED_AMOUNT;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.REASONFORCHANGING
     */
    private BigDecimal REASONFORCHANGING;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_VIA_TRF_YN
     */
    private String CONTRIBBLOCK_VIA_TRF_YN;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_AMT
     */
    private BigDecimal CONTRIBBLOCK_TRF_AMT;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_BLOCK_AMT
     */
    private BigDecimal CONTRIBBLOCK_TRF_BLOCK_AMT;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_REASON
     */
    private String CONTRIBBLOCK_TRF_REASON;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_BR
     */
    private BigDecimal CONTRIBBLOCK_TRF_MARGIN_BR;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_CY
     */
    private BigDecimal CONTRIBBLOCK_TRF_MARGIN_CY;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_GL
     */
    private BigDecimal CONTRIBBLOCK_TRF_MARGIN_GL;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_CIF
     */
    private BigDecimal CONTRIBBLOCK_TRF_MARGIN_CIF;

    /**
     * This field corresponds to the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_SL
     */
    private BigDecimal CONTRIBBLOCK_TRF_MARGIN_SL;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.BRANCH
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.BRANCH
     *
     * @param BRANCH the value for TRS_REQUEST_CONTRIBUTOR_DET.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.COMP_CODE
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.COMP_CODE
     *
     * @param COMP_CODE the value for TRS_REQUEST_CONTRIBUTOR_DET.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.REQ_NO
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.REQ_NO
     */
    public BigDecimal getREQ_NO() {
        return REQ_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.REQ_NO
     *
     * @param REQ_NO the value for TRS_REQUEST_CONTRIBUTOR_DET.REQ_NO
     */
    public void setREQ_NO(BigDecimal REQ_NO) {
        this.REQ_NO = REQ_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.SPECIFIC_CIF
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.SPECIFIC_CIF
     */
    public BigDecimal getSPECIFIC_CIF() {
        return SPECIFIC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.SPECIFIC_CIF
     *
     * @param SPECIFIC_CIF the value for TRS_REQUEST_CONTRIBUTOR_DET.SPECIFIC_CIF
     */
    public void setSPECIFIC_CIF(BigDecimal SPECIFIC_CIF) {
        this.SPECIFIC_CIF = SPECIFIC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.SPECIFIC_COUNTRY
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.SPECIFIC_COUNTRY
     */
    public BigDecimal getSPECIFIC_COUNTRY() {
        return SPECIFIC_COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.SPECIFIC_COUNTRY
     *
     * @param SPECIFIC_COUNTRY the value for TRS_REQUEST_CONTRIBUTOR_DET.SPECIFIC_COUNTRY
     */
    public void setSPECIFIC_COUNTRY(BigDecimal SPECIFIC_COUNTRY) {
        this.SPECIFIC_COUNTRY = SPECIFIC_COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.INVESTMENT_CY
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.INVESTMENT_CY
     */
    public BigDecimal getINVESTMENT_CY() {
        return INVESTMENT_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.INVESTMENT_CY
     *
     * @param INVESTMENT_CY the value for TRS_REQUEST_CONTRIBUTOR_DET.INVESTMENT_CY
     */
    public void setINVESTMENT_CY(BigDecimal INVESTMENT_CY) {
        this.INVESTMENT_CY = INVESTMENT_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.INVESTMENT_AMOUNT
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.INVESTMENT_AMOUNT
     */
    public BigDecimal getINVESTMENT_AMOUNT() {
        return INVESTMENT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.INVESTMENT_AMOUNT
     *
     * @param INVESTMENT_AMOUNT the value for TRS_REQUEST_CONTRIBUTOR_DET.INVESTMENT_AMOUNT
     */
    public void setINVESTMENT_AMOUNT(BigDecimal INVESTMENT_AMOUNT) {
        this.INVESTMENT_AMOUNT = INVESTMENT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.VALUE_DATE
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.VALUE_DATE
     */
    public Date getVALUE_DATE() {
        return VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.VALUE_DATE
     *
     * @param VALUE_DATE the value for TRS_REQUEST_CONTRIBUTOR_DET.VALUE_DATE
     */
    public void setVALUE_DATE(Date VALUE_DATE) {
        this.VALUE_DATE = VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.MATURITY_DATE
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.MATURITY_DATE
     */
    public Date getMATURITY_DATE() {
        return MATURITY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.MATURITY_DATE
     *
     * @param MATURITY_DATE the value for TRS_REQUEST_CONTRIBUTOR_DET.MATURITY_DATE
     */
    public void setMATURITY_DATE(Date MATURITY_DATE) {
        this.MATURITY_DATE = MATURITY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.VALUE_DATE_INSTRUCTION
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.VALUE_DATE_INSTRUCTION
     */
    public String getVALUE_DATE_INSTRUCTION() {
        return VALUE_DATE_INSTRUCTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.VALUE_DATE_INSTRUCTION
     *
     * @param VALUE_DATE_INSTRUCTION the value for TRS_REQUEST_CONTRIBUTOR_DET.VALUE_DATE_INSTRUCTION
     */
    public void setVALUE_DATE_INSTRUCTION(String VALUE_DATE_INSTRUCTION) {
        this.VALUE_DATE_INSTRUCTION = VALUE_DATE_INSTRUCTION == null ? null : VALUE_DATE_INSTRUCTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.MATURITY_DATE_INSTRUCTION
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.MATURITY_DATE_INSTRUCTION
     */
    public String getMATURITY_DATE_INSTRUCTION() {
        return MATURITY_DATE_INSTRUCTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.MATURITY_DATE_INSTRUCTION
     *
     * @param MATURITY_DATE_INSTRUCTION the value for TRS_REQUEST_CONTRIBUTOR_DET.MATURITY_DATE_INSTRUCTION
     */
    public void setMATURITY_DATE_INSTRUCTION(String MATURITY_DATE_INSTRUCTION) {
        this.MATURITY_DATE_INSTRUCTION = MATURITY_DATE_INSTRUCTION == null ? null : MATURITY_DATE_INSTRUCTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.YIELD_FROM
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.YIELD_FROM
     */
    public BigDecimal getYIELD_FROM() {
        return YIELD_FROM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.YIELD_FROM
     *
     * @param YIELD_FROM the value for TRS_REQUEST_CONTRIBUTOR_DET.YIELD_FROM
     */
    public void setYIELD_FROM(BigDecimal YIELD_FROM) {
        this.YIELD_FROM = YIELD_FROM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.YIELD_TO
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.YIELD_TO
     */
    public BigDecimal getYIELD_TO() {
        return YIELD_TO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.YIELD_TO
     *
     * @param YIELD_TO the value for TRS_REQUEST_CONTRIBUTOR_DET.YIELD_TO
     */
    public void setYIELD_TO(BigDecimal YIELD_TO) {
        this.YIELD_TO = YIELD_TO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.REMARKS
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.REMARKS
     */
    public String getREMARKS() {
        return REMARKS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.REMARKS
     *
     * @param REMARKS the value for TRS_REQUEST_CONTRIBUTOR_DET.REMARKS
     */
    public void setREMARKS(String REMARKS) {
        this.REMARKS = REMARKS == null ? null : REMARKS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_BR
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.ACC_BR
     */
    public BigDecimal getACC_BR() {
        return ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_BR
     *
     * @param ACC_BR the value for TRS_REQUEST_CONTRIBUTOR_DET.ACC_BR
     */
    public void setACC_BR(BigDecimal ACC_BR) {
        this.ACC_BR = ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_CY
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.ACC_CY
     */
    public BigDecimal getACC_CY() {
        return ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_CY
     *
     * @param ACC_CY the value for TRS_REQUEST_CONTRIBUTOR_DET.ACC_CY
     */
    public void setACC_CY(BigDecimal ACC_CY) {
        this.ACC_CY = ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_GL
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.ACC_GL
     */
    public BigDecimal getACC_GL() {
        return ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_GL
     *
     * @param ACC_GL the value for TRS_REQUEST_CONTRIBUTOR_DET.ACC_GL
     */
    public void setACC_GL(BigDecimal ACC_GL) {
        this.ACC_GL = ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_CIF
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.ACC_CIF
     */
    public BigDecimal getACC_CIF() {
        return ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_CIF
     *
     * @param ACC_CIF the value for TRS_REQUEST_CONTRIBUTOR_DET.ACC_CIF
     */
    public void setACC_CIF(BigDecimal ACC_CIF) {
        this.ACC_CIF = ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_SL
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.ACC_SL
     */
    public BigDecimal getACC_SL() {
        return ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ACC_SL
     *
     * @param ACC_SL the value for TRS_REQUEST_CONTRIBUTOR_DET.ACC_SL
     */
    public void setACC_SL(BigDecimal ACC_SL) {
        this.ACC_SL = ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_IND
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_IND
     */
    public String getROLLOVER_IND() {
        return ROLLOVER_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_IND
     *
     * @param ROLLOVER_IND the value for TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_IND
     */
    public void setROLLOVER_IND(String ROLLOVER_IND) {
        this.ROLLOVER_IND = ROLLOVER_IND == null ? null : ROLLOVER_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMT_TYPE
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMT_TYPE
     */
    public String getROLLOVER_AMT_TYPE() {
        return ROLLOVER_AMT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMT_TYPE
     *
     * @param ROLLOVER_AMT_TYPE the value for TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMT_TYPE
     */
    public void setROLLOVER_AMT_TYPE(String ROLLOVER_AMT_TYPE) {
        this.ROLLOVER_AMT_TYPE = ROLLOVER_AMT_TYPE == null ? null : ROLLOVER_AMT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMOUNT
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMOUNT
     */
    public BigDecimal getROLLOVER_AMOUNT() {
        return ROLLOVER_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMOUNT
     *
     * @param ROLLOVER_AMOUNT the value for TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMOUNT
     */
    public void setROLLOVER_AMOUNT(BigDecimal ROLLOVER_AMOUNT) {
        this.ROLLOVER_AMOUNT = ROLLOVER_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_METHOD
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_METHOD
     */
    public String getROLLOVER_METHOD() {
        return ROLLOVER_METHOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_METHOD
     *
     * @param ROLLOVER_METHOD the value for TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_METHOD
     */
    public void setROLLOVER_METHOD(String ROLLOVER_METHOD) {
        this.ROLLOVER_METHOD = ROLLOVER_METHOD == null ? null : ROLLOVER_METHOD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMT_TYPE_2
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMT_TYPE_2
     */
    public String getROLLOVER_AMT_TYPE_2() {
        return ROLLOVER_AMT_TYPE_2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMT_TYPE_2
     *
     * @param ROLLOVER_AMT_TYPE_2 the value for TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMT_TYPE_2
     */
    public void setROLLOVER_AMT_TYPE_2(String ROLLOVER_AMT_TYPE_2) {
        this.ROLLOVER_AMT_TYPE_2 = ROLLOVER_AMT_TYPE_2 == null ? null : ROLLOVER_AMT_TYPE_2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMOUNT_2
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMOUNT_2
     */
    public BigDecimal getROLLOVER_AMOUNT_2() {
        return ROLLOVER_AMOUNT_2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMOUNT_2
     *
     * @param ROLLOVER_AMOUNT_2 the value for TRS_REQUEST_CONTRIBUTOR_DET.ROLLOVER_AMOUNT_2
     */
    public void setROLLOVER_AMOUNT_2(BigDecimal ROLLOVER_AMOUNT_2) {
        this.ROLLOVER_AMOUNT_2 = ROLLOVER_AMOUNT_2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.BLOCK_CONTRIB_AMT_YN
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.BLOCK_CONTRIB_AMT_YN
     */
    public String getBLOCK_CONTRIB_AMT_YN() {
        return BLOCK_CONTRIB_AMT_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.BLOCK_CONTRIB_AMT_YN
     *
     * @param BLOCK_CONTRIB_AMT_YN the value for TRS_REQUEST_CONTRIBUTOR_DET.BLOCK_CONTRIB_AMT_YN
     */
    public void setBLOCK_CONTRIB_AMT_YN(String BLOCK_CONTRIB_AMT_YN) {
        this.BLOCK_CONTRIB_AMT_YN = BLOCK_CONTRIB_AMT_YN == null ? null : BLOCK_CONTRIB_AMT_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIB_BLOCKED_AMOUNT
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.CONTRIB_BLOCKED_AMOUNT
     */
    public BigDecimal getCONTRIB_BLOCKED_AMOUNT() {
        return CONTRIB_BLOCKED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIB_BLOCKED_AMOUNT
     *
     * @param CONTRIB_BLOCKED_AMOUNT the value for TRS_REQUEST_CONTRIBUTOR_DET.CONTRIB_BLOCKED_AMOUNT
     */
    public void setCONTRIB_BLOCKED_AMOUNT(BigDecimal CONTRIB_BLOCKED_AMOUNT) {
        this.CONTRIB_BLOCKED_AMOUNT = CONTRIB_BLOCKED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.REASONFORCHANGING
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.REASONFORCHANGING
     */
    public BigDecimal getREASONFORCHANGING() {
        return REASONFORCHANGING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.REASONFORCHANGING
     *
     * @param REASONFORCHANGING the value for TRS_REQUEST_CONTRIBUTOR_DET.REASONFORCHANGING
     */
    public void setREASONFORCHANGING(BigDecimal REASONFORCHANGING) {
        this.REASONFORCHANGING = REASONFORCHANGING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_VIA_TRF_YN
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_VIA_TRF_YN
     */
    public String getCONTRIBBLOCK_VIA_TRF_YN() {
        return CONTRIBBLOCK_VIA_TRF_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_VIA_TRF_YN
     *
     * @param CONTRIBBLOCK_VIA_TRF_YN the value for TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_VIA_TRF_YN
     */
    public void setCONTRIBBLOCK_VIA_TRF_YN(String CONTRIBBLOCK_VIA_TRF_YN) {
        this.CONTRIBBLOCK_VIA_TRF_YN = CONTRIBBLOCK_VIA_TRF_YN == null ? null : CONTRIBBLOCK_VIA_TRF_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_AMT
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_AMT
     */
    public BigDecimal getCONTRIBBLOCK_TRF_AMT() {
        return CONTRIBBLOCK_TRF_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_AMT
     *
     * @param CONTRIBBLOCK_TRF_AMT the value for TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_AMT
     */
    public void setCONTRIBBLOCK_TRF_AMT(BigDecimal CONTRIBBLOCK_TRF_AMT) {
        this.CONTRIBBLOCK_TRF_AMT = CONTRIBBLOCK_TRF_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_BLOCK_AMT
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_BLOCK_AMT
     */
    public BigDecimal getCONTRIBBLOCK_TRF_BLOCK_AMT() {
        return CONTRIBBLOCK_TRF_BLOCK_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_BLOCK_AMT
     *
     * @param CONTRIBBLOCK_TRF_BLOCK_AMT the value for TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_BLOCK_AMT
     */
    public void setCONTRIBBLOCK_TRF_BLOCK_AMT(BigDecimal CONTRIBBLOCK_TRF_BLOCK_AMT) {
        this.CONTRIBBLOCK_TRF_BLOCK_AMT = CONTRIBBLOCK_TRF_BLOCK_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_REASON
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_REASON
     */
    public String getCONTRIBBLOCK_TRF_REASON() {
        return CONTRIBBLOCK_TRF_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_REASON
     *
     * @param CONTRIBBLOCK_TRF_REASON the value for TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_REASON
     */
    public void setCONTRIBBLOCK_TRF_REASON(String CONTRIBBLOCK_TRF_REASON) {
        this.CONTRIBBLOCK_TRF_REASON = CONTRIBBLOCK_TRF_REASON == null ? null : CONTRIBBLOCK_TRF_REASON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_BR
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_BR
     */
    public BigDecimal getCONTRIBBLOCK_TRF_MARGIN_BR() {
        return CONTRIBBLOCK_TRF_MARGIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_BR
     *
     * @param CONTRIBBLOCK_TRF_MARGIN_BR the value for TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_BR
     */
    public void setCONTRIBBLOCK_TRF_MARGIN_BR(BigDecimal CONTRIBBLOCK_TRF_MARGIN_BR) {
        this.CONTRIBBLOCK_TRF_MARGIN_BR = CONTRIBBLOCK_TRF_MARGIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_CY
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_CY
     */
    public BigDecimal getCONTRIBBLOCK_TRF_MARGIN_CY() {
        return CONTRIBBLOCK_TRF_MARGIN_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_CY
     *
     * @param CONTRIBBLOCK_TRF_MARGIN_CY the value for TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_CY
     */
    public void setCONTRIBBLOCK_TRF_MARGIN_CY(BigDecimal CONTRIBBLOCK_TRF_MARGIN_CY) {
        this.CONTRIBBLOCK_TRF_MARGIN_CY = CONTRIBBLOCK_TRF_MARGIN_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_GL
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_GL
     */
    public BigDecimal getCONTRIBBLOCK_TRF_MARGIN_GL() {
        return CONTRIBBLOCK_TRF_MARGIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_GL
     *
     * @param CONTRIBBLOCK_TRF_MARGIN_GL the value for TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_GL
     */
    public void setCONTRIBBLOCK_TRF_MARGIN_GL(BigDecimal CONTRIBBLOCK_TRF_MARGIN_GL) {
        this.CONTRIBBLOCK_TRF_MARGIN_GL = CONTRIBBLOCK_TRF_MARGIN_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_CIF
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_CIF
     */
    public BigDecimal getCONTRIBBLOCK_TRF_MARGIN_CIF() {
        return CONTRIBBLOCK_TRF_MARGIN_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_CIF
     *
     * @param CONTRIBBLOCK_TRF_MARGIN_CIF the value for TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_CIF
     */
    public void setCONTRIBBLOCK_TRF_MARGIN_CIF(BigDecimal CONTRIBBLOCK_TRF_MARGIN_CIF) {
        this.CONTRIBBLOCK_TRF_MARGIN_CIF = CONTRIBBLOCK_TRF_MARGIN_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_SL
     *
     * @return the value of TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_SL
     */
    public BigDecimal getCONTRIBBLOCK_TRF_MARGIN_SL() {
        return CONTRIBBLOCK_TRF_MARGIN_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_SL
     *
     * @param CONTRIBBLOCK_TRF_MARGIN_SL the value for TRS_REQUEST_CONTRIBUTOR_DET.CONTRIBBLOCK_TRF_MARGIN_SL
     */
    public void setCONTRIBBLOCK_TRF_MARGIN_SL(BigDecimal CONTRIBBLOCK_TRF_MARGIN_SL) {
        this.CONTRIBBLOCK_TRF_MARGIN_SL = CONTRIBBLOCK_TRF_MARGIN_SL;
    }
}