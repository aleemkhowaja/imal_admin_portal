package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;

import com.opensymphony.xwork2.util.ValueStack;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.RootUtil;

public class PathTextEditor extends UIBean
{

    public static final String EDITOR_TEMPLATE = "path-texteditor";
    private String id;
    private String width;
    private String height;
    
    private String required;
    private String readonly;

	public PathTextEditor(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    @Override
    protected String getDefaultTemplate()
    {
	return EDITOR_TEMPLATE;
    }

    @Override
    public void evaluateExtraParams()
    {
		super.evaluateExtraParams();
		if(id != null)
		{
		    addParameter("id", findString(id));
		}
		if(width != null)
		{
		    addParameter("width", findString(width));
		}
		if(height != null)
		{
		    addParameter("height", findString(height));
		}
		readonly = "false";
		SYS_PARAM_SCREEN_DISPLAYVO theVO = RootUtil.returnParamScreenDisplay(request, name, id);
		if(theVO != null)
		{
		    if(theVO.getIS_MANDATORY() != null && theVO.getIS_MANDATORY().intValue() == 1)
		    {
			   required = "true";
		    }
		    else
		    {
			    required = "false";
			    if(theVO.getIS_READONLY()!=null && theVO.getIS_READONLY().intValue() == 1)
			    {
			    	readonly = "true";
			    }
			    else
			    {
			    	readonly = "false";
			    }
		    }
		}
		if(StringUtil.isNotEmpty(required))
		{
		    addParameter("required", findValue(required, Boolean.class));
		}
		
		if(StringUtil.isNotEmpty(readonly))
		{		
			addParameter("readonly", readonly);
		}
	
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(String id)
    {
	this.id = id;
    }

    /**
     * @return the id
     */
    @Override
    public String getId()
    {
	return id;
    }

    /**
     * @return the width
     */
    public String getWidth()
    {
	return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(String width)
    {
	this.width = width;
    }

    /**
     * @return the height
     */
    public String getHeight()
    {
	return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height)
    {
	this.height = height;
    }

    /**
     * @return the required
     */
    public String getRequired()
    {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(String required)
    {
        this.required = required;
    }

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

    
    
}