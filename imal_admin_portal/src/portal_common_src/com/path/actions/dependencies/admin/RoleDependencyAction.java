package com.path.actions.dependencies.admin;

import java.math.BigDecimal;

import com.path.bo.admin.role.RoleBO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.S_ROLEVO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.admin.role.RoleSC;

public class RoleDependencyAction extends BaseAction
{
    public S_ROLEVO getRoleVO()
    {
        return roleVO;
    }

    public void setRoleVO(S_ROLEVO roleVO)
    {
        this.roleVO = roleVO;
    }

    public RoleSC getSc()
    {
        return sc;
    }

    public void setSc(RoleSC sc)
    {
        this.sc = sc;
    }

    public void setRoleBO(RoleBO roleBO)
    {
        this.roleBO = roleBO;
    }

    private RoleBO roleBO;
    private S_ROLEVO roleVO;
    private RoleSC sc = new RoleSC();
    
    @Override
    public Object getModel()
    {
	return sc;
    }
    
    public String workspaceRoleDependency()
    {
	try
	{
	    roleVO = roleBO.returnRole(sc);
	    SYS_PARAM_SCREEN_DISPLAYVO vo = new SYS_PARAM_SCREEN_DISPLAYVO();
	    if(StringUtil.nullToEmpty(sc.getRoleName()).isEmpty())
	    {
		vo.setIS_READONLY(BigDecimal.ZERO);
		vo.setIS_MANDATORY(BigDecimal.ONE);
	    }
	    else
	    {
		/**
		 * [MarwanMaddah]: in case the select role is valid
		 * or the previous value exists set user_id lookup readOnly. 
		 */
		if(roleVO!=null || !StringUtil.nullToEmpty(sc.getRolePrevName()).isEmpty())
		{		    
		    vo.setIS_READONLY(BigDecimal.ONE);
		    vo.setIS_MANDATORY(BigDecimal.ZERO);
		}
	    }
	    getAdditionalScreenParams().put("lookuptxt_user_id", vo);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

}
