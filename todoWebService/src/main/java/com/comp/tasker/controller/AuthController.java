package com.comp.tasker.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comp.tasker.service.AuthService;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Handles HTTP requests for the different operations on user authentication.
 * 
 * A basic and crude implementation of a login service.
 * 
 * @author Vincent Montesclaros
 *
 */
@RestController
@RequestMapping(value = "")
public class AuthController {

	/**
	 * Service containing methods and business logic for operations on users.
	 */
	@Autowired
	private AuthService authService;

	/**
	 * Returns the user's information and role if the given credentials are
	 * correct.
	 * 
	 * @param userCredentials
	 *            the map containing the email and password of the user to be
	 *            verified.
	 * @return the user's information and role.
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(@RequestBody Map<String, String> userCredentials) {
		String email = userCredentials.get("email");
		String password = userCredentials.get("password");

		return authService.login(email, password);
	}
}
