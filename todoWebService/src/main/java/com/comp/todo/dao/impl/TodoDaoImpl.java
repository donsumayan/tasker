package com.comp.todo.dao.impl;

import org.springframework.stereotype.Repository;

import com.comp.todo.dao.TodoDao;
import com.comp.todo.model.Todo;

/**
 * Base implementation for common CRUD operations and queries on todos.
 * 
 * @author Vincent Montesclaros
 *
 */
@Repository
public class TodoDaoImpl extends BaseDaoImpl<Todo, Long> implements TodoDao {
	public TodoDaoImpl() {
		this(Todo.class);
	}

	protected TodoDaoImpl(Class<Todo> entityClass) {
		super(entityClass);
	}
}
