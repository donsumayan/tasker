package com.comp.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	/**
	 * Deletes all todos in the database.
	 * 
	 * @return the number of todo records deleted in the database.
	 */
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public Object deleteAllTodos() {
		return todoService.deleteAllTodos();
	}

	/**
	 * Deletes a todo with the given ID.
	 * 
	 * @param todoId
	 *            the ID of the todo to be deleted.
	 * @return 1 if the todo with the given ID is successfully deleted.
	 */
	@RequestMapping(value = "/{todoId}", method = RequestMethod.DELETE)
	public Object deleteTodo(@PathVariable Long todoId) {
		return todoService.removeById(todoId);
	}

}
