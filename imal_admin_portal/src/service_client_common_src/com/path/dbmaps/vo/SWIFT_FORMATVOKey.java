package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SWIFT_FORMATVOKey extends BaseVO {
    /**
     * This field corresponds to the database column SWIFT_FORMAT.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column SWIFT_FORMAT.MSG_CODE
     */
    private String MSG_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_FORMAT.LINE_NO
     *
     * @return the value of SWIFT_FORMAT.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_FORMAT.LINE_NO
     *
     * @param LINE_NO the value for SWIFT_FORMAT.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_FORMAT.MSG_CODE
     *
     * @return the value of SWIFT_FORMAT.MSG_CODE
     */
    public String getMSG_CODE() {
        return MSG_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_FORMAT.MSG_CODE
     *
     * @param MSG_CODE the value for SWIFT_FORMAT.MSG_CODE
     */
    public void setMSG_CODE(String MSG_CODE) {
        this.MSG_CODE = MSG_CODE == null ? null : MSG_CODE.trim();
    }
}