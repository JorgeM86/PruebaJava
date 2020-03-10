package com.cidenet.hulkStore.daos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cidenet.hulkStore.entities.UsersDTO;

@RunWith(SpringRunner.class)
@DataJpaTest
class UsersDAOTest {

	@Autowired
	private UsersDAO userRepository;
	
	@Test
	public void findAllUsers() {
		List<UsersDTO> allUsers = userRepository.findAll();
		assertNotNull(allUsers);
	}
	
	@Test
	public void findUserByID() {
		//El usuario con ID 1000 es proporcionado por el archivo dataTest.sql en src/test/resources
		UsersDTO dbUserDTO = userRepository.findById(1000).orElse(null);
		assertNotNull(dbUserDTO);
	}
	
	@Test
	public void saveUser() {
		UsersDTO userDTO = new UsersDTO();
		userDTO.setUser_id(12);
		userDTO.setName("Juan");
		userDTO.setLast_name("Perez");
		userDTO.setEmail("juan@email.com");
		userDTO.setBirth_date(new Date());
		userDTO.setGender("Masculino");
		userDTO.setPassword("123");
		userDTO.setRegistration_date(new Date());
		
		UsersDTO dbUserDTO = userRepository.save(userDTO);
		assertNotNull(dbUserDTO);
		
		System.out.println(dbUserDTO.toString());
	}
	
	@Test
	public void findByEmail() {	
		//Encuentra el ususario en la base de datos proporcionado por el archivo dataTest.sql en src/test/resources
		UsersDTO dbUserDTO = userRepository.findByEmail("user1@email.com");
		assertNotNull(dbUserDTO);
		System.out.println(dbUserDTO.toString());
	}

}
