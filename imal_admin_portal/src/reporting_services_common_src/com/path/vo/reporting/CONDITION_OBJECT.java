package com.path.vo.reporting;

import java.io.Serializable;



public class CONDITION_OBJECT implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5024835389643195681L;

	/**
	 * This property corresponds to the place of CONDITION_OBJECT in the list of arguments referenced in SQL_OBJECT.
	 * Index value is the time of object creation in milliseconds. 
	 */
	private long index;
	
	/**
	 * The entity selected in the first lookup in 'Joins / Conditions / Having' zones.
	 */
	private	IRP_ENTITIESCO entity1;
	
	/**
	 * The field selected in the first lookup in 'Joins / Conditions / Having' zones.
	 */
	private	IRP_FIELDSCO field1;
	
	/**
	 * The entity selected in the second lookup in 'Joins / Having' zones.
	 */	
	private	IRP_ENTITIESCO entity2;
	
	/**
	 * The field selected in the second lookup in 'Joins / Having' zones.
	 */	
	private	IRP_FIELDSCO field2;
	
	/**
	 * The join selected in the DDL in 'Join' zone. 
	 */
	private	String join;

	/**
	 * The operator selected in the DDL in 'Conditions / Having' zones.
	 */
	private	String operator;

	/**
	 * The first argument selected in the DDL in 'Conditions / Having' zones.
	 */
	private	IRP_REP_ARGUMENTSCO argument1;

	/**
	 * The second argument selected in the DDL in 'Conditions / Having' zones.
	 */
	private	IRP_REP_ARGUMENTSCO argument2;

	/**
	 * value in case the argument in 'Conditions / Having' zones is not a predefined argument.
	 */
	private	String value;
	/**
	 * The left parenthesis selected in 'Conditions / Having' zones.
	 */
	private	String lparenthesis;
	
	/**
	 * The right parenthesis selected in 'Conditions / Having' zones.
	 */
	private	String rparenthesis;
	
	/**
	 * The value selected in conjunction DDL in 'Conditions / Having' zones.
	 * Value is either �and� or �or�.
	 */
	private	String conjunction;

	/**used to fill the translation of the conjunction**/
	private String conjunctionName;
	
	public String getConjunctionName() {
		return conjunctionName;
	}

	public void setConjunctionName(String conjunctionName) {
		this.conjunctionName = conjunctionName;
	}

	/**
	 * The operator name in 'Conditions / Having' zones.
	 */
	private String operatorName;
	
	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public IRP_ENTITIESCO getEntity1() {
		return entity1;
	}

	public void setEntity1(IRP_ENTITIESCO entity1) {
		this.entity1 = entity1;
	}

	public IRP_FIELDSCO getField1() {
		return field1;
	}

	public void setField1(IRP_FIELDSCO field1) {
		this.field1 = field1;
	}

	public IRP_ENTITIESCO getEntity2() {
		return entity2;
	}

	public void setEntity2(IRP_ENTITIESCO entity2) {
		this.entity2 = entity2;
	}

	public IRP_FIELDSCO getField2() {
		return field2;
	}

	public void setField2(IRP_FIELDSCO field2) {
		this.field2 = field2;
	}

	public String getJoin() {
		return join;
	}

	public void setJoin(String join) {
		this.join = join;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public IRP_REP_ARGUMENTSCO getArgument1() {
		return argument1;
	}

	public void setArgument1(IRP_REP_ARGUMENTSCO argument1) {
		this.argument1 = argument1;
	}

	public IRP_REP_ARGUMENTSCO getArgument2() {
		return argument2;
	}

	public void setArgument2(IRP_REP_ARGUMENTSCO argument2) {
		this.argument2 = argument2;
	}

	public String getLparenthesis() {
		return lparenthesis;
	}

	public void setLparenthesis(String lparenthesis) {
		this.lparenthesis = lparenthesis;
	}

	public String getRparenthesis() {
		return rparenthesis;
	}

	public void setRparenthesis(String rparenthesis) {
		this.rparenthesis = rparenthesis;
	}

	public String getConjunction() {
		return conjunction;
	}

	public void setConjunction(String conjunction) {
		this.conjunction = conjunction;
	}
}

