package com.comp.todo.constants;

/**
 * Contains the constants used in the project.
 * 
 * @author Vincent Montesclaros
 *
 */
public final class Constants {

	/**
	 * Default constructor method.
	 */
	private Constants() {

	}

	/**
	 * Refers to the value for the role "Admin" in the database.
	 */
	public static final String ADMIN = "Admin";

	/**
	 * Refers to the value for the role "Admin" to be used in Spring Security.
	 */
	public static final String ROLE_ADMIN = "ROLE_ADMIN";

	/**
	 * Refers to the value for the role "User" in the database.
	 */
	public static final String USER = "User";

	/**
	 * Refers to the value for the role "User" to be used in Spring Security.
	 */
	public static final String ROLE_USER = "ROLE_USER";

	/**
	 * Message to be returned if user does not exist in the database.
	 */
	public static final String AUTH_USER_NOT_FOUND = "User not found.";

}
