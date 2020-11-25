package com.path.vo.common.swift.swiftoutward;

import com.path.dbmaps.vo.SWIFT_DWSCHEDVO;
import com.path.dbmaps.vo.SWIFT_DWSVO;
import com.path.dbmaps.vo.SWIFT_REPORTSVO;
import com.path.lib.vo.BaseVO;

public class SwiftOutwardSchedRepCO extends BaseVO
{
    private SWIFT_DWSVO swiftDwsVO;
    private SWIFT_REPORTSVO swiftReportsVO;
    private SWIFT_DWSCHEDVO swiftDwschedVO;
    
    public SWIFT_DWSCHEDVO getSwiftDwschedVO()
    {
        return swiftDwschedVO;
    }
    public void setSwiftDwschedVO(SWIFT_DWSCHEDVO swiftDwschedVO)
    {
        this.swiftDwschedVO = swiftDwschedVO;
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
