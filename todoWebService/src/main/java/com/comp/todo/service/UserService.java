package com.comp.todo.service;

import com.comp.todo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Base interface for calling data access objects to perform CRUD operations on
 * users.
 * 
 * @author Vincent Montesclaros
 *
 */
public interface UserService extends BaseService<User, Long> {
	/**
	 * Calls the data access object and tells it to delete all users in the
	 * database.
	 * 
	 * @return the number of users records deleted if successful.
	 */
	public Long deleteAllUsers();

	/**
	 * Returns all the users in the database.
	 * 
	 * @return the list of all users from the database in JSON format.
	 * @throws JsonProcessingException
	 */
	public String getUsers() throws JsonProcessingException;

	/**
	 * Adds a user into the database.
	 * 
	 * @param user
	 *            the user to be added.
	 * @return 1 if the operation is successful.
	 */
	public Long addUser(User user);
}
