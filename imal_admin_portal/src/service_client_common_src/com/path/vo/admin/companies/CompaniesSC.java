package com.path.vo.admin.companies;

import com.path.struts2.lib.common.GridParamsSC;

public class CompaniesSC extends GridParamsSC
{

    public CompaniesSC()
    {
	super.setSearchCols(new String[] { "COMP_CODE", "BRIEF_DESC_ENG" });
    }

}
