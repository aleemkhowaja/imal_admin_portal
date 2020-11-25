package com.path.vo.admin.branches;

import com.path.lib.vo.BaseVO;

public class BranchesCO extends BaseVO
{
    private static final long serialVersionUID = 1L;

    /**
     * this field corresponds to branch Code Readonly dependency
     */
    private Boolean BRANCH_CODE_READONLY;

    /**
     * this field corresponds to branch description Readonly dependency
     */
    private String BRIEF_DESC_ENG_READONLY;

    public Boolean getBRANCH_CODE_READONLY()
    {
	return BRANCH_CODE_READONLY;
    }

    public void setBRANCH_CODE_READONLY(Boolean bRANCHCODEREADONLY)
    {
	BRANCH_CODE_READONLY = bRANCHCODEREADONLY;
    }

    public String getBRIEF_DESC_ENG_READONLY()
    {
	return BRIEF_DESC_ENG_READONLY;
    }

    public void setBRIEF_DESC_ENG_READONLY(String bRIEFDESCENGREADONLY)
    {
	BRIEF_DESC_ENG_READONLY = bRIEFDESCENGREADONLY;
    }

}
