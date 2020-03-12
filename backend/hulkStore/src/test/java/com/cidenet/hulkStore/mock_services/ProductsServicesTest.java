package com.cidenet.hulkStore.mock_services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cidenet.hulkStore.daos.ProductsDAO;
import com.cidenet.hulkStore.entities.ProductsDTO;
import com.cidenet.hulkStore.services.ProductsServices;

class ProductsServicesTest {
	
	@InjectMocks
	ProductsServices productsServices;
	
	@Mock
	ProductsDAO productsRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllProducts() {
		List<ProductsDTO> allProducts = new ArrayList<ProductsDTO>();
		ProductsDTO c1 = new ProductsDTO(1, "Thor Comics", "Comics of the god of thunder", 25, 20000, 1, 1);
		allProducts.add(c1);
		
		when(productsRepository.findAll()).thenReturn(allProducts);
		
		List<ProductsDTO> list = productsServices.getAllProducts();
		assertNotNull(list);
		assertTrue(list.size() == allProducts.size());
		assertEquals(list.get(0).getName(), "Thor Comics");
		assertEquals(list, allProducts);
	}

	@Test
	void testGetProductByID() {
		ProductsDTO productDTO = new ProductsDTO(1, "Thor Comics", "Comics of the god of thunder", 25, 20000, 1, 1);
		when(productsRepository.findById(anyInt())).thenReturn(Optional.of(productDTO));
		ProductsDTO dbProductDTO = productsServices.getProductByID(1);
		assertNotNull(dbProductDTO);
		assertEquals(dbProductDTO.getName(), "Thor Comics");
	}

	@Test
	void testSaveProduct() {
		ProductsDTO productDTO = new ProductsDTO("Thor Comics", "Comics of the god of thunder", 25, 20000, 1, 1);
		when(productsRepository.save(productDTO)).thenReturn(productDTO);
		ProductsDTO dbProductDTO = productsServices.saveProduct(productDTO);
		assertNotNull(dbProductDTO);
		assertEquals(dbProductDTO.getName(), "Thor Comics");
	}

	@Test
	void testDeleteProduct() {
		doNothing().when(productsRepository).deleteById(anyInt());
		productsServices.deleteProduct(1);
		verify(productsRepository, times(1)).deleteById(1);
	}

}
