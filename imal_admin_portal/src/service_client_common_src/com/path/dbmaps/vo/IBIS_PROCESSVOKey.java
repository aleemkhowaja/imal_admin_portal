package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class IBIS_PROCESSVOKey extends BaseVO {
    private BigDecimal BRANCH_CODE;

    private BigDecimal COMP_CODE;

    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}