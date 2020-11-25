/**
 * 
 */
package com.path.vo.generator;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * @author marwanmaddah
 *
 */
public class GeneratorSC extends GridParamsSC 
{
// private String rowId;
 private String templateId;
 private String templateName;
 private String appId;
 private String appFuncId;
 private String isDefault;

public GeneratorSC(){
		super.setSearchCols(new String[]{"TEMPLATE_ID", "TEMPLATE_NAME", "APP_ID", "APP_FUNC_ID", "IS_DEFAULT"});
 }
/**
 * @return the rowId
 */
//public String getRowId() {
//	return rowId;
//}

/**
 * @param rowId the rowId to set
 */
//public void setRowId(String rowId) {
//	this.rowId = rowId;
//}

/**
 * @return the templateId
 */
public String getTemplateId() {
	return templateId;
}

/**
 * @param templateId the templateId to set
 */
public void setTemplateId(String templateId) {
	this.templateId = templateId;
}
public String getTemplateName() {
	return templateName;
}
public void setTemplateName(String templateName) {
	this.templateName = templateName;
}
public String getAppId() {
	return appId;
}
public void setAppId(String appId) {
	this.appId = appId;
}
public String getAppFuncId() {
	return appFuncId;
}
public void setAppFuncId(String appFuncId) {
	this.appFuncId = appFuncId;
}
public String getIsDefault() {
	return isDefault;
}
public void setIsDefault(String isDefault) {
	this.isDefault = isDefault;
}

}
