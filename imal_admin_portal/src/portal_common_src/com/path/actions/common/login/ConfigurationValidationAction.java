package com.path.actions.common.login;

import java.util.Arrays;
import java.util.List;

import com.path.lib.common.util.PathPropertyUtil;
import com.path.struts2.lib.common.base.BaseAction;

/**
 * Make static validation checking on system configuration properties
 * 
 * @author HusseinZaraket
 *
 */
public class ConfigurationValidationAction extends BaseAction {

	private static final String CONFIG_VALIDATION_MESSAGE = "CONFIG_VALIDATION_MESSAGE";
	private static final String PROPERTIES_FILE_NAME = "PathRemoting";
	private static final String TRUE = "true";

	// config.verify.system.prop
	private static final String CONFIG_VERIFY_SYSTEM_PROP = "config.verify.system.prop";

	// java.awt.headless
	private static final String JAVA_AWT_HEADLESS = "java.awt.headless";

	public String verifyConfig() {
		try {
			String systemProperties = PathPropertyUtil.returnPathPropertyFromFile(PROPERTIES_FILE_NAME, CONFIG_VERIFY_SYSTEM_PROP);

			if (null == systemProperties) {
				addActionError("ERROR : config.verify.system.prop is not declared in  " + PROPERTIES_FILE_NAME + ".properties file.");
			} else {
				List<String> sysPropList = Arrays.asList(systemProperties.split(","));
				for (String sysProp : sysPropList) {
					addActionMessage(sysProp + " = " + System.getProperty(sysProp));
				}

				if (!sysPropList.contains(JAVA_AWT_HEADLESS)) {
					addActionError("ERROR : java.awt.headless should be added to config.verify.system.prop in " + PROPERTIES_FILE_NAME + ".properties file.");
				} else if (null == System.getProperty(JAVA_AWT_HEADLESS)) {
					addActionError("ERROR : java.awt.headless is not declared as system configurtion property at the server.");
				} else if (!TRUE.equals(System.getProperty(JAVA_AWT_HEADLESS))) {
					addActionError("ERROR : java.awt.headless value should be true in system configurtion property at the server.");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CONFIG_VALIDATION_MESSAGE;
	}
}
