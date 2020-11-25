/**
 * 
 */
package com.path.vo.common.screengenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.SYS_DYN_SCREEN_ELEMENTSVO;
import com.path.dbmaps.vo.SYS_DYN_SCREEN_ELEMENTS_DETVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.common.customization.button.SysParamGlobalActArgMapSC;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DynamicScreenDetailsCO.java used to
 */
public class DynamicScreenDetailsCO  extends BaseVO
{
    private SYS_DYN_SCREEN_ELEMENTSVO           sysDynScreenElemVO = new SYS_DYN_SCREEN_ELEMENTSVO();
    private String                              userName;
    private List<SYS_DYN_SCREEN_ELEMENTS_DETVO> elementDetLst      = new ArrayList<SYS_DYN_SCREEN_ELEMENTS_DETVO>(); 
    private List<DynamicScreenParamsMapCO> dynamicScreenParamsMapCOList = new ArrayList<DynamicScreenParamsMapCO>();
    private List<SysParamGlobalActArgMapSC>  globalActivityParamsMapSCList = new ArrayList<SysParamGlobalActArgMapSC>();
    private BigDecimal createFromElemId;
     /**
      * @return the sysDynScreenElemVO
      */
     public SYS_DYN_SCREEN_ELEMENTSVO getSysDynScreenElemVO()
     {
         return sysDynScreenElemVO;
     }
     
     /**
      * @param sysDynScreenElemVO the sysDynScreenElemVO to set
      */
     public void setSysDynScreenElemVO(SYS_DYN_SCREEN_ELEMENTSVO sysDynScreenElemVO)
     {
         this.sysDynScreenElemVO = sysDynScreenElemVO;
     }

     /**
      * @return the elementDetLst
      */
     public List<SYS_DYN_SCREEN_ELEMENTS_DETVO> getElementDetLst()
     {
         return elementDetLst;
     }

     /**
      * @param elementDetLst the elementDetLst to set
      */
     public void setElementDetLst(List<SYS_DYN_SCREEN_ELEMENTS_DETVO> elementDetLst)
     {
         this.elementDetLst = elementDetLst;
     }

    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * @return the dynamicScreenParamsMapCOList
     */
    public List<DynamicScreenParamsMapCO> getDynamicScreenParamsMapCOList()
    {
        return dynamicScreenParamsMapCOList;
    }

    /**
     * @param dynamicScreenParamsMapCOList the dynamicScreenParamsMapCOList to set
     */
    public void setDynamicScreenParamsMapCOList(List<DynamicScreenParamsMapCO> dynamicScreenParamsMapCOList)
    {
        this.dynamicScreenParamsMapCOList = dynamicScreenParamsMapCOList;
    }

    public BigDecimal getCreateFromElemId()
    {
        return createFromElemId;
    }

    public void setCreateFromElemId(BigDecimal createFromElemId)
    {
        this.createFromElemId = createFromElemId;
    }

    /**
     * @return the globalActivityParamsMapSCList
     */
    public List<SysParamGlobalActArgMapSC> getGlobalActivityParamsMapSCList()
    {
        return globalActivityParamsMapSCList;
    }

    /**
     * @param globalActivityParamsMapSCList the globalActivityParamsMapSCList to set
     */
    public void setGlobalActivityParamsMapSCList(List<SysParamGlobalActArgMapSC> globalActivityParamsMapSCList)
    {
        this.globalActivityParamsMapSCList = globalActivityParamsMapSCList;
    }
    
}
