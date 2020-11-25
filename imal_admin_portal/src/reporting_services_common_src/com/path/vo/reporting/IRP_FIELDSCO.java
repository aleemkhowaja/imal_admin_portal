package com.path.vo.reporting;

import com.path.bo.reporting.ReportingConstantsCommon;
import com.path.dbmaps.vo.IRP_FIELDSVO;

public class IRP_FIELDSCO extends IRP_FIELDSVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4664565345776996742L;
	
	
	/**
	 * This property corresponds to the place of IRP_FIELDSCO in the list of fields referenced in SQL_OBJECT 
	 */
	private Long index;
	
	/**
	 * This property corresponds to the database column IRP_ENTITIES.ENTITY_ALIAS
	 */
	private String ENTITY_ALIAS;
	
	/**
	 * This property corresponds to the alias entered by the user on UI
	 * when he creates expressions and aggregate fields. 
	 */
	private String labelAlias;
	
	/**
	 * This property corresponds to the field syntax.
	 * The query builder refers to this property to build the sql syntax that should
	 * run against db to retrieve the data.
	 */
	private String fieldSyntax;

	/**
	 * This property corresponds to the html rendered on UI to represent an expression.
	 */
	private String html;
	
	/**
	 * This property corresponds to the aggregate function (max, min, avg...) concatenated to the field alias
	 */
	private String aggregate;
	
	/**
	 * This property corresponds to the field order (asc, desc) if the sql is ordered by this field. 
	 */
	private String order;
	
	private Long PARENT_INDEX;
	
	/*properties added for grid tree*/
	private String level;
	private String parent;
	private String isLeaf;
	private String feName; // is used to fill the name that should be displayed in the 'choose fields' grid, it will be common for all fields
	//used to store the field id used inside the aggregate 
	private Long aggrFeId;
	
	/**
	 * The type of field.
	 * simple field involved in �select� => type = 1
	 * field based on an expression or on aggregate function and involved in �select� => type = 1
	 * field involved in �order by� => type = 1 
	 * field based on a subquery and involved in �select� => type = 2
	 */
	private	String type;

	/**
	 * The sql of the field that is based on a subquery
	 * It is null for other fields having type 1.
	 */
	private	SQL_OBJECT sql;

	//to display the entity alias concatenated with the nb. times selected
	private String entityAliasWithCount;
	
	/**
	 * The name of the group to which belongs the field when it is used to group the report.
	 */
	private String groupName;
	
	/**
	 * This takes 2 values : 1 , means the field is old, 0, means the field is new.
	 */
	private String oldField; //Mira 04-Jun-2012 Entities Screen
	
	private String javaFieldType;//get the type of a field from db and transform it to a java type
	
	private int hasBusinessName=1; // 1:if the field has business name or a description(when uploading from jrxml)  ; 0: field do not have desc.
	
	public int getHasBusinessName() {
		return hasBusinessName;
	}

	public void setHasBusinessName(int hasBusinessName) {
		this.hasBusinessName = hasBusinessName;
	}

	public String getEntityAliasWithCount() {
		return entityAliasWithCount;
	}

	public void setEntityAliasWithCount(String entityAliasWithCount) {
		this.entityAliasWithCount = entityAliasWithCount;
	}

	public String getAggregateAlias() {
		return aggregate + "(" + this.getFIELD_ALIAS() + ")";
	}


	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}

	public String getENTITY_ALIAS() {
		return ENTITY_ALIAS;
	}

	public void setENTITY_ALIAS(String eNTITYALIAS) {
		ENTITY_ALIAS = eNTITYALIAS;
	}

	public String getLabelAlias() {
		return labelAlias;
	}

	public void setLabelAlias(String labelAlias) {
		this.labelAlias = labelAlias;
	}

	public String getFieldSyntax() {
		return fieldSyntax;
	}

	public void setFieldSyntax(String fieldSyntax) {
		this.fieldSyntax = fieldSyntax;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getAggregate() {
		return aggregate;
	}

	public void setAggregate(String aggregate) {
		this.aggregate = aggregate;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SQL_OBJECT getSql() {
		return sql;
	}

	public void setSql(SQL_OBJECT sql) {
		this.sql = sql;
	}

	public Long getPARENT_INDEX() {
		return PARENT_INDEX;
	}

	public void setPARENT_INDEX(Long pARENTINDEX) {
		PARENT_INDEX = pARENTINDEX;
	}

	public Long getAggrFeId() {
		return aggrFeId;
	}

	public void setAggrFeId(Long aggrFeId) {
		this.aggrFeId = aggrFeId;
	}
	
	static Object lock = new Object();
	 public static int getSequenceNextVal() 
	  {
	     	synchronized(lock)
	     	{
	     	    if(ReportingConstantsCommon.fieldSequence ==10000)
	     	    {
	     		  ReportingConstantsCommon.fieldSequence=1;
			  return  ReportingConstantsCommon.fieldSequence;
	     	    }
	     	    else
	     	    {
	     		 ReportingConstantsCommon.fieldSequence++;
			 return  ReportingConstantsCommon.fieldSequence;
	     	    }
	     	}
		  
	  }

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getFeName() {
		return feName;
	}

	public void setFeName(String feName) {
		this.feName = feName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	//Mira 04-Jun-2012 Entities Screen
	public String getOldField()
	{
	    return oldField;
	}

	public void setOldField(String oldField)
	{
	    this.oldField = oldField;
	}
	//Mira END 04-Jun-2012
	
	public String retJavaFieldType()
	{
	    if(getFIELD_DATA_TYPE().equals("java.math.BigDecimal"))
	    {
		javaFieldType="NUMBER";
	    }
	    else if(getFIELD_DATA_TYPE().equals("java.util.Date"))
	    {
		javaFieldType="DATE";
	    }
	    else if(getFIELD_DATA_TYPE().equals("java.lang.String"))
	    {
		javaFieldType="VARCHAR2";
	    }
	    return javaFieldType;
	    
	}

}
