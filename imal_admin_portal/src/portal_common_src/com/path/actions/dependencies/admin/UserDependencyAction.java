package com.path.actions.dependencies.admin;

import java.math.BigDecimal;
import java.util.Map;

import com.path.bo.admin.user.UsrBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.dashboardportal.DashboardPortalBO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_USR_ALLOWED_PORTLETSVO;
import com.path.dbmaps.vo.USER_PORTLETSVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.admin.user.UsrSC;
import com.path.vo.common.SessionCO;

public class UserDependencyAction extends BaseAction
{
    private UsrBO usrBO;
    private final UsrSC usrSC = new UsrSC();
    private USRVO usrVO;
    private DashboardPortalBO dashboardPortalBO;
    @Override
    public Object getModel()
    {
	return usrSC;
    }
    
    /**
     * this method check if the user have been already assigned to the specified portlet
     * @return
     */
    public String userPortletDependency()
    {
	try
	{
	    usrSC.setUser_id(StringUtil.nullToEmpty(usrSC.getUser_id()).toUpperCase()); 
	    usrSC.setCompCode(returnSessionObject().getCompanyCode());
	    usrSC.setPreferredLanguage(returnSessionObject().getLanguage());
	    usrSC.setLovTypeId(ConstantsCommon.USER_STATUS_LOV_TYPE);
	    if(StringUtil.isNotEmpty(usrSC.getPortletCode()) && StringUtil.isNotEmpty(usrSC.getUser_id()))
	    {
		USER_PORTLETSVO assgndPortletsVO = new USER_PORTLETSVO();
		assgndPortletsVO.setPORTLET_CODE(usrSC.getPortletCode());
		assgndPortletsVO.setUSER_ID(usrSC.getUser_id());
		if(dashboardPortalBO.checkUsrAssignedPrtlts(assgndPortletsVO))
		{
		    throw new BOException(MessageCodes.DUPLICATED_ENTRIES);
		}
	    }

	    usrVO = usrBO.getUserDetailsFor_w_lookup_user(usrSC);
	    if(usrVO == null)
	    {
		usrSC.setPortletCode(null);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String userDependency()
    {
	try
	{
	    usrSC.setUser_id(StringUtil.nullToEmpty(usrSC.getUser_id()).toUpperCase());  
	    usrSC.setCompCode(returnSessionObject().getCompanyCode());
	    usrSC.setPreferredLanguage(returnSessionObject().getLanguage());
	    usrSC.setLovTypeId(ConstantsCommon.USER_STATUS_LOV_TYPE);
	    if(StringUtil.isNotEmpty(usrSC.getPortletCode()))
	    {
		SYS_PARAM_USR_ALLOWED_PORTLETSVO allwdPortletVO = new SYS_PARAM_USR_ALLOWED_PORTLETSVO();
		allwdPortletVO.setUSER_ID(usrSC.getUser_id());
		allwdPortletVO.setPORTLET_CODE(usrSC.getPortletCode());
		if(dashboardPortalBO.checkUsrAllwdPrtlts(allwdPortletVO))
		{
		    throw new BOException(MessageCodes.DUPLICATED_ENTRIES);
		}
	    }

	    usrVO = usrBO.getUserDetailsFor_w_lookup_user(usrSC);
	    if(usrVO == null)
	    {
		usrSC.setPortletCode(null);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public String workspaceUserDependency()
    {
	try
	{
	    SYS_PARAM_SCREEN_DISPLAYVO vo = new SYS_PARAM_SCREEN_DISPLAYVO();
	    SessionCO sessionCO = returnSessionObject();
	    
	    usrSC.setCompCode(sessionCO.getCompanyCode());
	    usrSC.setPreferredLanguage(sessionCO.getLanguage());
	    usrSC.setLovTypeId(ConstantsCommon.USER_STATUS_LOV_TYPE);
	    usrSC.setUser_id(StringUtil.nullToEmpty(usrSC.getUser_id()).toUpperCase());
	    usrVO = usrBO.getUserDetailsFor_w_lookup_user(usrSC);
	    if(StringUtil.nullToEmpty(usrSC.getUser_id()).isEmpty())
	    {
		vo.setIS_READONLY(BigDecimal.ZERO);
		vo.setIS_MANDATORY(BigDecimal.ONE);
	    }
	    else
	    {
		/**
		 * [MarwanMaddah]: in case the select User is valid
		 * or the previous value exists set Role_name lookup ReadOnly. 
		 */
		if(usrVO!=null || !StringUtil.nullToEmpty(usrSC.getUserPrevId()).isEmpty())
		{
		   vo.setIS_READONLY(BigDecimal.ONE);
		   vo.setIS_MANDATORY(BigDecimal.ZERO);
		}
	    }
	    getAdditionalScreenParams().put("lookuptxt_role_name", vo);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String logLevelUserDependency()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    usrSC.setCompCode(sessionCO.getCompanyCode());
	    usrSC.setPreferredLanguage(sessionCO.getLanguage());
	    usrSC.setLovTypeId(ConstantsCommon.USER_STATUS_LOV_TYPE);
	    usrSC.setUser_id(StringUtil.nullToEmpty(usrSC.getUser_id()).toUpperCase());
	    usrVO = usrBO.getUserDetailsFor_w_lookup_user(usrSC);
	    
	    if(usrVO != null)
	    {
		Map resultMap = Log.returnLogByUserRemainingTime(usrVO.getUSER_ID());
		if(resultMap != null)
		{
		    String logByUserMsg = returnCommonLibBO().returnTranslErrorMessage(MessageCodes.LOG_BY_USER_REMAINING_TIME, new String[] { StringUtil.nullToEmpty(resultMap.get("minutes")), StringUtil.nullToEmpty(resultMap.get("seconds"))}, sessionCO.getLanguage());
		    usrVO.setUSER_STS(logByUserMsg);
		}
		else
		{
		    usrVO.setUSER_STS(null);
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    /**
     * added by Maria for TP#482435
     * 
     * @return
     */
    public String userEmailDependency()
    {
	try
	{
	    if((ConstantsCommon.ONE.equals(usrSC.getFieldFlag())
		    && !(StringUtil.nullToEmpty(usrSC.getUser_id()).isEmpty())
		    || (ConstantsCommon.TWO.equals(usrSC.getFieldFlag())
			    && !(StringUtil.nullToEmpty(usrSC.getEmail_id()).isEmpty()))))
	    {
		usrVO = usrBO.getUserEmailDetails(usrSC);
		if(usrVO == null)
		{
		    Integer msgCode;
		    if(ConstantsCommon.ONE.equals(usrSC.getFieldFlag()))
		    {
			msgCode = MessageCodes.INVALID_USER_ID;
		    }
		    else
		    {
			msgCode = MessageCodes.INVALID_EMAIL_ID;
		    }

		    throw new BOException(msgCode);

		}
	    }

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setUsrBO(UsrBO usrBO)
    {
	this.usrBO = usrBO;
    }

    public USRVO getUsrVO()
    {
        return usrVO;
    }

    public void setUsrVO(USRVO usrVO)
    {
        this.usrVO = usrVO;
    }

    public void setDashboardPortalBO(DashboardPortalBO dashboardPortalBO)
    {
        this.dashboardPortalBO = dashboardPortalBO;
    }
}
