/**
 * 
 */
package com.path.struts2.taglib.tabs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * PathTabTag.java used to
 */
public class PathTabTag extends AbstractUITag
{
    private static final long serialVersionUID = 1L;

    protected String target;
    protected String closable;
    private   String labelKey;
    private   String href;
    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
      return new PathTab(stack, req, res);
    }

    @Override
    protected void populateParams()
    {
      super.populateParams();

      PathTab tab = (PathTab) component;
      tab.setTarget(target);
      tab.setClosable(closable);
      tab.setDisabled(disabled);
      tab.setLabelKey(labelKey);
      tab.setHref(href);
    }

    public void setTarget(String target)
    {
      this.target = target;
    }

    public void setClosable(String closable)
    {
      this.closable = closable;
    }

    /**
     * @return the labelKey
     */
    public String getLabelKey()
    {
        return labelKey;
    }

    /**
     * @param labelKey the labelKey to set
     */
    public void setLabelKey(String labelKey)
    {
        this.labelKey = labelKey;
    }

    /**
     * @return the href
     */
    public String getHref()
    {
        return href;
    }

    /**
     * @param href the href to set
     */
    public void setHref(String href)
    {
        this.href = href;
    }

}
