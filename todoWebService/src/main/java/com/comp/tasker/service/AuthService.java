package com.comp.tasker.service;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Base interface for performing authorization and authentication operations for
 * users.
 * 
 * @author Vincent Montesclaros
 *
 */
public interface AuthService {

	/**
	 * Verifies and authorizes a user based on the given credentials.
	 * 
	 * @param email
	 *            the email of the user.
	 * @param password
	 *            the password of the user.
	 * @return the user's info (including role) in JSON format.
	 * @throws JsonProcessingException
	 */
	public String login(String email, String password);

}
