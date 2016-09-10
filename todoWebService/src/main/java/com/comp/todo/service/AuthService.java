package com.comp.todo.service;

import com.comp.todo.model.User;

/**
 * Base interface for performing authorization and authentication operations for
 * users.
 * 
 * @author Vincent Montesclaros
 *
 */
public interface AuthService {

	public User login(String email, String password);

}
