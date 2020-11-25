package com.path.actions.admin.dynamicparams;

import java.util.ArrayList;

import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.admin.dynamicparams.DynamicFormVO;
import com.path.vo.admin.dynamicparams.DynamicParamsVO;

/*
* Desciption
* DynamicParamsAction is the base action class for Dynamic-Params.
*
* @author Wissam Abou Jaoude
*
* Copyright 2010, Path Solutions
* Path Solutions retains all ownership rights to this source code 
*/
public class DynamicParamsAction extends BaseAction 
{
    DynamicFormVO formVO;
    
    public static final String TEXTFIELD_ELEMENT = "textfield";
    public static final String COMBO_ELEMENT = "comboBox";
    public static final String RADIO_ELEMENT = "radioButton";
    public static final String CHKBOX_ELEMENT = "checkBox";
    public static final String CHKBOX_LIST_ELEMENT = "checkBoxList";
    public static final String DATE_ELEMENT = "datePicker";
    public static final String TXTAREA_ELEMENT = "textArea";
    public static final String SUBMIT_ELEMENT = "submit";
    public static final String BUTTON_ELEMENT = "button";
    public static final String LIVESEARCH_ELEMENT = "livesearch";
    public static final String HIDDEN_ELEMENT = "hidden";
    public static final String LABEL_ELEMENT = "label";
    public static final String DIV_ELEMENT = "div";
    public static final String SUCCESS_DYNAMIC_PARAM = "SUCCESS_DYNAMIC_PARAM";
    public static final String SUCCESS_DYNAMIC_GRID = "SUCCESS_DYNAMIC_GRID";

    public static final String DT_NUMBER = "Number";
    public static final String DT_STRING = "String";
    public static final String DT_DATE = "Date";
    
    public static final String MODE_NUMBER = "number";

    /*
     * Responsible for doing the management of restructuring the dynamic params List according to row and column 
     */
    private void restructureList(ArrayList<DynamicParamsVO> lst)
    {
	orderRow(lst);
	orderColumn(lst);
    }

    /*
     *Responsible for ordering the dynamic params List according to their row value sequentially
     */
    private void orderRow(ArrayList<DynamicParamsVO> lst)
    {
	int smallestRow;
	for(int i = 0; i < lst.size() - 1; ++i)
	{
	    smallestRow = i;
	    for(int j = i + 1; j < lst.size(); ++j)
	    {
		if(lst.get(smallestRow).getRow() > lst.get(j).getRow())
		{
		    smallestRow = j;
		}
	    }
	    if(i != smallestRow)
	    {
		swap(lst, i, smallestRow);
	    }
	}
    }

    /*
     *Responsible for ordering the dynamic params List According to their Column value sequentially
     */
    private void orderColumn(ArrayList<DynamicParamsVO> lst)
    {
	int smallestColumn;
	for(int i = 0; i < lst.size() - 1; ++i)
	{
	    smallestColumn = i;
	    for(int j = i + 1; j < lst.size(); ++j)
	    {
		if(lst.get(i).getRow() != null && lst.get(i).getRow().equals(lst.get(j).getRow())
			&& lst.get(smallestColumn).getColumn() > lst.get(j).getColumn())
		{
			smallestColumn = j;
		}
	    }
	    if(i != smallestColumn)
	    {
		swap(lst, i, smallestColumn);
	    }
	}
    }

    /*
     * The following function will do the swap between two different indexes from the Dynamic params list.
     * This function is requested from orderRow and orderCiolumn
     */

    public void swap(ArrayList<DynamicParamsVO> lst, int index1, int index2)
    {
	DynamicParamsVO vo = lst.get(index1);
	lst.set(index1, lst.get(index2));
	lst.set(index2, vo);
    }


    public DynamicFormVO getFormVO()
    {
        return formVO;
    }

    public void setFormVO(DynamicFormVO formVO)
    {
        this.formVO = formVO;
    }

    /*
     * This function will be requested from the action that will extends DynamicParamsAction and will
     * be responsible for requesting the restructureList to order the rows and the columns.
     */
    public void fillFormElements(ArrayList lst, String action, String formId, String formTarget)
    {
	restructureList(lst);
	formVO = new DynamicFormVO();
	formVO.setElement_list(lst);
	formVO.setAction(action);
	formVO.setTarget(formTarget);
	if (!StringUtil.nullToEmpty(formId).isEmpty())
	{
	    formVO.setFormId(formId);
	}
    }
    
    /*
     * This function will be requested from the action that will extends DynamicParamsAction and will
     * be responsible for requesting the restructureList to order the rows and the columns. it will call the common
     * fillFormElements method and set the applyChangeTrack as additional parameter.
     */
    public void fillFormElements(ArrayList lst, String action, String formId, String formTarget, String applyChangeTrack)
    {
	fillFormElements(lst, action, formId, formTarget);
	formVO.setApplyChangeTrack(applyChangeTrack);
    }
    
    public void fillFormElements(ArrayList lst, String action, String formId, String formTarget, String applyChangeTrack, String onLoadScript)
    {
	fillFormElements(lst, action, formId, formTarget);
	if(!StringUtil.nullToEmpty(applyChangeTrack).isEmpty())
	{
	    formVO.setApplyChangeTrack(applyChangeTrack); 
	}
	if(!StringUtil.nullToEmpty(onLoadScript).isEmpty())
	{	    
	    formVO.setOnLoadScript(onLoadScript);
	}
    }
    /**
     * added to manage the absoluteElements
     * this argument is used to eliminate the table structure in case of dynamic absolute elements 
     * used for the screens that are generated from "create dynamic screen" section.
     * marwanmaddah
     */
    public void fillFormElements(ArrayList lst, String action, String formId, String formTarget, String applyChangeTrack, String onLoadScript, Boolean absoluteElements)
    {
	fillFormElements(lst, action, formId, formTarget);
	if(!StringUtil.nullToEmpty(applyChangeTrack).isEmpty())
	{
	    formVO.setApplyChangeTrack(applyChangeTrack); 
	}
	if(!StringUtil.nullToEmpty(onLoadScript).isEmpty())
	{	    
	    formVO.setOnLoadScript(onLoadScript);
	}
	if(Boolean.TRUE.equals(absoluteElements))
	{
	    formVO.setAbsoluteElements(ConstantsCommon.TRUE); 
	}
    }

}
