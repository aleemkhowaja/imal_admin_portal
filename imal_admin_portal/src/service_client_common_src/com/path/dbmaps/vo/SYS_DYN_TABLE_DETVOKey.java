package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SYS_DYN_TABLE_DETVOKey extends BaseVO {
    /**
     * This field corresponds to the database column SYS_DYN_TABLE_DET.COL_ID
     */
    private BigDecimal COL_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_TABLE_DET.COL_ID
     *
     * @return the value of SYS_DYN_TABLE_DET.COL_ID
     */
    public BigDecimal getCOL_ID() {
        return COL_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_TABLE_DET.COL_ID
     *
     * @param COL_ID the value for SYS_DYN_TABLE_DET.COL_ID
     */
    public void setCOL_ID(BigDecimal COL_ID) {
        this.COL_ID = COL_ID;
    }
}