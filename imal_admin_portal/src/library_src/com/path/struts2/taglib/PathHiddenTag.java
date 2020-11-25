package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.components.Hidden;
import org.apache.struts2.views.jsp.ui.HiddenTag;

import com.opensymphony.xwork2.util.ValueStack;


/**
 * @see Hidden
 */
public class PathHiddenTag extends HiddenTag {

    private static final long serialVersionUID = -1124367972048371675L;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
	
        return new PathHidden(stack, req, res);
    }
}
