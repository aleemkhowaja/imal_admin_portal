package com.path.vo.reporting;

import com.path.struts2.lib.common.GridParamsSC;

public class QRY_GRIDSC extends GridParamsSC 
{
	private String ENTITY_DB_NAME;
	private Long PARENT_ID;
	//ADDED FOR JOIN QUERY
	private String FIELD_NAME;
	
	public String getFIELD_NAME() {
		return FIELD_NAME;
	}

	public void setFIELD_NAME(String fIELDNAME) {
		FIELD_NAME = fIELDNAME;
	}
	//END ADDED FOR JOIN QUERY
	public QRY_GRIDSC()
	{
		super.setSearchCols(new String[] {"ENTITY_ALIAS","ENTITY_DB_NAME","FIELD_ALIAS","FIELD_DB_NAME"});
	}
	
	public String getENTITY_DB_NAME() {
		return ENTITY_DB_NAME;
	}

	public void setENTITY_DB_NAME(String eNTITYDBNAME) {
		ENTITY_DB_NAME = eNTITYDBNAME;
	}

	public Long getPARENT_ID() {
		return PARENT_ID;
	}

	public void setPARENT_ID(Long pARENTID) {
		PARENT_ID = pARENTID;
	}

	
	
}
