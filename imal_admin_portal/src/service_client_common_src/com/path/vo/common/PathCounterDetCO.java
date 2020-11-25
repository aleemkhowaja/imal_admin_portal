/**
 * 
 */
package com.path.vo.common;

import java.util.List;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * PathCounterDetCO.java used to
 */
public class PathCounterDetCO extends BaseVO
{
   private List<PathCounterLcCO> insertList;
   private List<PathCounterLcCO> updateList;
/**
 * @return the insertList
 */
public List<PathCounterLcCO> getInsertList()
{
    return insertList;
}
/**
 * @param insertList the insertList to set
 */
public void setInsertList(List<PathCounterLcCO> insertList)
{
    this.insertList = insertList;
}
/**
 * @return the updateList
 */
public List<PathCounterLcCO> getUpdateList()
{
    return updateList;
}
/**
 * @param updateList the updateList to set
 */
public void setUpdateList(List<PathCounterLcCO> updateList)
{
    this.updateList = updateList;
}
}
