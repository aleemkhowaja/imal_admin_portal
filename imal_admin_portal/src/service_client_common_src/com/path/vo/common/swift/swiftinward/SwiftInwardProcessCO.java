package com.path.vo.common.swift.swiftinward;

import com.path.dbmaps.vo.SWIFT_MSGDET_INVO;
import com.path.dbmaps.vo.SWIFT_MSGHDR_INVO;
import com.path.lib.vo.BaseVO;


public class SwiftInwardProcessCO extends BaseVO
{
    private SWIFT_MSGHDR_INVO swiftMsghdrInVO;
    private SWIFT_MSGDET_INVO swiftMsgdetInVO;
    public void setSwiftMsghdrInVO(SWIFT_MSGHDR_INVO swiftMsghdrInVO)
    {
	this.swiftMsghdrInVO = swiftMsghdrInVO;
    }
    public SWIFT_MSGHDR_INVO getSwiftMsghdrInVO()
    {
	return swiftMsghdrInVO;
    }
    public SWIFT_MSGDET_INVO getSwiftMsgdetInVO()
    {
        return swiftMsgdetInVO;
    }
    public void setSwiftMsgdetInVO(SWIFT_MSGDET_INVO swiftMsgdetInVO)
    {
        this.swiftMsgdetInVO = swiftMsgdetInVO;
    }
   
    
}
