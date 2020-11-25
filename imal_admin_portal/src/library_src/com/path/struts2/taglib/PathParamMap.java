/**
 * 
 */
package com.path.struts2.taglib;

import java.io.Writer;
import java.util.Map;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          PathParamMap.java used to pass a map of parameter to a struts url
 *          tag
 */
public class PathParamMap extends Component
{
    private String map;

    public PathParamMap(ValueStack stack)
    {
	super(stack);
    }

    @Override
    public boolean end(Writer writer, String body)
    {

	if(this.map == null)
	{
	    return super.end(writer, "");
	}
	//Find the map in the valueStack
	Object o = findValue(this.map);
	if(o == null)
	{
	    return super.end(writer, "");
	}
	if(!(o instanceof Map))
	{
	    return super.end(writer, "");
	}
	//Return the parent component, s:url
	Component component = findAncestor(Component.class);
	//Fill the parameters defined in the map into the parent component (s:url)
	component.addAllParameters((Map) o);
	return super.end(writer, "");
    }

    public void setMap(String map)
    {
	this.map = map;
    }
}
