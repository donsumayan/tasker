package com.comp.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comp.todo.service.TodoService;

/**
 * Handles HTTP requests for the different operations on todos.
 * 
 * @author Vincent Montesclaros
 *
 */
@RestController
@RequestMapping(value = "/todos")
public class TodoController {

	/**
	 * Service containing methods and business logic for operations on todos.
	 */
	@Autowired
	private TodoService todoService;

	/**
	 * Returns all the todos from the database.
	 * 
	 * @return the list of all todos in the database.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Object getTodos() {
		return todoService.listAll();
	}
}
