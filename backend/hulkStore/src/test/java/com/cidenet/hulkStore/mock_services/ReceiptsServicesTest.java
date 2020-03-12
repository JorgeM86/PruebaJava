package com.cidenet.hulkStore.mock_services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cidenet.hulkStore.daos.ReceiptsDAO;
import com.cidenet.hulkStore.entities.ReceiptsDTO;
import com.cidenet.hulkStore.services.ReceiptsServices;

class ReceiptsServicesTest {
	
	@InjectMocks
	ReceiptsServices receiptsServices;
	
	@Mock
	ReceiptsDAO receiptsRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllReceipts() {
		List<ReceiptsDTO> allReceipts = new ArrayList<ReceiptsDTO>();
		ReceiptsDTO receiptDTO = new ReceiptsDTO();
		receiptDTO.setTotal_price(40000);
		receiptDTO.setTotal_quantity(2);
		receiptDTO.setProduct_fk(2000);
		receiptDTO.setUser_fk(1000);
		receiptDTO.setDate(new Date());
		allReceipts.add(receiptDTO);
		
		when(receiptsRepository.findAll()).thenReturn(allReceipts);
		
		List<ReceiptsDTO> list = receiptsServices.getAllReceipts();
		assertNotNull(list);
		assertTrue(list.size() == allReceipts.size());
		assertEquals(list.get(0).getUser_fk(), 1000);
		assertEquals(list, allReceipts);
	}

	@Test
	void testGetReceiptByID() {
		ReceiptsDTO receiptDTO = new ReceiptsDTO();
		receiptDTO.setTotal_price(40000);
		receiptDTO.setTotal_quantity(2);
		receiptDTO.setProduct_fk(2000);
		receiptDTO.setUser_fk(1000);
		receiptDTO.setDate(new Date());
		when(receiptsRepository.findById(anyInt())).thenReturn(Optional.of(receiptDTO));
		ReceiptsDTO dbReceiptDTO = receiptsServices.getReceiptByID(1);
		assertNotNull(dbReceiptDTO);
		assertEquals(dbReceiptDTO.getUser_fk(), 1000);
	}

	@Test
	void testSaveReceipt() {
		ReceiptsDTO receiptDTO = new ReceiptsDTO();
		receiptDTO.setTotal_price(40000);
		receiptDTO.setTotal_quantity(2);
		receiptDTO.setProduct_fk(2000);
		receiptDTO.setUser_fk(1000);
		receiptDTO.setDate(new Date());
		when(receiptsRepository.save(receiptDTO)).thenReturn(receiptDTO);
		ReceiptsDTO dbReceiptDTO = receiptsServices.saveReceipt(receiptDTO);
		assertNotNull(dbReceiptDTO);
		assertEquals(dbReceiptDTO.getUser_fk(), 1000);
	}

	@Test
	void testUpdateProduct() {
		when(receiptsRepository.updateProductQuantity(anyInt(), anyInt())).thenReturn(1);
		int rowsUpdated = receiptsRepository.updateProductQuantity(3, 1000);
		assertNotNull(rowsUpdated);
		assertTrue(rowsUpdated > 0);
	}

	@Test
	void testDeleteReceipt() {
		doNothing().when(receiptsRepository).deleteById(anyInt());
		receiptsServices.deleteReceipt(1);
		verify(receiptsRepository, times(1)).deleteById(1);
	}

}
