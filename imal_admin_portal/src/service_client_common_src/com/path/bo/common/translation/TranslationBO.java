/**
 * 
 */
package com.path.bo.common.translation;

import java.util.ArrayList;

import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.SYS_PARAM_LOV_TYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.translation.TransUpdateCO;
import com.path.vo.common.translation.TranslationCO;
import com.path.vo.common.translation.TranslationSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: rabihelkhatib
 * 
 *          TranslationBO.java used to declare the Tranlastion screen business
 *          methods
 */
public interface TranslationBO
{
    /**
     * Method to fill the Labels Grid
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return ArrayList<TranslationCO>
     */
    public ArrayList<TranslationCO> selectLabelList(TranslationSC translationSC) throws BaseException;

    /**
     * Method to retrun the Labels count
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return Integer
     */
    public Integer selectLabelListCount(TranslationSC translationSC) throws BaseException;
    
    /**
     * Method to fill the Labels' translation Grid
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return ArrayList<TranslationCO>
     */
    public ArrayList<TranslationCO> selectLabelTransList(TranslationSC translationSC) throws BaseException;

    /**
     * Method to fill the Labels' translation count
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return Integer
     */
    public Integer selectLabelTransListCount(TranslationSC translationSC) throws BaseException;
    
    /**
     * Method to return the Label's translation
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return TranslationCO
     */
    public TranslationCO returnLabelTrans(TranslationSC translationSC) throws BaseException;
    
    /**
     * Method to fill the Groups' Grid
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return ArrayList<TranslationCO>
     */
    public ArrayList<TranslationCO> selectGroupList(TranslationSC translationSC) throws BaseException;

    /**
     * Method to return the Groups' count
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return Integer
     */
    public Integer selectGroupListCount(TranslationSC translationSC) throws BaseException;

    /**
     * Method to fill the Groups' translation Grid
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return ArrayList<TranslationCO>
     */
    public ArrayList<TranslationCO> selectGroupTransList(TranslationSC translationSC) throws BaseException;

    /**
     * Method to return the Groups' translation Count
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return Integer
     */
    public Integer selectGroupTransListCount(TranslationSC translationSC) throws BaseException;

    /**
     * Method to return the Group by KEY_GROUP_ID
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return TranslationCO
     */
    public TranslationCO checkGroupByIDDep(TranslationSC translationSC) throws BaseException;

    /**
     * Method to return the Page reference list
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return ArrayList<OPTVO>
     */
    public ArrayList<OPTVO> transPageRefList(TranslationSC translationSC) throws BaseException;

    /**
     * Method to return the Page reference list Count
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return Integer
     */
    public Integer transPageRefListCount(TranslationSC translationSC) throws BaseException;
    
    /**
     * To return the label keys list 
     * @author marwanmaddah
     * @date   Jul 21, 2014
     * @param translationSC
     * @return
     * @throws BaseException ArrayList<OPTVO>
     *
     */
    public ArrayList<OPTVO> transLabelKeyList(TranslationSC translationSC) throws BaseException;
    
    /**
     * To return the label keys list count
     * @author marwanmaddah
     * @date   Jul 21, 2014
     * @param translationSC
     * @return
     * @throws BaseException Integer
     *
     */
    public Integer transLabelKeyListCount(TranslationSC translationSC) throws BaseException;
    /**
     * Method to return the Page reference by pageRef
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return OPTVO
     */
    public OPTVO transPageRefByIDDep(TranslationSC translationSC) throws BaseException;
    /**
     * method to return the Label key by labelKey
     * @author marwanmaddah
     * @date   Jul 25, 2014
     * @param translationSC
     * @return
     * @throws BaseException SYS_PARAM_KEY_LABELVO
     *
     */
    public TranslationCO transLabelKeyByIDDep(TranslationSC translationSC) throws BaseException;
    /**
     * Method to save the new Key label
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return
     */
    public void saveNewKeyLabel(TranslationCO translationCO, TranslationSC translationSC) throws BaseException;

    /**
     * Method to save the new Key group
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return
     */
    public int saveNewKeyGroup(TranslationCO translationCO) throws BaseException;

    /**
     * Method to update the Translation Group ID in the SYS_PARAM_KEY_LABEL
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return
     */
    public void updateTransGroup(TranslationCO translationCO) throws BaseException;

    /**
     * Method to save group Translation
     * 
     * @param groupTranslationCO
     * @throws BaseException
     */
    public void saveGroupTrans(TransUpdateCO groupTranslationCO) throws BaseException;

    /**
     * Method to save label Translation
     * 
     * @param labelTranslationCO
     * @throws BaseException
     */
    public void saveLabelTrans(TransUpdateCO labelTranslationCO) throws BaseException;

    /**
     * Method to delete a Group translation
     * 
     * @param translationCO
     * @throws BaseException
     */
    public void deleteKeyGroup(TranslationCO translationCO) throws BaseException;

    /**
     * Method to delete a Key Label translation
     * 
     * @param translationCO
     * @throws BaseException
     */
    public void deleteKeyLabel(TranslationCO translationCO) throws BaseException;

    /**
     * Method to delete group Translation
     * 
     * @param translationCO
     * @throws BaseException
     */
    public void deleteGroupTrans(TranslationCO translationCO) throws BaseException;

    /**
     * Method to delete label Translation
     * 
     * @param translationCO
     * @throws BaseException
     */
    public void deleteLabelTrans(TranslationCO translationCO) throws BaseException;

    /**
     * Method to return the KEY_LABEL_CODE(s) dependent on a certain group
     * 
     * @param translationSC
     * @throws BaseException
     */
    public ArrayList<TranslationCO> returnGrpDependentList(TranslationSC translationSC) throws BaseException;

    /**
     * Method to return the KEY_LABEL_CODE(s) Count dependent on a certain group
     * 
     * @param translationSC
     * @throws BaseException
     */
    public int returnGrpDependentListCount(TranslationSC translationSC) throws BaseException;

    /**
     * Method to return the KEY_LABEL_CODE(s) List String dependent on a certain group
     * 
     * @param translationSC
     * @throws BaseException
     */
    public String returnGrpDependent(TranslationSC translationSC) throws BaseException;
    
    /**
     * Method to return a StringBuffer of all the Translation records required for export
     * 
     * @param translationSC
     * @throws BaseException
     */
    public StringBuffer returnLblExp(TranslationSC translationSC) throws BaseException;
    
    /**
     * Method to Method to Process the imported translation file
     * @return translationCO 
     * @param translationCO
     * @throws BaseException
     */
    public TranslationCO importLabels(TranslationCO translationCO) throws BaseException;
    /**
     * method to return details for specific key from Reference database, this is technical method used during 
     * development and QA phase at PathSolutions only.
     * @param translationSC
     */
    public void checkReferenceDBDetails(TranslationSC translationSC) throws BaseException;
    /**
     * method to send details for specific key to Reference database, this is technical method used during 
     * development and QA phase at PathSolutions only.
     * @param translationSC
     */
    public void sendReferenceDBDetails(TranslationSC translationSC) throws BaseException;
    
    /**
     * Method to fill the LOV Grid
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return ArrayList<TranslationCO>
     */
    public ArrayList<SYS_PARAM_LOV_TYPEVO> selectLOVList(TranslationSC translationSC) throws BaseException;

    /**
     * Method to return the LOVs count
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return Integer
     */
    public Integer selectLOVListCount(TranslationSC translationSC) throws BaseException;
    
    
    /**
     * Method to fill the LOVs' translation Grid
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return ArrayList<SYS_PARAM_LOV_TRANSVO>
     */
    public ArrayList<TranslationCO> selectLOVTransList(TranslationSC translationSC) throws BaseException;

    /**
     * Method to return the LOV's translation count
     * 
     * @param TranslationSC
     * @throws BaseException
     * @return Integer
     */
    public Integer selectLOVTransListCount(TranslationSC translationSC) throws BaseException;
    

    /**
     * Method to save LOV Translation
     * 
     * @param lovTranslationCO
     * @throws BaseException
     */
    public void saveLOVTrans(TransUpdateCO lovTranslationCO) throws BaseException;
    

    /**
     * Method to delete Labels and translation by APP_NAME and PROG_REF
     * Created upon request of reporting team this method will not delete PROG_REF "ROOT" or APP_NAME "IMAL"
     * @param translationSC
     * @throws BaseException
     */
    public void delByProgRef(TranslationSC translationSC) throws BaseException;
    
    /**
     * 440134 Translation Keys with Non Case Sensitivity BLME Issue
     * Checks the existence of keyLabelCode regardless of it's CASE state.
     * @param TranslationSC
     * @return int
     * @throws BaseException
     */
    public int checkKeyLabelCodeExist(TranslationSC sc) throws BaseException;
}
