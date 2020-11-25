package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.util.Date;

public class USR_PUSH_ALERTVO extends BaseVO {
    /**
     * This field corresponds to the database column USR_PUSH_ALERT.USER_ID
     */
    private String USER_ID;

    /**
     * This field corresponds to the database column USR_PUSH_ALERT.DEFAULT_REFRESH_TME
     */
    private String DEFAULT_REFRESH_TME;

    /**
     * This field corresponds to the database column USR_PUSH_ALERT.NEXT_PUSH_DATE
     */
    private Date NEXT_PUSH_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USR_PUSH_ALERT.USER_ID
     *
     * @return the value of USR_PUSH_ALERT.USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USR_PUSH_ALERT.USER_ID
     *
     * @param USER_ID the value for USR_PUSH_ALERT.USER_ID
     */
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID == null ? null : USER_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USR_PUSH_ALERT.DEFAULT_REFRESH_TME
     *
     * @return the value of USR_PUSH_ALERT.DEFAULT_REFRESH_TME
     */
    public String getDEFAULT_REFRESH_TME() {
        return DEFAULT_REFRESH_TME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USR_PUSH_ALERT.DEFAULT_REFRESH_TME
     *
     * @param DEFAULT_REFRESH_TME the value for USR_PUSH_ALERT.DEFAULT_REFRESH_TME
     */
    public void setDEFAULT_REFRESH_TME(String DEFAULT_REFRESH_TME) {
        this.DEFAULT_REFRESH_TME = DEFAULT_REFRESH_TME == null ? null : DEFAULT_REFRESH_TME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USR_PUSH_ALERT.NEXT_PUSH_DATE
     *
     * @return the value of USR_PUSH_ALERT.NEXT_PUSH_DATE
     */
    public Date getNEXT_PUSH_DATE() {
        return NEXT_PUSH_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USR_PUSH_ALERT.NEXT_PUSH_DATE
     *
     * @param NEXT_PUSH_DATE the value for USR_PUSH_ALERT.NEXT_PUSH_DATE
     */
    public void setNEXT_PUSH_DATE(Date NEXT_PUSH_DATE) {
        this.NEXT_PUSH_DATE = NEXT_PUSH_DATE;
    }
}