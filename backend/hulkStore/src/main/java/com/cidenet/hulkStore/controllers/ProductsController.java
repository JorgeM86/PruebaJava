package com.cidenet.hulkStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet.hulkStore.Response;
import com.cidenet.hulkStore.entities.ProductsDTO;
import com.cidenet.hulkStore.services.ProductsServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
public class ProductsController {
	
	@Autowired
	private ProductsServices services;
	
	@GetMapping(path = "/api/products/all")
	public ResponseEntity<Response> findAll() {
		Response response = new Response();
		try {
			response.setData(services.getAllProducts());
			response.setStatus("success");
		} catch (Exception e) {
			response.setStatus("failure");
			response.setMessage(e.toString());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/api/products/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> saveProduct(@RequestParam("product_info") String productJson) {
		Response response = new Response();
		try {
			ProductsDTO productsDTO = new ObjectMapper().readValue(productJson, ProductsDTO.class);
			Object obj = services.saveProduct(productsDTO);
			if (obj != null) {
				response.setData(obj);
				response.setStatus("success");
			} else {
				response.setStatus("failure");
			}
		} catch (Exception e) {
			response.setStatus("failure");
			response.setMessage(e.toString());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 
	
	@PostMapping(path = "/api/products/delete", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> deleteDelete(@RequestParam("product_info") Integer id) {
		Response response = new Response();
		try {
			services.deleteProduct(id);
			response.setStatus("success");
		} catch (Exception e) {
			response.setStatus("failure");
			response.setMessage(e.toString());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 

}
