package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SYS_PARAM_BPM_TASK_MAPVOKey extends BaseVO {
    /**
     * This field corresponds to the database column SYS_PARAM_BPM_TASK_MAP.TASK_MAP_ID
     */
    private BigDecimal TASK_MAP_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_BPM_TASK_MAP.TASK_MAP_ID
     *
     * @return the value of SYS_PARAM_BPM_TASK_MAP.TASK_MAP_ID
     */
    public BigDecimal getTASK_MAP_ID() {
        return TASK_MAP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_BPM_TASK_MAP.TASK_MAP_ID
     *
     * @param TASK_MAP_ID the value for SYS_PARAM_BPM_TASK_MAP.TASK_MAP_ID
     */
    public void setTASK_MAP_ID(BigDecimal TASK_MAP_ID) {
        this.TASK_MAP_ID = TASK_MAP_ID;
    }
}