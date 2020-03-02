package com.cidenet.hulkStore.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cidenet.hulkStore.entities.UsersDTO;

public interface UsersDAO extends JpaRepository<UsersDTO, Integer> {

	//@Query("from users where email=?1 and password=?2")
	public UsersDTO findByEmail(String email);
	
}
