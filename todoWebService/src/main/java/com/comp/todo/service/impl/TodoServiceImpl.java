package com.comp.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp.todo.dao.BaseDao;
import com.comp.todo.dao.TodoDao;
import com.comp.todo.model.Todo;
import com.comp.todo.service.TodoService;

/**
 * Base implementation for calling data access objects to perform CRUD
 * operations on todos.
 * 
 * @author Vincent Montesclaros
 *
 */
@Service
@Transactional
public class TodoServiceImpl extends BaseServiceImpl<Todo, Long> implements TodoService {

	/**
	 * Data access object for todos.
	 */
	@Autowired
	private TodoDao todoDao;

	public TodoServiceImpl() {

	}

	@Autowired
	public TodoServiceImpl(@Qualifier("todoDaoImpl") BaseDao<Todo, Long> baseDao) {
		super(baseDao);
	}

	@Override
	public List<Todo> findByUserId(Long userId) {
		return todoDao.findByUserId(userId);
	}

	@Override
	public Long deleteAllTodos() {
		return todoDao.deleteAll();
	}
}
