/**
 * 
 */
package com.path.vo.common.screengenerator;

import java.math.BigDecimal;
import com.path.lib.vo.BaseVO;

/**
 * @author marwanmaddah
 *
 */
public class LinkedElementsCO extends BaseVO
{
   private String id;
   private String name;
   private String expression;
   //TP#1070377
   private BigDecimal elemId;
   private String propertyCode;
   private BigDecimal elementType;
/**
 * @return the id
 */
public String getId()
{
    return id;
}
/**
 * @param id the id to set
 */
public void setId(String id)
{
    this.id = id;
}
/**
 * @return the expression
 */
public String getExpression()
{
    return expression;
}
/**
 * @param expression the expression to set
 */
public void setExpression(String expression)
{
    this.expression = expression;
}
/**
 * @return the name
 */
public String getName()
{
    return name;
}
/**
 * @param name the name to set
 */
public void setName(String name)
{
    this.name = name;
}
public BigDecimal getElemId()
{
    return elemId;
}
public void setElemId(BigDecimal elemId)
{
    this.elemId = elemId;
}
public String getPropertyCode()
{
    return propertyCode;
}
public void setPropertyCode(String propertyCode)
{
    this.propertyCode = propertyCode;
}
public BigDecimal getElementType()
{
    return elementType;
}
public void setElementType(BigDecimal elementType)
{
    this.elementType = elementType;
}
}
