/**
 * 
 */
package com.path.vo.common.screengenerator;

import java.math.BigDecimal;
import java.util.List;

import com.path.lib.vo.BaseVO;

/**
 * @author marwanmaddah
 *
 */
public class DynScrTablesCO extends BaseVO
{
   private BigDecimal TABLE_ID;
   private String     TABLE_TECH_NAME;
   private String     TABLE_DESC;
   private String     createdBy;
   private List<DynScrTableColsCO> colsLst;
   private String     createTblScript;
   private String modifiedBy;
/**
 * @return the tABLE_ID
 */
public BigDecimal getTABLE_ID()
{
    return TABLE_ID;
}
/**
 * @param tABLE_ID the tABLE_ID to set
 */
public void setTABLE_ID(BigDecimal tABLE_ID)
{
    TABLE_ID = tABLE_ID;
}
/**
 * @return the tABLE_TECH_NAME
 */
public String getTABLE_TECH_NAME()
{
    return TABLE_TECH_NAME;
}
/**
 * @param tABLE_TECH_NAME the tABLE_TECH_NAME to set
 */
public void setTABLE_TECH_NAME(String tABLE_TECH_NAME)
{
    TABLE_TECH_NAME = tABLE_TECH_NAME;
}
/**
 * @return the tABLE_DESC
 */
public String getTABLE_DESC()
{
    return TABLE_DESC;
}
/**
 * @param tABLE_DESC the tABLE_DESC to set
 */
public void setTABLE_DESC(String tABLE_DESC)
{
    TABLE_DESC = tABLE_DESC;
}
/**
 * @return the colsLst
 */
public List<DynScrTableColsCO> getColsLst()
{
    return colsLst;
}
/**
 * @param colsLst the colsLst to set
 */
public void setColsLst(List<DynScrTableColsCO> colsLst)
{
    this.colsLst = colsLst;
}
/**
 * @return the createTblScript
 */
public String getCreateTblScript()
{
    return createTblScript;
}
/**
 * @param createTblScript the createTblScript to set
 */
public void setCreateTblScript(String createTblScript)
{
    this.createTblScript = createTblScript;
}
/**
 * @return the createdBy
 */
public String getCreatedBy()
{
    return createdBy;
}
/**
 * @param createdBy the createdBy to set
 */
public void setCreatedBy(String createdBy)
{
    this.createdBy = createdBy;
}
    /**
     * @return the modifiedBy
     */
    public String getModifiedBy()
    {
	return modifiedBy;
    }
    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy)
    {
	this.modifiedBy = modifiedBy;
    }
}
