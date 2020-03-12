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
import com.cidenet.hulkStore.controllers.TypesController;
import com.cidenet.hulkStore.entities.TypesDTO;
import com.cidenet.hulkStore.services.TypesServices;

class TypesControllerTest {
	
	@InjectMocks
    TypesController controller;
     
    @Mock
    TypesServices services;
    
    @BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	@Test
	void testFindAll() {
		List<TypesDTO> allTypes = new ArrayList<TypesDTO>();
		TypesDTO c1 = new TypesDTO(1, "Comics", "Comics de tus heroies favoritos");
		TypesDTO c2 = new TypesDTO(2, "Juguetes", "Juguetes de tus heroies favoritos");
		allTypes.add(c1);
		allTypes.add(c2);
		
		when(services.getAllTypes()).thenReturn(allTypes);
        
        ResponseEntity<Response> responseEntity = controller.findAll();
        List<TypesDTO> list = (List<TypesDTO>) responseEntity.getBody().getData();
        
        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getStatus(), "success");
        assertEquals(list.get(0).getName(), "Comics");
        assertEquals(list.get(0).getDescription(), "Comics de tus heroies favoritos");
        assertEquals(list.get(1).getName(), "Juguetes");
        assertEquals(list.get(1).getDescription(), "Juguetes de tus heroies favoritos");
	}

}
