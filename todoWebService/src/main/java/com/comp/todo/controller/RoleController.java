package com.comp.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comp.todo.service.RoleService;

/**
 * Handles HTTP requests for the different operations on user roles.
 * 
 * @author Vincent Montesclaros
 *
 */
@RestController
@RequestMapping(value = "/roles")
public class RoleController {

	/**
	 * Service containing methods and business logic for operations on user
	 * roles.
	 */
	@Autowired
	private RoleService roleService;

	/**
	 * Returns all the user roles from the database.
	 * 
	 * @return the list of all user roles in the database.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Object getRoles() {
		return roleService.listAll();
	}
}
