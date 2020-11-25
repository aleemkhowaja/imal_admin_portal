package com.path.bo.common.dynfiles;

import java.util.ArrayList;

public class DynFilesHighestTagLevel
{
    private int highestTagLevel = -1;
    private String sqlText;
    private String parentTagPath;
    private ArrayList<String> highestTagPaths;
    private ArrayList<DynFilesTagsList> dynFilesTagsList;
    private ArrayList<DynFilesSQLOccurences> dynFilesSQLOccurences;
    private ArrayList<String> sqlColumns;
    
    public int getHighestTagLevel()
    {
        return highestTagLevel;
    }
    public void setHighestTagLevel(int highestTagLevel)
    {
        this.highestTagLevel = highestTagLevel;
    }
    public String getSqlText()
    {
        return sqlText;
    }
    public void setSqlText(String sqlText)
    {
        this.sqlText = sqlText;
    }
    public String getParentTagPath()
    {
        return parentTagPath;
    }
    public void setParentTagPath(String parentTagPath)
    {
        this.parentTagPath = parentTagPath;
    }
    public ArrayList<String> getHighestTagPaths()
    {
        return highestTagPaths;
    }
    public void setHighestTagPaths(ArrayList<String> highestTagPaths)
    {
        this.highestTagPaths = highestTagPaths;
    }
    public ArrayList<DynFilesTagsList> getDynFilesTagsList()
    {
        return dynFilesTagsList;
    }
    public void setDynFilesTagsList(ArrayList<DynFilesTagsList> dynFilesTagsList)
    {
        this.dynFilesTagsList = dynFilesTagsList;
    }
    public ArrayList<DynFilesSQLOccurences> getDynFilesSQLOccurences()
    {
        return dynFilesSQLOccurences;
    }
    public void setDynFilesSQLOccurences(ArrayList<DynFilesSQLOccurences> dynFilesSQLOccurences)
    {
        this.dynFilesSQLOccurences = dynFilesSQLOccurences;
    }
    public ArrayList<String> getSqlColumns()
    {
        return sqlColumns;
    }
    public void setSqlColumns(ArrayList<String> sqlColumns)
    {
        this.sqlColumns = sqlColumns;
    }
}