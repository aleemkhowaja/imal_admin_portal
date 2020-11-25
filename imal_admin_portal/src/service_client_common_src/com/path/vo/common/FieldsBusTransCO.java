/**
 * 
 */
package com.path.vo.common;

import com.path.dbmaps.vo.SYS_PARAM_FIELD_BUS_TRANSVO;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: deniskhaddad
 *
 * FieldsBusTransCO.java used to store additional details of SYS
 */
public class FieldsBusTransCO extends SYS_PARAM_FIELD_BUS_TRANSVO
{
  private String  MAP_KEY;

public String getMAP_KEY()
{
    return MAP_KEY;
}

public void setMAP_KEY(String mAPKEY)
{
    MAP_KEY = mAPKEY;
}

}
