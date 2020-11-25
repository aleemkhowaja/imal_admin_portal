package com.path.vo.common.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>GraphicalNodeCO.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
public class GraphicalNodeCO implements Serializable
{
    private Integer angle;
    private Integer width;
    private Integer height;
    private Integer strokeWidth;
    private Integer rx;
    private Integer ry;
    private String id;
    private String parentId;
    private String text;
    private String fillColor;
    private String textColor;
    private String strokeColor;
    private String linkColor;
    private String linkLabel;
    private Integer textDiplayLength;
    //customDetails that contain additional details added by Dev
    private String customDetails;
    private GraphicalPattern graphicalPattern;
    
    private List<GraphicalNodeCO> parentNodesList = new ArrayList<GraphicalNodeCO>();
    
    private Integer posX;
    private Integer posY;
    private String linkVertices;
    
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
     * @return the width
     */
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
     * @return the rx
     */
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
     * @return the text
     */
    public String getText()
    {
	return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text)
    {
	this.text = text;
    }

    /**
     * @return the fillColor
     */
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
     * @return the textColor
     */
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
     * @return the linkColor
     */
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
     * @return the linkLabel
     */
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
     * @return the parentNodesList
     */
    public List<GraphicalNodeCO> getParentNodesList()
    {
        return parentNodesList;
    }

    /**
     * @param parentNodesList the parentNodesList to set
     */
    public void setParentNodesList(List<GraphicalNodeCO> parentNodesList)
    {
        this.parentNodesList = parentNodesList;
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
     * @return the posX
     */
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
     * @return the graphicalPattern
     */
    public GraphicalPattern getGraphicalPattern()
    {
        return graphicalPattern;
    }

    /**
     * @param graphicalPattern the graphicalPattern to set
     */
    public void setGraphicalPattern(GraphicalPattern graphicalPattern)
    {
        this.graphicalPattern = graphicalPattern;
    }

    /**
     * @return the linkVertices
     */
    public String getLinkVertices()
    {
        return linkVertices;
    }

    /**
     * @param linkVertices the linkVertices to set
     */
    public void setLinkVertices(String linkVertices)
    {
        this.linkVertices = linkVertices;
    }


    
}
