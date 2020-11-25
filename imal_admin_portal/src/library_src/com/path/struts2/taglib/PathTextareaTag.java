package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.TextareaTag;

import com.opensymphony.xwork2.util.ValueStack;

public class PathTextareaTag extends TextareaTag {

    private String dir;
    private String maxlength;
    private String size;
    private String overrideLabelText;
    private String required;
    private String onlyArabic;
    
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new PathTextArea(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();
        
        PathTextArea pathTextarea = (PathTextArea)component;
        pathTextarea.setDir(dir);
        pathTextarea.setMaxlength(maxlength);
        pathTextarea.setSize(size);
        pathTextarea.setOverrideLabelText(overrideLabelText);
        pathTextarea.setRequired(required);
        pathTextarea.setOnlyArabic(onlyArabic);
    }

    public void setDir(String dir)
    {
        this.dir = dir;
    }

    public void setMaxlength(String maxlength)
    {
        this.maxlength = maxlength;
    }

    public void setSize(String size)
    {
        this.size = size;
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


    public void setOnlyArabic(String onlyArabic)
    {
        this.onlyArabic = onlyArabic;
    }
    
}
