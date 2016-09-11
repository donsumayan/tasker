package com.comp.tasker.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp.tasker.constants.Views;
import com.comp.tasker.dao.BaseDao;
import com.comp.tasker.dao.TodoDao;
import com.comp.tasker.model.Todo;
import com.comp.tasker.model.User;
import com.comp.tasker.service.DateTimeService;
import com.comp.tasker.service.TodoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Base implementation for calling data access objects to perform CRUD
 * operations on todos.
 * 
 * @author Vincent Montesclaros
 *
 */
/**
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

	/**
	 * Service for date and time operations.
	 */
	@Autowired
	private DateTimeService dateTimeService;

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

	@Override
	public Long createTodo(Long userId, Map<String, String> noteDetails) {
		String note = noteDetails.get("note");
		Boolean isDone = Boolean.parseBoolean(noteDetails.get("isDone"));
		Date currentDate = dateTimeService.getSystemDate();

		Todo todo = new Todo(note, isDone, currentDate, currentDate, new User(userId));

		return todoDao.save(todo);
	}

	@Override
	public Long updateTodo(Todo todo) {
		Date currentDate = dateTimeService.getSystemDate();
		todo.setDateUpdated(currentDate);
		return todoDao.saveOrUpdate(todo);
	}

	@Override
	public String getAllTodos() {
		List<Todo> todos = todoDao.list();
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter viewWriter = mapper.writerWithView(Views.Admin.class);
		try {
			return viewWriter.writeValueAsString(todos);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	@Override
	public String getTodosByUserId(Long userId) {
		List<Todo> todos = todoDao.findByUserId(userId);
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter viewWriter = mapper.writerWithView(Views.User.class);
		try {
			return viewWriter.writeValueAsString(todos);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	@Override
	public String getTodoById(Long todoId) {
		Todo todo = todoDao.get(todoId);
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter viewWriter = mapper.writerWithView(Views.User.class);
		try {
			return viewWriter.writeValueAsString(todo);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
}
