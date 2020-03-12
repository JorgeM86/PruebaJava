package com.cidenet.hulkStore.mock_controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cidenet.hulkStore.Response;
import com.cidenet.hulkStore.controllers.ReceiptsController;
import com.cidenet.hulkStore.entities.ReceiptsDTO;
import com.cidenet.hulkStore.services.ReceiptsServices;

class ReceiptsControllerTest {

	@InjectMocks
    ReceiptsController controller;
     
    @Mock
    ReceiptsServices services;
    
    @BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}
	
	@Test
	void testFindAll() {
		List<ReceiptsDTO> allReceipts = new ArrayList<ReceiptsDTO>();
		ReceiptsDTO receiptDTO = new ReceiptsDTO();
		receiptDTO.setTotal_price(40000);
		receiptDTO.setTotal_quantity(2);
		receiptDTO.setProduct_fk(2000);
		receiptDTO.setUser_fk(1000);
		receiptDTO.setDate(new Date());
		allReceipts.add(receiptDTO);
        
        when(services.getAllReceipts()).thenReturn(allReceipts);
        
        ResponseEntity<Response> responseEntity = controller.findAll();
        List<ReceiptsDTO> list = (List<ReceiptsDTO>) responseEntity.getBody().getData();
        
        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getStatus(), "success");
        assertEquals(list.get(0).getTotal_price(), 40000);
        assertEquals(list.get(0).getTotal_quantity(), 2);
	}

	@Test
	void testSaveReceipt() {
		ReceiptsDTO receiptDTO = new ReceiptsDTO();
		receiptDTO.setTotal_price(40000);
		receiptDTO.setTotal_quantity(2);
		receiptDTO.setProduct_fk(2000);
		receiptDTO.setUser_fk(1000);
		receiptDTO.setDate(new Date());
		
		String json = "{\"total_price\":\"100000\",\"total_quantity\":\"6\",\"product_fk\":\"1\",\"user_fk\":\"1\"}";
        
        when(services.saveReceipt(any(ReceiptsDTO.class))).thenReturn(receiptDTO);
        
        ResponseEntity<Response> responseEntity = controller.saveReceipt(json);
        ReceiptsDTO dbReceiptsDTO = (ReceiptsDTO) responseEntity.getBody().getData();
        
        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getStatus(), "success");
        assertEquals(dbReceiptsDTO.getTotal_price(), 40000);
        assertEquals(dbReceiptsDTO.getTotal_quantity(), 2);
        assertEquals(dbReceiptsDTO, receiptDTO);
	}

	@Test
	void testDeleteReceipt() {
		doNothing().when(services).deleteReceipt(anyInt());
		ResponseEntity<Response> responseEntity = controller.deleteReceipt(1);
		assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getStatus(), "success");
		verify(services, times(1)).deleteReceipt(1);
	}

}
