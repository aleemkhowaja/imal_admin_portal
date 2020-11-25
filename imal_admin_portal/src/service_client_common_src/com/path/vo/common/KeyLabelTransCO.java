/**
 * 
 */
package com.path.vo.common;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * KeyLabelTransCO.java used to
 */
public class KeyLabelTransCO extends RetailBaseVO
{
    private String     KEY_LABEL_CODE;
    private String     VALUE_TRANS;
    private String     KEY_LABEL_DESC;
    private BigDecimal KEY_GROUP_ID;
    private String     GROUP_VALUE_TRANS;
    private String     KEY_GROUP_DESC;
    private String	MAP_KEY;
    private HashMap<String, HashMap> transMap = new HashMap<String, HashMap>();
    /**
     * @return the kEY_LABEL_CODE
     */
    public String getKEY_LABEL_CODE()
    {
        return KEY_LABEL_CODE;
    }
    /**
     * @param kEYLABELCODE the kEY_LABEL_CODE to set
     */
    public void setKEY_LABEL_CODE(String kEYLABELCODE)
    {
        KEY_LABEL_CODE = kEYLABELCODE;
    }
    /**
     * @return the vALUE_TRANS
     */
    public String getVALUE_TRANS()
    {
        return VALUE_TRANS;
    }
    /**
     * @param vALUETRANS the vALUE_TRANS to set
     */
    public void setVALUE_TRANS(String vALUETRANS)
    {
        VALUE_TRANS = vALUETRANS;
    }
    /**
     * @return the kEY_LABEL_DESC
     */
    public String getKEY_LABEL_DESC()
    {
        return KEY_LABEL_DESC;
    }
    /**
     * @param kEYLABELDESC the kEY_LABEL_DESC to set
     */
    public void setKEY_LABEL_DESC(String kEYLABELDESC)
    {
        KEY_LABEL_DESC = kEYLABELDESC;
    }
    /**
     * @return the kEY_GROUP_ID
     */
    public BigDecimal getKEY_GROUP_ID()
    {
        return KEY_GROUP_ID;
    }
    /**
     * @param kEYGROUPID the kEY_GROUP_ID to set
     */
    public void setKEY_GROUP_ID(BigDecimal kEYGROUPID)
    {
        KEY_GROUP_ID = kEYGROUPID;
    }
    /**
     * @return the gROUP_VALUE_TRANS
     */
    public String getGROUP_VALUE_TRANS()
    {
        return GROUP_VALUE_TRANS;
    }
    /**
     * @param gROUPVALUETRANS the gROUP_VALUE_TRANS to set
     */
    public void setGROUP_VALUE_TRANS(String gROUPVALUETRANS)
    {
        GROUP_VALUE_TRANS = gROUPVALUETRANS;
    }
    /**
     * @return the kEY_GROUP_DESC
     */
    public String getKEY_GROUP_DESC()
    {
        return KEY_GROUP_DESC;
    }
    /**
     * @param kEYGROUPDESC the kEY_GROUP_DESC to set
     */
    public void setKEY_GROUP_DESC(String kEYGROUPDESC)
    {
        KEY_GROUP_DESC = kEYGROUPDESC;
    }
    public String getMAP_KEY()
    {
        return MAP_KEY;
    }
    public void setMAP_KEY(String mAPKEY)
    {
        MAP_KEY = mAPKEY;
    }
    public void setTransMap(HashMap<String, HashMap> transMap)
    {
	this.transMap = transMap;
    }
    public HashMap<String, HashMap> getTransMap()
    {
	return transMap;
    }
}
