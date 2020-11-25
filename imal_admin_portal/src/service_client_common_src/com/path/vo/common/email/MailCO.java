/**
 * 
 */
package com.path.vo.common.email;

import java.util.List;

import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * mailCO.java used to
 */
public class MailCO extends RetailBaseVO
{
   private String       subject;
   private StringBuffer bodyMail;
   private byte[]       attachements;
   private List<byte[]> attachmentList;
   private String[]     to;
   private String[]     cc;
   private String[]     bcc;
   private String       from;
   private String[]     filesNames;
   private String 	requestReceipt;
   private String       bodyDirection;
/**
 * @return the subject
 */
public String getSubject()
{
    return subject;
}
/**
 * @param subject the subject to set
 */
public void setSubject(String subject)
{
    this.subject = subject;
}
/**
 * @return the attachements
 */
public byte[] getAttachements()
{
    return attachements;
}
/**
 * @param attachements the attachements to set
 */
public void setAttachements(byte[] attachements)
{
    this.attachements = attachements;
}
/**
 * @return the to
 */
public String[] getTo()
{
    return to;
}
/**
 * @param to the to to set
 */
public void setTo(String... to)
{
    this.to = to;
}
/**
 * @return the cc
 */
public String[] getCc()
{
    return cc;
}
/**
 * @param cc the cc to set
 */
public void setCc(String... cc)
{
    this.cc = cc;
}
/**
 * @return the bcc
 */
public String[] getBcc()
{
    return bcc;
}
/**
 * @param bcc the bcc to set
 */
public void setBcc(String... bcc)
{
    this.bcc = bcc;
}
/**
 * @return the from
 */
public String getFrom()
{
    return from;
}
/**
 * @param from the from to set
 */
public void setFrom(String from)
{
    this.from = from;
}
/**
 * @return the bodyMail
 */
public StringBuffer getBodyMail()
{
    return bodyMail;
}
/**
 * @param bodyMail the bodyMail to set
 */
public void setBodyMail(StringBuffer bodyMail)
{
    this.bodyMail = bodyMail;
}
/**
 * @return the filesNames
 */
public String[] getFilesNames()
{
    return filesNames;
}
/**
 * @param filesNames the filesNames to set
 */
public void setFilesNames(String... filesNames)
{
    this.filesNames = filesNames;
}
/**
 * @return the attachmentList
 */
public List<byte[]> getAttachmentList()
{
    return attachmentList;
}
/**
 * @param attachmentList the attachmentList to set
 */
public void setAttachmentList(List<byte[]> attachmentList)
{
    this.attachmentList = attachmentList;
}
public String getRequestReceipt()
{
    return requestReceipt;
}
public void setRequestReceipt(String requestReceipt)
{
    this.requestReceipt = requestReceipt;
}
public String getBodyDirection()
{
    return bodyDirection;
}
public void setBodyDirection(String bodyDirection)
{
    this.bodyDirection = bodyDirection;
}
}
