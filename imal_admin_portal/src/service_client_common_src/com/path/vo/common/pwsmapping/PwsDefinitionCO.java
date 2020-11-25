/**
 *
 * Copyright 2019, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * USER STORY #799705 Control record - PWS mapping screen
 *
 */
package com.path.vo.common.pwsmapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.COMMON_PWS_MAPPINGVO;
import com.path.dbmaps.vo.COMMON_PWS_MAPPING_DEFVO;
import com.path.dbmaps.vo.COMMON_PWS_MAPPING_DETAILSVO;
import com.path.dbmaps.vo.IM_IMAL_APIVO;
import com.path.lib.vo.BaseVO;

public class PwsDefinitionCO extends BaseVO{
	
	/**
     * Hold reference for Common Pws Mapping
     */
    private COMMON_PWS_MAPPINGVO mappingVO = new COMMON_PWS_MAPPINGVO();
    
    private COMMON_PWS_MAPPING_DETAILSVO mappingDetVO = new COMMON_PWS_MAPPING_DETAILSVO();

    
	List<COMMON_PWS_MAPPING_DETAILSVO> lstCommonPwsMappingDetailsVO;

    /**
     * Hold reference for Common Pws Mapping definition
     */
    private COMMON_PWS_MAPPING_DEFVO definitionVO = new COMMON_PWS_MAPPING_DEFVO();
	
    /**
     * Hold reference for Api definition
     */
    private IM_IMAL_APIVO apiDefinitionVO = new IM_IMAL_APIVO();
    
	/**
	 * Hold the list of arguments
	 */
	private String serviceType;
	
	
	private String argumentItems;
	/**
	 * Hold the list of arguments
	 */
	private ArrayList<String> argumentList = new ArrayList<String>();
	
	/**
	 * Hold Api arguments
	 */
	private String argGridUpdates;
	
	/**
	 * Hold List of Api arguments
	 */
	private ArrayList<CommonMappingArgCO> argGridUpdatesList;
	
	private BigDecimal apiCode;
	
	/**
	 * @return
	 */
	public ArrayList<String> getArgumentList() {
		return argumentList;
	}

	/**
	 * @param argumentList
	 */
	public void setArgumentList(ArrayList<String> argumentList) {
		this.argumentList = argumentList;
	}

	/**
	 * @return
	 */
	public COMMON_PWS_MAPPINGVO getMappingVO() {
		return mappingVO;
	}

	/**
	 * @param mappingVO
	 */
	public void setMappingVO(COMMON_PWS_MAPPINGVO mappingVO) {
		this.mappingVO = mappingVO;
	}

	/**
	 * @return
	 */
	public COMMON_PWS_MAPPING_DEFVO getDefinitionVO() {
		return definitionVO;
	}

	/**
	 * @param definitionVO
	 */
	public void setDefinitionVO(COMMON_PWS_MAPPING_DEFVO definitionVO) {
		this.definitionVO = definitionVO;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public IM_IMAL_APIVO getApiDefinitionVO() {
		return apiDefinitionVO;
	}

	public void setApiDefinitionVO(IM_IMAL_APIVO apiDefinitionVO) {
		this.apiDefinitionVO = apiDefinitionVO;
	}

	/**
	 * @return the argGridUpdates
	 */
	public String getArgGridUpdates() {
		return argGridUpdates;
	}

	/**
	 * @param argGridUpdates the argGridUpdates to set
	 */
	public void setArgGridUpdates(String argGridUpdates) {
		this.argGridUpdates = argGridUpdates;
	}

	/**
	 * @return the argGridUpdatesList
	 */
	public ArrayList<CommonMappingArgCO> getArgGridUpdatesList() {
		return argGridUpdatesList;
	}

	/**
	 * @param argGridUpdatesList the argGridUpdatesList to set
	 */
	public void setArgGridUpdatesList(ArrayList<CommonMappingArgCO> argGridUpdatesList) {
		this.argGridUpdatesList = argGridUpdatesList;
	}

	public String getArgumentItems() {
		return argumentItems;
	}

	public void setArgumentItems(String argumentItems) {
		this.argumentItems = argumentItems;
	}

	public COMMON_PWS_MAPPING_DETAILSVO getMappingDetVO() {
		return mappingDetVO;
	}

	public void setMappingDetVO(COMMON_PWS_MAPPING_DETAILSVO mappingDetVO) {
		this.mappingDetVO = mappingDetVO;
	}

	public List<COMMON_PWS_MAPPING_DETAILSVO> getLstCommonPwsMappingDetailsVO() {
		return lstCommonPwsMappingDetailsVO;
	}

	public void setLstCommonPwsMappingDetailsVO(List<COMMON_PWS_MAPPING_DETAILSVO> lstCommonPwsMappingDetailsVO) {
		this.lstCommonPwsMappingDetailsVO = lstCommonPwsMappingDetailsVO;
	}

	public BigDecimal getApiCode() {
		return apiCode;
	}

	public void setApiCode(BigDecimal apiCode) {
		this.apiCode = apiCode;
	}
}

