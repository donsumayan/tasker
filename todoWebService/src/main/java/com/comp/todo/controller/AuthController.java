package com.comp.todo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comp.todo.service.AuthService;

/**
 * Handles HTTP requests for the different operations on user authentication.
 * 
 * Just a basic and crude implementation of a login service.
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(@RequestBody Map<String, String> userCredentials) {
		String email = userCredentials.get("email");
		String password = userCredentials.get("password");

		return authService.login(email, password);
	}
}
