package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.comp.tasker.controller.UserController;
import com.comp.tasker.dao.UserDao;
import com.comp.tasker.model.Todo;
import com.comp.tasker.model.User;
import com.comp.tasker.service.TodoService;
import com.comp.tasker.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

public class UserTest {
	@Mock
	User user;

	@Mock
	Todo todo;
	
	@Mock
	UserController userController;
	
	@Mock
	UserService userService;
	
	@Mock
	TodoService todoService;
	
	@Mock
	UserDao userDao;
	
	private List list;
	private Map map;
	private long id;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		
		// setup data
		list = new ArrayList<>();	// create constants for this!
		map = new HashMap();
		id = 1L;
	}
	
	@Test
	public void testCreation() {
		assertNotNull(user);
        assertNotNull(userController);
        assertNotNull(userService);
        assertNotNull(userDao);

        assertNotNull(todo);
        assertNotNull(todoService);
	}
	
	@Test
	public void testGetUsers() throws JsonProcessingException {
		Mockito.when(userController.getUsers()).thenReturn(list);	// check if it performs correctly
		assertEquals(list, userController.getUsers());
		
		Mockito.when(userService.getUsers()).thenReturn("");	// check if it performs correctly
		assertEquals("", userService.getUsers());
		
		Mockito.when(userDao.list()).thenReturn(list);	// check if it performs correctly
		assertEquals(list, userDao.list());
		
		userController.getUser(1L);	// verify if it gets invoked	
		Mockito.verify(userService).getUsers();
		Mockito.verify(userDao).list();
	}
	
	@Test
	public void testDeleteAllUsers() {
		Mockito.when(userController.deleteAllUsers()).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, userController.deleteAllUsers());
		
		Mockito.when(userService.deleteAllUsers()).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, userService.deleteAllUsers().longValue());
		
		Mockito.when(userDao.deleteAll()).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, userDao.deleteAll());
		
		userController.deleteAllUsers();	// verify if it gets invoked	
		Mockito.verify(userService).deleteAllUsers();
		Mockito.verify(userDao).deleteAll();
	}
	
	@Test
	public void testCreateUser() {
		String email = user.getEmail();
		
		Mockito.when(userController.createUser(user)).thenReturn(1);	// check if it performs correctly
		assertEquals(1, userController.createUser(user));
		
		Mockito.when(userService.addUser(user).longValue()).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, userService.addUser(user).longValue());
		
		Mockito.when(userDao.save(user)).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, userDao.save(user));
		
		Mockito.when(userDao.findByEmail(email)).thenReturn(user);	// check if it performs correctly
		assertEquals(user, userDao.findByEmail(email));
		
		userController.createUser(user);	// verify if it gets invoked
		Mockito.verify(userService).addUser(user);
		Mockito.verify(userDao).findByEmail(email);
		Mockito.verify(userDao).save(user);
	}
	
	@Test
	public void testUpdateUsers() {
		Mockito.when(userController.updateUser(user)).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, userController.updateUser(user));
		
		Mockito.when(userService.updateUser(user)).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, userService.updateUser(user).longValue());
		
		Mockito.when(userDao.saveOrUpdate(user)).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, userDao.saveOrUpdate(user));
		
		userController.updateUser(user); // verify if it gets invoked
		Mockito.verify(userService).updateUser(user);
		Mockito.verify(userDao).saveOrUpdate(user);
	}
	
	@Test
	public void testGetUser() throws JsonProcessingException {
		Mockito.when(userController.getUser(id)).thenReturn(user);	// check if it performs correctly
		assertEquals(user, userController.getUser(id));
		
		Mockito.when(userService.get(id)).thenReturn(user);	// check if it performs correctly
		assertEquals(user, userService.get(id));
		
		userController.getUsers();	// verify if it gets invoked
		Mockito.verify(userService).get(id);
	}
	
	@Test
	public void testGetAllUserTodos() {
		Mockito.when(userController.getAllUserTodos(id)).thenReturn(list);	// check if it performs correctly
		assertEquals(list, userController.getAllUserTodos(id));
		
		Mockito.when(todoService.getTodosByUserId(id)).thenReturn("");	// check if it performs correctly
		assertEquals("", todoService.getTodosByUserId(id));
		
		userController.getAllUserTodos(id);	// verify if it gets invoked
		Mockito.verify(todoService).getTodosByUserId(id);
	}
	
	@Test
	public void testCreateTodo() {
		Mockito.when(userController.createTodo(id, map)).thenReturn(1);	// check if it performs correctly
		assertEquals(1, userController.createTodo(id, map));
		
		Mockito.when(todoService.createTodo(id, map)).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, todoService.createTodo(1L, map).longValue());
		
		userController.createTodo(id, map);	// verify if it gets invoked
		Mockito.verify(todoService).createTodo(1L, map);
	}
	
	@Test
	public void testUpdateTodo() {
		Mockito.when(userController.updateTodo(todo)).thenReturn(1);	// check if it performs correctly
		assertEquals(1, userController.updateTodo(todo));
		
		Mockito.when(todoService.updateTodo(todo)).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, todoService.updateTodo(todo).longValue());
		
		userController.updateTodo(todo);	// verify if it gets invoked
		Mockito.verify(todoService).updateTodo(todo);
	}
	
	@Test
	public void testGetTodo() {
		Mockito.when(userController.getTodo(id)).thenReturn(todo);	// check if it performs correctly
		assertEquals(todo, userController.getTodo(id));
		
		Mockito.when(todoService.getTodoById(id)).thenReturn("");	// check if it performs correctly
		assertEquals("", todoService.getTodoById(id));
		
		userController.getTodo(id);	// verify if it gets invoked
		Mockito.verify(todoService).getTodoById(id);
	}
	
	@Test
	public void testDeleteTodo() {
		Mockito.when(userController.deleteTodo(id)).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, userController.deleteTodo(id));

		Mockito.when(todoService.removeById(id)).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, todoService.removeById(id));
		
		userController.deleteTodo(id);	// verify if it gets invoked
		Mockito.verify(todoService).removeById(id);
	}
}
