package com.path.vo.common.swift.swiftoutward;

import com.path.dbmaps.vo.SWIFT_FORMATVO;
import com.path.dbmaps.vo.SWIFT_MSGDETVO;
import com.path.dbmaps.vo.SWIFT_MSGDETVOWithBLOBs;
import com.path.lib.vo.BaseVO;


public class SwiftOutwardProcessCO extends BaseVO
{
    private SWIFT_MSGDETVO swiftMsgDetVO;
    private SWIFT_FORMATVO swiftFormatVO;
    private SWIFT_MSGDETVOWithBLOBs swiftMsgDetVOWithBLOBs;
    
    
    public SWIFT_MSGDETVOWithBLOBs getSwiftMsgDetVOWithBLOBs()
    {
        return swiftMsgDetVOWithBLOBs;
    }
    public void setSwiftMsgDetVOWithBLOBs(SWIFT_MSGDETVOWithBLOBs swiftMsgDetVOWithBLOBs)
    {
        this.swiftMsgDetVOWithBLOBs = swiftMsgDetVOWithBLOBs;
    }
    public SWIFT_MSGDETVO getSwiftMsgDetVO()
    {
        return swiftMsgDetVO;
    }
    public void setSwiftMsgDetVO(SWIFT_MSGDETVO swiftMsgDetVO)
    {
        this.swiftMsgDetVO = swiftMsgDetVO;
    }
    public SWIFT_FORMATVO getSwiftFormatVO()
    {
        return swiftFormatVO;
    }
    public void setSwiftFormatVO(SWIFT_FORMATVO swiftFormatVO)
    {
        this.swiftFormatVO = swiftFormatVO;
    }
}
