package com.comp.tasker.constants;

/**
 * Contains the SQL constants used in the project.
 * 
 * @author Vincent Montesclaros
 *
 */
public final class SQLConstants {

	/**
	 * Default constructor method.
	 */
	private SQLConstants() {

	}

	/**
	 * SQL statement for retrieving current datetime in the database.
	 */
	public static final String SQL_SELECT_NOW = "SELECT NOW()";
}
