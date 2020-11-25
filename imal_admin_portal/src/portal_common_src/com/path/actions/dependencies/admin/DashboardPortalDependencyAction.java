package com.path.actions.dependencies.admin;

import com.path.bo.common.MessageCodes;
import com.path.bo.common.dashboardportal.DashboardPortalBO;
import com.path.dbmaps.vo.SYS_PARAM_PORTLET_TYPEVO;
import com.path.dbmaps.vo.SYS_PARAM_USR_ALLOWED_PORTLETSVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.dashboardportal.DashboardPortalSC;

public class DashboardPortalDependencyAction extends BaseAction
{

    private final DashboardPortalSC sc = new DashboardPortalSC();
    private DashboardPortalBO dashboardPortalBO;
    private SYS_PARAM_PORTLET_TYPEVO portletVO = new SYS_PARAM_PORTLET_TYPEVO();
    
    @Override
    public Object getModel()
    {
	return sc;
    }
    
    public String DashboardPortletDependency()
    {
	try
	{
	    portletVO.setPORTLET_CODE(sc.getPortletCode());
	    if(StringUtil.isNotEmpty(sc.getPortletCode()) && StringUtil.isNotEmpty(sc.getUSER_ID()))
	    {
		SYS_PARAM_USR_ALLOWED_PORTLETSVO allwdPortletVO = new SYS_PARAM_USR_ALLOWED_PORTLETSVO();
		allwdPortletVO.setUSER_ID(sc.getUSER_ID());
		allwdPortletVO.setPORTLET_CODE(sc.getPortletCode());
		if(dashboardPortalBO.checkUsrAllwdPrtlts(allwdPortletVO))
		{
		    throw new BOException(MessageCodes.DUPLICATED_ENTRIES);
		}
	    }
	    portletVO = dashboardPortalBO.returnPortletInfo(portletVO);
	    if(portletVO == null)
	    {
		sc.setUSER_ID(null);
	    }
	    else
	    {
		portletVO.setTITLE_KEY(getText(portletVO.getTITLE_KEY()));
		String pCode = portletVO.getPORTLET_CODE();
		if(pCode.startsWith("_"))
		{
		    if(portletVO.getPORTLET_URL().startsWith("REPORT_"))
		    {
			portletVO.setABV_DESC_KEY(getText("reporting.report"));
		    }
		    else
		    {
			portletVO.setABV_DESC_KEY(getText("external_key"));
			portletVO.setTITLE_KEY(portletVO.getTITLE_KEY()+" ("+portletVO.getPORTLET_URL()+")");
		    }
		}
		else
		{
		    portletVO.setABV_DESC_KEY(getText("widget_key"));
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    portletVO.setPORTLET_CODE(null);
	}
	return SUCCESS;
    }

    public void setDashboardPortalBO(DashboardPortalBO dashboardPortalBO)
    {
        this.dashboardPortalBO = dashboardPortalBO;
    }

    public SYS_PARAM_PORTLET_TYPEVO getPortletVO()
    {
        return portletVO;
    }

    public void setPortletVO(SYS_PARAM_PORTLET_TYPEVO portletVO)
    {
        this.portletVO = portletVO;
    }
}
