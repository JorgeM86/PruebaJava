package com.cidenet.hulkStore.mock_controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
import com.cidenet.hulkStore.controllers.UserController;
import com.cidenet.hulkStore.entities.UsersDTO;
import com.cidenet.hulkStore.services.UsersServices;

class UserControllerTest {

	@InjectMocks
    UserController controller;
     
    @Mock
    UsersServices services;
    
    @BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}
	
	@Test
	void testGetUserByID() {
		UsersDTO userDTO = new UsersDTO();
		userDTO.setUser_id(12);
		userDTO.setName("Juan");
		userDTO.setLast_name("Perez");
		userDTO.setEmail("juan@email.com");
		userDTO.setBirth_date(new Date());
		userDTO.setGender("Masculino");
		userDTO.setPassword("123");
		userDTO.setRegistration_date(new Date());
		
		when(services.getUserByID(anyInt())).thenReturn(userDTO);
		
		ResponseEntity<Response> responseEntity = controller.getUserByID(1);
		UsersDTO dbUsersDTO = (UsersDTO) responseEntity.getBody().getData();
		
		assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getStatus(), "success");
        assertEquals(dbUsersDTO.getName(), "Juan");
        assertEquals(dbUsersDTO.getLast_name(), "Perez");
        assertEquals(dbUsersDTO, userDTO);
		
	}

}
