package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.comp.tasker.controller.TodoController;
import com.comp.tasker.dao.TodoDao;
import com.comp.tasker.model.Todo;
import com.comp.tasker.model.User;
import com.comp.tasker.service.TodoService;

public class TodoTest {

	@Spy
	TodoController todoController;

	@Mock
	TodoService todoService;

	@Mock
	TodoDao todoDao;

	private List list;
	private final static String RESULT_GET_TODOS = "[{\"id\":1,\"note\":\"ASDF!\",\"isDone\":true,\"dateCreated\":1473397772000,\"dateUpdated\":1473590567000,\"user\":{\"id\":1,\"firstName\":\"Vincent2\",\"lastName\":\"Montesclaros\",\"email\":\"vincent@gmail.com\",\"role\":{\"id\":1,\"name\":\"Admin\"}}},{\"id\":2,\"note\":\"Just do it!\",\"isDone\":false,\"dateCreated\":1473397772000,\"dateUpdated\":1473397773000,\"user\":{\"id\":1,\"firstName\":\"Vincent2\",\"lastName\":\"Montesclaros\",\"email\":\"vincent@gmail.com\",\"role\":{\"id\":1,\"name\":\"Admin\"}}},{\"id\":3,\"note\":\"Just do it!\",\"isDone\":false,\"dateCreated\":1473397772000,\"dateUpdated\":1473397773000,\"user\":{\"id\":2,\"firstName\":\"Francis\",\"lastName\":\"Montesclaros\",\"email\":\"francis@gmail.com\",\"role\":{\"id\":2,\"name\":\"User\"}}},{\"id\":25,\"note\":\"New todo!!\",\"isDone\":false,\"dateCreated\":1473591020000,\"dateUpdated\":1473591020000,\"user\":{\"id\":1,\"firstName\":\"Vincent2\",\"lastName\":\"Montesclaros\",\"email\":\"vincent@gmail.com\",\"role\":{\"id\":1,\"name\":\"Admin\"}}}]";

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		// setup data
		list = new ArrayList<Todo>(); // create constants for this!
		User user1 = new User();
		User user2 = new User();

		Todo todo1 = new Todo();
		todo1.setId(1);
		todo1.setIsDone(true);
		todo1.setNote("ASDF!");
		todo1.setUser(user1);

		Todo todo2 = new Todo();
		todo2.setId(2);
		todo2.setIsDone(false);
		todo2.setNote("Just do it!");
		todo2.setUser(user1);

		Todo todo3 = new Todo();
		todo3.setId(3);
		todo3.setIsDone(false);
		todo3.setNote("Just do it!");
		todo3.setUser(user2);

		Todo todo4 = new Todo();
		todo4.setId(25);
		todo4.setIsDone(false);
		todo4.setNote("New todo!!");
		todo4.setUser(user1);

		list.add(todo1);
		list.add(todo2);
		list.add(todo3);
		list.add(todo4);

	}

	@Test
	public void testCreation() {
		assertNotNull(todoController);
		assertNotNull(todoService);
		assertNotNull(todoDao);
	}

	@Test
	public void testGetTodos() {
		Mockito.doReturn(RESULT_GET_TODOS).when(todoController).getTodos();
		assertEquals(RESULT_GET_TODOS, todoController.getTodos());

		Mockito.when(todoService.getAllTodos()).thenReturn(RESULT_GET_TODOS);
		assertEquals(RESULT_GET_TODOS, todoService.getAllTodos());

		Mockito.when(todoDao.list()).thenReturn(list);
		assertEquals(list, todoDao.list());

		Mockito.verify(todoService).getAllTodos();
		Mockito.verify(todoDao).list();
	}

	@Test
	public void testDeleteTodo() {
		Mockito.doReturn(1).when(todoController).deleteTodo(1L);
		assertEquals(1, todoController.deleteTodo(1L));

		Mockito.when(todoService.removeById(1L)).thenReturn(1L);
		assertEquals(1L, todoService.removeById(1L));

		Mockito.verify(todoService).removeById(1L);
	}

	@Test
	public void testDeleteAllTodos() {
		Mockito.doReturn(4L).when(todoController).deleteAllTodos();
		assertEquals(4L, todoController.deleteAllTodos());

		Mockito.when(todoService.deleteAllTodos()).thenReturn(4L);
		assertEquals(4L, todoService.deleteAllTodos().longValue());

		Mockito.when(todoDao.deleteAll()).thenReturn(4L);
		assertEquals(4L, todoDao.deleteAll());

		Mockito.verify(todoService).deleteAllTodos();
		Mockito.verify(todoDao).deleteAll();
	}
}
