package com.path.struts2.taglib;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Form;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.ConstantsCommon;
import com.path.struts2.lib.common.base.BaseAction;

public class PathForm extends Form
{
    private String dateMask;
    private String groupSepa;
    private String decimalSepa;
    private String isReadOnly;
    private Map numberFormats = new HashMap<String, String>();
    private String enableAudit;
    private String useHiddenProps;
    private String applyChangeTrack; //used in case we need to have a from without useHiddenProps but still want the change track to be applied
    private String exclTrackSecIds; 

    public PathForm(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    @Override
    public boolean start(Writer arg0)
    {
	//the additional code should exists before calling super.start()	

	if(dateMask != null)
	{
	    addParameter("dateMask", findString(dateMask));
	}
	if(groupSepa != null)
	{
	    addParameter("groupSepa", findString(groupSepa));
	}
	if(decimalSepa != null)
	{
	    addParameter("decimalSepa", findString(decimalSepa));
	}

	if(numberFormats != null)
	{
	    addParameter("numberFormats", numberFormats);
	}
	if(useHiddenProps != null)
	{
	    addParameter("useHiddenProps", findString(useHiddenProps));
	}
	if(applyChangeTrack != null)
	{
	    addParameter("applyChangeTrack", findString(applyChangeTrack));
	}
	if(exclTrackSecIds != null)
	{
	    addParameter("exclTrackSecIds", findString(exclTrackSecIds));
	}

    
	//the super.start() should be called at the end of the method
	return super.start(arg0);
    }


    public String getIsReadOnly()
    {
	return isReadOnly;
    }

    public void setIsReadOnly(String isReadOnly)
    {
	this.isReadOnly = isReadOnly;
    }

    public String getDateMask()
    {
	return dateMask;
    }

    public void setDateMask(String dateMask)
    {
	this.dateMask = dateMask;
    }

    public String getGroupSepa()
    {
	return groupSepa;
    }

    public void setGroupSepa(String groupSepa)
    {
	this.groupSepa = groupSepa;
    }

    public String getDecimalSepa()
    {
	return decimalSepa;
    }

    public void setDecimalSepa(String decimalSepa)
    {
	this.decimalSepa = decimalSepa;
    }

    public Map getNumberFormats()
    {
	return numberFormats;
    }

    public void setNumberFormats(Map numberFormats)
    {
	this.numberFormats = numberFormats;
    }
    /**
     * 
     * @param enableAudit
     * If the action mode is in READ_MODE then the enableAudit will be set to the Action for Audit purpose 
     */
    public void setEnableAudit(String enableAudit)
    {
	this.enableAudit = enableAudit;
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	if(ConstantsCommon.READ_MODE.equals(baseAction.getAuditMode()))
	{
	    baseAction.set_enableAudit(Boolean.parseBoolean(enableAudit));
	}
    }

    public String getEnableAudit()
    {
	return enableAudit;
    }

    public String getUseHiddenProps()
    {
        return useHiddenProps;
    }

    public void setUseHiddenProps(String useHiddenProps)
    {
        this.useHiddenProps = useHiddenProps;
    }

    public String getApplyChangeTrack()
    {
        return applyChangeTrack;
    }

    public void setApplyChangeTrack(String applyChangeTrack)
    {
        this.applyChangeTrack = applyChangeTrack;
    }

    public String getExclTrackSecIds()
    {
        return exclTrackSecIds;
    }

    public void setExclTrackSecIds(String exclTrackSecIds)
    {
        this.exclTrackSecIds = exclTrackSecIds;
    }

    
}
