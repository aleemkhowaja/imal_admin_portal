/**
 * 
 */
package com.path.vo.common.statuscustomization;

import java.io.Serializable;


/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * SelectedStatusCO.java used to
 */
public class SelectedStatusCO implements Serializable
{
   private String STATUS_CODE;

/**
 * @return the sTATUS_CODE
 */
public String getSTATUS_CODE()
{
    return STATUS_CODE;
}

/**
 * @param sTATUSCODE the sTATUS_CODE to set
 */
public void setSTATUS_CODE(String sTATUSCODE)
{
    STATUS_CODE = sTATUSCODE;
}
}
