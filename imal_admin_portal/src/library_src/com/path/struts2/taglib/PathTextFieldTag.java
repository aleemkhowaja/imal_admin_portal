package com.path.struts2.taglib;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.struts2.lib.common.RootUtil;
import com.path.vo.common.SessionCO;

public class PathTextFieldTag extends PathBaseTag
{
	protected String mode;
	protected String minValue;
	protected String maxValue;
	protected String nbFormat;
	protected String noFormat    = "false";
	protected String groupSepa   = ",";
	protected String decimalSepa = ".";
	protected String leadZeros; 
	private   String showCurrency;
	private   String currencySymbol;
	private   String emptyValue;
	private   String afterDepEvent;
	private   String beforeDepEvent;
	private   String txtFormat;
        private   String formatter;
	private static String NUMBER_MODE = "number";
	private HashMap numberFormats;
	
	private String overrideLabelText;
	private String descriptionKey;
	private String onlyArabic;
	private String maxLenBeforeDec;
	private String allowDefValCust;
	private String required;

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
	{
		return new PathTextField(stack, req, res);
	}

	@Override
	protected void populateParams()
	{
		super.populateParams();

		PathTextField textField = ((PathTextField) component);
		if(mode == null || mode.isEmpty())
		{
			mode = "varchar";
		}
		textField.setMode(mode);
		textField.setMinValue(minValue);
		textField.setMaxValue(maxValue);
		textField.setNbFormat(nbFormat);
		textField.setNoFormat(noFormat);
		textField.setDecimalSepa(decimalSepa);
		textField.setGroupSepa(groupSepa);
		textField.setShowCurrency(showCurrency);
		textField.setCurrencySymbol(currencySymbol);
		textField.setEmptyValue(emptyValue);
		textField.setLeadZeros(leadZeros);
		textField.setAfterDepEvent(afterDepEvent);
		textField.setOverrideLabelText(overrideLabelText);
		textField.setBeforeDepEvent(beforeDepEvent);
		textField.setTxtFormat(txtFormat);
		textField.setFormatter(formatter);
		textField.setDescriptionKey(descriptionKey);
		textField.setOnlyArabic(onlyArabic);
		textField.setMaxLenBeforeDec(maxLenBeforeDec);
		textField.setAllowDefValCust(allowDefValCust);
		textField.setRequired(required);
	}

	public void setMode(String mode)
	{
		this.mode = mode;
	}

	public void setMinValue(String minValue)
	{
		this.minValue = minValue;
	}

	public void setMaxValue(String maxValue)
	{
		this.maxValue = maxValue;
	}

	public void setNbFormat(String nbFormat)
	{
		this.nbFormat = nbFormat;
	}

	@Override
	public int doStartTag() throws JspException
	{
		if(NUMBER_MODE.equals(mode))
		{
            numberFormats  = RootUtil.returnNumberFormat(pageContext.getSession());		        

            HashMap formats = RootUtil.manageNumberFormat(nbFormat, noFormat, numberFormats);

			if(StringUtil.nullToEmpty(nbFormat).equalsIgnoreCase("base"))
			{
				SessionCO sesCO = (SessionCO) pageContext.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
				 if (sesCO != null && sesCO.getBaseCurrDecPoint() != null) 
				 {
					try 
					{
						nbFormat = NumberUtil.currencyMask(sesCO.getBaseCurrDecPoint());
					} 
					 catch (BaseException e) 
					{
						Log.getInstance().error(e,"Error in aplying CurrencyMase TextField");
					}
				 }
			}
			Object tmpObj = null;
			if(nbFormat == null)
			{
				tmpObj = formats.get("nbFormat");
				if(tmpObj != null)
				{				    
				    nbFormat = (String) tmpObj;
				}
			}
			
			/**
			 * noFormat
			 */
			tmpObj = formats.get("noFormat");
			noFormat = (tmpObj == null) ? null : (String) tmpObj;
			
			/**
			 * Group Sepa 
			 */
			tmpObj = formats.get("groupSepa");
			groupSepa   = (tmpObj == null) ? "," : (String) tmpObj;
			
			/**
			 *  Decimal Separater.
			 */
			tmpObj = formats.get("decimalSepa");
			decimalSepa = (tmpObj == null) ? "." : (String) tmpObj;
		}
		return super.doStartTag();
	}

	public void setNoFormat(String noFormat)
	{
		this.noFormat = noFormat;
	}

	public void setShowCurrency(String showCurrency)
	{
		this.showCurrency = showCurrency;
	}

	public void setCurrencySymbol(String currencySymbol)
	{
		this.currencySymbol = currencySymbol;
	}

	public void setEmptyValue(String emptyValue)
	{
		this.emptyValue = emptyValue;
	}

	/**
	 * @return the decimalSepa
	 */
	public String getDecimalSepa()
	{
	    return decimalSepa;
	}

	/**
	 * @return the groupSepa
	 */
	public String getGroupSepa()
	{
	    return groupSepa;
	}

	/**
	 * @param groupSepa the groupSepa to set
	 */
	public void setGroupSepa(String groupSepa)
	{
	    this.groupSepa = groupSepa;
	}

	/**
	 * @param decimalSepa the decimalSepa to set
	 */
	public void setDecimalSepa(String decimalSepa)
	{
	    this.decimalSepa = decimalSepa;
	}

	/**
	 * @param leadZeros the leadZeros to set
	 */
	public void setLeadZeros(String leadZeros)
	{
	    this.leadZeros = leadZeros;
	}

	public void setAfterDepEvent(String afterDepEvent)
	{
	    this.afterDepEvent = afterDepEvent;
	}

	public void setOverrideLabelText(String overrideLabelText)
	{
	    this.overrideLabelText = overrideLabelText;
	}

	public void setBeforeDepEvent(String beforeDepEvent)
	{
	    this.beforeDepEvent = beforeDepEvent;
	}

	public void setTxtFormat(String txtFormat)
	{
	    this.txtFormat = txtFormat;
	}

	/**
	 * @return the formatter
	 */
	public String getFormatter()
	{
	    return formatter;
	}

	/**
	 * @param formatter the formatter to set
	 */
	public void setFormatter(String formatter)
	{
	    this.formatter = formatter;
	}

	public void setDescriptionKey(String descriptionKey)
	{
	    this.descriptionKey = descriptionKey;
	}

	/**
	 * @param onlyArabic the onlyArabic to set
	 */
	public void setOnlyArabic(String onlyArabic)
	{
	    this.onlyArabic = onlyArabic;
	}

	public void setMaxLenBeforeDec(String maxLenBeforeDec)
	{
	    this.maxLenBeforeDec = maxLenBeforeDec;
	}
	/**
	 * 
	 * @param allowDefValCust
	 */
	public void setAllowDefValCust(String allowDefValCust)
	{
	    this.allowDefValCust = allowDefValCust;
	}

	/**
	 * @return the required
	 */
	public String getRequired()
	{
	    return required;
	}

	/**
	 * @param required the required to set
	 */
	public void setRequired(String required)
	{
	    this.required = required;
	}
	
}
