package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRS_DEAL_BATCH_DETAILSVO extends TRS_DEAL_BATCH_DETAILSVOKey {
    /**
     * This field corresponds to the database column TRS_DEAL_BATCH_DETAILS.MASTER_TRS_NO
     */
    private BigDecimal MASTER_TRS_NO;

    /**
     * This field corresponds to the database column TRS_DEAL_BATCH_DETAILS.NO_OF_COPY
     */
    private BigDecimal NO_OF_COPY;

    /**
     * This field corresponds to the database column TRS_DEAL_BATCH_DETAILS.TRS_TYPE
     */
    private String TRS_TYPE;

    /**
     * This field corresponds to the database column TRS_DEAL_BATCH_DETAILS.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column TRS_DEAL_BATCH_DETAILS.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column TRS_DEAL_BATCH_DETAILS.SERVER_CREATED_DATE
     */
    private Date SERVER_CREATED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DEAL_BATCH_DETAILS.MASTER_TRS_NO
     *
     * @return the value of TRS_DEAL_BATCH_DETAILS.MASTER_TRS_NO
     */
    public BigDecimal getMASTER_TRS_NO() {
        return MASTER_TRS_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DEAL_BATCH_DETAILS.MASTER_TRS_NO
     *
     * @param MASTER_TRS_NO the value for TRS_DEAL_BATCH_DETAILS.MASTER_TRS_NO
     */
    public void setMASTER_TRS_NO(BigDecimal MASTER_TRS_NO) {
        this.MASTER_TRS_NO = MASTER_TRS_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DEAL_BATCH_DETAILS.NO_OF_COPY
     *
     * @return the value of TRS_DEAL_BATCH_DETAILS.NO_OF_COPY
     */
    public BigDecimal getNO_OF_COPY() {
        return NO_OF_COPY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DEAL_BATCH_DETAILS.NO_OF_COPY
     *
     * @param NO_OF_COPY the value for TRS_DEAL_BATCH_DETAILS.NO_OF_COPY
     */
    public void setNO_OF_COPY(BigDecimal NO_OF_COPY) {
        this.NO_OF_COPY = NO_OF_COPY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DEAL_BATCH_DETAILS.TRS_TYPE
     *
     * @return the value of TRS_DEAL_BATCH_DETAILS.TRS_TYPE
     */
    public String getTRS_TYPE() {
        return TRS_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DEAL_BATCH_DETAILS.TRS_TYPE
     *
     * @param TRS_TYPE the value for TRS_DEAL_BATCH_DETAILS.TRS_TYPE
     */
    public void setTRS_TYPE(String TRS_TYPE) {
        this.TRS_TYPE = TRS_TYPE == null ? null : TRS_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DEAL_BATCH_DETAILS.CREATED_BY
     *
     * @return the value of TRS_DEAL_BATCH_DETAILS.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DEAL_BATCH_DETAILS.CREATED_BY
     *
     * @param CREATED_BY the value for TRS_DEAL_BATCH_DETAILS.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DEAL_BATCH_DETAILS.DATE_CREATED
     *
     * @return the value of TRS_DEAL_BATCH_DETAILS.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DEAL_BATCH_DETAILS.DATE_CREATED
     *
     * @param DATE_CREATED the value for TRS_DEAL_BATCH_DETAILS.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DEAL_BATCH_DETAILS.SERVER_CREATED_DATE
     *
     * @return the value of TRS_DEAL_BATCH_DETAILS.SERVER_CREATED_DATE
     */
    public Date getSERVER_CREATED_DATE() {
        return SERVER_CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DEAL_BATCH_DETAILS.SERVER_CREATED_DATE
     *
     * @param SERVER_CREATED_DATE the value for TRS_DEAL_BATCH_DETAILS.SERVER_CREATED_DATE
     */
    public void setSERVER_CREATED_DATE(Date SERVER_CREATED_DATE) {
        this.SERVER_CREATED_DATE = SERVER_CREATED_DATE;
    }
}