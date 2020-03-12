package com.cidenet.hulkStore.mock_services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cidenet.hulkStore.daos.CategoriesDAO;
import com.cidenet.hulkStore.entities.CategoriesDTO;
import com.cidenet.hulkStore.services.CategoriesServices;

class CategoriesServicesTest {

	@InjectMocks
	CategoriesServices categoriesServices;
	
	@Mock
	CategoriesDAO categoriesRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testGetAllCategories() {
		List<CategoriesDTO> allCategories = new ArrayList<CategoriesDTO>();
		CategoriesDTO c1 = new CategoriesDTO(1, "Marvel", "Heroes del Marvel Universe");
		CategoriesDTO c2 = new CategoriesDTO(2, "DC Comics", "Heroes de DC Comics");
		CategoriesDTO c3 = new CategoriesDTO(3, "Otros", "Heroes de la comunidad");
		allCategories.add(c1);
		allCategories.add(c2);
		allCategories.add(c3);
		
		when(categoriesRepository.findAll()).thenReturn(allCategories);
		
		List<CategoriesDTO> list = categoriesServices.getAllCategories();
		assertNotNull(list);
		assertTrue(list.size() == allCategories.size());
		assertEquals(list.get(0).getName(), "Marvel");
		assertEquals(list.get(1).getName(), "DC Comics");
		assertEquals(list.get(2).getName(), "Otros");
		assertEquals(list, allCategories);
	}

}
