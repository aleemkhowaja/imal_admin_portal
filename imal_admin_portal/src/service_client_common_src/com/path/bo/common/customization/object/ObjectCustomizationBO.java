/**
 * 
 */
package com.path.bo.common.customization.object;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.SYS_PARAM_OBJ_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.customization.object.ObjectCustomizationCO;
import com.path.vo.common.customization.object.ObjectCustomizationSC;

/**
 * @author marwanmaddah
 *
 */
public interface ObjectCustomizationBO
{
    /**
     * used to retrieve the the data of the selected object in case there are. 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public ObjectCustomizationCO returnObjectCustomization(ObjectCustomizationSC criteria) throws BaseException;
    /**
     * Used to update and save the customization data of the current Object. 
     * @param custCO
     * @throws BaseException
     */
    public void updateObjCustomization(ObjectCustomizationCO custCO) throws BaseException;
    /**
     * Used to update and save the custom activity on columns data of the current Object. 
     * @param custCO
     * @throws BaseException
     */
    public void updateCustActivtyOnCols(ObjectCustomizationCO custCO) throws BaseException;   
    /**
     * used to reset customization data of the current Object. 
     * @param custCO
     * @throws BaseException
     */
    public void resetCustomization(ObjectCustomizationCO custCO)throws BaseException;
    
    /**
     * used to return the count of customization details of the current Object.
     * @param custSC
     * @return
     * @throws BaseException
     */
    public int returnCusomizationDetailsListCount(ObjectCustomizationSC custSC)throws BaseException;
    
    /**
     * used to retrieve the customization details data of the current Object.
     * @param custSC
     * @return
     * @throws BaseException
     */
    public List<ObjectCustomizationSC> returnCusomizationDetailsList(ObjectCustomizationSC custSC)throws BaseException;
    /**
     * delete object customization details
     * @param custSC
     * @throws BaseException
     */
    public void deleteObjectCustDetails(ObjectCustomizationSC custSC)throws BaseException;
    /**
     * export object customization
     * @param custSC
     * @return
     * @throws BaseException
     */
    public ObjectCustomizationCO returnCustExp(ObjectCustomizationSC custSC)throws BaseException;
    /**
     * import object customization 
     * @param objCustCO
     * @throws BaseException
     */
    public void insertObjectCustomization(ObjectCustomizationCO objCustCO)throws BaseException;
   
    /**
     * get objectCustomization sql
     * @param custCO
     * @return
     */
    public String returnObjectCustSQL(ObjectCustomizationCO custCO)throws BaseException;
    /**
     * @description used to return field technical details from FIELD_TECH_DETAILS
     * 
     * @param sysParamObjDispVO
     * @return BigDecimal
     * @throws BaseException
     */
    public BigDecimal returnObjDisplayId(SYS_PARAM_OBJ_DISPLAYVO sysParamObjDispVO) throws BaseException;
}
