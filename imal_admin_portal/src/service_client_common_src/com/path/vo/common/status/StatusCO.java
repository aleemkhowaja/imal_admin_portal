/**
 * @Auther:MarwanMaddah
 * @Date:Mar 13, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.common.status;

import java.util.Date;
import java.util.Map;

import com.path.lib.vo.BaseVO;

/**
 * @author MarwanMaddah
 * 
 */
public class StatusCO extends BaseVO
{
    private String code;
    private String userName;
    private String status_desc;
    private Date status_date;
    /**
     * used to fill additional Maps if Exists
     */
    private Map<String,Object> addFieldMap;

    /**
     * @return the code
     */
    public String getCode()
    {
	return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code)
    {
	this.code = code;
    }

    /**
     * @return the status_desc
     */
    public String getStatus_desc()
    {
	return status_desc;
    }

    /**
     * @param statusDesc the status_desc to set
     */
    public void setStatus_desc(String statusDesc)
    {
	status_desc = statusDesc;
    }

    /**
     * @return the status_date
     */
    public Date getStatus_date()
    {
	return status_date;
    }

    /**
     * @param statusDate the status_date to set
     */
    public void setStatus_date(Date statusDate)
    {
	status_date = statusDate;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
	return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
	this.userName = userName;
    }
  
    public Map<String, Object> getAddFieldMap()
    {
        return addFieldMap;
    }

    public void setAddFieldMap(Map<String, Object> addFieldMap)
    {
        this.addFieldMap = addFieldMap;
    }

}
