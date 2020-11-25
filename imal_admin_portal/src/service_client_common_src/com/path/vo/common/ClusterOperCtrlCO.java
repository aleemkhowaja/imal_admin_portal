package com.path.vo.common;

import java.util.Date;

import com.path.dbmaps.vo.SYS_CLUSTER_OPERATION_CTRLVO;

public class ClusterOperCtrlCO extends SYS_CLUSTER_OPERATION_CTRLVO
{
    private Date operationTime;

    public Date getOperationTime()
    {
        return operationTime;
    }

    public void setOperationTime(Date operationTime)
    {
        this.operationTime = operationTime;
    }
}
