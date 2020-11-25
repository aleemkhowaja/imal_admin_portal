/**
 * 
 */
package com.path.struts2.taglib.collapsible;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: Rabih El Khatib
 *
 * PathCollapsGroupTag.java used to
 */
public class PathCollapsGroupTag extends AbstractUITag
{
//    protected String openOnMouseover;
//    protected String collapsible;
//    protected String animate;
//    protected String spinner;
//    protected String cache;
//    protected String sortable;
//
//    protected String onAddTopics;
//    protected String onRemoveTopics;
    
    private String userPrefLabel;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
      return new PathCollapsGroup(stack, req, res);
    }

    @Override
    protected void populateParams()
    {
      super.populateParams();
      PathCollapsGroup collapsGroup = (PathCollapsGroup) component;
//      collapsGroup.setAnimate(animate);
//      collapsGroup.setCollapsible(collapsible);
//      collapsGroup.setOpenOnMouseover(openOnMouseover);
//      collapsGroup.setSpinner(spinner);
//      collapsGroup.setCache(cache);
//      collapsGroup.setSortable(sortable);
//      collapsGroup.setOnAddTopics(onAddTopics);
//      collapsGroup.setOnRemoveTopics(onRemoveTopics);
      collapsGroup.setUserPrefLabel(userPrefLabel);
    }

    /**
     * @return the userPrefLabel
     */
    public String getUserPrefLabel()
    {
        return userPrefLabel;
    }

    /**
     * @param userPrefLabel the userPrefLabel to set
     */
    public void setUserPrefLabel(String userPrefLabel)
    {
        this.userPrefLabel = userPrefLabel;
    }

}
