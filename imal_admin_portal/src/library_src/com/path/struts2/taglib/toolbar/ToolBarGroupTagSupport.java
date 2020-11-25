package com.path.struts2.taglib.toolbar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("serial")
public class ToolBarGroupTagSupport extends AbstractClosingTag {

	private String id;
	private String buttonIcon;
	private String buttonLabel;
	private String position = "top"; //default value
	private String hideOnClick = "true"; //default value
	
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new ToolBarGroup(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();
		ToolBarGroup tBar = (ToolBarGroup) component;
		tBar.setId(id);
		tBar.setButtonLabel(buttonLabel);
		tBar.setButtonIcon(buttonIcon);
		tBar.setHideOnClick(hideOnClick);
		tBar.setPosition(position);
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
