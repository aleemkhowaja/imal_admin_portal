package com.path.vo.common.customization;

import com.path.dbmaps.vo.AXSVO;
import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.OPT_EXTENDEDVO;
import com.path.struts2.lib.common.BaseObject;



public class SavedAsScreensCO extends BaseObject{
	private OPTVO optVO = new OPTVO();
	private OPT_EXTENDEDVO optExtendedVO = new OPT_EXTENDEDVO();
	private AXSVO axsVO = new AXSVO();
	private String deleteParent;
	private String deleteSeries;
	private String message;

	
	public AXSVO getAxsVO() {
		return axsVO;
	}


	public void setAxsVO(AXSVO axsVO) {
		this.axsVO = axsVO;
	}


	public OPTVO getOptVO() {
		return optVO;
	}
	
	
	public void setOptVO(OPTVO optVO) {
		this.optVO = optVO;
	}

	
	public OPT_EXTENDEDVO getOptExtendedVO() {
		return optExtendedVO;
	}
	
	
	public void setOptExtendedVO(OPT_EXTENDEDVO optExtendedVO) {
		this.optExtendedVO = optExtendedVO;
	}


	public String getDeleteSeries() {
		return deleteSeries;
	}


	public void setDeleteSeries(String deleteSeries) {
		this.deleteSeries = deleteSeries;
	}


	public String getDeleteParent() {
		return deleteParent;
	}


	public void setDeleteParent(String deleteParent) {
		this.deleteParent = deleteParent;
	}


	public void setMessage(String nonDeletedDuplicatedParents)
	{
	    this.message = nonDeletedDuplicatedParents;	    
	}
	
	public String getMessage()
	{
	    return message;
	}



	
	
}
