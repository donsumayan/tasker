package com.comp.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comp.todo.model.Todo;
import com.comp.todo.model.User;
import com.comp.todo.service.TodoService;
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
	 * Service containing methods and business logic for operations on todos.
	 */
	@Autowired
	private TodoService todoService;

	/**
	 * Returns all the users from the database.
	 * 
	 * @return the list of all users in the database.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Object getUsers() {
		return userService.listAll();
	}

	/**
	 * Deletes all users in the database.
	 * 
	 * @return the number of user records deleted in the database.
	 */
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public Object deleteAllUsers() {
		return userService.deleteAllUsers();
	}

	/**
	 * Saves a user into the database.
	 * 
	 * @param user
	 *            the new user to be saved.
	 * @return 1 if the user is successfully saved.
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Object createUser(@RequestBody User user) {
		return userService.add(user);
	}

	/**
	 * Updates a user's details.
	 * 
	 * @param user
	 *            the updated user.
	 * @return 1 if the user is successfully updated.
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public Object updateUser(@RequestBody User user) {
		return userService.update(user);
	}

	/**
	 * Deletes a user with the given ID.
	 * 
	 * @param userId
	 *            the ID of the user to be deleted.
	 * @return 1 if the user with the given ID is successfully deleted.
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public Object deleteUser(@PathVariable Long userId) {
		return userService.removeById(userId);
	}

	/**
	 * Retrieves a user from the database.
	 * 
	 * @param userId
	 *            the ID of the user to be retrieved.
	 * @return the user or null if it does not exist.
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Object getUser(@PathVariable Long userId) {
		return userService.get(userId);
	}

	/**
	 * Returns all the user's todos from the database.
	 * 
	 * @return the list of all the user's todos in the database.
	 */
	@RequestMapping(value = "/{userId}/todos", method = RequestMethod.GET)
	public Object getAllUserTodos(@PathVariable Long userId) {
		return todoService.findByUserId(userId);
	}

	/**
	 * Saves a todo into the database.
	 * 
	 * @param todo
	 *            the new todo to be saved.
	 * @return 1 if the user is successfully saved.
	 */
	@RequestMapping(value = "/{userId}/todos", method = RequestMethod.POST)
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
	@RequestMapping(value = "/{userId}/todos", method = RequestMethod.PUT)
	public Object updateTodo(@RequestBody Todo todo) {
		return todoService.update(todo);
	}

	/**
	 * Retrieves a todo from the database.
	 * 
	 * @param todoId
	 *            the ID of the todo to be retrieved.
	 * @return the todo or null if it does not exist.
	 */
	@RequestMapping(value = "/{userId}/todos/{todoId}", method = RequestMethod.GET)
	public Object getTodo(@PathVariable Long todoId) {
		return todoService.get(todoId);
	}

	/**
	 * Deletes a todo with the given ID.
	 * 
	 * @param todoId
	 *            the ID of the todo to be deleted.
	 * @return 1 if the todo with the given ID is successfully deleted.
	 */
	@RequestMapping(value = "/{userId}/todos/{todoId}", method = RequestMethod.DELETE)
	public Object deleteTodo(@PathVariable Long todoId) {
		return todoService.removeById(todoId);
	}

}
