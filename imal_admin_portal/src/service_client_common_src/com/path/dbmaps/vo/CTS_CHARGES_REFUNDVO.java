package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CTS_CHARGES_REFUNDVO extends CTS_CHARGES_REFUNDVOKey
{
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.FROM_DATE
     */
    private Date FROM_DATE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.TO_DATE
     */
    private Date TO_DATE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.ENTITY_TYPE
     */
    private String ENTITY_TYPE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.ENTITY_NO
     */
    private BigDecimal ENTITY_NO;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.REFUND_PERC
     */
    private BigDecimal REFUND_PERC;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.STATUS
     */
    private String STATUS;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.CREATED_BY
     */
    private String CREATED_BY;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.CREATED_DATE
     */
    private Date CREATED_DATE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.MODIFIED_BY
     */
    private String MODIFIED_BY;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.APPROVED_BY
     */
    private String APPROVED_BY;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.APPROVED_DATE
     */
    private Date APPROVED_DATE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.DELETED_BY
     */
    private String DELETED_BY;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.DELETED_DATE
     */
    private Date DELETED_DATE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.TO_REVERSE_BY
     */
    private String TO_REVERSE_BY;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.TO_REVERSE_DATE
     */
    private Date TO_REVERSE_DATE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.REVERSE_BY
     */
    private String REVERSE_BY;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.REVERSE_DATE
     */
    private Date REVERSE_DATE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.DATE_UPDATED
     */
    private Date DATE_UPDATED;

    public Date getFROM_DATE()
    {
        return FROM_DATE;
    }

    public void setFROM_DATE(Date FROM_DATE)
    {
        this.FROM_DATE = FROM_DATE;
    }

    public Date getTO_DATE()
    {
        return TO_DATE;
    }

    public void setTO_DATE(Date TO_DATE)
    {
        this.TO_DATE = TO_DATE;
    }

    public String getENTITY_TYPE()
    {
        return ENTITY_TYPE;
    }

    public void setENTITY_TYPE(String ENTITY_TYPE)
    {
        this.ENTITY_TYPE = ENTITY_TYPE;
    }

    public BigDecimal getENTITY_NO()
    {
        return ENTITY_NO;
    }

    public void setENTITY_NO(BigDecimal ENTITY_NO)
    {
        this.ENTITY_NO = ENTITY_NO;
    }

    public BigDecimal getREFUND_PERC()
    {
        return REFUND_PERC;
    }

    public void setREFUND_PERC(BigDecimal REFUND_PERC)
    {
        this.REFUND_PERC = REFUND_PERC;
    }

    public String getSTATUS()
    {
        return STATUS;
    }

    public void setSTATUS(String STATUS)
    {
        this.STATUS = STATUS;
    }

    public String getCREATED_BY()
    {
        return CREATED_BY;
    }

    public void setCREATED_BY(String CREATED_BY)
    {
        this.CREATED_BY = CREATED_BY;
    }

    public Date getCREATED_DATE()
    {
        return CREATED_DATE;
    }

    public void setCREATED_DATE(Date CREATED_DATE)
    {
        this.CREATED_DATE = CREATED_DATE;
    }

    public String getMODIFIED_BY()
    {
        return MODIFIED_BY;
    }

    public void setMODIFIED_BY(String MODIFIED_BY)
    {
        this.MODIFIED_BY = MODIFIED_BY;
    }

    public Date getMODIFIED_DATE()
    {
        return MODIFIED_DATE;
    }

    public void setMODIFIED_DATE(Date MODIFIED_DATE)
    {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    public String getAPPROVED_BY()
    {
        return APPROVED_BY;
    }

    public void setAPPROVED_BY(String APPROVED_BY)
    {
        this.APPROVED_BY = APPROVED_BY;
    }

    public Date getAPPROVED_DATE()
    {
        return APPROVED_DATE;
    }

    public void setAPPROVED_DATE(Date APPROVED_DATE)
    {
        this.APPROVED_DATE = APPROVED_DATE;
    }

    public String getDELETED_BY()
    {
        return DELETED_BY;
    }

    public void setDELETED_BY(String DELETED_BY)
    {
        this.DELETED_BY = DELETED_BY;
    }

    public Date getDELETED_DATE()
    {
        return DELETED_DATE;
    }

    public void setDELETED_DATE(Date DELETED_DATE)
    {
        this.DELETED_DATE = DELETED_DATE;
    }

    public String getTO_REVERSE_BY()
    {
        return TO_REVERSE_BY;
    }

    public void setTO_REVERSE_BY(String TO_REVERSE_BY)
    {
        this.TO_REVERSE_BY = TO_REVERSE_BY;
    }

    public Date getTO_REVERSE_DATE()
    {
        return TO_REVERSE_DATE;
    }

    public void setTO_REVERSE_DATE(Date TO_REVERSE_DATE)
    {
        this.TO_REVERSE_DATE = TO_REVERSE_DATE;
    }

    public String getREVERSE_BY()
    {
        return REVERSE_BY;
    }

    public void setREVERSE_BY(String REVERSE_BY)
    {
        this.REVERSE_BY = REVERSE_BY;
    }

    public Date getREVERSE_DATE()
    {
        return REVERSE_DATE;
    }

    public void setREVERSE_DATE(Date REVERSE_DATE)
    {
        this.REVERSE_DATE = REVERSE_DATE;
    }

    public Date getDATE_UPDATED()
    {
        return DATE_UPDATED;
    }

    public void setDATE_UPDATED(Date dATE_UPDATED)
    {
        DATE_UPDATED = dATE_UPDATED;
    }
}
