package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class PMSCSTDINVENTORYVO extends PMSCSTDINVENTORYVOKey {
    /**
     * This field corresponds to the database column PMSCSTDINVENTORY.QTY
     */
    private BigDecimal QTY;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCSTDINVENTORY.QTY
     *
     * @return the value of PMSCSTDINVENTORY.QTY
     */
    public BigDecimal getQTY() {
        return QTY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCSTDINVENTORY.QTY
     *
     * @param QTY the value for PMSCSTDINVENTORY.QTY
     */
    public void setQTY(BigDecimal QTY) {
        this.QTY = QTY;
    }
}