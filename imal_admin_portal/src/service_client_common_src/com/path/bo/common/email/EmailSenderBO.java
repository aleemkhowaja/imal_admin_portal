/**
 * 
 */
package com.path.bo.common.email;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.email.MailCO;
import com.path.vo.common.email.MailServerCO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * EmailSenderBO.java used to
 */
public interface EmailSenderBO
{
    public void sendEmail(MailCO mailCO) throws BaseException;
    public void sendEmail(List<MailCO> mailCOLst) throws BaseException;
    public void sendEmail(MailCO mailCO,MailServerCO mailServerCO) throws BaseException;
    public void sendEmail(List<MailCO> mailCOLst,MailServerCO mailServerCO) throws BaseException;
}
