package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_CIRCULAR_DEFVO extends BaseVO {
    /**
     * This field corresponds to the database column CTS_CIRCULAR_DEF.CODE
     */
    private BigDecimal CIRCULAR_CODE;

    /**
     * This field corresponds to the database column CTS_CIRCULAR_DEF.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_CIRCULAR_DEF.ADDITIONAL_REFERENCE
     */
    private String ADDITIONAL_REFERENCE;

    /**
     * This field corresponds to the database column CTS_CIRCULAR_DEF.BRIEF_NAME_ENG
     */
    private String BRIEF_NAME_ENG;

    /**
     * This field corresponds to the database column CTS_CIRCULAR_DEF.LONG_NAME_ENG
     */
    private String LONG_NAME_ENG;

    /**
     * This field corresponds to the database column CTS_CIRCULAR_DEF.BRIEF_NAME_AR
     */
    private String BRIEF_NAME_AR;

    /**
     * This field corresponds to the database column CTS_CIRCULAR_DEF.LONG_NAME_AR
     */
    private String LONG_NAME_AR;

    /**
     * This field corresponds to the database column CTS_CIRCULAR_DEF.AUTH_CEILING_CV_AMNT
     */
    private BigDecimal AUTH_CEILING_CV_AMNT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIRCULAR_DEF.CODE
     *
     * @return the value of CTS_CIRCULAR_DEF.CODE
     */
    public BigDecimal getCIRCULAR_CODE()
    {
        return CIRCULAR_CODE;
    }

    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIRCULAR_DEF.CODE
     *
     * @param CODE the value for CTS_CIRCULAR_DEF.CODE
     */

    public void setCIRCULAR_CODE(BigDecimal cIRCULAR_CODE)
    {
        CIRCULAR_CODE = cIRCULAR_CODE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIRCULAR_DEF.COMP_CODE
     *
     * @return the value of CTS_CIRCULAR_DEF.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIRCULAR_DEF.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_CIRCULAR_DEF.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIRCULAR_DEF.ADDITIONAL_REFERENCE
     *
     * @return the value of CTS_CIRCULAR_DEF.ADDITIONAL_REFERENCE
     */
    public String getADDITIONAL_REFERENCE() {
        return ADDITIONAL_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIRCULAR_DEF.ADDITIONAL_REFERENCE
     *
     * @param ADDITIONAL_REFERENCE the value for CTS_CIRCULAR_DEF.ADDITIONAL_REFERENCE
     */
    public void setADDITIONAL_REFERENCE(String ADDITIONAL_REFERENCE) {
        this.ADDITIONAL_REFERENCE = ADDITIONAL_REFERENCE == null ? null : ADDITIONAL_REFERENCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIRCULAR_DEF.BRIEF_NAME_ENG
     *
     * @return the value of CTS_CIRCULAR_DEF.BRIEF_NAME_ENG
     */
    public String getBRIEF_NAME_ENG() {
        return BRIEF_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIRCULAR_DEF.BRIEF_NAME_ENG
     *
     * @param BRIEF_NAME_ENG the value for CTS_CIRCULAR_DEF.BRIEF_NAME_ENG
     */
    public void setBRIEF_NAME_ENG(String BRIEF_NAME_ENG) {
        this.BRIEF_NAME_ENG = BRIEF_NAME_ENG == null ? null : BRIEF_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIRCULAR_DEF.LONG_NAME_ENG
     *
     * @return the value of CTS_CIRCULAR_DEF.LONG_NAME_ENG
     */
    public String getLONG_NAME_ENG() {
        return LONG_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIRCULAR_DEF.LONG_NAME_ENG
     *
     * @param LONG_NAME_ENG the value for CTS_CIRCULAR_DEF.LONG_NAME_ENG
     */
    public void setLONG_NAME_ENG(String LONG_NAME_ENG) {
        this.LONG_NAME_ENG = LONG_NAME_ENG == null ? null : LONG_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIRCULAR_DEF.BRIEF_NAME_AR
     *
     * @return the value of CTS_CIRCULAR_DEF.BRIEF_NAME_AR
     */
    public String getBRIEF_NAME_AR() {
        return BRIEF_NAME_AR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIRCULAR_DEF.BRIEF_NAME_AR
     *
     * @param BRIEF_NAME_AR the value for CTS_CIRCULAR_DEF.BRIEF_NAME_AR
     */
    public void setBRIEF_NAME_AR(String BRIEF_NAME_AR) {
        this.BRIEF_NAME_AR = BRIEF_NAME_AR == null ? null : BRIEF_NAME_AR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIRCULAR_DEF.LONG_NAME_AR
     *
     * @return the value of CTS_CIRCULAR_DEF.LONG_NAME_AR
     */
    public String getLONG_NAME_AR() {
        return LONG_NAME_AR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIRCULAR_DEF.LONG_NAME_AR
     *
     * @param LONG_NAME_AR the value for CTS_CIRCULAR_DEF.LONG_NAME_AR
     */
    public void setLONG_NAME_AR(String LONG_NAME_AR) {
        this.LONG_NAME_AR = LONG_NAME_AR == null ? null : LONG_NAME_AR.trim();
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIRCULAR_DEF.AUTH_CEILING_CV_AMNT
     *
     * @return the value of CTS_CIRCULAR_DEF.AUTH_CEILING_CV_AMNT
     */
    public BigDecimal getAUTH_CEILING_CV_AMNT()
    {
        return AUTH_CEILING_CV_AMNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIRCULAR_DEF.AUTH_CEILING_CV_AMNT
     *
     * @param AUTH_CEILING_CV_AMNT the value for CTS_CIRCULAR_DEF.AUTH_CEILING_CV_AMNT
     */
    public void setAUTH_CEILING_CV_AMNT(BigDecimal aUTH_CEILING_CV_AMNT)
    {
        AUTH_CEILING_CV_AMNT = aUTH_CEILING_CV_AMNT;
    }
}