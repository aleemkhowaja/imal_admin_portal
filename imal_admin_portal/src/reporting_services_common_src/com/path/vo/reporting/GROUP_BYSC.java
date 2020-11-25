package com.path.vo.reporting;

import com.path.struts2.lib.common.GridParamsSC;

public class GROUP_BYSC extends GridParamsSC {

	private String queryName;
	private String fieldName;
	
	public GROUP_BYSC(){
		super.setSearchCols(new String[] {"queryName","fieldName"});
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
