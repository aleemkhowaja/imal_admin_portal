package com.path.dbmaps.vo;

public class CTSTRXTYPE_ACCVO extends CTSTRXTYPE_ACCVOKey {
    /**
     * This field corresponds to the database column CTSTRXTYPE_ACC.TRX_DEFAULT_ACC
     */
    private String TRX_DEFAULT_ACC;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRXTYPE_ACC.TRX_DEFAULT_ACC
     *
     * @return the value of CTSTRXTYPE_ACC.TRX_DEFAULT_ACC
     */
    public String getTRX_DEFAULT_ACC() {
        return TRX_DEFAULT_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRXTYPE_ACC.TRX_DEFAULT_ACC
     *
     * @param TRX_DEFAULT_ACC the value for CTSTRXTYPE_ACC.TRX_DEFAULT_ACC
     */
    public void setTRX_DEFAULT_ACC(String TRX_DEFAULT_ACC) {
        this.TRX_DEFAULT_ACC = TRX_DEFAULT_ACC == null ? null : TRX_DEFAULT_ACC.trim();
    }
}