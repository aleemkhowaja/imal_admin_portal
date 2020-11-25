package com.path.vo.reporting;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class DesignerGridSC  extends GridParamsSC 
{

	private BigDecimal rep_Id;
	private BigDecimal link_rep_Id;
	private BigDecimal field_index;
	private String col_name;

	public String getCol_name() {
		return col_name;
	}

	public void setCol_name(String colName) {
		col_name = colName;
	}

	public BigDecimal getField_index() {
		return field_index;
	}

	public void setField_index(BigDecimal fieldIndex) {
		field_index = fieldIndex;
	}

	public BigDecimal getRep_Id() {
		return rep_Id;
	}

	public void setRep_Id(BigDecimal repId) {
		rep_Id = repId;
	}

	public BigDecimal getLink_rep_Id() {
		return link_rep_Id;
	}

	public void setLink_rep_Id(BigDecimal linkRepId) {
		link_rep_Id = linkRepId;
	}


	public DesignerGridSC()
	{
		super.setSearchCols(new String[] {"REPORT_NAME","COLUMN_NAME","LINKED_REP_NAME"});
	}
}
