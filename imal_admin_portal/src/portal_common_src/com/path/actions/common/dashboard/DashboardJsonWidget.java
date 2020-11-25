package com.path.actions.common.dashboard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.dashboardportal.DashboardPortalBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dashboardportal.DashboardPortalSC;
import com.path.vo.common.dashboardportal.WidgetVO;

public class DashboardJsonWidget extends BaseAction
{
    private String layout;
    private String emptyDash;
    private ArrayList<WidgetVO> data = new ArrayList<WidgetVO>();
    private DashboardPortalBO dashboardPortalBO;
    
    private static final String PATH_REMOTING  = "PathRemoting";
    private static final String REP_COMMON_URL_PARAMS = "reports.commonParamsUrl";
    private static final String REP_COMMON_URL_DIRECT = "reports.commonDirectUrl";

    @Override
    public String execute()
    {
	//user dashboard layout
	try
	{
	    //access on the workspace Customize option and delete option
	    SessionCO session = returnSessionObject();
	    String currAppName = session.getCurrentAppName();
	    String[] opts = {ConstantsCommon.DASH_WKSPCE_WIDGET_CUST_OPT,ConstantsCommon.DASH_PORTAL_WIDGET_LIST_OPT,ConstantsCommon.DASH_ASSGN_USR_WIDGET_OPT};
	    HashMap<String,String> accessOpts = returnAccessRightByProgRef(opts, currAppName);
	    
	    String wkspceCustRight = accessOpts.get(ConstantsCommon.DASH_WKSPCE_WIDGET_CUST_OPT+"_"+currAppName);
	    String usrSideBarRight = accessOpts.get(ConstantsCommon.DASH_PORTAL_WIDGET_LIST_OPT+"_"+currAppName);
	    String wdgtAssignRight = accessOpts.get(ConstantsCommon.DASH_ASSGN_USR_WIDGET_OPT+"_"+currAppName);

	    DashboardPortalSC sc = new DashboardPortalSC();
	    sc.setUSER_ID(returnSessionObject().getUserName());
	    data = (ArrayList<WidgetVO>)dashboardPortalBO.returnUserPortal(sc);
	    if(data == null || data.isEmpty())
	    {
		setLayout("layout2");
		setEmptyDash("true");
	    }
	    else
	    {
		WidgetVO theVO;
		for(int i=0; i<data.size(); i++)
		{
		    theVO = data.get(i);
		    /**
		     * [MarwanMaddah]:In case the widget contents is a report
		     */
		    if(theVO.getUrl().startsWith(ConstantsCommon.PORTAL_REP_WIDGET))
		    {
			/**
			 * [Marwan Maddah]: regular expression to catch the report id from the URL
			 * this expression will catch the digits that are exists after "r_i="
			 * basic expression of it is : (\\w+)=(\\d+(.\\d+)?)
			 */
			String patrn = "(r_i)=(\\d+(.\\d+)?)";
			Pattern acceptedPattern = Pattern.compile(patrn);
			Matcher matcher = acceptedPattern.matcher(theVO.getUrl());
			BigDecimal reportId = null;
			while (matcher.find()) {            
			    reportId = new BigDecimal(matcher.group(2));
			}
			/**
			 * 
			 */
			CommonLibSC criteria = new CommonLibSC();
			criteria.setReportId(reportId);
			StringBuffer reportURL= new StringBuffer();
			/**
			 * [Marwan Maddah]:
			 * in case the args count >0, then the current report has arguments 
			 * in this case the parameters screen will appear and from it the report can be opened.
			 */
			if(returnCommonLibBO().checkReportDisplayArgs(criteria)>0)
			{
			    String repCommonURLParams = PathPropertyUtil.getPathRemotingProp(PATH_REMOTING, REP_COMMON_URL_PARAMS);
			    if(StringUtil.nullToEmpty(repCommonURLParams).isEmpty())
			    {
				throw new BOException(getText("exist_rep_common_prop_key"));
			    }
			    
			    reportURL.append(repCommonURLParams.trim());
			    reportURL.append("?");
			}
			else
			{
			    String repCommonUrlDirect = PathPropertyUtil.getPathRemotingProp(PATH_REMOTING, REP_COMMON_URL_DIRECT);
			    if(StringUtil.nullToEmpty(repCommonUrlDirect).isEmpty())
			    {
				throw new BOException(getText("exist_rep_common_prop_key"));
			    }
			    
			    reportURL.append(repCommonUrlDirect.trim());
			    reportURL.append("?");
			    reportURL.append("fromMenu=true");
			}
			String repUrl = theVO.getUrl().replace(ConstantsCommon.PORTAL_REP_WIDGET,reportURL);
			theVO.setUrl(repUrl);
			theVO.setRepUrl("1");
		    }
		    if(BigDecimal.ONE.compareTo(theVO.getUserPortlets().getCOLUMN_INDEX()) == 0)
		    {
			theVO.setColumn(DashboardPortalConstant.COLUMN_FIRST_CSS);
		    }
		    else if(theVO.getUserPortlets().getCOLUMN_INDEX().intValue() == 2)
		    {
			theVO.setColumn(DashboardPortalConstant.COLUMN_SECOND_CSS);
		    }
		    else
		    {
			theVO.setColumn(DashboardPortalConstant.COLUMN_THIRD_CSS);
		    }
		    theVO.setTitle(getText(theVO.getTitleKey()));
		    setLayout(theVO.getUserPortlets().getLAYOUT());
		    theVO.setMaximize(getText(ConstantsCommon.MAXIMIZE_KEY));
		    theVO.setMinimize(getText(ConstantsCommon.MINIMIZE_KEY));
		    theVO.setDel(getText(ConstantsCommon.DELETE_KEY));
		    theVO.setAssign_key_trans(getText(ConstantsCommon.ASSIGN_KEY));
		    theVO.setCustomize_key_trans(getText(ConstantsCommon.CUSTOMIZE_KEY));
		    theVO.setResize_key_trans(getText(ConstantsCommon.RESIZE_KEY));
		    theVO.setRefresh(getText(ConstantsCommon.REFRESH_KEY));
		    theVO.setWdgtDeleteDisplay("");
		    theVO.setWrkspceCustDisplay("");
		    theVO.setWdgtAssignDisplay("");
		    
		    if(usrSideBarRight == null)
		    {
			theVO.setWdgtDeleteDisplay("display:none");
		    }

		    if(wkspceCustRight == null || !DashboardPortalConstant.WORKSPACE_PORTLET_CODE.equals(theVO.getId()))
		    {
			theVO.setWrkspceCustDisplay("display:none");
		    }

		    if(wdgtAssignRight == null || DashboardPortalConstant.WORKSPACE_PORTLET_CODE.equals(theVO.getId()))
		    {
			theVO.setWdgtAssignDisplay("display:none");
		    }
			

		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String getLayout()
    {
	return layout;
    }

    public void setLayout(String layout)
    {
	this.layout = layout;
    }

    public ArrayList<WidgetVO> getData()
    {
	return data;
    }

    public void setData(ArrayList<WidgetVO> data)
    {
	this.data = data;
    }

    public void setDashboardPortalBO(DashboardPortalBO dashboardPortalBO)
    {
	this.dashboardPortalBO = dashboardPortalBO;
    }

    public String getEmptyDash()
    {
        return emptyDash;
    }

    public void setEmptyDash(String emptyDash)
    {
        this.emptyDash = emptyDash;
    }

}
