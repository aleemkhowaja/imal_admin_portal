package com.path.vo.common.iis.islamiccalculator;

import java.io.Serializable;

import com.path.dbmaps.vo.TRSDEAL_NIDCVO;
import com.path.lib.vo.BaseVO;

public class TrsdealNidcCO extends BaseVO implements Serializable
{
    private TRSDEAL_NIDCVO trsdealNIDCVO;


    public TRSDEAL_NIDCVO getTrsdealNIDCVO()
    {
	return trsdealNIDCVO;
    }

    public void setTrsdealNIDCVO(TRSDEAL_NIDCVO trsdealNIDCVO)
    {
	this.trsdealNIDCVO = trsdealNIDCVO;
    }
}
