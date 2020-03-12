package com.cidenet.hulkStore.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.cidenet.hulkStore.daos.UsersDAO;
import com.cidenet.hulkStore.entities.UsersDTO;

@Repository
@Transactional
public class UsersServices {
	
	@Autowired
    private PasswordEncoder encoder;
	
	@Autowired
	private UsersDAO repository;
	
	public UsersDTO getUserByID(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public UsersDTO getUserByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public UsersDTO saveUser(UsersDTO userDTO) {
		return repository.save(userDTO);
	}
	
	public String authUser(String email, String password) {
		String status = "NOT_FOUND";
		UsersDTO userDTO = getUserByEmail(email);
		if (userDTO != null) {
			if (encoder.matches(password, userDTO.getPassword())) {
				status = "APPROVED";
			} else {
				status = "BAD_CREDENTIALS";
			}
		}
		return status;
	}
	
	public String registrateUser(UsersDTO userDTO) {
		String status = "USER_FOUND";
		UsersDTO user = getUserByEmail(userDTO.getEmail());
		if (user == null) {
			userDTO.setPassword(encoder.encode(userDTO.getPassword()));
            userDTO.setRegistration_date(new Date());
            saveUser(userDTO);
            status = "APPROVED";
		}
		return status;
	}

}
