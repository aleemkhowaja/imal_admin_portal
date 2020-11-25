/**
 * 
 */
package com.path.vo.common.dynamicscreen;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * LinkDynScrTabCO.java used to
 */
public class LinkDynScrTabCO extends BaseVO
{
   private String     OBJECT_CODE;
   private String     OBJECT_TYPE;
   private String     PROG_REF;
   private String     APP_NAME;
   private String     SUB_OBJECT_DESC;
   private String     tabDesc;
   private BigDecimal SUB_OBJECT_ID;
   private BigDecimal DYN_SCREEN_ID;
   private String     SCREEN_DESC;
   private String     CREATED_BY;
   private Date       CREATED_DATE;
   private String     MODIFIED_BY;
   private Date       MODIFIED_DATE;
   private String     USER_ID;
   
public String getOBJECT_CODE()
{
    return OBJECT_CODE;
}
public void setOBJECT_CODE(String oBJECT_CODE)
{
    OBJECT_CODE = oBJECT_CODE;
}
public String getOBJECT_TYPE()
{
    return OBJECT_TYPE;
}
public void setOBJECT_TYPE(String oBJECT_TYPE)
{
    OBJECT_TYPE = oBJECT_TYPE;
}
public String getPROG_REF()
{
    return PROG_REF;
}
public void setPROG_REF(String pROG_REF)
{
    PROG_REF = pROG_REF;
}
public String getAPP_NAME()
{
    return APP_NAME;
}
public void setAPP_NAME(String aPP_NAME)
{
    APP_NAME = aPP_NAME;
}
public String getSUB_OBJECT_DESC()
{
    return SUB_OBJECT_DESC;
}
public void setSUB_OBJECT_DESC(String sUB_OBJECT_DESC)
{
    SUB_OBJECT_DESC = sUB_OBJECT_DESC;
}
public BigDecimal getSUB_OBJECT_ID()
{
    return SUB_OBJECT_ID;
}
public void setSUB_OBJECT_ID(BigDecimal sUB_OBJECT_ID)
{
    SUB_OBJECT_ID = sUB_OBJECT_ID;
}
public BigDecimal getDYN_SCREEN_ID()
{
    return DYN_SCREEN_ID;
}
public void setDYN_SCREEN_ID(BigDecimal dYN_SCREEN_ID)
{
    DYN_SCREEN_ID = dYN_SCREEN_ID;
}
public String getCREATED_BY()
{
    return CREATED_BY;
}
public void setCREATED_BY(String cREATED_BY)
{
    CREATED_BY = cREATED_BY;
}
public Date getCREATED_DATE()
{
    return CREATED_DATE;
}
public void setCREATED_DATE(Date cREATED_DATE)
{
    CREATED_DATE = cREATED_DATE;
}
public String getMODIFIED_BY()
{
    return MODIFIED_BY;
}
public void setMODIFIED_BY(String mODIFIED_BY)
{
    MODIFIED_BY = mODIFIED_BY;
}
public Date getMODIFIED_DATE()
{
    return MODIFIED_DATE;
}
public void setMODIFIED_DATE(Date mODIFIED_DATE)
{
    MODIFIED_DATE = mODIFIED_DATE;
}
public String getSCREEN_DESC()
{
    return SCREEN_DESC;
}
public void setSCREEN_DESC(String sCREEN_DESC)
{
    SCREEN_DESC = sCREEN_DESC;
}
public String getUSER_ID()
{
    return USER_ID;
}
public void setUSER_ID(String uSER_ID)
{
    USER_ID = uSER_ID;
}
public String getTabDesc()
{
    return tabDesc;
}
public void setTabDesc(String tabDesc)
{
    this.tabDesc = tabDesc;
}
}
