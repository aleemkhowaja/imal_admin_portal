package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSSETLMT_CALC_VALUES_TEMPVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSSETLMT_CALC_VALUES_TEMP.KEY_ID
     */
    private String KEY_ID;

    /**
     * This field corresponds to the database column TRSSETLMT_CALC_VALUES_TEMP.SL_NO
     */
    private BigDecimal SL_NO;

    /**
     * This field corresponds to the database column TRSSETLMT_CALC_VALUES_TEMP.TYPE
     */
    private String TYPE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSSETLMT_CALC_VALUES_TEMP.KEY_ID
     *
     * @return the value of TRSSETLMT_CALC_VALUES_TEMP.KEY_ID
     */
    public String getKEY_ID() {
        return KEY_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSSETLMT_CALC_VALUES_TEMP.KEY_ID
     *
     * @param KEY_ID the value for TRSSETLMT_CALC_VALUES_TEMP.KEY_ID
     */
    public void setKEY_ID(String KEY_ID) {
        this.KEY_ID = KEY_ID == null ? null : KEY_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSSETLMT_CALC_VALUES_TEMP.SL_NO
     *
     * @return the value of TRSSETLMT_CALC_VALUES_TEMP.SL_NO
     */
    public BigDecimal getSL_NO() {
        return SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSSETLMT_CALC_VALUES_TEMP.SL_NO
     *
     * @param SL_NO the value for TRSSETLMT_CALC_VALUES_TEMP.SL_NO
     */
    public void setSL_NO(BigDecimal SL_NO) {
        this.SL_NO = SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSSETLMT_CALC_VALUES_TEMP.TYPE
     *
     * @return the value of TRSSETLMT_CALC_VALUES_TEMP.TYPE
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSSETLMT_CALC_VALUES_TEMP.TYPE
     *
     * @param TYPE the value for TRSSETLMT_CALC_VALUES_TEMP.TYPE
     */
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE == null ? null : TYPE.trim();
    }
}