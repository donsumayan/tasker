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

import com.comp.tasker.controller.RoleController;
import com.comp.tasker.service.RoleService;


public class RoleTest {
	
	@Mock
	RoleController roleController;

	@Mock
	RoleService roleService;
	
	private List list;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		list = new ArrayList<>();
	}
	
	@Test
	public void testCreation() {
        assertNotNull(roleController);
        assertNotNull(roleService);
	}
	
	@Test
	public void testGetRoles() {
		Mockito.when(roleController.getRoles()).thenReturn(list);	// check if it performs correctly
		assertEquals(list, roleController.getRoles());
		
		Mockito.when(roleService.listAll()).thenReturn(list);	// check if it performs correctly
		assertEquals(list, roleService.listAll());
		
		roleController.getRoles();
		Mockito.verify(roleService).listAll();	// verify if it gets invoked
	}
}
