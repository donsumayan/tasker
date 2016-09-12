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
		final String email = "vincent@gmail.com";
		final String password = "$2a$06$RG2qrvrrXVzoyWtgdpVC5OBQ7woFEY5JOFmTEljcW7zE9qweflgfS";
		final String result = "{\"id\":1,\"firstName\":\"Vincent2\",\"lastName\":\"Montesclaros\",\"email\":\"vincent@gmail.com\",\"role\":{\"id\":1,\"name\":\"Admin\"}}";
		
		Map map = new HashMap();
		map.put("email", email);
		map.put("password", password);
		
		Mockito.when(authController.login(map)).thenReturn(result);
		assertEquals(result, authController.login(map));
		
		Mockito.when(authService.login(email, password)).thenReturn(result);
		assertEquals(result, authService.login(email, password));
		
		Mockito.verify(authService).login(email,  password);
	}
}
