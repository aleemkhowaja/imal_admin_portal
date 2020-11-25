/**
 *
 * Copyright 2019, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * USER STORY #799705 Control record - PWS mapping screen
 *
 */
package com.path.vo.common.pwsmapping;

import com.path.dbmaps.vo.COMMON_PWS_MAPPING_DETAILSVO;
import com.path.dbmaps.vo.IM_API_ARGUMENTVO;
import com.path.lib.vo.BaseVO;

public class CommonMappingArgCO  extends BaseVO{
	
	/**
     * Hold reference for Common Pws Mapping detail
     */
    private COMMON_PWS_MAPPING_DETAILSVO argMap = new COMMON_PWS_MAPPING_DETAILSVO();
    
	/**
     * Hold reference for Common Pws Mapping detail
     */
    private IM_API_ARGUMENTVO apiArgVO = new IM_API_ARGUMENTVO();

    
	/**
	 * @return
	 */
	public COMMON_PWS_MAPPING_DETAILSVO getArgMap() {
		return argMap;
	}

	/**
	 * @param argMap
	 */
	public void setArgMap(COMMON_PWS_MAPPING_DETAILSVO argMap) {
		this.argMap = argMap;
	}

	/**
	 * @return
	 */
	public IM_API_ARGUMENTVO getApiArgVO() {
		return apiArgVO;
	}

	/**
	 * @param apiArgVO
	 */
	public void setApiArgVO(IM_API_ARGUMENTVO apiArgVO) {
		this.apiArgVO = apiArgVO;
	}
    
    

}
