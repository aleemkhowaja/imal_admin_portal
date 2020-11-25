package com.path.vo.reporting;

import com.path.lib.vo.BaseVO;

public class AUTOMATED_IMPORT_REPORTSCO extends BaseVO
{
    private String ZIP_FILE_NAME;
    private boolean USE_EXISTING_OPT;
    private boolean SKIP_TRANSLATION;
    private boolean UPDATE_VERSION_IF_EQUAL;
    
    private String ACTION;
    
    public String getZIP_FILE_NAME()
    {
        return ZIP_FILE_NAME;
    }
    public void setZIP_FILE_NAME(String zIPFILENAME)
    {
        ZIP_FILE_NAME = zIPFILENAME;
    }
    public boolean isUSE_EXISTING_OPT()
    {
        return USE_EXISTING_OPT;
    }
    public void setUSE_EXISTING_OPT(boolean uSEEXISTINGOPT)
    {
        USE_EXISTING_OPT = uSEEXISTINGOPT;
    }
    public boolean isSKIP_TRANSLATION()
    {
        return SKIP_TRANSLATION;
    }
    public void setSKIP_TRANSLATION(boolean sKIPTRANSLATION)
    {
        SKIP_TRANSLATION = sKIPTRANSLATION;
    }
    public String getACTION()
    {
        return ACTION;
    }
    public void setACTION(String aCTION)
    {
        ACTION = aCTION;
    }
    public boolean isUPDATE_VERSION_IF_EQUAL()
    {
        return UPDATE_VERSION_IF_EQUAL;
    }
    public void setUPDATE_VERSION_IF_EQUAL(boolean uPDATEVERSIONIFEQUAL)
    {
        UPDATE_VERSION_IF_EQUAL = uPDATEVERSIONIFEQUAL;
    }

    
    
}
