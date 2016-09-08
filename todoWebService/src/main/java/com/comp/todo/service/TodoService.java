package com.comp.todo.service;

import com.comp.todo.model.Todo;

/**
 * Base interface for calling data access objects to perform CRUD operations on
 * todos.
 * 
 * @author Vincent Montesclaros
 *
 */
public interface TodoService extends BaseService<Todo, Long> {

}
