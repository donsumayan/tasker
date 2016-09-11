package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.comp.tasker.controller.AuthController;
import com.comp.tasker.service.AuthService;

public class AuthTest {
	
	@Mock
	AuthController authController;
	
	@Mock
	AuthService authService;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testCreation() {
		assertNotNull(authController);
		assertNotNull(authService);
	}
	
	@Test
	public void testLogin() {
		String str = "";
		Map map = new HashMap();
		Mockito.when(authController.login(map)).thenReturn(str);	// check if it performs correctly
		assertEquals("", authController.login(map));
		
		Mockito.when(authService.login("", "")).thenReturn(str);	// check if it performs correctly
		assertEquals("", authService.login("", ""));
		
		
		authController.login(map);	// verify if it gets invoked	
//		Mockito.verify(authService).login("",  "");
	}
}
