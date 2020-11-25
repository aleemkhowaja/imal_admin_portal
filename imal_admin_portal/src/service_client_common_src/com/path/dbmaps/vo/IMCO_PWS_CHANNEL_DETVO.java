package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class IMCO_PWS_CHANNEL_DETVO extends BaseVO {
    /**
     * This field corresponds to the database column IMCO_PWS_CHANNEL_DET.CHANNEL_ID
     */
    private BigDecimal CHANNEL_ID;

    /**
     * This field corresponds to the database column IMCO_PWS_CHANNEL_DET.HOST_NAME
     */
    private String HOST_NAME;

    /**
     * This field corresponds to the database column IMCO_PWS_CHANNEL_DET.HASH_KEY
     */
    private String HASH_KEY;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMCO_PWS_CHANNEL_DET.CHANNEL_ID
     *
     * @return the value of IMCO_PWS_CHANNEL_DET.CHANNEL_ID
     */
    public BigDecimal getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMCO_PWS_CHANNEL_DET.CHANNEL_ID
     *
     * @param CHANNEL_ID the value for IMCO_PWS_CHANNEL_DET.CHANNEL_ID
     */
    public void setCHANNEL_ID(BigDecimal CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMCO_PWS_CHANNEL_DET.HOST_NAME
     *
     * @return the value of IMCO_PWS_CHANNEL_DET.HOST_NAME
     */
    public String getHOST_NAME() {
        return HOST_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMCO_PWS_CHANNEL_DET.HOST_NAME
     *
     * @param HOST_NAME the value for IMCO_PWS_CHANNEL_DET.HOST_NAME
     */
    public void setHOST_NAME(String HOST_NAME) {
        this.HOST_NAME = HOST_NAME == null ? null : HOST_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMCO_PWS_CHANNEL_DET.HASH_KEY
     *
     * @return the value of IMCO_PWS_CHANNEL_DET.HASH_KEY
     */
    public String getHASH_KEY() {
        return HASH_KEY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMCO_PWS_CHANNEL_DET.HASH_KEY
     *
     * @param HASH_KEY the value for IMCO_PWS_CHANNEL_DET.HASH_KEY
     */
    public void setHASH_KEY(String HASH_KEY) {
        this.HASH_KEY = HASH_KEY == null ? null : HASH_KEY.trim();
    }
}