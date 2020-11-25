package com.path.vo.common.swift.swiftoutward;

import com.path.dbmaps.vo.SWIFT_DWSVO;
import com.path.dbmaps.vo.SWIFT_REPORTSVO;
import com.path.lib.vo.BaseVO;

public class SwiftRepListCO extends BaseVO
{
    private SWIFT_DWSVO swiftDwsVO;
    private SWIFT_REPORTSVO swiftReportsVO = new SWIFT_REPORTSVO();
    private boolean repSelected;
    
    
    public boolean isRepSelected()
    {
        return repSelected;
    }
    public void setRepSelected(boolean repSelected)
    {
        this.repSelected = repSelected;
    }
    public SWIFT_DWSVO getSwiftDwsVO()
    {
        return swiftDwsVO;
    }
    public void setSwiftDwsVO(SWIFT_DWSVO swiftDwsVO)
    {
        this.swiftDwsVO = swiftDwsVO;
    }
    public SWIFT_REPORTSVO getSwiftReportsVO()
    {
        return swiftReportsVO;
    }
    public void setSwiftReportsVO(SWIFT_REPORTSVO swiftReportsVO)
    {
        this.swiftReportsVO = swiftReportsVO;
    }
}
