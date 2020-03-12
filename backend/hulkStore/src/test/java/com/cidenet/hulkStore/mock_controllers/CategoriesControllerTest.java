package com.cidenet.hulkStore.mock_controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
import com.cidenet.hulkStore.controllers.CategoriesController;
import com.cidenet.hulkStore.entities.CategoriesDTO;
import com.cidenet.hulkStore.services.CategoriesServices;

class CategoriesControllerTest {

	@InjectMocks
    CategoriesController controller;
     
    @Mock
    CategoriesServices services;
    
    @BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}
	
	@Test
	void testFindAll() {
		List<CategoriesDTO> allCategories = new ArrayList<CategoriesDTO>();
		CategoriesDTO c1 = new CategoriesDTO(1, "Marvel", "Heroes del Marvel Universe");
		CategoriesDTO c2 = new CategoriesDTO(2, "DC Comics", "Heroes de DC Comics");
		CategoriesDTO c3 = new CategoriesDTO(3, "Otros", "Heroes de la comunidad");
		allCategories.add(c1);
		allCategories.add(c2);
		allCategories.add(c3);
        
        when(services.getAllCategories()).thenReturn(allCategories);
        
        ResponseEntity<Response> responseEntity = controller.findAll();
        List<CategoriesDTO> list = (List<CategoriesDTO>) responseEntity.getBody().getData();
        
        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getStatus(), "success");
        assertEquals(list.get(0).getName(), "Marvel");
        assertEquals(list.get(0).getDescription(), "Heroes del Marvel Universe");
        assertEquals(list.get(1).getName(), "DC Comics");
        assertEquals(list.get(1).getDescription(), "Heroes de DC Comics");
	}

}
