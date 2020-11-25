package com.path.struts2.taglib.jquery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.views.jsp.ui.SpinnerTag;
import com.opensymphony.xwork2.util.ValueStack;

public class PathSpinnerTag extends SpinnerTag {

    private String overrideLabelText;
    private String required;
    
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
  {
    return new PathSpinner(stack, req, res);
  }

  protected void populateParams()
  {
    super.populateParams();

    PathSpinner spinner = (PathSpinner) component;
    spinner.setOverrideLabelText(overrideLabelText);
    spinner.setRequired(required);
  }

public void setOverrideLabelText(String overrideLabelText)
{
    this.overrideLabelText = overrideLabelText;
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

}
