package com.path.vo.common.customization.css;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>ThemeCss.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
public class ThemeCss implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<ClassCss> classCss;

    /**
     * @return the classCss
     */
    public List<ClassCss> getClassCss()
    {
	return classCss;
    }

    /**
     * @param classCss the classCss to set
     */
    public void setClassCss(List<ClassCss> classCss)
    {
	this.classCss = classCss;
    }

}
