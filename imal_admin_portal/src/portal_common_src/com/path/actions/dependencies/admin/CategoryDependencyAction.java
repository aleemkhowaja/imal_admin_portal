package com.path.actions.dependencies.admin;

import java.util.List;

import com.path.bo.admin.category.CategoryBO;
import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.OPT_CATEGORYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.admin.category.CategorySC;
import com.path.vo.common.SessionCO;

/**
 * 
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author GhenoieSaab
 * 
 * 
 *         CategoryDependencyAction.java used for all dependencies related to
 * 
 * 
 */
public class CategoryDependencyAction extends BaseAction
{

    private CategoryBO categoryBO;
    private CategorySC categorySC = new CategorySC();
    
    public String dependencyByCategory()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    categorySC.setCurrAppName(sessionCO.getCurrentAppName());
	    categorySC.setPreferredLanguage(sessionCO.getLanguage());
	    categorySC.setNbRec(-1);
	    List<OPT_CATEGORYVO> resultList = categoryBO.returnCategoryList(categorySC);
	    if(resultList == null || resultList.isEmpty() || resultList.size() > 1)
	    {
		categorySC.setCategId(null);
		throw new BOException(MessageCodes.INVALID_VALUE);
	    }
	    
	    categorySC.setCategDesc(resultList.get(0).getCATEG_DESC_ENG());
	}
	catch(BOException e)
	{
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCategory method of CategoryDependencyAction");
	    handleException(e, null, null);
	}
	NumberUtil.resetEmptyValues(categorySC);
	return SUCCESS;

    }

    /**
     * @param categoryBO the categoryBO to set
     */
    public void setCategoryBO(CategoryBO categoryBO)
    {
	this.categoryBO = categoryBO;
    }

    /**
     * @return the categorySC
     */
    public CategorySC getCategorySC()
    {
        return categorySC;
    }

    /**
     * @param categorySC the categorySC to set
     */
    public void setCategorySC(CategorySC categorySC)
    {
        this.categorySC = categorySC;
    }

    
}
