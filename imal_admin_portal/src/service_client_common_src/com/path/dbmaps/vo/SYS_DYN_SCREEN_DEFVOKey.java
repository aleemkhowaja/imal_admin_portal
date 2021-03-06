package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SYS_DYN_SCREEN_DEFVOKey extends BaseVO {
    /**
     * This field corresponds to the database column SYS_DYN_SCREEN_DEF.DYN_SCREEN_ID
     */
    private BigDecimal DYN_SCREEN_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_SCREEN_DEF.DYN_SCREEN_ID
     *
     * @return the value of SYS_DYN_SCREEN_DEF.DYN_SCREEN_ID
     */
    public BigDecimal getDYN_SCREEN_ID() {
        return DYN_SCREEN_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_SCREEN_DEF.DYN_SCREEN_ID
     *
     * @param DYN_SCREEN_ID the value for SYS_DYN_SCREEN_DEF.DYN_SCREEN_ID
     */
    public void setDYN_SCREEN_ID(BigDecimal DYN_SCREEN_ID) {
        this.DYN_SCREEN_ID = DYN_SCREEN_ID;
    }
}