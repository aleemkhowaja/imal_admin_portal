package com.path.struts2.redirectaction;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.dispatcher.mapper.DefaultActionMapper;

/**
 * 
 * Copyright 2017, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * PathServletActionRedirectResult.java used to
 */
public class PathDefaultActionMapper extends DefaultActionMapper
{

    /* (non-Javadoc)
     * @see org.apache.struts2.dispatcher.mapper.DefaultActionMapper#handleDynamicMethod(org.apache.struts2.dispatcher.mapper.ActionMapping, java.lang.StringBuilder)
     */
    protected void handleDynamicMethod(ActionMapping mapping, StringBuilder uri)
    {
	// See WW-3965
        if (StringUtils.isNotEmpty(mapping.getMethod())) {
            if (allowDynamicMethodCalls) {
                // handle "name!method" convention.
                String name = mapping.getName();
                if (!name.contains("!")) {
                    // Append the method as no bang found
                    uri.append("!").append(mapping.getMethod());
                }
            } else {
        	//[PathSolutions] remove the append("!") that was added to url and that was causing error when allowDynamicMethodCalls is set to fault (by default)
                uri.append(mapping.getMethod());
            }
        }
    }
    
}
