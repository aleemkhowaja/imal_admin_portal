package com.path.vo.admin.dynamicparams;

import java.util.List;

import com.path.lib.vo.BaseVO;

public class DynamicFormVO extends BaseVO
{
    public String action;
    public String target;
    public String formId;
    public String applyChangeTrack;
    public String useHiddenProps;
    public String onLoadScript;
    public String absoluteElements;
    public List<DynamicParamsVO> element_list;
    public String tableCssStyle; 
    public String changeTrack;

    public DynamicFormVO()
    {
	target = "";
	formId = "formId";
    }
    
    public String getAction()
    {
	return action;
    }

    public void setAction(String action)
    {
	this.action = action;
    }

    public List<DynamicParamsVO> getElement_list()
    {
	return element_list;
    }

    public void setElement_list(List<DynamicParamsVO> elementList)
    {
	element_list = elementList;
    }

    public String getTarget()
    {
        return target;
    }

    public void setTarget(String target)
    {
        this.target = target;
    }

    public String getFormId()
    {
        return formId;
    }

    public void setFormId(String formId)
    {
        this.formId = formId;
    }

    public String getApplyChangeTrack()
    {
        return applyChangeTrack;
    }

    public void setApplyChangeTrack(String applyChangeTrack)
    {
        this.applyChangeTrack = applyChangeTrack;
    }

    public String getUseHiddenProps()
    {
        return useHiddenProps;
    }

    public void setUseHiddenProps(String useHiddenProps)
    {
        this.useHiddenProps = useHiddenProps;
    }

    /**
     * @return the onLoadScript
     */
    public String getOnLoadScript()
    {
        return onLoadScript;
    }

    /**
     * @param onLoadScript the onLoadScript to set
     */
    public void setOnLoadScript(String onLoadScript)
    {
        this.onLoadScript = onLoadScript;
    }

    public String getAbsoluteElements()
    {
        return absoluteElements;
    }

    public void setAbsoluteElements(String absoluteElements)
    {
        this.absoluteElements = absoluteElements;
    }

    public String getTableCssStyle()
    {
        return tableCssStyle;
    }

    public void setTableCssStyle(String tableCssStyle)
    {
        this.tableCssStyle = tableCssStyle;
    }
    
    /**
     * @return the changeTrack
     */
    public String getChangeTrack()
    {
        return changeTrack;
    }

    /**
     * @param changeTrack the changeTrack to set
     */
    public void setChangeTrack(String changeTrack)
    {
        this.changeTrack = changeTrack;
    }
}
