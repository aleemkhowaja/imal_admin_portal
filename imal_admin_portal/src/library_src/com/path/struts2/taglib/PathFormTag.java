package com.path.struts2.taglib;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.FormTag;

import com.opensymphony.xwork2.util.ValueStack;
import com.path.lib.common.util.DateUtil;
import com.path.struts2.lib.common.RootUtil;

public class PathFormTag extends FormTag
{

    private String isReadOnly;
    private HashMap numberFormats;
    private String enableAudit = "false";
    private String useHiddenProps;
    private String applyChangeTrack;
    private String exclTrackSecIds;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
	return new PathForm(stack, req, res);
    }

    @Override
    protected void populateParams()
    {
	super.populateParams();

	PathForm pathForm = ((PathForm) component);
	pathForm.setEnableAudit(enableAudit);
	pathForm.setUseHiddenProps(useHiddenProps);
	pathForm.setApplyChangeTrack(applyChangeTrack);
	pathForm.setExclTrackSecIds(exclTrackSecIds);
	if(isReadOnly == null || isReadOnly.isEmpty())
	{
	    this.setIsReadOnly("false");
	}

	if(theme == null || theme.isEmpty())
	{
	    pathForm.setTheme("path-xhtml");
	}

	if(numberFormats == null)
	{
	    pathForm.setDateMask("dd/MM/yyyy");
	    pathForm.setGroupSepa(",");
	    pathForm.setDecimalSepa(".");
	}
	else
	{
	    // dateMask
	    Object tmpObj = DateUtil.returnDateFormat(numberFormats);
	    pathForm.setDateMask((String) tmpObj);
	    // groupSepa
	    tmpObj = numberFormats.get("groupsepa");
	    pathForm.setGroupSepa((String) tmpObj);
	    // decimalSepa
	    tmpObj = numberFormats.get("decimalsepa");
	    pathForm.setDecimalSepa((String) tmpObj);
	    pathForm.setNumberFormats(numberFormats);
	}

    }

    @Override
    public int doStartTag() throws JspException
    {
	 Object numFormatObj = RootUtil.returnNumberFormat(pageContext.getSession());
	
	if(numFormatObj != null)
	{
	    numberFormats = (HashMap) numFormatObj;
	}
	return super.doStartTag();
    }


    public void setIsReadOnly(String isReadOnly)
    {
	this.isReadOnly = isReadOnly;
    }

    public HashMap getNumberFormats()
    {
	return numberFormats;
    }

    public void setEnableAudit(String enableAudit)
    {
	this.enableAudit = enableAudit;
    }

    public String getEnableAudit()
    {
	return enableAudit;
    }

    public void setUseHiddenProps(String useHiddenProps)
    {
        this.useHiddenProps = useHiddenProps;
    }

    public void setApplyChangeTrack(String applyChangeTrack)
    {
        this.applyChangeTrack = applyChangeTrack;
    }

    public void setExclTrackSecIds(String exclTrackSecIds)
    {
        this.exclTrackSecIds = exclTrackSecIds;
    }

}
