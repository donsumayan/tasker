package com.comp.todo.dao;

import com.comp.todo.model.User;

/**
 * Base interface for CRUD operations and common queries on users.
 * 
 * @author Vincent Montesclaros
 *
 */
public interface UserDao extends BaseDao<User, Long> {
	/**
	 * Retrieves the user with the given email.
	 * 
	 * @param email
	 *            the email of the user to be retrieved.
	 * 
	 * @return the user with the given email.
	 */
	public User findByEmail(String email);

}
