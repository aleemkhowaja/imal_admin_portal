/**
 * 
 */
package com.path.vo.common.dynamicscreen;

import java.util.ArrayList;
import java.util.List;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * AdditionElementsJSONCO.java used to
 */
public class AdditionalElementsJSONCO extends BaseVO
{
   List<LinkDynScrTabCO> addElementLst = new ArrayList<LinkDynScrTabCO>();

    public List<LinkDynScrTabCO> getAddElementLst()
    {
        return addElementLst;
    }
    
    public void setAddElementLst(List<LinkDynScrTabCO> addElementLst)
    {
        this.addElementLst = addElementLst;
    }
}
