package com.path.bo.common;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.path.dbmaps.vo.LOCVO;
import com.path.dbmaps.vo.PTH_CTRL1VO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.SWIFT_CONTROLVO;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DETAILS_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_CIFSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.S_AUDIT_MASK_FIELDSVO;
import com.path.vo.common.FieldsBusTransCO;

public class CachedConstantsCommon
{
    public volatile static HashMap<String, String[]> optHm  = new HashMap<String, String[]>(); //each menuVar with its String[]{ optUrl,Window_name
    public volatile static HashMap<String, HashMap> findInfo  = new HashMap<String, HashMap>(); //hashMap for cashing of different Info like trx Type
    public volatile static HashMap<String, Map<String,FieldsBusTransCO>> busTransInfo  = new HashMap<String, Map<String,FieldsBusTransCO>>(); //hashMap for caching business Translation of Fields, used in Base Action
    public volatile static HashMap<String, HashMap<String, Object>> expressionCodesMap ; //hashMap for caching parsed and Translated DW Expressions to Java
    public volatile static HashMap<String, PTH_CTRLVO> pthCtrlVOMap = new HashMap<String, PTH_CTRLVO>();  // SADS control record VO map
    public static final String DEFAULT_PTHCTRL_CACHE_KEY = "default_pthctrl";
    public volatile static PTH_CTRL1VO pthCtrl1VO; // general control record VO
    public static final String DYN_DYSPLAY_CACH_KEY = "dyb_disp_key";
    public volatile static SWIFT_CONTROLVO swiftCtrlVO; // SWIFT control record VO
    //[TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
    public static final String CUSTOM_ELEMENT_ACTIVITIES_CACHE_KEY = "customActivityOnGridColumns";
        
    /**
     * HashMap for Caching the required fields ...
     */
    public volatile static HashMap<String, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>> requiredFieldsMap = new HashMap<String, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>>();
    public volatile static HashMap<String, HashMap<String, SYS_PARAM_OBJ_DISPLAYVO>> requiredObjMap = new HashMap<String, HashMap<String, SYS_PARAM_OBJ_DISPLAYVO>>();
    public volatile static HashMap<String, HashMap<String, SYS_PARAM_OBJ_DETAILS_DISPLAYVO>> requiredObjDetailsMap = new HashMap<String, HashMap<String, SYS_PARAM_OBJ_DETAILS_DISPLAYVO>>();
    public volatile static HashMap<String, HashMap> keyLabelTransMap = new HashMap<String, HashMap>();
    public volatile static String apply_dynamic_screen = "1";
    
    /**
     * database Errors properties caching
     */
    public volatile static Properties databaseErrors;
    /**
     * HashMap for Caching the alerts parameters by appName and progRef ...
     */
    public volatile static Map<String, Map<String, Object>> alertsParamMap = new HashMap<String, Map<String,Object>>();
    public volatile static Map<String, List<LOCVO>> userLocations = new HashMap<String, List<LOCVO>>();
    
    /**
     * hashmap for caching maxlengths of additional Fields
     */
    public volatile static HashMap<String, HashMap<String, HashMap<String, BigDecimal>>> maxLengMap = new HashMap<String, HashMap<String, HashMap<String, BigDecimal>>>(); 
    
    //447471 Masking the info of VIP customers
    public volatile static HashMap<String, List<S_AUDIT_MASK_FIELDSVO>> fieldsToBeMasked = new HashMap<String, List<S_AUDIT_MASK_FIELDSVO>>();  // Fields to be masked in Audit   
    
    //691148 Field & CIF Audit  
    public volatile static HashMap<String, List<SYS_PARAM_SCREEN_CIFSVO>> screenCIFs = new HashMap<String, List<SYS_PARAM_SCREEN_CIFSVO>>();  // List of screen CIF fields to be audited. 
    
}
