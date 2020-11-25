package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TFS_PRODUCT_DOMVO extends BaseVO {
    /**
     * This field corresponds to the database column TFS_PRODUCT_DOM.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TFS_PRODUCT_DOM.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TFS_PRODUCT_DOM.DOC_CODE
     */
    private BigDecimal DOC_CODE;

    /**
     * This field corresponds to the database column TFS_PRODUCT_DOM.REQUEST_NBR
     */
    private BigDecimal REQUEST_NBR;

    /**
     * This field corresponds to the database column TFS_PRODUCT_DOM.DOC_ACCEPTED
     */
    private String DOC_ACCEPTED;

    /**
     * This field corresponds to the database column TFS_PRODUCT_DOM.DOC_COMMENT
     */
    private String DOC_COMMENT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_PRODUCT_DOM.BRANCH_CODE
     *
     * @return the value of TFS_PRODUCT_DOM.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_PRODUCT_DOM.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TFS_PRODUCT_DOM.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_PRODUCT_DOM.COMP_CODE
     *
     * @return the value of TFS_PRODUCT_DOM.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_PRODUCT_DOM.COMP_CODE
     *
     * @param COMP_CODE the value for TFS_PRODUCT_DOM.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_PRODUCT_DOM.DOC_CODE
     *
     * @return the value of TFS_PRODUCT_DOM.DOC_CODE
     */
    public BigDecimal getDOC_CODE() {
        return DOC_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_PRODUCT_DOM.DOC_CODE
     *
     * @param DOC_CODE the value for TFS_PRODUCT_DOM.DOC_CODE
     */
    public void setDOC_CODE(BigDecimal DOC_CODE) {
        this.DOC_CODE = DOC_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_PRODUCT_DOM.REQUEST_NBR
     *
     * @return the value of TFS_PRODUCT_DOM.REQUEST_NBR
     */
    public BigDecimal getREQUEST_NBR() {
        return REQUEST_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_PRODUCT_DOM.REQUEST_NBR
     *
     * @param REQUEST_NBR the value for TFS_PRODUCT_DOM.REQUEST_NBR
     */
    public void setREQUEST_NBR(BigDecimal REQUEST_NBR) {
        this.REQUEST_NBR = REQUEST_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_PRODUCT_DOM.DOC_ACCEPTED
     *
     * @return the value of TFS_PRODUCT_DOM.DOC_ACCEPTED
     */
    public String getDOC_ACCEPTED() {
        return DOC_ACCEPTED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_PRODUCT_DOM.DOC_ACCEPTED
     *
     * @param DOC_ACCEPTED the value for TFS_PRODUCT_DOM.DOC_ACCEPTED
     */
    public void setDOC_ACCEPTED(String DOC_ACCEPTED) {
        this.DOC_ACCEPTED = DOC_ACCEPTED == null ? null : DOC_ACCEPTED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TFS_PRODUCT_DOM.DOC_COMMENT
     *
     * @return the value of TFS_PRODUCT_DOM.DOC_COMMENT
     */
    public String getDOC_COMMENT() {
        return DOC_COMMENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TFS_PRODUCT_DOM.DOC_COMMENT
     *
     * @param DOC_COMMENT the value for TFS_PRODUCT_DOM.DOC_COMMENT
     */
    public void setDOC_COMMENT(String DOC_COMMENT) {
        this.DOC_COMMENT = DOC_COMMENT == null ? null : DOC_COMMENT.trim();
    }
}