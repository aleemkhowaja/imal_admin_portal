package com.path.vo.common;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTSTRSVO;
import com.path.dbmaps.vo.CTSTRS_BENEF_DETVO;
import com.path.struts2.lib.common.BaseSC;

public class PropertiesByTrxTypeSC extends BaseSC
{
    private BigDecimal trxType;
    private Object objValue;// argument to be set when checking on mandatory fields by trx type in ctstrs
    private String resultMsgs;//message containing all mandatory fields not filled
    private String validateProp;
    private CTSTRSVO ctstrsVO;//To check on mandatory fields in this VO
    private CTSTRS_BENEF_DETVO ctstrsBenefDetVO;//To check on mandatory fields in this VO
    
    public Object getObjValue()
    {
        return objValue;
    }
    public void setObjValue(Object objValue)
    {
        this.objValue = objValue;
    }
    public String getResultMsgs()
    {
        return resultMsgs;
    }
    public void setResultMsgs(String resultMsgs)
    {
        this.resultMsgs = resultMsgs;
    }
    public String getValidateProp()
    {
        return validateProp;
    }
    public void setValidateProp(String validateProp)
    {
        this.validateProp = validateProp;
    }
    public BigDecimal getTrxType()
    {
        return trxType;
    }
    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }
    public CTSTRSVO getCtstrsVO()
    {
        return ctstrsVO;
    }
    public void setCtstrsVO(CTSTRSVO ctstrsVO)
    {
        this.ctstrsVO = ctstrsVO;
    }
    public CTSTRS_BENEF_DETVO getCtstrsBenefDetVO()
    {
        return ctstrsBenefDetVO;
    }
    public void setCtstrsBenefDetVO(CTSTRS_BENEF_DETVO ctstrsBenefDetVO)
    {
        this.ctstrsBenefDetVO = ctstrsBenefDetVO;
    }
    
}
