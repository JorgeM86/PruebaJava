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

import com.cidenet.hulkStore.daos.TypesDAO;
import com.cidenet.hulkStore.entities.TypesDTO;
import com.cidenet.hulkStore.services.TypesServices;

class TypesServicesTest {
	
	@InjectMocks
	TypesServices typesServices;
	
	@Mock
	TypesDAO typesRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testGetAllTypes() {
		List<TypesDTO> allTypes = new ArrayList<TypesDTO>();
		TypesDTO c1 = new TypesDTO(1, "Comics", "Comics de tus heroies favoritos");
		TypesDTO c2 = new TypesDTO(2, "Juguetes", "Juguetes de tus heroies favoritos");
		allTypes.add(c1);
		allTypes.add(c2);
		
		when(typesRepository.findAll()).thenReturn(allTypes);
		
		List<TypesDTO> list = typesServices.getAllTypes();
		assertNotNull(list);
		assertTrue(list.size() == allTypes.size());
		assertEquals(list.get(0).getName(), "Comics");
		assertEquals(list, allTypes);
	}


}
