package com.cidenet.hulkStore.mock_controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cidenet.hulkStore.Response;
import com.cidenet.hulkStore.controllers.AuthController;
import com.cidenet.hulkStore.entities.UsersDTO;
import com.cidenet.hulkStore.services.UsersServices;

class AuthControllerTest {

	@InjectMocks
	AuthController controller;
     
    @Mock
    UsersServices services;
    
    @BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	@Test
	void testAttemptRegistration() {
		when(services.registrateUser(any(UsersDTO.class))).thenReturn("APPROVED");
		
		String json = "{\"user_type\":\"1\",\"name\":\"Juan\",\"last_name\":\"Perez\",\"gender\":\"Masculino\","
				+ "\"email\":\"juan@email.com\",\"password\":\"123\",\"cellphone\":\"987\"}";
		ResponseEntity<Response> responseEntity = controller.attemptRegistration(json);
		assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getStatus(), "APPROVED");
	}

}
