package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class EOD_ENG_MGMT_BATCHVOKey extends BaseVO {
    /**
     * This field corresponds to the database column EOD_ENG_MGMT_BATCH.EOD_ENG_MGMT_BATCH_ID
     */
    private BigDecimal EOD_ENG_MGMT_BATCH_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT_BATCH.EOD_ENG_MGMT_BATCH_ID
     *
     * @return the value of EOD_ENG_MGMT_BATCH.EOD_ENG_MGMT_BATCH_ID
     */
    public BigDecimal getEOD_ENG_MGMT_BATCH_ID() {
        return EOD_ENG_MGMT_BATCH_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT_BATCH.EOD_ENG_MGMT_BATCH_ID
     *
     * @param EOD_ENG_MGMT_BATCH_ID the value for EOD_ENG_MGMT_BATCH.EOD_ENG_MGMT_BATCH_ID
     */
    public void setEOD_ENG_MGMT_BATCH_ID(BigDecimal EOD_ENG_MGMT_BATCH_ID) {
        this.EOD_ENG_MGMT_BATCH_ID = EOD_ENG_MGMT_BATCH_ID;
    }
}