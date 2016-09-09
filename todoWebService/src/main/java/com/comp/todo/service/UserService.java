package com.comp.todo.service;

import com.comp.todo.model.User;

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
}
