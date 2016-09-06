package com.comp.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comp.todo.service.UserService;

/**
 * Handles HTTP requests for the different operations on users.
 * 
 * @author Vincent Montesclaros
 *
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

	/**
	 * Service containing methods and business logic for operations on users.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Returns all the users from the database.
	 * 
	 * @return the list of all users in the database.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Object getUsers() {
		return userService.listAll();
	}

}
