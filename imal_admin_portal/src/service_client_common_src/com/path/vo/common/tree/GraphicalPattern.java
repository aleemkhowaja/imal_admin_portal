package com.path.vo.common.tree;

public class GraphicalPattern
{
    private String patternName;
    private String patternType;
    private String imageUrl;
    
    public GraphicalPattern(String patternName, String imageUrl)
    {
	super();
	this.patternName = patternName;
	this.imageUrl = imageUrl;
    }
    
    public GraphicalPattern(String patternName, String patternType, String imageUrl)
    {
	super();
	this.patternName = patternName;
	this.patternType = patternType;
	this.imageUrl = imageUrl;
    }

    /**
     * @return the patternName
     */
    public String getPatternName()
    {
        return patternName;
    }
    /**
     * @param patternName the patternName to set
     */
    public void setPatternName(String patternName)
    {
        this.patternName = patternName;
    }
    /**
     * @return the imageUrl
     */
    public String getImageUrl()
    {
        return imageUrl;
    }
    /**
     * @param imageUrl the imageUrl to set
     */
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }
    /**
     * @return the patternType
     */
    public String getPatternType()
    {
        return patternType;
    }
    /**
     * @param patternType the patternType to set
     */
    public void setPatternType(String patternType)
    {
        this.patternType = patternType;
    }
    
}
