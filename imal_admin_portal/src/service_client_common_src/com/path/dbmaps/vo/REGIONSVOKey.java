package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class REGIONSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column REGIONS.REGION_CODE
     */
    private BigDecimal REGION_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REGIONS.REGION_CODE
     *
     * @return the value of REGIONS.REGION_CODE
     */
    public BigDecimal getREGION_CODE() {
        return REGION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REGIONS.REGION_CODE
     *
     * @param REGION_CODE the value for REGIONS.REGION_CODE
     */
    public void setREGION_CODE(BigDecimal REGION_CODE) {
        this.REGION_CODE = REGION_CODE;
    }
}