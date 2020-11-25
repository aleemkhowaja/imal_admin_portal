package com.path.vo.reporting;

import java.util.LinkedHashMap;

import com.path.bo.reporting.ReportingConstantsCommon;
import com.path.dbmaps.vo.IRP_ENTITIESVO;

public class IRP_ENTITIESCO extends IRP_ENTITIESVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6512342674886258784L;
	
	/**
	 * This property corresponds to the place of IRP_ENTITIESCO in the list of entities referenced in SQL_OBJECT 
	 */
	private Long index; //get time in ms
	private LinkedHashMap <Long,IRP_FIELDSCO>  selectedFields=new LinkedHashMap();
	
	/**
	 * The type of entity.
	 * simple entity => type = 1
	 * based on a subquery => type = 2
	 */
	private	String type;	

	/**
	 * The sql of the entity that is based on a subquery.
	 * It is null for simple entity.
	 */
	private	SQL_OBJECT sql;
	
	//to fill the alias generated in background of each entity
	private String syntaxAlias;
	
	//to display the entity alias concatenated with the nb. times selected
	private String entityAliasWithCount;
	
	public String getEntityAliasWithCount() {
		return entityAliasWithCount;
	}

	public void setEntityAliasWithCount(String entityAliasWithCount) {
		this.entityAliasWithCount = entityAliasWithCount;
	}

	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
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

	public LinkedHashMap<Long, IRP_FIELDSCO> getSelectedFields() {
		return selectedFields;
	}

	public void setSelectedFields(LinkedHashMap<Long, IRP_FIELDSCO> selectedFields) {
		this.selectedFields = selectedFields;
	}

	public String getSyntaxAlias() {
		return syntaxAlias;
	}

	public void setSyntaxAlias(String syntaxAlias) {
		this.syntaxAlias = syntaxAlias;
	}

	static Object lock = new Object();
	 public static int getSequenceNextVal() 
	  {
	     synchronized(lock)
	     {
		  if(ReportingConstantsCommon.entitySequence ==10000)
		  {
		      ReportingConstantsCommon.entitySequence=1;
		      return  ReportingConstantsCommon.entitySequence;
		  }
		  else
		  {
		      	ReportingConstantsCommon.entitySequence++;
			return  ReportingConstantsCommon.entitySequence;
		  } 
	     }
		  
	  }

}
