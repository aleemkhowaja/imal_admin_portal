package com.path.bo.common.customization.file;

import java.io.FileNotFoundException;
import java.util.Map;

import com.path.lib.common.exception.BaseException;

/**
 * Hold all behaviors and functionalities related to the file customization
 * 
 * @author MohammadAliMezzawi
 */
public interface FileCustomizationBO
{

    /**
     * Store the given file into the given directory
     * 
     * @param fileInfo
     * @return The file path
     * @throws BaseException
     * @throws FileNotFoundException
     */
    public Map<String, Object> storeFile(Map<String, Object> fileInfo) throws BaseException;
}
