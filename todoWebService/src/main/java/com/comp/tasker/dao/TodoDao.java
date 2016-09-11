package com.comp.tasker.dao;

import java.util.List;

import com.comp.tasker.model.Todo;

/**
 * Base interface for CRUD operations and common queries on todos.
 * 
 * @author Vincent Montesclaros
 *
 */
public interface TodoDao extends BaseDao<Todo, Long> {
	/**
	 * Retrieves the list of todos with the given user id.
	 * 
	 * @param userId
	 *            the id of the user whose todos are to be retrieved.
	 * @return the list of todos the specified user has.
	 */
	public List<Todo> findByUserId(Long userId);
}
