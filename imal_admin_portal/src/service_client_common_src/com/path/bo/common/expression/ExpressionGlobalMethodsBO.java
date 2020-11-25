package com.path.bo.common.expression;

public interface ExpressionGlobalMethodsBO
{
    /**
     * 
     * Used for calling Method
     * 
     * @param methodName method name to call as String 
     * @param parameters List of Parameter
     * @return
     * @throws Exception
     */
    public Object callGlobalMethod(String methodName, Object... parameters) throws Exception;
}
