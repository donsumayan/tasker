package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

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
	
	@Spy
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
	private final static String RESULT_GET_USERS = "[{\"id\":1,\"firstName\":\"Vincent\",\"lastName\":\"Montesclaros\",\"email\":\"vincent@gmail.com\",\"role\":{\"id\":1,\"name\":\"Admin\"}},{\"id\":2,\"firstName\":\"Fealrone\",\"lastName\":\"Alajas\",\"email\":\"fealrone@gmail.com\",\"role\":{\"id\":2,\"name\":\"User\"}}]";
	private final static String RESULT_USER_1_TODO = "[{\"id\":1,\"note\":\"ASDF!\",\"isDone\":true,\"dateCreated\":1473397772000,\"dateUpdated\":1473590567000},{\"id\":2,\"note\":\"Just do it!\",\"isDone\":false,\"dateCreated\":1473397772000,\"dateUpdated\":1473397773000},{\"id\":25,\"note\":\"New todo!!\",\"isDone\":false,\"dateCreated\":1473591020000,\"dateUpdated\":1473591020000}]";
	private final static String RESULT_USER_1_TODO_1 = "{\"id\":1,\"note\":\"ASDF!\",\"isDone\":true,\"dateCreated\":1473397772000,\"dateUpdated\":1473590567000}";
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		
		// setup data
		list = new ArrayList<>();
		
		User user1 = new User();
		user1.setId(1L);
		user1.setEmail("vincent@gmail.com");
		user1.setFirstName("Vincent2");
		user1.setLastName("Montesclaros");
		user1.setPassword("$2a$06$RG2qrvrrXVzoyWtgdpVC5OBQ7woFEY5JOFmTEljcW7zE9qweflgfS");
		
		User user2 = new User();
		user2.setId(2L);
		user2.setEmail("francis@gmail.com");
		user2.setFirstName("Francis");
		user2.setLastName("Montesclaros");
		user2.setPassword("$2a$06$RG2qrvrrXVzoyWtgdpVC5OBQ7woFEY5JOFmTEljcW7zE9qweflgfS");
		
		list.add(user1);
		list.add(user2);
		
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
		Mockito.doReturn(RESULT_GET_USERS).when(userController).getUsers();
		assertEquals(RESULT_GET_USERS, userController.getUsers());
		
		Mockito.when(userService.getUsers()).thenReturn(RESULT_GET_USERS);
		assertEquals(RESULT_GET_USERS, userService.getUsers());
		
		Mockito.when(userDao.list()).thenReturn(list);
		assertEquals(list, userDao.list());
			
		Mockito.verify(userService).getUsers();
		Mockito.verify(userDao).list();
	}
	
	@Test
	public void testDeleteAllUsers() {
		Mockito.doReturn(2L).when(userController).deleteAllUsers();
		assertEquals(2L, userController.deleteAllUsers());
		
		Mockito.when(userService.deleteAllUsers()).thenReturn(2L);
		assertEquals(2L, userService.deleteAllUsers().longValue());
		
		Mockito.when(userDao.deleteAll()).thenReturn(2L);
		assertEquals(2L, userDao.deleteAll());
		
		Mockito.verify(userService).deleteAllUsers();
		Mockito.verify(userDao).deleteAll();
	}
	
	@Test
	public void testCreateUser() {
		String email = user.getEmail();
		
		Mockito.doReturn(1L).when(userController).createUser(user);
		assertEquals(1L, userController.createUser(user));
		
		Mockito.when(userService.addUser(user).longValue()).thenReturn(1L);
		assertEquals(1L, userService.addUser(user).longValue());
		
		Mockito.when(userDao.findByEmail(email)).thenReturn(user);
		assertEquals(user, userDao.findByEmail(email));
		
		Mockito.when(userDao.save(user)).thenReturn(1L);
		assertEquals(1L, userDao.save(user));
		
		Mockito.verify(userService).addUser(user);
		
		InOrder order = Mockito.inOrder(userDao);
		order.verify(userDao).findByEmail(email);
		order.verify(userDao).save(user);
	}
	
	@Test
	public void testUpdateUsers() {
		Mockito.doReturn(1L).when(userController).updateUser(user);
		assertEquals(1L, userController.updateUser(user));
		
		Mockito.when(userService.updateUser(user)).thenReturn(1L);
		assertEquals(1L, userService.updateUser(user).longValue());
		
		Mockito.when(userDao.saveOrUpdate(user)).thenReturn(1L);
		assertEquals(1L, userDao.saveOrUpdate(user));
		
		Mockito.verify(userService).updateUser(user);
		Mockito.verify(userDao).saveOrUpdate(user);
	}
	
	@Test
	public void testGetUser() throws JsonProcessingException {
		Mockito.doReturn(user).when(userController).getUser(id);
		assertEquals(user, userController.getUser(id));
		
		Mockito.when(userService.get(id)).thenReturn(user);
		assertEquals(user, userService.get(id));
		
		Mockito.verify(userService).get(id);
	}
	
	@Test
	public void testGetAllUserTodos() {
		Mockito.doReturn(RESULT_USER_1_TODO).when(userController).getAllUserTodos(1L);
		assertEquals(RESULT_USER_1_TODO, userController.getAllUserTodos(1L));
		
		Mockito.when(todoService.getTodosByUserId(1L)).thenReturn(RESULT_USER_1_TODO);
		assertEquals(RESULT_USER_1_TODO, todoService.getTodosByUserId(1L));
		
		Mockito.verify(todoService).getTodosByUserId(1L);
	}
	
	@Test
	public void testCreateTodo() {
		Mockito.doReturn(1L).when(userController).createTodo(1L, map);
		assertEquals(1L, userController.createTodo(id, map));
		
		Mockito.when(todoService.createTodo(1L, map)).thenReturn(1L);
		assertEquals(1L, todoService.createTodo(1L, map).longValue());
		
		Mockito.verify(todoService).createTodo(1L, map);
	}
	
	@Test
	public void testUpdateTodo() {
		Mockito.doReturn(1L).when(userController).updateTodo(todo);
		assertEquals(1L, userController.updateTodo(todo));
		
		Mockito.when(todoService.updateTodo(todo)).thenReturn(1L);
		assertEquals(1L, todoService.updateTodo(todo).longValue());
		
		Mockito.verify(todoService).updateTodo(todo);
	}
	
	@Test
	public void testGetTodo() {
		Mockito.doReturn(RESULT_USER_1_TODO_1).when(userController).getTodo(1L);
		assertEquals(RESULT_USER_1_TODO_1, userController.getTodo(1L));
		
		Mockito.when(todoService.getTodoById(1L)).thenReturn(RESULT_USER_1_TODO_1);
		assertEquals(RESULT_USER_1_TODO_1, todoService.getTodoById(1L));
		
		Mockito.verify(todoService).getTodoById(1L);
	}
	
	@Test
	public void testDeleteTodo() {
		Mockito.doReturn(1L).when(userController).deleteTodo(1L);
		assertEquals(1L, userController.deleteTodo(1L));

		Mockito.when(todoService.removeById(1L)).thenReturn(1L);
		assertEquals(1L, todoService.removeById(1L));
		
		Mockito.verify(todoService).removeById(1L);
	}
}
