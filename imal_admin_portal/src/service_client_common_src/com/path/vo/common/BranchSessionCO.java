package com.path.vo.common;

import com.path.dbmaps.vo.BRANCH_SESSIONVO;
import com.path.lib.vo.BaseVO;

public class BranchSessionCO extends BaseVO
{
    private BRANCH_SESSIONVO branchSessionVO;
    private String userId;
    public BRANCH_SESSIONVO getBranchSessionVO()
    {
        return branchSessionVO;
    }
    public void setBranchSessionVO(BRANCH_SESSIONVO branchSessionVO)
    {
        this.branchSessionVO = branchSessionVO;
    }
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    } 
}
