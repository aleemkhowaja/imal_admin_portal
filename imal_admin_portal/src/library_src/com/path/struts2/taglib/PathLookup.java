package com.path.struts2.taglib;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsException;

import com.jgeppert.struts2.jquery.components.Dialog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;

public class PathLookup extends Dialog
{// Dialog

    private String required;
    
    @Override
    public boolean start(Writer arg0)
    {
	//the additional code should exists before calling super.start()	
	
	SYS_PARAM_SCREEN_DISPLAYVO theVO = RootUtil.returnParamScreenDisplay(request, name, id);
	if(theVO != null)
	{
	    if(theVO.getIS_MANDATORY() != null)
	    {
		    if(theVO.getIS_MANDATORY().intValue() == 1)
		    {
			required = "true";
		    }
		    else
		    {
			required = "false";
		    }
	    }
	    if(theVO.getIS_READONLY() != null)
	    {
		    if(theVO.getIS_READONLY().intValue() == 1)
		    {
			readOnly = "true";
		    }
		    else
		    {
			readOnly = "false";
		    }
	    }
	    if(theVO.getIS_VISIBLE()!= null && theVO.getIS_VISIBLE().intValue() == 0)
	    {
		if(cssStyle == null || cssStyle.isEmpty())
		{
		    cssStyle = "";
		}
		else
		{
		    cssStyle += ";";
		}
		cssStyle += "display:none";
		addParameter("cssStyle", findString(cssStyle));
	    }
	    
	    if(!StringUtil.nullToEmpty(theVO.getLABEL_KEY()).isEmpty())
	    {
		BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
		overrideLabelText =  baseAction.getText(theVO.getLABEL_KEY());
		addParameter("overrideLabelText", findString(overrideLabelText));
		// LABEL_KEY is coming already translated in case of additionalScreensParams upon load of screen
		overrideLabelKey = theVO.getLabelKeyVal() != null ? theVO.getLabelKeyVal() : theVO.getLABEL_KEY();
		addParameter("overrideLabelKey", findString(overrideLabelKey));
	    }
	}
	
	if(onOk != null)
	{
		addParameter("onOk", findString(onOk));
	}
	if(onCancel != null)
	{
		addParameter("onCancel", findString(onCancel));
	}
	if(readOnly != null)
	{
		    addParameter("readOnly", findValue(readOnly, Boolean.class));
	}
	if(StringUtil.isNotEmpty(required))
	{
	    addParameter("required", findValue(required, Boolean.class));
	}
	
	//the super.start() should be called at the end of the method
	return super.start(arg0);
    }

    


    public static final String PATH_TEMPLATE = "pathlookup";
    public static final String PATH_THEME = "path-xhtml";

    /**
     * Unique Id of the lookup component.
     */
    private String id;
    /**
     * Specify the action name of Action Class(Implementer should define the
     * class) which needs to get invoked while clicking the lookup button of the
     * dialog.
     * 
     */

    private String actionName;
    /**
     * Using for where clause parameters (ColumnName:ComponentId) Column Name =
     * DbColumnName and ComponentId = Id of the component(ie, textfield,textarea
     * etc...)
     */

    private String paramList;
    /**
     * Using for setting the data (Once the record is selected in the grid and
     * clicks OK button of the lookup component) into corresponding components
     * like textfield,textarea,etc...(ColumnName:Component Id) Column Name = The
     * column name (column header) Component Id = The id of the component in
     * which the value get set.
     */
    private String resultList;
    /**
     * Name of the function which needs to call while clicking OK button of the
     * dialog (The implementer should write the function). If no functions
     * specified then the component will take the value of outputparam and fill
     * the content automatically
     */
    private String onOk;

    /**
     * Name of the function which needs to call while clicking CANCEL button of
     * the dialog (The implementer should write the function). If no functions
     * specified then the component will take the value of outputparam and fill
     * the content automatically
     */
    private String onCancel;

    private String autoOpen = "false";

    private String modal = "true";

    private String title;

    private String hideEffect = "scale";

    private String position = "center";

    private String width = "1100";

    private String height = "375";

    private String name;
    
    private String readOnly;
    
    private String overrideLabelText;
    
    private String overrideLabelKey;

    public PathLookup(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);

	// TODO Auto-generated constructor stub
    }

    @Override
    public boolean end(Writer writer, String body)
    {
	evaluateParams();

	try
	{
	    super.end(writer, body, false);
	    setTheme(PATH_THEME);
	    setTemplate(PATH_TEMPLATE);
	    mergeTemplate(writer, buildTemplateName(template, PATH_TEMPLATE));
	}
	catch(Exception e)
	{
	    throw new StrutsException(e);
	}
	finally
	{
	    popComponentStack();
	}

	return false;
    }

    /**
     * Sets the path theme
     */
    @Override
    public void setTheme(String theme)
    {
	super.setTheme(PATH_THEME);
    }

    /**
     * Get the path template
     */
    @Override
    protected String getDefaultTemplate()
    {
	return PATH_TEMPLATE;
    }

    /**
     * Get the id
     */
    @Override
    public String getId()
    {
	return id;
    }

    /**
     *Sets the id
     */
    @Override
    public void setId(String id)
    {
	this.id = id;
    }

    /**
     * Get the action name.
     * 
     * @return
     */
    public String getActionName()
    {
	return actionName;
    }

    /**
     * Set the action name
     * 
     * @param actionName
     */
    public void setActionName(String actionName)
    {
	this.actionName = actionName;
    }

    /**
     * Get the result list
     * 
     * @return
     */
    public String getResultList()
    {
	return resultList;
    }

    /**
     * Set the result list
     * 
     * @param resultlist
     */
    public void setResultList(String resultList)
    {
	this.resultList = resultList;
    }

    /**
     * Get the ok button value
     * 
     * @return
     */
    public String getOnOk()
    {
	return onOk;
    }

    /**
     * Set the ok button value
     * 
     * @param onok
     */
    public void setOnOk(String onOk)
    {
	this.onOk = onOk;
    }

    /**
     * get the cancel button value
     * 
     * @return
     */
    public String getOnCancel()
    {
	return onCancel;
    }

    /**
     * Set the cancel button value
     * 
     * @param oncancel
     */
    public void setOnCancel(String onCancel)
    {
	this.onCancel = onCancel;
    }

    /**
     * Get the auto open property
     * 
     * @return
     */
    public String getAutoOpen()
    {
	return autoOpen;
    }

    /**
     * Set the autoOpen property
     * 
     * @param autoOpen
     */
    @Override
    public void setAutoOpen(String autoOpen)
    {
	this.autoOpen = autoOpen;
    }

    /**
     * Get whether the lookup dialog is modal or not
     * 
     * @return
     */
    public String getModal()
    {
	return modal;
    }

    /**
     * Set the modal attribute
     * 
     * @param modal
     */
    @Override
    public void setModal(String modal)
    {
	this.modal = modal;
    }

    /**
     * Get the title of the lookup Dialog
     * 
     * @return
     */
    public String getTitle()
    {
	return title;
    }

    /**
     * Set the title of the lokkup dialog
     */
    @Override
    public void setTitle(String title)
    {
	this.title = title;
    }

    /**
     * Get the value of hide effect property
     * 
     * @return
     */
    public String getHideEffect()
    {
	return hideEffect;
    }

    /**
     * Set the hide effect property of lookup dialog
     * 
     * @param hideEffect
     */
    @Override
    public void setHideEffect(String hideEffect)
    {
	this.hideEffect = hideEffect;
    }

    /**
     * Get the position value of lookup dialog
     * 
     * @return
     */
    public String getPosition()
    {
	return position;
    }

    /**
     * Set the position of lookup dialog
     * 
     * @param position
     */
    @Override
    public void setPosition(String position)
    {
	this.position = position;
    }

    /**
     * Get the width of lookup dialog
     * 
     * @return
     */
    public String getWidth()
    {
	return width;
    }

    /**
     * Set the width of lookup dialog
     * 
     * @param width
     */
    @Override
    public void setWidth(String width)
    {
	this.width = width;
    }

    /**
     * Get the height of lookup dialog
     * 
     * @return
     */
    public String getHeight()
    {
	return height;
    }

    /**
     * Set the height of lookup dialog
     * 
     * @param height
     */
    @Override
    public void setHeight(String height)
    {
	this.height = height;
    }

    /**
     * Get the name of lookup dialog
     * 
     * @return
     */
    public String getName()
    {
	return name;
    }

    /**
     * Set the name of lookup Dialog
     */
    @Override
    public void setName(String name)
    {
	this.name = name;
    }

    /*
     * public static String getPathTemplate() { return PATH_TEMPLATE; } public
     * static String getPathTheme() { return PATH_THEME; }
     */
    /**
     * Get the param list
     * 
     * @return
     */
    public String getParamList()
    {
	return paramList;
    }

    /**
     * Set the param list
     * 
     * @param keylist
     */
    public void setParamList(String keyList)
    {
	this.paramList = keyList;
    }

    public String getReadOnly()
    {
        return readOnly;
    }

    public void setReadOnly(String readOnly)
    {
        this.readOnly = readOnly;
    }

    public String getOverrideLabelText()
    {
        return overrideLabelText;
    }

    public void setOverrideLabelText(String overrideLabelText)
    {
        this.overrideLabelText = overrideLabelText;
    }

    public String getOverrideLabelKey()
    {
        return overrideLabelKey;
    }

    public void setOverrideLabelKey(String overrideLabelKey)
    {
        this.overrideLabelKey = overrideLabelKey;
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
