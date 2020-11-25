package com.path.vo.common.customization.file;

import com.path.lib.vo.BaseVO;

/**
 * Represent the File Customization value holder
 * 
 * @author MohammadAliMezzawi
 *
 */
public class FileCustomizationCO extends BaseVO
{
	/**
	 * Hold file name
	 */
	private String name;
	
	/**
	 * Hold file content as String
	 */
	private String content;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
