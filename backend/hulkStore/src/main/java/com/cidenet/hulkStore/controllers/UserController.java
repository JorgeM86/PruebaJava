package com.cidenet.hulkStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet.hulkStore.Response;
import com.cidenet.hulkStore.daos.UsersDAO;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UsersDAO repository;
	
	@GetMapping(path = "/api/user/{id}")
	public ResponseEntity<Response> getUserByID(@PathVariable("id") int id) {
		Response response = new Response();
		try {
			response.setStatus("success");
			response.setData(repository.findById(id));
		} catch (Exception e) {
			response.setStatus("failure");
			response.setMessage(e.toString());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
