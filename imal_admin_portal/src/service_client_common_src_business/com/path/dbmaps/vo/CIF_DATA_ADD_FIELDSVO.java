package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CIF_DATA_ADD_FIELDSVO extends CIF_DATA_ADD_FIELDSVOKey {
    /**
     * This field corresponds to the database column CIF_DATA_ADD_FIELDS.ADD_NUM
     */
    private BigDecimal ADD_NUM;

    /**
     * This field corresponds to the database column CIF_DATA_ADD_FIELDS.ADD_VC
     */
    private String ADD_VC;

    /**
     * This field corresponds to the database column CIF_DATA_ADD_FIELDS.ADD_DT
     */
    private Date ADD_DT;

    /**
     * This field corresponds to the database column CIF_DATA_ADD_FIELDS.ADD_VC
     */
    private String ADD_DR;
    
    /**
     * This field corresponds to the database column CIF_DATA_ADD_FIELDS.IS_READONLY_YN
     */
    private String IS_READONLY_YN;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_DATA_ADD_FIELDS.ADD_NUM
     *
     * @return the value of CIF_DATA_ADD_FIELDS.ADD_NUM
     */
    public BigDecimal getADD_NUM() {
        return ADD_NUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_DATA_ADD_FIELDS.ADD_NUM
     *
     * @param ADD_NUM the value for CIF_DATA_ADD_FIELDS.ADD_NUM
     */
    public void setADD_NUM(BigDecimal ADD_NUM) {
        this.ADD_NUM = ADD_NUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_DATA_ADD_FIELDS.ADD_VC
     *
     * @return the value of CIF_DATA_ADD_FIELDS.ADD_VC
     */
    public String getADD_VC() {
        return ADD_VC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_DATA_ADD_FIELDS.ADD_VC
     *
     * @param ADD_VC the value for CIF_DATA_ADD_FIELDS.ADD_VC
     */
    public void setADD_VC(String ADD_VC) {
        this.ADD_VC = ADD_VC == null ? null : ADD_VC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_DATA_ADD_FIELDS.ADD_DT
     *
     * @return the value of CIF_DATA_ADD_FIELDS.ADD_DT
     */
    public Date getADD_DT() {
        return ADD_DT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_DATA_ADD_FIELDS.ADD_DT
     *
     * @param ADD_DT the value for CIF_DATA_ADD_FIELDS.ADD_DT
     */
    public void setADD_DT(Date ADD_DT) {
        this.ADD_DT = ADD_DT;
    }

    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_DATA_ADD_FIELDS.IS_READONLY_YN
     *
     * @return the value of CIF_DATA_ADD_FIELDS.IS_READONLY_YN
     */
    public String getIS_READONLY_YN()
    {
        return IS_READONLY_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_DATA_ADD_FIELDS.IS_READONLY_YN
     *
     * @param IS_READONLY_YN the value for CIF_DATA_ADD_FIELDS.IS_READONLY_YN
     */
    public void setIS_READONLY_YN(String iS_READONLY_YN)
    {
	IS_READONLY_YN = iS_READONLY_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CIF_DATA_ADD_FIELDS.ADD_DR
     *
     * @return the value of CIF_DATA_ADD_FIELDS.ADD_DR
     */
    public String getADD_DR()
    {
        return ADD_DR;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CIF_DATA_ADD_FIELDS.ADD_DR
     *
     * @param ADD_DR the value for CIF_DATA_ADD_FIELDS.ADD_DR
     */
    public void setADD_DR(String aDD_DR)
    {
        ADD_DR = aDD_DR;
    }

    
}