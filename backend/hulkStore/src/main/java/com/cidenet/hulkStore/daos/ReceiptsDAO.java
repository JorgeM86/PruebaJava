package com.cidenet.hulkStore.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cidenet.hulkStore.entities.ReceiptsDTO;

@Transactional
public interface ReceiptsDAO extends JpaRepository<ReceiptsDTO, Integer> {

	@Modifying
	@Query("update ProductsDTO p set p.quantity = p.quantity - ?1 where p.product_id = ?2")
	void updateProductQuantity(Integer quantity, Integer id);
	
}
