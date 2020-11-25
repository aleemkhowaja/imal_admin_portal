package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class EOD_ACCRUALVO extends BaseVO {
    /**
     * This field corresponds to the database column EOD_ACCRUAL.ACC_NO
     */
    private String ACC_NO;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.APP_NAME
     */
    private String APP_NAME;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.TRX_NO
     */
    private String TRX_NO;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.ORIGIN_BR
     */
    private BigDecimal ORIGIN_BR;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.PRERIODICITY
     */
    private String PRERIODICITY;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.PERIODICITY_NBR
     */
    private BigDecimal PERIODICITY_NBR;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.SPECIFIC_DAY
     */
    private String SPECIFIC_DAY;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.LAST_ACC_DATE
     */
    private Date LAST_ACC_DATE;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.TRX_DESC
     */
    private String TRX_DESC;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.VALIDITY_FROM
     */
    private Date VALIDITY_FROM;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.VALIDITY_TO
     */
    private Date VALIDITY_TO;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.TOTAL_COMMISSION
     */
    private BigDecimal TOTAL_COMMISSION;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.TOTAL_ACCRUABLE
     */
    private BigDecimal TOTAL_ACCRUABLE;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.AMOUNT_ACCRUABLE
     */
    private BigDecimal AMOUNT_ACCRUABLE;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.TOTAL_DAYS
     */
    private BigDecimal TOTAL_DAYS;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.TOTAL_ACCRUABLE_DAYS
     */
    private BigDecimal TOTAL_ACCRUABLE_DAYS;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.TRX_RATE
     */
    private BigDecimal TRX_RATE;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.TRX_SETTLED
     */
    private String TRX_SETTLED;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.ADD_REFERENCE
     */
    private String ADD_REFERENCE;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.AC_CHARGE_CY
     */
    private BigDecimal AC_CHARGE_CY;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.AC_CHARGE_GL
     */
    private BigDecimal AC_CHARGE_GL;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.AC_CHARGE_CIF
     */
    private BigDecimal AC_CHARGE_CIF;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.AC_CHARGE_SL
     */
    private BigDecimal AC_CHARGE_SL;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.AC_COMMISSION_CY
     */
    private BigDecimal AC_COMMISSION_CY;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.AC_COMMISSION_GL
     */
    private BigDecimal AC_COMMISSION_GL;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.AC_COMMISSION_CIF
     */
    private BigDecimal AC_COMMISSION_CIF;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.AC_COMMISSION_SL
     */
    private BigDecimal AC_COMMISSION_SL;

    /**
     * This field corresponds to the database column EOD_ACCRUAL.CLO_SET_AMOUNT
     */
    private BigDecimal CLO_SET_AMOUNT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.ACC_NO
     *
     * @return the value of EOD_ACCRUAL.ACC_NO
     */
    public String getACC_NO() {
        return ACC_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.ACC_NO
     *
     * @param ACC_NO the value for EOD_ACCRUAL.ACC_NO
     */
    public void setACC_NO(String ACC_NO) {
        this.ACC_NO = ACC_NO == null ? null : ACC_NO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.APP_NAME
     *
     * @return the value of EOD_ACCRUAL.APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.APP_NAME
     *
     * @param APP_NAME the value for EOD_ACCRUAL.APP_NAME
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.BRANCH_CODE
     *
     * @return the value of EOD_ACCRUAL.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for EOD_ACCRUAL.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.COMP_CODE
     *
     * @return the value of EOD_ACCRUAL.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.COMP_CODE
     *
     * @param COMP_CODE the value for EOD_ACCRUAL.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.TRX_NO
     *
     * @return the value of EOD_ACCRUAL.TRX_NO
     */
    public String getTRX_NO() {
        return TRX_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.TRX_NO
     *
     * @param TRX_NO the value for EOD_ACCRUAL.TRX_NO
     */
    public void setTRX_NO(String TRX_NO) {
        this.TRX_NO = TRX_NO == null ? null : TRX_NO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.ORIGIN_BR
     *
     * @return the value of EOD_ACCRUAL.ORIGIN_BR
     */
    public BigDecimal getORIGIN_BR() {
        return ORIGIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.ORIGIN_BR
     *
     * @param ORIGIN_BR the value for EOD_ACCRUAL.ORIGIN_BR
     */
    public void setORIGIN_BR(BigDecimal ORIGIN_BR) {
        this.ORIGIN_BR = ORIGIN_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.PRERIODICITY
     *
     * @return the value of EOD_ACCRUAL.PRERIODICITY
     */
    public String getPRERIODICITY() {
        return PRERIODICITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.PRERIODICITY
     *
     * @param PRERIODICITY the value for EOD_ACCRUAL.PRERIODICITY
     */
    public void setPRERIODICITY(String PRERIODICITY) {
        this.PRERIODICITY = PRERIODICITY == null ? null : PRERIODICITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.PERIODICITY_NBR
     *
     * @return the value of EOD_ACCRUAL.PERIODICITY_NBR
     */
    public BigDecimal getPERIODICITY_NBR() {
        return PERIODICITY_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.PERIODICITY_NBR
     *
     * @param PERIODICITY_NBR the value for EOD_ACCRUAL.PERIODICITY_NBR
     */
    public void setPERIODICITY_NBR(BigDecimal PERIODICITY_NBR) {
        this.PERIODICITY_NBR = PERIODICITY_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.SPECIFIC_DAY
     *
     * @return the value of EOD_ACCRUAL.SPECIFIC_DAY
     */
    public String getSPECIFIC_DAY() {
        return SPECIFIC_DAY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.SPECIFIC_DAY
     *
     * @param SPECIFIC_DAY the value for EOD_ACCRUAL.SPECIFIC_DAY
     */
    public void setSPECIFIC_DAY(String SPECIFIC_DAY) {
        this.SPECIFIC_DAY = SPECIFIC_DAY == null ? null : SPECIFIC_DAY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.LAST_ACC_DATE
     *
     * @return the value of EOD_ACCRUAL.LAST_ACC_DATE
     */
    public Date getLAST_ACC_DATE() {
        return LAST_ACC_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.LAST_ACC_DATE
     *
     * @param LAST_ACC_DATE the value for EOD_ACCRUAL.LAST_ACC_DATE
     */
    public void setLAST_ACC_DATE(Date LAST_ACC_DATE) {
        this.LAST_ACC_DATE = LAST_ACC_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.TRX_DESC
     *
     * @return the value of EOD_ACCRUAL.TRX_DESC
     */
    public String getTRX_DESC() {
        return TRX_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.TRX_DESC
     *
     * @param TRX_DESC the value for EOD_ACCRUAL.TRX_DESC
     */
    public void setTRX_DESC(String TRX_DESC) {
        this.TRX_DESC = TRX_DESC == null ? null : TRX_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.VALIDITY_FROM
     *
     * @return the value of EOD_ACCRUAL.VALIDITY_FROM
     */
    public Date getVALIDITY_FROM() {
        return VALIDITY_FROM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.VALIDITY_FROM
     *
     * @param VALIDITY_FROM the value for EOD_ACCRUAL.VALIDITY_FROM
     */
    public void setVALIDITY_FROM(Date VALIDITY_FROM) {
        this.VALIDITY_FROM = VALIDITY_FROM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.VALIDITY_TO
     *
     * @return the value of EOD_ACCRUAL.VALIDITY_TO
     */
    public Date getVALIDITY_TO() {
        return VALIDITY_TO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.VALIDITY_TO
     *
     * @param VALIDITY_TO the value for EOD_ACCRUAL.VALIDITY_TO
     */
    public void setVALIDITY_TO(Date VALIDITY_TO) {
        this.VALIDITY_TO = VALIDITY_TO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.TOTAL_COMMISSION
     *
     * @return the value of EOD_ACCRUAL.TOTAL_COMMISSION
     */
    public BigDecimal getTOTAL_COMMISSION() {
        return TOTAL_COMMISSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.TOTAL_COMMISSION
     *
     * @param TOTAL_COMMISSION the value for EOD_ACCRUAL.TOTAL_COMMISSION
     */
    public void setTOTAL_COMMISSION(BigDecimal TOTAL_COMMISSION) {
        this.TOTAL_COMMISSION = TOTAL_COMMISSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.TOTAL_ACCRUABLE
     *
     * @return the value of EOD_ACCRUAL.TOTAL_ACCRUABLE
     */
    public BigDecimal getTOTAL_ACCRUABLE() {
        return TOTAL_ACCRUABLE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.TOTAL_ACCRUABLE
     *
     * @param TOTAL_ACCRUABLE the value for EOD_ACCRUAL.TOTAL_ACCRUABLE
     */
    public void setTOTAL_ACCRUABLE(BigDecimal TOTAL_ACCRUABLE) {
        this.TOTAL_ACCRUABLE = TOTAL_ACCRUABLE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.AMOUNT_ACCRUABLE
     *
     * @return the value of EOD_ACCRUAL.AMOUNT_ACCRUABLE
     */
    public BigDecimal getAMOUNT_ACCRUABLE() {
        return AMOUNT_ACCRUABLE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.AMOUNT_ACCRUABLE
     *
     * @param AMOUNT_ACCRUABLE the value for EOD_ACCRUAL.AMOUNT_ACCRUABLE
     */
    public void setAMOUNT_ACCRUABLE(BigDecimal AMOUNT_ACCRUABLE) {
        this.AMOUNT_ACCRUABLE = AMOUNT_ACCRUABLE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.TOTAL_DAYS
     *
     * @return the value of EOD_ACCRUAL.TOTAL_DAYS
     */
    public BigDecimal getTOTAL_DAYS() {
        return TOTAL_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.TOTAL_DAYS
     *
     * @param TOTAL_DAYS the value for EOD_ACCRUAL.TOTAL_DAYS
     */
    public void setTOTAL_DAYS(BigDecimal TOTAL_DAYS) {
        this.TOTAL_DAYS = TOTAL_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.TOTAL_ACCRUABLE_DAYS
     *
     * @return the value of EOD_ACCRUAL.TOTAL_ACCRUABLE_DAYS
     */
    public BigDecimal getTOTAL_ACCRUABLE_DAYS() {
        return TOTAL_ACCRUABLE_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.TOTAL_ACCRUABLE_DAYS
     *
     * @param TOTAL_ACCRUABLE_DAYS the value for EOD_ACCRUAL.TOTAL_ACCRUABLE_DAYS
     */
    public void setTOTAL_ACCRUABLE_DAYS(BigDecimal TOTAL_ACCRUABLE_DAYS) {
        this.TOTAL_ACCRUABLE_DAYS = TOTAL_ACCRUABLE_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.TRX_RATE
     *
     * @return the value of EOD_ACCRUAL.TRX_RATE
     */
    public BigDecimal getTRX_RATE() {
        return TRX_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.TRX_RATE
     *
     * @param TRX_RATE the value for EOD_ACCRUAL.TRX_RATE
     */
    public void setTRX_RATE(BigDecimal TRX_RATE) {
        this.TRX_RATE = TRX_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.TRX_SETTLED
     *
     * @return the value of EOD_ACCRUAL.TRX_SETTLED
     */
    public String getTRX_SETTLED() {
        return TRX_SETTLED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.TRX_SETTLED
     *
     * @param TRX_SETTLED the value for EOD_ACCRUAL.TRX_SETTLED
     */
    public void setTRX_SETTLED(String TRX_SETTLED) {
        this.TRX_SETTLED = TRX_SETTLED == null ? null : TRX_SETTLED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.ADD_REFERENCE
     *
     * @return the value of EOD_ACCRUAL.ADD_REFERENCE
     */
    public String getADD_REFERENCE() {
        return ADD_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.ADD_REFERENCE
     *
     * @param ADD_REFERENCE the value for EOD_ACCRUAL.ADD_REFERENCE
     */
    public void setADD_REFERENCE(String ADD_REFERENCE) {
        this.ADD_REFERENCE = ADD_REFERENCE == null ? null : ADD_REFERENCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.AC_CHARGE_CY
     *
     * @return the value of EOD_ACCRUAL.AC_CHARGE_CY
     */
    public BigDecimal getAC_CHARGE_CY() {
        return AC_CHARGE_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.AC_CHARGE_CY
     *
     * @param AC_CHARGE_CY the value for EOD_ACCRUAL.AC_CHARGE_CY
     */
    public void setAC_CHARGE_CY(BigDecimal AC_CHARGE_CY) {
        this.AC_CHARGE_CY = AC_CHARGE_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.AC_CHARGE_GL
     *
     * @return the value of EOD_ACCRUAL.AC_CHARGE_GL
     */
    public BigDecimal getAC_CHARGE_GL() {
        return AC_CHARGE_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.AC_CHARGE_GL
     *
     * @param AC_CHARGE_GL the value for EOD_ACCRUAL.AC_CHARGE_GL
     */
    public void setAC_CHARGE_GL(BigDecimal AC_CHARGE_GL) {
        this.AC_CHARGE_GL = AC_CHARGE_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.AC_CHARGE_CIF
     *
     * @return the value of EOD_ACCRUAL.AC_CHARGE_CIF
     */
    public BigDecimal getAC_CHARGE_CIF() {
        return AC_CHARGE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.AC_CHARGE_CIF
     *
     * @param AC_CHARGE_CIF the value for EOD_ACCRUAL.AC_CHARGE_CIF
     */
    public void setAC_CHARGE_CIF(BigDecimal AC_CHARGE_CIF) {
        this.AC_CHARGE_CIF = AC_CHARGE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.AC_CHARGE_SL
     *
     * @return the value of EOD_ACCRUAL.AC_CHARGE_SL
     */
    public BigDecimal getAC_CHARGE_SL() {
        return AC_CHARGE_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.AC_CHARGE_SL
     *
     * @param AC_CHARGE_SL the value for EOD_ACCRUAL.AC_CHARGE_SL
     */
    public void setAC_CHARGE_SL(BigDecimal AC_CHARGE_SL) {
        this.AC_CHARGE_SL = AC_CHARGE_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.AC_COMMISSION_CY
     *
     * @return the value of EOD_ACCRUAL.AC_COMMISSION_CY
     */
    public BigDecimal getAC_COMMISSION_CY() {
        return AC_COMMISSION_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.AC_COMMISSION_CY
     *
     * @param AC_COMMISSION_CY the value for EOD_ACCRUAL.AC_COMMISSION_CY
     */
    public void setAC_COMMISSION_CY(BigDecimal AC_COMMISSION_CY) {
        this.AC_COMMISSION_CY = AC_COMMISSION_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.AC_COMMISSION_GL
     *
     * @return the value of EOD_ACCRUAL.AC_COMMISSION_GL
     */
    public BigDecimal getAC_COMMISSION_GL() {
        return AC_COMMISSION_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.AC_COMMISSION_GL
     *
     * @param AC_COMMISSION_GL the value for EOD_ACCRUAL.AC_COMMISSION_GL
     */
    public void setAC_COMMISSION_GL(BigDecimal AC_COMMISSION_GL) {
        this.AC_COMMISSION_GL = AC_COMMISSION_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.AC_COMMISSION_CIF
     *
     * @return the value of EOD_ACCRUAL.AC_COMMISSION_CIF
     */
    public BigDecimal getAC_COMMISSION_CIF() {
        return AC_COMMISSION_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.AC_COMMISSION_CIF
     *
     * @param AC_COMMISSION_CIF the value for EOD_ACCRUAL.AC_COMMISSION_CIF
     */
    public void setAC_COMMISSION_CIF(BigDecimal AC_COMMISSION_CIF) {
        this.AC_COMMISSION_CIF = AC_COMMISSION_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.AC_COMMISSION_SL
     *
     * @return the value of EOD_ACCRUAL.AC_COMMISSION_SL
     */
    public BigDecimal getAC_COMMISSION_SL() {
        return AC_COMMISSION_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.AC_COMMISSION_SL
     *
     * @param AC_COMMISSION_SL the value for EOD_ACCRUAL.AC_COMMISSION_SL
     */
    public void setAC_COMMISSION_SL(BigDecimal AC_COMMISSION_SL) {
        this.AC_COMMISSION_SL = AC_COMMISSION_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ACCRUAL.CLO_SET_AMOUNT
     *
     * @return the value of EOD_ACCRUAL.CLO_SET_AMOUNT
     */
    public BigDecimal getCLO_SET_AMOUNT() {
        return CLO_SET_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ACCRUAL.CLO_SET_AMOUNT
     *
     * @param CLO_SET_AMOUNT the value for EOD_ACCRUAL.CLO_SET_AMOUNT
     */
    public void setCLO_SET_AMOUNT(BigDecimal CLO_SET_AMOUNT) {
        this.CLO_SET_AMOUNT = CLO_SET_AMOUNT;
    }
}