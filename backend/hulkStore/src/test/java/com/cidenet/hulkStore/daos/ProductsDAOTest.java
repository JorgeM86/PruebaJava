package com.cidenet.hulkStore.daos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cidenet.hulkStore.entities.ProductsDTO;

@RunWith(SpringRunner.class)
@DataJpaTest
class ProductsDAOTest {

	@Autowired
	private ProductsDAO repository;
	
	@Test
	public void findAllProduct() {
		List<ProductsDTO> allProducts = repository.findAll();
		assertNotNull(allProducts);
	}
	
	@Test
	public void findProductByID() {
		//El producto con ID 1000 es proporcionado por el archivo dataTest.sql en src/test/resources
		ProductsDTO dbProductDTO = repository.findById(1000).orElse(null);
		assertNotNull(dbProductDTO);
	}
	
	@Test
	public void saveProduct() {
		ProductsDTO productDTO = new ProductsDTO("Thor Comics", "Comics of the god of thunder", 25, 20000, 1, 1);
		assertNotNull(repository.save(productDTO));
	}
	
	@Test
	public void updateProduct() {
		//New product for testing
		ProductsDTO productDTO = new ProductsDTO("Thor Comics", "Comics of the god of thunder", 25, 20000, 1, 1);
		repository.save(productDTO);
		
		//Update price and quantity
		//New price 25000
		//New quantity 75
		productDTO.setPrice(25000.0);
		productDTO.setQuantity(75);
		
		//Cuando la ID no existe usa persist, cuando existe usa merge
		ProductsDTO dbProductDTO = repository.save(productDTO);
		
		assertTrue(dbProductDTO.getPrice() == 25000.0 && dbProductDTO.getQuantity() == 75);
		
	}
	
	@Test
	public void deleteProduct() {
		//Encuentra el producto en la base de datos proporcionado por el archivo dataTest.sql en src/test/resources
		ProductsDTO productDTO1 = repository.findById(2000).orElse(null);
		assertNotNull(productDTO1);
		
		repository.deleteById(2000);
		ProductsDTO productDTO2 = repository.findById(2000).orElse(null);
		assertNull(productDTO2);
		
	}

}
