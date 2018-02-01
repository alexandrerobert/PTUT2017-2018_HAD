package com.mycompany.mavenwebapphadbpm;

/**
 * This class will store the data properties, its value and type for an individual
 * @author lexr
 *
 */
public class Info {
	/**
	 * Name of the relation
	 */
	String relation; 
	/**
	 * The value of the relation
	 */
	String value; 
	/**
	 * Type of the value
	 */
	String type;
	/**
	 * Create information about a data property
	 * @param rel The name of the property
	 * @param val The value of the property
	 * @param type The type of the property
	 */
	public Info(String rel, String val, String type) {
		relation = rel;
		value = val;
		this.type = type;
	}
	
	/**
	 * @return the name of the property
	 */
	public String getRelation() {
		return this.relation;
	}
	
	/**
	 * @return The value of the property
	 */
	public String getValue() {
		return this.value;
	}
	
	/**
	 * @return The type of the property
	 */
	public String getType() {
		return this.type;
	}
}