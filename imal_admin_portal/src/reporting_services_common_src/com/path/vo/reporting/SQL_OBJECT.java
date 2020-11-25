package com.path.vo.reporting;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

public class SQL_OBJECT implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 837729638243168754L;
	
	private String QUERY_NAME;
	/**
	 * List of entities selected in �New Query� zone to be involved in the sql.
	 */
	private	LinkedHashMap<Long,IRP_ENTITIESCO> entities = new LinkedHashMap(); //<IRP_ENTITIESCO> 
	
	/**
	 * List of fields selected in �New Query� zone.
	 */
	private	LinkedHashMap<Long,IRP_FIELDSCO> fields=new LinkedHashMap<Long, IRP_FIELDSCO>();
	
	/**
	 * List of fields created in 'Expressions' zone.
	 */
	private	LinkedHashMap<Long ,IRP_FIELDSCO> expressionFields=new LinkedHashMap<Long, IRP_FIELDSCO>();
	
	/**
	 * List of fields created in �Aggregate Fields� zone.
	 */
	private	LinkedHashMap<Long,IRP_FIELDSCO> aggregateFields=new LinkedHashMap<Long, IRP_FIELDSCO>();
	
	/**
	 * List of arguments created in �Arguments� zone.
	 */
	private	LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> argumentsList = new LinkedHashMap<Long, IRP_REP_ARGUMENTSCO>();

	/**
	 * List of conditions created in 'Join Entities' zone.
	 */
	private	LinkedHashMap<Long,CONDITION_OBJECT> joinsList = new LinkedHashMap<Long, CONDITION_OBJECT>();
	
	/**
	 * List of conditions created in 'Conditions' zone.
	 */
	private	LinkedHashMap<Long,CONDITION_OBJECT> conditionsList= new LinkedHashMap<Long, CONDITION_OBJECT>();
	
	/**
	 * List of conditions created in 'Having' zone.
	 */
	private	LinkedHashMap<Long,CONDITION_OBJECT> havingList = new LinkedHashMap<Long, CONDITION_OBJECT>();

	/**
	 * List of fields selected in 'choose fields' zone .
	 */
	private	LinkedHashMap<Long,IRP_FIELDSCO> displayFields=new LinkedHashMap<Long, IRP_FIELDSCO>();
	
	/**
	 * HashMap containing the fields used to group the report.
	 */
	private	LinkedHashMap<Long,IRP_FIELDSCO> groupByHM = new LinkedHashMap<Long, IRP_FIELDSCO>();
	
	/**
	 * The layout of query output: Tabular or free form
	 */
	private String outputLayout;
	
	private StringBuffer sqbSyntax;
	
	private Date DATE_UPDATED;
	
	private String isQryArg;
	
	private BigDecimal CONN_ID;
	
	public BigDecimal getCONN_ID() {
        return CONN_ID;
    }

    public void setCONN_ID(BigDecimal CONN_ID) {
        this.CONN_ID = CONN_ID;
    }
	
	public String getIsQryArg()
	{
	    return isQryArg;
	}

	public void setIsQryArg(String isQryArg)
	{
	    this.isQryArg = isQryArg;
	}

	public Date getDATE_UPDATED() {
		return DATE_UPDATED;
	}

	public void setDATE_UPDATED(Date dATEUPDATED) {
		DATE_UPDATED = dATEUPDATED;
	}

	public StringBuffer getSqbSyntax() {
		return sqbSyntax;
	}

	public void setSqbSyntax(StringBuffer sqbSyntax) {
		this.sqbSyntax = sqbSyntax;
	}

	public LinkedHashMap<Long, IRP_FIELDSCO> getDisplayFields() {
		return displayFields;
	}

	public void setDisplayFields(LinkedHashMap<Long, IRP_FIELDSCO> displayFields) {
		this.displayFields = displayFields;
	}

	public LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> getArgumentsList() {
		return argumentsList;
	}

	public void setArgumentsList(LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> argumentsList) {
		this.argumentsList = argumentsList;
	}
	
	public LinkedHashMap<Long, IRP_ENTITIESCO> getEntities() {
		return entities;
	}

	public void setEntities(LinkedHashMap<Long, IRP_ENTITIESCO> entities) {
		this.entities = entities;
	}

	public LinkedHashMap<Long, IRP_FIELDSCO> getFields() {
		return fields;
	}

	public void setFields(LinkedHashMap<Long, IRP_FIELDSCO> fields) {
		this.fields = fields;
	}

	public LinkedHashMap<Long, IRP_FIELDSCO> getExpressionFields() {
		return expressionFields;
	}

	public void setExpressionFields(
			LinkedHashMap<Long, IRP_FIELDSCO> expressionFields) {
		this.expressionFields = expressionFields;
	}

	
	public LinkedHashMap<Long, IRP_FIELDSCO> getAggregateFields() {
		return aggregateFields;
	}

	public void setAggregateFields(LinkedHashMap<Long, IRP_FIELDSCO> aggregateFields) {
		this.aggregateFields = aggregateFields;
	}

	public LinkedHashMap<Long, CONDITION_OBJECT> getJoinsList() {
		return joinsList;
	}

	public void setJoinsList(LinkedHashMap<Long, CONDITION_OBJECT> joinsList) {
		this.joinsList = joinsList;
	}

	public LinkedHashMap<Long, CONDITION_OBJECT> getConditionsList() {
		return conditionsList;
	}

	public void setConditionsList(LinkedHashMap<Long,CONDITION_OBJECT> conditionsList) {
		this.conditionsList = conditionsList;
	}

	public LinkedHashMap<Long,CONDITION_OBJECT> getHavingList() {
		return havingList;
	}

	public void setHavingList(LinkedHashMap<Long,CONDITION_OBJECT> havingList) {
		this.havingList = havingList;
	}

	public String getQUERY_NAME() {
		return QUERY_NAME;
	}

	public void setQUERY_NAME(String qUERYNAME) {
		QUERY_NAME = qUERYNAME;
	}
	
	public String getOutputLayout() {
		return outputLayout;
	}

	public void setOutputLayout(String outputLayout) {
		this.outputLayout = outputLayout;
	}

	public LinkedHashMap<Long, IRP_FIELDSCO> getGroupByHM() {
		return groupByHM;
	}

	public void setGroupByHM(LinkedHashMap<Long, IRP_FIELDSCO> groupByHM) {
		this.groupByHM = groupByHM;
	}

	public ArrayList<IRP_FIELDSCO> getAllFields(){
		ArrayList<IRP_FIELDSCO> allFields = new ArrayList<IRP_FIELDSCO>();
		allFields.addAll(this.fields.values());
		allFields.addAll(this.expressionFields.values());
		allFields.addAll(this.aggregateFields.values());
		return allFields;		
	}
	
	public ArrayList<CONDITION_OBJECT> getAllConditions(){
		ArrayList<CONDITION_OBJECT> allConditions = new ArrayList<CONDITION_OBJECT>();
		if(this.conditionsList != null)
		{
			allConditions.addAll(this.conditionsList.values());
		}
		if(this.havingList != null)
		{
			allConditions.addAll(this.havingList.values());
		}
		return allConditions;		
	}
	
}
