package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SYS_PARAM_KEY_GROUPVO extends BaseVO {
    /**
     * This field corresponds to the database column SYS_PARAM_KEY_GROUP.KEY_GROUP_ID
     */
    private BigDecimal KEY_GROUP_ID;

    /**
     * This field corresponds to the database column SYS_PARAM_KEY_GROUP.KEY_GROUP_DESC
     */
    private String KEY_GROUP_DESC;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_KEY_GROUP.KEY_GROUP_ID
     *
     * @return the value of SYS_PARAM_KEY_GROUP.KEY_GROUP_ID
     */
    public BigDecimal getKEY_GROUP_ID() {
        return KEY_GROUP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_KEY_GROUP.KEY_GROUP_ID
     *
     * @param KEY_GROUP_ID the value for SYS_PARAM_KEY_GROUP.KEY_GROUP_ID
     */
    public void setKEY_GROUP_ID(BigDecimal KEY_GROUP_ID) {
        this.KEY_GROUP_ID = KEY_GROUP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_KEY_GROUP.KEY_GROUP_DESC
     *
     * @return the value of SYS_PARAM_KEY_GROUP.KEY_GROUP_DESC
     */
    public String getKEY_GROUP_DESC() {
        return KEY_GROUP_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_KEY_GROUP.KEY_GROUP_DESC
     *
     * @param KEY_GROUP_DESC the value for SYS_PARAM_KEY_GROUP.KEY_GROUP_DESC
     */
    public void setKEY_GROUP_DESC(String KEY_GROUP_DESC) {
        this.KEY_GROUP_DESC = KEY_GROUP_DESC == null ? null : KEY_GROUP_DESC;
    }
}