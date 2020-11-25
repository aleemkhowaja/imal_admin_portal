package com.path.struts2.taglib.jquery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.views.jsp.ui.SubmitTag;
import com.opensymphony.xwork2.util.ValueStack;

public class PathSubmitTag extends SubmitTag
{

    private String freezeOnSubmit = "true";
    private String progRef;
    private String allowView;
    private String allowCust;
    private String enableAfterExecution;
    private String overrideLabelText;
    protected String shortcutKey;
    private String customBtnId;
    private String buttonIconUrl;
    private String sourceAppName;
    
    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
	return new PathSubmit(stack, req, res);
    }

    public void setFreezeOnSubmit(String freezeOnSubmit)
    {
        this.freezeOnSubmit = freezeOnSubmit;
    }

    @Override
    protected void populateParams()
    {
	// TODO Auto-generated method stub
	super.populateParams();
	PathSubmit pathSubmit = (PathSubmit)component;
	pathSubmit.setFreezeOnSubmit(freezeOnSubmit);
	pathSubmit.setAllowCust(allowCust);
	pathSubmit.setEnableAfterExecution(enableAfterExecution);
	pathSubmit.setOverrideLabelText(overrideLabelText);
	if("true".equals(freezeOnSubmit))
	{
	    //setting indicator in case freezeOnSubmit is set to true
	    pathSubmit.setIndicator("indicatorDiv");
	}
	pathSubmit.setProgRef(progRef);
	pathSubmit.setShortcutKey(shortcutKey);
	pathSubmit.setCustomBtnId(customBtnId);
	pathSubmit.setButtonIconUrl(buttonIconUrl);
	pathSubmit.setSourceAppName(sourceAppName);
	pathSubmit.setAllowView(allowView);
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    /**
     * @param allowCust the allowCust to set
     */
    public void setAllowCust(String allowCust)
    {
        this.allowCust = allowCust;
    }
    
    

    public void setEnableAfterExecution(String enableAfterExecution)
    {
        this.enableAfterExecution = enableAfterExecution;
    }

    /**
     * @param overrideLabelText the overrideLabelText to set
     */
    public void setOverrideLabelText(String overrideLabelText)
    {
        this.overrideLabelText = overrideLabelText;
    }

    /**
     * @param shortcutKey the shortcutKey to set
     */
    public void setShortcutKey(String shortcutKey)
    {
        this.shortcutKey = shortcutKey;
    }
   
    public void setCustomBtnId(String customBtnId)
    {
        this.customBtnId = customBtnId;
    }

    public void setButtonIconUrl(String buttonIconUrl)
    {
        this.buttonIconUrl = buttonIconUrl;
    }
    /**
     * @param sourceAppName the sourceAppName to set
     */
    public void setSourceAppName(String sourceAppName)
    {
        this.sourceAppName = sourceAppName;
    }

    public String getAllowView()
    {
        return allowView;
    }

    public void setAllowView(String allowView)
    {
        this.allowView = allowView;
    }
}
