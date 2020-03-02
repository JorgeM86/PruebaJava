package com.cidenet.hulkStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet.hulkStore.Response;
import com.cidenet.hulkStore.daos.TypesDAO;

@CrossOrigin
@RestController
public class TypesController {
	
	@Autowired
	private TypesDAO repository;
	
	@GetMapping(path = "/api/types/all")
	public ResponseEntity<Response> findAll() {
		Response response = new Response();
		try {
			response.setData(repository.findAll());
			response.setStatus("success");
		} catch (Exception e) {
			response.setStatus("failure");
			response.setMessage(e.toString());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
