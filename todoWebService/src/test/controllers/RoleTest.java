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
import org.mockito.Spy;

import com.comp.tasker.controller.RoleController;
import com.comp.tasker.model.Role;
import com.comp.tasker.service.RoleService;


public class RoleTest {
	
	@Spy
	RoleController roleController;

	@Mock
	RoleService roleService;
	
	private List<Role> list;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		list = new ArrayList<>();
		
		Role role1 = new Role();
		role1.setId(1);
		role1.setName("Admin");
		
		Role role2 = new Role();
		role2.setId(2);
		role2.setName("User");
		
		list.add(role1);
		list.add(role2);
	}
	
	@Test
	public void testCreation() {
        assertNotNull(roleController);
        assertNotNull(roleService);
	}
	
	@Test
	public void testGetRoles() {
		Mockito.doReturn(list).when(roleController).getRoles();	// check if it performs correctly
		assertEquals(list, roleController.getRoles());
		
		Mockito.when(roleService.listAll()).thenReturn(list);	// check if it performs correctly
		assertEquals(list, roleService.listAll());
		
		Mockito.verify(roleService).listAll();	// verify if it gets invoked
	}
}
