package com.path.vo.common;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.ACC_NV_CONTROLVO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.struts2.lib.common.BaseSC;

public class MaturityDateSC extends BaseSC
{

    Date openingDate;
    Date maturityDate;
    String maturedCalculation;
    ACC_NV_CONTROLVO accNvcontrol = new ACC_NV_CONTROLVO();
    RIFATTVO rifattVO = new RIFATTVO();
    String extendMatDteHol;
    BigDecimal compCountry;
    String gmiFlag;

    public String getGmiFlag()
    {
        return gmiFlag;
    }

    public void setGmiFlag(String gmiFlag)
    {
        this.gmiFlag = gmiFlag;
    }

    public BigDecimal getCompCountry()
    {
	return compCountry;
    }

    public void setCompCountry(BigDecimal compCountry)
    {
	this.compCountry = compCountry;
    }

    public Date getOpeningDate()
    {
	return openingDate;
    }

    public void setOpeningDate(Date openingDate)
    {
	this.openingDate = openingDate;
    }

    public Date getMaturityDate()
    {
	return maturityDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
	this.maturityDate = maturityDate;
    }

    public String getMaturedCalculation()
    {
	return maturedCalculation;
    }

    public void setMaturedCalculation(String maturedCalculation)
    {
	this.maturedCalculation = maturedCalculation;
    }

    public ACC_NV_CONTROLVO getAccNvcontrol()
    {
	return accNvcontrol;
    }

    public void setAccNvcontrol(ACC_NV_CONTROLVO accNvcontrol)
    {
	this.accNvcontrol = accNvcontrol;
    }

    public RIFATTVO getRifattVO()
    {
	return rifattVO;
    }

    public void setRifattVO(RIFATTVO rifattVO)
    {
	this.rifattVO = rifattVO;
    }

    public String getExtendMatDteHol()
    {
	return extendMatDteHol;
    }

    public void setExtendMatDteHol(String extendMatDteHol)
    {
	this.extendMatDteHol = extendMatDteHol;
    }

}