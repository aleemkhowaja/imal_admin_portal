/**
 * 
 */
package com.path.vo.common;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * ScreenElementsMapCO.java used to
 */
public class ScreenElementsMapCO  extends BaseVO
{
    private String PROG_REF;
    private String DISPLAY_FIELD_NAME;
    private String ELEMENT_NAME;
    private String ELEMENT_ID;
    private String FIELD_DATA_TYPE;
    private String FLD_IDENTIFIER;
    
    public String getPROG_REF()
    {
        return PROG_REF;
    }
    public void setPROG_REF(String pROG_REF)
    {
        PROG_REF = pROG_REF;
    }
    public String getDISPLAY_FIELD_NAME()
    {
        return DISPLAY_FIELD_NAME;
    }
    public void setDISPLAY_FIELD_NAME(String dISPLAY_FIELD_NAME)
    {
        DISPLAY_FIELD_NAME = dISPLAY_FIELD_NAME;
    }
    public String getELEMENT_NAME()
    {
        return ELEMENT_NAME;
    }
    public void setELEMENT_NAME(String eLEMENT_NAME)
    {
        ELEMENT_NAME = eLEMENT_NAME;
    }
    public String getELEMENT_ID()
    {
        return ELEMENT_ID;
    }
    public void setELEMENT_ID(String eLEMENT_ID)
    {
        ELEMENT_ID = eLEMENT_ID;
    }
    public String getFIELD_DATA_TYPE()
    {
        return FIELD_DATA_TYPE;
    }
    public void setFIELD_DATA_TYPE(String fIELD_DATA_TYPE)
    {
        FIELD_DATA_TYPE = fIELD_DATA_TYPE;
    }
    public String getFLD_IDENTIFIER()
    {
        return FLD_IDENTIFIER;
    }
    public void setFLD_IDENTIFIER(String fLD_IDENTIFIER)
    {
        FLD_IDENTIFIER = fLD_IDENTIFIER;
    }
}
