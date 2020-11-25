package com.path.vo.common;

import java.util.Date;

import com.path.vo.core.common.RetailBaseVO;

public class MaturityDetails extends RetailBaseVO {
	  Date maturityDate;	 
	  long maturityDays;
	  Date finalMaturityDate;
	  Date LastPostDate;
	  public Date getLastPostDate() {
		return LastPostDate;
	}
	public void setLastPostDate(Date lastPostDate) {
		LastPostDate = lastPostDate;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	
	public long getMaturityDays() {
		return maturityDays;
	}
	public void setMaturityDays(long maturityDays) {
		this.maturityDays = maturityDays;
	}
	public Date getFinalMaturityDate() {
		return finalMaturityDate;
	}
	public void setFinalMaturityDate(Date finalMaturityDate) {
		this.finalMaturityDate = finalMaturityDate;
	}
	  
}
