package com.path.dbmaps.vo;

import java.util.Date;

public class S_ROLE_DETAILVO extends S_ROLE_DETAILVOKey{

	private String CREATED_BY;
	private String AUTHORIZED_BY;
	private String STATUS;
	private String DELETED_BY;
	private String DELETE_REJECTED_BY;
	private String TO_BE_DELETED;
	private Date DATE_DELETED;
	private Date DATE_DELETE_REJECTED;
	private Date DATE_APPROVED;
	
	public String getCREATED_BY() {
		return CREATED_BY;
	}
	public void setCREATED_BY(String CREATED_BY) {
		this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
	}
	
	public String getAUTHORIZED_BY() {
		return AUTHORIZED_BY;
	}
	public void setAUTHORIZED_BY(String AUTHORIZED_BY) {
		this.AUTHORIZED_BY = AUTHORIZED_BY == null ? null : AUTHORIZED_BY.trim();
	}
	
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String STATUS) {
		this.STATUS = STATUS == null ? null : STATUS.trim();
	}
	
	public String getDELETED_BY() {
		return DELETED_BY;
	}
	public void setDELETED_BY(String DELETED_BY) {
		this.DELETED_BY = DELETED_BY == null ? null : DELETED_BY.trim();
	}
	
	public String getDELETE_REJECTED_BY() {
		return DELETE_REJECTED_BY;
	}
	public void setDELETE_REJECTED_BY(String DELETE_REJECTED_BY) {
		this.DELETE_REJECTED_BY = DELETE_REJECTED_BY == null ? null : DELETE_REJECTED_BY.trim();
	}
	
	public String getTO_BE_DELETED() {
		return TO_BE_DELETED;
	}
	public void setTO_BE_DELETED(String TO_BE_DELETED) {
		this.TO_BE_DELETED = TO_BE_DELETED == null ? null : TO_BE_DELETED.trim();
	}
	
	public Date getDATE_DELETED() {
		return DATE_DELETED;
	}
	public void setDATE_DELETED(Date dATE_DELETED) {
		DATE_DELETED = dATE_DELETED;
	}
	public Date getDATE_DELETE_REJECTED() {
		return DATE_DELETE_REJECTED;
	}
	public void setDATE_DELETE_REJECTED(Date DATE_DELETE_REJECTED) {
		this.DATE_DELETE_REJECTED = DATE_DELETE_REJECTED;
	}
	public Date getDATE_APPROVED() {
		return DATE_APPROVED;
	}
	public void setDATE_APPROVED(Date dATE_APPROVED) {
		DATE_APPROVED = dATE_APPROVED;
	}
	
}
