package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSDEAL_WRITE_OFFVO extends TRSDEAL_WRITE_OFFVOKey {
    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.TRX_DATE
     */
    private Date TRX_DATE;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.DEAL_NO
     */
    private BigDecimal DEAL_NO;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.DEAL_CY
     */
    private BigDecimal DEAL_CY;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.PRODUCT_TYPE
     */
    private String PRODUCT_TYPE;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.PRODUCT_CODE
     */
    private BigDecimal PRODUCT_CODE;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.AC_NO
     */
    private String AC_NO;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.WRITE_OFF_TYPE
     */
    private BigDecimal WRITE_OFF_TYPE;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.BALANCE_OUTSTANDING
     */
    private BigDecimal BALANCE_OUTSTANDING;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.UNEARNED_INCOME
     */
    private BigDecimal UNEARNED_INCOME;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.CURRENT_BALANCE
     */
    private BigDecimal CURRENT_BALANCE;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.PRINCIPAL
     */
    private BigDecimal PRINCIPAL;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.OWINGS_DUE
     */
    private BigDecimal OWINGS_DUE;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.SPIIS
     */
    private BigDecimal SPIIS;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.IIS
     */
    private BigDecimal IIS;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.NPF_AMOUNT
     */
    private BigDecimal NPF_AMOUNT;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.PROVISION_AMOUNT
     */
    private BigDecimal PROVISION_AMOUNT;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.REALIZE_VALUE
     */
    private BigDecimal REALIZE_VALUE;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.WRITE_OFF_AMOUNT
     */
    private BigDecimal WRITE_OFF_AMOUNT;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.WRITE_DOWN_AMOUNT
     */
    private BigDecimal WRITE_DOWN_AMOUNT;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.APPROVING_COMMITEE
     */
    private String APPROVING_COMMITEE;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.APPROVING_DATE
     */
    private Date APPROVING_DATE;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.SERVER_DATE_CREATED
     */
    private Date SERVER_DATE_CREATED;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.DATE_MODIFIED
     */
    private Date DATE_MODIFIED;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.SERVER_DATE_MODIFIED
     */
    private Date SERVER_DATE_MODIFIED;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.DELETED_BY
     */
    private String DELETED_BY;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.DATE_DELETED
     */
    private Date DATE_DELETED;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.SERVER_DATE_DELETED
     */
    private Date SERVER_DATE_DELETED;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.APPROVED_BY
     */
    private String APPROVED_BY;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.DATE_APPROVED
     */
    private Date DATE_APPROVED;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.SERVER_DATE_APPROVED
     */
    private Date SERVER_DATE_APPROVED;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.REVERSED_BY
     */
    private String REVERSED_BY;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.DATE_REVERSED
     */
    private Date DATE_REVERSED;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.SERVER_DATE_REVERSED
     */
    private Date SERVER_DATE_REVERSED;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.PRODUCT_CLASS
     */
    private BigDecimal PRODUCT_CLASS;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.DRAWDOWN_BRANCH
     */
    private BigDecimal DRAWDOWN_BRANCH;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.DRAWDOWN_NO
     */
    private BigDecimal DRAWDOWN_NO;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    /**
     * This field corresponds to the database column TRSDEAL_WRITE_OFF.REVERSAL_STATUS
     */
    private String REVERSAL_STATUS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.TRX_DATE
     *
     * @return the value of TRSDEAL_WRITE_OFF.TRX_DATE
     */
    public Date getTRX_DATE() {
        return TRX_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.TRX_DATE
     *
     * @param TRX_DATE the value for TRSDEAL_WRITE_OFF.TRX_DATE
     */
    public void setTRX_DATE(Date TRX_DATE) {
        this.TRX_DATE = TRX_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.DEAL_NO
     *
     * @return the value of TRSDEAL_WRITE_OFF.DEAL_NO
     */
    public BigDecimal getDEAL_NO() {
        return DEAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.DEAL_NO
     *
     * @param DEAL_NO the value for TRSDEAL_WRITE_OFF.DEAL_NO
     */
    public void setDEAL_NO(BigDecimal DEAL_NO) {
        this.DEAL_NO = DEAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.DEAL_CY
     *
     * @return the value of TRSDEAL_WRITE_OFF.DEAL_CY
     */
    public BigDecimal getDEAL_CY() {
        return DEAL_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.DEAL_CY
     *
     * @param DEAL_CY the value for TRSDEAL_WRITE_OFF.DEAL_CY
     */
    public void setDEAL_CY(BigDecimal DEAL_CY) {
        this.DEAL_CY = DEAL_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.PRODUCT_TYPE
     *
     * @return the value of TRSDEAL_WRITE_OFF.PRODUCT_TYPE
     */
    public String getPRODUCT_TYPE() {
        return PRODUCT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.PRODUCT_TYPE
     *
     * @param PRODUCT_TYPE the value for TRSDEAL_WRITE_OFF.PRODUCT_TYPE
     */
    public void setPRODUCT_TYPE(String PRODUCT_TYPE) {
        this.PRODUCT_TYPE = PRODUCT_TYPE == null ? null : PRODUCT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.PRODUCT_CODE
     *
     * @return the value of TRSDEAL_WRITE_OFF.PRODUCT_CODE
     */
    public BigDecimal getPRODUCT_CODE() {
        return PRODUCT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.PRODUCT_CODE
     *
     * @param PRODUCT_CODE the value for TRSDEAL_WRITE_OFF.PRODUCT_CODE
     */
    public void setPRODUCT_CODE(BigDecimal PRODUCT_CODE) {
        this.PRODUCT_CODE = PRODUCT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.AC_NO
     *
     * @return the value of TRSDEAL_WRITE_OFF.AC_NO
     */
    public String getAC_NO() {
        return AC_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.AC_NO
     *
     * @param AC_NO the value for TRSDEAL_WRITE_OFF.AC_NO
     */
    public void setAC_NO(String AC_NO) {
        this.AC_NO = AC_NO == null ? null : AC_NO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.CIF_NO
     *
     * @return the value of TRSDEAL_WRITE_OFF.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.CIF_NO
     *
     * @param CIF_NO the value for TRSDEAL_WRITE_OFF.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.WRITE_OFF_TYPE
     *
     * @return the value of TRSDEAL_WRITE_OFF.WRITE_OFF_TYPE
     */
    public BigDecimal getWRITE_OFF_TYPE() {
        return WRITE_OFF_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.WRITE_OFF_TYPE
     *
     * @param WRITE_OFF_TYPE the value for TRSDEAL_WRITE_OFF.WRITE_OFF_TYPE
     */
    public void setWRITE_OFF_TYPE(BigDecimal WRITE_OFF_TYPE) {
        this.WRITE_OFF_TYPE = WRITE_OFF_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.STATUS
     *
     * @return the value of TRSDEAL_WRITE_OFF.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.STATUS
     *
     * @param STATUS the value for TRSDEAL_WRITE_OFF.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.BALANCE_OUTSTANDING
     *
     * @return the value of TRSDEAL_WRITE_OFF.BALANCE_OUTSTANDING
     */
    public BigDecimal getBALANCE_OUTSTANDING() {
        return BALANCE_OUTSTANDING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.BALANCE_OUTSTANDING
     *
     * @param BALANCE_OUTSTANDING the value for TRSDEAL_WRITE_OFF.BALANCE_OUTSTANDING
     */
    public void setBALANCE_OUTSTANDING(BigDecimal BALANCE_OUTSTANDING) {
        this.BALANCE_OUTSTANDING = BALANCE_OUTSTANDING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.UNEARNED_INCOME
     *
     * @return the value of TRSDEAL_WRITE_OFF.UNEARNED_INCOME
     */
    public BigDecimal getUNEARNED_INCOME() {
        return UNEARNED_INCOME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.UNEARNED_INCOME
     *
     * @param UNEARNED_INCOME the value for TRSDEAL_WRITE_OFF.UNEARNED_INCOME
     */
    public void setUNEARNED_INCOME(BigDecimal UNEARNED_INCOME) {
        this.UNEARNED_INCOME = UNEARNED_INCOME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.CURRENT_BALANCE
     *
     * @return the value of TRSDEAL_WRITE_OFF.CURRENT_BALANCE
     */
    public BigDecimal getCURRENT_BALANCE() {
        return CURRENT_BALANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.CURRENT_BALANCE
     *
     * @param CURRENT_BALANCE the value for TRSDEAL_WRITE_OFF.CURRENT_BALANCE
     */
    public void setCURRENT_BALANCE(BigDecimal CURRENT_BALANCE) {
        this.CURRENT_BALANCE = CURRENT_BALANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.PRINCIPAL
     *
     * @return the value of TRSDEAL_WRITE_OFF.PRINCIPAL
     */
    public BigDecimal getPRINCIPAL() {
        return PRINCIPAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.PRINCIPAL
     *
     * @param PRINCIPAL the value for TRSDEAL_WRITE_OFF.PRINCIPAL
     */
    public void setPRINCIPAL(BigDecimal PRINCIPAL) {
        this.PRINCIPAL = PRINCIPAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.OWINGS_DUE
     *
     * @return the value of TRSDEAL_WRITE_OFF.OWINGS_DUE
     */
    public BigDecimal getOWINGS_DUE() {
        return OWINGS_DUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.OWINGS_DUE
     *
     * @param OWINGS_DUE the value for TRSDEAL_WRITE_OFF.OWINGS_DUE
     */
    public void setOWINGS_DUE(BigDecimal OWINGS_DUE) {
        this.OWINGS_DUE = OWINGS_DUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.SPIIS
     *
     * @return the value of TRSDEAL_WRITE_OFF.SPIIS
     */
    public BigDecimal getSPIIS() {
        return SPIIS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.SPIIS
     *
     * @param SPIIS the value for TRSDEAL_WRITE_OFF.SPIIS
     */
    public void setSPIIS(BigDecimal SPIIS) {
        this.SPIIS = SPIIS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.IIS
     *
     * @return the value of TRSDEAL_WRITE_OFF.IIS
     */
    public BigDecimal getIIS() {
        return IIS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.IIS
     *
     * @param IIS the value for TRSDEAL_WRITE_OFF.IIS
     */
    public void setIIS(BigDecimal IIS) {
        this.IIS = IIS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.NPF_AMOUNT
     *
     * @return the value of TRSDEAL_WRITE_OFF.NPF_AMOUNT
     */
    public BigDecimal getNPF_AMOUNT() {
        return NPF_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.NPF_AMOUNT
     *
     * @param NPF_AMOUNT the value for TRSDEAL_WRITE_OFF.NPF_AMOUNT
     */
    public void setNPF_AMOUNT(BigDecimal NPF_AMOUNT) {
        this.NPF_AMOUNT = NPF_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.PROVISION_AMOUNT
     *
     * @return the value of TRSDEAL_WRITE_OFF.PROVISION_AMOUNT
     */
    public BigDecimal getPROVISION_AMOUNT() {
        return PROVISION_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.PROVISION_AMOUNT
     *
     * @param PROVISION_AMOUNT the value for TRSDEAL_WRITE_OFF.PROVISION_AMOUNT
     */
    public void setPROVISION_AMOUNT(BigDecimal PROVISION_AMOUNT) {
        this.PROVISION_AMOUNT = PROVISION_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.REALIZE_VALUE
     *
     * @return the value of TRSDEAL_WRITE_OFF.REALIZE_VALUE
     */
    public BigDecimal getREALIZE_VALUE() {
        return REALIZE_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.REALIZE_VALUE
     *
     * @param REALIZE_VALUE the value for TRSDEAL_WRITE_OFF.REALIZE_VALUE
     */
    public void setREALIZE_VALUE(BigDecimal REALIZE_VALUE) {
        this.REALIZE_VALUE = REALIZE_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.WRITE_OFF_AMOUNT
     *
     * @return the value of TRSDEAL_WRITE_OFF.WRITE_OFF_AMOUNT
     */
    public BigDecimal getWRITE_OFF_AMOUNT() {
        return WRITE_OFF_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.WRITE_OFF_AMOUNT
     *
     * @param WRITE_OFF_AMOUNT the value for TRSDEAL_WRITE_OFF.WRITE_OFF_AMOUNT
     */
    public void setWRITE_OFF_AMOUNT(BigDecimal WRITE_OFF_AMOUNT) {
        this.WRITE_OFF_AMOUNT = WRITE_OFF_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.WRITE_DOWN_AMOUNT
     *
     * @return the value of TRSDEAL_WRITE_OFF.WRITE_DOWN_AMOUNT
     */
    public BigDecimal getWRITE_DOWN_AMOUNT() {
        return WRITE_DOWN_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.WRITE_DOWN_AMOUNT
     *
     * @param WRITE_DOWN_AMOUNT the value for TRSDEAL_WRITE_OFF.WRITE_DOWN_AMOUNT
     */
    public void setWRITE_DOWN_AMOUNT(BigDecimal WRITE_DOWN_AMOUNT) {
        this.WRITE_DOWN_AMOUNT = WRITE_DOWN_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.APPROVING_COMMITEE
     *
     * @return the value of TRSDEAL_WRITE_OFF.APPROVING_COMMITEE
     */
    public String getAPPROVING_COMMITEE() {
        return APPROVING_COMMITEE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.APPROVING_COMMITEE
     *
     * @param APPROVING_COMMITEE the value for TRSDEAL_WRITE_OFF.APPROVING_COMMITEE
     */
    public void setAPPROVING_COMMITEE(String APPROVING_COMMITEE) {
        this.APPROVING_COMMITEE = APPROVING_COMMITEE == null ? null : APPROVING_COMMITEE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.APPROVING_DATE
     *
     * @return the value of TRSDEAL_WRITE_OFF.APPROVING_DATE
     */
    public Date getAPPROVING_DATE() {
        return APPROVING_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.APPROVING_DATE
     *
     * @param APPROVING_DATE the value for TRSDEAL_WRITE_OFF.APPROVING_DATE
     */
    public void setAPPROVING_DATE(Date APPROVING_DATE) {
        this.APPROVING_DATE = APPROVING_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.CREATED_BY
     *
     * @return the value of TRSDEAL_WRITE_OFF.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.CREATED_BY
     *
     * @param CREATED_BY the value for TRSDEAL_WRITE_OFF.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.DATE_CREATED
     *
     * @return the value of TRSDEAL_WRITE_OFF.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.DATE_CREATED
     *
     * @param DATE_CREATED the value for TRSDEAL_WRITE_OFF.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.SERVER_DATE_CREATED
     *
     * @return the value of TRSDEAL_WRITE_OFF.SERVER_DATE_CREATED
     */
    public Date getSERVER_DATE_CREATED() {
        return SERVER_DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.SERVER_DATE_CREATED
     *
     * @param SERVER_DATE_CREATED the value for TRSDEAL_WRITE_OFF.SERVER_DATE_CREATED
     */
    public void setSERVER_DATE_CREATED(Date SERVER_DATE_CREATED) {
        this.SERVER_DATE_CREATED = SERVER_DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.MODIFIED_BY
     *
     * @return the value of TRSDEAL_WRITE_OFF.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for TRSDEAL_WRITE_OFF.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.DATE_MODIFIED
     *
     * @return the value of TRSDEAL_WRITE_OFF.DATE_MODIFIED
     */
    public Date getDATE_MODIFIED() {
        return DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.DATE_MODIFIED
     *
     * @param DATE_MODIFIED the value for TRSDEAL_WRITE_OFF.DATE_MODIFIED
     */
    public void setDATE_MODIFIED(Date DATE_MODIFIED) {
        this.DATE_MODIFIED = DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.SERVER_DATE_MODIFIED
     *
     * @return the value of TRSDEAL_WRITE_OFF.SERVER_DATE_MODIFIED
     */
    public Date getSERVER_DATE_MODIFIED() {
        return SERVER_DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.SERVER_DATE_MODIFIED
     *
     * @param SERVER_DATE_MODIFIED the value for TRSDEAL_WRITE_OFF.SERVER_DATE_MODIFIED
     */
    public void setSERVER_DATE_MODIFIED(Date SERVER_DATE_MODIFIED) {
        this.SERVER_DATE_MODIFIED = SERVER_DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.DELETED_BY
     *
     * @return the value of TRSDEAL_WRITE_OFF.DELETED_BY
     */
    public String getDELETED_BY() {
        return DELETED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.DELETED_BY
     *
     * @param DELETED_BY the value for TRSDEAL_WRITE_OFF.DELETED_BY
     */
    public void setDELETED_BY(String DELETED_BY) {
        this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.DATE_DELETED
     *
     * @return the value of TRSDEAL_WRITE_OFF.DATE_DELETED
     */
    public Date getDATE_DELETED() {
        return DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.DATE_DELETED
     *
     * @param DATE_DELETED the value for TRSDEAL_WRITE_OFF.DATE_DELETED
     */
    public void setDATE_DELETED(Date DATE_DELETED) {
        this.DATE_DELETED = DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.SERVER_DATE_DELETED
     *
     * @return the value of TRSDEAL_WRITE_OFF.SERVER_DATE_DELETED
     */
    public Date getSERVER_DATE_DELETED() {
        return SERVER_DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.SERVER_DATE_DELETED
     *
     * @param SERVER_DATE_DELETED the value for TRSDEAL_WRITE_OFF.SERVER_DATE_DELETED
     */
    public void setSERVER_DATE_DELETED(Date SERVER_DATE_DELETED) {
        this.SERVER_DATE_DELETED = SERVER_DATE_DELETED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.APPROVED_BY
     *
     * @return the value of TRSDEAL_WRITE_OFF.APPROVED_BY
     */
    public String getAPPROVED_BY() {
        return APPROVED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.APPROVED_BY
     *
     * @param APPROVED_BY the value for TRSDEAL_WRITE_OFF.APPROVED_BY
     */
    public void setAPPROVED_BY(String APPROVED_BY) {
        this.APPROVED_BY = APPROVED_BY == null ? null : APPROVED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.DATE_APPROVED
     *
     * @return the value of TRSDEAL_WRITE_OFF.DATE_APPROVED
     */
    public Date getDATE_APPROVED() {
        return DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.DATE_APPROVED
     *
     * @param DATE_APPROVED the value for TRSDEAL_WRITE_OFF.DATE_APPROVED
     */
    public void setDATE_APPROVED(Date DATE_APPROVED) {
        this.DATE_APPROVED = DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.SERVER_DATE_APPROVED
     *
     * @return the value of TRSDEAL_WRITE_OFF.SERVER_DATE_APPROVED
     */
    public Date getSERVER_DATE_APPROVED() {
        return SERVER_DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.SERVER_DATE_APPROVED
     *
     * @param SERVER_DATE_APPROVED the value for TRSDEAL_WRITE_OFF.SERVER_DATE_APPROVED
     */
    public void setSERVER_DATE_APPROVED(Date SERVER_DATE_APPROVED) {
        this.SERVER_DATE_APPROVED = SERVER_DATE_APPROVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.REVERSED_BY
     *
     * @return the value of TRSDEAL_WRITE_OFF.REVERSED_BY
     */
    public String getREVERSED_BY() {
        return REVERSED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.REVERSED_BY
     *
     * @param REVERSED_BY the value for TRSDEAL_WRITE_OFF.REVERSED_BY
     */
    public void setREVERSED_BY(String REVERSED_BY) {
        this.REVERSED_BY = REVERSED_BY == null ? null : REVERSED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.DATE_REVERSED
     *
     * @return the value of TRSDEAL_WRITE_OFF.DATE_REVERSED
     */
    public Date getDATE_REVERSED() {
        return DATE_REVERSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.DATE_REVERSED
     *
     * @param DATE_REVERSED the value for TRSDEAL_WRITE_OFF.DATE_REVERSED
     */
    public void setDATE_REVERSED(Date DATE_REVERSED) {
        this.DATE_REVERSED = DATE_REVERSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.SERVER_DATE_REVERSED
     *
     * @return the value of TRSDEAL_WRITE_OFF.SERVER_DATE_REVERSED
     */
    public Date getSERVER_DATE_REVERSED() {
        return SERVER_DATE_REVERSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.SERVER_DATE_REVERSED
     *
     * @param SERVER_DATE_REVERSED the value for TRSDEAL_WRITE_OFF.SERVER_DATE_REVERSED
     */
    public void setSERVER_DATE_REVERSED(Date SERVER_DATE_REVERSED) {
        this.SERVER_DATE_REVERSED = SERVER_DATE_REVERSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.PRODUCT_CLASS
     *
     * @return the value of TRSDEAL_WRITE_OFF.PRODUCT_CLASS
     */
    public BigDecimal getPRODUCT_CLASS() {
        return PRODUCT_CLASS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.PRODUCT_CLASS
     *
     * @param PRODUCT_CLASS the value for TRSDEAL_WRITE_OFF.PRODUCT_CLASS
     */
    public void setPRODUCT_CLASS(BigDecimal PRODUCT_CLASS) {
        this.PRODUCT_CLASS = PRODUCT_CLASS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.DRAWDOWN_BRANCH
     *
     * @return the value of TRSDEAL_WRITE_OFF.DRAWDOWN_BRANCH
     */
    public BigDecimal getDRAWDOWN_BRANCH() {
        return DRAWDOWN_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.DRAWDOWN_BRANCH
     *
     * @param DRAWDOWN_BRANCH the value for TRSDEAL_WRITE_OFF.DRAWDOWN_BRANCH
     */
    public void setDRAWDOWN_BRANCH(BigDecimal DRAWDOWN_BRANCH) {
        this.DRAWDOWN_BRANCH = DRAWDOWN_BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.DRAWDOWN_NO
     *
     * @return the value of TRSDEAL_WRITE_OFF.DRAWDOWN_NO
     */
    public BigDecimal getDRAWDOWN_NO() {
        return DRAWDOWN_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.DRAWDOWN_NO
     *
     * @param DRAWDOWN_NO the value for TRSDEAL_WRITE_OFF.DRAWDOWN_NO
     */
    public void setDRAWDOWN_NO(BigDecimal DRAWDOWN_NO) {
        this.DRAWDOWN_NO = DRAWDOWN_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.DATE_UPDATED
     *
     * @return the value of TRSDEAL_WRITE_OFF.DATE_UPDATED
     */
    public Date getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.DATE_UPDATED
     *
     * @param DATE_UPDATED the value for TRSDEAL_WRITE_OFF.DATE_UPDATED
     */
    public void setDATE_UPDATED(Date DATE_UPDATED) {
        this.DATE_UPDATED = DATE_UPDATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_WRITE_OFF.REVERSAL_STATUS
     *
     * @return the value of TRSDEAL_WRITE_OFF.REVERSAL_STATUS
     */
    public String getREVERSAL_STATUS() {
        return REVERSAL_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_WRITE_OFF.REVERSAL_STATUS
     *
     * @param REVERSAL_STATUS the value for TRSDEAL_WRITE_OFF.REVERSAL_STATUS
     */
    public void setREVERSAL_STATUS(String REVERSAL_STATUS) {
        this.REVERSAL_STATUS = REVERSAL_STATUS == null ? null : REVERSAL_STATUS.trim();
    }
}