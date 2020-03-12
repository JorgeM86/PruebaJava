package com.cidenet.hulkStore.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cidenet.hulkStore.daos.ReceiptsDAO;
import com.cidenet.hulkStore.entities.ReceiptsDTO;

@Repository
@Transactional
public class ReceiptsServices {

	@Autowired
	private ReceiptsDAO repository;
	
	public List<ReceiptsDTO> getAllReceipts() {
		return repository.findAll();
	}
	
	public ReceiptsDTO getReceiptByID(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public ReceiptsDTO saveReceipt(ReceiptsDTO receiptDTO) {
		return repository.save(receiptDTO);
	}
	
	public int updateProduct(Integer quantity, Integer id) {
		return repository.updateProductQuantity(quantity, id);
	}
	
	public void deleteReceipt(int id) {
		repository.deleteById(id);
	}
	
}
