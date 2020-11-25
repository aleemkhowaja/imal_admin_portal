package com.path.lib.common.base;

import java.util.HashMap;

import com.path.bo.common.CommonLibBO;
import com.path.bo.common.audit.AuditBO;
import com.path.bo.common.smart.SmartBO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.log.Log;
import com.path.vo.common.RequiredFieldsSC;

public class BaseBO
{
	protected final static Log log = Log.getInstance();

	//common bean to be used in all BOImpl where we need to call the common CRUD methods 
	protected BaseDAOInterface genericDAO;
	
	//common bean to be used in all BOImpl where we need to call general common methods
	protected CommonLibBO commonLibBO;
	
	//common bean to be used in all BOImpl where we need to call audit Function
	protected AuditBO auditBO;
	
	 //common bean to be used in all BOImpl where we need to call SMART Function
	 protected SmartBO smartBO;
	 
	public void setGenericDAO(BaseDAOInterface genericDAO)
	{
		this.genericDAO = genericDAO;
	}

	public void setCommonLibBO(CommonLibBO commonLibBO) {
		this.commonLibBO = commonLibBO;
	}

	public void setAuditBO(AuditBO auditBO)
	{
	    this.auditBO = auditBO;
	}

	public void setSmartBO(SmartBO smartBO)
	{
	    this.smartBO = smartBO;
	}

    /**
     * Method that calls apply Dynamic Display Common processing to specify
     * needed action Type
     * 
     * @param elementId element ID to which actionType to be applied
     * @param elementName element Name to which actionType to be applied
     *            (elementId, and elementId both cannot be null)
     * @param actionType action to be applied (READONLY, MANDATORY, VISIBLE,...)
     *            ConstatntsCommon.ACTION_TYPE_...
     * @param value the value to be set (can be null)
     * @param businessMapToApplyTo current business element HashMap
     * @param criteria in case value is null then the criteria should be specified to fetch the
     *            details from DB
     * @return businessMapToApplyTo HashMap filled with requested action type
     *         details
     * @throws BaseException
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> applyDynScreenDisplay(String elementId, String elementName,
	    String actionType, String value, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo,
	    RequiredFieldsSC criteria) throws BaseException
    {
	return commonLibBO.applyDynScreenDisplay(elementId, elementName, actionType, value, businessMapToApplyTo,
		criteria);
    }

    /**
     * Method that calls apply Dynamic Display Common processing to specify
     * needed action Type on Array of provided Element Names or Ids
     * 
     * @param elementIdsOrNames array of provided names or ids to apply action
     *            on
     * @param actionType action to be applied (READONLY, MANDATORY, VISIBLE,...)
     *            ConstatntsCommon.ACTION_TYPE_...
     * @param value the value to be set (can be null)
     * @param businessMapToApplyTo current business element HashMap
     * @param criteria in case value is null then the criteria should be
     *            specified to fetch the details from DB
     * @return businessMapToApplyTo HashMap filled with requested action type
     *         details
     * @throws BaseException
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> applyDynScreenDisplay(String[] elementIdsOrNames,
	    String actionType, String value, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo,
	    RequiredFieldsSC criteria) throws BaseException
    {
	return commonLibBO.applyDynScreenDisplay(elementIdsOrNames, actionType, value, businessMapToApplyTo, criteria);
    }
	
}
