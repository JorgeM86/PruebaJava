package com.cidenet.hulkStore.daos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cidenet.hulkStore.entities.ReceiptsDTO;

@RunWith(SpringRunner.class)
@DataJpaTest
class ReceiptsDAOTest {
	
	@Autowired
	private ReceiptsDAO repository;

	@Test
	public void findAllReceipts() {
		List<ReceiptsDTO> allReceipts = repository.findAll();
		assertNotNull(allReceipts);
	}
	
	@Test
	public void findReceiptByID() {
		//El recibo con ID 1000 es proporcionado por el archivo dataTest.sql en src/test/resources
		ReceiptsDTO dbReceiptDTO = repository.findById(1000).orElse(null);
		assertNotNull(dbReceiptDTO);
	}
	
	@Test
	public void saveReceipt() {
		//Nueva compra hecha por el ususario User1 con ID 1000 en la base de datos proporcionado por el archivo dataTest.sql en src/test/resources
		ReceiptsDTO receiptDTO = new ReceiptsDTO();
		receiptDTO.setTotal_price(40000);
		receiptDTO.setTotal_quantity(2);
		receiptDTO.setProduct_fk(2000);
		receiptDTO.setUser_fk(1000);
		receiptDTO.setDate(new Date());
		assertNotNull(repository.save(receiptDTO));
	}
	
	@Test
	public void updateReceipt() {
		//New receipt for testing
		ReceiptsDTO receiptDTO = new ReceiptsDTO();
		receiptDTO.setTotal_price(40000);
		receiptDTO.setTotal_quantity(2);
		receiptDTO.setProduct_fk(2000);
		receiptDTO.setUser_fk(1000);
		receiptDTO.setDate(new Date());
		repository.save(receiptDTO);
		
		//Update total_price and total_quantity
		//New total_price 60000
		//New total_quantity 3
		receiptDTO.setTotal_price(60000.0);
		receiptDTO.setTotal_quantity(3);
		
		//Cuando la ID no existe usa persist, cuando existe usa merge
		ReceiptsDTO dbreceiptDTO = repository.save(receiptDTO);
		
		assertTrue(dbreceiptDTO.getTotal_price()== 60000.0 && dbreceiptDTO.getTotal_quantity() == 3);
		
	}
	
	@Test
	public void buyProduct() {
		//Cuando se crea un nuevo recibo (comprar producto) se hace un update a al stock (cantidad) del producto.
		//New receipt for testing
		ReceiptsDTO receiptDTO = new ReceiptsDTO();
		receiptDTO.setTotal_price(40000);
		receiptDTO.setTotal_quantity(2);
		receiptDTO.setProduct_fk(2000);
		receiptDTO.setUser_fk(1000);
		receiptDTO.setDate(new Date());
		repository.save(receiptDTO);
		
		//Al crear el recibo se debe de restar la cantidad comprada al producto, retorna 1 indicando que si
		//cambio algo en la bse de datos
		assertTrue(repository.updateProductQuantity(receiptDTO.getTotal_quantity(), 2000) > 0);
	}
	
	@Test
	public void deleteReceipt() {
		//Encuentra el recibo en la base de datos proporcionado por el archivo dataTest.sql en src/test/resources
		ReceiptsDTO receiptDTO1 = repository.findById(1000).orElse(null);
		assertNotNull(receiptDTO1);
		
		repository.deleteById(1000);
		ReceiptsDTO receiptDTO2 = repository.findById(1000).orElse(null);
		assertNull(receiptDTO2);
		
	}

}
