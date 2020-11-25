package com.path.bo.common.dynfiles;

import java.util.ArrayList;

public class DynFilesTags
{
    private String tagName;
    private String tagPath;
    private String tagValue;
    private int tagLevel;
    private ArrayList<DynFilesTagAttributes> dynFilesAttributes;
    private ArrayList<DynFilesTags> dynFilesTags;
    
    public String getTagName()
    {
        return tagName;
    }
    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }
    public String getTagPath()
    {
        return tagPath;
    }
    public void setTagPath(String tagPath)
    {
        this.tagPath = tagPath;
    }
    public String getTagValue()
    {
        return tagValue;
    }
    public void setTagValue(String tagValue)
    {
        this.tagValue = tagValue;
    }
    public int getTagLevel()
    {
        return tagLevel;
    }
    public void setTagLevel(int tagLevel)
    {
        this.tagLevel = tagLevel;
    }
    public ArrayList<DynFilesTagAttributes> getDynFilesAttributes()
    {
        return dynFilesAttributes;
    }
    public void setDynFilesAttributes(ArrayList<DynFilesTagAttributes> dynFilesAttributes)
    {
        this.dynFilesAttributes = dynFilesAttributes;
    }
    public ArrayList<DynFilesTags> getDynFilesTags()
    {
        return dynFilesTags;
    }
    public void setDynFilesTags(ArrayList<DynFilesTags> dynFilesTags)
    {
        this.dynFilesTags = dynFilesTags;
    }
}
