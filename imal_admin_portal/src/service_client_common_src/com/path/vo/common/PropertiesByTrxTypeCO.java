package com.path.vo.common;

import com.path.dbmaps.vo.CTSTRXTYPE_DETVO;
import com.path.dbmaps.vo.CTSTRXTYPE_STDVO;
import com.path.lib.vo.BaseVO;

public class PropertiesByTrxTypeCO extends BaseVO
{
    private CTSTRXTYPE_DETVO ctstrxtypeDETVO;
    private CTSTRXTYPE_STDVO ctstrxtypeSTDVO;
    public CTSTRXTYPE_DETVO getCtstrxtypeDETVO()
    {
        return ctstrxtypeDETVO;
    }
    public void setCtstrxtypeDETVO(CTSTRXTYPE_DETVO ctstrxtypeDETVO)
    {
        this.ctstrxtypeDETVO = ctstrxtypeDETVO;
    }
    public CTSTRXTYPE_STDVO getCtstrxtypeSTDVO()
    {
        return ctstrxtypeSTDVO;
    }
    public void setCtstrxtypeSTDVO(CTSTRXTYPE_STDVO ctstrxtypeSTDVO)
    {
        this.ctstrxtypeSTDVO = ctstrxtypeSTDVO;
    }

}
