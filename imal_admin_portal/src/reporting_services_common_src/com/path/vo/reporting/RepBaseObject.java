package com.path.vo.reporting;

import java.io.Serializable;
import java.math.BigDecimal;

import com.path.bo.common.ConstantsCommon;

public class RepBaseObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4019715042994307786L;
	
	private int isOracle;
    private int isSybase;
    private final BigDecimal emptyBigDecimalValue = ConstantsCommon.EMPTY_BIGDECIMAL_VALUE;

    public int getIsOracle()
    {
	return this.isOracle;
    }

    public int getIsSybase()
    {
	return this.isSybase;
    }

    public void setIsOracle(int isOracle)
    {
	this.isOracle = isOracle;
    }

    public void setIsSybase(int isSybase)
    {
	this.isSybase = isSybase;
    }

	public BigDecimal getEmptyBigDecimalValue() {
		return emptyBigDecimalValue;
	}
}
