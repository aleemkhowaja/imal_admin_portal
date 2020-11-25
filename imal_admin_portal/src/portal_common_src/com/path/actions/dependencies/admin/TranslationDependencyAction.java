/**
 * 
 */
package com.path.actions.dependencies.admin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.translation.TranslationBO;
import com.path.dbmaps.vo.OPTVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.translation.TranslationCO;
import com.path.vo.common.translation.TranslationSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: rabihelkhatib
 * 
 *          TranslationDependencyAction.java used to Generate Dependencies for
 *          Translation Screen
 */
public class TranslationDependencyAction extends BaseAction
{
    private TranslationBO translationBO;
    private TranslationSC translationSC = new TranslationSC();
    private OPTVO optVO = new OPTVO();
    private TranslationCO translationCO = new TranslationCO();

    public String pageRefDep()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    if((ConstantsCommon.EXPORT_SPECIFIC_APP.equals(translationSC.getSelectedApp()))
		    || ((ConstantsCommon.IBIS_APP_NAME.equals(sessionCO.getCurrentAppName()) || ConstantsCommon.REP_APP_NAME
			    .equals(sessionCO.getCurrentAppName())) && StringUtil
			    .isNotEmpty(translationSC.getAppName())))
	    {
		translationSC.setAppName(translationSC.getAppName());
	    }
	    else
	    {
		translationSC.setAppName(sessionCO.getCurrentAppName());
	    }
	    
	    translationSC.setPreferredLanguage(sessionCO.getLanguage());
	    if(ConstantsCommon.PROGREF_ROOT.equals(translationSC.getPageRef()))
	    {
		optVO.setPROG_DESC(ConstantsCommon.PROGREF_ROOT);
		optVO.setPROG_REF(ConstantsCommon.PROGREF_ROOT);
		optVO.setParent(ConstantsCommon.PROGREF_ROOT);
	    }
	    else
	    {
		optVO = translationBO.transPageRefByIDDep(translationSC);
	    }

	    if(optVO == null)
	    {
		optVO = new OPTVO();
		optVO.setPROG_DESC(null);
		optVO.setPROG_REF(null);
		optVO.setParent(null);
	    }
	}
	catch(Exception e)
	{
	    optVO.setPROG_REF(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public String labelKeyDep()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    
	    if(ConstantsCommon.EXPORT_SPECIFIC_APP.equals(translationSC.getSelectedApp()))
	    {
		translationSC.setAppName(translationSC.getAppName());
	    }
	    else
	    {
		translationSC.setAppName(sessionCO.getCurrentAppName());
	    }

	    translationSC.setPreferredLanguage(sessionCO.getLanguage());
            if(StringUtil.nullToEmpty(translationSC.getLabelKey()).isEmpty())
            {
		translationCO = null;
            }
            else
            {
        	translationCO = translationBO.transLabelKeyByIDDep(translationSC);
            }
            
	    if(translationCO == null)
	    {
		translationCO = new TranslationCO();
		translationCO.getSysParamKeyLabelVO().setKEY_LABEL_CODE(null);
		translationCO.getSysParamKeyLabelVO().setKEY_LABEL_DESC(null);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String groupByIDDep()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    translationSC.setPreferredLanguage(sessionCO.getLanguage());
	    TranslationCO transCO = translationBO.checkGroupByIDDep(translationSC);

	    if(transCO == null)
	    {
		translationCO.getSysParamKeyGroupVO().setKEY_GROUP_DESC(null);
		translationSC.setAppName(translationCO.getSysParamKeyLabelVO().getAPP_NAME());
		translationSC.setPageRef(translationCO.getSysParamKeyLabelVO().getPROG_REF());
		translationSC.setKeyLabelCode(translationCO.getSysParamKeyLabelVO().getKEY_LABEL_CODE());
		
		if(StringUtil.isNotEmpty(translationSC.getAppName()))
		{
		    transCO = translationBO.returnLabelTrans(translationSC);
		}
		
		if(transCO == null)
		{
		    translationCO.setPrefTrans(translationCO.getSysParamKeyLabelVO().getKEY_LABEL_DESC());
		    translationCO.getSysParamKeyGroupVO().setKEY_GROUP_ID(null);
		}
		else
		{
		    translationCO.getSysParamKeyGroupVO().setKEY_GROUP_ID(null);
		    if(StringUtil.isNotEmpty(transCO.getLblValueTrans()))
		    {
			translationCO.setPrefTrans(transCO.getLblValueTrans());
		    }
		}
	    }
	    else
	    {
		translationCO.setPrefTrans(transCO.getPrefTrans());
		translationCO.getSysParamKeyGroupVO()
		.setKEY_GROUP_ID(transCO.getSysParamKeyGroupVO().getKEY_GROUP_ID());
		translationCO.getSysParamKeyGroupVO().setKEY_GROUP_DESC(
			transCO.getSysParamKeyGroupVO().getKEY_GROUP_DESC());
	    }
	}
	catch(Exception e)
	{
	    translationCO.getSysParamKeyLabelVO().setKEY_GROUP_ID(null);
	    translationSC.setKeyGroupID(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String updateTransGroup()
    {
	try
	{
	    groupByIDDep();
	    translationBO.updateTransGroup(translationCO);

	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return SUCCESS;
    }

    /**
     * 440134 Translation Keys with Non Case Sensitivity BLME Issue
     * Checks the existence of keyLabelCode regardless of it's CASE state.
     * @return
     */
    public String keyLowerDep()
    {
		try
		{
		    SessionCO sessionObject = returnSessionObject();
		    if(translationSC.getGlobalRef())
		    {
			translationSC.setAppName(ConstantsCommon.IMAL_APP_NAME);
		    }
		    else
		    {
			translationSC.setAppName(StringUtil.nullEmptyToValue(translationCO.getSysParamKeyLabelVO().getAPP_NAME(),
				sessionObject.getCurrentAppName()));
		    }
		    translationCO.getSysParamKeyLabelVO().setKEY_LABEL_CODE(translationSC.getKeyLabelCode());
		    if(!StringUtil.isNotEmpty(translationSC.getPageRef()))
		    {
			throw new BOException(getText("missing_elt_key") + " " + getText("prog_ref_key"));
		    }
		    Pattern pattern = Pattern.compile("[^0-9][^A-Z][\\w_]+");// Pattern no leading numbers, no Upper case all normal lower case without special characters except underscore
		    Matcher matcher = pattern.matcher(translationSC.getKeyLabelCode());
		    if(!matcher.matches())
		    {
			throw new BOException(MessageCodes.INVALID_MISSING, new String[] { translationSC.getKeyLabelCode() });
		    }
		    if(translationBO.checkKeyLabelCodeExist(translationSC) > 0)
		    {
			throw new BOException(MessageCodes.TRANS_DUPLICATE_KEY_INSERT, new String[] {translationSC.getKeyLabelCode()});
		    }
		}
		catch(Exception e)
		{
		    translationCO.getSysParamKeyLabelVO().setKEY_LABEL_CODE(null);
		    handleException(e, null, null);
		}
		return SUCCESS;
    }
    
    
    public TranslationSC getTranslationSC()
    {
	return translationSC;
    }

    public void setTranslationSC(TranslationSC translationSC)
    {
	this.translationSC = translationSC;
    }

    public OPTVO getOptVO()
    {
	return optVO;
    }

    public void setOptVO(OPTVO optVO)
    {
	this.optVO = optVO;
    }

    public TranslationCO getTranslationCO()
    {
	return translationCO;
    }

    public void setTranslationCO(TranslationCO translationCO)
    {
	this.translationCO = translationCO;
    }

    public void setTranslationBO(TranslationBO translationBO)
    {
	this.translationBO = translationBO;
    }

}
