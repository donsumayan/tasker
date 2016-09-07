package com.comp.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comp.todo.model.Todo;
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
	 * Saves a todo into the database.
	 * 
	 * @param todo
	 *            the new todo to be saved.
	 * @return 1 if the user is successfully saved.
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Object createTodo(@RequestBody Todo todo) {
		return todoService.add(todo);
	}

	/**
	 * Updates a todo's details.
	 * 
	 * @param user
	 *            the updated todo.
	 * @return 1 if the todo is successfully updated.
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Object updateTodo(@RequestBody Todo todo) {
		return todoService.update(todo);
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

	/**
	 * Retrieves a todo from the database.
	 * 
	 * @param todoId
	 *            the ID of the todo to be retrieved.
	 * @return the todo or null if it does not exist.
	 */
	@RequestMapping(value = "/{todoId}", method = RequestMethod.GET)
	public Object getTodo(@PathVariable Long todoId) {
		return todoService.get(todoId);
	}
}
