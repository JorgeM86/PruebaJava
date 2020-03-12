package com.cidenet.hulkStore.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cidenet.hulkStore.daos.ProductsDAO;
import com.cidenet.hulkStore.entities.ProductsDTO;

@Repository
@Transactional
public class ProductsServices {

	@Autowired
	private ProductsDAO repository;
	
	public List<ProductsDTO> getAllProducts() {
		return repository.findAll();
	}
	
	public ProductsDTO getProductByID(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public ProductsDTO saveProduct(ProductsDTO productDTO) {
		return repository.save(productDTO);
	}
	
	public void deleteProduct(int id) {
		repository.deleteById(id);
	}
	
}
