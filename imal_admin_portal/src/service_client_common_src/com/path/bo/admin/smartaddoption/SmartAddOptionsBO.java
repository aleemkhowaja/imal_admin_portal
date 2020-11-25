/**
 * 
 */
package com.path.bo.admin.smartaddoption;

import java.util.List;

import com.path.dbmaps.vo.S_ADDITIONS_OPTIONSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.smartaddoption.SmartAddOptionsSC;

/**
 * @author raees
 *
 */
public interface SmartAddOptionsBO
{
	public int returnSmartAddOptionsListCount(SmartAddOptionsSC smartAddOptionsSC) throws BaseException;
    public List<S_ADDITIONS_OPTIONSVO> returnSmartAddOptionsList(SmartAddOptionsSC smartAddOptionsSC) throws BaseException;
    public S_ADDITIONS_OPTIONSVO returnDependencyByOptionCode(SmartAddOptionsSC smartAddOptionsSC) throws BaseException;
    
    
}
