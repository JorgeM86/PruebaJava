package com.cidenet.hulkStore.mock_services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cidenet.hulkStore.daos.UsersDAO;
import com.cidenet.hulkStore.entities.UsersDTO;
import com.cidenet.hulkStore.services.UsersServices;

class UsersServicesTest {
	
	@InjectMocks
	UsersServices usersServices;
	
	@Mock
	UsersDAO usersRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
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
		
		when(usersRepository.findById(anyInt())).thenReturn(Optional.of(userDTO));
		UsersDTO dbUsersDTO = usersServices.getUserByID(1);
		assertNotNull(dbUsersDTO);
		assertEquals(dbUsersDTO.getName(), "Juan");
	}

	@Test
	void testSaveUser() {
		UsersDTO userDTO = new UsersDTO();
		userDTO.setUser_id(12);
		userDTO.setName("Juan");
		userDTO.setLast_name("Perez");
		userDTO.setEmail("juan@email.com");
		userDTO.setBirth_date(new Date());
		userDTO.setGender("Masculino");
		userDTO.setPassword("123");
		userDTO.setRegistration_date(new Date());
		
		when(usersRepository.save(userDTO)).thenReturn(userDTO);
		UsersDTO dbUsersDTO = usersServices.saveUser(userDTO);
		assertNotNull(dbUsersDTO);
		assertEquals(dbUsersDTO.getName(), "Juan");
	}
	
	@Test
	void testFindUserByEmail() {
		UsersDTO userDTO = new UsersDTO();
		userDTO.setUser_id(12);
		userDTO.setName("Juan");
		userDTO.setLast_name("Perez");
		userDTO.setEmail("juan@email.com");
		userDTO.setBirth_date(new Date());
		userDTO.setGender("Masculino");
		userDTO.setPassword("123");
		userDTO.setRegistration_date(new Date());
		
		when(usersRepository.findByEmail(anyString())).thenReturn(userDTO);
		UsersDTO dbUsersDTO = usersServices.getUserByEmail("test@email.com");
		assertNotNull(dbUsersDTO);
		assertEquals(dbUsersDTO.getName(), "Juan");
	}

}
