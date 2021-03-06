package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SYS_PARAM_ACTION_ARG_MAPVOKey extends BaseVO {
    /**
     * This field corresponds to the database column SYS_PARAM_ACTION_ARG_MAP.ACTION_SEQ_ID
     */
    private BigDecimal ACTION_SEQ_ID;

    /**
     * This field corresponds to the database column SYS_PARAM_ACTION_ARG_MAP.ARG_ID
     */
    private BigDecimal ARG_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_ACTION_ARG_MAP.ACTION_SEQ_ID
     *
     * @return the value of SYS_PARAM_ACTION_ARG_MAP.ACTION_SEQ_ID
     */
    public BigDecimal getACTION_SEQ_ID() {
        return ACTION_SEQ_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_ACTION_ARG_MAP.ACTION_SEQ_ID
     *
     * @param ACTION_SEQ_ID the value for SYS_PARAM_ACTION_ARG_MAP.ACTION_SEQ_ID
     */
    public void setACTION_SEQ_ID(BigDecimal ACTION_SEQ_ID) {
        this.ACTION_SEQ_ID = ACTION_SEQ_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_ACTION_ARG_MAP.ARG_ID
     *
     * @return the value of SYS_PARAM_ACTION_ARG_MAP.ARG_ID
     */
    public BigDecimal getARG_ID() {
        return ARG_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_ACTION_ARG_MAP.ARG_ID
     *
     * @param ARG_ID the value for SYS_PARAM_ACTION_ARG_MAP.ARG_ID
     */
    public void setARG_ID(BigDecimal ARG_ID) {
        this.ARG_ID = ARG_ID;
    }
}