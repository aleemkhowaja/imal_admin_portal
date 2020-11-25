package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class S_TODO_DETVOKey extends BaseVO {
    
    /**
     * This field corresponds to the database column S_TODO_DET.TODO_CODE
     */
    private BigDecimal TODO_CODE;

    /**
     * This field corresponds to the database column S_TODO_DET.TODO_LINE
     */
    private BigDecimal TODO_LINE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_TODO_DET.TODO_CODE
     *
     * @return the value of S_TODO_DET.TODO_CODE
     */
    public BigDecimal getTODO_CODE() {
        return TODO_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_TODO_DET.TODO_CODE
     *
     * @param TODO_CODE the value for S_TODO_DET.TODO_CODE
     */
    public void setTODO_CODE(BigDecimal TODO_CODE) {
        this.TODO_CODE = TODO_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_TODO_DET.TODO_LINE
     *
     * @return the value of S_TODO_DET.TODO_LINE
     */
    public BigDecimal getTODO_LINE() {
        return TODO_LINE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_TODO_DET.TODO_LINE
     *
     * @param TODO_LINE the value for S_TODO_DET.TODO_LINE
     */
    public void setTODO_LINE(BigDecimal TODO_LINE) {
        this.TODO_LINE = TODO_LINE;
    }
}