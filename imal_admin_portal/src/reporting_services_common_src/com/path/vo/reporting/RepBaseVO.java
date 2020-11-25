package com.path.vo.reporting;

import java.math.BigDecimal;

import com.path.vo.common.audit.AuditRefCO;

public class RepBaseVO extends RepBaseObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = -899606851529756588L;
	
	private BigDecimal baseCurrencyCode;
    Object auditObj;
    private AuditRefCO auditRefCO; // for audit reference setting to be common

    public Object getAuditObj()
    {
        return auditObj;
    }

    public void setAuditObj(Object auditObj)
    {
        this.auditObj = auditObj;
    }

    public BigDecimal getBaseCurrencyCode()
    {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(BigDecimal baseCurrencyCode)
    {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public AuditRefCO getAuditRefCO()
    {
        return auditRefCO;
    }

    public void setAuditRefCO(AuditRefCO auditRefCO)
    {
        this.auditRefCO = auditRefCO;
    }
}
