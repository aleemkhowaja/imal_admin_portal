package com.path.bo.common.customization.button;

import java.util.Map;

import com.path.lib.common.exception.BaseException;

public interface ButtonCustomizationRmiCallerBO
{
    public Map<String, Object> executeBoMethod(String boReference, String boMethod, Map<String, Object> inputMap) throws BaseException;
}
