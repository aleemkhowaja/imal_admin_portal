package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.RadioTag;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: DeniskHaddad
 *
 * PathRadioTag.java used to overwrite Struts Radio Tag
 */
public class PathRadioTag extends RadioTag {

    private String considerChoiceValue;
    private String dynValue;
    //Bug 514831 Handling Radio Group label
    private String groupElemKeyLabel;
    private String hasHiddenOpt;
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new PathRadio(stack, req, res);
    }
    /**
     * 
     */
    @Override
    protected void populateParams()
    {
	super.populateParams();
	PathRadio radio = (PathRadio)component;
	radio.setConsiderChoiceValue(considerChoiceValue); 
	radio.setDynValue(dynValue);
	radio.setHasHiddenOpt(hasHiddenOpt);
	radio.setGroupElemKeyLabel(groupElemKeyLabel);
    }
    /**
     * @return the considerChoiceValue
     */
    public String getConsiderChoiceValue()
    {
        return considerChoiceValue;
    }
    /**
     * @param considerChoiceValue the considerChoiceValue to set
     */
    public void setConsiderChoiceValue(String considerChoiceValue)
    {
        this.considerChoiceValue = considerChoiceValue;
    }
    /**
     * @return the dynValue
     */
    public String getDynValue()
    {
        return dynValue;
    }
    /**
     * @param dynValue the dynValue to set
     */
    public void setDynValue(String dynValue)
    {
        this.dynValue = dynValue;
    }
    public String getGroupElemKeyLabel()
    {
        return groupElemKeyLabel;
    }
    public void setGroupElemKeyLabel(String groupElemKeyLabel)
    {
        this.groupElemKeyLabel = groupElemKeyLabel;
    }
    /**
     * @return the hasHiddenOpt
     */
    public String getHasHiddenOpt()
    {
        return hasHiddenOpt;
    }
    /**
     * @param hasHiddenOpt the hasHiddenOpt to set
     */
    public void setHasHiddenOpt(String hasHiddenOpt)
    {
        this.hasHiddenOpt = hasHiddenOpt;
    }    

}
