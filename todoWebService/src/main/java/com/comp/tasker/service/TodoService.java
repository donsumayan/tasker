package com.comp.tasker.service;

import java.util.List;
import java.util.Map;

import com.comp.tasker.model.Todo;

/**
 * Base interface for calling data access objects to perform CRUD operations on
 * todos.
 * 
 * @author Vincent Montesclaros
 *
 */
public interface TodoService extends BaseService<Todo, Long> {
	/**
	 * Calls the data access object and tells it to retrieve the list of todos
	 * with the given user id.
	 * 
	 * @param userId
	 *            the id of the user whose todos are to be retrieved.
	 * @return the list of todos the specified user has.
	 */
	public List<Todo> findByUserId(Long userId);

	/**
	 * Returns all the todos in the database.
	 * 
	 * @return all the todos in the database in JSON format.
	 */
	public String getAllTodos();

	/**
	 * Calls the data access object and tells it to delete all todos in the
	 * database.
	 * 
	 * @return the number of todo records deleted if successful.
	 */
	public Long deleteAllTodos();

	/**
	 * Creates a new todo based on the data inside the Map.
	 * 
	 * @param userId
	 *            the id of the user who owns the todo.
	 * @param noteDetails
	 *            map containing the details of the note to be saved.
	 * @return 1 if the todo was successfully created.
	 */
	public Long createTodo(Long userId, Map<String, String> noteDetails);

	/**
	 * Updates the existing todo in the database.
	 * 
	 * @param todo
	 *            the todo containing updated values for its fields.
	 * @return 1 if the todo was successfully updated.
	 */
	public Long updateTodo(Todo todo);

	/**
	 * Returns all todos in the database with the given user ID.
	 * 
	 * @param userId
	 *            the user ID of all the todos to be retrieved.
	 * @return the list of todos in JSON format.
	 */
	public String getTodosByUserId(Long userId);

	/**
	 * Returns the todo in the database with the given ID.
	 * 
	 * @param todoId
	 *            the ID of the todo to be retrieved.
	 * @return the todo in JSON format.
	 */
	public String getTodoById(Long todoId);
}
