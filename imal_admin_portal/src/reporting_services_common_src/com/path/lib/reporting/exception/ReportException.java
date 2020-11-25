package com.path.lib.reporting.exception;

public class ReportException extends Exception
{
    private String message;
    private String[] params;
    private Integer errorCode;
    private Integer msgType;

    public String getMessage()
    {
	return message;
    }

    public void setMessage(String message)
    {
	this.message = message;
    }

    public String[] getParams()
    {
	return params;
    }

    public void setParams(String[] params)
    {
	this.params = params;
    }

    public Integer getErrorCode()
    {
	return errorCode;
    }

    public void setErrorCode(Integer errorCode)
    {
	this.errorCode = errorCode;
    }

    public Integer getMsgType()
    {
	return msgType;
    }

    public void setMsgType(Integer msgType)
    {
	this.msgType = msgType;
    }
}
