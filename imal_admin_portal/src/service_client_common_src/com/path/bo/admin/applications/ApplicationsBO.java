package com.path.bo.admin.applications;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.applications.ApplicationsSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: deniskhaddad
 *
 * ApplicationsBO.java used as interface for Applications needed Data
 */
public interface ApplicationsBO
{
    /**
     * 
     * Used for returning application List
     * 
     * @param applciationssSC
     * @return
     * @throws BaseException
     */
    public List returnAplicationList(ApplicationsSC applciationssSC) throws BaseException;
    /**
     * 
     * Used for returning Application Count
     * 
     * @param applciationssSC
     * @return
     * @throws BaseException
     */
    public int returnApplicationCount(ApplicationsSC applciationssSC) throws BaseException;
}
