package com.cidenet.hulkStore.mock_controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
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
import com.cidenet.hulkStore.controllers.ProductsController;
import com.cidenet.hulkStore.entities.ProductsDTO;
import com.cidenet.hulkStore.services.ProductsServices;

class ProductsControllerTest {
	
	@InjectMocks
    ProductsController controller;
     
    @Mock
    ProductsServices services;
    
    @BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	@Test
	void testFindAll() {
        List<ProductsDTO> allProducts = new ArrayList<ProductsDTO>();
		ProductsDTO c1 = new ProductsDTO(1, "Batman", "Comics of the Dark Knight", 25, 20000, 2, 1);
		allProducts.add(c1);
        
        when(services.getAllProducts()).thenReturn(allProducts);
        
        ResponseEntity<Response> responseEntity = controller.findAll();
        List<ProductsDTO> list = (List<ProductsDTO>) responseEntity.getBody().getData();
        
        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getStatus(), "success");
        assertEquals(list.get(0).getName(), "Batman");
        assertEquals(list.get(0).getDescription(), "Comics of the Dark Knight");
	}

	@Test
	void testSaveProduct() {
        ProductsDTO productDTO = new ProductsDTO(1, "Batman", "Comics of the Dark Knight", 25, 20000, 2, 1);
        String json = "{\"name\":\"Thor Comics\",\"description\":\"Comics of the god of thunder\","
        		+ "\"quantity\":\"100\",\"price\":\"20000\",\"category_fk\":\"1\",\"type_fk\":\"1\"}";
        
        when(services.saveProduct(any(ProductsDTO.class))).thenReturn(productDTO);
        
        ResponseEntity<Response> responseEntity = controller.saveProduct(json);
        ProductsDTO dbProductDTO = (ProductsDTO) responseEntity.getBody().getData();
        
        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getStatus(), "success");
        assertEquals(dbProductDTO.getName(), "Batman");
        assertEquals(dbProductDTO.getDescription(), "Comics of the Dark Knight");
        assertEquals(dbProductDTO, productDTO);
	}
	
	@Test
	void testDeleteProduct() {
		doNothing().when(services).deleteProduct(anyInt());
		ResponseEntity<Response> responseEntity = controller.deleteDelete(1);
		assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getStatus(), "success");
		verify(services, times(1)).deleteProduct(1);
	}

}
