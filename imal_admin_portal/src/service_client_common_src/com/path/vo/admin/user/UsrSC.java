package com.path.vo.admin.user;

import java.sql.Date;
import java.util.HashMap;

import com.path.struts2.lib.common.GridParamsSC;

public class UsrSC extends GridParamsSC
{
    private String user_id;
    private String user_grp_id;
    private String user_grp_desc;
    private Date user_valid_dt;
    private String user_sts;
    private HashMap status;
    private String portletCode;
    private String userListFlag;
    private String userPrevId;
    private String reportId;
    private String reportRef;
    private String appName;
    private String profType;
    private String sys_restriction_type;
    /* Login Alert Implementation TP#297149 */
    private String subordinate_id;
    private Integer subordinate_count;
    private Date login_alert_approval;
    private Integer pwdRestrictMirrorNo;
    private Date pwdDate;
    
    private String windowsUser; //Mark Ayoub - Paty
    
    // Added By Maria for TP#482435
    private String FieldFlag;
    private String Email_id;
    private String fromDealerScreen = "0";
    
    public UsrSC()
    {
	super.setSearchCols(new String[] { "USR_ID", "USER_ID", "FIRST_NAME", "MIDDLE_NAME", "LAST_NAME",
		"USER_GRP_ID", "USER_GRP_ID", "USER_GRP_DESC", "USER_VALID_DT", "USER_STS", "DATE_AUTHORIZED" });
    }

    public String getUser_id()
    {
	return user_id;
    }

    public void setUser_id(String userId)
    {
	user_id = userId;
    }

    public String getUser_grp_id()
    {
	return user_grp_id;
    }

    public void setUser_grp_id(String userGrpId)
    {
	user_grp_id = userGrpId;
    }

    public String getUser_grp_desc()
    {
	return user_grp_desc;
    }

    public void setUser_grp_desc(String userGrpDesc)
    {
	user_grp_desc = userGrpDesc;
    }

    public Date getUser_valid_dt()
    {
	return user_valid_dt;
    }

    public void setUser_valid_dt(Date userValidDt)
    {
	user_valid_dt = userValidDt;
    }

    public String getUser_sts()
    {
	return user_sts;
    }

    public void setUser_sts(String userSts)
    {
	user_sts = userSts;
    }

    public HashMap getStatus()
    {
	return status;
    }

    public void setStatus(HashMap status)
    {
	this.status = status;
    }

    public String getPortletCode()
    {
	return portletCode;
    }

    public void setPortletCode(String portletCode)
    {
	this.portletCode = portletCode;
    }

    public String getUserListFlag()
    {
	return userListFlag;
    }

    public void setUserListFlag(String userListFlag)
    {
	this.userListFlag = userListFlag;
    }

    /**
     * @return the userPrevId
     */
    public String getUserPrevId()
    {
	return userPrevId;
    }

    /**
     * @param userPrevId the userPrevId to set
     */
    public void setUserPrevId(String userPrevId)
    {
	this.userPrevId = userPrevId;
    }

    /**
     * @return the reportId
     */
    public String getReportId()
    {
        return reportId;
    }

    /**
     * @param reportId the reportId to set
     */
    public void setReportId(String reportId)
    {
        this.reportId = reportId;
    }

    /**
     * @return the reportRef
     */
    public String getReportRef()
    {
        return reportRef;
    }

    /**
     * @param reportRef the reportRef to set
     */
    public void setReportRef(String reportRef)
    {
        this.reportRef = reportRef;
    }

    /**
     * @return the appName
     */
    public String getAppName()
    {
        return appName;
    }

    /**
     * @param appName the appName to set
     */
    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    /**
     * @return the profType
     */
    public String getProfType()
    {
        return profType;
    }

    /**
     * @param profType the profType to set
     */
    public void setProfType(String profType)
    {
        this.profType = profType;
    }

    public String getSys_restriction_type()
    {
        return sys_restriction_type;
    }

    public void setSys_restriction_type(String sysRestrictionType)
    {
        sys_restriction_type = sysRestrictionType;
    }
        
    public String getSubordinate_id()
    {
        return subordinate_id;
    }

    public void setSubordinate_id(String subordinateId)
    {
        subordinate_id = subordinateId;
    }

    public Integer getSubordinate_count()
    {
        return subordinate_count;
    }

    public void setSubordinate_count(Integer subordinateCount)
    {
        subordinate_count = subordinateCount;
    }

    public Date getLogin_alert_approval()
    {
        return login_alert_approval;
    }

    public void setLogin_alert_approval(Date loginAlertApproval)
    {
        login_alert_approval = loginAlertApproval;
    }

    public Integer getPwdRestrictMirrorNo()
    {
        return pwdRestrictMirrorNo;
    }

    public void setPwdRestrictMirrorNo(Integer pwdRestrictMirrorNo)
    {
        this.pwdRestrictMirrorNo = pwdRestrictMirrorNo;
    }

    public Date getPwdDate()
    {
        return pwdDate;
    }

    public void setPwdDate(Date pwdDate)
    {
        this.pwdDate = pwdDate;
    }

    public String getWindowsUser()
    {
        return windowsUser;
    }

    public void setWindowsUser(String windowsUser)
    {
        this.windowsUser = windowsUser;
    }

    public String getFieldFlag()
    {
	return FieldFlag;
    }

    public void setFieldFlag(String fieldFlag)
    {
	FieldFlag = fieldFlag;
    }

    public String getEmail_id()
    {
	return Email_id;
    }

    public void setEmail_id(String email_id)
    {
	Email_id = email_id;
    }

	public String getFromDealerScreen() {
		return fromDealerScreen;
	}

	public void setFromDealerScreen(String fromDealerScreen) {
		this.fromDealerScreen = fromDealerScreen;
	}
    
}
