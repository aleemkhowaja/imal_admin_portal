package com.path.vo.common.iis.islamiccalculator;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.BaseSC;

public class IslamicCalculatorBalloonSC extends BaseSC{
	private BigDecimal balloonNo;
	private Date paymentDate;
	private BigDecimal balloonAmount;
	public BigDecimal getBalloonNo() {
		return balloonNo;
	}
	public void setBalloonNo(BigDecimal balloonNo) {
		this.balloonNo = balloonNo;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public BigDecimal getBalloonAmount() {
		return balloonAmount;
	}
	public void setBalloonAmount(BigDecimal balloonAmount) {
		this.balloonAmount = balloonAmount;
	}

}
