package com.path.struts2.taglib.toolbar;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;

import com.opensymphony.xwork2.util.ValueStack;

public class ToolBarGroup extends ClosingUIBean// Component
{
	
	public static final String OPEN_TEMPLATE = "path-toolbargroup";
	public static final String PATH_TEMPLATE = "path-toolbargroup-close";
	public static final String PATH_THEME = "path-xhtml";

	private String id;
	private String buttonIcon;
	private String buttonLabel;
	private String position;
	private String hideOnClick;
	
	public ToolBarGroup(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
		
	}
	
	@Override
	public boolean start(Writer arg0)
        {
	     // the super.start() should be called at the end of the method
    	     return super.start(arg0);
        }

	@Override
	public void setTheme(String theme) {
		super.setTheme(PATH_THEME);
	
	}

	@Override
	protected String getDefaultTemplate() {
		return PATH_TEMPLATE;
	}

	@Override
	public String getDefaultOpenTemplate() {
		return OPEN_TEMPLATE;
	}

	/**
	 * @return the id
	 */
	public String getId()
	{
	    return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
	    this.id = id;
	}

	/**
	 * @return the buttonIcon
	 */
	public String getButtonIcon()
	{
	    return buttonIcon;
	}

	/**
	 * @param buttonIcon the buttonIcon to set
	 */
	public void setButtonIcon(String buttonIcon)
	{
	    this.buttonIcon = buttonIcon;
	}

	/**
	 * @return the buttonLabel
	 */
	public String getButtonLabel()
	{
	    return buttonLabel;
	}

	/**
	 * @param buttonLabel the buttonLabel to set
	 */
	public void setButtonLabel(String buttonLabel)
	{
	    this.buttonLabel = buttonLabel;
	}

	/**
	 * @return the position
	 */
	public String getPosition()
	{
	    return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position)
	{
	    this.position = position;
	}

	/**
	 * @return the hideOnClick
	 */
	public String getHideOnClick()
	{
	    return hideOnClick;
	}

	/**
	 * @param hideOnClick the hideOnClick to set
	 */
	public void setHideOnClick(String hideOnClick)
	{
	    this.hideOnClick = hideOnClick;
	}
	
	
}
