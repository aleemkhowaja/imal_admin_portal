package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

public class TRS_RPT_COLLATERAL_STATUSVO extends BaseVO {

    
    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.USER_ID
     */
    private String USER_ID;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.ORIGIN
     */
    private String ORIGIN;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.SERIAL_NO
     */
    private BigDecimal SERIAL_NO;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.CURRENCY
     */
    private BigDecimal CURRENCY;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.SHORT_NAME_ENG
     */
    private String SHORT_NAME_ENG;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.BRIEF_NAME_ENG
     */
    private String BRIEF_NAME_ENG;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.DEAL_ORIGINAL
     */
    private BigDecimal DEAL_ORIGINAL;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.FINAL_MATURITY_DATE
     */
    private Date FINAL_MATURITY_DATE;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.COLLATERAL_DESC
     */
    private String COLLATERAL_DESC;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.COLL_VALUE
     */
    private BigDecimal COLL_VALUE;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.MIN_REQ
     */
    private BigDecimal MIN_REQ;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.TRSDEAL_CY
     */
    private BigDecimal TRSDEAL_CY;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.DEAL_AMOUNT
     */
    private BigDecimal DEAL_AMOUNT;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.COV_VALUE
     */
    private BigDecimal COV_VALUE;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.DEAL_COLL_VALUE
     */
    private BigDecimal DEAL_COLL_VALUE;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.DEAL_DISC_VALUE
     */
    private BigDecimal DEAL_DISC_VALUE;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.MINREQCOV_FLAG
     */
    private String MINREQCOV_FLAG;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.LIMIT_SERIAL_NO
     */
    private BigDecimal LIMIT_SERIAL_NO;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.TRX_NO_CUSTOM
     */
    private String TRX_NO_CUSTOM;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.COLL_VALUE_IN_COLL_CY
     */
    private BigDecimal COLL_VALUE_IN_COLL_CY;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.DEAL_AMOUNT_CV
     */
    private BigDecimal DEAL_AMOUNT_CV;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.SP_ID
     */
    private BigDecimal SP_ID;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.DEAL_STATUS
     */
    private String DEAL_STATUS;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.ALLOCATED_COLLATERAL_AMOUNT
     */
    private BigDecimal ALLOCATED_COLLATERAL_AMOUNT;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.DEAL_COVERAGE
     */
    private BigDecimal DEAL_COVERAGE;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.DEAL_COVERAGE_FULL
     */
    private String DEAL_COVERAGE_FULL;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.MIN_REQUIRED_BASE
     */
    private String MIN_REQUIRED_BASE;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.MIN_REQUIRED_MIN
     */
    private String MIN_REQUIRED_MIN;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.COVERAGE_STATUS
     */
    private String COVERAGE_STATUS;

    /**
     * This field corresponds to the database column TRS_RPT_COLLATERAL_STATUS.ALLOCATED_OUTSTANDING_AMOUNT
     */
    private BigDecimal ALLOCATED_OUTSTANDING_AMOUNT;

    /**
     * This field corresponds to the database column
     * TRS_RPT_COLLATERAL_STATUS.COLLATERAL_BRANCH
     */
    private BigDecimal COLLATERAL_BRANCH;


    /**
     * This field corresponds to the database column
     * TRS_RPT_COLLATERAL_STATUS.FORCED_COLLATERAL_VALUE
     */
    private BigDecimal FORCED_COLLATERAL_VALUE;

    /**
     * This field corresponds to the database column
     * TRS_RPT_COLLATERAL_STATUS.FORCED_COVERAGE_VALUE
     */
    private BigDecimal FORCED_COVERAGE_VALUE;
    
    
    /**
     * @return the FORCED_COLLATERAL_VALUE
     */
    public BigDecimal getFORCED_COLLATERAL_VALUE()
    {
	return FORCED_COLLATERAL_VALUE;
    }

    /**
     * @param FORCED_COLLATERAL_VALUE the FORCED_COLLATERAL_VALUE to set
     */
    public void setFORCED_COLLATERAL_VALUE(BigDecimal FORCED_COLLATERAL_VALUE)
    {
	this.FORCED_COLLATERAL_VALUE = FORCED_COLLATERAL_VALUE;
    }
    
    /**
     * @return the FORCED_COVERAGE_VALUE
     */
    public BigDecimal getFORCED_COVERAGE_VALUE()
    {
	return FORCED_COVERAGE_VALUE;
    }

    /**
     * @param COLLATERAL_BRANCH the FORCED_COVERAGE_VALUE to set
     */
    public void setFORCED_COVERAGE_VALUE(BigDecimal FORCED_COVERAGE_VALUE)
    {
	this.FORCED_COVERAGE_VALUE = FORCED_COVERAGE_VALUE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.COMP_CODE
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.COMP_CODE
     *
     * @param COMP_CODE the value for TRS_RPT_COLLATERAL_STATUS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.BRANCH_CODE
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRS_RPT_COLLATERAL_STATUS.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.CIF_NO
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.CIF_NO
     *
     * @param CIF_NO the value for TRS_RPT_COLLATERAL_STATUS.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.USER_ID
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.USER_ID
     *
     * @param USER_ID the value for TRS_RPT_COLLATERAL_STATUS.USER_ID
     */
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID == null ? null : USER_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.ORIGIN
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.ORIGIN
     */
    public String getORIGIN() {
        return ORIGIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.ORIGIN
     *
     * @param ORIGIN the value for TRS_RPT_COLLATERAL_STATUS.ORIGIN
     */
    public void setORIGIN(String ORIGIN) {
        this.ORIGIN = ORIGIN == null ? null : ORIGIN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.SERIAL_NO
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.SERIAL_NO
     */
    public BigDecimal getSERIAL_NO() {
        return SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.SERIAL_NO
     *
     * @param SERIAL_NO the value for TRS_RPT_COLLATERAL_STATUS.SERIAL_NO
     */
    public void setSERIAL_NO(BigDecimal SERIAL_NO) {
        this.SERIAL_NO = SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.CODE
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.CODE
     *
     * @param CODE the value for TRS_RPT_COLLATERAL_STATUS.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.CURRENCY
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.CURRENCY
     */
    public BigDecimal getCURRENCY() {
        return CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.CURRENCY
     *
     * @param CURRENCY the value for TRS_RPT_COLLATERAL_STATUS.CURRENCY
     */
    public void setCURRENCY(BigDecimal CURRENCY) {
        this.CURRENCY = CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.SHORT_NAME_ENG
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.SHORT_NAME_ENG
     */
    public String getSHORT_NAME_ENG() {
        return SHORT_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.SHORT_NAME_ENG
     *
     * @param SHORT_NAME_ENG the value for TRS_RPT_COLLATERAL_STATUS.SHORT_NAME_ENG
     */
    public void setSHORT_NAME_ENG(String SHORT_NAME_ENG) {
        this.SHORT_NAME_ENG = SHORT_NAME_ENG == null ? null : SHORT_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.BRIEF_NAME_ENG
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.BRIEF_NAME_ENG
     */
    public String getBRIEF_NAME_ENG() {
        return BRIEF_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.BRIEF_NAME_ENG
     *
     * @param BRIEF_NAME_ENG the value for TRS_RPT_COLLATERAL_STATUS.BRIEF_NAME_ENG
     */
    public void setBRIEF_NAME_ENG(String BRIEF_NAME_ENG) {
        this.BRIEF_NAME_ENG = BRIEF_NAME_ENG == null ? null : BRIEF_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.STATUS
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.STATUS
     *
     * @param STATUS the value for TRS_RPT_COLLATERAL_STATUS.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_ORIGINAL
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.DEAL_ORIGINAL
     */
    public BigDecimal getDEAL_ORIGINAL() {
        return DEAL_ORIGINAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_ORIGINAL
     *
     * @param DEAL_ORIGINAL the value for TRS_RPT_COLLATERAL_STATUS.DEAL_ORIGINAL
     */
    public void setDEAL_ORIGINAL(BigDecimal DEAL_ORIGINAL) {
        this.DEAL_ORIGINAL = DEAL_ORIGINAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.FINAL_MATURITY_DATE
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.FINAL_MATURITY_DATE
     */
    public Date getFINAL_MATURITY_DATE() {
        return FINAL_MATURITY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.FINAL_MATURITY_DATE
     *
     * @param FINAL_MATURITY_DATE the value for TRS_RPT_COLLATERAL_STATUS.FINAL_MATURITY_DATE
     */
    public void setFINAL_MATURITY_DATE(Date FINAL_MATURITY_DATE) {
        this.FINAL_MATURITY_DATE = FINAL_MATURITY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.COLLATERAL_DESC
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.COLLATERAL_DESC
     */
    public String getCOLLATERAL_DESC() {
        return COLLATERAL_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.COLLATERAL_DESC
     *
     * @param COLLATERAL_DESC the value for TRS_RPT_COLLATERAL_STATUS.COLLATERAL_DESC
     */
    public void setCOLLATERAL_DESC(String COLLATERAL_DESC) {
        this.COLLATERAL_DESC = COLLATERAL_DESC == null ? null : COLLATERAL_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.COLL_VALUE
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.COLL_VALUE
     */
    public BigDecimal getCOLL_VALUE() {
        return COLL_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.COLL_VALUE
     *
     * @param COLL_VALUE the value for TRS_RPT_COLLATERAL_STATUS.COLL_VALUE
     */
    public void setCOLL_VALUE(BigDecimal COLL_VALUE) {
        this.COLL_VALUE = COLL_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.MIN_REQ
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.MIN_REQ
     */
    public BigDecimal getMIN_REQ() {
        return MIN_REQ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.MIN_REQ
     *
     * @param MIN_REQ the value for TRS_RPT_COLLATERAL_STATUS.MIN_REQ
     */
    public void setMIN_REQ(BigDecimal MIN_REQ) {
        this.MIN_REQ = MIN_REQ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.TRSDEAL_CY
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.TRSDEAL_CY
     */
    public BigDecimal getTRSDEAL_CY() {
        return TRSDEAL_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.TRSDEAL_CY
     *
     * @param TRSDEAL_CY the value for TRS_RPT_COLLATERAL_STATUS.TRSDEAL_CY
     */
    public void setTRSDEAL_CY(BigDecimal TRSDEAL_CY) {
        this.TRSDEAL_CY = TRSDEAL_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_AMOUNT
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.DEAL_AMOUNT
     */
    public BigDecimal getDEAL_AMOUNT() {
        return DEAL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_AMOUNT
     *
     * @param DEAL_AMOUNT the value for TRS_RPT_COLLATERAL_STATUS.DEAL_AMOUNT
     */
    public void setDEAL_AMOUNT(BigDecimal DEAL_AMOUNT) {
        this.DEAL_AMOUNT = DEAL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.COV_VALUE
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.COV_VALUE
     */
    public BigDecimal getCOV_VALUE() {
        return COV_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.COV_VALUE
     *
     * @param COV_VALUE the value for TRS_RPT_COLLATERAL_STATUS.COV_VALUE
     */
    public void setCOV_VALUE(BigDecimal COV_VALUE) {
        this.COV_VALUE = COV_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_COLL_VALUE
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.DEAL_COLL_VALUE
     */
    public BigDecimal getDEAL_COLL_VALUE() {
        return DEAL_COLL_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_COLL_VALUE
     *
     * @param DEAL_COLL_VALUE the value for TRS_RPT_COLLATERAL_STATUS.DEAL_COLL_VALUE
     */
    public void setDEAL_COLL_VALUE(BigDecimal DEAL_COLL_VALUE) {
        this.DEAL_COLL_VALUE = DEAL_COLL_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_DISC_VALUE
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.DEAL_DISC_VALUE
     */
    public BigDecimal getDEAL_DISC_VALUE() {
        return DEAL_DISC_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_DISC_VALUE
     *
     * @param DEAL_DISC_VALUE the value for TRS_RPT_COLLATERAL_STATUS.DEAL_DISC_VALUE
     */
    public void setDEAL_DISC_VALUE(BigDecimal DEAL_DISC_VALUE) {
        this.DEAL_DISC_VALUE = DEAL_DISC_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.MINREQCOV_FLAG
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.MINREQCOV_FLAG
     */
    public String getMINREQCOV_FLAG() {
        return MINREQCOV_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.MINREQCOV_FLAG
     *
     * @param MINREQCOV_FLAG the value for TRS_RPT_COLLATERAL_STATUS.MINREQCOV_FLAG
     */
    public void setMINREQCOV_FLAG(String MINREQCOV_FLAG) {
        this.MINREQCOV_FLAG = MINREQCOV_FLAG == null ? null : MINREQCOV_FLAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.LIMIT_SERIAL_NO
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.LIMIT_SERIAL_NO
     */
    public BigDecimal getLIMIT_SERIAL_NO() {
        return LIMIT_SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.LIMIT_SERIAL_NO
     *
     * @param LIMIT_SERIAL_NO the value for TRS_RPT_COLLATERAL_STATUS.LIMIT_SERIAL_NO
     */
    public void setLIMIT_SERIAL_NO(BigDecimal LIMIT_SERIAL_NO) {
        this.LIMIT_SERIAL_NO = LIMIT_SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.TRX_NO_CUSTOM
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.TRX_NO_CUSTOM
     */
    public String getTRX_NO_CUSTOM() {
        return TRX_NO_CUSTOM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.TRX_NO_CUSTOM
     *
     * @param TRX_NO_CUSTOM the value for TRS_RPT_COLLATERAL_STATUS.TRX_NO_CUSTOM
     */
    public void setTRX_NO_CUSTOM(String TRX_NO_CUSTOM) {
        this.TRX_NO_CUSTOM = TRX_NO_CUSTOM == null ? null : TRX_NO_CUSTOM.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.COLL_VALUE_IN_COLL_CY
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.COLL_VALUE_IN_COLL_CY
     */
    public BigDecimal getCOLL_VALUE_IN_COLL_CY() {
        return COLL_VALUE_IN_COLL_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.COLL_VALUE_IN_COLL_CY
     *
     * @param COLL_VALUE_IN_COLL_CY the value for TRS_RPT_COLLATERAL_STATUS.COLL_VALUE_IN_COLL_CY
     */
    public void setCOLL_VALUE_IN_COLL_CY(BigDecimal COLL_VALUE_IN_COLL_CY) {
        this.COLL_VALUE_IN_COLL_CY = COLL_VALUE_IN_COLL_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_AMOUNT_CV
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.DEAL_AMOUNT_CV
     */
    public BigDecimal getDEAL_AMOUNT_CV() {
        return DEAL_AMOUNT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_AMOUNT_CV
     *
     * @param DEAL_AMOUNT_CV the value for TRS_RPT_COLLATERAL_STATUS.DEAL_AMOUNT_CV
     */
    public void setDEAL_AMOUNT_CV(BigDecimal DEAL_AMOUNT_CV) {
        this.DEAL_AMOUNT_CV = DEAL_AMOUNT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.SP_ID
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.SP_ID
     */
    public BigDecimal getSP_ID() {
        return SP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.SP_ID
     *
     * @param SP_ID the value for TRS_RPT_COLLATERAL_STATUS.SP_ID
     */
    public void setSP_ID(BigDecimal SP_ID) {
        this.SP_ID = SP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_STATUS
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.DEAL_STATUS
     */
    public String getDEAL_STATUS() {
        return DEAL_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_STATUS
     *
     * @param DEAL_STATUS the value for TRS_RPT_COLLATERAL_STATUS.DEAL_STATUS
     */
    public void setDEAL_STATUS(String DEAL_STATUS) {
        this.DEAL_STATUS = DEAL_STATUS == null ? null : DEAL_STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.ALLOCATED_COLLATERAL_AMOUNT
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.ALLOCATED_COLLATERAL_AMOUNT
     */
    public BigDecimal getALLOCATED_COLLATERAL_AMOUNT() {
        return ALLOCATED_COLLATERAL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.ALLOCATED_COLLATERAL_AMOUNT
     *
     * @param ALLOCATED_COLLATERAL_AMOUNT the value for TRS_RPT_COLLATERAL_STATUS.ALLOCATED_COLLATERAL_AMOUNT
     */
    public void setALLOCATED_COLLATERAL_AMOUNT(BigDecimal ALLOCATED_COLLATERAL_AMOUNT) {
        this.ALLOCATED_COLLATERAL_AMOUNT = ALLOCATED_COLLATERAL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_COVERAGE
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.DEAL_COVERAGE
     */
    public BigDecimal getDEAL_COVERAGE() {
        return DEAL_COVERAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_COVERAGE
     *
     * @param DEAL_COVERAGE the value for TRS_RPT_COLLATERAL_STATUS.DEAL_COVERAGE
     */
    public void setDEAL_COVERAGE(BigDecimal DEAL_COVERAGE) {
        this.DEAL_COVERAGE = DEAL_COVERAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_COVERAGE_FULL
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.DEAL_COVERAGE_FULL
     */
    public String getDEAL_COVERAGE_FULL() {
        return DEAL_COVERAGE_FULL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.DEAL_COVERAGE_FULL
     *
     * @param DEAL_COVERAGE_FULL the value for TRS_RPT_COLLATERAL_STATUS.DEAL_COVERAGE_FULL
     */
    public void setDEAL_COVERAGE_FULL(String DEAL_COVERAGE_FULL) {
        this.DEAL_COVERAGE_FULL = DEAL_COVERAGE_FULL == null ? null : DEAL_COVERAGE_FULL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.MIN_REQUIRED_BASE
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.MIN_REQUIRED_BASE
     */
    public String getMIN_REQUIRED_BASE() {
        return MIN_REQUIRED_BASE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.MIN_REQUIRED_BASE
     *
     * @param MIN_REQUIRED_BASE the value for TRS_RPT_COLLATERAL_STATUS.MIN_REQUIRED_BASE
     */
    public void setMIN_REQUIRED_BASE(String MIN_REQUIRED_BASE) {
        this.MIN_REQUIRED_BASE = MIN_REQUIRED_BASE == null ? null : MIN_REQUIRED_BASE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.MIN_REQUIRED_MIN
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.MIN_REQUIRED_MIN
     */
    public String getMIN_REQUIRED_MIN() {
        return MIN_REQUIRED_MIN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.MIN_REQUIRED_MIN
     *
     * @param MIN_REQUIRED_MIN the value for TRS_RPT_COLLATERAL_STATUS.MIN_REQUIRED_MIN
     */
    public void setMIN_REQUIRED_MIN(String MIN_REQUIRED_MIN) {
        this.MIN_REQUIRED_MIN = MIN_REQUIRED_MIN == null ? null : MIN_REQUIRED_MIN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.COVERAGE_STATUS
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.COVERAGE_STATUS
     */
    public String getCOVERAGE_STATUS() {
        return COVERAGE_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.COVERAGE_STATUS
     *
     * @param COVERAGE_STATUS the value for TRS_RPT_COLLATERAL_STATUS.COVERAGE_STATUS
     */
    public void setCOVERAGE_STATUS(String COVERAGE_STATUS) {
        this.COVERAGE_STATUS = COVERAGE_STATUS == null ? null : COVERAGE_STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_RPT_COLLATERAL_STATUS.ALLOCATED_OUTSTANDING_AMOUNT
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.ALLOCATED_OUTSTANDING_AMOUNT
     */
    public BigDecimal getALLOCATED_OUTSTANDING_AMOUNT() {
        return ALLOCATED_OUTSTANDING_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_RPT_COLLATERAL_STATUS.ALLOCATED_OUTSTANDING_AMOUNT
     *
     * @param ALLOCATED_OUTSTANDING_AMOUNT the value for TRS_RPT_COLLATERAL_STATUS.ALLOCATED_OUTSTANDING_AMOUNT
     */
    public void setALLOCATED_OUTSTANDING_AMOUNT(BigDecimal ALLOCATED_OUTSTANDING_AMOUNT) {
        this.ALLOCATED_OUTSTANDING_AMOUNT = ALLOCATED_OUTSTANDING_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column TRS_RPT_COLLATERAL_STATUS.COLLATERAL_BRANCH
     *
     * @return the value of TRS_RPT_COLLATERAL_STATUS.COLLATERAL_BRANCH
     */
    public BigDecimal getCOLLATERAL_BRANCH()
    {
	return COLLATERAL_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column TRS_RPT_COLLATERAL_STATUS.COLLATERAL_BRANCH
     *
     * @param COLLATERAL_BRANCH the value for
     *            TRS_RPT_COLLATERAL_STATUS.COLLATERAL_BRANCH
     */
    public void setCOLLATERAL_BRANCH(BigDecimal COLLATERAL_BRANCH)
    {
	this.COLLATERAL_BRANCH = COLLATERAL_BRANCH;
    }
}