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
import com.cidenet.hulkStore.daos.ReceiptsDAO;
import com.cidenet.hulkStore.entities.ReceiptsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
public class ReceiptsController {

	@Autowired
	private ReceiptsDAO repository;
	
	@GetMapping(path = "/api/receipts/all")
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
	
	@PostMapping(path = "/api/receipts/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> saveReceipt(@RequestParam("receipt_info") String receiptJson) {
		Response response = new Response();
		try {
			ReceiptsDTO receiptsDTO = new ObjectMapper().readValue(receiptJson, ReceiptsDTO.class);
			Object obj = repository.save(receiptsDTO);
			if (obj != null) {
				repository.updateProductQuantity(receiptsDTO.getTotal_quantity(), receiptsDTO.getProduct_fk());
				response.setData(obj);
				response.setStatus("success");
			} else {
				response.setStatus("failure");
			}
		} catch (Exception e) {
			response.setStatus("failure");
			response.setMessage(e.toString());
			System.out.println(e);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 
	
	@PostMapping(path = "/api/receipts/delete", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> deleteReceipt(@RequestParam("product_info") Integer id) {
		Response response = new Response();
		try {
			repository.deleteById(id);
			response.setStatus("success");
		} catch (Exception e) {
			response.setStatus("failure");
			response.setMessage(e.toString());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	} 
	
}
