package com.path.vo.common.yrt;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;

public class YRTSC extends BaseSC
{

    private BigDecimal year;
    private BigDecimal month;
    private String yrMonth; // used to concatenate month with year

    public BigDecimal getYear()
    {
	return year;
    }

    public void setYear(BigDecimal year)
    {
	this.year = year;
    }

    public BigDecimal getMonth()
    {
	return month;
    }

    public void setMonth(BigDecimal month)
    {
	this.month = month;
    }

    public String getYrMonth()
    {
	return yrMonth;
    }

    public void setYrMonth(String yrMonth)
    {
	this.yrMonth = yrMonth;
    }

}
