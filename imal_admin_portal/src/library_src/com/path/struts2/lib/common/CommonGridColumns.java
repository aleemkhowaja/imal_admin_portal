package com.path.struts2.lib.common;


public class CommonGridColumns
{
	protected String align; // Defines the alignment of the cell in the Body
	// layer, not in header cell. Possible values: left,
	// center, right., Default 'left'}
	protected String cssClass; // The css class to use for element
	protected String cssErrorClass; // The css error class to use for element
	protected String cssErrorStyle; // The css error style definitions for
	// element to use
	protected String cssStyle; // The css style definitions for element to use
	protected String dataType; // Type of the result. e.g. html, xml, text,
	// json, ...
	protected String defval; // The default value for the search field. This
	// option is used only in Custom Searching and
	// will be set as initial search.
	protected String disabled; // Set the html disabled attribute on rendered
	// html element
	protected String editable; // Defines if the field is editable
	protected String editoptions; // Array of allowed options (attributes) for
	// edittype option
	protected String editrules; // sets additional rules for the editable field.
	// e.g {number:true, required: true,
	// minValue:10, maxValue:100}
	protected String edittype; // Defines the edit type for inline and form
	// editing Possible values: text, textarea,
	// select, checkbox, password, button, image and
	// file
	protected String effect; // Perform a effect on the elements specified in
	// the 'targets' attribute. e.g. bounce,
	// highlight, pulsate, shake, size or transfer
	protected String effectDuration; // Duration of effect in milliseconds. Only
	// valid if 'effect' attribute is set
	protected String effectMode; // The Effect Mode. show, hide, toggle, none
	protected String effectOptions; // jQuery options for effect, eg 'color :
	// #aaaaaa' for the highlight effect or
	// 'times : 3' for the bounce effect. Only
	// valid if 'effect' attribute is set
	protected String errorElementId; // This should provide the id of the
	// element into which the error text
	// will be placed when an error ocurrs
	// loading the container. If 'errorTest'
	// is provided, that wil be used,
	// otherwise the ajax error message text
	// wil be used
	protected String errorText; // The text to be displayed on load error. If
	// 'errorElement' is provided, this will display
	// the error in the elemtn (if existing), if
	// not, it will display the error as the
	// contents of this container
	protected String formIds; // Comma delimited list of form ids for which to
	// serialize all fields during submission when
	// this element is clicked (if multiple forms
	// have overlapping element names, it is
	// indeterminate which will be used)
	protected String formatoptions; // Format options can be defined for
	// particular columns, overwriting the
	// defaults from the language file
	protected String href; // The url to be use when this element is clicked
	protected String id; // HTML id attribute
	protected String indicator; // If loading content into a target, Id of
								// element that will be displayed during loading
								// and hidden afterwards (will override settings
								// for the target container)
	protected String label; // Label expression used for rendering an element
							// specific label
	protected String name; // Set the unique name in the grid for the column.
							// This property is required. As well as other words
							// used as property/event names, the reserved words
							// (which cannot be used for names) include subgrid,
							// cb and rn
	protected String title;// Column title
	protected String index; // Set the index name when sorting. Passed as sidx
							// parameter
	protected String width;// Set the initial width of the column, in pixels
	protected String formatter; // The predefined types (string) or custom
								// function name that controls the format of
								// this field. e.g.: integer, currency, date,
								// checkbox
	protected String sortable; // defines is this can be sorted
	protected String resizable;// Defines if the column can be re sized
	protected String key; // In case if there is no id from server, this can be
							// set as as id for the unique row id. Only one
							// column can have this property. If there are more
							// than one key the grid finds the first one and the
							// second is ignored
	protected String search; // When used in search modules, disables or enables
								// searching on that column
	protected String searchoptions; // Defines the search options used
									// searching. e.g.
									// {sopt:['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']}
	protected String hidden; // Defines if this column is hidden at
								// initialization
	protected String hidedlg; // If set to true this column will not appear in
								// the modal dialog where users can choose which
								// columns to show or hide
	protected String formoptions; // Defines various options for form editing.
									// e.g. { label:'My Label', elmprefix:'(*)',
									// rowpos:1, colpos:2 }
	protected String surl; // Valid only in Custom Searching and edittype :
							// 'select' and describes the url from where we can
							// get already-constructed select element
	public String getAlign()
	{
		return align;
	}
	public void setAlign(String align)
	{
		this.align = align;
	}
	public String getCssClass()
	{
		return cssClass;
	}
	public void setCssClass(String cssClass)
	{
		this.cssClass = cssClass;
	}
	public String getCssErrorClass()
	{
		return cssErrorClass;
	}
	public void setCssErrorClass(String cssErrorClass)
	{
		this.cssErrorClass = cssErrorClass;
	}
	public String getCssErrorStyle()
	{
		return cssErrorStyle;
	}
	public void setCssErrorStyle(String cssErrorStyle)
	{
		this.cssErrorStyle = cssErrorStyle;
	}
	public String getCssStyle()
	{
		return cssStyle;
	}
	public void setCssStyle(String cssStyle)
	{
		this.cssStyle = cssStyle;
	}
	public String getDataType()
	{
		return dataType;
	}
	public void setDataType(String dataType)
	{
		this.dataType = dataType;
	}
	public String getDefval()
	{
		return defval;
	}
	public void setDefval(String defval)
	{
		this.defval = defval;
	}
	public String getDisabled()
	{
		return disabled;
	}
	public void setDisabled(String disabled)
	{
		this.disabled = disabled;
	}
	public String getEditable()
	{
		return editable;
	}
	public void setEditable(String editable)
	{
		this.editable = editable;
	}
	public String getEditoptions()
	{
		return editoptions;
	}
	public void setEditoptions(String editoptions)
	{
		this.editoptions = editoptions;
	}
	public String getEditrules()
	{
		return editrules;
	}
	public void setEditrules(String editrules)
	{
		this.editrules = editrules;
	}
	public String getEdittype()
	{
		return edittype;
	}
	public void setEdittype(String edittype)
	{
		this.edittype = edittype;
	}
	public String getEffect()
	{
		return effect;
	}
	public void setEffect(String effect)
	{
		this.effect = effect;
	}
	public String getEffectDuration()
	{
		return effectDuration;
	}
	public void setEffectDuration(String effectDuration)
	{
		this.effectDuration = effectDuration;
	}
	public String getEffectMode()
	{
		return effectMode;
	}
	public void setEffectMode(String effectMode)
	{
		this.effectMode = effectMode;
	}
	public String getEffectOptions()
	{
		return effectOptions;
	}
	public void setEffectOptions(String effectOptions)
	{
		this.effectOptions = effectOptions;
	}
	public String getErrorElementId()
	{
		return errorElementId;
	}
	public void setErrorElementId(String errorElementId)
	{
		this.errorElementId = errorElementId;
	}
	public String getErrorText()
	{
		return errorText;
	}
	public void setErrorText(String errorText)
	{
		this.errorText = errorText;
	}
	public String getFormIds()
	{
		return formIds;
	}
	public void setFormIds(String formIds)
	{
		this.formIds = formIds;
	}
	public String getFormatoptions()
	{
		return formatoptions;
	}
	public void setFormatoptions(String formatoptions)
	{
		this.formatoptions = formatoptions;
	}
	public String getHref()
	{
		return href;
	}
	public void setHref(String href)
	{
		this.href = href;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getIndicator()
	{
		return indicator;
	}
	public void setIndicator(String indicator)
	{
		this.indicator = indicator;
	}
	public String getLabel()
	{
		return label;
	}
	public void setLabel(String label)
	{
		this.label = label;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getIndex()
	{
		return index;
	}
	public void setIndex(String index)
	{
		this.index = index;
	}
	public String getWidth()
	{
		return width;
	}
	public void setWidth(String width)
	{
		this.width = width;
	}
	public String getFormatter()
	{
		return formatter;
	}
	public void setFormatter(String formatter)
	{
		this.formatter = formatter;
	}
	public String getSortable()
	{
		return sortable;
	}
	public void setSortable(String sortable)
	{
		this.sortable = sortable;
	}
	public String getResizable()
	{
		return resizable;
	}
	public void setResizable(String resizable)
	{
		this.resizable = resizable;
	}
	public String getKey()
	{
		return key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
	public String getSearch()
	{
		return search;
	}
	public void setSearch(String search)
	{
		this.search = search;
	}
	public String getSearchoptions()
	{
		return searchoptions;
	}
	public void setSearchoptions(String searchoptions)
	{
		this.searchoptions = searchoptions;
	}
	public String getHidden()
	{
		return hidden;
	}
	public void setHidden(String hidden)
	{
		this.hidden = hidden;
	}
	public String getHidedlg()
	{
		return hidedlg;
	}
	public void setHidedlg(String hidedlg)
	{
		this.hidedlg = hidedlg;
	}
	public String getFormoptions()
	{
		return formoptions;
	}
	public void setFormoptions(String formoptions)
	{
		this.formoptions = formoptions;
	}
	public String getSurl()
	{
		return surl;
	}
	public void setSurl(String surl)
	{
		this.surl = surl;
	}

}
