/**
 * 
 */
package com.path.actions.dependencies.admin;

import com.path.bo.admin.smartaddoption.SmartAddOptionsBO;
import com.path.dbmaps.vo.S_ADDITIONS_OPTIONSVO;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.admin.smartaddoption.SmartAddOptionsSC;

/**
 * @author raees
 *
 */
@SuppressWarnings("serial")
public class SmartAddOptionsDependencyAction extends BaseAction
{
	private SmartAddOptionsSC smartAddOptionsSC = new SmartAddOptionsSC();
	private SmartAddOptionsBO smartAddOptionsBO;
	private S_ADDITIONS_OPTIONSVO sadditionsOptionsVO;
	
	/**
	 * get the dependency by option Code
	 * @return String
	 */
    public String dependencyByOptionCode() 
    {
		try 
		{
			if(smartAddOptionsSC.getOptionSerial() == null){
				sadditionsOptionsVO = new S_ADDITIONS_OPTIONSVO();
			}else{
			    sadditionsOptionsVO = smartAddOptionsBO.returnDependencyByOptionCode(smartAddOptionsSC);
			    sadditionsOptionsVO=(sadditionsOptionsVO==null?new S_ADDITIONS_OPTIONSVO():sadditionsOptionsVO);
			}
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByOptionCode method of SmartAddOptionsDependencyAction");
			handleException(e, "ERROR in SmartAddOptions Dependency", null);
		}

		return SUCCESS;
	}
    
	/**
	 * @return the smartAddOptionsSC
	 */
	public SmartAddOptionsSC getSmartAddOptionsSC()
	{
		return smartAddOptionsSC;
	}
	/**
	 * @param smartAddOptionsSC the smartAddOptionsSC to set
	 */
	public void setSmartAddOptionsSC(SmartAddOptionsSC smartAddOptionsSC)
	{
		this.smartAddOptionsSC = smartAddOptionsSC;
	}
	/**
	 * @param smartAddOptionsBO the smartAddOptionsBO to set
	 */
	public void setSmartAddOptionsBO(SmartAddOptionsBO smartAddOptionsBO)
	{
		this.smartAddOptionsBO = smartAddOptionsBO;
	}

	/**
	 * @return the sAdditionsOptionsVO
	 */
	public S_ADDITIONS_OPTIONSVO getSadditionsOptionsVO()
	{
		return sadditionsOptionsVO;
	}

	/**
	 * @param sAdditionsOptionsVO the sAdditionsOptionsVO to set
	 */
	public void setSadditionsOptionsVO(S_ADDITIONS_OPTIONSVO sAdditionsOptionsVO)
	{
		this.sadditionsOptionsVO = sAdditionsOptionsVO;
	}
}
