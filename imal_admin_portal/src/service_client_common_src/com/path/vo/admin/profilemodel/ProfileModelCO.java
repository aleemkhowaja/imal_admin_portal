/**
 * 
 */
package com.path.vo.admin.profilemodel;

import com.path.lib.vo.BaseVO;

/**
 * @author MarwanMaddah
 *
 */
public class ProfileModelCO extends BaseVO{
 
    private static final long serialVersionUID = 1L;
	private String PROFMOD_ID;
    private String PROFMOD_NAME;
    private String PROF_ID;
    private String PROF_NAME;
    private String PROF_DETAILS;
 
public String getPROFMOD_ID() {
	return PROFMOD_ID;
}
public void setPROFMOD_ID(String pROFMODID) {
	PROFMOD_ID = pROFMODID;
}
public String getPROFMOD_NAME() {
	return PROFMOD_NAME;
}
public void setPROFMOD_NAME(String pROFMODNAME) {
	PROFMOD_NAME = pROFMODNAME;
}
/**
 * @return the pROF_ID
 */
public String getPROF_ID() {
	return PROF_ID;
}
/**
 * @param pROFID the pROF_ID to set
 */
public void setPROF_ID(String pROFID) {
	PROF_ID = pROFID;
}
/**
 * @return the pROF_NAME
 */
public String getPROF_NAME() {
	return PROF_NAME;
}
/**
 * @param pROFNAME the pROF_NAME to set
 */
public void setPROF_NAME(String pROFNAME) {
	PROF_NAME = pROFNAME;
}
/**
 * @return the pROF_DETAILS
 */
public String getPROF_DETAILS() {
	return PROF_DETAILS;
}
/**
 * @param pROFDETAILS the pROF_DETAILS to set
 */
public void setPROF_DETAILS(String pROFDETAILS) {
	PROF_DETAILS = pROFDETAILS;
}
}
