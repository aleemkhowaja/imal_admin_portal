/**
 * 
 */
package com.path.vo.common.dynamicscreen;

import java.math.BigDecimal;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * DynamicScreenConstant.java used to
 */
public class DynamicScreenConstant
{
    public static final BigDecimal LOV_ELEMENT_TYPE = new BigDecimal(659);
    
    public static final String SRC_TYPE_LINK_TO_DYN_SCREEN = "1";
    public static final String SRC_TYPE_LINK_TO_GLOBAL_ACTIVITY = "3";
    public static final BigDecimal DYN_SCRN_DEFAULT_WIDTH = BigDecimal.valueOf(1024);
    
    public enum MAP_ELEMENT_TYPE
    {
	CUSTOM_BTN("1"), /*normal screen - add custom button - add action screen*/
	NORMAL_BTN_LINK_TO_DYN_SCREEN("2"), /*normal screen - normal button - customization - link to dynamic screen id*/ 
	NORMAL_BTN_LINK_TO_GLOBAL_ACT("3"), /*normal screen - normal button - customization - link to global activity*/
	DYN_BTN_LINK_TO_DYN_SCREEN("4"), /*dynamic screen - dynamic button - button source - internal screen id - dynamic screen*/
	DYN_BTN_LINK_TO_GLOBAL_ACT("5"); /*dynamic screen - dynamic button - button source - global activity*/
	
	private final String value;
	private MAP_ELEMENT_TYPE(final String value)
	{
	    this.value = value;
	}
	
	public boolean equals(final String value){
	    return this.value.equalsIgnoreCase(value);
	}
	public String getValue()
	{
	    return this.value;
	}
    };
    
    public enum BTN_SRC_TYPE
    {
	GLOBAL_ACTIVITY("3"); 
	private final String value;
	private BTN_SRC_TYPE(final String value)
	{
	    this.value = value;
	}
	
	public boolean equals(final String value){
	    return this.value.equalsIgnoreCase(value);
	}
	public String getValue()
	{
	    return this.value;
	}
    };
    
}
