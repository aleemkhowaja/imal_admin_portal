package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TFS_DRAFT_DRAWNVO extends BaseVO {
    /**
     * This field corresponds to the database column TFS_DRAFT_DRAWN.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column TFS_DRAFT_DRAWN.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TFS_DRAFT_DRAWN.LC_NUMBER
     */
    private BigDecimal LC_NUMBER;

    /**
     * This field corresponds to the database column TFS_DRAFT_DRAWN.LC_TYPE
     */
    private String LC_TYPE;

    /**
     * This field corresponds to the database column TFS_DRAFT_DRAWN.LC_YEAR
     */
    private BigDecimal LC_YEAR;

    /**
     * This field corresponds to the database column TFS_DRAFT_DRAWN.DRAFT_DRAWN_ON
     */
    private String DRAFT_DRAWN_ON;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_DRAFT_DRAWN.BRANCH
     *
     * @return the value of TFS_DRAFT_DRAWN.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_DRAFT_DRAWN.BRANCH
     *
     * @param BRANCH the value for TFS_DRAFT_DRAWN.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_DRAFT_DRAWN.COMP_CODE
     *
     * @return the value of TFS_DRAFT_DRAWN.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_DRAFT_DRAWN.COMP_CODE
     *
     * @param COMP_CODE the value for TFS_DRAFT_DRAWN.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_DRAFT_DRAWN.LC_NUMBER
     *
     * @return the value of TFS_DRAFT_DRAWN.LC_NUMBER
     */
    public BigDecimal getLC_NUMBER() {
        return LC_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_DRAFT_DRAWN.LC_NUMBER
     *
     * @param LC_NUMBER the value for TFS_DRAFT_DRAWN.LC_NUMBER
     */
    public void setLC_NUMBER(BigDecimal LC_NUMBER) {
        this.LC_NUMBER = LC_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_DRAFT_DRAWN.LC_TYPE
     *
     * @return the value of TFS_DRAFT_DRAWN.LC_TYPE
     */
    public String getLC_TYPE() {
        return LC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_DRAFT_DRAWN.LC_TYPE
     *
     * @param LC_TYPE the value for TFS_DRAFT_DRAWN.LC_TYPE
     */
    public void setLC_TYPE(String LC_TYPE) {
        this.LC_TYPE = LC_TYPE == null ? null : LC_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_DRAFT_DRAWN.LC_YEAR
     *
     * @return the value of TFS_DRAFT_DRAWN.LC_YEAR
     */
    public BigDecimal getLC_YEAR() {
        return LC_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_DRAFT_DRAWN.LC_YEAR
     *
     * @param LC_YEAR the value for TFS_DRAFT_DRAWN.LC_YEAR
     */
    public void setLC_YEAR(BigDecimal LC_YEAR) {
        this.LC_YEAR = LC_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_DRAFT_DRAWN.DRAFT_DRAWN_ON
     *
     * @return the value of TFS_DRAFT_DRAWN.DRAFT_DRAWN_ON
     */
    public String getDRAFT_DRAWN_ON() {
        return DRAFT_DRAWN_ON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_DRAFT_DRAWN.DRAFT_DRAWN_ON
     *
     * @param DRAFT_DRAWN_ON the value for TFS_DRAFT_DRAWN.DRAFT_DRAWN_ON
     */
    public void setDRAFT_DRAWN_ON(String DRAFT_DRAWN_ON) {
        this.DRAFT_DRAWN_ON = DRAFT_DRAWN_ON == null ? null : DRAFT_DRAWN_ON.trim();
    }
}