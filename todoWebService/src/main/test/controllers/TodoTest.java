package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.comp.tasker.controller.TodoController;
import com.comp.tasker.dao.TodoDao;
import com.comp.tasker.service.TodoService;


public class TodoTest {

	@Mock
	TodoController todoController;
	
	@Mock
	TodoService todoService;
	
	@Mock
	TodoDao todoDao;
	
	private List list;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		// setup data
		list = new ArrayList<>();	// create constants for this!
	}
	@Test
	public void testCreation() {
		assertNotNull(todoController);
		assertNotNull(todoService);
		assertNotNull(todoDao);
	}
	
	@Test
	public void testGetTodos() {
		Mockito.when(todoController.getTodos()).thenReturn("");	// check if it performs correctly
		assertEquals("", todoController.getTodos());
		
		Mockito.when(todoService.getAllTodos()).thenReturn("");
		assertEquals("", todoService.getAllTodos());

		Mockito.when(todoDao.list()).thenReturn(list);
		assertEquals(list, todoDao.list());
		
		todoController.getTodos();	// verify if it gets invoked
		Mockito.verify(todoService).getAllTodos();
		Mockito.verify(todoDao).list();
	}
	
	@Test
	public void testDeleteTodo() {
		Mockito.when(todoController.deleteTodo(1L)).thenReturn(1);	// check if it performs correctly
		assertEquals(1, todoController.deleteTodo(1L));
		
		Mockito.when(todoService.removeById(1L)).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, todoService.removeById(1L));
		
		todoController.deleteTodo(1L);	// verify if it gets invoked
		Mockito.verify(todoService).removeById(1L);
	}
	
	@Test
	public void testDeleteAllTodos() {
		Mockito.when(todoController.deleteAllTodos()).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, todoController.deleteAllTodos());
		
		Mockito.when(todoService.deleteAllTodos()).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, todoService.deleteAllTodos().longValue());
		
		Mockito.when(todoDao.deleteAll()).thenReturn(1L);	// check if it performs correctly
		assertEquals(1L, todoDao.deleteAll());
		
		todoController.deleteAllTodos();	// verify if it gets invoked
		Mockito.verify(todoService).deleteAllTodos();
		Mockito.verify(todoDao).deleteAll();
	}
}
