package com.path.vo.reporting;

import com.path.dbmaps.vo.IRP_CONNECTIONSVO;
import com.path.lib.vo.BaseVO;

public class IRP_CONNECTIONSCO extends BaseVO
{

    private IRP_CONNECTIONSVO irpConnectionsVO= new IRP_CONNECTIONSVO();
    
    private String host;
    private String dbConfPass;
    private String oldDbPass;
    
    
    

    public String getOldDbPass()
    {
        return oldDbPass;
    }
    public void setOldDbPass(String oldDbPass)
    {
        this.oldDbPass = oldDbPass;
    }
    public String getDbConfPass()
    {
        return dbConfPass;
    }
    public void setDbConfPass(String dbConfPass)
    {
        this.dbConfPass = dbConfPass;
    }
    public IRP_CONNECTIONSVO getIrpConnectionsVO()
    {
        return irpConnectionsVO;
    }
    public void setIrpConnectionsVO(IRP_CONNECTIONSVO irpConnectionsVO)
    {
        this.irpConnectionsVO = irpConnectionsVO;
    }
    public String getHost()
    {
        return host;
    }
    public void setHost(String host)
    {
        this.host = host;
    }
    
}
