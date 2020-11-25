package com.path.vo.common.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.path.lib.common.util.StringUtil;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>GraphicalNode.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
@SuppressWarnings("serial")
public class GraphicalNode
{
    public static final String PATH_RECT_TYPE = "path.Rect";
    public static final String LINK_TYPE = "link";

    private static final String DEFAULT_FILL_COLOR = "#0281bb";
    private static final String DEFAULT_TEXT_COLOR = "white";
    private static final String DEFAULT_STROKE_COLOR = "white";
    private static final String DEFAULT_LINK_COLOR = "black";
    public static final String BG_IMAGE_PATTERN = "bgimage.pattern";
    
    private boolean loadPosition;

    private Integer angle = 0;
    private Integer width = 80;
    private Integer height = 60;
    private Integer strokeWidth = 2;
    private Integer rx = 12;
    private Integer ry = 12;
    private Integer posX;
    private Integer posY;

    private String id;
    private String type;

    private String linkSrcId;
    private String linkTargetId;
    private String linkLabel;
    private String parentId;
    private String fillColor;
    private String textKey;
    private String textColor;
    private String strokeColor;
    private String linkColor;

    private Map<String, Object> attrs;
    private Map<String, Integer> size;
    private Map<String, Integer> position;
    private Map<String, String> source;
    private Map<String, String> target;
    private List<Map<String, Object>> labels;

    private List<GraphicalNode> children;
    private Integer textDiplayLength = null;
    //customDetails that contain additional details added by Dev
    private String customDetails;
    
    private String urlPattern;
    private GraphicalVertice[] vertices;
    
    public GraphicalNode()
    {
	super();
    }

    /**
     * @param linkSrcId
     * @param linkTargetId
     */
    public GraphicalNode(String linkSrcId, String linkTargetId)
    {
	this.linkSrcId = linkSrcId;
	this.linkTargetId = linkTargetId;
	this.type = LINK_TYPE;
    }

    /**
     * @param id
     * @param type
     * @param fillColor
     * @param textKey
     * @param textColor
     * @param strokeColor
     */
    public GraphicalNode(String id, String parentId, String fillColor, String textKey, String textColor,
	    String strokeColor, String linkColor)
    {
	this.id = id;
	this.parentId = parentId;
	this.type = PATH_RECT_TYPE;
	this.fillColor = fillColor;
	this.textKey = textKey;
	this.textColor = textColor;
	this.strokeColor = strokeColor;
	this.linkColor = linkColor;
	this.children = new ArrayList<GraphicalNode>();
    }

    /**
     * Responsible of populating the graphical node
     */
    public void populateNode()
    {
	attrs = new HashMap<String, Object>();
	
	HashMap<String, String> hrefMap = new HashMap<String, String>();
	hrefMap.put("xlink:href", "#");
	attrs.put("a", hrefMap);

	HashMap<String, String> textMap = new HashMap<String, String>();
	textMap.put("text", textKey);
	if(textDiplayLength != null)
	{
	    textMap.put("textDiplayLength", String.valueOf(textDiplayLength));
	}
	textMap.put("fill", textColor == null ? DEFAULT_TEXT_COLOR : textColor);
	attrs.put("text", textMap);
	
	HashMap<String, Object> rectMap = new HashMap<String, Object>();
	if(StringUtil.isNotEmpty(urlPattern))
	{
	    rectMap.put("fill", "url(#" + urlPattern + ")");
	    urlPattern = null;
	}
	else
	{
	    rectMap.put("fill", fillColor == null ? DEFAULT_FILL_COLOR : fillColor);
	}
	rectMap.put("stroke", strokeColor == null ? DEFAULT_STROKE_COLOR : strokeColor);
	rectMap.put("stroke-width", strokeWidth);
	rectMap.put("rx", rx);
	rectMap.put("ry", ry);
	attrs.put("rect", rectMap);

	size = new HashMap<String, Integer>();
	size.put("width", width);
	size.put("height", height);

	if(loadPosition)
	{
	    position = new HashMap<String, Integer>();
	    position.put("x", posX);
	    position.put("y", posY);
	}
	
	//If the node have customDetails then add them to populated node
	if(StringUtil.isNotEmpty(customDetails))
	{
	    attrs.put("customDetails", customDetails);
	}
    }

    /**
     * Responsible of creating the link between the parent and the children
     * nodes
     */
    public void populateNodesLink()
    {
	attrs = new HashMap<String, Object>();
	HashMap<String, String> marketTarMap = new HashMap<String, String>();
	marketTarMap.put("d", "M 10 0 L 0 5 L 10 10 z");
	attrs.put(".marker-target", marketTarMap);
	
	HashMap<String, String> connMap = new HashMap<String, String>();
	connMap.put("stroke", linkColor == null ? DEFAULT_LINK_COLOR : linkColor);
	attrs.put(".connection", connMap);
	
	if(linkLabel != null && !linkLabel.isEmpty())
	{
	    labels = new ArrayList<Map<String,Object>>();
	    Map<String,Object> label = new HashMap<String, Object>();
	    label.put("position", 0.5);
	    Map<String, Object> labelAttr = new HashMap<String, Object>();
	    Map<String, Object> labelTextAttr = new HashMap<String, Object>();
	    labelTextAttr.put("text", linkLabel);
	    labelAttr.put("text", labelTextAttr);
	    labelTextAttr.put("font-family", "arial");
	    labelTextAttr.put("font-size", "11");
	    label.put("attrs", labelAttr);
	    labels.add(label);
	}
	
	source = new HashMap<String, String>();
	source.put("id", linkSrcId);

	target = new HashMap<String, String>();
	target.put("id", linkTargetId);
    }

    /**
     * @return the width
     */
    @JSON(serialize = false)
    public Integer getWidth()
    {
	return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(Integer width)
    {
	this.width = width;
    }

    /**
     * @return the height
     */
    @JSON(serialize = false)
    public Integer getHeight()
    {
	return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Integer height)
    {
	this.height = height;
    }

    /**
     * @return the strokeWidth
     */
    @JSON(serialize = false)
    public Integer getStrokeWidth()
    {
	return strokeWidth;
    }

    /**
     * @param strokeWidth the strokeWidth to set
     */
    public void setStrokeWidth(Integer strokeWidth)
    {
	this.strokeWidth = strokeWidth;
    }

    /**
     * @return the id
     */
    public String getId()
    {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id)
    {
	this.id = id;
    }

    /**
     * @return the parentId
     */
    public String getParentId()
    {
	return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(String parentId)
    {
	this.parentId = parentId;
    }

    /**
     * @return the type
     */
    public String getType()
    {
	return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
	this.type = type;
    }

    /**
     * @return the fillColor
     */
    @JSON(serialize = false)
    public String getFillColor()
    {
	return fillColor;
    }

    /**
     * @param fillColor the fillColor to set
     */
    public void setFillColor(String fillColor)
    {
	this.fillColor = fillColor;
    }

    /**
     * @return the rx
     */
    @JSON(serialize = false)
    public Integer getRx()
    {
	return rx;
    }

    /**
     * @param rx the rx to set
     */
    public void setRx(Integer rx)
    {
	this.rx = rx;
    }

    /**
     * @return the ry
     */
    @JSON(serialize = false)
    public Integer getRy()
    {
	return ry;
    }

    /**
     * @param ry the ry to set
     */
    public void setRy(Integer ry)
    {
	this.ry = ry;
    }

    /**
     * @return the textKey
     */
    @JSON(serialize = false)
    public String getTextKey()
    {
	return textKey;
    }

    /**
     * @param textKey the textKey to set
     */
    public void setTextKey(String textKey)
    {
	this.textKey = textKey;
    }

    /**
     * @return the textColor
     */
    @JSON(serialize = false)
    public String getTextColor()
    {
	return textColor;
    }

    /**
     * @param textColor the textColor to set
     */
    public void setTextColor(String textColor)
    {
	this.textColor = textColor;
    }

    /**
     * @return the strokeColor
     */
    @JSON(serialize = false)
    public String getStrokeColor()
    {
	return strokeColor;
    }

    /**
     * @param strokeColor the strokeColor to set
     */
    public void setStrokeColor(String strokeColor)
    {
	this.strokeColor = strokeColor;
    }

    /**
     * @return the attrs
     */
    public Map<String, Object> getAttrs()
    {
	return attrs;
    }

    /**
     * @param attrs the attrs to set
     */
    public void setAttrs(Map<String, Object> attrs)
    {
	this.attrs = attrs;
    }

    /**
     * /**
     * 
     * @return the size
     */
    public Map<String, Integer> getSize()
    {
	return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Map<String, Integer> size)
    {
	this.size = size;
    }

    /**
     * @return the angle
     */
    public Integer getAngle()
    {
	return angle;
    }

    /**
     * @param angle the angle to set
     */
    public void setAngle(Integer angle)
    {
	this.angle = angle;
    }

    /**
     * @return the children
     */
    @JSON(serialize = false)
    public List<GraphicalNode> getChildren()
    {
	return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<GraphicalNode> children)
    {
	this.children = children;
    }

    /**
     * @return the linkSrcId
     */
    @JSON(serialize = false)
    public String getLinkSrcId()
    {
	return linkSrcId;
    }

    /**
     * @param linkSrcId the linkSrcId to set
     */
    public void setLinkSrcId(String linkSrcId)
    {
	this.linkSrcId = linkSrcId;
    }

    /**
     * @return the linkTargetId
     */
    @JSON(serialize = false)
    public String getLinkTargetId()
    {
	return linkTargetId;
    }

    /**
     * @param linkTargetId the linkTargetId to set
     */
    public void setLinkTargetId(String linkTargetId)
    {
	this.linkTargetId = linkTargetId;
    }

    /**
     * @return the linkLabel
     */
    @JSON(serialize = false)
    public String getLinkLabel()
    {
        return linkLabel;
    }

    /**
     * @param linkLabel the linkLabel to set
    */
    public void setLinkLabel(String linkLabel)
    {
        this.linkLabel = linkLabel;
    }

    /**
     * @return the source
     */
    public Map<String, String> getSource()
    {
	return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(Map<String, String> source)
    {
	this.source = source;
    }

    /**
     * @return the target
     */
    public Map<String, String> getTarget()
    {
	return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(Map<String, String> target)
    {
	this.target = target;
    }

    /**
     * @return the linkColor
     */
    @JSON(serialize = false)
    public String getLinkColor()
    {
        return linkColor;
    }

    /**
     * @param linkColor the linkColor to set
     */
    public void setLinkColor(String linkColor)
    {
        this.linkColor = linkColor;
    }

    /**
     * @return the posX
     */
    @JSON(serialize = false)
    public Integer getPosX()
    {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(Integer posX)
    {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    @JSON(serialize = false)
    public Integer getPosY()
    {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(Integer posY)
    {
        this.posY = posY;
    }

    /**
     * @return the position
     */
    public Map<String, Integer> getPosition()
    {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Map<String, Integer> position)
    {
        this.position = position;
    }

    /**
     * @return the loadPosition
     */
    @JSON(serialize = false)
    public boolean isLoadPosition()
    {
        return loadPosition;
    }

    /**
     * @param loadPosition the loadPosition to set
     */
    public void setLoadPosition(boolean loadPosition)
    {
        this.loadPosition = loadPosition;
    }

    /**
     * @return the labels
     */
    public List<Map<String, Object>> getLabels()
    {
        return labels;
    }

    /**
     * @param labels the labels to set
     */
    public void setLabels(List<Map<String, Object>> labels)
    {
        this.labels = labels;
    }

    /**
     * @return the textDiplayLength
     */
    public Integer getTextDiplayLength()
    {
        return textDiplayLength;
    }

    /**
     * @param textDiplayLength the textDiplayLength to set
     */
    public void setTextDiplayLength(Integer textDiplayLength)
    {
        this.textDiplayLength = textDiplayLength;
    }

    public String getCustomDetails()
    {
        return customDetails;
    }

    public void setCustomDetails(String customDetails)
    {
        this.customDetails = customDetails;
    }

    /**
     * @return the urlPattern
     */
    public String getUrlPattern()
    {
        return urlPattern;
    }

    /**
     * @param urlPattern the urlPattern to set
     */
    public void setUrlPattern(String urlPattern)
    {
        this.urlPattern = urlPattern;
    }

    /**
     * @return the vertices
     */
    public GraphicalVertice[] getVertices()
    {
        return vertices;
    }

    /**
     * @param vertices the vertices to set
     */
    public void setVertices(GraphicalVertice[] vertices)
    {
        this.vertices = vertices;
    }

}
