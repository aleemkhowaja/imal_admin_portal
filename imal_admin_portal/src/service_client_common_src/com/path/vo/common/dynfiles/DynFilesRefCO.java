package com.path.vo.common.dynfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: ElieAchkar
 *
 * DynFilesRefCO.java used to store the parameters sent by the Interface and
 * the File Code with its details
 */

public class DynFilesRefCO extends BaseVO//to do check baseVO for the properties like compCode and check naming standard
{
    private String userID;		// logged in user
    private String compCode;		// company code
    private String branchCode;		// branch code
    private String appName;		// application name
    private BigDecimal structType;	// type of file, export or import
    private ArrayList<DynFilesCO> dynFilesCO;
    
    public String getUserID()
    {
        return userID;
    }
    public void setUserID(String userID)
    {
        this.userID = userID;
    }
    public String getCompCode()
    {
        return compCode;
    }
    public void setCompCode(String compCode)
    {
        this.compCode = compCode;
    }
    public String getBranchCode()
    {
        return branchCode;
    }
    public void setBranchCode(String branchCode)
    {
        this.branchCode = branchCode;
    }
    public String getAppName()
    {
        return appName;
    }
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    public ArrayList<DynFilesCO> getDynFilesCO()
    {
        return dynFilesCO;
    }
    public void setDynFilesCO(ArrayList<DynFilesCO> dynFilesCO)
    {
        this.dynFilesCO = dynFilesCO;
    }
    public BigDecimal getStructType()
    {
        return structType;
    }
    public void setStructType(BigDecimal structType)
    {
        this.structType = structType;
    }
}
