/**
 * 
 */
package com.path.vo.admin.smartaddoption;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * @author raees
 *
 */
@SuppressWarnings("serial")
public class SmartAddOptionsSC extends GridParamsSC
{
	private BigDecimal optionCode;
	private BigDecimal optionSerial;

	/**
	 * @return the optionCode
	 */
	public BigDecimal getOptionCode()
	{
		return optionCode;
	}

	/**
	 * @param optionCode the optionCode to set
	 */
	public void setOptionCode(BigDecimal optionCode)
	{
		this.optionCode = optionCode;
	}

	/**
	 * @return the optionSerial
	 */
	public BigDecimal getOptionSerial()
	{
		return optionSerial;
	}

	/**
	 * @param optionSerial the optionSerial to set
	 */
	public void setOptionSerial(BigDecimal optionSerial)
	{
		this.optionSerial = optionSerial;
	}
}
