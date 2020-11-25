package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class MSNGR_CONTACTLIST_DTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column MSNGR_CONTACTLIST_DT.ID
     */
    private BigDecimal ID;

    /**
     * This field corresponds to the database column MSNGR_CONTACTLIST_DT.USERID
     */
    private String USERID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MSNGR_CONTACTLIST_DT.ID
     *
     * @return the value of MSNGR_CONTACTLIST_DT.ID
     */
    public BigDecimal getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MSNGR_CONTACTLIST_DT.ID
     *
     * @param ID the value for MSNGR_CONTACTLIST_DT.ID
     */
    public void setID(BigDecimal ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MSNGR_CONTACTLIST_DT.USERID
     *
     * @return the value of MSNGR_CONTACTLIST_DT.USERID
     */
    public String getUSERID() {
        return USERID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MSNGR_CONTACTLIST_DT.USERID
     *
     * @param USERID the value for MSNGR_CONTACTLIST_DT.USERID
     */
    public void setUSERID(String USERID) {
        this.USERID = USERID == null ? null : USERID.trim();
    }
}