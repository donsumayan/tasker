package com.comp.todo.service;

import java.util.List;

import com.comp.todo.model.Todo;

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
	 * Calls the data access object and tells it to delete all todos in the
	 * database.
	 * 
	 * @return the number of todo records deleted if successful.
	 */
	public Long deleteAllTodos();
}
