package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;

public class SYS_PARAM_ATTRIBUTEVOKey extends BaseVO {
    /**
     * This field corresponds to the database column SYS_PARAM_ATTRIBUTE.ATTRIBUTE_CODE
     */
    private String ATTRIBUTE_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_ATTRIBUTE.ATTRIBUTE_CODE
     *
     * @return the value of SYS_PARAM_ATTRIBUTE.ATTRIBUTE_CODE
     */
    public String getATTRIBUTE_CODE() {
        return ATTRIBUTE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_ATTRIBUTE.ATTRIBUTE_CODE
     *
     * @param ATTRIBUTE_CODE the value for SYS_PARAM_ATTRIBUTE.ATTRIBUTE_CODE
     */
    public void setATTRIBUTE_CODE(String ATTRIBUTE_CODE) {
        this.ATTRIBUTE_CODE = ATTRIBUTE_CODE == null ? null : ATTRIBUTE_CODE.trim();
    }
}